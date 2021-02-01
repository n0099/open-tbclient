package com.pgl.sys.ces.d;

import android.content.Context;
/* loaded from: classes6.dex */
public class c {
    private static b qah = null;

    public static b b(Context context, String str, int i, a aVar) {
        if (qah == null) {
            synchronized (c.class) {
                if (qah == null) {
                    qah = com.pgl.sys.ces.b.a(context, str, i, aVar);
                }
            }
        }
        return qah;
    }
}
