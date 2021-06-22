package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import java.util.Map;
/* loaded from: classes7.dex */
public class ax implements ar {

    /* renamed from: a  reason: collision with root package name */
    public static volatile ax f41108a;

    /* renamed from: a  reason: collision with other field name */
    public int f134a = aw.f41107a;

    /* renamed from: a  reason: collision with other field name */
    public ar f135a;

    public ax(Context context) {
        this.f135a = aw.a(context);
        com.xiaomi.channel.commonutils.logger.b.m56a("create id manager is: " + this.f134a);
    }

    public static ax a(Context context) {
        if (f41108a == null) {
            synchronized (ax.class) {
                if (f41108a == null) {
                    f41108a = new ax(context.getApplicationContext());
                }
            }
        }
        return f41108a;
    }

    private String a(String str) {
        return str == null ? "" : str;
    }

    private String b(String str) {
        return TextUtils.isEmpty(str) ? "" : str.length() > 5 ? str.substring(str.length() - 5) : str;
    }

    @Override // com.xiaomi.push.ar
    public String a() {
        return a(this.f135a.a());
    }

    public void a(Map<String, String> map) {
        if (map == null) {
            return;
        }
        String a2 = a();
        if (!TextUtils.isEmpty(a2)) {
            map.put("udid", a2);
        }
        String mo135b = mo135b();
        if (!TextUtils.isEmpty(mo135b)) {
            map.put("oaid", mo135b);
        }
        String c2 = c();
        if (!TextUtils.isEmpty(c2)) {
            map.put("vaid", c2);
        }
        String d2 = d();
        if (!TextUtils.isEmpty(d2)) {
            map.put("aaid", d2);
        }
        map.put("oaid_type", String.valueOf(this.f134a));
    }

    @Override // com.xiaomi.push.ar
    public boolean a() {
        return this.f135a.m137a();
    }

    @Override // com.xiaomi.push.ar
    /* renamed from: b */
    public String mo135b() {
        return a(this.f135a.mo135b());
    }

    @Override // com.xiaomi.push.ar
    public String c() {
        return a(this.f135a.c());
    }

    @Override // com.xiaomi.push.ar
    public String d() {
        return a(this.f135a.d());
    }

    public String e() {
        return "t:" + this.f134a + " s:" + a() + " d:" + b(a()) + " | " + b(mo135b()) + " | " + b(c()) + " | " + b(d());
    }
}
