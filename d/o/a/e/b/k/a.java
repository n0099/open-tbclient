package d.o.a.e.b.k;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes6.dex */
public class a implements ThreadFactory {

    /* renamed from: e  reason: collision with root package name */
    public final String f66595e;

    /* renamed from: f  reason: collision with root package name */
    public final AtomicInteger f66596f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f66597g;

    public a(String str) {
        this(str, false);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        int incrementAndGet = this.f66596f.incrementAndGet();
        Thread thread = new Thread(runnable, this.f66595e + "-" + incrementAndGet);
        if (!this.f66597g) {
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
        this.f66596f = new AtomicInteger();
        this.f66595e = str;
        this.f66597g = z;
    }
}
