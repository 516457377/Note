## Android 日常笔记(五)

 1. 还在用Eclipse的我偶尔下载一个项目需要打开一下as，然后更新个sdk。再移到Eclipse里面，如果更新了sdk.buildtools 就会可能出现
    ```Failed to load E:\SDK\android-sdk-windows\build-tools\27.0.2\lib\dx.jar```
     这样的问题，解决办法有两个。  
    - 在项目文件的`project.properties`加上`sdk.buildtools=25.0.2 //设置sdk使用的buildtools版本`就可以了。后面的值根据之前能用的修改。  
    - 第二个办法就是，直接替换sdk里面`27.0.2\lib\dx.jar`把这个替换成之前能用的`dx.jar`这样比较方便的就是不用每个项目都改一次；可能存在缺陷，具体未知。
    
2. 还在用落后的`Eclipse`的我，找demo的时候总会遇到一些as项目，as项目依赖包都是从`build.gradle`里面配置的，所以遇到需要从`as`搬到`Eclipse`就会发现我找不到libs；

    解决办法 
    先从导包找到`import`定位到需要的libs包位置，然后从右键`Library Properties`就能看到在本地的jar文件的位置，找到ta然后导入`Eclipse`就ok。
    > 注意：通常直接打开的jar文件都是sources文件，是不能使用的，需要返回上一层从另外两个文件中找到，真正的jar文件。可以使用工具`jd-gui`查看如果能看到文件内容的就是可以用的，如果不能看到是*.java结尾的文件就是不能用的。
    [jd-gui 下载](https://github.com/516457377/Note/raw/master/Android/jd-gui.exe)  
    ![如图](/Android/TIM截图20190326115254.jpg)
