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
/* loaded from: classes8.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final long f70845a;

    /* renamed from: b  reason: collision with root package name */
    public final long f70846b;

    /* renamed from: c  reason: collision with root package name */
    public final long f70847c;

    /* renamed from: d  reason: collision with root package name */
    public final long f70848d;

    /* renamed from: e  reason: collision with root package name */
    public final long f70849e;

    /* renamed from: f  reason: collision with root package name */
    public final long f70850f;

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
        this.f70845a = j;
        this.f70846b = j2;
        this.f70847c = j3;
        this.f70848d = j4;
        this.f70849e = j5;
        this.f70850f = j6;
    }

    public long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f70850f : invokeV.longValue;
    }

    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f70845a : invokeV.longValue;
    }

    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f70848d : invokeV.longValue;
    }

    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f70847c : invokeV.longValue;
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f70846b : invokeV.longValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (obj instanceof d) {
                d dVar = (d) obj;
                return this.f70845a == dVar.f70845a && this.f70846b == dVar.f70846b && this.f70847c == dVar.f70847c && this.f70848d == dVar.f70848d && this.f70849e == dVar.f70849e && this.f70850f == dVar.f70850f;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f70849e : invokeV.longValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? k.b(Long.valueOf(this.f70845a), Long.valueOf(this.f70846b), Long.valueOf(this.f70847c), Long.valueOf(this.f70848d), Long.valueOf(this.f70849e), Long.valueOf(this.f70850f)) : invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            j.b c2 = d.f.d.a.j.c(this);
            c2.c("hitCount", this.f70845a);
            c2.c("missCount", this.f70846b);
            c2.c("loadSuccessCount", this.f70847c);
            c2.c("loadExceptionCount", this.f70848d);
            c2.c("totalLoadTime", this.f70849e);
            c2.c("evictionCount", this.f70850f);
            return c2.toString();
        }
        return (String) invokeV.objValue;
    }
}
