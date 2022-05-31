package com.repackage;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.poly.statistics.exception.ServerDataException;
import com.baidu.poly.widget.PayChannelEntity;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class z61 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String b = "payChannel";
    public static String c = "installmentPeriod";
    public static String d = "payType";
    public static volatile z61 e;
    public transient /* synthetic */ FieldHolder $fh;
    public w61 a;

    /* loaded from: classes7.dex */
    public class a extends r61<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r61 a;
        public final /* synthetic */ z61 b;

        public a(z61 z61Var, r61 r61Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z61Var, r61Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = z61Var;
            this.a = r61Var;
        }

        @Override // com.repackage.r61
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.b.w("7", 119501, "cashier/channelAllInfo", i);
                this.a.b(th, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.r61
        /* renamed from: d */
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt(StatConstants.KEY_EXT_ERR_CODE, -1);
                    int optInt2 = jSONObject.optInt("errno", -1);
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    if (optJSONObject == null || optInt != 0 || optInt2 != 0) {
                        this.b.w("7", 119503, "cashier/channelAllInfo", optInt2);
                        String optString = jSONObject.optString("errmsg");
                        r61 r61Var = this.a;
                        ServerDataException serverDataException = new ServerDataException("errmsg = " + optString);
                        r61Var.b(serverDataException, "errno is " + optInt2);
                        return;
                    }
                    this.a.c(optJSONObject);
                } catch (JSONException unused) {
                    this.b.w("7", 119502, "cashier/channelAllInfo", -1);
                    this.a.b(new ServerDataException("服务异常，请稍后重试"), "服务异常，请稍后重试");
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends r61<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ r61 b;
        public final /* synthetic */ z61 c;

        public b(z61 z61Var, String str, r61 r61Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z61Var, str, r61Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = z61Var;
            this.a = str;
            this.b = r61Var;
        }

        @Override // com.repackage.r61
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.c.x("8", 119501, "cashier/launchpayment", i, this.a);
                this.b.b(th, n81.a().getResources().getString(R.string.obfuscated_res_0x7f0f0413));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.r61
        /* renamed from: d */
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("errno", -1);
                    if (optInt != 0) {
                        this.c.x("8", 119503, "cashier/launchpayment", optInt, this.a);
                        String optString = jSONObject.optString("msg");
                        r61 r61Var = this.b;
                        r61Var.b(new ServerDataException("msg = " + optString), optString);
                        return;
                    }
                    this.b.c(this.c.y(jSONObject.optJSONObject("data")));
                } catch (JSONException unused) {
                    this.c.x("8", 119502, "cashier/launchpayment", -1, this.a);
                    this.b.b(new ServerDataException("服务异常，请稍后重试"), "服务异常，请稍后重试");
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends r61<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r61 a;
        public final /* synthetic */ z61 b;

        public c(z61 z61Var, r61 r61Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z61Var, r61Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = z61Var;
            this.a = r61Var;
        }

        @Override // com.repackage.r61
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.b.w("8", 119501, "cashier/pay", i);
                this.a.b(th, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.r61
        /* renamed from: d */
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("errno", -1);
                    if (optInt != 0) {
                        this.b.w("8", 119503, "cashier/pay", optInt);
                        String optString = jSONObject.optString("msg");
                        r61 r61Var = this.a;
                        r61Var.b(new ServerDataException("msg = " + optString), optString);
                        return;
                    }
                    this.a.c(this.b.y(jSONObject.optJSONObject("data")));
                } catch (Throwable unused) {
                    this.b.w("8", 119502, "cashier/pay", -1);
                    this.a.b(new ServerDataException("服务异常，请稍后重试"), "服务异常，请稍后重试");
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends r61<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r61 a;
        public final /* synthetic */ z61 b;

        public d(z61 z61Var, r61 r61Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z61Var, r61Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = z61Var;
            this.a = r61Var;
        }

        @Override // com.repackage.r61
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.b.w(TbEnum.SystemMessage.EVENT_ID_GROUP_JOIN, 119501, "cashier/sdkAdaptH5QueryPay", i);
                this.a.b(th, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.r61
        /* renamed from: d */
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("errno", -1);
                    if (optInt != 0) {
                        this.b.w(TbEnum.SystemMessage.EVENT_ID_GROUP_JOIN, 119503, "cashier/sdkAdaptH5QueryPay", optInt);
                        String optString = jSONObject.optString("msg");
                        r61 r61Var = this.a;
                        ServerDataException serverDataException = new ServerDataException("msg = " + optString);
                        r61Var.b(serverDataException, "errno is " + optInt);
                        return;
                    }
                    this.a.c(jSONObject.optJSONObject("data"));
                } catch (Throwable unused) {
                    this.b.w(TbEnum.SystemMessage.EVENT_ID_GROUP_JOIN, 119502, "cashier/sdkAdaptH5QueryPay", -1);
                    this.a.b(new ServerDataException("服务异常，请稍后重试"), "服务异常，请稍后重试");
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends r61<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r61 a;

        public e(z61 z61Var, r61 r61Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z61Var, r61Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r61Var;
        }

        @Override // com.repackage.r61
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.a.b(th, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.r61
        /* renamed from: d */
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("errno", -1);
                    if (optInt == 0) {
                        this.a.c(jSONObject.optJSONObject("data"));
                        return;
                    }
                    String optString = jSONObject.optString("msg");
                    r61 r61Var = this.a;
                    ServerDataException serverDataException = new ServerDataException("msg=" + optString);
                    r61Var.b(serverDataException, "code=" + optInt);
                } catch (Throwable th) {
                    j81.d(th.getMessage());
                    this.a.b(new ServerDataException("服务异常，请稍后重试"), "服务异常，请稍后重试");
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f extends r61<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r61 a;

        public f(z61 z61Var, r61 r61Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z61Var, r61Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r61Var;
        }

        @Override // com.repackage.r61
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.a.b(th, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.r61
        /* renamed from: d */
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("errno", -1);
                    if (optInt == 0) {
                        this.a.c(jSONObject.optJSONObject("data"));
                        return;
                    }
                    String optString = jSONObject.optString("msg");
                    r61 r61Var = this.a;
                    ServerDataException serverDataException = new ServerDataException("msg=" + optString);
                    r61Var.b(serverDataException, "code=" + optInt);
                } catch (Throwable th) {
                    j81.d(th.getMessage());
                    this.a.b(new ServerDataException("服务异常，请稍后重试"), "服务异常，请稍后重试");
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g extends r61<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r61 a;

        public g(z61 z61Var, r61 r61Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z61Var, r61Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r61Var;
        }

        @Override // com.repackage.r61
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.a.b(th, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.r61
        /* renamed from: d */
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("errno", -1);
                    if (optInt == 0) {
                        this.a.c(jSONObject.optJSONObject("data"));
                        return;
                    }
                    String optString = jSONObject.optString("msg");
                    r61 r61Var = this.a;
                    ServerDataException serverDataException = new ServerDataException("msg=" + optString);
                    r61Var.b(serverDataException, "code=" + optInt);
                } catch (Throwable th) {
                    j81.d(th.getMessage());
                    this.a.b(new ServerDataException("服务异常，请稍后重试"), "服务异常，请稍后重试");
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755160164, "Lcom/repackage/z61;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755160164, "Lcom/repackage/z61;");
        }
    }

    public z61(w61 w61Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {w61Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = w61Var;
    }

    public static z61 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (e == null) {
                synchronized (z61.class) {
                    if (e == null) {
                        e = new z61(new x61());
                    }
                }
            }
            return e;
        }
        return (z61) invokeV.objValue;
    }

    public s61 d(Bundle bundle, t61 t61Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bundle, t61Var)) == null) {
            s61 s61Var = new s61();
            t(s61Var, bundle);
            s61Var.d(d, "android");
            n(bundle, s61Var, t61Var);
            return s61Var;
        }
        return (s61) invokeLL.objValue;
    }

    public void e(Bundle bundle, r61<JSONObject> r61Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle, r61Var) == null) {
            f(bundle, false, r61Var);
        }
    }

    public void f(Bundle bundle, boolean z, r61<JSONObject> r61Var) {
        String c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{bundle, Boolean.valueOf(z), r61Var}) == null) {
            t61 h = h();
            Set<String> keySet = bundle.keySet();
            s61 s61Var = new s61();
            for (String str : keySet) {
                if ((bundle.get(str) instanceof String) && (!z || !"bduss".equals(str))) {
                    s61Var.d(str, bundle.get(str).toString());
                }
            }
            n(bundle, s61Var, h);
            r(bundle, s61Var, h);
            p(bundle, s61Var, h);
            if (z) {
                c2 = b71.d();
            } else {
                c2 = b71.c();
            }
            w71.a("1.02", System.currentTimeMillis());
            this.a.a(c2, h, s61Var, new a(this, r61Var));
        }
    }

    public void g(String str, s61 s61Var, r61<JSONObject> r61Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, s61Var, r61Var) == null) {
            this.a.a(str, h(), s61Var, new g(this, r61Var));
        }
    }

    public final t61 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            t61 t61Var = new t61();
            a71.d(t61Var);
            return t61Var;
        }
        return (t61) invokeV.objValue;
    }

    public final t61 i(t61 t61Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, t61Var)) == null) {
            if (t61Var == null) {
                t61Var = new t61();
            }
            a71.d(t61Var);
            return t61Var;
        }
        return (t61) invokeL.objValue;
    }

    public void k(String str, String str2, String str3, r61<JSONObject> r61Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048582, this, str, str2, str3, r61Var) == null) {
            t61 h = h();
            o(str, h);
            s61 s61Var = new s61();
            s61Var.d("bduss", str);
            s61Var.d("payChannel", str2);
            s61Var.d("appKey", str3);
            this.a.a(b71.i(), h, s61Var, new e(this, r61Var));
        }
    }

    public void l(String str, String str2, String str3, r61<JSONObject> r61Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048583, this, str, str2, str3, r61Var) == null) {
            t61 h = h();
            o(str, h);
            s61 s61Var = new s61();
            s61Var.d("appKey", str3);
            s61Var.d("bduss", str);
            s61Var.d("payChannel", str2);
            s61Var.d("sign", q71.c("appKey=" + str3 + "&bduss=" + str + "&payChannel=" + str2 + "&lLoIsWxrSeJmHQD2TVQQ"));
            this.a.a(b71.k(), h, s61Var, new f(this, r61Var));
        }
    }

    public void m(Bundle bundle, r61<JSONObject> r61Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle, r61Var) == null) {
            t61 h = h();
            Set<String> keySet = bundle.keySet();
            s61 s61Var = new s61();
            for (String str : keySet) {
                if (bundle.get(str) instanceof String) {
                    s61Var.d(str, bundle.get(str).toString());
                }
            }
            this.a.a(b71.m(), h, s61Var, new d(this, r61Var));
        }
    }

    public final void n(Bundle bundle, s61 s61Var, t61 t61Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048585, this, bundle, s61Var, t61Var) == null) {
            String string = bundle.getString("bduss");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            o(string, t61Var);
        }
    }

    public final void o(String str, t61 t61Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, t61Var) == null) {
            String a2 = t61Var.a("Cookie");
            String str2 = "BDUSS=" + str;
            if (a2 == null) {
                t61Var.d("Cookie", str2);
                return;
            }
            t61Var.d("Cookie", a2 + "; " + str2);
        }
    }

    public final void p(Bundle bundle, s61 s61Var, t61 t61Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, bundle, s61Var, t61Var) == null) {
            String string = bundle.getString("clientId");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            q(string, t61Var);
        }
    }

    public final void q(String str, t61 t61Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, str, t61Var) == null) {
            String a2 = t61Var.a("Cookie");
            String str2 = "CLIENTID=" + str;
            if (a2 == null) {
                t61Var.d("Cookie", str2);
                return;
            }
            t61Var.d("Cookie", a2 + "; " + str2);
        }
    }

    public final void r(Bundle bundle, s61 s61Var, t61 t61Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048589, this, bundle, s61Var, t61Var) == null) {
            String string = bundle.getString("openBduss");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            s(string, t61Var);
        }
    }

    public final void s(String str, t61 t61Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, str, t61Var) == null) {
            String a2 = t61Var.a("Cookie");
            String str2 = "OPENBDUSS=" + str;
            if (a2 == null) {
                t61Var.d("Cookie", str2);
                return;
            }
            t61Var.d("Cookie", a2 + "; " + str2);
        }
    }

    public final void t(s61 s61Var, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048591, this, s61Var, bundle) == null) || bundle == null || s61Var == null) {
            return;
        }
        for (String str : bundle.keySet()) {
            s61Var.d(str, bundle.getString(str));
        }
        Iterator<Map.Entry<String, String>> it = s61Var.b().entrySet().iterator();
        while (it.hasNext()) {
            if (TextUtils.isEmpty(it.next().getValue())) {
                it.remove();
            }
        }
    }

    public void u(Bundle bundle, r61<Map<String, String>> r61Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, bundle, r61Var) == null) {
            t61 h = h();
            s61 d2 = d(bundle, h);
            this.a.a(b71.l(), h, d2, new c(this, r61Var));
        }
    }

    public void v(t61 t61Var, Bundle bundle, r61<Map<String, String>> r61Var, PayChannelEntity payChannelEntity, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048593, this, t61Var, bundle, r61Var, payChannelEntity, str) == null) {
            t61 i = i(t61Var);
            Set<String> keySet = bundle.keySet();
            s61 s61Var = new s61();
            for (String str2 : keySet) {
                if (bundle.get(str2) instanceof String) {
                    s61Var.d(str2, bundle.get(str2).toString());
                }
            }
            if (payChannelEntity == null) {
                return;
            }
            String payChannel = payChannelEntity.getPayChannel();
            if (!TextUtils.isEmpty(payChannel)) {
                s61Var.d(b, payChannel);
            }
            String installmentPeriod = payChannelEntity.getInstallmentPeriod();
            if (!TextUtils.isEmpty(installmentPeriod)) {
                s61Var.d(c, installmentPeriod);
            }
            n(bundle, s61Var, i);
            this.a.a(b71.j(), i, s61Var, new b(this, str, r61Var));
        }
    }

    public final void w(String str, int i, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{str, Integer.valueOf(i), str2, Integer.valueOf(i2)}) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("exceptionType", "" + i);
            hashMap.put("path", str2);
            hashMap.put(StatConstants.KEY_EXT_ERR_CODE, "" + i2);
            w71.c(str, hashMap);
        }
    }

    public final void x(String str, int i, String str2, int i2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{str, Integer.valueOf(i), str2, Integer.valueOf(i2), str3}) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("exceptionType", "" + i);
            hashMap.put("path", str2);
            hashMap.put(StatConstants.KEY_EXT_ERR_CODE, "" + i2);
            if (!TextUtils.isEmpty(str3)) {
                hashMap.put("isFoldChannel", str3);
            }
            w71.c(str, hashMap);
        }
    }

    public final Map<String, String> y(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, jSONObject)) == null) {
            Map<String, String> c2 = k81.c();
            if (jSONObject != null) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (!TextUtils.isEmpty(next)) {
                        c2.put(next, jSONObject.optString(next));
                    }
                }
            }
            return c2;
        }
        return (Map) invokeL.objValue;
    }
}
