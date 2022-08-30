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
import com.googlecode.mp4parser.authoring.tracks.MP3TrackImpl;
/* loaded from: classes7.dex */
public final class VbriSeeker implements Mp3Extractor.Seeker {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final long durationUs;
    public final long[] positions;
    public final long[] timesUs;

    public VbriSeeker(long[] jArr, long[] jArr2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jArr, jArr2, Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.timesUs = jArr;
        this.positions = jArr2;
        this.durationUs = j;
    }

    public static VbriSeeker create(MpegAudioHeader mpegAudioHeader, ParsableByteArray parsableByteArray, long j, long j2) {
        InterceptResult invokeCommon;
        int readUnsignedByte;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{mpegAudioHeader, parsableByteArray, Long.valueOf(j), Long.valueOf(j2)})) == null) {
            parsableByteArray.skipBytes(10);
            int readInt = parsableByteArray.readInt();
            if (readInt <= 0) {
                return null;
            }
            int i = mpegAudioHeader.sampleRate;
            long scaleLargeTimestamp = Util.scaleLargeTimestamp(readInt, 1000000 * (i >= 32000 ? MP3TrackImpl.SAMPLES_PER_FRAME : 576), i);
            int readUnsignedShort = parsableByteArray.readUnsignedShort();
            int readUnsignedShort2 = parsableByteArray.readUnsignedShort();
            int readUnsignedShort3 = parsableByteArray.readUnsignedShort();
            int i2 = 2;
            parsableByteArray.skipBytes(2);
            long j3 = j + mpegAudioHeader.frameSize;
            int i3 = readUnsignedShort + 1;
            long[] jArr = new long[i3];
            long[] jArr2 = new long[i3];
            jArr[0] = 0;
            jArr2[0] = j3;
            int i4 = 1;
            while (i4 < i3) {
                if (readUnsignedShort3 == 1) {
                    readUnsignedByte = parsableByteArray.readUnsignedByte();
                } else if (readUnsignedShort3 == i2) {
                    readUnsignedByte = parsableByteArray.readUnsignedShort();
                } else if (readUnsignedShort3 == 3) {
                    readUnsignedByte = parsableByteArray.readUnsignedInt24();
                } else if (readUnsignedShort3 != 4) {
                    return null;
                } else {
                    readUnsignedByte = parsableByteArray.readUnsignedIntToInt();
                }
                int i5 = i3;
                j3 += readUnsignedByte * readUnsignedShort2;
                int i6 = readUnsignedShort2;
                int i7 = readUnsignedShort3;
                jArr[i4] = (i4 * scaleLargeTimestamp) / readUnsignedShort;
                jArr2[i4] = j2 == -1 ? j3 : Math.min(j2, j3);
                i4++;
                i3 = i5;
                readUnsignedShort2 = i6;
                readUnsignedShort3 = i7;
                i2 = 2;
            }
            return new VbriSeeker(jArr, jArr2, scaleLargeTimestamp);
        }
        return (VbriSeeker) invokeCommon.objValue;
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
        return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) ? this.positions[Util.binarySearchFloor(this.timesUs, j, true, true)] : invokeJ.longValue;
    }

    @Override // com.google.android.exoplayer2.extractor.mp3.Mp3Extractor.Seeker
    public long getTimeUs(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) ? this.timesUs[Util.binarySearchFloor(this.positions, j, true, true)] : invokeJ.longValue;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public boolean isSeekable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }
}
