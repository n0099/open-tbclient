package com.github.anrwatchdog;

import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
/* loaded from: classes6.dex */
public class a extends Thread {
    private static final b pFX = new b() { // from class: com.github.anrwatchdog.a.1
        @Override // com.github.anrwatchdog.a.b
        public void onAppNotResponding(ANRError aNRError) {
            throw aNRError;
        }
    };
    private static final InterfaceC1053a pFY = new InterfaceC1053a() { // from class: com.github.anrwatchdog.a.2
        @Override // com.github.anrwatchdog.a.InterfaceC1053a
        public long iN(long j) {
            return 0L;
        }
    };
    private static final c pFZ = new c() { // from class: com.github.anrwatchdog.a.3
        @Override // com.github.anrwatchdog.a.c
        public void a(InterruptedException interruptedException) {
            Log.w("ANRWatchdog", "Interrupted: " + interruptedException.getMessage());
        }
    };
    private b pGa;
    private InterfaceC1053a pGb;
    private c pGc;
    private final Handler pGd;
    private final int pGe;
    private String pGf;
    private boolean pGg;
    private boolean pGh;
    private volatile long pGi;
    private volatile boolean pGj;
    private final Runnable pGk;

    /* renamed from: com.github.anrwatchdog.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC1053a {
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
        this.pGa = pFX;
        this.pGb = pFY;
        this.pGc = pFZ;
        this.pGd = new Handler(Looper.getMainLooper());
        this.pGf = "";
        this.pGg = false;
        this.pGh = true;
        this.pGi = 0L;
        this.pGj = false;
        this.pGk = new Runnable() { // from class: com.github.anrwatchdog.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.this.pGi = 0L;
                a.this.pGj = false;
            }
        };
        this.pGe = i;
    }

    public a a(b bVar) {
        if (bVar == null) {
            this.pGa = pFX;
        } else {
            this.pGa = bVar;
        }
        return this;
    }

    public a eyb() {
        this.pGf = null;
        return this;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        ANRError NewMainOnly;
        setName("|ANR-WatchDog|");
        long j = this.pGe;
        while (!isInterrupted()) {
            boolean z = this.pGi == 0;
            this.pGi += j;
            if (z) {
                this.pGd.post(this.pGk);
            }
            try {
                Thread.sleep(j);
                if (this.pGi != 0 && !this.pGj) {
                    if (!this.pGh && (Debug.isDebuggerConnected() || Debug.waitingForDebugger())) {
                        Log.w("ANRWatchdog", "An ANR was detected but ignored because the debugger is connected (you can prevent this with setIgnoreDebugger(true))");
                        this.pGj = true;
                    } else {
                        j = this.pGb.iN(this.pGi);
                        if (j <= 0) {
                            if (this.pGf != null) {
                                NewMainOnly = ANRError.New(this.pGi, this.pGf, this.pGg);
                            } else {
                                NewMainOnly = ANRError.NewMainOnly(this.pGi);
                            }
                            this.pGa.onAppNotResponding(NewMainOnly);
                            j = this.pGe;
                            this.pGj = true;
                        }
                    }
                }
            } catch (InterruptedException e) {
                this.pGc.a(e);
                return;
            }
        }
    }
}
