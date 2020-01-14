package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.Format;
import java.io.IOException;
import java.util.Arrays;
/* loaded from: classes5.dex */
public interface m {
    int a(f fVar, int i, boolean z) throws IOException, InterruptedException;

    void a(long j, int i, int i2, int i3, a aVar);

    void a(com.google.android.exoplayer2.util.l lVar, int i);

    void h(Format format);

    /* loaded from: classes5.dex */
    public static final class a {
        public final int mcG;
        public final int mcH;
        public final int mdJ;
        public final byte[] mdK;

        public a(int i, byte[] bArr, int i2, int i3) {
            this.mdJ = i;
            this.mdK = bArr;
            this.mcG = i2;
            this.mcH = i3;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.mdJ == aVar.mdJ && this.mcG == aVar.mcG && this.mcH == aVar.mcH && Arrays.equals(this.mdK, aVar.mdK);
        }

        public int hashCode() {
            return (((((this.mdJ * 31) + Arrays.hashCode(this.mdK)) * 31) + this.mcG) * 31) + this.mcH;
        }
    }
}
