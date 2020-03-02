package com.google.android.exoplayer2.extractor;
/* loaded from: classes6.dex */
public interface l {
    boolean duQ();

    long fL(long j);

    long getDurationUs();

    /* loaded from: classes6.dex */
    public static final class a implements l {
        private final long lZD;

        public a(long j) {
            this.lZD = j;
        }

        @Override // com.google.android.exoplayer2.extractor.l
        public boolean duQ() {
            return false;
        }

        @Override // com.google.android.exoplayer2.extractor.l
        public long getDurationUs() {
            return this.lZD;
        }

        @Override // com.google.android.exoplayer2.extractor.l
        public long fL(long j) {
            return 0L;
        }
    }
}
