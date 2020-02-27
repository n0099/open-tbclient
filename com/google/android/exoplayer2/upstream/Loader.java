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
    private final ExecutorService mGF;
    private b<? extends c> mGG;
    private IOException muy;

    /* loaded from: classes6.dex */
    public interface a<T extends c> {
        int a(T t, long j, long j2, IOException iOException);

        void a(T t, long j, long j2);

        void a(T t, long j, long j2, boolean z);
    }

    /* loaded from: classes6.dex */
    public interface c {
        void cancelLoad();

        boolean dwr();

        void load() throws IOException, InterruptedException;
    }

    /* loaded from: classes6.dex */
    public interface d {
        void dwl();
    }

    /* loaded from: classes6.dex */
    public static final class UnexpectedLoaderException extends IOException {
        public UnexpectedLoaderException(Throwable th) {
            super("Unexpected " + th.getClass().getSimpleName() + ": " + th.getMessage(), th);
        }
    }

    public Loader(String str) {
        this.mGF = v.Qy(str);
    }

    public <T extends c> long a(T t, a<T> aVar, int i) {
        Looper myLooper = Looper.myLooper();
        com.google.android.exoplayer2.util.a.checkState(myLooper != null);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        new b(myLooper, t, aVar, i, elapsedRealtime).start(0L);
        return elapsedRealtime;
    }

    public boolean isLoading() {
        return this.mGG != null;
    }

    public void cNy() {
        this.mGG.vU(false);
    }

    public void release() {
        a((d) null);
    }

    public boolean a(d dVar) {
        boolean z = false;
        if (this.mGG != null) {
            this.mGG.vU(true);
            if (dVar != null) {
                this.mGF.execute(new e(dVar));
            }
        } else if (dVar != null) {
            dVar.dwl();
            z = true;
        }
        this.mGF.shutdown();
        return z;
    }

    @Override // com.google.android.exoplayer2.upstream.o
    public void dwj() throws IOException {
        LS(Integer.MIN_VALUE);
    }

    public void LS(int i) throws IOException {
        if (this.muy != null) {
            throw this.muy;
        }
        if (this.mGG != null) {
            b<? extends c> bVar = this.mGG;
            if (i == Integer.MIN_VALUE) {
                i = this.mGG.mGJ;
            }
            bVar.LS(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes6.dex */
    public final class b<T extends c> extends Handler implements Runnable {
        private int errorCount;
        private final long lbG;
        private final T mGH;
        private final a<T> mGI;
        public final int mGJ;
        private IOException mGK;
        private volatile Thread mGL;
        private volatile boolean released;

        public b(Looper looper, T t, a<T> aVar, int i, long j) {
            super(looper);
            this.mGH = t;
            this.mGI = aVar;
            this.mGJ = i;
            this.lbG = j;
        }

        public void LS(int i) throws IOException {
            if (this.mGK != null && this.errorCount > i) {
                throw this.mGK;
            }
        }

        public void start(long j) {
            com.google.android.exoplayer2.util.a.checkState(Loader.this.mGG == null);
            Loader.this.mGG = this;
            if (j > 0) {
                sendEmptyMessageDelayed(0, j);
            } else {
                execute();
            }
        }

        public void vU(boolean z) {
            this.released = z;
            this.mGK = null;
            if (hasMessages(0)) {
                removeMessages(0);
                if (!z) {
                    sendEmptyMessage(1);
                }
            } else {
                this.mGH.cancelLoad();
                if (this.mGL != null) {
                    this.mGL.interrupt();
                }
            }
            if (z) {
                finish();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                this.mGI.a((a<T>) this.mGH, elapsedRealtime, elapsedRealtime - this.lbG, true);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.mGL = Thread.currentThread();
                if (!this.mGH.dwr()) {
                    t.beginSection("load:" + this.mGH.getClass().getSimpleName());
                    try {
                        this.mGH.load();
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
                com.google.android.exoplayer2.util.a.checkState(this.mGH.dwr());
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
                    long j = elapsedRealtime - this.lbG;
                    if (this.mGH.dwr()) {
                        this.mGI.a((a<T>) this.mGH, elapsedRealtime, j, false);
                        return;
                    }
                    switch (message.what) {
                        case 1:
                            this.mGI.a((a<T>) this.mGH, elapsedRealtime, j, false);
                            return;
                        case 2:
                            try {
                                this.mGI.a(this.mGH, elapsedRealtime, j);
                                return;
                            } catch (RuntimeException e) {
                                Log.e("LoadTask", "Unexpected exception handling load completed", e);
                                Loader.this.muy = new UnexpectedLoaderException(e);
                                return;
                            }
                        case 3:
                            this.mGK = (IOException) message.obj;
                            int a = this.mGI.a((a<T>) this.mGH, elapsedRealtime, j, this.mGK);
                            if (a == 3) {
                                Loader.this.muy = this.mGK;
                                return;
                            } else if (a != 2) {
                                this.errorCount = a == 1 ? 1 : this.errorCount + 1;
                                start(dzi());
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
            this.mGK = null;
            Loader.this.mGF.execute(Loader.this.mGG);
        }

        private void finish() {
            Loader.this.mGG = null;
        }

        private long dzi() {
            return Math.min((this.errorCount - 1) * 1000, 5000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class e extends Handler implements Runnable {
        private final d mGN;

        public e(d dVar) {
            this.mGN = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (getLooper().getThread().isAlive()) {
                sendEmptyMessage(0);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            this.mGN.dwl();
        }
    }
}
