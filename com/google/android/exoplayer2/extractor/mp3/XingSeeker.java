package com.google.android.exoplayer2.extractor.mp3;

import com.google.android.exoplayer2.extractor.MpegAudioHeader;
import com.google.android.exoplayer2.extractor.mp3.Mp3Extractor;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
/* loaded from: classes7.dex */
public final class XingSeeker implements Mp3Extractor.Seeker {
    public final long durationUs;
    public final long firstFramePosition;
    public final int headerSize;
    public final long inputLength;
    public final long sizeBytes;
    public final long[] tableOfContents;

    public XingSeeker(long j, long j2, long j3) {
        this(j, j2, j3, null, 0L, 0);
    }

    public XingSeeker(long j, long j2, long j3, long[] jArr, long j4, int i) {
        this.firstFramePosition = j;
        this.durationUs = j2;
        this.inputLength = j3;
        this.tableOfContents = jArr;
        this.sizeBytes = j4;
        this.headerSize = i;
    }

    public static XingSeeker create(MpegAudioHeader mpegAudioHeader, ParsableByteArray parsableByteArray, long j, long j2) {
        int readUnsignedIntToInt;
        int i = mpegAudioHeader.samplesPerFrame;
        int i2 = mpegAudioHeader.sampleRate;
        long j3 = j + mpegAudioHeader.frameSize;
        int readInt = parsableByteArray.readInt();
        if ((readInt & 1) == 1 && (readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt()) != 0) {
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
        return null;
    }

    private long getTimeUsForTocPosition(int i) {
        return (this.durationUs * i) / 100;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public long getDurationUs() {
        return this.durationUs;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public boolean isSeekable() {
        if (this.tableOfContents != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public long getPosition(long j) {
        long j2;
        if (!isSeekable()) {
            return this.firstFramePosition;
        }
        float f = (((float) j) * 100.0f) / ((float) this.durationUs);
        float f2 = 256.0f;
        float f3 = 0.0f;
        if (f <= 0.0f) {
            f2 = 0.0f;
        } else if (f < 100.0f) {
            int i = (int) f;
            if (i != 0) {
                f3 = (float) this.tableOfContents[i - 1];
            }
            if (i < 99) {
                f2 = (float) this.tableOfContents[i];
            }
            f2 = ((f2 - f3) * (f - i)) + f3;
        }
        long round = Math.round(f2 * 0.00390625d * this.sizeBytes);
        long j3 = this.firstFramePosition;
        long j4 = round + j3;
        long j5 = this.inputLength;
        if (j5 != -1) {
            j2 = j5 - 1;
        } else {
            j2 = ((j3 - this.headerSize) + this.sizeBytes) - 1;
        }
        return Math.min(j4, j2);
    }

    @Override // com.google.android.exoplayer2.extractor.mp3.Mp3Extractor.Seeker
    public long getTimeUs(long j) {
        long j2;
        long j3;
        long j4;
        long j5 = 0;
        if (isSeekable()) {
            if (j >= this.firstFramePosition) {
                double d = ((j - j2) * 256.0d) / this.sizeBytes;
                int binarySearchFloor = Util.binarySearchFloor(this.tableOfContents, (long) d, true, false) + 1;
                long timeUsForTocPosition = getTimeUsForTocPosition(binarySearchFloor);
                if (binarySearchFloor == 0) {
                    j3 = 0;
                } else {
                    j3 = this.tableOfContents[binarySearchFloor - 1];
                }
                if (binarySearchFloor == 99) {
                    j4 = 256;
                } else {
                    j4 = this.tableOfContents[binarySearchFloor];
                }
                long timeUsForTocPosition2 = getTimeUsForTocPosition(binarySearchFloor + 1);
                if (j4 != j3) {
                    j5 = (long) (((timeUsForTocPosition2 - timeUsForTocPosition) * (d - j3)) / (j4 - j3));
                }
                return timeUsForTocPosition + j5;
            }
        }
        return 0L;
    }
}
