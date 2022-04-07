package com.repackage;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Locale;
/* loaded from: classes5.dex */
public final class cc3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public long b;
    public long c;
    public String d;
    public String e;
    public final StringBuilder f;
    public boolean g;

    public cc3() {
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
        this.a = 0L;
        this.b = 0L;
        this.c = 2L;
        this.d = "";
        this.e = "";
        this.f = new StringBuilder();
        this.g = false;
    }

    public long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (o() * 10000000) + (j() * 10000) + (h() * 1) : invokeV.longValue;
    }

    public cc3 b(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
            p(j / 10000000);
            long j2 = j % 10000000;
            k(j2 / 10000);
            i((j2 % 10000) / 1);
            return this;
        }
        return (cc3) invokeJ.objValue;
    }

    public cc3 c(c94 c94Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, c94Var)) == null) {
            if (c94Var != null) {
                i(c94Var.a);
                d(c94Var.b);
                q(c94Var.e);
                if (!TextUtils.isEmpty(c94Var.d)) {
                    f(c94Var.d);
                }
            }
            return this;
        }
        return (cc3) invokeL.objValue;
    }

    public cc3 d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (str == null) {
                str = "";
            }
            this.d = str;
            return this;
        }
        return (cc3) invokeL.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.d : (String) invokeV.objValue;
    }

    public cc3 f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            StringBuilder sb = this.f;
            sb.append(str);
            sb.append("\n");
            return this;
        }
        return (cc3) invokeL.objValue;
    }

    public StringBuilder g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f : (StringBuilder) invokeV.objValue;
    }

    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.b : invokeV.longValue;
    }

    public cc3 i(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j)) == null) {
            this.b = m(j, 9999L, "error");
            return this;
        }
        return (cc3) invokeJ.objValue;
    }

    public long j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.a : invokeV.longValue;
    }

    public cc3 k(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048586, this, j)) == null) {
            this.a = m(j, 999L, "feature");
            return this;
        }
        return (cc3) invokeJ.objValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.g : invokeV.booleanValue;
    }

    public final long m(long j, long j2, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), str})) == null) {
            boolean z = j < 0 || j > j2;
            if (z) {
                f("illegalFallback " + str + "::" + j);
            }
            return z ? j2 : j;
        }
        return invokeCommon.longValue;
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.g = true;
        }
    }

    public long o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.c : invokeV.longValue;
    }

    public cc3 p(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048591, this, j)) == null) {
            this.c = m(j, 9L, com.tencent.connect.common.Constants.PARAM_PLATFORM);
            return this;
        }
        return (cc3) invokeJ.objValue;
    }

    public cc3 q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            if (str == null) {
                str = "";
            }
            this.e = str;
            return this;
        }
        return (cc3) invokeL.objValue;
    }

    public String r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.e : (String) invokeV.objValue;
    }

    public String s(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format(Locale.getDefault(), "%s :: code(%08d) desc(%s) \n", super.toString(), Long.valueOf(a()), Long.valueOf(o()), Long.valueOf(j()), Long.valueOf(h()), e()));
            if (i >= -200) {
                sb.append(String.format(Locale.getDefault(), "  p(%01d) f(%03d) e(%04d) \n", Long.valueOf(o()), Long.valueOf(j()), Long.valueOf(h())));
            }
            if (i >= -100) {
                sb.append(String.format(Locale.getDefault(), "  details(%s) \n", g()));
            }
            return sb.toString();
        }
        return (String) invokeI.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? s(-100) : (String) invokeV.objValue;
    }
}
