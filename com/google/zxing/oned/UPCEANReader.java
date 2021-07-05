package com.google.zxing.oned;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitArray;
import java.util.Arrays;
import java.util.Map;
/* loaded from: classes7.dex */
public abstract class UPCEANReader extends OneDReader {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int[] END_PATTERN;
    public static final int[][] L_AND_G_PATTERNS;
    public static final int[][] L_PATTERNS;
    public static final float MAX_AVG_VARIANCE = 0.48f;
    public static final float MAX_INDIVIDUAL_VARIANCE = 0.7f;
    public static final int[] MIDDLE_PATTERN;
    public static final int[] START_END_PATTERN;
    public transient /* synthetic */ FieldHolder $fh;
    public final StringBuilder decodeRowStringBuffer;
    public final EANManufacturerOrgSupport eanManSupport;
    public final UPCEANExtensionSupport extensionReader;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1184608388, "Lcom/google/zxing/oned/UPCEANReader;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1184608388, "Lcom/google/zxing/oned/UPCEANReader;");
                return;
            }
        }
        START_END_PATTERN = new int[]{1, 1, 1};
        MIDDLE_PATTERN = new int[]{1, 1, 1, 1, 1};
        END_PATTERN = new int[]{1, 1, 1, 1, 1, 1};
        int[][] iArr = {new int[]{3, 2, 1, 1}, new int[]{2, 2, 2, 1}, new int[]{2, 1, 2, 2}, new int[]{1, 4, 1, 1}, new int[]{1, 1, 3, 2}, new int[]{1, 2, 3, 1}, new int[]{1, 1, 1, 4}, new int[]{1, 3, 1, 2}, new int[]{1, 2, 1, 3}, new int[]{3, 1, 1, 2}};
        L_PATTERNS = iArr;
        int[][] iArr2 = new int[20];
        L_AND_G_PATTERNS = iArr2;
        System.arraycopy(iArr, 0, iArr2, 0, 10);
        for (int i2 = 10; i2 < 20; i2++) {
            int[] iArr3 = L_PATTERNS[i2 - 10];
            int[] iArr4 = new int[iArr3.length];
            for (int i3 = 0; i3 < iArr3.length; i3++) {
                iArr4[i3] = iArr3[(iArr3.length - i3) - 1];
            }
            L_AND_G_PATTERNS[i2] = iArr4;
        }
    }

    public UPCEANReader() {
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
        this.decodeRowStringBuffer = new StringBuilder(20);
        this.extensionReader = new UPCEANExtensionSupport();
        this.eanManSupport = new EANManufacturerOrgSupport();
    }

    public static boolean checkStandardUPCEANChecksum(CharSequence charSequence) throws FormatException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, charSequence)) == null) {
            int length = charSequence.length();
            if (length == 0) {
                return false;
            }
            int i2 = 0;
            for (int i3 = length - 2; i3 >= 0; i3 -= 2) {
                int charAt = charSequence.charAt(i3) - '0';
                if (charAt < 0 || charAt > 9) {
                    throw FormatException.getFormatInstance();
                }
                i2 += charAt;
            }
            int i4 = i2 * 3;
            for (int i5 = length - 1; i5 >= 0; i5 -= 2) {
                int charAt2 = charSequence.charAt(i5) - '0';
                if (charAt2 < 0 || charAt2 > 9) {
                    throw FormatException.getFormatInstance();
                }
                i4 += charAt2;
            }
            return i4 % 10 == 0;
        }
        return invokeL.booleanValue;
    }

    public static int decodeDigit(BitArray bitArray, int[] iArr, int i2, int[][] iArr2) throws NotFoundException {
        InterceptResult invokeLLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(65539, null, bitArray, iArr, i2, iArr2)) == null) {
            OneDReader.recordPattern(bitArray, i2, iArr);
            int length = iArr2.length;
            float f2 = 0.48f;
            int i3 = -1;
            for (int i4 = 0; i4 < length; i4++) {
                float patternMatchVariance = OneDReader.patternMatchVariance(iArr, iArr2[i4], 0.7f);
                if (patternMatchVariance < f2) {
                    i3 = i4;
                    f2 = patternMatchVariance;
                }
            }
            if (i3 >= 0) {
                return i3;
            }
            throw NotFoundException.getNotFoundInstance();
        }
        return invokeLLIL.intValue;
    }

    public static int[] findGuardPattern(BitArray bitArray, int i2, boolean z, int[] iArr) throws NotFoundException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65540, null, new Object[]{bitArray, Integer.valueOf(i2), Boolean.valueOf(z), iArr})) == null) ? findGuardPattern(bitArray, i2, z, iArr, new int[iArr.length]) : (int[]) invokeCommon.objValue;
    }

    public static int[] findStartGuardPattern(BitArray bitArray) throws NotFoundException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, bitArray)) == null) {
            int[] iArr = new int[START_END_PATTERN.length];
            int[] iArr2 = null;
            boolean z = false;
            int i2 = 0;
            while (!z) {
                Arrays.fill(iArr, 0, START_END_PATTERN.length, 0);
                iArr2 = findGuardPattern(bitArray, i2, false, START_END_PATTERN, iArr);
                int i3 = iArr2[0];
                int i4 = iArr2[1];
                int i5 = i3 - (i4 - i3);
                if (i5 >= 0) {
                    z = bitArray.isRange(i5, i3, false);
                }
                i2 = i4;
            }
            return iArr2;
        }
        return (int[]) invokeL.objValue;
    }

    public boolean checkChecksum(String str) throws FormatException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? checkStandardUPCEANChecksum(str) : invokeL.booleanValue;
    }

    public int[] decodeEnd(BitArray bitArray, int i2) throws NotFoundException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitArray, i2)) == null) ? findGuardPattern(bitArray, i2, false, START_END_PATTERN) : (int[]) invokeLI.objValue;
    }

    public abstract int decodeMiddle(BitArray bitArray, int[] iArr, StringBuilder sb) throws NotFoundException;

    @Override // com.google.zxing.oned.OneDReader
    public Result decodeRow(int i2, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeILL = interceptable.invokeILL(1048579, this, i2, bitArray, map)) == null) ? decodeRow(i2, bitArray, findStartGuardPattern(bitArray), map) : (Result) invokeILL.objValue;
    }

    public abstract BarcodeFormat getBarcodeFormat();

    public static int[] findGuardPattern(BitArray bitArray, int i2, boolean z, int[] iArr, int[] iArr2) throws NotFoundException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{bitArray, Integer.valueOf(i2), Boolean.valueOf(z), iArr, iArr2})) == null) {
            int size = bitArray.getSize();
            int nextUnset = z ? bitArray.getNextUnset(i2) : bitArray.getNextSet(i2);
            int length = iArr.length;
            boolean z2 = z;
            int i3 = 0;
            int i4 = nextUnset;
            while (nextUnset < size) {
                if (bitArray.get(nextUnset) ^ z2) {
                    iArr2[i3] = iArr2[i3] + 1;
                } else {
                    int i5 = length - 1;
                    if (i3 != i5) {
                        i3++;
                    } else if (OneDReader.patternMatchVariance(iArr2, iArr, 0.7f) < 0.48f) {
                        return new int[]{i4, nextUnset};
                    } else {
                        i4 += iArr2[0] + iArr2[1];
                        int i6 = length - 2;
                        System.arraycopy(iArr2, 2, iArr2, 0, i6);
                        iArr2[i6] = 0;
                        iArr2[i5] = 0;
                        i3--;
                    }
                    iArr2[i3] = 1;
                    z2 = !z2;
                }
                nextUnset++;
            }
            throw NotFoundException.getNotFoundInstance();
        }
        return (int[]) invokeCommon.objValue;
    }

    public Result decodeRow(int i2, BitArray bitArray, int[] iArr, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        InterceptResult invokeCommon;
        int i3;
        String lookupCountryIdentifier;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), bitArray, iArr, map})) == null) {
            ResultPointCallback resultPointCallback = map == null ? null : (ResultPointCallback) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
            boolean z = true;
            if (resultPointCallback != null) {
                resultPointCallback.foundPossibleResultPoint(new ResultPoint((iArr[0] + iArr[1]) / 2.0f, i2));
            }
            StringBuilder sb = this.decodeRowStringBuffer;
            sb.setLength(0);
            int decodeMiddle = decodeMiddle(bitArray, iArr, sb);
            if (resultPointCallback != null) {
                resultPointCallback.foundPossibleResultPoint(new ResultPoint(decodeMiddle, i2));
            }
            int[] decodeEnd = decodeEnd(bitArray, decodeMiddle);
            if (resultPointCallback != null) {
                resultPointCallback.foundPossibleResultPoint(new ResultPoint((decodeEnd[0] + decodeEnd[1]) / 2.0f, i2));
            }
            int i4 = decodeEnd[1];
            int i5 = (i4 - decodeEnd[0]) + i4;
            if (i5 < bitArray.getSize() && bitArray.isRange(i4, i5, false)) {
                String sb2 = sb.toString();
                if (sb2.length() >= 8) {
                    if (checkChecksum(sb2)) {
                        BarcodeFormat barcodeFormat = getBarcodeFormat();
                        float f2 = i2;
                        Result result = new Result(sb2, null, new ResultPoint[]{new ResultPoint((iArr[1] + iArr[0]) / 2.0f, f2), new ResultPoint((decodeEnd[1] + decodeEnd[0]) / 2.0f, f2)}, barcodeFormat);
                        try {
                            Result decodeRow = this.extensionReader.decodeRow(i2, bitArray, decodeEnd[1]);
                            result.putMetadata(ResultMetadataType.UPC_EAN_EXTENSION, decodeRow.getText());
                            result.putAllMetadata(decodeRow.getResultMetadata());
                            result.addResultPoints(decodeRow.getResultPoints());
                            i3 = decodeRow.getText().length();
                        } catch (ReaderException unused) {
                            i3 = 0;
                        }
                        int[] iArr2 = map != null ? (int[]) map.get(DecodeHintType.ALLOWED_EAN_EXTENSIONS) : null;
                        if (iArr2 != null) {
                            int length = iArr2.length;
                            int i6 = 0;
                            while (true) {
                                if (i6 >= length) {
                                    z = false;
                                    break;
                                } else if (i3 == iArr2[i6]) {
                                    break;
                                } else {
                                    i6++;
                                }
                            }
                            if (!z) {
                                throw NotFoundException.getNotFoundInstance();
                            }
                        }
                        if ((barcodeFormat == BarcodeFormat.EAN_13 || barcodeFormat == BarcodeFormat.UPC_A) && (lookupCountryIdentifier = this.eanManSupport.lookupCountryIdentifier(sb2)) != null) {
                            result.putMetadata(ResultMetadataType.POSSIBLE_COUNTRY, lookupCountryIdentifier);
                        }
                        return result;
                    }
                    throw ChecksumException.getChecksumInstance();
                }
                throw FormatException.getFormatInstance();
            }
            throw NotFoundException.getNotFoundInstance();
        }
        return (Result) invokeCommon.objValue;
    }
}
