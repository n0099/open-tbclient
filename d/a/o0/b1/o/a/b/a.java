package d.a.o0.b1.o.a.b;

import android.content.Context;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.b1.o.a.d.e;
import d.a.o0.b1.o.a.f.b;
import java.util.Calendar;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.o0.b1.o.a.c.a f51765a;

    public a(Context context, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        d.a.o0.b1.o.a.c.a aVar = new d.a.o0.b1.o.a.c.a(2);
        this.f51765a = aVar;
        aVar.A = context;
        aVar.f51766a = eVar;
    }

    public b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new b(this.f51765a) : (b) invokeV.objValue;
    }

    public a b(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            this.f51765a.T = z;
            return this;
        }
        return (a) invokeZ.objValue;
    }

    public a c(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
            this.f51765a.R = z;
            return this;
        }
        return (a) invokeZ.objValue;
    }

    public a d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            this.f51765a.P = i2;
            return this;
        }
        return (a) invokeI.objValue;
    }

    public a e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            this.f51765a.H = i2;
            return this;
        }
        return (a) invokeI.objValue;
    }

    public a f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            this.f51765a.L = i2;
            return this;
        }
        return (a) invokeI.objValue;
    }

    public a g(Calendar calendar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, calendar)) == null) {
            this.f51765a.f51770e = calendar;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a h(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, viewGroup)) == null) {
            this.f51765a.y = viewGroup;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            this.f51765a.O = i2;
            return this;
        }
        return (a) invokeI.objValue;
    }

    public a j(String str, String str2, String str3, String str4, String str5, String str6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{str, str2, str3, str4, str5, str6})) == null) {
            d.a.o0.b1.o.a.c.a aVar = this.f51765a;
            aVar.l = str;
            aVar.m = str2;
            aVar.n = str3;
            aVar.o = str4;
            aVar.p = str5;
            aVar.q = str6;
            return this;
        }
        return (a) invokeCommon.objValue;
    }

    public a k(int i2, d.a.o0.b1.o.a.d.a aVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048586, this, i2, aVar)) == null) {
            d.a.o0.b1.o.a.c.a aVar2 = this.f51765a;
            aVar2.x = i2;
            aVar2.f51768c = aVar;
            return this;
        }
        return (a) invokeIL.objValue;
    }

    public a l(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048587, this, f2)) == null) {
            this.f51765a.Q = f2;
            return this;
        }
        return (a) invokeF.objValue;
    }

    public a m(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
            this.f51765a.N = i2;
            return this;
        }
        return (a) invokeI.objValue;
    }

    public a n(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
            this.f51765a.M = i2;
            return this;
        }
        return (a) invokeI.objValue;
    }

    public a o(int i2, int i3, int i4, int i5, int i6, int i7) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)})) == null) {
            d.a.o0.b1.o.a.c.a aVar = this.f51765a;
            aVar.r = i2;
            aVar.s = i3;
            aVar.t = i4;
            aVar.u = i5;
            aVar.v = i6;
            aVar.w = i7;
            return this;
        }
        return (a) invokeCommon.objValue;
    }

    public a p(boolean[] zArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, zArr)) == null) {
            this.f51765a.f51769d = zArr;
            return this;
        }
        return (a) invokeL.objValue;
    }
}
