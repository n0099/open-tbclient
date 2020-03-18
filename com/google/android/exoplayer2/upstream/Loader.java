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
    private final ExecutorService mIB;
    private b<? extends c> mIC;
    private IOException mwr;

    /* loaded from: classes6.dex */
    public interface a<T extends c> {
        int a(T t, long j, long j2, IOException iOException);

        void a(T t, long j, long j2);

        void a(T t, long j, long j2, boolean z);
    }

    /* loaded from: classes6.dex */
    public interface c {
        void cancelLoad();

        boolean dwR();

        void load() throws IOException, InterruptedException;
    }

    /* loaded from: classes6.dex */
    public interface d {
        void dwL();
    }

    /* loaded from: classes6.dex */
    public static final class UnexpectedLoaderException extends IOException {
        public UnexpectedLoaderException(Throwable th) {
            super("Unexpected " + th.getClass().getSimpleName() + ": " + th.getMessage(), th);
        }
    }

    public Loader(String str) {
        this.mIB = v.Qy(str);
    }

    public <T extends c> long a(T t, a<T> aVar, int i) {
        Looper myLooper = Looper.myLooper();
        com.google.android.exoplayer2.util.a.checkState(myLooper != null);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        new b(myLooper, t, aVar, i, elapsedRealtime).start(0L);
        return elapsedRealtime;
    }

    public boolean isLoading() {
        return this.mIC != null;
    }

    public void cNV() {
        this.mIC.wb(false);
    }

    public void release() {
        a((d) null);
    }

    public boolean a(d dVar) {
        boolean z = false;
        if (this.mIC != null) {
            this.mIC.wb(true);
            if (dVar != null) {
                this.mIB.execute(new e(dVar));
            }
        } else if (dVar != null) {
            dVar.dwL();
            z = true;
        }
        this.mIB.shutdown();
        return z;
    }

    @Override // com.google.android.exoplayer2.upstream.o
    public void dwJ() throws IOException {
        LY(Integer.MIN_VALUE);
    }

    public void LY(int i) throws IOException {
        if (this.mwr != null) {
            throw this.mwr;
        }
        if (this.mIC != null) {
            b<? extends c> bVar = this.mIC;
            if (i == Integer.MIN_VALUE) {
                i = this.mIC.mIG;
            }
            bVar.LY(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes6.dex */
    public final class b<T extends c> extends Handler implements Runnable {
        private int errorCount;
        private final long ldz;
        private final T mIE;
        private final a<T> mIF;
        public final int mIG;
        private IOException mIH;
        private volatile Thread mII;
        private volatile boolean released;

        public b(Looper looper, T t, a<T> aVar, int i, long j) {
            super(looper);
            this.mIE = t;
            this.mIF = aVar;
            this.mIG = i;
            this.ldz = j;
        }

        public void LY(int i) throws IOException {
            if (this.mIH != null && this.errorCount > i) {
                throw this.mIH;
            }
        }

        public void start(long j) {
            com.google.android.exoplayer2.util.a.checkState(Loader.this.mIC == null);
            Loader.this.mIC = this;
            if (j > 0) {
                sendEmptyMessageDelayed(0, j);
            } else {
                execute();
            }
        }

        public void wb(boolean z) {
            this.released = z;
            this.mIH = null;
            if (hasMessages(0)) {
                removeMessages(0);
                if (!z) {
                    sendEmptyMessage(1);
                }
            } else {
                this.mIE.cancelLoad();
                if (this.mII != null) {
                    this.mII.interrupt();
                }
            }
            if (z) {
                finish();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                this.mIF.a((a<T>) this.mIE, elapsedRealtime, elapsedRealtime - this.ldz, true);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.mII = Thread.currentThread();
                if (!this.mIE.dwR()) {
                    t.beginSection("load:" + this.mIE.getClass().getSimpleName());
                    try {
                        this.mIE.load();
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
                com.google.android.exoplayer2.util.a.checkState(this.mIE.dwR());
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
                    long j = elapsedRealtime - this.ldz;
                    if (this.mIE.dwR()) {
                        this.mIF.a((a<T>) this.mIE, elapsedRealtime, j, false);
                        return;
                    }
                    switch (message.what) {
                        case 1:
                            this.mIF.a((a<T>) this.mIE, elapsedRealtime, j, false);
                            return;
                        case 2:
                            try {
                                this.mIF.a(this.mIE, elapsedRealtime, j);
                                return;
                            } catch (RuntimeException e) {
                                Log.e("LoadTask", "Unexpected exception handling load completed", e);
                                Loader.this.mwr = new UnexpectedLoaderException(e);
                                return;
                            }
                        case 3:
                            this.mIH = (IOException) message.obj;
                            int a = this.mIF.a((a<T>) this.mIE, elapsedRealtime, j, this.mIH);
                            if (a == 3) {
                                Loader.this.mwr = this.mIH;
                                return;
                            } else if (a != 2) {
                                this.errorCount = a == 1 ? 1 : this.errorCount + 1;
                                start(dzI());
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
            this.mIH = null;
            Loader.this.mIB.execute(Loader.this.mIC);
        }

        private void finish() {
            Loader.this.mIC = null;
        }

        private long dzI() {
            return Math.min((this.errorCount - 1) * 1000, 5000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class e extends Handler implements Runnable {
        private final d mIK;

        public e(d dVar) {
            this.mIK = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (getLooper().getThread().isAlive()) {
                sendEmptyMessage(0);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            this.mIK.dwL();
        }
    }
}
