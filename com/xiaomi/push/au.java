package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import java.util.Map;
/* loaded from: classes6.dex */
public class au implements ar {

    /* renamed from: a  reason: collision with root package name */
    private static volatile au f13867a;

    /* renamed from: a  reason: collision with other field name */
    private ar f193a;

    private au(Context context) {
        this.f193a = at.a(context);
        com.xiaomi.channel.commonutils.logger.b.m80a("create id manager is: " + this.f193a);
    }

    public static au a(Context context) {
        if (f13867a == null) {
            synchronized (au.class) {
                if (f13867a == null) {
                    f13867a = new au(context.getApplicationContext());
                }
            }
        }
        return f13867a;
    }

    private String a(String str) {
        return str == null ? "" : str;
    }

    @Override // com.xiaomi.push.ar
    public String a() {
        return a(this.f193a.a());
    }

    public void a(Map<String, String> map) {
        if (map == null) {
            return;
        }
        String a2 = a();
        if (!TextUtils.isEmpty(a2)) {
            map.put("udid", a2);
        }
        String mo161b = mo161b();
        if (!TextUtils.isEmpty(mo161b)) {
            map.put("oaid", mo161b);
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
        return this.f193a.m163a();
    }

    @Override // com.xiaomi.push.ar
    /* renamed from: b */
    public String mo161b() {
        return a(this.f193a.mo161b());
    }

    @Override // com.xiaomi.push.ar
    public String c() {
        return a(this.f193a.c());
    }

    @Override // com.xiaomi.push.ar
    public String d() {
        return a(this.f193a.d());
    }
}
