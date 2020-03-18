package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.Format;
import java.io.IOException;
import java.util.Arrays;
/* loaded from: classes6.dex */
public interface m {
    int a(f fVar, int i, boolean z) throws IOException, InterruptedException;

    void a(long j, int i, int i2, int i3, a aVar);

    void a(com.google.android.exoplayer2.util.l lVar, int i);

    void h(Format format);

    /* loaded from: classes6.dex */
    public static final class a {
        public final int mff;
        public final int mfg;
        public final int mgi;
        public final byte[] mgj;

        public a(int i, byte[] bArr, int i2, int i3) {
            this.mgi = i;
            this.mgj = bArr;
            this.mff = i2;
            this.mfg = i3;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.mgi == aVar.mgi && this.mff == aVar.mff && this.mfg == aVar.mfg && Arrays.equals(this.mgj, aVar.mgj);
        }

        public int hashCode() {
            return (((((this.mgi * 31) + Arrays.hashCode(this.mgj)) * 31) + this.mff) * 31) + this.mfg;
        }
    }
}
