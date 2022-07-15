package com.repackage;

import android.content.Context;
import android.util.Log;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.retry.HttpRetryStatistic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class bv3 extends ez1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean A;
    public transient /* synthetic */ FieldHolder $fh;
    public View z;

    /* loaded from: classes5.dex */
    public class a extends vy1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(bv3 bv3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bv3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.vy1
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                super.a(str);
                if (bv3.A) {
                    Log.e("SwanGameConsoleManager", "onPageFinished");
                }
                cv3.a();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755813582, "Lcom/repackage/bv3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755813582, "Lcom/repackage/bv3;");
                return;
            }
        }
        A = rg1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bv3(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.ez1, com.repackage.mm1
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            cv3.h(false);
            this.z = null;
            super.F();
        }
    }

    @Override // com.repackage.ez1, com.repackage.mm1
    public void H(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            this.z = view2;
        }
    }

    @Override // com.repackage.ez1, com.repackage.mm1
    public void R(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (t().getVisibility() == (z ? 0 : 8)) {
                return;
            }
            if (A) {
                Log.i("SwanGameConsoleManager", "setConsoleVisible:" + z);
            }
            if (z) {
                ul2.U().m("console", wu3.u(true));
            }
            if (this.z != null) {
                this.z.setVisibility(z ? 4 : 0);
            }
            super.R(z);
        }
    }

    @Override // com.repackage.ez1, com.baidu.swan.apps.core.SwanAppWebViewManager, com.repackage.pm1
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "console" : (String) invokeV.objValue;
    }

    @Override // com.repackage.ez1, com.repackage.mm1
    public void i0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            cv3.g(str, str2);
        }
    }

    @Override // com.repackage.ez1
    public void i1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            t().setVisibility(8);
            t().setBackgroundColor(0);
            cv3.c();
            k1();
            String i = xu3.m().i();
            if (A) {
                Log.d("SwanGameConsoleManager", HttpRetryStatistic.RETRY_URL + i);
            }
            loadUrl(i);
        }
    }

    public final void k1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            c(new a(this));
        }
    }
}
