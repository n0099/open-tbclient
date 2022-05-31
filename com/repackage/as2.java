package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.payment.PaymentManager;
import com.baidu.poly.widget.PolyActivity;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.m43;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class as2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public static final String[] h;
    public static final Map<String, String> i;
    public transient /* synthetic */ FieldHolder $fh;
    public d a;
    public hz2 b;
    public SwanAppActivity c;
    public PaymentManager d;
    public String e;
    public String f;

    /* loaded from: classes5.dex */
    public class a implements ae3<k43<m43.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;
        public final /* synthetic */ String b;
        public final /* synthetic */ as2 c;

        public a(as2 as2Var, JSONObject jSONObject, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {as2Var, jSONObject, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = as2Var;
            this.a = jSONObject;
            this.b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ae3
        /* renamed from: a */
        public void onCallback(k43<m43.e> k43Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, k43Var) == null) {
                if (f43.h(k43Var)) {
                    this.c.p(this.a, this.b);
                    return;
                }
                hw1.i("SwanAppThirdPayment", "authorize fail");
                a63.H(false, this.c.f, a63.m("", "authorize fail"));
                this.c.i(new hr1(k43Var.b(), f43.f(k43Var.b())));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements tf1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ JSONObject b;
        public final /* synthetic */ as2 c;

        public b(as2 as2Var, String str, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {as2Var, str, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = as2Var;
            this.a = str;
            this.b = jSONObject;
        }

        @Override // com.repackage.tf1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i == 0) {
                    a63.J(this.c.f, true, false);
                    a63.S("success", 13, this.a);
                    this.c.l(this.b);
                    return;
                }
                hw1.i("SwanAppThirdPayment", "login fail");
                a63.H(false, this.c.f, a63.m("", "login error"));
                a63.S(com.baidu.pass.biometrics.face.liveness.b.a.g0, 13, this.a);
                a63.J(this.c.f, false, false);
                this.c.i(new hr1(5, "login error"));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements g61 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;
        public final /* synthetic */ as2 b;

        public c(as2 as2Var, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {as2Var, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = as2Var;
            this.a = jSONObject;
        }

        /* JADX WARN: Removed duplicated region for block: B:29:0x0088  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x009a  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00c7  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x0059 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // com.repackage.g61
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onPayResult(int i, String str) {
            JSONObject jSONObject;
            JSONException e;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                hw1.b("SwanAppThirdPayment", "pay result from nuomi: code:" + i + ", result: " + str);
                JSONObject jSONObject2 = new JSONObject();
                Object obj = null;
                try {
                    jSONObject = new JSONObject(str);
                    try {
                        obj = jSONObject.remove("returnData");
                        jSONObject.remove("msg");
                        jSONObject.remove("statusCode");
                    } catch (JSONException e2) {
                        e = e2;
                        if (as2.g) {
                            Log.e("SwanAppThirdPayment", Log.getStackTraceString(e));
                        }
                        if (obj != null) {
                        }
                        if (i != 0) {
                        }
                        if (i != 1) {
                        }
                        String j = as2.j(i, this.b.c);
                        if (TextUtils.equals("WeChat", this.b.e)) {
                            i = 0;
                        }
                        this.b.i(new hr1(i, j, jSONObject));
                    }
                } catch (JSONException e3) {
                    jSONObject = jSONObject2;
                    e = e3;
                }
                if (obj != null) {
                    try {
                        jSONObject.put("returnData", new JSONObject(String.valueOf(obj)));
                    } catch (JSONException e4) {
                        if (as2.g) {
                            Log.e("SwanAppThirdPayment", Log.getStackTraceString(e4));
                        }
                        try {
                            jSONObject.put("returnData", obj);
                        } catch (JSONException e5) {
                            if (as2.g) {
                                Log.e("SwanAppThirdPayment", Log.getStackTraceString(e5));
                            }
                        }
                    }
                }
                if (i != 0) {
                    a63.H(true, this.b.f, this.b.k(str, this.a));
                } else {
                    hw1.i("SwanAppThirdPayment", "pay not success: code:" + i + ", result: " + str);
                    a63.H(false, this.b.f, this.b.k(str, this.a));
                }
                if (i != 1) {
                    a63.K(this.b.f, "result", i);
                }
                String j2 = as2.j(i, this.b.c);
                if (TextUtils.equals("WeChat", this.b.e) && i == 1) {
                    i = 0;
                }
                this.b.i(new hr1(i, j2, jSONObject));
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface d {
        void a(@NonNull hr1 hr1Var);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755846287, "Lcom/repackage/as2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755846287, "Lcom/repackage/as2;");
                return;
            }
        }
        g = rf1.a;
        h = new String[]{"dealId", "appKey", "totalAmount", "tpOrderId", "rsaSign", "dealTitle", PolyActivity.CHOSEN_CHANNEL_KEY, "payInfo", "tradeNo", "mchIdMd5"};
        HashMap hashMap = new HashMap();
        i = hashMap;
        hashMap.put("WeChat", "thirdPayWechatH5");
        i.put("Alipay", "thirdPayAlipay");
    }

    public as2(@NonNull hz2 hz2Var, @NonNull SwanAppActivity swanAppActivity, @NonNull d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hz2Var, swanAppActivity, dVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = "thirdPayUnknown";
        this.b = hz2Var;
        this.c = swanAppActivity;
        this.a = dVar;
        this.d = new PaymentManager();
    }

    public static String j(int i2, Context context) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65546, null, i2, context)) == null) {
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        return context.getString(R.string.obfuscated_res_0x7f0f1259);
                    }
                    return context.getString(R.string.obfuscated_res_0x7f0f1258);
                }
                return context.getString(R.string.obfuscated_res_0x7f0f125a);
            }
            return context.getString(R.string.obfuscated_res_0x7f0f125b);
        }
        return (String) invokeIL.objValue;
    }

    public final void i(@NonNull hr1 hr1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, hr1Var) == null) {
            this.a.a(hr1Var);
            hw1.b("SwanAppThirdPayment", "pay result to js: " + hr1Var);
        }
    }

    public final String k(String str, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, jSONObject)) == null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                JSONObject jSONObject3 = new JSONObject(str);
                jSONObject2.put("orderId", jSONObject.opt("tpOrderId"));
                jSONObject2.put("msg", jSONObject3.opt("msg"));
            } catch (JSONException e) {
                hw1.b("SwanAppThirdPayment", Log.getStackTraceString(e));
                try {
                    jSONObject2.put("orderId", jSONObject.opt("tpOrderId"));
                    jSONObject2.put("msg", str);
                } catch (JSONException e2) {
                    hw1.b("SwanAppThirdPayment", Log.getStackTraceString(e2));
                }
            }
            return jSONObject2.toString();
        }
        return (String) invokeLL.objValue;
    }

    public final void l(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
            a63.K(this.f, "intoPayment", 0);
            try {
                wr2.z(this.b, jSONObject);
                jSONObject.put(PolyActivity.TRADE_TYPE, PolyActivity.DIRECT_PAY_TRADE_TYPE);
                jSONObject.put(PolyActivity.PANEL_TYPE_KEY, "NONE");
            } catch (JSONException e) {
                if (g) {
                    Log.e("SwanAppThirdPayment", Log.getStackTraceString(e));
                }
            }
            hw1.b("SwanAppThirdPayment", "orderInfo to nuomi: " + jSONObject);
            this.d.j(this.c, jSONObject, null, new c(this, jSONObject));
        }
    }

    public final hr1 m(JSONObject jSONObject) {
        InterceptResult invokeL;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, jSONObject)) == null) {
            if (jSONObject == null) {
                return new hr1(202, "parse orderInfo fail");
            }
            for (String str : h) {
                Object opt = jSONObject.opt(str);
                if (opt == null) {
                    return new hr1(202, str + " is necessary");
                } else if (!(opt instanceof String)) {
                    return new hr1(202, str + " must be a string");
                } else if (TextUtils.isEmpty((String) opt)) {
                    return new hr1(202, str + " is empty");
                }
            }
            Object opt2 = jSONObject.opt("returnData");
            if (opt2 == null || (opt2 instanceof JSONObject)) {
                return null;
            }
            return new hr1(202, "returnData must be a object");
        }
        return (hr1) invokeL.objValue;
    }

    public void n(@Nullable JSONObject jSONObject, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, jSONObject, str) == null) {
            a63.K(this.f, "create", 0);
            hr1 m = m(jSONObject);
            if (m != null) {
                hw1.i("SwanAppThirdPayment", "orderInfo param error: " + m);
                a63.H(false, this.f, a63.m("", "orderInfo param error"));
                i(m);
                return;
            }
            String optString = jSONObject.optString(PolyActivity.CHOSEN_CHANNEL_KEY);
            this.e = optString;
            String str2 = i.get(optString);
            this.f = str2;
            if (TextUtils.isEmpty(str2)) {
                hw1.i("SwanAppThirdPayment", "orderInfo param error: chosen channel error");
                a63.H(false, "thirdPayUnknown", a63.m("", "orderInfo param error: chosen channel error"));
                i(new hr1(202, "chosenChannel error"));
                return;
            }
            o(jSONObject, str);
        }
    }

    public final void o(JSONObject jSONObject, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, jSONObject, str) == null) {
            this.b.d0().g(this.c, "scope_request_thirdpayment", new a(this, jSONObject, str));
        }
    }

    public final void p(JSONObject jSONObject, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, jSONObject, str) == null) {
            if (!b61.a().b(this.c)) {
                SwanAppActivity swanAppActivity = this.c;
                zy2.g(swanAppActivity, swanAppActivity.getText(R.string.obfuscated_res_0x7f0f01e3)).G();
                a63.H(false, "wechatH5Action", a63.m("", "Error: wechat not install. "));
                i(new hr1(1002, "had not installed WeChat"));
                return;
            }
            a63.K(this.f, "login", 0);
            if (this.b.M().e(this.c)) {
                a63.J(this.f, true, true);
                l(jSONObject);
                return;
            }
            a63.S("show", 13, str);
            this.b.M().f(this.c, null, new b(this, str, jSONObject));
        }
    }
}
