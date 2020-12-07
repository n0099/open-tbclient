package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import java.util.Map;
/* loaded from: classes18.dex */
public class au implements ar {

    /* renamed from: a  reason: collision with root package name */
    private static volatile au f4570a;

    /* renamed from: a  reason: collision with other field name */
    private ar f115a;

    private au(Context context) {
        this.f115a = at.a(context);
        com.xiaomi.channel.commonutils.logger.b.m47a("create id manager is: " + this.f115a);
    }

    public static au a(Context context) {
        if (f4570a == null) {
            synchronized (au.class) {
                if (f4570a == null) {
                    f4570a = new au(context.getApplicationContext());
                }
            }
        }
        return f4570a;
    }

    private String a(String str) {
        return str == null ? "" : str;
    }

    @Override // com.xiaomi.push.ar
    public String a() {
        return a(this.f115a.a());
    }

    public void a(Map<String, String> map) {
        if (map == null) {
            return;
        }
        String a2 = a();
        if (!TextUtils.isEmpty(a2)) {
            map.put("udid", a2);
        }
        String mo128b = mo128b();
        if (!TextUtils.isEmpty(mo128b)) {
            map.put("oaid", mo128b);
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
        return this.f115a.m130a();
    }

    @Override // com.xiaomi.push.ar
    /* renamed from: b */
    public String mo128b() {
        return a(this.f115a.mo128b());
    }

    @Override // com.xiaomi.push.ar
    public String c() {
        return a(this.f115a.c());
    }

    @Override // com.xiaomi.push.ar
    public String d() {
        return a(this.f115a.d());
    }
}
