package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.sapi2.activity.BaseActivity;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f37253a;

    /* renamed from: a  reason: collision with other field name */
    public Context f76a;

    /* renamed from: a  reason: collision with other field name */
    public a f77a;

    /* renamed from: a  reason: collision with other field name */
    public String f78a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, a> f79a;

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with other field name */
        public Context f80a;

        /* renamed from: a  reason: collision with other field name */
        public String f81a;

        /* renamed from: b  reason: collision with root package name */
        public String f37255b;

        /* renamed from: c  reason: collision with root package name */
        public String f37256c;

        /* renamed from: d  reason: collision with root package name */
        public String f37257d;

        /* renamed from: e  reason: collision with root package name */
        public String f37258e;

        /* renamed from: f  reason: collision with root package name */
        public String f37259f;

        /* renamed from: g  reason: collision with root package name */
        public String f37260g;

        /* renamed from: h  reason: collision with root package name */
        public String f37261h;

        /* renamed from: a  reason: collision with other field name */
        public boolean f82a = true;

        /* renamed from: b  reason: collision with other field name */
        public boolean f83b = false;

        /* renamed from: a  reason: collision with root package name */
        public int f37254a = 1;

        public a(Context context) {
            this.f80a = context;
        }

        public static a a(Context context, String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                a aVar = new a(context);
                aVar.f81a = jSONObject.getString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
                aVar.f37255b = jSONObject.getString("appToken");
                aVar.f37256c = jSONObject.getString("regId");
                aVar.f37257d = jSONObject.getString("regSec");
                aVar.f37259f = jSONObject.getString("devId");
                aVar.f37258e = jSONObject.getString("vName");
                aVar.f82a = jSONObject.getBoolean("valid");
                aVar.f83b = jSONObject.getBoolean("paused");
                aVar.f37254a = jSONObject.getInt("envType");
                aVar.f37260g = jSONObject.getString("regResource");
                return aVar;
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.a(th);
                return null;
            }
        }

        private String a() {
            Context context = this.f80a;
            return com.xiaomi.push.g.m325a(context, context.getPackageName());
        }

        public static String a(a aVar) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, aVar.f81a);
                jSONObject.put("appToken", aVar.f37255b);
                jSONObject.put("regId", aVar.f37256c);
                jSONObject.put("regSec", aVar.f37257d);
                jSONObject.put("devId", aVar.f37259f);
                jSONObject.put("vName", aVar.f37258e);
                jSONObject.put("valid", aVar.f82a);
                jSONObject.put("paused", aVar.f83b);
                jSONObject.put("envType", aVar.f37254a);
                jSONObject.put("regResource", aVar.f37260g);
                return jSONObject.toString();
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.a(th);
                return null;
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m111a() {
            b.a(this.f80a).edit().clear().commit();
            this.f81a = null;
            this.f37255b = null;
            this.f37256c = null;
            this.f37257d = null;
            this.f37259f = null;
            this.f37258e = null;
            this.f82a = false;
            this.f83b = false;
            this.f37261h = null;
            this.f37254a = 1;
        }

        public void a(int i2) {
            this.f37254a = i2;
        }

        public void a(String str, String str2) {
            this.f37256c = str;
            this.f37257d = str2;
            this.f37259f = com.xiaomi.push.i.l(this.f80a);
            this.f37258e = a();
            this.f82a = true;
        }

        public void a(String str, String str2, String str3) {
            this.f81a = str;
            this.f37255b = str2;
            this.f37260g = str3;
            SharedPreferences.Editor edit = b.a(this.f80a).edit();
            edit.putString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f81a);
            edit.putString("appToken", str2);
            edit.putString("regResource", str3);
            edit.commit();
        }

        public void a(boolean z) {
            this.f83b = z;
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m112a() {
            return m113a(this.f81a, this.f37255b);
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m113a(String str, String str2) {
            boolean equals = TextUtils.equals(this.f81a, str);
            boolean equals2 = TextUtils.equals(this.f37255b, str2);
            boolean z = !TextUtils.isEmpty(this.f37256c);
            boolean z2 = !TextUtils.isEmpty(this.f37257d);
            boolean z3 = TextUtils.equals(this.f37259f, com.xiaomi.push.i.l(this.f80a)) || TextUtils.equals(this.f37259f, com.xiaomi.push.i.k(this.f80a));
            boolean z4 = equals && equals2 && z && z2 && z3;
            if (!z4) {
                com.xiaomi.channel.commonutils.logger.b.e(String.format("register invalid, aid=%s;atn=%s;rid=%s;rse=%s;did=%s", Boolean.valueOf(equals), Boolean.valueOf(equals2), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)));
            }
            return z4;
        }

        public void b() {
            this.f82a = false;
            b.a(this.f80a).edit().putBoolean("valid", this.f82a).commit();
        }

        public void b(String str, String str2, String str3) {
            this.f37256c = str;
            this.f37257d = str2;
            this.f37259f = com.xiaomi.push.i.l(this.f80a);
            this.f37258e = a();
            this.f82a = true;
            this.f37261h = str3;
            SharedPreferences.Editor edit = b.a(this.f80a).edit();
            edit.putString("regId", str);
            edit.putString("regSec", str2);
            edit.putString("devId", this.f37259f);
            edit.putString("vName", a());
            edit.putBoolean("valid", true);
            edit.putString("appRegion", str3);
            edit.commit();
        }

        public void c(String str, String str2, String str3) {
            this.f81a = str;
            this.f37255b = str2;
            this.f37260g = str3;
        }
    }

    public b(Context context) {
        this.f76a = context;
        c();
    }

    public static SharedPreferences a(Context context) {
        return context.getSharedPreferences("mipush", 0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static b m98a(Context context) {
        if (f37253a == null) {
            synchronized (b.class) {
                if (f37253a == null) {
                    f37253a = new b(context);
                }
            }
        }
        return f37253a;
    }

    private void c() {
        this.f77a = new a(this.f76a);
        this.f79a = new HashMap();
        SharedPreferences a2 = a(this.f76a);
        this.f77a.f81a = a2.getString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, null);
        this.f77a.f37255b = a2.getString("appToken", null);
        this.f77a.f37256c = a2.getString("regId", null);
        this.f77a.f37257d = a2.getString("regSec", null);
        this.f77a.f37259f = a2.getString("devId", null);
        if (!TextUtils.isEmpty(this.f77a.f37259f) && com.xiaomi.push.i.m425a(this.f77a.f37259f)) {
            this.f77a.f37259f = com.xiaomi.push.i.l(this.f76a);
            a2.edit().putString("devId", this.f77a.f37259f).commit();
        }
        this.f77a.f37258e = a2.getString("vName", null);
        this.f77a.f82a = a2.getBoolean("valid", true);
        this.f77a.f83b = a2.getBoolean("paused", false);
        this.f77a.f37254a = a2.getInt("envType", 1);
        this.f77a.f37260g = a2.getString("regResource", null);
        this.f77a.f37261h = a2.getString("appRegion", null);
    }

    public int a() {
        return this.f77a.f37254a;
    }

    public a a(String str) {
        if (this.f79a.containsKey(str)) {
            return this.f79a.get(str);
        }
        String str2 = "hybrid_app_info_" + str;
        SharedPreferences a2 = a(this.f76a);
        if (a2.contains(str2)) {
            a a3 = a.a(this.f76a, a2.getString(str2, ""));
            this.f79a.put(str2, a3);
            return a3;
        }
        return null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m99a() {
        return this.f77a.f81a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m100a() {
        this.f77a.m111a();
    }

    public void a(int i2) {
        this.f77a.a(i2);
        a(this.f76a).edit().putInt("envType", i2).commit();
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m101a(String str) {
        SharedPreferences.Editor edit = a(this.f76a).edit();
        edit.putString("vName", str);
        edit.commit();
        this.f77a.f37258e = str;
    }

    public void a(String str, a aVar) {
        this.f79a.put(str, aVar);
        String a2 = a.a(aVar);
        a(this.f76a).edit().putString("hybrid_app_info_" + str, a2).commit();
    }

    public void a(String str, String str2, String str3) {
        this.f77a.a(str, str2, str3);
    }

    public void a(boolean z) {
        this.f77a.a(z);
        a(this.f76a).edit().putBoolean("paused", z).commit();
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m102a() {
        Context context = this.f76a;
        return !TextUtils.equals(com.xiaomi.push.g.m325a(context, context.getPackageName()), this.f77a.f37258e);
    }

    public boolean a(String str, String str2) {
        return this.f77a.m113a(str, str2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m103a(String str, String str2, String str3) {
        a a2 = a(str3);
        return a2 != null && TextUtils.equals(str, a2.f81a) && TextUtils.equals(str2, a2.f37255b);
    }

    public String b() {
        return this.f77a.f37255b;
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m104b() {
        this.f77a.b();
    }

    public void b(String str) {
        this.f79a.remove(str);
        a(this.f76a).edit().remove("hybrid_app_info_" + str).commit();
    }

    public void b(String str, String str2, String str3) {
        this.f77a.b(str, str2, str3);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m105b() {
        if (this.f77a.m112a()) {
            return true;
        }
        com.xiaomi.channel.commonutils.logger.b.m57a("Don't send message before initialization succeeded!");
        return false;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m106c() {
        return this.f77a.f37256c;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m107c() {
        return this.f77a.m112a();
    }

    public String d() {
        return this.f77a.f37257d;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m108d() {
        return (TextUtils.isEmpty(this.f77a.f81a) || TextUtils.isEmpty(this.f77a.f37255b) || TextUtils.isEmpty(this.f77a.f37256c) || TextUtils.isEmpty(this.f77a.f37257d)) ? false : true;
    }

    public String e() {
        return this.f77a.f37260g;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m109e() {
        return this.f77a.f83b;
    }

    public String f() {
        return this.f77a.f37261h;
    }

    /* renamed from: f  reason: collision with other method in class */
    public boolean m110f() {
        return !this.f77a.f82a;
    }
}
