package d.o.a.e.b.k;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes6.dex */
public class a implements ThreadFactory {

    /* renamed from: e  reason: collision with root package name */
    public final String f68080e;

    /* renamed from: f  reason: collision with root package name */
    public final AtomicInteger f68081f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f68082g;

    public a(String str) {
        this(str, false);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        int incrementAndGet = this.f68081f.incrementAndGet();
        Thread thread = new Thread(runnable, this.f68080e + "-" + incrementAndGet);
        if (!this.f68082g) {
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
        }
        return thread;
    }

    public a(String str, boolean z) {
        this.f68081f = new AtomicInteger();
        this.f68080e = str;
        this.f68082g = z;
    }
}
