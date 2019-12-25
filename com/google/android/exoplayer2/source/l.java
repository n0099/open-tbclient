package com.google.android.exoplayer2.source;

import android.support.annotation.Nullable;
import com.google.android.exoplayer2.x;
import java.io.IOException;
/* loaded from: classes4.dex */
public interface l {

    /* loaded from: classes4.dex */
    public interface a {
        void a(l lVar, x xVar, @Nullable Object obj);
    }

    k a(b bVar, com.google.android.exoplayer2.upstream.b bVar2);

    void a(com.google.android.exoplayer2.g gVar, boolean z, a aVar);

    void dtN() throws IOException;

    void e(k kVar);

    void releaseSource();

    /* loaded from: classes4.dex */
    public static final class b {
        public static final b mnC = new b(-1, -1, -1);
        public final int mnD;
        public final int mnE;
        public final int periodIndex;

        public b(int i) {
            this(i, -1, -1);
        }

        public b(int i, int i2, int i3) {
            this.periodIndex = i;
            this.mnD = i2;
            this.mnE = i3;
        }

        public b Kr(int i) {
            return this.periodIndex == i ? this : new b(i, this.mnD, this.mnE);
        }

        public boolean dtV() {
            return this.mnD != -1;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return this.periodIndex == bVar.periodIndex && this.mnD == bVar.mnD && this.mnE == bVar.mnE;
        }

        public int hashCode() {
            return ((((this.periodIndex + 527) * 31) + this.mnD) * 31) + this.mnE;
        }
    }
}
