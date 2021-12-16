package com.google.zxing.oned;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.EnumMap;
import java.util.Map;
/* loaded from: classes3.dex */
public final class UPCEANExtension5Support {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] CHECK_DIGIT_ENCODINGS;
    public transient /* synthetic */ FieldHolder $fh;
    public final int[] decodeMiddleCounters;
    public final StringBuilder decodeRowStringBuffer;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1736917014, "Lcom/google/zxing/oned/UPCEANExtension5Support;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1736917014, "Lcom/google/zxing/oned/UPCEANExtension5Support;");
                return;
            }
        }
        CHECK_DIGIT_ENCODINGS = new int[]{24, 20, 18, 17, 12, 6, 3, 10, 9, 5};
    }

    public UPCEANExtension5Support() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.decodeMiddleCounters = new int[4];
        this.decodeRowStringBuffer = new StringBuilder();
    }

    private int decodeMiddle(BitArray bitArray, int[] iArr, StringBuilder sb) throws NotFoundException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, this, bitArray, iArr, sb)) == null) {
            int[] iArr2 = this.decodeMiddleCounters;
            iArr2[0] = 0;
            iArr2[1] = 0;
            iArr2[2] = 0;
            iArr2[3] = 0;
            int size = bitArray.getSize();
            int i2 = iArr[1];
            int i3 = 0;
            for (int i4 = 0; i4 < 5 && i2 < size; i4++) {
                int decodeDigit = UPCEANReader.decodeDigit(bitArray, iArr2, i2, UPCEANReader.L_AND_G_PATTERNS);
                sb.append((char) ((decodeDigit % 10) + 48));
                for (int i5 : iArr2) {
                    i2 += i5;
                }
                if (decodeDigit >= 10) {
                    i3 |= 1 << (4 - i4);
                }
                if (i4 != 4) {
                    i2 = bitArray.getNextUnset(bitArray.getNextSet(i2));
                }
            }
            if (sb.length() == 5) {
                if (extensionChecksum(sb.toString()) == determineCheckDigit(i3)) {
                    return i2;
                }
                throw NotFoundException.getNotFoundInstance();
            }
            throw NotFoundException.getNotFoundInstance();
        }
        return invokeLLL.intValue;
    }

    public static int determineCheckDigit(int i2) throws NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) {
            for (int i3 = 0; i3 < 10; i3++) {
                if (i2 == CHECK_DIGIT_ENCODINGS[i3]) {
                    return i3;
                }
            }
            throw NotFoundException.getNotFoundInstance();
        }
        return invokeI.intValue;
    }

    public static int extensionChecksum(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, charSequence)) == null) {
            int length = charSequence.length();
            int i2 = 0;
            for (int i3 = length - 2; i3 >= 0; i3 -= 2) {
                i2 += charSequence.charAt(i3) - '0';
            }
            int i4 = i2 * 3;
            for (int i5 = length - 1; i5 >= 0; i5 -= 2) {
                i4 += charSequence.charAt(i5) - '0';
            }
            return (i4 * 3) % 10;
        }
        return invokeL.intValue;
    }

    public static String parseExtension5String(String str) {
        InterceptResult invokeL;
        String valueOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            char charAt = str.charAt(0);
            String str2 = "";
            if (charAt == '0') {
                str2 = "£";
            } else if (charAt == '5') {
                str2 = "$";
            } else if (charAt == '9') {
                if ("90000".equals(str)) {
                    return null;
                }
                if ("99991".equals(str)) {
                    return "0.00";
                }
                if ("99990".equals(str)) {
                    return "Used";
                }
            }
            int parseInt = Integer.parseInt(str.substring(1));
            String valueOf2 = String.valueOf(parseInt / 100);
            int i2 = parseInt % 100;
            if (i2 < 10) {
                valueOf = "0" + i2;
            } else {
                valueOf = String.valueOf(i2);
            }
            return str2 + valueOf2 + '.' + valueOf;
        }
        return (String) invokeL.objValue;
    }

    public static Map<ResultMetadataType, Object> parseExtensionString(String str) {
        InterceptResult invokeL;
        String parseExtension5String;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            if (str.length() == 5 && (parseExtension5String = parseExtension5String(str)) != null) {
                EnumMap enumMap = new EnumMap(ResultMetadataType.class);
                enumMap.put((EnumMap) ResultMetadataType.SUGGESTED_PRICE, (ResultMetadataType) parseExtension5String);
                return enumMap;
            }
            return null;
        }
        return (Map) invokeL.objValue;
    }

    public Result decodeRow(int i2, BitArray bitArray, int[] iArr) throws NotFoundException {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048576, this, i2, bitArray, iArr)) == null) {
            StringBuilder sb = this.decodeRowStringBuffer;
            sb.setLength(0);
            int decodeMiddle = decodeMiddle(bitArray, iArr, sb);
            String sb2 = sb.toString();
            Map<ResultMetadataType, Object> parseExtensionString = parseExtensionString(sb2);
            float f2 = i2;
            Result result = new Result(sb2, null, new ResultPoint[]{new ResultPoint((iArr[0] + iArr[1]) / 2.0f, f2), new ResultPoint(decodeMiddle, f2)}, BarcodeFormat.UPC_EAN_EXTENSION);
            if (parseExtensionString != null) {
                result.putAllMetadata(parseExtensionString);
            }
            return result;
        }
        return (Result) invokeILL.objValue;
    }
}
