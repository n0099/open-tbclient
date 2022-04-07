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
/* loaded from: classes5.dex */
public class d extends c.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final f j;

    public d(boolean z, f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = z;
        this.j = fVar;
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(z ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.b = fVar.d(allocate, 16L);
        this.c = fVar.c(allocate, 28L);
        this.d = fVar.c(allocate, 32L);
        this.e = fVar.d(allocate, 42L);
        this.f = fVar.d(allocate, 44L);
        this.g = fVar.d(allocate, 46L);
        this.h = fVar.d(allocate, 48L);
        this.i = fVar.d(allocate, 50L);
    }

    @Override // com.kwad.a.kwai.c.b
    public c.a a(long j, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Integer.valueOf(i)})) == null) ? new a(this.j, this, j, i) : (c.a) invokeCommon.objValue;
    }

    @Override // com.kwad.a.kwai.c.b
    public c.AbstractC0283c a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) ? new g(this.j, this, j) : (c.AbstractC0283c) invokeJ.objValue;
    }

    @Override // com.kwad.a.kwai.c.b
    public c.d a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) ? new i(this.j, this, i) : (c.d) invokeI.objValue;
    }
}
