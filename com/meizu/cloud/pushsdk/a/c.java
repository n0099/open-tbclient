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
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f37256a = "c";

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, String> f37257b;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, String> f37258c;

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, Object> f37259d;

    /* renamed from: e  reason: collision with root package name */
    public HashMap<String, Object> f37260e;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Context f37261a = null;

        public a a(Context context) {
            this.f37261a = context;
            return this;
        }

        public c a() {
            return new c(this);
        }
    }

    public c(a aVar) {
        this.f37257b = new HashMap<>();
        this.f37258c = new HashMap<>();
        this.f37259d = new HashMap<>();
        this.f37260e = new HashMap<>();
        e();
        if (aVar.f37261a != null) {
            a(aVar.f37261a);
        }
        d.h.a.a.a.d(f37256a, "Subject created successfully.");
    }

    private void a(Context context, long j) {
        com.meizu.cloud.pushsdk.util.b.a(context, "mz_push_preference", "upload_app_list_time", j);
    }

    private void a(String str, Object obj) {
        if ((TextUtils.isEmpty(str) || obj == null) && (!(obj instanceof String) || ((String) obj).isEmpty())) {
            return;
        }
        this.f37259d.put(str, obj);
    }

    private void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.f37257b.put(str, str2);
    }

    private void b(String str, Object obj) {
        if ((TextUtils.isEmpty(str) || obj == null) && (!(obj instanceof String) || ((String) obj).isEmpty())) {
            return;
        }
        this.f37260e.put(str, obj);
    }

    private void b(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.f37258c.put(str, str2);
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
        b(b.f37253g, Build.BRAND);
        b(b.f37254h, Build.MODEL);
        b(b.j, Build.VERSION.RELEASE);
        b(b.k, Build.DISPLAY);
        b(b.m, MzSystemUtils.getCurrentLanguage());
    }

    private void e(Context context) {
        Location c2 = e.c(context);
        if (c2 == null) {
            d.h.a.a.a.b(f37256a, "Location information not available.");
            return;
        }
        b(b.B, Double.valueOf(c2.getLongitude()));
        b(b.C, Double.valueOf(c2.getAltitude()));
        b(b.D, Double.valueOf(c2.getLatitude()));
    }

    private void f(Context context) {
        a(b.f37248b, MzSystemUtils.getDeviceId(context));
        a(b.f37249c, MzSystemUtils.getSubscriberId(context, MzSystemUtils.getSubId(context, 0)));
        a(b.f37250d, MzSystemUtils.getSubscriberId(context, MzSystemUtils.getSubId(context, 1)));
        a(b.f37251e, MzSystemUtils.getLineNumber(context));
        b(b.n, MzSystemUtils.getOperator(context));
    }

    private void g(Context context) {
        b(b.f37255i, com.meizu.cloud.pushsdk.base.c.b(context));
        b(b.z, (Object) MzSystemUtils.getNetWorkType(context));
        b(b.A, (Object) MzSystemUtils.getBSSID(context));
        b(b.E, MzSystemUtils.getWifiList(context));
    }

    public Map<String, String> a() {
        return this.f37257b;
    }

    public void a(int i2, int i3) {
        this.f37258c.put(b.l, Integer.toString(i2) + "." + Integer.toString(i3));
    }

    public void a(Context context) {
        e(context);
        f(context);
        b(context);
        g(context);
        d(context);
    }

    public Map<String, String> b() {
        return this.f37258c;
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
            d.h.a.a.a.b(f37256a, "Display.getSize isn't available on older devices.");
            if (display != null) {
                a(display.getWidth(), display.getHeight());
            } else {
                d.h.a.a.a.b(f37256a, "error get display");
            }
        }
    }

    public Map<String, Object> c() {
        return this.f37259d;
    }

    public Map<String, Object> d() {
        return this.f37260e;
    }
}
