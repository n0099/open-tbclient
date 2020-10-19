package com.kascend.chushou.d;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.util.List;
import kotlin.jvm.internal.q;
import kotlin.text.l;
@kotlin.h
/* loaded from: classes6.dex */
public final class d {
    public static final d ohb = new d();

    private d() {
    }

    public final File o(String str, File file) {
        String str2;
        q.n(file, "f");
        String str3 = str;
        if (str3 == null || str3.length() == 0) {
            return null;
        }
        if (str == null) {
            q.eob();
        }
        List b = l.b((CharSequence) str, new String[]{Constants.ACCEPT_TIME_SEPARATOR_SP}, false, 0, 6, (Object) null);
        if (b.size() > 1) {
            str2 = (String) b.get(1);
        } else {
            str2 = (String) b.get(0);
        }
        if (str2.length() == 0) {
            return null;
        }
        try {
            byte[] decode = Base64.decode(str2, 0);
            if (decode != null) {
                if (decode.length == 0 ? false : true) {
                    return tv.chushou.zues.utils.c.a(BitmapFactory.decodeByteArray(decode, 0, decode.length), file, Bitmap.CompressFormat.JPEG, 100);
                }
                return null;
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    public final void a(String str, String str2, tv.chushou.zues.widget.a.c cVar, int i, int i2) {
        q.n(str2, "avatarUrl");
        q.n(cVar, "sp");
        int length = cVar.length();
        ImageRequestBuilder za = ImageRequestBuilder.ad(i.We(str2)).a(new com.kascend.chushou.widget.gif.a(i, i2, str)).za(true);
        com.facebook.drawee.view.b a2 = com.facebook.drawee.view.b.a(new com.facebook.drawee.generic.b(tv.chushou.widget.a.c.getResources()).MA(com.kascend.chushou.view.a.a(null)).dYF(), tv.chushou.basis.d.b.etB());
        com.facebook.drawee.controller.a dXS = com.facebook.drawee.a.a.c.dXf().bj(za.eej()).dXW();
        q.m(a2, "draweeHolder");
        a2.setController(dXS);
        cVar.append(" ");
        String str3 = str;
        int i3 = str3 == null || str3.length() == 0 ? i2 : i;
        cVar.a(a2, length, length, i3, i3, false, 2);
        cVar.append(" ");
    }

    public final void a() {
        tv.chushou.zues.utils.h.euf();
        System.gc();
    }
}
