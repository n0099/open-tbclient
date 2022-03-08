package com.tachikoma.core.api;

import android.content.Context;
import android.widget.ImageView;
import com.tachikoma.core.component.imageview.TKCDNUrlInner;
import java.util.List;
/* loaded from: classes8.dex */
public interface IAnimatedImageInner {
    ImageView getImageViewHost(Context context);

    boolean getPlayNow(ImageView imageView);

    void setBorderColor(ImageView imageView, String str);

    void setBorderRadius(ImageView imageView, int i2);

    void setBorderWidth(ImageView imageView, double d2);

    void setCDNUrls(ImageView imageView, List<TKCDNUrlInner> list, int i2, int i3, String str);

    void setSrc(ImageView imageView, String str, String str2);

    void setUri(ImageView imageView, String str, String str2, int i2, int i3);

    void setUrlAndPlaceHolder(ImageView imageView, String str, String str2, String str3, int i2, int i3);

    void setUrls(ImageView imageView, List<TKCDNUrlInner> list, int i2, int i3);

    void startGifAnimation(ImageView imageView);

    void stopGifAnimation(ImageView imageView);
}
