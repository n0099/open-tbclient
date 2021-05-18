package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import java.util.Map;
/* loaded from: classes7.dex */
public class ax implements ar {

    /* renamed from: a  reason: collision with root package name */
    public static volatile ax f37397a;

    /* renamed from: a  reason: collision with other field name */
    public int f134a = aw.f37396a;

    /* renamed from: a  reason: collision with other field name */
    public ar f135a;

    public ax(Context context) {
        this.f135a = aw.a(context);
        com.xiaomi.channel.commonutils.logger.b.m57a("create id manager is: " + this.f134a);
    }

    public static ax a(Context context) {
        if (f37397a == null) {
            synchronized (ax.class) {
                if (f37397a == null) {
                    f37397a = new ax(context.getApplicationContext());
                }
            }
        }
        return f37397a;
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
        String mo136b = mo136b();
        if (!TextUtils.isEmpty(mo136b)) {
            map.put("oaid", mo136b);
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
        return this.f135a.m138a();
    }

    @Override // com.xiaomi.push.ar
    /* renamed from: b */
    public String mo136b() {
        return a(this.f135a.mo136b());
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
        return "t:" + this.f134a + " s:" + a() + " d:" + b(a()) + " | " + b(mo136b()) + " | " + b(c()) + " | " + b(d());
    }
}
