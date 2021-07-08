package d.f.b.a.e0.p;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.f.b.a.i0.v;
import java.util.Collections;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public final class f implements d.f.b.a.e0.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final b f70260e;

    /* renamed from: f  reason: collision with root package name */
    public final long[] f70261f;

    /* renamed from: g  reason: collision with root package name */
    public final Map<String, e> f70262g;

    /* renamed from: h  reason: collision with root package name */
    public final Map<String, c> f70263h;

    public f(b bVar, Map<String, e> map, Map<String, c> map2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, map, map2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f70260e = bVar;
        this.f70263h = map2;
        this.f70262g = map != null ? Collections.unmodifiableMap(map) : Collections.emptyMap();
        this.f70261f = bVar.j();
    }

    @Override // d.f.b.a.e0.e
    public long a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? this.f70261f[i2] : invokeI.longValue;
    }

    @Override // d.f.b.a.e0.e
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f70261f.length : invokeV.intValue;
    }

    @Override // d.f.b.a.e0.e
    public int c(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) {
            int b2 = v.b(this.f70261f, j, false, false);
            if (b2 < this.f70261f.length) {
                return b2;
            }
            return -1;
        }
        return invokeJ.intValue;
    }

    @Override // d.f.b.a.e0.e
    public List<d.f.b.a.e0.b> d(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) ? this.f70260e.h(j, this.f70262g, this.f70263h) : (List) invokeJ.objValue;
    }
}
