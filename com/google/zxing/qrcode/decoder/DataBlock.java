package com.google.zxing.qrcode.decoder;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.qrcode.decoder.Version;
/* loaded from: classes7.dex */
public final class DataBlock {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] codewords;
    public final int numDataCodewords;

    public DataBlock(int i, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), bArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.numDataCodewords = i;
        this.codewords = bArr;
    }

    public static DataBlock[] getDataBlocks(byte[] bArr, Version version, ErrorCorrectionLevel errorCorrectionLevel) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, bArr, version, errorCorrectionLevel)) == null) {
            if (bArr.length == version.getTotalCodewords()) {
                Version.ECBlocks eCBlocksForLevel = version.getECBlocksForLevel(errorCorrectionLevel);
                Version.ECB[] eCBlocks = eCBlocksForLevel.getECBlocks();
                int i = 0;
                for (Version.ECB ecb : eCBlocks) {
                    i += ecb.getCount();
                }
                DataBlock[] dataBlockArr = new DataBlock[i];
                int i2 = 0;
                for (Version.ECB ecb2 : eCBlocks) {
                    int i3 = 0;
                    while (i3 < ecb2.getCount()) {
                        int dataCodewords = ecb2.getDataCodewords();
                        dataBlockArr[i2] = new DataBlock(dataCodewords, new byte[eCBlocksForLevel.getECCodewordsPerBlock() + dataCodewords]);
                        i3++;
                        i2++;
                    }
                }
                int length = dataBlockArr[0].codewords.length;
                int i4 = i - 1;
                while (i4 >= 0 && dataBlockArr[i4].codewords.length != length) {
                    i4--;
                }
                int i5 = i4 + 1;
                int eCCodewordsPerBlock = length - eCBlocksForLevel.getECCodewordsPerBlock();
                int i6 = 0;
                for (int i7 = 0; i7 < eCCodewordsPerBlock; i7++) {
                    int i8 = 0;
                    while (i8 < i2) {
                        dataBlockArr[i8].codewords[i7] = bArr[i6];
                        i8++;
                        i6++;
                    }
                }
                int i9 = i5;
                while (i9 < i2) {
                    dataBlockArr[i9].codewords[eCCodewordsPerBlock] = bArr[i6];
                    i9++;
                    i6++;
                }
                int length2 = dataBlockArr[0].codewords.length;
                while (eCCodewordsPerBlock < length2) {
                    int i10 = 0;
                    while (i10 < i2) {
                        dataBlockArr[i10].codewords[i10 < i5 ? eCCodewordsPerBlock : eCCodewordsPerBlock + 1] = bArr[i6];
                        i10++;
                        i6++;
                    }
                    eCCodewordsPerBlock++;
                }
                return dataBlockArr;
            }
            throw new IllegalArgumentException();
        }
        return (DataBlock[]) invokeLLL.objValue;
    }

    public byte[] getCodewords() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.codewords : (byte[]) invokeV.objValue;
    }

    public int getNumDataCodewords() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.numDataCodewords : invokeV.intValue;
    }
}
