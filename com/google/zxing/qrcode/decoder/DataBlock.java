package com.google.zxing.qrcode.decoder;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.qrcode.decoder.Version;
/* loaded from: classes11.dex */
public final class DataBlock {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] codewords;
    public final int numDataCodewords;

    public DataBlock(int i2, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), bArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.numDataCodewords = i2;
        this.codewords = bArr;
    }

    public static DataBlock[] getDataBlocks(byte[] bArr, Version version, ErrorCorrectionLevel errorCorrectionLevel) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, bArr, version, errorCorrectionLevel)) == null) {
            if (bArr.length == version.getTotalCodewords()) {
                Version.ECBlocks eCBlocksForLevel = version.getECBlocksForLevel(errorCorrectionLevel);
                Version.ECB[] eCBlocks = eCBlocksForLevel.getECBlocks();
                int i2 = 0;
                for (Version.ECB ecb : eCBlocks) {
                    i2 += ecb.getCount();
                }
                DataBlock[] dataBlockArr = new DataBlock[i2];
                int i3 = 0;
                for (Version.ECB ecb2 : eCBlocks) {
                    int i4 = 0;
                    while (i4 < ecb2.getCount()) {
                        int dataCodewords = ecb2.getDataCodewords();
                        dataBlockArr[i3] = new DataBlock(dataCodewords, new byte[eCBlocksForLevel.getECCodewordsPerBlock() + dataCodewords]);
                        i4++;
                        i3++;
                    }
                }
                int length = dataBlockArr[0].codewords.length;
                int i5 = i2 - 1;
                while (i5 >= 0 && dataBlockArr[i5].codewords.length != length) {
                    i5--;
                }
                int i6 = i5 + 1;
                int eCCodewordsPerBlock = length - eCBlocksForLevel.getECCodewordsPerBlock();
                int i7 = 0;
                for (int i8 = 0; i8 < eCCodewordsPerBlock; i8++) {
                    int i9 = 0;
                    while (i9 < i3) {
                        dataBlockArr[i9].codewords[i8] = bArr[i7];
                        i9++;
                        i7++;
                    }
                }
                int i10 = i6;
                while (i10 < i3) {
                    dataBlockArr[i10].codewords[eCCodewordsPerBlock] = bArr[i7];
                    i10++;
                    i7++;
                }
                int length2 = dataBlockArr[0].codewords.length;
                while (eCCodewordsPerBlock < length2) {
                    int i11 = 0;
                    while (i11 < i3) {
                        dataBlockArr[i11].codewords[i11 < i6 ? eCCodewordsPerBlock : eCCodewordsPerBlock + 1] = bArr[i7];
                        i11++;
                        i7++;
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
