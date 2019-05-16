package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {
    private static volatile d b;
    String a;
    private Context c;
    private a d;
    private Map<String, a> e;

    /* loaded from: classes3.dex */
    public static class a {
        public String a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;
        public boolean i = true;
        public boolean j = false;
        public int k = 1;
        private Context l;

        public a(Context context) {
            this.l = context;
        }

        public static a a(Context context, String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                a aVar = new a(context);
                aVar.a = jSONObject.getString("appId");
                aVar.b = jSONObject.getString("appToken");
                aVar.c = jSONObject.getString("regId");
                aVar.d = jSONObject.getString("regSec");
                aVar.f = jSONObject.getString("devId");
                aVar.e = jSONObject.getString("vName");
                aVar.i = jSONObject.getBoolean("valid");
                aVar.j = jSONObject.getBoolean("paused");
                aVar.k = jSONObject.getInt("envType");
                aVar.g = jSONObject.getString("regResource");
                return aVar;
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.a(th);
                return null;
            }
        }

        public static String a(a aVar) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("appId", aVar.a);
                jSONObject.put("appToken", aVar.b);
                jSONObject.put("regId", aVar.c);
                jSONObject.put("regSec", aVar.d);
                jSONObject.put("devId", aVar.f);
                jSONObject.put("vName", aVar.e);
                jSONObject.put("valid", aVar.i);
                jSONObject.put("paused", aVar.j);
                jSONObject.put("envType", aVar.k);
                jSONObject.put("regResource", aVar.g);
                return jSONObject.toString();
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.a(th);
                return null;
            }
        }

        private String d() {
            return com.xiaomi.channel.commonutils.android.a.a(this.l, this.l.getPackageName());
        }

        public void a(int i) {
            this.k = i;
        }

        public void a(String str, String str2) {
            this.c = str;
            this.d = str2;
            this.f = com.xiaomi.channel.commonutils.android.d.k(this.l);
            this.e = d();
            this.i = true;
        }

        public void a(String str, String str2, String str3) {
            this.a = str;
            this.b = str2;
            this.g = str3;
            SharedPreferences.Editor edit = d.b(this.l).edit();
            edit.putString("appId", this.a);
            edit.putString("appToken", str2);
            edit.putString("regResource", str3);
            edit.commit();
        }

        public void a(boolean z) {
            this.j = z;
        }

        public boolean a() {
            return b(this.a, this.b);
        }

        public void b() {
            d.b(this.l).edit().clear().commit();
            this.a = null;
            this.b = null;
            this.c = null;
            this.d = null;
            this.f = null;
            this.e = null;
            this.i = false;
            this.j = false;
            this.h = null;
            this.k = 1;
        }

        public void b(String str, String str2, String str3) {
            this.c = str;
            this.d = str2;
            this.f = com.xiaomi.channel.commonutils.android.d.k(this.l);
            this.e = d();
            this.i = true;
            this.h = str3;
            SharedPreferences.Editor edit = d.b(this.l).edit();
            edit.putString("regId", str);
            edit.putString("regSec", str2);
            edit.putString("devId", this.f);
            edit.putString("vName", d());
            edit.putBoolean("valid", true);
            edit.putString("appRegion", str3);
            edit.commit();
        }

        public boolean b(String str, String str2) {
            return TextUtils.equals(this.a, str) && TextUtils.equals(this.b, str2) && !TextUtils.isEmpty(this.c) && !TextUtils.isEmpty(this.d) && TextUtils.equals(this.f, com.xiaomi.channel.commonutils.android.d.k(this.l));
        }

        public void c() {
            this.i = false;
            d.b(this.l).edit().putBoolean("valid", this.i).commit();
        }

        public void c(String str, String str2, String str3) {
            this.a = str;
            this.b = str2;
            this.g = str3;
        }
    }

    private d(Context context) {
        this.c = context;
        o();
    }

    public static d a(Context context) {
        if (b == null) {
            synchronized (d.class) {
                if (b == null) {
                    b = new d(context);
                }
            }
        }
        return b;
    }

    public static SharedPreferences b(Context context) {
        return context.getSharedPreferences("mipush", 0);
    }

    private void o() {
        this.d = new a(this.c);
        this.e = new HashMap();
        SharedPreferences b2 = b(this.c);
        this.d.a = b2.getString("appId", null);
        this.d.b = b2.getString("appToken", null);
        this.d.c = b2.getString("regId", null);
        this.d.d = b2.getString("regSec", null);
        this.d.f = b2.getString("devId", null);
        if (!TextUtils.isEmpty(this.d.f) && this.d.f.startsWith("a-")) {
            this.d.f = com.xiaomi.channel.commonutils.android.d.k(this.c);
            b2.edit().putString("devId", this.d.f).commit();
        }
        this.d.e = b2.getString("vName", null);
        this.d.i = b2.getBoolean("valid", true);
        this.d.j = b2.getBoolean("paused", false);
        this.d.k = b2.getInt("envType", 1);
        this.d.g = b2.getString("regResource", null);
    }

    public void a(int i) {
        this.d.a(i);
        b(this.c).edit().putInt("envType", i).commit();
    }

    public void a(String str) {
        SharedPreferences.Editor edit = b(this.c).edit();
        edit.putString("vName", str);
        edit.commit();
        this.d.e = str;
    }

    public void a(String str, a aVar) {
        this.e.put(str, aVar);
        String a2 = a.a(aVar);
        b(this.c).edit().putString("hybrid_app_info_" + str, a2).commit();
    }

    public void a(String str, String str2, String str3) {
        this.d.a(str, str2, str3);
    }

    public void a(boolean z) {
        this.d.a(z);
        b(this.c).edit().putBoolean("paused", z).commit();
    }

    public boolean a() {
        return !TextUtils.equals(com.xiaomi.channel.commonutils.android.a.a(this.c, this.c.getPackageName()), this.d.e);
    }

    public boolean a(String str, String str2) {
        return this.d.b(str, str2);
    }

    public a b(String str) {
        if (this.e.containsKey(str)) {
            return this.e.get(str);
        }
        String str2 = "hybrid_app_info_" + str;
        SharedPreferences b2 = b(this.c);
        if (b2.contains(str2)) {
            a a2 = a.a(this.c, b2.getString(str2, ""));
            this.e.put(str2, a2);
            return a2;
        }
        return null;
    }

    public void b(String str, String str2, String str3) {
        this.d.b(str, str2, str3);
    }

    public boolean b() {
        if (this.d.a()) {
            return true;
        }
        com.xiaomi.channel.commonutils.logger.b.a("Don't send message before initialization succeeded!");
        return false;
    }

    public String c() {
        return this.d.a;
    }

    public void c(String str) {
        this.e.remove(str);
        b(this.c).edit().remove("hybrid_app_info_" + str).commit();
    }

    public boolean c(String str, String str2, String str3) {
        a b2 = b(str3);
        return b2 != null && TextUtils.equals(str, b2.a) && TextUtils.equals(str2, b2.b);
    }

    public String d() {
        return this.d.b;
    }

    public String e() {
        return this.d.c;
    }

    public String f() {
        return this.d.d;
    }

    public String g() {
        return this.d.g;
    }

    public String h() {
        return this.d.h;
    }

    public void i() {
        this.d.b();
    }

    public boolean j() {
        return this.d.a();
    }

    public void k() {
        this.d.c();
    }

    public boolean l() {
        return this.d.j;
    }

    public int m() {
        return this.d.k;
    }

    public boolean n() {
        return !this.d.i;
    }
}
