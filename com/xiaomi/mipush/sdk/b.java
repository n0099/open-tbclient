package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.sapi2.activity.BaseActivity;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b {
    public static volatile b a;

    /* renamed from: a  reason: collision with other field name */
    public Context f71a;

    /* renamed from: a  reason: collision with other field name */
    public a f72a;

    /* renamed from: a  reason: collision with other field name */
    public String f73a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, a> f74a;

    /* loaded from: classes10.dex */
    public static class a {

        /* renamed from: a  reason: collision with other field name */
        public Context f75a;

        /* renamed from: a  reason: collision with other field name */
        public String f76a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;

        /* renamed from: a  reason: collision with other field name */
        public boolean f77a = true;

        /* renamed from: b  reason: collision with other field name */
        public boolean f78b = false;
        public int a = 1;

        public a(Context context) {
            this.f75a = context;
        }

        public static a a(Context context, String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                a aVar = new a(context);
                aVar.f76a = jSONObject.getString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
                aVar.b = jSONObject.getString("appToken");
                aVar.c = jSONObject.getString("regId");
                aVar.d = jSONObject.getString("regSec");
                aVar.f = jSONObject.getString("devId");
                aVar.e = jSONObject.getString("vName");
                aVar.f77a = jSONObject.getBoolean("valid");
                aVar.f78b = jSONObject.getBoolean("paused");
                aVar.a = jSONObject.getInt("envType");
                aVar.g = jSONObject.getString("regResource");
                return aVar;
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.a(th);
                return null;
            }
        }

        private String a() {
            Context context = this.f75a;
            return com.xiaomi.push.g.m515a(context, context.getPackageName());
        }

        public static String a(a aVar) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, aVar.f76a);
                jSONObject.put("appToken", aVar.b);
                jSONObject.put("regId", aVar.c);
                jSONObject.put("regSec", aVar.d);
                jSONObject.put("devId", aVar.f);
                jSONObject.put("vName", aVar.e);
                jSONObject.put("valid", aVar.f77a);
                jSONObject.put("paused", aVar.f78b);
                jSONObject.put("envType", aVar.a);
                jSONObject.put("regResource", aVar.g);
                return jSONObject.toString();
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.a(th);
                return null;
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m237a() {
            b.a(this.f75a).edit().clear().commit();
            this.f76a = null;
            this.b = null;
            this.c = null;
            this.d = null;
            this.f = null;
            this.e = null;
            this.f77a = false;
            this.f78b = false;
            this.h = null;
            this.a = 1;
        }

        public void a(int i) {
            this.a = i;
        }

        public void a(String str, String str2) {
            this.c = str;
            this.d = str2;
            this.f = com.xiaomi.push.i.h(this.f75a);
            this.e = a();
            this.f77a = true;
        }

        public void a(String str, String str2, String str3) {
            this.f76a = str;
            this.b = str2;
            this.g = str3;
            SharedPreferences.Editor edit = b.a(this.f75a).edit();
            edit.putString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f76a);
            edit.putString("appToken", str2);
            edit.putString("regResource", str3);
            edit.commit();
        }

        public void a(boolean z) {
            this.f78b = z;
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m238a() {
            return m239a(this.f76a, this.b);
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m239a(String str, String str2) {
            boolean equals = TextUtils.equals(this.f76a, str);
            boolean equals2 = TextUtils.equals(this.b, str2);
            boolean z = !TextUtils.isEmpty(this.c);
            boolean z2 = !TextUtils.isEmpty(this.d);
            boolean z3 = TextUtils.equals(this.f, com.xiaomi.push.i.h(this.f75a)) || TextUtils.equals(this.f, com.xiaomi.push.i.g(this.f75a));
            boolean z4 = equals && equals2 && z && z2 && z3;
            if (!z4) {
                com.xiaomi.channel.commonutils.logger.b.e(String.format("register invalid, aid=%s;atn=%s;rid=%s;rse=%s;did=%s", Boolean.valueOf(equals), Boolean.valueOf(equals2), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)));
            }
            return z4;
        }

        public void b() {
            this.f77a = false;
            b.a(this.f75a).edit().putBoolean("valid", this.f77a).commit();
        }

        public void b(String str, String str2, String str3) {
            this.c = str;
            this.d = str2;
            this.f = com.xiaomi.push.i.h(this.f75a);
            this.e = a();
            this.f77a = true;
            this.h = str3;
            SharedPreferences.Editor edit = b.a(this.f75a).edit();
            edit.putString("regId", str);
            edit.putString("regSec", str2);
            edit.putString("devId", this.f);
            edit.putString("vName", a());
            edit.putBoolean("valid", true);
            edit.putString("appRegion", str3);
            edit.commit();
        }

        public void c(String str, String str2, String str3) {
            this.f76a = str;
            this.b = str2;
            this.g = str3;
        }
    }

    public b(Context context) {
        this.f71a = context;
        c();
    }

    public static SharedPreferences a(Context context) {
        return context.getSharedPreferences("mipush", 0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static b m224a(Context context) {
        if (a == null) {
            synchronized (b.class) {
                if (a == null) {
                    a = new b(context);
                }
            }
        }
        return a;
    }

    private void c() {
        this.f72a = new a(this.f71a);
        this.f74a = new HashMap();
        SharedPreferences a2 = a(this.f71a);
        this.f72a.f76a = a2.getString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, null);
        this.f72a.b = a2.getString("appToken", null);
        this.f72a.c = a2.getString("regId", null);
        this.f72a.d = a2.getString("regSec", null);
        this.f72a.f = a2.getString("devId", null);
        if (!TextUtils.isEmpty(this.f72a.f) && com.xiaomi.push.i.a(this.f72a.f)) {
            this.f72a.f = com.xiaomi.push.i.h(this.f71a);
            a2.edit().putString("devId", this.f72a.f).commit();
        }
        this.f72a.e = a2.getString("vName", null);
        this.f72a.f77a = a2.getBoolean("valid", true);
        this.f72a.f78b = a2.getBoolean("paused", false);
        this.f72a.a = a2.getInt("envType", 1);
        this.f72a.g = a2.getString("regResource", null);
        this.f72a.h = a2.getString("appRegion", null);
    }

    public int a() {
        return this.f72a.a;
    }

    public a a(String str) {
        if (this.f74a.containsKey(str)) {
            return this.f74a.get(str);
        }
        String str2 = "hybrid_app_info_" + str;
        SharedPreferences a2 = a(this.f71a);
        if (a2.contains(str2)) {
            a a3 = a.a(this.f71a, a2.getString(str2, ""));
            this.f74a.put(str2, a3);
            return a3;
        }
        return null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m225a() {
        return this.f72a.f76a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m226a() {
        this.f72a.m237a();
    }

    public void a(int i) {
        this.f72a.a(i);
        a(this.f71a).edit().putInt("envType", i).commit();
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m227a(String str) {
        SharedPreferences.Editor edit = a(this.f71a).edit();
        edit.putString("vName", str);
        edit.commit();
        this.f72a.e = str;
    }

    public void a(String str, a aVar) {
        this.f74a.put(str, aVar);
        String a2 = a.a(aVar);
        a(this.f71a).edit().putString("hybrid_app_info_" + str, a2).commit();
    }

    public void a(String str, String str2, String str3) {
        this.f72a.a(str, str2, str3);
    }

    public void a(boolean z) {
        this.f72a.a(z);
        a(this.f71a).edit().putBoolean("paused", z).commit();
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m228a() {
        Context context = this.f71a;
        return !TextUtils.equals(com.xiaomi.push.g.m515a(context, context.getPackageName()), this.f72a.e);
    }

    public boolean a(String str, String str2) {
        return this.f72a.m239a(str, str2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m229a(String str, String str2, String str3) {
        a a2 = a(str3);
        return a2 != null && TextUtils.equals(str, a2.f76a) && TextUtils.equals(str2, a2.b);
    }

    public String b() {
        return this.f72a.b;
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m230b() {
        this.f72a.b();
    }

    public void b(String str) {
        this.f74a.remove(str);
        a(this.f71a).edit().remove("hybrid_app_info_" + str).commit();
    }

    public void b(String str, String str2, String str3) {
        this.f72a.b(str, str2, str3);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m231b() {
        if (this.f72a.m238a()) {
            return true;
        }
        com.xiaomi.channel.commonutils.logger.b.m180a("Don't send message before initialization succeeded!");
        return false;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m232c() {
        return this.f72a.c;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m233c() {
        return this.f72a.m238a();
    }

    public String d() {
        return this.f72a.d;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m234d() {
        return (TextUtils.isEmpty(this.f72a.f76a) || TextUtils.isEmpty(this.f72a.b) || TextUtils.isEmpty(this.f72a.c) || TextUtils.isEmpty(this.f72a.d)) ? false : true;
    }

    public String e() {
        return this.f72a.g;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m235e() {
        return this.f72a.f78b;
    }

    public String f() {
        return this.f72a.h;
    }

    /* renamed from: f  reason: collision with other method in class */
    public boolean m236f() {
        return !this.f72a.f77a;
    }
}
