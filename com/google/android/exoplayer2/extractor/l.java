package com.google.android.exoplayer2.extractor;
/* loaded from: classes6.dex */
public interface l {
    boolean dvo();

    long fM(long j);

    long getDurationUs();

    /* loaded from: classes6.dex */
    public static final class a implements l {
        private final long mbx;

        public a(long j) {
            this.mbx = j;
        }

        @Override // com.google.android.exoplayer2.extractor.l
        public boolean dvo() {
            return false;
        }

        @Override // com.google.android.exoplayer2.extractor.l
        public long getDurationUs() {
            return this.mbx;
        }

        @Override // com.google.android.exoplayer2.extractor.l
        public long fM(long j) {
            return 0L;
        }
    }
}
