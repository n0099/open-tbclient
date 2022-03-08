package com.google.android.exoplayer2.upstream.crypto;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.datacollector.growth.utils.UBCEncryptor;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.util.Assertions;
import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes7.dex */
public final class AesFlushingCipher {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int blockSize;
    public final Cipher cipher;
    public final byte[] flushedBlock;
    public int pendingXorBytes;
    public final byte[] zerosBlock;

    public AesFlushingCipher(int i2, byte[] bArr, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), bArr, Long.valueOf(j2), Long.valueOf(j3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        try {
            Cipher cipher = Cipher.getInstance(UBCEncryptor.TRANSFORMATION);
            this.cipher = cipher;
            int blockSize = cipher.getBlockSize();
            this.blockSize = blockSize;
            this.zerosBlock = new byte[blockSize];
            this.flushedBlock = new byte[blockSize];
            int i5 = (int) (j3 % blockSize);
            this.cipher.init(i2, new SecretKeySpec(bArr, this.cipher.getAlgorithm().split("/")[0]), new IvParameterSpec(getInitializationVector(j2, j3 / blockSize)));
            if (i5 != 0) {
                updateInPlace(new byte[i5], 0, i5);
            }
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException e2) {
            throw new RuntimeException(e2);
        }
    }

    private byte[] getInitializationVector(long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) ? ByteBuffer.allocate(16).putLong(j2).putLong(j3).array() : (byte[]) invokeCommon.objValue;
    }

    private int nonFlushingUpdate(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, this, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), bArr2, Integer.valueOf(i4)})) == null) {
            try {
                return this.cipher.update(bArr, i2, i3, bArr2, i4);
            } catch (ShortBufferException e2) {
                throw new RuntimeException(e2);
            }
        }
        return invokeCommon.intValue;
    }

    public void update(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), bArr2, Integer.valueOf(i4)}) == null) {
            int i5 = i2;
            do {
                int i6 = this.pendingXorBytes;
                if (i6 > 0) {
                    bArr2[i4] = (byte) (bArr[i5] ^ this.flushedBlock[this.blockSize - i6]);
                    i4++;
                    i5++;
                    this.pendingXorBytes = i6 - 1;
                    i3--;
                } else {
                    int nonFlushingUpdate = nonFlushingUpdate(bArr, i5, i3, bArr2, i4);
                    if (i3 == nonFlushingUpdate) {
                        return;
                    }
                    int i7 = i3 - nonFlushingUpdate;
                    int i8 = 0;
                    Assertions.checkState(i7 < this.blockSize);
                    int i9 = i4 + nonFlushingUpdate;
                    int i10 = this.blockSize - i7;
                    this.pendingXorBytes = i10;
                    Assertions.checkState(nonFlushingUpdate(this.zerosBlock, 0, i10, this.flushedBlock, 0) == this.blockSize);
                    while (i8 < i7) {
                        bArr2[i9] = this.flushedBlock[i8];
                        i8++;
                        i9++;
                    }
                    return;
                }
            } while (i3 != 0);
        }
    }

    public void updateInPlace(byte[] bArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr, i2, i3) == null) {
            update(bArr, i2, i3, bArr, i2);
        }
    }
}
