package com.google.zxing.qrcode.encoder;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.location.BDLocation;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitArray;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Version;
/* loaded from: classes7.dex */
public final class MatrixUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int[][] POSITION_ADJUSTMENT_PATTERN;
    public static final int[][] POSITION_ADJUSTMENT_PATTERN_COORDINATE_TABLE;
    public static final int[][] POSITION_DETECTION_PATTERN;
    public static final int[][] TYPE_INFO_COORDINATES;
    public static final int TYPE_INFO_MASK_PATTERN = 21522;
    public static final int TYPE_INFO_POLY = 1335;
    public static final int VERSION_INFO_POLY = 7973;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-785911701, "Lcom/google/zxing/qrcode/encoder/MatrixUtil;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-785911701, "Lcom/google/zxing/qrcode/encoder/MatrixUtil;");
                return;
            }
        }
        POSITION_DETECTION_PATTERN = new int[][]{new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};
        POSITION_ADJUSTMENT_PATTERN = new int[][]{new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};
        POSITION_ADJUSTMENT_PATTERN_COORDINATE_TABLE = new int[][]{new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, 102, -1, -1}, new int[]{6, 28, 54, 80, 106, -1, -1}, new int[]{6, 32, 58, 84, 110, -1, -1}, new int[]{6, 30, 58, 86, 114, -1, -1}, new int[]{6, 34, 62, 90, 118, -1, -1}, new int[]{6, 26, 50, 74, 98, 122, -1}, new int[]{6, 30, 54, 78, 102, 126, -1}, new int[]{6, 26, 52, 78, 104, 130, -1}, new int[]{6, 30, 56, 82, 108, 134, -1}, new int[]{6, 34, 60, 86, 112, 138, -1}, new int[]{6, 30, 58, 86, 114, Cea708Decoder.COMMAND_DLC, -1}, new int[]{6, 34, 62, 90, 118, Cea708Decoder.COMMAND_SPL, -1}, new int[]{6, 30, 54, 78, 102, 126, 150}, new int[]{6, 24, 50, 76, 102, 128, Cea708Decoder.COMMAND_DF2}, new int[]{6, 28, 54, 80, 106, 132, Cea708Decoder.COMMAND_DF6}, new int[]{6, 32, 58, 84, 110, 136, BDLocation.TypeServerDecryptError}, new int[]{6, 26, 54, 82, 110, 138, TTAdConstant.IMAGE_MODE_LIVE}, new int[]{6, 30, 58, 86, 114, Cea708Decoder.COMMAND_DLC, Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID}};
        TYPE_INFO_COORDINATES = new int[][]{new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};
    }

    public MatrixUtil() {
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

    public static void buildMatrix(BitArray bitArray, ErrorCorrectionLevel errorCorrectionLevel, Version version, int i, ByteMatrix byteMatrix) throws WriterException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{bitArray, errorCorrectionLevel, version, Integer.valueOf(i), byteMatrix}) == null) {
            clearMatrix(byteMatrix);
            embedBasicPatterns(version, byteMatrix);
            embedTypeInfo(errorCorrectionLevel, i, byteMatrix);
            maybeEmbedVersionInfo(version, byteMatrix);
            embedDataBits(bitArray, i, byteMatrix);
        }
    }

    public static int calculateBCHCode(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65539, null, i, i2)) == null) {
            if (i2 != 0) {
                int findMSBSet = findMSBSet(i2);
                int i3 = i << (findMSBSet - 1);
                while (findMSBSet(i3) >= findMSBSet) {
                    i3 ^= i2 << (findMSBSet(i3) - findMSBSet);
                }
                return i3;
            }
            throw new IllegalArgumentException("0 polynomial");
        }
        return invokeII.intValue;
    }

    public static void clearMatrix(ByteMatrix byteMatrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, byteMatrix) == null) {
            byteMatrix.clear((byte) -1);
        }
    }

    public static void embedBasicPatterns(Version version, ByteMatrix byteMatrix) throws WriterException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, version, byteMatrix) == null) {
            embedPositionDetectionPatternsAndSeparators(byteMatrix);
            embedDarkDotAtLeftBottomCorner(byteMatrix);
            maybeEmbedPositionAdjustmentPatterns(version, byteMatrix);
            embedTimingPatterns(byteMatrix);
        }
    }

    public static void embedDarkDotAtLeftBottomCorner(ByteMatrix byteMatrix) throws WriterException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, byteMatrix) == null) {
            if (byteMatrix.get(8, byteMatrix.getHeight() - 8) != 0) {
                byteMatrix.set(8, byteMatrix.getHeight() - 8, 1);
                return;
            }
            throw new WriterException();
        }
    }

    public static void embedDataBits(BitArray bitArray, int i, ByteMatrix byteMatrix) throws WriterException {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65543, null, bitArray, i, byteMatrix) == null) {
            int width = byteMatrix.getWidth() - 1;
            int height = byteMatrix.getHeight() - 1;
            int i2 = 0;
            int i3 = -1;
            while (width > 0) {
                if (width == 6) {
                    width--;
                }
                while (height >= 0 && height < byteMatrix.getHeight()) {
                    for (int i4 = 0; i4 < 2; i4++) {
                        int i5 = width - i4;
                        if (isEmpty(byteMatrix.get(i5, height))) {
                            if (i2 < bitArray.getSize()) {
                                z = bitArray.get(i2);
                                i2++;
                            } else {
                                z = false;
                            }
                            if (i != -1 && MaskUtil.getDataMaskBit(i, i5, height)) {
                                z = !z;
                            }
                            byteMatrix.set(i5, height, z);
                        }
                    }
                    height += i3;
                }
                i3 = -i3;
                height += i3;
                width -= 2;
            }
            if (i2 == bitArray.getSize()) {
                return;
            }
            throw new WriterException("Not all bits consumed: " + i2 + WebvttCueParser.CHAR_SLASH + bitArray.getSize());
        }
    }

    public static void embedHorizontalSeparationPattern(int i, int i2, ByteMatrix byteMatrix) throws WriterException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(65544, null, i, i2, byteMatrix) == null) {
            for (int i3 = 0; i3 < 8; i3++) {
                int i4 = i + i3;
                if (isEmpty(byteMatrix.get(i4, i2))) {
                    byteMatrix.set(i4, i2, 0);
                } else {
                    throw new WriterException();
                }
            }
        }
    }

    public static void embedPositionAdjustmentPattern(int i, int i2, ByteMatrix byteMatrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(65545, null, i, i2, byteMatrix) == null) {
            for (int i3 = 0; i3 < 5; i3++) {
                for (int i4 = 0; i4 < 5; i4++) {
                    byteMatrix.set(i + i4, i2 + i3, POSITION_ADJUSTMENT_PATTERN[i3][i4]);
                }
            }
        }
    }

    public static void embedPositionDetectionPattern(int i, int i2, ByteMatrix byteMatrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(65546, null, i, i2, byteMatrix) == null) {
            for (int i3 = 0; i3 < 7; i3++) {
                for (int i4 = 0; i4 < 7; i4++) {
                    byteMatrix.set(i + i4, i2 + i3, POSITION_DETECTION_PATTERN[i3][i4]);
                }
            }
        }
    }

    public static void embedPositionDetectionPatternsAndSeparators(ByteMatrix byteMatrix) throws WriterException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, byteMatrix) == null) {
            int length = POSITION_DETECTION_PATTERN[0].length;
            embedPositionDetectionPattern(0, 0, byteMatrix);
            embedPositionDetectionPattern(byteMatrix.getWidth() - length, 0, byteMatrix);
            embedPositionDetectionPattern(0, byteMatrix.getWidth() - length, byteMatrix);
            embedHorizontalSeparationPattern(0, 7, byteMatrix);
            embedHorizontalSeparationPattern(byteMatrix.getWidth() - 8, 7, byteMatrix);
            embedHorizontalSeparationPattern(0, byteMatrix.getWidth() - 8, byteMatrix);
            embedVerticalSeparationPattern(7, 0, byteMatrix);
            embedVerticalSeparationPattern((byteMatrix.getHeight() - 7) - 1, 0, byteMatrix);
            embedVerticalSeparationPattern(7, byteMatrix.getHeight() - 7, byteMatrix);
        }
    }

    public static void embedTimingPatterns(ByteMatrix byteMatrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, byteMatrix) == null) {
            int i = 8;
            while (i < byteMatrix.getWidth() - 8) {
                int i2 = i + 1;
                int i3 = i2 % 2;
                if (isEmpty(byteMatrix.get(i, 6))) {
                    byteMatrix.set(i, 6, i3);
                }
                if (isEmpty(byteMatrix.get(6, i))) {
                    byteMatrix.set(6, i, i3);
                }
                i = i2;
            }
        }
    }

    public static void embedTypeInfo(ErrorCorrectionLevel errorCorrectionLevel, int i, ByteMatrix byteMatrix) throws WriterException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65549, null, errorCorrectionLevel, i, byteMatrix) == null) {
            BitArray bitArray = new BitArray();
            makeTypeInfoBits(errorCorrectionLevel, i, bitArray);
            for (int i2 = 0; i2 < bitArray.getSize(); i2++) {
                boolean z = bitArray.get((bitArray.getSize() - 1) - i2);
                int[][] iArr = TYPE_INFO_COORDINATES;
                byteMatrix.set(iArr[i2][0], iArr[i2][1], z);
                if (i2 < 8) {
                    byteMatrix.set((byteMatrix.getWidth() - i2) - 1, 8, z);
                } else {
                    byteMatrix.set(8, (byteMatrix.getHeight() - 7) + (i2 - 8), z);
                }
            }
        }
    }

    public static void embedVerticalSeparationPattern(int i, int i2, ByteMatrix byteMatrix) throws WriterException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(65550, null, i, i2, byteMatrix) == null) {
            for (int i3 = 0; i3 < 7; i3++) {
                int i4 = i2 + i3;
                if (isEmpty(byteMatrix.get(i, i4))) {
                    byteMatrix.set(i, i4, 0);
                } else {
                    throw new WriterException();
                }
            }
        }
    }

    public static int findMSBSet(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65551, null, i)) == null) ? 32 - Integer.numberOfLeadingZeros(i) : invokeI.intValue;
    }

    public static boolean isEmpty(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65552, null, i)) == null) ? i == -1 : invokeI.booleanValue;
    }

    public static void makeTypeInfoBits(ErrorCorrectionLevel errorCorrectionLevel, int i, BitArray bitArray) throws WriterException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65553, null, errorCorrectionLevel, i, bitArray) == null) {
            if (QRCode.isValidMaskPattern(i)) {
                int bits = (errorCorrectionLevel.getBits() << 3) | i;
                bitArray.appendBits(bits, 5);
                bitArray.appendBits(calculateBCHCode(bits, 1335), 10);
                BitArray bitArray2 = new BitArray();
                bitArray2.appendBits(21522, 15);
                bitArray.xor(bitArray2);
                if (bitArray.getSize() == 15) {
                    return;
                }
                throw new WriterException("should not happen but we got: " + bitArray.getSize());
            }
            throw new WriterException("Invalid mask pattern");
        }
    }

    public static void makeVersionInfoBits(Version version, BitArray bitArray) throws WriterException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65554, null, version, bitArray) == null) {
            bitArray.appendBits(version.getVersionNumber(), 6);
            bitArray.appendBits(calculateBCHCode(version.getVersionNumber(), VERSION_INFO_POLY), 12);
            if (bitArray.getSize() == 18) {
                return;
            }
            throw new WriterException("should not happen but we got: " + bitArray.getSize());
        }
    }

    public static void maybeEmbedPositionAdjustmentPatterns(Version version, ByteMatrix byteMatrix) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65555, null, version, byteMatrix) == null) || version.getVersionNumber() < 2) {
            return;
        }
        int versionNumber = version.getVersionNumber() - 1;
        int[][] iArr = POSITION_ADJUSTMENT_PATTERN_COORDINATE_TABLE;
        int[] iArr2 = iArr[versionNumber];
        int length = iArr[versionNumber].length;
        for (int i = 0; i < length; i++) {
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = iArr2[i];
                int i4 = iArr2[i2];
                if (i4 != -1 && i3 != -1 && isEmpty(byteMatrix.get(i4, i3))) {
                    embedPositionAdjustmentPattern(i4 - 2, i3 - 2, byteMatrix);
                }
            }
        }
    }

    public static void maybeEmbedVersionInfo(Version version, ByteMatrix byteMatrix) throws WriterException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65556, null, version, byteMatrix) == null) || version.getVersionNumber() < 7) {
            return;
        }
        BitArray bitArray = new BitArray();
        makeVersionInfoBits(version, bitArray);
        int i = 17;
        for (int i2 = 0; i2 < 6; i2++) {
            for (int i3 = 0; i3 < 3; i3++) {
                boolean z = bitArray.get(i);
                i--;
                byteMatrix.set(i2, (byteMatrix.getHeight() - 11) + i3, z);
                byteMatrix.set((byteMatrix.getHeight() - 11) + i3, i2, z);
            }
        }
    }
}
