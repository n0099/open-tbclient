package com.meizu.cloud.pushsdk.b.e;

import android.content.Context;
import android.location.Location;
import android.os.Build;
import com.baidu.ar.util.Constants;
import com.meizu.cloud.pushsdk.b.f.e;
import com.sina.weibo.sdk.constant.WBPageConstants;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class b {
    private static String a = b.class.getSimpleName();
    private HashMap<String, String> b;
    private HashMap<String, Object> c;
    private HashMap<String, String> d;

    private b(a aVar) {
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
        com.meizu.cloud.pushsdk.b.f.c.c(a, "Subject created successfully.", new Object[0]);
    }

    /* loaded from: classes2.dex */
    public static class a {
        private Context a = null;

        public a a(Context context) {
            this.a = context;
            return this;
        }

        public b a() {
            return new b(this);
        }
    }

    public void a(Context context) {
        b(context);
        c(context);
    }

    private void a(String str, String str2) {
        if (str != null && str2 != null && !str.isEmpty() && !str2.isEmpty()) {
            this.d.put(str, str2);
        }
    }

    private void a(String str, Object obj) {
        if ((str != null && obj != null && !str.isEmpty()) || ((obj instanceof String) && !((String) obj).isEmpty())) {
            this.c.put(str, obj);
        }
    }

    private void d() {
        a(Constants.HTTP_OS_TYPE, "android-" + Build.VERSION.RELEASE);
    }

    private void e() {
        a("osVersion", Build.DISPLAY);
    }

    private void f() {
        a("deviceModel", Build.MODEL);
    }

    private void g() {
        a("deviceManufacturer", Build.MANUFACTURER);
    }

    public void b(Context context) {
        Location c = e.c(context);
        if (c == null) {
            com.meizu.cloud.pushsdk.b.f.c.a(a, "Location information not available.", new Object[0]);
            return;
        }
        a(WBPageConstants.ParamKey.LATITUDE, Double.valueOf(c.getLatitude()));
        a(WBPageConstants.ParamKey.LONGITUDE, Double.valueOf(c.getLongitude()));
        a("altitude", Double.valueOf(c.getAltitude()));
        a("latitudeLongitudeAccuracy", Float.valueOf(c.getAccuracy()));
        a("speed", Float.valueOf(c.getSpeed()));
        a("bearing", Float.valueOf(c.getBearing()));
    }

    public void c(Context context) {
        String b = e.b(context);
        if (b != null) {
            a("carrier", b);
        }
    }

    public Map<String, Object> a() {
        return this.c;
    }

    public Map<String, String> b() {
        return this.d;
    }

    public Map<String, String> c() {
        return this.b;
    }
}
