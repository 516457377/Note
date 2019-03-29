## Android 日常笔记(五)

1. #### Eclipse 更新SDK编译报错问题
 
     还在用Eclipse的我偶尔下载一个项目需要打开一下as，然后更新个sdk。再移到Eclipse里面，如果更新了sdk.buildtools 就会可能出现  
        ```Failed to load E:\SDK\android-sdk-windows\build-tools\27.0.2\lib\dx.jar```  
     这样的问题，解决办法有两个。  
    - 在项目文件的`project.properties`加上`sdk.buildtools=25.0.2 //设置sdk使用的buildtools版本`就可以了。后面的值根据之前能用的修改。  
    - 第二个办法就是，直接替换sdk里面`27.0.2\lib\dx.jar`把这个替换成之前能用的`dx.jar`这样比较方便的就是不用每个项目都改一次；可能存在缺陷，具体 未知。
---
2. #### 将Android Studio 中的libs搬到Eclipse
 
     还在用落后的`Eclipse`的我，找demo的时候总会遇到一些as项目，as项目依赖包都是从`build.gradle`里面配置的，所以遇到需要从`as`搬到`Eclipse`就会发现我找不到libs；  
     解决办法  
     先从导包找到`import`定位到需要的libs包位置，然后从右键`Library Properties`就能看到在本地的jar文件的位置，找到ta然后导入`Eclipse`就ok。
         > 注意：通常直接打开的jar文件都是sources文件，是不能使用的，需要返回上一层从另外两个文件中找到，真正的jar文件。可以使用工具`jd-gui`查看如果能看到文件内容的就是可以用的，如果不能看到是*.java结尾的文件就是不能用的。
         [jd-gui 下载](https://github.com/516457377/Note/raw/master/Android/jd-gui.exe)  
        ![如图](/Android/TIM截图20190326115254.jpg)
---
 3. #### Android正则表达式使用：具体正则规则就自行百度  
    [在线校验工具](https://tool.lu/regex/) | [更多详细了解](https://blog.csdn.net/gdutxiaoxu/article/details/77800756)  
    [一个正则校验工具类](https://github.com/516457377/Note/blob/master/Tools/RegexUtil.java)
    
            import java.util.regex.Matcher;  
            import java.util.regex.Pattern;  
            
            String pattern = "(2(5[0-5]{1}|[0-4]\\d{1})|[0-1]?\\d{1,2})(\\.(2(5[0-5]{1}|[0-4]\\d{1})|[0-1]?\\d{1,2})){3}"; //正则规则（IP地址） 
            Pattern r = Pattern.compile(pattern);
            Matcher m = r.matcher(str);  //str为输入验证的值 
            System.out.println(m.matches());  //结果
---
4. #### 银行卡号归属
    [查询工具类](https://github.com/516457377/Note/blob/master/Tools/BankInfo.java)

        String where = BankInfo.getNameOfBank("955888999912312312", 0);
        //工商银行.牡丹银联理财金卡:
        //ps：第二个参数为偏移位从第几位开始读，需要调整，暂时无用。
        
---
5. #### 关于Android Studio构建项目问题

0.

