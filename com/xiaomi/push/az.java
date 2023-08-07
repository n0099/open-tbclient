package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import java.util.Map;
/* loaded from: classes10.dex */
public class az implements at {
    public static volatile az a;

    /* renamed from: a  reason: collision with other field name */
    public int f129a = ay.a;

    /* renamed from: a  reason: collision with other field name */
    public at f130a;

    public az(Context context) {
        this.f130a = ay.a(context);
        com.xiaomi.channel.commonutils.logger.b.m178a("create id manager is: " + this.f129a);
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
    public String mo263a() {
        return a(this.f130a.mo263a());
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
        String mo263a = mo263a();
        if (!TextUtils.isEmpty(mo263a)) {
            map.put("oaid", mo263a);
        }
        String c = c();
        if (!TextUtils.isEmpty(c)) {
            map.put("vaid", c);
        }
        String d = d();
        if (!TextUtils.isEmpty(d)) {
            map.put("aaid", d);
        }
        map.put("oaid_type", String.valueOf(this.f129a));
    }

    @Override // com.xiaomi.push.at
    /* renamed from: a */
    public boolean mo264a() {
        return this.f130a.mo264a();
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
