package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.searchbox.net.update.UpdateConstants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d {
    private static volatile d a;

    /* renamed from: a  reason: collision with other field name */
    private Context f62a;

    /* renamed from: a  reason: collision with other field name */
    private a f63a;

    /* renamed from: a  reason: collision with other field name */
    String f64a;

    /* renamed from: a  reason: collision with other field name */
    private Map<String, a> f65a;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with other field name */
        private Context f66a;

        /* renamed from: a  reason: collision with other field name */
        public String f67a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;

        /* renamed from: a  reason: collision with other field name */
        public boolean f68a = true;

        /* renamed from: b  reason: collision with other field name */
        public boolean f69b = false;
        public int a = 1;

        public a(Context context) {
            this.f66a = context;
        }

        public static a a(Context context, String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                a aVar = new a(context);
                aVar.f67a = jSONObject.getString("appId");
                aVar.b = jSONObject.getString("appToken");
                aVar.c = jSONObject.getString("regId");
                aVar.d = jSONObject.getString("regSec");
                aVar.f = jSONObject.getString("devId");
                aVar.e = jSONObject.getString("vName");
                aVar.f68a = jSONObject.getBoolean(UpdateConstants.VALID_KEY);
                aVar.f69b = jSONObject.getBoolean("paused");
                aVar.a = jSONObject.getInt("envType");
                aVar.g = jSONObject.getString("regResource");
                return aVar;
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.a(th);
                return null;
            }
        }

        private String a() {
            return com.xiaomi.push.g.m291a(this.f66a, this.f66a.getPackageName());
        }

        public static String a(a aVar) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("appId", aVar.f67a);
                jSONObject.put("appToken", aVar.b);
                jSONObject.put("regId", aVar.c);
                jSONObject.put("regSec", aVar.d);
                jSONObject.put("devId", aVar.f);
                jSONObject.put("vName", aVar.e);
                jSONObject.put(UpdateConstants.VALID_KEY, aVar.f68a);
                jSONObject.put("paused", aVar.f69b);
                jSONObject.put("envType", aVar.a);
                jSONObject.put("regResource", aVar.g);
                return jSONObject.toString();
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.a(th);
                return null;
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m92a() {
            d.a(this.f66a).edit().clear().commit();
            this.f67a = null;
            this.b = null;
            this.c = null;
            this.d = null;
            this.f = null;
            this.e = null;
            this.f68a = false;
            this.f69b = false;
            this.h = null;
            this.a = 1;
        }

        public void a(int i) {
            this.a = i;
        }

        public void a(String str, String str2) {
            this.c = str;
            this.d = str2;
            this.f = com.xiaomi.push.i.l(this.f66a);
            this.e = a();
            this.f68a = true;
        }

        public void a(String str, String str2, String str3) {
            this.f67a = str;
            this.b = str2;
            this.g = str3;
            SharedPreferences.Editor edit = d.a(this.f66a).edit();
            edit.putString("appId", this.f67a);
            edit.putString("appToken", str2);
            edit.putString("regResource", str3);
            edit.commit();
        }

        public void a(boolean z) {
            this.f69b = z;
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m93a() {
            return m94a(this.f67a, this.b);
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m94a(String str, String str2) {
            return TextUtils.equals(this.f67a, str) && TextUtils.equals(this.b, str2) && !TextUtils.isEmpty(this.c) && !TextUtils.isEmpty(this.d) && (TextUtils.equals(this.f, com.xiaomi.push.i.l(this.f66a)) || TextUtils.equals(this.f, com.xiaomi.push.i.k(this.f66a)));
        }

        public void b() {
            this.f68a = false;
            d.a(this.f66a).edit().putBoolean(UpdateConstants.VALID_KEY, this.f68a).commit();
        }

        public void b(String str, String str2, String str3) {
            this.c = str;
            this.d = str2;
            this.f = com.xiaomi.push.i.l(this.f66a);
            this.e = a();
            this.f68a = true;
            this.h = str3;
            SharedPreferences.Editor edit = d.a(this.f66a).edit();
            edit.putString("regId", str);
            edit.putString("regSec", str2);
            edit.putString("devId", this.f);
            edit.putString("vName", a());
            edit.putBoolean(UpdateConstants.VALID_KEY, true);
            edit.putString("appRegion", str3);
            edit.commit();
        }

        public void c(String str, String str2, String str3) {
            this.f67a = str;
            this.b = str2;
            this.g = str3;
        }
    }

    private d(Context context) {
        this.f62a = context;
        c();
    }

    public static SharedPreferences a(Context context) {
        return context.getSharedPreferences("mipush", 0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static d m80a(Context context) {
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
        this.f63a = new a(this.f62a);
        this.f65a = new HashMap();
        SharedPreferences a2 = a(this.f62a);
        this.f63a.f67a = a2.getString("appId", null);
        this.f63a.b = a2.getString("appToken", null);
        this.f63a.c = a2.getString("regId", null);
        this.f63a.d = a2.getString("regSec", null);
        this.f63a.f = a2.getString("devId", null);
        if (!TextUtils.isEmpty(this.f63a.f) && this.f63a.f.startsWith("a-")) {
            this.f63a.f = com.xiaomi.push.i.l(this.f62a);
            a2.edit().putString("devId", this.f63a.f).commit();
        }
        this.f63a.e = a2.getString("vName", null);
        this.f63a.f68a = a2.getBoolean(UpdateConstants.VALID_KEY, true);
        this.f63a.f69b = a2.getBoolean("paused", false);
        this.f63a.a = a2.getInt("envType", 1);
        this.f63a.g = a2.getString("regResource", null);
        this.f63a.h = a2.getString("appRegion", null);
    }

    public int a() {
        return this.f63a.a;
    }

    public a a(String str) {
        if (this.f65a.containsKey(str)) {
            return this.f65a.get(str);
        }
        String str2 = "hybrid_app_info_" + str;
        SharedPreferences a2 = a(this.f62a);
        if (a2.contains(str2)) {
            a a3 = a.a(this.f62a, a2.getString(str2, ""));
            this.f65a.put(str2, a3);
            return a3;
        }
        return null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m81a() {
        return this.f63a.f67a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m82a() {
        this.f63a.m92a();
    }

    public void a(int i) {
        this.f63a.a(i);
        a(this.f62a).edit().putInt("envType", i).commit();
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m83a(String str) {
        SharedPreferences.Editor edit = a(this.f62a).edit();
        edit.putString("vName", str);
        edit.commit();
        this.f63a.e = str;
    }

    public void a(String str, a aVar) {
        this.f65a.put(str, aVar);
        String a2 = a.a(aVar);
        a(this.f62a).edit().putString("hybrid_app_info_" + str, a2).commit();
    }

    public void a(String str, String str2, String str3) {
        this.f63a.a(str, str2, str3);
    }

    public void a(boolean z) {
        this.f63a.a(z);
        a(this.f62a).edit().putBoolean("paused", z).commit();
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m84a() {
        return !TextUtils.equals(com.xiaomi.push.g.m291a(this.f62a, this.f62a.getPackageName()), this.f63a.e);
    }

    public boolean a(String str, String str2) {
        return this.f63a.m94a(str, str2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m85a(String str, String str2, String str3) {
        a a2 = a(str3);
        return a2 != null && TextUtils.equals(str, a2.f67a) && TextUtils.equals(str2, a2.b);
    }

    public String b() {
        return this.f63a.b;
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m86b() {
        this.f63a.b();
    }

    public void b(String str) {
        this.f65a.remove(str);
        a(this.f62a).edit().remove("hybrid_app_info_" + str).commit();
    }

    public void b(String str, String str2, String str3) {
        this.f63a.b(str, str2, str3);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m87b() {
        if (this.f63a.m93a()) {
            return true;
        }
        com.xiaomi.channel.commonutils.logger.b.m42a("Don't send message before initialization succeeded!");
        return false;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m88c() {
        return this.f63a.c;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m89c() {
        return this.f63a.m93a();
    }

    public String d() {
        return this.f63a.d;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m90d() {
        return this.f63a.f69b;
    }

    public String e() {
        return this.f63a.g;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m91e() {
        return !this.f63a.f68a;
    }

    public String f() {
        return this.f63a.h;
    }
}
