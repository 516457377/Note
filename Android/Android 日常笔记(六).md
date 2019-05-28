# Android 日常笔记(六)

#### 1. Android 自定义View的时候当继承类是ViewGroup的时候onDraw方法不生效。
> 分析参考：[自定义viewGroup 为什么不走 onDraw方法？](https://blog.csdn.net/sinat_26710701/article/details/71171726)  

如果你想要在自定义viewgroup中重写onDraw方法，必须在构造函数中调用  
`setWillNotDraw(false);`

---

