package com.google.android.exoplayer2.extractor;
/* loaded from: classes5.dex */
public interface l {
    long dso();

    boolean dtB();

    long fN(long j);

    /* loaded from: classes5.dex */
    public static final class a implements l {
        private final long lYQ;

        public a(long j) {
            this.lYQ = j;
        }

        @Override // com.google.android.exoplayer2.extractor.l
        public boolean dtB() {
            return false;
        }

        @Override // com.google.android.exoplayer2.extractor.l
        public long dso() {
            return this.lYQ;
        }

        @Override // com.google.android.exoplayer2.extractor.l
        public long fN(long j) {
            return 0L;
        }
    }
}
