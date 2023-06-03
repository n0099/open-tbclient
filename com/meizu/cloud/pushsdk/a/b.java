package com.meizu.cloud.pushsdk.a;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.text.TextUtils;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.d.f.e;
import com.meizu.cloud.pushsdk.util.MzSystemUtils;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class b {
    public static final String a = "b";
    public final HashMap<String, String> b;
    public final HashMap<String, Object> c;
    public final HashMap<String, Object> d;

    /* loaded from: classes10.dex */
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
        this.b = new HashMap<>();
        this.c = new HashMap<>();
        this.d = new HashMap<>();
        d();
        if (aVar.a != null) {
            b(aVar.a);
            a(aVar.a);
            c(aVar.a);
            d(aVar.a);
        }
        DebugLogger.i(a, "Subject created successfully.");
    }

    private void a(String str, int i, int i2) {
        this.b.put(str, i + "." + i2);
    }

    private void a(String str, Object obj) {
        if (TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        if ((obj instanceof String) && ((String) obj).isEmpty()) {
            return;
        }
        this.c.put(str, obj);
    }

    private void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.b.put(str, str2);
    }

    private void b(Context context) {
        a("op", e.c(context));
    }

    private void b(String str, Object obj) {
        if (TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        if ((obj instanceof String) && ((String) obj).isEmpty()) {
            return;
        }
        this.d.put(str, obj);
    }

    private void c(Context context) {
        b("nt", MzSystemUtils.getNetWorkType(context));
    }

    private void d() {
        a("br", Build.BRAND);
        a("dc", Build.MODEL);
        a("ot", Build.VERSION.RELEASE);
        a("ov", Build.DISPLAY);
        a("ll", MzSystemUtils.getCurrentLanguage());
    }

    private void d(Context context) {
        a("pn", (Object) context.getPackageName());
        a("pv", (Object) MzSystemUtils.getAppVersionName(context));
        a("pvc", Integer.valueOf(MzSystemUtils.getAppVersionCode(context)));
        a("st", Integer.valueOf(!TextUtils.isEmpty(MzSystemUtils.findReceiver(context, "com.meizu.ups.push.intent.MESSAGE", context.getPackageName())) ? 1 : 0));
    }

    public Map<String, String> a() {
        return this.b;
    }

    public void a(Context context) {
        Point d = e.d(context);
        if (d == null) {
            DebugLogger.e(a, "screen information not available.");
        } else {
            a("ss", d.x, d.y);
        }
    }

    public Map<String, Object> b() {
        return this.c;
    }

    public Map<String, Object> c() {
        return this.d;
    }
}
