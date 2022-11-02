package com.google.android.exoplayer2.util;

import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.appsearch.update.patchupdate.GDiffPatcher;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.ParserException;
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

    public static byte[] buildAacAudioSpecificConfig(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIII = interceptable.invokeIII(65538, null, i, i2, i3)) == null) ? new byte[]{(byte) (((i << 3) & GDiffPatcher.DATA_INT) | ((i2 >> 1) & 7)), (byte) (((i2 << 7) & 128) | ((i3 << 3) & 120))} : (byte[]) invokeIII.objValue;
    }

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
        AUDIO_SPECIFIC_CONFIG_SAMPLING_RATE_TABLE = new int[]{96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};
        AUDIO_SPECIFIC_CONFIG_CHANNEL_COUNT_TABLE = new int[]{0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};
    }

    public CodecSpecificDataUtil() {
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

    public static byte[] buildAacLcAudioSpecificConfig(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65539, null, i, i2)) == null) {
            int i3 = 0;
            int i4 = 0;
            int i5 = -1;
            while (true) {
                int[] iArr = AUDIO_SPECIFIC_CONFIG_SAMPLING_RATE_TABLE;
                if (i4 >= iArr.length) {
                    break;
                }
                if (i == iArr[i4]) {
                    i5 = i4;
                }
                i4++;
            }
            int i6 = -1;
            while (true) {
                int[] iArr2 = AUDIO_SPECIFIC_CONFIG_CHANNEL_COUNT_TABLE;
                if (i3 >= iArr2.length) {
                    break;
                }
                if (i2 == iArr2[i3]) {
                    i6 = i3;
                }
                i3++;
            }
            if (i != -1 && i6 != -1) {
                return buildAacAudioSpecificConfig(2, i5, i6);
            }
            throw new IllegalArgumentException("Invalid sample rate or number of channels: " + i + StringUtil.ARRAY_ELEMENT_SEPARATOR + i2);
        }
        return (byte[]) invokeII.objValue;
    }

    public static byte[] buildNalUnit(byte[] bArr, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr, i, i2)) == null) {
            byte[] bArr2 = NAL_START_CODE;
            byte[] bArr3 = new byte[bArr2.length + i2];
            System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
            System.arraycopy(bArr, i, bArr3, NAL_START_CODE.length, i2);
            return bArr3;
        }
        return (byte[]) invokeLII.objValue;
    }

    public static int findNalStartCode(byte[] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65541, null, bArr, i)) == null) {
            int length = bArr.length - NAL_START_CODE.length;
            while (i <= length) {
                if (isNalStartCode(bArr, i)) {
                    return i;
                }
                i++;
            }
            return -1;
        }
        return invokeLI.intValue;
    }

    public static boolean isNalStartCode(byte[] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65544, null, bArr, i)) == null) {
            if (bArr.length - i <= NAL_START_CODE.length) {
                return false;
            }
            int i2 = 0;
            while (true) {
                byte[] bArr2 = NAL_START_CODE;
                if (i2 < bArr2.length) {
                    if (bArr[i + i2] != bArr2[i2]) {
                        return false;
                    }
                    i2++;
                } else {
                    return true;
                }
            }
        } else {
            return invokeLI.booleanValue;
        }
    }

    public static int getAacAudioObjectType(ParsableBitArray parsableBitArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, parsableBitArray)) == null) {
            int readBits = parsableBitArray.readBits(5);
            if (readBits == 31) {
                return parsableBitArray.readBits(6) + 32;
            }
            return readBits;
        }
        return invokeL.intValue;
    }

    public static int getAacSamplingFrequency(ParsableBitArray parsableBitArray) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, parsableBitArray)) == null) {
            int readBits = parsableBitArray.readBits(4);
            if (readBits == 15) {
                return parsableBitArray.readBits(24);
            }
            if (readBits < 13) {
                z = true;
            } else {
                z = false;
            }
            Assertions.checkArgument(z);
            return AUDIO_SPECIFIC_CONFIG_SAMPLING_RATE_TABLE[readBits];
        }
        return invokeL.intValue;
    }

    public static Pair<Integer, Integer> parseAacAudioSpecificConfig(byte[] bArr) throws ParserException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, bArr)) == null) {
            return parseAacAudioSpecificConfig(new ParsableBitArray(bArr), false);
        }
        return (Pair) invokeL.objValue;
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
            boolean z2 = true;
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
            int i = AUDIO_SPECIFIC_CONFIG_CHANNEL_COUNT_TABLE[readBits];
            if (i == -1) {
                z2 = false;
            }
            Assertions.checkArgument(z2);
            return Pair.create(Integer.valueOf(aacSamplingFrequency), Integer.valueOf(i));
        }
        return (Pair) invokeLZ.objValue;
    }

    public static void parseGaSpecificConfig(ParsableBitArray parsableBitArray, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65547, null, parsableBitArray, i, i2) == null) {
            parsableBitArray.skipBits(1);
            if (parsableBitArray.readBit()) {
                parsableBitArray.skipBits(14);
            }
            boolean readBit = parsableBitArray.readBit();
            if (i2 != 0) {
                if (i == 6 || i == 20) {
                    parsableBitArray.skipBits(3);
                }
                if (readBit) {
                    if (i == 22) {
                        parsableBitArray.skipBits(16);
                    }
                    if (i == 17 || i == 19 || i == 20 || i == 23) {
                        parsableBitArray.skipBits(3);
                    }
                    parsableBitArray.skipBits(1);
                    return;
                }
                return;
            }
            throw new UnsupportedOperationException();
        }
    }

    public static byte[][] splitNalUnits(byte[] bArr) {
        InterceptResult invokeL;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, bArr)) == null) {
            if (!isNalStartCode(bArr, 0)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int i = 0;
            do {
                arrayList.add(Integer.valueOf(i));
                i = findNalStartCode(bArr, i + NAL_START_CODE.length);
            } while (i != -1);
            byte[][] bArr2 = new byte[arrayList.size()];
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                int intValue = ((Integer) arrayList.get(i2)).intValue();
                if (i2 < arrayList.size() - 1) {
                    length = ((Integer) arrayList.get(i2 + 1)).intValue();
                } else {
                    length = bArr.length;
                }
                int i3 = length - intValue;
                byte[] bArr3 = new byte[i3];
                System.arraycopy(bArr, intValue, bArr3, 0, i3);
                bArr2[i2] = bArr3;
            }
            return bArr2;
        }
        return (byte[][]) invokeL.objValue;
    }
}
