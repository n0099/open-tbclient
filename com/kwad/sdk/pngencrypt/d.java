package com.kwad.sdk.pngencrypt;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.pngencrypt.ChunkReader;
/* loaded from: classes10.dex */
public abstract class d extends ChunkReader {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final DeflatedChunksSet f73012e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f73013f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f73014g;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f73015h;

    /* renamed from: i  reason: collision with root package name */
    public int f73016i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(int i2, String str, boolean z, long j2, DeflatedChunksSet deflatedChunksSet) {
        super(i2, str, j2, ChunkReader.ChunkReaderMode.PROCESS);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r8;
            Object[] objArr = {Integer.valueOf(i2), str, Boolean.valueOf(z), Long.valueOf(j2), deflatedChunksSet};
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
        this.f73013f = false;
        this.f73014g = false;
        this.f73016i = -1;
        this.f73012e = deflatedChunksSet;
        if (str.equals("fdAT")) {
            this.f73014g = true;
            this.f73015h = new byte[4];
        }
        deflatedChunksSet.a(this);
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f73016i = i2;
        }
    }

    @Override // com.kwad.sdk.pngencrypt.ChunkReader
    public void a(int i2, byte[] bArr, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), bArr, Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            if (this.f73014g && i2 < 4) {
                while (i2 < 4 && i4 > 0) {
                    this.f73015h[i2] = bArr[i3];
                    i2++;
                    i3++;
                    i4--;
                }
            }
            if (i4 > 0) {
                this.f73012e.a(bArr, i3, i4);
                if (this.f73013f) {
                    System.arraycopy(bArr, i3, a().f72963d, this.f72892b, i4);
                }
            }
        }
    }

    @Override // com.kwad.sdk.pngencrypt.ChunkReader
    public void c() {
        int c2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f73014g && a().f72962c.equals("fdAT") && this.f73016i >= 0 && (c2 = n.c(this.f73015h, 0)) != this.f73016i) {
            com.kwad.sdk.core.d.a.a(new PngjException("bad chunk sequence for fDAT chunk " + c2 + " expected " + this.f73016i));
        }
    }
}
