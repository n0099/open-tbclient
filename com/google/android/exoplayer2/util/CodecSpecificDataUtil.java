package com.google.android.exoplayer2.util;

import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.ParserException;
import com.kuaishou.weapon.un.w0;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public final class CodecSpecificDataUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int AUDIO_OBJECT_TYPE_AAC_LC = 2;
    public static final int AUDIO_OBJECT_TYPE_ER_BSAC = 22;
    public static final int AUDIO_OBJECT_TYPE_ESCAPE = 31;
    public static final int AUDIO_OBJECT_TYPE_PS = 29;
    public static final int AUDIO_OBJECT_TYPE_SBR = 5;
    public static final int AUDIO_SPECIFIC_CONFIG_CHANNEL_CONFIGURATION_INVALID = -1;
    public static final int[] AUDIO_SPECIFIC_CONFIG_CHANNEL_COUNT_TABLE;
    public static final int AUDIO_SPECIFIC_CONFIG_FREQUENCY_INDEX_ARBITRARY = 15;
    public static final int[] AUDIO_SPECIFIC_CONFIG_SAMPLING_RATE_TABLE;
    public static final byte[] NAL_START_CODE;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(312275798, "Lcom/google/android/exoplayer2/util/CodecSpecificDataUtil;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(312275798, "Lcom/google/android/exoplayer2/util/CodecSpecificDataUtil;");
                return;
            }
        }
        NAL_START_CODE = new byte[]{0, 0, 0, 1};
        AUDIO_SPECIFIC_CONFIG_SAMPLING_RATE_TABLE = new int[]{96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, w0.X3, 11025, 8000, 7350};
        AUDIO_SPECIFIC_CONFIG_CHANNEL_COUNT_TABLE = new int[]{0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};
    }

    public CodecSpecificDataUtil() {
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

    public static byte[] buildAacAudioSpecificConfig(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIII = interceptable.invokeIII(65538, null, i2, i3, i4)) == null) ? new byte[]{(byte) (((i2 << 3) & 248) | ((i3 >> 1) & 7)), (byte) (((i3 << 7) & 128) | ((i4 << 3) & 120))} : (byte[]) invokeIII.objValue;
    }

    public static byte[] buildAacLcAudioSpecificConfig(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65539, null, i2, i3)) == null) {
            int i4 = 0;
            int i5 = 0;
            int i6 = -1;
            while (true) {
                int[] iArr = AUDIO_SPECIFIC_CONFIG_SAMPLING_RATE_TABLE;
                if (i5 >= iArr.length) {
                    break;
                }
                if (i2 == iArr[i5]) {
                    i6 = i5;
                }
                i5++;
            }
            int i7 = -1;
            while (true) {
                int[] iArr2 = AUDIO_SPECIFIC_CONFIG_CHANNEL_COUNT_TABLE;
                if (i4 >= iArr2.length) {
                    break;
                }
                if (i3 == iArr2[i4]) {
                    i7 = i4;
                }
                i4++;
            }
            if (i2 != -1 && i7 != -1) {
                return buildAacAudioSpecificConfig(2, i6, i7);
            }
            throw new IllegalArgumentException("Invalid sample rate or number of channels: " + i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i3);
        }
        return (byte[]) invokeII.objValue;
    }

    public static byte[] buildNalUnit(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr, i2, i3)) == null) {
            byte[] bArr2 = NAL_START_CODE;
            byte[] bArr3 = new byte[bArr2.length + i3];
            System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
            System.arraycopy(bArr, i2, bArr3, NAL_START_CODE.length, i3);
            return bArr3;
        }
        return (byte[]) invokeLII.objValue;
    }

    public static int findNalStartCode(byte[] bArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65541, null, bArr, i2)) == null) {
            int length = bArr.length - NAL_START_CODE.length;
            while (i2 <= length) {
                if (isNalStartCode(bArr, i2)) {
                    return i2;
                }
                i2++;
            }
            return -1;
        }
        return invokeLI.intValue;
    }

    public static int getAacAudioObjectType(ParsableBitArray parsableBitArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, parsableBitArray)) == null) {
            int readBits = parsableBitArray.readBits(5);
            return readBits == 31 ? parsableBitArray.readBits(6) + 32 : readBits;
        }
        return invokeL.intValue;
    }

    public static int getAacSamplingFrequency(ParsableBitArray parsableBitArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, parsableBitArray)) == null) {
            int readBits = parsableBitArray.readBits(4);
            if (readBits == 15) {
                return parsableBitArray.readBits(24);
            }
            Assertions.checkArgument(readBits < 13);
            return AUDIO_SPECIFIC_CONFIG_SAMPLING_RATE_TABLE[readBits];
        }
        return invokeL.intValue;
    }

    public static boolean isNalStartCode(byte[] bArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLI = interceptable.invokeLI(65544, null, bArr, i2)) != null) {
            return invokeLI.booleanValue;
        }
        if (bArr.length - i2 <= NAL_START_CODE.length) {
            return false;
        }
        int i3 = 0;
        while (true) {
            byte[] bArr2 = NAL_START_CODE;
            if (i3 >= bArr2.length) {
                return true;
            }
            if (bArr[i2 + i3] != bArr2[i3]) {
                return false;
            }
            i3++;
        }
    }

    public static Pair<Integer, Integer> parseAacAudioSpecificConfig(byte[] bArr) throws ParserException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, bArr)) == null) ? parseAacAudioSpecificConfig(new ParsableBitArray(bArr), false) : (Pair) invokeL.objValue;
    }

    public static void parseGaSpecificConfig(ParsableBitArray parsableBitArray, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65547, null, parsableBitArray, i2, i3) == null) {
            parsableBitArray.skipBits(1);
            if (parsableBitArray.readBit()) {
                parsableBitArray.skipBits(14);
            }
            boolean readBit = parsableBitArray.readBit();
            if (i3 == 0) {
                throw new UnsupportedOperationException();
            }
            if (i2 == 6 || i2 == 20) {
                parsableBitArray.skipBits(3);
            }
            if (readBit) {
                if (i2 == 22) {
                    parsableBitArray.skipBits(16);
                }
                if (i2 == 17 || i2 == 19 || i2 == 20 || i2 == 23) {
                    parsableBitArray.skipBits(3);
                }
                parsableBitArray.skipBits(1);
            }
        }
    }

    public static byte[][] splitNalUnits(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, bArr)) == null) {
            if (isNalStartCode(bArr, 0)) {
                ArrayList arrayList = new ArrayList();
                int i2 = 0;
                do {
                    arrayList.add(Integer.valueOf(i2));
                    i2 = findNalStartCode(bArr, i2 + NAL_START_CODE.length);
                } while (i2 != -1);
                byte[][] bArr2 = new byte[arrayList.size()];
                int i3 = 0;
                while (i3 < arrayList.size()) {
                    int intValue = ((Integer) arrayList.get(i3)).intValue();
                    int intValue2 = (i3 < arrayList.size() + (-1) ? ((Integer) arrayList.get(i3 + 1)).intValue() : bArr.length) - intValue;
                    byte[] bArr3 = new byte[intValue2];
                    System.arraycopy(bArr, intValue, bArr3, 0, intValue2);
                    bArr2[i3] = bArr3;
                    i3++;
                }
                return bArr2;
            }
            return null;
        }
        return (byte[][]) invokeL.objValue;
    }

    public static Pair<Integer, Integer> parseAacAudioSpecificConfig(ParsableBitArray parsableBitArray, boolean z) throws ParserException {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65545, null, parsableBitArray, z)) == null) {
            int aacAudioObjectType = getAacAudioObjectType(parsableBitArray);
            int aacSamplingFrequency = getAacSamplingFrequency(parsableBitArray);
            int readBits = parsableBitArray.readBits(4);
            if (aacAudioObjectType == 5 || aacAudioObjectType == 29) {
                aacSamplingFrequency = getAacSamplingFrequency(parsableBitArray);
                aacAudioObjectType = getAacAudioObjectType(parsableBitArray);
                if (aacAudioObjectType == 22) {
                    readBits = parsableBitArray.readBits(4);
                }
            }
            if (z) {
                if (aacAudioObjectType != 1 && aacAudioObjectType != 2 && aacAudioObjectType != 3 && aacAudioObjectType != 4 && aacAudioObjectType != 6 && aacAudioObjectType != 7 && aacAudioObjectType != 17) {
                    switch (aacAudioObjectType) {
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                            break;
                        default:
                            throw new ParserException("Unsupported audio object type: " + aacAudioObjectType);
                    }
                }
                parseGaSpecificConfig(parsableBitArray, aacAudioObjectType, readBits);
                switch (aacAudioObjectType) {
                    case 17:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        int readBits2 = parsableBitArray.readBits(2);
                        if (readBits2 == 2 || readBits2 == 3) {
                            throw new ParserException("Unsupported epConfig: " + readBits2);
                        }
                }
            }
            int i2 = AUDIO_SPECIFIC_CONFIG_CHANNEL_COUNT_TABLE[readBits];
            Assertions.checkArgument(i2 != -1);
            return Pair.create(Integer.valueOf(aacSamplingFrequency), Integer.valueOf(i2));
        }
        return (Pair) invokeLZ.objValue;
    }
}
