package com.kuaishou.tachikoma.api.app;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.kuaishou.tachikoma.api.model.TKCDNUrl;
import java.util.List;
/* loaded from: classes5.dex */
public interface WebImageHandler {
    void load(ImageView imageView, String str, Drawable drawable, int i);

    void load(ImageView imageView, List<TKCDNUrl> list, int i, int i2, int i3);

    void load(ImageView imageView, List<TKCDNUrl> list, int i, int i2, Drawable drawable, int i3);

    void load(String str, ImageView imageView, int i);
}
