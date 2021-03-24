package com.pgl.sys.ces;

import android.content.Context;
/* loaded from: classes6.dex */
public final class a {
    static {
        try {
            System.loadLibrary("nms");
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        }
    }

    public static native Object meta(int i, Context context, Object obj);

    public static Object njss(int i, Object obj) {
        try {
            return b.a().a(i, obj);
        } catch (Throwable unused) {
            return null;
        }
    }
}
