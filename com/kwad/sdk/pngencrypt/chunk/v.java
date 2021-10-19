package com.kwad.sdk.pngencrypt.chunk;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes10.dex */
public class v extends aa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public int f73536h;

    /* renamed from: i  reason: collision with root package name */
    public int[] f73537i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(com.kwad.sdk.pngencrypt.k kVar) {
        super("PLTE", kVar);
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
        this.f73536h = 0;
    }

    public void a(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048576, this, i2, i3, i4, i5) == null) {
            this.f73537i[i2] = (i3 << 16) | (i4 << 8) | i5;
        }
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public void a(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) {
            b(dVar.f73494a / 3);
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.f73536h) {
                byte[] bArr = dVar.f73497d;
                int i4 = i3 + 1;
                int i5 = i4 + 1;
                a(i2, bArr[i3] & 255, bArr[i4] & 255, bArr[i5] & 255);
                i2++;
                i3 = i5 + 1;
            }
        }
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f73536h = i2;
            if (i2 < 1 || i2 > 256) {
                throw new PngjException("invalid pallette - nentries=" + this.f73536h);
            }
            int[] iArr = this.f73537i;
            if (iArr == null || iArr.length != i2) {
                this.f73537i = new int[this.f73536h];
            }
        }
    }
}
