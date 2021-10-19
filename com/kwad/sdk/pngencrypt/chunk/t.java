package com.kwad.sdk.pngencrypt.chunk;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes10.dex */
public class t extends aa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public long f73530h;

    /* renamed from: i  reason: collision with root package name */
    public long f73531i;

    /* renamed from: j  reason: collision with root package name */
    public int f73532j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(com.kwad.sdk.pngencrypt.k kVar) {
        super("oFFs", kVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {kVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (com.kwad.sdk.pngencrypt.k) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) {
            if (dVar.f73494a != 9) {
                throw new PngjException("bad chunk length " + dVar);
            }
            long c2 = com.kwad.sdk.pngencrypt.n.c(dVar.f73497d, 0);
            this.f73530h = c2;
            if (c2 < 0) {
                this.f73530h = c2 + 4294967296L;
            }
            long c3 = com.kwad.sdk.pngencrypt.n.c(dVar.f73497d, 4);
            this.f73531i = c3;
            if (c3 < 0) {
                this.f73531i = c3 + 4294967296L;
            }
            this.f73532j = com.kwad.sdk.pngencrypt.n.a(dVar.f73497d, 8);
        }
    }
}
