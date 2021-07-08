package com.google.zxing.qrcode.encoder;

import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitArray;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Version;
/* loaded from: classes6.dex */
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
        POSITION_ADJUSTMENT_PATTERN_COORDINATE_TABLE = new int[][]{new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, 102, -1, -1}, new int[]{6, 28, 54, 80, 106, -1, -1}, new int[]{6, 32, 58, 84, 110, -1, -1}, new int[]{6, 30, 58, 86, 114, -1, -1}, new int[]{6, 34, 62, 90, 118, -1, -1}, new int[]{6, 26, 50, 74, 98, 122, -1}, new int[]{6, 30, 54, 78, 102, 126, -1}, new int[]{6, 26, 52, 78, 104, IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER, -1}, new int[]{6, 30, 56, 82, 108, 134, -1}, new int[]{6, 34, 60, 86, 112, 138, -1}, new int[]{6, 30, 58, 86, 114, 142, -1}, new int[]{6, 34, 62, 90, 118, 146, -1}, new int[]{6, 30, 54, 78, 102, 126, 150}, new int[]{6, 24, 50, 76, 102, 128, Opcodes.IFNE}, new int[]{6, 28, 54, 80, 106, 132, 158}, new int[]{6, 32, 58, 84, 110, 136, 162}, new int[]{6, 26, 54, 82, 110, 138, 166}, new int[]{6, 30, 58, 86, 114, 142, Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID}};
        TYPE_INFO_COORDINATES = new int[][]{new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};
    }

    public MatrixUtil() {
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

    public static void buildMatrix(BitArray bitArray, ErrorCorrectionLevel errorCorrectionLevel, Version version, int i2, ByteMatrix byteMatrix) throws WriterException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{bitArray, errorCorrectionLevel, version, Integer.valueOf(i2), byteMatrix}) == null) {
            clearMatrix(byteMatrix);
            embedBasicPatterns(version, byteMatrix);
            embedTypeInfo(errorCorrectionLevel, i2, byteMatrix);
            maybeEmbedVersionInfo(version, byteMatrix);
            embedDataBits(bitArray, i2, byteMatrix);
        }
    }

    public static int calculateBCHCode(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65539, null, i2, i3)) == null) {
            if (i3 != 0) {
                int findMSBSet = findMSBSet(i3);
                int i4 = i2 << (findMSBSet - 1);
                while (findMSBSet(i4) >= findMSBSet) {
                    i4 ^= i3 << (findMSBSet(i4) - findMSBSet);
                }
                return i4;
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
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, version, byteMatrix) == null) {
            embedPositionDetectionPatternsAndSeparators(byteMatrix);
            embedDarkDotAtLeftBottomCorner(byteMatrix);
            maybeEmbedPositionAdjustmentPatterns(version, byteMatrix);
            embedTimingPatterns(byteMatrix);
        }
    }

    public static void embedDarkDotAtLeftBottomCorner(ByteMatrix byteMatrix) throws WriterException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, byteMatrix) == null) {
            if (byteMatrix.get(8, byteMatrix.getHeight() - 8) != 0) {
                byteMatrix.set(8, byteMatrix.getHeight() - 8, 1);
                return;
            }
            throw new WriterException();
        }
    }

    public static void embedDataBits(BitArray bitArray, int i2, ByteMatrix byteMatrix) throws WriterException {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65543, null, bitArray, i2, byteMatrix) == null) {
            int width = byteMatrix.getWidth() - 1;
            int height = byteMatrix.getHeight() - 1;
            int i3 = 0;
            int i4 = -1;
            while (width > 0) {
                if (width == 6) {
                    width--;
                }
                while (height >= 0 && height < byteMatrix.getHeight()) {
                    for (int i5 = 0; i5 < 2; i5++) {
                        int i6 = width - i5;
                        if (isEmpty(byteMatrix.get(i6, height))) {
                            if (i3 < bitArray.getSize()) {
                                z = bitArray.get(i3);
                                i3++;
                            } else {
                                z = false;
                            }
                            if (i2 != -1 && MaskUtil.getDataMaskBit(i2, i6, height)) {
                                z = !z;
                            }
                            byteMatrix.set(i6, height, z);
                        }
                    }
                    height += i4;
                }
                i4 = -i4;
                height += i4;
                width -= 2;
            }
            if (i3 == bitArray.getSize()) {
                return;
            }
            throw new WriterException("Not all bits consumed: " + i3 + '/' + bitArray.getSize());
        }
    }

    public static void embedHorizontalSeparationPattern(int i2, int i3, ByteMatrix byteMatrix) throws WriterException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(65544, null, i2, i3, byteMatrix) == null) {
            for (int i4 = 0; i4 < 8; i4++) {
                int i5 = i2 + i4;
                if (isEmpty(byteMatrix.get(i5, i3))) {
                    byteMatrix.set(i5, i3, 0);
                } else {
                    throw new WriterException();
                }
            }
        }
    }

    public static void embedPositionAdjustmentPattern(int i2, int i3, ByteMatrix byteMatrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(65545, null, i2, i3, byteMatrix) == null) {
            for (int i4 = 0; i4 < 5; i4++) {
                for (int i5 = 0; i5 < 5; i5++) {
                    byteMatrix.set(i2 + i5, i3 + i4, POSITION_ADJUSTMENT_PATTERN[i4][i5]);
                }
            }
        }
    }

    public static void embedPositionDetectionPattern(int i2, int i3, ByteMatrix byteMatrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(65546, null, i2, i3, byteMatrix) == null) {
            for (int i4 = 0; i4 < 7; i4++) {
                for (int i5 = 0; i5 < 7; i5++) {
                    byteMatrix.set(i2 + i5, i3 + i4, POSITION_DETECTION_PATTERN[i4][i5]);
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
            int i2 = 8;
            while (i2 < byteMatrix.getWidth() - 8) {
                int i3 = i2 + 1;
                int i4 = i3 % 2;
                if (isEmpty(byteMatrix.get(i2, 6))) {
                    byteMatrix.set(i2, 6, i4);
                }
                if (isEmpty(byteMatrix.get(6, i2))) {
                    byteMatrix.set(6, i2, i4);
                }
                i2 = i3;
            }
        }
    }

    public static void embedTypeInfo(ErrorCorrectionLevel errorCorrectionLevel, int i2, ByteMatrix byteMatrix) throws WriterException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65549, null, errorCorrectionLevel, i2, byteMatrix) == null) {
            BitArray bitArray = new BitArray();
            makeTypeInfoBits(errorCorrectionLevel, i2, bitArray);
            for (int i3 = 0; i3 < bitArray.getSize(); i3++) {
                boolean z = bitArray.get((bitArray.getSize() - 1) - i3);
                int[][] iArr = TYPE_INFO_COORDINATES;
                byteMatrix.set(iArr[i3][0], iArr[i3][1], z);
                if (i3 < 8) {
                    byteMatrix.set((byteMatrix.getWidth() - i3) - 1, 8, z);
                } else {
                    byteMatrix.set(8, (byteMatrix.getHeight() - 7) + (i3 - 8), z);
                }
            }
        }
    }

    public static void embedVerticalSeparationPattern(int i2, int i3, ByteMatrix byteMatrix) throws WriterException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(65550, null, i2, i3, byteMatrix) == null) {
            for (int i4 = 0; i4 < 7; i4++) {
                int i5 = i3 + i4;
                if (isEmpty(byteMatrix.get(i2, i5))) {
                    byteMatrix.set(i2, i5, 0);
                } else {
                    throw new WriterException();
                }
            }
        }
    }

    public static int findMSBSet(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65551, null, i2)) == null) ? 32 - Integer.numberOfLeadingZeros(i2) : invokeI.intValue;
    }

    public static boolean isEmpty(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65552, null, i2)) == null) ? i2 == -1 : invokeI.booleanValue;
    }

    public static void makeTypeInfoBits(ErrorCorrectionLevel errorCorrectionLevel, int i2, BitArray bitArray) throws WriterException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65553, null, errorCorrectionLevel, i2, bitArray) == null) {
            if (QRCode.isValidMaskPattern(i2)) {
                int bits = (errorCorrectionLevel.getBits() << 3) | i2;
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
        for (int i2 = 0; i2 < length; i2++) {
            for (int i3 = 0; i3 < length; i3++) {
                int i4 = iArr2[i2];
                int i5 = iArr2[i3];
                if (i5 != -1 && i4 != -1 && isEmpty(byteMatrix.get(i5, i4))) {
                    embedPositionAdjustmentPattern(i5 - 2, i4 - 2, byteMatrix);
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
        int i2 = 17;
        for (int i3 = 0; i3 < 6; i3++) {
            for (int i4 = 0; i4 < 3; i4++) {
                boolean z = bitArray.get(i2);
                i2--;
                byteMatrix.set(i3, (byteMatrix.getHeight() - 11) + i4, z);
                byteMatrix.set((byteMatrix.getHeight() - 11) + i4, i3, z);
            }
        }
    }
}
