package com.google.android.exoplayer2.source.a;

import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.m;
import java.io.IOException;
/* loaded from: classes6.dex */
public final class d implements com.google.android.exoplayer2.extractor.g {
    private com.google.android.exoplayer2.extractor.l mrA;
    public final com.google.android.exoplayer2.extractor.e mrW;
    private final int mtk;
    private final Format mtl;
    private final SparseArray<a> mtm = new SparseArray<>();
    private boolean mtn;
    private b mto;
    private Format[] mtp;

    /* loaded from: classes6.dex */
    public interface b {
        com.google.android.exoplayer2.extractor.m dK(int i, int i2);
    }

    public d(com.google.android.exoplayer2.extractor.e eVar, int i, Format format) {
        this.mrW = eVar;
        this.mtk = i;
        this.mtl = format;
    }

    public com.google.android.exoplayer2.extractor.l dwK() {
        return this.mrA;
    }

    public Format[] dwL() {
        return this.mtp;
    }

    public void a(b bVar) {
        this.mto = bVar;
        if (!this.mtn) {
            this.mrW.a(this);
            this.mtn = true;
            return;
        }
        this.mrW.N(0L, 0L);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mtm.size()) {
                this.mtm.valueAt(i2).b(bVar);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.g
    public com.google.android.exoplayer2.extractor.m dK(int i, int i2) {
        a aVar = this.mtm.get(i);
        if (aVar == null) {
            com.google.android.exoplayer2.util.a.checkState(this.mtp == null);
            a aVar2 = new a(i, i2, i2 == this.mtk ? this.mtl : null);
            aVar2.b(this.mto);
            this.mtm.put(i, aVar2);
            return aVar2;
        }
        return aVar;
    }

    @Override // com.google.android.exoplayer2.extractor.g
    public void duS() {
        Format[] formatArr = new Format[this.mtm.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mtm.size()) {
                formatArr[i2] = this.mtm.valueAt(i2).mtr;
                i = i2 + 1;
            } else {
                this.mtp = formatArr;
                return;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.g
    public void a(com.google.android.exoplayer2.extractor.l lVar) {
        this.mrA = lVar;
    }

    /* loaded from: classes6.dex */
    private static final class a implements com.google.android.exoplayer2.extractor.m {
        private final int id;
        private com.google.android.exoplayer2.extractor.m mgF;
        private final Format mtq;
        public Format mtr;
        private final int type;

        public a(int i, int i2, Format format) {
            this.id = i;
            this.type = i2;
            this.mtq = format;
        }

        public void b(b bVar) {
            if (bVar == null) {
                this.mgF = new com.google.android.exoplayer2.extractor.d();
                return;
            }
            this.mgF = bVar.dK(this.id, this.type);
            if (this.mtr != null) {
                this.mgF.h(this.mtr);
            }
        }

        @Override // com.google.android.exoplayer2.extractor.m
        public void h(Format format) {
            if (this.mtq != null) {
                format = format.c(this.mtq);
            }
            this.mtr = format;
            this.mgF.h(this.mtr);
        }

        @Override // com.google.android.exoplayer2.extractor.m
        public int a(com.google.android.exoplayer2.extractor.f fVar, int i, boolean z) throws IOException, InterruptedException {
            return this.mgF.a(fVar, i, z);
        }

        @Override // com.google.android.exoplayer2.extractor.m
        public void a(com.google.android.exoplayer2.util.l lVar, int i) {
            this.mgF.a(lVar, i);
        }

        @Override // com.google.android.exoplayer2.extractor.m
        public void a(long j, int i, int i2, int i3, m.a aVar) {
            this.mgF.a(j, i, i2, i3, aVar);
        }
    }
}
