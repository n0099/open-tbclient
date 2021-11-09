package com.kwad.sdk.pngencrypt.chunk;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class h extends aa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public int f65932h;

    /* renamed from: i  reason: collision with root package name */
    public int f65933i;
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
            com.kwad.sdk.pngencrypt.k kVar = this.f65897e;
            if (kVar.f65981f) {
                this.f65932h = com.kwad.sdk.pngencrypt.n.b(dVar.f65919d, 0);
            } else if (kVar.f65982g) {
                this.l = dVar.f65919d[0] & 255;
            } else {
                this.f65933i = com.kwad.sdk.pngencrypt.n.b(dVar.f65919d, 0);
                this.j = com.kwad.sdk.pngencrypt.n.b(dVar.f65919d, 2);
                this.k = com.kwad.sdk.pngencrypt.n.b(dVar.f65919d, 4);
            }
        }
    }
}
