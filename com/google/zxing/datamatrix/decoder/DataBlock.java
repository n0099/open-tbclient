package com.google.zxing.datamatrix.decoder;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.datamatrix.decoder.Version;
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

    public static DataBlock[] getDataBlocks(byte[] bArr, Version version) {
        InterceptResult invokeLL;
        boolean z;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, bArr, version)) == null) {
            Version.ECBlocks eCBlocks = version.getECBlocks();
            Version.ECB[] eCBlocks2 = eCBlocks.getECBlocks();
            int i3 = 0;
            for (Version.ECB ecb : eCBlocks2) {
                i3 += ecb.getCount();
            }
            DataBlock[] dataBlockArr = new DataBlock[i3];
            int i4 = 0;
            for (Version.ECB ecb2 : eCBlocks2) {
                int i5 = 0;
                while (i5 < ecb2.getCount()) {
                    int dataCodewords = ecb2.getDataCodewords();
                    dataBlockArr[i4] = new DataBlock(dataCodewords, new byte[eCBlocks.getECCodewords() + dataCodewords]);
                    i5++;
                    i4++;
                }
            }
            int length = dataBlockArr[0].codewords.length - eCBlocks.getECCodewords();
            int i6 = length - 1;
            int i7 = 0;
            for (int i8 = 0; i8 < i6; i8++) {
                int i9 = 0;
                while (i9 < i4) {
                    dataBlockArr[i9].codewords[i8] = bArr[i7];
                    i9++;
                    i7++;
                }
            }
            if (version.getVersionNumber() == 24) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                i = 8;
            } else {
                i = i4;
            }
            int i10 = 0;
            while (i10 < i) {
                dataBlockArr[i10].codewords[i6] = bArr[i7];
                i10++;
                i7++;
            }
            int length2 = dataBlockArr[0].codewords.length;
            while (length < length2) {
                int i11 = 0;
                while (i11 < i4) {
                    if (z) {
                        i2 = (i11 + 8) % i4;
                    } else {
                        i2 = i11;
                    }
                    dataBlockArr[i2].codewords[(z && i2 > 7) ? length - 1 : length] = bArr[i7];
                    i11++;
                    i7++;
                }
                length++;
            }
            if (i7 == bArr.length) {
                return dataBlockArr;
            }
            throw new IllegalArgumentException();
        }
        return (DataBlock[]) invokeLL.objValue;
    }

    public byte[] getCodewords() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.codewords;
        }
        return (byte[]) invokeV.objValue;
    }

    public int getNumDataCodewords() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.numDataCodewords;
        }
        return invokeV.intValue;
    }
}
