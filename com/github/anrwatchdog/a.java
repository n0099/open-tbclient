package com.github.anrwatchdog;

import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
/* loaded from: classes6.dex */
public class a extends Thread {
    private static final b pKx = new b() { // from class: com.github.anrwatchdog.a.1
        @Override // com.github.anrwatchdog.a.b
        public void onAppNotResponding(ANRError aNRError) {
            throw aNRError;
        }
    };
    private static final InterfaceC1070a pKy = new InterfaceC1070a() { // from class: com.github.anrwatchdog.a.2
        @Override // com.github.anrwatchdog.a.InterfaceC1070a
        public long iN(long j) {
            return 0L;
        }
    };
    private static final c pKz = new c() { // from class: com.github.anrwatchdog.a.3
        @Override // com.github.anrwatchdog.a.c
        public void a(InterruptedException interruptedException) {
            Log.w("ANRWatchdog", "Interrupted: " + interruptedException.getMessage());
        }
    };
    private b pKA;
    private InterfaceC1070a pKB;
    private c pKC;
    private final Handler pKD;
    private final int pKE;
    private String pKF;
    private boolean pKG;
    private boolean pKH;
    private volatile long pKI;
    private volatile boolean pKJ;
    private final Runnable pKK;

    /* renamed from: com.github.anrwatchdog.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC1070a {
        long iN(long j);
    }

    /* loaded from: classes6.dex */
    public interface b {
        void onAppNotResponding(ANRError aNRError);
    }

    /* loaded from: classes6.dex */
    public interface c {
        void a(InterruptedException interruptedException);
    }

    public a() {
        this(5000);
    }

    public a(int i) {
        this.pKA = pKx;
        this.pKB = pKy;
        this.pKC = pKz;
        this.pKD = new Handler(Looper.getMainLooper());
        this.pKF = "";
        this.pKG = false;
        this.pKH = true;
        this.pKI = 0L;
        this.pKJ = false;
        this.pKK = new Runnable() { // from class: com.github.anrwatchdog.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.this.pKI = 0L;
                a.this.pKJ = false;
            }
        };
        this.pKE = i;
    }

    public a a(b bVar) {
        if (bVar == null) {
            this.pKA = pKx;
        } else {
            this.pKA = bVar;
        }
        return this;
    }

    public a eBT() {
        this.pKF = null;
        return this;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        ANRError NewMainOnly;
        setName("|ANR-WatchDog|");
        long j = this.pKE;
        while (!isInterrupted()) {
            boolean z = this.pKI == 0;
            this.pKI += j;
            if (z) {
                this.pKD.post(this.pKK);
            }
            try {
                Thread.sleep(j);
                if (this.pKI != 0 && !this.pKJ) {
                    if (!this.pKH && (Debug.isDebuggerConnected() || Debug.waitingForDebugger())) {
                        Log.w("ANRWatchdog", "An ANR was detected but ignored because the debugger is connected (you can prevent this with setIgnoreDebugger(true))");
                        this.pKJ = true;
                    } else {
                        j = this.pKB.iN(this.pKI);
                        if (j <= 0) {
                            if (this.pKF != null) {
                                NewMainOnly = ANRError.New(this.pKI, this.pKF, this.pKG);
                            } else {
                                NewMainOnly = ANRError.NewMainOnly(this.pKI);
                            }
                            this.pKA.onAppNotResponding(NewMainOnly);
                            j = this.pKE;
                            this.pKJ = true;
                        }
                    }
                }
            } catch (InterruptedException e) {
                this.pKC.a(e);
                return;
            }
        }
    }
}
