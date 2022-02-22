package com.kwad.a.kwai;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.a.kwai.c;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/* loaded from: classes4.dex */
public class d extends c.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: j  reason: collision with root package name */
    public final f f55566j;

    public d(boolean z, f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = z;
        this.f55566j = fVar;
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(z ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.f55555b = fVar.d(allocate, 16L);
        this.f55556c = fVar.c(allocate, 28L);
        this.f55557d = fVar.c(allocate, 32L);
        this.f55558e = fVar.d(allocate, 42L);
        this.f55559f = fVar.d(allocate, 44L);
        this.f55560g = fVar.d(allocate, 46L);
        this.f55561h = fVar.d(allocate, 48L);
        this.f55562i = fVar.d(allocate, 50L);
    }

    @Override // com.kwad.a.kwai.c.b
    public c.a a(long j2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)})) == null) ? new a(this.f55566j, this, j2, i2) : (c.a) invokeCommon.objValue;
    }

    @Override // com.kwad.a.kwai.c.b
    public c.AbstractC2103c a(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) ? new g(this.f55566j, this, j2) : (c.AbstractC2103c) invokeJ.objValue;
    }

    @Override // com.kwad.a.kwai.c.b
    public c.d a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? new i(this.f55566j, this, i2) : (c.d) invokeI.objValue;
    }
}
