package d.a.o0.b.e;

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

    /* renamed from: i  reason: collision with root package name */
    public final String f67601i;

    /* renamed from: f  reason: collision with root package name */
    public boolean f67598f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f67599g = false;

    /* renamed from: h  reason: collision with root package name */
    public long f67600h = -1;

    /* renamed from: e  reason: collision with root package name */
    public final BlockingQueue<Runnable> f67597e = new LinkedBlockingQueue();

    public g(String str) {
        this.f67601i = str;
    }

    public void a() throws IOException {
        b(0);
    }

    public void b(int i2) throws IOException {
        long nanoTime = System.nanoTime();
        long convert = TimeUnit.NANOSECONDS.convert(i2, TimeUnit.MILLISECONDS);
        if (!this.f67599g) {
            if (!this.f67598f) {
                this.f67598f = true;
                while (this.f67598f) {
                    if (i2 == 0) {
                        try {
                            c(false, 0L).run();
                        } catch (InterruptedIOException | RuntimeException e2) {
                            this.f67598f = false;
                            this.f67599g = true;
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
                poll = this.f67597e.take();
            } else {
                poll = this.f67597e.poll(j, TimeUnit.NANOSECONDS);
            }
            if (poll != null) {
                return poll;
            }
            d.a.o0.a.a.c("cr_CronetHttpURLConn", "****** Messageloop timeout exception, url is: %s", this.f67601i);
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
                this.f67597e.put(runnable);
                return;
            } catch (InterruptedException e2) {
                throw new RejectedExecutionException(e2);
            }
        }
        throw new IllegalArgumentException();
    }

    public void quit() {
        this.f67598f = false;
    }
}
