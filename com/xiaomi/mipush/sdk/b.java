package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.searchbox.cloudcontrol.utils.CloudControlUBCUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes18.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static volatile b f4762a;

    /* renamed from: a  reason: collision with other field name */
    private Context f65a;

    /* renamed from: a  reason: collision with other field name */
    private a f66a;

    /* renamed from: a  reason: collision with other field name */
    String f67a;

    /* renamed from: a  reason: collision with other field name */
    private Map<String, a> f68a;

    /* loaded from: classes18.dex */
    public static class a {

        /* renamed from: a  reason: collision with other field name */
        private Context f69a;

        /* renamed from: a  reason: collision with other field name */
        public String f70a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;

        /* renamed from: a  reason: collision with other field name */
        public boolean f71a = true;

        /* renamed from: b  reason: collision with other field name */
        public boolean f72b = false;

        /* renamed from: a  reason: collision with root package name */
        public int f4763a = 1;

        public a(Context context) {
            this.f69a = context;
        }

        public static a a(Context context, String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                a aVar = new a(context);
                aVar.f70a = jSONObject.getString("appId");
                aVar.b = jSONObject.getString("appToken");
                aVar.c = jSONObject.getString("regId");
                aVar.d = jSONObject.getString("regSec");
                aVar.f = jSONObject.getString("devId");
                aVar.e = jSONObject.getString("vName");
                aVar.f71a = jSONObject.getBoolean(CloudControlUBCUtils.KEY_VALID);
                aVar.f72b = jSONObject.getBoolean("paused");
                aVar.f4763a = jSONObject.getInt("envType");
                aVar.g = jSONObject.getString("regResource");
                return aVar;
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.a(th);
                return null;
            }
        }

        private String a() {
            return com.xiaomi.push.g.m310a(this.f69a, this.f69a.getPackageName());
        }

        public static String a(a aVar) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("appId", aVar.f70a);
                jSONObject.put("appToken", aVar.b);
                jSONObject.put("regId", aVar.c);
                jSONObject.put("regSec", aVar.d);
                jSONObject.put("devId", aVar.f);
                jSONObject.put("vName", aVar.e);
                jSONObject.put(CloudControlUBCUtils.KEY_VALID, aVar.f71a);
                jSONObject.put("paused", aVar.f72b);
                jSONObject.put("envType", aVar.f4763a);
                jSONObject.put("regResource", aVar.g);
                return jSONObject.toString();
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.a(th);
                return null;
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m109a() {
            b.a(this.f69a).edit().clear().commit();
            this.f70a = null;
            this.b = null;
            this.c = null;
            this.d = null;
            this.f = null;
            this.e = null;
            this.f71a = false;
            this.f72b = false;
            this.h = null;
            this.f4763a = 1;
        }

        public void a(int i) {
            this.f4763a = i;
        }

        public void a(String str, String str2) {
            this.c = str;
            this.d = str2;
            this.f = com.xiaomi.push.i.l(this.f69a);
            this.e = a();
            this.f71a = true;
        }

        public void a(String str, String str2, String str3) {
            this.f70a = str;
            this.b = str2;
            this.g = str3;
            SharedPreferences.Editor edit = b.a(this.f69a).edit();
            edit.putString("appId", this.f70a);
            edit.putString("appToken", str2);
            edit.putString("regResource", str3);
            edit.commit();
        }

        public void a(boolean z) {
            this.f72b = z;
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m110a() {
            return m111a(this.f70a, this.b);
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m111a(String str, String str2) {
            return TextUtils.equals(this.f70a, str) && TextUtils.equals(this.b, str2) && !TextUtils.isEmpty(this.c) && !TextUtils.isEmpty(this.d) && (TextUtils.equals(this.f, com.xiaomi.push.i.l(this.f69a)) || TextUtils.equals(this.f, com.xiaomi.push.i.k(this.f69a)));
        }

        public void b() {
            this.f71a = false;
            b.a(this.f69a).edit().putBoolean(CloudControlUBCUtils.KEY_VALID, this.f71a).commit();
        }

        public void b(String str, String str2, String str3) {
            this.c = str;
            this.d = str2;
            this.f = com.xiaomi.push.i.l(this.f69a);
            this.e = a();
            this.f71a = true;
            this.h = str3;
            SharedPreferences.Editor edit = b.a(this.f69a).edit();
            edit.putString("regId", str);
            edit.putString("regSec", str2);
            edit.putString("devId", this.f);
            edit.putString("vName", a());
            edit.putBoolean(CloudControlUBCUtils.KEY_VALID, true);
            edit.putString("appRegion", str3);
            edit.commit();
        }

        public void c(String str, String str2, String str3) {
            this.f70a = str;
            this.b = str2;
            this.g = str3;
        }
    }

    private b(Context context) {
        this.f65a = context;
        c();
    }

    public static SharedPreferences a(Context context) {
        return context.getSharedPreferences("mipush", 0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static b m97a(Context context) {
        if (f4762a == null) {
            synchronized (b.class) {
                if (f4762a == null) {
                    f4762a = new b(context);
                }
            }
        }
        return f4762a;
    }

    private void c() {
        this.f66a = new a(this.f65a);
        this.f68a = new HashMap();
        SharedPreferences a2 = a(this.f65a);
        this.f66a.f70a = a2.getString("appId", null);
        this.f66a.b = a2.getString("appToken", null);
        this.f66a.c = a2.getString("regId", null);
        this.f66a.d = a2.getString("regSec", null);
        this.f66a.f = a2.getString("devId", null);
        if (!TextUtils.isEmpty(this.f66a.f) && com.xiaomi.push.i.m394a(this.f66a.f)) {
            this.f66a.f = com.xiaomi.push.i.l(this.f65a);
            a2.edit().putString("devId", this.f66a.f).commit();
        }
        this.f66a.e = a2.getString("vName", null);
        this.f66a.f71a = a2.getBoolean(CloudControlUBCUtils.KEY_VALID, true);
        this.f66a.f72b = a2.getBoolean("paused", false);
        this.f66a.f4763a = a2.getInt("envType", 1);
        this.f66a.g = a2.getString("regResource", null);
        this.f66a.h = a2.getString("appRegion", null);
    }

    public int a() {
        return this.f66a.f4763a;
    }

    public a a(String str) {
        if (this.f68a.containsKey(str)) {
            return this.f68a.get(str);
        }
        String str2 = "hybrid_app_info_" + str;
        SharedPreferences a2 = a(this.f65a);
        if (a2.contains(str2)) {
            a a3 = a.a(this.f65a, a2.getString(str2, ""));
            this.f68a.put(str2, a3);
            return a3;
        }
        return null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m98a() {
        return this.f66a.f70a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m99a() {
        this.f66a.m109a();
    }

    public void a(int i) {
        this.f66a.a(i);
        a(this.f65a).edit().putInt("envType", i).commit();
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m100a(String str) {
        SharedPreferences.Editor edit = a(this.f65a).edit();
        edit.putString("vName", str);
        edit.commit();
        this.f66a.e = str;
    }

    public void a(String str, a aVar) {
        this.f68a.put(str, aVar);
        String a2 = a.a(aVar);
        a(this.f65a).edit().putString("hybrid_app_info_" + str, a2).commit();
    }

    public void a(String str, String str2, String str3) {
        this.f66a.a(str, str2, str3);
    }

    public void a(boolean z) {
        this.f66a.a(z);
        a(this.f65a).edit().putBoolean("paused", z).commit();
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m101a() {
        return !TextUtils.equals(com.xiaomi.push.g.m310a(this.f65a, this.f65a.getPackageName()), this.f66a.e);
    }

    public boolean a(String str, String str2) {
        return this.f66a.m111a(str, str2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m102a(String str, String str2, String str3) {
        a a2 = a(str3);
        return a2 != null && TextUtils.equals(str, a2.f70a) && TextUtils.equals(str2, a2.b);
    }

    public String b() {
        return this.f66a.b;
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m103b() {
        this.f66a.b();
    }

    public void b(String str) {
        this.f68a.remove(str);
        a(this.f65a).edit().remove("hybrid_app_info_" + str).commit();
    }

    public void b(String str, String str2, String str3) {
        this.f66a.b(str, str2, str3);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m104b() {
        if (this.f66a.m110a()) {
            return true;
        }
        com.xiaomi.channel.commonutils.logger.b.m57a("Don't send message before initialization succeeded!");
        return false;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m105c() {
        return this.f66a.c;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m106c() {
        return this.f66a.m110a();
    }

    public String d() {
        return this.f66a.d;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m107d() {
        return this.f66a.f72b;
    }

    public String e() {
        return this.f66a.g;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m108e() {
        return !this.f66a.f71a;
    }

    public String f() {
        return this.f66a.h;
    }
}
