package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
/* loaded from: classes9.dex */
public final class SampleMetadataQueue {
    public static final int SAMPLE_CAPACITY_INCREMENT = 1000;
    public int absoluteStartIndex;
    public int length;
    public int readPosition;
    public int relativeStartIndex;
    public Format upstreamFormat;
    public int upstreamSourceId;
    public int capacity = 1000;
    public int[] sourceIds = new int[1000];
    public long[] offsets = new long[1000];
    public long[] timesUs = new long[1000];
    public int[] flags = new int[1000];
    public int[] sizes = new int[1000];
    public TrackOutput.CryptoData[] cryptoDatas = new TrackOutput.CryptoData[1000];
    public Format[] formats = new Format[1000];
    public long largestDiscardedTimestampUs = Long.MIN_VALUE;
    public long largestQueuedTimestampUs = Long.MIN_VALUE;
    public boolean upstreamFormatRequired = true;
    public boolean upstreamKeyframeRequired = true;

    /* loaded from: classes9.dex */
    public static final class SampleExtrasHolder {
        public TrackOutput.CryptoData cryptoData;
        public long offset;
        public int size;
    }

    public synchronized int advanceToEnd() {
        int i;
        i = this.length - this.readPosition;
        this.readPosition = this.length;
        return i;
    }

    public synchronized long discardToEnd() {
        if (this.length == 0) {
            return -1L;
        }
        return discardSamples(this.length);
    }

    public synchronized long discardToRead() {
        if (this.readPosition == 0) {
            return -1L;
        }
        return discardSamples(this.readPosition);
    }

    public synchronized long getLargestQueuedTimestampUs() {
        return this.largestQueuedTimestampUs;
    }

    public int getReadIndex() {
        return this.absoluteStartIndex + this.readPosition;
    }

    public synchronized Format getUpstreamFormat() {
        Format format;
        if (this.upstreamFormatRequired) {
            format = null;
        } else {
            format = this.upstreamFormat;
        }
        return format;
    }

    public int getWriteIndex() {
        return this.absoluteStartIndex + this.length;
    }

    public synchronized boolean hasNextSample() {
        boolean z;
        if (this.readPosition != this.length) {
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    public int peekSourceId() {
        int relativeIndex = getRelativeIndex(this.readPosition);
        if (hasNextSample()) {
            return this.sourceIds[relativeIndex];
        }
        return this.upstreamSourceId;
    }

    public synchronized void rewind() {
        this.readPosition = 0;
    }

    private long discardSamples(int i) {
        int i2;
        this.largestDiscardedTimestampUs = Math.max(this.largestDiscardedTimestampUs, getLargestTimestamp(i));
        this.length -= i;
        this.absoluteStartIndex += i;
        int i3 = this.relativeStartIndex + i;
        this.relativeStartIndex = i3;
        int i4 = this.capacity;
        if (i3 >= i4) {
            this.relativeStartIndex = i3 - i4;
        }
        int i5 = this.readPosition - i;
        this.readPosition = i5;
        if (i5 < 0) {
            this.readPosition = 0;
        }
        if (this.length == 0) {
            int i6 = this.relativeStartIndex;
            if (i6 == 0) {
                i6 = this.capacity;
            }
            return this.offsets[i6 - 1] + this.sizes[i2];
        }
        return this.offsets[this.relativeStartIndex];
    }

    public synchronized boolean attemptSplice(long j) {
        boolean z = false;
        if (this.length == 0) {
            if (j > this.largestDiscardedTimestampUs) {
                z = true;
            }
            return z;
        } else if (Math.max(this.largestDiscardedTimestampUs, getLargestTimestamp(this.readPosition)) >= j) {
            return false;
        } else {
            int i = this.length;
            int relativeIndex = getRelativeIndex(this.length - 1);
            while (i > this.readPosition && this.timesUs[relativeIndex] >= j) {
                i--;
                relativeIndex--;
                if (relativeIndex == -1) {
                    relativeIndex = this.capacity - 1;
                }
            }
            discardUpstreamSamples(this.absoluteStartIndex + i);
            return true;
        }
    }

    private int findSampleBefore(int i, int i2, long j, boolean z) {
        int i3 = -1;
        for (int i4 = 0; i4 < i2 && this.timesUs[i] <= j; i4++) {
            if (!z || (this.flags[i] & 1) != 0) {
                i3 = i4;
            }
            i++;
            if (i == this.capacity) {
                i = 0;
            }
        }
        return i3;
    }

    private long getLargestTimestamp(int i) {
        long j = Long.MIN_VALUE;
        if (i == 0) {
            return Long.MIN_VALUE;
        }
        int relativeIndex = getRelativeIndex(i - 1);
        for (int i2 = 0; i2 < i; i2++) {
            j = Math.max(j, this.timesUs[relativeIndex]);
            if ((this.flags[relativeIndex] & 1) != 0) {
                break;
            }
            relativeIndex--;
            if (relativeIndex == -1) {
                relativeIndex = this.capacity - 1;
            }
        }
        return j;
    }

    private int getRelativeIndex(int i) {
        int i2 = this.relativeStartIndex + i;
        int i3 = this.capacity;
        if (i2 >= i3) {
            return i2 - i3;
        }
        return i2;
    }

    public synchronized void commitSampleTimestamp(long j) {
        this.largestQueuedTimestampUs = Math.max(this.largestQueuedTimestampUs, j);
    }

    public synchronized boolean format(Format format) {
        if (format == null) {
            this.upstreamFormatRequired = true;
            return false;
        }
        this.upstreamFormatRequired = false;
        if (Util.areEqual(format, this.upstreamFormat)) {
            return false;
        }
        this.upstreamFormat = format;
        return true;
    }

    public void reset(boolean z) {
        this.length = 0;
        this.absoluteStartIndex = 0;
        this.relativeStartIndex = 0;
        this.readPosition = 0;
        this.upstreamKeyframeRequired = true;
        this.largestDiscardedTimestampUs = Long.MIN_VALUE;
        this.largestQueuedTimestampUs = Long.MIN_VALUE;
        if (z) {
            this.upstreamFormat = null;
            this.upstreamFormatRequired = true;
        }
    }

    public void sourceId(int i) {
        this.upstreamSourceId = i;
    }

    public synchronized int advanceTo(long j, boolean z, boolean z2) {
        int relativeIndex = getRelativeIndex(this.readPosition);
        if (hasNextSample() && j >= this.timesUs[relativeIndex] && (j <= this.largestQueuedTimestampUs || z2)) {
            int findSampleBefore = findSampleBefore(relativeIndex, this.length - this.readPosition, j, z);
            if (findSampleBefore == -1) {
                return -1;
            }
            this.readPosition += findSampleBefore;
            return findSampleBefore;
        }
        return -1;
    }

    public synchronized long discardTo(long j, boolean z, boolean z2) {
        int i;
        if (this.length != 0 && j >= this.timesUs[this.relativeStartIndex]) {
            if (z2 && this.readPosition != this.length) {
                i = this.readPosition + 1;
            } else {
                i = this.length;
            }
            int findSampleBefore = findSampleBefore(this.relativeStartIndex, i, j, z);
            if (findSampleBefore == -1) {
                return -1L;
            }
            return discardSamples(findSampleBefore);
        }
        return -1L;
    }

    public synchronized void commitSample(long j, int i, long j2, int i2, TrackOutput.CryptoData cryptoData) {
        boolean z;
        if (this.upstreamKeyframeRequired) {
            if ((i & 1) == 0) {
                return;
            }
            this.upstreamKeyframeRequired = false;
        }
        if (!this.upstreamFormatRequired) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z);
        commitSampleTimestamp(j);
        int relativeIndex = getRelativeIndex(this.length);
        this.timesUs[relativeIndex] = j;
        this.offsets[relativeIndex] = j2;
        this.sizes[relativeIndex] = i2;
        this.flags[relativeIndex] = i;
        this.cryptoDatas[relativeIndex] = cryptoData;
        this.formats[relativeIndex] = this.upstreamFormat;
        this.sourceIds[relativeIndex] = this.upstreamSourceId;
        int i3 = this.length + 1;
        this.length = i3;
        if (i3 == this.capacity) {
            int i4 = this.capacity + 1000;
            int[] iArr = new int[i4];
            long[] jArr = new long[i4];
            long[] jArr2 = new long[i4];
            int[] iArr2 = new int[i4];
            int[] iArr3 = new int[i4];
            TrackOutput.CryptoData[] cryptoDataArr = new TrackOutput.CryptoData[i4];
            Format[] formatArr = new Format[i4];
            int i5 = this.capacity - this.relativeStartIndex;
            System.arraycopy(this.offsets, this.relativeStartIndex, jArr, 0, i5);
            System.arraycopy(this.timesUs, this.relativeStartIndex, jArr2, 0, i5);
            System.arraycopy(this.flags, this.relativeStartIndex, iArr2, 0, i5);
            System.arraycopy(this.sizes, this.relativeStartIndex, iArr3, 0, i5);
            System.arraycopy(this.cryptoDatas, this.relativeStartIndex, cryptoDataArr, 0, i5);
            System.arraycopy(this.formats, this.relativeStartIndex, formatArr, 0, i5);
            System.arraycopy(this.sourceIds, this.relativeStartIndex, iArr, 0, i5);
            int i6 = this.relativeStartIndex;
            System.arraycopy(this.offsets, 0, jArr, i5, i6);
            System.arraycopy(this.timesUs, 0, jArr2, i5, i6);
            System.arraycopy(this.flags, 0, iArr2, i5, i6);
            System.arraycopy(this.sizes, 0, iArr3, i5, i6);
            System.arraycopy(this.cryptoDatas, 0, cryptoDataArr, i5, i6);
            System.arraycopy(this.formats, 0, formatArr, i5, i6);
            System.arraycopy(this.sourceIds, 0, iArr, i5, i6);
            this.offsets = jArr;
            this.timesUs = jArr2;
            this.flags = iArr2;
            this.sizes = iArr3;
            this.cryptoDatas = cryptoDataArr;
            this.formats = formatArr;
            this.sourceIds = iArr;
            this.relativeStartIndex = 0;
            this.length = this.capacity;
            this.capacity = i4;
        }
    }

    public long discardUpstreamSamples(int i) {
        boolean z;
        int writeIndex = getWriteIndex() - i;
        if (writeIndex >= 0 && writeIndex <= this.length - this.readPosition) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkArgument(z);
        int i2 = this.length - writeIndex;
        this.length = i2;
        this.largestQueuedTimestampUs = Math.max(this.largestDiscardedTimestampUs, getLargestTimestamp(i2));
        int i3 = this.length;
        if (i3 == 0) {
            return 0L;
        }
        int relativeIndex = getRelativeIndex(i3 - 1);
        return this.offsets[relativeIndex] + this.sizes[relativeIndex];
    }

    public synchronized int read(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z, boolean z2, Format format, SampleExtrasHolder sampleExtrasHolder) {
        if (!hasNextSample()) {
            if (z2) {
                decoderInputBuffer.setFlags(4);
                return -4;
            } else if (this.upstreamFormat == null || (!z && this.upstreamFormat == format)) {
                return -3;
            } else {
                formatHolder.format = this.upstreamFormat;
                return -5;
            }
        }
        int relativeIndex = getRelativeIndex(this.readPosition);
        if (!z && this.formats[relativeIndex] == format) {
            if (decoderInputBuffer.isFlagsOnly()) {
                return -3;
            }
            decoderInputBuffer.timeUs = this.timesUs[relativeIndex];
            decoderInputBuffer.setFlags(this.flags[relativeIndex]);
            sampleExtrasHolder.size = this.sizes[relativeIndex];
            sampleExtrasHolder.offset = this.offsets[relativeIndex];
            sampleExtrasHolder.cryptoData = this.cryptoDatas[relativeIndex];
            this.readPosition++;
            return -4;
        }
        formatHolder.format = this.formats[relativeIndex];
        return -5;
    }
}
