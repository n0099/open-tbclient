package d.a.q0.n.i.m;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class c extends g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public String f54028d;

    /* renamed from: e  reason: collision with root package name */
    public long f54029e;

    /* renamed from: f  reason: collision with root package name */
    public String f54030f;

    /* renamed from: g  reason: collision with root package name */
    public long f54031g;

    /* renamed from: h  reason: collision with root package name */
    public String f54032h;

    /* renamed from: i  reason: collision with root package name */
    public String f54033i;
    public long j;
    public long k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(String str, int i2) {
        super(i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f54029e = -1L;
        this.f54031g = -1L;
        this.j = -1L;
        this.k = 0L;
        this.f54028d = str;
    }

    public long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f54031g : invokeV.longValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f54028d : (String) invokeV.objValue;
    }

    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.j : invokeV.longValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f54032h : (String) invokeV.objValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f54030f : (String) invokeV.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f54033i : (String) invokeV.objValue;
    }

    public long l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f54029e : invokeV.longValue;
    }

    public long m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.k : invokeV.longValue;
    }

    public c n(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j)) == null) {
            this.f54031g = j;
            return this;
        }
        return (c) invokeJ.objValue;
    }

    public c o(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048585, this, j)) == null) {
            this.j = j;
            return this;
        }
        return (c) invokeJ.objValue;
    }

    public c p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            this.f54032h = str;
            return this;
        }
        return (c) invokeL.objValue;
    }

    public c q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            this.f54030f = str;
            return this;
        }
        return (c) invokeL.objValue;
    }

    public c r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            this.f54033i = str;
            return this;
        }
        return (c) invokeL.objValue;
    }

    public c s(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048589, this, j)) == null) {
            this.f54029e = j;
            return this;
        }
        return (c) invokeJ.objValue;
    }

    public void t(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048590, this, j) == null) {
            this.k = j;
        }
    }
}
