## Android 日常笔记(四)

#### 1.  BigDecimal加减乘除精准运算

[精确大数据加减乘除：](https://blog.csdn.net/huiwenjie168/article/details/6998140)

Java代码 
```java
import java.math.BigDecimal;   
/**  
* 由于Java的简单类型不能够精确的对浮点数进行运算，这个工具类提供精  
* 确的浮点数运算，包括加减乘除和四舍五入。  
*/  
public class Arith{ //默认除法运算精度   
private static final int DEF_DIV_SCALE = 10; //这个类不能实例化   
private Arith(){   
}   
/**  
* 提供精确的加法运算。  
* @param v1 被加数  
* @param v2 加数  
* @return 两个参数的和  
*/  
public static double add(double v1,double v2){   
BigDecimal b1 = new BigDecimal(Double.toString(v1));   
BigDecimal b2 = new BigDecimal(Double.toString(v2));   
return b1.add(b2).doubleValue();   
}   
/**  
* 提供精确的减法运算。  
* @param v1 被减数  
* @param v2 减数  
* @return 两个参数的差  
*/  
public static double sub(double v1,double v2){   
BigDecimal b1 = new BigDecimal(Double.toString(v1));   
BigDecimal b2 = new BigDecimal(Double.toString(v2));   
return b1.subtract(b2).doubleValue();   
}   
/**  
* 提供精确的乘法运算。  
* @param v1 被乘数  
* @param v2 乘数  
* @return 两个参数的积  
*/  
public static double mul(double v1,double v2){   
BigDecimal b1 = new BigDecimal(Double.toString(v1));   
BigDecimal b2 = new BigDecimal(Double.toString(v2));   
return b1.multiply(b2).doubleValue();   
}   
/**  
* 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到  
* 小数点以后10位，以后的数字四舍五入。  
* @param v1 被除数  
* @param v2 除数  
* @return 两个参数的商  
*/  
public static double div(double v1,double v2){   
return div(v1,v2,DEF_DIV_SCALE);   
}   
/**  
* 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指  
* 定精度，以后的数字四舍五入。  
* @param v1 被除数  
* @param v2 除数  
* @param scale 表示表示需要精确到小数点以后几位。  
* @return 两个参数的商  
*/  
public static double div(double v1,double v2,int scale){   
if(scale<0){   
throw new IllegalArgumentException(   
"The scale must be a positive integer or zero");   
}   
BigDecimal b1 = new BigDecimal(Double.toString(v1));   
BigDecimal b2 = new BigDecimal(Double.toString(v2));   
return b1.divide(b2,scale,BigDecimal.ROUND_HALF_UP).doubleValue();   
}   
/**  
* 提供精确的小数位四舍五入处理。  
* @param v 需要四舍五入的数字  
* @param scale 小数点后保留几位  
* @return 四舍五入后的结果  
*/  
public static double round(double v,int scale){   
if(scale<0){   
throw new IllegalArgumentException("The scale must be a positive integer or zero");   
}   
BigDecimal b = new BigDecimal(Double.toString(v));   
BigDecimal one = new BigDecimal("1");   
return b.divide(one,scale,BigDecimal.ROUND_HALF_UP).doubleValue();   
}   
};  
```


#### 2. Android NDK版本下载：目前最新18
[摘抄地址](https://blog.csdn.net/gyh198/article/details/75036686)

四种操作系统，window、ios、linux。

```
翻不了墙的话，可以用迅雷下载

最新版本r18

https://dl.google.com/android/repository/android-ndk-r18b-windows-x86.zip

https://dl.google.com/android/repository/android-ndk-r18b-windows-x86_64.zip

https://dl.google.com/android/repository/android-ndk-r18b-darwin-x86_64.zip

https://dl.google.com/android/repository/android-ndk-r18b-linux-x86_64.zip

历史版本：

https://dl.google.com/android/repository/android-ndk-r17c-windows-x86.zip

https://dl.google.com/android/repository/android-ndk-r17c-windows-x86_64.zip

https://dl.google.com/android/repository/android-ndk-r17c-darwin-x86_64.zip

https://dl.google.com/android/repository/android-ndk-r17c-linux-x86_64.zip

https://dl.google.com/android/repository/android-ndk-r16b-windows-x86.zip

https://dl.google.com/android/repository/android-ndk-r16b-windows-x86_64.zip

https://dl.google.com/android/repository/android-ndk-r16b-darwin-x86_64.zip

https://dl.google.com/android/repository/android-ndk-r16b-linux-x86_64.zip

https://dl.google.com/android/repository/android-ndk-r15c-windows-x86.zip

https://dl.google.com/android/repository/android-ndk-r15c-windows-x86_64.zip

https://dl.google.com/android/repository/android-ndk-r15c-darwin-x86_64.zip

https://dl.google.com/android/repository/android-ndk-r15c-linux-x86_64.zip

https://dl.google.com/android/repository/android-ndk-r14b-windows-x86.zip

https://dl.google.com/android/repository/android-ndk-r14b-windows-x86_64.zip

https://dl.google.com/android/repository/android-ndk-r14b-darwin-x86_64.zip

https://dl.google.com/android/repository/android-ndk-r14b-linux-x86_64.zip

https://dl.google.com/android/repository/android-ndk-r13b-windows-x86.zip

https://dl.google.com/android/repository/android-ndk-r13b-windows-x86_64.zip

https://dl.google.com/android/repository/android-ndk-r13b-darwin-x86_64.zip

https://dl.google.com/android/repository/android-ndk-r13b-linux-x86_64.zip

https://dl.google.com/android/repository/android-ndk-r12b-windows-x86.zip

https://dl.google.com/android/repository/android-ndk-r12b-windows-x86_64.zip

https://dl.google.com/android/repository/android-ndk-r12b-darwin-x86_64.zip

https://dl.google.com/android/repository/android-ndk-r12b-linux-x86_64.zip

https://dl.google.com/android/repository/android-ndk-r11c-windows-x86.zip

https://dl.google.com/android/repository/android-ndk-r11c-windows-x86_64.zip

https://dl.google.com/android/repository/android-ndk-r11c-darwin-x86_64.zip

https://dl.google.com/android/repository/android-ndk-r11c-linux-x86_64.zip

https://dl.google.com/android/repository/android-ndk-r10e-windows-x86.zip

https://dl.google.com/android/repository/android-ndk-r10e-windows-x86_64.zip

https://dl.google.com/android/repository/android-ndk-r10e-darwin-x86_64.zip

https://dl.google.com/android/repository/android-ndk-r10e-linux-x86_64.zip

```


#### 3.  java使用AES加密解密 AES-128-ECB加密

[参考地址](https://www.cnblogs.com/chen-lhx/p/5817161.html)

```java
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
/**
 *
 * @author Administrator
 *
 */
public class AES {

    // 加密
    public static String Encrypt(String sSrc, String sKey) throws Exception {
        if (sKey == null) {
            System.out.print("Key为空null");
            return null;
        }
        // 判断Key是否为16位
        if (sKey.length() != 16) {
            System.out.print("Key长度不是16位");
            return null;
        }
        byte[] raw = sKey.getBytes("utf-8");
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");//"算法/模式/补码方式"
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        byte[] encrypted = cipher.doFinal(sSrc.getBytes("utf-8"));

        return new Base64().encodeToString(encrypted);//此处使用BASE64做转码功能，同时能起到2次加密的作用。
    }

    // 解密
    public static String Decrypt(String sSrc, String sKey) throws Exception {
        try {
            // 判断Key是否正确
            if (sKey == null) {
                System.out.print("Key为空null");
                return null;
            }
            // 判断Key是否为16位
            if (sKey.length() != 16) {
                System.out.print("Key长度不是16位");
                return null;
            }
            byte[] raw = sKey.getBytes("utf-8");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);
            byte[] encrypted1 = new Base64().decode(sSrc);//先用base64解密
            try {
                byte[] original = cipher.doFinal(encrypted1);
                String originalString = new String(original,"utf-8");
                return originalString;
            } catch (Exception e) {
                System.out.println(e.toString());
                return null;
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return null;
        }
    }

    public static void main(String[] args) throws Exception {
        /*
         * 此处使用AES-128-ECB加密模式，key需要为16位。
         */
        String cKey = "1234567890123456";
        // 需要加密的字串
        String cSrc = "www.gowhere.so";
        System.out.println(cSrc);
        // 加密
        String enString = AES.Encrypt(cSrc, cKey);
        System.out.println("加密后的字串是：" + enString);

        // 解密
        String DeString = AES.Decrypt(enString, cKey);
        System.out.println("解密后的字串是：" + DeString);
    }
}

//源代码片段来自云代码http://yuncode.net
```

#### 4. 求两个数的最大公约数
```java
 /**求两个数的最大公约数*/
public static int gcd(int x, int y) {
    if (y == 0)
        return x;
    else
        return gcd(y, x % y);
}
```



#### 5. [jitpack.io](https://jitpack.io)提取Gradle库种的jar或者aar文件：
> 还有一种直接在AS里面导出。[参考笔记五。](https://github.com/516457377/Note/blob/master/Android/Android%20%E6%97%A5%E5%B8%B8%E7%AC%94%E8%AE%B0(%E4%BA%94).md#2-将android-studio-中的libs搬到eclipse)

1）进入：<https://jitpack.io> ->搜索对应的githun地址lib

2）按提示操作成为如址：<https://jitpack.io/#delight-im/Android-AdvancedWebView>

3）点击你需要的版本的 log 进入：<https://jitpack.io/com/github/delight-im/Android-AdvancedWebView/v2.1.0/build.log>

4）拖到最后复制jar包链接拼接成你需要的jar包的地址：<https://jitpack.io/com/github/delight-im/Android-AdvancedWebView/v2.1.0/Android-AdvancedWebView-v2.1.0-javadoc.jar>

example：<https://jitpack.io/com/github/516457377/HelloLibs/1.0/HelloLibs-1.0.aar>

[https://jitpack.io/](https://jitpack.io/com/github/516457377/HelloLibs/1.0/HelloLibs-1.0.aar) **+**

![img1](/Android/Android日常笔记四/img1.png)  


#### 6.  利用JitPack创建自己的开源库。

简介：官网：<https://www.jitpack.io/>

发布文档：<https://www.jitpack.io/docs/ANDROID/>

详细参考：

[网页剪报](https://note.youdao.com/share/?id=244b28bd0fbe9d544a3533f4389cf698&type=notebook#/wcp1529403559536557)|[截长图](/Android/Android日常笔记四/img2.png)|[原网页](https://www.jianshu.com/p/e443456bb506)

使用：

* In your root build.gradle:

```groovy
buildscript { 
  dependencies {
    classpath 'com.github.dcendents:android-maven-gradle-plugin:2.1' 
}
```

*  In your library/build.gradle add:
```groovy
apply plugin: 'com.github.dcendents.android-maven'  

 group='com.github.YourUsername'
使用：需要添加
maven { url "https://jitpack.io" }
```

#### 7. Android 单元测试

详细：

[网页剪报](https://note.youdao.com/share/?id=244b28bd0fbe9d544a3533f4389cf698&type=notebook#/wcp1529640846305782)|[截长图](/Android/Android日常笔记四/img3.png)|[原网页](https://blog.csdn.net/vv_bug/article/details/53151737)|[demo github链接](https://github.com/913453448/AndroidUnit)

总结：

```
java单元测试直接new 对象即可。

Android 单元测试通过：

Context appContext = InstrumentationRegistry.*getTargetContext*();

获取Context进行测试。（不需要和ui交互）
```

#### 8. Android Studio class is never used 提示去除

> 感觉没啥必要去除吧。习惯了

就是方法未使用到会提示某个方法未使用。

File | Settings | Editor | Inspections

然后找到

Java | Declaration redundancy | Unused declaration

去掉勾就行了。

![img](/Android/Android日常笔记四/img4.png)

#### 9. Log cat输出是有长度限制的

限制为：4*1024个字符长度；

分段处理：

```java
import android.util.Log;

/**
 * 打印日志的工具类
 *
 * @author donkor
 */
public class LogUtil {
    //规定每段显示的长度
    private static int LOG_MAXLENGTH = 2000;

    public static void e(String TAG, String msg) {
            int strLength = msg.length();
            int start = 0;
            int end = LOG_MAXLENGTH;
            for (int i = 0; i < 100; i++) {
                //剩下的文本还是大于规定长度则继续重复截取并输出
                if (strLength > end) {
                    Log.e(TAG + i, msg.substring(start, end));
                    start = end;
                    end = end + LOG_MAXLENGTH;
                } else {
                    Log.e(TAG, msg.substring(start, strLength));
                    break;
                }
        }
    }
}
```

#### 10. 浅谈Arrays.asList()方法的使用（数组与集合互转）

首先，该方法是将数组转化为list。有以下几点需要注意：

- 该方法不适用于基本数据类型（byte,short,int,long,float,double,boolean）

- 该方法将数组与列表链接起来，当更新其中之一时，另一个自动更新

- **不支持add和remove方法**

- 如果需要转换成一个可编辑列表应该用new
```
ArrayList<String> list =new ArrayList<String>(Arrays.asList(arg));
```
- 集合转数组需要传入一个数组类型和长度。（其实传入的这个数组就是最终返回的）
```
String[] ss=list.toArray(new String[list.size()]);
```

#### 11.  API 23（6.0权限申请 Android 权限申请基本方法

1. 申请
```java
if (Build.VERSION.SDK_INT < 23) {
            onCreates();//不需要申请
        } else {
            // 权限组
            List<String> list = new ArrayList(Arrays.asList(Manifest.permission.ACCESS_FINE_LOCATION));
            Iterator<String> iterator = list.iterator();

            while (iterator.hasNext()) {//判断是否具有权限，有权限的剔除，无权限则申请
                String mis = iterator.next();
                if (checkCallingOrSelfPermission(mis) == PackageManager.PERMISSION_GRANTED) {
                    iterator.remove();
                }
            }

            if (list.size() > 0) {// 如果权限组大于0表示还有未通过的权限，则申请权限，否则正常执行
                requestPermissions(list.toArray(new String[list.size()]), REQUEST_CODE_ACCESS);
            } else {
                onCreates();
            }
```

2. 结果
```java
@Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,@NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE) {
            boolean allOK = true;
            for (int i = 0; i < grantResults.length; i++) {// 判断返回权限组的返回请求结果
                if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                } else {
                    allOK = false;// 如果有一个不通过表示不可执行
                }
            }
            if (allOK) {
                onCreates();
            } else
                finish();
        }
    }
```

#### 12. Android在Java代码中设置TextView的drawableLeft、drawableRight、drawableTop、drawableBottom

使用方法：
```java
void android.widget.TextView.setCompoundDrawables(Drawable left, Drawable top, Drawable right, Drawable bottom)
```

Drawable可以通过 
```java
Drawable rightDrawable = getResources().getDrawable(R.drawable.icon_new); 
```
得到

但是API提示，`setCompoundDrawables()` 调用的时候，Drawable对象必须调用`setBounds(int left, int top, int right, int bottom)`方法，于是我们加一行代码就可以了。

eg：
```java
Drawable rightDrawable = getResources().getDrawable(R.drawable.icon_new);

rightDrawable.setBounds(0, 0, rightDrawable.getMinimumWidth(), rightDrawable.getMinimumHeight());

tvVersionStatus.setCompoundDrawables(null, null, rightDrawable, null);
```


#### 13. android（相对布局） RelativeLayout 按钮(Button)总在最上层的问题

从Lollipop(5.0-20)版本开始,按钮增加了一个 StateListAnimator style,即使你在增加了按钮之后增加其他控件,这个按钮最终都会显示在最上层解决方法:

XML:
```xml
android:stateListAnimator="@null"
```
Java:
```java
Button button = new Button(this);

button.setText("Button");

if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

button.setStateListAnimator(null);

}
```
另外其他控件可以使用`view.bringToFront() `可以将布局在下层的控件放到上层，不被其他控件挡住。

