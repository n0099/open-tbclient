package com.pgl.sys.ces.d;

import android.content.Context;
/* loaded from: classes4.dex */
public class c {
    private static b pQc = null;

    public static b b(Context context, String str, int i, a aVar) {
        if (pQc == null) {
            synchronized (c.class) {
                if (pQc == null) {
                    pQc = com.pgl.sys.ces.b.a(context, str, i, aVar);
                }
            }
        }
        return pQc;
    }
}
