package com.google.android.exoplayer2.extractor.mp4;

import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.Assertions;
/* loaded from: classes7.dex */
public final class TrackEncryptionBox {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "TrackEncryptionBox";
    public transient /* synthetic */ FieldHolder $fh;
    public final TrackOutput.CryptoData cryptoData;
    public final byte[] defaultInitializationVector;
    public final int initializationVectorSize;
    public final boolean isEncrypted;
    @Nullable
    public final String schemeType;

    public TrackEncryptionBox(boolean z, @Nullable String str, int i2, byte[] bArr, int i3, int i4, @Nullable byte[] bArr2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), str, Integer.valueOf(i2), bArr, Integer.valueOf(i3), Integer.valueOf(i4), bArr2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Assertions.checkArgument((bArr2 == null) ^ (i2 == 0));
        this.isEncrypted = z;
        this.schemeType = str;
        this.initializationVectorSize = i2;
        this.defaultInitializationVector = bArr2;
        this.cryptoData = new TrackOutput.CryptoData(schemeToCryptoMode(str), bArr, i3, i4);
    }

    public static int schemeToCryptoMode(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (str == null) {
                return 1;
            }
            char c2 = 65535;
            switch (str.hashCode()) {
                case 3046605:
                    if (str.equals(C.CENC_TYPE_cbc1)) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 3046671:
                    if (str.equals(C.CENC_TYPE_cbcs)) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 3049879:
                    if (str.equals("cenc")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 3049895:
                    if (str.equals(C.CENC_TYPE_cens)) {
                        c2 = 1;
                        break;
                    }
                    break;
            }
            if (c2 == 0 || c2 == 1) {
                return 1;
            }
            if (c2 == 2 || c2 == 3) {
                return 2;
            }
            String str2 = "Unsupported protection scheme type '" + str + "'. Assuming AES-CTR crypto mode.";
            return 1;
        }
        return invokeL.intValue;
    }
}
