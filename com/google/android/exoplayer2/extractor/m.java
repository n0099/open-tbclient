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
        public final int mcB;
        public final int mcC;
        public final int mdE;
        public final byte[] mdF;

        public a(int i, byte[] bArr, int i2, int i3) {
            this.mdE = i;
            this.mdF = bArr;
            this.mcB = i2;
            this.mcC = i3;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.mdE == aVar.mdE && this.mcB == aVar.mcB && this.mcC == aVar.mcC && Arrays.equals(this.mdF, aVar.mdF);
        }

        public int hashCode() {
            return (((((this.mdE * 31) + Arrays.hashCode(this.mdF)) * 31) + this.mcB) * 31) + this.mcC;
        }
    }
}
