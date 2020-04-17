package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.searchbox.cloudcontrol.utils.CloudControlUBCUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class d {
    private static volatile d a;

    /* renamed from: a  reason: collision with other field name */
    private Context f59a;

    /* renamed from: a  reason: collision with other field name */
    private a f60a;

    /* renamed from: a  reason: collision with other field name */
    String f61a;

    /* renamed from: a  reason: collision with other field name */
    private Map<String, a> f62a;

    /* loaded from: classes8.dex */
    public static class a {

        /* renamed from: a  reason: collision with other field name */
        private Context f63a;

        /* renamed from: a  reason: collision with other field name */
        public String f64a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;

        /* renamed from: a  reason: collision with other field name */
        public boolean f65a = true;

        /* renamed from: b  reason: collision with other field name */
        public boolean f66b = false;
        public int a = 1;

        public a(Context context) {
            this.f63a = context;
        }

        public static a a(Context context, String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                a aVar = new a(context);
                aVar.f64a = jSONObject.getString("appId");
                aVar.b = jSONObject.getString("appToken");
                aVar.c = jSONObject.getString("regId");
                aVar.d = jSONObject.getString("regSec");
                aVar.f = jSONObject.getString("devId");
                aVar.e = jSONObject.getString("vName");
                aVar.f65a = jSONObject.getBoolean(CloudControlUBCUtils.KEY_VALID);
                aVar.f66b = jSONObject.getBoolean("paused");
                aVar.a = jSONObject.getInt("envType");
                aVar.g = jSONObject.getString("regResource");
                return aVar;
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.a(th);
                return null;
            }
        }

        private String a() {
            return com.xiaomi.push.g.m299a(this.f63a, this.f63a.getPackageName());
        }

        public static String a(a aVar) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("appId", aVar.f64a);
                jSONObject.put("appToken", aVar.b);
                jSONObject.put("regId", aVar.c);
                jSONObject.put("regSec", aVar.d);
                jSONObject.put("devId", aVar.f);
                jSONObject.put("vName", aVar.e);
                jSONObject.put(CloudControlUBCUtils.KEY_VALID, aVar.f65a);
                jSONObject.put("paused", aVar.f66b);
                jSONObject.put("envType", aVar.a);
                jSONObject.put("regResource", aVar.g);
                return jSONObject.toString();
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.a(th);
                return null;
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m100a() {
            d.a(this.f63a).edit().clear().commit();
            this.f64a = null;
            this.b = null;
            this.c = null;
            this.d = null;
            this.f = null;
            this.e = null;
            this.f65a = false;
            this.f66b = false;
            this.h = null;
            this.a = 1;
        }

        public void a(int i) {
            this.a = i;
        }

        public void a(String str, String str2) {
            this.c = str;
            this.d = str2;
            this.f = com.xiaomi.push.i.l(this.f63a);
            this.e = a();
            this.f65a = true;
        }

        public void a(String str, String str2, String str3) {
            this.f64a = str;
            this.b = str2;
            this.g = str3;
            SharedPreferences.Editor edit = d.a(this.f63a).edit();
            edit.putString("appId", this.f64a);
            edit.putString("appToken", str2);
            edit.putString("regResource", str3);
            edit.commit();
        }

        public void a(boolean z) {
            this.f66b = z;
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m101a() {
            return m102a(this.f64a, this.b);
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m102a(String str, String str2) {
            return TextUtils.equals(this.f64a, str) && TextUtils.equals(this.b, str2) && !TextUtils.isEmpty(this.c) && !TextUtils.isEmpty(this.d) && (TextUtils.equals(this.f, com.xiaomi.push.i.l(this.f63a)) || TextUtils.equals(this.f, com.xiaomi.push.i.k(this.f63a)));
        }

        public void b() {
            this.f65a = false;
            d.a(this.f63a).edit().putBoolean(CloudControlUBCUtils.KEY_VALID, this.f65a).commit();
        }

        public void b(String str, String str2, String str3) {
            this.c = str;
            this.d = str2;
            this.f = com.xiaomi.push.i.l(this.f63a);
            this.e = a();
            this.f65a = true;
            this.h = str3;
            SharedPreferences.Editor edit = d.a(this.f63a).edit();
            edit.putString("regId", str);
            edit.putString("regSec", str2);
            edit.putString("devId", this.f);
            edit.putString("vName", a());
            edit.putBoolean(CloudControlUBCUtils.KEY_VALID, true);
            edit.putString("appRegion", str3);
            edit.commit();
        }

        public void c(String str, String str2, String str3) {
            this.f64a = str;
            this.b = str2;
            this.g = str3;
        }
    }

    private d(Context context) {
        this.f59a = context;
        c();
    }

    public static SharedPreferences a(Context context) {
        return context.getSharedPreferences("mipush", 0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static d m88a(Context context) {
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
        this.f60a = new a(this.f59a);
        this.f62a = new HashMap();
        SharedPreferences a2 = a(this.f59a);
        this.f60a.f64a = a2.getString("appId", null);
        this.f60a.b = a2.getString("appToken", null);
        this.f60a.c = a2.getString("regId", null);
        this.f60a.d = a2.getString("regSec", null);
        this.f60a.f = a2.getString("devId", null);
        if (!TextUtils.isEmpty(this.f60a.f) && this.f60a.f.startsWith("a-")) {
            this.f60a.f = com.xiaomi.push.i.l(this.f59a);
            a2.edit().putString("devId", this.f60a.f).commit();
        }
        this.f60a.e = a2.getString("vName", null);
        this.f60a.f65a = a2.getBoolean(CloudControlUBCUtils.KEY_VALID, true);
        this.f60a.f66b = a2.getBoolean("paused", false);
        this.f60a.a = a2.getInt("envType", 1);
        this.f60a.g = a2.getString("regResource", null);
        this.f60a.h = a2.getString("appRegion", null);
    }

    public int a() {
        return this.f60a.a;
    }

    public a a(String str) {
        if (this.f62a.containsKey(str)) {
            return this.f62a.get(str);
        }
        String str2 = "hybrid_app_info_" + str;
        SharedPreferences a2 = a(this.f59a);
        if (a2.contains(str2)) {
            a a3 = a.a(this.f59a, a2.getString(str2, ""));
            this.f62a.put(str2, a3);
            return a3;
        }
        return null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m89a() {
        return this.f60a.f64a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m90a() {
        this.f60a.m100a();
    }

    public void a(int i) {
        this.f60a.a(i);
        a(this.f59a).edit().putInt("envType", i).commit();
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m91a(String str) {
        SharedPreferences.Editor edit = a(this.f59a).edit();
        edit.putString("vName", str);
        edit.commit();
        this.f60a.e = str;
    }

    public void a(String str, a aVar) {
        this.f62a.put(str, aVar);
        String a2 = a.a(aVar);
        a(this.f59a).edit().putString("hybrid_app_info_" + str, a2).commit();
    }

    public void a(String str, String str2, String str3) {
        this.f60a.a(str, str2, str3);
    }

    public void a(boolean z) {
        this.f60a.a(z);
        a(this.f59a).edit().putBoolean("paused", z).commit();
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m92a() {
        return !TextUtils.equals(com.xiaomi.push.g.m299a(this.f59a, this.f59a.getPackageName()), this.f60a.e);
    }

    public boolean a(String str, String str2) {
        return this.f60a.m102a(str, str2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m93a(String str, String str2, String str3) {
        a a2 = a(str3);
        return a2 != null && TextUtils.equals(str, a2.f64a) && TextUtils.equals(str2, a2.b);
    }

    public String b() {
        return this.f60a.b;
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m94b() {
        this.f60a.b();
    }

    public void b(String str) {
        this.f62a.remove(str);
        a(this.f59a).edit().remove("hybrid_app_info_" + str).commit();
    }

    public void b(String str, String str2, String str3) {
        this.f60a.b(str, str2, str3);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m95b() {
        if (this.f60a.m101a()) {
            return true;
        }
        com.xiaomi.channel.commonutils.logger.b.m50a("Don't send message before initialization succeeded!");
        return false;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m96c() {
        return this.f60a.c;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m97c() {
        return this.f60a.m101a();
    }

    public String d() {
        return this.f60a.d;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m98d() {
        return this.f60a.f66b;
    }

    public String e() {
        return this.f60a.g;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m99e() {
        return !this.f60a.f65a;
    }

    public String f() {
        return this.f60a.h;
    }
}
