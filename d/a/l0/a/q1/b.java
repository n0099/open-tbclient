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
    public static final boolean j = k.f43199a;
    public static String[] k = {"duershow"};

    /* renamed from: a  reason: collision with root package name */
    public d.a.l0.a.a2.e f44172a;

    /* renamed from: b  reason: collision with root package name */
    public UnitedSchemeEntity f44173b;

    /* renamed from: c  reason: collision with root package name */
    public CallbackHandler f44174c;

    /* renamed from: d  reason: collision with root package name */
    public String f44175d;

    /* renamed from: e  reason: collision with root package name */
    public String f44176e;

    /* renamed from: f  reason: collision with root package name */
    public int f44177f;

    /* renamed from: g  reason: collision with root package name */
    public String f44178g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.b0.a f44179h = new d.a.b0.a();

    /* renamed from: i  reason: collision with root package name */
    public String f44180i;

    /* loaded from: classes3.dex */
    public class a implements d.a.l0.a.m.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f44181e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44182f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f44183g;

        public a(boolean z, String str, String str2) {
            this.f44181e = z;
            this.f44182f = str;
            this.f44183g = str2;
        }

        @Override // d.a.l0.a.m.a
        public void onResult(int i2) {
            if (i2 == 0) {
                if (!this.f44181e) {
                    d.a.l0.a.j2.k.M("success", 9, this.f44182f);
                }
                b.this.C(this.f44183g);
                return;
            }
            if (!this.f44181e) {
                d.a.l0.a.j2.k.M("fail", 9, this.f44182f);
            }
            b.this.f44177f = 5;
            b.this.f44178g = null;
            b.this.L(null);
        }
    }

    /* renamed from: d.a.l0.a.q1.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0802b implements d.a.b0.e.a {
        public C0802b() {
        }

        @Override // d.a.b0.e.a
        public void onPayResult(int i2, String str) {
            b.this.f44177f = i2;
            b.this.f44178g = str;
            if (b.j) {
                Log.d("SwanAppPaymentManager", "statusCode: " + i2 + " ,result:" + str);
            }
            b.this.N(i2, "baiduqianbao", str);
            d.a.l0.a.j2.k.F("baiduqianbao", "result", i2);
            if (i2 != 0 || !TextUtils.equals(b.this.f44175d, "2.0")) {
                b.this.L(null);
            } else {
                d.a.l0.a.c1.a.R().e(b.this.f44176e, b.this);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.a.b0.e.a {
        public c() {
        }

        @Override // d.a.b0.e.a
        public void onPayResult(int i2, String str) {
            b.this.f44177f = i2;
            b.this.f44178g = str;
            d.a.l0.a.e0.d.h("SwanAppPaymentManager", "statusCode: " + b.this.f44177f + " ,result:" + b.this.f44178g);
            b.this.N(i2, LBSTransAuthPresenter.AUTH_CHANNEL_ALI, str);
            if (i2 != 1) {
                d.a.l0.a.j2.k.F(LBSTransAuthPresenter.AUTH_CHANNEL_ALI, "result", i2);
            }
            if (i2 != 0 || !TextUtils.equals(b.this.f44175d, "2.0")) {
                b.this.L(null);
            } else {
                d.a.l0.a.c1.a.R().e(b.this.f44176e, b.this);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements d.a.l0.a.m.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44187e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44188f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String[] f44189g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ JSONObject f44190h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ boolean f44191i;

        public d(String str, String str2, String[] strArr, JSONObject jSONObject, boolean z) {
            this.f44187e = str;
            this.f44188f = str2;
            this.f44189g = strArr;
            this.f44190h = jSONObject;
            this.f44191i = z;
        }

        @Override // d.a.l0.a.m.a
        public void onResult(int i2) {
            if (i2 == 0) {
                d.a.l0.a.j2.k.M("success", 8, this.f44187e);
                if (b.this.f44172a.m0()) {
                    b.this.G(this.f44188f, this.f44189g, this.f44190h, true, false);
                    return;
                } else {
                    b.this.D(this.f44188f, this.f44189g, this.f44190h, true, false);
                    return;
                }
            }
            if (!this.f44191i) {
                d.a.l0.a.j2.k.M("fail", 8, this.f44187e);
                d.a.l0.a.e0.d.h("SwanAppPaymentManager", "login error");
                d.a.l0.a.j2.k.D(false, BeanConstants.CHANNEL_ID_NUOMI, d.a.l0.a.q1.a.c("", "login error"));
            }
            b.this.f44177f = 5;
            b.this.f44178g = null;
            b.this.L(null);
            d.a.l0.a.j2.k.E(BeanConstants.CHANNEL_ID_NUOMI, false, false);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements j {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f44192a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String[] f44193b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ JSONObject f44194c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f44195d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f44196e;

        public e(String str, String[] strArr, JSONObject jSONObject, boolean z, boolean z2) {
            this.f44192a = str;
            this.f44193b = strArr;
            this.f44194c = jSONObject;
            this.f44195d = z;
            this.f44196e = z2;
        }

        @Override // d.a.l0.a.q1.b.j
        public void a(String str) {
            if (TextUtils.isEmpty(b.this.f44180i)) {
                return;
            }
            CallbackHandler callbackHandler = b.this.f44174c;
            String str2 = b.this.f44180i;
            callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, 6, b.this.f44172a.x().getString(d.a.l0.a.h.swan_game_anti_addiction) + str).toString());
        }

        @Override // d.a.l0.a.q1.b.j
        public void onSuccess() {
            b.this.D(this.f44192a, this.f44193b, this.f44194c, this.f44195d, this.f44196e);
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Function1<Boolean, Unit> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f44198e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String[] f44199f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONObject f44200g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f44201h;

        public f(JSONObject jSONObject, String[] strArr, JSONObject jSONObject2, String str) {
            this.f44198e = jSONObject;
            this.f44199f = strArr;
            this.f44200g = jSONObject2;
            this.f44201h = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a */
        public Unit invoke(Boolean bool) {
            if (bool.booleanValue()) {
                b.this.E(this.f44198e, this.f44199f, this.f44200g);
                return null;
            }
            d.a.l0.a.e0.d.h("SwanAppPaymentManager", "paykey invalid order info " + this.f44201h);
            d.a.l0.a.j2.k.D(false, BeanConstants.CHANNEL_ID_NUOMI, d.a.l0.a.q1.a.c("", "paykey invalid"));
            b.this.M();
            return null;
        }
    }

    /* loaded from: classes3.dex */
    public class g implements d.a.l0.a.q1.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ JSONObject f44203a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JSONObject f44204b;

        public g(JSONObject jSONObject, JSONObject jSONObject2) {
            this.f44203a = jSONObject;
            this.f44204b = jSONObject2;
        }

        @Override // d.a.l0.a.q1.d
        public void onPayResult(int i2, String str) {
            b.this.K(i2, str, this.f44203a, this.f44204b);
        }
    }

    /* loaded from: classes3.dex */
    public class h implements d.a.b0.e.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ JSONObject f44206a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JSONObject f44207b;

        public h(JSONObject jSONObject, JSONObject jSONObject2) {
            this.f44206a = jSONObject;
            this.f44207b = jSONObject2;
        }

        @Override // d.a.b0.e.a
        public void onPayResult(int i2, String str) {
            b.this.K(i2, str, this.f44206a, this.f44207b);
        }
    }

    /* loaded from: classes3.dex */
    public class i implements d.a.l0.a.v2.e1.b<d.a.l0.a.e2.c.i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44209e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44210f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f44211g;

        public i(String str, String str2, String str3) {
            this.f44209e = str;
            this.f44210f = str2;
            this.f44211g = str3;
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
                if (TextUtils.equals(b.this.f44175d, "2.0")) {
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
                if (TextUtils.equals(this.f44209e, "mapp_request_duxiaoman")) {
                    d.a.l0.a.j2.k.D(false, "baiduqianbao", d.a.l0.a.q1.a.c("", "authorize fail"));
                } else if (TextUtils.equals(this.f44209e, "mapp_request_alipayment")) {
                    d.a.l0.a.j2.k.D(false, LBSTransAuthPresenter.AUTH_CHANNEL_ALI, d.a.l0.a.q1.a.c("", "authorize fail"));
                } else if (TextUtils.equals(this.f44209e, "mapp_request_wechatpayment")) {
                    d.a.l0.a.j2.k.D(false, "wechatH5Action", d.a.l0.a.q1.a.c("", "authorize fail"));
                }
                d.a.l0.a.e0.d.h("SwanAppPaymentManager", "Error: authorized fail. scope = " + this.f44209e);
                b.this.f44174c.handleSchemeDispatchCallback(b.this.f44180i, UnitedSchemeUtility.wrapCallbackParamsWithBase64(str, 1001, "authorize denied").toString());
                return;
            }
            String str2 = this.f44209e;
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
                b.this.A(this.f44210f, this.f44211g);
            } else if (c2 == 1) {
                b.this.y(this.f44210f);
            } else if (c2 != 2) {
            } else {
                b.this.O();
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface j {
        void a(String str);

        void onSuccess();
    }

    public b(d.a.l0.a.a2.e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, String str2, String str3) {
        this.f44172a = eVar;
        this.f44173b = unitedSchemeEntity;
        this.f44174c = callbackHandler;
        this.f44175d = str;
        this.f44176e = str2;
        this.f44180i = str3;
    }

    public static String I(int i2) {
        return i2 != 0 ? i2 != 2 ? "支付失败" : "支付取消" : "支付成功";
    }

    public final boolean A(String str, String str2) {
        if (this.f44172a.j().e(this.f44172a.k())) {
            C(str);
            return true;
        }
        d.a.l0.a.a2.e eVar = this.f44172a;
        if (eVar == null) {
            return false;
        }
        boolean e2 = eVar.j().e(this.f44172a.x());
        if (!e2) {
            d.a.l0.a.j2.k.M("show", 9, str2);
        }
        this.f44172a.j().f(this.f44172a.k(), null, new a(e2, str2, str));
        return true;
    }

    public boolean B(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) && (str.equals("mapp_request_duxiaoman") || str.equals("mapp_request_alipayment"))) {
            this.f44173b.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            d.a.l0.a.e0.d.h("SwanAppPaymentManager", "Error: order info is null.");
            return false;
        }
        this.f44172a.T().g(this.f44172a.x(), str, new i(str, str2, str3));
        UnitedSchemeUtility.callCallback(this.f44174c, this.f44173b, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }

    public final void C(String str) {
        d.a.l0.a.j2.k.F("baiduqianbao", "intoPayment", 0);
        this.f44179h.d(this.f44172a.k(), str, new C0802b());
    }

    public final void D(String str, String[] strArr, JSONObject jSONObject, boolean z, boolean z2) {
        F(str, strArr, jSONObject);
        d.a.l0.a.j2.k.E(BeanConstants.CHANNEL_ID_NUOMI, z, z2);
    }

    public final void E(JSONObject jSONObject, String[] strArr, JSONObject jSONObject2) {
        boolean z;
        try {
            if (d.a.l0.a.s.a.f.f44582d.f()) {
                jSONObject.put("openBduss", d.a.l0.a.c1.a.a0().d(d.a.l0.a.c1.a.b()));
                jSONObject.put("clientId", d.a.l0.a.c1.a.m().b());
            } else {
                jSONObject.put("bduss", d.a.l0.a.c1.a.a0().d(d.a.l0.a.c1.a.b()));
            }
            jSONObject.put("cuid", d.a.l0.a.c1.a.a0().i(d.a.l0.a.c1.a.b()));
            String optString = jSONObject.optString("bizInfo");
            JSONObject jSONObject3 = TextUtils.isEmpty(optString) ? new JSONObject() : new JSONObject(optString);
            jSONObject3.put("swanFrom", this.f44172a.L().T());
            jSONObject3.put("cuid", d.a.l0.a.c1.a.a0().i(d.a.l0.a.c1.a.b()));
            jSONObject3.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, d.a.l0.a.a2.d.g().getAppId());
            x(jSONObject3);
            jSONObject.put("bizInfo", jSONObject3.toString());
            jSONObject.put("platformId", "100003");
            jSONObject.put("nativeAppId", d.a.l0.a.c1.a.m().a());
            jSONObject.put("sceneSource", "swan");
            jSONObject.put("swanNativeVersion", l.a());
            z(jSONObject, this.f44172a.D());
            if (j) {
                Log.i("SwanAppPaymentManager", jSONObject.toString());
            }
        } catch (JSONException e2) {
            if (k.f43199a) {
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
            this.f44179h.i(this.f44172a.x(), jSONObject, strArr, new h(jSONObject2, jSONObject));
            d.a.l0.a.e0.d.h("SwanAppPaymentManager", "doPolymerPay: " + jSONObject.toString());
        }
        UnitedSchemeUtility.callCallback(this.f44174c, this.f44173b, UnitedSchemeUtility.wrapCallbackParams(0));
        if (this.f44172a.z() != null) {
            String valueOf = String.valueOf(this.f44172a.L().G());
            String valueOf2 = String.valueOf(UnitedSchemeUtility.getParams(this.f44172a.L().W()).get("_baiduboxapp"));
            Bundle bundle = new Bundle();
            bundle.putString("frameType", valueOf);
            bundle.putString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f44172a.L().H());
            try {
                bundle.putString("params", URLEncoder.encode(valueOf2, "UTF-8"));
            } catch (UnsupportedEncodingException e3) {
                if (j) {
                    throw new RuntimeException("This method requires UTF-8 encoding support", e3);
                }
            }
            this.f44172a.z().N(7, bundle);
        }
    }

    public final void F(String str, String[] strArr, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            d.a.l0.a.n1.q.c.d.b(jSONObject2.optString("appKey"), new f(jSONObject2, strArr, jSONObject, str));
        } catch (JSONException e2) {
            M();
            d.a.l0.a.e0.d.h("SwanAppPaymentManager", " doPolymerPayChecked error " + str);
            if (k.f43199a) {
                e2.printStackTrace();
            }
        }
    }

    public final void G(String str, String[] strArr, JSONObject jSONObject, boolean z, boolean z2) {
        d.a.l0.a.c1.b.e().a(str, new e(str, strArr, jSONObject, z, z2));
    }

    public final String H(String str, JSONObject jSONObject) {
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

    public boolean J(String str, JSONObject jSONObject) {
        String[] strArr;
        Object opt;
        String optString = jSONObject.optString("invokeFrom");
        if (TextUtils.isEmpty(optString)) {
            optString = RetrieveTaskManager.KEY;
        }
        String str2 = optString;
        boolean e2 = this.f44172a.j().e(this.f44172a.x());
        if (!e2) {
            d.a.l0.a.j2.k.M("show", 8, str2);
        }
        if (TextUtils.isEmpty(str)) {
            this.f44173b.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        String optString2 = jSONObject.optString("__plugin__");
        d.a.l0.a.t1.d.a.a("start payment");
        if (!TextUtils.isEmpty(optString2) && (opt = jSONObject.opt("error")) != null) {
            String optString3 = jSONObject.optString("slaveId");
            d.a.l0.a.t1.c.c.a aVar = new d.a.l0.a.t1.c.c.a(jSONObject.optString("componentId"));
            aVar.f44761a = optString3;
            aVar.f44763c = opt;
            aVar.f44764d = false;
            aVar.f44765e = null;
            aVar.b();
            d.a.l0.a.e0.d.h("SwanAppPaymentManager", "Error: param check error - plugin pay contains custom error");
            d.a.l0.a.j2.k.D(false, BeanConstants.CHANNEL_ID_NUOMI, d.a.l0.a.q1.a.c("", "param check error - plugin pay contains custom error"));
            this.f44173b.result = UnitedSchemeUtility.wrapCallbackParams(1001);
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
        if (this.f44172a.x() == null) {
            this.f44177f = 5;
            this.f44178g = null;
            L(null);
            if (j) {
                throw new RuntimeException("swanApp getActivity returns null");
            }
            return true;
        } else if (this.f44172a.j().e(this.f44172a.k())) {
            if (this.f44172a.m0()) {
                G(str, strArr, jSONObject, true, true);
                return true;
            }
            D(str, strArr, jSONObject, true, true);
            return true;
        } else {
            this.f44172a.j().f(this.f44172a.k(), null, new d(str2, str, strArr, jSONObject, e2));
            return true;
        }
    }

    public final void K(int i2, String str, JSONObject jSONObject, JSONObject jSONObject2) {
        d.a.l0.a.g1.f.V().b();
        d.a.l0.a.e0.d.g("SwanAppPaymentManager", "sendSecondCallback statusCode: " + this.f44177f + " params: " + this.f44178g + " payParams: " + jSONObject.toString() + " orderId: " + jSONObject2.optString("tpOrderId"));
        N(i2, BeanConstants.CHANNEL_ID_NUOMI, H(str, jSONObject2));
        this.f44177f = i2;
        this.f44178g = str;
        if (i2 != 1) {
            d.a.l0.a.j2.k.F(BeanConstants.CHANNEL_ID_NUOMI, "result", i2);
        }
        L(null);
        if (jSONObject != null && !TextUtils.isEmpty(jSONObject.optString("__plugin__"))) {
            String optString = jSONObject.optString("slaveId");
            String optString2 = jSONObject.optString("componentId");
            Object opt = jSONObject.opt("error");
            d.a.l0.a.t1.c.c.a aVar = new d.a.l0.a.t1.c.c.a(optString2);
            aVar.f44761a = optString;
            aVar.f44763c = opt;
            aVar.f44764d = i2 == 0;
            aVar.f44765e = str;
            aVar.b();
            d.a.l0.a.t1.g.b.j();
        }
        if (this.f44177f != 0 || d.a.l0.a.x1.c.f45762c.c()) {
            return;
        }
        d.a.l0.a.x1.c.f45762c.e();
    }

    public final void L(String str) {
        try {
            if (TextUtils.equals(this.f44175d, "2.0")) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("payId", str);
                if (!TextUtils.isEmpty(this.f44178g)) {
                    jSONObject.put("payResult", Base64.encodeToString(this.f44178g.getBytes("UTF-8"), 2));
                }
                d.a.l0.a.e0.d.g("SwanAppPaymentManager", "Success: sendSecondCallback, data = " + jSONObject + " status code = " + this.f44177f);
                this.f44174c.handleSchemeDispatchCallback(this.f44180i, UnitedSchemeUtility.wrapCallbackParams(jSONObject, this.f44177f, I(this.f44177f)).toString());
                return;
            }
            d.a.l0.a.e0.d.g("SwanAppPaymentManager", "Success: sendSecondCallback, result = " + this.f44178g + " status code = " + this.f44177f);
            this.f44174c.handleSchemeDispatchCallback(this.f44180i, UnitedSchemeUtility.wrapCallbackParamsWithBase64(this.f44178g, this.f44177f, I(this.f44177f)).toString());
        } catch (UnsupportedEncodingException | JSONException e2) {
            d.a.l0.a.e0.d.g("SwanAppPaymentManager", "Fail: sendSecondCallback exception , exception = " + e2.getMessage() + " stack trace = " + Arrays.toString(e2.getStackTrace()));
            CallbackHandler callbackHandler = this.f44174c;
            String str2 = this.f44180i;
            int i2 = this.f44177f;
            callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, i2, I(i2)).toString());
        }
    }

    public final void M() {
        d.a.l0.a.a2.e eVar = this.f44172a;
        if (eVar != null) {
            d.a.l0.a.z1.b.f.e.f(eVar.x(), d.a.l0.a.h.swanapp_payment_illegal).F();
            if (TextUtils.isEmpty(this.f44180i)) {
                return;
            }
            this.f44174c.handleSchemeDispatchCallback(this.f44180i, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, 6, this.f44172a.x().getString(d.a.l0.a.h.swanapp_payment_illegal)).toString());
        }
    }

    public final void N(int i2, String str, String str2) {
        d.a.l0.a.j2.k.D(i2 == 0, str, str2);
    }

    public final boolean O() {
        d.a.l0.a.e0.d.g("SwanAppPaymentManager", "start UnitedSchemeWalletDispatcher ACTION_REQUEST_WECHAT_PAYMENT");
        if (d.a.l0.a.q1.a.b().e(this.f44172a, this.f44174c, this.f44173b)) {
            this.f44177f = 0;
            this.f44178g = null;
            if (TextUtils.equals(this.f44175d, "2.0")) {
                d.a.l0.a.c1.a.R().e(this.f44176e, this);
            } else {
                L(null);
            }
            d.a.l0.a.j2.k.C("wechatH5Action", null, null);
            return true;
        }
        d.a.l0.a.e0.d.h("SwanAppPaymentManager", "Error: open webview error.  entity = " + this.f44173b.toString());
        this.f44174c.handleSchemeDispatchCallback(this.f44180i, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
        return false;
    }

    @Override // d.a.l0.a.x1.a
    public void a(String str) {
        d.a.l0.a.e0.d.b("SwanAppPaymentManager", "Fail: request payId failed");
        d.a.l0.a.e0.d.b("SwanAppPaymentManager", str);
        L(null);
    }

    @Override // d.a.l0.a.x1.a
    public void b(JSONObject jSONObject) {
        String str;
        d.a.l0.a.e0.d.b("SwanAppPaymentManager", "Info: getPayId Request Response =  " + jSONObject.toString());
        if (jSONObject.optInt("errno") == 0) {
            str = jSONObject.optJSONObject("data").optString("payid");
            d.a.l0.a.e0.d.b("SwanAppPaymentManager", "Info: payId =  " + str);
        } else {
            str = null;
        }
        L(str);
        if (d.a.l0.a.x1.c.f45762c.c()) {
            return;
        }
        if (d.a.l0.a.c1.a.a0().e(this.f44172a)) {
            d.a.l0.a.x1.c.f45762c.e();
        } else {
            d.a.l0.a.x1.c.f45762c.f();
        }
    }

    public final JSONObject x(JSONObject jSONObject) {
        if (this.f44172a.m0() && jSONObject != null) {
            b.a L = this.f44172a.L();
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

    public final boolean y(String str) {
        if (j) {
            Log.d("SwanAppPaymentManager", "start UnitedSchemeWalletDispatcher ACTION_REQUEST_ALI_PAYMENT orderInfo: " + str);
        }
        d.a.l0.a.j2.k.F(LBSTransAuthPresenter.AUTH_CHANNEL_ALI, "intoPayment", 0);
        this.f44179h.c(this.f44172a.k(), str, new c());
        return true;
    }

    public final void z(@NonNull JSONObject jSONObject, @NonNull String str) throws JSONException {
        PMSAppInfo s = d.a.l0.n.g.a.h().s(str);
        int i2 = s == null ? PMSConstants.PayProtected.NO_PAY_PROTECTED.type : s.payProtected;
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("baoStatus", i2);
        jSONObject2.put("sappId", 10001);
        jSONObject2.put("objectId", str);
        jSONObject.put("baoInfo", jSONObject2.toString());
    }
}
