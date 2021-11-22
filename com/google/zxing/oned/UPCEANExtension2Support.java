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
/* loaded from: classes11.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            int i2 = iArr[1];
            int i3 = 0;
            for (int i4 = 0; i4 < 2 && i2 < size; i4++) {
                int decodeDigit = UPCEANReader.decodeDigit(bitArray, iArr2, i2, UPCEANReader.L_AND_G_PATTERNS);
                sb.append((char) ((decodeDigit % 10) + 48));
                for (int i5 : iArr2) {
                    i2 += i5;
                }
                if (decodeDigit >= 10) {
                    i3 |= 1 << (1 - i4);
                }
                if (i4 != 1) {
                    i2 = bitArray.getNextUnset(bitArray.getNextSet(i2));
                }
            }
            if (sb.length() == 2) {
                if (Integer.parseInt(sb.toString()) % 4 == i3) {
                    return i2;
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
