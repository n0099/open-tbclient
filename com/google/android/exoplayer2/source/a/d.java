package com.google.android.exoplayer2.source.a;

import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.m;
import java.io.IOException;
/* loaded from: classes6.dex */
public final class d implements com.google.android.exoplayer2.extractor.g {
    public final com.google.android.exoplayer2.extractor.e mtR;
    private com.google.android.exoplayer2.extractor.l mtu;
    private final int mve;
    private final Format mvf;
    private final SparseArray<a> mvg = new SparseArray<>();
    private boolean mvh;
    private b mvi;
    private Format[] mvj;

    /* loaded from: classes6.dex */
    public interface b {
        com.google.android.exoplayer2.extractor.m dL(int i, int i2);
    }

    public d(com.google.android.exoplayer2.extractor.e eVar, int i, Format format) {
        this.mtR = eVar;
        this.mve = i;
        this.mvf = format;
    }

    public com.google.android.exoplayer2.extractor.l dxk() {
        return this.mtu;
    }

    public Format[] dxl() {
        return this.mvj;
    }

    public void a(b bVar) {
        this.mvi = bVar;
        if (!this.mvh) {
            this.mtR.a(this);
            this.mvh = true;
            return;
        }
        this.mtR.N(0L, 0L);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mvg.size()) {
                this.mvg.valueAt(i2).b(bVar);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.g
    public com.google.android.exoplayer2.extractor.m dL(int i, int i2) {
        a aVar = this.mvg.get(i);
        if (aVar == null) {
            com.google.android.exoplayer2.util.a.checkState(this.mvj == null);
            a aVar2 = new a(i, i2, i2 == this.mve ? this.mvf : null);
            aVar2.b(this.mvi);
            this.mvg.put(i, aVar2);
            return aVar2;
        }
        return aVar;
    }

    @Override // com.google.android.exoplayer2.extractor.g
    public void dvs() {
        Format[] formatArr = new Format[this.mvg.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mvg.size()) {
                formatArr[i2] = this.mvg.valueAt(i2).mvl;
                i = i2 + 1;
            } else {
                this.mvj = formatArr;
                return;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.g
    public void a(com.google.android.exoplayer2.extractor.l lVar) {
        this.mtu = lVar;
    }

    /* loaded from: classes6.dex */
    private static final class a implements com.google.android.exoplayer2.extractor.m {
        private final int id;
        private com.google.android.exoplayer2.extractor.m miA;
        private final Format mvk;
        public Format mvl;
        private final int type;

        public a(int i, int i2, Format format) {
            this.id = i;
            this.type = i2;
            this.mvk = format;
        }

        public void b(b bVar) {
            if (bVar == null) {
                this.miA = new com.google.android.exoplayer2.extractor.d();
                return;
            }
            this.miA = bVar.dL(this.id, this.type);
            if (this.mvl != null) {
                this.miA.h(this.mvl);
            }
        }

        @Override // com.google.android.exoplayer2.extractor.m
        public void h(Format format) {
            if (this.mvk != null) {
                format = format.c(this.mvk);
            }
            this.mvl = format;
            this.miA.h(this.mvl);
        }

        @Override // com.google.android.exoplayer2.extractor.m
        public int a(com.google.android.exoplayer2.extractor.f fVar, int i, boolean z) throws IOException, InterruptedException {
            return this.miA.a(fVar, i, z);
        }

        @Override // com.google.android.exoplayer2.extractor.m
        public void a(com.google.android.exoplayer2.util.l lVar, int i) {
            this.miA.a(lVar, i);
        }

        @Override // com.google.android.exoplayer2.extractor.m
        public void a(long j, int i, int i2, int i3, m.a aVar) {
            this.miA.a(j, i, i2, i3, aVar);
        }
    }
}
