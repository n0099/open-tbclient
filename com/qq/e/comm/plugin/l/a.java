package com.qq.e.comm.plugin.l;

import android.text.TextUtils;
import com.qq.e.comm.plugin.s.e;
import com.qq.e.comm.plugin.util.ai;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile a f12481a;

    private a() {
    }

    public static a a() {
        if (f12481a == null) {
            synchronized (a.class) {
                try {
                    if (f12481a == null) {
                        f12481a = new a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f12481a;
    }

    private <T> T a(e eVar, String str, Class<T> cls, T t) {
        ai.a("ABTestManager", "---------------------ABTest------------------");
        ai.a("ABTestManager", "cfg : " + eVar);
        ai.a("ABTestManager", "key : " + str);
        ai.a("ABTestManager", "defValue : " + t);
        if (eVar != null && eVar.f12748a != null && !TextUtils.isEmpty(str)) {
            try {
                Object opt = eVar.f12748a.opt(str);
                if (opt != null) {
                    t = cls.cast(opt);
                } else {
                    ai.a("ABTestManager", "cannot find key : " + str + " in [cfg -> playcfg]");
                }
            } catch (Exception e) {
                ai.a("ABTestManager", "get cfg value error.", e);
                e.printStackTrace();
            }
            ai.a("ABTestManager", "value : " + t);
        }
        return t;
    }

    public int a(e eVar, String str, int i) {
        return ((Integer) a(eVar, str, Integer.class, Integer.valueOf(i))).intValue();
    }
}
