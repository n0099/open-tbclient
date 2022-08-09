package com.repackage;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class pc9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String b = "UnionIDHelper";
    public static boolean c;
    public static pc9 d;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* loaded from: classes7.dex */
    public class a implements xc9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oc9 a;

        public a(pc9 pc9Var, oc9 oc9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pc9Var, oc9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oc9Var;
        }

        @Override // com.repackage.xc9
        public void a(yc9 yc9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, yc9Var) == null) {
                if (pc9.c) {
                    String str = pc9.b;
                    Log.d(str, "异步回调 结果:" + yc9Var);
                    String str2 = pc9.b;
                    StringBuilder sb = new StringBuilder();
                    sb.append("异步回调 (listener != null):");
                    sb.append(this.a != null);
                    Log.d(str2, sb.toString());
                }
                oc9 oc9Var = this.a;
                if (oc9Var != null) {
                    oc9Var.a(0, yc9Var == null ? null : new nc9(yc9Var.c(), yc9Var.isSupport(), yc9Var.getOAID(), yc9Var.getAAID(), yc9Var.getVAID(), yc9Var.getStatusCode()));
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755414581, "Lcom/repackage/pc9;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755414581, "Lcom/repackage/pc9;");
        }
    }

    public pc9(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = context.getApplicationContext();
    }

    public static pc9 c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (d == null) {
                synchronized (pc9.class) {
                    if (d == null) {
                        d = new pc9(context);
                        rc9.c(context);
                    }
                }
            }
            return d;
        }
        return (pc9) invokeL.objValue;
    }

    public nc9 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            yc9 u = vc9.p().u(this.a);
            if (c) {
                String str = b;
                Log.d(str, "同步 结果:" + u);
            }
            if (u == null) {
                return null;
            }
            return new nc9(u.c(), u.isSupport(), u.getOAID(), u.getAAID(), u.getVAID(), u.getStatusCode());
        }
        return (nc9) invokeV.objValue;
    }

    public void e(qc9 qc9Var, oc9 oc9Var, Looper looper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qc9Var, oc9Var, looper) == null) {
            vc9.p().j(this.a, looper, new a(this, oc9Var));
        }
    }

    public void f(oc9 oc9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, oc9Var) == null) {
            qc9 qc9Var = new qc9();
            qc9Var.b(1);
            qc9Var.a(false);
            e(qc9Var, oc9Var, Looper.getMainLooper());
        }
    }
}
