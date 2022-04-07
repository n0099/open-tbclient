package com.google.zxing.aztec.encoder;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.common.BitArray;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonEncoder;
/* loaded from: classes5.dex */
public final class Encoder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_AZTEC_LAYERS = 0;
    public static final int DEFAULT_EC_PERCENT = 33;
    public static final int MAX_NB_BITS = 32;
    public static final int MAX_NB_BITS_COMPACT = 4;
    public static final int[] WORD_SIZE;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(254813103, "Lcom/google/zxing/aztec/encoder/Encoder;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(254813103, "Lcom/google/zxing/aztec/encoder/Encoder;");
                return;
            }
        }
        WORD_SIZE = new int[]{4, 6, 6, 8, 8, 8, 8, 8, 8, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};
    }

    public Encoder() {
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

    public static int[] bitsToWords(BitArray bitArray, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65538, null, bitArray, i, i2)) == null) {
            int[] iArr = new int[i2];
            int size = bitArray.getSize() / i;
            for (int i3 = 0; i3 < size; i3++) {
                int i4 = 0;
                for (int i5 = 0; i5 < i; i5++) {
                    i4 |= bitArray.get((i3 * i) + i5) ? 1 << ((i - i5) - 1) : 0;
                }
                iArr[i3] = i4;
            }
            return iArr;
        }
        return (int[]) invokeLII.objValue;
    }

    public static void drawBullsEye(BitMatrix bitMatrix, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65539, null, bitMatrix, i, i2) == null) {
            for (int i3 = 0; i3 < i2; i3 += 2) {
                int i4 = i - i3;
                int i5 = i4;
                while (true) {
                    int i6 = i + i3;
                    if (i5 <= i6) {
                        bitMatrix.set(i5, i4);
                        bitMatrix.set(i5, i6);
                        bitMatrix.set(i4, i5);
                        bitMatrix.set(i6, i5);
                        i5++;
                    }
                }
            }
            int i7 = i - i2;
            bitMatrix.set(i7, i7);
            int i8 = i7 + 1;
            bitMatrix.set(i8, i7);
            bitMatrix.set(i7, i8);
            int i9 = i + i2;
            bitMatrix.set(i9, i7);
            bitMatrix.set(i9, i8);
            bitMatrix.set(i9, i9 - 1);
        }
    }

    public static void drawModeMessage(BitMatrix bitMatrix, boolean z, int i, BitArray bitArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{bitMatrix, Boolean.valueOf(z), Integer.valueOf(i), bitArray}) == null) {
            int i2 = i / 2;
            int i3 = 0;
            if (z) {
                while (i3 < 7) {
                    int i4 = (i2 - 3) + i3;
                    if (bitArray.get(i3)) {
                        bitMatrix.set(i4, i2 - 5);
                    }
                    if (bitArray.get(i3 + 7)) {
                        bitMatrix.set(i2 + 5, i4);
                    }
                    if (bitArray.get(20 - i3)) {
                        bitMatrix.set(i4, i2 + 5);
                    }
                    if (bitArray.get(27 - i3)) {
                        bitMatrix.set(i2 - 5, i4);
                    }
                    i3++;
                }
                return;
            }
            while (i3 < 10) {
                int i5 = (i2 - 5) + i3 + (i3 / 5);
                if (bitArray.get(i3)) {
                    bitMatrix.set(i5, i2 - 7);
                }
                if (bitArray.get(i3 + 10)) {
                    bitMatrix.set(i2 + 7, i5);
                }
                if (bitArray.get(29 - i3)) {
                    bitMatrix.set(i5, i2 + 7);
                }
                if (bitArray.get(39 - i3)) {
                    bitMatrix.set(i2 - 7, i5);
                }
                i3++;
            }
        }
    }

    public static AztecCode encode(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, bArr)) == null) ? encode(bArr, 33, 0) : (AztecCode) invokeL.objValue;
    }

    public static BitArray generateCheckWords(BitArray bitArray, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65543, null, bitArray, i, i2)) == null) {
            ReedSolomonEncoder reedSolomonEncoder = new ReedSolomonEncoder(getGF(i2));
            int i3 = i / i2;
            int[] bitsToWords = bitsToWords(bitArray, i2, i3);
            reedSolomonEncoder.encode(bitsToWords, i3 - (bitArray.getSize() / i2));
            BitArray bitArray2 = new BitArray();
            bitArray2.appendBits(0, i % i2);
            for (int i4 : bitsToWords) {
                bitArray2.appendBits(i4, i2);
            }
            return bitArray2;
        }
        return (BitArray) invokeLII.objValue;
    }

    public static BitArray generateModeMessage(boolean z, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            BitArray bitArray = new BitArray();
            if (z) {
                bitArray.appendBits(i - 1, 2);
                bitArray.appendBits(i2 - 1, 6);
                return generateCheckWords(bitArray, 28, 4);
            }
            bitArray.appendBits(i - 1, 5);
            bitArray.appendBits(i2 - 1, 11);
            return generateCheckWords(bitArray, 40, 4);
        }
        return (BitArray) invokeCommon.objValue;
    }

    public static GenericGF getGF(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65545, null, i)) == null) {
            if (i != 4) {
                if (i != 6) {
                    if (i != 8) {
                        if (i != 10) {
                            if (i == 12) {
                                return GenericGF.AZTEC_DATA_12;
                            }
                            throw new IllegalArgumentException("Unsupported word size " + i);
                        }
                        return GenericGF.AZTEC_DATA_10;
                    }
                    return GenericGF.AZTEC_DATA_8;
                }
                return GenericGF.AZTEC_DATA_6;
            }
            return GenericGF.AZTEC_PARAM;
        }
        return (GenericGF) invokeI.objValue;
    }

    public static BitArray stuffBits(BitArray bitArray, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65546, null, bitArray, i)) == null) {
            BitArray bitArray2 = new BitArray();
            int size = bitArray.getSize();
            int i2 = (1 << i) - 2;
            int i3 = 0;
            while (i3 < size) {
                int i4 = 0;
                for (int i5 = 0; i5 < i; i5++) {
                    int i6 = i3 + i5;
                    if (i6 >= size || bitArray.get(i6)) {
                        i4 |= 1 << ((i - 1) - i5);
                    }
                }
                int i7 = i4 & i2;
                if (i7 == i2) {
                    bitArray2.appendBits(i7, i);
                } else if (i7 == 0) {
                    bitArray2.appendBits(i4 | 1, i);
                } else {
                    bitArray2.appendBits(i4, i);
                    i3 += i;
                }
                i3--;
                i3 += i;
            }
            return bitArray2;
        }
        return (BitArray) invokeLI.objValue;
    }

    public static int totalBitsInLayer(int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            return ((z ? 88 : 112) + (i << 4)) * i;
        }
        return invokeCommon.intValue;
    }

    public static AztecCode encode(byte[] bArr, int i, int i2) {
        InterceptResult invokeLII;
        BitArray bitArray;
        int i3;
        boolean z;
        int i4;
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65542, null, bArr, i, i2)) == null) {
            BitArray encode = new HighLevelEncoder(bArr).encode();
            int size = ((encode.getSize() * i) / 100) + 11;
            int size2 = encode.getSize() + size;
            int i7 = 0;
            int i8 = 1;
            if (i2 != 0) {
                z = i2 < 0;
                i4 = Math.abs(i2);
                if (i4 <= (z ? 4 : 32)) {
                    i5 = totalBitsInLayer(i4, z);
                    i3 = WORD_SIZE[i4];
                    int i9 = i5 - (i5 % i3);
                    bitArray = stuffBits(encode, i3);
                    if (bitArray.getSize() + size <= i9) {
                        if (z && bitArray.getSize() > (i3 << 6)) {
                            throw new IllegalArgumentException("Data to large for user specified layer");
                        }
                    } else {
                        throw new IllegalArgumentException("Data to large for user specified layer");
                    }
                } else {
                    throw new IllegalArgumentException(String.format("Illegal value %s for layers", Integer.valueOf(i2)));
                }
            } else {
                BitArray bitArray2 = null;
                int i10 = 0;
                int i11 = 0;
                while (i10 <= 32) {
                    boolean z2 = i10 <= 3;
                    int i12 = z2 ? i10 + 1 : i10;
                    int i13 = totalBitsInLayer(i12, z2);
                    if (size2 <= i13) {
                        int[] iArr = WORD_SIZE;
                        if (i11 != iArr[i12]) {
                            int i14 = iArr[i12];
                            i11 = i14;
                            bitArray2 = stuffBits(encode, i14);
                        }
                        int i15 = i13 - (i13 % i11);
                        if ((!z2 || bitArray2.getSize() <= (i11 << 6)) && bitArray2.getSize() + size <= i15) {
                            bitArray = bitArray2;
                            i3 = i11;
                            z = z2;
                            i4 = i12;
                            i5 = i13;
                        }
                    }
                    i10++;
                    i7 = 0;
                    i8 = 1;
                }
                throw new IllegalArgumentException("Data too large for an Aztec code");
            }
            BitArray generateCheckWords = generateCheckWords(bitArray, i5, i3);
            int size3 = bitArray.getSize() / i3;
            BitArray generateModeMessage = generateModeMessage(z, i4, size3);
            int i16 = (z ? 11 : 14) + (i4 << 2);
            int[] iArr2 = new int[i16];
            int i17 = 2;
            if (z) {
                for (int i18 = 0; i18 < i16; i18++) {
                    iArr2[i18] = i18;
                }
                i6 = i16;
            } else {
                int i19 = i16 / 2;
                i6 = i16 + 1 + (((i19 - 1) / 15) * 2);
                int i20 = i6 / 2;
                for (int i21 = 0; i21 < i19; i21++) {
                    int i22 = (i21 / 15) + i21;
                    iArr2[(i19 - i21) - i8] = (i20 - i22) - 1;
                    iArr2[i19 + i21] = i22 + i20 + i8;
                }
            }
            BitMatrix bitMatrix = new BitMatrix(i6);
            int i23 = 0;
            int i24 = 0;
            while (i23 < i4) {
                int i25 = ((i4 - i23) << i17) + (z ? 9 : 12);
                int i26 = 0;
                while (i26 < i25) {
                    int i27 = i26 << 1;
                    while (i7 < i17) {
                        if (generateCheckWords.get(i24 + i27 + i7)) {
                            int i28 = i23 << 1;
                            bitMatrix.set(iArr2[i28 + i7], iArr2[i28 + i26]);
                        }
                        if (generateCheckWords.get((i25 << 1) + i24 + i27 + i7)) {
                            int i29 = i23 << 1;
                            bitMatrix.set(iArr2[i29 + i26], iArr2[((i16 - 1) - i29) - i7]);
                        }
                        if (generateCheckWords.get((i25 << 2) + i24 + i27 + i7)) {
                            int i30 = (i16 - 1) - (i23 << 1);
                            bitMatrix.set(iArr2[i30 - i7], iArr2[i30 - i26]);
                        }
                        if (generateCheckWords.get((i25 * 6) + i24 + i27 + i7)) {
                            int i31 = i23 << 1;
                            bitMatrix.set(iArr2[((i16 - 1) - i31) - i26], iArr2[i31 + i7]);
                        }
                        i7++;
                        i17 = 2;
                    }
                    i26++;
                    i7 = 0;
                    i17 = 2;
                }
                i24 += i25 << 3;
                i23++;
                i7 = 0;
                i17 = 2;
            }
            drawModeMessage(bitMatrix, z, i6, generateModeMessage);
            if (z) {
                drawBullsEye(bitMatrix, i6 / 2, 5);
            } else {
                int i32 = i6 / 2;
                drawBullsEye(bitMatrix, i32, 7);
                int i33 = 0;
                int i34 = 0;
                while (i34 < (i16 / 2) - 1) {
                    for (int i35 = i32 & 1; i35 < i6; i35 += 2) {
                        int i36 = i32 - i33;
                        bitMatrix.set(i36, i35);
                        int i37 = i32 + i33;
                        bitMatrix.set(i37, i35);
                        bitMatrix.set(i35, i36);
                        bitMatrix.set(i35, i37);
                    }
                    i34 += 15;
                    i33 += 16;
                }
            }
            AztecCode aztecCode = new AztecCode();
            aztecCode.setCompact(z);
            aztecCode.setSize(i6);
            aztecCode.setLayers(i4);
            aztecCode.setCodeWords(size3);
            aztecCode.setMatrix(bitMatrix);
            return aztecCode;
        }
        return (AztecCode) invokeLII.objValue;
    }
}
