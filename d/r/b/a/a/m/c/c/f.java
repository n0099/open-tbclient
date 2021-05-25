package d.r.b.a.a.m.c.c;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class f {

    /* renamed from: e  reason: collision with root package name */
    public static f f68180e;

    /* renamed from: f  reason: collision with root package name */
    public static final b f68181f = new b(null);

    /* renamed from: a  reason: collision with root package name */
    public ExecutorService f68182a;

    /* renamed from: b  reason: collision with root package name */
    public d f68183b;

    /* renamed from: c  reason: collision with root package name */
    public d.r.b.a.a.m.c.c.b f68184c;

    /* renamed from: d  reason: collision with root package name */
    public ScheduledExecutorService f68185d;

    /* loaded from: classes7.dex */
    public static final class a implements ThreadFactory {

        /* renamed from: e  reason: collision with root package name */
        public static final a f68186e = new a();

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setPriority(1);
            return thread;
        }
    }

    /* loaded from: classes7.dex */
    public static final class b {
        public b() {
        }

        public final f a() {
            if (f.f68180e == null) {
                synchronized (f.class) {
                    if (f.f68180e == null) {
                        f.f68180e = new f(null);
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            return f.f68180e;
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public f() {
        if (d.r.b.a.a.m.c.c.a.a() == null) {
            this.f68182a = Executors.newFixedThreadPool(5);
            Executors.newSingleThreadExecutor();
            Executors.newScheduledThreadPool(1, a.f68186e);
            return;
        }
        d a2 = d.r.b.a.a.m.c.c.a.a();
        this.f68183b = a2;
        if (a2 == null) {
            Intrinsics.throwNpe();
        }
        d.r.b.a.a.m.c.c.b a3 = a2.a();
        this.f68184c = a3;
        if (a3 == null) {
            Executors.newSingleThreadExecutor();
        }
    }

    public final void c(Runnable runnable) {
        d dVar = this.f68183b;
        if (dVar == null) {
            ExecutorService executorService = this.f68182a;
            if (executorService == null) {
                Intrinsics.throwNpe();
            }
            executorService.execute(runnable);
        } else if (dVar != null) {
            try {
                dVar.b(runnable, 0L);
            } catch (Throwable unused) {
                ScheduledExecutorService d2 = d();
                if (d2 == null) {
                    Intrinsics.throwNpe();
                }
                d2.execute(runnable);
            }
        }
    }

    public final ScheduledExecutorService d() {
        ScheduledExecutorService newScheduledThreadPool;
        ScheduledExecutorService scheduledExecutorService = this.f68185d;
        if (scheduledExecutorService != null) {
            return scheduledExecutorService;
        }
        synchronized (this) {
            if (this.f68185d != null) {
                newScheduledThreadPool = this.f68185d;
            } else {
                newScheduledThreadPool = Executors.newScheduledThreadPool(1);
                this.f68185d = newScheduledThreadPool;
            }
        }
        return newScheduledThreadPool;
    }

    public /* synthetic */ f(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
