package com.github.anrwatchdog;

import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
/* loaded from: classes15.dex */
public class a extends Thread {
    private static final b pQc = new b() { // from class: com.github.anrwatchdog.a.1
        @Override // com.github.anrwatchdog.a.b
        public void onAppNotResponding(ANRError aNRError) {
            throw aNRError;
        }
    };
    private static final InterfaceC1057a pQd = new InterfaceC1057a() { // from class: com.github.anrwatchdog.a.2
        @Override // com.github.anrwatchdog.a.InterfaceC1057a
        public long iQ(long j) {
            return 0L;
        }
    };
    private static final c pQe = new c() { // from class: com.github.anrwatchdog.a.3
        @Override // com.github.anrwatchdog.a.c
        public void a(InterruptedException interruptedException) {
            Log.w("ANRWatchdog", "Interrupted: " + interruptedException.getMessage());
        }
    };
    private b pQf;
    private InterfaceC1057a pQg;
    private c pQh;
    private final Handler pQi;
    private final int pQj;
    private String pQk;
    private boolean pQl;
    private boolean pQm;
    private volatile long pQn;
    private volatile boolean pQo;
    private final Runnable pQp;

    /* renamed from: com.github.anrwatchdog.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public interface InterfaceC1057a {
        long iQ(long j);
    }

    /* loaded from: classes15.dex */
    public interface b {
        void onAppNotResponding(ANRError aNRError);
    }

    /* loaded from: classes15.dex */
    public interface c {
        void a(InterruptedException interruptedException);
    }

    public a() {
        this(5000);
    }

    public a(int i) {
        this.pQf = pQc;
        this.pQg = pQd;
        this.pQh = pQe;
        this.pQi = new Handler(Looper.getMainLooper());
        this.pQk = "";
        this.pQl = false;
        this.pQm = true;
        this.pQn = 0L;
        this.pQo = false;
        this.pQp = new Runnable() { // from class: com.github.anrwatchdog.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.this.pQn = 0L;
                a.this.pQo = false;
            }
        };
        this.pQj = i;
    }

    public a a(b bVar) {
        if (bVar == null) {
            this.pQf = pQc;
        } else {
            this.pQf = bVar;
        }
        return this;
    }

    public a eAt() {
        this.pQk = null;
        return this;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        ANRError NewMainOnly;
        setName("|ANR-WatchDog|");
        long j = this.pQj;
        while (!isInterrupted()) {
            boolean z = this.pQn == 0;
            this.pQn += j;
            if (z) {
                this.pQi.post(this.pQp);
            }
            try {
                Thread.sleep(j);
                if (this.pQn != 0 && !this.pQo) {
                    if (!this.pQm && (Debug.isDebuggerConnected() || Debug.waitingForDebugger())) {
                        Log.w("ANRWatchdog", "An ANR was detected but ignored because the debugger is connected (you can prevent this with setIgnoreDebugger(true))");
                        this.pQo = true;
                    } else {
                        j = this.pQg.iQ(this.pQn);
                        if (j <= 0) {
                            if (this.pQk != null) {
                                NewMainOnly = ANRError.New(this.pQn, this.pQk, this.pQl);
                            } else {
                                NewMainOnly = ANRError.NewMainOnly(this.pQn);
                            }
                            this.pQf.onAppNotResponding(NewMainOnly);
                            j = this.pQj;
                            this.pQo = true;
                        }
                    }
                }
            } catch (InterruptedException e) {
                this.pQh.a(e);
                return;
            }
        }
    }
}
