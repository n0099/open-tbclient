package com.google.zxing.datamatrix.decoder;

import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.asm.Opcodes;
import com.alipay.sdk.encrypt.a;
import com.baidu.ar.auth.FeatureCodes;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.FormatException;
import com.google.zxing.common.BitSource;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.StringUtils;
import com.google.zxing.datamatrix.encoder.HighLevelEncoder;
import com.kuaishou.weapon.un.w0;
import com.tachikoma.core.utility.FileUtil;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.text.Typography;
import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.aspectj.runtime.reflect.SignatureImpl;
/* loaded from: classes3.dex */
public final class DecodedBitStreamParser {
    public static /* synthetic */ Interceptable $ic;
    public static final char[] C40_BASIC_SET_CHARS;
    public static final char[] C40_SHIFT2_SET_CHARS;
    public static final char[] TEXT_BASIC_SET_CHARS;
    public static final char[] TEXT_SHIFT2_SET_CHARS;
    public static final char[] TEXT_SHIFT3_SET_CHARS;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.google.zxing.datamatrix.decoder.DecodedBitStreamParser$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$google$zxing$datamatrix$decoder$DecodedBitStreamParser$Mode;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2126503952, "Lcom/google/zxing/datamatrix/decoder/DecodedBitStreamParser$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2126503952, "Lcom/google/zxing/datamatrix/decoder/DecodedBitStreamParser$1;");
                    return;
                }
            }
            int[] iArr = new int[Mode.values().length];
            $SwitchMap$com$google$zxing$datamatrix$decoder$DecodedBitStreamParser$Mode = iArr;
            try {
                iArr[Mode.C40_ENCODE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$zxing$datamatrix$decoder$DecodedBitStreamParser$Mode[Mode.TEXT_ENCODE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$zxing$datamatrix$decoder$DecodedBitStreamParser$Mode[Mode.ANSIX12_ENCODE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$zxing$datamatrix$decoder$DecodedBitStreamParser$Mode[Mode.EDIFACT_ENCODE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$zxing$datamatrix$decoder$DecodedBitStreamParser$Mode[Mode.BASE256_ENCODE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class Mode {
        public static final /* synthetic */ Mode[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Mode ANSIX12_ENCODE;
        public static final Mode ASCII_ENCODE;
        public static final Mode BASE256_ENCODE;
        public static final Mode C40_ENCODE;
        public static final Mode EDIFACT_ENCODE;
        public static final Mode PAD_ENCODE;
        public static final Mode TEXT_ENCODE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(115888978, "Lcom/google/zxing/datamatrix/decoder/DecodedBitStreamParser$Mode;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(115888978, "Lcom/google/zxing/datamatrix/decoder/DecodedBitStreamParser$Mode;");
                    return;
                }
            }
            PAD_ENCODE = new Mode("PAD_ENCODE", 0);
            ASCII_ENCODE = new Mode("ASCII_ENCODE", 1);
            C40_ENCODE = new Mode("C40_ENCODE", 2);
            TEXT_ENCODE = new Mode("TEXT_ENCODE", 3);
            ANSIX12_ENCODE = new Mode("ANSIX12_ENCODE", 4);
            EDIFACT_ENCODE = new Mode("EDIFACT_ENCODE", 5);
            Mode mode = new Mode("BASE256_ENCODE", 6);
            BASE256_ENCODE = mode;
            $VALUES = new Mode[]{PAD_ENCODE, ASCII_ENCODE, C40_ENCODE, TEXT_ENCODE, ANSIX12_ENCODE, EDIFACT_ENCODE, mode};
        }

        public Mode(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static Mode valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Mode) Enum.valueOf(Mode.class, str) : (Mode) invokeL.objValue;
        }

        public static Mode[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Mode[]) $VALUES.clone() : (Mode[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-605564067, "Lcom/google/zxing/datamatrix/decoder/DecodedBitStreamParser;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-605564067, "Lcom/google/zxing/datamatrix/decoder/DecodedBitStreamParser;");
                return;
            }
        }
        C40_BASIC_SET_CHARS = new char[]{'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        char[] cArr = {'!', '\"', '#', '$', '%', Typography.amp, ExtendedMessageFormat.QUOTE, '(', ')', '*', '+', ',', SignatureImpl.SEP, '.', '/', ':', ';', Typography.less, a.f31721h, Typography.greater, '?', '@', '[', FileUtil.WINDOWS_SEPARATOR, ']', '^', '_'};
        C40_SHIFT2_SET_CHARS = cArr;
        TEXT_BASIC_SET_CHARS = new char[]{'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        TEXT_SHIFT2_SET_CHARS = cArr;
        TEXT_SHIFT3_SET_CHARS = new char[]{'`', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', ExtendedMessageFormat.START_FE, '|', ExtendedMessageFormat.END_FE, '~', 127};
    }

    public DecodedBitStreamParser() {
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

    public static DecoderResult decode(byte[] bArr) throws FormatException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) {
            BitSource bitSource = new BitSource(bArr);
            StringBuilder sb = new StringBuilder(100);
            StringBuilder sb2 = new StringBuilder(0);
            ArrayList arrayList = new ArrayList(1);
            Mode mode = Mode.ASCII_ENCODE;
            do {
                if (mode == Mode.ASCII_ENCODE) {
                    mode = decodeAsciiSegment(bitSource, sb, sb2);
                } else {
                    int i2 = AnonymousClass1.$SwitchMap$com$google$zxing$datamatrix$decoder$DecodedBitStreamParser$Mode[mode.ordinal()];
                    if (i2 == 1) {
                        decodeC40Segment(bitSource, sb);
                    } else if (i2 == 2) {
                        decodeTextSegment(bitSource, sb);
                    } else if (i2 == 3) {
                        decodeAnsiX12Segment(bitSource, sb);
                    } else if (i2 == 4) {
                        decodeEdifactSegment(bitSource, sb);
                    } else if (i2 == 5) {
                        decodeBase256Segment(bitSource, sb, arrayList);
                    } else {
                        throw FormatException.getFormatInstance();
                    }
                    mode = Mode.ASCII_ENCODE;
                }
                if (mode == Mode.PAD_ENCODE) {
                    break;
                }
            } while (bitSource.available() > 0);
            if (sb2.length() > 0) {
                sb.append((CharSequence) sb2);
            }
            String sb3 = sb.toString();
            if (arrayList.isEmpty()) {
                arrayList = null;
            }
            return new DecoderResult(bArr, sb3, arrayList, null);
        }
        return (DecoderResult) invokeL.objValue;
    }

    public static void decodeAnsiX12Segment(BitSource bitSource, StringBuilder sb) throws FormatException {
        int readBits;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, bitSource, sb) == null) {
            int[] iArr = new int[3];
            while (bitSource.available() != 8 && (readBits = bitSource.readBits(8)) != 254) {
                parseTwoBytes(readBits, bitSource.readBits(8), iArr);
                for (int i2 = 0; i2 < 3; i2++) {
                    int i3 = iArr[i2];
                    if (i3 == 0) {
                        sb.append(CharUtils.CR);
                    } else if (i3 == 1) {
                        sb.append('*');
                    } else if (i3 == 2) {
                        sb.append(Typography.greater);
                    } else if (i3 == 3) {
                        sb.append(' ');
                    } else if (i3 < 14) {
                        sb.append((char) (i3 + 44));
                    } else if (i3 < 40) {
                        sb.append((char) (i3 + 51));
                    } else {
                        throw FormatException.getFormatInstance();
                    }
                }
                if (bitSource.available() <= 0) {
                    return;
                }
            }
        }
    }

    public static Mode decodeAsciiSegment(BitSource bitSource, StringBuilder sb, StringBuilder sb2) throws FormatException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, bitSource, sb, sb2)) == null) {
            boolean z = false;
            do {
                int readBits = bitSource.readBits(8);
                if (readBits == 0) {
                    throw FormatException.getFormatInstance();
                }
                if (readBits <= 128) {
                    if (z) {
                        readBits += 128;
                    }
                    sb.append((char) (readBits - 1));
                    return Mode.ASCII_ENCODE;
                } else if (readBits == 129) {
                    return Mode.PAD_ENCODE;
                } else {
                    if (readBits <= 229) {
                        int i2 = readBits - 130;
                        if (i2 < 10) {
                            sb.append('0');
                        }
                        sb.append(i2);
                    } else if (readBits == 230) {
                        return Mode.C40_ENCODE;
                    } else {
                        if (readBits == 231) {
                            return Mode.BASE256_ENCODE;
                        }
                        if (readBits == 232) {
                            sb.append(com.google.zxing.maxicode.decoder.DecodedBitStreamParser.GS);
                        } else if (readBits != 233 && readBits != 234) {
                            if (readBits == 235) {
                                z = true;
                            } else if (readBits == 236) {
                                sb.append(HighLevelEncoder.MACRO_05_HEADER);
                                sb2.insert(0, HighLevelEncoder.MACRO_TRAILER);
                            } else if (readBits == 237) {
                                sb.append(HighLevelEncoder.MACRO_06_HEADER);
                                sb2.insert(0, HighLevelEncoder.MACRO_TRAILER);
                            } else if (readBits == 238) {
                                return Mode.ANSIX12_ENCODE;
                            } else {
                                if (readBits == 239) {
                                    return Mode.TEXT_ENCODE;
                                }
                                if (readBits == 240) {
                                    return Mode.EDIFACT_ENCODE;
                                }
                                if (readBits != 241 && readBits >= 242 && (readBits != 254 || bitSource.available() != 0)) {
                                    throw FormatException.getFormatInstance();
                                }
                            }
                        }
                    }
                }
            } while (bitSource.available() > 0);
            return Mode.ASCII_ENCODE;
        }
        return (Mode) invokeLLL.objValue;
    }

    public static void decodeBase256Segment(BitSource bitSource, StringBuilder sb, Collection<byte[]> collection) throws FormatException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, bitSource, sb, collection) == null) {
            int byteOffset = bitSource.getByteOffset() + 1;
            int i2 = byteOffset + 1;
            int unrandomize255State = unrandomize255State(bitSource.readBits(8), byteOffset);
            if (unrandomize255State == 0) {
                unrandomize255State = bitSource.available() / 8;
            } else if (unrandomize255State >= 250) {
                unrandomize255State = ((unrandomize255State - 249) * 250) + unrandomize255State(bitSource.readBits(8), i2);
                i2++;
            }
            if (unrandomize255State >= 0) {
                byte[] bArr = new byte[unrandomize255State];
                int i3 = 0;
                while (i3 < unrandomize255State) {
                    if (bitSource.available() >= 8) {
                        bArr[i3] = (byte) unrandomize255State(bitSource.readBits(8), i2);
                        i3++;
                        i2++;
                    } else {
                        throw FormatException.getFormatInstance();
                    }
                }
                collection.add(bArr);
                try {
                    sb.append(new String(bArr, StringUtils.ISO88591));
                    return;
                } catch (UnsupportedEncodingException e2) {
                    throw new IllegalStateException("Platform does not support required encoding: " + e2);
                }
            }
            throw FormatException.getFormatInstance();
        }
    }

    public static void decodeC40Segment(BitSource bitSource, StringBuilder sb) throws FormatException {
        int readBits;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, bitSource, sb) == null) {
            int[] iArr = new int[3];
            boolean z = false;
            int i2 = 0;
            while (bitSource.available() != 8 && (readBits = bitSource.readBits(8)) != 254) {
                parseTwoBytes(readBits, bitSource.readBits(8), iArr);
                for (int i3 = 0; i3 < 3; i3++) {
                    int i4 = iArr[i3];
                    if (i2 != 0) {
                        if (i2 != 1) {
                            if (i2 == 2) {
                                char[] cArr = C40_SHIFT2_SET_CHARS;
                                if (i4 < cArr.length) {
                                    char c2 = cArr[i4];
                                    if (z) {
                                        sb.append((char) (c2 + 128));
                                        z = false;
                                    } else {
                                        sb.append(c2);
                                    }
                                } else if (i4 == 27) {
                                    sb.append(com.google.zxing.maxicode.decoder.DecodedBitStreamParser.GS);
                                } else if (i4 != 30) {
                                    throw FormatException.getFormatInstance();
                                } else {
                                    z = true;
                                }
                                i2 = 0;
                            } else if (i2 != 3) {
                                throw FormatException.getFormatInstance();
                            } else {
                                if (z) {
                                    sb.append((char) (i4 + w0.Q));
                                    z = false;
                                    i2 = 0;
                                } else {
                                    sb.append((char) (i4 + 96));
                                    i2 = 0;
                                }
                            }
                        } else if (z) {
                            sb.append((char) (i4 + 128));
                            z = false;
                            i2 = 0;
                        } else {
                            sb.append((char) i4);
                            i2 = 0;
                        }
                    } else if (i4 < 3) {
                        i2 = i4 + 1;
                    } else {
                        char[] cArr2 = C40_BASIC_SET_CHARS;
                        if (i4 < cArr2.length) {
                            char c3 = cArr2[i4];
                            if (z) {
                                sb.append((char) (c3 + 128));
                                z = false;
                            } else {
                                sb.append(c3);
                            }
                        } else {
                            throw FormatException.getFormatInstance();
                        }
                    }
                }
                if (bitSource.available() <= 0) {
                    return;
                }
            }
        }
    }

    public static void decodeEdifactSegment(BitSource bitSource, StringBuilder sb) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, bitSource, sb) == null) {
            while (bitSource.available() > 16) {
                for (int i2 = 0; i2 < 4; i2++) {
                    int readBits = bitSource.readBits(6);
                    if (readBits == 31) {
                        int bitOffset = 8 - bitSource.getBitOffset();
                        if (bitOffset != 8) {
                            bitSource.readBits(bitOffset);
                            return;
                        }
                        return;
                    }
                    if ((readBits & 32) == 0) {
                        readBits |= 64;
                    }
                    sb.append((char) readBits);
                }
                if (bitSource.available() <= 0) {
                    return;
                }
            }
        }
    }

    public static void decodeTextSegment(BitSource bitSource, StringBuilder sb) throws FormatException {
        int readBits;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, bitSource, sb) == null) {
            int[] iArr = new int[3];
            boolean z = false;
            int i2 = 0;
            while (bitSource.available() != 8 && (readBits = bitSource.readBits(8)) != 254) {
                parseTwoBytes(readBits, bitSource.readBits(8), iArr);
                for (int i3 = 0; i3 < 3; i3++) {
                    int i4 = iArr[i3];
                    if (i2 != 0) {
                        if (i2 != 1) {
                            if (i2 == 2) {
                                char[] cArr = TEXT_SHIFT2_SET_CHARS;
                                if (i4 < cArr.length) {
                                    char c2 = cArr[i4];
                                    if (z) {
                                        sb.append((char) (c2 + 128));
                                        z = false;
                                    } else {
                                        sb.append(c2);
                                    }
                                } else if (i4 == 27) {
                                    sb.append(com.google.zxing.maxicode.decoder.DecodedBitStreamParser.GS);
                                } else if (i4 != 30) {
                                    throw FormatException.getFormatInstance();
                                } else {
                                    z = true;
                                }
                                i2 = 0;
                            } else if (i2 == 3) {
                                char[] cArr2 = TEXT_SHIFT3_SET_CHARS;
                                if (i4 < cArr2.length) {
                                    char c3 = cArr2[i4];
                                    if (z) {
                                        sb.append((char) (c3 + 128));
                                        z = false;
                                        i2 = 0;
                                    } else {
                                        sb.append(c3);
                                        i2 = 0;
                                    }
                                } else {
                                    throw FormatException.getFormatInstance();
                                }
                            } else {
                                throw FormatException.getFormatInstance();
                            }
                        } else if (z) {
                            sb.append((char) (i4 + 128));
                            z = false;
                            i2 = 0;
                        } else {
                            sb.append((char) i4);
                            i2 = 0;
                        }
                    } else if (i4 < 3) {
                        i2 = i4 + 1;
                    } else {
                        char[] cArr3 = TEXT_BASIC_SET_CHARS;
                        if (i4 < cArr3.length) {
                            char c4 = cArr3[i4];
                            if (z) {
                                sb.append((char) (c4 + 128));
                                z = false;
                            } else {
                                sb.append(c4);
                            }
                        } else {
                            throw FormatException.getFormatInstance();
                        }
                    }
                }
                if (bitSource.available() <= 0) {
                    return;
                }
            }
        }
    }

    public static void parseTwoBytes(int i2, int i3, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(65545, null, i2, i3, iArr) == null) {
            int i4 = ((i2 << 8) + i3) - 1;
            int i5 = i4 / FeatureCodes.ADVANCE_BEAUTY;
            iArr[0] = i5;
            int i6 = i4 - (i5 * FeatureCodes.ADVANCE_BEAUTY);
            int i7 = i6 / 40;
            iArr[1] = i7;
            iArr[2] = i6 - (i7 * 40);
        }
    }

    public static int unrandomize255State(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65546, null, i2, i3)) == null) {
            int i4 = i2 - (((i3 * Opcodes.FCMPL) % 255) + 1);
            return i4 >= 0 ? i4 : i4 + 256;
        }
        return invokeII.intValue;
    }
}
