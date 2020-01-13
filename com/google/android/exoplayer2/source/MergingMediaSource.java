package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.x;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public final class MergingMediaSource implements l {
    private final x.b laT;
    private final l[] mqt;
    private l.a mqz;
    private x mrA;
    private Object mrB;
    private int mrC;
    private IllegalMergeException mrD;
    private final ArrayList<l> mrz;

    /* loaded from: classes5.dex */
    public static final class IllegalMergeException extends IOException {
        public static final int REASON_PERIOD_COUNT_MISMATCH = 1;
        public static final int REASON_WINDOWS_ARE_DYNAMIC = 0;
        public final int reason;

        public IllegalMergeException(int i) {
            this.reason = i;
        }
    }

    @Override // com.google.android.exoplayer2.source.l
    public void a(com.google.android.exoplayer2.g gVar, boolean z, l.a aVar) {
        this.mqz = aVar;
        for (final int i = 0; i < this.mqt.length; i++) {
            this.mqt[i].a(gVar, false, new l.a() { // from class: com.google.android.exoplayer2.source.MergingMediaSource.1
                @Override // com.google.android.exoplayer2.source.l.a
                public void a(l lVar, x xVar, Object obj) {
                    MergingMediaSource.this.a(i, xVar, obj);
                }
            });
        }
    }

    @Override // com.google.android.exoplayer2.source.l
    public void duY() throws IOException {
        if (this.mrD != null) {
            throw this.mrD;
        }
        for (l lVar : this.mqt) {
            lVar.duY();
        }
    }

    @Override // com.google.android.exoplayer2.source.l
    public k a(l.b bVar, com.google.android.exoplayer2.upstream.b bVar2) {
        k[] kVarArr = new k[this.mqt.length];
        for (int i = 0; i < kVarArr.length; i++) {
            kVarArr[i] = this.mqt[i].a(bVar, bVar2);
        }
        return new m(kVarArr);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void e(k kVar) {
        m mVar = (m) kVar;
        for (int i = 0; i < this.mqt.length; i++) {
            this.mqt[i].e(mVar.mru[i]);
        }
    }

    @Override // com.google.android.exoplayer2.source.l
    public void releaseSource() {
        for (l lVar : this.mqt) {
            lVar.releaseSource();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, x xVar, Object obj) {
        if (this.mrD == null) {
            this.mrD = b(xVar);
        }
        if (this.mrD == null) {
            this.mrz.remove(this.mqt[i]);
            if (i == 0) {
                this.mrA = xVar;
                this.mrB = obj;
            }
            if (this.mrz.isEmpty()) {
                this.mqz.a(this, this.mrA, this.mrB);
            }
        }
    }

    private IllegalMergeException b(x xVar) {
        int dsl = xVar.dsl();
        for (int i = 0; i < dsl; i++) {
            if (xVar.a(i, this.laT, false).isDynamic) {
                return new IllegalMergeException(0);
            }
        }
        if (this.mrC == -1) {
            this.mrC = xVar.dsm();
        } else if (xVar.dsm() != this.mrC) {
            return new IllegalMergeException(1);
        }
        return null;
    }
}
