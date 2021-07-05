package d.f.b.a.d0.w;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.f.b.a.d0.o;
import java.io.IOException;
/* loaded from: classes10.dex */
public final class k implements o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final int f72929e;

    /* renamed from: f  reason: collision with root package name */
    public final l f72930f;

    public k(l lVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lVar, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f72930f = lVar;
        this.f72929e = i2;
    }

    @Override // d.f.b.a.d0.o
    public void a() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f72930f.G();
        }
    }

    @Override // d.f.b.a.d0.o
    public int f(d.f.b.a.l lVar, d.f.b.a.y.e eVar, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lVar, eVar, z)) == null) ? this.f72930f.M(this.f72929e, lVar, eVar, z) : invokeLLZ.intValue;
    }

    @Override // d.f.b.a.d0.o
    public boolean isReady() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f72930f.E(this.f72929e) : invokeV.booleanValue;
    }

    @Override // d.f.b.a.d0.o
    public int j(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) ? this.f72930f.V(this.f72929e, j) : invokeJ.intValue;
    }
}
