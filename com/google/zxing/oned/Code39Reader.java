package com.google.zxing.oned;

import androidx.core.view.InputDeviceCompat;
import com.baidu.location.BDLocation;
import com.baidu.pass.face.platform.utils.FileUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.titan.sdk.verifier.ApkSignatureSchemeV2Verifier;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import com.google.zxing.maxicode.decoder.DecodedBitStreamParser;
import java.util.Arrays;
import java.util.Map;
/* loaded from: classes5.dex */
public final class Code39Reader extends OneDReader {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ALPHABET_STRING = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%";
    public static final int ASTERISK_ENCODING;
    public static final int[] CHARACTER_ENCODINGS;
    public static final String CHECK_DIGIT_STRING = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%";
    public transient /* synthetic */ FieldHolder $fh;
    public final int[] counters;
    public final StringBuilder decodeRowResult;
    public final boolean extendedMode;
    public final boolean usingCheckDigit;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1990545317, "Lcom/google/zxing/oned/Code39Reader;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1990545317, "Lcom/google/zxing/oned/Code39Reader;");
                return;
            }
        }
        int[] iArr = {52, 289, 97, 352, 49, 304, 112, 37, 292, 100, 265, 73, 328, 25, 280, 88, 13, 268, 76, 28, ApkSignatureSchemeV2Verifier.SIGNATURE_RSA_PKCS1_V1_5_WITH_SHA256, 67, 322, 19, 274, 82, 7, 262, 70, 22, 385, 193, FileUtils.S_IRWXU, Cea708Decoder.COMMAND_SPC, 400, 208, 133, 388, 196, 148, 168, BDLocation.TypeServerDecryptError, 138, 42};
        CHARACTER_ENCODINGS = iArr;
        ASTERISK_ENCODING = iArr[39];
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Code39Reader() {
        this(false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this(((Boolean) newInitContext.callArgs[0]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static String decodeExtended(CharSequence charSequence) throws FormatException {
        InterceptResult invokeL;
        int i;
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, charSequence)) == null) {
            int length = charSequence.length();
            StringBuilder sb = new StringBuilder(length);
            int i2 = 0;
            while (i2 < length) {
                char charAt = charSequence.charAt(i2);
                if (charAt != '+' && charAt != '$' && charAt != '%' && charAt != '/') {
                    sb.append(charAt);
                } else {
                    i2++;
                    char charAt2 = charSequence.charAt(i2);
                    if (charAt != '$') {
                        if (charAt != '%') {
                            if (charAt != '+') {
                                if (charAt != '/') {
                                    c = 0;
                                } else if (charAt2 >= 'A' && charAt2 <= 'O') {
                                    i = charAt2 - ' ';
                                } else if (charAt2 != 'Z') {
                                    throw FormatException.getFormatInstance();
                                } else {
                                    c = ':';
                                }
                                sb.append(c);
                            } else if (charAt2 < 'A' || charAt2 > 'Z') {
                                throw FormatException.getFormatInstance();
                            } else {
                                i = charAt2 + WebvttCueParser.CHAR_SPACE;
                            }
                        } else if (charAt2 >= 'A' && charAt2 <= 'E') {
                            i = charAt2 - '&';
                        } else if (charAt2 < 'F' || charAt2 > 'W') {
                            throw FormatException.getFormatInstance();
                        } else {
                            i = charAt2 + DecodedBitStreamParser.TWOSHIFTA;
                        }
                    } else if (charAt2 < 'A' || charAt2 > 'Z') {
                        throw FormatException.getFormatInstance();
                    } else {
                        i = charAt2 - '@';
                    }
                    c = (char) i;
                    sb.append(c);
                }
                i2++;
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static int[] findAsteriskPattern(BitArray bitArray, int[] iArr) throws NotFoundException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, bitArray, iArr)) == null) {
            int size = bitArray.getSize();
            int nextSet = bitArray.getNextSet(0);
            int length = iArr.length;
            int i = nextSet;
            boolean z = false;
            int i2 = 0;
            while (nextSet < size) {
                if (bitArray.get(nextSet) ^ z) {
                    iArr[i2] = iArr[i2] + 1;
                } else {
                    int i3 = length - 1;
                    if (i2 != i3) {
                        i2++;
                    } else if (toNarrowWidePattern(iArr) == ASTERISK_ENCODING && bitArray.isRange(Math.max(0, i - ((nextSet - i) / 2)), i, false)) {
                        return new int[]{i, nextSet};
                    } else {
                        i += iArr[0] + iArr[1];
                        int i4 = length - 2;
                        System.arraycopy(iArr, 2, iArr, 0, i4);
                        iArr[i4] = 0;
                        iArr[i3] = 0;
                        i2--;
                    }
                    iArr[i2] = 1;
                    z = !z;
                }
                nextSet++;
            }
            throw NotFoundException.getNotFoundInstance();
        }
        return (int[]) invokeLL.objValue;
    }

    public static char patternToChar(int i) throws NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeI = interceptable.invokeI(65542, null, i)) != null) {
            return invokeI.charValue;
        }
        int i2 = 0;
        while (true) {
            int[] iArr = CHARACTER_ENCODINGS;
            if (i2 < iArr.length) {
                if (iArr[i2] == i) {
                    return ALPHABET_STRING.charAt(i2);
                }
                i2++;
            } else {
                throw NotFoundException.getNotFoundInstance();
            }
        }
    }

    public static int toNarrowWidePattern(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65543, null, iArr)) != null) {
            return invokeL.intValue;
        }
        int length = iArr.length;
        int i = 0;
        while (true) {
            int i2 = Integer.MAX_VALUE;
            for (int i3 : iArr) {
                if (i3 < i2 && i3 > i) {
                    i2 = i3;
                }
            }
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < length; i7++) {
                int i8 = iArr[i7];
                if (i8 > i2) {
                    i5 |= 1 << ((length - 1) - i7);
                    i4++;
                    i6 += i8;
                }
            }
            if (i4 == 3) {
                for (int i9 = 0; i9 < length && i4 > 0; i9++) {
                    int i10 = iArr[i9];
                    if (i10 > i2) {
                        i4--;
                        if ((i10 << 1) >= i6) {
                            return -1;
                        }
                    }
                }
                return i5;
            } else if (i4 <= 3) {
                return -1;
            } else {
                i = i2;
            }
        }
    }

    @Override // com.google.zxing.oned.OneDReader
    public Result decodeRow(int i, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        InterceptResult invokeILL;
        int[] findAsteriskPattern;
        String sb;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeILL = interceptable.invokeILL(1048576, this, i, bitArray, map)) != null) {
            return (Result) invokeILL.objValue;
        }
        int[] iArr = this.counters;
        Arrays.fill(iArr, 0);
        StringBuilder sb2 = this.decodeRowResult;
        sb2.setLength(0);
        int nextSet = bitArray.getNextSet(findAsteriskPattern(bitArray, iArr)[1]);
        int size = bitArray.getSize();
        while (true) {
            OneDReader.recordPattern(bitArray, nextSet, iArr);
            int narrowWidePattern = toNarrowWidePattern(iArr);
            if (narrowWidePattern >= 0) {
                char patternToChar = patternToChar(narrowWidePattern);
                sb2.append(patternToChar);
                int i2 = nextSet;
                for (int i3 : iArr) {
                    i2 += i3;
                }
                int nextSet2 = bitArray.getNextSet(i2);
                if (patternToChar == '*') {
                    sb2.setLength(sb2.length() - 1);
                    int i4 = 0;
                    for (int i5 : iArr) {
                        i4 += i5;
                    }
                    int i6 = (nextSet2 - nextSet) - i4;
                    if (nextSet2 != size && (i6 << 1) < i4) {
                        throw NotFoundException.getNotFoundInstance();
                    }
                    if (this.usingCheckDigit) {
                        int length = sb2.length() - 1;
                        int i7 = 0;
                        for (int i8 = 0; i8 < length; i8++) {
                            i7 += CHECK_DIGIT_STRING.indexOf(this.decodeRowResult.charAt(i8));
                        }
                        if (sb2.charAt(length) == CHECK_DIGIT_STRING.charAt(i7 % 43)) {
                            sb2.setLength(length);
                        } else {
                            throw ChecksumException.getChecksumInstance();
                        }
                    }
                    if (sb2.length() != 0) {
                        if (this.extendedMode) {
                            sb = decodeExtended(sb2);
                        } else {
                            sb = sb2.toString();
                        }
                        float f = i;
                        return new Result(sb, null, new ResultPoint[]{new ResultPoint((findAsteriskPattern[1] + findAsteriskPattern[0]) / 2.0f, f), new ResultPoint(nextSet + (i4 / 2.0f), f)}, BarcodeFormat.CODE_39);
                    }
                    throw NotFoundException.getNotFoundInstance();
                }
                nextSet = nextSet2;
            } else {
                throw NotFoundException.getNotFoundInstance();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Code39Reader(boolean z) {
        this(z, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Boolean) objArr2[0]).booleanValue(), ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public Code39Reader(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.usingCheckDigit = z;
        this.extendedMode = z2;
        this.decodeRowResult = new StringBuilder(20);
        this.counters = new int[9];
    }
}
