package com.github.anrwatchdog;

import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
/* loaded from: classes19.dex */
public class a extends Thread {
    private static final b prL = new b() { // from class: com.github.anrwatchdog.a.1
        @Override // com.github.anrwatchdog.a.b
        public void onAppNotResponding(ANRError aNRError) {
            throw aNRError;
        }
    };
    private static final InterfaceC1002a prM = new InterfaceC1002a() { // from class: com.github.anrwatchdog.a.2
        @Override // com.github.anrwatchdog.a.InterfaceC1002a
        public long iz(long j) {
            return 0L;
        }
    };
    private static final c prN = new c() { // from class: com.github.anrwatchdog.a.3
        @Override // com.github.anrwatchdog.a.c
        public void a(InterruptedException interruptedException) {
            Log.w("ANRWatchdog", "Interrupted: " + interruptedException.getMessage());
        }
    };
    private b prO;
    private InterfaceC1002a prP;
    private c prQ;
    private final Handler prR;
    private final int prS;
    private String prT;
    private boolean prU;
    private boolean prV;
    private volatile long prW;
    private volatile boolean prX;
    private final Runnable prY;

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
        this.prO = prL;
        this.prP = prM;
        this.prQ = prN;
        this.prR = new Handler(Looper.getMainLooper());
        this.prT = "";
        this.prU = false;
        this.prV = true;
        this.prW = 0L;
        this.prX = false;
        this.prY = new Runnable() { // from class: com.github.anrwatchdog.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.this.prW = 0L;
                a.this.prX = false;
            }
        };
        this.prS = i;
    }

    public a a(b bVar) {
        if (bVar == null) {
            this.prO = prL;
        } else {
            this.prO = bVar;
        }
        return this;
    }

    public a exD() {
        this.prT = null;
        return this;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        ANRError NewMainOnly;
        setName("|ANR-WatchDog|");
        long j = this.prS;
        while (!isInterrupted()) {
            boolean z = this.prW == 0;
            this.prW += j;
            if (z) {
                this.prR.post(this.prY);
            }
            try {
                Thread.sleep(j);
                if (this.prW != 0 && !this.prX) {
                    if (!this.prV && (Debug.isDebuggerConnected() || Debug.waitingForDebugger())) {
                        Log.w("ANRWatchdog", "An ANR was detected but ignored because the debugger is connected (you can prevent this with setIgnoreDebugger(true))");
                        this.prX = true;
                    } else {
                        j = this.prP.iz(this.prW);
                        if (j <= 0) {
                            if (this.prT != null) {
                                NewMainOnly = ANRError.New(this.prW, this.prT, this.prU);
                            } else {
                                NewMainOnly = ANRError.NewMainOnly(this.prW);
                            }
                            this.prO.onAppNotResponding(NewMainOnly);
                            j = this.prS;
                            this.prX = true;
                        }
                    }
                }
            } catch (InterruptedException e) {
                this.prQ.a(e);
                return;
            }
        }
    }
}
