package com.google.android.exoplayer2.source.a;

import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.m;
import java.io.IOException;
/* loaded from: classes6.dex */
public final class d implements com.google.android.exoplayer2.extractor.g {
    private com.google.android.exoplayer2.extractor.l mrC;
    public final com.google.android.exoplayer2.extractor.e mrY;
    private final int mtm;
    private final Format mtn;
    private final SparseArray<a> mto = new SparseArray<>();
    private boolean mtp;
    private b mtq;
    private Format[] mtr;

    /* loaded from: classes6.dex */
    public interface b {
        com.google.android.exoplayer2.extractor.m dK(int i, int i2);
    }

    public d(com.google.android.exoplayer2.extractor.e eVar, int i, Format format) {
        this.mrY = eVar;
        this.mtm = i;
        this.mtn = format;
    }

    public com.google.android.exoplayer2.extractor.l dwM() {
        return this.mrC;
    }

    public Format[] dwN() {
        return this.mtr;
    }

    public void a(b bVar) {
        this.mtq = bVar;
        if (!this.mtp) {
            this.mrY.a(this);
            this.mtp = true;
            return;
        }
        this.mrY.N(0L, 0L);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mto.size()) {
                this.mto.valueAt(i2).b(bVar);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.g
    public com.google.android.exoplayer2.extractor.m dK(int i, int i2) {
        a aVar = this.mto.get(i);
        if (aVar == null) {
            com.google.android.exoplayer2.util.a.checkState(this.mtr == null);
            a aVar2 = new a(i, i2, i2 == this.mtm ? this.mtn : null);
            aVar2.b(this.mtq);
            this.mto.put(i, aVar2);
            return aVar2;
        }
        return aVar;
    }

    @Override // com.google.android.exoplayer2.extractor.g
    public void duU() {
        Format[] formatArr = new Format[this.mto.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mto.size()) {
                formatArr[i2] = this.mto.valueAt(i2).mtt;
                i = i2 + 1;
            } else {
                this.mtr = formatArr;
                return;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.g
    public void a(com.google.android.exoplayer2.extractor.l lVar) {
        this.mrC = lVar;
    }

    /* loaded from: classes6.dex */
    private static final class a implements com.google.android.exoplayer2.extractor.m {
        private final int id;
        private com.google.android.exoplayer2.extractor.m mgH;
        private final Format mts;
        public Format mtt;
        private final int type;

        public a(int i, int i2, Format format) {
            this.id = i;
            this.type = i2;
            this.mts = format;
        }

        public void b(b bVar) {
            if (bVar == null) {
                this.mgH = new com.google.android.exoplayer2.extractor.d();
                return;
            }
            this.mgH = bVar.dK(this.id, this.type);
            if (this.mtt != null) {
                this.mgH.h(this.mtt);
            }
        }

        @Override // com.google.android.exoplayer2.extractor.m
        public void h(Format format) {
            if (this.mts != null) {
                format = format.c(this.mts);
            }
            this.mtt = format;
            this.mgH.h(this.mtt);
        }

        @Override // com.google.android.exoplayer2.extractor.m
        public int a(com.google.android.exoplayer2.extractor.f fVar, int i, boolean z) throws IOException, InterruptedException {
            return this.mgH.a(fVar, i, z);
        }

        @Override // com.google.android.exoplayer2.extractor.m
        public void a(com.google.android.exoplayer2.util.l lVar, int i) {
            this.mgH.a(lVar, i);
        }

        @Override // com.google.android.exoplayer2.extractor.m
        public void a(long j, int i, int i2, int i3, m.a aVar) {
            this.mgH.a(j, i, i2, i3, aVar);
        }
    }
}
