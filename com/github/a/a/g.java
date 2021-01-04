package com.github.a.a;

import android.os.Debug;
import android.os.SystemClock;
import android.util.Printer;
import com.baidu.android.imsdk.internal.IMConnection;
/* loaded from: classes15.dex */
public class g implements Printer {
    private long pJt;
    private long pJu = 0;
    private long pJv = 0;
    private a pJw;
    private final boolean pJx;

    /* loaded from: classes15.dex */
    public interface a {
        void d(long j, long j2, long j3, long j4);
    }

    public g(a aVar, long j, boolean z) {
        this.pJt = IMConnection.RETRY_DELAY_TIMES;
        this.pJw = null;
        if (aVar == null) {
            throw new IllegalArgumentException("blockListener should not be null.");
        }
        this.pJw = aVar;
        this.pJt = j;
        this.pJx = z;
    }

    @Override // android.util.Printer
    public void println(String str) {
        if (!this.pJx || !Debug.isDebuggerConnected()) {
            if (str.charAt(0) == '>') {
                this.pJu = System.currentTimeMillis();
                this.pJv = SystemClock.currentThreadTimeMillis();
                eBB();
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (iL(currentTimeMillis)) {
                iM(currentTimeMillis);
            }
            eBC();
        }
    }

    private boolean iL(long j) {
        return j - this.pJu > this.pJt;
    }

    private void iM(final long j) {
        final long j2 = this.pJu;
        final long j3 = this.pJv;
        final long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        e.eBz().post(new Runnable() { // from class: com.github.a.a.g.1
            @Override // java.lang.Runnable
            public void run() {
                g.this.pJw.d(j2, j, j3, currentThreadTimeMillis);
            }
        });
    }

    private void eBB() {
        if (c.eBu().pJi != null) {
            c.eBu().pJi.start();
        }
        if (c.eBu().pJj != null) {
            c.eBu().pJj.start();
        }
    }

    private void eBC() {
        if (c.eBu().pJi != null) {
            c.eBu().pJi.stop();
        }
        if (c.eBu().pJj != null) {
            c.eBu().pJj.stop();
        }
    }
}
