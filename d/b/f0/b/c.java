package d.b.f0.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.xiaomi.mipush.sdk.Constants;
import d.b.f0.e.i;
import d.b.f0.k.e;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static volatile c f43220b = null;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f43221c = false;

    /* renamed from: a  reason: collision with root package name */
    public Context f43222a;

    /* loaded from: classes2.dex */
    public class a extends d.b.f0.k.c {
        public a() {
        }

        @Override // d.b.f0.k.c
        public void b() {
            try {
                String b2 = new d.b.f0.f.d(c.this.f43222a, null).b();
                if (TextUtils.isEmpty(b2)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject(b2);
                if (jSONObject.optInt("0") == 0) {
                    c.f43221c = jSONObject.optInt("1") == 2;
                }
            } catch (Throwable th) {
                d.b.f0.l.c.d(th);
            }
        }
    }

    public c(Context context) {
        this.f43222a = context;
    }

    public static c b(Context context) {
        if (f43220b == null) {
            synchronized (c.class) {
                if (f43220b == null) {
                    f43220b = new c(context);
                }
            }
        }
        return f43220b;
    }

    public String c(JSONObject jSONObject, long j) {
        if (jSONObject != null) {
            try {
                if (jSONObject.length() != 0) {
                    String d2 = new d.b.f0.f.d(this.f43222a, null).d(jSONObject, j);
                    if (!TextUtils.isEmpty(d2)) {
                        return d2;
                    }
                }
            } catch (Throwable th) {
                d.b.f0.l.c.d(th);
            }
        }
        return "";
    }

    public void d() {
        e.c().b(new a());
    }

    public String e(JSONObject jSONObject, long j) {
        if (jSONObject != null) {
            try {
                if (jSONObject.length() != 0) {
                    String i = new d.b.f0.f.d(this.f43222a, null).i(jSONObject, j);
                    if (!TextUtils.isEmpty(i)) {
                        return i;
                    }
                }
            } catch (Throwable th) {
                d.b.f0.l.c.d(th);
            }
        }
        return "";
    }

    public synchronized boolean f() {
        try {
            if (g()) {
                return true;
            }
            d.b.f0.f.d dVar = new d.b.f0.f.d(this.f43222a, null);
            String h2 = dVar.h();
            if (TextUtils.isEmpty(h2)) {
                for (int i = 0; i < 3; i++) {
                    h2 = dVar.h();
                    if (!TextUtils.isEmpty(h2)) {
                        break;
                    }
                }
            }
            if (TextUtils.isEmpty(h2)) {
                return false;
            }
            JSONObject jSONObject = new JSONObject(h2);
            int optInt = jSONObject.optInt("0", -1);
            if (optInt == 2) {
                d.b.f0.b.a.g(this.f43222a).L(false);
            } else {
                d.b.f0.b.a.g(this.f43222a).L(true);
            }
            if (optInt == 1 || optInt == 3) {
                return true;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("1");
            if (optJSONObject == null) {
                return false;
            }
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("yd_config");
            if (optJSONObject2 != null) {
                String optString = optJSONObject2.optString(Constants.APP_ID);
                String optString2 = optJSONObject2.optString(com.alipay.sdk.cons.b.f1883h);
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                    i.i("cm", optString, optString2);
                }
                int optInt2 = optJSONObject2.optInt("status", -1);
                if (optInt2 == 1) {
                    d.b.f0.b.a.g(this.f43222a).m(true);
                } else if (optInt2 == 2) {
                    d.b.f0.b.a.g(this.f43222a).m(false);
                }
                d.b.f0.b.a.g(this.f43222a).W(optJSONObject2.toString());
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("dx_config");
            if (optJSONObject3 != null) {
                String optString3 = optJSONObject3.optString(Constants.APP_ID);
                String optString4 = optJSONObject3.optString(com.alipay.sdk.cons.b.f1883h);
                if (!TextUtils.isEmpty(optString3) && !TextUtils.isEmpty(optString4)) {
                    i.i(Config.EXCEPTION_CRASH_TYPE, optString3, optString4);
                }
                int optInt3 = optJSONObject3.optInt("status", -1);
                if (optInt3 == 1) {
                    d.b.f0.b.a.g(this.f43222a).w(true);
                } else if (optInt3 == 2) {
                    d.b.f0.b.a.g(this.f43222a).w(false);
                }
                d.b.f0.b.a.g(this.f43222a).z(optJSONObject3.toString());
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("lt_config");
            if (optJSONObject4 != null) {
                String optString5 = optJSONObject4.optString(Constants.APP_ID);
                String optString6 = optJSONObject4.optString(com.alipay.sdk.cons.b.f1883h);
                if (!TextUtils.isEmpty(optString5) && !TextUtils.isEmpty(optString6)) {
                    i.i("cu", optString5, optString6);
                }
                int optInt4 = optJSONObject4.optInt("status", -1);
                if (optInt4 == 1) {
                    d.b.f0.b.a.g(this.f43222a).B(true);
                } else if (optInt4 == 2) {
                    d.b.f0.b.a.g(this.f43222a).B(false);
                }
                d.b.f0.b.a.g(this.f43222a).O(optJSONObject4.toString());
            }
            JSONObject optJSONObject5 = optJSONObject.optJSONObject("auto_config");
            if (optJSONObject5 != null) {
                String optString7 = optJSONObject5.optString(com.alipay.sdk.cons.b.f1883h, "");
                String optString8 = optJSONObject5.optString("secret_key", "");
                if (!TextUtils.isEmpty(optString7) && !TextUtils.isEmpty(optString8)) {
                    d.b.f0.a.f43201b = optString7;
                    d.b.f0.a.f43202c = optString8;
                    d.b.f0.b.a.g(this.f43222a).A(optString7, optString8);
                }
            }
            d.b.f0.b.a.g(this.f43222a).S(optJSONObject.optString("encrypt_key", ""));
            JSONObject optJSONObject6 = jSONObject.optJSONObject("a_setting");
            if (optJSONObject6 != null) {
                if ("1".equals(optJSONObject6.optString("1", "1"))) {
                    d.b.f0.b.a.g(this.f43222a).G(true);
                } else {
                    d.b.f0.b.a.g(this.f43222a).G(false);
                }
            }
            d.b.f0.b.a.g(this.f43222a).k(jSONObject.optLong("3", 300L) * 1000);
            d.b.f0.b.a.g(this.f43222a).N(System.currentTimeMillis());
            return true;
        } catch (Throwable th) {
            d.b.f0.l.c.d(th);
            return false;
        }
    }

    public final boolean g() {
        try {
            if (System.currentTimeMillis() - d.b.f0.b.a.g(this.f43222a).f0() > d.b.f0.b.a.g(this.f43222a).C()) {
                return false;
            }
            String l0 = d.b.f0.b.a.g(this.f43222a).l0();
            String Q = d.b.f0.b.a.g(this.f43222a).Q();
            String d0 = d.b.f0.b.a.g(this.f43222a).d0();
            if (TextUtils.isEmpty(l0) && TextUtils.isEmpty(Q) && TextUtils.isEmpty(d0)) {
                return false;
            }
            if (!TextUtils.isEmpty(l0)) {
                JSONObject jSONObject = new JSONObject(l0);
                String string = jSONObject.getString(Constants.APP_ID);
                String string2 = jSONObject.getString(com.alipay.sdk.cons.b.f1883h);
                if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                    i.i("cm", string, string2);
                }
            }
            if (!TextUtils.isEmpty(Q)) {
                JSONObject jSONObject2 = new JSONObject(Q);
                String string3 = jSONObject2.getString(Constants.APP_ID);
                String string4 = jSONObject2.getString(com.alipay.sdk.cons.b.f1883h);
                if (!TextUtils.isEmpty(string3) && !TextUtils.isEmpty(string4)) {
                    i.i(Config.EXCEPTION_CRASH_TYPE, string3, string4);
                }
            }
            if (TextUtils.isEmpty(d0)) {
                return true;
            }
            JSONObject jSONObject3 = new JSONObject(d0);
            String optString = jSONObject3.optString(Constants.APP_ID);
            String optString2 = jSONObject3.optString(com.alipay.sdk.cons.b.f1883h);
            if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
                return true;
            }
            i.i("cu", optString, optString2);
            return true;
        } catch (Throwable th) {
            d.b.f0.l.c.d(th);
            return false;
        }
    }
}
