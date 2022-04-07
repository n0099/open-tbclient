package com.google.android.exoplayer2.decoder;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.util.Util;
/* loaded from: classes4.dex */
public final class CryptoInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int clearBlocks;
    public int encryptedBlocks;
    public final MediaCodec.CryptoInfo frameworkCryptoInfo;
    public byte[] iv;
    public byte[] key;
    public int mode;
    public int[] numBytesOfClearData;
    public int[] numBytesOfEncryptedData;
    public int numSubSamples;
    public final PatternHolderV24 patternHolder;

    /* renamed from: com.google.android.exoplayer2.decoder.CryptoInfo$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    @TargetApi(24)
    /* loaded from: classes4.dex */
    public static final class PatternHolderV24 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final MediaCodec.CryptoInfo frameworkCryptoInfo;
        public final MediaCodec.CryptoInfo.Pattern pattern;

        public /* synthetic */ PatternHolderV24(MediaCodec.CryptoInfo cryptoInfo, AnonymousClass1 anonymousClass1) {
            this(cryptoInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void set(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(65539, this, i, i2) == null) {
                this.pattern.set(i, i2);
                this.frameworkCryptoInfo.setPattern(this.pattern);
            }
        }

        public PatternHolderV24(MediaCodec.CryptoInfo cryptoInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cryptoInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.frameworkCryptoInfo = cryptoInfo;
            this.pattern = new MediaCodec.CryptoInfo.Pattern(0, 0);
        }
    }

    public CryptoInfo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        MediaCodec.CryptoInfo newFrameworkCryptoInfoV16 = Util.SDK_INT >= 16 ? newFrameworkCryptoInfoV16() : null;
        this.frameworkCryptoInfo = newFrameworkCryptoInfoV16;
        this.patternHolder = Util.SDK_INT >= 24 ? new PatternHolderV24(newFrameworkCryptoInfoV16, null) : null;
    }

    @TargetApi(16)
    private MediaCodec.CryptoInfo newFrameworkCryptoInfoV16() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) ? new MediaCodec.CryptoInfo() : (MediaCodec.CryptoInfo) invokeV.objValue;
    }

    @TargetApi(16)
    private void updateFrameworkCryptoInfoV16() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            MediaCodec.CryptoInfo cryptoInfo = this.frameworkCryptoInfo;
            cryptoInfo.numSubSamples = this.numSubSamples;
            cryptoInfo.numBytesOfClearData = this.numBytesOfClearData;
            cryptoInfo.numBytesOfEncryptedData = this.numBytesOfEncryptedData;
            cryptoInfo.key = this.key;
            cryptoInfo.iv = this.iv;
            cryptoInfo.mode = this.mode;
            if (Util.SDK_INT >= 24) {
                this.patternHolder.set(this.encryptedBlocks, this.clearBlocks);
            }
        }
    }

    @TargetApi(16)
    public MediaCodec.CryptoInfo getFrameworkCryptoInfoV16() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.frameworkCryptoInfo : (MediaCodec.CryptoInfo) invokeV.objValue;
    }

    public void set(int i, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), iArr, iArr2, bArr, bArr2, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            this.numSubSamples = i;
            this.numBytesOfClearData = iArr;
            this.numBytesOfEncryptedData = iArr2;
            this.key = bArr;
            this.iv = bArr2;
            this.mode = i2;
            this.encryptedBlocks = i3;
            this.clearBlocks = i4;
            if (Util.SDK_INT >= 16) {
                updateFrameworkCryptoInfoV16();
            }
        }
    }
}
