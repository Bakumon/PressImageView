# PressImageView

自带按下效果的 ImageView。为什么会有这个东西呢？解决两个问题。
1. 网络图片没有按下效果的配图
通常我们实现 view 的按下效果是通过 selector 这是 background 实现的，但如果是 ImageView 的话，就需要两个图片，一个正常状态，一个按下状态，本地的资源图片还好，如果是网络图片，这种方式就没办法做了，于是有了这个自定义 ImageView。

2. 只改变 ImageView 的 src 按下效果
有些图片是不规则的，通过改透明度的方法修改的是整个 ImageView 的按下效果，这样不是很好。

## Preview

![](https://github.com/Bakumon/PressImageView/raw/master/art/PressImageView.gif)

## Usage

```xml
<me.bakumon.library.pressimageview.PressImageView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:id="@+id/press_imageview"
        app:pressColorBrightness="0.85"
        android:clickable="true"
        android:src="@drawable/image" />
```

|xml 属性|说明|
|--|--|
|pressColorBrightness|0~2之间的浮点数，0最暗，1无效过，2最亮|

|java 方法|说明|
|--|--|
|setPressColorBrightness(float pressBrightness)|0~2之间的浮点数，0最暗，1无效果，2最亮|

## TODO

- [ ] Ripple 或其他效果

## License

[MIT](https://github.com/Bakumon/PressImageView/blob/master/LICENSE)