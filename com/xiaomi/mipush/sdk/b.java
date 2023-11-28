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
    public Context f66a;

    /* renamed from: a  reason: collision with other field name */
    public a f67a;

    /* renamed from: a  reason: collision with other field name */
    public String f68a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, a> f69a;

    /* loaded from: classes10.dex */
    public static class a {

        /* renamed from: a  reason: collision with other field name */
        public Context f70a;

        /* renamed from: a  reason: collision with other field name */
        public String f71a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;

        /* renamed from: a  reason: collision with other field name */
        public boolean f72a = true;

        /* renamed from: b  reason: collision with other field name */
        public boolean f73b = false;
        public int a = 1;

        public a(Context context) {
            this.f70a = context;
        }

        public static a a(Context context, String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                a aVar = new a(context);
                aVar.f71a = jSONObject.getString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
                aVar.b = jSONObject.getString("appToken");
                aVar.c = jSONObject.getString("regId");
                aVar.d = jSONObject.getString("regSec");
                aVar.f = jSONObject.getString("devId");
                aVar.e = jSONObject.getString("vName");
                aVar.f72a = jSONObject.getBoolean("valid");
                aVar.f73b = jSONObject.getBoolean("paused");
                aVar.a = jSONObject.getInt("envType");
                aVar.g = jSONObject.getString("regResource");
                return aVar;
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.a(th);
                return null;
            }
        }

        private String a() {
            Context context = this.f70a;
            return com.xiaomi.push.g.m525a(context, context.getPackageName());
        }

        public static String a(a aVar) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, aVar.f71a);
                jSONObject.put("appToken", aVar.b);
                jSONObject.put("regId", aVar.c);
                jSONObject.put("regSec", aVar.d);
                jSONObject.put("devId", aVar.f);
                jSONObject.put("vName", aVar.e);
                jSONObject.put("valid", aVar.f72a);
                jSONObject.put("paused", aVar.f73b);
                jSONObject.put("envType", aVar.a);
                jSONObject.put("regResource", aVar.g);
                return jSONObject.toString();
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.a(th);
                return null;
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m247a() {
            b.a(this.f70a).edit().clear().commit();
            this.f71a = null;
            this.b = null;
            this.c = null;
            this.d = null;
            this.f = null;
            this.e = null;
            this.f72a = false;
            this.f73b = false;
            this.h = null;
            this.a = 1;
        }

        public void a(int i) {
            this.a = i;
        }

        public void a(String str, String str2) {
            this.c = str;
            this.d = str2;
            this.f = com.xiaomi.push.i.h(this.f70a);
            this.e = a();
            this.f72a = true;
        }

        public void a(String str, String str2, String str3) {
            this.f71a = str;
            this.b = str2;
            this.g = str3;
            SharedPreferences.Editor edit = b.a(this.f70a).edit();
            edit.putString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f71a);
            edit.putString("appToken", str2);
            edit.putString("regResource", str3);
            edit.commit();
        }

        public void a(boolean z) {
            this.f73b = z;
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m248a() {
            return m249a(this.f71a, this.b);
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m249a(String str, String str2) {
            boolean equals = TextUtils.equals(this.f71a, str);
            boolean equals2 = TextUtils.equals(this.b, str2);
            boolean z = !TextUtils.isEmpty(this.c);
            boolean z2 = !TextUtils.isEmpty(this.d);
            boolean z3 = TextUtils.equals(this.f, com.xiaomi.push.i.h(this.f70a)) || TextUtils.equals(this.f, com.xiaomi.push.i.g(this.f70a));
            boolean z4 = equals && equals2 && z && z2 && z3;
            if (!z4) {
                com.xiaomi.channel.commonutils.logger.b.e(String.format("register invalid, aid=%s;atn=%s;rid=%s;rse=%s;did=%s", Boolean.valueOf(equals), Boolean.valueOf(equals2), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)));
            }
            return z4;
        }

        public void b() {
            this.f72a = false;
            b.a(this.f70a).edit().putBoolean("valid", this.f72a).commit();
        }

        public void b(String str, String str2, String str3) {
            this.c = str;
            this.d = str2;
            this.f = com.xiaomi.push.i.h(this.f70a);
            this.e = a();
            this.f72a = true;
            this.h = str3;
            SharedPreferences.Editor edit = b.a(this.f70a).edit();
            edit.putString("regId", str);
            edit.putString("regSec", str2);
            edit.putString("devId", this.f);
            edit.putString("vName", a());
            edit.putBoolean("valid", true);
            edit.putString("appRegion", str3);
            edit.commit();
        }

        public void c(String str, String str2, String str3) {
            this.f71a = str;
            this.b = str2;
            this.g = str3;
        }
    }

    public b(Context context) {
        this.f66a = context;
        c();
    }

    public static SharedPreferences a(Context context) {
        return context.getSharedPreferences("mipush", 0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static b m234a(Context context) {
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
        this.f67a = new a(this.f66a);
        this.f69a = new HashMap();
        SharedPreferences a2 = a(this.f66a);
        this.f67a.f71a = a2.getString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, null);
        this.f67a.b = a2.getString("appToken", null);
        this.f67a.c = a2.getString("regId", null);
        this.f67a.d = a2.getString("regSec", null);
        this.f67a.f = a2.getString("devId", null);
        if (!TextUtils.isEmpty(this.f67a.f) && com.xiaomi.push.i.a(this.f67a.f)) {
            this.f67a.f = com.xiaomi.push.i.h(this.f66a);
            a2.edit().putString("devId", this.f67a.f).commit();
        }
        this.f67a.e = a2.getString("vName", null);
        this.f67a.f72a = a2.getBoolean("valid", true);
        this.f67a.f73b = a2.getBoolean("paused", false);
        this.f67a.a = a2.getInt("envType", 1);
        this.f67a.g = a2.getString("regResource", null);
        this.f67a.h = a2.getString("appRegion", null);
    }

    public int a() {
        return this.f67a.a;
    }

    public a a(String str) {
        if (this.f69a.containsKey(str)) {
            return this.f69a.get(str);
        }
        String str2 = "hybrid_app_info_" + str;
        SharedPreferences a2 = a(this.f66a);
        if (a2.contains(str2)) {
            a a3 = a.a(this.f66a, a2.getString(str2, ""));
            this.f69a.put(str2, a3);
            return a3;
        }
        return null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m235a() {
        return this.f67a.f71a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m236a() {
        this.f67a.m247a();
    }

    public void a(int i) {
        this.f67a.a(i);
        a(this.f66a).edit().putInt("envType", i).commit();
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m237a(String str) {
        SharedPreferences.Editor edit = a(this.f66a).edit();
        edit.putString("vName", str);
        edit.commit();
        this.f67a.e = str;
    }

    public void a(String str, a aVar) {
        this.f69a.put(str, aVar);
        String a2 = a.a(aVar);
        a(this.f66a).edit().putString("hybrid_app_info_" + str, a2).commit();
    }

    public void a(String str, String str2, String str3) {
        this.f67a.a(str, str2, str3);
    }

    public void a(boolean z) {
        this.f67a.a(z);
        a(this.f66a).edit().putBoolean("paused", z).commit();
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m238a() {
        Context context = this.f66a;
        return !TextUtils.equals(com.xiaomi.push.g.m525a(context, context.getPackageName()), this.f67a.e);
    }

    public boolean a(String str, String str2) {
        return this.f67a.m249a(str, str2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m239a(String str, String str2, String str3) {
        a a2 = a(str3);
        return a2 != null && TextUtils.equals(str, a2.f71a) && TextUtils.equals(str2, a2.b);
    }

    public String b() {
        return this.f67a.b;
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m240b() {
        this.f67a.b();
    }

    public void b(String str) {
        this.f69a.remove(str);
        a(this.f66a).edit().remove("hybrid_app_info_" + str).commit();
    }

    public void b(String str, String str2, String str3) {
        this.f67a.b(str, str2, str3);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m241b() {
        if (this.f67a.m248a()) {
            return true;
        }
        com.xiaomi.channel.commonutils.logger.b.m190a("Don't send message before initialization succeeded!");
        return false;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m242c() {
        return this.f67a.c;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m243c() {
        return this.f67a.m248a();
    }

    public String d() {
        return this.f67a.d;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m244d() {
        return (TextUtils.isEmpty(this.f67a.f71a) || TextUtils.isEmpty(this.f67a.b) || TextUtils.isEmpty(this.f67a.c) || TextUtils.isEmpty(this.f67a.d)) ? false : true;
    }

    public String e() {
        return this.f67a.g;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m245e() {
        return this.f67a.f73b;
    }

    public String f() {
        return this.f67a.h;
    }

    /* renamed from: f  reason: collision with other method in class */
    public boolean m246f() {
        return !this.f67a.f72a;
    }
}
