package org.apache.commons.lang3;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
import kotlin.UShort;
import okhttp3.internal.ws.WebSocketProtocol;
/* loaded from: classes3.dex */
public class Conversion {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static /* synthetic */ Interceptable $ic;
    public static final boolean[] FFFF;
    public static final boolean[] FFFT;
    public static final boolean[] FFTF;
    public static final boolean[] FFTT;
    public static final boolean[] FTFF;
    public static final boolean[] FTFT;
    public static final boolean[] FTTF;
    public static final boolean[] FTTT;
    public static final boolean[] TFFF;
    public static final boolean[] TFFT;
    public static final boolean[] TFTF;
    public static final boolean[] TFTT;
    public static final boolean[] TTFF;
    public static final boolean[] TTFT;
    public static final boolean[] TTTF;
    public static final boolean[] TTTT;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1190116074, "Lorg/apache/commons/lang3/Conversion;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1190116074, "Lorg/apache/commons/lang3/Conversion;");
                return;
            }
        }
        TTTT = new boolean[]{true, true, true, true};
        FTTT = new boolean[]{false, true, true, true};
        TFTT = new boolean[]{true, false, true, true};
        FFTT = new boolean[]{false, false, true, true};
        TTFT = new boolean[]{true, true, false, true};
        FTFT = new boolean[]{false, true, false, true};
        TFFT = new boolean[]{true, false, false, true};
        FFFT = new boolean[]{false, false, false, true};
        TTTF = new boolean[]{true, true, true, false};
        FTTF = new boolean[]{false, true, true, false};
        TFTF = new boolean[]{true, false, true, false};
        FFTF = new boolean[]{false, false, true, false};
        TTFF = new boolean[]{true, true, false, false};
        FTFF = new boolean[]{false, true, false, false};
        TFFF = new boolean[]{true, false, false, false};
        FFFF = new boolean[]{false, false, false, false};
    }

    public Conversion() {
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

    public static char binaryBeMsb0ToHexDigit(boolean[] zArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, zArr)) == null) ? binaryBeMsb0ToHexDigit(zArr, 0) : invokeL.charValue;
    }

    public static byte binaryToByte(boolean[] zArr, int i2, byte b2, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{zArr, Integer.valueOf(i2), Byte.valueOf(b2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            if ((zArr.length == 0 && i2 == 0) || i4 == 0) {
                return b2;
            }
            if ((i4 - 1) + i3 < 8) {
                for (int i5 = 0; i5 < i4; i5++) {
                    int i6 = i5 + i3;
                    b2 = (byte) ((b2 & (~(1 << i6))) | ((zArr[i5 + i2] ? 1 : 0) << i6));
                }
                return b2;
            }
            throw new IllegalArgumentException("nBools-1+dstPos is greather or equal to than 8");
        }
        return invokeCommon.byteValue;
    }

    public static char binaryToHexDigit(boolean[] zArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, zArr)) == null) ? binaryToHexDigit(zArr, 0) : invokeL.charValue;
    }

    public static char binaryToHexDigitMsb0_4bits(boolean[] zArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, zArr)) == null) ? binaryToHexDigitMsb0_4bits(zArr, 0) : invokeL.charValue;
    }

    public static int binaryToInt(boolean[] zArr, int i2, int i3, int i4, int i5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{zArr, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
            if ((zArr.length == 0 && i2 == 0) || i5 == 0) {
                return i3;
            }
            if ((i5 - 1) + i4 < 32) {
                for (int i6 = 0; i6 < i5; i6++) {
                    int i7 = i6 + i4;
                    i3 = (i3 & (~(1 << i7))) | ((zArr[i6 + i2] ? 1 : 0) << i7);
                }
                return i3;
            }
            throw new IllegalArgumentException("nBools-1+dstPos is greather or equal to than 32");
        }
        return invokeCommon.intValue;
    }

    public static long binaryToLong(boolean[] zArr, int i2, long j2, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{zArr, Integer.valueOf(i2), Long.valueOf(j2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            if ((zArr.length == 0 && i2 == 0) || i4 == 0) {
                return j2;
            }
            if ((i4 - 1) + i3 < 64) {
                for (int i5 = 0; i5 < i4; i5++) {
                    int i6 = i5 + i3;
                    j2 = (j2 & (~(1 << i6))) | ((zArr[i5 + i2] ? 1L : 0L) << i6);
                }
                return j2;
            }
            throw new IllegalArgumentException("nBools-1+dstPos is greather or equal to than 64");
        }
        return invokeCommon.longValue;
    }

    public static short binaryToShort(boolean[] zArr, int i2, short s, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{zArr, Integer.valueOf(i2), Short.valueOf(s), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            if ((zArr.length == 0 && i2 == 0) || i4 == 0) {
                return s;
            }
            if ((i4 - 1) + i3 < 16) {
                for (int i5 = 0; i5 < i4; i5++) {
                    int i6 = i5 + i3;
                    s = (short) ((s & (~(1 << i6))) | ((zArr[i5 + i2] ? 1 : 0) << i6));
                }
                return s;
            }
            throw new IllegalArgumentException("nBools-1+dstPos is greather or equal to than 16");
        }
        return invokeCommon.shortValue;
    }

    public static int byteArrayToInt(byte[] bArr, int i2, int i3, int i4, int i5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
            if ((bArr.length == 0 && i2 == 0) || i5 == 0) {
                return i3;
            }
            if (((i5 - 1) * 8) + i4 < 32) {
                for (int i6 = 0; i6 < i5; i6++) {
                    int i7 = (i6 * 8) + i4;
                    i3 = (i3 & (~(255 << i7))) | ((bArr[i6 + i2] & 255) << i7);
                }
                return i3;
            }
            throw new IllegalArgumentException("(nBytes-1)*8+dstPos is greather or equal to than 32");
        }
        return invokeCommon.intValue;
    }

    public static long byteArrayToLong(byte[] bArr, int i2, long j2, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65549, null, new Object[]{bArr, Integer.valueOf(i2), Long.valueOf(j2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            if ((bArr.length == 0 && i2 == 0) || i4 == 0) {
                return j2;
            }
            if (((i4 - 1) * 8) + i3 < 64) {
                for (int i5 = 0; i5 < i4; i5++) {
                    int i6 = (i5 * 8) + i3;
                    j2 = (j2 & (~(255 << i6))) | ((bArr[i5 + i2] & 255) << i6);
                }
                return j2;
            }
            throw new IllegalArgumentException("(nBytes-1)*8+dstPos is greather or equal to than 64");
        }
        return invokeCommon.longValue;
    }

    public static short byteArrayToShort(byte[] bArr, int i2, short s, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65550, null, new Object[]{bArr, Integer.valueOf(i2), Short.valueOf(s), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            if ((bArr.length == 0 && i2 == 0) || i4 == 0) {
                return s;
            }
            if (((i4 - 1) * 8) + i3 < 16) {
                for (int i5 = 0; i5 < i4; i5++) {
                    int i6 = (i5 * 8) + i3;
                    s = (short) ((s & (~(255 << i6))) | ((bArr[i5 + i2] & 255) << i6));
                }
                return s;
            }
            throw new IllegalArgumentException("(nBytes-1)*8+dstPos is greather or equal to than 16");
        }
        return invokeCommon.shortValue;
    }

    public static UUID byteArrayToUuid(byte[] bArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65551, null, bArr, i2)) == null) {
            if (bArr.length - i2 >= 16) {
                return new UUID(byteArrayToLong(bArr, i2, 0L, 0, 8), byteArrayToLong(bArr, i2 + 8, 0L, 0, 8));
            }
            throw new IllegalArgumentException("Need at least 16 bytes for UUID");
        }
        return (UUID) invokeLI.objValue;
    }

    public static boolean[] byteToBinary(byte b2, int i2, boolean[] zArr, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65552, null, new Object[]{Byte.valueOf(b2), Integer.valueOf(i2), zArr, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            if (i4 == 0) {
                return zArr;
            }
            if ((i4 - 1) + i2 < 8) {
                for (int i5 = 0; i5 < i4; i5++) {
                    int i6 = i3 + i5;
                    boolean z = true;
                    if (((b2 >> (i5 + i2)) & 1) == 0) {
                        z = false;
                    }
                    zArr[i6] = z;
                }
                return zArr;
            }
            throw new IllegalArgumentException("nBools-1+srcPos is greather or equal to than 8");
        }
        return (boolean[]) invokeCommon.objValue;
    }

    public static String byteToHex(byte b2, int i2, String str, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65553, null, new Object[]{Byte.valueOf(b2), Integer.valueOf(i2), str, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            if (i4 == 0) {
                return str;
            }
            if (((i4 - 1) * 4) + i2 < 8) {
                StringBuilder sb = new StringBuilder(str);
                int length = sb.length();
                for (int i5 = 0; i5 < i4; i5++) {
                    int i6 = (b2 >> ((i5 * 4) + i2)) & 15;
                    int i7 = i3 + i5;
                    if (i7 == length) {
                        length++;
                        sb.append(intToHexDigit(i6));
                    } else {
                        sb.setCharAt(i7, intToHexDigit(i6));
                    }
                }
                return sb.toString();
            }
            throw new IllegalArgumentException("(nHexs-1)*4+srcPos is greather or equal to than 8");
        }
        return (String) invokeCommon.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean[] hexDigitMsb0ToBinary(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65554, null, new Object[]{Character.valueOf(c2)})) == null) {
            switch (c2) {
                case '0':
                    return (boolean[]) FFFF.clone();
                case '1':
                    return (boolean[]) FFFT.clone();
                case '2':
                    return (boolean[]) FFTF.clone();
                case '3':
                    return (boolean[]) FFTT.clone();
                case '4':
                    return (boolean[]) FTFF.clone();
                case '5':
                    return (boolean[]) FTFT.clone();
                case '6':
                    return (boolean[]) FTTF.clone();
                case '7':
                    return (boolean[]) FTTT.clone();
                case '8':
                    return (boolean[]) TFFF.clone();
                case '9':
                    return (boolean[]) TFFT.clone();
                default:
                    switch (c2) {
                        case 'A':
                            return (boolean[]) TFTF.clone();
                        case 'B':
                            return (boolean[]) TFTT.clone();
                        case 'C':
                            return (boolean[]) TTFF.clone();
                        case 'D':
                            return (boolean[]) TTFT.clone();
                        case 'E':
                            return (boolean[]) TTTF.clone();
                        case 'F':
                            return (boolean[]) TTTT.clone();
                        default:
                            switch (c2) {
                                case 'a':
                                    break;
                                case 'b':
                                    break;
                                case 'c':
                                    break;
                                case 'd':
                                    break;
                                case 'e':
                                    break;
                                case 'f':
                                    break;
                                default:
                                    throw new IllegalArgumentException("Cannot interpret '" + c2 + "' as a hexadecimal digit");
                            }
                    }
            }
        } else {
            return (boolean[]) invokeCommon.objValue;
        }
    }

    public static int hexDigitMsb0ToInt(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65555, null, new Object[]{Character.valueOf(c2)})) == null) {
            switch (c2) {
                case '0':
                    return 0;
                case '1':
                    return 8;
                case '2':
                    return 4;
                case '3':
                    return 12;
                case '4':
                    return 2;
                case '5':
                    return 10;
                case '6':
                    return 6;
                case '7':
                    return 14;
                case '8':
                    return 1;
                case '9':
                    return 9;
                default:
                    switch (c2) {
                        case 'A':
                            return 5;
                        case 'B':
                            return 13;
                        case 'C':
                            return 3;
                        case 'D':
                            return 11;
                        case 'E':
                            return 7;
                        case 'F':
                            return 15;
                        default:
                            switch (c2) {
                                case 'a':
                                    return 5;
                                case 'b':
                                    return 13;
                                case 'c':
                                    return 3;
                                case 'd':
                                    return 11;
                                case 'e':
                                    return 7;
                                case 'f':
                                    return 15;
                                default:
                                    throw new IllegalArgumentException("Cannot interpret '" + c2 + "' as a hexadecimal digit");
                            }
                    }
            }
        }
        return invokeCommon.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean[] hexDigitToBinary(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65556, null, new Object[]{Character.valueOf(c2)})) == null) {
            switch (c2) {
                case '0':
                    return (boolean[]) FFFF.clone();
                case '1':
                    return (boolean[]) TFFF.clone();
                case '2':
                    return (boolean[]) FTFF.clone();
                case '3':
                    return (boolean[]) TTFF.clone();
                case '4':
                    return (boolean[]) FFTF.clone();
                case '5':
                    return (boolean[]) TFTF.clone();
                case '6':
                    return (boolean[]) FTTF.clone();
                case '7':
                    return (boolean[]) TTTF.clone();
                case '8':
                    return (boolean[]) FFFT.clone();
                case '9':
                    return (boolean[]) TFFT.clone();
                default:
                    switch (c2) {
                        case 'A':
                            return (boolean[]) FTFT.clone();
                        case 'B':
                            return (boolean[]) TTFT.clone();
                        case 'C':
                            return (boolean[]) FFTT.clone();
                        case 'D':
                            return (boolean[]) TFTT.clone();
                        case 'E':
                            return (boolean[]) FTTT.clone();
                        case 'F':
                            return (boolean[]) TTTT.clone();
                        default:
                            switch (c2) {
                                case 'a':
                                    break;
                                case 'b':
                                    break;
                                case 'c':
                                    break;
                                case 'd':
                                    break;
                                case 'e':
                                    break;
                                case 'f':
                                    break;
                                default:
                                    throw new IllegalArgumentException("Cannot interpret '" + c2 + "' as a hexadecimal digit");
                            }
                    }
            }
        } else {
            return (boolean[]) invokeCommon.objValue;
        }
    }

    public static int hexDigitToInt(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65557, null, new Object[]{Character.valueOf(c2)})) == null) {
            int digit = Character.digit(c2, 16);
            if (digit >= 0) {
                return digit;
            }
            throw new IllegalArgumentException("Cannot interpret '" + c2 + "' as a hexadecimal digit");
        }
        return invokeCommon.intValue;
    }

    public static byte hexToByte(String str, int i2, byte b2, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65558, null, new Object[]{str, Integer.valueOf(i2), Byte.valueOf(b2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            if (i4 == 0) {
                return b2;
            }
            if (((i4 - 1) * 4) + i3 < 8) {
                for (int i5 = 0; i5 < i4; i5++) {
                    int i6 = (i5 * 4) + i3;
                    b2 = (byte) ((b2 & (~(15 << i6))) | ((hexDigitToInt(str.charAt(i5 + i2)) & 15) << i6));
                }
                return b2;
            }
            throw new IllegalArgumentException("(nHexs-1)*4+dstPos is greather or equal to than 8");
        }
        return invokeCommon.byteValue;
    }

    public static int hexToInt(String str, int i2, int i3, int i4, int i5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65559, null, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
            if (i5 == 0) {
                return i3;
            }
            if (((i5 - 1) * 4) + i4 < 32) {
                for (int i6 = 0; i6 < i5; i6++) {
                    int i7 = (i6 * 4) + i4;
                    i3 = (i3 & (~(15 << i7))) | ((hexDigitToInt(str.charAt(i6 + i2)) & 15) << i7);
                }
                return i3;
            }
            throw new IllegalArgumentException("(nHexs-1)*4+dstPos is greather or equal to than 32");
        }
        return invokeCommon.intValue;
    }

    public static long hexToLong(String str, int i2, long j2, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65560, null, new Object[]{str, Integer.valueOf(i2), Long.valueOf(j2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            if (i4 == 0) {
                return j2;
            }
            if (((i4 - 1) * 4) + i3 < 64) {
                for (int i5 = 0; i5 < i4; i5++) {
                    int i6 = (i5 * 4) + i3;
                    j2 = (j2 & (~(15 << i6))) | ((hexDigitToInt(str.charAt(i5 + i2)) & 15) << i6);
                }
                return j2;
            }
            throw new IllegalArgumentException("(nHexs-1)*4+dstPos is greather or equal to than 64");
        }
        return invokeCommon.longValue;
    }

    public static short hexToShort(String str, int i2, short s, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65561, null, new Object[]{str, Integer.valueOf(i2), Short.valueOf(s), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            if (i4 == 0) {
                return s;
            }
            if (((i4 - 1) * 4) + i3 < 16) {
                for (int i5 = 0; i5 < i4; i5++) {
                    int i6 = (i5 * 4) + i3;
                    s = (short) ((s & (~(15 << i6))) | ((hexDigitToInt(str.charAt(i5 + i2)) & 15) << i6));
                }
                return s;
            }
            throw new IllegalArgumentException("(nHexs-1)*4+dstPos is greather or equal to than 16");
        }
        return invokeCommon.shortValue;
    }

    public static long intArrayToLong(int[] iArr, int i2, long j2, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65562, null, new Object[]{iArr, Integer.valueOf(i2), Long.valueOf(j2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            if ((iArr.length == 0 && i2 == 0) || i4 == 0) {
                return j2;
            }
            if (((i4 - 1) * 32) + i3 < 64) {
                for (int i5 = 0; i5 < i4; i5++) {
                    int i6 = (i5 * 32) + i3;
                    j2 = (j2 & (~(4294967295 << i6))) | ((iArr[i5 + i2] & 4294967295L) << i6);
                }
                return j2;
            }
            throw new IllegalArgumentException("(nInts-1)*32+dstPos is greather or equal to than 64");
        }
        return invokeCommon.longValue;
    }

    public static boolean[] intToBinary(int i2, int i3, boolean[] zArr, int i4, int i5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65563, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), zArr, Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
            if (i5 == 0) {
                return zArr;
            }
            if ((i5 - 1) + i3 < 32) {
                for (int i6 = 0; i6 < i5; i6++) {
                    int i7 = i4 + i6;
                    boolean z = true;
                    if (((i2 >> (i6 + i3)) & 1) == 0) {
                        z = false;
                    }
                    zArr[i7] = z;
                }
                return zArr;
            }
            throw new IllegalArgumentException("nBools-1+srcPos is greather or equal to than 32");
        }
        return (boolean[]) invokeCommon.objValue;
    }

    public static byte[] intToByteArray(int i2, int i3, byte[] bArr, int i4, int i5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65564, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), bArr, Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
            if (i5 == 0) {
                return bArr;
            }
            if (((i5 - 1) * 8) + i3 < 32) {
                for (int i6 = 0; i6 < i5; i6++) {
                    bArr[i4 + i6] = (byte) ((i2 >> ((i6 * 8) + i3)) & 255);
                }
                return bArr;
            }
            throw new IllegalArgumentException("(nBytes-1)*8+srcPos is greather or equal to than 32");
        }
        return (byte[]) invokeCommon.objValue;
    }

    public static String intToHex(int i2, int i3, String str, int i4, int i5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65565, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
            if (i5 == 0) {
                return str;
            }
            if (((i5 - 1) * 4) + i3 < 32) {
                StringBuilder sb = new StringBuilder(str);
                int length = sb.length();
                for (int i6 = 0; i6 < i5; i6++) {
                    int i7 = (i2 >> ((i6 * 4) + i3)) & 15;
                    int i8 = i4 + i6;
                    if (i8 == length) {
                        length++;
                        sb.append(intToHexDigit(i7));
                    } else {
                        sb.setCharAt(i8, intToHexDigit(i7));
                    }
                }
                return sb.toString();
            }
            throw new IllegalArgumentException("(nHexs-1)*4+srcPos is greather or equal to than 32");
        }
        return (String) invokeCommon.objValue;
    }

    public static char intToHexDigit(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65566, null, i2)) == null) {
            char forDigit = Character.forDigit(i2, 16);
            if (forDigit != 0) {
                return forDigit;
            }
            throw new IllegalArgumentException("nibble value not between 0 and 15: " + i2);
        }
        return invokeI.charValue;
    }

    public static char intToHexDigitMsb0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65567, null, i2)) == null) {
            switch (i2) {
                case 0:
                    return '0';
                case 1:
                    return '8';
                case 2:
                    return '4';
                case 3:
                    return 'c';
                case 4:
                    return '2';
                case 5:
                    return 'a';
                case 6:
                    return '6';
                case 7:
                    return 'e';
                case 8:
                    return '1';
                case 9:
                    return '9';
                case 10:
                    return '5';
                case 11:
                    return 'd';
                case 12:
                    return '3';
                case 13:
                    return 'b';
                case 14:
                    return '7';
                case 15:
                    return 'f';
                default:
                    throw new IllegalArgumentException("nibble value not between 0 and 15: " + i2);
            }
        }
        return invokeI.charValue;
    }

    public static short[] intToShortArray(int i2, int i3, short[] sArr, int i4, int i5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65568, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), sArr, Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
            if (i5 == 0) {
                return sArr;
            }
            if (((i5 - 1) * 16) + i3 < 32) {
                for (int i6 = 0; i6 < i5; i6++) {
                    sArr[i4 + i6] = (short) ((i2 >> ((i6 * 16) + i3)) & 65535);
                }
                return sArr;
            }
            throw new IllegalArgumentException("(nShorts-1)*16+srcPos is greather or equal to than 32");
        }
        return (short[]) invokeCommon.objValue;
    }

    public static boolean[] longToBinary(long j2, int i2, boolean[] zArr, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65569, null, new Object[]{Long.valueOf(j2), Integer.valueOf(i2), zArr, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            if (i4 == 0) {
                return zArr;
            }
            if ((i4 - 1) + i2 < 64) {
                for (int i5 = 0; i5 < i4; i5++) {
                    zArr[i3 + i5] = (1 & (j2 >> (i5 + i2))) != 0;
                }
                return zArr;
            }
            throw new IllegalArgumentException("nBools-1+srcPos is greather or equal to than 64");
        }
        return (boolean[]) invokeCommon.objValue;
    }

    public static byte[] longToByteArray(long j2, int i2, byte[] bArr, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65570, null, new Object[]{Long.valueOf(j2), Integer.valueOf(i2), bArr, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            if (i4 == 0) {
                return bArr;
            }
            if (((i4 - 1) * 8) + i2 < 64) {
                for (int i5 = 0; i5 < i4; i5++) {
                    bArr[i3 + i5] = (byte) (255 & (j2 >> ((i5 * 8) + i2)));
                }
                return bArr;
            }
            throw new IllegalArgumentException("(nBytes-1)*8+srcPos is greather or equal to than 64");
        }
        return (byte[]) invokeCommon.objValue;
    }

    public static String longToHex(long j2, int i2, String str, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65571, null, new Object[]{Long.valueOf(j2), Integer.valueOf(i2), str, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            if (i4 == 0) {
                return str;
            }
            if (((i4 - 1) * 4) + i2 < 64) {
                StringBuilder sb = new StringBuilder(str);
                int length = sb.length();
                for (int i5 = 0; i5 < i4; i5++) {
                    int i6 = (int) ((j2 >> ((i5 * 4) + i2)) & 15);
                    int i7 = i3 + i5;
                    if (i7 == length) {
                        length++;
                        sb.append(intToHexDigit(i6));
                    } else {
                        sb.setCharAt(i7, intToHexDigit(i6));
                    }
                }
                return sb.toString();
            }
            throw new IllegalArgumentException("(nHexs-1)*4+srcPos is greather or equal to than 64");
        }
        return (String) invokeCommon.objValue;
    }

    public static int[] longToIntArray(long j2, int i2, int[] iArr, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65572, null, new Object[]{Long.valueOf(j2), Integer.valueOf(i2), iArr, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            if (i4 == 0) {
                return iArr;
            }
            if (((i4 - 1) * 32) + i2 < 64) {
                for (int i5 = 0; i5 < i4; i5++) {
                    iArr[i3 + i5] = (int) ((-1) & (j2 >> ((i5 * 32) + i2)));
                }
                return iArr;
            }
            throw new IllegalArgumentException("(nInts-1)*32+srcPos is greather or equal to than 64");
        }
        return (int[]) invokeCommon.objValue;
    }

    public static short[] longToShortArray(long j2, int i2, short[] sArr, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65573, null, new Object[]{Long.valueOf(j2), Integer.valueOf(i2), sArr, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            if (i4 == 0) {
                return sArr;
            }
            if (((i4 - 1) * 16) + i2 < 64) {
                for (int i5 = 0; i5 < i4; i5++) {
                    sArr[i3 + i5] = (short) (WebSocketProtocol.PAYLOAD_SHORT_MAX & (j2 >> ((i5 * 16) + i2)));
                }
                return sArr;
            }
            throw new IllegalArgumentException("(nShorts-1)*16+srcPos is greather or equal to than 64");
        }
        return (short[]) invokeCommon.objValue;
    }

    public static int shortArrayToInt(short[] sArr, int i2, int i3, int i4, int i5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65574, null, new Object[]{sArr, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
            if ((sArr.length == 0 && i2 == 0) || i5 == 0) {
                return i3;
            }
            if (((i5 - 1) * 16) + i4 < 32) {
                for (int i6 = 0; i6 < i5; i6++) {
                    int i7 = (i6 * 16) + i4;
                    i3 = (i3 & (~(65535 << i7))) | ((sArr[i6 + i2] & UShort.MAX_VALUE) << i7);
                }
                return i3;
            }
            throw new IllegalArgumentException("(nShorts-1)*16+dstPos is greather or equal to than 32");
        }
        return invokeCommon.intValue;
    }

    public static long shortArrayToLong(short[] sArr, int i2, long j2, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65575, null, new Object[]{sArr, Integer.valueOf(i2), Long.valueOf(j2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            if ((sArr.length == 0 && i2 == 0) || i4 == 0) {
                return j2;
            }
            if (((i4 - 1) * 16) + i3 < 64) {
                for (int i5 = 0; i5 < i4; i5++) {
                    int i6 = (i5 * 16) + i3;
                    j2 = (j2 & (~(WebSocketProtocol.PAYLOAD_SHORT_MAX << i6))) | ((sArr[i5 + i2] & WebSocketProtocol.PAYLOAD_SHORT_MAX) << i6);
                }
                return j2;
            }
            throw new IllegalArgumentException("(nShorts-1)*16+dstPos is greather or equal to than 64");
        }
        return invokeCommon.longValue;
    }

    public static boolean[] shortToBinary(short s, int i2, boolean[] zArr, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65576, null, new Object[]{Short.valueOf(s), Integer.valueOf(i2), zArr, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            if (i4 == 0) {
                return zArr;
            }
            if ((i4 - 1) + i2 < 16) {
                for (int i5 = 0; i5 < i4; i5++) {
                    int i6 = i3 + i5;
                    boolean z = true;
                    if (((s >> (i5 + i2)) & 1) == 0) {
                        z = false;
                    }
                    zArr[i6] = z;
                }
                return zArr;
            }
            throw new IllegalArgumentException("nBools-1+srcPos is greather or equal to than 16");
        }
        return (boolean[]) invokeCommon.objValue;
    }

    public static byte[] shortToByteArray(short s, int i2, byte[] bArr, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65577, null, new Object[]{Short.valueOf(s), Integer.valueOf(i2), bArr, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            if (i4 == 0) {
                return bArr;
            }
            if (((i4 - 1) * 8) + i2 < 16) {
                for (int i5 = 0; i5 < i4; i5++) {
                    bArr[i3 + i5] = (byte) ((s >> ((i5 * 8) + i2)) & 255);
                }
                return bArr;
            }
            throw new IllegalArgumentException("(nBytes-1)*8+srcPos is greather or equal to than 16");
        }
        return (byte[]) invokeCommon.objValue;
    }

    public static String shortToHex(short s, int i2, String str, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65578, null, new Object[]{Short.valueOf(s), Integer.valueOf(i2), str, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            if (i4 == 0) {
                return str;
            }
            if (((i4 - 1) * 4) + i2 < 16) {
                StringBuilder sb = new StringBuilder(str);
                int length = sb.length();
                for (int i5 = 0; i5 < i4; i5++) {
                    int i6 = (s >> ((i5 * 4) + i2)) & 15;
                    int i7 = i3 + i5;
                    if (i7 == length) {
                        length++;
                        sb.append(intToHexDigit(i6));
                    } else {
                        sb.setCharAt(i7, intToHexDigit(i6));
                    }
                }
                return sb.toString();
            }
            throw new IllegalArgumentException("(nHexs-1)*4+srcPos is greather or equal to than 16");
        }
        return (String) invokeCommon.objValue;
    }

    public static byte[] uuidToByteArray(UUID uuid, byte[] bArr, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65579, null, uuid, bArr, i2, i3)) == null) {
            if (i3 == 0) {
                return bArr;
            }
            if (i3 <= 16) {
                longToByteArray(uuid.getMostSignificantBits(), 0, bArr, i2, i3 > 8 ? 8 : i3);
                if (i3 >= 8) {
                    longToByteArray(uuid.getLeastSignificantBits(), 0, bArr, i2 + 8, i3 - 8);
                }
                return bArr;
            }
            throw new IllegalArgumentException("nBytes is greather than 16");
        }
        return (byte[]) invokeLLII.objValue;
    }

    public static char binaryBeMsb0ToHexDigit(boolean[] zArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, zArr, i2)) == null) {
            if (zArr.length != 0) {
                int length = ((zArr.length - 1) - i2) + 1;
                int min = Math.min(4, length);
                boolean[] zArr2 = new boolean[4];
                System.arraycopy(zArr, length - min, zArr2, 4 - min, min);
                return zArr2[0] ? zArr2[1] ? zArr2[2] ? zArr2[3] ? 'f' : 'e' : zArr2[3] ? 'd' : 'c' : zArr2[2] ? zArr2[3] ? 'b' : 'a' : zArr2[3] ? '9' : '8' : zArr2[1] ? zArr2[2] ? zArr2[3] ? '7' : '6' : zArr2[3] ? '5' : '4' : zArr2[2] ? zArr2[3] ? '3' : '2' : zArr2[3] ? '1' : '0';
            }
            throw new IllegalArgumentException("Cannot convert an empty array.");
        }
        return invokeLI.charValue;
    }

    public static char binaryToHexDigit(boolean[] zArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, zArr, i2)) == null) {
            if (zArr.length != 0) {
                int i3 = i2 + 3;
                if (zArr.length > i3 && zArr[i3]) {
                    int i4 = i2 + 2;
                    if (zArr.length <= i4 || !zArr[i4]) {
                        int i5 = i2 + 1;
                        return (zArr.length <= i5 || !zArr[i5]) ? zArr[i2] ? '9' : '8' : zArr[i2] ? 'b' : 'a';
                    }
                    int i6 = i2 + 1;
                    return (zArr.length <= i6 || !zArr[i6]) ? zArr[i2] ? 'd' : 'c' : zArr[i2] ? 'f' : 'e';
                }
                int i7 = i2 + 2;
                if (zArr.length <= i7 || !zArr[i7]) {
                    int i8 = i2 + 1;
                    return (zArr.length <= i8 || !zArr[i8]) ? zArr[i2] ? '1' : '0' : zArr[i2] ? '3' : '2';
                }
                int i9 = i2 + 1;
                return (zArr.length <= i9 || !zArr[i9]) ? zArr[i2] ? '5' : '4' : zArr[i2] ? '7' : '6';
            }
            throw new IllegalArgumentException("Cannot convert an empty array.");
        }
        return invokeLI.charValue;
    }

    public static char binaryToHexDigitMsb0_4bits(boolean[] zArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65544, null, zArr, i2)) == null) {
            if (zArr.length <= 8) {
                if (zArr.length - i2 >= 4) {
                    return zArr[i2 + 3] ? zArr[i2 + 2] ? zArr[i2 + 1] ? zArr[i2] ? 'f' : '7' : zArr[i2] ? 'b' : '3' : zArr[i2 + 1] ? zArr[i2] ? 'd' : '5' : zArr[i2] ? '9' : '1' : zArr[i2 + 2] ? zArr[i2 + 1] ? zArr[i2] ? 'e' : '6' : zArr[i2] ? 'a' : '2' : zArr[i2 + 1] ? zArr[i2] ? 'c' : '4' : zArr[i2] ? '8' : '0';
                }
                throw new IllegalArgumentException("src.length-srcPos<4: src.length=" + zArr.length + ", srcPos=" + i2);
            }
            throw new IllegalArgumentException("src.length>8: src.length=" + zArr.length);
        }
        return invokeLI.charValue;
    }
}
