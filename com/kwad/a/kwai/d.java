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
/* loaded from: classes3.dex */
public class d extends c.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: j  reason: collision with root package name */
    public final f f57538j;

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
        this.f57538j = fVar;
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(z ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.f57527b = fVar.d(allocate, 16L);
        this.f57528c = fVar.c(allocate, 28L);
        this.f57529d = fVar.c(allocate, 32L);
        this.f57530e = fVar.d(allocate, 42L);
        this.f57531f = fVar.d(allocate, 44L);
        this.f57532g = fVar.d(allocate, 46L);
        this.f57533h = fVar.d(allocate, 48L);
        this.f57534i = fVar.d(allocate, 50L);
    }

    @Override // com.kwad.a.kwai.c.b
    public c.a a(long j2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)})) == null) ? new a(this.f57538j, this, j2, i2) : (c.a) invokeCommon.objValue;
    }

    @Override // com.kwad.a.kwai.c.b
    public c.AbstractC2070c a(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) ? new g(this.f57538j, this, j2) : (c.AbstractC2070c) invokeJ.objValue;
    }

    @Override // com.kwad.a.kwai.c.b
    public c.d a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? new i(this.f57538j, this, i2) : (c.d) invokeI.objValue;
    }
}
