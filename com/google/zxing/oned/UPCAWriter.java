package com.google.zxing.oned;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;
/* loaded from: classes8.dex */
public final class UPCAWriter implements Writer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final EAN13Writer subWriter;

    public UPCAWriter() {
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
        this.subWriter = new EAN13Writer();
    }

    public static String preencode(String str) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            int length = str.length();
            if (length == 11) {
                int i2 = 0;
                for (int i3 = 0; i3 < 11; i3++) {
                    int charAt = str.charAt(i3) - '0';
                    if (i3 % 2 == 0) {
                        i = 3;
                    } else {
                        i = 1;
                    }
                    i2 += charAt * i;
                }
                str = str + ((1000 - i2) % 10);
            } else if (length != 12) {
                throw new IllegalArgumentException("Requested contents should be 11 or 12 digits long, but got " + str.length());
            }
            return "0" + str;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2) throws WriterException {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048576, this, str, barcodeFormat, i, i2)) == null) {
            return encode(str, barcodeFormat, i, i2, null);
        }
        return (BitMatrix) invokeLLII.objValue;
    }

    @Override // com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) throws WriterException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, barcodeFormat, Integer.valueOf(i), Integer.valueOf(i2), map})) == null) {
            if (barcodeFormat == BarcodeFormat.UPC_A) {
                return this.subWriter.encode(preencode(str), BarcodeFormat.EAN_13, i, i2, map);
            }
            throw new IllegalArgumentException("Can only encode UPC-A, but got " + barcodeFormat);
        }
        return (BitMatrix) invokeCommon.objValue;
    }
}
