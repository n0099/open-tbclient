package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import java.util.Map;
/* loaded from: classes18.dex */
public class au implements ar {

    /* renamed from: a  reason: collision with root package name */
    private static volatile au f4800a;

    /* renamed from: a  reason: collision with other field name */
    private ar f117a;

    private au(Context context) {
        this.f117a = at.a(context);
        com.xiaomi.channel.commonutils.logger.b.m57a("create id manager is: " + this.f117a);
    }

    public static au a(Context context) {
        if (f4800a == null) {
            synchronized (au.class) {
                if (f4800a == null) {
                    f4800a = new au(context.getApplicationContext());
                }
            }
        }
        return f4800a;
    }

    private String a(String str) {
        return str == null ? "" : str;
    }

    @Override // com.xiaomi.push.ar
    public String a() {
        return a(this.f117a.a());
    }

    public void a(Map<String, String> map) {
        if (map == null) {
            return;
        }
        String a2 = a();
        if (!TextUtils.isEmpty(a2)) {
            map.put("udid", a2);
        }
        String mo138b = mo138b();
        if (!TextUtils.isEmpty(mo138b)) {
            map.put("oaid", mo138b);
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
        return this.f117a.m140a();
    }

    @Override // com.xiaomi.push.ar
    /* renamed from: b */
    public String mo138b() {
        return a(this.f117a.mo138b());
    }

    @Override // com.xiaomi.push.ar
    public String c() {
        return a(this.f117a.c());
    }

    @Override // com.xiaomi.push.ar
    public String d() {
        return a(this.f117a.d());
    }
}
