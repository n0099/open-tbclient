package com.kwad.sdk.pngencrypt.chunk;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes2.dex */
public class r extends ae {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean j;
    public String k;
    public String l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(com.kwad.sdk.pngencrypt.k kVar) {
        super("iTXt", kVar);
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
        this.j = false;
        this.k = "";
        this.l = "";
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) {
            int[] iArr = new int[3];
            int i2 = 0;
            int i3 = 0;
            while (true) {
                byte[] bArr = dVar.f65920d;
                if (i2 >= bArr.length) {
                    break;
                }
                if (bArr[i2] == 0) {
                    iArr[i3] = i2;
                    i3++;
                    if (i3 == 1) {
                        i2 += 2;
                    }
                    if (i3 == 3) {
                        break;
                    }
                }
                i2++;
            }
            if (i3 != 3) {
                com.kwad.sdk.core.d.a.a(new PngjException("Bad formed PngChunkITXT chunk"));
            }
            ((ae) this).f65907h = b.a(dVar.f65920d, 0, iArr[0]);
            int i4 = iArr[0] + 1;
            boolean z = dVar.f65920d[i4] != 0;
            this.j = z;
            int i5 = i4 + 1;
            if (z && dVar.f65920d[i5] != 0) {
                com.kwad.sdk.core.d.a.a(new PngjException("Bad formed PngChunkITXT chunk - bad compression method "));
            }
            this.k = b.a(dVar.f65920d, i5, iArr[1] - i5);
            this.l = b.b(dVar.f65920d, iArr[1] + 1, (iArr[2] - iArr[1]) - 1);
            int i6 = iArr[2] + 1;
            boolean z2 = this.j;
            byte[] bArr2 = dVar.f65920d;
            this.f65908i = z2 ? b.b(b.a(bArr2, i6, bArr2.length - i6, false)) : b.b(bArr2, i6, bArr2.length - i6);
        }
    }
}
