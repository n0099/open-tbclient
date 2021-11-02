package com.meizu.cloud.pushsdk.c.e;

import android.content.Context;
import android.location.Location;
import android.os.Build;
import com.baidu.pass.face.platform.common.ConstantHelper;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.meizu.cloud.pushsdk.c.f.e;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static String f67564a = "b";

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, String> f67565b;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, Object> f67566c;

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, String> f67567d;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Context f67568a = null;

        public a a(Context context) {
            this.f67568a = context;
            return this;
        }

        public b a() {
            return new b(this);
        }
    }

    public b(a aVar) {
        this.f67565b = new HashMap<>();
        this.f67566c = new HashMap<>();
        this.f67567d = new HashMap<>();
        d();
        e();
        f();
        g();
        if (aVar.f67568a != null) {
            a(aVar.f67568a);
        }
        com.meizu.cloud.pushsdk.c.f.c.c(f67564a, "Subject created successfully.", new Object[0]);
    }

    private void a(String str, Object obj) {
        if ((str == null || obj == null || str.isEmpty()) && (!(obj instanceof String) || ((String) obj).isEmpty())) {
            return;
        }
        this.f67566c.put(str, obj);
    }

    private void a(String str, String str2) {
        if (str == null || str2 == null || str.isEmpty() || str2.isEmpty()) {
            return;
        }
        this.f67567d.put(str, str2);
    }

    private void d() {
        a("ot", "android-" + Build.VERSION.RELEASE);
    }

    private void e() {
        a(SearchJsBridge.COOKIE_OV, Build.DISPLAY);
    }

    private void f() {
        a("dm", Build.MODEL);
    }

    private void g() {
        a("df", Build.MANUFACTURER);
    }

    public Map<String, Object> a() {
        return this.f67566c;
    }

    public void a(Context context) {
        b(context);
        c(context);
    }

    public Map<String, String> b() {
        return this.f67567d;
    }

    public void b(Context context) {
        Location c2 = e.c(context);
        if (c2 == null) {
            com.meizu.cloud.pushsdk.c.f.c.a(f67564a, "Location information not available.", new Object[0]);
            return;
        }
        a("la", Double.valueOf(c2.getLatitude()));
        a("lt", Double.valueOf(c2.getLongitude()));
        a("al", Double.valueOf(c2.getAltitude()));
        a("lla", Float.valueOf(c2.getAccuracy()));
        a("speed", Float.valueOf(c2.getSpeed()));
        a("br", Float.valueOf(c2.getBearing()));
    }

    public Map<String, String> c() {
        return this.f67565b;
    }

    public void c(Context context) {
        String b2 = e.b(context);
        if (b2 != null) {
            a(ConstantHelper.LOG_CATE, b2);
        }
    }
}
