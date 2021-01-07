package com.github.a.a;

import android.os.Debug;
import android.os.SystemClock;
import android.util.Printer;
import com.baidu.android.imsdk.internal.IMConnection;
/* loaded from: classes6.dex */
public class g implements Printer {
    private long pLb;
    private long pLc = 0;
    private long pLd = 0;
    private a pLe;
    private final boolean pLf;

    /* loaded from: classes6.dex */
    public interface a {
        void d(long j, long j2, long j3, long j4);
    }

    public g(a aVar, long j, boolean z) {
        this.pLb = IMConnection.RETRY_DELAY_TIMES;
        this.pLe = null;
        if (aVar == null) {
            throw new IllegalArgumentException("blockListener should not be null.");
        }
        this.pLe = aVar;
        this.pLb = j;
        this.pLf = z;
    }

    @Override // android.util.Printer
    public void println(String str) {
        if (!this.pLf || !Debug.isDebuggerConnected()) {
            if (str.charAt(0) == '>') {
                this.pLc = System.currentTimeMillis();
                this.pLd = SystemClock.currentThreadTimeMillis();
                eCf();
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (iO(currentTimeMillis)) {
                iP(currentTimeMillis);
            }
            eCg();
        }
    }

    private boolean iO(long j) {
        return j - this.pLc > this.pLb;
    }

    private void iP(final long j) {
        final long j2 = this.pLc;
        final long j3 = this.pLd;
        final long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        e.eCd().post(new Runnable() { // from class: com.github.a.a.g.1
            @Override // java.lang.Runnable
            public void run() {
                g.this.pLe.d(j2, j, j3, currentThreadTimeMillis);
            }
        });
    }

    private void eCf() {
        if (c.eBY().pKQ != null) {
            c.eBY().pKQ.start();
        }
        if (c.eBY().pKR != null) {
            c.eBY().pKR.start();
        }
    }

    private void eCg() {
        if (c.eBY().pKQ != null) {
            c.eBY().pKQ.stop();
        }
        if (c.eBY().pKR != null) {
            c.eBY().pKR.stop();
        }
    }
}
