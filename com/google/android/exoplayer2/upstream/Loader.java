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
/* loaded from: classes5.dex */
public final class Loader implements o {
    private final ExecutorService mFZ;
    private b<? extends c> mGa;
    private IOException mtS;

    /* loaded from: classes5.dex */
    public interface a<T extends c> {
        int a(T t, long j, long j2, IOException iOException);

        void a(T t, long j, long j2);

        void a(T t, long j, long j2, boolean z);
    }

    /* loaded from: classes5.dex */
    public interface c {
        void cancelLoad();

        boolean dvh();

        void load() throws IOException, InterruptedException;
    }

    /* loaded from: classes5.dex */
    public interface d {
        void dvb();
    }

    /* loaded from: classes5.dex */
    public static final class UnexpectedLoaderException extends IOException {
        public UnexpectedLoaderException(Throwable th) {
            super("Unexpected " + th.getClass().getSimpleName() + ": " + th.getMessage(), th);
        }
    }

    public Loader(String str) {
        this.mFZ = v.Ql(str);
    }

    public <T extends c> long a(T t, a<T> aVar, int i) {
        Looper myLooper = Looper.myLooper();
        com.google.android.exoplayer2.util.a.checkState(myLooper != null);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        new b(myLooper, t, aVar, i, elapsedRealtime).start(0L);
        return elapsedRealtime;
    }

    public boolean isLoading() {
        return this.mGa != null;
    }

    public void cMd() {
        this.mGa.vQ(false);
    }

    public void release() {
        a((d) null);
    }

    public boolean a(d dVar) {
        boolean z = false;
        if (this.mGa != null) {
            this.mGa.vQ(true);
            if (dVar != null) {
                this.mFZ.execute(new e(dVar));
            }
        } else if (dVar != null) {
            dVar.dvb();
            z = true;
        }
        this.mFZ.shutdown();
        return z;
    }

    @Override // com.google.android.exoplayer2.upstream.o
    public void duZ() throws IOException {
        LN(Integer.MIN_VALUE);
    }

    public void LN(int i) throws IOException {
        if (this.mtS != null) {
            throw this.mtS;
        }
        if (this.mGa != null) {
            b<? extends c> bVar = this.mGa;
            if (i == Integer.MIN_VALUE) {
                i = this.mGa.mGd;
            }
            bVar.LN(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes5.dex */
    public final class b<T extends c> extends Handler implements Runnable {
        private int errorCount;
        private final long lba;
        private final T mGb;
        private final a<T> mGc;
        public final int mGd;
        private IOException mGe;
        private volatile Thread mGf;
        private volatile boolean released;

        public b(Looper looper, T t, a<T> aVar, int i, long j) {
            super(looper);
            this.mGb = t;
            this.mGc = aVar;
            this.mGd = i;
            this.lba = j;
        }

        public void LN(int i) throws IOException {
            if (this.mGe != null && this.errorCount > i) {
                throw this.mGe;
            }
        }

        public void start(long j) {
            com.google.android.exoplayer2.util.a.checkState(Loader.this.mGa == null);
            Loader.this.mGa = this;
            if (j > 0) {
                sendEmptyMessageDelayed(0, j);
            } else {
                execute();
            }
        }

        public void vQ(boolean z) {
            this.released = z;
            this.mGe = null;
            if (hasMessages(0)) {
                removeMessages(0);
                if (!z) {
                    sendEmptyMessage(1);
                }
            } else {
                this.mGb.cancelLoad();
                if (this.mGf != null) {
                    this.mGf.interrupt();
                }
            }
            if (z) {
                finish();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                this.mGc.a((a<T>) this.mGb, elapsedRealtime, elapsedRealtime - this.lba, true);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.mGf = Thread.currentThread();
                if (!this.mGb.dvh()) {
                    t.beginSection("load:" + this.mGb.getClass().getSimpleName());
                    try {
                        this.mGb.load();
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
                com.google.android.exoplayer2.util.a.checkState(this.mGb.dvh());
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
                    long j = elapsedRealtime - this.lba;
                    if (this.mGb.dvh()) {
                        this.mGc.a((a<T>) this.mGb, elapsedRealtime, j, false);
                        return;
                    }
                    switch (message.what) {
                        case 1:
                            this.mGc.a((a<T>) this.mGb, elapsedRealtime, j, false);
                            return;
                        case 2:
                            try {
                                this.mGc.a(this.mGb, elapsedRealtime, j);
                                return;
                            } catch (RuntimeException e) {
                                Log.e("LoadTask", "Unexpected exception handling load completed", e);
                                Loader.this.mtS = new UnexpectedLoaderException(e);
                                return;
                            }
                        case 3:
                            this.mGe = (IOException) message.obj;
                            int a = this.mGc.a((a<T>) this.mGb, elapsedRealtime, j, this.mGe);
                            if (a == 3) {
                                Loader.this.mtS = this.mGe;
                                return;
                            } else if (a != 2) {
                                this.errorCount = a == 1 ? 1 : this.errorCount + 1;
                                start(dxY());
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
            this.mGe = null;
            Loader.this.mFZ.execute(Loader.this.mGa);
        }

        private void finish() {
            Loader.this.mGa = null;
        }

        private long dxY() {
            return Math.min((this.errorCount - 1) * 1000, 5000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class e extends Handler implements Runnable {
        private final d mGh;

        public e(d dVar) {
            this.mGh = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (getLooper().getThread().isAlive()) {
                sendEmptyMessage(0);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            this.mGh.dvb();
        }
    }
}
