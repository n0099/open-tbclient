package com.github.a.a;

import android.os.Debug;
import android.os.SystemClock;
import android.util.Printer;
import com.baidu.android.imsdk.internal.IMConnection;
/* loaded from: classes6.dex */
public class g implements Printer {
    private long pGB;
    private long pGC = 0;
    private long pGD = 0;
    private a pGE;
    private final boolean pGF;

    /* loaded from: classes6.dex */
    public interface a {
        void d(long j, long j2, long j3, long j4);
    }

    public g(a aVar, long j, boolean z) {
        this.pGB = IMConnection.RETRY_DELAY_TIMES;
        this.pGE = null;
        if (aVar == null) {
            throw new IllegalArgumentException("blockListener should not be null.");
        }
        this.pGE = aVar;
        this.pGB = j;
        this.pGF = z;
    }

    @Override // android.util.Printer
    public void println(String str) {
        if (!this.pGF || !Debug.isDebuggerConnected()) {
            if (str.charAt(0) == '>') {
                this.pGC = System.currentTimeMillis();
                this.pGD = SystemClock.currentThreadTimeMillis();
                eyn();
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (iO(currentTimeMillis)) {
                iP(currentTimeMillis);
            }
            eyo();
        }
    }

    private boolean iO(long j) {
        return j - this.pGC > this.pGB;
    }

    private void iP(final long j) {
        final long j2 = this.pGC;
        final long j3 = this.pGD;
        final long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        e.eyl().post(new Runnable() { // from class: com.github.a.a.g.1
            @Override // java.lang.Runnable
            public void run() {
                g.this.pGE.d(j2, j, j3, currentThreadTimeMillis);
            }
        });
    }

    private void eyn() {
        if (c.eyg().pGq != null) {
            c.eyg().pGq.start();
        }
        if (c.eyg().pGr != null) {
            c.eyg().pGr.start();
        }
    }

    private void eyo() {
        if (c.eyg().pGq != null) {
            c.eyg().pGq.stop();
        }
        if (c.eyg().pGr != null) {
            c.eyg().pGr.stop();
        }
    }
}
