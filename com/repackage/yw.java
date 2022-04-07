package com.repackage;

import android.app.Activity;
import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class yw {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CharSequence a;
    public int b;
    public CharSequence c;
    public int d;
    public int e;
    public a f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public wu m;

    /* loaded from: classes7.dex */
    public interface a {
        void a();
    }

    public yw() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = 2;
        this.b = 14;
        this.d = 14;
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            ax.e();
            cx.f();
        }
    }

    public static int m(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) ? av.a() : invokeL.intValue;
    }

    public yw a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? this : (yw) invokeI.objValue;
    }

    public yw b(wu wuVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wuVar)) == null) {
            this.m = wuVar;
            return this;
        }
        return (yw) invokeL.objValue;
    }

    public yw c(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar)) == null) {
            this.f = aVar;
            return this;
        }
        return (yw) invokeL.objValue;
    }

    public yw d(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, charSequence)) == null) {
            this.a = charSequence;
            return this;
        }
        return (yw) invokeL.objValue;
    }

    public yw e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            this.g = str;
            return this;
        }
        return (yw) invokeL.objValue;
    }

    public void g(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, context) == null) && l()) {
            f();
            ax.g(context, this.a, this.e, this.g, this.l, this.h, this.m);
        }
    }

    public yw h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            if (i >= 1 && i <= 10) {
                this.e = i;
            } else {
                this.e = 2;
            }
            return this;
        }
        return (yw) invokeI.objValue;
    }

    public yw i(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, charSequence)) == null) {
            this.c = charSequence;
            return this;
        }
        return (yw) invokeL.objValue;
    }

    public yw j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            this.h = str;
            return this;
        }
        return (yw) invokeL.objValue;
    }

    public void k(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, context) == null) && l() && context != null) {
            f();
            if (context instanceof Activity) {
                cx.g((Activity) context, this.a, this.b, this.c, this.d, this.e, this.g, this.l, this.h, this.i, this.j, this.k, this.f, this.m);
            } else {
                ax.f(context, this.a, this.b, this.l, this.c, this.d, this.e, this.g, this.h, this.i, this.j, this.k, this.f, this.m);
            }
        }
    }

    public final boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.a != null : invokeV.booleanValue;
    }

    public yw n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            this.i = str;
            return this;
        }
        return (yw) invokeL.objValue;
    }

    public yw o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            this.j = str;
            return this;
        }
        return (yw) invokeL.objValue;
    }

    public yw p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            this.k = str;
            return this;
        }
        return (yw) invokeL.objValue;
    }

    public yw q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            this.l = str;
            return this;
        }
        return (yw) invokeL.objValue;
    }
}
