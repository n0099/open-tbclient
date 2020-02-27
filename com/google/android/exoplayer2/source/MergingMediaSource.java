package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.x;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public final class MergingMediaSource implements l {
    private final x.b lbE;
    private final l[] mre;
    private l.a mrk;
    private final ArrayList<l> msl;
    private x msm;
    private Object msn;
    private int mso;
    private IllegalMergeException msp;

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
        this.mrk = aVar;
        for (final int i = 0; i < this.mre.length; i++) {
            this.mre[i].a(gVar, false, new l.a() { // from class: com.google.android.exoplayer2.source.MergingMediaSource.1
                @Override // com.google.android.exoplayer2.source.l.a
                public void a(l lVar, x xVar, Object obj) {
                    MergingMediaSource.this.a(i, xVar, obj);
                }
            });
        }
    }

    @Override // com.google.android.exoplayer2.source.l
    public void dwk() throws IOException {
        if (this.msp != null) {
            throw this.msp;
        }
        for (l lVar : this.mre) {
            lVar.dwk();
        }
    }

    @Override // com.google.android.exoplayer2.source.l
    public k a(l.b bVar, com.google.android.exoplayer2.upstream.b bVar2) {
        k[] kVarArr = new k[this.mre.length];
        for (int i = 0; i < kVarArr.length; i++) {
            kVarArr[i] = this.mre[i].a(bVar, bVar2);
        }
        return new m(kVarArr);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void e(k kVar) {
        m mVar = (m) kVar;
        for (int i = 0; i < this.mre.length; i++) {
            this.mre[i].e(mVar.msf[i]);
        }
    }

    @Override // com.google.android.exoplayer2.source.l
    public void releaseSource() {
        for (l lVar : this.mre) {
            lVar.releaseSource();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, x xVar, Object obj) {
        if (this.msp == null) {
            this.msp = b(xVar);
        }
        if (this.msp == null) {
            this.msl.remove(this.mre[i]);
            if (i == 0) {
                this.msm = xVar;
                this.msn = obj;
            }
            if (this.msl.isEmpty()) {
                this.mrk.a(this, this.msm, this.msn);
            }
        }
    }

    private IllegalMergeException b(x xVar) {
        int dtz = xVar.dtz();
        for (int i = 0; i < dtz; i++) {
            if (xVar.a(i, this.lbE, false).isDynamic) {
                return new IllegalMergeException(0);
            }
        }
        if (this.mso == -1) {
            this.mso = xVar.dtA();
        } else if (xVar.dtA() != this.mso) {
            return new IllegalMergeException(1);
        }
        return null;
    }
}
