package com.google.zxing.oned;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;
/* loaded from: classes11.dex */
public final class UPCEWriter extends UPCEANWriter {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CODE_WIDTH = 51;
    public transient /* synthetic */ FieldHolder $fh;

    public UPCEWriter() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter, com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i2, int i3, Map<EncodeHintType, ?> map) throws WriterException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, barcodeFormat, Integer.valueOf(i2), Integer.valueOf(i3), map})) == null) {
            if (barcodeFormat == BarcodeFormat.UPC_E) {
                return super.encode(str, barcodeFormat, i2, i3, map);
            }
            throw new IllegalArgumentException("Can only encode UPC_E, but got " + barcodeFormat);
        }
        return (BitMatrix) invokeCommon.objValue;
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public boolean[] encode(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (str.length() == 8) {
                int i2 = UPCEReader.CHECK_DIGIT_ENCODINGS[Integer.parseInt(str.substring(7, 8))];
                boolean[] zArr = new boolean[51];
                int appendPattern = OneDimensionalCodeWriter.appendPattern(zArr, 0, UPCEANReader.START_END_PATTERN, true) + 0;
                int i3 = 1;
                while (i3 <= 6) {
                    int i4 = i3 + 1;
                    int parseInt = Integer.parseInt(str.substring(i3, i4));
                    if (((i2 >> (6 - i3)) & 1) == 1) {
                        parseInt += 10;
                    }
                    appendPattern += OneDimensionalCodeWriter.appendPattern(zArr, appendPattern, UPCEANReader.L_AND_G_PATTERNS[parseInt], false);
                    i3 = i4;
                }
                OneDimensionalCodeWriter.appendPattern(zArr, appendPattern, UPCEANReader.END_PATTERN, false);
                return zArr;
            }
            throw new IllegalArgumentException("Requested contents should be 8 digits long, but got " + str.length());
        }
        return (boolean[]) invokeL.objValue;
    }
}
