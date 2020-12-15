package com.github.a.a;

import android.os.Debug;
import android.os.SystemClock;
import android.util.Printer;
import com.baidu.android.imsdk.internal.IMConnection;
/* loaded from: classes7.dex */
public class g implements Printer {
    private long psr;
    private long pss = 0;
    private long pst = 0;
    private a psu;
    private final boolean psv;

    /* loaded from: classes7.dex */
    public interface a {
        void d(long j, long j2, long j3, long j4);
    }

    public g(a aVar, long j, boolean z) {
        this.psr = IMConnection.RETRY_DELAY_TIMES;
        this.psu = null;
        if (aVar == null) {
            throw new IllegalArgumentException("blockListener should not be null.");
        }
        this.psu = aVar;
        this.psr = j;
        this.psv = z;
    }

    @Override // android.util.Printer
    public void println(String str) {
        if (!this.psv || !Debug.isDebuggerConnected()) {
            if (str.charAt(0) == '>') {
                this.pss = System.currentTimeMillis();
                this.pst = SystemClock.currentThreadTimeMillis();
                exQ();
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (iA(currentTimeMillis)) {
                iB(currentTimeMillis);
            }
            exR();
        }
    }

    private boolean iA(long j) {
        return j - this.pss > this.psr;
    }

    private void iB(final long j) {
        final long j2 = this.pss;
        final long j3 = this.pst;
        final long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        e.exO().post(new Runnable() { // from class: com.github.a.a.g.1
            @Override // java.lang.Runnable
            public void run() {
                g.this.psu.d(j2, j, j3, currentThreadTimeMillis);
            }
        });
    }

    private void exQ() {
        if (c.exJ().psg != null) {
            c.exJ().psg.start();
        }
        if (c.exJ().psh != null) {
            c.exJ().psh.start();
        }
    }

    private void exR() {
        if (c.exJ().psg != null) {
            c.exJ().psg.stop();
        }
        if (c.exJ().psh != null) {
            c.exJ().psh.stop();
        }
    }
}
