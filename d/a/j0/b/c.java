package d.a.j0.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.xiaomi.mipush.sdk.Constants;
import d.a.j0.e.i;
import d.a.j0.k.e;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static volatile c f43949b = null;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f43950c = false;

    /* renamed from: a  reason: collision with root package name */
    public Context f43951a;

    /* loaded from: classes2.dex */
    public class a extends d.a.j0.k.c {
        public a() {
        }

        @Override // d.a.j0.k.c
        public void b() {
            try {
                String b2 = new d.a.j0.f.d(c.this.f43951a, null).b();
                if (TextUtils.isEmpty(b2)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject(b2);
                if (jSONObject.optInt("0") == 0) {
                    c.f43950c = jSONObject.optInt("1") == 2;
                }
            } catch (Throwable th) {
                d.a.j0.l.c.d(th);
            }
        }
    }

    public c(Context context) {
        this.f43951a = context;
    }

    public static c b(Context context) {
        if (f43949b == null) {
            synchronized (c.class) {
                if (f43949b == null) {
                    f43949b = new c(context);
                }
            }
        }
        return f43949b;
    }

    public String c(JSONObject jSONObject, long j) {
        if (jSONObject != null) {
            try {
                if (jSONObject.length() != 0) {
                    String d2 = new d.a.j0.f.d(this.f43951a, null).d(jSONObject, j);
                    if (!TextUtils.isEmpty(d2)) {
                        return d2;
                    }
                }
            } catch (Throwable th) {
                d.a.j0.l.c.d(th);
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
                    String j2 = new d.a.j0.f.d(this.f43951a, null).j(jSONObject, j);
                    if (!TextUtils.isEmpty(j2)) {
                        return j2;
                    }
                }
            } catch (Throwable th) {
                d.a.j0.l.c.d(th);
            }
        }
        return "";
    }

    public synchronized boolean f() {
        try {
            if (g()) {
                return true;
            }
            d.a.j0.f.d dVar = new d.a.j0.f.d(this.f43951a, null);
            String i2 = dVar.i();
            if (TextUtils.isEmpty(i2)) {
                for (int i3 = 0; i3 < 3; i3++) {
                    i2 = dVar.i();
                    if (!TextUtils.isEmpty(i2)) {
                        break;
                    }
                }
            }
            if (TextUtils.isEmpty(i2)) {
                return false;
            }
            JSONObject jSONObject = new JSONObject(i2);
            int optInt = jSONObject.optInt("0", -1);
            if (optInt == 2) {
                d.a.j0.b.a.h(this.f43951a).N(false);
            } else {
                d.a.j0.b.a.h(this.f43951a).N(true);
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
                String optString2 = optJSONObject2.optString("app_key");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                    i.j("cm", optString, optString2);
                }
                int optInt2 = optJSONObject2.optInt("status", -1);
                if (optInt2 == 1) {
                    d.a.j0.b.a.h(this.f43951a).n(true);
                } else if (optInt2 == 2) {
                    d.a.j0.b.a.h(this.f43951a).n(false);
                }
                d.a.j0.b.a.h(this.f43951a).Y(optJSONObject2.toString());
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("dx_config");
            if (optJSONObject3 != null) {
                String optString3 = optJSONObject3.optString(Constants.APP_ID);
                String optString4 = optJSONObject3.optString("app_key");
                if (!TextUtils.isEmpty(optString3) && !TextUtils.isEmpty(optString4)) {
                    i.j(Config.EXCEPTION_CRASH_TYPE, optString3, optString4);
                }
                int optInt3 = optJSONObject3.optInt("status", -1);
                if (optInt3 == 1) {
                    d.a.j0.b.a.h(this.f43951a).x(true);
                } else if (optInt3 == 2) {
                    d.a.j0.b.a.h(this.f43951a).x(false);
                }
                d.a.j0.b.a.h(this.f43951a).B(optJSONObject3.toString());
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("lt_config");
            if (optJSONObject4 != null) {
                String optString5 = optJSONObject4.optString(Constants.APP_ID);
                String optString6 = optJSONObject4.optString("app_key");
                if (!TextUtils.isEmpty(optString5) && !TextUtils.isEmpty(optString6)) {
                    i.j("cu", optString5, optString6);
                }
                int optInt4 = optJSONObject4.optInt("status", -1);
                if (optInt4 == 1) {
                    d.a.j0.b.a.h(this.f43951a).D(true);
                } else if (optInt4 == 2) {
                    d.a.j0.b.a.h(this.f43951a).D(false);
                }
                d.a.j0.b.a.h(this.f43951a).Q(optJSONObject4.toString());
            }
            JSONObject optJSONObject5 = optJSONObject.optJSONObject("auto_config");
            if (optJSONObject5 != null) {
                String optString7 = optJSONObject5.optString("app_key", "");
                String optString8 = optJSONObject5.optString("secret_key", "");
                if (!TextUtils.isEmpty(optString7) && !TextUtils.isEmpty(optString8)) {
                    d.a.j0.a.f43930b = optString7;
                    d.a.j0.a.f43931c = optString8;
                    d.a.j0.b.a.h(this.f43951a).C(optString7, optString8);
                }
            }
            d.a.j0.b.a.h(this.f43951a).U(optJSONObject.optString("encrypt_key", ""));
            JSONObject optJSONObject6 = jSONObject.optJSONObject("a_setting");
            if (optJSONObject6 != null) {
                if ("1".equals(optJSONObject6.optString("1", "1"))) {
                    d.a.j0.b.a.h(this.f43951a).I(true);
                } else {
                    d.a.j0.b.a.h(this.f43951a).I(false);
                }
                d.a.j0.b.a.h(this.f43951a).z(optJSONObject6.optInt("2"));
            }
            d.a.j0.b.a.h(this.f43951a).l(jSONObject.optLong("3", 300L) * 1000);
            d.a.j0.b.a.h(this.f43951a).P(System.currentTimeMillis());
            return true;
        } catch (Throwable th) {
            d.a.j0.l.c.d(th);
            return false;
        }
    }

    public final boolean g() {
        try {
            if (System.currentTimeMillis() - d.a.j0.b.a.h(this.f43951a).i0() > d.a.j0.b.a.h(this.f43951a).E()) {
                return false;
            }
            String o0 = d.a.j0.b.a.h(this.f43951a).o0();
            String S = d.a.j0.b.a.h(this.f43951a).S();
            String f0 = d.a.j0.b.a.h(this.f43951a).f0();
            if (TextUtils.isEmpty(o0) && TextUtils.isEmpty(S) && TextUtils.isEmpty(f0)) {
                return false;
            }
            if (!TextUtils.isEmpty(o0)) {
                JSONObject jSONObject = new JSONObject(o0);
                String string = jSONObject.getString(Constants.APP_ID);
                String string2 = jSONObject.getString("app_key");
                if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                    i.j("cm", string, string2);
                }
            }
            if (!TextUtils.isEmpty(S)) {
                JSONObject jSONObject2 = new JSONObject(S);
                String string3 = jSONObject2.getString(Constants.APP_ID);
                String string4 = jSONObject2.getString("app_key");
                if (!TextUtils.isEmpty(string3) && !TextUtils.isEmpty(string4)) {
                    i.j(Config.EXCEPTION_CRASH_TYPE, string3, string4);
                }
            }
            if (TextUtils.isEmpty(f0)) {
                return true;
            }
            JSONObject jSONObject3 = new JSONObject(f0);
            String optString = jSONObject3.optString(Constants.APP_ID);
            String optString2 = jSONObject3.optString("app_key");
            if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
                return true;
            }
            i.j("cu", optString, optString2);
            return true;
        } catch (Throwable th) {
            d.a.j0.l.c.d(th);
            return false;
        }
    }
}
