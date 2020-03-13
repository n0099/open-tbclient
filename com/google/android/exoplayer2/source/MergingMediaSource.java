package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.x;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public final class MergingMediaSource implements l {
    private final x.b lbS;
    private final l[] mrr;
    private l.a mrx;
    private Object msA;
    private int msB;
    private IllegalMergeException msC;
    private final ArrayList<l> msy;
    private x msz;

    /* loaded from: classes6.dex */
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
        this.mrx = aVar;
        for (final int i = 0; i < this.mrr.length; i++) {
            this.mrr[i].a(gVar, false, new l.a() { // from class: com.google.android.exoplayer2.source.MergingMediaSource.1
                @Override // com.google.android.exoplayer2.source.l.a
                public void a(l lVar, x xVar, Object obj) {
                    MergingMediaSource.this.a(i, xVar, obj);
                }
            });
        }
    }

    @Override // com.google.android.exoplayer2.source.l
    public void dwn() throws IOException {
        if (this.msC != null) {
            throw this.msC;
        }
        for (l lVar : this.mrr) {
            lVar.dwn();
        }
    }

    @Override // com.google.android.exoplayer2.source.l
    public k a(l.b bVar, com.google.android.exoplayer2.upstream.b bVar2) {
        k[] kVarArr = new k[this.mrr.length];
        for (int i = 0; i < kVarArr.length; i++) {
            kVarArr[i] = this.mrr[i].a(bVar, bVar2);
        }
        return new m(kVarArr);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void e(k kVar) {
        m mVar = (m) kVar;
        for (int i = 0; i < this.mrr.length; i++) {
            this.mrr[i].e(mVar.mst[i]);
        }
    }

    @Override // com.google.android.exoplayer2.source.l
    public void releaseSource() {
        for (l lVar : this.mrr) {
            lVar.releaseSource();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, x xVar, Object obj) {
        if (this.msC == null) {
            this.msC = b(xVar);
        }
        if (this.msC == null) {
            this.msy.remove(this.mrr[i]);
            if (i == 0) {
                this.msz = xVar;
                this.msA = obj;
            }
            if (this.msy.isEmpty()) {
                this.mrx.a(this, this.msz, this.msA);
            }
        }
    }

    private IllegalMergeException b(x xVar) {
        int dtC = xVar.dtC();
        for (int i = 0; i < dtC; i++) {
            if (xVar.a(i, this.lbS, false).isDynamic) {
                return new IllegalMergeException(0);
            }
        }
        if (this.msB == -1) {
            this.msB = xVar.dtD();
        } else if (xVar.dtD() != this.msB) {
            return new IllegalMergeException(1);
        }
        return null;
    }
}
