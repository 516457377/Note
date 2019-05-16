## Android 日常笔记(五)

#### 1. Eclipse 更新SDK编译报错问题

还在用Eclipse的我偶尔下载一个项目需要打开一下as，然后更新个sdk。再移到Eclipse里面，如果更新了sdk.buildtools 就会可能出现  
   ```Failed to load E:\SDK\android-sdk-windows\build-tools\27.0.2\lib\dx.jar```  
这样的问题，解决办法有两个。  

- 在项目文件的`project.properties`加上`sdk.buildtools=25.0.2 //设置sdk使用的buildtools版本`就可以了。后面的值根据之前能用的修改。  
- 第二个办法就是，直接替换sdk里面`27.0.2\lib\dx.jar`把这个替换成之前能用的`dx.jar`这样比较方便的就是不用每个项目都改一次；可能存在缺陷，具体 未知。

---
#### 2. 将Android Studio 中的libs搬到Eclipse

还在用落后的`Eclipse`的我，找demo的时候总会遇到一些as项目，as项目依赖包都是从`build.gradle`里面配置的，所以遇到需要从`as`搬到`Eclipse`就会发现我找不到libs；  
**解决办法**  

先从导包找到`import`定位到需要的libs包位置，然后从右键`Library Properties`就能看到在本地的jar文件的位置，找到ta然后导入`Eclipse`就ok。
> 注意：通常直接打开的jar文件都是sources文件，是不能使用的，需要返回上一层从另外两个文件中找到，真正的jar文件。可以使用工具`jd-gui`查看如果能看到文件内容的就是可以用的，如果不能看到是*.java结尾的文件就是不能用的。

[jd-gui 下载](https://github.com/516457377/Note/raw/master/Android/Android日常笔记五/jd-gui.exe)  

![img1](/Android/Android日常笔记五/img1.jpg)

---
#### 3. Android正则表达式使用：具体正则规则就自行百度  
[在线校验工具](https://tool.lu/regex/) | [更多详细了解](https://blog.csdn.net/gdutxiaoxu/article/details/77800756)  
[一个正则校验工具类](https://github.com/516457377/Note/blob/master/Tools/RegexUtil.java)

```java
import java.util.regex.Matcher;  
import java.util.regex.Pattern;  
        
String pattern = "(2(5[0-5]{1}|[0-4]\\d{1})|[0-1]?\\d{1,2})(\\.(2(5[0-5]{1}|[0-4]\\d{1})|[0-1]?\\d{1,2})){3}"; //正则规则（IP地址） 
Pattern r = Pattern.compile(pattern);
Matcher m = r.matcher(str);  //str为输入验证的值 
System.out.println(m.matches());  //结果
```

---
#### 4. 银行卡号归属
[查询工具类](https://github.com/516457377/Note/blob/master/Tools/BankInfo.java)

```java
	String where = BankInfo.getNameOfBank("955888999912312312", 0);
	//工商银行.牡丹银联理财金卡:
	//ps：第二个参数为偏移位从第几位开始读，需要调整，暂时无用。
```

---
#### 5. 关于Android Studio构建项目问题
开始用as，拉了一个项目下来发现构筑各种慢，build一次要半个小时还没搞定：  
```Metadata of https://dl.google.com/dl/android/maven2/*****```  
报各种这样的错误。错误信息打开后也发现网址打不开，所以问题应该就是远程代码库的问题了。那么怎么解决呢，想办法更换代码库地址鸭，还记得之前自己创建代码库的时候，需要在

> 先在 build.gradle(Project:XXXX) 的 repositories 添加 maven { url 'https://jitpack.io' }

所以应该也是有办法更换的，个人猜测在`dependencies `添加了依赖库就会从`repositories`里面去寻找各种链接然后下载。
    
网上找到了一些存储仓库[地址](https://blog.csdn.net/u011216417/article/details/73480899)：

> 当然 jcenter在国内的话，基本没人使用了,当然作为android开发者24小时翻墙，是可以用得。。这里非常推荐使用阿里，速度，那叫一个快。。。千万别把这些一股脑地都放到自己的项目中。用不了，还耽误搜索时间。

```groovy
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
    maven  {url "http://repo1.maven.org/maven2"}
    mavenCentral()
    jcenter()
    google()
    }
```

---
#### 6. Android Studio 踩坑指南：build 报 `Connection timed out: connect`
今天又拉了一个项目，起初报一个错误，猜测应该是gwf 搞的鬼。架上工具然后依然报错，想到了上一次问题找了些加了些网络仓库地址，但是这些地址大部分都是专门的仓库地址并不是镜像地址，依然会走之`google()`我就纳闷了。又找了很久。后来网上发现了一[**篇文章**](https://blog.csdn.net/rookie_or_beginner/article/details/80736986)  
说是可能是gradle的问题，果断去把`gradle-wrapper.properties`里面的版本改了一下。重新构建果然ok。

![img2](/Android/Android日常笔记五/img2.jpg)  
    
后面还遇到一个问题  

        Configuration on demand is not supported by the current version of
        the Android Gradle plugin since you are using Gradle version 4.6 or
        above. Suggestion: disable configuration on demand by setting
        org.gradle.configureondemand=false in your gradle.properties file or
        use a Gradle version less than 4.6.

解决办法网上说有两个一个修改setting配置，我觉得这样对其他项目有影响。方法儿使用4.6以下的gradle。---》OK。  
附上gradle下载地址，可以查看有哪些版本：[HTTPS地址（慢）](https://services.gradle.org/distributions/) | [HTTP地址（快）](http://services.gradle.org/distributions/)

---
#### 7. List 集合remove(location)后集合的位置变化

一个list集合`remove`其中一个元素之后，后面的元素会**自动向前移动**，因此可以使用循环，`get(0)`一直遍历。`Iterator`应该同理。

---
#### 8. Activity之startActivityForResult  
当启动一个Avtivity之后有时候希望能过监听到启动的对象的状态或者返回参数，可以使用startActivityForResult(Intent intent, int requestCode)方法，该方法会需要传入一个`int requestCode`请求码参数，该参数会在启动Act被销毁后传回`onActivityResult(int requestCode, int resultCode, Intent data)`中，用于验证。返回方法中另外两个参数`int resultCode, Intent data`需要在启动Act中设置。用于返回数据对应操作。  
    在启动对象中通过`setResult(resultCode, intent);`方法设置返回参数。  

> 注意请求码requestCode不能大于65536，同时不能为负数。否则无效。
---
#### 9. Android Studio中如何用Framework.jar替换SDK。修改jar优先级
在Eclipse中我们可以通过这样  
![img3](/Android/Android日常笔记五/img3.jpg)  
但是在as里面就有点迷茫了。通过搜索发现一个方法，使用了第一个操作就可以了。后面的[参考一下吧](https://segmentfault.com/q/1010000005885793)；|[参考二](https://blog.csdn.net/github_38336967/article/details/77504294)  
![img4](/Android/Android日常笔记五/img4.jpg)

---
#### 10. Android Overscan，设置屏边距。
> 什么是overscan？

对于电视机，有一个Overscan的概念，如下图，所谓Overscan区域，就是电视机屏幕四周某些不可见的区域，这是电视机的特性。  
具体设置方法可以在串口工具或者`adb shell`不需要su权限。估计手机的单手模式也是这个。

	wm overscan  10，20，30，40//左上右下  
即可让周围自动设置边距，但是遇到问题就是播放视频的时候。会直接全屏。导致想要的效果不佳。解决办法发愁中。
[参考内容1](https://www.cnblogs.com/all-for-fiona/p/4054527.html)|[参考内容2](https://blog.csdn.net/xueshanhaizi/article/details/69383118)  

---

#### 11. Ping检测IP地址或网址是否可以连通。

* 回调接口：

```java
/**返回结果*/
interface PingListener {
    /**@param success return true is can connect,else disconnect*/
    void onResult(boolean success);
}
```

* 主方法：

```java
  /**
   * 通过ip ping 来判断ip是否通
   * @param ip 地址192.168.1.1 or www.baidu.com
   * @param showDialog 是否显示dialog阻止其他操作
   * @param listener 返回结果。
   */
  private void judgeTheConnect(final String ip,boolean showDialog,@Nullable final PingListener listener) {
      final ProgressDialog waitPro = new ProgressDialog(this);
      waitPro.setIndeterminate(true);
      waitPro.setMessage("wait..");
      waitPro.setCanceledOnTouchOutside(false);
      if (showDialog) {
          waitPro.show();
      }
      new Thread(new Runnable() {
          public void run() {
              boolean result = false;
              try {
                  if (ip != null) {
                      // 代表ping 3 次 超时时间为10秒
                      Process p = Runtime.getRuntime().exec("ping -c 3 -w 10 " + ip);// ping3次
                      int status = p.waitFor();
                      if (status == 0) {
                          // 代表成功
                          result = true;
                      } else {
                          // 代表失败
                          result = false;
                      }
                  } else {
                      // IP为空
                      result = false;
                  }
              } catch (Exception e) {
                  // LogUtil.e(aaa, e.getMessage());
                  result = false;
              }
              waitPro.dismiss();
              if (null != listener) {
                  final boolean re = result;
                  runOnUiThread(new Runnable() {//转到UI线程
                      public void run() {
                          listener.onResult(re);
                      }
                  });
              }
          }
      }).start();
  }
```

---

#### 12. Android 在服务`Service`或广播`BroadcastReceiver `弹Dialog。

[参考](https://blog.csdn.net/monkin2011/article/details/78016124)

直接在广播、服务中启动dialog是会报错的。解决办法：

* 权限
```xml
<uses-permission android:name="android.permission.SYSTEM_ALERT_WINDOW" />
```

* Dialog设置

```java
dialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
```

* 动态注册广播（这个有待验证，我自己测试静态注册也是可以启动起来的）

---

#### 13. Eclipse 中编译Jni生成so文件。

先列举一些参考资料，排序有先后；

* [eclipse配置外部工具利用javah编译生成头文件](https://blog.csdn.net/henren555/article/details/9324849)
* [在eclipse中android NDK开发环境的搭建](https://blog.csdn.net/lovexieyuan520/article/details/43212333) |（我是没有配置这个的）
* [eclipse android jni 开发，so库编译](https://blog.csdn.net/wjb201314/article/details/74225630)
* [android — NDK生成so文件](https://blog.csdn.net/laczff21/article/details/7542236)
* [参考资料](https://blog.csdn.net/caoxi_/article/details/52182897)
* AS

---
#### 14. Android 签名文件JKS《---》KEYSTORE 互转

[参考资料：Android jks文件签名转换keystore文件签名](https://blog.csdn.net/ONLYMETAGAIN/article/details/78781316)
[参考资料：P12,JKS,CER,RFX,PEM转换速记](https://blog.csdn.net/ONLYMETAGAIN/article/details/78782056)

---