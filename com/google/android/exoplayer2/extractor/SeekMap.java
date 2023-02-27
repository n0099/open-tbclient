package com.google.android.exoplayer2.extractor;
/* loaded from: classes7.dex */
public interface SeekMap {
    long getDurationUs();

    long getPosition(long j);

    boolean isSeekable();

    /* loaded from: classes7.dex */
    public static final class Unseekable implements SeekMap {
        public final long durationUs;

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public long getPosition(long j) {
            return 0L;
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public boolean isSeekable() {
            return false;
        }

        public Unseekable(long j) {
            this.durationUs = j;
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public long getDurationUs() {
            return this.durationUs;
        }
    }
}
