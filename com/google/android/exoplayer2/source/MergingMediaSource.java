package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.x;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public final class MergingMediaSource implements l {
    private final x.b kXt;
    private final l[] mmE;
    private l.a mmK;
    private final ArrayList<l> mnK;
    private x mnL;
    private Object mnM;
    private int mnN;
    private IllegalMergeException mnO;

    /* loaded from: classes4.dex */
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
        this.mmK = aVar;
        for (final int i = 0; i < this.mmE.length; i++) {
            this.mmE[i].a(gVar, false, new l.a() { // from class: com.google.android.exoplayer2.source.MergingMediaSource.1
                @Override // com.google.android.exoplayer2.source.l.a
                public void a(l lVar, x xVar, Object obj) {
                    MergingMediaSource.this.a(i, xVar, obj);
                }
            });
        }
    }

    @Override // com.google.android.exoplayer2.source.l
    public void dtN() throws IOException {
        if (this.mnO != null) {
            throw this.mnO;
        }
        for (l lVar : this.mmE) {
            lVar.dtN();
        }
    }

    @Override // com.google.android.exoplayer2.source.l
    public k a(l.b bVar, com.google.android.exoplayer2.upstream.b bVar2) {
        k[] kVarArr = new k[this.mmE.length];
        for (int i = 0; i < kVarArr.length; i++) {
            kVarArr[i] = this.mmE[i].a(bVar, bVar2);
        }
        return new m(kVarArr);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void e(k kVar) {
        m mVar = (m) kVar;
        for (int i = 0; i < this.mmE.length; i++) {
            this.mmE[i].e(mVar.mnF[i]);
        }
    }

    @Override // com.google.android.exoplayer2.source.l
    public void releaseSource() {
        for (l lVar : this.mmE) {
            lVar.releaseSource();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, x xVar, Object obj) {
        if (this.mnO == null) {
            this.mnO = b(xVar);
        }
        if (this.mnO == null) {
            this.mnK.remove(this.mmE[i]);
            if (i == 0) {
                this.mnL = xVar;
                this.mnM = obj;
            }
            if (this.mnK.isEmpty()) {
                this.mmK.a(this, this.mnL, this.mnM);
            }
        }
    }

    private IllegalMergeException b(x xVar) {
        int dqZ = xVar.dqZ();
        for (int i = 0; i < dqZ; i++) {
            if (xVar.a(i, this.kXt, false).isDynamic) {
                return new IllegalMergeException(0);
            }
        }
        if (this.mnN == -1) {
            this.mnN = xVar.dra();
        } else if (xVar.dra() != this.mnN) {
            return new IllegalMergeException(1);
        }
        return null;
    }
}
