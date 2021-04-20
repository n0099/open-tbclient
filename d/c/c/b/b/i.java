package d.c.c.b.b;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.bytedance.sdk.adnet.core.Request;
import d.c.c.b.d.o;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* loaded from: classes5.dex */
public class i<T> implements o.a<T>, Future<o<T>> {

    /* renamed from: e  reason: collision with root package name */
    public Request<?> f66490e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f66491f = false;

    /* renamed from: g  reason: collision with root package name */
    public o<T> f66492g;

    public static <E> i<E> c() {
        return new i<>();
    }

    @Override // d.c.c.b.d.o.a
    public synchronized void a(o<T> oVar) {
        this.f66491f = true;
        this.f66492g = oVar;
        notifyAll();
    }

    @Override // d.c.c.b.d.o.a
    public synchronized void b(o<T> oVar) {
        this.f66491f = true;
        this.f66492g = oVar;
        notifyAll();
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean cancel(boolean z) {
        if (this.f66490e == null) {
            return false;
        }
        if (isDone()) {
            return false;
        }
        this.f66490e.cancel();
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.concurrent.Future
    /* renamed from: d */
    public o<T> get(long j, @NonNull TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        return e(Long.valueOf(TimeUnit.MILLISECONDS.convert(j, timeUnit)));
    }

    public final synchronized o<T> e(Long l) throws InterruptedException, TimeoutException {
        if (this.f66491f) {
            return this.f66492g;
        }
        if (l == null) {
            while (!isDone()) {
                wait(0L);
            }
        } else if (l.longValue() > 0) {
            long uptimeMillis = SystemClock.uptimeMillis();
            long longValue = l.longValue() + uptimeMillis;
            while (!isDone() && uptimeMillis < longValue) {
                wait(longValue - uptimeMillis);
                uptimeMillis = SystemClock.uptimeMillis();
            }
        }
        if (this.f66491f) {
            return this.f66492g;
        }
        throw new TimeoutException();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.concurrent.Future
    /* renamed from: f */
    public o<T> get() throws InterruptedException {
        try {
            return e(null);
        } catch (TimeoutException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        Request<?> request = this.f66490e;
        if (request == null) {
            return false;
        }
        return request.isCanceled();
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isDone() {
        boolean z;
        if (!this.f66491f) {
            z = isCancelled();
        }
        return z;
    }
}
