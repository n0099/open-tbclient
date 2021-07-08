package com.kwad.sdk.pngencrypt;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.pngencrypt.ChunkReader;
/* loaded from: classes6.dex */
public abstract class d extends ChunkReader {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final DeflatedChunksSet f35831e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f35832f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f35833g;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f35834h;

    /* renamed from: i  reason: collision with root package name */
    public int f35835i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(int i2, String str, boolean z, long j, DeflatedChunksSet deflatedChunksSet) {
        super(i2, str, j, ChunkReader.ChunkReaderMode.PROCESS);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r8;
            Object[] objArr = {Integer.valueOf(i2), str, Boolean.valueOf(z), Long.valueOf(j), deflatedChunksSet};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), (String) objArr2[1], ((Long) objArr2[2]).longValue(), (ChunkReader.ChunkReaderMode) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f35832f = false;
        this.f35833g = false;
        this.f35835i = -1;
        this.f35831e = deflatedChunksSet;
        if (str.equals("fdAT")) {
            this.f35833g = true;
            this.f35834h = new byte[4];
        }
        deflatedChunksSet.a(this);
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f35835i = i2;
        }
    }

    @Override // com.kwad.sdk.pngencrypt.ChunkReader
    public void a(int i2, byte[] bArr, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), bArr, Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            if (this.f35833g && i2 < 4) {
                while (i2 < 4 && i4 > 0) {
                    this.f35834h[i2] = bArr[i3];
                    i2++;
                    i3++;
                    i4--;
                }
            }
            if (i4 > 0) {
                this.f35831e.a(bArr, i3, i4);
                if (this.f35832f) {
                    System.arraycopy(bArr, i3, a().f35792d, this.f35726b, i4);
                }
            }
        }
    }

    @Override // com.kwad.sdk.pngencrypt.ChunkReader
    public void c() {
        int c2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f35833g && a().f35791c.equals("fdAT") && this.f35835i >= 0 && (c2 = n.c(this.f35834h, 0)) != this.f35835i) {
            com.kwad.sdk.core.d.a.a(new PngjException("bad chunk sequence for fDAT chunk " + c2 + " expected " + this.f35835i));
        }
    }
}
