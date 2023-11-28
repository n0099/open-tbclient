package com.xiaomi.push;

import android.content.Context;
/* loaded from: classes10.dex */
public class ay {
    public static int a;

    public static at a(Context context) {
        if (j.m720a()) {
            a = 1;
            return new ax(context);
        } else if (aq.a(context)) {
            a = 2;
            return new aq(context);
        } else if (ba.a(context)) {
            a = 4;
            return new ba(context);
        } else if (be.a(context)) {
            a = 5;
            return new be(context);
        } else if (aw.a(context)) {
            a = 3;
            return new au(context);
        } else {
            a = 0;
            return new bd();
        }
    }
}
