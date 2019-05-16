package com.xiaomi.metoknlp.devicediscover;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class n {
    private static String a;
    private static n i;
    private g c;
    private h f;
    private k g;
    private Context h;
    private Object b = new Object();
    private int d = 0;
    private d e = new d();
    private Handler j = new b(this);

    public static n a() {
        if (i == null) {
            i = new n();
        }
        return i;
    }

    public void a(HashMap hashMap) {
        if (hashMap == null) {
            return;
        }
        String c = j.c(this.h);
        if (this.e != null && c != null) {
            this.e.g(c);
            if (hashMap.containsKey(c)) {
                this.e.h((String) hashMap.get(c));
            }
        }
        Object b = j.b(this.h);
        if (b != null && hashMap.containsKey(b)) {
            hashMap.remove(b);
        }
        if (this.e == null || hashMap.size() <= 0) {
            return;
        }
        this.e.a(new ArrayList(hashMap.values()));
        c();
    }

    private void e() {
        m.a(this.h, this.j, 0);
    }

    private void f() {
        String d = j.d(this.h);
        String a2 = j.a(this.h, 2);
        String a3 = j.a(this.h, 1);
        if (d == null || a2 == null || a3 == null || this.e == null) {
            return;
        }
        this.e.a(Build.MODEL).b(com.xiaomi.metoknlp.a.d.b()).c(d).f(a2).e(a3).a(this.f.a()).b(this.f.b());
    }

    private void g() {
        c();
    }

    private void h() {
        if (this.d != 4 || this.e == null) {
            return;
        }
        ((com.xiaomi.metoknlp.a) this.h).a(this.e.a().a().toString());
    }

    private void i() {
        this.g = new k(this, null);
        a = com.xiaomi.metoknlp.b.a().e();
        this.g.execute(new StringBuffer(a).append("/api/v2/realip").toString());
    }

    public void a(Context context) {
        this.h = context;
        this.f = new h(this, null);
        this.c = new g(context);
        this.c.b();
        this.c.a(this.f);
    }

    public void b() {
        if (this.c != null) {
            this.c.c();
            this.c.d();
            this.c = null;
        }
        this.f = null;
    }

    public void c() {
        if (com.xiaomi.metoknlp.b.a().f()) {
            switch (this.d) {
                case 0:
                    this.d = 1;
                    f();
                    if (this.e != null) {
                        e();
                        return;
                    }
                    return;
                case 1:
                    this.d = 2;
                    g();
                    return;
                case 2:
                    this.d = 3;
                    i();
                    return;
                case 3:
                    this.d = 4;
                    this.g.cancel(true);
                    this.g = null;
                    h();
                    return;
                default:
                    return;
            }
        }
    }

    public void d() {
        if (this.c != null) {
            this.c.a();
        }
    }
}
