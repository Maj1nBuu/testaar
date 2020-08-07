# testaar
maven库使用demo

练习使用maven 灵活打包 主要想解决arr依赖的lib无法打进去的问题


审核人员联系邮箱 raymond4cn@gmail.com


# 自建Maven库笔记 #

### 预先准备 ###
1. 可科学上网
2. 注册一个账号 bintray

### 网站信息填写和承接内容的准备 ###
1.create a organization [https://bintray.com/](https://bintray.com/)
	键入unique identifier和name
2.add a reposity which is maven type in origanization
3.add a package in maven

### 本地项目添加规格内容并上传到maven库 ###

1.项目的build.gradle中buildscript中添加
最新版本号，在[https://github.com/novoda/bintray-release](https://github.com/novoda/bintray-release)中查看

	classpath 'com.novoda:bintray-release:<latest-version>'

2.再需要上传的module的build.gradle中添加如下代码

	apply plugin: 'com.novoda.bintray-release'

	publish {
	    userOrg = 'buu1212' //bintray账户下unique identifier
	    groupId = 'com.sxnet.demoaar' //模块包名
	    artifactId = 'testLiba' //项目名称 package name
	    publishVersion = '1.0.1' //版本号 模块的版本
	    desc = 'merge aar' //项目介绍，可以不写
	    website = '' //项目主页，可以不写
	}

3.命令行上传对应的模块编译成的aar包
BINTRAY_USERNAME对应bintray中你的账户昵称,BINTRAY_API_KEY在Edit Profile中的API Key,-PdryRun=false会上传到仓库中，如果为true，只会执行gradle任务，但不会上传.

	gradlew clean build bintrayUpload -PbintrayUser=BINTRAY_USERNAME -PbintrayKey=BINTRAY_API_KEY -PdryRun=false

结果**Bulid Successful** 表明上传成功.
结果**Bulid Failed** 可查看详细的原因.

### 使用maven库 ###
1.在项目的build.gradle中添加

	allprojects{
		repositories{
			...
			maven{
				url 'https://dl.bintray.com/账户昵称/maven库名称'
			}
		}
	}
	例如:maven { url 'https://dl.bintray.com/buu1212/maven' }
2.在使用的模块的build.gradle中添加依赖

	implementation '模块名称:项目名称:版本号'
	例如:implementation 'com.sxnet.demoaar:testLiba:1.0.1'