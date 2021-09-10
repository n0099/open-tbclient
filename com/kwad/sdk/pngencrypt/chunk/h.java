package com.kwad.sdk.pngencrypt.chunk;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class h extends aa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public int f73156h;

    /* renamed from: i  reason: collision with root package name */
    public int f73157i;

    /* renamed from: j  reason: collision with root package name */
    public int f73158j;
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
            com.kwad.sdk.pngencrypt.k kVar = this.f73119e;
            if (kVar.f73217f) {
                this.f73156h = com.kwad.sdk.pngencrypt.n.b(dVar.f73143d, 0);
            } else if (kVar.f73218g) {
                this.l = dVar.f73143d[0] & 255;
            } else {
                this.f73157i = com.kwad.sdk.pngencrypt.n.b(dVar.f73143d, 0);
                this.f73158j = com.kwad.sdk.pngencrypt.n.b(dVar.f73143d, 2);
                this.k = com.kwad.sdk.pngencrypt.n.b(dVar.f73143d, 4);
            }
        }
    }
}
