package com.github.anrwatchdog;

import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
/* loaded from: classes14.dex */
public class a extends Thread {
    private static final b pRr = new b() { // from class: com.github.anrwatchdog.a.1
        @Override // com.github.anrwatchdog.a.b
        public void onAppNotResponding(ANRError aNRError) {
            throw aNRError;
        }
    };
    private static final InterfaceC1076a pRs = new InterfaceC1076a() { // from class: com.github.anrwatchdog.a.2
        @Override // com.github.anrwatchdog.a.InterfaceC1076a
        public long iQ(long j) {
            return 0L;
        }
    };
    private static final c pRt = new c() { // from class: com.github.anrwatchdog.a.3
        @Override // com.github.anrwatchdog.a.c
        public void a(InterruptedException interruptedException) {
            Log.w("ANRWatchdog", "Interrupted: " + interruptedException.getMessage());
        }
    };
    private boolean pRA;
    private boolean pRB;
    private volatile long pRC;
    private volatile boolean pRD;
    private final Runnable pRE;
    private b pRu;
    private InterfaceC1076a pRv;
    private c pRw;
    private final Handler pRx;
    private final int pRy;
    private String pRz;

    /* renamed from: com.github.anrwatchdog.a$a  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public interface InterfaceC1076a {
        long iQ(long j);
    }

    /* loaded from: classes14.dex */
    public interface b {
        void onAppNotResponding(ANRError aNRError);
    }

    /* loaded from: classes14.dex */
    public interface c {
        void a(InterruptedException interruptedException);
    }

    public a() {
        this(5000);
    }

    public a(int i) {
        this.pRu = pRr;
        this.pRv = pRs;
        this.pRw = pRt;
        this.pRx = new Handler(Looper.getMainLooper());
        this.pRz = "";
        this.pRA = false;
        this.pRB = true;
        this.pRC = 0L;
        this.pRD = false;
        this.pRE = new Runnable() { // from class: com.github.anrwatchdog.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.this.pRC = 0L;
                a.this.pRD = false;
            }
        };
        this.pRy = i;
    }

    public a a(b bVar) {
        if (bVar == null) {
            this.pRu = pRr;
        } else {
            this.pRu = bVar;
        }
        return this;
    }

    public a eAH() {
        this.pRz = null;
        return this;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        ANRError NewMainOnly;
        setName("|ANR-WatchDog|");
        long j = this.pRy;
        while (!isInterrupted()) {
            boolean z = this.pRC == 0;
            this.pRC += j;
            if (z) {
                this.pRx.post(this.pRE);
            }
            try {
                Thread.sleep(j);
                if (this.pRC != 0 && !this.pRD) {
                    if (!this.pRB && (Debug.isDebuggerConnected() || Debug.waitingForDebugger())) {
                        Log.w("ANRWatchdog", "An ANR was detected but ignored because the debugger is connected (you can prevent this with setIgnoreDebugger(true))");
                        this.pRD = true;
                    } else {
                        j = this.pRv.iQ(this.pRC);
                        if (j <= 0) {
                            if (this.pRz != null) {
                                NewMainOnly = ANRError.New(this.pRC, this.pRz, this.pRA);
                            } else {
                                NewMainOnly = ANRError.NewMainOnly(this.pRC);
                            }
                            this.pRu.onAppNotResponding(NewMainOnly);
                            j = this.pRy;
                            this.pRD = true;
                        }
                    }
                }
            } catch (InterruptedException e) {
                this.pRw.a(e);
                return;
            }
        }
    }
}
