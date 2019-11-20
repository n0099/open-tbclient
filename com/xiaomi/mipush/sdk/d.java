package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {
    private static volatile d a;

    /* renamed from: a  reason: collision with other field name */
    private Context f58a;

    /* renamed from: a  reason: collision with other field name */
    private a f59a;

    /* renamed from: a  reason: collision with other field name */
    String f60a;

    /* renamed from: a  reason: collision with other field name */
    private Map<String, a> f61a;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with other field name */
        private Context f62a;

        /* renamed from: a  reason: collision with other field name */
        public String f63a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;

        /* renamed from: a  reason: collision with other field name */
        public boolean f64a = true;

        /* renamed from: b  reason: collision with other field name */
        public boolean f65b = false;
        public int a = 1;

        public a(Context context) {
            this.f62a = context;
        }

        public static a a(Context context, String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                a aVar = new a(context);
                aVar.f63a = jSONObject.getString("appId");
                aVar.b = jSONObject.getString("appToken");
                aVar.c = jSONObject.getString("regId");
                aVar.d = jSONObject.getString("regSec");
                aVar.f = jSONObject.getString("devId");
                aVar.e = jSONObject.getString("vName");
                aVar.f64a = jSONObject.getBoolean("valid");
                aVar.f65b = jSONObject.getBoolean("paused");
                aVar.a = jSONObject.getInt("envType");
                aVar.g = jSONObject.getString("regResource");
                return aVar;
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.a(th);
                return null;
            }
        }

        private String a() {
            return com.xiaomi.push.g.m279a(this.f62a, this.f62a.getPackageName());
        }

        public static String a(a aVar) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("appId", aVar.f63a);
                jSONObject.put("appToken", aVar.b);
                jSONObject.put("regId", aVar.c);
                jSONObject.put("regSec", aVar.d);
                jSONObject.put("devId", aVar.f);
                jSONObject.put("vName", aVar.e);
                jSONObject.put("valid", aVar.f64a);
                jSONObject.put("paused", aVar.f65b);
                jSONObject.put("envType", aVar.a);
                jSONObject.put("regResource", aVar.g);
                return jSONObject.toString();
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.a(th);
                return null;
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m80a() {
            d.a(this.f62a).edit().clear().commit();
            this.f63a = null;
            this.b = null;
            this.c = null;
            this.d = null;
            this.f = null;
            this.e = null;
            this.f64a = false;
            this.f65b = false;
            this.h = null;
            this.a = 1;
        }

        public void a(int i) {
            this.a = i;
        }

        public void a(String str, String str2) {
            this.c = str;
            this.d = str2;
            this.f = com.xiaomi.push.i.l(this.f62a);
            this.e = a();
            this.f64a = true;
        }

        public void a(String str, String str2, String str3) {
            this.f63a = str;
            this.b = str2;
            this.g = str3;
            SharedPreferences.Editor edit = d.a(this.f62a).edit();
            edit.putString("appId", this.f63a);
            edit.putString("appToken", str2);
            edit.putString("regResource", str3);
            edit.commit();
        }

        public void a(boolean z) {
            this.f65b = z;
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m81a() {
            return m82a(this.f63a, this.b);
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m82a(String str, String str2) {
            return TextUtils.equals(this.f63a, str) && TextUtils.equals(this.b, str2) && !TextUtils.isEmpty(this.c) && !TextUtils.isEmpty(this.d) && (TextUtils.equals(this.f, com.xiaomi.push.i.l(this.f62a)) || TextUtils.equals(this.f, com.xiaomi.push.i.k(this.f62a)));
        }

        public void b() {
            this.f64a = false;
            d.a(this.f62a).edit().putBoolean("valid", this.f64a).commit();
        }

        public void b(String str, String str2, String str3) {
            this.c = str;
            this.d = str2;
            this.f = com.xiaomi.push.i.l(this.f62a);
            this.e = a();
            this.f64a = true;
            this.h = str3;
            SharedPreferences.Editor edit = d.a(this.f62a).edit();
            edit.putString("regId", str);
            edit.putString("regSec", str2);
            edit.putString("devId", this.f);
            edit.putString("vName", a());
            edit.putBoolean("valid", true);
            edit.putString("appRegion", str3);
            edit.commit();
        }

        public void c(String str, String str2, String str3) {
            this.f63a = str;
            this.b = str2;
            this.g = str3;
        }
    }

    private d(Context context) {
        this.f58a = context;
        c();
    }

    public static SharedPreferences a(Context context) {
        return context.getSharedPreferences("mipush", 0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static d m68a(Context context) {
        if (a == null) {
            synchronized (d.class) {
                if (a == null) {
                    a = new d(context);
                }
            }
        }
        return a;
    }

    private void c() {
        this.f59a = new a(this.f58a);
        this.f61a = new HashMap();
        SharedPreferences a2 = a(this.f58a);
        this.f59a.f63a = a2.getString("appId", null);
        this.f59a.b = a2.getString("appToken", null);
        this.f59a.c = a2.getString("regId", null);
        this.f59a.d = a2.getString("regSec", null);
        this.f59a.f = a2.getString("devId", null);
        if (!TextUtils.isEmpty(this.f59a.f) && this.f59a.f.startsWith("a-")) {
            this.f59a.f = com.xiaomi.push.i.l(this.f58a);
            a2.edit().putString("devId", this.f59a.f).commit();
        }
        this.f59a.e = a2.getString("vName", null);
        this.f59a.f64a = a2.getBoolean("valid", true);
        this.f59a.f65b = a2.getBoolean("paused", false);
        this.f59a.a = a2.getInt("envType", 1);
        this.f59a.g = a2.getString("regResource", null);
        this.f59a.h = a2.getString("appRegion", null);
    }

    public int a() {
        return this.f59a.a;
    }

    public a a(String str) {
        if (this.f61a.containsKey(str)) {
            return this.f61a.get(str);
        }
        String str2 = "hybrid_app_info_" + str;
        SharedPreferences a2 = a(this.f58a);
        if (a2.contains(str2)) {
            a a3 = a.a(this.f58a, a2.getString(str2, ""));
            this.f61a.put(str2, a3);
            return a3;
        }
        return null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m69a() {
        return this.f59a.f63a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m70a() {
        this.f59a.m80a();
    }

    public void a(int i) {
        this.f59a.a(i);
        a(this.f58a).edit().putInt("envType", i).commit();
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m71a(String str) {
        SharedPreferences.Editor edit = a(this.f58a).edit();
        edit.putString("vName", str);
        edit.commit();
        this.f59a.e = str;
    }

    public void a(String str, a aVar) {
        this.f61a.put(str, aVar);
        String a2 = a.a(aVar);
        a(this.f58a).edit().putString("hybrid_app_info_" + str, a2).commit();
    }

    public void a(String str, String str2, String str3) {
        this.f59a.a(str, str2, str3);
    }

    public void a(boolean z) {
        this.f59a.a(z);
        a(this.f58a).edit().putBoolean("paused", z).commit();
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m72a() {
        return !TextUtils.equals(com.xiaomi.push.g.m279a(this.f58a, this.f58a.getPackageName()), this.f59a.e);
    }

    public boolean a(String str, String str2) {
        return this.f59a.m82a(str, str2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m73a(String str, String str2, String str3) {
        a a2 = a(str3);
        return a2 != null && TextUtils.equals(str, a2.f63a) && TextUtils.equals(str2, a2.b);
    }

    public String b() {
        return this.f59a.b;
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m74b() {
        this.f59a.b();
    }

    public void b(String str) {
        this.f61a.remove(str);
        a(this.f58a).edit().remove("hybrid_app_info_" + str).commit();
    }

    public void b(String str, String str2, String str3) {
        this.f59a.b(str, str2, str3);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m75b() {
        if (this.f59a.m81a()) {
            return true;
        }
        com.xiaomi.channel.commonutils.logger.b.m30a("Don't send message before initialization succeeded!");
        return false;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m76c() {
        return this.f59a.c;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m77c() {
        return this.f59a.m81a();
    }

    public String d() {
        return this.f59a.d;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m78d() {
        return this.f59a.f65b;
    }

    public String e() {
        return this.f59a.g;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m79e() {
        return !this.f59a.f64a;
    }

    public String f() {
        return this.f59a.h;
    }
}
