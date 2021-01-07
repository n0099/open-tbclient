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
    private static volatile b f14119a;

    /* renamed from: a  reason: collision with other field name */
    private Context f142a;

    /* renamed from: a  reason: collision with other field name */
    private a f143a;

    /* renamed from: a  reason: collision with other field name */
    String f144a;

    /* renamed from: a  reason: collision with other field name */
    private Map<String, a> f145a;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with other field name */
        private Context f146a;

        /* renamed from: a  reason: collision with other field name */
        public String f147a;

        /* renamed from: b  reason: collision with root package name */
        public String f14121b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;

        /* renamed from: a  reason: collision with other field name */
        public boolean f148a = true;

        /* renamed from: b  reason: collision with other field name */
        public boolean f149b = false;

        /* renamed from: a  reason: collision with root package name */
        public int f14120a = 1;

        public a(Context context) {
            this.f146a = context;
        }

        public static a a(Context context, String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                a aVar = new a(context);
                aVar.f147a = jSONObject.getString("appId");
                aVar.f14121b = jSONObject.getString("appToken");
                aVar.c = jSONObject.getString("regId");
                aVar.d = jSONObject.getString("regSec");
                aVar.f = jSONObject.getString("devId");
                aVar.e = jSONObject.getString("vName");
                aVar.f148a = jSONObject.getBoolean(CloudControlUBCUtils.KEY_VALID);
                aVar.f149b = jSONObject.getBoolean("paused");
                aVar.f14120a = jSONObject.getInt("envType");
                aVar.g = jSONObject.getString("regResource");
                return aVar;
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.a(th);
                return null;
            }
        }

        private String a() {
            return com.xiaomi.push.g.m337a(this.f146a, this.f146a.getPackageName());
        }

        public static String a(a aVar) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("appId", aVar.f147a);
                jSONObject.put("appToken", aVar.f14121b);
                jSONObject.put("regId", aVar.c);
                jSONObject.put("regSec", aVar.d);
                jSONObject.put("devId", aVar.f);
                jSONObject.put("vName", aVar.e);
                jSONObject.put(CloudControlUBCUtils.KEY_VALID, aVar.f148a);
                jSONObject.put("paused", aVar.f149b);
                jSONObject.put("envType", aVar.f14120a);
                jSONObject.put("regResource", aVar.g);
                return jSONObject.toString();
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.a(th);
                return null;
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m136a() {
            b.a(this.f146a).edit().clear().commit();
            this.f147a = null;
            this.f14121b = null;
            this.c = null;
            this.d = null;
            this.f = null;
            this.e = null;
            this.f148a = false;
            this.f149b = false;
            this.h = null;
            this.f14120a = 1;
        }

        public void a(int i) {
            this.f14120a = i;
        }

        public void a(String str, String str2) {
            this.c = str;
            this.d = str2;
            this.f = com.xiaomi.push.i.l(this.f146a);
            this.e = a();
            this.f148a = true;
        }

        public void a(String str, String str2, String str3) {
            this.f147a = str;
            this.f14121b = str2;
            this.g = str3;
            SharedPreferences.Editor edit = b.a(this.f146a).edit();
            edit.putString("appId", this.f147a);
            edit.putString("appToken", str2);
            edit.putString("regResource", str3);
            edit.commit();
        }

        public void a(boolean z) {
            this.f149b = z;
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m137a() {
            return m138a(this.f147a, this.f14121b);
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m138a(String str, String str2) {
            return TextUtils.equals(this.f147a, str) && TextUtils.equals(this.f14121b, str2) && !TextUtils.isEmpty(this.c) && !TextUtils.isEmpty(this.d) && (TextUtils.equals(this.f, com.xiaomi.push.i.l(this.f146a)) || TextUtils.equals(this.f, com.xiaomi.push.i.k(this.f146a)));
        }

        public void b() {
            this.f148a = false;
            b.a(this.f146a).edit().putBoolean(CloudControlUBCUtils.KEY_VALID, this.f148a).commit();
        }

        public void b(String str, String str2, String str3) {
            this.c = str;
            this.d = str2;
            this.f = com.xiaomi.push.i.l(this.f146a);
            this.e = a();
            this.f148a = true;
            this.h = str3;
            SharedPreferences.Editor edit = b.a(this.f146a).edit();
            edit.putString("regId", str);
            edit.putString("regSec", str2);
            edit.putString("devId", this.f);
            edit.putString("vName", a());
            edit.putBoolean(CloudControlUBCUtils.KEY_VALID, true);
            edit.putString("appRegion", str3);
            edit.commit();
        }

        public void c(String str, String str2, String str3) {
            this.f147a = str;
            this.f14121b = str2;
            this.g = str3;
        }
    }

    private b(Context context) {
        this.f142a = context;
        c();
    }

    public static SharedPreferences a(Context context) {
        return context.getSharedPreferences("mipush", 0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static b m124a(Context context) {
        if (f14119a == null) {
            synchronized (b.class) {
                if (f14119a == null) {
                    f14119a = new b(context);
                }
            }
        }
        return f14119a;
    }

    private void c() {
        this.f143a = new a(this.f142a);
        this.f145a = new HashMap();
        SharedPreferences a2 = a(this.f142a);
        this.f143a.f147a = a2.getString("appId", null);
        this.f143a.f14121b = a2.getString("appToken", null);
        this.f143a.c = a2.getString("regId", null);
        this.f143a.d = a2.getString("regSec", null);
        this.f143a.f = a2.getString("devId", null);
        if (!TextUtils.isEmpty(this.f143a.f) && com.xiaomi.push.i.m421a(this.f143a.f)) {
            this.f143a.f = com.xiaomi.push.i.l(this.f142a);
            a2.edit().putString("devId", this.f143a.f).commit();
        }
        this.f143a.e = a2.getString("vName", null);
        this.f143a.f148a = a2.getBoolean(CloudControlUBCUtils.KEY_VALID, true);
        this.f143a.f149b = a2.getBoolean("paused", false);
        this.f143a.f14120a = a2.getInt("envType", 1);
        this.f143a.g = a2.getString("regResource", null);
        this.f143a.h = a2.getString("appRegion", null);
    }

    public int a() {
        return this.f143a.f14120a;
    }

    public a a(String str) {
        if (this.f145a.containsKey(str)) {
            return this.f145a.get(str);
        }
        String str2 = "hybrid_app_info_" + str;
        SharedPreferences a2 = a(this.f142a);
        if (a2.contains(str2)) {
            a a3 = a.a(this.f142a, a2.getString(str2, ""));
            this.f145a.put(str2, a3);
            return a3;
        }
        return null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m125a() {
        return this.f143a.f147a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m126a() {
        this.f143a.m136a();
    }

    public void a(int i) {
        this.f143a.a(i);
        a(this.f142a).edit().putInt("envType", i).commit();
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m127a(String str) {
        SharedPreferences.Editor edit = a(this.f142a).edit();
        edit.putString("vName", str);
        edit.commit();
        this.f143a.e = str;
    }

    public void a(String str, a aVar) {
        this.f145a.put(str, aVar);
        String a2 = a.a(aVar);
        a(this.f142a).edit().putString("hybrid_app_info_" + str, a2).commit();
    }

    public void a(String str, String str2, String str3) {
        this.f143a.a(str, str2, str3);
    }

    public void a(boolean z) {
        this.f143a.a(z);
        a(this.f142a).edit().putBoolean("paused", z).commit();
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m128a() {
        return !TextUtils.equals(com.xiaomi.push.g.m337a(this.f142a, this.f142a.getPackageName()), this.f143a.e);
    }

    public boolean a(String str, String str2) {
        return this.f143a.m138a(str, str2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m129a(String str, String str2, String str3) {
        a a2 = a(str3);
        return a2 != null && TextUtils.equals(str, a2.f147a) && TextUtils.equals(str2, a2.f14121b);
    }

    public String b() {
        return this.f143a.f14121b;
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m130b() {
        this.f143a.b();
    }

    public void b(String str) {
        this.f145a.remove(str);
        a(this.f142a).edit().remove("hybrid_app_info_" + str).commit();
    }

    public void b(String str, String str2, String str3) {
        this.f143a.b(str, str2, str3);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m131b() {
        if (this.f143a.m137a()) {
            return true;
        }
        com.xiaomi.channel.commonutils.logger.b.m84a("Don't send message before initialization succeeded!");
        return false;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m132c() {
        return this.f143a.c;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m133c() {
        return this.f143a.m137a();
    }

    public String d() {
        return this.f143a.d;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m134d() {
        return this.f143a.f149b;
    }

    public String e() {
        return this.f143a.g;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m135e() {
        return !this.f143a.f148a;
    }

    public String f() {
        return this.f143a.h;
    }
}
