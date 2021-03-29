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
    public static volatile b f40180a;

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
        public String f40182b;

        /* renamed from: c  reason: collision with root package name */
        public String f40183c;

        /* renamed from: d  reason: collision with root package name */
        public String f40184d;

        /* renamed from: e  reason: collision with root package name */
        public String f40185e;

        /* renamed from: f  reason: collision with root package name */
        public String f40186f;

        /* renamed from: g  reason: collision with root package name */
        public String f40187g;

        /* renamed from: h  reason: collision with root package name */
        public String f40188h;

        /* renamed from: a  reason: collision with other field name */
        public boolean f82a = true;

        /* renamed from: b  reason: collision with other field name */
        public boolean f83b = false;

        /* renamed from: a  reason: collision with root package name */
        public int f40181a = 1;

        public a(Context context) {
            this.f80a = context;
        }

        public static a a(Context context, String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                a aVar = new a(context);
                aVar.f81a = jSONObject.getString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
                aVar.f40182b = jSONObject.getString("appToken");
                aVar.f40183c = jSONObject.getString("regId");
                aVar.f40184d = jSONObject.getString("regSec");
                aVar.f40186f = jSONObject.getString("devId");
                aVar.f40185e = jSONObject.getString("vName");
                aVar.f82a = jSONObject.getBoolean("valid");
                aVar.f83b = jSONObject.getBoolean("paused");
                aVar.f40181a = jSONObject.getInt("envType");
                aVar.f40187g = jSONObject.getString("regResource");
                return aVar;
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.a(th);
                return null;
            }
        }

        private String a() {
            Context context = this.f80a;
            return com.xiaomi.push.g.m319a(context, context.getPackageName());
        }

        public static String a(a aVar) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, aVar.f81a);
                jSONObject.put("appToken", aVar.f40182b);
                jSONObject.put("regId", aVar.f40183c);
                jSONObject.put("regSec", aVar.f40184d);
                jSONObject.put("devId", aVar.f40186f);
                jSONObject.put("vName", aVar.f40185e);
                jSONObject.put("valid", aVar.f82a);
                jSONObject.put("paused", aVar.f83b);
                jSONObject.put("envType", aVar.f40181a);
                jSONObject.put("regResource", aVar.f40187g);
                return jSONObject.toString();
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.a(th);
                return null;
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m105a() {
            b.a(this.f80a).edit().clear().commit();
            this.f81a = null;
            this.f40182b = null;
            this.f40183c = null;
            this.f40184d = null;
            this.f40186f = null;
            this.f40185e = null;
            this.f82a = false;
            this.f83b = false;
            this.f40188h = null;
            this.f40181a = 1;
        }

        public void a(int i) {
            this.f40181a = i;
        }

        public void a(String str, String str2) {
            this.f40183c = str;
            this.f40184d = str2;
            this.f40186f = com.xiaomi.push.i.l(this.f80a);
            this.f40185e = a();
            this.f82a = true;
        }

        public void a(String str, String str2, String str3) {
            this.f81a = str;
            this.f40182b = str2;
            this.f40187g = str3;
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
        public boolean m106a() {
            return m107a(this.f81a, this.f40182b);
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m107a(String str, String str2) {
            boolean equals = TextUtils.equals(this.f81a, str);
            boolean equals2 = TextUtils.equals(this.f40182b, str2);
            boolean z = !TextUtils.isEmpty(this.f40183c);
            boolean z2 = !TextUtils.isEmpty(this.f40184d);
            boolean z3 = TextUtils.equals(this.f40186f, com.xiaomi.push.i.l(this.f80a)) || TextUtils.equals(this.f40186f, com.xiaomi.push.i.k(this.f80a));
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
            this.f40183c = str;
            this.f40184d = str2;
            this.f40186f = com.xiaomi.push.i.l(this.f80a);
            this.f40185e = a();
            this.f82a = true;
            this.f40188h = str3;
            SharedPreferences.Editor edit = b.a(this.f80a).edit();
            edit.putString("regId", str);
            edit.putString("regSec", str2);
            edit.putString("devId", this.f40186f);
            edit.putString("vName", a());
            edit.putBoolean("valid", true);
            edit.putString("appRegion", str3);
            edit.commit();
        }

        public void c(String str, String str2, String str3) {
            this.f81a = str;
            this.f40182b = str2;
            this.f40187g = str3;
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
    public static b m92a(Context context) {
        if (f40180a == null) {
            synchronized (b.class) {
                if (f40180a == null) {
                    f40180a = new b(context);
                }
            }
        }
        return f40180a;
    }

    private void c() {
        this.f77a = new a(this.f76a);
        this.f79a = new HashMap();
        SharedPreferences a2 = a(this.f76a);
        this.f77a.f81a = a2.getString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, null);
        this.f77a.f40182b = a2.getString("appToken", null);
        this.f77a.f40183c = a2.getString("regId", null);
        this.f77a.f40184d = a2.getString("regSec", null);
        this.f77a.f40186f = a2.getString("devId", null);
        if (!TextUtils.isEmpty(this.f77a.f40186f) && com.xiaomi.push.i.m419a(this.f77a.f40186f)) {
            this.f77a.f40186f = com.xiaomi.push.i.l(this.f76a);
            a2.edit().putString("devId", this.f77a.f40186f).commit();
        }
        this.f77a.f40185e = a2.getString("vName", null);
        this.f77a.f82a = a2.getBoolean("valid", true);
        this.f77a.f83b = a2.getBoolean("paused", false);
        this.f77a.f40181a = a2.getInt("envType", 1);
        this.f77a.f40187g = a2.getString("regResource", null);
        this.f77a.f40188h = a2.getString("appRegion", null);
    }

    public int a() {
        return this.f77a.f40181a;
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
    public String m93a() {
        return this.f77a.f81a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m94a() {
        this.f77a.m105a();
    }

    public void a(int i) {
        this.f77a.a(i);
        a(this.f76a).edit().putInt("envType", i).commit();
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m95a(String str) {
        SharedPreferences.Editor edit = a(this.f76a).edit();
        edit.putString("vName", str);
        edit.commit();
        this.f77a.f40185e = str;
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
    public boolean m96a() {
        Context context = this.f76a;
        return !TextUtils.equals(com.xiaomi.push.g.m319a(context, context.getPackageName()), this.f77a.f40185e);
    }

    public boolean a(String str, String str2) {
        return this.f77a.m107a(str, str2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m97a(String str, String str2, String str3) {
        a a2 = a(str3);
        return a2 != null && TextUtils.equals(str, a2.f81a) && TextUtils.equals(str2, a2.f40182b);
    }

    public String b() {
        return this.f77a.f40182b;
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m98b() {
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
    public boolean m99b() {
        if (this.f77a.m106a()) {
            return true;
        }
        com.xiaomi.channel.commonutils.logger.b.m51a("Don't send message before initialization succeeded!");
        return false;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m100c() {
        return this.f77a.f40183c;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m101c() {
        return this.f77a.m106a();
    }

    public String d() {
        return this.f77a.f40184d;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m102d() {
        return (TextUtils.isEmpty(this.f77a.f81a) || TextUtils.isEmpty(this.f77a.f40182b) || TextUtils.isEmpty(this.f77a.f40183c) || TextUtils.isEmpty(this.f77a.f40184d)) ? false : true;
    }

    public String e() {
        return this.f77a.f40187g;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m103e() {
        return this.f77a.f83b;
    }

    public String f() {
        return this.f77a.f40188h;
    }

    /* renamed from: f  reason: collision with other method in class */
    public boolean m104f() {
        return !this.f77a.f82a;
    }
}
