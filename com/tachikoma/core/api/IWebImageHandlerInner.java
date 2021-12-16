package com.tachikoma.core.api;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tachikoma.core.component.imageview.TKCDNUrlInner;
import java.util.List;
/* loaded from: classes3.dex */
public interface IWebImageHandlerInner {
    void load(ImageView imageView, String str, Drawable drawable, int i2);

    void load(ImageView imageView, List<TKCDNUrlInner> list, int i2, int i3, int i4);

    void load(ImageView imageView, List<TKCDNUrlInner> list, int i2, int i3, Drawable drawable, int i4);

    void load(String str, ImageView imageView, int i2);
}
