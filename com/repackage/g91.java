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
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.EventAlias;
import java.net.URLDecoder;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class g91 {
    public static /* synthetic */ Interceptable $ic;
    public static g91 c;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public b b;

    /* loaded from: classes6.dex */
    public class a extends e81<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ia1 a;

        public a(g91 g91Var, ia1 ia1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g91Var, ia1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ia1Var;
        }

        @Override // com.repackage.e81
        public void b(Throwable th, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, th, str) == null) {
                this.a.onResult(119501, "");
                th.printStackTrace();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.e81
        /* renamed from: d */
        public void c(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
                int optInt = jSONObject.optInt("status", -1);
                int optInt2 = jSONObject.optInt("signStatus", -1);
                int optInt3 = jSONObject.optInt("payStatus", -1);
                if (2 != optInt && 2 != optInt3) {
                    this.a.onResult(optInt2, "");
                } else {
                    this.a.onResult(0, EventAlias.PayEventAlias.PAY_SUCCESS);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void onResult(int i, String str);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755723310, "Lcom/repackage/g91;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755723310, "Lcom/repackage/g91;");
                return;
            }
        }
        c = new g91();
    }

    public g91() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static g91 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? c : (g91) invokeV.objValue;
    }

    public void a(ia1 ia1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ia1Var) == null) {
            String[] split = this.a.split("&");
            f81 f81Var = new f81();
            for (String str : split) {
                String[] split2 = str.split("=");
                if (split2 != null && split2.length == 2) {
                    if (TextUtils.equals(split2[0], "timestamp")) {
                        f81Var.d(split2[0], URLDecoder.decode(split2[1]));
                    } else {
                        f81Var.d(split2[0], split2[1]);
                    }
                }
            }
            m81.j().g(o81.e(), f81Var, new a(this, ia1Var));
        }
    }

    public b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.b : (b) invokeV.objValue;
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.a = str;
        }
    }

    public void e(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.b = bVar;
        }
    }
}
