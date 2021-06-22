package d.a.k0.e;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.mapapi.UIMsg;
import com.baidu.mobstat.Config;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class i {
    public static String k = "";
    public static String l = "";
    public static String m = "";
    public static String n = "";
    public static String o = "";
    public static String p = "";
    public static String q;
    public static String r;

    /* renamed from: a  reason: collision with root package name */
    public Context f44198a;

    /* renamed from: b  reason: collision with root package name */
    public String f44199b;

    /* renamed from: c  reason: collision with root package name */
    public int f44200c;

    /* renamed from: d  reason: collision with root package name */
    public int f44201d;

    /* renamed from: e  reason: collision with root package name */
    public String f44202e;

    /* renamed from: f  reason: collision with root package name */
    public long f44203f;

    /* renamed from: g  reason: collision with root package name */
    public String f44204g;

    /* renamed from: h  reason: collision with root package name */
    public String f44205h;

    /* renamed from: i  reason: collision with root package name */
    public long f44206i;
    public long j = 8000;

    public i(Context context) {
        this.f44198a = context;
    }

    public static void j(String str, String str2, String str3) {
        if (TextUtils.equals(str, "cm")) {
            k = str2;
            l = str3;
        } else if (TextUtils.equals(str, Config.EXCEPTION_CRASH_TYPE)) {
            m = str2;
            n = str3;
        } else if (TextUtils.equals(str, "cu")) {
            o = str2;
            p = str3;
        }
    }

    public String a(String str) {
        try {
            if (!TextUtils.isEmpty(str) && str.length() == 11 && str.contains("*") && str.charAt(3) == '*') {
                int g0 = d.a.k0.b.a.h(this.f44198a).g0();
                if (g0 <= 11 - str.replace("*", "").trim().length()) {
                    return str;
                }
                char[] charArray = str.toCharArray();
                StringBuilder sb = new StringBuilder();
                int i2 = g0 + 3;
                for (int i3 = 0; i3 < charArray.length; i3++) {
                    if (i3 < 3) {
                        sb.append(charArray[i3]);
                    } else if (i3 < i2) {
                        sb.append("*");
                    } else {
                        sb.append(charArray[i3]);
                    }
                }
                return sb.toString();
            }
            return str;
        } catch (Throwable th) {
            d.a.k0.l.c.d(th);
            return str;
        }
    }

    public void b(int i2) {
        try {
            if (d.a.k0.c.a.c().h(i2)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("0", this.f44200c);
                jSONObject.put("1", this.f44202e);
                jSONObject.put("3", this.f44199b);
                jSONObject.put("4", d.a.k0.l.d.j(this.f44198a));
                if (!TextUtils.isEmpty(this.f44204g)) {
                    jSONObject.put("5", d.a.k0.l.e.c(this.f44204g.getBytes(), d.a.k0.b.a.h(this.f44198a).k0()));
                }
                jSONObject.put("6", q);
                String c2 = d.a.k0.b.c.b(this.f44198a).c(jSONObject, this.j);
                if (d.a.k0.c.a.c().h(i2)) {
                    if (!TextUtils.isEmpty(c2)) {
                        s();
                        JSONObject jSONObject2 = new JSONObject(c2);
                        int optInt = jSONObject2.optInt("0", -1);
                        d.a.k0.b.a.h(this.f44198a).A(System.currentTimeMillis());
                        if (optInt == 0) {
                            d.a.k0.b.a.h(this.f44198a).k(0);
                            JSONObject optJSONObject = new JSONObject(jSONObject2.optString("1")).optJSONObject("data");
                            f(i2, 0, 0, this.f44200c, jSONObject2.optString("1"), optInt, optJSONObject != null ? optJSONObject.optString("uk") : "");
                            return;
                        }
                        d.a.k0.b.a.h(this.f44198a).k(4);
                        f(i2, 4, a.a(optInt), this.f44200c, jSONObject2.optString("1"), optInt, "");
                        return;
                    }
                    f(i2, 4, 2005, this.f44200c, "server req empty.", -1, "");
                }
            }
        } catch (Throwable th) {
            d.a.k0.l.c.d(th);
            d(i2, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, this.f44200c, "post token unknown error.");
        }
    }

    public void c(int i2, int i3) {
        Message message = new Message();
        message.what = i2;
        message.arg1 = this.f44200c;
        message.arg2 = i3;
        d.a().c(message, this.j);
    }

    public void d(int i2, int i3, int i4, int i5, String str) {
        f(i2, i3, i4, i5, str, -1, "");
    }

    public synchronized void e(int i2, int i3, int i4, int i5, String str, int i6) {
        b bVar = new b();
        bVar.f44119a = i6;
        c.j().c(i2, i3, i4, i5, str, bVar, true);
    }

    public synchronized void f(int i2, int i3, int i4, int i5, String str, int i6, String str2) {
        b bVar = new b();
        bVar.f44119a = 2;
        bVar.f44121c = i6;
        bVar.f44122d = str2;
        c.j().c(i2, i3, i4, i5, str, bVar, true);
    }

    public void g(int i2, int i3, String str) {
        if (d.a.k0.c.a.c().h(i2)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("0", i3);
                jSONObject.put("1", str);
                String e2 = d.a.k0.b.c.b(this.f44198a).e(jSONObject, this.j);
                if (d.a.k0.c.a.c().h(i2)) {
                    if (TextUtils.isEmpty(e2)) {
                        m(i2, 4, 2005, this.f44200c, "server req empty.");
                    } else {
                        t();
                        JSONObject jSONObject2 = new JSONObject(e2);
                        int optInt = jSONObject2.optInt("0", -1);
                        String optString = jSONObject2.optString("1");
                        d.a.k0.b.a.h(this.f44198a).K(System.currentTimeMillis());
                        if (optInt == 0) {
                            d.a.k0.b.a.h(this.f44198a).q(0);
                            n(i2, 0, 0, this.f44200c, optString, optInt, "");
                        } else {
                            int a2 = a.a(optInt);
                            d.a.k0.b.a.h(this.f44198a).q(4);
                            n(i2, 4, a2, this.f44200c, optString, optInt, "");
                        }
                    }
                }
            } catch (Throwable th) {
                d.a.k0.l.c.d(th);
                m(i2, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, this.f44200c, "post token unknown error.");
            }
        }
    }

    public void h(Context context, int i2) {
        q = UUID.randomUUID().toString();
        d.a.k0.b.c.b(context).f();
        s();
    }

    public void i(Context context, int i2, long j) {
        this.j = j;
    }

    public boolean k() {
        return false;
    }

    public void l(int i2) {
        this.f44201d = i2;
    }

    public void m(int i2, int i3, int i4, int i5, String str) {
        n(i2, i3, i4, i5, str, -1, "");
    }

    public void n(int i2, int i3, int i4, int i5, String str, int i6, String str2) {
        b bVar = new b();
        bVar.f44119a = 4;
        bVar.f44121c = i6;
        bVar.f44122d = str2;
        c.j().c(i2, i3, i4, i5, str, bVar, true);
    }

    public void o(Context context, int i2) {
        r = UUID.randomUUID().toString();
        d.a.k0.b.c.b(context).f();
        t();
    }

    public void p(Context context, int i2, long j) {
        d.a.k0.b.c.b(context).f();
    }

    public boolean q() {
        return false;
    }

    public boolean r() {
        int i2 = this.f44200c;
        return i2 == 1 ? (TextUtils.isEmpty(k) || TextUtils.isEmpty(l)) ? false : true : i2 == 3 ? (TextUtils.isEmpty(m) || TextUtils.isEmpty(n)) ? false : true : (i2 != 2 || TextUtils.isEmpty(o) || TextUtils.isEmpty(p)) ? false : true;
    }

    public void s() {
        this.f44202e = null;
        this.f44203f = 0L;
        this.f44204g = null;
    }

    public void t() {
        this.f44205h = null;
        this.f44206i = 0L;
    }

    public String toString() {
        return getClass().getSimpleName();
    }
}
