package com.google.android.exoplayer2.upstream;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.exoplayer2.util.t;
import com.google.android.exoplayer2.util.v;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
/* loaded from: classes6.dex */
public final class Loader implements o {
    private final ExecutorService mGS;
    private b<? extends c> mGT;
    private IOException muL;

    /* loaded from: classes6.dex */
    public interface a<T extends c> {
        int a(T t, long j, long j2, IOException iOException);

        void a(T t, long j, long j2);

        void a(T t, long j, long j2, boolean z);
    }

    /* loaded from: classes6.dex */
    public interface c {
        void cancelLoad();

        boolean dwu();

        void load() throws IOException, InterruptedException;
    }

    /* loaded from: classes6.dex */
    public interface d {
        void dwo();
    }

    /* loaded from: classes6.dex */
    public static final class UnexpectedLoaderException extends IOException {
        public UnexpectedLoaderException(Throwable th) {
            super("Unexpected " + th.getClass().getSimpleName() + ": " + th.getMessage(), th);
        }
    }

    public Loader(String str) {
        this.mGS = v.Qz(str);
    }

    public <T extends c> long a(T t, a<T> aVar, int i) {
        Looper myLooper = Looper.myLooper();
        com.google.android.exoplayer2.util.a.checkState(myLooper != null);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        new b(myLooper, t, aVar, i, elapsedRealtime).start(0L);
        return elapsedRealtime;
    }

    public boolean isLoading() {
        return this.mGT != null;
    }

    public void cNB() {
        this.mGT.vU(false);
    }

    public void release() {
        a((d) null);
    }

    public boolean a(d dVar) {
        boolean z = false;
        if (this.mGT != null) {
            this.mGT.vU(true);
            if (dVar != null) {
                this.mGS.execute(new e(dVar));
            }
        } else if (dVar != null) {
            dVar.dwo();
            z = true;
        }
        this.mGS.shutdown();
        return z;
    }

    @Override // com.google.android.exoplayer2.upstream.o
    public void dwm() throws IOException {
        LS(Integer.MIN_VALUE);
    }

    public void LS(int i) throws IOException {
        if (this.muL != null) {
            throw this.muL;
        }
        if (this.mGT != null) {
            b<? extends c> bVar = this.mGT;
            if (i == Integer.MIN_VALUE) {
                i = this.mGT.mGW;
            }
            bVar.LS(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes6.dex */
    public final class b<T extends c> extends Handler implements Runnable {
        private int errorCount;
        private final long lbU;
        private final T mGU;
        private final a<T> mGV;
        public final int mGW;
        private IOException mGX;
        private volatile Thread mGY;
        private volatile boolean released;

        public b(Looper looper, T t, a<T> aVar, int i, long j) {
            super(looper);
            this.mGU = t;
            this.mGV = aVar;
            this.mGW = i;
            this.lbU = j;
        }

        public void LS(int i) throws IOException {
            if (this.mGX != null && this.errorCount > i) {
                throw this.mGX;
            }
        }

        public void start(long j) {
            com.google.android.exoplayer2.util.a.checkState(Loader.this.mGT == null);
            Loader.this.mGT = this;
            if (j > 0) {
                sendEmptyMessageDelayed(0, j);
            } else {
                execute();
            }
        }

        public void vU(boolean z) {
            this.released = z;
            this.mGX = null;
            if (hasMessages(0)) {
                removeMessages(0);
                if (!z) {
                    sendEmptyMessage(1);
                }
            } else {
                this.mGU.cancelLoad();
                if (this.mGY != null) {
                    this.mGY.interrupt();
                }
            }
            if (z) {
                finish();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                this.mGV.a((a<T>) this.mGU, elapsedRealtime, elapsedRealtime - this.lbU, true);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.mGY = Thread.currentThread();
                if (!this.mGU.dwu()) {
                    t.beginSection("load:" + this.mGU.getClass().getSimpleName());
                    try {
                        this.mGU.load();
                    } finally {
                        t.endSection();
                    }
                }
                if (!this.released) {
                    sendEmptyMessage(2);
                }
            } catch (IOException e) {
                if (!this.released) {
                    obtainMessage(3, e).sendToTarget();
                }
            } catch (Error e2) {
                Log.e("LoadTask", "Unexpected error loading stream", e2);
                if (!this.released) {
                    obtainMessage(4, e2).sendToTarget();
                }
                throw e2;
            } catch (InterruptedException e3) {
                com.google.android.exoplayer2.util.a.checkState(this.mGU.dwu());
                if (!this.released) {
                    sendEmptyMessage(2);
                }
            } catch (Exception e4) {
                Log.e("LoadTask", "Unexpected exception loading stream", e4);
                if (!this.released) {
                    obtainMessage(3, new UnexpectedLoaderException(e4)).sendToTarget();
                }
            } catch (OutOfMemoryError e5) {
                Log.e("LoadTask", "OutOfMemory error loading stream", e5);
                if (!this.released) {
                    obtainMessage(3, new UnexpectedLoaderException(e5)).sendToTarget();
                }
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (!this.released) {
                if (message.what == 0) {
                    execute();
                } else if (message.what == 4) {
                    throw ((Error) message.obj);
                } else {
                    finish();
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    long j = elapsedRealtime - this.lbU;
                    if (this.mGU.dwu()) {
                        this.mGV.a((a<T>) this.mGU, elapsedRealtime, j, false);
                        return;
                    }
                    switch (message.what) {
                        case 1:
                            this.mGV.a((a<T>) this.mGU, elapsedRealtime, j, false);
                            return;
                        case 2:
                            try {
                                this.mGV.a(this.mGU, elapsedRealtime, j);
                                return;
                            } catch (RuntimeException e) {
                                Log.e("LoadTask", "Unexpected exception handling load completed", e);
                                Loader.this.muL = new UnexpectedLoaderException(e);
                                return;
                            }
                        case 3:
                            this.mGX = (IOException) message.obj;
                            int a = this.mGV.a((a<T>) this.mGU, elapsedRealtime, j, this.mGX);
                            if (a == 3) {
                                Loader.this.muL = this.mGX;
                                return;
                            } else if (a != 2) {
                                this.errorCount = a == 1 ? 1 : this.errorCount + 1;
                                start(dzl());
                                return;
                            } else {
                                return;
                            }
                        default:
                            return;
                    }
                }
            }
        }

        private void execute() {
            this.mGX = null;
            Loader.this.mGS.execute(Loader.this.mGT);
        }

        private void finish() {
            Loader.this.mGT = null;
        }

        private long dzl() {
            return Math.min((this.errorCount - 1) * 1000, 5000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class e extends Handler implements Runnable {
        private final d mHa;

        public e(d dVar) {
            this.mHa = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (getLooper().getThread().isAlive()) {
                sendEmptyMessage(0);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            this.mHa.dwo();
        }
    }
}
