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
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f67196a = "c";

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, String> f67197b;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, String> f67198c;

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, Object> f67199d;

    /* renamed from: e  reason: collision with root package name */
    public HashMap<String, Object> f67200e;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Context f67201a = null;

        public a a(Context context) {
            this.f67201a = context;
            return this;
        }

        public c a() {
            return new c(this);
        }
    }

    public c(a aVar) {
        this.f67197b = new HashMap<>();
        this.f67198c = new HashMap<>();
        this.f67199d = new HashMap<>();
        this.f67200e = new HashMap<>();
        e();
        if (aVar.f67201a != null) {
            a(aVar.f67201a);
        }
        b.l.a.a.a.d(f67196a, "Subject created successfully.");
    }

    private void a(Context context, long j) {
        com.meizu.cloud.pushsdk.util.b.a(context, "mz_push_preference", "upload_app_list_time", j);
    }

    private void a(String str, Object obj) {
        if ((TextUtils.isEmpty(str) || obj == null) && (!(obj instanceof String) || ((String) obj).isEmpty())) {
            return;
        }
        this.f67199d.put(str, obj);
    }

    private void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.f67197b.put(str, str2);
    }

    private void b(String str, Object obj) {
        if ((TextUtils.isEmpty(str) || obj == null) && (!(obj instanceof String) || ((String) obj).isEmpty())) {
            return;
        }
        this.f67200e.put(str, obj);
    }

    private void b(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.f67198c.put(str, str2);
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
        b(b.f67193g, Build.BRAND);
        b(b.f67194h, Build.MODEL);
        b(b.j, Build.VERSION.RELEASE);
        b(b.k, Build.DISPLAY);
        b(b.m, MzSystemUtils.getCurrentLanguage());
    }

    private void e(Context context) {
        Location c2 = e.c(context);
        if (c2 == null) {
            b.l.a.a.a.b(f67196a, "Location information not available.");
            return;
        }
        b(b.B, Double.valueOf(c2.getLongitude()));
        b(b.C, Double.valueOf(c2.getAltitude()));
        b(b.D, Double.valueOf(c2.getLatitude()));
    }

    private void f(Context context) {
        a(b.f67188b, MzSystemUtils.getDeviceId(context));
        a(b.f67189c, MzSystemUtils.getSubscriberId(context, MzSystemUtils.getSubId(context, 0)));
        a(b.f67190d, MzSystemUtils.getSubscriberId(context, MzSystemUtils.getSubId(context, 1)));
        a(b.f67191e, MzSystemUtils.getLineNumber(context));
        b(b.n, MzSystemUtils.getOperator(context));
    }

    private void g(Context context) {
        b(b.f67195i, com.meizu.cloud.pushsdk.base.c.b(context));
        b(b.z, (Object) MzSystemUtils.getNetWorkType(context));
        b(b.A, (Object) MzSystemUtils.getBSSID(context));
        b(b.E, MzSystemUtils.getWifiList(context));
    }

    public Map<String, String> a() {
        return this.f67197b;
    }

    public void a(int i2, int i3) {
        this.f67198c.put(b.l, Integer.toString(i2) + "." + Integer.toString(i3));
    }

    public void a(Context context) {
        e(context);
        f(context);
        b(context);
        g(context);
        d(context);
    }

    public Map<String, String> b() {
        return this.f67198c;
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
            b.l.a.a.a.b(f67196a, "Display.getSize isn't available on older devices.");
            if (display != null) {
                a(display.getWidth(), display.getHeight());
            } else {
                b.l.a.a.a.b(f67196a, "error get display");
            }
        }
    }

    public Map<String, Object> c() {
        return this.f67199d;
    }

    public Map<String, Object> d() {
        return this.f67200e;
    }
}
