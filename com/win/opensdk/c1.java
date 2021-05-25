package com.win.opensdk;

import android.content.Context;
import android.text.TextUtils;
import java.util.Date;
/* loaded from: classes7.dex */
public class c1 {

    /* renamed from: a  reason: collision with root package name */
    public static c1 f37023a;

    public static c1 a() {
        if (f37023a == null) {
            synchronized (c1.class) {
                if (f37023a == null) {
                    f37023a = new c1();
                }
            }
        }
        return f37023a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0053, code lost:
        if (((r6 / 60) / 60) >= r10.f36804a.getSharedPreferences("_prefs", 0).getInt("interval", 0)) goto L7;
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
            s1.e(context, str);
        }
        u1.a(new b1(this, context));
        D0 a2 = D0.a(context);
        long h2 = s1.h(a2.f36804a);
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
            a2.f36805b = System.currentTimeMillis();
            u1.a(new C0(a2));
        }
        z.c(context);
        n1.a(context);
    }
}
