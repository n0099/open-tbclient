package com.google.android.exoplayer2.source;

import android.support.annotation.Nullable;
import com.google.android.exoplayer2.x;
import java.io.IOException;
/* loaded from: classes6.dex */
public interface l {

    /* loaded from: classes6.dex */
    public interface a {
        void a(l lVar, x xVar, @Nullable Object obj);
    }

    k a(b bVar, com.google.android.exoplayer2.upstream.b bVar2);

    void a(com.google.android.exoplayer2.g gVar, boolean z, a aVar);

    void dwK() throws IOException;

    void e(k kVar);

    void releaseSource();

    /* loaded from: classes6.dex */
    public static final class b {
        public static final b mtX = new b(-1, -1, -1);
        public final int mtY;
        public final int mtZ;
        public final int periodIndex;

        public b(int i) {
            this(i, -1, -1);
        }

        public b(int i, int i2, int i3) {
            this.periodIndex = i;
            this.mtY = i2;
            this.mtZ = i3;
        }

        public b KL(int i) {
            return this.periodIndex == i ? this : new b(i, this.mtY, this.mtZ);
        }

        public boolean dwS() {
            return this.mtY != -1;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return this.periodIndex == bVar.periodIndex && this.mtY == bVar.mtY && this.mtZ == bVar.mtZ;
        }

        public int hashCode() {
            return ((((this.periodIndex + 527) * 31) + this.mtY) * 31) + this.mtZ;
        }
    }
}
