package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import java.util.Map;
/* loaded from: classes6.dex */
public class au implements ar {

    /* renamed from: a  reason: collision with root package name */
    private static volatile au f14165a;

    /* renamed from: a  reason: collision with other field name */
    private ar f194a;

    private au(Context context) {
        this.f194a = at.a(context);
        com.xiaomi.channel.commonutils.logger.b.m84a("create id manager is: " + this.f194a);
    }

    public static au a(Context context) {
        if (f14165a == null) {
            synchronized (au.class) {
                if (f14165a == null) {
                    f14165a = new au(context.getApplicationContext());
                }
            }
        }
        return f14165a;
    }

    private String a(String str) {
        return str == null ? "" : str;
    }

    @Override // com.xiaomi.push.ar
    public String a() {
        return a(this.f194a.a());
    }

    public void a(Map<String, String> map) {
        if (map == null) {
            return;
        }
        String a2 = a();
        if (!TextUtils.isEmpty(a2)) {
            map.put("udid", a2);
        }
        String mo165b = mo165b();
        if (!TextUtils.isEmpty(mo165b)) {
            map.put("oaid", mo165b);
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
        return this.f194a.m167a();
    }

    @Override // com.xiaomi.push.ar
    /* renamed from: b */
    public String mo165b() {
        return a(this.f194a.mo165b());
    }

    @Override // com.xiaomi.push.ar
    public String c() {
        return a(this.f194a.c());
    }

    @Override // com.xiaomi.push.ar
    public String d() {
        return a(this.f194a.d());
    }
}
