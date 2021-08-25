package com.kwad.sdk.pngencrypt.chunk;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes10.dex */
public class w extends aa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public int f73004h;

    /* renamed from: i  reason: collision with root package name */
    public int f73005i;

    /* renamed from: j  reason: collision with root package name */
    public int f73006j;
    public int k;
    public int l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(com.kwad.sdk.pngencrypt.k kVar) {
        super("sBIT", kVar);
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

    private int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            int i2 = this.f72939e.f73037f ? 1 : 3;
            return this.f72939e.f73036e ? i2 + 1 : i2;
        }
        return invokeV.intValue;
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        int a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) {
            if (dVar.f72960a != c()) {
                throw new PngjException("bad chunk length " + dVar);
            }
            if (this.f72939e.f73037f) {
                this.f73004h = com.kwad.sdk.pngencrypt.n.a(dVar.f72963d, 0);
                if (!this.f72939e.f73036e) {
                    return;
                }
                a2 = com.kwad.sdk.pngencrypt.n.a(dVar.f72963d, 1);
            } else {
                this.f73006j = com.kwad.sdk.pngencrypt.n.a(dVar.f72963d, 0);
                this.k = com.kwad.sdk.pngencrypt.n.a(dVar.f72963d, 1);
                this.l = com.kwad.sdk.pngencrypt.n.a(dVar.f72963d, 2);
                if (!this.f72939e.f73036e) {
                    return;
                }
                a2 = com.kwad.sdk.pngencrypt.n.a(dVar.f72963d, 3);
            }
            this.f73005i = a2;
        }
    }
}
