package com.kwad.sdk.pngencrypt.chunk;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes10.dex */
public class i extends aa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public double f73513h;

    /* renamed from: i  reason: collision with root package name */
    public double f73514i;

    /* renamed from: j  reason: collision with root package name */
    public double f73515j;
    public double k;
    public double l;
    public double m;
    public double n;
    public double o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(com.kwad.sdk.pngencrypt.k kVar) {
        super("cHRM", kVar);
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
            if (dVar.f73494a != 32) {
                throw new PngjException("bad chunk " + dVar);
            }
            this.f73513h = com.kwad.sdk.pngencrypt.n.a(com.kwad.sdk.pngencrypt.n.c(dVar.f73497d, 0));
            this.f73514i = com.kwad.sdk.pngencrypt.n.a(com.kwad.sdk.pngencrypt.n.c(dVar.f73497d, 4));
            this.f73515j = com.kwad.sdk.pngencrypt.n.a(com.kwad.sdk.pngencrypt.n.c(dVar.f73497d, 8));
            this.k = com.kwad.sdk.pngencrypt.n.a(com.kwad.sdk.pngencrypt.n.c(dVar.f73497d, 12));
            this.l = com.kwad.sdk.pngencrypt.n.a(com.kwad.sdk.pngencrypt.n.c(dVar.f73497d, 16));
            this.m = com.kwad.sdk.pngencrypt.n.a(com.kwad.sdk.pngencrypt.n.c(dVar.f73497d, 20));
            this.n = com.kwad.sdk.pngencrypt.n.a(com.kwad.sdk.pngencrypt.n.c(dVar.f73497d, 24));
            this.o = com.kwad.sdk.pngencrypt.n.a(com.kwad.sdk.pngencrypt.n.c(dVar.f73497d, 28));
        }
    }
}
