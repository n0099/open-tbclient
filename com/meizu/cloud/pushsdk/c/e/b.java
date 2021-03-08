package com.meizu.cloud.pushsdk.c.e;

import android.content.Context;
import android.location.Location;
import android.os.Build;
import com.meizu.cloud.pushsdk.c.f.e;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static String f7417a = b.class.getSimpleName();
    private HashMap<String, String> b;
    private HashMap<String, Object> c;
    private HashMap<String, String> d;

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private Context f7418a = null;

        public a a(Context context) {
            this.f7418a = context;
            return this;
        }

        public b a() {
            return new b(this);
        }
    }

    private b(a aVar) {
        this.b = new HashMap<>();
        this.c = new HashMap<>();
        this.d = new HashMap<>();
        d();
        e();
        f();
        g();
        if (aVar.f7418a != null) {
            a(aVar.f7418a);
        }
        com.meizu.cloud.pushsdk.c.f.c.c(f7417a, "Subject created successfully.", new Object[0]);
    }

    private void a(String str, Object obj) {
        if ((str == null || obj == null || str.isEmpty()) && (!(obj instanceof String) || ((String) obj).isEmpty())) {
            return;
        }
        this.c.put(str, obj);
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
        a("dm", Build.MODEL);
    }

    private void g() {
        a("df", Build.MANUFACTURER);
    }

    public Map<String, Object> a() {
        return this.c;
    }

    public void a(Context context) {
        b(context);
        c(context);
    }

    public Map<String, String> b() {
        return this.d;
    }

    public void b(Context context) {
        Location c = e.c(context);
        if (c == null) {
            com.meizu.cloud.pushsdk.c.f.c.a(f7417a, "Location information not available.", new Object[0]);
            return;
        }
        a("la", Double.valueOf(c.getLatitude()));
        a("lt", Double.valueOf(c.getLongitude()));
        a("al", Double.valueOf(c.getAltitude()));
        a("lla", Float.valueOf(c.getAccuracy()));
        a("speed", Float.valueOf(c.getSpeed()));
        a("br", Float.valueOf(c.getBearing()));
    }

    public Map<String, String> c() {
        return this.b;
    }

    public void c(Context context) {
        String b = e.b(context);
        if (b != null) {
            a("ca", b);
        }
    }
}
