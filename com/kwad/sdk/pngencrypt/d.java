package com.kwad.sdk.pngencrypt;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.pngencrypt.ChunkReader;
/* loaded from: classes2.dex */
public abstract class d extends ChunkReader {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final DeflatedChunksSet f66871e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f66872f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f66873g;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f66874h;

    /* renamed from: i  reason: collision with root package name */
    public int f66875i;

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
        this.f66872f = false;
        this.f66873g = false;
        this.f66875i = -1;
        this.f66871e = deflatedChunksSet;
        if (str.equals("fdAT")) {
            this.f66873g = true;
            this.f66874h = new byte[4];
        }
        deflatedChunksSet.a(this);
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f66875i = i2;
        }
    }

    @Override // com.kwad.sdk.pngencrypt.ChunkReader
    public void a(int i2, byte[] bArr, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), bArr, Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            if (this.f66873g && i2 < 4) {
                while (i2 < 4 && i4 > 0) {
                    this.f66874h[i2] = bArr[i3];
                    i2++;
                    i3++;
                    i4--;
                }
            }
            if (i4 > 0) {
                this.f66871e.a(bArr, i3, i4);
                if (this.f66872f) {
                    System.arraycopy(bArr, i3, a().f66832d, this.f66766b, i4);
                }
            }
        }
    }

    @Override // com.kwad.sdk.pngencrypt.ChunkReader
    public void c() {
        int c2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f66873g && a().f66831c.equals("fdAT") && this.f66875i >= 0 && (c2 = n.c(this.f66874h, 0)) != this.f66875i) {
            com.kwad.sdk.core.d.a.a(new PngjException("bad chunk sequence for fDAT chunk " + c2 + " expected " + this.f66875i));
        }
    }
}
