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
    public static volatile b f40932a;

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
        public String f40934b;

        /* renamed from: c  reason: collision with root package name */
        public String f40935c;

        /* renamed from: d  reason: collision with root package name */
        public String f40936d;

        /* renamed from: e  reason: collision with root package name */
        public String f40937e;

        /* renamed from: f  reason: collision with root package name */
        public String f40938f;

        /* renamed from: g  reason: collision with root package name */
        public String f40939g;

        /* renamed from: h  reason: collision with root package name */
        public String f40940h;

        /* renamed from: a  reason: collision with other field name */
        public boolean f82a = true;

        /* renamed from: b  reason: collision with other field name */
        public boolean f83b = false;

        /* renamed from: a  reason: collision with root package name */
        public int f40933a = 1;

        public a(Context context) {
            this.f80a = context;
        }

        public static a a(Context context, String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                a aVar = new a(context);
                aVar.f81a = jSONObject.getString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
                aVar.f40934b = jSONObject.getString("appToken");
                aVar.f40935c = jSONObject.getString("regId");
                aVar.f40936d = jSONObject.getString("regSec");
                aVar.f40938f = jSONObject.getString("devId");
                aVar.f40937e = jSONObject.getString("vName");
                aVar.f82a = jSONObject.getBoolean("valid");
                aVar.f83b = jSONObject.getBoolean("paused");
                aVar.f40933a = jSONObject.getInt("envType");
                aVar.f40939g = jSONObject.getString("regResource");
                return aVar;
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.a(th);
                return null;
            }
        }

        private String a() {
            Context context = this.f80a;
            return com.xiaomi.push.g.m324a(context, context.getPackageName());
        }

        public static String a(a aVar) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, aVar.f81a);
                jSONObject.put("appToken", aVar.f40934b);
                jSONObject.put("regId", aVar.f40935c);
                jSONObject.put("regSec", aVar.f40936d);
                jSONObject.put("devId", aVar.f40938f);
                jSONObject.put("vName", aVar.f40937e);
                jSONObject.put("valid", aVar.f82a);
                jSONObject.put("paused", aVar.f83b);
                jSONObject.put("envType", aVar.f40933a);
                jSONObject.put("regResource", aVar.f40939g);
                return jSONObject.toString();
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.a(th);
                return null;
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m110a() {
            b.a(this.f80a).edit().clear().commit();
            this.f81a = null;
            this.f40934b = null;
            this.f40935c = null;
            this.f40936d = null;
            this.f40938f = null;
            this.f40937e = null;
            this.f82a = false;
            this.f83b = false;
            this.f40940h = null;
            this.f40933a = 1;
        }

        public void a(int i2) {
            this.f40933a = i2;
        }

        public void a(String str, String str2) {
            this.f40935c = str;
            this.f40936d = str2;
            this.f40938f = com.xiaomi.push.i.l(this.f80a);
            this.f40937e = a();
            this.f82a = true;
        }

        public void a(String str, String str2, String str3) {
            this.f81a = str;
            this.f40934b = str2;
            this.f40939g = str3;
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
        public boolean m111a() {
            return m112a(this.f81a, this.f40934b);
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m112a(String str, String str2) {
            boolean equals = TextUtils.equals(this.f81a, str);
            boolean equals2 = TextUtils.equals(this.f40934b, str2);
            boolean z = !TextUtils.isEmpty(this.f40935c);
            boolean z2 = !TextUtils.isEmpty(this.f40936d);
            boolean z3 = TextUtils.equals(this.f40938f, com.xiaomi.push.i.l(this.f80a)) || TextUtils.equals(this.f40938f, com.xiaomi.push.i.k(this.f80a));
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
            this.f40935c = str;
            this.f40936d = str2;
            this.f40938f = com.xiaomi.push.i.l(this.f80a);
            this.f40937e = a();
            this.f82a = true;
            this.f40940h = str3;
            SharedPreferences.Editor edit = b.a(this.f80a).edit();
            edit.putString("regId", str);
            edit.putString("regSec", str2);
            edit.putString("devId", this.f40938f);
            edit.putString("vName", a());
            edit.putBoolean("valid", true);
            edit.putString("appRegion", str3);
            edit.commit();
        }

        public void c(String str, String str2, String str3) {
            this.f81a = str;
            this.f40934b = str2;
            this.f40939g = str3;
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
    public static b m97a(Context context) {
        if (f40932a == null) {
            synchronized (b.class) {
                if (f40932a == null) {
                    f40932a = new b(context);
                }
            }
        }
        return f40932a;
    }

    private void c() {
        this.f77a = new a(this.f76a);
        this.f79a = new HashMap();
        SharedPreferences a2 = a(this.f76a);
        this.f77a.f81a = a2.getString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, null);
        this.f77a.f40934b = a2.getString("appToken", null);
        this.f77a.f40935c = a2.getString("regId", null);
        this.f77a.f40936d = a2.getString("regSec", null);
        this.f77a.f40938f = a2.getString("devId", null);
        if (!TextUtils.isEmpty(this.f77a.f40938f) && com.xiaomi.push.i.m424a(this.f77a.f40938f)) {
            this.f77a.f40938f = com.xiaomi.push.i.l(this.f76a);
            a2.edit().putString("devId", this.f77a.f40938f).commit();
        }
        this.f77a.f40937e = a2.getString("vName", null);
        this.f77a.f82a = a2.getBoolean("valid", true);
        this.f77a.f83b = a2.getBoolean("paused", false);
        this.f77a.f40933a = a2.getInt("envType", 1);
        this.f77a.f40939g = a2.getString("regResource", null);
        this.f77a.f40940h = a2.getString("appRegion", null);
    }

    public int a() {
        return this.f77a.f40933a;
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
    public String m98a() {
        return this.f77a.f81a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m99a() {
        this.f77a.m110a();
    }

    public void a(int i2) {
        this.f77a.a(i2);
        a(this.f76a).edit().putInt("envType", i2).commit();
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m100a(String str) {
        SharedPreferences.Editor edit = a(this.f76a).edit();
        edit.putString("vName", str);
        edit.commit();
        this.f77a.f40937e = str;
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
    public boolean m101a() {
        Context context = this.f76a;
        return !TextUtils.equals(com.xiaomi.push.g.m324a(context, context.getPackageName()), this.f77a.f40937e);
    }

    public boolean a(String str, String str2) {
        return this.f77a.m112a(str, str2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m102a(String str, String str2, String str3) {
        a a2 = a(str3);
        return a2 != null && TextUtils.equals(str, a2.f81a) && TextUtils.equals(str2, a2.f40934b);
    }

    public String b() {
        return this.f77a.f40934b;
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m103b() {
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
    public boolean m104b() {
        if (this.f77a.m111a()) {
            return true;
        }
        com.xiaomi.channel.commonutils.logger.b.m56a("Don't send message before initialization succeeded!");
        return false;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m105c() {
        return this.f77a.f40935c;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m106c() {
        return this.f77a.m111a();
    }

    public String d() {
        return this.f77a.f40936d;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m107d() {
        return (TextUtils.isEmpty(this.f77a.f81a) || TextUtils.isEmpty(this.f77a.f40934b) || TextUtils.isEmpty(this.f77a.f40935c) || TextUtils.isEmpty(this.f77a.f40936d)) ? false : true;
    }

    public String e() {
        return this.f77a.f40939g;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m108e() {
        return this.f77a.f83b;
    }

    public String f() {
        return this.f77a.f40940h;
    }

    /* renamed from: f  reason: collision with other method in class */
    public boolean m109f() {
        return !this.f77a.f82a;
    }
}
