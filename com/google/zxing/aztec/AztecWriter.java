package com.google.zxing.aztec;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.aztec.encoder.AztecCode;
import com.google.zxing.aztec.encoder.Encoder;
import com.google.zxing.common.BitMatrix;
import java.nio.charset.Charset;
import java.util.Map;
/* loaded from: classes7.dex */
public final class AztecWriter implements Writer {
    public static /* synthetic */ Interceptable $ic;
    public static final Charset DEFAULT_CHARSET;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(990712492, "Lcom/google/zxing/aztec/AztecWriter;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(990712492, "Lcom/google/zxing/aztec/AztecWriter;");
                return;
            }
        }
        DEFAULT_CHARSET = Charset.forName("ISO-8859-1");
    }

    public AztecWriter() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static BitMatrix renderResult(AztecCode aztecCode, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65539, null, aztecCode, i2, i3)) == null) {
            BitMatrix matrix = aztecCode.getMatrix();
            if (matrix != null) {
                int width = matrix.getWidth();
                int height = matrix.getHeight();
                int max = Math.max(i2, width);
                int max2 = Math.max(i3, height);
                int min = Math.min(max / width, max2 / height);
                int i4 = (max - (width * min)) / 2;
                int i5 = (max2 - (height * min)) / 2;
                BitMatrix bitMatrix = new BitMatrix(max, max2);
                int i6 = 0;
                while (i6 < height) {
                    int i7 = i4;
                    int i8 = 0;
                    while (i8 < width) {
                        if (matrix.get(i8, i6)) {
                            bitMatrix.setRegion(i7, i5, min, min);
                        }
                        i8++;
                        i7 += min;
                    }
                    i6++;
                    i5 += min;
                }
                return bitMatrix;
            }
            throw new IllegalStateException();
        }
        return (BitMatrix) invokeLII.objValue;
    }

    @Override // com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048576, this, str, barcodeFormat, i2, i3)) == null) ? encode(str, barcodeFormat, i2, i3, null) : (BitMatrix) invokeLLII.objValue;
    }

    @Override // com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i2, int i3, Map<EncodeHintType, ?> map) {
        InterceptResult invokeCommon;
        Charset charset;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, barcodeFormat, Integer.valueOf(i2), Integer.valueOf(i3), map})) == null) {
            Charset charset2 = DEFAULT_CHARSET;
            if (map != null) {
                if (map.containsKey(EncodeHintType.CHARACTER_SET)) {
                    charset2 = Charset.forName(map.get(EncodeHintType.CHARACTER_SET).toString());
                }
                int parseInt = map.containsKey(EncodeHintType.ERROR_CORRECTION) ? Integer.parseInt(map.get(EncodeHintType.ERROR_CORRECTION).toString()) : 33;
                if (map.containsKey(EncodeHintType.AZTEC_LAYERS)) {
                    charset = charset2;
                    i4 = parseInt;
                    i5 = Integer.parseInt(map.get(EncodeHintType.AZTEC_LAYERS).toString());
                    return encode(str, barcodeFormat, i2, i3, charset, i4, i5);
                }
                charset = charset2;
                i4 = parseInt;
            } else {
                charset = charset2;
                i4 = 33;
            }
            i5 = 0;
            return encode(str, barcodeFormat, i2, i3, charset, i4, i5);
        }
        return (BitMatrix) invokeCommon.objValue;
    }

    public static BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i2, int i3, Charset charset, int i4, int i5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{str, barcodeFormat, Integer.valueOf(i2), Integer.valueOf(i3), charset, Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
            if (barcodeFormat == BarcodeFormat.AZTEC) {
                return renderResult(Encoder.encode(str.getBytes(charset), i4, i5), i2, i3);
            }
            throw new IllegalArgumentException("Can only encode AZTEC, but got " + barcodeFormat);
        }
        return (BitMatrix) invokeCommon.objValue;
    }
}
