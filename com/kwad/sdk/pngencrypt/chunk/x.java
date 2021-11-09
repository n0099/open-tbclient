package com.kwad.sdk.pngencrypt.chunk;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.pngencrypt.PngjException;
/* loaded from: classes2.dex */
public class x extends s {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public String f65954h;

    /* renamed from: i  reason: collision with root package name */
    public int f65955i;
    public int[] j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(com.kwad.sdk.pngencrypt.k kVar) {
        super("sPLT", kVar);
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
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) {
            int i7 = 0;
            int i8 = 0;
            while (true) {
                byte[] bArr = dVar.f65919d;
                if (i8 >= bArr.length) {
                    i8 = -1;
                    break;
                } else if (bArr[i8] == 0) {
                    break;
                } else {
                    i8++;
                }
            }
            if (i8 > 0) {
                byte[] bArr2 = dVar.f65919d;
                if (i8 <= bArr2.length - 2) {
                    this.f65954h = b.a(bArr2, 0, i8);
                    int a2 = com.kwad.sdk.pngencrypt.n.a(dVar.f65919d, i8 + 1);
                    this.f65955i = a2;
                    int i9 = i8 + 2;
                    int length = (dVar.f65919d.length - i9) / (a2 == 8 ? 6 : 10);
                    this.j = new int[length * 5];
                    int i10 = i9;
                    int i11 = 0;
                    while (i7 < length) {
                        if (this.f65955i == 8) {
                            int i12 = i10 + 1;
                            i3 = com.kwad.sdk.pngencrypt.n.a(dVar.f65919d, i10);
                            int i13 = i12 + 1;
                            i4 = com.kwad.sdk.pngencrypt.n.a(dVar.f65919d, i12);
                            int i14 = i13 + 1;
                            i5 = com.kwad.sdk.pngencrypt.n.a(dVar.f65919d, i13);
                            i2 = i14 + 1;
                            i6 = com.kwad.sdk.pngencrypt.n.a(dVar.f65919d, i14);
                        } else {
                            int b2 = com.kwad.sdk.pngencrypt.n.b(dVar.f65919d, i10);
                            int i15 = i10 + 2;
                            int b3 = com.kwad.sdk.pngencrypt.n.b(dVar.f65919d, i15);
                            int i16 = i15 + 2;
                            int b4 = com.kwad.sdk.pngencrypt.n.b(dVar.f65919d, i16);
                            int i17 = i16 + 2;
                            int b5 = com.kwad.sdk.pngencrypt.n.b(dVar.f65919d, i17);
                            i2 = i17 + 2;
                            i3 = b2;
                            i4 = b3;
                            i5 = b4;
                            i6 = b5;
                        }
                        int b6 = com.kwad.sdk.pngencrypt.n.b(dVar.f65919d, i2);
                        int[] iArr = this.j;
                        int i18 = i11 + 1;
                        iArr[i11] = i3;
                        int i19 = i18 + 1;
                        iArr[i18] = i4;
                        int i20 = i19 + 1;
                        iArr[i19] = i5;
                        int i21 = i20 + 1;
                        iArr[i20] = i6;
                        iArr[i21] = b6;
                        i7++;
                        i11 = i21 + 1;
                        i10 = i2 + 2;
                    }
                    return;
                }
            }
            throw new PngjException("bad sPLT chunk: no separator found");
        }
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f65954h : (String) invokeV.objValue;
    }
}
