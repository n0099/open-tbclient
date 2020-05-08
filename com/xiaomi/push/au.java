package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import java.util.Map;
/* loaded from: classes8.dex */
public class au implements ar {
    private static volatile au a;

    /* renamed from: a  reason: collision with other field name */
    private ar f113a;

    private au(Context context) {
        this.f113a = at.a(context);
        com.xiaomi.channel.commonutils.logger.b.m50a("create id manager is: " + this.f113a);
    }

    public static au a(Context context) {
        if (a == null) {
            synchronized (au.class) {
                if (a == null) {
                    a = new au(context.getApplicationContext());
                }
            }
        }
        return a;
    }

    private String a(String str) {
        return str == null ? "" : str;
    }

    @Override // com.xiaomi.push.ar
    public String a() {
        return a(this.f113a.a());
    }

    public void a(Map<String, String> map) {
        if (map == null) {
            return;
        }
        String a2 = a();
        if (!TextUtils.isEmpty(a2)) {
            map.put("udid", a2);
        }
        String mo131b = mo131b();
        if (!TextUtils.isEmpty(mo131b)) {
            map.put("oaid", mo131b);
        }
        String c = c();
        if (!TextUtils.isEmpty(c)) {
            map.put("vaid", c);
        }
        String d = d();
        if (TextUtils.isEmpty(d)) {
            return;
        }
        map.put("aaid", d);
    }

    @Override // com.xiaomi.push.ar
    public boolean a() {
        return this.f113a.m133a();
    }

    @Override // com.xiaomi.push.ar
    /* renamed from: b */
    public String mo131b() {
        return a(this.f113a.mo131b());
    }

    @Override // com.xiaomi.push.ar
    public String c() {
        return a(this.f113a.c());
    }

    @Override // com.xiaomi.push.ar
    public String d() {
        return a(this.f113a.d());
    }
}
