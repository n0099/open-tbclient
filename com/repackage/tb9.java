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
public class tb9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String b = "UnionIDHelper";
    public static boolean c;
    public static tb9 d;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* loaded from: classes7.dex */
    public class a implements bc9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sb9 a;

        public a(tb9 tb9Var, sb9 sb9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tb9Var, sb9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sb9Var;
        }

        @Override // com.repackage.bc9
        public void a(cc9 cc9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cc9Var) == null) {
                if (tb9.c) {
                    String str = tb9.b;
                    Log.d(str, "异步回调 结果:" + cc9Var);
                    String str2 = tb9.b;
                    StringBuilder sb = new StringBuilder();
                    sb.append("异步回调 (listener != null):");
                    sb.append(this.a != null);
                    Log.d(str2, sb.toString());
                }
                sb9 sb9Var = this.a;
                if (sb9Var != null) {
                    sb9Var.a(0, cc9Var == null ? null : new rb9(cc9Var.c(), cc9Var.isSupport(), cc9Var.getOAID(), cc9Var.getAAID(), cc9Var.getVAID(), cc9Var.getStatusCode()));
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755296378, "Lcom/repackage/tb9;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755296378, "Lcom/repackage/tb9;");
        }
    }

    public tb9(Context context) {
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

    public static tb9 c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (d == null) {
                synchronized (tb9.class) {
                    if (d == null) {
                        d = new tb9(context);
                        vb9.c(context);
                    }
                }
            }
            return d;
        }
        return (tb9) invokeL.objValue;
    }

    public void d(ub9 ub9Var, sb9 sb9Var, Looper looper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, ub9Var, sb9Var, looper) == null) {
            zb9.o().i(this.a, looper, new a(this, sb9Var));
        }
    }

    public void e(sb9 sb9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sb9Var) == null) {
            ub9 ub9Var = new ub9();
            ub9Var.b(1);
            ub9Var.a(false);
            d(ub9Var, sb9Var, Looper.getMainLooper());
        }
    }
}
