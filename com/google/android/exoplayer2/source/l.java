package com.google.android.exoplayer2.source;

import android.support.annotation.Nullable;
import com.google.android.exoplayer2.x;
import java.io.IOException;
/* loaded from: classes5.dex */
public interface l {

    /* loaded from: classes5.dex */
    public interface a {
        void a(l lVar, x xVar, @Nullable Object obj);
    }

    k a(b bVar, com.google.android.exoplayer2.upstream.b bVar2);

    void a(com.google.android.exoplayer2.g gVar, boolean z, a aVar);

    void dva() throws IOException;

    void e(k kVar);

    void releaseSource();

    /* loaded from: classes5.dex */
    public static final class b {
        public static final b mrw = new b(-1, -1, -1);
        public final int mrx;
        public final int mry;
        public final int periodIndex;

        public b(int i) {
            this(i, -1, -1);
        }

        public b(int i, int i2, int i3) {
            this.periodIndex = i;
            this.mrx = i2;
            this.mry = i3;
        }

        public b KA(int i) {
            return this.periodIndex == i ? this : new b(i, this.mrx, this.mry);
        }

        public boolean dvi() {
            return this.mrx != -1;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return this.periodIndex == bVar.periodIndex && this.mrx == bVar.mrx && this.mry == bVar.mry;
        }

        public int hashCode() {
            return ((((this.periodIndex + 527) * 31) + this.mrx) * 31) + this.mry;
        }
    }
}
