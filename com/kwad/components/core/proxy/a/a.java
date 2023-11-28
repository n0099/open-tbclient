package com.kwad.components.core.proxy.a;

import android.os.SystemClock;
import com.kwad.components.core.proxy.PageCreateStage;
import com.kwad.sdk.utils.bn;
/* loaded from: classes10.dex */
public final class a {
    public String QQ;
    public long QR;
    public long QS;
    public long QT;
    public boolean QU;
    public c QV;

    public a(c cVar) {
        this.QV = cVar;
    }

    public final void B(long j) {
        this.QR = j;
        this.QS = SystemClock.uptimeMillis();
    }

    public final void a(PageCreateStage pageCreateStage) {
        c cVar = this.QV;
        if (cVar != null) {
            cVar.onCreateStageChange(pageCreateStage);
        }
    }

    public final void ao(String str) {
        this.QQ = str;
    }

    public final void pW() {
        if (this.QU) {
            return;
        }
        this.QU = true;
        bn.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.proxy.a.a.1
            @Override // java.lang.Runnable
            public final void run() {
                a.this.QT = SystemClock.uptimeMillis();
                a.this.report();
            }
        });
    }

    public final void report() {
        long j;
        long j2;
        b bVar = new b();
        bVar.QQ = this.QQ;
        long j3 = this.QR;
        long j4 = 0;
        if (j3 != 0) {
            j = this.QS - j3;
        } else {
            j = 0;
        }
        bVar.QY = j;
        long j5 = this.QS;
        if (j5 != 0) {
            j2 = this.QT - j5;
        } else {
            j2 = 0;
        }
        bVar.QZ = j2;
        long j6 = this.QR;
        if (j6 != 0) {
            j4 = this.QT - j6;
        }
        bVar.QX = j4;
        com.kwad.components.core.o.a.pX().a(bVar);
        com.kwad.sdk.core.e.c.d("PageMonitor", bVar.toString());
    }
}
