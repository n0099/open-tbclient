package com.repackage;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URLDecoder;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class u81 {
    public static /* synthetic */ Interceptable $ic;
    public static long c;
    public static u81 d;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public boolean b;

    /* loaded from: classes7.dex */
    public class a extends t71<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x91 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ u81 c;

        public a(u81 u81Var, x91 x91Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u81Var, x91Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = u81Var;
            this.a = x91Var;
            this.b = str;
        }

        @Override // com.repackage.t71
        public void b(Throwable th, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, th, str) == null) || this.c.b) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (x71.b(p91.a()) && currentTimeMillis - u81.c <= 3000) {
                if (this.c.a) {
                    this.a.onResult(1, "");
                }
                this.c.i(this.b, this.a);
            } else {
                this.a.onResult(3, "支付失败，请重试");
            }
            this.c.a = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t71
        /* renamed from: d */
        public void c(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) || this.c.b) {
                return;
            }
            int optInt = jSONObject.optInt("status", -1);
            int optInt2 = jSONObject.optInt("payStatus", -1);
            if (optInt != 1 || optInt2 != 0) {
                if (optInt == 2 || (optInt == 1 && optInt2 == 2)) {
                    this.a.onResult(0, "小额免密支付成功");
                } else if (optInt != 1 || optInt2 != 3) {
                    if (System.currentTimeMillis() - u81.c <= 3000) {
                        if (this.c.a) {
                            this.a.onResult(1, "");
                        }
                        this.c.i(this.b, this.a);
                    } else {
                        this.a.onResult(6, "支付结果查询失败，请重试");
                    }
                } else {
                    this.a.onResult(3, "支付失败，请重试");
                }
                this.c.a = false;
                return;
            }
            this.a.onResult(3, "支付失败，请重试");
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755307197, "Lcom/repackage/u81;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755307197, "Lcom/repackage/u81;");
        }
    }

    public u81() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = true;
        this.b = false;
    }

    public static u81 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (d == null) {
                synchronized (u81.class) {
                    if (d == null) {
                        d = new u81();
                    }
                }
            }
            return d;
        }
        return (u81) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b = true;
        }
    }

    public void g(String str, x91 x91Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, x91Var) == null) {
            this.b = false;
            this.a = true;
            c = System.currentTimeMillis();
            i(str, x91Var);
        }
    }

    public final void i(String str, x91 x91Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, x91Var) == null) {
            String[] split = str.split("&");
            u71 u71Var = new u71();
            for (String str2 : split) {
                String[] split2 = str2.split("=");
                if (split2.length == 2) {
                    if (TextUtils.equals(split2[0], "timestamp")) {
                        u71Var.d(split2[0], URLDecoder.decode(split2[1]));
                    } else {
                        u71Var.d(split2[0], split2[1]);
                    }
                }
            }
            u71Var.d("terminalData", "{\"queryOrderType\":\"AGREEMENT\",\"payChannel\":\"BAIDU-ALIPAY-WISE\"}");
            b81.j().g(d81.e(), u71Var, new a(this, x91Var, str));
        }
    }
}
