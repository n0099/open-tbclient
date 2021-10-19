package com.kwad.sdk.pngencrypt.chunk;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes10.dex */
public class ag extends ae {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ag(com.kwad.sdk.pngencrypt.k kVar) {
        super("zTXt", kVar);
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
            int i2 = 0;
            while (true) {
                byte[] bArr = dVar.f73497d;
                if (i2 >= bArr.length) {
                    i2 = -1;
                    break;
                } else if (bArr[i2] == 0) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 < 0 || i2 > dVar.f73497d.length - 2) {
                com.kwad.sdk.core.d.a.a(new PngjException("bad zTXt chunk: no separator found"));
            }
            ((ae) this).f73484h = b.a(dVar.f73497d, 0, i2);
            if (dVar.f73497d[i2 + 1] != 0) {
                com.kwad.sdk.core.d.a.a(new PngjException("bad zTXt chunk: unknown compression method"));
            }
            byte[] bArr2 = dVar.f73497d;
            this.f73485i = b.a(b.a(bArr2, i2 + 2, (bArr2.length - i2) - 2, false));
        }
    }
}
