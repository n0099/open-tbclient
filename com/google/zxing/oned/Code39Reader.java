package com.google.zxing.oned;

import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobads.container.widget.player.PlayerEvent;
import com.baidu.pass.face.platform.utils.FileUtils;
import com.baidu.searchbox.live.interfaces.player.VideoInfoConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.qrcodescanner.QRScanCodeActivity;
import com.google.ar.core.InstallActivity;
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
/* loaded from: classes11.dex */
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
        int[] iArr = {52, QRScanCodeActivity.DIALOG_TXT_COPY, 97, VideoInfoConstants.VIDEO_MPD_VID, 49, 304, 112, 37, 292, 100, 265, 73, 328, 25, InstallActivity.BOX_SIZE_DP, 88, 13, 268, 76, 28, 259, 67, 322, 19, 274, 82, 7, PlayerEvent.PLAY_LOADING_END, 70, 22, 385, 193, FileUtils.S_IRWXU, 145, 400, 208, 133, 388, 196, Opcodes.LCMP, 168, 162, 138, 42};
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this(((Boolean) newInitContext.callArgs[0]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static String decodeExtended(CharSequence charSequence) throws FormatException {
        InterceptResult invokeL;
        int i2;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, charSequence)) == null) {
            int length = charSequence.length();
            StringBuilder sb = new StringBuilder(length);
            int i3 = 0;
            while (i3 < length) {
                char charAt = charSequence.charAt(i3);
                if (charAt != '+' && charAt != '$' && charAt != '%' && charAt != '/') {
                    sb.append(charAt);
                } else {
                    i3++;
                    char charAt2 = charSequence.charAt(i3);
                    if (charAt != '$') {
                        if (charAt != '%') {
                            if (charAt != '+') {
                                if (charAt != '/') {
                                    c2 = 0;
                                } else if (charAt2 >= 'A' && charAt2 <= 'O') {
                                    i2 = charAt2 - ' ';
                                } else if (charAt2 != 'Z') {
                                    throw FormatException.getFormatInstance();
                                } else {
                                    c2 = ':';
                                }
                                sb.append(c2);
                            } else if (charAt2 < 'A' || charAt2 > 'Z') {
                                throw FormatException.getFormatInstance();
                            } else {
                                i2 = charAt2 + ' ';
                            }
                        } else if (charAt2 >= 'A' && charAt2 <= 'E') {
                            i2 = charAt2 - '&';
                        } else if (charAt2 < 'F' || charAt2 > 'W') {
                            throw FormatException.getFormatInstance();
                        } else {
                            i2 = charAt2 + DecodedBitStreamParser.TWOSHIFTA;
                        }
                    } else if (charAt2 < 'A' || charAt2 > 'Z') {
                        throw FormatException.getFormatInstance();
                    } else {
                        i2 = charAt2 - '@';
                    }
                    c2 = (char) i2;
                    sb.append(c2);
                }
                i3++;
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static int[] findAsteriskPattern(BitArray bitArray, int[] iArr) throws NotFoundException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, bitArray, iArr)) == null) {
            int size = bitArray.getSize();
            int nextSet = bitArray.getNextSet(0);
            int length = iArr.length;
            int i2 = nextSet;
            boolean z = false;
            int i3 = 0;
            while (nextSet < size) {
                if (bitArray.get(nextSet) ^ z) {
                    iArr[i3] = iArr[i3] + 1;
                } else {
                    int i4 = length - 1;
                    if (i3 != i4) {
                        i3++;
                    } else if (toNarrowWidePattern(iArr) == ASTERISK_ENCODING && bitArray.isRange(Math.max(0, i2 - ((nextSet - i2) / 2)), i2, false)) {
                        return new int[]{i2, nextSet};
                    } else {
                        i2 += iArr[0] + iArr[1];
                        int i5 = length - 2;
                        System.arraycopy(iArr, 2, iArr, 0, i5);
                        iArr[i5] = 0;
                        iArr[i4] = 0;
                        i3--;
                    }
                    iArr[i3] = 1;
                    z = !z;
                }
                nextSet++;
            }
            throw NotFoundException.getNotFoundInstance();
        }
        return (int[]) invokeLL.objValue;
    }

    public static char patternToChar(int i2) throws NotFoundException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeI = interceptable.invokeI(AdIconUtil.BAIDU_LOGO_ID, null, i2)) != null) {
            return invokeI.charValue;
        }
        int i3 = 0;
        while (true) {
            int[] iArr = CHARACTER_ENCODINGS;
            if (i3 < iArr.length) {
                if (iArr[i3] == i2) {
                    return ALPHABET_STRING.charAt(i3);
                }
                i3++;
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
        int i2 = 0;
        while (true) {
            int i3 = Integer.MAX_VALUE;
            for (int i4 : iArr) {
                if (i4 < i3 && i4 > i2) {
                    i3 = i4;
                }
            }
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            for (int i8 = 0; i8 < length; i8++) {
                int i9 = iArr[i8];
                if (i9 > i3) {
                    i6 |= 1 << ((length - 1) - i8);
                    i5++;
                    i7 += i9;
                }
            }
            if (i5 == 3) {
                for (int i10 = 0; i10 < length && i5 > 0; i10++) {
                    int i11 = iArr[i10];
                    if (i11 > i3) {
                        i5--;
                        if ((i11 << 1) >= i7) {
                            return -1;
                        }
                    }
                }
                return i6;
            } else if (i5 <= 3) {
                return -1;
            } else {
                i2 = i3;
            }
        }
    }

    @Override // com.google.zxing.oned.OneDReader
    public Result decodeRow(int i2, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        InterceptResult invokeILL;
        int[] findAsteriskPattern;
        String sb;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeILL = interceptable.invokeILL(1048576, this, i2, bitArray, map)) != null) {
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
                int i3 = nextSet;
                for (int i4 : iArr) {
                    i3 += i4;
                }
                int nextSet2 = bitArray.getNextSet(i3);
                if (patternToChar == '*') {
                    sb2.setLength(sb2.length() - 1);
                    int i5 = 0;
                    for (int i6 : iArr) {
                        i5 += i6;
                    }
                    int i7 = (nextSet2 - nextSet) - i5;
                    if (nextSet2 != size && (i7 << 1) < i5) {
                        throw NotFoundException.getNotFoundInstance();
                    }
                    if (this.usingCheckDigit) {
                        int length = sb2.length() - 1;
                        int i8 = 0;
                        for (int i9 = 0; i9 < length; i9++) {
                            i8 += CHECK_DIGIT_STRING.indexOf(this.decodeRowResult.charAt(i9));
                        }
                        if (sb2.charAt(length) == CHECK_DIGIT_STRING.charAt(i8 % 43)) {
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
                        float f2 = i2;
                        return new Result(sb, null, new ResultPoint[]{new ResultPoint((findAsteriskPattern[1] + findAsteriskPattern[0]) / 2.0f, f2), new ResultPoint(nextSet + (i5 / 2.0f), f2)}, BarcodeFormat.CODE_39);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
