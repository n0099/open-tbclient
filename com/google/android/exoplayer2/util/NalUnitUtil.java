package com.google.android.exoplayer2.util;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
import java.util.Arrays;
/* loaded from: classes7.dex */
public final class NalUnitUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final float[] ASPECT_RATIO_IDC_VALUES;
    public static final int EXTENDED_SAR = 255;
    public static final int H264_NAL_UNIT_TYPE_SEI = 6;
    public static final int H264_NAL_UNIT_TYPE_SPS = 7;
    public static final int H265_NAL_UNIT_TYPE_PREFIX_SEI = 39;
    public static final byte[] NAL_START_CODE;
    public static final String TAG = "NalUnitUtil";
    public static int[] scratchEscapePositions;
    public static final Object scratchEscapePositionsLock;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public final class PpsData {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final boolean bottomFieldPicOrderInFramePresentFlag;
        public final int picParameterSetId;
        public final int seqParameterSetId;

        public PpsData(int i, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.picParameterSetId = i;
            this.seqParameterSetId = i2;
            this.bottomFieldPicOrderInFramePresentFlag = z;
        }
    }

    /* loaded from: classes7.dex */
    public final class SpsData {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final boolean deltaPicOrderAlwaysZeroFlag;
        public final boolean frameMbsOnlyFlag;
        public final int frameNumLength;
        public final int height;
        public final int picOrderCntLsbLength;
        public final int picOrderCountType;
        public final float pixelWidthAspectRatio;
        public final boolean separateColorPlaneFlag;
        public final int seqParameterSetId;
        public final int width;

        public SpsData(int i, int i2, int i3, float f, boolean z, boolean z2, int i4, int i5, int i6, boolean z3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f), Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Boolean.valueOf(z3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i7 = newInitContext.flag;
                if ((i7 & 1) != 0) {
                    int i8 = i7 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.seqParameterSetId = i;
            this.width = i2;
            this.height = i3;
            this.pixelWidthAspectRatio = f;
            this.separateColorPlaneFlag = z;
            this.frameMbsOnlyFlag = z2;
            this.frameNumLength = i4;
            this.picOrderCountType = i5;
            this.picOrderCntLsbLength = i6;
            this.deltaPicOrderAlwaysZeroFlag = z3;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1652505109, "Lcom/google/android/exoplayer2/util/NalUnitUtil;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1652505109, "Lcom/google/android/exoplayer2/util/NalUnitUtil;");
                return;
            }
        }
        NAL_START_CODE = new byte[]{0, 0, 0, 1};
        ASPECT_RATIO_IDC_VALUES = new float[]{1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};
        scratchEscapePositionsLock = new Object();
        scratchEscapePositions = new int[10];
    }

    public NalUnitUtil() {
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

    public static void clearPrefixFlags(boolean[] zArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, zArr) == null) {
            zArr[0] = false;
            zArr[1] = false;
            zArr[2] = false;
        }
    }

    public static void discardToSps(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, byteBuffer) == null) {
            int position = byteBuffer.position();
            int i = 0;
            int i2 = 0;
            while (true) {
                int i3 = i + 1;
                if (i3 < position) {
                    int i4 = byteBuffer.get(i) & 255;
                    if (i2 == 3) {
                        if (i4 == 1 && (byteBuffer.get(i3) & 31) == 7) {
                            ByteBuffer duplicate = byteBuffer.duplicate();
                            duplicate.position(i - 3);
                            duplicate.limit(position);
                            byteBuffer.position(0);
                            byteBuffer.put(duplicate);
                            return;
                        }
                    } else if (i4 == 0) {
                        i2++;
                    }
                    if (i4 != 0) {
                        i2 = 0;
                    }
                    i = i3;
                } else {
                    byteBuffer.clear();
                    return;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:71:0x009b, code lost:
        r8 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int findNalUnit(byte[] bArr, int i, int i2, boolean[] zArr) {
        InterceptResult invokeCommon;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{bArr, Integer.valueOf(i), Integer.valueOf(i2), zArr})) == null) {
            int i3 = i2 - i;
            boolean z3 = false;
            if (i3 >= 0) {
                z = true;
            } else {
                z = false;
            }
            Assertions.checkState(z);
            if (i3 == 0) {
                return i2;
            }
            if (zArr != null) {
                if (zArr[0]) {
                    clearPrefixFlags(zArr);
                    return i - 3;
                } else if (i3 > 1 && zArr[1] && bArr[i] == 1) {
                    clearPrefixFlags(zArr);
                    return i - 2;
                } else if (i3 > 2 && zArr[2] && bArr[i] == 0 && bArr[i + 1] == 1) {
                    clearPrefixFlags(zArr);
                    return i - 1;
                }
            }
            int i4 = i2 - 1;
            int i5 = i + 2;
            while (i5 < i4) {
                if ((bArr[i5] & 254) == 0) {
                    int i6 = i5 - 2;
                    if (bArr[i6] == 0 && bArr[i5 - 1] == 0 && bArr[i5] == 1) {
                        if (zArr != null) {
                            clearPrefixFlags(zArr);
                        }
                        return i6;
                    }
                    i5 -= 2;
                }
                i5 += 3;
            }
            if (zArr != null) {
                boolean z4 = i3 > 2 ? false : false;
                zArr[0] = z4;
                if (i3 <= 1 ? !(!zArr[2] || bArr[i4] != 0) : !(bArr[i2 - 2] != 0 || bArr[i4] != 0)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                zArr[1] = z2;
                if (bArr[i4] == 0) {
                    z3 = true;
                }
                zArr[2] = z3;
            }
            return i2;
        }
        return invokeCommon.intValue;
    }

    public static int findNextUnescapeIndex(byte[] bArr, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65541, null, bArr, i, i2)) == null) {
            while (i < i2 - 2) {
                if (bArr[i] == 0 && bArr[i + 1] == 0 && bArr[i + 2] == 3) {
                    return i;
                }
                i++;
            }
            return i2;
        }
        return invokeLII.intValue;
    }

    public static int getH265NalUnitType(byte[] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, bArr, i)) == null) {
            return (bArr[i + 3] & 126) >> 1;
        }
        return invokeLI.intValue;
    }

    public static int getNalUnitType(byte[] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, bArr, i)) == null) {
            return bArr[i + 3] & 31;
        }
        return invokeLI.intValue;
    }

    public static void skipScalingList(ParsableNalUnitBitArray parsableNalUnitBitArray, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65547, null, parsableNalUnitBitArray, i) == null) {
            int i2 = 8;
            int i3 = 8;
            for (int i4 = 0; i4 < i; i4++) {
                if (i2 != 0) {
                    i2 = ((parsableNalUnitBitArray.readSignedExpGolombCodedInt() + i3) + 256) % 256;
                }
                if (i2 != 0) {
                    i3 = i2;
                }
            }
        }
    }

    public static boolean isNalUnitSei(String str, byte b) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{str, Byte.valueOf(b)})) == null) {
            if ("video/avc".equals(str) && (b & 31) == 6) {
                return true;
            }
            if (MimeTypes.VIDEO_H265.equals(str) && ((b & 126) >> 1) == 39) {
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static PpsData parsePpsNalUnit(byte[] bArr, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65545, null, bArr, i, i2)) == null) {
            ParsableNalUnitBitArray parsableNalUnitBitArray = new ParsableNalUnitBitArray(bArr, i, i2);
            parsableNalUnitBitArray.skipBits(8);
            int readUnsignedExpGolombCodedInt = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            int readUnsignedExpGolombCodedInt2 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            parsableNalUnitBitArray.skipBit();
            return new PpsData(readUnsignedExpGolombCodedInt, readUnsignedExpGolombCodedInt2, parsableNalUnitBitArray.readBit());
        }
        return (PpsData) invokeLII.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x014a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static SpsData parseSpsNalUnit(byte[] bArr, int i, int i2) {
        InterceptResult invokeLII;
        int readUnsignedExpGolombCodedInt;
        boolean z;
        boolean z2;
        int i3;
        int i4;
        int i5;
        int i6;
        boolean z3;
        boolean readBit;
        float f;
        int readBits;
        int i7;
        int i8;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65546, null, bArr, i, i2)) == null) {
            ParsableNalUnitBitArray parsableNalUnitBitArray = new ParsableNalUnitBitArray(bArr, i, i2);
            parsableNalUnitBitArray.skipBits(8);
            int readBits2 = parsableNalUnitBitArray.readBits(8);
            parsableNalUnitBitArray.skipBits(16);
            int readUnsignedExpGolombCodedInt2 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            int i9 = 1;
            if (readBits2 != 100 && readBits2 != 110 && readBits2 != 122 && readBits2 != 244 && readBits2 != 44 && readBits2 != 83 && readBits2 != 86 && readBits2 != 118 && readBits2 != 128 && readBits2 != 138) {
                readUnsignedExpGolombCodedInt = 1;
                z2 = false;
            } else {
                readUnsignedExpGolombCodedInt = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                if (readUnsignedExpGolombCodedInt == 3) {
                    z = parsableNalUnitBitArray.readBit();
                } else {
                    z = false;
                }
                parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                parsableNalUnitBitArray.skipBit();
                if (parsableNalUnitBitArray.readBit()) {
                    if (readUnsignedExpGolombCodedInt != 3) {
                        i3 = 8;
                    } else {
                        i3 = 12;
                    }
                    for (int i10 = 0; i10 < i3; i10++) {
                        if (parsableNalUnitBitArray.readBit()) {
                            if (i10 < 6) {
                                i4 = 16;
                            } else {
                                i4 = 64;
                            }
                            skipScalingList(parsableNalUnitBitArray, i4);
                        }
                    }
                }
                z2 = z;
            }
            int readUnsignedExpGolombCodedInt3 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 4;
            int readUnsignedExpGolombCodedInt4 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            if (readUnsignedExpGolombCodedInt4 == 0) {
                i5 = readUnsignedExpGolombCodedInt2;
                i6 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 4;
            } else if (readUnsignedExpGolombCodedInt4 == 1) {
                boolean readBit2 = parsableNalUnitBitArray.readBit();
                parsableNalUnitBitArray.readSignedExpGolombCodedInt();
                parsableNalUnitBitArray.readSignedExpGolombCodedInt();
                long readUnsignedExpGolombCodedInt5 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                i5 = readUnsignedExpGolombCodedInt2;
                for (int i11 = 0; i11 < readUnsignedExpGolombCodedInt5; i11++) {
                    parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                }
                z3 = readBit2;
                i6 = 0;
                parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                parsableNalUnitBitArray.skipBit();
                int readUnsignedExpGolombCodedInt6 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 1;
                readBit = parsableNalUnitBitArray.readBit();
                int readUnsignedExpGolombCodedInt7 = (2 - (readBit ? 1 : 0)) * (parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 1);
                if (!readBit) {
                    parsableNalUnitBitArray.skipBit();
                }
                parsableNalUnitBitArray.skipBit();
                int i12 = readUnsignedExpGolombCodedInt6 * 16;
                int i13 = readUnsignedExpGolombCodedInt7 * 16;
                if (parsableNalUnitBitArray.readBit()) {
                    int readUnsignedExpGolombCodedInt8 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                    int readUnsignedExpGolombCodedInt9 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                    int readUnsignedExpGolombCodedInt10 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                    int readUnsignedExpGolombCodedInt11 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                    if (readUnsignedExpGolombCodedInt == 0) {
                        i8 = 2 - (readBit ? 1 : 0);
                    } else {
                        if (readUnsignedExpGolombCodedInt == 3) {
                            i7 = 1;
                        } else {
                            i7 = 2;
                        }
                        if (readUnsignedExpGolombCodedInt == 1) {
                            i9 = 2;
                        }
                        i8 = (2 - (readBit ? 1 : 0)) * i9;
                        i9 = i7;
                    }
                    i12 -= (readUnsignedExpGolombCodedInt8 + readUnsignedExpGolombCodedInt9) * i9;
                    i13 -= (readUnsignedExpGolombCodedInt10 + readUnsignedExpGolombCodedInt11) * i8;
                }
                int i14 = i13;
                int i15 = i12;
                float f2 = 1.0f;
                if (parsableNalUnitBitArray.readBit() && parsableNalUnitBitArray.readBit()) {
                    readBits = parsableNalUnitBitArray.readBits(8);
                    if (readBits != 255) {
                        int readBits3 = parsableNalUnitBitArray.readBits(16);
                        int readBits4 = parsableNalUnitBitArray.readBits(16);
                        if (readBits3 != 0 && readBits4 != 0) {
                            f2 = readBits3 / readBits4;
                        }
                        f = f2;
                    } else {
                        float[] fArr = ASPECT_RATIO_IDC_VALUES;
                        if (readBits < fArr.length) {
                            f = fArr[readBits];
                        } else {
                            Log.w(TAG, "Unexpected aspect_ratio_idc value: " + readBits);
                        }
                    }
                    return new SpsData(i5, i15, i14, f, z2, readBit, readUnsignedExpGolombCodedInt3, readUnsignedExpGolombCodedInt4, i6, z3);
                }
                f = 1.0f;
                return new SpsData(i5, i15, i14, f, z2, readBit, readUnsignedExpGolombCodedInt3, readUnsignedExpGolombCodedInt4, i6, z3);
            } else {
                i5 = readUnsignedExpGolombCodedInt2;
                i6 = 0;
            }
            z3 = false;
            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            parsableNalUnitBitArray.skipBit();
            int readUnsignedExpGolombCodedInt62 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 1;
            readBit = parsableNalUnitBitArray.readBit();
            int readUnsignedExpGolombCodedInt72 = (2 - (readBit ? 1 : 0)) * (parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 1);
            if (!readBit) {
            }
            parsableNalUnitBitArray.skipBit();
            int i122 = readUnsignedExpGolombCodedInt62 * 16;
            int i132 = readUnsignedExpGolombCodedInt72 * 16;
            if (parsableNalUnitBitArray.readBit()) {
            }
            int i142 = i132;
            int i152 = i122;
            float f22 = 1.0f;
            if (parsableNalUnitBitArray.readBit()) {
                readBits = parsableNalUnitBitArray.readBits(8);
                if (readBits != 255) {
                }
                return new SpsData(i5, i152, i142, f, z2, readBit, readUnsignedExpGolombCodedInt3, readUnsignedExpGolombCodedInt4, i6, z3);
            }
            f = 1.0f;
            return new SpsData(i5, i152, i142, f, z2, readBit, readUnsignedExpGolombCodedInt3, readUnsignedExpGolombCodedInt4, i6, z3);
        }
        return (SpsData) invokeLII.objValue;
    }

    public static int unescapeStream(byte[] bArr, int i) {
        InterceptResult invokeLI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65548, null, bArr, i)) == null) {
            synchronized (scratchEscapePositionsLock) {
                int i3 = 0;
                int i4 = 0;
                while (i3 < i) {
                    try {
                        i3 = findNextUnescapeIndex(bArr, i3, i);
                        if (i3 < i) {
                            if (scratchEscapePositions.length <= i4) {
                                scratchEscapePositions = Arrays.copyOf(scratchEscapePositions, scratchEscapePositions.length * 2);
                            }
                            scratchEscapePositions[i4] = i3;
                            i3 += 3;
                            i4++;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                i2 = i - i4;
                int i5 = 0;
                int i6 = 0;
                for (int i7 = 0; i7 < i4; i7++) {
                    int i8 = scratchEscapePositions[i7] - i6;
                    System.arraycopy(bArr, i6, bArr, i5, i8);
                    int i9 = i5 + i8;
                    int i10 = i9 + 1;
                    bArr[i9] = 0;
                    i5 = i10 + 1;
                    bArr[i10] = 0;
                    i6 += i8 + 3;
                }
                System.arraycopy(bArr, i6, bArr, i5, i2 - i5);
            }
            return i2;
        }
        return invokeLI.intValue;
    }
}
