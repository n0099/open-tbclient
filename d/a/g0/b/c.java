package d.a.g0.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.xiaomi.mipush.sdk.Constants;
import d.a.g0.e.i;
import d.a.g0.k.e;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static volatile c f40762b = null;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f40763c = false;

    /* renamed from: a  reason: collision with root package name */
    public Context f40764a;

    /* loaded from: classes2.dex */
    public class a extends d.a.g0.k.c {
        public a() {
        }

        @Override // d.a.g0.k.c
        public void b() {
            try {
                String b2 = new d.a.g0.f.d(c.this.f40764a, null).b();
                if (TextUtils.isEmpty(b2)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject(b2);
                if (jSONObject.optInt("0") == 0) {
                    c.f40763c = jSONObject.optInt("1") == 2;
                }
            } catch (Throwable th) {
                d.a.g0.l.c.d(th);
            }
        }
    }

    public c(Context context) {
        this.f40764a = context;
    }

    public static c b(Context context) {
        if (f40762b == null) {
            synchronized (c.class) {
                if (f40762b == null) {
                    f40762b = new c(context);
                }
            }
        }
        return f40762b;
    }

    public String c(JSONObject jSONObject, long j) {
        if (jSONObject != null) {
            try {
                if (jSONObject.length() != 0) {
                    String d2 = new d.a.g0.f.d(this.f40764a, null).d(jSONObject, j);
                    if (!TextUtils.isEmpty(d2)) {
                        return d2;
                    }
                }
            } catch (Throwable th) {
                d.a.g0.l.c.d(th);
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
                    String i2 = new d.a.g0.f.d(this.f40764a, null).i(jSONObject, j);
                    if (!TextUtils.isEmpty(i2)) {
                        return i2;
                    }
                }
            } catch (Throwable th) {
                d.a.g0.l.c.d(th);
            }
        }
        return "";
    }

    public synchronized boolean f() {
        try {
            if (g()) {
                return true;
            }
            d.a.g0.f.d dVar = new d.a.g0.f.d(this.f40764a, null);
            String h2 = dVar.h();
            if (TextUtils.isEmpty(h2)) {
                for (int i2 = 0; i2 < 3; i2++) {
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
                d.a.g0.b.a.g(this.f40764a).L(false);
            } else {
                d.a.g0.b.a.g(this.f40764a).L(true);
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
                String optString2 = optJSONObject2.optString(com.alipay.sdk.cons.b.f1831h);
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                    i.i("cm", optString, optString2);
                }
                int optInt2 = optJSONObject2.optInt("status", -1);
                if (optInt2 == 1) {
                    d.a.g0.b.a.g(this.f40764a).m(true);
                } else if (optInt2 == 2) {
                    d.a.g0.b.a.g(this.f40764a).m(false);
                }
                d.a.g0.b.a.g(this.f40764a).W(optJSONObject2.toString());
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("dx_config");
            if (optJSONObject3 != null) {
                String optString3 = optJSONObject3.optString(Constants.APP_ID);
                String optString4 = optJSONObject3.optString(com.alipay.sdk.cons.b.f1831h);
                if (!TextUtils.isEmpty(optString3) && !TextUtils.isEmpty(optString4)) {
                    i.i(Config.EXCEPTION_CRASH_TYPE, optString3, optString4);
                }
                int optInt3 = optJSONObject3.optInt("status", -1);
                if (optInt3 == 1) {
                    d.a.g0.b.a.g(this.f40764a).w(true);
                } else if (optInt3 == 2) {
                    d.a.g0.b.a.g(this.f40764a).w(false);
                }
                d.a.g0.b.a.g(this.f40764a).z(optJSONObject3.toString());
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("lt_config");
            if (optJSONObject4 != null) {
                String optString5 = optJSONObject4.optString(Constants.APP_ID);
                String optString6 = optJSONObject4.optString(com.alipay.sdk.cons.b.f1831h);
                if (!TextUtils.isEmpty(optString5) && !TextUtils.isEmpty(optString6)) {
                    i.i("cu", optString5, optString6);
                }
                int optInt4 = optJSONObject4.optInt("status", -1);
                if (optInt4 == 1) {
                    d.a.g0.b.a.g(this.f40764a).B(true);
                } else if (optInt4 == 2) {
                    d.a.g0.b.a.g(this.f40764a).B(false);
                }
                d.a.g0.b.a.g(this.f40764a).O(optJSONObject4.toString());
            }
            JSONObject optJSONObject5 = optJSONObject.optJSONObject("auto_config");
            if (optJSONObject5 != null) {
                String optString7 = optJSONObject5.optString(com.alipay.sdk.cons.b.f1831h, "");
                String optString8 = optJSONObject5.optString("secret_key", "");
                if (!TextUtils.isEmpty(optString7) && !TextUtils.isEmpty(optString8)) {
                    d.a.g0.a.f40743b = optString7;
                    d.a.g0.a.f40744c = optString8;
                    d.a.g0.b.a.g(this.f40764a).A(optString7, optString8);
                }
            }
            d.a.g0.b.a.g(this.f40764a).S(optJSONObject.optString("encrypt_key", ""));
            JSONObject optJSONObject6 = jSONObject.optJSONObject("a_setting");
            if (optJSONObject6 != null) {
                if ("1".equals(optJSONObject6.optString("1", "1"))) {
                    d.a.g0.b.a.g(this.f40764a).G(true);
                } else {
                    d.a.g0.b.a.g(this.f40764a).G(false);
                }
            }
            d.a.g0.b.a.g(this.f40764a).k(jSONObject.optLong("3", 300L) * 1000);
            d.a.g0.b.a.g(this.f40764a).N(System.currentTimeMillis());
            return true;
        } catch (Throwable th) {
            d.a.g0.l.c.d(th);
            return false;
        }
    }

    public final boolean g() {
        try {
            if (System.currentTimeMillis() - d.a.g0.b.a.g(this.f40764a).f0() > d.a.g0.b.a.g(this.f40764a).C()) {
                return false;
            }
            String l0 = d.a.g0.b.a.g(this.f40764a).l0();
            String Q = d.a.g0.b.a.g(this.f40764a).Q();
            String d0 = d.a.g0.b.a.g(this.f40764a).d0();
            if (TextUtils.isEmpty(l0) && TextUtils.isEmpty(Q) && TextUtils.isEmpty(d0)) {
                return false;
            }
            if (!TextUtils.isEmpty(l0)) {
                JSONObject jSONObject = new JSONObject(l0);
                String string = jSONObject.getString(Constants.APP_ID);
                String string2 = jSONObject.getString(com.alipay.sdk.cons.b.f1831h);
                if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                    i.i("cm", string, string2);
                }
            }
            if (!TextUtils.isEmpty(Q)) {
                JSONObject jSONObject2 = new JSONObject(Q);
                String string3 = jSONObject2.getString(Constants.APP_ID);
                String string4 = jSONObject2.getString(com.alipay.sdk.cons.b.f1831h);
                if (!TextUtils.isEmpty(string3) && !TextUtils.isEmpty(string4)) {
                    i.i(Config.EXCEPTION_CRASH_TYPE, string3, string4);
                }
            }
            if (TextUtils.isEmpty(d0)) {
                return true;
            }
            JSONObject jSONObject3 = new JSONObject(d0);
            String optString = jSONObject3.optString(Constants.APP_ID);
            String optString2 = jSONObject3.optString(com.alipay.sdk.cons.b.f1831h);
            if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
                return true;
            }
            i.i("cu", optString, optString2);
            return true;
        } catch (Throwable th) {
            d.a.g0.l.c.d(th);
            return false;
        }
    }
}
