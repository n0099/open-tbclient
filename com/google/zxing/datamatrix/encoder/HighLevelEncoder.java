package com.google.zxing.datamatrix.encoder;

import androidx.core.view.InputDeviceCompat;
import com.baidu.appsearch.update.patchupdate.GDiffPatcher;
import com.baidu.mapapi.UIMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.Dimension;
import java.util.Arrays;
/* loaded from: classes8.dex */
public final class HighLevelEncoder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ASCII_ENCODATION = 0;
    public static final int BASE256_ENCODATION = 5;
    public static final int C40_ENCODATION = 1;
    public static final char C40_UNLATCH = 254;
    public static final int EDIFACT_ENCODATION = 4;
    public static final char LATCH_TO_ANSIX12 = 238;
    public static final char LATCH_TO_BASE256 = 231;
    public static final char LATCH_TO_C40 = 230;
    public static final char LATCH_TO_EDIFACT = 240;
    public static final char LATCH_TO_TEXT = 239;
    public static final char MACRO_05 = 236;
    public static final String MACRO_05_HEADER = "[)>\u001e05\u001d";
    public static final char MACRO_06 = 237;
    public static final String MACRO_06_HEADER = "[)>\u001e06\u001d";
    public static final String MACRO_TRAILER = "\u001e\u0004";
    public static final char PAD = 129;
    public static final int TEXT_ENCODATION = 2;
    public static final char UPPER_SHIFT = 235;
    public static final int X12_ENCODATION = 3;
    public static final char X12_UNLATCH = 254;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean isDigit(char c) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{Character.valueOf(c)})) == null) ? c >= '0' && c <= '9' : invokeCommon.booleanValue;
    }

    public static boolean isExtendedASCII(char c) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{Character.valueOf(c)})) == null) ? c >= 128 && c <= 255 : invokeCommon.booleanValue;
    }

    public static boolean isNativeC40(char c) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{Character.valueOf(c)})) == null) {
            if (c != ' ') {
                if (c < '0' || c > '9') {
                    return c >= 'A' && c <= 'Z';
                }
                return true;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean isNativeEDIFACT(char c) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{Character.valueOf(c)})) == null) ? c >= ' ' && c <= '^' : invokeCommon.booleanValue;
    }

    public static boolean isNativeText(char c) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{Character.valueOf(c)})) == null) {
            if (c != ' ') {
                if (c < '0' || c > '9') {
                    return c >= 'a' && c <= 'z';
                }
                return true;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean isSpecialB256(char c) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65549, null, new Object[]{Character.valueOf(c)})) == null) {
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean isX12TermSep(char c) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65550, null, new Object[]{Character.valueOf(c)})) == null) ? c == '\r' || c == '*' || c == '>' : invokeCommon.booleanValue;
    }

    public HighLevelEncoder() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static int determineConsecutiveDigitCount(CharSequence charSequence, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, charSequence, i)) == null) {
            int length = charSequence.length();
            int i2 = 0;
            if (i < length) {
                char charAt = charSequence.charAt(i);
                while (isDigit(charAt) && i < length) {
                    i2++;
                    i++;
                    if (i < length) {
                        charAt = charSequence.charAt(i);
                    }
                }
            }
            return i2;
        }
        return invokeLI.intValue;
    }

    public static String encodeHighLevel(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return encodeHighLevel(str, SymbolShapeHint.FORCE_NONE, null, null);
        }
        return (String) invokeL.objValue;
    }

    public static int getMinimumCount(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, bArr)) == null) {
            int i = 0;
            for (int i2 = 0; i2 < 6; i2++) {
                i += bArr[i2];
            }
            return i;
        }
        return invokeL.intValue;
    }

    public static String encodeHighLevel(String str, SymbolShapeHint symbolShapeHint, Dimension dimension, Dimension dimension2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65539, null, str, symbolShapeHint, dimension, dimension2)) == null) {
            int i = 0;
            Encoder[] encoderArr = {new ASCIIEncoder(), new C40Encoder(), new TextEncoder(), new X12Encoder(), new EdifactEncoder(), new Base256Encoder()};
            EncoderContext encoderContext = new EncoderContext(str);
            encoderContext.setSymbolShape(symbolShapeHint);
            encoderContext.setSizeConstraints(dimension, dimension2);
            if (str.startsWith(MACRO_05_HEADER) && str.endsWith(MACRO_TRAILER)) {
                encoderContext.writeCodeword(MACRO_05);
                encoderContext.setSkipAtEnd(2);
                encoderContext.pos += 7;
            } else if (str.startsWith(MACRO_06_HEADER) && str.endsWith(MACRO_TRAILER)) {
                encoderContext.writeCodeword(MACRO_06);
                encoderContext.setSkipAtEnd(2);
                encoderContext.pos += 7;
            }
            while (encoderContext.hasMoreCharacters()) {
                encoderArr[i].encode(encoderContext);
                if (encoderContext.getNewEncoding() >= 0) {
                    i = encoderContext.getNewEncoding();
                    encoderContext.resetEncoderSignal();
                }
            }
            int codewordCount = encoderContext.getCodewordCount();
            encoderContext.updateSymbolInfo();
            int dataCapacity = encoderContext.getSymbolInfo().getDataCapacity();
            if (codewordCount < dataCapacity && i != 0 && i != 5) {
                encoderContext.writeCodeword((char) 254);
            }
            StringBuilder codewords = encoderContext.getCodewords();
            if (codewords.length() < dataCapacity) {
                codewords.append(PAD);
            }
            while (codewords.length() < dataCapacity) {
                codewords.append(randomize253State(PAD, codewords.length() + 1));
            }
            return encoderContext.getCodewords().toString();
        }
        return (String) invokeLLLL.objValue;
    }

    public static int findMinimums(float[] fArr, int[] iArr, int i, byte[] bArr) {
        InterceptResult invokeLLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(InputDeviceCompat.SOURCE_TRACKBALL, null, fArr, iArr, i, bArr)) == null) {
            Arrays.fill(bArr, (byte) 0);
            for (int i2 = 0; i2 < 6; i2++) {
                iArr[i2] = (int) Math.ceil(fArr[i2]);
                int i3 = iArr[i2];
                if (i > i3) {
                    Arrays.fill(bArr, (byte) 0);
                    i = i3;
                }
                if (i == i3) {
                    bArr[i2] = (byte) (bArr[i2] + 1);
                }
            }
            return i;
        }
        return invokeLLIL.intValue;
    }

    public static void illegalCharacter(char c) {
        String hexString;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{Character.valueOf(c)}) == null) {
            throw new IllegalArgumentException("Illegal character: " + c + " (0x" + ("0000".substring(0, 4 - hexString.length()) + Integer.toHexString(c)) + ')');
        }
    }

    public static boolean isNativeX12(char c) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{Character.valueOf(c)})) == null) {
            if (!isX12TermSep(c) && c != ' ') {
                if (c < '0' || c > '9') {
                    if (c < 'A' || c > 'Z') {
                        return false;
                    }
                    return true;
                }
                return true;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static int lookAheadTest(CharSequence charSequence, int i, int i2) {
        InterceptResult invokeLII;
        float[] fArr;
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65551, null, charSequence, i, i2)) == null) {
            if (i >= charSequence.length()) {
                return i2;
            }
            if (i2 == 0) {
                fArr = new float[]{0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.25f};
            } else {
                fArr = new float[]{1.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.25f};
                fArr[i2] = 0.0f;
            }
            int i3 = 0;
            while (true) {
                int i4 = i + i3;
                if (i4 == charSequence.length()) {
                    byte[] bArr = new byte[6];
                    int[] iArr = new int[6];
                    int findMinimums = findMinimums(fArr, iArr, Integer.MAX_VALUE, bArr);
                    int minimumCount = getMinimumCount(bArr);
                    if (iArr[0] == findMinimums) {
                        return 0;
                    }
                    if (minimumCount == 1 && bArr[5] > 0) {
                        return 5;
                    }
                    if (minimumCount == 1 && bArr[4] > 0) {
                        return 4;
                    }
                    if (minimumCount == 1 && bArr[2] > 0) {
                        return 2;
                    }
                    if (minimumCount == 1 && bArr[3] > 0) {
                        return 3;
                    }
                    return 1;
                }
                char charAt = charSequence.charAt(i4);
                i3++;
                if (isDigit(charAt)) {
                    fArr[0] = fArr[0] + 0.5f;
                } else if (isExtendedASCII(charAt)) {
                    fArr[0] = (float) Math.ceil(fArr[0]);
                    fArr[0] = fArr[0] + 2.0f;
                } else {
                    fArr[0] = (float) Math.ceil(fArr[0]);
                    fArr[0] = fArr[0] + 1.0f;
                }
                if (isNativeC40(charAt)) {
                    fArr[1] = fArr[1] + 0.6666667f;
                } else if (isExtendedASCII(charAt)) {
                    fArr[1] = fArr[1] + 2.6666667f;
                } else {
                    fArr[1] = fArr[1] + 1.3333334f;
                }
                if (isNativeText(charAt)) {
                    fArr[2] = fArr[2] + 0.6666667f;
                } else if (isExtendedASCII(charAt)) {
                    fArr[2] = fArr[2] + 2.6666667f;
                } else {
                    fArr[2] = fArr[2] + 1.3333334f;
                }
                if (isNativeX12(charAt)) {
                    fArr[3] = fArr[3] + 0.6666667f;
                } else if (isExtendedASCII(charAt)) {
                    fArr[3] = fArr[3] + 4.3333335f;
                } else {
                    fArr[3] = fArr[3] + 3.3333333f;
                }
                if (isNativeEDIFACT(charAt)) {
                    fArr[4] = fArr[4] + 0.75f;
                } else if (isExtendedASCII(charAt)) {
                    fArr[4] = fArr[4] + 4.25f;
                } else {
                    fArr[4] = fArr[4] + 3.25f;
                }
                if (isSpecialB256(charAt)) {
                    c = 5;
                    fArr[5] = fArr[5] + 4.0f;
                } else {
                    c = 5;
                    fArr[5] = fArr[5] + 1.0f;
                }
                if (i3 >= 4) {
                    int[] iArr2 = new int[6];
                    byte[] bArr2 = new byte[6];
                    findMinimums(fArr, iArr2, Integer.MAX_VALUE, bArr2);
                    int minimumCount2 = getMinimumCount(bArr2);
                    if (iArr2[0] < iArr2[c] && iArr2[0] < iArr2[1] && iArr2[0] < iArr2[2] && iArr2[0] < iArr2[3] && iArr2[0] < iArr2[4]) {
                        return 0;
                    }
                    if (iArr2[5] >= iArr2[0] && bArr2[1] + bArr2[2] + bArr2[3] + bArr2[4] != 0) {
                        if (minimumCount2 == 1 && bArr2[4] > 0) {
                            return 4;
                        }
                        if (minimumCount2 == 1 && bArr2[2] > 0) {
                            return 2;
                        }
                        if (minimumCount2 == 1 && bArr2[3] > 0) {
                            return 3;
                        }
                        if (iArr2[1] + 1 < iArr2[0] && iArr2[1] + 1 < iArr2[5] && iArr2[1] + 1 < iArr2[4] && iArr2[1] + 1 < iArr2[2]) {
                            if (iArr2[1] < iArr2[3]) {
                                return 1;
                            }
                            if (iArr2[1] == iArr2[3]) {
                                for (int i5 = i + i3 + 1; i5 < charSequence.length(); i5++) {
                                    char charAt2 = charSequence.charAt(i5);
                                    if (isX12TermSep(charAt2)) {
                                        return 3;
                                    }
                                    if (!isNativeX12(charAt2)) {
                                        break;
                                    }
                                }
                                return 1;
                            }
                        }
                    } else {
                        return 5;
                    }
                }
            }
        } else {
            return invokeLII.intValue;
        }
    }

    public static char randomize253State(char c, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65552, null, new Object[]{Character.valueOf(c), Integer.valueOf(i)})) == null) {
            int i2 = c + ((i * 149) % GDiffPatcher.COPY_INT_USHORT) + 1;
            if (i2 > 254) {
                i2 += UIMsg.m_AppUI.V_WM_LISTLISTUPDATE;
            }
            return (char) i2;
        }
        return invokeCommon.charValue;
    }
}
