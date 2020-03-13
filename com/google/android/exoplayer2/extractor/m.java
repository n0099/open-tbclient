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
        public final int mdA;
        public final int mdz;
        public final int meC;
        public final byte[] meD;

        public a(int i, byte[] bArr, int i2, int i3) {
            this.meC = i;
            this.meD = bArr;
            this.mdz = i2;
            this.mdA = i3;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.meC == aVar.meC && this.mdz == aVar.mdz && this.mdA == aVar.mdA && Arrays.equals(this.meD, aVar.meD);
        }

        public int hashCode() {
            return (((((this.meC * 31) + Arrays.hashCode(this.meD)) * 31) + this.mdz) * 31) + this.mdA;
        }
    }
}
