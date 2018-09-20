#!/bin/sh

echo "更新服务开始。。。。"

###jenkins 从 gitlab 上拉取的项目所在路径
home="/Users/Function/.jenkins/workspace/spring-cloud"

### 自定义的docker-compose.yml 文件所在路径
docker_home="/Users/Function/Documents/workspace/docker-workspace/spring-cloud"

### admin服务文件夹名
admin_home="/admin-service"
### eureka服务文件夹名
eureka_home="/eureka-service"
### business服务文件夹名
business_home="/business-service/business-service-impl"


### 判断admin服务路径是否存在

if [ ! -e ${home}${admin_home} ];then
echo "${admin_home} 不存在"
exit 1;
fi

### 判断eureka服务路径是否存在
if [ ! -e "${home}${eureka_home}" ];then
echo "${eureka_home} 不存在"
exit 1;
fi

### 判断bussines_home服务路径是否存在
if [ ! -e "${home}${business_home}" ];then
echo "${business_home} 不存在"
exit 1;
fi


### 执行项目根目录下gradlew文件

echo "清除上次构建文件......"
cd ${home}
sh ${home}/gradlew clean
sleep 5


echo "开始构建Admin服务...."
cd ${home}${admin_home}
sh ${home}/gradlew bootJar -x test
echo "Admin服务构建完成...."

sleep 5

echo "开始构建eureka服务...."
cd ${home}${eureka_home}
sh ${home}/gradlew bootJar -x test
echo "开始构建eureka服务构建完成...."

sleep 5

echo "开始构建business服务...."
cd ${home}${business_home}
sh ${home}/gradlew bootJar -x test
echo "Service服务构建完成...."

sleep 5




if [ ! $? -eq 0  ];then
echo "gradle 执行失败: $?"
exit 1;
fi


echo "将最新jar包移动到DOCKER目录. ${docker_home}"
if [ ! -e "${docker_home}" ]; then
echo "${docker_home} 不存在"
exit 1;
fi

echo "删除旧的jar..."
rm -rf ${docker_home}/*.jar


echo "开始移动Eurake.."
mv ${home}${eureka_home}/build/libs/eureka-service.jar ${docker_home}

echo "开始移动Admin.."
mv ${home}${admin_home}/build/libs/admin-service.jar ${docker_home}


echo "开始移动Business.."
mv ${home}${business_home}/build/libs/business-service-impl.jar ${docker_home}


### 进入 docker-compose 文件所在目录
cd ${docker_home}

echo "停止并删除启动的容器....."
### 先停止并删除 上一次根据docker-compose启动的容器 注：echo 中输入的是你本机电脑密码，用 shell 执行 docker 命令时需要sudo 权限
echo "ccz123456..." | sudo -S docker-compose down
sleep 1

echo "删除spring-cloud 服务镜像....."
### 删除上一次构建的spring-cloud项目镜像   其中 grep service 中的service 是镜像名中包含的字段，是生成镜像时可以指定，如镜像名为: sc-service ，编写docker-compose时会说明
echo "ccz123456..." | sudo -S docker rmi --force `docker images | grep service | awk '{print $3}'`
sleep 1

echo "构建spring-cloud新的服务镜像....."
### 构建镜像镜像
echo "ccz123456..." | sudo -S docker-compose build
sleep 1

echo "启动服务容器....."
### 构建镜像并启动容器
echo "ccz123456..." | sudo -S docker-compose up -d
