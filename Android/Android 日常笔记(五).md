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
    开始用as，拉了一个项目下来发现构筑各种慢，build一次要半个小时还没搞定：  
    ```Metadata of https://dl.google.com/dl/android/maven2/*****```  
    报各种这样的错误。错误信息打开后也发现网址打不开，所以问题应该就是远程代码库的问题了。那么怎么解决呢，想办法更换代码库地址鸭，还记得之前自己创建代码库的时候，需要在
    > 先在 build.gradle(Project:XXXX) 的 repositories 添加 maven { url 'https://jitpack.io' }

    所以应该也是有办法更换的，个人猜测在`dependencies `添加了依赖库就会从`repositories`里面去寻找各种链接然后下载。
    
    网上找到了一些存储仓库[地址](https://blog.csdn.net/u011216417/article/details/73480899)：
    
        repositories {
        maven { url "https://jitpack.io" }
        maven { url "http://maven.aliyun.com/nexus/content/groups/public/" }
        maven { url 'http://maven.oschina.net/content/groups/public/' } 
        maven { url 'https://oss.sonatype.org/content/repositories/snapshots/' } 
        maven { url "http://maven.springframework.org/release" } 
        maven { url "http://maven.restlet.org" } 
        maven { url "http://mirrors.ibiblio.org/maven2" }
        maven {
            url "http://repo.baichuan-android.taobao.com/content/groups/BaichuanRepositories/"
        }
        maven { url 'https://maven.fabric.io/public' }
        mavenCentral()
        jcenter()
        google()
        }
6. #### Android Studio 踩坑指南：build 报 `Connection timed out: connect`
    今天又拉了一个项目，起初报一个错误，猜测应该是gwf 搞的鬼。架上工具然后依然报错，想到了上一次问题找了些加了些网络仓库地址，但是这些地址大部分都是专门的仓库地址并不是镜像地址，依然会走之`google()`我就纳闷了。又找了很久。后来网上发现了一[**篇文章**](https://blog.csdn.net/rookie_or_beginner/article/details/80736986)  
说是可能是gradle的问题，果断去把`gradle-wrapper.properties`里面的版本改了一下。重新构建果然ok。

    ![图2](https://github.com/516457377/Note/blob/master/Android/img2.jpg)  
    后面还遇到一个问题  
    
        Configuration on demand is not supported by the current version of
        the Android Gradle plugin since you are using Gradle version 4.6 or
        above. Suggestion: disable configuration on demand by setting
        org.gradle.configureondemand=false in your gradle.properties file or
        use a Gradle version less than 4.6.
    
    解决办法网上说有两个一个修改setting配置，我觉得这样对其他项目有影响。方法儿使用4.6以下的gradle。---》OK。  
    附上gradle下载地址，可以查看有哪些版本：[HTTPS地址（慢）](https://services.gradle.org/distributions/) | [HTTP地址（快）](http://services.gradle.org/distributions/)

0.

