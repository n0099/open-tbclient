package d.b.k0.b.e;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public class g implements Executor {
    public final String i;

    /* renamed from: f  reason: collision with root package name */
    public boolean f64829f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f64830g = false;

    /* renamed from: h  reason: collision with root package name */
    public long f64831h = -1;

    /* renamed from: e  reason: collision with root package name */
    public final BlockingQueue<Runnable> f64828e = new LinkedBlockingQueue();

    public g(String str) {
        this.i = str;
    }

    public void a() throws IOException {
        b(0);
    }

    public void b(int i) throws IOException {
        long nanoTime = System.nanoTime();
        long convert = TimeUnit.NANOSECONDS.convert(i, TimeUnit.MILLISECONDS);
        if (!this.f64830g) {
            if (!this.f64829f) {
                this.f64829f = true;
                while (this.f64829f) {
                    if (i == 0) {
                        try {
                            c(false, 0L).run();
                        } catch (InterruptedIOException | RuntimeException e2) {
                            this.f64829f = false;
                            this.f64830g = true;
                            throw e2;
                        }
                    } else {
                        c(true, (convert - System.nanoTime()) + nanoTime).run();
                    }
                }
                return;
            }
            throw new IllegalStateException("Cannot run loop when it is already running.");
        }
        throw new IllegalStateException("Cannot run loop as an exception has occurred previously.");
    }

    public final Runnable c(boolean z, long j) throws InterruptedIOException {
        Runnable poll;
        try {
            if (!z) {
                poll = this.f64828e.take();
            } else {
                poll = this.f64828e.poll(j, TimeUnit.NANOSECONDS);
            }
            if (poll != null) {
                return poll;
            }
            d.b.k0.a.a.c("cr_CronetHttpURLConn", "****** Messageloop timeout exception, url is: %s", this.i);
            throw new SocketTimeoutException();
        } catch (InterruptedException e2) {
            InterruptedIOException interruptedIOException = new InterruptedIOException();
            interruptedIOException.initCause(e2);
            throw interruptedIOException;
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) throws RejectedExecutionException {
        if (runnable != null) {
            try {
                this.f64828e.put(runnable);
                return;
            } catch (InterruptedException e2) {
                throw new RejectedExecutionException(e2);
            }
        }
        throw new IllegalArgumentException();
    }

    public void quit() {
        this.f64829f = false;
    }
}
