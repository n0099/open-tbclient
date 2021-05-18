package rx.internal.operators;

import h.d;
import h.f;
import h.j;
import h.o.d.j.f0;
import h.o.d.j.i;
import h.o.d.j.r;
import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;
import rx.exceptions.CompositeException;
import rx.exceptions.MissingBackpressureException;
import rx.exceptions.OnErrorThrowable;
import rx.internal.util.ScalarSynchronousObservable;
import rx.internal.util.atomic.SpscExactAtomicArrayQueue;
/* loaded from: classes7.dex */
public final class OperatorMerge<T> implements d.b<T, h.d<? extends T>> {

    /* renamed from: e  reason: collision with root package name */
    public final boolean f69066e;

    /* renamed from: f  reason: collision with root package name */
    public final int f69067f;

    /* loaded from: classes7.dex */
    public static final class MergeProducer<T> extends AtomicLong implements f {
        public static final long serialVersionUID = -1214379189873595503L;
        public final d<T> subscriber;

        public MergeProducer(d<T> dVar) {
            this.subscriber = dVar;
        }

        public long produced(int i2) {
            return addAndGet(-i2);
        }

        @Override // h.f
        public void request(long j) {
            int i2 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i2 <= 0) {
                if (i2 < 0) {
                    throw new IllegalArgumentException("n >= 0 required");
                }
            } else if (get() == Long.MAX_VALUE) {
            } else {
                h.o.a.a.b(this, j);
                this.subscriber.d();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final OperatorMerge<Object> f69068a = new OperatorMerge<>(true, Integer.MAX_VALUE);
    }

    /* loaded from: classes7.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public static final OperatorMerge<Object> f69069a = new OperatorMerge<>(false, Integer.MAX_VALUE);
    }

    /* loaded from: classes7.dex */
    public static final class c<T> extends j<T> {
        public static final int j = h.o.d.f.f68630g / 4;

        /* renamed from: e  reason: collision with root package name */
        public final d<T> f69070e;

        /* renamed from: f  reason: collision with root package name */
        public final long f69071f;

        /* renamed from: g  reason: collision with root package name */
        public volatile boolean f69072g;

        /* renamed from: h  reason: collision with root package name */
        public volatile h.o.d.f f69073h;

        /* renamed from: i  reason: collision with root package name */
        public int f69074i;

        public c(d<T> dVar, long j2) {
            this.f69070e = dVar;
            this.f69071f = j2;
        }

        public void b(long j2) {
            int i2 = this.f69074i - ((int) j2);
            if (i2 > j) {
                this.f69074i = i2;
                return;
            }
            int i3 = h.o.d.f.f68630g;
            this.f69074i = i3;
            int i4 = i3 - i2;
            if (i4 > 0) {
                request(i4);
            }
        }

        @Override // h.e
        public void onCompleted() {
            this.f69072g = true;
            this.f69070e.d();
        }

        @Override // h.e
        public void onError(Throwable th) {
            this.f69072g = true;
            this.f69070e.j().offer(th);
            this.f69070e.d();
        }

        @Override // h.e
        public void onNext(T t) {
            this.f69070e.r(this, t);
        }

        @Override // h.j
        public void onStart() {
            int i2 = h.o.d.f.f68630g;
            this.f69074i = i2;
            request(i2);
        }
    }

    /* loaded from: classes7.dex */
    public static final class d<T> extends j<h.d<? extends T>> {
        public static final c<?>[] v = new c[0];

        /* renamed from: e  reason: collision with root package name */
        public final j<? super T> f69075e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f69076f;

        /* renamed from: g  reason: collision with root package name */
        public final int f69077g;

        /* renamed from: h  reason: collision with root package name */
        public MergeProducer<T> f69078h;

        /* renamed from: i  reason: collision with root package name */
        public volatile Queue<Object> f69079i;
        public volatile h.u.b j;
        public volatile ConcurrentLinkedQueue<Throwable> k;
        public volatile boolean l;
        public boolean m;
        public boolean n;
        public final Object o = new Object();
        public volatile c<?>[] p = v;
        public long q;
        public long r;
        public int s;
        public final int t;
        public int u;

        public d(j<? super T> jVar, boolean z, int i2) {
            this.f69075e = jVar;
            this.f69076f = z;
            this.f69077g = i2;
            if (i2 == Integer.MAX_VALUE) {
                this.t = Integer.MAX_VALUE;
                request(Long.MAX_VALUE);
                return;
            }
            this.t = Math.max(1, i2 >> 1);
            request(i2);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v1, resolved type: rx.internal.operators.OperatorMerge$c<?>[] */
        /* JADX WARN: Multi-variable type inference failed */
        public void b(c<T> cVar) {
            i().a(cVar);
            synchronized (this.o) {
                c<?>[] cVarArr = this.p;
                int length = cVarArr.length;
                c<?>[] cVarArr2 = new c[length + 1];
                System.arraycopy(cVarArr, 0, cVarArr2, 0, length);
                cVarArr2[length] = cVar;
                this.p = cVarArr2;
            }
        }

        public boolean c() {
            if (this.f69075e.isUnsubscribed()) {
                return true;
            }
            ConcurrentLinkedQueue<Throwable> concurrentLinkedQueue = this.k;
            if (this.f69076f || concurrentLinkedQueue == null || concurrentLinkedQueue.isEmpty()) {
                return false;
            }
            try {
                o();
                return true;
            } finally {
                unsubscribe();
            }
        }

        public void d() {
            synchronized (this) {
                if (this.m) {
                    this.n = true;
                    return;
                }
                this.m = true;
                f();
            }
        }

        public void e() {
            int i2 = this.u + 1;
            if (i2 == this.t) {
                this.u = 0;
                p(i2);
                return;
            }
            this.u = i2;
        }

        public void f() {
            boolean z;
            long j;
            int i2;
            boolean z2;
            int i3;
            try {
                j<? super T> jVar = this.f69075e;
                while (!c()) {
                    Queue<Object> queue = this.f69079i;
                    long j2 = this.f69078h.get();
                    boolean z3 = j2 == Long.MAX_VALUE;
                    if (queue != null) {
                        int i4 = 0;
                        while (true) {
                            j = j2;
                            int i5 = 0;
                            i2 = i4;
                            Object obj = null;
                            while (true) {
                                if (j <= 0) {
                                    break;
                                }
                                Object poll = queue.poll();
                                if (c()) {
                                    return;
                                }
                                if (poll == null) {
                                    obj = poll;
                                    break;
                                }
                                jVar.onNext((Object) NotificationLite.e(poll));
                                i2++;
                                i5++;
                                j--;
                                obj = poll;
                            }
                            if (i5 > 0) {
                                j = z3 ? Long.MAX_VALUE : this.f69078h.produced(i5);
                            }
                            if (j == 0 || obj == null) {
                                break;
                            }
                            i4 = i2;
                            j2 = j;
                        }
                    } else {
                        j = j2;
                        i2 = 0;
                    }
                    boolean z4 = this.l;
                    Queue<Object> queue2 = this.f69079i;
                    c<?>[] cVarArr = this.p;
                    int length = cVarArr.length;
                    if (z4 && ((queue2 == null || queue2.isEmpty()) && length == 0)) {
                        ConcurrentLinkedQueue<Throwable> concurrentLinkedQueue = this.k;
                        if (concurrentLinkedQueue != null && !concurrentLinkedQueue.isEmpty()) {
                            o();
                            return;
                        }
                        jVar.onCompleted();
                        return;
                    }
                    if (length > 0) {
                        long j3 = this.r;
                        int i6 = this.s;
                        if (length <= i6 || cVarArr[i6].f69071f != j3) {
                            if (length <= i6) {
                                i6 = 0;
                            }
                            for (int i7 = 0; i7 < length && cVarArr[i6].f69071f != j3; i7++) {
                                i6++;
                                if (i6 == length) {
                                    i6 = 0;
                                }
                            }
                            this.s = i6;
                            this.r = cVarArr[i6].f69071f;
                        }
                        z2 = false;
                        for (int i8 = 0; i8 < length; i8++) {
                            if (c()) {
                                return;
                            }
                            c<?> cVar = cVarArr[i6];
                            Object obj2 = null;
                            do {
                                int i9 = 0;
                                while (j > 0) {
                                    if (c()) {
                                        return;
                                    }
                                    h.o.d.f fVar = cVar.f69073h;
                                    if (fVar == null || (obj2 = fVar.i()) == null) {
                                        break;
                                    }
                                    try {
                                        jVar.onNext((Object) NotificationLite.e(obj2));
                                        j--;
                                        i9++;
                                    }
                                }
                                if (i9 > 0) {
                                    j = !z3 ? this.f69078h.produced(i9) : Long.MAX_VALUE;
                                    cVar.b(i9);
                                }
                                i3 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
                                if (i3 == 0) {
                                    break;
                                }
                            } while (obj2 != null);
                            boolean z5 = cVar.f69072g;
                            h.o.d.f fVar2 = cVar.f69073h;
                            if (z5 && (fVar2 == null || fVar2.e())) {
                                n(cVar);
                                if (c()) {
                                    return;
                                }
                                i2++;
                                z2 = true;
                            }
                            if (i3 == 0) {
                                break;
                            }
                            i6++;
                            if (i6 == length) {
                                i6 = 0;
                            }
                        }
                        this.s = i6;
                        this.r = cVarArr[i6].f69071f;
                    } else {
                        z2 = false;
                    }
                    if (i2 > 0) {
                        request(i2);
                    }
                    if (!z2) {
                        synchronized (this) {
                            try {
                                if (!this.n) {
                                    try {
                                        this.m = false;
                                        return;
                                    } catch (Throwable th) {
                                        th = th;
                                        z = true;
                                        while (true) {
                                            try {
                                                break;
                                            } catch (Throwable th2) {
                                                th = th2;
                                            }
                                        }
                                        throw th;
                                    }
                                }
                                this.n = false;
                            } catch (Throwable th3) {
                                th = th3;
                                z = false;
                            }
                        }
                        try {
                            break;
                            throw th;
                        } catch (Throwable th4) {
                            th = th4;
                            if (!z) {
                                synchronized (this) {
                                    this.m = false;
                                }
                            }
                            throw th;
                        }
                    }
                }
            } catch (Throwable th5) {
                th = th5;
                z = false;
            }
        }

        public void g(T t, long j) {
            try {
                this.f69075e.onNext(t);
                if (j != Long.MAX_VALUE) {
                    this.f69078h.produced(1);
                }
                int i2 = this.u + 1;
                if (i2 == this.t) {
                    this.u = 0;
                    p(i2);
                } else {
                    this.u = i2;
                }
                synchronized (this) {
                    try {
                        if (!this.n) {
                            this.m = false;
                            return;
                        }
                        this.n = false;
                        f();
                    }
                }
            }
        }

        public void h(c<T> cVar, T t, long j) {
            try {
                this.f69075e.onNext(t);
                if (j != Long.MAX_VALUE) {
                    this.f69078h.produced(1);
                }
                cVar.b(1L);
                synchronized (this) {
                    try {
                        if (!this.n) {
                            this.m = false;
                            return;
                        }
                        this.n = false;
                        f();
                    }
                }
            }
        }

        public h.u.b i() {
            h.u.b bVar;
            h.u.b bVar2 = this.j;
            if (bVar2 == null) {
                boolean z = false;
                synchronized (this) {
                    bVar = this.j;
                    if (bVar == null) {
                        h.u.b bVar3 = new h.u.b();
                        this.j = bVar3;
                        bVar = bVar3;
                        z = true;
                    }
                }
                if (z) {
                    add(bVar);
                }
                return bVar;
            }
            return bVar2;
        }

        public Queue<Throwable> j() {
            ConcurrentLinkedQueue<Throwable> concurrentLinkedQueue = this.k;
            if (concurrentLinkedQueue == null) {
                synchronized (this) {
                    concurrentLinkedQueue = this.k;
                    if (concurrentLinkedQueue == null) {
                        concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
                        this.k = concurrentLinkedQueue;
                    }
                }
            }
            return concurrentLinkedQueue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: rx.internal.operators.OperatorMerge$d<T> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // h.e
        /* renamed from: k */
        public void onNext(h.d<? extends T> dVar) {
            if (dVar == null) {
                return;
            }
            if (dVar == h.d.e()) {
                e();
            } else if (dVar instanceof ScalarSynchronousObservable) {
                q(((ScalarSynchronousObservable) dVar).L());
            } else {
                long j = this.q;
                this.q = 1 + j;
                c cVar = new c(this, j);
                b(cVar);
                dVar.I(cVar);
                d();
            }
        }

        public void l(T t) {
            Queue<Object> spscExactAtomicArrayQueue;
            Queue<Object> queue = this.f69079i;
            if (queue == null) {
                int i2 = this.f69077g;
                if (i2 == Integer.MAX_VALUE) {
                    queue = new h.o.d.i.f<>(h.o.d.f.f68630g);
                } else {
                    if (i.a(i2)) {
                        if (f0.b()) {
                            spscExactAtomicArrayQueue = new r<>(i2);
                        } else {
                            spscExactAtomicArrayQueue = new h.o.d.i.c<>(i2);
                        }
                    } else {
                        spscExactAtomicArrayQueue = new SpscExactAtomicArrayQueue<>(i2);
                    }
                    queue = spscExactAtomicArrayQueue;
                }
                this.f69079i = queue;
            }
            if (queue.offer(NotificationLite.h(t))) {
                return;
            }
            unsubscribe();
            onError(OnErrorThrowable.addValueAsLastCause(new MissingBackpressureException(), t));
        }

        public void m(c<T> cVar, T t) {
            h.o.d.f fVar = cVar.f69073h;
            if (fVar == null) {
                fVar = h.o.d.f.b();
                cVar.add(fVar);
                cVar.f69073h = fVar;
            }
            try {
                fVar.g(NotificationLite.h(t));
            } catch (IllegalStateException e2) {
                if (cVar.isUnsubscribed()) {
                    return;
                }
                cVar.unsubscribe();
                cVar.onError(e2);
            } catch (MissingBackpressureException e3) {
                cVar.unsubscribe();
                cVar.onError(e3);
            }
        }

        public void n(c<T> cVar) {
            h.o.d.f fVar = cVar.f69073h;
            if (fVar != null) {
                fVar.j();
            }
            this.j.b(cVar);
            synchronized (this.o) {
                c<?>[] cVarArr = this.p;
                int length = cVarArr.length;
                int i2 = -1;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    } else if (cVar.equals(cVarArr[i3])) {
                        i2 = i3;
                        break;
                    } else {
                        i3++;
                    }
                }
                if (i2 < 0) {
                    return;
                }
                if (length == 1) {
                    this.p = v;
                    return;
                }
                c<?>[] cVarArr2 = new c[length - 1];
                System.arraycopy(cVarArr, 0, cVarArr2, 0, i2);
                System.arraycopy(cVarArr, i2 + 1, cVarArr2, i2, (length - i2) - 1);
                this.p = cVarArr2;
            }
        }

        public final void o() {
            ArrayList arrayList = new ArrayList(this.k);
            if (arrayList.size() == 1) {
                this.f69075e.onError((Throwable) arrayList.get(0));
            } else {
                this.f69075e.onError(new CompositeException(arrayList));
            }
        }

        @Override // h.e
        public void onCompleted() {
            this.l = true;
            d();
        }

        @Override // h.e
        public void onError(Throwable th) {
            j().offer(th);
            this.l = true;
            d();
        }

        public void p(long j) {
            request(j);
        }

        public void q(T t) {
            long j = this.f69078h.get();
            boolean z = false;
            if (j != 0) {
                synchronized (this) {
                    j = this.f69078h.get();
                    if (!this.m && j != 0) {
                        this.m = true;
                        z = true;
                    }
                }
            }
            if (z) {
                Queue<Object> queue = this.f69079i;
                if (queue != null && !queue.isEmpty()) {
                    l(t);
                    f();
                    return;
                }
                g(t, j);
                return;
            }
            l(t);
            d();
        }

        public void r(c<T> cVar, T t) {
            long j = this.f69078h.get();
            boolean z = false;
            if (j != 0) {
                synchronized (this) {
                    j = this.f69078h.get();
                    if (!this.m && j != 0) {
                        this.m = true;
                        z = true;
                    }
                }
            }
            if (z) {
                h.o.d.f fVar = cVar.f69073h;
                if (fVar != null && !fVar.e()) {
                    m(cVar, t);
                    f();
                    return;
                }
                h(cVar, t, j);
                return;
            }
            m(cVar, t);
            d();
        }
    }

    public OperatorMerge(boolean z, int i2) {
        this.f69066e = z;
        this.f69067f = i2;
    }

    public static <T> OperatorMerge<T> b(boolean z) {
        if (z) {
            return (OperatorMerge<T>) a.f69068a;
        }
        return (OperatorMerge<T>) b.f69069a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.f
    /* renamed from: a */
    public j<h.d<? extends T>> call(j<? super T> jVar) {
        d dVar = new d(jVar, this.f69066e, this.f69067f);
        MergeProducer<T> mergeProducer = new MergeProducer<>(dVar);
        dVar.f69078h = mergeProducer;
        jVar.add(dVar);
        jVar.setProducer(mergeProducer);
        return dVar;
    }
}
