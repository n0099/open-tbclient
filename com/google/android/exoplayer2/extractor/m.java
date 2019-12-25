package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.Format;
import java.io.IOException;
import java.util.Arrays;
/* loaded from: classes4.dex */
public interface m {
    int a(f fVar, int i, boolean z) throws IOException, InterruptedException;

    void a(long j, int i, int i2, int i3, a aVar);

    void a(com.google.android.exoplayer2.util.l lVar, int i);

    void h(Format format);

    /* loaded from: classes4.dex */
    public static final class a {
        public final int lYJ;
        public final int lYK;
        public final int lZM;
        public final byte[] lZN;

        public a(int i, byte[] bArr, int i2, int i3) {
            this.lZM = i;
            this.lZN = bArr;
            this.lYJ = i2;
            this.lYK = i3;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.lZM == aVar.lZM && this.lYJ == aVar.lYJ && this.lYK == aVar.lYK && Arrays.equals(this.lZN, aVar.lZN);
        }

        public int hashCode() {
            return (((((this.lZM * 31) + Arrays.hashCode(this.lZN)) * 31) + this.lYJ) * 31) + this.lYK;
        }
    }
}
