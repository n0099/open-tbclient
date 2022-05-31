package com.repackage;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class mh2 {
    public static /* synthetic */ Interceptable $ic;
    public static final qh2 a;
    public static volatile qh2 b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements ae3<HybridUbcFlow> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ae3
        /* renamed from: a */
        public void onCallback(HybridUbcFlow hybridUbcFlow) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, hybridUbcFlow) == null) {
                mh2.b().b(TextUtils.equals(hybridUbcFlow.m().optString("type"), "3") || hybridUbcFlow.p("na_first_meaningful_paint"), hybridUbcFlow);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755499366, "Lcom/repackage/mh2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755499366, "Lcom/repackage/mh2;");
                return;
            }
        }
        rh2 rh2Var = new rh2();
        a = rh2Var;
        b = rh2Var;
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            b().c();
        }
    }

    @NonNull
    public static qh2 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b : (qh2) invokeV.objValue;
    }

    public static void c(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65539, null, i) == null) || i == 3) {
            return;
        }
        b().c();
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) {
            if (TextUtils.equals(str, "3")) {
                f(new ph2(str));
            } else {
                f(new oh2(str));
            }
        }
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            f(a);
        }
    }

    public static void f(@NonNull qh2 qh2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, qh2Var) == null) {
            b = qh2Var;
        }
    }
}
