package com.google.android.exoplayer2.source.a;

import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.m;
import java.io.IOException;
/* loaded from: classes5.dex */
public final class d implements com.google.android.exoplayer2.extractor.g {
    private com.google.android.exoplayer2.extractor.l mqU;
    public final com.google.android.exoplayer2.extractor.e mrq;
    private final int msE;
    private final Format msF;
    private final SparseArray<a> msG = new SparseArray<>();
    private boolean msH;
    private b msI;
    private Format[] msJ;

    /* loaded from: classes5.dex */
    public interface b {
        com.google.android.exoplayer2.extractor.m dH(int i, int i2);
    }

    public d(com.google.android.exoplayer2.extractor.e eVar, int i, Format format) {
        this.mrq = eVar;
        this.msE = i;
        this.msF = format;
    }

    public com.google.android.exoplayer2.extractor.l dvA() {
        return this.mqU;
    }

    public Format[] dvB() {
        return this.msJ;
    }

    public void a(b bVar) {
        this.msI = bVar;
        if (!this.msH) {
            this.mrq.a(this);
            this.msH = true;
            return;
        }
        this.mrq.O(0L, 0L);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.msG.size()) {
                this.msG.valueAt(i2).b(bVar);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.g
    public com.google.android.exoplayer2.extractor.m dH(int i, int i2) {
        a aVar = this.msG.get(i);
        if (aVar == null) {
            com.google.android.exoplayer2.util.a.checkState(this.msJ == null);
            a aVar2 = new a(i, i2, i2 == this.msE ? this.msF : null);
            aVar2.b(this.msI);
            this.msG.put(i, aVar2);
            return aVar2;
        }
        return aVar;
    }

    @Override // com.google.android.exoplayer2.extractor.g
    public void dtH() {
        Format[] formatArr = new Format[this.msG.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.msG.size()) {
                formatArr[i2] = this.msG.valueAt(i2).msL;
                i = i2 + 1;
            } else {
                this.msJ = formatArr;
                return;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.g
    public void a(com.google.android.exoplayer2.extractor.l lVar) {
        this.mqU = lVar;
    }

    /* loaded from: classes5.dex */
    private static final class a implements com.google.android.exoplayer2.extractor.m {
        private final int id;
        private com.google.android.exoplayer2.extractor.m mfZ;
        private final Format msK;
        public Format msL;
        private final int type;

        public a(int i, int i2, Format format) {
            this.id = i;
            this.type = i2;
            this.msK = format;
        }

        public void b(b bVar) {
            if (bVar == null) {
                this.mfZ = new com.google.android.exoplayer2.extractor.d();
                return;
            }
            this.mfZ = bVar.dH(this.id, this.type);
            if (this.msL != null) {
                this.mfZ.h(this.msL);
            }
        }

        @Override // com.google.android.exoplayer2.extractor.m
        public void h(Format format) {
            if (this.msK != null) {
                format = format.c(this.msK);
            }
            this.msL = format;
            this.mfZ.h(this.msL);
        }

        @Override // com.google.android.exoplayer2.extractor.m
        public int a(com.google.android.exoplayer2.extractor.f fVar, int i, boolean z) throws IOException, InterruptedException {
            return this.mfZ.a(fVar, i, z);
        }

        @Override // com.google.android.exoplayer2.extractor.m
        public void a(com.google.android.exoplayer2.util.l lVar, int i) {
            this.mfZ.a(lVar, i);
        }

        @Override // com.google.android.exoplayer2.extractor.m
        public void a(long j, int i, int i2, int i3, m.a aVar) {
            this.mfZ.a(j, i, i2, i3, aVar);
        }
    }
}
