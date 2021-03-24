package d.b.j0.b.e;

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
    public boolean f63828f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f63829g = false;

    /* renamed from: h  reason: collision with root package name */
    public long f63830h = -1;

    /* renamed from: e  reason: collision with root package name */
    public final BlockingQueue<Runnable> f63827e = new LinkedBlockingQueue();

    public g(String str) {
        this.i = str;
    }

    public void a() throws IOException {
        b(0);
    }

    public void b(int i) throws IOException {
        long nanoTime = System.nanoTime();
        long convert = TimeUnit.NANOSECONDS.convert(i, TimeUnit.MILLISECONDS);
        if (!this.f63829g) {
            if (!this.f63828f) {
                this.f63828f = true;
                while (this.f63828f) {
                    if (i == 0) {
                        try {
                            c(false, 0L).run();
                        } catch (InterruptedIOException | RuntimeException e2) {
                            this.f63828f = false;
                            this.f63829g = true;
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
                poll = this.f63827e.take();
            } else {
                poll = this.f63827e.poll(j, TimeUnit.NANOSECONDS);
            }
            if (poll != null) {
                return poll;
            }
            d.b.j0.a.a.c("cr_CronetHttpURLConn", "****** Messageloop timeout exception, url is: %s", this.i);
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
                this.f63827e.put(runnable);
                return;
            } catch (InterruptedException e2) {
                throw new RejectedExecutionException(e2);
            }
        }
        throw new IllegalArgumentException();
    }

    public void quit() {
        this.f63828f = false;
    }
}
