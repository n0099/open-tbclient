package d.b.f0.k;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public class d implements ThreadFactory {

    /* renamed from: h  reason: collision with root package name */
    public static final AtomicInteger f43397h = new AtomicInteger(1);

    /* renamed from: e  reason: collision with root package name */
    public final AtomicInteger f43398e;

    /* renamed from: f  reason: collision with root package name */
    public String f43399f;

    /* renamed from: g  reason: collision with root package name */
    public int f43400g;

    public d() {
        this(5);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.f43399f + this.f43398e.getAndIncrement());
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        int i = this.f43400g;
        if (i != 5) {
            thread.setPriority(i);
        } else {
            thread.setPriority(5);
        }
        return thread;
    }

    public d(int i) {
        this.f43398e = new AtomicInteger(1);
        this.f43399f = "sso-" + f43397h.getAndIncrement() + "-thread-";
        this.f43400g = i;
    }
}
