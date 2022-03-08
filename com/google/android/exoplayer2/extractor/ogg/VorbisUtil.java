package com.google.android.exoplayer2.extractor.ogg;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Arrays;
/* loaded from: classes7.dex */
public final class VorbisUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "VorbisUtil";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static final class CodeBook {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int dimensions;
        public final int entries;
        public final boolean isOrdered;
        public final long[] lengthMap;
        public final int lookupType;

        public CodeBook(int i2, int i3, long[] jArr, int i4, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), jArr, Integer.valueOf(i4), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.dimensions = i2;
            this.entries = i3;
            this.lengthMap = jArr;
            this.lookupType = i4;
            this.isOrdered = z;
        }
    }

    /* loaded from: classes7.dex */
    public static final class CommentHeader {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String[] comments;
        public final int length;
        public final String vendor;

        public CommentHeader(String str, String[] strArr, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, strArr, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.vendor = str;
            this.comments = strArr;
            this.length = i2;
        }
    }

    /* loaded from: classes7.dex */
    public static final class Mode {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final boolean blockFlag;
        public final int mapping;
        public final int transformType;
        public final int windowType;

        public Mode(boolean z, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.blockFlag = z;
            this.windowType = i2;
            this.transformType = i3;
            this.mapping = i4;
        }
    }

    /* loaded from: classes7.dex */
    public static final class VorbisIdHeader {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int bitrateMax;
        public final int bitrateMin;
        public final int bitrateNominal;
        public final int blockSize0;
        public final int blockSize1;
        public final int channels;
        public final byte[] data;
        public final boolean framingFlag;
        public final long sampleRate;
        public final long version;

        public VorbisIdHeader(long j2, int i2, long j3, int i3, int i4, int i5, int i6, int i7, boolean z, byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {Long.valueOf(j2), Integer.valueOf(i2), Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Boolean.valueOf(z), bArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i8 = newInitContext.flag;
                if ((i8 & 1) != 0) {
                    int i9 = i8 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.version = j2;
            this.channels = i2;
            this.sampleRate = j3;
            this.bitrateMax = i3;
            this.bitrateNominal = i4;
            this.bitrateMin = i5;
            this.blockSize0 = i6;
            this.blockSize1 = i7;
            this.framingFlag = z;
            this.data = bArr;
        }

        public int getApproximateBitrate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                int i2 = this.bitrateNominal;
                return i2 == 0 ? (this.bitrateMin + this.bitrateMax) / 2 : i2;
            }
            return invokeV.intValue;
        }
    }

    public VorbisUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static int iLog(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) {
            int i3 = 0;
            while (i2 > 0) {
                i3++;
                i2 >>>= 1;
            }
            return i3;
        }
        return invokeI.intValue;
    }

    public static long mapType1QuantValues(long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) ? (long) Math.floor(Math.pow(j2, 1.0d / j3)) : invokeCommon.longValue;
    }

    public static CodeBook readBook(VorbisBitArray vorbisBitArray) throws ParserException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, vorbisBitArray)) == null) {
            if (vorbisBitArray.readBits(24) == 5653314) {
                int readBits = vorbisBitArray.readBits(16);
                int readBits2 = vorbisBitArray.readBits(24);
                long[] jArr = new long[readBits2];
                boolean readBit = vorbisBitArray.readBit();
                long j2 = 0;
                if (!readBit) {
                    boolean readBit2 = vorbisBitArray.readBit();
                    for (int i2 = 0; i2 < readBits2; i2++) {
                        if (readBit2) {
                            if (vorbisBitArray.readBit()) {
                                jArr[i2] = vorbisBitArray.readBits(5) + 1;
                            } else {
                                jArr[i2] = 0;
                            }
                        } else {
                            jArr[i2] = vorbisBitArray.readBits(5) + 1;
                        }
                    }
                } else {
                    int readBits3 = vorbisBitArray.readBits(5) + 1;
                    int i3 = 0;
                    while (i3 < readBits2) {
                        int readBits4 = vorbisBitArray.readBits(iLog(readBits2 - i3));
                        for (int i4 = 0; i4 < readBits4 && i3 < readBits2; i4++) {
                            jArr[i3] = readBits3;
                            i3++;
                        }
                        readBits3++;
                    }
                }
                int readBits5 = vorbisBitArray.readBits(4);
                if (readBits5 <= 2) {
                    if (readBits5 == 1 || readBits5 == 2) {
                        vorbisBitArray.skipBits(32);
                        vorbisBitArray.skipBits(32);
                        int readBits6 = vorbisBitArray.readBits(4) + 1;
                        vorbisBitArray.skipBits(1);
                        if (readBits5 != 1) {
                            j2 = readBits2 * readBits;
                        } else if (readBits != 0) {
                            j2 = mapType1QuantValues(readBits2, readBits);
                        }
                        vorbisBitArray.skipBits((int) (j2 * readBits6));
                    }
                    return new CodeBook(readBits, readBits2, jArr, readBits5, readBit);
                }
                throw new ParserException("lookup type greater than 2 not decodable: " + readBits5);
            }
            throw new ParserException("expected code book to start with [0x56, 0x43, 0x42] at " + vorbisBitArray.getPosition());
        }
        return (CodeBook) invokeL.objValue;
    }

    public static void readFloors(VorbisBitArray vorbisBitArray) throws ParserException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, vorbisBitArray) == null) {
            int readBits = vorbisBitArray.readBits(6) + 1;
            for (int i2 = 0; i2 < readBits; i2++) {
                int readBits2 = vorbisBitArray.readBits(16);
                if (readBits2 == 0) {
                    vorbisBitArray.skipBits(8);
                    vorbisBitArray.skipBits(16);
                    vorbisBitArray.skipBits(16);
                    vorbisBitArray.skipBits(6);
                    vorbisBitArray.skipBits(8);
                    int readBits3 = vorbisBitArray.readBits(4) + 1;
                    for (int i3 = 0; i3 < readBits3; i3++) {
                        vorbisBitArray.skipBits(8);
                    }
                } else if (readBits2 == 1) {
                    int readBits4 = vorbisBitArray.readBits(5);
                    int i4 = -1;
                    int[] iArr = new int[readBits4];
                    for (int i5 = 0; i5 < readBits4; i5++) {
                        iArr[i5] = vorbisBitArray.readBits(4);
                        if (iArr[i5] > i4) {
                            i4 = iArr[i5];
                        }
                    }
                    int i6 = i4 + 1;
                    int[] iArr2 = new int[i6];
                    for (int i7 = 0; i7 < i6; i7++) {
                        iArr2[i7] = vorbisBitArray.readBits(3) + 1;
                        int readBits5 = vorbisBitArray.readBits(2);
                        if (readBits5 > 0) {
                            vorbisBitArray.skipBits(8);
                        }
                        for (int i8 = 0; i8 < (1 << readBits5); i8++) {
                            vorbisBitArray.skipBits(8);
                        }
                    }
                    vorbisBitArray.skipBits(2);
                    int readBits6 = vorbisBitArray.readBits(4);
                    int i9 = 0;
                    int i10 = 0;
                    for (int i11 = 0; i11 < readBits4; i11++) {
                        i9 += iArr2[iArr[i11]];
                        while (i10 < i9) {
                            vorbisBitArray.skipBits(readBits6);
                            i10++;
                        }
                    }
                } else {
                    throw new ParserException("floor type greater than 1 not decodable: " + readBits2);
                }
            }
        }
    }

    public static void readMappings(int i2, VorbisBitArray vorbisBitArray) throws ParserException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65541, null, i2, vorbisBitArray) == null) {
            int readBits = vorbisBitArray.readBits(6) + 1;
            for (int i3 = 0; i3 < readBits; i3++) {
                int readBits2 = vorbisBitArray.readBits(16);
                if (readBits2 != 0) {
                    String str = "mapping type other than 0 not supported: " + readBits2;
                } else {
                    int readBits3 = vorbisBitArray.readBit() ? vorbisBitArray.readBits(4) + 1 : 1;
                    if (vorbisBitArray.readBit()) {
                        int readBits4 = vorbisBitArray.readBits(8) + 1;
                        for (int i4 = 0; i4 < readBits4; i4++) {
                            int i5 = i2 - 1;
                            vorbisBitArray.skipBits(iLog(i5));
                            vorbisBitArray.skipBits(iLog(i5));
                        }
                    }
                    if (vorbisBitArray.readBits(2) != 0) {
                        throw new ParserException("to reserved bits must be zero after mapping coupling steps");
                    }
                    if (readBits3 > 1) {
                        for (int i6 = 0; i6 < i2; i6++) {
                            vorbisBitArray.skipBits(4);
                        }
                    }
                    for (int i7 = 0; i7 < readBits3; i7++) {
                        vorbisBitArray.skipBits(8);
                        vorbisBitArray.skipBits(8);
                        vorbisBitArray.skipBits(8);
                    }
                }
            }
        }
    }

    public static Mode[] readModes(VorbisBitArray vorbisBitArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, vorbisBitArray)) == null) {
            int readBits = vorbisBitArray.readBits(6) + 1;
            Mode[] modeArr = new Mode[readBits];
            for (int i2 = 0; i2 < readBits; i2++) {
                modeArr[i2] = new Mode(vorbisBitArray.readBit(), vorbisBitArray.readBits(16), vorbisBitArray.readBits(16), vorbisBitArray.readBits(8));
            }
            return modeArr;
        }
        return (Mode[]) invokeL.objValue;
    }

    public static void readResidues(VorbisBitArray vorbisBitArray) throws ParserException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, vorbisBitArray) == null) {
            int readBits = vorbisBitArray.readBits(6) + 1;
            for (int i2 = 0; i2 < readBits; i2++) {
                if (vorbisBitArray.readBits(16) <= 2) {
                    vorbisBitArray.skipBits(24);
                    vorbisBitArray.skipBits(24);
                    vorbisBitArray.skipBits(24);
                    int readBits2 = vorbisBitArray.readBits(6) + 1;
                    vorbisBitArray.skipBits(8);
                    int[] iArr = new int[readBits2];
                    for (int i3 = 0; i3 < readBits2; i3++) {
                        iArr[i3] = ((vorbisBitArray.readBit() ? vorbisBitArray.readBits(5) : 0) * 8) + vorbisBitArray.readBits(3);
                    }
                    for (int i4 = 0; i4 < readBits2; i4++) {
                        for (int i5 = 0; i5 < 8; i5++) {
                            if ((iArr[i4] & (1 << i5)) != 0) {
                                vorbisBitArray.skipBits(8);
                            }
                        }
                    }
                } else {
                    throw new ParserException("residueType greater than 2 is not decodable");
                }
            }
        }
    }

    public static CommentHeader readVorbisCommentHeader(ParsableByteArray parsableByteArray) throws ParserException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, parsableByteArray)) == null) {
            verifyVorbisHeaderCapturePattern(3, parsableByteArray, false);
            String readString = parsableByteArray.readString((int) parsableByteArray.readLittleEndianUnsignedInt());
            int length = 11 + readString.length();
            long readLittleEndianUnsignedInt = parsableByteArray.readLittleEndianUnsignedInt();
            String[] strArr = new String[(int) readLittleEndianUnsignedInt];
            int i2 = length + 4;
            for (int i3 = 0; i3 < readLittleEndianUnsignedInt; i3++) {
                strArr[i3] = parsableByteArray.readString((int) parsableByteArray.readLittleEndianUnsignedInt());
                i2 = i2 + 4 + strArr[i3].length();
            }
            if ((parsableByteArray.readUnsignedByte() & 1) != 0) {
                return new CommentHeader(readString, strArr, i2 + 1);
            }
            throw new ParserException("framing bit expected to be set");
        }
        return (CommentHeader) invokeL.objValue;
    }

    public static VorbisIdHeader readVorbisIdentificationHeader(ParsableByteArray parsableByteArray) throws ParserException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, parsableByteArray)) == null) {
            verifyVorbisHeaderCapturePattern(1, parsableByteArray, false);
            long readLittleEndianUnsignedInt = parsableByteArray.readLittleEndianUnsignedInt();
            int readUnsignedByte = parsableByteArray.readUnsignedByte();
            long readLittleEndianUnsignedInt2 = parsableByteArray.readLittleEndianUnsignedInt();
            int readLittleEndianInt = parsableByteArray.readLittleEndianInt();
            int readLittleEndianInt2 = parsableByteArray.readLittleEndianInt();
            int readLittleEndianInt3 = parsableByteArray.readLittleEndianInt();
            int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
            return new VorbisIdHeader(readLittleEndianUnsignedInt, readUnsignedByte, readLittleEndianUnsignedInt2, readLittleEndianInt, readLittleEndianInt2, readLittleEndianInt3, (int) Math.pow(2.0d, readUnsignedByte2 & 15), (int) Math.pow(2.0d, (readUnsignedByte2 & 240) >> 4), (parsableByteArray.readUnsignedByte() & 1) > 0, Arrays.copyOf(parsableByteArray.data, parsableByteArray.limit()));
        }
        return (VorbisIdHeader) invokeL.objValue;
    }

    public static Mode[] readVorbisModes(ParsableByteArray parsableByteArray, int i2) throws ParserException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65546, null, parsableByteArray, i2)) == null) {
            verifyVorbisHeaderCapturePattern(5, parsableByteArray, false);
            int readUnsignedByte = parsableByteArray.readUnsignedByte() + 1;
            VorbisBitArray vorbisBitArray = new VorbisBitArray(parsableByteArray.data);
            vorbisBitArray.skipBits(parsableByteArray.getPosition() * 8);
            for (int i3 = 0; i3 < readUnsignedByte; i3++) {
                readBook(vorbisBitArray);
            }
            int readBits = vorbisBitArray.readBits(6) + 1;
            for (int i4 = 0; i4 < readBits; i4++) {
                if (vorbisBitArray.readBits(16) != 0) {
                    throw new ParserException("placeholder of time domain transforms not zeroed out");
                }
            }
            readFloors(vorbisBitArray);
            readResidues(vorbisBitArray);
            readMappings(i2, vorbisBitArray);
            Mode[] readModes = readModes(vorbisBitArray);
            if (vorbisBitArray.readBit()) {
                return readModes;
            }
            throw new ParserException("framing bit after modes not set as expected");
        }
        return (Mode[]) invokeLI.objValue;
    }

    public static boolean verifyVorbisHeaderCapturePattern(int i2, ParsableByteArray parsableByteArray, boolean z) throws ParserException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{Integer.valueOf(i2), parsableByteArray, Boolean.valueOf(z)})) == null) {
            if (parsableByteArray.bytesLeft() < 7) {
                if (z) {
                    return false;
                }
                throw new ParserException("too short header: " + parsableByteArray.bytesLeft());
            } else if (parsableByteArray.readUnsignedByte() != i2) {
                if (z) {
                    return false;
                }
                throw new ParserException("expected header type " + Integer.toHexString(i2));
            } else if (parsableByteArray.readUnsignedByte() == 118 && parsableByteArray.readUnsignedByte() == 111 && parsableByteArray.readUnsignedByte() == 114 && parsableByteArray.readUnsignedByte() == 98 && parsableByteArray.readUnsignedByte() == 105 && parsableByteArray.readUnsignedByte() == 115) {
                return true;
            } else {
                if (z) {
                    return false;
                }
                throw new ParserException("expected characters 'vorbis'");
            }
        }
        return invokeCommon.booleanValue;
    }
}
