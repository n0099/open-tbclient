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
/* loaded from: classes5.dex */
public final class d {
    public static final d neU = new d();

    private d() {
    }

    public final File n(String str, File file) {
        String str2;
        q.m(file, "f");
        String str3 = str;
        if (str3 == null || str3.length() == 0) {
            return null;
        }
        if (str == null) {
            q.dQK();
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
        q.m(str2, "avatarUrl");
        q.m(cVar, "sp");
        int length = cVar.length();
        ImageRequestBuilder wM = ImageRequestBuilder.ac(i.Rk(str2)).a(new com.kascend.chushou.widget.gif.a(i, i2, str)).wM(true);
        com.facebook.drawee.view.b a = com.facebook.drawee.view.b.a(new com.facebook.drawee.generic.b(tv.chushou.widget.a.c.getResources()).Iq(com.kascend.chushou.view.a.a(null)).dBB(), tv.chushou.basis.d.b.dWi());
        com.facebook.drawee.controller.a dAN = com.facebook.drawee.a.a.c.dAa().bc(wM.dHf()).dAR();
        q.l((Object) a, "draweeHolder");
        a.setController(dAN);
        cVar.append(" ");
        String str3 = str;
        int i3 = str3 == null || str3.length() == 0 ? i2 : i;
        cVar.a(a, length, length, i3, i3, false, 2);
        cVar.append(" ");
    }

    public final void a() {
        tv.chushou.zues.utils.h.dWN();
        System.gc();
    }
}
