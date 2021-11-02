package com.google.zxing.oned;

import androidx.core.view.InputDeviceCompat;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobads.container.util.SDKLogTypeConstants;
import com.baidu.searchbox.live.interfaces.player.VideoInfoConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.qrcodescanner.QRScanCodeActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
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
import org.apache.http.HttpStatus;
/* loaded from: classes2.dex */
public final class Code93Reader extends OneDReader {
    public static /* synthetic */ Interceptable $ic = null;
    public static final char[] ALPHABET;
    public static final String ALPHABET_STRING = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*";
    public static final int ASTERISK_ENCODING;
    public static final int[] CHARACTER_ENCODINGS;
    public transient /* synthetic */ FieldHolder $fh;
    public final int[] counters;
    public final StringBuilder decodeRowResult;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1817297625, "Lcom/google/zxing/oned/Code93Reader;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1817297625, "Lcom/google/zxing/oned/Code93Reader;");
                return;
            }
        }
        ALPHABET = ALPHABET_STRING.toCharArray();
        int[] iArr = {276, 328, 324, 322, 296, 292, QRScanCodeActivity.DIALOG_CHECK_SAFE, 336, 274, 266, HttpStatus.SC_FAILED_DEPENDENCY, HttpStatus.SC_METHOD_FAILURE, SDKLogTypeConstants.TYPE_RSPLASH_HTML_LOG, 404, 402, 394, 360, 356, VideoInfoConstants.VIDEO_PREFERRED_CLARITY_RANK, 308, 282, 344, 332, 326, 300, 278, 436, 434, 428, HttpStatus.SC_UNPROCESSABLE_ENTITY, 406, 410, SDKLogTypeConstants.TYPE_FEED_CLICK, 358, 310, 314, 302, 468, 466, 458, SDKLogTypeConstants.TYPE_APO_CLICK, 374, SDKLogTypeConstants.TYPE_LP_DOWNLOAD, QRScanCodeActivity.DIALOG_ALIPAY_JD_WX_COPY, 474, FloatingActionButton.AUTO_MINI_LARGEST_SCREEN_WIDTH, ARPMessageType.MSG_TYPE_IMU_MIRROR_DATA, 350};
        CHARACTER_ENCODINGS = iArr;
        ASTERISK_ENCODING = iArr[47];
    }

    public Code93Reader() {
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
        this.decodeRowResult = new StringBuilder(20);
        this.counters = new int[6];
    }

    public static void checkChecksums(CharSequence charSequence) throws ChecksumException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, charSequence) == null) {
            int length = charSequence.length();
            checkOneChecksum(charSequence, length - 2, 20);
            checkOneChecksum(charSequence, length - 1, 15);
        }
    }

    public static void checkOneChecksum(CharSequence charSequence, int i2, int i3) throws ChecksumException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65539, null, charSequence, i2, i3) == null) {
            int i4 = 0;
            int i5 = 1;
            for (int i6 = i2 - 1; i6 >= 0; i6--) {
                i4 += ALPHABET_STRING.indexOf(charSequence.charAt(i6)) * i5;
                i5++;
                if (i5 > i3) {
                    i5 = 1;
                }
            }
            if (charSequence.charAt(i2) != ALPHABET[i4 % 47]) {
                throw ChecksumException.getChecksumInstance();
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
                if (charAt < 'a' || charAt > 'd') {
                    sb.append(charAt);
                } else if (i3 < length - 1) {
                    i3++;
                    char charAt2 = charSequence.charAt(i3);
                    switch (charAt) {
                        case 'a':
                            if (charAt2 >= 'A' && charAt2 <= 'Z') {
                                i2 = charAt2 - '@';
                                c2 = (char) i2;
                                break;
                            } else {
                                throw FormatException.getFormatInstance();
                            }
                            break;
                        case 'b':
                            if (charAt2 >= 'A' && charAt2 <= 'E') {
                                i2 = charAt2 - '&';
                            } else if (charAt2 >= 'F' && charAt2 <= 'J') {
                                i2 = charAt2 + DecodedBitStreamParser.TWOSHIFTA;
                            } else if (charAt2 >= 'K' && charAt2 <= 'O') {
                                i2 = charAt2 + 16;
                            } else if (charAt2 >= 'P' && charAt2 <= 'S') {
                                i2 = charAt2 + '+';
                            } else if (charAt2 >= 'T' && charAt2 <= 'Z') {
                                c2 = 127;
                                break;
                            } else {
                                throw FormatException.getFormatInstance();
                            }
                            c2 = (char) i2;
                            break;
                        case 'c':
                            if (charAt2 >= 'A' && charAt2 <= 'O') {
                                i2 = charAt2 - ' ';
                                c2 = (char) i2;
                                break;
                            } else if (charAt2 == 'Z') {
                                c2 = ':';
                                break;
                            } else {
                                throw FormatException.getFormatInstance();
                            }
                        case 'd':
                            if (charAt2 >= 'A' && charAt2 <= 'Z') {
                                i2 = charAt2 + ' ';
                                c2 = (char) i2;
                                break;
                            } else {
                                throw FormatException.getFormatInstance();
                            }
                            break;
                        default:
                            c2 = 0;
                            break;
                    }
                    sb.append(c2);
                } else {
                    throw FormatException.getFormatInstance();
                }
                i3++;
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    private int[] findAsteriskPattern(BitArray bitArray) throws NotFoundException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, bitArray)) == null) {
            int size = bitArray.getSize();
            int nextSet = bitArray.getNextSet(0);
            Arrays.fill(this.counters, 0);
            int[] iArr = this.counters;
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
                    } else if (toPattern(iArr) == ASTERISK_ENCODING) {
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
        return (int[]) invokeL.objValue;
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
                    return ALPHABET[i3];
                }
                i3++;
            } else {
                throw NotFoundException.getNotFoundInstance();
            }
        }
    }

    public static int toPattern(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, iArr)) == null) {
            int i2 = 0;
            for (int i3 : iArr) {
                i2 += i3;
            }
            int length = iArr.length;
            int i4 = 0;
            for (int i5 = 0; i5 < length; i5++) {
                int round = Math.round((iArr[i5] * 9.0f) / i2);
                if (round <= 0 || round > 4) {
                    return -1;
                }
                if ((i5 & 1) == 0) {
                    for (int i6 = 0; i6 < round; i6++) {
                        i4 = (i4 << 1) | 1;
                    }
                } else {
                    i4 <<= round;
                }
            }
            return i4;
        }
        return invokeL.intValue;
    }

    @Override // com.google.zxing.oned.OneDReader
    public Result decodeRow(int i2, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        InterceptResult invokeILL;
        int[] findAsteriskPattern;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeILL = interceptable.invokeILL(1048576, this, i2, bitArray, map)) != null) {
            return (Result) invokeILL.objValue;
        }
        int nextSet = bitArray.getNextSet(findAsteriskPattern(bitArray)[1]);
        int size = bitArray.getSize();
        int[] iArr = this.counters;
        Arrays.fill(iArr, 0);
        StringBuilder sb = this.decodeRowResult;
        sb.setLength(0);
        while (true) {
            OneDReader.recordPattern(bitArray, nextSet, iArr);
            int pattern = toPattern(iArr);
            if (pattern >= 0) {
                char patternToChar = patternToChar(pattern);
                sb.append(patternToChar);
                int i3 = nextSet;
                for (int i4 : iArr) {
                    i3 += i4;
                }
                int nextSet2 = bitArray.getNextSet(i3);
                if (patternToChar == '*') {
                    sb.deleteCharAt(sb.length() - 1);
                    int i5 = 0;
                    for (int i6 : iArr) {
                        i5 += i6;
                    }
                    if (nextSet2 != size && bitArray.get(nextSet2)) {
                        if (sb.length() >= 2) {
                            checkChecksums(sb);
                            sb.setLength(sb.length() - 2);
                            float f2 = i2;
                            return new Result(decodeExtended(sb), null, new ResultPoint[]{new ResultPoint((findAsteriskPattern[1] + findAsteriskPattern[0]) / 2.0f, f2), new ResultPoint(nextSet + (i5 / 2.0f), f2)}, BarcodeFormat.CODE_93);
                        }
                        throw NotFoundException.getNotFoundInstance();
                    }
                    throw NotFoundException.getNotFoundInstance();
                }
                nextSet = nextSet2;
            } else {
                throw NotFoundException.getNotFoundInstance();
            }
        }
    }
}
