package com.google.android.exoplayer2.extractor;
/* loaded from: classes5.dex */
public interface l {
    long dsq();

    boolean dtD();

    long fN(long j);

    /* loaded from: classes5.dex */
    public static final class a implements l {
        private final long lYV;

        public a(long j) {
            this.lYV = j;
        }

        @Override // com.google.android.exoplayer2.extractor.l
        public boolean dtD() {
            return false;
        }

        @Override // com.google.android.exoplayer2.extractor.l
        public long dsq() {
            return this.lYV;
        }

        @Override // com.google.android.exoplayer2.extractor.l
        public long fN(long j) {
            return 0L;
        }
    }
}
