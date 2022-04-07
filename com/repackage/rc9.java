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
public class rc9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String b = "UnionIDHelper";
    public static boolean c;
    public static rc9 d;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* loaded from: classes7.dex */
    public class a implements zc9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qc9 a;

        public a(rc9 rc9Var, qc9 qc9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rc9Var, qc9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qc9Var;
        }

        @Override // com.repackage.zc9
        public void a(ad9 ad9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ad9Var) == null) {
                if (rc9.c) {
                    String str = rc9.b;
                    Log.d(str, "异步回调 结果:" + ad9Var);
                    String str2 = rc9.b;
                    StringBuilder sb = new StringBuilder();
                    sb.append("异步回调 (listener != null):");
                    sb.append(this.a != null);
                    Log.d(str2, sb.toString());
                }
                qc9 qc9Var = this.a;
                if (qc9Var != null) {
                    qc9Var.a(0, ad9Var == null ? null : new pc9(ad9Var.c(), ad9Var.isSupport(), ad9Var.getOAID(), ad9Var.getAAID(), ad9Var.getVAID(), ad9Var.getStatusCode()));
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755354999, "Lcom/repackage/rc9;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755354999, "Lcom/repackage/rc9;");
        }
    }

    public rc9(Context context) {
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

    public static rc9 c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (d == null) {
                synchronized (rc9.class) {
                    if (d == null) {
                        d = new rc9(context);
                        tc9.c(context);
                    }
                }
            }
            return d;
        }
        return (rc9) invokeL.objValue;
    }

    public void d(sc9 sc9Var, qc9 qc9Var, Looper looper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, sc9Var, qc9Var, looper) == null) {
            xc9.o().i(this.a, looper, new a(this, qc9Var));
        }
    }

    public void e(qc9 qc9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qc9Var) == null) {
            sc9 sc9Var = new sc9();
            sc9Var.b(1);
            sc9Var.a(false);
            d(sc9Var, qc9Var, Looper.getMainLooper());
        }
    }
}
