package com.google.zxing.oned;

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
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;
/* loaded from: classes10.dex */
public final class ITFWriter extends OneDimensionalCodeWriter {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] END_PATTERN;
    public static final int[] START_PATTERN;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(758550455, "Lcom/google/zxing/oned/ITFWriter;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(758550455, "Lcom/google/zxing/oned/ITFWriter;");
                return;
            }
        }
        START_PATTERN = new int[]{1, 1, 1, 1};
        END_PATTERN = new int[]{3, 1, 1};
    }

    public ITFWriter() {
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

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter, com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i2, int i3, Map<EncodeHintType, ?> map) throws WriterException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, barcodeFormat, Integer.valueOf(i2), Integer.valueOf(i3), map})) == null) {
            if (barcodeFormat == BarcodeFormat.ITF) {
                return super.encode(str, barcodeFormat, i2, i3, map);
            }
            throw new IllegalArgumentException("Can only encode ITF, but got " + barcodeFormat);
        }
        return (BitMatrix) invokeCommon.objValue;
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public boolean[] encode(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            int length = str.length();
            if (length % 2 == 0) {
                if (length <= 80) {
                    boolean[] zArr = new boolean[(length * 9) + 9];
                    int appendPattern = OneDimensionalCodeWriter.appendPattern(zArr, 0, START_PATTERN, true);
                    for (int i2 = 0; i2 < length; i2 += 2) {
                        int digit = Character.digit(str.charAt(i2), 10);
                        int digit2 = Character.digit(str.charAt(i2 + 1), 10);
                        int[] iArr = new int[18];
                        for (int i3 = 0; i3 < 5; i3++) {
                            int i4 = i3 * 2;
                            int[][] iArr2 = ITFReader.PATTERNS;
                            iArr[i4] = iArr2[digit][i3];
                            iArr[i4 + 1] = iArr2[digit2][i3];
                        }
                        appendPattern += OneDimensionalCodeWriter.appendPattern(zArr, appendPattern, iArr, true);
                    }
                    OneDimensionalCodeWriter.appendPattern(zArr, appendPattern, END_PATTERN, true);
                    return zArr;
                }
                throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length);
            }
            throw new IllegalArgumentException("The length of the input should be even");
        }
        return (boolean[]) invokeL.objValue;
    }
}
