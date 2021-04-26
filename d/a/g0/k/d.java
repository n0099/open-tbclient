package d.a.g0.k;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public class d implements ThreadFactory {

    /* renamed from: h  reason: collision with root package name */
    public static final AtomicInteger f40951h = new AtomicInteger(1);

    /* renamed from: e  reason: collision with root package name */
    public final AtomicInteger f40952e;

    /* renamed from: f  reason: collision with root package name */
    public String f40953f;

    /* renamed from: g  reason: collision with root package name */
    public int f40954g;

    public d() {
        this(5);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.f40953f + this.f40952e.getAndIncrement());
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        int i2 = this.f40954g;
        if (i2 != 5) {
            thread.setPriority(i2);
        } else {
            thread.setPriority(5);
        }
        return thread;
    }

    public d(int i2) {
        this.f40952e = new AtomicInteger(1);
        this.f40953f = "sso-" + f40951h.getAndIncrement() + "-thread-";
        this.f40954g = i2;
    }
}
