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
/* loaded from: classes7.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f38192a = "c";

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, String> f38193b;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, String> f38194c;

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, Object> f38195d;

    /* renamed from: e  reason: collision with root package name */
    public HashMap<String, Object> f38196e;

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Context f38197a = null;

        public a a(Context context) {
            this.f38197a = context;
            return this;
        }

        public c a() {
            return new c(this);
        }
    }

    public c(a aVar) {
        this.f38193b = new HashMap<>();
        this.f38194c = new HashMap<>();
        this.f38195d = new HashMap<>();
        this.f38196e = new HashMap<>();
        e();
        if (aVar.f38197a != null) {
            a(aVar.f38197a);
        }
        d.j.a.a.a.d(f38192a, "Subject created successfully.");
    }

    private void a(Context context, long j) {
        com.meizu.cloud.pushsdk.util.b.a(context, "mz_push_preference", "upload_app_list_time", j);
    }

    private void a(String str, Object obj) {
        if ((TextUtils.isEmpty(str) || obj == null) && (!(obj instanceof String) || ((String) obj).isEmpty())) {
            return;
        }
        this.f38195d.put(str, obj);
    }

    private void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.f38193b.put(str, str2);
    }

    private void b(String str, Object obj) {
        if ((TextUtils.isEmpty(str) || obj == null) && (!(obj instanceof String) || ((String) obj).isEmpty())) {
            return;
        }
        this.f38196e.put(str, obj);
    }

    private void b(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.f38194c.put(str, str2);
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
        b(b.f38189g, Build.BRAND);
        b(b.f38190h, Build.MODEL);
        b(b.j, Build.VERSION.RELEASE);
        b(b.k, Build.DISPLAY);
        b(b.m, MzSystemUtils.getCurrentLanguage());
    }

    private void e(Context context) {
        Location c2 = e.c(context);
        if (c2 == null) {
            d.j.a.a.a.b(f38192a, "Location information not available.");
            return;
        }
        b(b.B, Double.valueOf(c2.getLongitude()));
        b(b.C, Double.valueOf(c2.getAltitude()));
        b(b.D, Double.valueOf(c2.getLatitude()));
    }

    private void f(Context context) {
        a(b.f38184b, MzSystemUtils.getDeviceId(context));
        a(b.f38185c, MzSystemUtils.getSubscriberId(context, MzSystemUtils.getSubId(context, 0)));
        a(b.f38186d, MzSystemUtils.getSubscriberId(context, MzSystemUtils.getSubId(context, 1)));
        a(b.f38187e, MzSystemUtils.getLineNumber(context));
        b(b.n, MzSystemUtils.getOperator(context));
    }

    private void g(Context context) {
        b(b.f38191i, com.meizu.cloud.pushsdk.base.c.b(context));
        b(b.z, (Object) MzSystemUtils.getNetWorkType(context));
        b(b.A, (Object) MzSystemUtils.getBSSID(context));
        b(b.E, MzSystemUtils.getWifiList(context));
    }

    public Map<String, String> a() {
        return this.f38193b;
    }

    public void a(int i2, int i3) {
        this.f38194c.put(b.l, Integer.toString(i2) + "." + Integer.toString(i3));
    }

    public void a(Context context) {
        e(context);
        f(context);
        b(context);
        g(context);
        d(context);
    }

    public Map<String, String> b() {
        return this.f38194c;
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
            d.j.a.a.a.b(f38192a, "Display.getSize isn't available on older devices.");
            if (display != null) {
                a(display.getWidth(), display.getHeight());
            } else {
                d.j.a.a.a.b(f38192a, "error get display");
            }
        }
    }

    public Map<String, Object> c() {
        return this.f38195d;
    }

    public Map<String, Object> d() {
        return this.f38196e;
    }
}
