package com.kwad.sdk.pngencrypt.chunk;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class h extends aa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public int f35805h;

    /* renamed from: i  reason: collision with root package name */
    public int f35806i;
    public int j;
    public int k;
    public int l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(com.kwad.sdk.pngencrypt.k kVar) {
        super("bKGD", kVar);
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
            com.kwad.sdk.pngencrypt.k kVar = this.f35770e;
            if (kVar.f35854f) {
                this.f35805h = com.kwad.sdk.pngencrypt.n.b(dVar.f35792d, 0);
            } else if (kVar.f35855g) {
                this.l = dVar.f35792d[0] & 255;
            } else {
                this.f35806i = com.kwad.sdk.pngencrypt.n.b(dVar.f35792d, 0);
                this.j = com.kwad.sdk.pngencrypt.n.b(dVar.f35792d, 2);
                this.k = com.kwad.sdk.pngencrypt.n.b(dVar.f35792d, 4);
            }
        }
    }
}
