package com.win.opensdk;

import android.content.Context;
import android.text.TextUtils;
import java.util.Date;
/* loaded from: classes7.dex */
public class F1 {

    /* renamed from: a  reason: collision with root package name */
    public static F1 f40053a;

    public static F1 a() {
        if (f40053a == null) {
            synchronized (F1.class) {
                if (f40053a == null) {
                    f40053a = new F1();
                }
            }
        }
        return f40053a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0053, code lost:
        if (((r6 / 60) / 60) >= r10.f40319a.getSharedPreferences("_prefs", 0).getInt("interval", 0)) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Context context, String str) {
        if (context == null) {
            throw new RuntimeException("Error:Context is not allowed to be null");
        }
        context.getApplicationContext();
        if (!TextUtils.isEmpty(str)) {
            V1.e(context, str);
        }
        X1.a(new E1(this, context));
        g1 a2 = g1.a(context);
        long h2 = V1.h(a2.f40319a);
        boolean z = true;
        if (h2 > 0) {
            try {
                long time = (new Date().getTime() - h2) / 1000;
                if (time < 0) {
                    a2.b();
                }
                z = false;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (z) {
            a2.f40320b = System.currentTimeMillis();
            X1.a(new f1(a2));
        }
        G.f(context);
        Q1.a(context);
    }
}
