package d.a.h0.a.i1;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.baidu.android.lbspay.presenter.LBSTransAuthPresenter;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.wallet.core.beans.BeanConstants;
import d.a.h0.a.k;
import d.a.h0.a.l;
import d.a.h0.a.v1.c.i.b;
import d.a.h0.a.y0.e.b;
import d.a.h0.g.b.a;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b implements d.a.h0.a.i1.g.a {
    public static final boolean j = k.f43101a;
    public static String[] k = {"duershow"};

    /* renamed from: a  reason: collision with root package name */
    public d.a.h0.a.r1.e f42659a;

    /* renamed from: b  reason: collision with root package name */
    public UnitedSchemeEntity f42660b;

    /* renamed from: c  reason: collision with root package name */
    public CallbackHandler f42661c;

    /* renamed from: d  reason: collision with root package name */
    public String f42662d;

    /* renamed from: e  reason: collision with root package name */
    public String f42663e;

    /* renamed from: f  reason: collision with root package name */
    public int f42664f;

    /* renamed from: g  reason: collision with root package name */
    public String f42665g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.z.a f42666h = new d.a.z.a();

    /* renamed from: i  reason: collision with root package name */
    public String f42667i;

    /* loaded from: classes3.dex */
    public class a implements d.a.h0.a.m.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f42668e;

        public a(String str) {
            this.f42668e = str;
        }

        @Override // d.a.h0.a.m.a
        public void onResult(int i2) {
            if (i2 == 0) {
                b.this.A(this.f42668e);
                return;
            }
            b.this.f42664f = 5;
            b.this.f42665g = null;
            b.this.I(null);
        }
    }

    /* renamed from: d.a.h0.a.i1.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0670b implements d.a.z.e.a {
        public C0670b() {
        }

        @Override // d.a.z.e.a
        public void onPayResult(int i2, String str) {
            b.this.f42664f = i2;
            b.this.f42665g = str;
            if (b.j) {
                Log.d("SwanAppPaymentManager", "statusCode: " + i2 + " ,result:" + str);
            }
            b.this.K(i2, "baiduqianbao", str);
            if (i2 != 0 || !TextUtils.equals(b.this.f42662d, "2.0")) {
                b.this.I(null);
            } else {
                d.a.h0.a.w0.a.G().e(b.this.f42663e, b.this);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.a.z.e.a {
        public c() {
        }

        @Override // d.a.z.e.a
        public void onPayResult(int i2, String str) {
            b.this.f42664f = i2;
            b.this.f42665g = str;
            if (b.j) {
                Log.d("SwanAppPaymentManager", "statusCode: " + b.this.f42664f + " ,result:" + b.this.f42665g);
            }
            b.this.K(i2, LBSTransAuthPresenter.AUTH_CHANNEL_ALI, str);
            if (i2 != 0 || !TextUtils.equals(b.this.f42662d, "2.0")) {
                b.this.I(null);
            } else {
                d.a.h0.a.w0.a.G().e(b.this.f42663e, b.this);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements d.a.h0.a.m.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f42672e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String[] f42673f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONObject f42674g;

        public d(String str, String[] strArr, JSONObject jSONObject) {
            this.f42672e = str;
            this.f42673f = strArr;
            this.f42674g = jSONObject;
        }

        @Override // d.a.h0.a.m.a
        public void onResult(int i2) {
            if (i2 == 0) {
                if (b.this.f42659a.i0()) {
                    b.this.E(this.f42672e, this.f42673f, this.f42674g, true, false);
                    return;
                } else {
                    b.this.B(this.f42672e, this.f42673f, this.f42674g, true, false);
                    return;
                }
            }
            b.this.f42664f = 5;
            b.this.f42665g = null;
            b.this.I(null);
            d.a.h0.a.z1.h.C(BeanConstants.CHANNEL_ID_NUOMI, false, false);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements a.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f42676a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String[] f42677b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ JSONObject f42678c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f42679d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f42680e;

        public e(String str, String[] strArr, JSONObject jSONObject, boolean z, boolean z2) {
            this.f42676a = str;
            this.f42677b = strArr;
            this.f42678c = jSONObject;
            this.f42679d = z;
            this.f42680e = z2;
        }

        @Override // d.a.h0.g.b.a.d
        public void onFail(String str) {
            if (TextUtils.isEmpty(b.this.f42667i)) {
                return;
            }
            CallbackHandler callbackHandler = b.this.f42661c;
            String str2 = b.this.f42667i;
            callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, 6, b.this.f42659a.v().getString(d.a.h0.a.h.swan_game_anti_addiction) + str).toString());
        }

        @Override // d.a.h0.g.b.a.d
        public void onSuccess() {
            b.this.B(this.f42676a, this.f42677b, this.f42678c, this.f42679d, this.f42680e);
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Function1<Boolean, Unit> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f42682e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String[] f42683f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONObject f42684g;

        public f(JSONObject jSONObject, String[] strArr, JSONObject jSONObject2) {
            this.f42682e = jSONObject;
            this.f42683f = strArr;
            this.f42684g = jSONObject2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a */
        public Unit invoke(Boolean bool) {
            if (bool.booleanValue()) {
                b.this.C(this.f42682e, this.f42683f, this.f42684g);
                return null;
            }
            b.this.J();
            return null;
        }
    }

    /* loaded from: classes3.dex */
    public class g implements d.a.h0.a.i1.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ JSONObject f42686a;

        public g(JSONObject jSONObject) {
            this.f42686a = jSONObject;
        }

        @Override // d.a.h0.a.i1.d
        public void onPayResult(int i2, String str) {
            b.this.H(i2, str, this.f42686a);
        }
    }

    /* loaded from: classes3.dex */
    public class h implements d.a.z.e.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ JSONObject f42688a;

        public h(JSONObject jSONObject) {
            this.f42688a = jSONObject;
        }

        @Override // d.a.z.e.a
        public void onPayResult(int i2, String str) {
            b.this.H(i2, str, this.f42688a);
        }
    }

    /* loaded from: classes3.dex */
    public class i implements d.a.h0.a.i2.u0.b<d.a.h0.a.v1.c.h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f42690e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f42691f;

        public i(String str, String str2) {
            this.f42690e = str;
            this.f42691f = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.a.h0.a.v1.c.h<b.e> hVar) {
            if (!d.a.h0.a.v1.c.c.h(hVar)) {
                String str = null;
                if (TextUtils.equals(b.this.f42662d, "2.0")) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("payId", "");
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    str = String.valueOf(jSONObject);
                }
                b.this.f42661c.handleSchemeDispatchCallback(b.this.f42667i, UnitedSchemeUtility.wrapCallbackParamsWithBase64(str, 1001, "authorize denied").toString());
                return;
            }
            String str2 = this.f42690e;
            char c2 = 65535;
            int hashCode = str2.hashCode();
            if (hashCode != -1689456891) {
                if (hashCode != -1250772529) {
                    if (hashCode == 1111965155 && str2.equals("mapp_request_alipayment")) {
                        c2 = 1;
                    }
                } else if (str2.equals("mapp_request_duxiaoman")) {
                    c2 = 0;
                }
            } else if (str2.equals("mapp_request_wechatpayment")) {
                c2 = 2;
            }
            if (c2 == 0) {
                b.this.y(this.f42691f);
            } else if (c2 == 1) {
                b.this.x(this.f42691f);
            } else if (c2 != 2) {
            } else {
                b.this.L();
            }
        }
    }

    public b(d.a.h0.a.r1.e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, String str2, String str3) {
        this.f42659a = eVar;
        this.f42660b = unitedSchemeEntity;
        this.f42661c = callbackHandler;
        this.f42662d = str;
        this.f42663e = str2;
        this.f42667i = str3;
    }

    public static String F(int i2) {
        return i2 != 0 ? i2 != 2 ? "支付失败" : "支付取消" : "支付成功";
    }

    public final void A(String str) {
        this.f42666h.d(this.f42659a.A(), str, new C0670b());
    }

    public final void B(String str, String[] strArr, JSONObject jSONObject, boolean z, boolean z2) {
        D(str, strArr, jSONObject);
        d.a.h0.a.z1.h.C(BeanConstants.CHANNEL_ID_NUOMI, z, z2);
    }

    public final void C(JSONObject jSONObject, String[] strArr, JSONObject jSONObject2) {
        boolean z;
        try {
            if (d.a.h0.a.r.a.f.f43778d.e()) {
                jSONObject.put("openBduss", d.a.h0.a.w0.a.O().c(d.a.h0.a.w0.a.c()));
                jSONObject.put("clientId", d.a.h0.a.w0.a.k().g());
            } else {
                jSONObject.put("bduss", d.a.h0.a.w0.a.O().c(d.a.h0.a.w0.a.c()));
            }
            jSONObject.put("cuid", d.a.h0.a.w0.a.O().f(d.a.h0.a.w0.a.c()));
            String optString = jSONObject.optString("bizInfo");
            JSONObject jSONObject3 = TextUtils.isEmpty(optString) ? new JSONObject() : new JSONObject(optString);
            jSONObject3.put("swanFrom", this.f42659a.J().S());
            jSONObject3.put("cuid", d.a.h0.a.w0.a.O().f(d.a.h0.a.w0.a.c()));
            jSONObject3.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, d.a.h0.a.r1.d.e().getAppId());
            w(jSONObject3);
            jSONObject.put("bizInfo", jSONObject3.toString());
            jSONObject.put("platformId", "100003");
            jSONObject.put("nativeAppId", d.a.h0.a.w0.a.k().f());
            jSONObject.put("swanNativeVersion", l.a());
            if (j) {
                Log.i("SwanAppPaymentManager", jSONObject.toString());
            }
        } catch (JSONException e2) {
            if (k.f43101a) {
                e2.printStackTrace();
            }
        }
        d.a.h0.a.z0.f.V().r();
        String[] strArr2 = k;
        int length = strArr2.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                z = false;
                break;
            } else if (strArr2[i2].equals(d.a.h0.a.w0.a.k().f())) {
                z = true;
                break;
            } else {
                i2++;
            }
        }
        if (z) {
            String a2 = d.a.h0.p.h.a(d.a.h0.p.h.a("https://etrade.baidu.com/cashier/create-qrcode", "orderInfo", Uri.encode(jSONObject.toString())), "deviceType", "ANDROID");
            d.a.h0.a.e0.l.i.J2("qrCodePay", d.a.h0.a.e1.b.c(a2, a2));
            d.a.h0.a.i1.e.b(new g(jSONObject2));
        } else {
            this.f42666h.i(this.f42659a.v(), jSONObject, strArr, new h(jSONObject2));
        }
        UnitedSchemeUtility.callCallback(this.f42661c, this.f42660b, UnitedSchemeUtility.wrapCallbackParams(0));
        if (this.f42659a.x() != null) {
            String valueOf = String.valueOf(this.f42659a.J().F());
            String valueOf2 = String.valueOf(UnitedSchemeUtility.getParams(this.f42659a.J().V()).get("_baiduboxapp"));
            Bundle bundle = new Bundle();
            bundle.putString("frameType", valueOf);
            bundle.putString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f42659a.J().G());
            try {
                bundle.putString("params", URLEncoder.encode(valueOf2, "UTF-8"));
            } catch (UnsupportedEncodingException e3) {
                if (j) {
                    throw new RuntimeException("This method requires UTF-8 encoding support", e3);
                }
            }
            this.f42659a.x().L(7, bundle);
        }
    }

    public final void D(String str, String[] strArr, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            d.a.h0.a.g1.o.c.d.b(jSONObject2.optString("appKey"), new f(jSONObject2, strArr, jSONObject));
        } catch (JSONException e2) {
            J();
            if (k.f43101a) {
                e2.printStackTrace();
            }
        }
    }

    public final void E(String str, String[] strArr, JSONObject jSONObject, boolean z, boolean z2) {
        d.a.h0.g.b.d.p().j(str, new e(str, strArr, jSONObject, z, z2));
    }

    public boolean G(String str, JSONObject jSONObject) {
        String[] strArr;
        Object opt;
        if (TextUtils.isEmpty(str)) {
            this.f42660b.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        String optString = jSONObject.optString("__plugin__");
        d.a.h0.a.l1.d.a.a("start payment");
        if (!TextUtils.isEmpty(optString) && (opt = jSONObject.opt("error")) != null) {
            String optString2 = jSONObject.optString("slaveId");
            d.a.h0.a.l1.c.c.a aVar = new d.a.h0.a.l1.c.c.a(jSONObject.optString("componentId"));
            aVar.f43252a = optString2;
            aVar.f43254c = opt;
            aVar.f43255d = false;
            aVar.f43256e = null;
            aVar.b();
            this.f42660b.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("bannedChannels");
        if (optJSONArray != null) {
            String[] strArr2 = new String[optJSONArray.length()];
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                strArr2[i2] = String.valueOf(optJSONArray.opt(i2));
            }
            strArr = strArr2;
        } else {
            strArr = null;
        }
        if (this.f42659a.v() == null) {
            this.f42664f = 5;
            this.f42665g = null;
            I(null);
            if (j) {
                throw new RuntimeException("swanApp getActivity returns null");
            }
            return true;
        } else if (this.f42659a.i().e(this.f42659a.A())) {
            if (this.f42659a.i0()) {
                E(str, strArr, jSONObject, true, true);
                return true;
            }
            B(str, strArr, jSONObject, true, true);
            return true;
        } else {
            this.f42659a.i().f(this.f42659a.A(), null, new d(str, strArr, jSONObject));
            return true;
        }
    }

    public final void H(int i2, String str, JSONObject jSONObject) {
        d.a.h0.a.z0.f.V().d();
        K(i2, BeanConstants.CHANNEL_ID_NUOMI, str);
        this.f42664f = i2;
        this.f42665g = str;
        I(null);
        if (jSONObject != null && !TextUtils.isEmpty(jSONObject.optString("__plugin__"))) {
            String optString = jSONObject.optString("slaveId");
            String optString2 = jSONObject.optString("componentId");
            Object opt = jSONObject.opt("error");
            d.a.h0.a.l1.c.c.a aVar = new d.a.h0.a.l1.c.c.a(optString2);
            aVar.f43252a = optString;
            aVar.f43254c = opt;
            aVar.f43255d = i2 == 0;
            aVar.f43256e = str;
            aVar.b();
            d.a.h0.a.l1.g.b.i();
        }
        if (this.f42664f == 0) {
            d.a.h0.a.o1.c.f43497b.d();
        }
    }

    public final void I(String str) {
        d.a.h0.a.c0.c.g("SwanAppPaymentManager", "sendSecondCallback, statusCode: " + this.f42664f + ", params: " + this.f42665g);
        try {
            if (TextUtils.equals(this.f42662d, "2.0")) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("payId", str);
                if (!TextUtils.isEmpty(this.f42665g)) {
                    jSONObject.put("payResult", Base64.encodeToString(this.f42665g.getBytes("UTF-8"), 2));
                }
                this.f42661c.handleSchemeDispatchCallback(this.f42667i, UnitedSchemeUtility.wrapCallbackParams(jSONObject, this.f42664f, F(this.f42664f)).toString());
                return;
            }
            this.f42661c.handleSchemeDispatchCallback(this.f42667i, UnitedSchemeUtility.wrapCallbackParamsWithBase64(this.f42665g, this.f42664f, F(this.f42664f)).toString());
        } catch (UnsupportedEncodingException | JSONException e2) {
            e2.printStackTrace();
            CallbackHandler callbackHandler = this.f42661c;
            String str2 = this.f42667i;
            int i2 = this.f42664f;
            callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, i2, F(i2)).toString());
        }
    }

    public final void J() {
        d.a.h0.a.r1.e eVar = this.f42659a;
        if (eVar != null) {
            d.a.h0.a.q1.b.f.d.e(eVar.v(), d.a.h0.a.h.swanapp_payment_illegal).C();
            if (TextUtils.isEmpty(this.f42667i)) {
                return;
            }
            this.f42661c.handleSchemeDispatchCallback(this.f42667i, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, 6, this.f42659a.v().getString(d.a.h0.a.h.swanapp_payment_illegal)).toString());
        }
    }

    public final void K(int i2, String str, String str2) {
        d.a.h0.a.z1.h.B(i2 == 0, str, str2, this.f42659a.J().F());
    }

    public final boolean L() {
        d.a.h0.a.c0.c.g("SwanAppPaymentManager", "start UnitedSchemeWalletDispatcher ACTION_REQUEST_WECHAT_PAYMENT");
        if (d.a.h0.a.i1.a.b().c(this.f42659a, this.f42661c, this.f42660b)) {
            this.f42664f = 0;
            this.f42665g = null;
            if (TextUtils.equals(this.f42662d, "2.0")) {
                d.a.h0.a.w0.a.G().e(this.f42663e, this);
            } else {
                I(null);
            }
            d.a.h0.a.z1.h.A("wechatH5Action", null, null);
            return true;
        }
        this.f42661c.handleSchemeDispatchCallback(this.f42667i, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
        return false;
    }

    @Override // d.a.h0.a.o1.a
    public void a(JSONObject jSONObject) {
        I(jSONObject.optInt("errno") == 0 ? jSONObject.optJSONObject("data").optString("payid") : null);
        if (d.a.h0.a.w0.a.O().d(this.f42659a)) {
            d.a.h0.a.o1.c.f43497b.d();
        } else {
            d.a.h0.a.o1.c.f43497b.e();
        }
    }

    @Override // d.a.h0.a.o1.a
    public void onFail(String str) {
        d.a.h0.a.c0.c.b("SwanAppPaymentManager", "request payId failed");
        d.a.h0.a.c0.c.b("SwanAppPaymentManager", str);
        I(null);
    }

    public final JSONObject w(JSONObject jSONObject) {
        if (this.f42659a.i0() && jSONObject != null) {
            b.a J = this.f42659a.J();
            if (J.L() == null) {
                return jSONObject;
            }
            JSONObject L = J.L();
            String optString = L.optString("log_id");
            String optString2 = L.optString("module_id");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                try {
                    jSONObject.put("log_id", optString);
                    jSONObject.put("module_id", optString2);
                } catch (JSONException e2) {
                    if (j) {
                        e2.printStackTrace();
                    }
                }
            }
        }
        return jSONObject;
    }

    public final boolean x(String str) {
        if (j) {
            Log.d("SwanAppPaymentManager", "start UnitedSchemeWalletDispatcher ACTION_REQUEST_ALI_PAYMENT orderInfo: " + str);
        }
        this.f42666h.c(this.f42659a.A(), str, new c());
        return true;
    }

    public final boolean y(String str) {
        if (this.f42659a.i().e(this.f42659a.A())) {
            A(str);
            return true;
        }
        this.f42659a.i().f(this.f42659a.A(), null, new a(str));
        return true;
    }

    public boolean z(String str, String str2) {
        if (TextUtils.isEmpty(str2) && (str.equals("mapp_request_duxiaoman") || str.equals("mapp_request_alipayment"))) {
            this.f42660b.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        this.f42659a.R().g(this.f42659a.v(), str, new i(str, str2));
        UnitedSchemeUtility.callCallback(this.f42661c, this.f42660b, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }
}
