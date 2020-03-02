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
        public final int mdo;
        public final int mdp;
        public final int mer;
        public final byte[] mes;

        public a(int i, byte[] bArr, int i2, int i3) {
            this.mer = i;
            this.mes = bArr;
            this.mdo = i2;
            this.mdp = i3;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.mer == aVar.mer && this.mdo == aVar.mdo && this.mdp == aVar.mdp && Arrays.equals(this.mes, aVar.mes);
        }

        public int hashCode() {
            return (((((this.mer * 31) + Arrays.hashCode(this.mes)) * 31) + this.mdo) * 31) + this.mdp;
        }
    }
}
