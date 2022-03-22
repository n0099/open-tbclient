package com.meizu.cloud.pushsdk.c.e;

import android.content.Context;
import android.location.Location;
import android.os.Build;
import com.baidu.sofire.d.D;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import com.kuaishou.weapon.un.x;
import com.meizu.cloud.pushsdk.c.f.e;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class b {
    public static String a = "b";

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, String> f42130b;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, Object> f42131c;

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, String> f42132d;

    /* loaded from: classes7.dex */
    public static class a {
        public Context a = null;

        public a a(Context context) {
            this.a = context;
            return this;
        }

        public b a() {
            return new b(this);
        }
    }

    public b(a aVar) {
        this.f42130b = new HashMap<>();
        this.f42131c = new HashMap<>();
        this.f42132d = new HashMap<>();
        d();
        e();
        f();
        g();
        if (aVar.a != null) {
            a(aVar.a);
        }
        com.meizu.cloud.pushsdk.c.f.c.c(a, "Subject created successfully.", new Object[0]);
    }

    private void a(String str, Object obj) {
        if ((str == null || obj == null || str.isEmpty()) && (!(obj instanceof String) || ((String) obj).isEmpty())) {
            return;
        }
        this.f42131c.put(str, obj);
    }

    private void a(String str, String str2) {
        if (str == null || str2 == null || str.isEmpty() || str2.isEmpty()) {
            return;
        }
        this.f42132d.put(str, str2);
    }

    private void d() {
        a("ot", "android-" + Build.VERSION.RELEASE);
    }

    private void e() {
        a(SearchJsBridge.COOKIE_OV, Build.DISPLAY);
    }

    private void f() {
        a(x.B, Build.MODEL);
    }

    private void g() {
        a("df", Build.MANUFACTURER);
    }

    public Map<String, Object> a() {
        return this.f42131c;
    }

    public void a(Context context) {
        b(context);
        c(context);
    }

    public Map<String, String> b() {
        return this.f42132d;
    }

    public void b(Context context) {
        Location c2 = e.c(context);
        if (c2 == null) {
            com.meizu.cloud.pushsdk.c.f.c.a(a, "Location information not available.", new Object[0]);
            return;
        }
        a(D.COLUMN_PLUGIN_PLUGIN_NOT_EXIST_LAST_POINT, Double.valueOf(c2.getLatitude()));
        a(WebvttCueParser.ENTITY_LESS_THAN, Double.valueOf(c2.getLongitude()));
        a("al", Double.valueOf(c2.getAltitude()));
        a("lla", Float.valueOf(c2.getAccuracy()));
        a("speed", Float.valueOf(c2.getSpeed()));
        a(TtmlNode.TAG_BR, Float.valueOf(c2.getBearing()));
    }

    public Map<String, String> c() {
        return this.f42130b;
    }

    public void c(Context context) {
        String b2 = e.b(context);
        if (b2 != null) {
            a("ca", b2);
        }
    }
}
