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
public class u99 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String b = "UnionIDHelper";
    public static boolean c;
    public static u99 d;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* loaded from: classes7.dex */
    public class a implements ca9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t99 a;

        public a(u99 u99Var, t99 t99Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u99Var, t99Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t99Var;
        }

        @Override // com.repackage.ca9
        public void a(da9 da9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, da9Var) == null) {
                if (u99.c) {
                    String str = u99.b;
                    Log.d(str, "异步回调 结果:" + da9Var);
                    String str2 = u99.b;
                    StringBuilder sb = new StringBuilder();
                    sb.append("异步回调 (listener != null):");
                    sb.append(this.a != null);
                    Log.d(str2, sb.toString());
                }
                t99 t99Var = this.a;
                if (t99Var != null) {
                    t99Var.a(0, da9Var == null ? null : new s99(da9Var.c(), da9Var.isSupport(), da9Var.getOAID(), da9Var.getAAID(), da9Var.getVAID(), da9Var.getStatusCode()));
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755305988, "Lcom/repackage/u99;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755305988, "Lcom/repackage/u99;");
        }
    }

    public u99(Context context) {
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

    public static u99 c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (d == null) {
                synchronized (u99.class) {
                    if (d == null) {
                        d = new u99(context);
                        w99.c(context);
                    }
                }
            }
            return d;
        }
        return (u99) invokeL.objValue;
    }

    public void d(v99 v99Var, t99 t99Var, Looper looper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, v99Var, t99Var, looper) == null) {
            aa9.o().i(this.a, looper, new a(this, t99Var));
        }
    }

    public void e(t99 t99Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t99Var) == null) {
            v99 v99Var = new v99();
            v99Var.b(1);
            v99Var.a(false);
            d(v99Var, t99Var, Looper.getMainLooper());
        }
    }
}
