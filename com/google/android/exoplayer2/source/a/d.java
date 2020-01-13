package com.google.android.exoplayer2.source.a;

import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.m;
import java.io.IOException;
/* loaded from: classes5.dex */
public final class d implements com.google.android.exoplayer2.extractor.g {
    private com.google.android.exoplayer2.extractor.l mqP;
    public final com.google.android.exoplayer2.extractor.e mrl;
    private final Format msA;
    private final SparseArray<a> msB = new SparseArray<>();
    private boolean msC;
    private b msD;
    private Format[] msE;
    private final int msz;

    /* loaded from: classes5.dex */
    public interface b {
        com.google.android.exoplayer2.extractor.m dH(int i, int i2);
    }

    public d(com.google.android.exoplayer2.extractor.e eVar, int i, Format format) {
        this.mrl = eVar;
        this.msz = i;
        this.msA = format;
    }

    public com.google.android.exoplayer2.extractor.l dvy() {
        return this.mqP;
    }

    public Format[] dvz() {
        return this.msE;
    }

    public void a(b bVar) {
        this.msD = bVar;
        if (!this.msC) {
            this.mrl.a(this);
            this.msC = true;
            return;
        }
        this.mrl.O(0L, 0L);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.msB.size()) {
                this.msB.valueAt(i2).b(bVar);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.g
    public com.google.android.exoplayer2.extractor.m dH(int i, int i2) {
        a aVar = this.msB.get(i);
        if (aVar == null) {
            com.google.android.exoplayer2.util.a.checkState(this.msE == null);
            a aVar2 = new a(i, i2, i2 == this.msz ? this.msA : null);
            aVar2.b(this.msD);
            this.msB.put(i, aVar2);
            return aVar2;
        }
        return aVar;
    }

    @Override // com.google.android.exoplayer2.extractor.g
    public void dtF() {
        Format[] formatArr = new Format[this.msB.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.msB.size()) {
                formatArr[i2] = this.msB.valueAt(i2).msG;
                i = i2 + 1;
            } else {
                this.msE = formatArr;
                return;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.g
    public void a(com.google.android.exoplayer2.extractor.l lVar) {
        this.mqP = lVar;
    }

    /* loaded from: classes5.dex */
    private static final class a implements com.google.android.exoplayer2.extractor.m {
        private final int id;
        private com.google.android.exoplayer2.extractor.m mfU;
        private final Format msF;
        public Format msG;
        private final int type;

        public a(int i, int i2, Format format) {
            this.id = i;
            this.type = i2;
            this.msF = format;
        }

        public void b(b bVar) {
            if (bVar == null) {
                this.mfU = new com.google.android.exoplayer2.extractor.d();
                return;
            }
            this.mfU = bVar.dH(this.id, this.type);
            if (this.msG != null) {
                this.mfU.h(this.msG);
            }
        }

        @Override // com.google.android.exoplayer2.extractor.m
        public void h(Format format) {
            if (this.msF != null) {
                format = format.c(this.msF);
            }
            this.msG = format;
            this.mfU.h(this.msG);
        }

        @Override // com.google.android.exoplayer2.extractor.m
        public int a(com.google.android.exoplayer2.extractor.f fVar, int i, boolean z) throws IOException, InterruptedException {
            return this.mfU.a(fVar, i, z);
        }

        @Override // com.google.android.exoplayer2.extractor.m
        public void a(com.google.android.exoplayer2.util.l lVar, int i) {
            this.mfU.a(lVar, i);
        }

        @Override // com.google.android.exoplayer2.extractor.m
        public void a(long j, int i, int i2, int i3, m.a aVar) {
            this.mfU.a(j, i, i2, i3, aVar);
        }
    }
}
