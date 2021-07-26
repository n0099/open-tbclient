package com.kwad.sdk.pngencrypt.chunk;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ad extends aa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public int f35966h;

    /* renamed from: i  reason: collision with root package name */
    public int f35967i;
    public int j;
    public int k;
    public int[] l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ad(com.kwad.sdk.pngencrypt.k kVar) {
        super("tRNS", kVar);
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
        this.l = new int[0];
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) {
            com.kwad.sdk.pngencrypt.k kVar = this.f35959e;
            if (kVar.f36043f) {
                this.f35966h = com.kwad.sdk.pngencrypt.n.b(dVar.f35981d, 0);
            } else if (!kVar.f36044g) {
                this.f35967i = com.kwad.sdk.pngencrypt.n.b(dVar.f35981d, 0);
                this.j = com.kwad.sdk.pngencrypt.n.b(dVar.f35981d, 2);
                this.k = com.kwad.sdk.pngencrypt.n.b(dVar.f35981d, 4);
            } else {
                int length = dVar.f35981d.length;
                this.l = new int[length];
                for (int i2 = 0; i2 < length; i2++) {
                    this.l[i2] = dVar.f35981d[i2] & 255;
                }
            }
        }
    }
}
