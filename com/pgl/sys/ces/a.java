package com.pgl.sys.ces;

import android.content.Context;
/* loaded from: classes7.dex */
public final class a {
    static {
        try {
            System.loadLibrary("nms");
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        }
    }

    public static native Object meta(int i2, Context context, Object obj);

    public static Object njss(int i2, Object obj) {
        try {
            return b.a().a(i2, obj);
        } catch (Throwable unused) {
            return null;
        }
    }
}
