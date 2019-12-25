package com.google.android.exoplayer2.extractor;
/* loaded from: classes4.dex */
public interface l {
    long drc();

    boolean dsp();

    long fI(long j);

    /* loaded from: classes4.dex */
    public static final class a implements l {
        private final long lUZ;

        public a(long j) {
            this.lUZ = j;
        }

        @Override // com.google.android.exoplayer2.extractor.l
        public boolean dsp() {
            return false;
        }

        @Override // com.google.android.exoplayer2.extractor.l
        public long drc() {
            return this.lUZ;
        }

        @Override // com.google.android.exoplayer2.extractor.l
        public long fI(long j) {
            return 0L;
        }
    }
}
