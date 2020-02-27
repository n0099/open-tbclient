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
        public final int mdm;
        public final int mdn;
        public final int mep;
        public final byte[] meq;

        public a(int i, byte[] bArr, int i2, int i3) {
            this.mep = i;
            this.meq = bArr;
            this.mdm = i2;
            this.mdn = i3;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.mep == aVar.mep && this.mdm == aVar.mdm && this.mdn == aVar.mdn && Arrays.equals(this.meq, aVar.meq);
        }

        public int hashCode() {
            return (((((this.mep * 31) + Arrays.hashCode(this.meq)) * 31) + this.mdm) * 31) + this.mdn;
        }
    }
}
