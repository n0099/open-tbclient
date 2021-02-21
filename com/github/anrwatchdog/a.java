package com.github.anrwatchdog;

import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
/* loaded from: classes15.dex */
public class a extends Thread {
    private static final b pQC = new b() { // from class: com.github.anrwatchdog.a.1
        @Override // com.github.anrwatchdog.a.b
        public void onAppNotResponding(ANRError aNRError) {
            throw aNRError;
        }
    };
    private static final InterfaceC1059a pQD = new InterfaceC1059a() { // from class: com.github.anrwatchdog.a.2
        @Override // com.github.anrwatchdog.a.InterfaceC1059a
        public long iQ(long j) {
            return 0L;
        }
    };
    private static final c pQE = new c() { // from class: com.github.anrwatchdog.a.3
        @Override // com.github.anrwatchdog.a.c
        public void a(InterruptedException interruptedException) {
            Log.w("ANRWatchdog", "Interrupted: " + interruptedException.getMessage());
        }
    };
    private b pQF;
    private InterfaceC1059a pQG;
    private c pQH;
    private final Handler pQI;
    private final int pQJ;
    private String pQK;
    private boolean pQL;
    private boolean pQM;
    private volatile long pQN;
    private volatile boolean pQO;
    private final Runnable pQP;

    /* renamed from: com.github.anrwatchdog.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public interface InterfaceC1059a {
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
        this.pQF = pQC;
        this.pQG = pQD;
        this.pQH = pQE;
        this.pQI = new Handler(Looper.getMainLooper());
        this.pQK = "";
        this.pQL = false;
        this.pQM = true;
        this.pQN = 0L;
        this.pQO = false;
        this.pQP = new Runnable() { // from class: com.github.anrwatchdog.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.this.pQN = 0L;
                a.this.pQO = false;
            }
        };
        this.pQJ = i;
    }

    public a a(b bVar) {
        if (bVar == null) {
            this.pQF = pQC;
        } else {
            this.pQF = bVar;
        }
        return this;
    }

    public a eAB() {
        this.pQK = null;
        return this;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        ANRError NewMainOnly;
        setName("|ANR-WatchDog|");
        long j = this.pQJ;
        while (!isInterrupted()) {
            boolean z = this.pQN == 0;
            this.pQN += j;
            if (z) {
                this.pQI.post(this.pQP);
            }
            try {
                Thread.sleep(j);
                if (this.pQN != 0 && !this.pQO) {
                    if (!this.pQM && (Debug.isDebuggerConnected() || Debug.waitingForDebugger())) {
                        Log.w("ANRWatchdog", "An ANR was detected but ignored because the debugger is connected (you can prevent this with setIgnoreDebugger(true))");
                        this.pQO = true;
                    } else {
                        j = this.pQG.iQ(this.pQN);
                        if (j <= 0) {
                            if (this.pQK != null) {
                                NewMainOnly = ANRError.New(this.pQN, this.pQK, this.pQL);
                            } else {
                                NewMainOnly = ANRError.NewMainOnly(this.pQN);
                            }
                            this.pQF.onAppNotResponding(NewMainOnly);
                            j = this.pQJ;
                            this.pQO = true;
                        }
                    }
                }
            } catch (InterruptedException e) {
                this.pQH.a(e);
                return;
            }
        }
    }
}
