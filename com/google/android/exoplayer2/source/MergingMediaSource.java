package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.x;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public final class MergingMediaSource implements l {
    private final x.b ldx;
    private final l[] msY;
    private l.a mte;
    private final ArrayList<l> muf;
    private x mug;
    private Object muh;
    private int mui;
    private IllegalMergeException muj;

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
        this.mte = aVar;
        for (final int i = 0; i < this.msY.length; i++) {
            this.msY[i].a(gVar, false, new l.a() { // from class: com.google.android.exoplayer2.source.MergingMediaSource.1
                @Override // com.google.android.exoplayer2.source.l.a
                public void a(l lVar, x xVar, Object obj) {
                    MergingMediaSource.this.a(i, xVar, obj);
                }
            });
        }
    }

    @Override // com.google.android.exoplayer2.source.l
    public void dwK() throws IOException {
        if (this.muj != null) {
            throw this.muj;
        }
        for (l lVar : this.msY) {
            lVar.dwK();
        }
    }

    @Override // com.google.android.exoplayer2.source.l
    public k a(l.b bVar, com.google.android.exoplayer2.upstream.b bVar2) {
        k[] kVarArr = new k[this.msY.length];
        for (int i = 0; i < kVarArr.length; i++) {
            kVarArr[i] = this.msY[i].a(bVar, bVar2);
        }
        return new m(kVarArr);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void e(k kVar) {
        m mVar = (m) kVar;
        for (int i = 0; i < this.msY.length; i++) {
            this.msY[i].e(mVar.mua[i]);
        }
    }

    @Override // com.google.android.exoplayer2.source.l
    public void releaseSource() {
        for (l lVar : this.msY) {
            lVar.releaseSource();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, x xVar, Object obj) {
        if (this.muj == null) {
            this.muj = b(xVar);
        }
        if (this.muj == null) {
            this.muf.remove(this.msY[i]);
            if (i == 0) {
                this.mug = xVar;
                this.muh = obj;
            }
            if (this.muf.isEmpty()) {
                this.mte.a(this, this.mug, this.muh);
            }
        }
    }

    private IllegalMergeException b(x xVar) {
        int dtZ = xVar.dtZ();
        for (int i = 0; i < dtZ; i++) {
            if (xVar.a(i, this.ldx, false).isDynamic) {
                return new IllegalMergeException(0);
            }
        }
        if (this.mui == -1) {
            this.mui = xVar.dua();
        } else if (xVar.dua() != this.mui) {
            return new IllegalMergeException(1);
        }
        return null;
    }
}
