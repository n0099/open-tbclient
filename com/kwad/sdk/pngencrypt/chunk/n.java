package com.kwad.sdk.pngencrypt.chunk;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes2.dex */
public class n extends aa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public String f58749h;

    /* renamed from: i  reason: collision with root package name */
    public byte[] f58750i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(com.kwad.sdk.pngencrypt.k kVar) {
        super("iCCP", kVar);
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
            int c2 = b.c(dVar.f58722d);
            this.f58749h = b.a(dVar.f58722d, 0, c2);
            byte[] bArr = dVar.f58722d;
            if ((bArr[c2 + 1] & 255) != 0) {
                throw new PngjException("bad compression for ChunkTypeICCP");
            }
            int i2 = c2 + 2;
            int length = bArr.length - i2;
            byte[] bArr2 = new byte[length];
            this.f58750i = bArr2;
            System.arraycopy(bArr, i2, bArr2, 0, length);
        }
    }
}
