package com.github.a.a;

import android.os.Debug;
import android.os.SystemClock;
import android.util.Printer;
import com.baidu.android.imsdk.internal.IMConnection;
/* loaded from: classes6.dex */
public class g implements Printer {
    private long pQG;
    private long pQH = 0;
    private long pQI = 0;
    private a pQJ;
    private final boolean pQK;

    /* loaded from: classes6.dex */
    public interface a {
        void d(long j, long j2, long j3, long j4);
    }

    public g(a aVar, long j, boolean z) {
        this.pQG = IMConnection.RETRY_DELAY_TIMES;
        this.pQJ = null;
        if (aVar == null) {
            throw new IllegalArgumentException("blockListener should not be null.");
        }
        this.pQJ = aVar;
        this.pQG = j;
        this.pQK = z;
    }

    @Override // android.util.Printer
    public void println(String str) {
        if (!this.pQK || !Debug.isDebuggerConnected()) {
            if (str.charAt(0) == '>') {
                this.pQH = System.currentTimeMillis();
                this.pQI = SystemClock.currentThreadTimeMillis();
                eAF();
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (iR(currentTimeMillis)) {
                iS(currentTimeMillis);
            }
            eAG();
        }
    }

    private boolean iR(long j) {
        return j - this.pQH > this.pQG;
    }

    private void iS(final long j) {
        final long j2 = this.pQH;
        final long j3 = this.pQI;
        final long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        e.eAD().post(new Runnable() { // from class: com.github.a.a.g.1
            @Override // java.lang.Runnable
            public void run() {
                g.this.pQJ.d(j2, j, j3, currentThreadTimeMillis);
            }
        });
    }

    private void eAF() {
        if (c.eAy().pQv != null) {
            c.eAy().pQv.start();
        }
        if (c.eAy().pQw != null) {
            c.eAy().pQw.start();
        }
    }

    private void eAG() {
        if (c.eAy().pQv != null) {
            c.eAy().pQv.stop();
        }
        if (c.eAy().pQw != null) {
            c.eAy().pQw.stop();
        }
    }
}
