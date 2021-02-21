package com.pgl.sys.ces.d;

import android.content.Context;
/* loaded from: classes6.dex */
public class c {
    private static b qaH = null;

    public static b b(Context context, String str, int i, a aVar) {
        if (qaH == null) {
            synchronized (c.class) {
                if (qaH == null) {
                    qaH = com.pgl.sys.ces.b.a(context, str, i, aVar);
                }
            }
        }
        return qaH;
    }
}
