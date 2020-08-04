package com.kascend.chushou.view;

import android.support.annotation.DrawableRes;
import com.facebook.drawee.drawable.p;
import com.kascend.chushou.a;
import tv.chushou.widget.a.c;
import tv.chushou.zues.widget.fresco.FrescoThumbnailView;
/* loaded from: classes6.dex */
public class a {
    public static void a(FrescoThumbnailView frescoThumbnailView, String str, int i, int i2) {
        if (frescoThumbnailView != null) {
            frescoThumbnailView.getHierarchy().b(c.dZX(), p.b.mVu);
            frescoThumbnailView.i(str, 0, i, i2);
        }
    }

    @DrawableRes
    public static int a(String str) {
        return a.c.commonres_placeholder_bg;
    }

    @DrawableRes
    public static int a() {
        return a.e.user_level_icon_default;
    }
}
