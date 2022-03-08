package com.google.android.exoplayer2.extractor.mp3;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.extractor.MpegAudioHeader;
import com.google.android.exoplayer2.extractor.mp3.Mp3Extractor;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
/* loaded from: classes7.dex */
public final class XingSeeker implements Mp3Extractor.Seeker {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final long durationUs;
    public final long firstFramePosition;
    public final int headerSize;
    public final long inputLength;
    public final long sizeBytes;
    public final long[] tableOfContents;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public XingSeeker(long j2, long j3, long j4) {
        this(j2, j3, j4, null, 0L, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue(), ((Long) objArr2[2]).longValue(), (long[]) objArr2[3], ((Long) objArr2[4]).longValue(), ((Integer) objArr2[5]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static XingSeeker create(MpegAudioHeader mpegAudioHeader, ParsableByteArray parsableByteArray, long j2, long j3) {
        InterceptResult invokeCommon;
        int readUnsignedIntToInt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{mpegAudioHeader, parsableByteArray, Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            int i2 = mpegAudioHeader.samplesPerFrame;
            int i3 = mpegAudioHeader.sampleRate;
            long j4 = j2 + mpegAudioHeader.frameSize;
            int readInt = parsableByteArray.readInt();
            if ((readInt & 1) != 1 || (readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt()) == 0) {
                return null;
            }
            long scaleLargeTimestamp = Util.scaleLargeTimestamp(readUnsignedIntToInt, i2 * 1000000, i3);
            if ((readInt & 6) != 6) {
                return new XingSeeker(j4, scaleLargeTimestamp, j3);
            }
            long readUnsignedIntToInt2 = parsableByteArray.readUnsignedIntToInt();
            parsableByteArray.skipBytes(1);
            long[] jArr = new long[99];
            for (int i4 = 0; i4 < 99; i4++) {
                jArr[i4] = parsableByteArray.readUnsignedByte();
            }
            return new XingSeeker(j4, scaleLargeTimestamp, j3, jArr, readUnsignedIntToInt2, mpegAudioHeader.frameSize);
        }
        return (XingSeeker) invokeCommon.objValue;
    }

    private long getTimeUsForTocPosition(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, this, i2)) == null) ? (this.durationUs * i2) / 100 : invokeI.longValue;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public long getDurationUs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.durationUs : invokeV.longValue;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public long getPosition(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
            if (!isSeekable()) {
                return this.firstFramePosition;
            }
            float f2 = (((float) j2) * 100.0f) / ((float) this.durationUs);
            if (f2 <= 0.0f) {
                r0 = 0.0f;
            } else if (f2 < 100.0f) {
                int i2 = (int) f2;
                float f3 = i2 != 0 ? (float) this.tableOfContents[i2 - 1] : 0.0f;
                r0 = (((i2 < 99 ? (float) this.tableOfContents[i2] : 256.0f) - f3) * (f2 - i2)) + f3;
            }
            long round = Math.round(r0 * 0.00390625d * this.sizeBytes);
            long j3 = this.firstFramePosition;
            long j4 = round + j3;
            long j5 = this.inputLength;
            return Math.min(j4, j5 != -1 ? j5 - 1 : ((j3 - this.headerSize) + this.sizeBytes) - 1);
        }
        return invokeJ.longValue;
    }

    @Override // com.google.android.exoplayer2.extractor.mp3.Mp3Extractor.Seeker
    public long getTimeUs(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2)) == null) {
            if (isSeekable()) {
                long j3 = this.firstFramePosition;
                if (j2 >= j3) {
                    double d2 = ((j2 - j3) * 256.0d) / this.sizeBytes;
                    int binarySearchFloor = Util.binarySearchFloor(this.tableOfContents, (long) d2, true, false) + 1;
                    long timeUsForTocPosition = getTimeUsForTocPosition(binarySearchFloor);
                    long j4 = binarySearchFloor == 0 ? 0L : this.tableOfContents[binarySearchFloor - 1];
                    long j5 = binarySearchFloor == 99 ? 256L : this.tableOfContents[binarySearchFloor];
                    return timeUsForTocPosition + (j5 != j4 ? (long) (((getTimeUsForTocPosition(binarySearchFloor + 1) - timeUsForTocPosition) * (d2 - j4)) / (j5 - j4)) : 0L);
                }
            }
            return 0L;
        }
        return invokeJ.longValue;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public boolean isSeekable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.tableOfContents != null : invokeV.booleanValue;
    }

    public XingSeeker(long j2, long j3, long j4, long[] jArr, long j5, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), jArr, Long.valueOf(j5), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.firstFramePosition = j2;
        this.durationUs = j3;
        this.inputLength = j4;
        this.tableOfContents = jArr;
        this.sizeBytes = j5;
        this.headerSize = i2;
    }
}
