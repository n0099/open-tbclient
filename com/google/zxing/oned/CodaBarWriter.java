package com.google.zxing.oned;

import com.baidu.android.common.others.IStringUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
/* loaded from: classes7.dex */
public final class CodaBarWriter extends OneDimensionalCodeWriter {
    public static /* synthetic */ Interceptable $ic;
    public static final char[] ALT_START_END_CHARS;
    public static final char[] CHARS_WHICH_ARE_TEN_LENGTH_EACH_AFTER_DECODED;
    public static final char DEFAULT_GUARD;
    public static final char[] START_END_CHARS;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-29006072, "Lcom/google/zxing/oned/CodaBarWriter;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-29006072, "Lcom/google/zxing/oned/CodaBarWriter;");
                return;
            }
        }
        char[] cArr = {'A', 'B', 'C', 'D'};
        START_END_CHARS = cArr;
        ALT_START_END_CHARS = new char[]{'T', 'N', '*', 'E'};
        CHARS_WHICH_ARE_TEN_LENGTH_EACH_AFTER_DECODED = new char[]{WebvttCueParser.CHAR_SLASH, ':', '+', IStringUtil.EXTENSION_SEPARATOR};
        DEFAULT_GUARD = cArr[0];
    }

    public CodaBarWriter() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public boolean[] encode(String str) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (str.length() < 2) {
                str = DEFAULT_GUARD + str + DEFAULT_GUARD;
            } else {
                char upperCase = Character.toUpperCase(str.charAt(0));
                char upperCase2 = Character.toUpperCase(str.charAt(str.length() - 1));
                boolean arrayContains = CodaBarReader.arrayContains(START_END_CHARS, upperCase);
                boolean arrayContains2 = CodaBarReader.arrayContains(START_END_CHARS, upperCase2);
                boolean arrayContains3 = CodaBarReader.arrayContains(ALT_START_END_CHARS, upperCase);
                boolean arrayContains4 = CodaBarReader.arrayContains(ALT_START_END_CHARS, upperCase2);
                if (arrayContains) {
                    if (!arrayContains2) {
                        throw new IllegalArgumentException("Invalid start/end guards: " + str);
                    }
                } else if (arrayContains3) {
                    if (!arrayContains4) {
                        throw new IllegalArgumentException("Invalid start/end guards: " + str);
                    }
                } else if (arrayContains2 || arrayContains4) {
                    throw new IllegalArgumentException("Invalid start/end guards: " + str);
                } else {
                    str = DEFAULT_GUARD + str + DEFAULT_GUARD;
                }
            }
            int i2 = 20;
            for (int i3 = 1; i3 < str.length() - 1; i3++) {
                if (Character.isDigit(str.charAt(i3)) || str.charAt(i3) == '-' || str.charAt(i3) == '$') {
                    i2 += 9;
                } else if (!CodaBarReader.arrayContains(CHARS_WHICH_ARE_TEN_LENGTH_EACH_AFTER_DECODED, str.charAt(i3))) {
                    throw new IllegalArgumentException("Cannot encode : '" + str.charAt(i3) + '\'');
                } else {
                    i2 += 10;
                }
            }
            boolean[] zArr = new boolean[i2 + (str.length() - 1)];
            int i4 = 0;
            for (int i5 = 0; i5 < str.length(); i5++) {
                char upperCase3 = Character.toUpperCase(str.charAt(i5));
                if (i5 == 0 || i5 == str.length() - 1) {
                    if (upperCase3 == '*') {
                        upperCase3 = 'C';
                    } else if (upperCase3 == 'E') {
                        upperCase3 = 'D';
                    } else if (upperCase3 == 'N') {
                        upperCase3 = 'B';
                    } else if (upperCase3 == 'T') {
                        upperCase3 = 'A';
                    }
                }
                int i6 = 0;
                while (true) {
                    char[] cArr = CodaBarReader.ALPHABET;
                    if (i6 >= cArr.length) {
                        i = 0;
                        break;
                    } else if (upperCase3 == cArr[i6]) {
                        i = CodaBarReader.CHARACTER_ENCODINGS[i6];
                        break;
                    } else {
                        i6++;
                    }
                }
                int i7 = 0;
                boolean z = true;
                while (true) {
                    int i8 = 0;
                    while (i7 < 7) {
                        zArr[i4] = z;
                        i4++;
                        if (((i >> (6 - i7)) & 1) == 0 || i8 == 1) {
                            z = !z;
                            i7++;
                        } else {
                            i8++;
                        }
                    }
                    break;
                }
                if (i5 < str.length() - 1) {
                    zArr[i4] = false;
                    i4++;
                }
            }
            return zArr;
        }
        return (boolean[]) invokeL.objValue;
    }
}
