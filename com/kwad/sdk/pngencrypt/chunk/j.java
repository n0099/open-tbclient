package com.kwad.sdk.pngencrypt.chunk;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class j extends s {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public int f35809h;

    /* renamed from: i  reason: collision with root package name */
    public int f35810i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public byte o;
    public byte p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(com.kwad.sdk.pngencrypt.k kVar) {
        super("fcTL", kVar);
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
            this.f35809h = com.kwad.sdk.pngencrypt.n.c(dVar.f35792d, 0);
            this.f35810i = com.kwad.sdk.pngencrypt.n.c(dVar.f35792d, 4);
            this.j = com.kwad.sdk.pngencrypt.n.c(dVar.f35792d, 8);
            this.k = com.kwad.sdk.pngencrypt.n.c(dVar.f35792d, 12);
            this.l = com.kwad.sdk.pngencrypt.n.c(dVar.f35792d, 16);
            this.m = com.kwad.sdk.pngencrypt.n.b(dVar.f35792d, 20);
            this.n = com.kwad.sdk.pngencrypt.n.b(dVar.f35792d, 22);
            byte[] bArr = dVar.f35792d;
            this.o = bArr[24];
            this.p = bArr[25];
        }
    }
}
