package com.google.android.exoplayer2.source.a;

import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.m;
import java.io.IOException;
/* loaded from: classes6.dex */
public final class d implements com.google.android.exoplayer2.extractor.g {
    private com.google.android.exoplayer2.extractor.l mrN;
    public final com.google.android.exoplayer2.extractor.e msk;
    private final SparseArray<a> mtA = new SparseArray<>();
    private boolean mtB;
    private b mtC;
    private Format[] mtD;
    private final int mty;
    private final Format mtz;

    /* loaded from: classes6.dex */
    public interface b {
        com.google.android.exoplayer2.extractor.m dK(int i, int i2);
    }

    public d(com.google.android.exoplayer2.extractor.e eVar, int i, Format format) {
        this.msk = eVar;
        this.mty = i;
        this.mtz = format;
    }

    public com.google.android.exoplayer2.extractor.l dwN() {
        return this.mrN;
    }

    public Format[] dwO() {
        return this.mtD;
    }

    public void a(b bVar) {
        this.mtC = bVar;
        if (!this.mtB) {
            this.msk.a(this);
            this.mtB = true;
            return;
        }
        this.msk.N(0L, 0L);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mtA.size()) {
                this.mtA.valueAt(i2).b(bVar);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.g
    public com.google.android.exoplayer2.extractor.m dK(int i, int i2) {
        a aVar = this.mtA.get(i);
        if (aVar == null) {
            com.google.android.exoplayer2.util.a.checkState(this.mtD == null);
            a aVar2 = new a(i, i2, i2 == this.mty ? this.mtz : null);
            aVar2.b(this.mtC);
            this.mtA.put(i, aVar2);
            return aVar2;
        }
        return aVar;
    }

    @Override // com.google.android.exoplayer2.extractor.g
    public void duV() {
        Format[] formatArr = new Format[this.mtA.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mtA.size()) {
                formatArr[i2] = this.mtA.valueAt(i2).mtF;
                i = i2 + 1;
            } else {
                this.mtD = formatArr;
                return;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.g
    public void a(com.google.android.exoplayer2.extractor.l lVar) {
        this.mrN = lVar;
    }

    /* loaded from: classes6.dex */
    private static final class a implements com.google.android.exoplayer2.extractor.m {
        private final int id;
        private com.google.android.exoplayer2.extractor.m mgS;
        private final Format mtE;
        public Format mtF;
        private final int type;

        public a(int i, int i2, Format format) {
            this.id = i;
            this.type = i2;
            this.mtE = format;
        }

        public void b(b bVar) {
            if (bVar == null) {
                this.mgS = new com.google.android.exoplayer2.extractor.d();
                return;
            }
            this.mgS = bVar.dK(this.id, this.type);
            if (this.mtF != null) {
                this.mgS.h(this.mtF);
            }
        }

        @Override // com.google.android.exoplayer2.extractor.m
        public void h(Format format) {
            if (this.mtE != null) {
                format = format.c(this.mtE);
            }
            this.mtF = format;
            this.mgS.h(this.mtF);
        }

        @Override // com.google.android.exoplayer2.extractor.m
        public int a(com.google.android.exoplayer2.extractor.f fVar, int i, boolean z) throws IOException, InterruptedException {
            return this.mgS.a(fVar, i, z);
        }

        @Override // com.google.android.exoplayer2.extractor.m
        public void a(com.google.android.exoplayer2.util.l lVar, int i) {
            this.mgS.a(lVar, i);
        }

        @Override // com.google.android.exoplayer2.extractor.m
        public void a(long j, int i, int i2, int i3, m.a aVar) {
            this.mgS.a(j, i, i2, i3, aVar);
        }
    }
}
