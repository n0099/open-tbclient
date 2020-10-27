package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.searchbox.cloudcontrol.utils.CloudControlUBCUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static volatile b f4760a;

    /* renamed from: a  reason: collision with other field name */
    private Context f60a;

    /* renamed from: a  reason: collision with other field name */
    private a f61a;

    /* renamed from: a  reason: collision with other field name */
    String f62a;

    /* renamed from: a  reason: collision with other field name */
    private Map<String, a> f63a;

    /* loaded from: classes12.dex */
    public static class a {

        /* renamed from: a  reason: collision with other field name */
        private Context f64a;

        /* renamed from: a  reason: collision with other field name */
        public String f65a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;

        /* renamed from: a  reason: collision with other field name */
        public boolean f66a = true;

        /* renamed from: b  reason: collision with other field name */
        public boolean f67b = false;

        /* renamed from: a  reason: collision with root package name */
        public int f4761a = 1;

        public a(Context context) {
            this.f64a = context;
        }

        public static a a(Context context, String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                a aVar = new a(context);
                aVar.f65a = jSONObject.getString("appId");
                aVar.b = jSONObject.getString("appToken");
                aVar.c = jSONObject.getString("regId");
                aVar.d = jSONObject.getString("regSec");
                aVar.f = jSONObject.getString("devId");
                aVar.e = jSONObject.getString("vName");
                aVar.f66a = jSONObject.getBoolean(CloudControlUBCUtils.KEY_VALID);
                aVar.f67b = jSONObject.getBoolean("paused");
                aVar.f4761a = jSONObject.getInt("envType");
                aVar.g = jSONObject.getString("regResource");
                return aVar;
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.a(th);
                return null;
            }
        }

        private String a() {
            return com.xiaomi.push.g.m307a(this.f64a, this.f64a.getPackageName());
        }

        public static String a(a aVar) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("appId", aVar.f65a);
                jSONObject.put("appToken", aVar.b);
                jSONObject.put("regId", aVar.c);
                jSONObject.put("regSec", aVar.d);
                jSONObject.put("devId", aVar.f);
                jSONObject.put("vName", aVar.e);
                jSONObject.put(CloudControlUBCUtils.KEY_VALID, aVar.f66a);
                jSONObject.put("paused", aVar.f67b);
                jSONObject.put("envType", aVar.f4761a);
                jSONObject.put("regResource", aVar.g);
                return jSONObject.toString();
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.a(th);
                return null;
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m106a() {
            b.a(this.f64a).edit().clear().commit();
            this.f65a = null;
            this.b = null;
            this.c = null;
            this.d = null;
            this.f = null;
            this.e = null;
            this.f66a = false;
            this.f67b = false;
            this.h = null;
            this.f4761a = 1;
        }

        public void a(int i) {
            this.f4761a = i;
        }

        public void a(String str, String str2) {
            this.c = str;
            this.d = str2;
            this.f = com.xiaomi.push.i.l(this.f64a);
            this.e = a();
            this.f66a = true;
        }

        public void a(String str, String str2, String str3) {
            this.f65a = str;
            this.b = str2;
            this.g = str3;
            SharedPreferences.Editor edit = b.a(this.f64a).edit();
            edit.putString("appId", this.f65a);
            edit.putString("appToken", str2);
            edit.putString("regResource", str3);
            edit.commit();
        }

        public void a(boolean z) {
            this.f67b = z;
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m107a() {
            return m108a(this.f65a, this.b);
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m108a(String str, String str2) {
            return TextUtils.equals(this.f65a, str) && TextUtils.equals(this.b, str2) && !TextUtils.isEmpty(this.c) && !TextUtils.isEmpty(this.d) && (TextUtils.equals(this.f, com.xiaomi.push.i.l(this.f64a)) || TextUtils.equals(this.f, com.xiaomi.push.i.k(this.f64a)));
        }

        public void b() {
            this.f66a = false;
            b.a(this.f64a).edit().putBoolean(CloudControlUBCUtils.KEY_VALID, this.f66a).commit();
        }

        public void b(String str, String str2, String str3) {
            this.c = str;
            this.d = str2;
            this.f = com.xiaomi.push.i.l(this.f64a);
            this.e = a();
            this.f66a = true;
            this.h = str3;
            SharedPreferences.Editor edit = b.a(this.f64a).edit();
            edit.putString("regId", str);
            edit.putString("regSec", str2);
            edit.putString("devId", this.f);
            edit.putString("vName", a());
            edit.putBoolean(CloudControlUBCUtils.KEY_VALID, true);
            edit.putString("appRegion", str3);
            edit.commit();
        }

        public void c(String str, String str2, String str3) {
            this.f65a = str;
            this.b = str2;
            this.g = str3;
        }
    }

    private b(Context context) {
        this.f60a = context;
        c();
    }

    public static SharedPreferences a(Context context) {
        return context.getSharedPreferences("mipush", 0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static b m94a(Context context) {
        if (f4760a == null) {
            synchronized (b.class) {
                if (f4760a == null) {
                    f4760a = new b(context);
                }
            }
        }
        return f4760a;
    }

    private void c() {
        this.f61a = new a(this.f60a);
        this.f63a = new HashMap();
        SharedPreferences a2 = a(this.f60a);
        this.f61a.f65a = a2.getString("appId", null);
        this.f61a.b = a2.getString("appToken", null);
        this.f61a.c = a2.getString("regId", null);
        this.f61a.d = a2.getString("regSec", null);
        this.f61a.f = a2.getString("devId", null);
        if (!TextUtils.isEmpty(this.f61a.f) && com.xiaomi.push.i.m391a(this.f61a.f)) {
            this.f61a.f = com.xiaomi.push.i.l(this.f60a);
            a2.edit().putString("devId", this.f61a.f).commit();
        }
        this.f61a.e = a2.getString("vName", null);
        this.f61a.f66a = a2.getBoolean(CloudControlUBCUtils.KEY_VALID, true);
        this.f61a.f67b = a2.getBoolean("paused", false);
        this.f61a.f4761a = a2.getInt("envType", 1);
        this.f61a.g = a2.getString("regResource", null);
        this.f61a.h = a2.getString("appRegion", null);
    }

    public int a() {
        return this.f61a.f4761a;
    }

    public a a(String str) {
        if (this.f63a.containsKey(str)) {
            return this.f63a.get(str);
        }
        String str2 = "hybrid_app_info_" + str;
        SharedPreferences a2 = a(this.f60a);
        if (a2.contains(str2)) {
            a a3 = a.a(this.f60a, a2.getString(str2, ""));
            this.f63a.put(str2, a3);
            return a3;
        }
        return null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m95a() {
        return this.f61a.f65a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m96a() {
        this.f61a.m106a();
    }

    public void a(int i) {
        this.f61a.a(i);
        a(this.f60a).edit().putInt("envType", i).commit();
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m97a(String str) {
        SharedPreferences.Editor edit = a(this.f60a).edit();
        edit.putString("vName", str);
        edit.commit();
        this.f61a.e = str;
    }

    public void a(String str, a aVar) {
        this.f63a.put(str, aVar);
        String a2 = a.a(aVar);
        a(this.f60a).edit().putString("hybrid_app_info_" + str, a2).commit();
    }

    public void a(String str, String str2, String str3) {
        this.f61a.a(str, str2, str3);
    }

    public void a(boolean z) {
        this.f61a.a(z);
        a(this.f60a).edit().putBoolean("paused", z).commit();
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m98a() {
        return !TextUtils.equals(com.xiaomi.push.g.m307a(this.f60a, this.f60a.getPackageName()), this.f61a.e);
    }

    public boolean a(String str, String str2) {
        return this.f61a.m108a(str, str2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m99a(String str, String str2, String str3) {
        a a2 = a(str3);
        return a2 != null && TextUtils.equals(str, a2.f65a) && TextUtils.equals(str2, a2.b);
    }

    public String b() {
        return this.f61a.b;
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m100b() {
        this.f61a.b();
    }

    public void b(String str) {
        this.f63a.remove(str);
        a(this.f60a).edit().remove("hybrid_app_info_" + str).commit();
    }

    public void b(String str, String str2, String str3) {
        this.f61a.b(str, str2, str3);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m101b() {
        if (this.f61a.m107a()) {
            return true;
        }
        com.xiaomi.channel.commonutils.logger.b.m54a("Don't send message before initialization succeeded!");
        return false;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m102c() {
        return this.f61a.c;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m103c() {
        return this.f61a.m107a();
    }

    public String d() {
        return this.f61a.d;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m104d() {
        return this.f61a.f67b;
    }

    public String e() {
        return this.f61a.g;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m105e() {
        return !this.f61a.f66a;
    }

    public String f() {
        return this.f61a.h;
    }
}
