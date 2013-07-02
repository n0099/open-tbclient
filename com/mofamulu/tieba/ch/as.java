package com.mofamulu.tieba.ch;

import android.content.Context;
/* loaded from: classes.dex */
public class as {
    static {
        av.a(new at());
    }

    public static boolean a(String str) {
        av b = b(str);
        return b != null && b.c() == 15856113;
    }

    public static boolean a(Context context, String str, ba baVar) {
        NickBinder a = NickService.a();
        if (a == null) {
            NickService.a(str, baVar);
            return true;
        }
        return a.a(str, baVar);
    }

    public static av b(String str) {
        NickBinder a = NickService.a();
        if (a == null) {
            return null;
        }
        return a.a(str);
    }

    public static boolean a() {
        NickBinder a = NickService.a();
        if (a == null) {
            return false;
        }
        return a.d();
    }
}
