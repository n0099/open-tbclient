package d.b.h0.a.i1;

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
import d.b.h0.a.k;
import d.b.h0.a.l;
import d.b.h0.a.v1.c.i.b;
import d.b.h0.a.y0.e.b;
import d.b.h0.g.b.a;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b implements d.b.h0.a.i1.g.a {
    public static final boolean j = k.f45772a;
    public static String[] k = {"duershow"};

    /* renamed from: a  reason: collision with root package name */
    public d.b.h0.a.r1.e f45344a;

    /* renamed from: b  reason: collision with root package name */
    public UnitedSchemeEntity f45345b;

    /* renamed from: c  reason: collision with root package name */
    public CallbackHandler f45346c;

    /* renamed from: d  reason: collision with root package name */
    public String f45347d;

    /* renamed from: e  reason: collision with root package name */
    public String f45348e;

    /* renamed from: f  reason: collision with root package name */
    public int f45349f;

    /* renamed from: g  reason: collision with root package name */
    public String f45350g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.z.a f45351h = new d.b.z.a();
    public String i;

    /* loaded from: classes2.dex */
    public class a implements d.b.h0.a.m.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f45352e;

        public a(String str) {
            this.f45352e = str;
        }

        @Override // d.b.h0.a.m.a
        public void onResult(int i) {
            if (i == 0) {
                b.this.A(this.f45352e);
                return;
            }
            b.this.f45349f = 5;
            b.this.f45350g = null;
            b.this.I(null);
        }
    }

    /* renamed from: d.b.h0.a.i1.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0731b implements d.b.z.e.a {
        public C0731b() {
        }

        @Override // d.b.z.e.a
        public void onPayResult(int i, String str) {
            b.this.f45349f = i;
            b.this.f45350g = str;
            if (b.j) {
                Log.d("SwanAppPaymentManager", "statusCode: " + i + " ,result:" + str);
            }
            b.this.K(i, "baiduqianbao", str);
            if (i != 0 || !TextUtils.equals(b.this.f45347d, "2.0")) {
                b.this.I(null);
            } else {
                d.b.h0.a.w0.a.G().d(b.this.f45348e, b.this);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements d.b.z.e.a {
        public c() {
        }

        @Override // d.b.z.e.a
        public void onPayResult(int i, String str) {
            b.this.f45349f = i;
            b.this.f45350g = str;
            if (b.j) {
                Log.d("SwanAppPaymentManager", "statusCode: " + b.this.f45349f + " ,result:" + b.this.f45350g);
            }
            b.this.K(i, LBSTransAuthPresenter.AUTH_CHANNEL_ALI, str);
            if (i != 0 || !TextUtils.equals(b.this.f45347d, "2.0")) {
                b.this.I(null);
            } else {
                d.b.h0.a.w0.a.G().d(b.this.f45348e, b.this);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements d.b.h0.a.m.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f45356e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String[] f45357f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONObject f45358g;

        public d(String str, String[] strArr, JSONObject jSONObject) {
            this.f45356e = str;
            this.f45357f = strArr;
            this.f45358g = jSONObject;
        }

        @Override // d.b.h0.a.m.a
        public void onResult(int i) {
            if (i == 0) {
                if (b.this.f45344a.i0()) {
                    b.this.E(this.f45356e, this.f45357f, this.f45358g, true, false);
                    return;
                } else {
                    b.this.B(this.f45356e, this.f45357f, this.f45358g, true, false);
                    return;
                }
            }
            b.this.f45349f = 5;
            b.this.f45350g = null;
            b.this.I(null);
            d.b.h0.a.z1.h.C(BeanConstants.CHANNEL_ID_NUOMI, false, false);
        }
    }

    /* loaded from: classes2.dex */
    public class e implements a.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f45360a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String[] f45361b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ JSONObject f45362c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f45363d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f45364e;

        public e(String str, String[] strArr, JSONObject jSONObject, boolean z, boolean z2) {
            this.f45360a = str;
            this.f45361b = strArr;
            this.f45362c = jSONObject;
            this.f45363d = z;
            this.f45364e = z2;
        }

        @Override // d.b.h0.g.b.a.d
        public void onFail(String str) {
            if (TextUtils.isEmpty(b.this.i)) {
                return;
            }
            CallbackHandler callbackHandler = b.this.f45346c;
            String str2 = b.this.i;
            callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, 6, b.this.f45344a.n().getString(d.b.h0.a.h.swan_game_anti_addiction) + str).toString());
        }

        @Override // d.b.h0.g.b.a.d
        public void onSuccess() {
            b.this.B(this.f45360a, this.f45361b, this.f45362c, this.f45363d, this.f45364e);
        }
    }

    /* loaded from: classes2.dex */
    public class f implements Function1<Boolean, Unit> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f45366e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String[] f45367f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONObject f45368g;

        public f(JSONObject jSONObject, String[] strArr, JSONObject jSONObject2) {
            this.f45366e = jSONObject;
            this.f45367f = strArr;
            this.f45368g = jSONObject2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a */
        public Unit invoke(Boolean bool) {
            if (bool.booleanValue()) {
                b.this.C(this.f45366e, this.f45367f, this.f45368g);
                return null;
            }
            b.this.J();
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public class g implements d.b.h0.a.i1.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ JSONObject f45370a;

        public g(JSONObject jSONObject) {
            this.f45370a = jSONObject;
        }

        @Override // d.b.h0.a.i1.d
        public void onPayResult(int i, String str) {
            b.this.H(i, str, this.f45370a);
        }
    }

    /* loaded from: classes2.dex */
    public class h implements d.b.z.e.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ JSONObject f45372a;

        public h(JSONObject jSONObject) {
            this.f45372a = jSONObject;
        }

        @Override // d.b.z.e.a
        public void onPayResult(int i, String str) {
            b.this.H(i, str, this.f45372a);
        }
    }

    /* loaded from: classes2.dex */
    public class i implements d.b.h0.a.i2.u0.b<d.b.h0.a.v1.c.h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f45374e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f45375f;

        public i(String str, String str2) {
            this.f45374e = str;
            this.f45375f = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.b.h0.a.v1.c.h<b.e> hVar) {
            if (!d.b.h0.a.v1.c.c.h(hVar)) {
                String str = null;
                if (TextUtils.equals(b.this.f45347d, "2.0")) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("payId", "");
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    str = String.valueOf(jSONObject);
                }
                b.this.f45346c.handleSchemeDispatchCallback(b.this.i, UnitedSchemeUtility.wrapCallbackParamsWithBase64(str, 1001, "authorize denied").toString());
                return;
            }
            String str2 = this.f45374e;
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
                b.this.y(this.f45375f);
            } else if (c2 == 1) {
                b.this.x(this.f45375f);
            } else if (c2 != 2) {
            } else {
                b.this.L();
            }
        }
    }

    public b(d.b.h0.a.r1.e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, String str2, String str3) {
        this.f45344a = eVar;
        this.f45345b = unitedSchemeEntity;
        this.f45346c = callbackHandler;
        this.f45347d = str;
        this.f45348e = str2;
        this.i = str3;
    }

    public static String F(int i2) {
        return i2 != 0 ? i2 != 2 ? "支付失败" : "支付取消" : "支付成功";
    }

    public final void A(String str) {
        this.f45351h.d(this.f45344a.A(), str, new C0731b());
    }

    public final void B(String str, String[] strArr, JSONObject jSONObject, boolean z, boolean z2) {
        D(str, strArr, jSONObject);
        d.b.h0.a.z1.h.C(BeanConstants.CHANNEL_ID_NUOMI, z, z2);
    }

    public final void C(JSONObject jSONObject, String[] strArr, JSONObject jSONObject2) {
        boolean z;
        try {
            if (d.b.h0.a.r.a.f.f46418d.e()) {
                jSONObject.put("openBduss", d.b.h0.a.w0.a.O().e(d.b.h0.a.w0.a.c()));
                jSONObject.put("clientId", d.b.h0.a.w0.a.k().h());
            } else {
                jSONObject.put("bduss", d.b.h0.a.w0.a.O().e(d.b.h0.a.w0.a.c()));
            }
            jSONObject.put("cuid", d.b.h0.a.w0.a.O().c(d.b.h0.a.w0.a.c()));
            String optString = jSONObject.optString("bizInfo");
            JSONObject jSONObject3 = TextUtils.isEmpty(optString) ? new JSONObject() : new JSONObject(optString);
            jSONObject3.put("swanFrom", this.f45344a.J().S());
            jSONObject3.put("cuid", d.b.h0.a.w0.a.O().c(d.b.h0.a.w0.a.c()));
            jSONObject3.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, d.b.h0.a.r1.d.e().getAppId());
            w(jSONObject3);
            jSONObject.put("bizInfo", jSONObject3.toString());
            jSONObject.put("platformId", "100003");
            jSONObject.put("nativeAppId", d.b.h0.a.w0.a.k().g());
            jSONObject.put("swanNativeVersion", l.a());
            if (j) {
                Log.i("SwanAppPaymentManager", jSONObject.toString());
            }
        } catch (JSONException e2) {
            if (k.f45772a) {
                e2.printStackTrace();
            }
        }
        d.b.h0.a.z0.f.V().D();
        String[] strArr2 = k;
        int length = strArr2.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                z = false;
                break;
            } else if (strArr2[i2].equals(d.b.h0.a.w0.a.k().g())) {
                z = true;
                break;
            } else {
                i2++;
            }
        }
        if (z) {
            String a2 = d.b.h0.p.h.a(d.b.h0.p.h.a("https://etrade.baidu.com/cashier/create-qrcode", "orderInfo", Uri.encode(jSONObject.toString())), "deviceType", "ANDROID");
            d.b.h0.a.e0.l.i.K2("qrCodePay", d.b.h0.a.e1.b.c(a2, a2));
            d.b.h0.a.i1.e.b(new g(jSONObject2));
        } else {
            this.f45351h.i(this.f45344a.n(), jSONObject, strArr, new h(jSONObject2));
        }
        UnitedSchemeUtility.callCallback(this.f45346c, this.f45345b, UnitedSchemeUtility.wrapCallbackParams(0));
        if (this.f45344a.q() != null) {
            String valueOf = String.valueOf(this.f45344a.J().F());
            String valueOf2 = String.valueOf(UnitedSchemeUtility.getParams(this.f45344a.J().V()).get("_baiduboxapp"));
            Bundle bundle = new Bundle();
            bundle.putString("frameType", valueOf);
            bundle.putString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f45344a.J().G());
            try {
                bundle.putString("params", URLEncoder.encode(valueOf2, "UTF-8"));
            } catch (UnsupportedEncodingException e3) {
                if (j) {
                    throw new RuntimeException("This method requires UTF-8 encoding support", e3);
                }
            }
            this.f45344a.q().L(7, bundle);
        }
    }

    public final void D(String str, String[] strArr, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            d.b.h0.a.g1.o.c.d.b(jSONObject2.optString("appKey"), new f(jSONObject2, strArr, jSONObject));
        } catch (JSONException e2) {
            J();
            if (k.f45772a) {
                e2.printStackTrace();
            }
        }
    }

    public final void E(String str, String[] strArr, JSONObject jSONObject, boolean z, boolean z2) {
        d.b.h0.g.b.d.p().j(str, new e(str, strArr, jSONObject, z, z2));
    }

    public boolean G(String str, JSONObject jSONObject) {
        String[] strArr;
        Object opt;
        if (TextUtils.isEmpty(str)) {
            this.f45345b.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        String optString = jSONObject.optString("__plugin__");
        d.b.h0.a.l1.d.a.a("start payment");
        if (!TextUtils.isEmpty(optString) && (opt = jSONObject.opt("error")) != null) {
            String optString2 = jSONObject.optString("slaveId");
            d.b.h0.a.l1.c.c.a aVar = new d.b.h0.a.l1.c.c.a(jSONObject.optString("componentId"));
            aVar.f45916a = optString2;
            aVar.f45918c = opt;
            aVar.f45919d = false;
            aVar.f45920e = null;
            aVar.b();
            this.f45345b.result = UnitedSchemeUtility.wrapCallbackParams(1001);
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
        if (this.f45344a.n() == null) {
            this.f45349f = 5;
            this.f45350g = null;
            I(null);
            if (j) {
                throw new RuntimeException("swanApp getActivity returns null");
            }
            return true;
        } else if (this.f45344a.z().e(this.f45344a.A())) {
            if (this.f45344a.i0()) {
                E(str, strArr, jSONObject, true, true);
                return true;
            }
            B(str, strArr, jSONObject, true, true);
            return true;
        } else {
            this.f45344a.z().f(this.f45344a.A(), null, new d(str, strArr, jSONObject));
            return true;
        }
    }

    public final void H(int i2, String str, JSONObject jSONObject) {
        d.b.h0.a.z0.f.V().f();
        K(i2, BeanConstants.CHANNEL_ID_NUOMI, str);
        this.f45349f = i2;
        this.f45350g = str;
        I(null);
        if (jSONObject != null && !TextUtils.isEmpty(jSONObject.optString("__plugin__"))) {
            String optString = jSONObject.optString("slaveId");
            String optString2 = jSONObject.optString("componentId");
            Object opt = jSONObject.opt("error");
            d.b.h0.a.l1.c.c.a aVar = new d.b.h0.a.l1.c.c.a(optString2);
            aVar.f45916a = optString;
            aVar.f45918c = opt;
            aVar.f45919d = i2 == 0;
            aVar.f45920e = str;
            aVar.b();
            d.b.h0.a.l1.g.b.i();
        }
        if (this.f45349f == 0) {
            d.b.h0.a.o1.c.f46150b.d();
        }
    }

    public final void I(String str) {
        d.b.h0.a.c0.c.g("SwanAppPaymentManager", "sendSecondCallback, statusCode: " + this.f45349f + ", params: " + this.f45350g);
        try {
            if (TextUtils.equals(this.f45347d, "2.0")) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("payId", str);
                if (!TextUtils.isEmpty(this.f45350g)) {
                    jSONObject.put("payResult", Base64.encodeToString(this.f45350g.getBytes("UTF-8"), 2));
                }
                this.f45346c.handleSchemeDispatchCallback(this.i, UnitedSchemeUtility.wrapCallbackParams(jSONObject, this.f45349f, F(this.f45349f)).toString());
                return;
            }
            this.f45346c.handleSchemeDispatchCallback(this.i, UnitedSchemeUtility.wrapCallbackParamsWithBase64(this.f45350g, this.f45349f, F(this.f45349f)).toString());
        } catch (UnsupportedEncodingException | JSONException e2) {
            e2.printStackTrace();
            CallbackHandler callbackHandler = this.f45346c;
            String str2 = this.i;
            int i2 = this.f45349f;
            callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, i2, F(i2)).toString());
        }
    }

    public final void J() {
        d.b.h0.a.r1.e eVar = this.f45344a;
        if (eVar != null) {
            d.b.h0.a.q1.b.f.d.e(eVar.n(), d.b.h0.a.h.swanapp_payment_illegal).C();
            if (TextUtils.isEmpty(this.i)) {
                return;
            }
            this.f45346c.handleSchemeDispatchCallback(this.i, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, 6, this.f45344a.n().getString(d.b.h0.a.h.swanapp_payment_illegal)).toString());
        }
    }

    public final void K(int i2, String str, String str2) {
        d.b.h0.a.z1.h.B(i2 == 0, str, str2, this.f45344a.J().F());
    }

    public final boolean L() {
        d.b.h0.a.c0.c.g("SwanAppPaymentManager", "start UnitedSchemeWalletDispatcher ACTION_REQUEST_WECHAT_PAYMENT");
        if (d.b.h0.a.i1.a.b().c(this.f45344a, this.f45346c, this.f45345b)) {
            this.f45349f = 0;
            this.f45350g = null;
            if (TextUtils.equals(this.f45347d, "2.0")) {
                d.b.h0.a.w0.a.G().d(this.f45348e, this);
            } else {
                I(null);
            }
            d.b.h0.a.z1.h.A("wechatH5Action", null, null);
            return true;
        }
        this.f45346c.handleSchemeDispatchCallback(this.i, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
        return false;
    }

    @Override // d.b.h0.a.o1.a
    public void a(JSONObject jSONObject) {
        I(jSONObject.optInt("errno") == 0 ? jSONObject.optJSONObject("data").optString("payid") : null);
        if (d.b.h0.a.w0.a.O().g(this.f45344a)) {
            d.b.h0.a.o1.c.f46150b.d();
        } else {
            d.b.h0.a.o1.c.f46150b.e();
        }
    }

    @Override // d.b.h0.a.o1.a
    public void onFail(String str) {
        d.b.h0.a.c0.c.b("SwanAppPaymentManager", "request payId failed");
        d.b.h0.a.c0.c.b("SwanAppPaymentManager", str);
        I(null);
    }

    public final JSONObject w(JSONObject jSONObject) {
        if (this.f45344a.i0() && jSONObject != null) {
            b.a J = this.f45344a.J();
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
        this.f45351h.c(this.f45344a.A(), str, new c());
        return true;
    }

    public final boolean y(String str) {
        if (this.f45344a.z().e(this.f45344a.A())) {
            A(str);
            return true;
        }
        this.f45344a.z().f(this.f45344a.A(), null, new a(str));
        return true;
    }

    public boolean z(String str, String str2) {
        if (TextUtils.isEmpty(str2) && (str.equals("mapp_request_duxiaoman") || str.equals("mapp_request_alipayment"))) {
            this.f45345b.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        this.f45344a.R().g(this.f45344a.n(), str, new i(str, str2));
        UnitedSchemeUtility.callCallback(this.f45346c, this.f45345b, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }
}
