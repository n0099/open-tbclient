package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.searchbox.cloudcontrol.utils.CloudControlUBCUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b {
    private static volatile b a;

    /* renamed from: a  reason: collision with other field name */
    private Context f61a;

    /* renamed from: a  reason: collision with other field name */
    private a f62a;

    /* renamed from: a  reason: collision with other field name */
    String f63a;

    /* renamed from: a  reason: collision with other field name */
    private Map<String, a> f64a;

    /* loaded from: classes8.dex */
    public static class a {

        /* renamed from: a  reason: collision with other field name */
        private Context f65a;

        /* renamed from: a  reason: collision with other field name */
        public String f66a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;

        /* renamed from: a  reason: collision with other field name */
        public boolean f67a = true;

        /* renamed from: b  reason: collision with other field name */
        public boolean f68b = false;
        public int a = 1;

        public a(Context context) {
            this.f65a = context;
        }

        public static a a(Context context, String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                a aVar = new a(context);
                aVar.f66a = jSONObject.getString("appId");
                aVar.b = jSONObject.getString("appToken");
                aVar.c = jSONObject.getString("regId");
                aVar.d = jSONObject.getString("regSec");
                aVar.f = jSONObject.getString("devId");
                aVar.e = jSONObject.getString("vName");
                aVar.f67a = jSONObject.getBoolean(CloudControlUBCUtils.KEY_VALID);
                aVar.f68b = jSONObject.getBoolean("paused");
                aVar.a = jSONObject.getInt("envType");
                aVar.g = jSONObject.getString("regResource");
                return aVar;
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.a(th);
                return null;
            }
        }

        private String a() {
            return com.xiaomi.push.g.m303a(this.f65a, this.f65a.getPackageName());
        }

        public static String a(a aVar) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("appId", aVar.f66a);
                jSONObject.put("appToken", aVar.b);
                jSONObject.put("regId", aVar.c);
                jSONObject.put("regSec", aVar.d);
                jSONObject.put("devId", aVar.f);
                jSONObject.put("vName", aVar.e);
                jSONObject.put(CloudControlUBCUtils.KEY_VALID, aVar.f67a);
                jSONObject.put("paused", aVar.f68b);
                jSONObject.put("envType", aVar.a);
                jSONObject.put("regResource", aVar.g);
                return jSONObject.toString();
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.a(th);
                return null;
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m102a() {
            b.a(this.f65a).edit().clear().commit();
            this.f66a = null;
            this.b = null;
            this.c = null;
            this.d = null;
            this.f = null;
            this.e = null;
            this.f67a = false;
            this.f68b = false;
            this.h = null;
            this.a = 1;
        }

        public void a(int i) {
            this.a = i;
        }

        public void a(String str, String str2) {
            this.c = str;
            this.d = str2;
            this.f = com.xiaomi.push.i.l(this.f65a);
            this.e = a();
            this.f67a = true;
        }

        public void a(String str, String str2, String str3) {
            this.f66a = str;
            this.b = str2;
            this.g = str3;
            SharedPreferences.Editor edit = b.a(this.f65a).edit();
            edit.putString("appId", this.f66a);
            edit.putString("appToken", str2);
            edit.putString("regResource", str3);
            edit.commit();
        }

        public void a(boolean z) {
            this.f68b = z;
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m103a() {
            return m104a(this.f66a, this.b);
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m104a(String str, String str2) {
            return TextUtils.equals(this.f66a, str) && TextUtils.equals(this.b, str2) && !TextUtils.isEmpty(this.c) && !TextUtils.isEmpty(this.d) && (TextUtils.equals(this.f, com.xiaomi.push.i.l(this.f65a)) || TextUtils.equals(this.f, com.xiaomi.push.i.k(this.f65a)));
        }

        public void b() {
            this.f67a = false;
            b.a(this.f65a).edit().putBoolean(CloudControlUBCUtils.KEY_VALID, this.f67a).commit();
        }

        public void b(String str, String str2, String str3) {
            this.c = str;
            this.d = str2;
            this.f = com.xiaomi.push.i.l(this.f65a);
            this.e = a();
            this.f67a = true;
            this.h = str3;
            SharedPreferences.Editor edit = b.a(this.f65a).edit();
            edit.putString("regId", str);
            edit.putString("regSec", str2);
            edit.putString("devId", this.f);
            edit.putString("vName", a());
            edit.putBoolean(CloudControlUBCUtils.KEY_VALID, true);
            edit.putString("appRegion", str3);
            edit.commit();
        }

        public void c(String str, String str2, String str3) {
            this.f66a = str;
            this.b = str2;
            this.g = str3;
        }
    }

    private b(Context context) {
        this.f61a = context;
        c();
    }

    public static SharedPreferences a(Context context) {
        return context.getSharedPreferences("mipush", 0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static b m90a(Context context) {
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
        this.f62a = new a(this.f61a);
        this.f64a = new HashMap();
        SharedPreferences a2 = a(this.f61a);
        this.f62a.f66a = a2.getString("appId", null);
        this.f62a.b = a2.getString("appToken", null);
        this.f62a.c = a2.getString("regId", null);
        this.f62a.d = a2.getString("regSec", null);
        this.f62a.f = a2.getString("devId", null);
        if (!TextUtils.isEmpty(this.f62a.f) && com.xiaomi.push.i.m387a(this.f62a.f)) {
            this.f62a.f = com.xiaomi.push.i.l(this.f61a);
            a2.edit().putString("devId", this.f62a.f).commit();
        }
        this.f62a.e = a2.getString("vName", null);
        this.f62a.f67a = a2.getBoolean(CloudControlUBCUtils.KEY_VALID, true);
        this.f62a.f68b = a2.getBoolean("paused", false);
        this.f62a.a = a2.getInt("envType", 1);
        this.f62a.g = a2.getString("regResource", null);
        this.f62a.h = a2.getString("appRegion", null);
    }

    public int a() {
        return this.f62a.a;
    }

    public a a(String str) {
        if (this.f64a.containsKey(str)) {
            return this.f64a.get(str);
        }
        String str2 = "hybrid_app_info_" + str;
        SharedPreferences a2 = a(this.f61a);
        if (a2.contains(str2)) {
            a a3 = a.a(this.f61a, a2.getString(str2, ""));
            this.f64a.put(str2, a3);
            return a3;
        }
        return null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m91a() {
        return this.f62a.f66a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m92a() {
        this.f62a.m102a();
    }

    public void a(int i) {
        this.f62a.a(i);
        a(this.f61a).edit().putInt("envType", i).commit();
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m93a(String str) {
        SharedPreferences.Editor edit = a(this.f61a).edit();
        edit.putString("vName", str);
        edit.commit();
        this.f62a.e = str;
    }

    public void a(String str, a aVar) {
        this.f64a.put(str, aVar);
        String a2 = a.a(aVar);
        a(this.f61a).edit().putString("hybrid_app_info_" + str, a2).commit();
    }

    public void a(String str, String str2, String str3) {
        this.f62a.a(str, str2, str3);
    }

    public void a(boolean z) {
        this.f62a.a(z);
        a(this.f61a).edit().putBoolean("paused", z).commit();
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m94a() {
        return !TextUtils.equals(com.xiaomi.push.g.m303a(this.f61a, this.f61a.getPackageName()), this.f62a.e);
    }

    public boolean a(String str, String str2) {
        return this.f62a.m104a(str, str2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m95a(String str, String str2, String str3) {
        a a2 = a(str3);
        return a2 != null && TextUtils.equals(str, a2.f66a) && TextUtils.equals(str2, a2.b);
    }

    public String b() {
        return this.f62a.b;
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m96b() {
        this.f62a.b();
    }

    public void b(String str) {
        this.f64a.remove(str);
        a(this.f61a).edit().remove("hybrid_app_info_" + str).commit();
    }

    public void b(String str, String str2, String str3) {
        this.f62a.b(str, str2, str3);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m97b() {
        if (this.f62a.m103a()) {
            return true;
        }
        com.xiaomi.channel.commonutils.logger.b.m50a("Don't send message before initialization succeeded!");
        return false;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m98c() {
        return this.f62a.c;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m99c() {
        return this.f62a.m103a();
    }

    public String d() {
        return this.f62a.d;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m100d() {
        return this.f62a.f68b;
    }

    public String e() {
        return this.f62a.g;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m101e() {
        return !this.f62a.f67a;
    }

    public String f() {
        return this.f62a.h;
    }
}
