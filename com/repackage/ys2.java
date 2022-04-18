package com.repackage;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.retrieve.RetrieveTaskManager;
import com.baidu.payment.PaymentManager;
import com.baidu.poly.widget.PolyActivity;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.alliance.login.SwanAppAllianceLoginHelper;
import com.baidu.swan.apps.pay.panel.PaymentPanelManager;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.gl2;
import com.repackage.o53;
import com.repackage.vs2;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.EventAlias;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class ys2 implements ft2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean j;
    public static String[] k;
    public transient /* synthetic */ FieldHolder $fh;
    public j03 a;
    public UnitedSchemeEntity b;
    public CallbackHandler c;
    public String d;
    public String e;
    public int f;
    public String g;
    public PaymentManager h;
    public String i;

    /* loaded from: classes7.dex */
    public class a implements cf3<m53<o53.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ ys2 d;

        public a(ys2 ys2Var, String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ys2Var, str, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = ys2Var;
            this.a = str;
            this.b = str2;
            this.c = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x00cb, code lost:
            if (r10.equals("mapp_request_duxiaoman") != false) goto L37;
         */
        @Override // com.repackage.cf3
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onCallback(m53<o53.e> m53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, m53Var) == null) {
                char c = 0;
                if (!h53.h(m53Var)) {
                    String str = null;
                    if (TextUtils.equals(this.d.d, "2.0")) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("payId", "");
                        } catch (JSONException e) {
                            if (ys2.j) {
                                e.printStackTrace();
                            }
                        }
                        str = String.valueOf(jSONObject);
                    }
                    if (TextUtils.equals(this.a, "mapp_request_duxiaoman")) {
                        c73.H(false, "baiduqianbao", c73.m("", "authorize fail"));
                    } else if (TextUtils.equals(this.a, "mapp_request_alipayment")) {
                        c73.H(false, "alipay", c73.m("", "authorize fail"));
                    } else if (TextUtils.equals(this.a, "mapp_request_wechatpayment")) {
                        c73.H(false, "wechatH5Action", c73.m("", "authorize fail"));
                    }
                    jx1.k("SwanAppPaymentManager", "Error: authorized fail. scope = " + this.a);
                    this.d.c.handleSchemeDispatchCallback(this.d.i, UnitedSchemeUtility.wrapCallbackParamsWithBase64(str, 1001, "authorize denied").toString());
                    return;
                }
                String str2 = this.a;
                int hashCode = str2.hashCode();
                if (hashCode == -1689456891) {
                    if (str2.equals("mapp_request_wechatpayment")) {
                        c = 2;
                    }
                    c = 65535;
                } else if (hashCode != -1250772529) {
                    if (hashCode == 1111965155 && str2.equals("mapp_request_alipayment")) {
                        c = 1;
                    }
                    c = 65535;
                }
                if (c == 0) {
                    this.d.B(this.b, this.c);
                } else if (c == 1) {
                    this.d.x(this.b);
                } else if (c != 2) {
                } else {
                    this.d.P();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements vg1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ ys2 d;

        public b(ys2 ys2Var, boolean z, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ys2Var, Boolean.valueOf(z), str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = ys2Var;
            this.a = z;
            this.b = str;
            this.c = str2;
        }

        @Override // com.repackage.vg1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i == 0) {
                    if (!this.a) {
                        c73.S("success", 9, this.b);
                    }
                    this.d.D(this.c);
                    return;
                }
                if (!this.a) {
                    c73.S(com.baidu.pass.biometrics.face.liveness.b.a.g0, 9, this.b);
                }
                this.d.f = 5;
                this.d.g = null;
                this.d.M(null);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements i71 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ys2 a;

        public c(ys2 ys2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ys2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ys2Var;
        }

        @Override // com.repackage.i71
        public void onPayResult(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                this.a.f = i;
                this.a.g = str;
                if (ys2.j) {
                    Log.d("SwanAppPaymentManager", "statusCode: " + i + " ,result:" + str);
                }
                this.a.O(i, "baiduqianbao", str);
                c73.K("baiduqianbao", "result", i);
                if (i != 0 || !TextUtils.equals(this.a.d, "2.0")) {
                    this.a.M(null);
                } else {
                    qj2.W().e(this.a.e, this.a);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements i71 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ys2 a;

        public d(ys2 ys2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ys2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ys2Var;
        }

        @Override // com.repackage.i71
        public void onPayResult(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                this.a.f = i;
                this.a.g = str;
                jx1.k("SwanAppPaymentManager", "statusCode: " + this.a.f + " ,result:" + this.a.g);
                this.a.O(i, "alipay", str);
                if (i != 1) {
                    c73.K("alipay", "result", i);
                }
                if (i != 0 || !TextUtils.equals(this.a.d, "2.0")) {
                    this.a.M(null);
                } else {
                    qj2.W().e(this.a.e, this.a);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements vg1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String[] c;
        public final /* synthetic */ JSONObject d;
        public final /* synthetic */ boolean e;
        public final /* synthetic */ ys2 f;

        public e(ys2 ys2Var, String str, String str2, String[] strArr, JSONObject jSONObject, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ys2Var, str, str2, strArr, jSONObject, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = ys2Var;
            this.a = str;
            this.b = str2;
            this.c = strArr;
            this.d = jSONObject;
            this.e = z;
        }

        @Override // com.repackage.vg1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i == 0) {
                    c73.S("success", 8, this.a);
                    if (this.f.a.v0()) {
                        this.f.H(this.b, this.c, this.d, true, false);
                        return;
                    } else {
                        this.f.E(this.b, this.c, this.d, true, false);
                        return;
                    }
                }
                if (!this.e) {
                    c73.S(com.baidu.pass.biometrics.face.liveness.b.a.g0, 8, this.a);
                    jx1.k("SwanAppPaymentManager", "login error");
                    c73.H(false, "nuomi", c73.m("", "login error"));
                }
                this.f.f = 5;
                this.f.g = null;
                this.f.M(null);
                c73.J("nuomi", false, false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String[] b;
        public final /* synthetic */ JSONObject c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ boolean e;
        public final /* synthetic */ ys2 f;

        public f(ys2 ys2Var, String str, String[] strArr, JSONObject jSONObject, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ys2Var, str, strArr, jSONObject, Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = ys2Var;
            this.a = str;
            this.b = strArr;
            this.c = jSONObject;
            this.d = z;
            this.e = z2;
        }

        @Override // com.repackage.ys2.k
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || TextUtils.isEmpty(this.f.i)) {
                return;
            }
            CallbackHandler callbackHandler = this.f.c;
            String str2 = this.f.i;
            callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, 6, this.f.a.x().getString(R.string.obfuscated_res_0x7f0f1244) + str).toString());
        }

        @Override // com.repackage.ys2.k
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f.E(this.a, this.b, this.c, this.d, this.e);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements Function1<Boolean, Unit> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String[] b;
        public final /* synthetic */ JSONObject c;
        public final /* synthetic */ ys2 d;

        public g(ys2 ys2Var, String str, String[] strArr, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ys2Var, str, strArr, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = ys2Var;
            this.a = str;
            this.b = strArr;
            this.c = jSONObject;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a */
        public Unit invoke(Boolean bool) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bool)) == null) {
                if (bool.booleanValue()) {
                    this.d.F(this.a, this.b, this.c);
                    return null;
                }
                jx1.k("SwanAppPaymentManager", "paykey invalid order info " + this.a);
                c73.H(false, "nuomi", c73.m("", "paykey invalid"));
                this.d.N();
                return null;
            }
            return (Unit) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class h implements at2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ys2 c;

        public h(ys2 ys2Var, JSONObject jSONObject, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ys2Var, jSONObject, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ys2Var;
            this.a = jSONObject;
            this.b = str;
        }

        @Override // com.repackage.at2
        public void onPayResult(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                this.c.L(i, str, this.a, this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements i71 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ys2 c;

        public i(ys2 ys2Var, JSONObject jSONObject, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ys2Var, jSONObject, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ys2Var;
            this.a = jSONObject;
            this.b = str;
        }

        @Override // com.repackage.i71
        public void onPayResult(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                this.c.L(i, str, this.a, this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements vs2.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;

        public j(ys2 ys2Var, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ys2Var, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jSONObject;
        }

        @Override // com.repackage.vs2.b
        public void a(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                if (jSONObject == null) {
                    jx1.i("SwanAppPaymentManager", "pay_check request success, but result is null.");
                    return;
                }
                try {
                    boolean z = jSONObject.getBoolean("channel_check");
                    c73.I("nuomi", z ? "pay check success" : "pay check fail", this.a.optString("appKey"), z ? "success" : com.baidu.pass.biometrics.face.liveness.b.a.g0);
                } catch (JSONException e) {
                    jx1.i("SwanAppPaymentManager", "pay_check request success, but result error: " + jSONObject + "\n" + Log.getStackTraceString(e));
                }
            }
        }

        @Override // com.repackage.vs2.b
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                jx1.i("SwanAppPaymentManager", "pay_check request fail: " + str);
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface k {
        void onFail(String str);

        void onSuccess();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755131303, "Lcom/repackage/ys2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755131303, "Lcom/repackage/ys2;");
                return;
            }
        }
        j = tg1.a;
        k = new String[]{"duershow"};
    }

    public ys2(j03 j03Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {j03Var, unitedSchemeEntity, callbackHandler, str, str2, str3};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = j03Var;
        this.b = unitedSchemeEntity;
        this.c = callbackHandler;
        this.d = str;
        this.e = str2;
        this.i = str3;
        this.h = new PaymentManager();
    }

    public static boolean A(JSONObject jSONObject) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            Object remove = jSONObject.remove("inlinePaySign");
            if (remove == null) {
                return true;
            }
            String str = remove + "";
            String A = PaymentPanelManager.z().A(str);
            String B = PaymentPanelManager.z().B(str);
            if (TextUtils.isEmpty(A)) {
                return false;
            }
            jSONObject.put("channelSource", "INNER_SDK");
            jSONObject.put(PolyActivity.PANEL_TYPE_KEY, "NONE");
            jSONObject.put(PolyActivity.CHOSEN_CHANNEL_KEY, A);
            if (!TextUtils.isEmpty(B)) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(new JSONObject(B));
                jSONObject.put("hostMarketingDetail", jSONArray.toString());
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static String J(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) ? i2 != 0 ? i2 != 2 ? EventAlias.PayEventAlias.PAY_FAIL : "支付取消" : EventAlias.PayEventAlias.PAY_SUCCESS : (String) invokeI.objValue;
    }

    public static JSONObject w(j03 j03Var, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65561, null, j03Var, jSONObject)) == null) {
            if (j03Var.v0() && jSONObject != null) {
                gl2.a V = j03Var.V();
                if (V.M() == null) {
                    return jSONObject;
                }
                JSONObject M = V.M();
                String optString = M.optString(TiebaStatic.Params.LOGID);
                String optString2 = M.optString("module_id");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                    try {
                        jSONObject.put(TiebaStatic.Params.LOGID, optString);
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
        return (JSONObject) invokeLL.objValue;
    }

    public static void y(@NonNull JSONObject jSONObject, @NonNull String str) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65562, null, jSONObject, str) == null) {
            PMSAppInfo u = e84.i().u(str);
            int i2 = u == null ? PMSConstants.PayProtected.NO_PAY_PROTECTED.type : u.payProtected;
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("baoStatus", i2);
            jSONObject2.put("sappId", 10001);
            jSONObject2.put("objectId", str);
            jSONObject.put("baoInfo", jSONObject2.toString());
        }
    }

    public static void z(@NonNull j03 j03Var, JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65563, null, j03Var, jSONObject) == null) {
            if (SwanAppAllianceLoginHelper.d.f()) {
                jSONObject.put("openBduss", qj2.h0().d(qj2.c()));
                jSONObject.put("clientId", qj2.n().b());
            } else {
                jSONObject.put("bduss", qj2.h0().d(qj2.c()));
            }
            jSONObject.put("cuid", qj2.h0().i(qj2.c()));
            String a2 = qj2.y().a();
            if (!TextUtils.isEmpty(a2)) {
                jSONObject.put("tpUid", a2);
            }
            String optString = jSONObject.optString("bizInfo");
            JSONObject jSONObject2 = TextUtils.isEmpty(optString) ? new JSONObject() : new JSONObject(optString);
            jSONObject2.put("swanFrom", j03Var.V().T());
            jSONObject2.put("cuid", qj2.h0().i(qj2.c()));
            jSONObject2.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, i03.J().getAppId());
            w(j03Var, jSONObject2);
            jSONObject.put("bizInfo", jSONObject2.toString());
            jSONObject.put("platformId", "100003");
            jSONObject.put("nativeAppId", qj2.n().a());
            jSONObject.put("sceneSource", "swan");
            jSONObject.put("swanNativeVersion", ug1.a());
            y(jSONObject, j03Var.N());
            if (j) {
                Log.i("SwanAppPaymentManager", jSONObject.toString());
            }
        }
    }

    public final boolean B(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            if (this.a.M().e(this.a.getActivity())) {
                D(str);
                return true;
            }
            j03 j03Var = this.a;
            if (j03Var == null) {
                return false;
            }
            boolean e2 = j03Var.M().e(this.a.x());
            if (!e2) {
                c73.S("show", 9, str2);
            }
            this.a.M().f(this.a.getActivity(), null, new b(this, e2, str2, str));
            return true;
        }
        return invokeLL.booleanValue;
    }

    public boolean C(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3)) == null) {
            if (TextUtils.isEmpty(str2) && (str.equals("mapp_request_duxiaoman") || str.equals("mapp_request_alipayment"))) {
                this.b.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                jx1.k("SwanAppPaymentManager", "Error: order info is null.");
                return false;
            }
            this.a.d0().g(this.a.x(), str, new a(this, str, str2, str3));
            UnitedSchemeUtility.callCallback(this.c, this.b, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public final void D(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            c73.K("baiduqianbao", "intoPayment", 0);
            this.h.e(this.a.getActivity(), str, new c(this));
        }
    }

    public final void E(String str, String[] strArr, JSONObject jSONObject, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, strArr, jSONObject, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            G(str, strArr, jSONObject);
            c73.J("nuomi", z, z2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0147 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x005b A[SYNTHETIC] */
    @SuppressLint({"BDThrowableCheck"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void F(String str, String[] strArr, JSONObject jSONObject) {
        JSONObject jSONObject2;
        JSONException e2;
        int length;
        int i2;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, str, strArr, jSONObject) == null) {
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject2 = new JSONObject(str);
                try {
                    z(this.a, jSONObject2);
                    if (!A(jSONObject2)) {
                        this.c.handleSchemeDispatchCallback(this.i, UnitedSchemeUtility.wrapCallbackParams(202).toString());
                        return;
                    }
                } catch (JSONException e3) {
                    e2 = e3;
                    if (tg1.a) {
                        e2.printStackTrace();
                    }
                    wl2.U().p();
                    String[] strArr2 = k;
                    length = strArr2.length;
                    i2 = 0;
                    while (true) {
                        if (i2 < length) {
                        }
                        i2++;
                    }
                    c73.K("nuomi", "intoPayment", 0);
                    if (!z) {
                    }
                    UnitedSchemeUtility.callCallback(this.c, this.b, UnitedSchemeUtility.wrapCallbackParams(0));
                    if (this.a.z() == null) {
                    }
                }
            } catch (JSONException e4) {
                jSONObject2 = jSONObject3;
                e2 = e4;
            }
            wl2.U().p();
            String[] strArr22 = k;
            length = strArr22.length;
            i2 = 0;
            while (true) {
                if (i2 < length) {
                    z = false;
                    break;
                } else if (strArr22[i2].equals(qj2.n().a())) {
                    z = true;
                    break;
                } else {
                    i2++;
                }
            }
            c73.K("nuomi", "intoPayment", 0);
            if (!z) {
                String a2 = rg4.a(rg4.a("https://etrade.baidu.com/cashier/create-qrcode", "orderInfo", Uri.encode(jSONObject2.toString())), "deviceType", "ANDROID");
                xz1.c3("qrCodePay", jq2.d(a2, a2));
                bt2.b(new h(this, jSONObject, str));
                jx1.k("SwanAppPaymentManager", "doPolymerPay Qr Code: " + jSONObject2.toString());
            } else {
                this.h.j(this.a.x(), jSONObject2, strArr, new i(this, jSONObject, str));
                jx1.k("SwanAppPaymentManager", "doPolymerPay: " + jSONObject2.toString());
            }
            UnitedSchemeUtility.callCallback(this.c, this.b, UnitedSchemeUtility.wrapCallbackParams(0));
            if (this.a.z() == null) {
                String valueOf = String.valueOf(this.a.V().G());
                String valueOf2 = String.valueOf(UnitedSchemeUtility.getParams(this.a.V().W()).get("_baiduboxapp"));
                Bundle bundle = new Bundle();
                bundle.putString("frameType", valueOf);
                bundle.putString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.a.V().H());
                try {
                    bundle.putString("params", URLEncoder.encode(valueOf2, "UTF-8"));
                } catch (UnsupportedEncodingException e5) {
                    if (j) {
                        throw new RuntimeException("This method requires UTF-8 encoding support", e5);
                    }
                }
                this.a.z().Y(7, bundle);
            }
        }
    }

    public final void G(String str, String[] strArr, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, str, strArr, jSONObject) == null) {
            try {
                String optString = new JSONObject(str).optString("appKey");
                if (!this.a.v0()) {
                    F(str, strArr, jSONObject);
                } else {
                    ks2.b(optString, new g(this, str, strArr, jSONObject));
                }
            } catch (JSONException e2) {
                N();
                jx1.k("SwanAppPaymentManager", " doPolymerPayChecked error " + str);
                if (tg1.a) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void H(String str, String[] strArr, JSONObject jSONObject, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, strArr, jSONObject, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            rj2.e().a(str, new f(this, str, strArr, jSONObject, z, z2));
        }
    }

    public final String I(String str, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, jSONObject)) == null) {
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
        return (String) invokeLL.objValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public boolean K(String str, JSONObject jSONObject) {
        InterceptResult invokeLL;
        String[] strArr;
        Object opt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, jSONObject)) == null) {
            String optString = jSONObject.optString("invokeFrom");
            if (TextUtils.isEmpty(optString)) {
                optString = RetrieveTaskManager.KEY;
            }
            String str2 = optString;
            boolean e2 = this.a.M().e(this.a.x());
            if (!e2) {
                c73.S("show", 8, str2);
            }
            if (TextUtils.isEmpty(str)) {
                this.b.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            String optString2 = jSONObject.optString("__plugin__");
            bw2.b("start payment");
            if (!TextUtils.isEmpty(optString2) && (opt = jSONObject.opt("error")) != null) {
                String optString3 = jSONObject.optString("slaveId");
                uv2 uv2Var = new uv2(jSONObject.optString("componentId"));
                uv2Var.a = optString3;
                uv2Var.c = opt;
                uv2Var.d = false;
                uv2Var.e = null;
                uv2Var.b();
                jx1.k("SwanAppPaymentManager", "Error: param check error - plugin pay contains custom error");
                c73.H(false, "nuomi", c73.m("", "param check error - plugin pay contains custom error"));
                this.b.result = UnitedSchemeUtility.wrapCallbackParams(1001);
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
            c73.K("nuomi", "login", 0);
            if (this.a.x() == null) {
                this.f = 5;
                this.g = null;
                M(null);
                if (j) {
                    throw new RuntimeException("swanApp getActivity returns null");
                }
                return true;
            } else if (this.a.M().e(this.a.getActivity())) {
                if (this.a.v0()) {
                    H(str, strArr, jSONObject, true, true);
                    return true;
                }
                E(str, strArr, jSONObject, true, true);
                return true;
            } else {
                this.a.M().f(this.a.getActivity(), null, new e(this, str2, str, strArr, jSONObject, e2));
                return true;
            }
        }
        return invokeLL.booleanValue;
    }

    public final void L(int i2, String str, JSONObject jSONObject, String str2) {
        JSONObject jSONObject2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), str, jSONObject, str2}) == null) {
            try {
                jSONObject2 = new JSONObject(str2);
            } catch (JSONException e2) {
                e2.printStackTrace();
                jSONObject2 = new JSONObject();
            }
            wl2.U().c();
            jx1.i("SwanAppPaymentManager", "sendSecondCallback statusCode: " + this.f + " params: " + this.g + " payParams: " + jSONObject.toString() + " orderId: " + jSONObject2.optString("tpOrderId"));
            O(i2, "nuomi", I(str, jSONObject2));
            this.f = i2;
            this.g = str;
            if (i2 != 1) {
                c73.K("nuomi", "result", i2);
            }
            M(null);
            if (jSONObject != null && !TextUtils.isEmpty(jSONObject.optString("__plugin__"))) {
                String optString = jSONObject.optString("slaveId");
                String optString2 = jSONObject.optString("componentId");
                Object opt = jSONObject.opt("error");
                uv2 uv2Var = new uv2(optString2);
                uv2Var.a = optString;
                uv2Var.c = opt;
                uv2Var.d = i2 == 0;
                uv2Var.e = str;
                uv2Var.b();
                hw2.j();
            }
            if (this.f == 0 && !py2.c.c()) {
                py2.c.e();
            }
            if (i2 == 0) {
                vs2 vs2Var = new vs2();
                vs2Var.h(jSONObject2);
                vs2Var.d(new j(this, jSONObject2));
            }
        }
    }

    public final void M(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            try {
                if (TextUtils.equals(this.d, "2.0")) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("payId", str);
                    if (!TextUtils.isEmpty(this.g)) {
                        jSONObject.put("payResult", Base64.encodeToString(this.g.getBytes("UTF-8"), 2));
                    }
                    jx1.i("SwanAppPaymentManager", "Success: sendSecondCallback, data = " + jSONObject + " status code = " + this.f);
                    this.c.handleSchemeDispatchCallback(this.i, UnitedSchemeUtility.wrapCallbackParams(jSONObject, this.f, J(this.f)).toString());
                    return;
                }
                jx1.i("SwanAppPaymentManager", "Success: sendSecondCallback, result = " + this.g + " status code = " + this.f);
                this.c.handleSchemeDispatchCallback(this.i, UnitedSchemeUtility.wrapCallbackParamsWithBase64(this.g, this.f, J(this.f)).toString());
            } catch (UnsupportedEncodingException | JSONException e2) {
                jx1.i("SwanAppPaymentManager", "Fail: sendSecondCallback exception , exception = " + e2.getMessage() + " stack trace = " + Arrays.toString(e2.getStackTrace()));
                CallbackHandler callbackHandler = this.c;
                String str2 = this.i;
                int i2 = this.f;
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, i2, J(i2)).toString());
            }
        }
    }

    public final void N() {
        j03 j03Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (j03Var = this.a) == null) {
            return;
        }
        b03.f(j03Var.x(), R.string.obfuscated_res_0x7f0f12b1).G();
        if (TextUtils.isEmpty(this.i)) {
            return;
        }
        this.c.handleSchemeDispatchCallback(this.i, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, 6, this.a.x().getString(R.string.obfuscated_res_0x7f0f12b1)).toString());
    }

    public final void O(int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048588, this, i2, str, str2) == null) {
            c73.H(i2 == 0, str, str2);
        }
    }

    public final boolean P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            jx1.i("SwanAppPaymentManager", "start UnitedSchemeWalletDispatcher ACTION_REQUEST_WECHAT_PAYMENT");
            if (et2.a(this.a, this.c, this.b)) {
                this.f = 0;
                this.g = null;
                if (TextUtils.equals(this.d, "2.0")) {
                    qj2.W().e(this.e, this);
                } else {
                    M(null);
                }
                c73.G("wechatH5Action", null, null);
                return true;
            }
            jx1.k("SwanAppPaymentManager", "Error: open webview error.  entity = " + this.b.toString());
            this.c.handleSchemeDispatchCallback(this.i, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.ny2
    public void a(JSONObject jSONObject) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, jSONObject) == null) {
            jx1.c("SwanAppPaymentManager", "Info: getPayId Request Response =  " + jSONObject.toString());
            if (jSONObject.optInt("errno") == 0) {
                str = jSONObject.optJSONObject("data").optString("payid");
                jx1.c("SwanAppPaymentManager", "Info: payId =  " + str);
            } else {
                str = null;
            }
            M(str);
            if (py2.c.c()) {
                return;
            }
            if (qj2.h0().e(this.a)) {
                py2.c.e();
            } else {
                py2.c.f();
            }
        }
    }

    @Override // com.repackage.ny2
    public void onFail(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            jx1.c("SwanAppPaymentManager", "Fail: request payId failed");
            jx1.c("SwanAppPaymentManager", str);
            M(null);
        }
    }

    public final boolean x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            if (j) {
                Log.d("SwanAppPaymentManager", "start UnitedSchemeWalletDispatcher ACTION_REQUEST_ALI_PAYMENT orderInfo: " + str);
            }
            c73.K("alipay", "intoPayment", 0);
            this.h.d(this.a.getActivity(), str, new d(this));
            return true;
        }
        return invokeL.booleanValue;
    }
}
