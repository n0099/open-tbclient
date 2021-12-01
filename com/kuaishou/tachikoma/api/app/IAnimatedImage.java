package com.kuaishou.tachikoma.api.app;

import android.content.Context;
import android.widget.ImageView;
import com.kuaishou.tachikoma.api.model.TKCDNUrl;
import java.util.List;
/* loaded from: classes2.dex */
public interface IAnimatedImage {
    ImageView getImageViewHost(Context context);

    boolean getPlayNow(ImageView imageView);

    void setBorderColor(ImageView imageView, String str);

    void setBorderRadius(ImageView imageView, int i2);

    void setBorderWidth(ImageView imageView, double d2);

    void setCDNUrls(ImageView imageView, List<TKCDNUrl> list, int i2, int i3, String str);

    void setSrc(ImageView imageView, String str, String str2);

    void setUri(ImageView imageView, String str, String str2, int i2, int i3);

    void setUrlAndPlaceHolder(ImageView imageView, String str, String str2, String str3, int i2, int i3);

    void setUrls(ImageView imageView, List<TKCDNUrl> list, int i2, int i3);

    void startGifAnimation(ImageView imageView);

    void stopGifAnimation(ImageView imageView);
}
