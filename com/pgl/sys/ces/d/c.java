package com.pgl.sys.ces.d;

import android.content.Context;
/* loaded from: classes6.dex */
public class c {
    private static b qbv = null;

    public static b b(Context context, String str, int i, a aVar) {
        if (qbv == null) {
            synchronized (c.class) {
                if (qbv == null) {
                    qbv = com.pgl.sys.ces.b.a(context, str, i, aVar);
                }
            }
        }
        return qbv;
    }
}
