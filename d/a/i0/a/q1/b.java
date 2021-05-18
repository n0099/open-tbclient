package d.a.i0.a.q1;

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
import d.a.i0.a.e2.c.j.b;
import d.a.i0.a.f1.e.b;
import d.a.i0.a.k;
import d.a.i0.a.l;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b implements d.a.i0.a.q1.g.a {
    public static final boolean j = k.f43025a;
    public static String[] k = {"duershow"};

    /* renamed from: a  reason: collision with root package name */
    public d.a.i0.a.a2.e f43996a;

    /* renamed from: b  reason: collision with root package name */
    public UnitedSchemeEntity f43997b;

    /* renamed from: c  reason: collision with root package name */
    public CallbackHandler f43998c;

    /* renamed from: d  reason: collision with root package name */
    public String f43999d;

    /* renamed from: e  reason: collision with root package name */
    public String f44000e;

    /* renamed from: f  reason: collision with root package name */
    public int f44001f;

    /* renamed from: g  reason: collision with root package name */
    public String f44002g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.z.a f44003h = new d.a.z.a();

    /* renamed from: i  reason: collision with root package name */
    public String f44004i;

    /* loaded from: classes3.dex */
    public class a implements d.a.i0.a.m.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f44005e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44006f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f44007g;

        public a(boolean z, String str, String str2) {
            this.f44005e = z;
            this.f44006f = str;
            this.f44007g = str2;
        }

        @Override // d.a.i0.a.m.a
        public void onResult(int i2) {
            if (i2 == 0) {
                if (!this.f44005e) {
                    d.a.i0.a.j2.k.M("success", 9, this.f44006f);
                }
                b.this.C(this.f44007g);
                return;
            }
            if (!this.f44005e) {
                d.a.i0.a.j2.k.M("fail", 9, this.f44006f);
            }
            b.this.f44001f = 5;
            b.this.f44002g = null;
            b.this.L(null);
        }
    }

    /* renamed from: d.a.i0.a.q1.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0791b implements d.a.z.e.a {
        public C0791b() {
        }

        @Override // d.a.z.e.a
        public void onPayResult(int i2, String str) {
            b.this.f44001f = i2;
            b.this.f44002g = str;
            if (b.j) {
                Log.d("SwanAppPaymentManager", "statusCode: " + i2 + " ,result:" + str);
            }
            b.this.N(i2, "baiduqianbao", str);
            d.a.i0.a.j2.k.F("baiduqianbao", "result", i2);
            if (i2 != 0 || !TextUtils.equals(b.this.f43999d, "2.0")) {
                b.this.L(null);
            } else {
                d.a.i0.a.c1.a.R().e(b.this.f44000e, b.this);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.a.z.e.a {
        public c() {
        }

        @Override // d.a.z.e.a
        public void onPayResult(int i2, String str) {
            b.this.f44001f = i2;
            b.this.f44002g = str;
            d.a.i0.a.e0.d.h("SwanAppPaymentManager", "statusCode: " + b.this.f44001f + " ,result:" + b.this.f44002g);
            b.this.N(i2, LBSTransAuthPresenter.AUTH_CHANNEL_ALI, str);
            if (i2 != 1) {
                d.a.i0.a.j2.k.F(LBSTransAuthPresenter.AUTH_CHANNEL_ALI, "result", i2);
            }
            if (i2 != 0 || !TextUtils.equals(b.this.f43999d, "2.0")) {
                b.this.L(null);
            } else {
                d.a.i0.a.c1.a.R().e(b.this.f44000e, b.this);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements d.a.i0.a.m.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44011e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44012f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String[] f44013g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ JSONObject f44014h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ boolean f44015i;

        public d(String str, String str2, String[] strArr, JSONObject jSONObject, boolean z) {
            this.f44011e = str;
            this.f44012f = str2;
            this.f44013g = strArr;
            this.f44014h = jSONObject;
            this.f44015i = z;
        }

        @Override // d.a.i0.a.m.a
        public void onResult(int i2) {
            if (i2 == 0) {
                d.a.i0.a.j2.k.M("success", 8, this.f44011e);
                if (b.this.f43996a.m0()) {
                    b.this.G(this.f44012f, this.f44013g, this.f44014h, true, false);
                    return;
                } else {
                    b.this.D(this.f44012f, this.f44013g, this.f44014h, true, false);
                    return;
                }
            }
            if (!this.f44015i) {
                d.a.i0.a.j2.k.M("fail", 8, this.f44011e);
                d.a.i0.a.e0.d.h("SwanAppPaymentManager", "login error");
                d.a.i0.a.j2.k.D(false, BeanConstants.CHANNEL_ID_NUOMI, d.a.i0.a.q1.a.c("", "login error"));
            }
            b.this.f44001f = 5;
            b.this.f44002g = null;
            b.this.L(null);
            d.a.i0.a.j2.k.E(BeanConstants.CHANNEL_ID_NUOMI, false, false);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements j {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f44016a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String[] f44017b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ JSONObject f44018c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f44019d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f44020e;

        public e(String str, String[] strArr, JSONObject jSONObject, boolean z, boolean z2) {
            this.f44016a = str;
            this.f44017b = strArr;
            this.f44018c = jSONObject;
            this.f44019d = z;
            this.f44020e = z2;
        }

        @Override // d.a.i0.a.q1.b.j
        public void a(String str) {
            if (TextUtils.isEmpty(b.this.f44004i)) {
                return;
            }
            CallbackHandler callbackHandler = b.this.f43998c;
            String str2 = b.this.f44004i;
            callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, 6, b.this.f43996a.x().getString(d.a.i0.a.h.swan_game_anti_addiction) + str).toString());
        }

        @Override // d.a.i0.a.q1.b.j
        public void onSuccess() {
            b.this.D(this.f44016a, this.f44017b, this.f44018c, this.f44019d, this.f44020e);
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Function1<Boolean, Unit> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f44022e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String[] f44023f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONObject f44024g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f44025h;

        public f(JSONObject jSONObject, String[] strArr, JSONObject jSONObject2, String str) {
            this.f44022e = jSONObject;
            this.f44023f = strArr;
            this.f44024g = jSONObject2;
            this.f44025h = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a */
        public Unit invoke(Boolean bool) {
            if (bool.booleanValue()) {
                b.this.E(this.f44022e, this.f44023f, this.f44024g);
                return null;
            }
            d.a.i0.a.e0.d.h("SwanAppPaymentManager", "paykey invalid order info " + this.f44025h);
            d.a.i0.a.j2.k.D(false, BeanConstants.CHANNEL_ID_NUOMI, d.a.i0.a.q1.a.c("", "paykey invalid"));
            b.this.M();
            return null;
        }
    }

    /* loaded from: classes3.dex */
    public class g implements d.a.i0.a.q1.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ JSONObject f44027a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JSONObject f44028b;

        public g(JSONObject jSONObject, JSONObject jSONObject2) {
            this.f44027a = jSONObject;
            this.f44028b = jSONObject2;
        }

        @Override // d.a.i0.a.q1.d
        public void onPayResult(int i2, String str) {
            b.this.K(i2, str, this.f44027a, this.f44028b);
        }
    }

    /* loaded from: classes3.dex */
    public class h implements d.a.z.e.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ JSONObject f44030a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JSONObject f44031b;

        public h(JSONObject jSONObject, JSONObject jSONObject2) {
            this.f44030a = jSONObject;
            this.f44031b = jSONObject2;
        }

        @Override // d.a.z.e.a
        public void onPayResult(int i2, String str) {
            b.this.K(i2, str, this.f44030a, this.f44031b);
        }
    }

    /* loaded from: classes3.dex */
    public class i implements d.a.i0.a.v2.e1.b<d.a.i0.a.e2.c.i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44033e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44034f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f44035g;

        public i(String str, String str2, String str3) {
            this.f44033e = str;
            this.f44034f = str2;
            this.f44035g = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x00c7, code lost:
            if (r10.equals("mapp_request_duxiaoman") != false) goto L35;
         */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onCallback(d.a.i0.a.e2.c.i<b.e> iVar) {
            char c2 = 0;
            if (!d.a.i0.a.e2.c.d.h(iVar)) {
                String str = null;
                if (TextUtils.equals(b.this.f43999d, "2.0")) {
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
                if (TextUtils.equals(this.f44033e, "mapp_request_duxiaoman")) {
                    d.a.i0.a.j2.k.D(false, "baiduqianbao", d.a.i0.a.q1.a.c("", "authorize fail"));
                } else if (TextUtils.equals(this.f44033e, "mapp_request_alipayment")) {
                    d.a.i0.a.j2.k.D(false, LBSTransAuthPresenter.AUTH_CHANNEL_ALI, d.a.i0.a.q1.a.c("", "authorize fail"));
                } else if (TextUtils.equals(this.f44033e, "mapp_request_wechatpayment")) {
                    d.a.i0.a.j2.k.D(false, "wechatH5Action", d.a.i0.a.q1.a.c("", "authorize fail"));
                }
                d.a.i0.a.e0.d.h("SwanAppPaymentManager", "Error: authorized fail. scope = " + this.f44033e);
                b.this.f43998c.handleSchemeDispatchCallback(b.this.f44004i, UnitedSchemeUtility.wrapCallbackParamsWithBase64(str, 1001, "authorize denied").toString());
                return;
            }
            String str2 = this.f44033e;
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
                b.this.A(this.f44034f, this.f44035g);
            } else if (c2 == 1) {
                b.this.y(this.f44034f);
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

    public b(d.a.i0.a.a2.e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, String str2, String str3) {
        this.f43996a = eVar;
        this.f43997b = unitedSchemeEntity;
        this.f43998c = callbackHandler;
        this.f43999d = str;
        this.f44000e = str2;
        this.f44004i = str3;
    }

    public static String I(int i2) {
        return i2 != 0 ? i2 != 2 ? "支付失败" : "支付取消" : "支付成功";
    }

    public final boolean A(String str, String str2) {
        if (this.f43996a.j().e(this.f43996a.k())) {
            C(str);
            return true;
        }
        d.a.i0.a.a2.e eVar = this.f43996a;
        if (eVar == null) {
            return false;
        }
        boolean e2 = eVar.j().e(this.f43996a.x());
        if (!e2) {
            d.a.i0.a.j2.k.M("show", 9, str2);
        }
        this.f43996a.j().f(this.f43996a.k(), null, new a(e2, str2, str));
        return true;
    }

    public boolean B(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) && (str.equals("mapp_request_duxiaoman") || str.equals("mapp_request_alipayment"))) {
            this.f43997b.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            d.a.i0.a.e0.d.h("SwanAppPaymentManager", "Error: order info is null.");
            return false;
        }
        this.f43996a.T().g(this.f43996a.x(), str, new i(str, str2, str3));
        UnitedSchemeUtility.callCallback(this.f43998c, this.f43997b, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }

    public final void C(String str) {
        d.a.i0.a.j2.k.F("baiduqianbao", "intoPayment", 0);
        this.f44003h.d(this.f43996a.k(), str, new C0791b());
    }

    public final void D(String str, String[] strArr, JSONObject jSONObject, boolean z, boolean z2) {
        F(str, strArr, jSONObject);
        d.a.i0.a.j2.k.E(BeanConstants.CHANNEL_ID_NUOMI, z, z2);
    }

    public final void E(JSONObject jSONObject, String[] strArr, JSONObject jSONObject2) {
        boolean z;
        try {
            if (d.a.i0.a.s.a.f.f44406d.f()) {
                jSONObject.put("openBduss", d.a.i0.a.c1.a.a0().d(d.a.i0.a.c1.a.b()));
                jSONObject.put("clientId", d.a.i0.a.c1.a.m().b());
            } else {
                jSONObject.put("bduss", d.a.i0.a.c1.a.a0().d(d.a.i0.a.c1.a.b()));
            }
            jSONObject.put("cuid", d.a.i0.a.c1.a.a0().i(d.a.i0.a.c1.a.b()));
            String optString = jSONObject.optString("bizInfo");
            JSONObject jSONObject3 = TextUtils.isEmpty(optString) ? new JSONObject() : new JSONObject(optString);
            jSONObject3.put("swanFrom", this.f43996a.L().T());
            jSONObject3.put("cuid", d.a.i0.a.c1.a.a0().i(d.a.i0.a.c1.a.b()));
            jSONObject3.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, d.a.i0.a.a2.d.g().getAppId());
            x(jSONObject3);
            jSONObject.put("bizInfo", jSONObject3.toString());
            jSONObject.put("platformId", "100003");
            jSONObject.put("nativeAppId", d.a.i0.a.c1.a.m().a());
            jSONObject.put("sceneSource", "swan");
            jSONObject.put("swanNativeVersion", l.a());
            z(jSONObject, this.f43996a.D());
            if (j) {
                Log.i("SwanAppPaymentManager", jSONObject.toString());
            }
        } catch (JSONException e2) {
            if (k.f43025a) {
                e2.printStackTrace();
            }
        }
        d.a.i0.a.g1.f.V().p();
        String[] strArr2 = k;
        int length = strArr2.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                z = false;
                break;
            } else if (strArr2[i2].equals(d.a.i0.a.c1.a.m().a())) {
                z = true;
                break;
            } else {
                i2++;
            }
        }
        d.a.i0.a.j2.k.F(BeanConstants.CHANNEL_ID_NUOMI, "intoPayment", 0);
        if (z) {
            String a2 = d.a.i0.t.i.a(d.a.i0.t.i.a("https://etrade.baidu.com/cashier/create-qrcode", "orderInfo", Uri.encode(jSONObject.toString())), "deviceType", "ANDROID");
            d.a.i0.a.h0.g.k.Q2("qrCodePay", d.a.i0.a.l1.b.e(a2, a2));
            d.a.i0.a.q1.e.b(new g(jSONObject2, jSONObject));
            d.a.i0.a.e0.d.h("SwanAppPaymentManager", "doPolymerPay Qr Code: " + jSONObject.toString());
        } else {
            this.f44003h.i(this.f43996a.x(), jSONObject, strArr, new h(jSONObject2, jSONObject));
            d.a.i0.a.e0.d.h("SwanAppPaymentManager", "doPolymerPay: " + jSONObject.toString());
        }
        UnitedSchemeUtility.callCallback(this.f43998c, this.f43997b, UnitedSchemeUtility.wrapCallbackParams(0));
        if (this.f43996a.z() != null) {
            String valueOf = String.valueOf(this.f43996a.L().G());
            String valueOf2 = String.valueOf(UnitedSchemeUtility.getParams(this.f43996a.L().W()).get("_baiduboxapp"));
            Bundle bundle = new Bundle();
            bundle.putString("frameType", valueOf);
            bundle.putString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f43996a.L().H());
            try {
                bundle.putString("params", URLEncoder.encode(valueOf2, "UTF-8"));
            } catch (UnsupportedEncodingException e3) {
                if (j) {
                    throw new RuntimeException("This method requires UTF-8 encoding support", e3);
                }
            }
            this.f43996a.z().N(7, bundle);
        }
    }

    public final void F(String str, String[] strArr, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            d.a.i0.a.n1.q.c.d.b(jSONObject2.optString("appKey"), new f(jSONObject2, strArr, jSONObject, str));
        } catch (JSONException e2) {
            M();
            d.a.i0.a.e0.d.h("SwanAppPaymentManager", " doPolymerPayChecked error " + str);
            if (k.f43025a) {
                e2.printStackTrace();
            }
        }
    }

    public final void G(String str, String[] strArr, JSONObject jSONObject, boolean z, boolean z2) {
        d.a.i0.a.c1.b.e().a(str, new e(str, strArr, jSONObject, z, z2));
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
        boolean e2 = this.f43996a.j().e(this.f43996a.x());
        if (!e2) {
            d.a.i0.a.j2.k.M("show", 8, str2);
        }
        if (TextUtils.isEmpty(str)) {
            this.f43997b.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        String optString2 = jSONObject.optString("__plugin__");
        d.a.i0.a.t1.d.a.a("start payment");
        if (!TextUtils.isEmpty(optString2) && (opt = jSONObject.opt("error")) != null) {
            String optString3 = jSONObject.optString("slaveId");
            d.a.i0.a.t1.c.c.a aVar = new d.a.i0.a.t1.c.c.a(jSONObject.optString("componentId"));
            aVar.f44585a = optString3;
            aVar.f44587c = opt;
            aVar.f44588d = false;
            aVar.f44589e = null;
            aVar.b();
            d.a.i0.a.e0.d.h("SwanAppPaymentManager", "Error: param check error - plugin pay contains custom error");
            d.a.i0.a.j2.k.D(false, BeanConstants.CHANNEL_ID_NUOMI, d.a.i0.a.q1.a.c("", "param check error - plugin pay contains custom error"));
            this.f43997b.result = UnitedSchemeUtility.wrapCallbackParams(1001);
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
        d.a.i0.a.j2.k.F(BeanConstants.CHANNEL_ID_NUOMI, "login", 0);
        if (this.f43996a.x() == null) {
            this.f44001f = 5;
            this.f44002g = null;
            L(null);
            if (j) {
                throw new RuntimeException("swanApp getActivity returns null");
            }
            return true;
        } else if (this.f43996a.j().e(this.f43996a.k())) {
            if (this.f43996a.m0()) {
                G(str, strArr, jSONObject, true, true);
                return true;
            }
            D(str, strArr, jSONObject, true, true);
            return true;
        } else {
            this.f43996a.j().f(this.f43996a.k(), null, new d(str2, str, strArr, jSONObject, e2));
            return true;
        }
    }

    public final void K(int i2, String str, JSONObject jSONObject, JSONObject jSONObject2) {
        d.a.i0.a.g1.f.V().b();
        d.a.i0.a.e0.d.g("SwanAppPaymentManager", "sendSecondCallback statusCode: " + this.f44001f + " params: " + this.f44002g + " payParams: " + jSONObject.toString() + " orderId: " + jSONObject2.optString("tpOrderId"));
        N(i2, BeanConstants.CHANNEL_ID_NUOMI, H(str, jSONObject2));
        this.f44001f = i2;
        this.f44002g = str;
        if (i2 != 1) {
            d.a.i0.a.j2.k.F(BeanConstants.CHANNEL_ID_NUOMI, "result", i2);
        }
        L(null);
        if (jSONObject != null && !TextUtils.isEmpty(jSONObject.optString("__plugin__"))) {
            String optString = jSONObject.optString("slaveId");
            String optString2 = jSONObject.optString("componentId");
            Object opt = jSONObject.opt("error");
            d.a.i0.a.t1.c.c.a aVar = new d.a.i0.a.t1.c.c.a(optString2);
            aVar.f44585a = optString;
            aVar.f44587c = opt;
            aVar.f44588d = i2 == 0;
            aVar.f44589e = str;
            aVar.b();
            d.a.i0.a.t1.g.b.j();
        }
        if (this.f44001f != 0 || d.a.i0.a.x1.c.f45586c.c()) {
            return;
        }
        d.a.i0.a.x1.c.f45586c.e();
    }

    public final void L(String str) {
        try {
            if (TextUtils.equals(this.f43999d, "2.0")) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("payId", str);
                if (!TextUtils.isEmpty(this.f44002g)) {
                    jSONObject.put("payResult", Base64.encodeToString(this.f44002g.getBytes("UTF-8"), 2));
                }
                d.a.i0.a.e0.d.g("SwanAppPaymentManager", "Success: sendSecondCallback, data = " + jSONObject + " status code = " + this.f44001f);
                this.f43998c.handleSchemeDispatchCallback(this.f44004i, UnitedSchemeUtility.wrapCallbackParams(jSONObject, this.f44001f, I(this.f44001f)).toString());
                return;
            }
            d.a.i0.a.e0.d.g("SwanAppPaymentManager", "Success: sendSecondCallback, result = " + this.f44002g + " status code = " + this.f44001f);
            this.f43998c.handleSchemeDispatchCallback(this.f44004i, UnitedSchemeUtility.wrapCallbackParamsWithBase64(this.f44002g, this.f44001f, I(this.f44001f)).toString());
        } catch (UnsupportedEncodingException | JSONException e2) {
            d.a.i0.a.e0.d.g("SwanAppPaymentManager", "Fail: sendSecondCallback exception , exception = " + e2.getMessage() + " stack trace = " + Arrays.toString(e2.getStackTrace()));
            CallbackHandler callbackHandler = this.f43998c;
            String str2 = this.f44004i;
            int i2 = this.f44001f;
            callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, i2, I(i2)).toString());
        }
    }

    public final void M() {
        d.a.i0.a.a2.e eVar = this.f43996a;
        if (eVar != null) {
            d.a.i0.a.z1.b.f.e.f(eVar.x(), d.a.i0.a.h.swanapp_payment_illegal).F();
            if (TextUtils.isEmpty(this.f44004i)) {
                return;
            }
            this.f43998c.handleSchemeDispatchCallback(this.f44004i, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, 6, this.f43996a.x().getString(d.a.i0.a.h.swanapp_payment_illegal)).toString());
        }
    }

    public final void N(int i2, String str, String str2) {
        d.a.i0.a.j2.k.D(i2 == 0, str, str2);
    }

    public final boolean O() {
        d.a.i0.a.e0.d.g("SwanAppPaymentManager", "start UnitedSchemeWalletDispatcher ACTION_REQUEST_WECHAT_PAYMENT");
        if (d.a.i0.a.q1.a.b().e(this.f43996a, this.f43998c, this.f43997b)) {
            this.f44001f = 0;
            this.f44002g = null;
            if (TextUtils.equals(this.f43999d, "2.0")) {
                d.a.i0.a.c1.a.R().e(this.f44000e, this);
            } else {
                L(null);
            }
            d.a.i0.a.j2.k.C("wechatH5Action", null, null);
            return true;
        }
        d.a.i0.a.e0.d.h("SwanAppPaymentManager", "Error: open webview error.  entity = " + this.f43997b.toString());
        this.f43998c.handleSchemeDispatchCallback(this.f44004i, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
        return false;
    }

    @Override // d.a.i0.a.x1.a
    public void a(String str) {
        d.a.i0.a.e0.d.b("SwanAppPaymentManager", "Fail: request payId failed");
        d.a.i0.a.e0.d.b("SwanAppPaymentManager", str);
        L(null);
    }

    @Override // d.a.i0.a.x1.a
    public void b(JSONObject jSONObject) {
        String str;
        d.a.i0.a.e0.d.b("SwanAppPaymentManager", "Info: getPayId Request Response =  " + jSONObject.toString());
        if (jSONObject.optInt("errno") == 0) {
            str = jSONObject.optJSONObject("data").optString("payid");
            d.a.i0.a.e0.d.b("SwanAppPaymentManager", "Info: payId =  " + str);
        } else {
            str = null;
        }
        L(str);
        if (d.a.i0.a.x1.c.f45586c.c()) {
            return;
        }
        if (d.a.i0.a.c1.a.a0().e(this.f43996a)) {
            d.a.i0.a.x1.c.f45586c.e();
        } else {
            d.a.i0.a.x1.c.f45586c.f();
        }
    }

    public final JSONObject x(JSONObject jSONObject) {
        if (this.f43996a.m0() && jSONObject != null) {
            b.a L = this.f43996a.L();
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
        d.a.i0.a.j2.k.F(LBSTransAuthPresenter.AUTH_CHANNEL_ALI, "intoPayment", 0);
        this.f44003h.c(this.f43996a.k(), str, new c());
        return true;
    }

    public final void z(@NonNull JSONObject jSONObject, @NonNull String str) throws JSONException {
        PMSAppInfo s = d.a.i0.n.g.a.h().s(str);
        int i2 = s == null ? PMSConstants.PayProtected.NO_PAY_PROTECTED.type : s.payProtected;
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("baoStatus", i2);
        jSONObject2.put("sappId", 10001);
        jSONObject2.put("objectId", str);
        jSONObject.put("baoInfo", jSONObject2.toString());
    }
}
