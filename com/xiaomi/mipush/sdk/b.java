package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.searchbox.cloudcontrol.utils.CloudControlUBCUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b {
    private static volatile b a;

    /* renamed from: a  reason: collision with other field name */
    private Context f63a;

    /* renamed from: a  reason: collision with other field name */
    private a f64a;

    /* renamed from: a  reason: collision with other field name */
    String f65a;

    /* renamed from: a  reason: collision with other field name */
    private Map<String, a> f66a;

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with other field name */
        private Context f67a;

        /* renamed from: a  reason: collision with other field name */
        public String f68a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;

        /* renamed from: a  reason: collision with other field name */
        public boolean f69a = true;

        /* renamed from: b  reason: collision with other field name */
        public boolean f70b = false;
        public int a = 1;

        public a(Context context) {
            this.f67a = context;
        }

        public static a a(Context context, String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                a aVar = new a(context);
                aVar.f68a = jSONObject.getString("appId");
                aVar.b = jSONObject.getString("appToken");
                aVar.c = jSONObject.getString("regId");
                aVar.d = jSONObject.getString("regSec");
                aVar.f = jSONObject.getString("devId");
                aVar.e = jSONObject.getString("vName");
                aVar.f69a = jSONObject.getBoolean(CloudControlUBCUtils.KEY_VALID);
                aVar.f70b = jSONObject.getBoolean("paused");
                aVar.a = jSONObject.getInt("envType");
                aVar.g = jSONObject.getString("regResource");
                return aVar;
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.a(th);
                return null;
            }
        }

        private String a() {
            return com.xiaomi.push.g.m307a(this.f67a, this.f67a.getPackageName());
        }

        public static String a(a aVar) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("appId", aVar.f68a);
                jSONObject.put("appToken", aVar.b);
                jSONObject.put("regId", aVar.c);
                jSONObject.put("regSec", aVar.d);
                jSONObject.put("devId", aVar.f);
                jSONObject.put("vName", aVar.e);
                jSONObject.put(CloudControlUBCUtils.KEY_VALID, aVar.f69a);
                jSONObject.put("paused", aVar.f70b);
                jSONObject.put("envType", aVar.a);
                jSONObject.put("regResource", aVar.g);
                return jSONObject.toString();
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.a(th);
                return null;
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m106a() {
            b.a(this.f67a).edit().clear().commit();
            this.f68a = null;
            this.b = null;
            this.c = null;
            this.d = null;
            this.f = null;
            this.e = null;
            this.f69a = false;
            this.f70b = false;
            this.h = null;
            this.a = 1;
        }

        public void a(int i) {
            this.a = i;
        }

        public void a(String str, String str2) {
            this.c = str;
            this.d = str2;
            this.f = com.xiaomi.push.i.l(this.f67a);
            this.e = a();
            this.f69a = true;
        }

        public void a(String str, String str2, String str3) {
            this.f68a = str;
            this.b = str2;
            this.g = str3;
            SharedPreferences.Editor edit = b.a(this.f67a).edit();
            edit.putString("appId", this.f68a);
            edit.putString("appToken", str2);
            edit.putString("regResource", str3);
            edit.commit();
        }

        public void a(boolean z) {
            this.f70b = z;
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m107a() {
            return m108a(this.f68a, this.b);
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m108a(String str, String str2) {
            return TextUtils.equals(this.f68a, str) && TextUtils.equals(this.b, str2) && !TextUtils.isEmpty(this.c) && !TextUtils.isEmpty(this.d) && (TextUtils.equals(this.f, com.xiaomi.push.i.l(this.f67a)) || TextUtils.equals(this.f, com.xiaomi.push.i.k(this.f67a)));
        }

        public void b() {
            this.f69a = false;
            b.a(this.f67a).edit().putBoolean(CloudControlUBCUtils.KEY_VALID, this.f69a).commit();
        }

        public void b(String str, String str2, String str3) {
            this.c = str;
            this.d = str2;
            this.f = com.xiaomi.push.i.l(this.f67a);
            this.e = a();
            this.f69a = true;
            this.h = str3;
            SharedPreferences.Editor edit = b.a(this.f67a).edit();
            edit.putString("regId", str);
            edit.putString("regSec", str2);
            edit.putString("devId", this.f);
            edit.putString("vName", a());
            edit.putBoolean(CloudControlUBCUtils.KEY_VALID, true);
            edit.putString("appRegion", str3);
            edit.commit();
        }

        public void c(String str, String str2, String str3) {
            this.f68a = str;
            this.b = str2;
            this.g = str3;
        }
    }

    private b(Context context) {
        this.f63a = context;
        c();
    }

    public static SharedPreferences a(Context context) {
        return context.getSharedPreferences("mipush", 0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static b m94a(Context context) {
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
        this.f64a = new a(this.f63a);
        this.f66a = new HashMap();
        SharedPreferences a2 = a(this.f63a);
        this.f64a.f68a = a2.getString("appId", null);
        this.f64a.b = a2.getString("appToken", null);
        this.f64a.c = a2.getString("regId", null);
        this.f64a.d = a2.getString("regSec", null);
        this.f64a.f = a2.getString("devId", null);
        if (!TextUtils.isEmpty(this.f64a.f) && com.xiaomi.push.i.m391a(this.f64a.f)) {
            this.f64a.f = com.xiaomi.push.i.l(this.f63a);
            a2.edit().putString("devId", this.f64a.f).commit();
        }
        this.f64a.e = a2.getString("vName", null);
        this.f64a.f69a = a2.getBoolean(CloudControlUBCUtils.KEY_VALID, true);
        this.f64a.f70b = a2.getBoolean("paused", false);
        this.f64a.a = a2.getInt("envType", 1);
        this.f64a.g = a2.getString("regResource", null);
        this.f64a.h = a2.getString("appRegion", null);
    }

    public int a() {
        return this.f64a.a;
    }

    public a a(String str) {
        if (this.f66a.containsKey(str)) {
            return this.f66a.get(str);
        }
        String str2 = "hybrid_app_info_" + str;
        SharedPreferences a2 = a(this.f63a);
        if (a2.contains(str2)) {
            a a3 = a.a(this.f63a, a2.getString(str2, ""));
            this.f66a.put(str2, a3);
            return a3;
        }
        return null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m95a() {
        return this.f64a.f68a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m96a() {
        this.f64a.m106a();
    }

    public void a(int i) {
        this.f64a.a(i);
        a(this.f63a).edit().putInt("envType", i).commit();
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m97a(String str) {
        SharedPreferences.Editor edit = a(this.f63a).edit();
        edit.putString("vName", str);
        edit.commit();
        this.f64a.e = str;
    }

    public void a(String str, a aVar) {
        this.f66a.put(str, aVar);
        String a2 = a.a(aVar);
        a(this.f63a).edit().putString("hybrid_app_info_" + str, a2).commit();
    }

    public void a(String str, String str2, String str3) {
        this.f64a.a(str, str2, str3);
    }

    public void a(boolean z) {
        this.f64a.a(z);
        a(this.f63a).edit().putBoolean("paused", z).commit();
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m98a() {
        return !TextUtils.equals(com.xiaomi.push.g.m307a(this.f63a, this.f63a.getPackageName()), this.f64a.e);
    }

    public boolean a(String str, String str2) {
        return this.f64a.m108a(str, str2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m99a(String str, String str2, String str3) {
        a a2 = a(str3);
        return a2 != null && TextUtils.equals(str, a2.f68a) && TextUtils.equals(str2, a2.b);
    }

    public String b() {
        return this.f64a.b;
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m100b() {
        this.f64a.b();
    }

    public void b(String str) {
        this.f66a.remove(str);
        a(this.f63a).edit().remove("hybrid_app_info_" + str).commit();
    }

    public void b(String str, String str2, String str3) {
        this.f64a.b(str, str2, str3);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m101b() {
        if (this.f64a.m107a()) {
            return true;
        }
        com.xiaomi.channel.commonutils.logger.b.m54a("Don't send message before initialization succeeded!");
        return false;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m102c() {
        return this.f64a.c;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m103c() {
        return this.f64a.m107a();
    }

    public String d() {
        return this.f64a.d;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m104d() {
        return this.f64a.f70b;
    }

    public String e() {
        return this.f64a.g;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m105e() {
        return !this.f64a.f69a;
    }

    public String f() {
        return this.f64a.h;
    }
}
