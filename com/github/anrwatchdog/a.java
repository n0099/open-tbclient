package com.github.anrwatchdog;

import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
/* loaded from: classes6.dex */
public class a extends Thread {
    private static final b pFW = new b() { // from class: com.github.anrwatchdog.a.1
        @Override // com.github.anrwatchdog.a.b
        public void onAppNotResponding(ANRError aNRError) {
            throw aNRError;
        }
    };
    private static final InterfaceC1053a pFX = new InterfaceC1053a() { // from class: com.github.anrwatchdog.a.2
        @Override // com.github.anrwatchdog.a.InterfaceC1053a
        public long iN(long j) {
            return 0L;
        }
    };
    private static final c pFY = new c() { // from class: com.github.anrwatchdog.a.3
        @Override // com.github.anrwatchdog.a.c
        public void a(InterruptedException interruptedException) {
            Log.w("ANRWatchdog", "Interrupted: " + interruptedException.getMessage());
        }
    };
    private b pFZ;
    private InterfaceC1053a pGa;
    private c pGb;
    private final Handler pGc;
    private final int pGd;
    private String pGe;
    private boolean pGf;
    private boolean pGg;
    private volatile long pGh;
    private volatile boolean pGi;
    private final Runnable pGj;

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
        this.pFZ = pFW;
        this.pGa = pFX;
        this.pGb = pFY;
        this.pGc = new Handler(Looper.getMainLooper());
        this.pGe = "";
        this.pGf = false;
        this.pGg = true;
        this.pGh = 0L;
        this.pGi = false;
        this.pGj = new Runnable() { // from class: com.github.anrwatchdog.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.this.pGh = 0L;
                a.this.pGi = false;
            }
        };
        this.pGd = i;
    }

    public a a(b bVar) {
        if (bVar == null) {
            this.pFZ = pFW;
        } else {
            this.pFZ = bVar;
        }
        return this;
    }

    public a eyb() {
        this.pGe = null;
        return this;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        ANRError NewMainOnly;
        setName("|ANR-WatchDog|");
        long j = this.pGd;
        while (!isInterrupted()) {
            boolean z = this.pGh == 0;
            this.pGh += j;
            if (z) {
                this.pGc.post(this.pGj);
            }
            try {
                Thread.sleep(j);
                if (this.pGh != 0 && !this.pGi) {
                    if (!this.pGg && (Debug.isDebuggerConnected() || Debug.waitingForDebugger())) {
                        Log.w("ANRWatchdog", "An ANR was detected but ignored because the debugger is connected (you can prevent this with setIgnoreDebugger(true))");
                        this.pGi = true;
                    } else {
                        j = this.pGa.iN(this.pGh);
                        if (j <= 0) {
                            if (this.pGe != null) {
                                NewMainOnly = ANRError.New(this.pGh, this.pGe, this.pGf);
                            } else {
                                NewMainOnly = ANRError.NewMainOnly(this.pGh);
                            }
                            this.pFZ.onAppNotResponding(NewMainOnly);
                            j = this.pGd;
                            this.pGi = true;
                        }
                    }
                }
            } catch (InterruptedException e) {
                this.pGb.a(e);
                return;
            }
        }
    }
}
