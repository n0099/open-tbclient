package com.pgl.sys.ces.d;

import android.content.Context;
/* loaded from: classes4.dex */
public class c {
    private static b pUC = null;

    public static b b(Context context, String str, int i, a aVar) {
        if (pUC == null) {
            synchronized (c.class) {
                if (pUC == null) {
                    pUC = com.pgl.sys.ces.b.a(context, str, i, aVar);
                }
            }
        }
        return pUC;
    }
}
