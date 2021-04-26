package d.b.c.b.b;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.bytedance.sdk.adnet.core.Request;
import d.b.c.b.d.o;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* loaded from: classes5.dex */
public class i<T> implements o.a<T>, Future<o<T>> {

    /* renamed from: e  reason: collision with root package name */
    public Request<?> f64981e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f64982f = false;

    /* renamed from: g  reason: collision with root package name */
    public o<T> f64983g;

    public static <E> i<E> c() {
        return new i<>();
    }

    @Override // d.b.c.b.d.o.a
    public synchronized void a(o<T> oVar) {
        this.f64982f = true;
        this.f64983g = oVar;
        notifyAll();
    }

    @Override // d.b.c.b.d.o.a
    public synchronized void b(o<T> oVar) {
        this.f64982f = true;
        this.f64983g = oVar;
        notifyAll();
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean cancel(boolean z) {
        if (this.f64981e == null) {
            return false;
        }
        if (isDone()) {
            return false;
        }
        this.f64981e.cancel();
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.concurrent.Future
    /* renamed from: d */
    public o<T> get(long j, @NonNull TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        return e(Long.valueOf(TimeUnit.MILLISECONDS.convert(j, timeUnit)));
    }

    public final synchronized o<T> e(Long l) throws InterruptedException, TimeoutException {
        if (this.f64982f) {
            return this.f64983g;
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
        if (this.f64982f) {
            return this.f64983g;
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
        Request<?> request = this.f64981e;
        if (request == null) {
            return false;
        }
        return request.isCanceled();
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isDone() {
        boolean z;
        if (!this.f64982f) {
            z = isCancelled();
        }
        return z;
    }
}
