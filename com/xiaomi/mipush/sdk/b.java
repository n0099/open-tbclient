package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.searchbox.cloudcontrol.utils.CloudControlUBCUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static volatile b f13821a;

    /* renamed from: a  reason: collision with other field name */
    private Context f141a;

    /* renamed from: a  reason: collision with other field name */
    private a f142a;

    /* renamed from: a  reason: collision with other field name */
    String f143a;

    /* renamed from: a  reason: collision with other field name */
    private Map<String, a> f144a;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with other field name */
        private Context f145a;

        /* renamed from: a  reason: collision with other field name */
        public String f146a;

        /* renamed from: b  reason: collision with root package name */
        public String f13823b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;

        /* renamed from: a  reason: collision with other field name */
        public boolean f147a = true;

        /* renamed from: b  reason: collision with other field name */
        public boolean f148b = false;

        /* renamed from: a  reason: collision with root package name */
        public int f13822a = 1;

        public a(Context context) {
            this.f145a = context;
        }

        public static a a(Context context, String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                a aVar = new a(context);
                aVar.f146a = jSONObject.getString("appId");
                aVar.f13823b = jSONObject.getString("appToken");
                aVar.c = jSONObject.getString("regId");
                aVar.d = jSONObject.getString("regSec");
                aVar.f = jSONObject.getString("devId");
                aVar.e = jSONObject.getString("vName");
                aVar.f147a = jSONObject.getBoolean(CloudControlUBCUtils.KEY_VALID);
                aVar.f148b = jSONObject.getBoolean("paused");
                aVar.f13822a = jSONObject.getInt("envType");
                aVar.g = jSONObject.getString("regResource");
                return aVar;
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.a(th);
                return null;
            }
        }

        private String a() {
            return com.xiaomi.push.g.m332a(this.f145a, this.f145a.getPackageName());
        }

        public static String a(a aVar) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("appId", aVar.f146a);
                jSONObject.put("appToken", aVar.f13823b);
                jSONObject.put("regId", aVar.c);
                jSONObject.put("regSec", aVar.d);
                jSONObject.put("devId", aVar.f);
                jSONObject.put("vName", aVar.e);
                jSONObject.put(CloudControlUBCUtils.KEY_VALID, aVar.f147a);
                jSONObject.put("paused", aVar.f148b);
                jSONObject.put("envType", aVar.f13822a);
                jSONObject.put("regResource", aVar.g);
                return jSONObject.toString();
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.a(th);
                return null;
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m131a() {
            b.a(this.f145a).edit().clear().commit();
            this.f146a = null;
            this.f13823b = null;
            this.c = null;
            this.d = null;
            this.f = null;
            this.e = null;
            this.f147a = false;
            this.f148b = false;
            this.h = null;
            this.f13822a = 1;
        }

        public void a(int i) {
            this.f13822a = i;
        }

        public void a(String str, String str2) {
            this.c = str;
            this.d = str2;
            this.f = com.xiaomi.push.i.l(this.f145a);
            this.e = a();
            this.f147a = true;
        }

        public void a(String str, String str2, String str3) {
            this.f146a = str;
            this.f13823b = str2;
            this.g = str3;
            SharedPreferences.Editor edit = b.a(this.f145a).edit();
            edit.putString("appId", this.f146a);
            edit.putString("appToken", str2);
            edit.putString("regResource", str3);
            edit.commit();
        }

        public void a(boolean z) {
            this.f148b = z;
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m132a() {
            return m133a(this.f146a, this.f13823b);
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m133a(String str, String str2) {
            return TextUtils.equals(this.f146a, str) && TextUtils.equals(this.f13823b, str2) && !TextUtils.isEmpty(this.c) && !TextUtils.isEmpty(this.d) && (TextUtils.equals(this.f, com.xiaomi.push.i.l(this.f145a)) || TextUtils.equals(this.f, com.xiaomi.push.i.k(this.f145a)));
        }

        public void b() {
            this.f147a = false;
            b.a(this.f145a).edit().putBoolean(CloudControlUBCUtils.KEY_VALID, this.f147a).commit();
        }

        public void b(String str, String str2, String str3) {
            this.c = str;
            this.d = str2;
            this.f = com.xiaomi.push.i.l(this.f145a);
            this.e = a();
            this.f147a = true;
            this.h = str3;
            SharedPreferences.Editor edit = b.a(this.f145a).edit();
            edit.putString("regId", str);
            edit.putString("regSec", str2);
            edit.putString("devId", this.f);
            edit.putString("vName", a());
            edit.putBoolean(CloudControlUBCUtils.KEY_VALID, true);
            edit.putString("appRegion", str3);
            edit.commit();
        }

        public void c(String str, String str2, String str3) {
            this.f146a = str;
            this.f13823b = str2;
            this.g = str3;
        }
    }

    private b(Context context) {
        this.f141a = context;
        c();
    }

    public static SharedPreferences a(Context context) {
        return context.getSharedPreferences("mipush", 0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static b m119a(Context context) {
        if (f13821a == null) {
            synchronized (b.class) {
                if (f13821a == null) {
                    f13821a = new b(context);
                }
            }
        }
        return f13821a;
    }

    private void c() {
        this.f142a = new a(this.f141a);
        this.f144a = new HashMap();
        SharedPreferences a2 = a(this.f141a);
        this.f142a.f146a = a2.getString("appId", null);
        this.f142a.f13823b = a2.getString("appToken", null);
        this.f142a.c = a2.getString("regId", null);
        this.f142a.d = a2.getString("regSec", null);
        this.f142a.f = a2.getString("devId", null);
        if (!TextUtils.isEmpty(this.f142a.f) && com.xiaomi.push.i.m416a(this.f142a.f)) {
            this.f142a.f = com.xiaomi.push.i.l(this.f141a);
            a2.edit().putString("devId", this.f142a.f).commit();
        }
        this.f142a.e = a2.getString("vName", null);
        this.f142a.f147a = a2.getBoolean(CloudControlUBCUtils.KEY_VALID, true);
        this.f142a.f148b = a2.getBoolean("paused", false);
        this.f142a.f13822a = a2.getInt("envType", 1);
        this.f142a.g = a2.getString("regResource", null);
        this.f142a.h = a2.getString("appRegion", null);
    }

    public int a() {
        return this.f142a.f13822a;
    }

    public a a(String str) {
        if (this.f144a.containsKey(str)) {
            return this.f144a.get(str);
        }
        String str2 = "hybrid_app_info_" + str;
        SharedPreferences a2 = a(this.f141a);
        if (a2.contains(str2)) {
            a a3 = a.a(this.f141a, a2.getString(str2, ""));
            this.f144a.put(str2, a3);
            return a3;
        }
        return null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m120a() {
        return this.f142a.f146a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m121a() {
        this.f142a.m131a();
    }

    public void a(int i) {
        this.f142a.a(i);
        a(this.f141a).edit().putInt("envType", i).commit();
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m122a(String str) {
        SharedPreferences.Editor edit = a(this.f141a).edit();
        edit.putString("vName", str);
        edit.commit();
        this.f142a.e = str;
    }

    public void a(String str, a aVar) {
        this.f144a.put(str, aVar);
        String a2 = a.a(aVar);
        a(this.f141a).edit().putString("hybrid_app_info_" + str, a2).commit();
    }

    public void a(String str, String str2, String str3) {
        this.f142a.a(str, str2, str3);
    }

    public void a(boolean z) {
        this.f142a.a(z);
        a(this.f141a).edit().putBoolean("paused", z).commit();
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m123a() {
        return !TextUtils.equals(com.xiaomi.push.g.m332a(this.f141a, this.f141a.getPackageName()), this.f142a.e);
    }

    public boolean a(String str, String str2) {
        return this.f142a.m133a(str, str2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m124a(String str, String str2, String str3) {
        a a2 = a(str3);
        return a2 != null && TextUtils.equals(str, a2.f146a) && TextUtils.equals(str2, a2.f13823b);
    }

    public String b() {
        return this.f142a.f13823b;
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m125b() {
        this.f142a.b();
    }

    public void b(String str) {
        this.f144a.remove(str);
        a(this.f141a).edit().remove("hybrid_app_info_" + str).commit();
    }

    public void b(String str, String str2, String str3) {
        this.f142a.b(str, str2, str3);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m126b() {
        if (this.f142a.m132a()) {
            return true;
        }
        com.xiaomi.channel.commonutils.logger.b.m79a("Don't send message before initialization succeeded!");
        return false;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m127c() {
        return this.f142a.c;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m128c() {
        return this.f142a.m132a();
    }

    public String d() {
        return this.f142a.d;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m129d() {
        return this.f142a.f148b;
    }

    public String e() {
        return this.f142a.g;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m130e() {
        return !this.f142a.f147a;
    }

    public String f() {
        return this.f142a.h;
    }
}
