package com.github.anrwatchdog;

import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
/* loaded from: classes19.dex */
public class a extends Thread {
    private static final b prN = new b() { // from class: com.github.anrwatchdog.a.1
        @Override // com.github.anrwatchdog.a.b
        public void onAppNotResponding(ANRError aNRError) {
            throw aNRError;
        }
    };
    private static final InterfaceC1002a prO = new InterfaceC1002a() { // from class: com.github.anrwatchdog.a.2
        @Override // com.github.anrwatchdog.a.InterfaceC1002a
        public long iz(long j) {
            return 0L;
        }
    };
    private static final c prP = new c() { // from class: com.github.anrwatchdog.a.3
        @Override // com.github.anrwatchdog.a.c
        public void a(InterruptedException interruptedException) {
            Log.w("ANRWatchdog", "Interrupted: " + interruptedException.getMessage());
        }
    };
    private b prQ;
    private InterfaceC1002a prR;
    private c prS;
    private final Handler prT;
    private final int prU;
    private String prV;
    private boolean prW;
    private boolean prX;
    private volatile long prY;
    private volatile boolean prZ;
    private final Runnable psa;

    /* renamed from: com.github.anrwatchdog.a$a  reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public interface InterfaceC1002a {
        long iz(long j);
    }

    /* loaded from: classes19.dex */
    public interface b {
        void onAppNotResponding(ANRError aNRError);
    }

    /* loaded from: classes19.dex */
    public interface c {
        void a(InterruptedException interruptedException);
    }

    public a() {
        this(5000);
    }

    public a(int i) {
        this.prQ = prN;
        this.prR = prO;
        this.prS = prP;
        this.prT = new Handler(Looper.getMainLooper());
        this.prV = "";
        this.prW = false;
        this.prX = true;
        this.prY = 0L;
        this.prZ = false;
        this.psa = new Runnable() { // from class: com.github.anrwatchdog.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.this.prY = 0L;
                a.this.prZ = false;
            }
        };
        this.prU = i;
    }

    public a a(b bVar) {
        if (bVar == null) {
            this.prQ = prN;
        } else {
            this.prQ = bVar;
        }
        return this;
    }

    public a exE() {
        this.prV = null;
        return this;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        ANRError NewMainOnly;
        setName("|ANR-WatchDog|");
        long j = this.prU;
        while (!isInterrupted()) {
            boolean z = this.prY == 0;
            this.prY += j;
            if (z) {
                this.prT.post(this.psa);
            }
            try {
                Thread.sleep(j);
                if (this.prY != 0 && !this.prZ) {
                    if (!this.prX && (Debug.isDebuggerConnected() || Debug.waitingForDebugger())) {
                        Log.w("ANRWatchdog", "An ANR was detected but ignored because the debugger is connected (you can prevent this with setIgnoreDebugger(true))");
                        this.prZ = true;
                    } else {
                        j = this.prR.iz(this.prY);
                        if (j <= 0) {
                            if (this.prV != null) {
                                NewMainOnly = ANRError.New(this.prY, this.prV, this.prW);
                            } else {
                                NewMainOnly = ANRError.NewMainOnly(this.prY);
                            }
                            this.prQ.onAppNotResponding(NewMainOnly);
                            j = this.prU;
                            this.prZ = true;
                        }
                    }
                }
            } catch (InterruptedException e) {
                this.prS.a(e);
                return;
            }
        }
    }
}
