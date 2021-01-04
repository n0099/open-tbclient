package com.github.anrwatchdog;

import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
/* loaded from: classes5.dex */
public class a extends Thread {
    private static final b pIP = new b() { // from class: com.github.anrwatchdog.a.1
        @Override // com.github.anrwatchdog.a.b
        public void onAppNotResponding(ANRError aNRError) {
            throw aNRError;
        }
    };
    private static final InterfaceC1029a pIQ = new InterfaceC1029a() { // from class: com.github.anrwatchdog.a.2
        @Override // com.github.anrwatchdog.a.InterfaceC1029a
        public long iK(long j) {
            return 0L;
        }
    };
    private static final c pIR = new c() { // from class: com.github.anrwatchdog.a.3
        @Override // com.github.anrwatchdog.a.c
        public void a(InterruptedException interruptedException) {
            Log.w("ANRWatchdog", "Interrupted: " + interruptedException.getMessage());
        }
    };
    private b pIS;
    private InterfaceC1029a pIT;
    private c pIU;
    private final Handler pIV;
    private final int pIW;
    private String pIX;
    private boolean pIY;
    private boolean pIZ;
    private volatile long pJa;
    private volatile boolean pJb;
    private final Runnable pJc;

    /* renamed from: com.github.anrwatchdog.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC1029a {
        long iK(long j);
    }

    /* loaded from: classes5.dex */
    public interface b {
        void onAppNotResponding(ANRError aNRError);
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a(InterruptedException interruptedException);
    }

    public a() {
        this(5000);
    }

    public a(int i) {
        this.pIS = pIP;
        this.pIT = pIQ;
        this.pIU = pIR;
        this.pIV = new Handler(Looper.getMainLooper());
        this.pIX = "";
        this.pIY = false;
        this.pIZ = true;
        this.pJa = 0L;
        this.pJb = false;
        this.pJc = new Runnable() { // from class: com.github.anrwatchdog.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.this.pJa = 0L;
                a.this.pJb = false;
            }
        };
        this.pIW = i;
    }

    public a a(b bVar) {
        if (bVar == null) {
            this.pIS = pIP;
        } else {
            this.pIS = bVar;
        }
        return this;
    }

    public a eBp() {
        this.pIX = null;
        return this;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        ANRError NewMainOnly;
        setName("|ANR-WatchDog|");
        long j = this.pIW;
        while (!isInterrupted()) {
            boolean z = this.pJa == 0;
            this.pJa += j;
            if (z) {
                this.pIV.post(this.pJc);
            }
            try {
                Thread.sleep(j);
                if (this.pJa != 0 && !this.pJb) {
                    if (!this.pIZ && (Debug.isDebuggerConnected() || Debug.waitingForDebugger())) {
                        Log.w("ANRWatchdog", "An ANR was detected but ignored because the debugger is connected (you can prevent this with setIgnoreDebugger(true))");
                        this.pJb = true;
                    } else {
                        j = this.pIT.iK(this.pJa);
                        if (j <= 0) {
                            if (this.pIX != null) {
                                NewMainOnly = ANRError.New(this.pJa, this.pIX, this.pIY);
                            } else {
                                NewMainOnly = ANRError.NewMainOnly(this.pJa);
                            }
                            this.pIS.onAppNotResponding(NewMainOnly);
                            j = this.pIW;
                            this.pJb = true;
                        }
                    }
                }
            } catch (InterruptedException e) {
                this.pIU.a(e);
                return;
            }
        }
    }
}
