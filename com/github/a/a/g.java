package com.github.a.a;

import android.os.Debug;
import android.os.SystemClock;
import android.util.Printer;
import com.baidu.android.imsdk.internal.IMConnection;
/* loaded from: classes6.dex */
public class g implements Printer {
    private long pRg;
    private long pRh = 0;
    private long pRi = 0;
    private a pRj;
    private final boolean pRk;

    /* loaded from: classes6.dex */
    public interface a {
        void d(long j, long j2, long j3, long j4);
    }

    public g(a aVar, long j, boolean z) {
        this.pRg = IMConnection.RETRY_DELAY_TIMES;
        this.pRj = null;
        if (aVar == null) {
            throw new IllegalArgumentException("blockListener should not be null.");
        }
        this.pRj = aVar;
        this.pRg = j;
        this.pRk = z;
    }

    @Override // android.util.Printer
    public void println(String str) {
        if (!this.pRk || !Debug.isDebuggerConnected()) {
            if (str.charAt(0) == '>') {
                this.pRh = System.currentTimeMillis();
                this.pRi = SystemClock.currentThreadTimeMillis();
                eAN();
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (iR(currentTimeMillis)) {
                iS(currentTimeMillis);
            }
            eAO();
        }
    }

    private boolean iR(long j) {
        return j - this.pRh > this.pRg;
    }

    private void iS(final long j) {
        final long j2 = this.pRh;
        final long j3 = this.pRi;
        final long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        e.eAL().post(new Runnable() { // from class: com.github.a.a.g.1
            @Override // java.lang.Runnable
            public void run() {
                g.this.pRj.d(j2, j, j3, currentThreadTimeMillis);
            }
        });
    }

    private void eAN() {
        if (c.eAG().pQV != null) {
            c.eAG().pQV.start();
        }
        if (c.eAG().pQW != null) {
            c.eAG().pQW.start();
        }
    }

    private void eAO() {
        if (c.eAG().pQV != null) {
            c.eAG().pQV.stop();
        }
        if (c.eAG().pQW != null) {
            c.eAG().pQW.stop();
        }
    }
}
