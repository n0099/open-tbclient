package com.pgl.sys.ces.d;

import android.content.Context;
/* loaded from: classes4.dex */
public class c {
    private static b pSU = null;

    public static b b(Context context, String str, int i, a aVar) {
        if (pSU == null) {
            synchronized (c.class) {
                if (pSU == null) {
                    pSU = com.pgl.sys.ces.b.a(context, str, i, aVar);
                }
            }
        }
        return pSU;
    }
}
