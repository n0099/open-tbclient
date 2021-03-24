package rx.internal.operators;

import h.d;
import h.f;
import h.j;
import h.o.d.g;
import h.o.d.k.f0;
import h.o.d.k.i;
import h.o.d.k.r;
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
    public final boolean f68188e;

    /* renamed from: f  reason: collision with root package name */
    public final int f68189f;

    /* loaded from: classes7.dex */
    public static final class MergeProducer<T> extends AtomicLong implements f {
        public static final long serialVersionUID = -1214379189873595503L;
        public final d<T> subscriber;

        public MergeProducer(d<T> dVar) {
            this.subscriber = dVar;
        }

        public long produced(int i) {
            return addAndGet(-i);
        }

        @Override // h.f
        public void request(long j) {
            if (j <= 0) {
                if (j < 0) {
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
        public static final OperatorMerge<Object> f68190a = new OperatorMerge<>(true, Integer.MAX_VALUE);
    }

    /* loaded from: classes7.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public static final OperatorMerge<Object> f68191a = new OperatorMerge<>(false, Integer.MAX_VALUE);
    }

    /* loaded from: classes7.dex */
    public static final class c<T> extends j<T> {
        public static final int j = g.f67930g / 4;

        /* renamed from: e  reason: collision with root package name */
        public final d<T> f68192e;

        /* renamed from: f  reason: collision with root package name */
        public final long f68193f;

        /* renamed from: g  reason: collision with root package name */
        public volatile boolean f68194g;

        /* renamed from: h  reason: collision with root package name */
        public volatile g f68195h;
        public int i;

        public c(d<T> dVar, long j2) {
            this.f68192e = dVar;
            this.f68193f = j2;
        }

        public void b(long j2) {
            int i = this.i - ((int) j2);
            if (i > j) {
                this.i = i;
                return;
            }
            int i2 = g.f67930g;
            this.i = i2;
            int i3 = i2 - i;
            if (i3 > 0) {
                request(i3);
            }
        }

        @Override // h.e
        public void onCompleted() {
            this.f68194g = true;
            this.f68192e.d();
        }

        @Override // h.e
        public void onError(Throwable th) {
            this.f68194g = true;
            this.f68192e.j().offer(th);
            this.f68192e.d();
        }

        @Override // h.e
        public void onNext(T t) {
            this.f68192e.r(this, t);
        }

        @Override // h.j
        public void onStart() {
            int i = g.f67930g;
            this.i = i;
            request(i);
        }
    }

    /* loaded from: classes7.dex */
    public static final class d<T> extends j<h.d<? extends T>> {
        public static final c<?>[] v = new c[0];

        /* renamed from: e  reason: collision with root package name */
        public final j<? super T> f68196e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f68197f;

        /* renamed from: g  reason: collision with root package name */
        public final int f68198g;

        /* renamed from: h  reason: collision with root package name */
        public MergeProducer<T> f68199h;
        public volatile Queue<Object> i;
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

        public d(j<? super T> jVar, boolean z, int i) {
            this.f68196e = jVar;
            this.f68197f = z;
            this.f68198g = i;
            if (i == Integer.MAX_VALUE) {
                this.t = Integer.MAX_VALUE;
                request(Long.MAX_VALUE);
                return;
            }
            this.t = Math.max(1, i >> 1);
            request(i);
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
            if (this.f68196e.isUnsubscribed()) {
                return true;
            }
            ConcurrentLinkedQueue<Throwable> concurrentLinkedQueue = this.k;
            if (this.f68197f || concurrentLinkedQueue == null || concurrentLinkedQueue.isEmpty()) {
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
            int i = this.u + 1;
            if (i == this.t) {
                this.u = 0;
                p(i);
                return;
            }
            this.u = i;
        }

        public void f() {
            boolean z;
            long j;
            int i;
            boolean z2;
            try {
                j<? super T> jVar = this.f68196e;
                while (!c()) {
                    Queue<Object> queue = this.i;
                    long j2 = this.f68199h.get();
                    boolean z3 = j2 == Long.MAX_VALUE;
                    if (queue != null) {
                        int i2 = 0;
                        while (true) {
                            j = j2;
                            int i3 = 0;
                            i = i2;
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
                                jVar.onNext((Object) NotificationLite.d(poll));
                                i++;
                                i3++;
                                j--;
                                obj = poll;
                            }
                            if (i3 > 0) {
                                j = z3 ? Long.MAX_VALUE : this.f68199h.produced(i3);
                            }
                            if (j == 0 || obj == null) {
                                break;
                            }
                            i2 = i;
                            j2 = j;
                        }
                    } else {
                        j = j2;
                        i = 0;
                    }
                    boolean z4 = this.l;
                    Queue<Object> queue2 = this.i;
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
                        int i4 = this.s;
                        if (length <= i4 || cVarArr[i4].f68193f != j3) {
                            if (length <= i4) {
                                i4 = 0;
                            }
                            for (int i5 = 0; i5 < length && cVarArr[i4].f68193f != j3; i5++) {
                                i4++;
                                if (i4 == length) {
                                    i4 = 0;
                                }
                            }
                            this.s = i4;
                            this.r = cVarArr[i4].f68193f;
                        }
                        z2 = false;
                        for (int i6 = 0; i6 < length; i6++) {
                            if (c()) {
                                return;
                            }
                            c<?> cVar = cVarArr[i4];
                            Object obj2 = null;
                            do {
                                int i7 = 0;
                                while (j > 0) {
                                    if (c()) {
                                        return;
                                    }
                                    g gVar = cVar.f68195h;
                                    if (gVar == null || (obj2 = gVar.i()) == null) {
                                        break;
                                    }
                                    try {
                                        jVar.onNext((Object) NotificationLite.d(obj2));
                                        j--;
                                        i7++;
                                    }
                                }
                                if (i7 > 0) {
                                    j = !z3 ? this.f68199h.produced(i7) : Long.MAX_VALUE;
                                    cVar.b(i7);
                                }
                                if (j == 0) {
                                    break;
                                }
                            } while (obj2 != null);
                            boolean z5 = cVar.f68194g;
                            g gVar2 = cVar.f68195h;
                            if (z5 && (gVar2 == null || gVar2.e())) {
                                n(cVar);
                                if (c()) {
                                    return;
                                }
                                i++;
                                z2 = true;
                            }
                            if (j == 0) {
                                break;
                            }
                            i4++;
                            if (i4 == length) {
                                i4 = 0;
                            }
                        }
                        this.s = i4;
                        this.r = cVarArr[i4].f68193f;
                    } else {
                        z2 = false;
                    }
                    if (i > 0) {
                        request(i);
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
                this.f68196e.onNext(t);
                if (j != Long.MAX_VALUE) {
                    this.f68199h.produced(1);
                }
                int i = this.u + 1;
                if (i == this.t) {
                    this.u = 0;
                    p(i);
                } else {
                    this.u = i;
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
                this.f68196e.onNext(t);
                if (j != Long.MAX_VALUE) {
                    this.f68199h.produced(1);
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
            if (dVar == h.d.f()) {
                e();
            } else if (dVar instanceof ScalarSynchronousObservable) {
                q(((ScalarSynchronousObservable) dVar).M());
            } else {
                long j = this.q;
                this.q = 1 + j;
                c cVar = new c(this, j);
                b(cVar);
                dVar.J(cVar);
                d();
            }
        }

        public void l(T t) {
            Queue<Object> spscExactAtomicArrayQueue;
            Queue<Object> queue = this.i;
            if (queue == null) {
                int i = this.f68198g;
                if (i == Integer.MAX_VALUE) {
                    queue = new h.o.d.j.f<>(g.f67930g);
                } else {
                    if (i.a(i)) {
                        if (f0.b()) {
                            spscExactAtomicArrayQueue = new r<>(i);
                        } else {
                            spscExactAtomicArrayQueue = new h.o.d.j.c<>(i);
                        }
                    } else {
                        spscExactAtomicArrayQueue = new SpscExactAtomicArrayQueue<>(i);
                    }
                    queue = spscExactAtomicArrayQueue;
                }
                this.i = queue;
            }
            if (queue.offer(NotificationLite.g(t))) {
                return;
            }
            unsubscribe();
            onError(OnErrorThrowable.addValueAsLastCause(new MissingBackpressureException(), t));
        }

        public void m(c<T> cVar, T t) {
            g gVar = cVar.f68195h;
            if (gVar == null) {
                gVar = g.b();
                cVar.add(gVar);
                cVar.f68195h = gVar;
            }
            try {
                gVar.g(NotificationLite.g(t));
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
            g gVar = cVar.f68195h;
            if (gVar != null) {
                gVar.j();
            }
            this.j.b(cVar);
            synchronized (this.o) {
                c<?>[] cVarArr = this.p;
                int length = cVarArr.length;
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (cVar.equals(cVarArr[i2])) {
                        i = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i < 0) {
                    return;
                }
                if (length == 1) {
                    this.p = v;
                    return;
                }
                c<?>[] cVarArr2 = new c[length - 1];
                System.arraycopy(cVarArr, 0, cVarArr2, 0, i);
                System.arraycopy(cVarArr, i + 1, cVarArr2, i, (length - i) - 1);
                this.p = cVarArr2;
            }
        }

        public final void o() {
            ArrayList arrayList = new ArrayList(this.k);
            if (arrayList.size() == 1) {
                this.f68196e.onError((Throwable) arrayList.get(0));
            } else {
                this.f68196e.onError(new CompositeException(arrayList));
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
            long j = this.f68199h.get();
            boolean z = false;
            if (j != 0) {
                synchronized (this) {
                    j = this.f68199h.get();
                    if (!this.m && j != 0) {
                        this.m = true;
                        z = true;
                    }
                }
            }
            if (z) {
                Queue<Object> queue = this.i;
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
            long j = this.f68199h.get();
            boolean z = false;
            if (j != 0) {
                synchronized (this) {
                    j = this.f68199h.get();
                    if (!this.m && j != 0) {
                        this.m = true;
                        z = true;
                    }
                }
            }
            if (z) {
                g gVar = cVar.f68195h;
                if (gVar != null && !gVar.e()) {
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

    public OperatorMerge(boolean z, int i) {
        this.f68188e = z;
        this.f68189f = i;
    }

    public static <T> OperatorMerge<T> b(boolean z) {
        if (z) {
            return (OperatorMerge<T>) a.f68190a;
        }
        return (OperatorMerge<T>) b.f68191a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.f
    /* renamed from: a */
    public j<h.d<? extends T>> call(j<? super T> jVar) {
        d dVar = new d(jVar, this.f68188e, this.f68189f);
        MergeProducer<T> mergeProducer = new MergeProducer<>(dVar);
        dVar.f68199h = mergeProducer;
        jVar.add(dVar);
        jVar.setProducer(mergeProducer);
        return dVar;
    }
}
