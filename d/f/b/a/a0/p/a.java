package d.f.b.a.a0.p;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.f.b.a.a0.p.b;
import d.f.b.a.i0.v;
/* loaded from: classes8.dex */
public final class a implements b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final long f69740a;

    /* renamed from: b  reason: collision with root package name */
    public final int f69741b;

    /* renamed from: c  reason: collision with root package name */
    public final long f69742c;

    public a(long j, int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), Integer.valueOf(i2), Long.valueOf(j2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f69740a = j;
        this.f69741b = i2;
        this.f69742c = j2 == -1 ? -9223372036854775807L : g(j2);
    }

    @Override // d.f.b.a.a0.l
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f69742c != -9223372036854775807L : invokeV.booleanValue;
    }

    @Override // d.f.b.a.a0.l
    public long c(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
            long j2 = this.f69742c;
            if (j2 == -9223372036854775807L) {
                return 0L;
            }
            return this.f69740a + ((v.l(j, 0L, j2) * this.f69741b) / 8000000);
        }
        return invokeJ.longValue;
    }

    @Override // d.f.b.a.a0.p.b.a
    public long g(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) ? ((Math.max(0L, j - this.f69740a) * 1000000) * 8) / this.f69741b : invokeJ.longValue;
    }

    @Override // d.f.b.a.a0.l
    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f69742c : invokeV.longValue;
    }
}
