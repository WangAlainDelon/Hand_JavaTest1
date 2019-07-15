# JavaTest1   #
**1. 工程运行环境**  
JDK:1.8  
Windows10/IDEA 
使用 maven 构建项目
UTF-8编码
  
* 1打开方式:打开IDEA，CVS->Checkout from Version Control->Git 输入Git仓库地址 从git上拉取项目，导入IDEA即可。

* 3. 模块  包含一个父模块和两个子模块
 模块Exam1完成的是练习一
 模块Exam2完成的是练习二的两个小题

**5. 数据源配置**  
数据库配置修改  
请修改JavaTest1\Exam2\src\main\resources\jdbc.propertiescom.test.utils.DBHelper中的内容，url，username，password修改成自己的，示例如下：     
driverClassName=com.mysql.jdbc.Driver
url=jdbc:mysql://localhost:3306/sakila?useUnicode=true&characterEncoding=utf8
username=root
password=133309 
      
# 说明：练习二的第二个小题未完成
* 如果打成jar包用java -jar 的方式来运行，运行的时候如果提示主题清单没有需要在jar包中的MANIFEST.MF添加Main-Class和他的运行主类
  
 * 如果java -jar的方式运行，的时候可能会报找不到类的错误，可能是打包的时候没有将依赖包一起打进去，需要添加maven 打包集成插件
 * 最好是在idea里面直接运行看效果。
            
   
