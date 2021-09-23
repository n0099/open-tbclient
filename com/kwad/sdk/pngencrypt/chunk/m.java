package com.kwad.sdk.pngencrypt.chunk;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes10.dex */
public class m extends aa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public int[] f73488h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(com.kwad.sdk.pngencrypt.k kVar) {
        super("hIST", kVar);
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
        this.f73488h = new int[0];
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048576, this, dVar) != null) {
            return;
        }
        if (!this.f73438e.f73537g) {
            throw new PngjException("only indexed images accept a HIST chunk");
        }
        this.f73488h = new int[dVar.f73462d.length / 2];
        int i2 = 0;
        while (true) {
            int[] iArr = this.f73488h;
            if (i2 >= iArr.length) {
                return;
            }
            iArr[i2] = com.kwad.sdk.pngencrypt.n.b(dVar.f73462d, i2 * 2);
            i2++;
        }
    }
}
