package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.x;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public final class MergingMediaSource implements l {
    private final x.b laY;
    private l.a mqE;
    private final l[] mqy;
    private final ArrayList<l> mrE;
    private x mrF;
    private Object mrG;
    private int mrH;
    private IllegalMergeException mrI;

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
        this.mqE = aVar;
        for (final int i = 0; i < this.mqy.length; i++) {
            this.mqy[i].a(gVar, false, new l.a() { // from class: com.google.android.exoplayer2.source.MergingMediaSource.1
                @Override // com.google.android.exoplayer2.source.l.a
                public void a(l lVar, x xVar, Object obj) {
                    MergingMediaSource.this.a(i, xVar, obj);
                }
            });
        }
    }

    @Override // com.google.android.exoplayer2.source.l
    public void dva() throws IOException {
        if (this.mrI != null) {
            throw this.mrI;
        }
        for (l lVar : this.mqy) {
            lVar.dva();
        }
    }

    @Override // com.google.android.exoplayer2.source.l
    public k a(l.b bVar, com.google.android.exoplayer2.upstream.b bVar2) {
        k[] kVarArr = new k[this.mqy.length];
        for (int i = 0; i < kVarArr.length; i++) {
            kVarArr[i] = this.mqy[i].a(bVar, bVar2);
        }
        return new m(kVarArr);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void e(k kVar) {
        m mVar = (m) kVar;
        for (int i = 0; i < this.mqy.length; i++) {
            this.mqy[i].e(mVar.mrz[i]);
        }
    }

    @Override // com.google.android.exoplayer2.source.l
    public void releaseSource() {
        for (l lVar : this.mqy) {
            lVar.releaseSource();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, x xVar, Object obj) {
        if (this.mrI == null) {
            this.mrI = b(xVar);
        }
        if (this.mrI == null) {
            this.mrE.remove(this.mqy[i]);
            if (i == 0) {
                this.mrF = xVar;
                this.mrG = obj;
            }
            if (this.mrE.isEmpty()) {
                this.mqE.a(this, this.mrF, this.mrG);
            }
        }
    }

    private IllegalMergeException b(x xVar) {
        int dsn = xVar.dsn();
        for (int i = 0; i < dsn; i++) {
            if (xVar.a(i, this.laY, false).isDynamic) {
                return new IllegalMergeException(0);
            }
        }
        if (this.mrH == -1) {
            this.mrH = xVar.dso();
        } else if (xVar.dso() != this.mrH) {
            return new IllegalMergeException(1);
        }
        return null;
    }
}
