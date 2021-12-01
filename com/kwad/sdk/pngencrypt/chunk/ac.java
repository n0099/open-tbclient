package com.kwad.sdk.pngencrypt.chunk;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes2.dex */
public class ac extends aa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public int f58704h;

    /* renamed from: i  reason: collision with root package name */
    public int f58705i;

    /* renamed from: j  reason: collision with root package name */
    public int f58706j;

    /* renamed from: k  reason: collision with root package name */
    public int f58707k;
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
            if (dVar.a != 7) {
                throw new PngjException("bad chunk " + dVar);
            }
            this.f58704h = com.kwad.sdk.pngencrypt.n.b(dVar.f58722d, 0);
            this.f58705i = com.kwad.sdk.pngencrypt.n.a(dVar.f58722d, 2);
            this.f58706j = com.kwad.sdk.pngencrypt.n.a(dVar.f58722d, 3);
            this.f58707k = com.kwad.sdk.pngencrypt.n.a(dVar.f58722d, 4);
            this.l = com.kwad.sdk.pngencrypt.n.a(dVar.f58722d, 5);
            this.m = com.kwad.sdk.pngencrypt.n.a(dVar.f58722d, 6);
        }
    }
}
