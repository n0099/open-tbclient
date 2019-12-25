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
/* loaded from: classes4.dex */
public final class Loader implements o {
    private final ExecutorService mCc;
    private b<? extends c> mCd;
    private IOException mpX;

    /* loaded from: classes4.dex */
    public interface a<T extends c> {
        int a(T t, long j, long j2, IOException iOException);

        void a(T t, long j, long j2);

        void a(T t, long j, long j2, boolean z);
    }

    /* loaded from: classes4.dex */
    public interface c {
        void cancelLoad();

        boolean dtU();

        void load() throws IOException, InterruptedException;
    }

    /* loaded from: classes4.dex */
    public interface d {
        void dtO();
    }

    /* loaded from: classes4.dex */
    public static final class UnexpectedLoaderException extends IOException {
        public UnexpectedLoaderException(Throwable th) {
            super("Unexpected " + th.getClass().getSimpleName() + ": " + th.getMessage(), th);
        }
    }

    public Loader(String str) {
        this.mCc = v.Qa(str);
    }

    public <T extends c> long a(T t, a<T> aVar, int i) {
        Looper myLooper = Looper.myLooper();
        com.google.android.exoplayer2.util.a.checkState(myLooper != null);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        new b(myLooper, t, aVar, i, elapsedRealtime).start(0L);
        return elapsedRealtime;
    }

    public boolean isLoading() {
        return this.mCd != null;
    }

    public void cKW() {
        this.mCd.vE(false);
    }

    public void release() {
        a((d) null);
    }

    public boolean a(d dVar) {
        boolean z = false;
        if (this.mCd != null) {
            this.mCd.vE(true);
            if (dVar != null) {
                this.mCc.execute(new e(dVar));
            }
        } else if (dVar != null) {
            dVar.dtO();
            z = true;
        }
        this.mCc.shutdown();
        return z;
    }

    @Override // com.google.android.exoplayer2.upstream.o
    public void dtM() throws IOException {
        LE(Integer.MIN_VALUE);
    }

    public void LE(int i) throws IOException {
        if (this.mpX != null) {
            throw this.mpX;
        }
        if (this.mCd != null) {
            b<? extends c> bVar = this.mCd;
            if (i == Integer.MIN_VALUE) {
                i = this.mCd.mCg;
            }
            bVar.LE(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes4.dex */
    public final class b<T extends c> extends Handler implements Runnable {
        private int errorCount;
        private final long kXv;
        private final T mCe;
        private final a<T> mCf;
        public final int mCg;
        private IOException mCh;
        private volatile Thread mCi;
        private volatile boolean released;

        public b(Looper looper, T t, a<T> aVar, int i, long j) {
            super(looper);
            this.mCe = t;
            this.mCf = aVar;
            this.mCg = i;
            this.kXv = j;
        }

        public void LE(int i) throws IOException {
            if (this.mCh != null && this.errorCount > i) {
                throw this.mCh;
            }
        }

        public void start(long j) {
            com.google.android.exoplayer2.util.a.checkState(Loader.this.mCd == null);
            Loader.this.mCd = this;
            if (j > 0) {
                sendEmptyMessageDelayed(0, j);
            } else {
                execute();
            }
        }

        public void vE(boolean z) {
            this.released = z;
            this.mCh = null;
            if (hasMessages(0)) {
                removeMessages(0);
                if (!z) {
                    sendEmptyMessage(1);
                }
            } else {
                this.mCe.cancelLoad();
                if (this.mCi != null) {
                    this.mCi.interrupt();
                }
            }
            if (z) {
                finish();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                this.mCf.a((a<T>) this.mCe, elapsedRealtime, elapsedRealtime - this.kXv, true);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.mCi = Thread.currentThread();
                if (!this.mCe.dtU()) {
                    t.beginSection("load:" + this.mCe.getClass().getSimpleName());
                    try {
                        this.mCe.load();
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
                com.google.android.exoplayer2.util.a.checkState(this.mCe.dtU());
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
                    long j = elapsedRealtime - this.kXv;
                    if (this.mCe.dtU()) {
                        this.mCf.a((a<T>) this.mCe, elapsedRealtime, j, false);
                        return;
                    }
                    switch (message.what) {
                        case 1:
                            this.mCf.a((a<T>) this.mCe, elapsedRealtime, j, false);
                            return;
                        case 2:
                            try {
                                this.mCf.a(this.mCe, elapsedRealtime, j);
                                return;
                            } catch (RuntimeException e) {
                                Log.e("LoadTask", "Unexpected exception handling load completed", e);
                                Loader.this.mpX = new UnexpectedLoaderException(e);
                                return;
                            }
                        case 3:
                            this.mCh = (IOException) message.obj;
                            int a = this.mCf.a((a<T>) this.mCe, elapsedRealtime, j, this.mCh);
                            if (a == 3) {
                                Loader.this.mpX = this.mCh;
                                return;
                            } else if (a != 2) {
                                this.errorCount = a == 1 ? 1 : this.errorCount + 1;
                                start(dwL());
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
            this.mCh = null;
            Loader.this.mCc.execute(Loader.this.mCd);
        }

        private void finish() {
            Loader.this.mCd = null;
        }

        private long dwL() {
            return Math.min((this.errorCount - 1) * 1000, 5000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class e extends Handler implements Runnable {
        private final d mCk;

        public e(d dVar) {
            this.mCk = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (getLooper().getThread().isAlive()) {
                sendEmptyMessage(0);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            this.mCk.dtO();
        }
    }
}
