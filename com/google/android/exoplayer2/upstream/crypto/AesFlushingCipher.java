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

    public AesFlushingCipher(int i, byte[] bArr, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), bArr, Long.valueOf(j), Long.valueOf(j2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            int i4 = (int) (j2 % blockSize);
            this.cipher.init(i, new SecretKeySpec(bArr, this.cipher.getAlgorithm().split("/")[0]), new IvParameterSpec(getInitializationVector(j, j2 / blockSize)));
            if (i4 != 0) {
                updateInPlace(new byte[i4], 0, i4);
            }
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException e) {
            throw new RuntimeException(e);
        }
    }

    private byte[] getInitializationVector(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            return ByteBuffer.allocate(16).putLong(j).putLong(j2).array();
        }
        return (byte[]) invokeCommon.objValue;
    }

    private int nonFlushingUpdate(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, this, new Object[]{bArr, Integer.valueOf(i), Integer.valueOf(i2), bArr2, Integer.valueOf(i3)})) == null) {
            try {
                return this.cipher.update(bArr, i, i2, bArr2, i3);
            } catch (ShortBufferException e) {
                throw new RuntimeException(e);
            }
        }
        return invokeCommon.intValue;
    }

    public void update(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{bArr, Integer.valueOf(i), Integer.valueOf(i2), bArr2, Integer.valueOf(i3)}) == null) {
            int i4 = i;
            do {
                int i5 = this.pendingXorBytes;
                if (i5 > 0) {
                    bArr2[i3] = (byte) (bArr[i4] ^ this.flushedBlock[this.blockSize - i5]);
                    i3++;
                    i4++;
                    this.pendingXorBytes = i5 - 1;
                    i2--;
                } else {
                    int nonFlushingUpdate = nonFlushingUpdate(bArr, i4, i2, bArr2, i3);
                    if (i2 == nonFlushingUpdate) {
                        return;
                    }
                    int i6 = i2 - nonFlushingUpdate;
                    int i7 = 0;
                    boolean z2 = true;
                    if (i6 < this.blockSize) {
                        z = true;
                    } else {
                        z = false;
                    }
                    Assertions.checkState(z);
                    int i8 = i3 + nonFlushingUpdate;
                    int i9 = this.blockSize - i6;
                    this.pendingXorBytes = i9;
                    if (nonFlushingUpdate(this.zerosBlock, 0, i9, this.flushedBlock, 0) != this.blockSize) {
                        z2 = false;
                    }
                    Assertions.checkState(z2);
                    while (i7 < i6) {
                        bArr2[i8] = this.flushedBlock[i7];
                        i7++;
                        i8++;
                    }
                    return;
                }
            } while (i2 != 0);
        }
    }

    public void updateInPlace(byte[] bArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr, i, i2) == null) {
            update(bArr, i, i2, bArr, i);
        }
    }
}
