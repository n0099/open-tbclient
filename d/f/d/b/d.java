package d.f.d.b;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.f.d.a.j;
import d.f.d.a.k;
import d.f.d.a.n;
/* loaded from: classes10.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final long f73742a;

    /* renamed from: b  reason: collision with root package name */
    public final long f73743b;

    /* renamed from: c  reason: collision with root package name */
    public final long f73744c;

    /* renamed from: d  reason: collision with root package name */
    public final long f73745d;

    /* renamed from: e  reason: collision with root package name */
    public final long f73746e;

    /* renamed from: f  reason: collision with root package name */
    public final long f73747f;

    public d(long j, long j2, long j3, long j4, long j5, long j6) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        n.d(j >= 0);
        n.d(j2 >= 0);
        n.d(j3 >= 0);
        n.d(j4 >= 0);
        n.d(j5 >= 0);
        n.d(j6 >= 0);
        this.f73742a = j;
        this.f73743b = j2;
        this.f73744c = j3;
        this.f73745d = j4;
        this.f73746e = j5;
        this.f73747f = j6;
    }

    public long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f73747f : invokeV.longValue;
    }

    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f73742a : invokeV.longValue;
    }

    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f73745d : invokeV.longValue;
    }

    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f73744c : invokeV.longValue;
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f73743b : invokeV.longValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (obj instanceof d) {
                d dVar = (d) obj;
                return this.f73742a == dVar.f73742a && this.f73743b == dVar.f73743b && this.f73744c == dVar.f73744c && this.f73745d == dVar.f73745d && this.f73746e == dVar.f73746e && this.f73747f == dVar.f73747f;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f73746e : invokeV.longValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? k.b(Long.valueOf(this.f73742a), Long.valueOf(this.f73743b), Long.valueOf(this.f73744c), Long.valueOf(this.f73745d), Long.valueOf(this.f73746e), Long.valueOf(this.f73747f)) : invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            j.b c2 = d.f.d.a.j.c(this);
            c2.c("hitCount", this.f73742a);
            c2.c("missCount", this.f73743b);
            c2.c("loadSuccessCount", this.f73744c);
            c2.c("loadExceptionCount", this.f73745d);
            c2.c("totalLoadTime", this.f73746e);
            c2.c("evictionCount", this.f73747f);
            return c2.toString();
        }
        return (String) invokeV.objValue;
    }
}
