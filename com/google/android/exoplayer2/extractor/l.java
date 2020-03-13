package com.google.android.exoplayer2.extractor;
/* loaded from: classes6.dex */
public interface l {
    boolean duR();

    long fL(long j);

    long getDurationUs();

    /* loaded from: classes6.dex */
    public static final class a implements l {
        private final long lZO;

        public a(long j) {
            this.lZO = j;
        }

        @Override // com.google.android.exoplayer2.extractor.l
        public boolean duR() {
            return false;
        }

        @Override // com.google.android.exoplayer2.extractor.l
        public long getDurationUs() {
            return this.lZO;
        }

        @Override // com.google.android.exoplayer2.extractor.l
        public long fL(long j) {
            return 0L;
        }
    }
}
