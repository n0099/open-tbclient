package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.pl4;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class ol4 {
    public static /* synthetic */ Interceptable $ic;
    public static pl4 a;
    public static ol4 b;
    public static boolean c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755435878, "Lcom/repackage/ol4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755435878, "Lcom/repackage/ol4;");
                return;
            }
        }
        new ArrayList(5);
    }

    public ol4() {
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

    public static ol4 a(BaseFragmentActivity baseFragmentActivity) {
        InterceptResult invokeL;
        pl4 pl4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, baseFragmentActivity)) == null) {
            if (b == null) {
                synchronized (ol4.class) {
                    if (b == null) {
                        b = new ol4();
                        a = pl4.a(baseFragmentActivity);
                    }
                }
            } else {
                pl4 pl4Var2 = a;
                if (pl4Var2 != null) {
                    pl4Var2.j(baseFragmentActivity.getPageContext());
                }
            }
            if (c && (pl4Var = a) != null) {
                pl4Var.d();
                a.c();
                c = false;
            }
            return b;
        }
        return (ol4) invokeL.objValue;
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            try {
                if (a != null) {
                    if (b != null) {
                        b.j();
                    }
                    a.e();
                    a.i();
                    a = null;
                }
                if (b != null) {
                    b = null;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || a == null) {
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            b();
            pl4 pl4Var = a;
            if (pl4Var != null) {
                pl4Var.d();
                c = false;
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            b();
            pl4 pl4Var = a;
            if (pl4Var != null) {
                pl4Var.c();
                c = false;
            }
        }
    }

    public void e(boolean z, boolean z2, boolean z3, pl4.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), aVar}) == null) {
            b();
            if (z) {
                c();
            }
            if (z2) {
                d();
            }
            l(z3);
            k(aVar);
        }
    }

    public void f(pl4.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            b();
            pl4 pl4Var = a;
            if (pl4Var != null) {
                if (pl4Var.b()) {
                    a.k(aVar);
                }
                a.f();
            }
        }
    }

    public void g(int i, pl4.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i, aVar) == null) {
            b();
            pl4 pl4Var = a;
            if (pl4Var != null) {
                if (pl4Var.b()) {
                    a.k(aVar);
                }
                a.g(i);
            }
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            b();
            pl4 pl4Var = a;
            if (pl4Var != null) {
                pl4Var.h();
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            b();
            i();
            m();
        }
    }

    public void k(pl4.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            b();
            pl4 pl4Var = a;
            if (pl4Var != null) {
                pl4Var.k(aVar);
            }
        }
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            b();
            pl4 pl4Var = a;
            if (pl4Var != null) {
                pl4Var.l(z);
            }
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            b();
            pl4 pl4Var = a;
            if (pl4Var != null) {
                pl4Var.m();
                c = true;
            }
        }
    }
}
