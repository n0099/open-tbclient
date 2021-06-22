package d.a.m0.a.q1;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.retrieve.RetrieveTaskManager;
import com.baidu.android.lbspay.presenter.LBSTransAuthPresenter;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.wallet.core.beans.BeanConstants;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.EventAlias;
import d.a.m0.a.e2.c.j.b;
import d.a.m0.a.f1.e.b;
import d.a.m0.a.k;
import d.a.m0.a.l;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b implements d.a.m0.a.q1.g.a {
    public static final boolean j = k.f46983a;
    public static String[] k = {"duershow"};

    /* renamed from: a  reason: collision with root package name */
    public d.a.m0.a.a2.e f47954a;

    /* renamed from: b  reason: collision with root package name */
    public UnitedSchemeEntity f47955b;

    /* renamed from: c  reason: collision with root package name */
    public CallbackHandler f47956c;

    /* renamed from: d  reason: collision with root package name */
    public String f47957d;

    /* renamed from: e  reason: collision with root package name */
    public String f47958e;

    /* renamed from: f  reason: collision with root package name */
    public int f47959f;

    /* renamed from: g  reason: collision with root package name */
    public String f47960g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.b0.a f47961h = new d.a.b0.a();

    /* renamed from: i  reason: collision with root package name */
    public String f47962i;

    /* loaded from: classes3.dex */
    public class a implements d.a.m0.a.m.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f47963e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47964f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f47965g;

        public a(boolean z, String str, String str2) {
            this.f47963e = z;
            this.f47964f = str;
            this.f47965g = str2;
        }

        @Override // d.a.m0.a.m.a
        public void onResult(int i2) {
            if (i2 == 0) {
                if (!this.f47963e) {
                    d.a.m0.a.j2.k.M("success", 9, this.f47964f);
                }
                b.this.B(this.f47965g);
                return;
            }
            if (!this.f47963e) {
                d.a.m0.a.j2.k.M(com.baidu.pass.biometrics.face.liveness.b.a.g0, 9, this.f47964f);
            }
            b.this.f47959f = 5;
            b.this.f47960g = null;
            b.this.K(null);
        }
    }

    /* renamed from: d.a.m0.a.q1.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0861b implements d.a.b0.e.a {
        public C0861b() {
        }

        @Override // d.a.b0.e.a
        public void onPayResult(int i2, String str) {
            b.this.f47959f = i2;
            b.this.f47960g = str;
            if (b.j) {
                Log.d("SwanAppPaymentManager", "statusCode: " + i2 + " ,result:" + str);
            }
            b.this.M(i2, "baiduqianbao", str);
            d.a.m0.a.j2.k.F("baiduqianbao", "result", i2);
            if (i2 != 0 || !TextUtils.equals(b.this.f47957d, "2.0")) {
                b.this.K(null);
            } else {
                d.a.m0.a.c1.a.R().e(b.this.f47958e, b.this);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.a.b0.e.a {
        public c() {
        }

        @Override // d.a.b0.e.a
        public void onPayResult(int i2, String str) {
            b.this.f47959f = i2;
            b.this.f47960g = str;
            d.a.m0.a.e0.d.h("SwanAppPaymentManager", "statusCode: " + b.this.f47959f + " ,result:" + b.this.f47960g);
            b.this.M(i2, LBSTransAuthPresenter.AUTH_CHANNEL_ALI, str);
            if (i2 != 1) {
                d.a.m0.a.j2.k.F(LBSTransAuthPresenter.AUTH_CHANNEL_ALI, "result", i2);
            }
            if (i2 != 0 || !TextUtils.equals(b.this.f47957d, "2.0")) {
                b.this.K(null);
            } else {
                d.a.m0.a.c1.a.R().e(b.this.f47958e, b.this);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements d.a.m0.a.m.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47969e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47970f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String[] f47971g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ JSONObject f47972h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ boolean f47973i;

        public d(String str, String str2, String[] strArr, JSONObject jSONObject, boolean z) {
            this.f47969e = str;
            this.f47970f = str2;
            this.f47971g = strArr;
            this.f47972h = jSONObject;
            this.f47973i = z;
        }

        @Override // d.a.m0.a.m.a
        public void onResult(int i2) {
            if (i2 == 0) {
                d.a.m0.a.j2.k.M("success", 8, this.f47969e);
                if (b.this.f47954a.m0()) {
                    b.this.F(this.f47970f, this.f47971g, this.f47972h, true, false);
                    return;
                } else {
                    b.this.C(this.f47970f, this.f47971g, this.f47972h, true, false);
                    return;
                }
            }
            if (!this.f47973i) {
                d.a.m0.a.j2.k.M(com.baidu.pass.biometrics.face.liveness.b.a.g0, 8, this.f47969e);
                d.a.m0.a.e0.d.h("SwanAppPaymentManager", "login error");
                d.a.m0.a.j2.k.D(false, BeanConstants.CHANNEL_ID_NUOMI, d.a.m0.a.q1.a.c("", "login error"));
            }
            b.this.f47959f = 5;
            b.this.f47960g = null;
            b.this.K(null);
            d.a.m0.a.j2.k.E(BeanConstants.CHANNEL_ID_NUOMI, false, false);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements j {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f47974a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String[] f47975b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ JSONObject f47976c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f47977d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f47978e;

        public e(String str, String[] strArr, JSONObject jSONObject, boolean z, boolean z2) {
            this.f47974a = str;
            this.f47975b = strArr;
            this.f47976c = jSONObject;
            this.f47977d = z;
            this.f47978e = z2;
        }

        @Override // d.a.m0.a.q1.b.j
        public void onFail(String str) {
            if (TextUtils.isEmpty(b.this.f47962i)) {
                return;
            }
            CallbackHandler callbackHandler = b.this.f47956c;
            String str2 = b.this.f47962i;
            callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, 6, b.this.f47954a.x().getString(d.a.m0.a.h.swan_game_anti_addiction) + str).toString());
        }

        @Override // d.a.m0.a.q1.b.j
        public void onSuccess() {
            b.this.C(this.f47974a, this.f47975b, this.f47976c, this.f47977d, this.f47978e);
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Function1<Boolean, Unit> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f47980e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String[] f47981f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONObject f47982g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f47983h;

        public f(JSONObject jSONObject, String[] strArr, JSONObject jSONObject2, String str) {
            this.f47980e = jSONObject;
            this.f47981f = strArr;
            this.f47982g = jSONObject2;
            this.f47983h = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a */
        public Unit invoke(Boolean bool) {
            if (bool.booleanValue()) {
                b.this.D(this.f47980e, this.f47981f, this.f47982g);
                return null;
            }
            d.a.m0.a.e0.d.h("SwanAppPaymentManager", "paykey invalid order info " + this.f47983h);
            d.a.m0.a.j2.k.D(false, BeanConstants.CHANNEL_ID_NUOMI, d.a.m0.a.q1.a.c("", "paykey invalid"));
            b.this.L();
            return null;
        }
    }

    /* loaded from: classes3.dex */
    public class g implements d.a.m0.a.q1.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ JSONObject f47985a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JSONObject f47986b;

        public g(JSONObject jSONObject, JSONObject jSONObject2) {
            this.f47985a = jSONObject;
            this.f47986b = jSONObject2;
        }

        @Override // d.a.m0.a.q1.d
        public void onPayResult(int i2, String str) {
            b.this.J(i2, str, this.f47985a, this.f47986b);
        }
    }

    /* loaded from: classes3.dex */
    public class h implements d.a.b0.e.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ JSONObject f47988a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JSONObject f47989b;

        public h(JSONObject jSONObject, JSONObject jSONObject2) {
            this.f47988a = jSONObject;
            this.f47989b = jSONObject2;
        }

        @Override // d.a.b0.e.a
        public void onPayResult(int i2, String str) {
            b.this.J(i2, str, this.f47988a, this.f47989b);
        }
    }

    /* loaded from: classes3.dex */
    public class i implements d.a.m0.a.v2.e1.b<d.a.m0.a.e2.c.i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47991e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47992f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f47993g;

        public i(String str, String str2, String str3) {
            this.f47991e = str;
            this.f47992f = str2;
            this.f47993g = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x00c7, code lost:
            if (r10.equals("mapp_request_duxiaoman") != false) goto L35;
         */
        @Override // d.a.m0.a.v2.e1.b
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onCallback(d.a.m0.a.e2.c.i<b.e> iVar) {
            char c2 = 0;
            if (!d.a.m0.a.e2.c.d.h(iVar)) {
                String str = null;
                if (TextUtils.equals(b.this.f47957d, "2.0")) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("payId", "");
                    } catch (JSONException e2) {
                        if (b.j) {
                            e2.printStackTrace();
                        }
                    }
                    str = String.valueOf(jSONObject);
                }
                if (TextUtils.equals(this.f47991e, "mapp_request_duxiaoman")) {
                    d.a.m0.a.j2.k.D(false, "baiduqianbao", d.a.m0.a.q1.a.c("", "authorize fail"));
                } else if (TextUtils.equals(this.f47991e, "mapp_request_alipayment")) {
                    d.a.m0.a.j2.k.D(false, LBSTransAuthPresenter.AUTH_CHANNEL_ALI, d.a.m0.a.q1.a.c("", "authorize fail"));
                } else if (TextUtils.equals(this.f47991e, "mapp_request_wechatpayment")) {
                    d.a.m0.a.j2.k.D(false, "wechatH5Action", d.a.m0.a.q1.a.c("", "authorize fail"));
                }
                d.a.m0.a.e0.d.h("SwanAppPaymentManager", "Error: authorized fail. scope = " + this.f47991e);
                b.this.f47956c.handleSchemeDispatchCallback(b.this.f47962i, UnitedSchemeUtility.wrapCallbackParamsWithBase64(str, 1001, "authorize denied").toString());
                return;
            }
            String str2 = this.f47991e;
            int hashCode = str2.hashCode();
            if (hashCode == -1689456891) {
                if (str2.equals("mapp_request_wechatpayment")) {
                    c2 = 2;
                }
                c2 = 65535;
            } else if (hashCode != -1250772529) {
                if (hashCode == 1111965155 && str2.equals("mapp_request_alipayment")) {
                    c2 = 1;
                }
                c2 = 65535;
            }
            if (c2 == 0) {
                b.this.z(this.f47992f, this.f47993g);
            } else if (c2 == 1) {
                b.this.x(this.f47992f);
            } else if (c2 != 2) {
            } else {
                b.this.N();
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface j {
        void onFail(String str);

        void onSuccess();
    }

    public b(d.a.m0.a.a2.e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, String str2, String str3) {
        this.f47954a = eVar;
        this.f47955b = unitedSchemeEntity;
        this.f47956c = callbackHandler;
        this.f47957d = str;
        this.f47958e = str2;
        this.f47962i = str3;
    }

    public static String H(int i2) {
        return i2 != 0 ? i2 != 2 ? EventAlias.PayEventAlias.PAY_FAIL : "支付取消" : EventAlias.PayEventAlias.PAY_SUCCESS;
    }

    public boolean A(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) && (str.equals("mapp_request_duxiaoman") || str.equals("mapp_request_alipayment"))) {
            this.f47955b.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            d.a.m0.a.e0.d.h("SwanAppPaymentManager", "Error: order info is null.");
            return false;
        }
        this.f47954a.T().g(this.f47954a.x(), str, new i(str, str2, str3));
        UnitedSchemeUtility.callCallback(this.f47956c, this.f47955b, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }

    public final void B(String str) {
        d.a.m0.a.j2.k.F("baiduqianbao", "intoPayment", 0);
        this.f47961h.d(this.f47954a.k(), str, new C0861b());
    }

    public final void C(String str, String[] strArr, JSONObject jSONObject, boolean z, boolean z2) {
        E(str, strArr, jSONObject);
        d.a.m0.a.j2.k.E(BeanConstants.CHANNEL_ID_NUOMI, z, z2);
    }

    public final void D(JSONObject jSONObject, String[] strArr, JSONObject jSONObject2) {
        boolean z;
        try {
            if (d.a.m0.a.s.a.f.f48364d.f()) {
                jSONObject.put("openBduss", d.a.m0.a.c1.a.a0().d(d.a.m0.a.c1.a.b()));
                jSONObject.put("clientId", d.a.m0.a.c1.a.m().b());
            } else {
                jSONObject.put("bduss", d.a.m0.a.c1.a.a0().d(d.a.m0.a.c1.a.b()));
            }
            jSONObject.put("cuid", d.a.m0.a.c1.a.a0().i(d.a.m0.a.c1.a.b()));
            String optString = jSONObject.optString("bizInfo");
            JSONObject jSONObject3 = TextUtils.isEmpty(optString) ? new JSONObject() : new JSONObject(optString);
            jSONObject3.put("swanFrom", this.f47954a.L().T());
            jSONObject3.put("cuid", d.a.m0.a.c1.a.a0().i(d.a.m0.a.c1.a.b()));
            jSONObject3.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, d.a.m0.a.a2.d.g().getAppId());
            w(jSONObject3);
            jSONObject.put("bizInfo", jSONObject3.toString());
            jSONObject.put("platformId", "100003");
            jSONObject.put("nativeAppId", d.a.m0.a.c1.a.m().a());
            jSONObject.put("sceneSource", "swan");
            jSONObject.put("swanNativeVersion", l.a());
            y(jSONObject, this.f47954a.D());
            if (j) {
                Log.i("SwanAppPaymentManager", jSONObject.toString());
            }
        } catch (JSONException e2) {
            if (k.f46983a) {
                e2.printStackTrace();
            }
        }
        d.a.m0.a.g1.f.V().p();
        String[] strArr2 = k;
        int length = strArr2.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                z = false;
                break;
            } else if (strArr2[i2].equals(d.a.m0.a.c1.a.m().a())) {
                z = true;
                break;
            } else {
                i2++;
            }
        }
        d.a.m0.a.j2.k.F(BeanConstants.CHANNEL_ID_NUOMI, "intoPayment", 0);
        if (z) {
            String a2 = d.a.m0.t.i.a(d.a.m0.t.i.a("https://etrade.baidu.com/cashier/create-qrcode", "orderInfo", Uri.encode(jSONObject.toString())), "deviceType", "ANDROID");
            d.a.m0.a.h0.g.k.Q2("qrCodePay", d.a.m0.a.l1.b.e(a2, a2));
            d.a.m0.a.q1.e.b(new g(jSONObject2, jSONObject));
            d.a.m0.a.e0.d.h("SwanAppPaymentManager", "doPolymerPay Qr Code: " + jSONObject.toString());
        } else {
            this.f47961h.i(this.f47954a.x(), jSONObject, strArr, new h(jSONObject2, jSONObject));
            d.a.m0.a.e0.d.h("SwanAppPaymentManager", "doPolymerPay: " + jSONObject.toString());
        }
        UnitedSchemeUtility.callCallback(this.f47956c, this.f47955b, UnitedSchemeUtility.wrapCallbackParams(0));
        if (this.f47954a.z() != null) {
            String valueOf = String.valueOf(this.f47954a.L().G());
            String valueOf2 = String.valueOf(UnitedSchemeUtility.getParams(this.f47954a.L().W()).get("_baiduboxapp"));
            Bundle bundle = new Bundle();
            bundle.putString("frameType", valueOf);
            bundle.putString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f47954a.L().H());
            try {
                bundle.putString("params", URLEncoder.encode(valueOf2, "UTF-8"));
            } catch (UnsupportedEncodingException e3) {
                if (j) {
                    throw new RuntimeException("This method requires UTF-8 encoding support", e3);
                }
            }
            this.f47954a.z().N(7, bundle);
        }
    }

    public final void E(String str, String[] strArr, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            d.a.m0.a.n1.q.c.d.b(jSONObject2.optString("appKey"), new f(jSONObject2, strArr, jSONObject, str));
        } catch (JSONException e2) {
            L();
            d.a.m0.a.e0.d.h("SwanAppPaymentManager", " doPolymerPayChecked error " + str);
            if (k.f46983a) {
                e2.printStackTrace();
            }
        }
    }

    public final void F(String str, String[] strArr, JSONObject jSONObject, boolean z, boolean z2) {
        d.a.m0.a.c1.b.e().a(str, new e(str, strArr, jSONObject, z, z2));
    }

    public final String G(String str, JSONObject jSONObject) {
        String optString = jSONObject.optString("tpOrderId");
        try {
            return new JSONObject(str).put("orderId", optString).toString();
        } catch (JSONException e2) {
            if (j) {
                e2.printStackTrace();
            }
            return str + " orderId = " + optString;
        }
    }

    public boolean I(String str, JSONObject jSONObject) {
        String[] strArr;
        Object opt;
        String optString = jSONObject.optString("invokeFrom");
        if (TextUtils.isEmpty(optString)) {
            optString = RetrieveTaskManager.KEY;
        }
        String str2 = optString;
        boolean e2 = this.f47954a.j().e(this.f47954a.x());
        if (!e2) {
            d.a.m0.a.j2.k.M("show", 8, str2);
        }
        if (TextUtils.isEmpty(str)) {
            this.f47955b.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        String optString2 = jSONObject.optString("__plugin__");
        d.a.m0.a.t1.d.a.a("start payment");
        if (!TextUtils.isEmpty(optString2) && (opt = jSONObject.opt("error")) != null) {
            String optString3 = jSONObject.optString("slaveId");
            d.a.m0.a.t1.c.c.a aVar = new d.a.m0.a.t1.c.c.a(jSONObject.optString("componentId"));
            aVar.f48543a = optString3;
            aVar.f48545c = opt;
            aVar.f48546d = false;
            aVar.f48547e = null;
            aVar.b();
            d.a.m0.a.e0.d.h("SwanAppPaymentManager", "Error: param check error - plugin pay contains custom error");
            d.a.m0.a.j2.k.D(false, BeanConstants.CHANNEL_ID_NUOMI, d.a.m0.a.q1.a.c("", "param check error - plugin pay contains custom error"));
            this.f47955b.result = UnitedSchemeUtility.wrapCallbackParams(1001);
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
        d.a.m0.a.j2.k.F(BeanConstants.CHANNEL_ID_NUOMI, "login", 0);
        if (this.f47954a.x() == null) {
            this.f47959f = 5;
            this.f47960g = null;
            K(null);
            if (j) {
                throw new RuntimeException("swanApp getActivity returns null");
            }
            return true;
        } else if (this.f47954a.j().e(this.f47954a.k())) {
            if (this.f47954a.m0()) {
                F(str, strArr, jSONObject, true, true);
                return true;
            }
            C(str, strArr, jSONObject, true, true);
            return true;
        } else {
            this.f47954a.j().f(this.f47954a.k(), null, new d(str2, str, strArr, jSONObject, e2));
            return true;
        }
    }

    public final void J(int i2, String str, JSONObject jSONObject, JSONObject jSONObject2) {
        d.a.m0.a.g1.f.V().b();
        d.a.m0.a.e0.d.g("SwanAppPaymentManager", "sendSecondCallback statusCode: " + this.f47959f + " params: " + this.f47960g + " payParams: " + jSONObject.toString() + " orderId: " + jSONObject2.optString("tpOrderId"));
        M(i2, BeanConstants.CHANNEL_ID_NUOMI, G(str, jSONObject2));
        this.f47959f = i2;
        this.f47960g = str;
        if (i2 != 1) {
            d.a.m0.a.j2.k.F(BeanConstants.CHANNEL_ID_NUOMI, "result", i2);
        }
        K(null);
        if (jSONObject != null && !TextUtils.isEmpty(jSONObject.optString("__plugin__"))) {
            String optString = jSONObject.optString("slaveId");
            String optString2 = jSONObject.optString("componentId");
            Object opt = jSONObject.opt("error");
            d.a.m0.a.t1.c.c.a aVar = new d.a.m0.a.t1.c.c.a(optString2);
            aVar.f48543a = optString;
            aVar.f48545c = opt;
            aVar.f48546d = i2 == 0;
            aVar.f48547e = str;
            aVar.b();
            d.a.m0.a.t1.g.b.j();
        }
        if (this.f47959f != 0 || d.a.m0.a.x1.c.f49544c.c()) {
            return;
        }
        d.a.m0.a.x1.c.f49544c.e();
    }

    public final void K(String str) {
        try {
            if (TextUtils.equals(this.f47957d, "2.0")) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("payId", str);
                if (!TextUtils.isEmpty(this.f47960g)) {
                    jSONObject.put("payResult", Base64.encodeToString(this.f47960g.getBytes("UTF-8"), 2));
                }
                d.a.m0.a.e0.d.g("SwanAppPaymentManager", "Success: sendSecondCallback, data = " + jSONObject + " status code = " + this.f47959f);
                this.f47956c.handleSchemeDispatchCallback(this.f47962i, UnitedSchemeUtility.wrapCallbackParams(jSONObject, this.f47959f, H(this.f47959f)).toString());
                return;
            }
            d.a.m0.a.e0.d.g("SwanAppPaymentManager", "Success: sendSecondCallback, result = " + this.f47960g + " status code = " + this.f47959f);
            this.f47956c.handleSchemeDispatchCallback(this.f47962i, UnitedSchemeUtility.wrapCallbackParamsWithBase64(this.f47960g, this.f47959f, H(this.f47959f)).toString());
        } catch (UnsupportedEncodingException | JSONException e2) {
            d.a.m0.a.e0.d.g("SwanAppPaymentManager", "Fail: sendSecondCallback exception , exception = " + e2.getMessage() + " stack trace = " + Arrays.toString(e2.getStackTrace()));
            CallbackHandler callbackHandler = this.f47956c;
            String str2 = this.f47962i;
            int i2 = this.f47959f;
            callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, i2, H(i2)).toString());
        }
    }

    public final void L() {
        d.a.m0.a.a2.e eVar = this.f47954a;
        if (eVar != null) {
            d.a.m0.a.z1.b.f.e.f(eVar.x(), d.a.m0.a.h.swanapp_payment_illegal).F();
            if (TextUtils.isEmpty(this.f47962i)) {
                return;
            }
            this.f47956c.handleSchemeDispatchCallback(this.f47962i, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, 6, this.f47954a.x().getString(d.a.m0.a.h.swanapp_payment_illegal)).toString());
        }
    }

    public final void M(int i2, String str, String str2) {
        d.a.m0.a.j2.k.D(i2 == 0, str, str2);
    }

    public final boolean N() {
        d.a.m0.a.e0.d.g("SwanAppPaymentManager", "start UnitedSchemeWalletDispatcher ACTION_REQUEST_WECHAT_PAYMENT");
        if (d.a.m0.a.q1.a.b().e(this.f47954a, this.f47956c, this.f47955b)) {
            this.f47959f = 0;
            this.f47960g = null;
            if (TextUtils.equals(this.f47957d, "2.0")) {
                d.a.m0.a.c1.a.R().e(this.f47958e, this);
            } else {
                K(null);
            }
            d.a.m0.a.j2.k.C("wechatH5Action", null, null);
            return true;
        }
        d.a.m0.a.e0.d.h("SwanAppPaymentManager", "Error: open webview error.  entity = " + this.f47955b.toString());
        this.f47956c.handleSchemeDispatchCallback(this.f47962i, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
        return false;
    }

    @Override // d.a.m0.a.x1.a
    public void a(JSONObject jSONObject) {
        String str;
        d.a.m0.a.e0.d.b("SwanAppPaymentManager", "Info: getPayId Request Response =  " + jSONObject.toString());
        if (jSONObject.optInt("errno") == 0) {
            str = jSONObject.optJSONObject("data").optString("payid");
            d.a.m0.a.e0.d.b("SwanAppPaymentManager", "Info: payId =  " + str);
        } else {
            str = null;
        }
        K(str);
        if (d.a.m0.a.x1.c.f49544c.c()) {
            return;
        }
        if (d.a.m0.a.c1.a.a0().e(this.f47954a)) {
            d.a.m0.a.x1.c.f49544c.e();
        } else {
            d.a.m0.a.x1.c.f49544c.f();
        }
    }

    @Override // d.a.m0.a.x1.a
    public void onFail(String str) {
        d.a.m0.a.e0.d.b("SwanAppPaymentManager", "Fail: request payId failed");
        d.a.m0.a.e0.d.b("SwanAppPaymentManager", str);
        K(null);
    }

    public final JSONObject w(JSONObject jSONObject) {
        if (this.f47954a.m0() && jSONObject != null) {
            b.a L = this.f47954a.L();
            if (L.M() == null) {
                return jSONObject;
            }
            JSONObject M = L.M();
            String optString = M.optString("log_id");
            String optString2 = M.optString("module_id");
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
        d.a.m0.a.j2.k.F(LBSTransAuthPresenter.AUTH_CHANNEL_ALI, "intoPayment", 0);
        this.f47961h.c(this.f47954a.k(), str, new c());
        return true;
    }

    public final void y(@NonNull JSONObject jSONObject, @NonNull String str) throws JSONException {
        PMSAppInfo s = d.a.m0.n.g.a.h().s(str);
        int i2 = s == null ? PMSConstants.PayProtected.NO_PAY_PROTECTED.type : s.payProtected;
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("baoStatus", i2);
        jSONObject2.put("sappId", 10001);
        jSONObject2.put("objectId", str);
        jSONObject.put("baoInfo", jSONObject2.toString());
    }

    public final boolean z(String str, String str2) {
        if (this.f47954a.j().e(this.f47954a.k())) {
            B(str);
            return true;
        }
        d.a.m0.a.a2.e eVar = this.f47954a;
        if (eVar == null) {
            return false;
        }
        boolean e2 = eVar.j().e(this.f47954a.x());
        if (!e2) {
            d.a.m0.a.j2.k.M("show", 9, str2);
        }
        this.f47954a.j().f(this.f47954a.k(), null, new a(e2, str2, str));
        return true;
    }
}
