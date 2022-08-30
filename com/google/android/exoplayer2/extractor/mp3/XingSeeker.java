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
    public XingSeeker(long j, long j2, long j3) {
        this(j, j2, j3, null, 0L, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue(), ((Long) objArr2[2]).longValue(), (long[]) objArr2[3], ((Long) objArr2[4]).longValue(), ((Integer) objArr2[5]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static XingSeeker create(MpegAudioHeader mpegAudioHeader, ParsableByteArray parsableByteArray, long j, long j2) {
        InterceptResult invokeCommon;
        int readUnsignedIntToInt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{mpegAudioHeader, parsableByteArray, Long.valueOf(j), Long.valueOf(j2)})) == null) {
            int i = mpegAudioHeader.samplesPerFrame;
            int i2 = mpegAudioHeader.sampleRate;
            long j3 = j + mpegAudioHeader.frameSize;
            int readInt = parsableByteArray.readInt();
            if ((readInt & 1) != 1 || (readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt()) == 0) {
                return null;
            }
            long scaleLargeTimestamp = Util.scaleLargeTimestamp(readUnsignedIntToInt, i * 1000000, i2);
            if ((readInt & 6) != 6) {
                return new XingSeeker(j3, scaleLargeTimestamp, j2);
            }
            long readUnsignedIntToInt2 = parsableByteArray.readUnsignedIntToInt();
            parsableByteArray.skipBytes(1);
            long[] jArr = new long[99];
            for (int i3 = 0; i3 < 99; i3++) {
                jArr[i3] = parsableByteArray.readUnsignedByte();
            }
            return new XingSeeker(j3, scaleLargeTimestamp, j2, jArr, readUnsignedIntToInt2, mpegAudioHeader.frameSize);
        }
        return (XingSeeker) invokeCommon.objValue;
    }

    private long getTimeUsForTocPosition(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, this, i)) == null) ? (this.durationUs * i) / 100 : invokeI.longValue;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public long getDurationUs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.durationUs : invokeV.longValue;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public long getPosition(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
            if (!isSeekable()) {
                return this.firstFramePosition;
            }
            float f = (((float) j) * 100.0f) / ((float) this.durationUs);
            if (f <= 0.0f) {
                r0 = 0.0f;
            } else if (f < 100.0f) {
                int i = (int) f;
                float f2 = i != 0 ? (float) this.tableOfContents[i - 1] : 0.0f;
                r0 = (((i < 99 ? (float) this.tableOfContents[i] : 256.0f) - f2) * (f - i)) + f2;
            }
            long round = Math.round(r0 * 0.00390625d * this.sizeBytes);
            long j2 = this.firstFramePosition;
            long j3 = round + j2;
            long j4 = this.inputLength;
            return Math.min(j3, j4 != -1 ? j4 - 1 : ((j2 - this.headerSize) + this.sizeBytes) - 1);
        }
        return invokeJ.longValue;
    }

    @Override // com.google.android.exoplayer2.extractor.mp3.Mp3Extractor.Seeker
    public long getTimeUs(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) {
            if (isSeekable()) {
                long j2 = this.firstFramePosition;
                if (j >= j2) {
                    double d = ((j - j2) * 256.0d) / this.sizeBytes;
                    int binarySearchFloor = Util.binarySearchFloor(this.tableOfContents, (long) d, true, false) + 1;
                    long timeUsForTocPosition = getTimeUsForTocPosition(binarySearchFloor);
                    long j3 = binarySearchFloor == 0 ? 0L : this.tableOfContents[binarySearchFloor - 1];
                    long j4 = binarySearchFloor == 99 ? 256L : this.tableOfContents[binarySearchFloor];
                    return timeUsForTocPosition + (j4 != j3 ? (long) (((getTimeUsForTocPosition(binarySearchFloor + 1) - timeUsForTocPosition) * (d - j3)) / (j4 - j3)) : 0L);
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

    public XingSeeker(long j, long j2, long j3, long[] jArr, long j4, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), jArr, Long.valueOf(j4), Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.firstFramePosition = j;
        this.durationUs = j2;
        this.inputLength = j3;
        this.tableOfContents = jArr;
        this.sizeBytes = j4;
        this.headerSize = i;
    }
}
