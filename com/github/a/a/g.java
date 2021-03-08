package com.github.a.a;

import android.os.Debug;
import android.os.SystemClock;
import android.util.Printer;
import com.baidu.android.imsdk.internal.IMConnection;
/* loaded from: classes5.dex */
public class g implements Printer {
    private long pRV;
    private long pRW = 0;
    private long pRX = 0;
    private a pRY;
    private final boolean pRZ;

    /* loaded from: classes5.dex */
    public interface a {
        void d(long j, long j2, long j3, long j4);
    }

    public g(a aVar, long j, boolean z) {
        this.pRV = IMConnection.RETRY_DELAY_TIMES;
        this.pRY = null;
        if (aVar == null) {
            throw new IllegalArgumentException("blockListener should not be null.");
        }
        this.pRY = aVar;
        this.pRV = j;
        this.pRZ = z;
    }

    @Override // android.util.Printer
    public void println(String str) {
        if (!this.pRZ || !Debug.isDebuggerConnected()) {
            if (str.charAt(0) == '>') {
                this.pRW = System.currentTimeMillis();
                this.pRX = SystemClock.currentThreadTimeMillis();
                eAT();
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (iR(currentTimeMillis)) {
                iS(currentTimeMillis);
            }
            eAU();
        }
    }

    private boolean iR(long j) {
        return j - this.pRW > this.pRV;
    }

    private void iS(final long j) {
        final long j2 = this.pRW;
        final long j3 = this.pRX;
        final long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        e.eAR().post(new Runnable() { // from class: com.github.a.a.g.1
            @Override // java.lang.Runnable
            public void run() {
                g.this.pRY.d(j2, j, j3, currentThreadTimeMillis);
            }
        });
    }

    private void eAT() {
        if (c.eAM().pRK != null) {
            c.eAM().pRK.start();
        }
        if (c.eAM().pRL != null) {
            c.eAM().pRL.start();
        }
    }

    private void eAU() {
        if (c.eAM().pRK != null) {
            c.eAM().pRK.stop();
        }
        if (c.eAM().pRL != null) {
            c.eAM().pRL.stop();
        }
    }
}
