package com.google.common.util.concurrent;

import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import d.g.c.a.n;
import d.g.c.a.s;
import d.g.c.i.a.l;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;
/* loaded from: classes6.dex */
public abstract class AbstractFuture<V> extends d.g.c.i.a.u.a implements l<V> {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f31593h = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));

    /* renamed from: i  reason: collision with root package name */
    public static final Logger f31594i = Logger.getLogger(AbstractFuture.class.getName());
    public static final b j;
    public static final Object k;

    /* renamed from: e  reason: collision with root package name */
    public volatile Object f31595e;

    /* renamed from: f  reason: collision with root package name */
    public volatile d f31596f;

    /* renamed from: g  reason: collision with root package name */
    public volatile k f31597g;

    /* loaded from: classes6.dex */
    public static final class Failure {

        /* renamed from: b  reason: collision with root package name */
        public static final Failure f31598b = new Failure(new Throwable("Failure occurred while trying to finish a future.") { // from class: com.google.common.util.concurrent.AbstractFuture.Failure.1
            @Override // java.lang.Throwable
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        });

        /* renamed from: a  reason: collision with root package name */
        public final Throwable f31599a;

        public Failure(Throwable th) {
            n.p(th);
            this.f31599a = th;
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class b {
        public b() {
        }

        public abstract boolean a(AbstractFuture<?> abstractFuture, d dVar, d dVar2);

        public abstract boolean b(AbstractFuture<?> abstractFuture, Object obj, Object obj2);

        public abstract boolean c(AbstractFuture<?> abstractFuture, k kVar, k kVar2);

        public abstract void d(k kVar, k kVar2);

        public abstract void e(k kVar, Thread thread);
    }

    /* loaded from: classes6.dex */
    public static final class c {

        /* renamed from: c  reason: collision with root package name */
        public static final c f31600c;

        /* renamed from: d  reason: collision with root package name */
        public static final c f31601d;

        /* renamed from: a  reason: collision with root package name */
        public final boolean f31602a;

        /* renamed from: b  reason: collision with root package name */
        public final Throwable f31603b;

        static {
            if (AbstractFuture.f31593h) {
                f31601d = null;
                f31600c = null;
                return;
            }
            f31601d = new c(false, null);
            f31600c = new c(true, null);
        }

        public c(boolean z, Throwable th) {
            this.f31602a = z;
            this.f31603b = th;
        }
    }

    /* loaded from: classes6.dex */
    public static final class d {

        /* renamed from: d  reason: collision with root package name */
        public static final d f31604d = new d(null, null);

        /* renamed from: a  reason: collision with root package name */
        public final Runnable f31605a;

        /* renamed from: b  reason: collision with root package name */
        public final Executor f31606b;

        /* renamed from: c  reason: collision with root package name */
        public d f31607c;

        public d(Runnable runnable, Executor executor) {
            this.f31605a = runnable;
            this.f31606b = executor;
        }
    }

    /* loaded from: classes6.dex */
    public static final class e extends b {

        /* renamed from: a  reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<k, Thread> f31608a;

        /* renamed from: b  reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<k, k> f31609b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<AbstractFuture, k> f31610c;

        /* renamed from: d  reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<AbstractFuture, d> f31611d;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<AbstractFuture, Object> f31612e;

        public e(AtomicReferenceFieldUpdater<k, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<k, k> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<AbstractFuture, k> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<AbstractFuture, d> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<AbstractFuture, Object> atomicReferenceFieldUpdater5) {
            super();
            this.f31608a = atomicReferenceFieldUpdater;
            this.f31609b = atomicReferenceFieldUpdater2;
            this.f31610c = atomicReferenceFieldUpdater3;
            this.f31611d = atomicReferenceFieldUpdater4;
            this.f31612e = atomicReferenceFieldUpdater5;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public boolean a(AbstractFuture<?> abstractFuture, d dVar, d dVar2) {
            return this.f31611d.compareAndSet(abstractFuture, dVar, dVar2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public boolean b(AbstractFuture<?> abstractFuture, Object obj, Object obj2) {
            return this.f31612e.compareAndSet(abstractFuture, obj, obj2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public boolean c(AbstractFuture<?> abstractFuture, k kVar, k kVar2) {
            return this.f31610c.compareAndSet(abstractFuture, kVar, kVar2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public void d(k kVar, k kVar2) {
            this.f31609b.lazySet(kVar, kVar2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public void e(k kVar, Thread thread) {
            this.f31608a.lazySet(kVar, thread);
        }
    }

    /* loaded from: classes6.dex */
    public static final class f<V> implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final AbstractFuture<V> f31613e;

        /* renamed from: f  reason: collision with root package name */
        public final l<? extends V> f31614f;

        public f(AbstractFuture<V> abstractFuture, l<? extends V> lVar) {
            this.f31613e = abstractFuture;
            this.f31614f = lVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f31613e.f31595e != this) {
                return;
            }
            if (AbstractFuture.j.b(this.f31613e, this, AbstractFuture.t(this.f31614f))) {
                AbstractFuture.q(this.f31613e);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class g extends b {
        public g() {
            super();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public boolean a(AbstractFuture<?> abstractFuture, d dVar, d dVar2) {
            synchronized (abstractFuture) {
                if (abstractFuture.f31596f == dVar) {
                    abstractFuture.f31596f = dVar2;
                    return true;
                }
                return false;
            }
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public boolean b(AbstractFuture<?> abstractFuture, Object obj, Object obj2) {
            synchronized (abstractFuture) {
                if (abstractFuture.f31595e == obj) {
                    abstractFuture.f31595e = obj2;
                    return true;
                }
                return false;
            }
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public boolean c(AbstractFuture<?> abstractFuture, k kVar, k kVar2) {
            synchronized (abstractFuture) {
                if (abstractFuture.f31597g == kVar) {
                    abstractFuture.f31597g = kVar2;
                    return true;
                }
                return false;
            }
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public void d(k kVar, k kVar2) {
            kVar.f31623b = kVar2;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public void e(k kVar, Thread thread) {
            kVar.f31622a = thread;
        }
    }

    /* loaded from: classes6.dex */
    public interface h<V> extends l<V> {
    }

    /* loaded from: classes6.dex */
    public static abstract class i<V> extends AbstractFuture<V> implements h<V> {
        @Override // com.google.common.util.concurrent.AbstractFuture, d.g.c.i.a.l
        public final void a(Runnable runnable, Executor executor) {
            super.a(runnable, executor);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final boolean cancel(boolean z) {
            return super.cancel(z);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final V get() throws InterruptedException, ExecutionException {
            return (V) super.get();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final boolean isCancelled() {
            return super.isCancelled();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final boolean isDone() {
            return super.isDone();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final V get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
            return (V) super.get(j, timeUnit);
        }
    }

    /* loaded from: classes6.dex */
    public static final class j extends b {

        /* renamed from: a  reason: collision with root package name */
        public static final Unsafe f31615a;

        /* renamed from: b  reason: collision with root package name */
        public static final long f31616b;

        /* renamed from: c  reason: collision with root package name */
        public static final long f31617c;

        /* renamed from: d  reason: collision with root package name */
        public static final long f31618d;

        /* renamed from: e  reason: collision with root package name */
        public static final long f31619e;

        /* renamed from: f  reason: collision with root package name */
        public static final long f31620f;

        /* loaded from: classes6.dex */
        public static class a implements PrivilegedExceptionAction<Unsafe> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.security.PrivilegedExceptionAction
            /* renamed from: a */
            public Unsafe run() throws Exception {
                Field[] declaredFields;
                for (Field field : Unsafe.class.getDeclaredFields()) {
                    field.setAccessible(true);
                    Object obj = field.get(null);
                    if (Unsafe.class.isInstance(obj)) {
                        return (Unsafe) Unsafe.class.cast(obj);
                    }
                }
                throw new NoSuchFieldError("the Unsafe");
            }
        }

        static {
            Unsafe unsafe;
            try {
                try {
                    unsafe = Unsafe.getUnsafe();
                } catch (PrivilegedActionException e2) {
                    throw new RuntimeException("Could not initialize intrinsics", e2.getCause());
                }
            } catch (SecurityException unused) {
                unsafe = (Unsafe) AccessController.doPrivileged(new a());
            }
            try {
                f31617c = unsafe.objectFieldOffset(AbstractFuture.class.getDeclaredField("g"));
                f31616b = unsafe.objectFieldOffset(AbstractFuture.class.getDeclaredField("f"));
                f31618d = unsafe.objectFieldOffset(AbstractFuture.class.getDeclaredField("e"));
                f31619e = unsafe.objectFieldOffset(k.class.getDeclaredField("a"));
                f31620f = unsafe.objectFieldOffset(k.class.getDeclaredField("b"));
                f31615a = unsafe;
            } catch (Exception e3) {
                s.e(e3);
                throw new RuntimeException(e3);
            }
        }

        public j() {
            super();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public boolean a(AbstractFuture<?> abstractFuture, d dVar, d dVar2) {
            return f31615a.compareAndSwapObject(abstractFuture, f31616b, dVar, dVar2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public boolean b(AbstractFuture<?> abstractFuture, Object obj, Object obj2) {
            return f31615a.compareAndSwapObject(abstractFuture, f31618d, obj, obj2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public boolean c(AbstractFuture<?> abstractFuture, k kVar, k kVar2) {
            return f31615a.compareAndSwapObject(abstractFuture, f31617c, kVar, kVar2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public void d(k kVar, k kVar2) {
            f31615a.putObject(kVar, f31620f, kVar2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        public void e(k kVar, Thread thread) {
            f31615a.putObject(kVar, f31619e, thread);
        }
    }

    /* loaded from: classes6.dex */
    public static final class k {

        /* renamed from: c  reason: collision with root package name */
        public static final k f31621c = new k(false);

        /* renamed from: a  reason: collision with root package name */
        public volatile Thread f31622a;

        /* renamed from: b  reason: collision with root package name */
        public volatile k f31623b;

        public k(boolean z) {
        }

        public void a(k kVar) {
            AbstractFuture.j.d(this, kVar);
        }

        public void b() {
            Thread thread = this.f31622a;
            if (thread != null) {
                this.f31622a = null;
                LockSupport.unpark(thread);
            }
        }

        public k() {
            AbstractFuture.j.e(this, Thread.currentThread());
        }
    }

    static {
        b gVar;
        Throwable th = null;
        try {
            gVar = new j();
            th = null;
        } catch (Throwable th2) {
            th = th2;
            try {
                gVar = new e(AtomicReferenceFieldUpdater.newUpdater(k.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(k.class, k.class, "b"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, k.class, "g"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, d.class, "f"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Object.class, "e"));
            } catch (Throwable th3) {
                gVar = new g();
                th = th3;
            }
        }
        j = gVar;
        if (th != null) {
            f31594i.log(Level.SEVERE, "UnsafeAtomicHelper is broken!", th);
            f31594i.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        k = new Object();
    }

    public static CancellationException o(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:16:0x0001 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.google.common.util.concurrent.AbstractFuture$b] */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.google.common.util.concurrent.AbstractFuture<?>] */
    /* JADX WARN: Type inference failed for: r4v1, types: [com.google.common.util.concurrent.AbstractFuture] */
    /* JADX WARN: Type inference failed for: r4v6, types: [com.google.common.util.concurrent.AbstractFuture<V>, com.google.common.util.concurrent.AbstractFuture] */
    public static void q(AbstractFuture<?> abstractFuture) {
        d dVar = null;
        while (true) {
            abstractFuture.y();
            abstractFuture.n();
            d p = abstractFuture.p(dVar);
            while (p != null) {
                dVar = p.f31607c;
                Runnable runnable = p.f31605a;
                if (runnable instanceof f) {
                    f fVar = (f) runnable;
                    abstractFuture = fVar.f31613e;
                    if (abstractFuture.f31595e == fVar) {
                        if (j.b(abstractFuture, fVar, t(fVar.f31614f))) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } else {
                    r(runnable, p.f31606b);
                }
                p = dVar;
            }
            return;
        }
    }

    public static void r(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e2) {
            Logger logger = f31594i;
            Level level = Level.SEVERE;
            logger.log(level, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e2);
        }
    }

    public static Object t(l<?> lVar) {
        Throwable a2;
        if (lVar instanceof h) {
            Object obj = ((AbstractFuture) lVar).f31595e;
            if (obj instanceof c) {
                c cVar = (c) obj;
                return cVar.f31602a ? cVar.f31603b != null ? new c(false, cVar.f31603b) : c.f31601d : obj;
            }
            return obj;
        } else if ((lVar instanceof d.g.c.i.a.u.a) && (a2 = d.g.c.i.a.u.b.a((d.g.c.i.a.u.a) lVar)) != null) {
            return new Failure(a2);
        } else {
            boolean isCancelled = lVar.isCancelled();
            if ((!f31593h) & isCancelled) {
                return c.f31601d;
            }
            try {
                Object u = u(lVar);
                if (!isCancelled) {
                    return u == null ? k : u;
                }
                return new c(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + lVar));
            } catch (CancellationException e2) {
                if (!isCancelled) {
                    return new Failure(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + lVar, e2));
                }
                return new c(false, e2);
            } catch (ExecutionException e3) {
                if (isCancelled) {
                    return new c(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + lVar, e3));
                }
                return new Failure(e3.getCause());
            } catch (Throwable th) {
                return new Failure(th);
            }
        }
    }

    public static <V> V u(Future<V> future) throws ExecutionException {
        V v;
        boolean z = false;
        while (true) {
            try {
                v = future.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return v;
    }

    public boolean A(V v) {
        if (v == null) {
            v = (V) k;
        }
        if (j.b(this, null, v)) {
            q(this);
            return true;
        }
        return false;
    }

    public boolean B(Throwable th) {
        n.p(th);
        if (j.b(this, null, new Failure(th))) {
            q(this);
            return true;
        }
        return false;
    }

    public boolean C(l<? extends V> lVar) {
        Failure failure;
        n.p(lVar);
        Object obj = this.f31595e;
        if (obj == null) {
            if (lVar.isDone()) {
                if (j.b(this, null, t(lVar))) {
                    q(this);
                    return true;
                }
                return false;
            }
            f fVar = new f(this, lVar);
            if (j.b(this, null, fVar)) {
                try {
                    lVar.a(fVar, DirectExecutor.INSTANCE);
                } catch (Throwable th) {
                    try {
                        failure = new Failure(th);
                    } catch (Throwable unused) {
                        failure = Failure.f31598b;
                    }
                    j.b(this, fVar, failure);
                }
                return true;
            }
            obj = this.f31595e;
        }
        if (obj instanceof c) {
            lVar.cancel(((c) obj).f31602a);
        }
        return false;
    }

    public final String D(Object obj) {
        return obj == this ? "this future" : String.valueOf(obj);
    }

    public final boolean E() {
        Object obj = this.f31595e;
        return (obj instanceof c) && ((c) obj).f31602a;
    }

    @Override // d.g.c.i.a.l
    public void a(Runnable runnable, Executor executor) {
        d dVar;
        n.q(runnable, "Runnable was null.");
        n.q(executor, "Executor was null.");
        if (!isDone() && (dVar = this.f31596f) != d.f31604d) {
            d dVar2 = new d(runnable, executor);
            do {
                dVar2.f31607c = dVar;
                if (j.a(this, dVar, dVar2)) {
                    return;
                }
                dVar = this.f31596f;
            } while (dVar != d.f31604d);
            r(runnable, executor);
        }
        r(runnable, executor);
    }

    @Override // d.g.c.i.a.u.a
    public final Throwable b() {
        if (this instanceof h) {
            Object obj = this.f31595e;
            if (obj instanceof Failure) {
                return ((Failure) obj).f31599a;
            }
            return null;
        }
        return null;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        Object obj = this.f31595e;
        if (!(obj == null) && !(obj instanceof f)) {
            return false;
        }
        c cVar = f31593h ? new c(z, new CancellationException("Future.cancel() was called.")) : z ? c.f31600c : c.f31601d;
        boolean z2 = false;
        AbstractFuture<V> abstractFuture = this;
        while (true) {
            if (j.b(abstractFuture, obj, cVar)) {
                if (z) {
                    abstractFuture.v();
                }
                q(abstractFuture);
                if (!(obj instanceof f)) {
                    return true;
                }
                l<? extends V> lVar = ((f) obj).f31614f;
                if (lVar instanceof h) {
                    abstractFuture = (AbstractFuture) lVar;
                    obj = abstractFuture.f31595e;
                    if (!(obj == null) && !(obj instanceof f)) {
                        return true;
                    }
                    z2 = true;
                } else {
                    lVar.cancel(z);
                    return true;
                }
            } else {
                obj = abstractFuture.f31595e;
                if (!(obj instanceof f)) {
                    return z2;
                }
            }
        }
    }

    @Override // java.util.concurrent.Future
    public V get(long j2, TimeUnit timeUnit) throws InterruptedException, TimeoutException, ExecutionException {
        long nanos = timeUnit.toNanos(j2);
        if (!Thread.interrupted()) {
            Object obj = this.f31595e;
            if ((obj != null) & (!(obj instanceof f))) {
                return s(obj);
            }
            long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
            if (nanos >= 1000) {
                k kVar = this.f31597g;
                if (kVar != k.f31621c) {
                    k kVar2 = new k();
                    do {
                        kVar2.a(kVar);
                        if (j.c(this, kVar, kVar2)) {
                            do {
                                LockSupport.parkNanos(this, nanos);
                                if (!Thread.interrupted()) {
                                    Object obj2 = this.f31595e;
                                    if ((obj2 != null) & (!(obj2 instanceof f))) {
                                        return s(obj2);
                                    }
                                    nanos = nanoTime - System.nanoTime();
                                } else {
                                    z(kVar2);
                                    throw new InterruptedException();
                                }
                            } while (nanos >= 1000);
                            z(kVar2);
                        } else {
                            kVar = this.f31597g;
                        }
                    } while (kVar != k.f31621c);
                    return s(this.f31595e);
                }
                return s(this.f31595e);
            }
            while (nanos > 0) {
                Object obj3 = this.f31595e;
                if ((obj3 != null) & (!(obj3 instanceof f))) {
                    return s(obj3);
                }
                if (!Thread.interrupted()) {
                    nanos = nanoTime - System.nanoTime();
                } else {
                    throw new InterruptedException();
                }
            }
            String abstractFuture = toString();
            String lowerCase = timeUnit.toString().toLowerCase(Locale.ROOT);
            String str = "Waited " + j2 + " " + timeUnit.toString().toLowerCase(Locale.ROOT);
            if (nanos + 1000 < 0) {
                String str2 = str + " (plus ";
                long j3 = -nanos;
                long convert = timeUnit.convert(j3, TimeUnit.NANOSECONDS);
                long nanos2 = j3 - timeUnit.toNanos(convert);
                int i2 = (convert > 0L ? 1 : (convert == 0L ? 0 : -1));
                boolean z = i2 == 0 || nanos2 > 1000;
                if (i2 > 0) {
                    String str3 = str2 + convert + " " + lowerCase;
                    if (z) {
                        str3 = str3 + ",";
                    }
                    str2 = str3 + " ";
                }
                if (z) {
                    str2 = str2 + nanos2 + " nanoseconds ";
                }
                str = str2 + "delay)";
            }
            if (isDone()) {
                throw new TimeoutException(str + " but future completed as timeout expired");
            }
            throw new TimeoutException(str + " for " + abstractFuture);
        }
        throw new InterruptedException();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.f31595e instanceof c;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        Object obj = this.f31595e;
        return (!(obj instanceof f)) & (obj != null);
    }

    public final void m(StringBuilder sb) {
        try {
            Object u = u(this);
            sb.append("SUCCESS, result=[");
            sb.append(D(u));
            sb.append(PreferencesUtil.RIGHT_MOUNT);
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (RuntimeException e2) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e2.getClass());
            sb.append(" thrown from get()]");
        } catch (ExecutionException e3) {
            sb.append("FAILURE, cause=[");
            sb.append(e3.getCause());
            sb.append(PreferencesUtil.RIGHT_MOUNT);
        }
    }

    public void n() {
    }

    public final d p(d dVar) {
        d dVar2;
        do {
            dVar2 = this.f31596f;
        } while (!j.a(this, dVar2, d.f31604d));
        d dVar3 = dVar;
        d dVar4 = dVar2;
        while (dVar4 != null) {
            d dVar5 = dVar4.f31607c;
            dVar4.f31607c = dVar3;
            dVar3 = dVar4;
            dVar4 = dVar5;
        }
        return dVar3;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    public final V s(Object obj) throws ExecutionException {
        if (!(obj instanceof c)) {
            if (!(obj instanceof Failure)) {
                if (obj == k) {
                    return null;
                }
                return obj;
            }
            throw new ExecutionException(((Failure) obj).f31599a);
        }
        throw o("Task was cancelled.", ((c) obj).f31603b);
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (isCancelled()) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            m(sb);
        } else {
            try {
                str = x();
            } catch (RuntimeException e2) {
                str = "Exception thrown from implementation: " + e2.getClass();
            }
            if (str != null && !str.isEmpty()) {
                sb.append("PENDING, info=[");
                sb.append(str);
                sb.append(PreferencesUtil.RIGHT_MOUNT);
            } else if (isDone()) {
                m(sb);
            } else {
                sb.append("PENDING");
            }
        }
        sb.append(PreferencesUtil.RIGHT_MOUNT);
        return sb.toString();
    }

    public void v() {
    }

    public final void w(Future<?> future) {
        if ((future != null) && isCancelled()) {
            future.cancel(E());
        }
    }

    public String x() {
        Object obj = this.f31595e;
        if (obj instanceof f) {
            return "setFuture=[" + D(((f) obj).f31614f) + PreferencesUtil.RIGHT_MOUNT;
        } else if (this instanceof ScheduledFuture) {
            return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
        } else {
            return null;
        }
    }

    public final void y() {
        k kVar;
        do {
            kVar = this.f31597g;
        } while (!j.c(this, kVar, k.f31621c));
        while (kVar != null) {
            kVar.b();
            kVar = kVar.f31623b;
        }
    }

    public final void z(k kVar) {
        kVar.f31622a = null;
        while (true) {
            k kVar2 = this.f31597g;
            if (kVar2 == k.f31621c) {
                return;
            }
            k kVar3 = null;
            while (kVar2 != null) {
                k kVar4 = kVar2.f31623b;
                if (kVar2.f31622a != null) {
                    kVar3 = kVar2;
                } else if (kVar3 != null) {
                    kVar3.f31623b = kVar4;
                    if (kVar3.f31622a == null) {
                        break;
                    }
                } else if (!j.c(this, kVar2, kVar4)) {
                    break;
                }
                kVar2 = kVar4;
            }
            return;
        }
    }

    @Override // java.util.concurrent.Future
    public V get() throws InterruptedException, ExecutionException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.f31595e;
            if ((obj2 != null) & (!(obj2 instanceof f))) {
                return s(obj2);
            }
            k kVar = this.f31597g;
            if (kVar != k.f31621c) {
                k kVar2 = new k();
                do {
                    kVar2.a(kVar);
                    if (j.c(this, kVar, kVar2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f31595e;
                            } else {
                                z(kVar2);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof f))));
                        return s(obj);
                    }
                    kVar = this.f31597g;
                } while (kVar != k.f31621c);
                return s(this.f31595e);
            }
            return s(this.f31595e);
        }
        throw new InterruptedException();
    }
}
