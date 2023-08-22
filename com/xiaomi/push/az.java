package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import java.util.Map;
/* loaded from: classes10.dex */
public class az implements at {
    public static volatile az a;

    /* renamed from: a  reason: collision with other field name */
    public int f130a = ay.a;

    /* renamed from: a  reason: collision with other field name */
    public at f131a;

    public az(Context context) {
        this.f131a = ay.a(context);
        com.xiaomi.channel.commonutils.logger.b.m180a("create id manager is: " + this.f130a);
    }

    public static az a(Context context) {
        if (a == null) {
            synchronized (az.class) {
                if (a == null) {
                    a = new az(context.getApplicationContext());
                }
            }
        }
        return a;
    }

    private String a(String str) {
        return str == null ? "" : str;
    }

    @Override // com.xiaomi.push.at
    /* renamed from: a */
    public String mo265a() {
        return a(this.f131a.mo265a());
    }

    /* JADX DEBUG: Possible override for method com.xiaomi.push.at.a()Ljava/lang/String; */
    /* JADX DEBUG: Possible override for method com.xiaomi.push.at.a()Z */
    public void a() {
    }

    public void a(Map<String, String> map) {
        if (map == null) {
            return;
        }
        String b = b();
        if (!TextUtils.isEmpty(b)) {
            map.put("udid", b);
        }
        String mo265a = mo265a();
        if (!TextUtils.isEmpty(mo265a)) {
            map.put("oaid", mo265a);
        }
        String c = c();
        if (!TextUtils.isEmpty(c)) {
            map.put("vaid", c);
        }
        String d = d();
        if (!TextUtils.isEmpty(d)) {
            map.put("aaid", d);
        }
        map.put("oaid_type", String.valueOf(this.f130a));
    }

    @Override // com.xiaomi.push.at
    /* renamed from: a */
    public boolean mo266a() {
        return this.f131a.mo266a();
    }

    public String b() {
        return null;
    }

    public String c() {
        return null;
    }

    public String d() {
        return null;
    }
}
