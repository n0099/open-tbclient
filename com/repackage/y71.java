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
public class y71 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String b = "payChannel";
    public static String c = "installmentPeriod";
    public static String d = "payType";
    public static volatile y71 e;
    public transient /* synthetic */ FieldHolder $fh;
    public v71 a;

    /* loaded from: classes7.dex */
    public class a extends q71<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q71 a;
        public final /* synthetic */ y71 b;

        public a(y71 y71Var, q71 q71Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y71Var, q71Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = y71Var;
            this.a = q71Var;
        }

        @Override // com.repackage.q71
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.b.w("7", 119501, "cashier/channelAllInfo", i);
                this.a.b(th, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.q71
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
                        q71 q71Var = this.a;
                        ServerDataException serverDataException = new ServerDataException("errmsg = " + optString);
                        q71Var.b(serverDataException, "errno is " + optInt2);
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
    public class b extends q71<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ q71 b;
        public final /* synthetic */ y71 c;

        public b(y71 y71Var, String str, q71 q71Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y71Var, str, q71Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = y71Var;
            this.a = str;
            this.b = q71Var;
        }

        @Override // com.repackage.q71
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.c.x("8", 119501, "cashier/launchpayment", i, this.a);
                this.b.b(th, m91.a().getResources().getString(R.string.obfuscated_res_0x7f0f040a));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.q71
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
                        q71 q71Var = this.b;
                        q71Var.b(new ServerDataException("msg = " + optString), optString);
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
    public class c extends q71<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q71 a;
        public final /* synthetic */ y71 b;

        public c(y71 y71Var, q71 q71Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y71Var, q71Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = y71Var;
            this.a = q71Var;
        }

        @Override // com.repackage.q71
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.b.w("8", 119501, "cashier/pay", i);
                this.a.b(th, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.q71
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
                        q71 q71Var = this.a;
                        q71Var.b(new ServerDataException("msg = " + optString), optString);
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
    public class d extends q71<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q71 a;
        public final /* synthetic */ y71 b;

        public d(y71 y71Var, q71 q71Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y71Var, q71Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = y71Var;
            this.a = q71Var;
        }

        @Override // com.repackage.q71
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.b.w(TbEnum.SystemMessage.EVENT_ID_GROUP_JOIN, 119501, "cashier/sdkAdaptH5QueryPay", i);
                this.a.b(th, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.q71
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
                        q71 q71Var = this.a;
                        ServerDataException serverDataException = new ServerDataException("msg = " + optString);
                        q71Var.b(serverDataException, "errno is " + optInt);
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
    public class e extends q71<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q71 a;

        public e(y71 y71Var, q71 q71Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y71Var, q71Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q71Var;
        }

        @Override // com.repackage.q71
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.a.b(th, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.q71
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
                    q71 q71Var = this.a;
                    ServerDataException serverDataException = new ServerDataException("msg=" + optString);
                    q71Var.b(serverDataException, "code=" + optInt);
                } catch (Throwable th) {
                    i91.d(th.getMessage());
                    this.a.b(new ServerDataException("服务异常，请稍后重试"), "服务异常，请稍后重试");
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f extends q71<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q71 a;

        public f(y71 y71Var, q71 q71Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y71Var, q71Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q71Var;
        }

        @Override // com.repackage.q71
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.a.b(th, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.q71
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
                    q71 q71Var = this.a;
                    ServerDataException serverDataException = new ServerDataException("msg=" + optString);
                    q71Var.b(serverDataException, "code=" + optInt);
                } catch (Throwable th) {
                    i91.d(th.getMessage());
                    this.a.b(new ServerDataException("服务异常，请稍后重试"), "服务异常，请稍后重试");
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g extends q71<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q71 a;

        public g(y71 y71Var, q71 q71Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y71Var, q71Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q71Var;
        }

        @Override // com.repackage.q71
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.a.b(th, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.q71
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
                    q71 q71Var = this.a;
                    ServerDataException serverDataException = new ServerDataException("msg=" + optString);
                    q71Var.b(serverDataException, "code=" + optInt);
                } catch (Throwable th) {
                    i91.d(th.getMessage());
                    this.a.b(new ServerDataException("服务异常，请稍后重试"), "服务异常，请稍后重试");
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755188994, "Lcom/repackage/y71;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755188994, "Lcom/repackage/y71;");
        }
    }

    public y71(v71 v71Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {v71Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = v71Var;
    }

    public static y71 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (e == null) {
                synchronized (y71.class) {
                    if (e == null) {
                        e = new y71(new w71());
                    }
                }
            }
            return e;
        }
        return (y71) invokeV.objValue;
    }

    public r71 d(Bundle bundle, s71 s71Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bundle, s71Var)) == null) {
            r71 r71Var = new r71();
            t(r71Var, bundle);
            r71Var.d(d, "android");
            n(bundle, r71Var, s71Var);
            return r71Var;
        }
        return (r71) invokeLL.objValue;
    }

    public void e(Bundle bundle, q71<JSONObject> q71Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle, q71Var) == null) {
            f(bundle, false, q71Var);
        }
    }

    public void f(Bundle bundle, boolean z, q71<JSONObject> q71Var) {
        String c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{bundle, Boolean.valueOf(z), q71Var}) == null) {
            s71 h = h();
            Set<String> keySet = bundle.keySet();
            r71 r71Var = new r71();
            for (String str : keySet) {
                if ((bundle.get(str) instanceof String) && (!z || !"bduss".equals(str))) {
                    r71Var.d(str, bundle.get(str).toString());
                }
            }
            n(bundle, r71Var, h);
            r(bundle, r71Var, h);
            p(bundle, r71Var, h);
            if (z) {
                c2 = a81.d();
            } else {
                c2 = a81.c();
            }
            v81.a("1.02", System.currentTimeMillis());
            this.a.a(c2, h, r71Var, new a(this, q71Var));
        }
    }

    public void g(String str, r71 r71Var, q71<JSONObject> q71Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, r71Var, q71Var) == null) {
            this.a.a(str, h(), r71Var, new g(this, q71Var));
        }
    }

    public final s71 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            s71 s71Var = new s71();
            z71.d(s71Var);
            return s71Var;
        }
        return (s71) invokeV.objValue;
    }

    public final s71 i(s71 s71Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, s71Var)) == null) {
            if (s71Var == null) {
                s71Var = new s71();
            }
            z71.d(s71Var);
            return s71Var;
        }
        return (s71) invokeL.objValue;
    }

    public void k(String str, String str2, String str3, q71<JSONObject> q71Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048582, this, str, str2, str3, q71Var) == null) {
            s71 h = h();
            o(str, h);
            r71 r71Var = new r71();
            r71Var.d("bduss", str);
            r71Var.d("payChannel", str2);
            r71Var.d("appKey", str3);
            this.a.a(a81.i(), h, r71Var, new e(this, q71Var));
        }
    }

    public void l(String str, String str2, String str3, q71<JSONObject> q71Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048583, this, str, str2, str3, q71Var) == null) {
            s71 h = h();
            o(str, h);
            r71 r71Var = new r71();
            r71Var.d("appKey", str3);
            r71Var.d("bduss", str);
            r71Var.d("payChannel", str2);
            r71Var.d("sign", p81.c("appKey=" + str3 + "&bduss=" + str + "&payChannel=" + str2 + "&lLoIsWxrSeJmHQD2TVQQ"));
            this.a.a(a81.k(), h, r71Var, new f(this, q71Var));
        }
    }

    public void m(Bundle bundle, q71<JSONObject> q71Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle, q71Var) == null) {
            s71 h = h();
            Set<String> keySet = bundle.keySet();
            r71 r71Var = new r71();
            for (String str : keySet) {
                if (bundle.get(str) instanceof String) {
                    r71Var.d(str, bundle.get(str).toString());
                }
            }
            this.a.a(a81.m(), h, r71Var, new d(this, q71Var));
        }
    }

    public final void n(Bundle bundle, r71 r71Var, s71 s71Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048585, this, bundle, r71Var, s71Var) == null) {
            String string = bundle.getString("bduss");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            o(string, s71Var);
        }
    }

    public final void o(String str, s71 s71Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, s71Var) == null) {
            String a2 = s71Var.a("Cookie");
            String str2 = "BDUSS=" + str;
            if (a2 == null) {
                s71Var.d("Cookie", str2);
                return;
            }
            s71Var.d("Cookie", a2 + "; " + str2);
        }
    }

    public final void p(Bundle bundle, r71 r71Var, s71 s71Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, bundle, r71Var, s71Var) == null) {
            String string = bundle.getString("clientId");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            q(string, s71Var);
        }
    }

    public final void q(String str, s71 s71Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, str, s71Var) == null) {
            String a2 = s71Var.a("Cookie");
            String str2 = "CLIENTID=" + str;
            if (a2 == null) {
                s71Var.d("Cookie", str2);
                return;
            }
            s71Var.d("Cookie", a2 + "; " + str2);
        }
    }

    public final void r(Bundle bundle, r71 r71Var, s71 s71Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048589, this, bundle, r71Var, s71Var) == null) {
            String string = bundle.getString("openBduss");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            s(string, s71Var);
        }
    }

    public final void s(String str, s71 s71Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, str, s71Var) == null) {
            String a2 = s71Var.a("Cookie");
            String str2 = "OPENBDUSS=" + str;
            if (a2 == null) {
                s71Var.d("Cookie", str2);
                return;
            }
            s71Var.d("Cookie", a2 + "; " + str2);
        }
    }

    public final void t(r71 r71Var, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048591, this, r71Var, bundle) == null) || bundle == null || r71Var == null) {
            return;
        }
        for (String str : bundle.keySet()) {
            r71Var.d(str, bundle.getString(str));
        }
        Iterator<Map.Entry<String, String>> it = r71Var.b().entrySet().iterator();
        while (it.hasNext()) {
            if (TextUtils.isEmpty(it.next().getValue())) {
                it.remove();
            }
        }
    }

    public void u(Bundle bundle, q71<Map<String, String>> q71Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, bundle, q71Var) == null) {
            s71 h = h();
            r71 d2 = d(bundle, h);
            this.a.a(a81.l(), h, d2, new c(this, q71Var));
        }
    }

    public void v(s71 s71Var, Bundle bundle, q71<Map<String, String>> q71Var, PayChannelEntity payChannelEntity, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048593, this, s71Var, bundle, q71Var, payChannelEntity, str) == null) {
            s71 i = i(s71Var);
            Set<String> keySet = bundle.keySet();
            r71 r71Var = new r71();
            for (String str2 : keySet) {
                if (bundle.get(str2) instanceof String) {
                    r71Var.d(str2, bundle.get(str2).toString());
                }
            }
            if (payChannelEntity == null) {
                return;
            }
            String payChannel = payChannelEntity.getPayChannel();
            if (!TextUtils.isEmpty(payChannel)) {
                r71Var.d(b, payChannel);
            }
            String installmentPeriod = payChannelEntity.getInstallmentPeriod();
            if (!TextUtils.isEmpty(installmentPeriod)) {
                r71Var.d(c, installmentPeriod);
            }
            n(bundle, r71Var, i);
            this.a.a(a81.j(), i, r71Var, new b(this, str, q71Var));
        }
    }

    public final void w(String str, int i, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{str, Integer.valueOf(i), str2, Integer.valueOf(i2)}) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("exceptionType", "" + i);
            hashMap.put("path", str2);
            hashMap.put(StatConstants.KEY_EXT_ERR_CODE, "" + i2);
            v81.c(str, hashMap);
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
            v81.c(str, hashMap);
        }
    }

    public final Map<String, String> y(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, jSONObject)) == null) {
            Map<String, String> c2 = j91.c();
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
