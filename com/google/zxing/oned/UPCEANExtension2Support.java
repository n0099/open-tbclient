package com.google.zxing.oned;

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
/* loaded from: classes5.dex */
public final class UPCEANExtension2Support {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int[] decodeMiddleCounters;
    public final StringBuilder decodeRowStringBuffer;

    public UPCEANExtension2Support() {
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
        this.decodeMiddleCounters = new int[4];
        this.decodeRowStringBuffer = new StringBuilder();
    }

    private int decodeMiddle(BitArray bitArray, int[] iArr, StringBuilder sb) throws NotFoundException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, this, bitArray, iArr, sb)) == null) {
            int[] iArr2 = this.decodeMiddleCounters;
            iArr2[0] = 0;
            iArr2[1] = 0;
            iArr2[2] = 0;
            iArr2[3] = 0;
            int size = bitArray.getSize();
            int i = iArr[1];
            int i2 = 0;
            for (int i3 = 0; i3 < 2 && i < size; i3++) {
                int decodeDigit = UPCEANReader.decodeDigit(bitArray, iArr2, i, UPCEANReader.L_AND_G_PATTERNS);
                sb.append((char) ((decodeDigit % 10) + 48));
                for (int i4 : iArr2) {
                    i += i4;
                }
                if (decodeDigit >= 10) {
                    i2 |= 1 << (1 - i3);
                }
                if (i3 != 1) {
                    i = bitArray.getNextUnset(bitArray.getNextSet(i));
                }
            }
            if (sb.length() == 2) {
                if (Integer.parseInt(sb.toString()) % 4 == i2) {
                    return i;
                }
                throw NotFoundException.getNotFoundInstance();
            }
            throw NotFoundException.getNotFoundInstance();
        }
        return invokeLLL.intValue;
    }

    public static Map<ResultMetadataType, Object> parseExtensionString(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (str.length() != 2) {
                return null;
            }
            EnumMap enumMap = new EnumMap(ResultMetadataType.class);
            enumMap.put((EnumMap) ResultMetadataType.ISSUE_NUMBER, (ResultMetadataType) Integer.valueOf(str));
            return enumMap;
        }
        return (Map) invokeL.objValue;
    }

    public Result decodeRow(int i, BitArray bitArray, int[] iArr) throws NotFoundException {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048576, this, i, bitArray, iArr)) == null) {
            StringBuilder sb = this.decodeRowStringBuffer;
            sb.setLength(0);
            int decodeMiddle = decodeMiddle(bitArray, iArr, sb);
            String sb2 = sb.toString();
            Map<ResultMetadataType, Object> parseExtensionString = parseExtensionString(sb2);
            float f = i;
            Result result = new Result(sb2, null, new ResultPoint[]{new ResultPoint((iArr[0] + iArr[1]) / 2.0f, f), new ResultPoint(decodeMiddle, f)}, BarcodeFormat.UPC_EAN_EXTENSION);
            if (parseExtensionString != null) {
                result.putAllMetadata(parseExtensionString);
            }
            return result;
        }
        return (Result) invokeILL.objValue;
    }
}
