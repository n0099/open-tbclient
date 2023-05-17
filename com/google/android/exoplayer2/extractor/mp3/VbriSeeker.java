package com.google.android.exoplayer2.extractor.mp3;

import com.google.android.exoplayer2.extractor.MpegAudioHeader;
import com.google.android.exoplayer2.extractor.mp3.Mp3Extractor;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.googlecode.mp4parser.authoring.tracks.MP3TrackImpl;
/* loaded from: classes9.dex */
public final class VbriSeeker implements Mp3Extractor.Seeker {
    public final long durationUs;
    public final long[] positions;
    public final long[] timesUs;

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public boolean isSeekable() {
        return true;
    }

    public VbriSeeker(long[] jArr, long[] jArr2, long j) {
        this.timesUs = jArr;
        this.positions = jArr2;
        this.durationUs = j;
    }

    public static VbriSeeker create(MpegAudioHeader mpegAudioHeader, ParsableByteArray parsableByteArray, long j, long j2) {
        int i;
        int readUnsignedByte;
        long min;
        parsableByteArray.skipBytes(10);
        int readInt = parsableByteArray.readInt();
        if (readInt <= 0) {
            return null;
        }
        int i2 = mpegAudioHeader.sampleRate;
        long j3 = readInt;
        if (i2 >= 32000) {
            i = MP3TrackImpl.SAMPLES_PER_FRAME;
        } else {
            i = 576;
        }
        long scaleLargeTimestamp = Util.scaleLargeTimestamp(j3, 1000000 * i, i2);
        int readUnsignedShort = parsableByteArray.readUnsignedShort();
        int readUnsignedShort2 = parsableByteArray.readUnsignedShort();
        int readUnsignedShort3 = parsableByteArray.readUnsignedShort();
        int i3 = 2;
        parsableByteArray.skipBytes(2);
        long j4 = j + mpegAudioHeader.frameSize;
        int i4 = readUnsignedShort + 1;
        long[] jArr = new long[i4];
        long[] jArr2 = new long[i4];
        jArr[0] = 0;
        jArr2[0] = j4;
        int i5 = 1;
        while (i5 < i4) {
            if (readUnsignedShort3 != 1) {
                if (readUnsignedShort3 != i3) {
                    if (readUnsignedShort3 != 3) {
                        if (readUnsignedShort3 != 4) {
                            return null;
                        }
                        readUnsignedByte = parsableByteArray.readUnsignedIntToInt();
                    } else {
                        readUnsignedByte = parsableByteArray.readUnsignedInt24();
                    }
                } else {
                    readUnsignedByte = parsableByteArray.readUnsignedShort();
                }
            } else {
                readUnsignedByte = parsableByteArray.readUnsignedByte();
            }
            int i6 = i4;
            j4 += readUnsignedByte * readUnsignedShort2;
            int i7 = readUnsignedShort2;
            int i8 = readUnsignedShort3;
            jArr[i5] = (i5 * scaleLargeTimestamp) / readUnsignedShort;
            if (j2 == -1) {
                min = j4;
            } else {
                min = Math.min(j2, j4);
            }
            jArr2[i5] = min;
            i5++;
            i4 = i6;
            readUnsignedShort2 = i7;
            readUnsignedShort3 = i8;
            i3 = 2;
        }
        return new VbriSeeker(jArr, jArr2, scaleLargeTimestamp);
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public long getDurationUs() {
        return this.durationUs;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public long getPosition(long j) {
        return this.positions[Util.binarySearchFloor(this.timesUs, j, true, true)];
    }

    @Override // com.google.android.exoplayer2.extractor.mp3.Mp3Extractor.Seeker
    public long getTimeUs(long j) {
        return this.timesUs[Util.binarySearchFloor(this.positions, j, true, true)];
    }
}
