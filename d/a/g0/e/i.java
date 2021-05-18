package d.a.g0.e;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.mapapi.UIMsg;
import com.baidu.mobstat.Config;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class i {
    public static String k = "";
    public static String l = "";
    public static String m = "";
    public static String n = "";
    public static String o = "";
    public static String p = "";
    public static int q;
    public static int r;

    /* renamed from: a  reason: collision with root package name */
    public Context f40118a;

    /* renamed from: b  reason: collision with root package name */
    public String f40119b;

    /* renamed from: c  reason: collision with root package name */
    public int f40120c;

    /* renamed from: d  reason: collision with root package name */
    public int f40121d;

    /* renamed from: e  reason: collision with root package name */
    public String f40122e;

    /* renamed from: f  reason: collision with root package name */
    public long f40123f;

    /* renamed from: g  reason: collision with root package name */
    public String f40124g;

    /* renamed from: h  reason: collision with root package name */
    public String f40125h;

    /* renamed from: i  reason: collision with root package name */
    public long f40126i;
    public long j = 8000;

    public i(Context context) {
        this.f40118a = context;
    }

    public static void i(String str, String str2, String str3) {
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

    public void a(int i2) {
        try {
            if (d.a.g0.c.a.c().h(i2)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("0", this.f40120c);
                jSONObject.put("1", this.f40122e);
                jSONObject.put("3", this.f40119b);
                jSONObject.put("4", d.a.g0.l.d.l(this.f40118a));
                if (!TextUtils.isEmpty(this.f40124g)) {
                    jSONObject.put("5", d.a.g0.l.e.c(this.f40124g.getBytes(), d.a.g0.b.a.g(this.f40118a).h0()));
                }
                jSONObject.put("6", q);
                String c2 = d.a.g0.b.c.b(this.f40118a).c(jSONObject, this.j);
                if (d.a.g0.c.a.c().h(i2)) {
                    if (!TextUtils.isEmpty(c2)) {
                        r();
                        JSONObject jSONObject2 = new JSONObject(c2);
                        int optInt = jSONObject2.optInt("0", -1);
                        d.a.g0.b.a.g(this.f40118a).y(System.currentTimeMillis());
                        if (optInt == 0) {
                            d.a.g0.b.a.g(this.f40118a).j(0);
                            JSONObject optJSONObject = new JSONObject(jSONObject2.optString("1")).optJSONObject("data");
                            e(i2, 0, 0, this.f40120c, jSONObject2.optString("1"), optInt, optJSONObject != null ? optJSONObject.optString("uk") : "");
                            return;
                        }
                        d.a.g0.b.a.g(this.f40118a).j(4);
                        e(i2, 4, a.a(optInt), this.f40120c, jSONObject2.optString("1"), optInt, "");
                        return;
                    }
                    e(i2, 4, 2005, this.f40120c, "server req empty.", -1, "");
                }
            }
        } catch (Throwable th) {
            d.a.g0.l.c.d(th);
            c(i2, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, this.f40120c, "post token unknown error.");
        }
    }

    public void b(int i2, int i3) {
        Message message = new Message();
        message.what = i2;
        message.arg1 = this.f40120c;
        message.arg2 = i3;
        d.a().c(message, this.j);
    }

    public void c(int i2, int i3, int i4, int i5, String str) {
        e(i2, i3, i4, i5, str, -1, "");
    }

    public synchronized void d(int i2, int i3, int i4, int i5, String str, int i6) {
        b bVar = new b();
        bVar.f40040a = i6;
        c.i().c(i2, i3, i4, i5, str, bVar, true);
    }

    public synchronized void e(int i2, int i3, int i4, int i5, String str, int i6, String str2) {
        b bVar = new b();
        bVar.f40040a = 2;
        bVar.f40042c = i6;
        bVar.f40043d = str2;
        c.i().c(i2, i3, i4, i5, str, bVar, true);
    }

    public void f(int i2, int i3, String str) {
        if (d.a.g0.c.a.c().h(i2)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("0", i3);
                jSONObject.put("1", str);
                String e2 = d.a.g0.b.c.b(this.f40118a).e(jSONObject, this.j);
                if (d.a.g0.c.a.c().h(i2)) {
                    if (TextUtils.isEmpty(e2)) {
                        l(i2, 4, 2005, this.f40120c, "server req empty.");
                    } else {
                        s();
                        JSONObject jSONObject2 = new JSONObject(e2);
                        int optInt = jSONObject2.optInt("0", -1);
                        String optString = jSONObject2.optString("1");
                        d.a.g0.b.a.g(this.f40118a).I(System.currentTimeMillis());
                        if (optInt == 0) {
                            d.a.g0.b.a.g(this.f40118a).p(0);
                            m(i2, 0, 0, this.f40120c, optString, optInt, "");
                        } else {
                            int a2 = a.a(optInt);
                            d.a.g0.b.a.g(this.f40118a).p(4);
                            m(i2, 4, a2, this.f40120c, optString, optInt, "");
                        }
                    }
                }
            } catch (Throwable th) {
                d.a.g0.l.c.d(th);
                l(i2, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, this.f40120c, "post token unknown error.");
            }
        }
    }

    public void g(Context context, int i2) {
        q = (int) (System.currentTimeMillis() / 1000);
        d.a.g0.b.c.b(context).f();
        r();
    }

    public void h(Context context, int i2, long j) {
        this.j = j;
    }

    public boolean j() {
        return false;
    }

    public void k(int i2) {
        this.f40121d = i2;
    }

    public void l(int i2, int i3, int i4, int i5, String str) {
        m(i2, i3, i4, i5, str, -1, "");
    }

    public void m(int i2, int i3, int i4, int i5, String str, int i6, String str2) {
        b bVar = new b();
        bVar.f40040a = 4;
        bVar.f40042c = i6;
        bVar.f40043d = str2;
        c.i().c(i2, i3, i4, i5, str, bVar, true);
    }

    public void n(Context context, int i2) {
        r = (int) (System.currentTimeMillis() / 1000);
        d.a.g0.b.c.b(context).f();
        s();
    }

    public void o(Context context, int i2, long j) {
        d.a.g0.b.c.b(context).f();
    }

    public boolean p() {
        return false;
    }

    public boolean q() {
        int i2 = this.f40120c;
        return i2 == 1 ? (TextUtils.isEmpty(k) || TextUtils.isEmpty(l)) ? false : true : i2 == 3 ? (TextUtils.isEmpty(m) || TextUtils.isEmpty(n)) ? false : true : (i2 != 2 || TextUtils.isEmpty(o) || TextUtils.isEmpty(p)) ? false : true;
    }

    public void r() {
        this.f40122e = null;
        this.f40123f = 0L;
        this.f40124g = null;
    }

    public void s() {
        this.f40125h = null;
        this.f40126i = 0L;
    }

    public String toString() {
        return getClass().getSimpleName();
    }
}
