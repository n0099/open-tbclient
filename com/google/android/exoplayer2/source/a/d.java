package com.google.android.exoplayer2.source.a;

import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.m;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class d implements com.google.android.exoplayer2.extractor.g {
    private com.google.android.exoplayer2.extractor.l mna;
    public final com.google.android.exoplayer2.extractor.e mnw;
    private final int moK;
    private final Format moL;
    private final SparseArray<a> moM = new SparseArray<>();
    private boolean moN;
    private b moO;
    private Format[] moP;

    /* loaded from: classes4.dex */
    public interface b {
        com.google.android.exoplayer2.extractor.m dJ(int i, int i2);
    }

    public d(com.google.android.exoplayer2.extractor.e eVar, int i, Format format) {
        this.mnw = eVar;
        this.moK = i;
        this.moL = format;
    }

    public com.google.android.exoplayer2.extractor.l dun() {
        return this.mna;
    }

    public Format[] duo() {
        return this.moP;
    }

    public void a(b bVar) {
        this.moO = bVar;
        if (!this.moN) {
            this.mnw.a(this);
            this.moN = true;
            return;
        }
        this.mnw.O(0L, 0L);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.moM.size()) {
                this.moM.valueAt(i2).b(bVar);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.g
    public com.google.android.exoplayer2.extractor.m dJ(int i, int i2) {
        a aVar = this.moM.get(i);
        if (aVar == null) {
            com.google.android.exoplayer2.util.a.checkState(this.moP == null);
            a aVar2 = new a(i, i2, i2 == this.moK ? this.moL : null);
            aVar2.b(this.moO);
            this.moM.put(i, aVar2);
            return aVar2;
        }
        return aVar;
    }

    @Override // com.google.android.exoplayer2.extractor.g
    public void dst() {
        Format[] formatArr = new Format[this.moM.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.moM.size()) {
                formatArr[i2] = this.moM.valueAt(i2).moR;
                i = i2 + 1;
            } else {
                this.moP = formatArr;
                return;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.g
    public void a(com.google.android.exoplayer2.extractor.l lVar) {
        this.mna = lVar;
    }

    /* loaded from: classes4.dex */
    private static final class a implements com.google.android.exoplayer2.extractor.m {
        private final int id;
        private com.google.android.exoplayer2.extractor.m mcf;
        private final Format moQ;
        public Format moR;
        private final int type;

        public a(int i, int i2, Format format) {
            this.id = i;
            this.type = i2;
            this.moQ = format;
        }

        public void b(b bVar) {
            if (bVar == null) {
                this.mcf = new com.google.android.exoplayer2.extractor.d();
                return;
            }
            this.mcf = bVar.dJ(this.id, this.type);
            if (this.moR != null) {
                this.mcf.h(this.moR);
            }
        }

        @Override // com.google.android.exoplayer2.extractor.m
        public void h(Format format) {
            if (this.moQ != null) {
                format = format.c(this.moQ);
            }
            this.moR = format;
            this.mcf.h(this.moR);
        }

        @Override // com.google.android.exoplayer2.extractor.m
        public int a(com.google.android.exoplayer2.extractor.f fVar, int i, boolean z) throws IOException, InterruptedException {
            return this.mcf.a(fVar, i, z);
        }

        @Override // com.google.android.exoplayer2.extractor.m
        public void a(com.google.android.exoplayer2.util.l lVar, int i) {
            this.mcf.a(lVar, i);
        }

        @Override // com.google.android.exoplayer2.extractor.m
        public void a(long j, int i, int i2, int i3, m.a aVar) {
            this.mcf.a(j, i, i2, i3, aVar);
        }
    }
}
