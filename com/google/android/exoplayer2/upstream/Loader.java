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
    private final ExecutorService mFU;
    private b<? extends c> mFV;
    private IOException mtN;

    /* loaded from: classes5.dex */
    public interface a<T extends c> {
        int a(T t, long j, long j2, IOException iOException);

        void a(T t, long j, long j2);

        void a(T t, long j, long j2, boolean z);
    }

    /* loaded from: classes5.dex */
    public interface c {
        void cancelLoad();

        boolean dvf();

        void load() throws IOException, InterruptedException;
    }

    /* loaded from: classes5.dex */
    public interface d {
        void duZ();
    }

    /* loaded from: classes5.dex */
    public static final class UnexpectedLoaderException extends IOException {
        public UnexpectedLoaderException(Throwable th) {
            super("Unexpected " + th.getClass().getSimpleName() + ": " + th.getMessage(), th);
        }
    }

    public Loader(String str) {
        this.mFU = v.Ql(str);
    }

    public <T extends c> long a(T t, a<T> aVar, int i) {
        Looper myLooper = Looper.myLooper();
        com.google.android.exoplayer2.util.a.checkState(myLooper != null);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        new b(myLooper, t, aVar, i, elapsedRealtime).start(0L);
        return elapsedRealtime;
    }

    public boolean isLoading() {
        return this.mFV != null;
    }

    public void cMb() {
        this.mFV.vQ(false);
    }

    public void release() {
        a((d) null);
    }

    public boolean a(d dVar) {
        boolean z = false;
        if (this.mFV != null) {
            this.mFV.vQ(true);
            if (dVar != null) {
                this.mFU.execute(new e(dVar));
            }
        } else if (dVar != null) {
            dVar.duZ();
            z = true;
        }
        this.mFU.shutdown();
        return z;
    }

    @Override // com.google.android.exoplayer2.upstream.o
    public void duX() throws IOException {
        LN(Integer.MIN_VALUE);
    }

    public void LN(int i) throws IOException {
        if (this.mtN != null) {
            throw this.mtN;
        }
        if (this.mFV != null) {
            b<? extends c> bVar = this.mFV;
            if (i == Integer.MIN_VALUE) {
                i = this.mFV.mFY;
            }
            bVar.LN(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes5.dex */
    public final class b<T extends c> extends Handler implements Runnable {
        private int errorCount;
        private final long laV;
        private final T mFW;
        private final a<T> mFX;
        public final int mFY;
        private IOException mFZ;
        private volatile Thread mGa;
        private volatile boolean released;

        public b(Looper looper, T t, a<T> aVar, int i, long j) {
            super(looper);
            this.mFW = t;
            this.mFX = aVar;
            this.mFY = i;
            this.laV = j;
        }

        public void LN(int i) throws IOException {
            if (this.mFZ != null && this.errorCount > i) {
                throw this.mFZ;
            }
        }

        public void start(long j) {
            com.google.android.exoplayer2.util.a.checkState(Loader.this.mFV == null);
            Loader.this.mFV = this;
            if (j > 0) {
                sendEmptyMessageDelayed(0, j);
            } else {
                execute();
            }
        }

        public void vQ(boolean z) {
            this.released = z;
            this.mFZ = null;
            if (hasMessages(0)) {
                removeMessages(0);
                if (!z) {
                    sendEmptyMessage(1);
                }
            } else {
                this.mFW.cancelLoad();
                if (this.mGa != null) {
                    this.mGa.interrupt();
                }
            }
            if (z) {
                finish();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                this.mFX.a((a<T>) this.mFW, elapsedRealtime, elapsedRealtime - this.laV, true);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.mGa = Thread.currentThread();
                if (!this.mFW.dvf()) {
                    t.beginSection("load:" + this.mFW.getClass().getSimpleName());
                    try {
                        this.mFW.load();
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
                com.google.android.exoplayer2.util.a.checkState(this.mFW.dvf());
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
                    long j = elapsedRealtime - this.laV;
                    if (this.mFW.dvf()) {
                        this.mFX.a((a<T>) this.mFW, elapsedRealtime, j, false);
                        return;
                    }
                    switch (message.what) {
                        case 1:
                            this.mFX.a((a<T>) this.mFW, elapsedRealtime, j, false);
                            return;
                        case 2:
                            try {
                                this.mFX.a(this.mFW, elapsedRealtime, j);
                                return;
                            } catch (RuntimeException e) {
                                Log.e("LoadTask", "Unexpected exception handling load completed", e);
                                Loader.this.mtN = new UnexpectedLoaderException(e);
                                return;
                            }
                        case 3:
                            this.mFZ = (IOException) message.obj;
                            int a = this.mFX.a((a<T>) this.mFW, elapsedRealtime, j, this.mFZ);
                            if (a == 3) {
                                Loader.this.mtN = this.mFZ;
                                return;
                            } else if (a != 2) {
                                this.errorCount = a == 1 ? 1 : this.errorCount + 1;
                                start(dxW());
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
            this.mFZ = null;
            Loader.this.mFU.execute(Loader.this.mFV);
        }

        private void finish() {
            Loader.this.mFV = null;
        }

        private long dxW() {
            return Math.min((this.errorCount - 1) * 1000, 5000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class e extends Handler implements Runnable {
        private final d mGc;

        public e(d dVar) {
            this.mGc = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (getLooper().getThread().isAlive()) {
                sendEmptyMessage(0);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            this.mGc.duZ();
        }
    }
}
