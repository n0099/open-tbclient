package com.meizu.cloud.pushsdk.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.location.Location;
import android.os.Build;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.meizu.cloud.pushsdk.c.f.e;
import com.meizu.cloud.pushsdk.util.MzSystemUtils;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class c {
    public static final String a = c.class.getSimpleName();
    private HashMap<String, String> b;
    private HashMap<String, String> c;
    private HashMap<String, Object> d;
    private HashMap<String, Object> e;

    /* loaded from: classes5.dex */
    public static class a {
        private Context a = null;

        public a a(Context context) {
            this.a = context;
            return this;
        }

        public c a() {
            return new c(this);
        }
    }

    private c(a aVar) {
        this.b = new HashMap<>();
        this.c = new HashMap<>();
        this.d = new HashMap<>();
        this.e = new HashMap<>();
        e();
        if (aVar.a != null) {
            a(aVar.a);
        }
        com.meizu.cloud.a.a.i(a, "Subject created successfully.");
    }

    private void a(String str, Object obj) {
        if ((TextUtils.isEmpty(str) || obj == null) && (!(obj instanceof String) || ((String) obj).isEmpty())) {
            return;
        }
        this.d.put(str, obj);
    }

    private void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.b.put(str, str2);
    }

    private void b(String str, Object obj) {
        if ((TextUtils.isEmpty(str) || obj == null) && (!(obj instanceof String) || ((String) obj).isEmpty())) {
            return;
        }
        this.e.put(str, obj);
    }

    private void b(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.c.put(str, str2);
    }

    private void c(Context context) {
        a(b.r, (Object) context.getPackageName());
        a(b.s, (Object) MzSystemUtils.getAppVersionName(context));
        a(b.t, Integer.valueOf(MzSystemUtils.getAppVersionCode(context)));
        a(b.u, MzSystemUtils.getInstalledPackage(context));
        a(b.p, Integer.valueOf(TextUtils.isEmpty(MzSystemUtils.findReceiver(context, "com.meizu.ups.push.intent.MESSAGE", context.getPackageName())) ? 0 : 1));
    }

    private void d(Context context) {
        Location c = e.c(context);
        if (c == null) {
            com.meizu.cloud.a.a.e(a, "Location information not available.");
            return;
        }
        b(b.B, Double.valueOf(c.getLongitude()));
        b(b.C, Double.valueOf(c.getAltitude()));
        b(b.D, Double.valueOf(c.getLatitude()));
    }

    private void e() {
        b(b.g, Build.BRAND);
        b(b.h, Build.MODEL);
        b(b.j, Build.VERSION.RELEASE);
        b(b.k, Build.DISPLAY);
        b(b.m, MzSystemUtils.getCurrentLanguage());
    }

    private void e(Context context) {
        a(b.b, MzSystemUtils.getDeviceId(context));
        a(b.c, MzSystemUtils.getSubscriberId(context, MzSystemUtils.getSubId(context, 0)));
        a(b.d, MzSystemUtils.getSubscriberId(context, MzSystemUtils.getSubId(context, 1)));
        a(b.e, MzSystemUtils.getLineNumber(context));
        b(b.n, MzSystemUtils.getOperator(context));
    }

    private void f(Context context) {
        b(b.i, com.meizu.cloud.pushsdk.base.c.b(context));
        b(b.z, (Object) MzSystemUtils.getNetWorkType(context));
        b(b.A, (Object) MzSystemUtils.getBSSID(context));
    }

    public Map<String, String> a() {
        return this.b;
    }

    public void a(int i, int i2) {
        this.c.put(b.l, Integer.toString(i) + "." + Integer.toString(i2));
    }

    public void a(Context context) {
        d(context);
        e(context);
        b(context);
        f(context);
        c(context);
    }

    public Map<String, String> b() {
        return this.c;
    }

    @TargetApi(19)
    public void b(Context context) {
        Display display;
        try {
            display = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            try {
                Point point = new Point();
                Display.class.getMethod("getSize", Point.class);
                display.getSize(point);
                a(point.x, point.y);
            } catch (Exception e) {
                com.meizu.cloud.a.a.e(a, "Display.getSize isn't available on older devices.");
                if (display != null) {
                    a(display.getWidth(), display.getHeight());
                } else {
                    com.meizu.cloud.a.a.e(a, "error get display");
                }
            }
        } catch (Exception e2) {
            display = null;
        }
    }

    public Map<String, Object> c() {
        return this.d;
    }

    public Map<String, Object> d() {
        return this.e;
    }
}
