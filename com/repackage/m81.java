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
/* loaded from: classes6.dex */
public class m81 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String b = "payChannel";
    public static String c = "installmentPeriod";
    public static String d = "payType";
    public static volatile m81 e;
    public transient /* synthetic */ FieldHolder $fh;
    public j81 a;

    /* loaded from: classes6.dex */
    public class a extends e81<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e81 a;
        public final /* synthetic */ m81 b;

        public a(m81 m81Var, e81 e81Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m81Var, e81Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = m81Var;
            this.a = e81Var;
        }

        @Override // com.repackage.e81
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.b.w("7", 119501, "cashier/channelAllInfo", i);
                this.a.b(th, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.e81
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
                        e81 e81Var = this.a;
                        ServerDataException serverDataException = new ServerDataException("errmsg = " + optString);
                        e81Var.b(serverDataException, "errno is " + optInt2);
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

    /* loaded from: classes6.dex */
    public class b extends e81<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ e81 b;
        public final /* synthetic */ m81 c;

        public b(m81 m81Var, String str, e81 e81Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m81Var, str, e81Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = m81Var;
            this.a = str;
            this.b = e81Var;
        }

        @Override // com.repackage.e81
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.c.x("8", 119501, "cashier/launchpayment", i, this.a);
                this.b.b(th, aa1.a().getResources().getString(R.string.obfuscated_res_0x7f0f040f));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.e81
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
                        e81 e81Var = this.b;
                        e81Var.b(new ServerDataException("msg = " + optString), optString);
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

    /* loaded from: classes6.dex */
    public class c extends e81<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e81 a;
        public final /* synthetic */ m81 b;

        public c(m81 m81Var, e81 e81Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m81Var, e81Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = m81Var;
            this.a = e81Var;
        }

        @Override // com.repackage.e81
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.b.w("8", 119501, "cashier/pay", i);
                this.a.b(th, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.e81
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
                        e81 e81Var = this.a;
                        e81Var.b(new ServerDataException("msg = " + optString), optString);
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

    /* loaded from: classes6.dex */
    public class d extends e81<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e81 a;
        public final /* synthetic */ m81 b;

        public d(m81 m81Var, e81 e81Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m81Var, e81Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = m81Var;
            this.a = e81Var;
        }

        @Override // com.repackage.e81
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.b.w(TbEnum.SystemMessage.EVENT_ID_GROUP_JOIN, 119501, "cashier/sdkAdaptH5QueryPay", i);
                this.a.b(th, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.e81
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
                        e81 e81Var = this.a;
                        ServerDataException serverDataException = new ServerDataException("msg = " + optString);
                        e81Var.b(serverDataException, "errno is " + optInt);
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

    /* loaded from: classes6.dex */
    public class e extends e81<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e81 a;

        public e(m81 m81Var, e81 e81Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m81Var, e81Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e81Var;
        }

        @Override // com.repackage.e81
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.a.b(th, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.e81
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
                    e81 e81Var = this.a;
                    ServerDataException serverDataException = new ServerDataException("msg=" + optString);
                    e81Var.b(serverDataException, "code=" + optInt);
                } catch (Throwable th) {
                    w91.d(th.getMessage());
                    this.a.b(new ServerDataException("服务异常，请稍后重试"), "服务异常，请稍后重试");
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f extends e81<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e81 a;

        public f(m81 m81Var, e81 e81Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m81Var, e81Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e81Var;
        }

        @Override // com.repackage.e81
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.a.b(th, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.e81
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
                    e81 e81Var = this.a;
                    ServerDataException serverDataException = new ServerDataException("msg=" + optString);
                    e81Var.b(serverDataException, "code=" + optInt);
                } catch (Throwable th) {
                    w91.d(th.getMessage());
                    this.a.b(new ServerDataException("服务异常，请稍后重试"), "服务异常，请稍后重试");
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g extends e81<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e81 a;

        public g(m81 m81Var, e81 e81Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m81Var, e81Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e81Var;
        }

        @Override // com.repackage.e81
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.a.b(th, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.e81
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
                    e81 e81Var = this.a;
                    ServerDataException serverDataException = new ServerDataException("msg=" + optString);
                    e81Var.b(serverDataException, "code=" + optInt);
                } catch (Throwable th) {
                    w91.d(th.getMessage());
                    this.a.b(new ServerDataException("服务异常，请稍后重试"), "服务异常，请稍后重试");
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755545525, "Lcom/repackage/m81;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755545525, "Lcom/repackage/m81;");
        }
    }

    public m81(j81 j81Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {j81Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = j81Var;
    }

    public static m81 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (e == null) {
                synchronized (m81.class) {
                    if (e == null) {
                        e = new m81(new k81());
                    }
                }
            }
            return e;
        }
        return (m81) invokeV.objValue;
    }

    public f81 d(Bundle bundle, g81 g81Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bundle, g81Var)) == null) {
            f81 f81Var = new f81();
            t(f81Var, bundle);
            f81Var.d(d, "android");
            n(bundle, f81Var, g81Var);
            return f81Var;
        }
        return (f81) invokeLL.objValue;
    }

    public void e(Bundle bundle, e81<JSONObject> e81Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle, e81Var) == null) {
            f(bundle, false, e81Var);
        }
    }

    public void f(Bundle bundle, boolean z, e81<JSONObject> e81Var) {
        String c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{bundle, Boolean.valueOf(z), e81Var}) == null) {
            g81 h = h();
            Set<String> keySet = bundle.keySet();
            f81 f81Var = new f81();
            for (String str : keySet) {
                if ((bundle.get(str) instanceof String) && (!z || !"bduss".equals(str))) {
                    f81Var.d(str, bundle.get(str).toString());
                }
            }
            n(bundle, f81Var, h);
            r(bundle, f81Var, h);
            p(bundle, f81Var, h);
            if (z) {
                c2 = o81.d();
            } else {
                c2 = o81.c();
            }
            j91.a("1.02", System.currentTimeMillis());
            this.a.a(c2, h, f81Var, new a(this, e81Var));
        }
    }

    public void g(String str, f81 f81Var, e81<JSONObject> e81Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, f81Var, e81Var) == null) {
            this.a.a(str, h(), f81Var, new g(this, e81Var));
        }
    }

    public final g81 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            g81 g81Var = new g81();
            n81.d(g81Var);
            return g81Var;
        }
        return (g81) invokeV.objValue;
    }

    public final g81 i(g81 g81Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, g81Var)) == null) {
            if (g81Var == null) {
                g81Var = new g81();
            }
            n81.d(g81Var);
            return g81Var;
        }
        return (g81) invokeL.objValue;
    }

    public void k(String str, String str2, String str3, e81<JSONObject> e81Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048582, this, str, str2, str3, e81Var) == null) {
            g81 h = h();
            o(str, h);
            f81 f81Var = new f81();
            f81Var.d("bduss", str);
            f81Var.d("payChannel", str2);
            f81Var.d("appKey", str3);
            this.a.a(o81.i(), h, f81Var, new e(this, e81Var));
        }
    }

    public void l(String str, String str2, String str3, e81<JSONObject> e81Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048583, this, str, str2, str3, e81Var) == null) {
            g81 h = h();
            o(str, h);
            f81 f81Var = new f81();
            f81Var.d("appKey", str3);
            f81Var.d("bduss", str);
            f81Var.d("payChannel", str2);
            f81Var.d("sign", d91.c("appKey=" + str3 + "&bduss=" + str + "&payChannel=" + str2 + "&lLoIsWxrSeJmHQD2TVQQ"));
            this.a.a(o81.k(), h, f81Var, new f(this, e81Var));
        }
    }

    public void m(Bundle bundle, e81<JSONObject> e81Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle, e81Var) == null) {
            g81 h = h();
            Set<String> keySet = bundle.keySet();
            f81 f81Var = new f81();
            for (String str : keySet) {
                if (bundle.get(str) instanceof String) {
                    f81Var.d(str, bundle.get(str).toString());
                }
            }
            this.a.a(o81.m(), h, f81Var, new d(this, e81Var));
        }
    }

    public final void n(Bundle bundle, f81 f81Var, g81 g81Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048585, this, bundle, f81Var, g81Var) == null) {
            String string = bundle.getString("bduss");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            o(string, g81Var);
        }
    }

    public final void o(String str, g81 g81Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, g81Var) == null) {
            String a2 = g81Var.a("Cookie");
            String str2 = "BDUSS=" + str;
            if (a2 == null) {
                g81Var.d("Cookie", str2);
                return;
            }
            g81Var.d("Cookie", a2 + "; " + str2);
        }
    }

    public final void p(Bundle bundle, f81 f81Var, g81 g81Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, bundle, f81Var, g81Var) == null) {
            String string = bundle.getString("clientId");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            q(string, g81Var);
        }
    }

    public final void q(String str, g81 g81Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, str, g81Var) == null) {
            String a2 = g81Var.a("Cookie");
            String str2 = "CLIENTID=" + str;
            if (a2 == null) {
                g81Var.d("Cookie", str2);
                return;
            }
            g81Var.d("Cookie", a2 + "; " + str2);
        }
    }

    public final void r(Bundle bundle, f81 f81Var, g81 g81Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048589, this, bundle, f81Var, g81Var) == null) {
            String string = bundle.getString("openBduss");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            s(string, g81Var);
        }
    }

    public final void s(String str, g81 g81Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, str, g81Var) == null) {
            String a2 = g81Var.a("Cookie");
            String str2 = "OPENBDUSS=" + str;
            if (a2 == null) {
                g81Var.d("Cookie", str2);
                return;
            }
            g81Var.d("Cookie", a2 + "; " + str2);
        }
    }

    public final void t(f81 f81Var, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048591, this, f81Var, bundle) == null) || bundle == null || f81Var == null) {
            return;
        }
        for (String str : bundle.keySet()) {
            f81Var.d(str, bundle.getString(str));
        }
        Iterator<Map.Entry<String, String>> it = f81Var.b().entrySet().iterator();
        while (it.hasNext()) {
            if (TextUtils.isEmpty(it.next().getValue())) {
                it.remove();
            }
        }
    }

    public void u(Bundle bundle, e81<Map<String, String>> e81Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, bundle, e81Var) == null) {
            g81 h = h();
            f81 d2 = d(bundle, h);
            this.a.a(o81.l(), h, d2, new c(this, e81Var));
        }
    }

    public void v(g81 g81Var, Bundle bundle, e81<Map<String, String>> e81Var, PayChannelEntity payChannelEntity, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048593, this, g81Var, bundle, e81Var, payChannelEntity, str) == null) {
            g81 i = i(g81Var);
            Set<String> keySet = bundle.keySet();
            f81 f81Var = new f81();
            for (String str2 : keySet) {
                if (bundle.get(str2) instanceof String) {
                    f81Var.d(str2, bundle.get(str2).toString());
                }
            }
            if (payChannelEntity == null) {
                return;
            }
            String payChannel = payChannelEntity.getPayChannel();
            if (!TextUtils.isEmpty(payChannel)) {
                f81Var.d(b, payChannel);
            }
            String installmentPeriod = payChannelEntity.getInstallmentPeriod();
            if (!TextUtils.isEmpty(installmentPeriod)) {
                f81Var.d(c, installmentPeriod);
            }
            n(bundle, f81Var, i);
            this.a.a(o81.j(), i, f81Var, new b(this, str, e81Var));
        }
    }

    public final void w(String str, int i, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{str, Integer.valueOf(i), str2, Integer.valueOf(i2)}) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("exceptionType", "" + i);
            hashMap.put("path", str2);
            hashMap.put(StatConstants.KEY_EXT_ERR_CODE, "" + i2);
            j91.c(str, hashMap);
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
            j91.c(str, hashMap);
        }
    }

    public final Map<String, String> y(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, jSONObject)) == null) {
            Map<String, String> c2 = x91.c();
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
