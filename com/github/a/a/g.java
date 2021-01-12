package com.github.a.a;

import android.os.Debug;
import android.os.SystemClock;
import android.util.Printer;
import com.baidu.android.imsdk.internal.IMConnection;
/* loaded from: classes6.dex */
public class g implements Printer {
    private long pGA;
    private long pGB = 0;
    private long pGC = 0;
    private a pGD;
    private final boolean pGE;

    /* loaded from: classes6.dex */
    public interface a {
        void d(long j, long j2, long j3, long j4);
    }

    public g(a aVar, long j, boolean z) {
        this.pGA = IMConnection.RETRY_DELAY_TIMES;
        this.pGD = null;
        if (aVar == null) {
            throw new IllegalArgumentException("blockListener should not be null.");
        }
        this.pGD = aVar;
        this.pGA = j;
        this.pGE = z;
    }

    @Override // android.util.Printer
    public void println(String str) {
        if (!this.pGE || !Debug.isDebuggerConnected()) {
            if (str.charAt(0) == '>') {
                this.pGB = System.currentTimeMillis();
                this.pGC = SystemClock.currentThreadTimeMillis();
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
        return j - this.pGB > this.pGA;
    }

    private void iP(final long j) {
        final long j2 = this.pGB;
        final long j3 = this.pGC;
        final long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        e.eyl().post(new Runnable() { // from class: com.github.a.a.g.1
            @Override // java.lang.Runnable
            public void run() {
                g.this.pGD.d(j2, j, j3, currentThreadTimeMillis);
            }
        });
    }

    private void eyn() {
        if (c.eyg().pGp != null) {
            c.eyg().pGp.start();
        }
        if (c.eyg().pGq != null) {
            c.eyg().pGq.start();
        }
    }

    private void eyo() {
        if (c.eyg().pGp != null) {
            c.eyg().pGp.stop();
        }
        if (c.eyg().pGq != null) {
            c.eyg().pGq.stop();
        }
    }
}
