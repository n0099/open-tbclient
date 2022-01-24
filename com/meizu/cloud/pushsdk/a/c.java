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
/* loaded from: classes3.dex */
public class c {
    public static final String a = "c";

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, String> f58502b;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, String> f58503c;

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, Object> f58504d;

    /* renamed from: e  reason: collision with root package name */
    public HashMap<String, Object> f58505e;

    /* loaded from: classes3.dex */
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
        this.f58502b = new HashMap<>();
        this.f58503c = new HashMap<>();
        this.f58504d = new HashMap<>();
        this.f58505e = new HashMap<>();
        e();
        if (aVar.a != null) {
            a(aVar.a);
        }
        c.k.a.a.a.d(a, "Subject created successfully.");
    }

    private void a(Context context, long j2) {
        com.meizu.cloud.pushsdk.util.b.a(context, "mz_push_preference", "upload_app_list_time", j2);
    }

    private void a(String str, Object obj) {
        if ((TextUtils.isEmpty(str) || obj == null) && (!(obj instanceof String) || ((String) obj).isEmpty())) {
            return;
        }
        this.f58504d.put(str, obj);
    }

    private void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.f58502b.put(str, str2);
    }

    private void b(String str, Object obj) {
        if ((TextUtils.isEmpty(str) || obj == null) && (!(obj instanceof String) || ((String) obj).isEmpty())) {
            return;
        }
        this.f58505e.put(str, obj);
    }

    private void b(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.f58503c.put(str, str2);
    }

    private long c(Context context) {
        return com.meizu.cloud.pushsdk.util.b.c(context, "mz_push_preference", "upload_app_list_time");
    }

    private void d(Context context) {
        a(b.r, (Object) context.getPackageName());
        a(b.s, (Object) MzSystemUtils.getAppVersionName(context));
        a(b.t, Integer.valueOf(MzSystemUtils.getAppVersionCode(context)));
        if (System.currentTimeMillis() - c(context) > 86400000) {
            a(b.u, MzSystemUtils.getInstalledPackage(context));
            a(context, System.currentTimeMillis());
        }
        a(b.p, Integer.valueOf(!TextUtils.isEmpty(MzSystemUtils.findReceiver(context, "com.meizu.ups.push.intent.MESSAGE", context.getPackageName())) ? 1 : 0));
    }

    private void e() {
        b(b.f58498g, Build.BRAND);
        b(b.f58499h, Build.MODEL);
        b(b.f58501j, Build.VERSION.RELEASE);
        b(b.k, Build.DISPLAY);
        b(b.m, MzSystemUtils.getCurrentLanguage());
    }

    private void e(Context context) {
        Location c2 = e.c(context);
        if (c2 == null) {
            c.k.a.a.a.b(a, "Location information not available.");
            return;
        }
        b(b.B, Double.valueOf(c2.getLongitude()));
        b(b.C, Double.valueOf(c2.getAltitude()));
        b(b.D, Double.valueOf(c2.getLatitude()));
    }

    private void f(Context context) {
        a(b.f58493b, MzSystemUtils.getDeviceId(context));
        a(b.f58494c, MzSystemUtils.getSubscriberId(context, MzSystemUtils.getSubId(context, 0)));
        a(b.f58495d, MzSystemUtils.getSubscriberId(context, MzSystemUtils.getSubId(context, 1)));
        a(b.f58496e, MzSystemUtils.getLineNumber(context));
        b(b.n, MzSystemUtils.getOperator(context));
    }

    private void g(Context context) {
        b(b.f58500i, com.meizu.cloud.pushsdk.base.c.b(context));
        b(b.z, (Object) MzSystemUtils.getNetWorkType(context));
        b(b.A, (Object) MzSystemUtils.getBSSID(context));
        b(b.E, MzSystemUtils.getWifiList(context));
    }

    public Map<String, String> a() {
        return this.f58502b;
    }

    public void a(int i2, int i3) {
        this.f58503c.put(b.l, Integer.toString(i2) + "." + Integer.toString(i3));
    }

    public void a(Context context) {
        e(context);
        f(context);
        b(context);
        g(context);
        d(context);
    }

    public Map<String, String> b() {
        return this.f58503c;
    }

    @TargetApi(19)
    public void b(Context context) {
        Display display = null;
        try {
            display = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            Display.class.getMethod("getSize", Point.class);
            display.getSize(point);
            a(point.x, point.y);
        } catch (Exception unused) {
            c.k.a.a.a.b(a, "Display.getSize isn't available on older devices.");
            if (display != null) {
                a(display.getWidth(), display.getHeight());
            } else {
                c.k.a.a.a.b(a, "error get display");
            }
        }
    }

    public Map<String, Object> c() {
        return this.f58504d;
    }

    public Map<String, Object> d() {
        return this.f58505e;
    }
}
