package com.google.zxing.datamatrix.decoder;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.datamatrix.decoder.Version;
/* loaded from: classes5.dex */
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

    public static DataBlock[] getDataBlocks(byte[] bArr, Version version) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, bArr, version)) == null) {
            Version.ECBlocks eCBlocks = version.getECBlocks();
            Version.ECB[] eCBlocks2 = eCBlocks.getECBlocks();
            int i = 0;
            for (Version.ECB ecb : eCBlocks2) {
                i += ecb.getCount();
            }
            DataBlock[] dataBlockArr = new DataBlock[i];
            int i2 = 0;
            for (Version.ECB ecb2 : eCBlocks2) {
                int i3 = 0;
                while (i3 < ecb2.getCount()) {
                    int dataCodewords = ecb2.getDataCodewords();
                    dataBlockArr[i2] = new DataBlock(dataCodewords, new byte[eCBlocks.getECCodewords() + dataCodewords]);
                    i3++;
                    i2++;
                }
            }
            int length = dataBlockArr[0].codewords.length - eCBlocks.getECCodewords();
            int i4 = length - 1;
            int i5 = 0;
            for (int i6 = 0; i6 < i4; i6++) {
                int i7 = 0;
                while (i7 < i2) {
                    dataBlockArr[i7].codewords[i6] = bArr[i5];
                    i7++;
                    i5++;
                }
            }
            boolean z = version.getVersionNumber() == 24;
            int i8 = z ? 8 : i2;
            int i9 = 0;
            while (i9 < i8) {
                dataBlockArr[i9].codewords[i4] = bArr[i5];
                i9++;
                i5++;
            }
            int length2 = dataBlockArr[0].codewords.length;
            while (length < length2) {
                int i10 = 0;
                while (i10 < i2) {
                    int i11 = z ? (i10 + 8) % i2 : i10;
                    dataBlockArr[i11].codewords[(!z || i11 <= 7) ? length : length - 1] = bArr[i5];
                    i10++;
                    i5++;
                }
                length++;
            }
            if (i5 == bArr.length) {
                return dataBlockArr;
            }
            throw new IllegalArgumentException();
        }
        return (DataBlock[]) invokeLL.objValue;
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
