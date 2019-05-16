package com.xiaomi.metoknlp;

import android.content.Context;
import android.content.SharedPreferences;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    private static boolean a = false;
    private static int b = 0;
    private static b c = null;
    private Context d;
    private SharedPreferences e;
    private List f = new ArrayList();

    private b(Context context) {
        this.d = context;
        this.e = this.d.getSharedPreferences("config", 0);
    }

    public static b a() {
        return c;
    }

    public static synchronized void a(Context context) {
        synchronized (b.class) {
            if (c == null) {
                c = new b(context);
            }
        }
    }

    public static boolean b() {
        return false;
    }

    public void a(g gVar) {
        if (gVar != null) {
            synchronized (this.f) {
                this.f.add(gVar);
            }
        }
    }

    public void a(String str) {
        SharedPreferences.Editor edit = this.e.edit();
        edit.putString("config_update_time", str);
        edit.commit();
    }

    public void c() {
        synchronized (this.f) {
            for (g gVar : this.f) {
                gVar.a();
            }
        }
    }

    public void d() {
        String a2;
        int i = 0;
        String k = k();
        String h = com.xiaomi.metoknlp.a.e.h();
        if (k.equals(h)) {
            return;
        }
        String d = com.xiaomi.metoknlp.a.e.d();
        String a3 = c.a("collect", "t_" + d);
        if (a3 == null || a3.isEmpty()) {
            int i2 = 0;
            do {
                a2 = c.a("collect", "t_" + d);
                if (a2 != null && !a2.isEmpty()) {
                    break;
                }
                i2++;
            } while (i2 != 5);
            if (i2 == 5) {
                return;
            }
            a3 = a2;
        }
        try {
            JSONObject jSONObject = new JSONObject(new JSONObject(a3).getString("data"));
            String string = this.e.getString("s_f", "");
            String optString = jSONObject.optString("s_f", "");
            boolean a4 = com.xiaomi.metoknlp.a.e.a(jSONObject.optInt("f_d_d", 0));
            SharedPreferences.Editor edit = this.e.edit();
            edit.putString("s_f", optString);
            edit.putBoolean("f_d_d", a4);
            edit.putString("m_s_u", jSONObject.optString("m_s_u", "https://metok.sys.miui.com"));
            edit.commit();
            new Date();
            new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmm");
            if (string != null && !string.isEmpty() && optString != null && !optString.isEmpty()) {
                Date parse = simpleDateFormat.parse(string);
                Date parse2 = simpleDateFormat.parse(optString);
                if (parse2.before(parse) || parse2.equals(parse)) {
                    a(h);
                    c();
                    return;
                }
            }
            String a5 = c.a("collect", "f_" + d);
            if (a5 == null || a5.isEmpty()) {
                do {
                    a5 = c.a("collect", "f_" + d);
                    if (a5 != null && !a5.isEmpty()) {
                        break;
                    }
                    i++;
                } while (i != 5);
                if (i == 5) {
                    return;
                }
            }
            try {
                JSONObject jSONObject2 = new JSONObject(new JSONObject(a5).getString("data"));
                SharedPreferences.Editor edit2 = this.e.edit();
                edit2.putLong("d_m_i", jSONObject2.optLong("d_m_i", Long.MAX_VALUE));
                edit2.putBoolean("d_n_s", com.xiaomi.metoknlp.a.e.a(jSONObject2.optInt("d_n_s", b)));
                edit2.putLong("d_s_t", jSONObject2.optLong("d_s_t", Long.MAX_VALUE));
                edit2.putLong("d_s_c_t", jSONObject2.optLong("d_s_c_t", Long.MAX_VALUE));
                edit2.commit();
                a(h);
                c();
            } catch (Exception e) {
            }
        } catch (Exception e2) {
        }
    }

    public String e() {
        return this.e.getString("m_s_u", "https://metok.sys.miui.com");
    }

    public boolean f() {
        return this.e.getBoolean("f_d_d", true);
    }

    public long g() {
        return this.e.getLong("d_m_i", Long.MAX_VALUE);
    }

    public boolean h() {
        return this.e.getBoolean("d_n_s", a);
    }

    public long i() {
        return this.e.getLong("d_s_t", Long.MAX_VALUE);
    }

    public long j() {
        return this.e.getLong("d_s_c_t", Long.MAX_VALUE);
    }

    public String k() {
        return this.e.getString("config_update_time", "0");
    }
}
