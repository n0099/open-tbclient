package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import java.io.IOException;
/* loaded from: classes9.dex */
public final class ClippingMediaPeriod implements MediaPeriod, MediaPeriod.Callback {
    public MediaPeriod.Callback callback;
    public final MediaPeriod mediaPeriod;
    public boolean pendingInitialDiscontinuity;
    public long startUs = C.TIME_UNSET;
    public long endUs = C.TIME_UNSET;
    public ClippingSampleStream[] sampleStreams = new ClippingSampleStream[0];

    /* loaded from: classes9.dex */
    public static final class ClippingSampleStream implements SampleStream {
        public final long endUs;
        public final MediaPeriod mediaPeriod;
        public boolean pendingDiscontinuity;
        public boolean sentEos;
        public final long startUs;
        public final SampleStream stream;

        public ClippingSampleStream(MediaPeriod mediaPeriod, SampleStream sampleStream, long j, long j2, boolean z) {
            this.mediaPeriod = mediaPeriod;
            this.stream = sampleStream;
            this.startUs = j;
            this.endUs = j2;
            this.pendingDiscontinuity = z;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int skipData(long j) {
            return this.stream.skipData(this.startUs + j);
        }

        public void clearPendingDiscontinuity() {
            this.pendingDiscontinuity = false;
        }

        public void clearSentEos() {
            this.sentEos = false;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public boolean isReady() {
            return this.stream.isReady();
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public void maybeThrowError() throws IOException {
            this.stream.maybeThrowError();
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z) {
            int i;
            if (this.pendingDiscontinuity) {
                return -3;
            }
            if (this.sentEos) {
                decoderInputBuffer.setFlags(4);
                return -4;
            }
            int readData = this.stream.readData(formatHolder, decoderInputBuffer, z);
            if (readData == -5) {
                Format format = formatHolder.format;
                int i2 = 0;
                if (this.startUs != 0) {
                    i = 0;
                } else {
                    i = format.encoderDelay;
                }
                if (this.endUs == Long.MIN_VALUE) {
                    i2 = format.encoderPadding;
                }
                formatHolder.format = format.copyWithGaplessInfo(i, i2);
                return -5;
            }
            long j = this.endUs;
            if (j != Long.MIN_VALUE && ((readData == -4 && decoderInputBuffer.timeUs >= j) || (readData == -3 && this.mediaPeriod.getBufferedPositionUs() == Long.MIN_VALUE))) {
                decoderInputBuffer.clear();
                decoderInputBuffer.setFlags(4);
                this.sentEos = true;
                return -4;
            }
            if (readData == -4 && !decoderInputBuffer.isEndOfStream()) {
                decoderInputBuffer.timeUs -= this.startUs;
            }
            return readData;
        }
    }

    public ClippingMediaPeriod(MediaPeriod mediaPeriod, boolean z) {
        this.mediaPeriod = mediaPeriod;
        this.pendingInitialDiscontinuity = z;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void prepare(MediaPeriod.Callback callback, long j) {
        this.callback = callback;
        this.mediaPeriod.prepare(this, this.startUs + j);
    }

    public void setClipping(long j, long j2) {
        this.startUs = j;
        this.endUs = j2;
    }

    public static boolean shouldKeepInitialDiscontinuity(TrackSelection[] trackSelectionArr) {
        for (TrackSelection trackSelection : trackSelectionArr) {
            if (trackSelection != null && !MimeTypes.isAudio(trackSelection.getSelectedFormat().sampleMimeType)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long j) {
        return this.mediaPeriod.continueLoading(j + this.startUs);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void discardBuffer(long j) {
        this.mediaPeriod.discardBuffer(j + this.startUs);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.source.SequenceableLoader.Callback
    public void onContinueLoadingRequested(MediaPeriod mediaPeriod) {
        this.callback.onContinueLoadingRequested(this);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod.Callback
    public void onPrepared(MediaPeriod mediaPeriod) {
        boolean z;
        if (this.startUs != C.TIME_UNSET && this.endUs != C.TIME_UNSET) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z);
        this.callback.onPrepared(this);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getBufferedPositionUs() {
        long bufferedPositionUs = this.mediaPeriod.getBufferedPositionUs();
        if (bufferedPositionUs != Long.MIN_VALUE) {
            long j = this.endUs;
            if (j == Long.MIN_VALUE || bufferedPositionUs < j) {
                return Math.max(0L, bufferedPositionUs - this.startUs);
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getNextLoadPositionUs() {
        long nextLoadPositionUs = this.mediaPeriod.getNextLoadPositionUs();
        if (nextLoadPositionUs != Long.MIN_VALUE) {
            long j = this.endUs;
            if (j == Long.MIN_VALUE || nextLoadPositionUs < j) {
                return nextLoadPositionUs - this.startUs;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public TrackGroupArray getTrackGroups() {
        return this.mediaPeriod.getTrackGroups();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void maybeThrowPrepareError() throws IOException {
        this.mediaPeriod.maybeThrowPrepareError();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long readDiscontinuity() {
        boolean z;
        ClippingSampleStream[] clippingSampleStreamArr;
        boolean z2 = false;
        if (this.pendingInitialDiscontinuity) {
            for (ClippingSampleStream clippingSampleStream : this.sampleStreams) {
                if (clippingSampleStream != null) {
                    clippingSampleStream.clearPendingDiscontinuity();
                }
            }
            this.pendingInitialDiscontinuity = false;
            long readDiscontinuity = readDiscontinuity();
            if (readDiscontinuity == C.TIME_UNSET) {
                return 0L;
            }
            return readDiscontinuity;
        }
        long readDiscontinuity2 = this.mediaPeriod.readDiscontinuity();
        if (readDiscontinuity2 == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        if (readDiscontinuity2 >= this.startUs) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z);
        long j = this.endUs;
        Assertions.checkState((j == Long.MIN_VALUE || readDiscontinuity2 <= j) ? true : true);
        return readDiscontinuity2 - this.startUs;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002f, code lost:
        if (r0 > r7) goto L18;
     */
    @Override // com.google.android.exoplayer2.source.MediaPeriod
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long seekToUs(long j) {
        ClippingSampleStream[] clippingSampleStreamArr;
        boolean z = false;
        for (ClippingSampleStream clippingSampleStream : this.sampleStreams) {
            if (clippingSampleStream != null) {
                clippingSampleStream.clearSentEos();
            }
        }
        long seekToUs = this.mediaPeriod.seekToUs(this.startUs + j);
        long j2 = this.startUs;
        if (seekToUs != j + j2) {
            if (seekToUs >= j2) {
                long j3 = this.endUs;
                if (j3 != Long.MIN_VALUE) {
                }
            }
            Assertions.checkState(z);
            return seekToUs - this.startUs;
        }
        z = true;
        Assertions.checkState(z);
        return seekToUs - this.startUs;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0068, code lost:
        if (r12 > r3) goto L28;
     */
    @Override // com.google.android.exoplayer2.source.MediaPeriod
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long selectTracks(TrackSelection[] trackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
        boolean z;
        this.sampleStreams = new ClippingSampleStream[sampleStreamArr.length];
        SampleStream[] sampleStreamArr2 = new SampleStream[sampleStreamArr.length];
        int i = 0;
        while (true) {
            SampleStream sampleStream = null;
            if (i >= sampleStreamArr.length) {
                break;
            }
            ClippingSampleStream[] clippingSampleStreamArr = this.sampleStreams;
            clippingSampleStreamArr[i] = (ClippingSampleStream) sampleStreamArr[i];
            if (clippingSampleStreamArr[i] != null) {
                sampleStream = clippingSampleStreamArr[i].stream;
            }
            sampleStreamArr2[i] = sampleStream;
            i++;
        }
        long selectTracks = this.mediaPeriod.selectTracks(trackSelectionArr, zArr, sampleStreamArr2, zArr2, j + this.startUs);
        boolean z2 = true;
        if (this.pendingInitialDiscontinuity) {
            if (this.startUs != 0 && shouldKeepInitialDiscontinuity(trackSelectionArr)) {
                z = true;
            } else {
                z = false;
            }
            this.pendingInitialDiscontinuity = z;
        }
        long j2 = this.startUs;
        if (selectTracks != j + j2) {
            if (selectTracks >= j2) {
                long j3 = this.endUs;
                if (j3 != Long.MIN_VALUE) {
                }
            }
            z2 = false;
        }
        Assertions.checkState(z2);
        for (int i2 = 0; i2 < sampleStreamArr.length; i2++) {
            if (sampleStreamArr2[i2] == null) {
                this.sampleStreams[i2] = null;
            } else if (sampleStreamArr[i2] == null || this.sampleStreams[i2].stream != sampleStreamArr2[i2]) {
                this.sampleStreams[i2] = new ClippingSampleStream(this, sampleStreamArr2[i2], this.startUs, this.endUs, this.pendingInitialDiscontinuity);
            }
            sampleStreamArr[i2] = this.sampleStreams[i2];
        }
        return selectTracks - this.startUs;
    }
}
