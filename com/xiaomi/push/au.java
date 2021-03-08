package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import java.util.Map;
/* loaded from: classes5.dex */
public class au implements ar {

    /* renamed from: a  reason: collision with root package name */
    private static volatile au f8263a;

    /* renamed from: a  reason: collision with other field name */
    private ar f114a;

    private au(Context context) {
        this.f114a = at.a(context);
        com.xiaomi.channel.commonutils.logger.b.m58a("create id manager is: " + this.f114a);
    }

    public static au a(Context context) {
        if (f8263a == null) {
            synchronized (au.class) {
                if (f8263a == null) {
                    f8263a = new au(context.getApplicationContext());
                }
            }
        }
        return f8263a;
    }

    private String a(String str) {
        return str == null ? "" : str;
    }

    @Override // com.xiaomi.push.ar
    public String a() {
        return a(this.f114a.a());
    }

    public void a(Map<String, String> map) {
        if (map == null) {
            return;
        }
        String a2 = a();
        if (!TextUtils.isEmpty(a2)) {
            map.put("udid", a2);
        }
        String mo139b = mo139b();
        if (!TextUtils.isEmpty(mo139b)) {
            map.put("oaid", mo139b);
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
        return this.f114a.m141a();
    }

    @Override // com.xiaomi.push.ar
    /* renamed from: b */
    public String mo139b() {
        return a(this.f114a.mo139b());
    }

    @Override // com.xiaomi.push.ar
    public String c() {
        return a(this.f114a.c());
    }

    @Override // com.xiaomi.push.ar
    public String d() {
        return a(this.f114a.d());
    }
}
