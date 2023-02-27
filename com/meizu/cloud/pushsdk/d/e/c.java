package com.meizu.cloud.pushsdk.d.e;

import android.content.Context;
import android.os.Build;
import com.kuaishou.weapon.p0.u;
import com.meizu.cloud.pushsdk.d.f.e;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class c {
    public static final String a = "c";
    public final HashMap<String, String> b;
    public final HashMap<String, Object> c;
    public final HashMap<String, String> d;

    /* loaded from: classes8.dex */
    public static class a {
        public Context a = null;

        public a a(Context context) {
            this.a = context;
            return this;
        }

        public c a() {
            return new c(this);
        }
    }

    public c(a aVar) {
        this.b = new HashMap<>();
        this.c = new HashMap<>();
        this.d = new HashMap<>();
        d();
        e();
        f();
        g();
        if (aVar.a != null) {
            a(aVar.a);
        }
        com.meizu.cloud.pushsdk.d.f.c.c(a, "Subject created successfully.", new Object[0]);
    }

    private void a(String str, String str2) {
        if (str == null || str2 == null || str.isEmpty() || str2.isEmpty()) {
            return;
        }
        this.d.put(str, str2);
    }

    private void d() {
        a("ot", "android-" + Build.VERSION.RELEASE);
    }

    private void e() {
        a("ov", Build.DISPLAY);
    }

    private void f() {
        a(u.A, Build.MODEL);
    }

    private void g() {
        a("df", Build.MANUFACTURER);
    }

    public Map<String, Object> a() {
        return this.c;
    }

    public void a(Context context) {
        b(context);
    }

    public Map<String, String> b() {
        return this.d;
    }

    public void b(Context context) {
        String b = e.b(context);
        if (b != null) {
            a("ca", b);
        }
    }

    public Map<String, String> c() {
        return this.b;
    }
}
