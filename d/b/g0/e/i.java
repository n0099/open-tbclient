package d.b.g0.e;

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
    public Context f43623a;

    /* renamed from: b  reason: collision with root package name */
    public String f43624b;

    /* renamed from: c  reason: collision with root package name */
    public int f43625c;

    /* renamed from: d  reason: collision with root package name */
    public int f43626d;

    /* renamed from: e  reason: collision with root package name */
    public String f43627e;

    /* renamed from: f  reason: collision with root package name */
    public long f43628f;

    /* renamed from: g  reason: collision with root package name */
    public String f43629g;

    /* renamed from: h  reason: collision with root package name */
    public String f43630h;
    public long i;
    public long j = 8000;

    public i(Context context) {
        this.f43623a = context;
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

    public void a(int i) {
        try {
            if (d.b.g0.c.a.c().h(i)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("0", this.f43625c);
                jSONObject.put("1", this.f43627e);
                jSONObject.put("3", this.f43624b);
                jSONObject.put("4", d.b.g0.l.d.l(this.f43623a));
                if (!TextUtils.isEmpty(this.f43629g)) {
                    jSONObject.put("5", d.b.g0.l.e.c(this.f43629g.getBytes(), d.b.g0.b.a.g(this.f43623a).h0()));
                }
                jSONObject.put("6", q);
                String c2 = d.b.g0.b.c.b(this.f43623a).c(jSONObject, this.j);
                if (d.b.g0.c.a.c().h(i)) {
                    if (!TextUtils.isEmpty(c2)) {
                        r();
                        JSONObject jSONObject2 = new JSONObject(c2);
                        int optInt = jSONObject2.optInt("0", -1);
                        d.b.g0.b.a.g(this.f43623a).y(System.currentTimeMillis());
                        if (optInt == 0) {
                            d.b.g0.b.a.g(this.f43623a).j(0);
                            JSONObject optJSONObject = new JSONObject(jSONObject2.optString("1")).optJSONObject("data");
                            e(i, 0, 0, this.f43625c, jSONObject2.optString("1"), optInt, optJSONObject != null ? optJSONObject.optString("uk") : "");
                            return;
                        }
                        d.b.g0.b.a.g(this.f43623a).j(4);
                        e(i, 4, a.a(optInt), this.f43625c, jSONObject2.optString("1"), optInt, "");
                        return;
                    }
                    e(i, 4, 2005, this.f43625c, "server req empty.", -1, "");
                }
            }
        } catch (Throwable th) {
            d.b.g0.l.c.d(th);
            c(i, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, this.f43625c, "post token unknown error.");
        }
    }

    public void b(int i, int i2) {
        Message message = new Message();
        message.what = i;
        message.arg1 = this.f43625c;
        message.arg2 = i2;
        d.a().c(message, this.j);
    }

    public void c(int i, int i2, int i3, int i4, String str) {
        e(i, i2, i3, i4, str, -1, "");
    }

    public synchronized void d(int i, int i2, int i3, int i4, String str, int i5) {
        b bVar = new b();
        bVar.f43550a = i5;
        c.i().c(i, i2, i3, i4, str, bVar, true);
    }

    public synchronized void e(int i, int i2, int i3, int i4, String str, int i5, String str2) {
        b bVar = new b();
        bVar.f43550a = 2;
        bVar.f43552c = i5;
        bVar.f43553d = str2;
        c.i().c(i, i2, i3, i4, str, bVar, true);
    }

    public void f(int i, int i2, String str) {
        if (d.b.g0.c.a.c().h(i)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("0", i2);
                jSONObject.put("1", str);
                String e2 = d.b.g0.b.c.b(this.f43623a).e(jSONObject, this.j);
                if (d.b.g0.c.a.c().h(i)) {
                    if (TextUtils.isEmpty(e2)) {
                        l(i, 4, 2005, this.f43625c, "server req empty.");
                    } else {
                        s();
                        JSONObject jSONObject2 = new JSONObject(e2);
                        int optInt = jSONObject2.optInt("0", -1);
                        String optString = jSONObject2.optString("1");
                        d.b.g0.b.a.g(this.f43623a).I(System.currentTimeMillis());
                        if (optInt == 0) {
                            d.b.g0.b.a.g(this.f43623a).p(0);
                            m(i, 0, 0, this.f43625c, optString, optInt, "");
                        } else {
                            int a2 = a.a(optInt);
                            d.b.g0.b.a.g(this.f43623a).p(4);
                            m(i, 4, a2, this.f43625c, optString, optInt, "");
                        }
                    }
                }
            } catch (Throwable th) {
                d.b.g0.l.c.d(th);
                l(i, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, this.f43625c, "post token unknown error.");
            }
        }
    }

    public void g(Context context, int i) {
        q = (int) (System.currentTimeMillis() / 1000);
        d.b.g0.b.c.b(context).f();
        r();
    }

    public void h(Context context, int i, long j) {
        this.j = j;
    }

    public boolean j() {
        return false;
    }

    public void k(int i) {
        this.f43626d = i;
    }

    public void l(int i, int i2, int i3, int i4, String str) {
        m(i, i2, i3, i4, str, -1, "");
    }

    public void m(int i, int i2, int i3, int i4, String str, int i5, String str2) {
        b bVar = new b();
        bVar.f43550a = 4;
        bVar.f43552c = i5;
        bVar.f43553d = str2;
        c.i().c(i, i2, i3, i4, str, bVar, true);
    }

    public void n(Context context, int i) {
        r = (int) (System.currentTimeMillis() / 1000);
        d.b.g0.b.c.b(context).f();
        s();
    }

    public void o(Context context, int i, long j) {
        d.b.g0.b.c.b(context).f();
    }

    public boolean p() {
        return false;
    }

    public boolean q() {
        int i = this.f43625c;
        return i == 1 ? (TextUtils.isEmpty(k) || TextUtils.isEmpty(l)) ? false : true : i == 3 ? (TextUtils.isEmpty(m) || TextUtils.isEmpty(n)) ? false : true : (i != 2 || TextUtils.isEmpty(o) || TextUtils.isEmpty(p)) ? false : true;
    }

    public void r() {
        this.f43627e = null;
        this.f43628f = 0L;
        this.f43629g = null;
    }

    public void s() {
        this.f43630h = null;
        this.i = 0L;
    }

    public String toString() {
        return getClass().getSimpleName();
    }
}
