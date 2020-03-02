package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.x;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public final class MergingMediaSource implements l {
    private final x.b lbG;
    private final l[] mrg;
    private l.a mrm;
    private final ArrayList<l> msn;
    private x mso;
    private Object msp;
    private int msq;
    private IllegalMergeException msr;

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
        this.mrm = aVar;
        for (final int i = 0; i < this.mrg.length; i++) {
            this.mrg[i].a(gVar, false, new l.a() { // from class: com.google.android.exoplayer2.source.MergingMediaSource.1
                @Override // com.google.android.exoplayer2.source.l.a
                public void a(l lVar, x xVar, Object obj) {
                    MergingMediaSource.this.a(i, xVar, obj);
                }
            });
        }
    }

    @Override // com.google.android.exoplayer2.source.l
    public void dwm() throws IOException {
        if (this.msr != null) {
            throw this.msr;
        }
        for (l lVar : this.mrg) {
            lVar.dwm();
        }
    }

    @Override // com.google.android.exoplayer2.source.l
    public k a(l.b bVar, com.google.android.exoplayer2.upstream.b bVar2) {
        k[] kVarArr = new k[this.mrg.length];
        for (int i = 0; i < kVarArr.length; i++) {
            kVarArr[i] = this.mrg[i].a(bVar, bVar2);
        }
        return new m(kVarArr);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void e(k kVar) {
        m mVar = (m) kVar;
        for (int i = 0; i < this.mrg.length; i++) {
            this.mrg[i].e(mVar.msi[i]);
        }
    }

    @Override // com.google.android.exoplayer2.source.l
    public void releaseSource() {
        for (l lVar : this.mrg) {
            lVar.releaseSource();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, x xVar, Object obj) {
        if (this.msr == null) {
            this.msr = b(xVar);
        }
        if (this.msr == null) {
            this.msn.remove(this.mrg[i]);
            if (i == 0) {
                this.mso = xVar;
                this.msp = obj;
            }
            if (this.msn.isEmpty()) {
                this.mrm.a(this, this.mso, this.msp);
            }
        }
    }

    private IllegalMergeException b(x xVar) {
        int dtB = xVar.dtB();
        for (int i = 0; i < dtB; i++) {
            if (xVar.a(i, this.lbG, false).isDynamic) {
                return new IllegalMergeException(0);
            }
        }
        if (this.msq == -1) {
            this.msq = xVar.dtC();
        } else if (xVar.dtC() != this.msq) {
            return new IllegalMergeException(1);
        }
        return null;
    }
}
