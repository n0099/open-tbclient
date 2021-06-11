package d.a.l0.a.q1;

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
import d.a.l0.a.e2.c.j.b;
import d.a.l0.a.f1.e.b;
import d.a.l0.a.k;
import d.a.l0.a.l;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b implements d.a.l0.a.q1.g.a {
    public static final boolean j = k.f46875a;
    public static String[] k = {"duershow"};

    /* renamed from: a  reason: collision with root package name */
    public d.a.l0.a.a2.e f47846a;

    /* renamed from: b  reason: collision with root package name */
    public UnitedSchemeEntity f47847b;

    /* renamed from: c  reason: collision with root package name */
    public CallbackHandler f47848c;

    /* renamed from: d  reason: collision with root package name */
    public String f47849d;

    /* renamed from: e  reason: collision with root package name */
    public String f47850e;

    /* renamed from: f  reason: collision with root package name */
    public int f47851f;

    /* renamed from: g  reason: collision with root package name */
    public String f47852g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.b0.a f47853h = new d.a.b0.a();

    /* renamed from: i  reason: collision with root package name */
    public String f47854i;

    /* loaded from: classes3.dex */
    public class a implements d.a.l0.a.m.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f47855e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47856f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f47857g;

        public a(boolean z, String str, String str2) {
            this.f47855e = z;
            this.f47856f = str;
            this.f47857g = str2;
        }

        @Override // d.a.l0.a.m.a
        public void onResult(int i2) {
            if (i2 == 0) {
                if (!this.f47855e) {
                    d.a.l0.a.j2.k.M("success", 9, this.f47856f);
                }
                b.this.B(this.f47857g);
                return;
            }
            if (!this.f47855e) {
                d.a.l0.a.j2.k.M(com.baidu.pass.biometrics.face.liveness.b.b.g0, 9, this.f47856f);
            }
            b.this.f47851f = 5;
            b.this.f47852g = null;
            b.this.K(null);
        }
    }

    /* renamed from: d.a.l0.a.q1.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0858b implements d.a.b0.e.a {
        public C0858b() {
        }

        @Override // d.a.b0.e.a
        public void onPayResult(int i2, String str) {
            b.this.f47851f = i2;
            b.this.f47852g = str;
            if (b.j) {
                Log.d("SwanAppPaymentManager", "statusCode: " + i2 + " ,result:" + str);
            }
            b.this.M(i2, "baiduqianbao", str);
            d.a.l0.a.j2.k.F("baiduqianbao", "result", i2);
            if (i2 != 0 || !TextUtils.equals(b.this.f47849d, "2.0")) {
                b.this.K(null);
            } else {
                d.a.l0.a.c1.a.R().e(b.this.f47850e, b.this);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.a.b0.e.a {
        public c() {
        }

        @Override // d.a.b0.e.a
        public void onPayResult(int i2, String str) {
            b.this.f47851f = i2;
            b.this.f47852g = str;
            d.a.l0.a.e0.d.h("SwanAppPaymentManager", "statusCode: " + b.this.f47851f + " ,result:" + b.this.f47852g);
            b.this.M(i2, LBSTransAuthPresenter.AUTH_CHANNEL_ALI, str);
            if (i2 != 1) {
                d.a.l0.a.j2.k.F(LBSTransAuthPresenter.AUTH_CHANNEL_ALI, "result", i2);
            }
            if (i2 != 0 || !TextUtils.equals(b.this.f47849d, "2.0")) {
                b.this.K(null);
            } else {
                d.a.l0.a.c1.a.R().e(b.this.f47850e, b.this);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements d.a.l0.a.m.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47861e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47862f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String[] f47863g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ JSONObject f47864h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ boolean f47865i;

        public d(String str, String str2, String[] strArr, JSONObject jSONObject, boolean z) {
            this.f47861e = str;
            this.f47862f = str2;
            this.f47863g = strArr;
            this.f47864h = jSONObject;
            this.f47865i = z;
        }

        @Override // d.a.l0.a.m.a
        public void onResult(int i2) {
            if (i2 == 0) {
                d.a.l0.a.j2.k.M("success", 8, this.f47861e);
                if (b.this.f47846a.m0()) {
                    b.this.F(this.f47862f, this.f47863g, this.f47864h, true, false);
                    return;
                } else {
                    b.this.C(this.f47862f, this.f47863g, this.f47864h, true, false);
                    return;
                }
            }
            if (!this.f47865i) {
                d.a.l0.a.j2.k.M(com.baidu.pass.biometrics.face.liveness.b.b.g0, 8, this.f47861e);
                d.a.l0.a.e0.d.h("SwanAppPaymentManager", "login error");
                d.a.l0.a.j2.k.D(false, BeanConstants.CHANNEL_ID_NUOMI, d.a.l0.a.q1.a.c("", "login error"));
            }
            b.this.f47851f = 5;
            b.this.f47852g = null;
            b.this.K(null);
            d.a.l0.a.j2.k.E(BeanConstants.CHANNEL_ID_NUOMI, false, false);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements j {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f47866a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String[] f47867b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ JSONObject f47868c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f47869d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f47870e;

        public e(String str, String[] strArr, JSONObject jSONObject, boolean z, boolean z2) {
            this.f47866a = str;
            this.f47867b = strArr;
            this.f47868c = jSONObject;
            this.f47869d = z;
            this.f47870e = z2;
        }

        @Override // d.a.l0.a.q1.b.j
        public void onFail(String str) {
            if (TextUtils.isEmpty(b.this.f47854i)) {
                return;
            }
            CallbackHandler callbackHandler = b.this.f47848c;
            String str2 = b.this.f47854i;
            callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, 6, b.this.f47846a.x().getString(d.a.l0.a.h.swan_game_anti_addiction) + str).toString());
        }

        @Override // d.a.l0.a.q1.b.j
        public void onSuccess() {
            b.this.C(this.f47866a, this.f47867b, this.f47868c, this.f47869d, this.f47870e);
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Function1<Boolean, Unit> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f47872e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String[] f47873f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONObject f47874g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f47875h;

        public f(JSONObject jSONObject, String[] strArr, JSONObject jSONObject2, String str) {
            this.f47872e = jSONObject;
            this.f47873f = strArr;
            this.f47874g = jSONObject2;
            this.f47875h = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a */
        public Unit invoke(Boolean bool) {
            if (bool.booleanValue()) {
                b.this.D(this.f47872e, this.f47873f, this.f47874g);
                return null;
            }
            d.a.l0.a.e0.d.h("SwanAppPaymentManager", "paykey invalid order info " + this.f47875h);
            d.a.l0.a.j2.k.D(false, BeanConstants.CHANNEL_ID_NUOMI, d.a.l0.a.q1.a.c("", "paykey invalid"));
            b.this.L();
            return null;
        }
    }

    /* loaded from: classes3.dex */
    public class g implements d.a.l0.a.q1.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ JSONObject f47877a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JSONObject f47878b;

        public g(JSONObject jSONObject, JSONObject jSONObject2) {
            this.f47877a = jSONObject;
            this.f47878b = jSONObject2;
        }

        @Override // d.a.l0.a.q1.d
        public void onPayResult(int i2, String str) {
            b.this.J(i2, str, this.f47877a, this.f47878b);
        }
    }

    /* loaded from: classes3.dex */
    public class h implements d.a.b0.e.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ JSONObject f47880a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JSONObject f47881b;

        public h(JSONObject jSONObject, JSONObject jSONObject2) {
            this.f47880a = jSONObject;
            this.f47881b = jSONObject2;
        }

        @Override // d.a.b0.e.a
        public void onPayResult(int i2, String str) {
            b.this.J(i2, str, this.f47880a, this.f47881b);
        }
    }

    /* loaded from: classes3.dex */
    public class i implements d.a.l0.a.v2.e1.b<d.a.l0.a.e2.c.i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47883e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47884f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f47885g;

        public i(String str, String str2, String str3) {
            this.f47883e = str;
            this.f47884f = str2;
            this.f47885g = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x00c7, code lost:
            if (r10.equals("mapp_request_duxiaoman") != false) goto L35;
         */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onCallback(d.a.l0.a.e2.c.i<b.e> iVar) {
            char c2 = 0;
            if (!d.a.l0.a.e2.c.d.h(iVar)) {
                String str = null;
                if (TextUtils.equals(b.this.f47849d, "2.0")) {
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
                if (TextUtils.equals(this.f47883e, "mapp_request_duxiaoman")) {
                    d.a.l0.a.j2.k.D(false, "baiduqianbao", d.a.l0.a.q1.a.c("", "authorize fail"));
                } else if (TextUtils.equals(this.f47883e, "mapp_request_alipayment")) {
                    d.a.l0.a.j2.k.D(false, LBSTransAuthPresenter.AUTH_CHANNEL_ALI, d.a.l0.a.q1.a.c("", "authorize fail"));
                } else if (TextUtils.equals(this.f47883e, "mapp_request_wechatpayment")) {
                    d.a.l0.a.j2.k.D(false, "wechatH5Action", d.a.l0.a.q1.a.c("", "authorize fail"));
                }
                d.a.l0.a.e0.d.h("SwanAppPaymentManager", "Error: authorized fail. scope = " + this.f47883e);
                b.this.f47848c.handleSchemeDispatchCallback(b.this.f47854i, UnitedSchemeUtility.wrapCallbackParamsWithBase64(str, 1001, "authorize denied").toString());
                return;
            }
            String str2 = this.f47883e;
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
                b.this.z(this.f47884f, this.f47885g);
            } else if (c2 == 1) {
                b.this.x(this.f47884f);
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

    public b(d.a.l0.a.a2.e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, String str2, String str3) {
        this.f47846a = eVar;
        this.f47847b = unitedSchemeEntity;
        this.f47848c = callbackHandler;
        this.f47849d = str;
        this.f47850e = str2;
        this.f47854i = str3;
    }

    public static String H(int i2) {
        return i2 != 0 ? i2 != 2 ? EventAlias.PayEventAlias.PAY_FAIL : "支付取消" : EventAlias.PayEventAlias.PAY_SUCCESS;
    }

    public boolean A(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) && (str.equals("mapp_request_duxiaoman") || str.equals("mapp_request_alipayment"))) {
            this.f47847b.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            d.a.l0.a.e0.d.h("SwanAppPaymentManager", "Error: order info is null.");
            return false;
        }
        this.f47846a.T().g(this.f47846a.x(), str, new i(str, str2, str3));
        UnitedSchemeUtility.callCallback(this.f47848c, this.f47847b, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }

    public final void B(String str) {
        d.a.l0.a.j2.k.F("baiduqianbao", "intoPayment", 0);
        this.f47853h.d(this.f47846a.k(), str, new C0858b());
    }

    public final void C(String str, String[] strArr, JSONObject jSONObject, boolean z, boolean z2) {
        E(str, strArr, jSONObject);
        d.a.l0.a.j2.k.E(BeanConstants.CHANNEL_ID_NUOMI, z, z2);
    }

    public final void D(JSONObject jSONObject, String[] strArr, JSONObject jSONObject2) {
        boolean z;
        try {
            if (d.a.l0.a.s.a.f.f48256d.f()) {
                jSONObject.put("openBduss", d.a.l0.a.c1.a.a0().d(d.a.l0.a.c1.a.b()));
                jSONObject.put("clientId", d.a.l0.a.c1.a.m().b());
            } else {
                jSONObject.put("bduss", d.a.l0.a.c1.a.a0().d(d.a.l0.a.c1.a.b()));
            }
            jSONObject.put("cuid", d.a.l0.a.c1.a.a0().i(d.a.l0.a.c1.a.b()));
            String optString = jSONObject.optString("bizInfo");
            JSONObject jSONObject3 = TextUtils.isEmpty(optString) ? new JSONObject() : new JSONObject(optString);
            jSONObject3.put("swanFrom", this.f47846a.L().T());
            jSONObject3.put("cuid", d.a.l0.a.c1.a.a0().i(d.a.l0.a.c1.a.b()));
            jSONObject3.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, d.a.l0.a.a2.d.g().getAppId());
            w(jSONObject3);
            jSONObject.put("bizInfo", jSONObject3.toString());
            jSONObject.put("platformId", "100003");
            jSONObject.put("nativeAppId", d.a.l0.a.c1.a.m().a());
            jSONObject.put("sceneSource", "swan");
            jSONObject.put("swanNativeVersion", l.a());
            y(jSONObject, this.f47846a.D());
            if (j) {
                Log.i("SwanAppPaymentManager", jSONObject.toString());
            }
        } catch (JSONException e2) {
            if (k.f46875a) {
                e2.printStackTrace();
            }
        }
        d.a.l0.a.g1.f.V().p();
        String[] strArr2 = k;
        int length = strArr2.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                z = false;
                break;
            } else if (strArr2[i2].equals(d.a.l0.a.c1.a.m().a())) {
                z = true;
                break;
            } else {
                i2++;
            }
        }
        d.a.l0.a.j2.k.F(BeanConstants.CHANNEL_ID_NUOMI, "intoPayment", 0);
        if (z) {
            String a2 = d.a.l0.t.i.a(d.a.l0.t.i.a("https://etrade.baidu.com/cashier/create-qrcode", "orderInfo", Uri.encode(jSONObject.toString())), "deviceType", "ANDROID");
            d.a.l0.a.h0.g.k.Q2("qrCodePay", d.a.l0.a.l1.b.e(a2, a2));
            d.a.l0.a.q1.e.b(new g(jSONObject2, jSONObject));
            d.a.l0.a.e0.d.h("SwanAppPaymentManager", "doPolymerPay Qr Code: " + jSONObject.toString());
        } else {
            this.f47853h.i(this.f47846a.x(), jSONObject, strArr, new h(jSONObject2, jSONObject));
            d.a.l0.a.e0.d.h("SwanAppPaymentManager", "doPolymerPay: " + jSONObject.toString());
        }
        UnitedSchemeUtility.callCallback(this.f47848c, this.f47847b, UnitedSchemeUtility.wrapCallbackParams(0));
        if (this.f47846a.z() != null) {
            String valueOf = String.valueOf(this.f47846a.L().G());
            String valueOf2 = String.valueOf(UnitedSchemeUtility.getParams(this.f47846a.L().W()).get("_baiduboxapp"));
            Bundle bundle = new Bundle();
            bundle.putString("frameType", valueOf);
            bundle.putString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f47846a.L().H());
            try {
                bundle.putString("params", URLEncoder.encode(valueOf2, "UTF-8"));
            } catch (UnsupportedEncodingException e3) {
                if (j) {
                    throw new RuntimeException("This method requires UTF-8 encoding support", e3);
                }
            }
            this.f47846a.z().N(7, bundle);
        }
    }

    public final void E(String str, String[] strArr, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            d.a.l0.a.n1.q.c.d.b(jSONObject2.optString("appKey"), new f(jSONObject2, strArr, jSONObject, str));
        } catch (JSONException e2) {
            L();
            d.a.l0.a.e0.d.h("SwanAppPaymentManager", " doPolymerPayChecked error " + str);
            if (k.f46875a) {
                e2.printStackTrace();
            }
        }
    }

    public final void F(String str, String[] strArr, JSONObject jSONObject, boolean z, boolean z2) {
        d.a.l0.a.c1.b.e().a(str, new e(str, strArr, jSONObject, z, z2));
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
        boolean e2 = this.f47846a.j().e(this.f47846a.x());
        if (!e2) {
            d.a.l0.a.j2.k.M("show", 8, str2);
        }
        if (TextUtils.isEmpty(str)) {
            this.f47847b.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        String optString2 = jSONObject.optString("__plugin__");
        d.a.l0.a.t1.d.a.a("start payment");
        if (!TextUtils.isEmpty(optString2) && (opt = jSONObject.opt("error")) != null) {
            String optString3 = jSONObject.optString("slaveId");
            d.a.l0.a.t1.c.c.a aVar = new d.a.l0.a.t1.c.c.a(jSONObject.optString("componentId"));
            aVar.f48435a = optString3;
            aVar.f48437c = opt;
            aVar.f48438d = false;
            aVar.f48439e = null;
            aVar.b();
            d.a.l0.a.e0.d.h("SwanAppPaymentManager", "Error: param check error - plugin pay contains custom error");
            d.a.l0.a.j2.k.D(false, BeanConstants.CHANNEL_ID_NUOMI, d.a.l0.a.q1.a.c("", "param check error - plugin pay contains custom error"));
            this.f47847b.result = UnitedSchemeUtility.wrapCallbackParams(1001);
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
        d.a.l0.a.j2.k.F(BeanConstants.CHANNEL_ID_NUOMI, "login", 0);
        if (this.f47846a.x() == null) {
            this.f47851f = 5;
            this.f47852g = null;
            K(null);
            if (j) {
                throw new RuntimeException("swanApp getActivity returns null");
            }
            return true;
        } else if (this.f47846a.j().e(this.f47846a.k())) {
            if (this.f47846a.m0()) {
                F(str, strArr, jSONObject, true, true);
                return true;
            }
            C(str, strArr, jSONObject, true, true);
            return true;
        } else {
            this.f47846a.j().f(this.f47846a.k(), null, new d(str2, str, strArr, jSONObject, e2));
            return true;
        }
    }

    public final void J(int i2, String str, JSONObject jSONObject, JSONObject jSONObject2) {
        d.a.l0.a.g1.f.V().b();
        d.a.l0.a.e0.d.g("SwanAppPaymentManager", "sendSecondCallback statusCode: " + this.f47851f + " params: " + this.f47852g + " payParams: " + jSONObject.toString() + " orderId: " + jSONObject2.optString("tpOrderId"));
        M(i2, BeanConstants.CHANNEL_ID_NUOMI, G(str, jSONObject2));
        this.f47851f = i2;
        this.f47852g = str;
        if (i2 != 1) {
            d.a.l0.a.j2.k.F(BeanConstants.CHANNEL_ID_NUOMI, "result", i2);
        }
        K(null);
        if (jSONObject != null && !TextUtils.isEmpty(jSONObject.optString("__plugin__"))) {
            String optString = jSONObject.optString("slaveId");
            String optString2 = jSONObject.optString("componentId");
            Object opt = jSONObject.opt("error");
            d.a.l0.a.t1.c.c.a aVar = new d.a.l0.a.t1.c.c.a(optString2);
            aVar.f48435a = optString;
            aVar.f48437c = opt;
            aVar.f48438d = i2 == 0;
            aVar.f48439e = str;
            aVar.b();
            d.a.l0.a.t1.g.b.j();
        }
        if (this.f47851f != 0 || d.a.l0.a.x1.c.f49436c.c()) {
            return;
        }
        d.a.l0.a.x1.c.f49436c.e();
    }

    public final void K(String str) {
        try {
            if (TextUtils.equals(this.f47849d, "2.0")) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("payId", str);
                if (!TextUtils.isEmpty(this.f47852g)) {
                    jSONObject.put("payResult", Base64.encodeToString(this.f47852g.getBytes("UTF-8"), 2));
                }
                d.a.l0.a.e0.d.g("SwanAppPaymentManager", "Success: sendSecondCallback, data = " + jSONObject + " status code = " + this.f47851f);
                this.f47848c.handleSchemeDispatchCallback(this.f47854i, UnitedSchemeUtility.wrapCallbackParams(jSONObject, this.f47851f, H(this.f47851f)).toString());
                return;
            }
            d.a.l0.a.e0.d.g("SwanAppPaymentManager", "Success: sendSecondCallback, result = " + this.f47852g + " status code = " + this.f47851f);
            this.f47848c.handleSchemeDispatchCallback(this.f47854i, UnitedSchemeUtility.wrapCallbackParamsWithBase64(this.f47852g, this.f47851f, H(this.f47851f)).toString());
        } catch (UnsupportedEncodingException | JSONException e2) {
            d.a.l0.a.e0.d.g("SwanAppPaymentManager", "Fail: sendSecondCallback exception , exception = " + e2.getMessage() + " stack trace = " + Arrays.toString(e2.getStackTrace()));
            CallbackHandler callbackHandler = this.f47848c;
            String str2 = this.f47854i;
            int i2 = this.f47851f;
            callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, i2, H(i2)).toString());
        }
    }

    public final void L() {
        d.a.l0.a.a2.e eVar = this.f47846a;
        if (eVar != null) {
            d.a.l0.a.z1.b.f.e.f(eVar.x(), d.a.l0.a.h.swanapp_payment_illegal).F();
            if (TextUtils.isEmpty(this.f47854i)) {
                return;
            }
            this.f47848c.handleSchemeDispatchCallback(this.f47854i, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, 6, this.f47846a.x().getString(d.a.l0.a.h.swanapp_payment_illegal)).toString());
        }
    }

    public final void M(int i2, String str, String str2) {
        d.a.l0.a.j2.k.D(i2 == 0, str, str2);
    }

    public final boolean N() {
        d.a.l0.a.e0.d.g("SwanAppPaymentManager", "start UnitedSchemeWalletDispatcher ACTION_REQUEST_WECHAT_PAYMENT");
        if (d.a.l0.a.q1.a.b().e(this.f47846a, this.f47848c, this.f47847b)) {
            this.f47851f = 0;
            this.f47852g = null;
            if (TextUtils.equals(this.f47849d, "2.0")) {
                d.a.l0.a.c1.a.R().e(this.f47850e, this);
            } else {
                K(null);
            }
            d.a.l0.a.j2.k.C("wechatH5Action", null, null);
            return true;
        }
        d.a.l0.a.e0.d.h("SwanAppPaymentManager", "Error: open webview error.  entity = " + this.f47847b.toString());
        this.f47848c.handleSchemeDispatchCallback(this.f47854i, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
        return false;
    }

    @Override // d.a.l0.a.x1.a
    public void a(JSONObject jSONObject) {
        String str;
        d.a.l0.a.e0.d.b("SwanAppPaymentManager", "Info: getPayId Request Response =  " + jSONObject.toString());
        if (jSONObject.optInt("errno") == 0) {
            str = jSONObject.optJSONObject("data").optString("payid");
            d.a.l0.a.e0.d.b("SwanAppPaymentManager", "Info: payId =  " + str);
        } else {
            str = null;
        }
        K(str);
        if (d.a.l0.a.x1.c.f49436c.c()) {
            return;
        }
        if (d.a.l0.a.c1.a.a0().e(this.f47846a)) {
            d.a.l0.a.x1.c.f49436c.e();
        } else {
            d.a.l0.a.x1.c.f49436c.f();
        }
    }

    @Override // d.a.l0.a.x1.a
    public void onFail(String str) {
        d.a.l0.a.e0.d.b("SwanAppPaymentManager", "Fail: request payId failed");
        d.a.l0.a.e0.d.b("SwanAppPaymentManager", str);
        K(null);
    }

    public final JSONObject w(JSONObject jSONObject) {
        if (this.f47846a.m0() && jSONObject != null) {
            b.a L = this.f47846a.L();
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
        d.a.l0.a.j2.k.F(LBSTransAuthPresenter.AUTH_CHANNEL_ALI, "intoPayment", 0);
        this.f47853h.c(this.f47846a.k(), str, new c());
        return true;
    }

    public final void y(@NonNull JSONObject jSONObject, @NonNull String str) throws JSONException {
        PMSAppInfo s = d.a.l0.n.g.a.h().s(str);
        int i2 = s == null ? PMSConstants.PayProtected.NO_PAY_PROTECTED.type : s.payProtected;
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("baoStatus", i2);
        jSONObject2.put("sappId", 10001);
        jSONObject2.put("objectId", str);
        jSONObject.put("baoInfo", jSONObject2.toString());
    }

    public final boolean z(String str, String str2) {
        if (this.f47846a.j().e(this.f47846a.k())) {
            B(str);
            return true;
        }
        d.a.l0.a.a2.e eVar = this.f47846a;
        if (eVar == null) {
            return false;
        }
        boolean e2 = eVar.j().e(this.f47846a.x());
        if (!e2) {
            d.a.l0.a.j2.k.M("show", 9, str2);
        }
        this.f47846a.j().f(this.f47846a.k(), null, new a(e2, str2, str));
        return true;
    }
}
