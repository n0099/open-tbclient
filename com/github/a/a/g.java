package com.github.a.a;

import android.os.Debug;
import android.os.SystemClock;
import android.util.Printer;
import com.baidu.android.imsdk.internal.IMConnection;
/* loaded from: classes7.dex */
public class g implements Printer {
    private long psp;
    private long psq = 0;
    private long psr = 0;
    private a pss;
    private final boolean pst;

    /* loaded from: classes7.dex */
    public interface a {
        void d(long j, long j2, long j3, long j4);
    }

    public g(a aVar, long j, boolean z) {
        this.psp = IMConnection.RETRY_DELAY_TIMES;
        this.pss = null;
        if (aVar == null) {
            throw new IllegalArgumentException("blockListener should not be null.");
        }
        this.pss = aVar;
        this.psp = j;
        this.pst = z;
    }

    @Override // android.util.Printer
    public void println(String str) {
        if (!this.pst || !Debug.isDebuggerConnected()) {
            if (str.charAt(0) == '>') {
                this.psq = System.currentTimeMillis();
                this.psr = SystemClock.currentThreadTimeMillis();
                exP();
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (iA(currentTimeMillis)) {
                iB(currentTimeMillis);
            }
            exQ();
        }
    }

    private boolean iA(long j) {
        return j - this.psq > this.psp;
    }

    private void iB(final long j) {
        final long j2 = this.psq;
        final long j3 = this.psr;
        final long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        e.exN().post(new Runnable() { // from class: com.github.a.a.g.1
            @Override // java.lang.Runnable
            public void run() {
                g.this.pss.d(j2, j, j3, currentThreadTimeMillis);
            }
        });
    }

    private void exP() {
        if (c.exI().pse != null) {
            c.exI().pse.start();
        }
        if (c.exI().psf != null) {
            c.exI().psf.start();
        }
    }

    private void exQ() {
        if (c.exI().pse != null) {
            c.exI().pse.stop();
        }
        if (c.exI().psf != null) {
            c.exI().psf.stop();
        }
    }
}
