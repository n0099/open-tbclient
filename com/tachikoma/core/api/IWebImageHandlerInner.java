package com.tachikoma.core.api;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tachikoma.core.component.imageview.TKCDNUrlInner;
import java.util.List;
/* loaded from: classes7.dex */
public interface IWebImageHandlerInner {
    void load(ImageView imageView, String str, Drawable drawable, int i);

    void load(ImageView imageView, List<TKCDNUrlInner> list, int i, int i2, int i3);

    void load(ImageView imageView, List<TKCDNUrlInner> list, int i, int i2, Drawable drawable, int i3);

    void load(String str, ImageView imageView, int i);
}
