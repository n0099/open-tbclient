package com.google.android.exoplayer2.extractor;
/* loaded from: classes6.dex */
public interface l {
    boolean duO();

    long fL(long j);

    long getDurationUs();

    /* loaded from: classes6.dex */
    public static final class a implements l {
        private final long lZB;

        public a(long j) {
            this.lZB = j;
        }

        @Override // com.google.android.exoplayer2.extractor.l
        public boolean duO() {
            return false;
        }

        @Override // com.google.android.exoplayer2.extractor.l
        public long getDurationUs() {
            return this.lZB;
        }

        @Override // com.google.android.exoplayer2.extractor.l
        public long fL(long j) {
            return 0L;
        }
    }
}
