package d.a.q0.k;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f53877a;

    /* renamed from: b  reason: collision with root package name */
    public int f53878b;

    /* renamed from: c  reason: collision with root package name */
    public int f53879c;

    /* renamed from: d  reason: collision with root package name */
    public String f53880d;

    /* renamed from: e  reason: collision with root package name */
    public Drawable f53881e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f53882f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f53883g;

    /* renamed from: h  reason: collision with root package name */
    public int f53884h;

    /* renamed from: i  reason: collision with root package name */
    public int f53885i;
    public long j;
    public e k;
    public d.a.q0.k.r.b l;

    public o(int i2, int i3, int i4, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f53878b = -1;
        this.f53879c = -1;
        this.f53882f = true;
        this.f53883g = true;
        this.f53884h = 0;
        this.f53885i = 0;
        this.j = 0L;
        this.f53877a = i2;
        this.f53878b = i3;
        this.f53879c = i4;
        this.f53883g = z;
    }

    public static o k(o oVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, oVar)) == null) {
            if (oVar == null) {
                return null;
            }
            return new o(oVar.f53877a, oVar.f53878b, oVar.f53879c, oVar.f53883g);
        }
        return (o) invokeL.objValue;
    }

    public static o l(o oVar, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, null, oVar, z)) == null) {
            if (oVar == null) {
                return null;
            }
            return new o(oVar.f53877a, oVar.f53878b, oVar.f53879c, z);
        }
        return (o) invokeLZ.objValue;
    }

    public Drawable a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            Drawable drawable = this.f53881e;
            if (drawable != null) {
                return drawable;
            }
            if (this.f53879c <= 0) {
                return null;
            }
            return context.getResources().getDrawable(this.f53879c);
        }
        return (Drawable) invokeL.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f53884h : invokeV.intValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f53877a : invokeV.intValue;
    }

    public d.a.q0.k.r.b d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.l : (d.a.q0.k.r.b) invokeV.objValue;
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.j : invokeV.longValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f53885i : invokeV.intValue;
    }

    public e g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.k : (e) invokeV.objValue;
    }

    public String h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, context)) == null) {
            String str = this.f53880d;
            if (str != null) {
                return str;
            }
            if (this.f53878b <= 0) {
                return null;
            }
            return context.getResources().getString(this.f53878b);
        }
        return (String) invokeL.objValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f53883g : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f53882f : invokeV.booleanValue;
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.f53879c = i2;
        }
    }

    public void n(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048587, this, j) == null) {
            this.j = j;
        }
    }

    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.f53885i = i2;
        }
    }

    public void p(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, eVar) == null) {
            this.k = eVar;
        }
    }

    public void q(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.f53878b = i2;
        }
    }
}
