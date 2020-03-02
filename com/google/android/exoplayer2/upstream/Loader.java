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
    private final ExecutorService mGH;
    private b<? extends c> mGI;
    private IOException muA;

    /* loaded from: classes6.dex */
    public interface a<T extends c> {
        int a(T t, long j, long j2, IOException iOException);

        void a(T t, long j, long j2);

        void a(T t, long j, long j2, boolean z);
    }

    /* loaded from: classes6.dex */
    public interface c {
        void cancelLoad();

        boolean dwt();

        void load() throws IOException, InterruptedException;
    }

    /* loaded from: classes6.dex */
    public interface d {
        void dwn();
    }

    /* loaded from: classes6.dex */
    public static final class UnexpectedLoaderException extends IOException {
        public UnexpectedLoaderException(Throwable th) {
            super("Unexpected " + th.getClass().getSimpleName() + ": " + th.getMessage(), th);
        }
    }

    public Loader(String str) {
        this.mGH = v.Qy(str);
    }

    public <T extends c> long a(T t, a<T> aVar, int i) {
        Looper myLooper = Looper.myLooper();
        com.google.android.exoplayer2.util.a.checkState(myLooper != null);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        new b(myLooper, t, aVar, i, elapsedRealtime).start(0L);
        return elapsedRealtime;
    }

    public boolean isLoading() {
        return this.mGI != null;
    }

    public void cNA() {
        this.mGI.vU(false);
    }

    public void release() {
        a((d) null);
    }

    public boolean a(d dVar) {
        boolean z = false;
        if (this.mGI != null) {
            this.mGI.vU(true);
            if (dVar != null) {
                this.mGH.execute(new e(dVar));
            }
        } else if (dVar != null) {
            dVar.dwn();
            z = true;
        }
        this.mGH.shutdown();
        return z;
    }

    @Override // com.google.android.exoplayer2.upstream.o
    public void dwl() throws IOException {
        LS(Integer.MIN_VALUE);
    }

    public void LS(int i) throws IOException {
        if (this.muA != null) {
            throw this.muA;
        }
        if (this.mGI != null) {
            b<? extends c> bVar = this.mGI;
            if (i == Integer.MIN_VALUE) {
                i = this.mGI.mGL;
            }
            bVar.LS(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes6.dex */
    public final class b<T extends c> extends Handler implements Runnable {
        private int errorCount;
        private final long lbI;
        private final T mGJ;
        private final a<T> mGK;
        public final int mGL;
        private IOException mGM;
        private volatile Thread mGN;
        private volatile boolean released;

        public b(Looper looper, T t, a<T> aVar, int i, long j) {
            super(looper);
            this.mGJ = t;
            this.mGK = aVar;
            this.mGL = i;
            this.lbI = j;
        }

        public void LS(int i) throws IOException {
            if (this.mGM != null && this.errorCount > i) {
                throw this.mGM;
            }
        }

        public void start(long j) {
            com.google.android.exoplayer2.util.a.checkState(Loader.this.mGI == null);
            Loader.this.mGI = this;
            if (j > 0) {
                sendEmptyMessageDelayed(0, j);
            } else {
                execute();
            }
        }

        public void vU(boolean z) {
            this.released = z;
            this.mGM = null;
            if (hasMessages(0)) {
                removeMessages(0);
                if (!z) {
                    sendEmptyMessage(1);
                }
            } else {
                this.mGJ.cancelLoad();
                if (this.mGN != null) {
                    this.mGN.interrupt();
                }
            }
            if (z) {
                finish();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                this.mGK.a((a<T>) this.mGJ, elapsedRealtime, elapsedRealtime - this.lbI, true);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.mGN = Thread.currentThread();
                if (!this.mGJ.dwt()) {
                    t.beginSection("load:" + this.mGJ.getClass().getSimpleName());
                    try {
                        this.mGJ.load();
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
                com.google.android.exoplayer2.util.a.checkState(this.mGJ.dwt());
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
                    long j = elapsedRealtime - this.lbI;
                    if (this.mGJ.dwt()) {
                        this.mGK.a((a<T>) this.mGJ, elapsedRealtime, j, false);
                        return;
                    }
                    switch (message.what) {
                        case 1:
                            this.mGK.a((a<T>) this.mGJ, elapsedRealtime, j, false);
                            return;
                        case 2:
                            try {
                                this.mGK.a(this.mGJ, elapsedRealtime, j);
                                return;
                            } catch (RuntimeException e) {
                                Log.e("LoadTask", "Unexpected exception handling load completed", e);
                                Loader.this.muA = new UnexpectedLoaderException(e);
                                return;
                            }
                        case 3:
                            this.mGM = (IOException) message.obj;
                            int a = this.mGK.a((a<T>) this.mGJ, elapsedRealtime, j, this.mGM);
                            if (a == 3) {
                                Loader.this.muA = this.mGM;
                                return;
                            } else if (a != 2) {
                                this.errorCount = a == 1 ? 1 : this.errorCount + 1;
                                start(dzk());
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
            this.mGM = null;
            Loader.this.mGH.execute(Loader.this.mGI);
        }

        private void finish() {
            Loader.this.mGI = null;
        }

        private long dzk() {
            return Math.min((this.errorCount - 1) * 1000, 5000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class e extends Handler implements Runnable {
        private final d mGP;

        public e(d dVar) {
            this.mGP = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (getLooper().getThread().isAlive()) {
                sendEmptyMessage(0);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            this.mGP.dwn();
        }
    }
}
