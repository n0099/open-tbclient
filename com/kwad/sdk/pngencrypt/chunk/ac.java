package com.kwad.sdk.pngencrypt.chunk;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes6.dex */
public class ac extends aa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public int f35775h;

    /* renamed from: i  reason: collision with root package name */
    public int f35776i;
    public int j;
    public int k;
    public int l;
    public int m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ac(com.kwad.sdk.pngencrypt.k kVar) {
        super("tIME", kVar);
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
            if (dVar.f35789a != 7) {
                throw new PngjException("bad chunk " + dVar);
            }
            this.f35775h = com.kwad.sdk.pngencrypt.n.b(dVar.f35792d, 0);
            this.f35776i = com.kwad.sdk.pngencrypt.n.a(dVar.f35792d, 2);
            this.j = com.kwad.sdk.pngencrypt.n.a(dVar.f35792d, 3);
            this.k = com.kwad.sdk.pngencrypt.n.a(dVar.f35792d, 4);
            this.l = com.kwad.sdk.pngencrypt.n.a(dVar.f35792d, 5);
            this.m = com.kwad.sdk.pngencrypt.n.a(dVar.f35792d, 6);
        }
    }
}
