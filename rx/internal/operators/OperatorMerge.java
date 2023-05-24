package rx.internal.operators;

import com.baidu.tieba.cab;
import com.baidu.tieba.d8b;
import com.baidu.tieba.fcb;
import com.baidu.tieba.i7b;
import com.baidu.tieba.ibb;
import com.baidu.tieba.k7b;
import com.baidu.tieba.lab;
import com.baidu.tieba.o7b;
import com.baidu.tieba.u9b;
import com.baidu.tieba.uab;
import com.baidu.tieba.z9b;
import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;
import rx.exceptions.CompositeException;
import rx.exceptions.MissingBackpressureException;
import rx.exceptions.OnErrorThrowable;
import rx.internal.util.ScalarSynchronousObservable;
import rx.internal.util.atomic.SpscExactAtomicArrayQueue;
/* loaded from: classes10.dex */
public final class OperatorMerge<T> implements i7b.b<T, i7b<? extends T>> {
    public final boolean a;
    public final int b;

    /* loaded from: classes10.dex */
    public static final class a {
        public static final OperatorMerge<Object> a = new OperatorMerge<>(true, Integer.MAX_VALUE);
    }

    /* loaded from: classes10.dex */
    public static final class b {
        public static final OperatorMerge<Object> a = new OperatorMerge<>(false, Integer.MAX_VALUE);
    }

    /* loaded from: classes10.dex */
    public static final class MergeProducer<T> extends AtomicLong implements k7b {
        public static final long serialVersionUID = -1214379189873595503L;
        public final d<T> subscriber;

        public MergeProducer(d<T> dVar) {
            this.subscriber = dVar;
        }

        public long produced(int i) {
            return addAndGet(-i);
        }

        @Override // com.baidu.tieba.k7b
        public void request(long j) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i > 0) {
                if (get() == Long.MAX_VALUE) {
                    return;
                }
                d8b.b(this, j);
                this.subscriber.i();
            } else if (i >= 0) {
            } else {
                throw new IllegalArgumentException("n >= 0 required");
            }
        }
    }

    /* loaded from: classes10.dex */
    public static final class c<T> extends o7b<T> {
        public static final int j = u9b.c / 4;
        public final d<T> e;
        public final long f;
        public volatile boolean g;
        public volatile u9b h;
        public int i;

        @Override // com.baidu.tieba.o7b
        public void d() {
            int i = u9b.c;
            this.i = i;
            e(i);
        }

        @Override // com.baidu.tieba.j7b
        public void onCompleted() {
            this.g = true;
            this.e.i();
        }

        public c(d<T> dVar, long j2) {
            this.e = dVar;
            this.f = j2;
        }

        public void g(long j2) {
            int i = this.i - ((int) j2);
            if (i > j) {
                this.i = i;
                return;
            }
            int i2 = u9b.c;
            this.i = i2;
            int i3 = i2 - i;
            if (i3 > 0) {
                e(i3);
            }
        }

        @Override // com.baidu.tieba.j7b
        public void onError(Throwable th) {
            this.g = true;
            this.e.o().offer(th);
            this.e.i();
        }

        @Override // com.baidu.tieba.j7b
        public void onNext(T t) {
            this.e.w(this, t);
        }
    }

    /* loaded from: classes10.dex */
    public static final class d<T> extends o7b<i7b<? extends T>> {
        public static final c<?>[] v = new c[0];
        public final o7b<? super T> e;
        public final boolean f;
        public final int g;
        public MergeProducer<T> h;
        public volatile Queue<Object> i;
        public volatile fcb j;
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

        public boolean h() {
            if (this.e.isUnsubscribed()) {
                return true;
            }
            ConcurrentLinkedQueue<Throwable> concurrentLinkedQueue = this.k;
            if (!this.f && concurrentLinkedQueue != null && !concurrentLinkedQueue.isEmpty()) {
                try {
                    t();
                    return true;
                } finally {
                    unsubscribe();
                }
            }
            return false;
        }

        public void i() {
            synchronized (this) {
                if (this.m) {
                    this.n = true;
                    return;
                }
                this.m = true;
                k();
            }
        }

        public void j() {
            int i = this.u + 1;
            if (i == this.t) {
                this.u = 0;
                u(i);
                return;
            }
            this.u = i;
        }

        public fcb n() {
            fcb fcbVar;
            fcb fcbVar2 = this.j;
            if (fcbVar2 == null) {
                boolean z = false;
                synchronized (this) {
                    fcbVar = this.j;
                    if (fcbVar == null) {
                        fcb fcbVar3 = new fcb();
                        this.j = fcbVar3;
                        fcbVar = fcbVar3;
                        z = true;
                    }
                }
                if (z) {
                    b(fcbVar);
                }
                return fcbVar;
            }
            return fcbVar2;
        }

        public Queue<Throwable> o() {
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

        @Override // com.baidu.tieba.j7b
        public void onCompleted() {
            this.l = true;
            i();
        }

        public final void t() {
            ArrayList arrayList = new ArrayList(this.k);
            if (arrayList.size() == 1) {
                this.e.onError((Throwable) arrayList.get(0));
            } else {
                this.e.onError(new CompositeException(arrayList));
            }
        }

        public d(o7b<? super T> o7bVar, boolean z, int i) {
            this.e = o7bVar;
            this.f = z;
            this.g = i;
            if (i == Integer.MAX_VALUE) {
                this.t = Integer.MAX_VALUE;
                e(Long.MAX_VALUE);
                return;
            }
            this.t = Math.max(1, i >> 1);
            e(i);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v1, resolved type: rx.internal.operators.OperatorMerge$c<?>[] */
        /* JADX WARN: Multi-variable type inference failed */
        public void g(c<T> cVar) {
            n().a(cVar);
            synchronized (this.o) {
                c<?>[] cVarArr = this.p;
                int length = cVarArr.length;
                c<?>[] cVarArr2 = new c[length + 1];
                System.arraycopy(cVarArr, 0, cVarArr2, 0, length);
                cVarArr2[length] = cVar;
                this.p = cVarArr2;
            }
        }

        @Override // com.baidu.tieba.j7b
        public void onError(Throwable th) {
            o().offer(th);
            this.l = true;
            i();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: rx.internal.operators.OperatorMerge$d<T> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tieba.j7b
        /* renamed from: p */
        public void onNext(i7b<? extends T> i7bVar) {
            if (i7bVar == null) {
                return;
            }
            if (i7bVar == i7b.d()) {
                j();
            } else if (i7bVar instanceof ScalarSynchronousObservable) {
                v(((ScalarSynchronousObservable) i7bVar).I());
            } else {
                long j = this.q;
                this.q = 1 + j;
                c cVar = new c(this, j);
                g(cVar);
                i7bVar.F(cVar);
                i();
            }
        }

        public void u(long j) {
            e(j);
        }

        public void k() {
            boolean z;
            boolean z2;
            long j;
            int i;
            boolean z3;
            int i2;
            try {
                o7b<? super T> o7bVar = this.e;
                while (!h()) {
                    Queue<Object> queue = this.i;
                    long j2 = this.h.get();
                    if (j2 == Long.MAX_VALUE) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (queue != null) {
                        int i3 = 0;
                        while (true) {
                            j = j2;
                            int i4 = 0;
                            i = i3;
                            Object obj = null;
                            while (true) {
                                if (j <= 0) {
                                    break;
                                }
                                Object poll = queue.poll();
                                if (h()) {
                                    return;
                                }
                                if (poll == null) {
                                    obj = poll;
                                    break;
                                }
                                o7bVar.onNext((Object) NotificationLite.e(poll));
                                i++;
                                i4++;
                                j--;
                                obj = poll;
                            }
                            if (i4 > 0) {
                                if (z2) {
                                    j = Long.MAX_VALUE;
                                } else {
                                    j = this.h.produced(i4);
                                }
                            }
                            if (j == 0 || obj == null) {
                                break;
                            }
                            i3 = i;
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
                            t();
                            return;
                        }
                        o7bVar.onCompleted();
                        return;
                    }
                    if (length > 0) {
                        long j3 = this.r;
                        int i5 = this.s;
                        if (length <= i5 || cVarArr[i5].f != j3) {
                            if (length <= i5) {
                                i5 = 0;
                            }
                            for (int i6 = 0; i6 < length && cVarArr[i5].f != j3; i6++) {
                                i5++;
                                if (i5 == length) {
                                    i5 = 0;
                                }
                            }
                            this.s = i5;
                            this.r = cVarArr[i5].f;
                        }
                        z3 = false;
                        for (int i7 = 0; i7 < length; i7++) {
                            if (h()) {
                                return;
                            }
                            c<?> cVar = cVarArr[i5];
                            Object obj2 = null;
                            do {
                                int i8 = 0;
                                while (j > 0) {
                                    if (h()) {
                                        return;
                                    }
                                    u9b u9bVar = cVar.h;
                                    if (u9bVar == null || (obj2 = u9bVar.i()) == null) {
                                        break;
                                    }
                                    try {
                                        o7bVar.onNext((Object) NotificationLite.e(obj2));
                                        j--;
                                        i8++;
                                    }
                                }
                                if (i8 > 0) {
                                    if (!z2) {
                                        j = this.h.produced(i8);
                                    } else {
                                        j = Long.MAX_VALUE;
                                    }
                                    cVar.g(i8);
                                }
                                i2 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
                                if (i2 == 0) {
                                    break;
                                }
                            } while (obj2 != null);
                            boolean z5 = cVar.g;
                            u9b u9bVar2 = cVar.h;
                            if (z5 && (u9bVar2 == null || u9bVar2.e())) {
                                s(cVar);
                                if (h()) {
                                    return;
                                }
                                i++;
                                z3 = true;
                            }
                            if (i2 == 0) {
                                break;
                            }
                            i5++;
                            if (i5 == length) {
                                i5 = 0;
                            }
                        }
                        this.s = i5;
                        this.r = cVarArr[i5].f;
                    } else {
                        z3 = false;
                    }
                    if (i > 0) {
                        e(i);
                    }
                    if (!z3) {
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

        public void l(T t, long j) {
            try {
                this.e.onNext(t);
                if (j != Long.MAX_VALUE) {
                    this.h.produced(1);
                }
                int i = this.u + 1;
                if (i == this.t) {
                    this.u = 0;
                    u(i);
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
                        k();
                    }
                }
            }
        }

        public void m(c<T> cVar, T t, long j) {
            try {
                this.e.onNext(t);
                if (j != Long.MAX_VALUE) {
                    this.h.produced(1);
                }
                cVar.g(1L);
                synchronized (this) {
                    try {
                        if (!this.n) {
                            this.m = false;
                            return;
                        }
                        this.n = false;
                        k();
                    }
                }
            }
        }

        public void q(T t) {
            Queue<Object> spscExactAtomicArrayQueue;
            Queue<Object> queue = this.i;
            if (queue == null) {
                int i = this.g;
                if (i == Integer.MAX_VALUE) {
                    queue = new cab<>(u9b.c);
                } else {
                    if (lab.a(i)) {
                        if (ibb.b()) {
                            spscExactAtomicArrayQueue = new uab<>(i);
                        } else {
                            spscExactAtomicArrayQueue = new z9b<>(i);
                        }
                    } else {
                        spscExactAtomicArrayQueue = new SpscExactAtomicArrayQueue<>(i);
                    }
                    queue = spscExactAtomicArrayQueue;
                }
                this.i = queue;
            }
            if (!queue.offer(NotificationLite.h(t))) {
                unsubscribe();
                onError(OnErrorThrowable.addValueAsLastCause(new MissingBackpressureException(), t));
            }
        }

        public void r(c<T> cVar, T t) {
            u9b u9bVar = cVar.h;
            if (u9bVar == null) {
                u9bVar = u9b.b();
                cVar.b(u9bVar);
                cVar.h = u9bVar;
            }
            try {
                u9bVar.g(NotificationLite.h(t));
            } catch (IllegalStateException e) {
                if (!cVar.isUnsubscribed()) {
                    cVar.unsubscribe();
                    cVar.onError(e);
                }
            } catch (MissingBackpressureException e2) {
                cVar.unsubscribe();
                cVar.onError(e2);
            }
        }

        public void s(c<T> cVar) {
            u9b u9bVar = cVar.h;
            if (u9bVar != null) {
                u9bVar.j();
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

        public void v(T t) {
            long j = this.h.get();
            boolean z = false;
            if (j != 0) {
                synchronized (this) {
                    j = this.h.get();
                    if (!this.m && j != 0) {
                        this.m = true;
                        z = true;
                    }
                }
            }
            if (z) {
                Queue<Object> queue = this.i;
                if (queue != null && !queue.isEmpty()) {
                    q(t);
                    k();
                    return;
                }
                l(t, j);
                return;
            }
            q(t);
            i();
        }

        public void w(c<T> cVar, T t) {
            long j = this.h.get();
            boolean z = false;
            if (j != 0) {
                synchronized (this) {
                    j = this.h.get();
                    if (!this.m && j != 0) {
                        this.m = true;
                        z = true;
                    }
                }
            }
            if (z) {
                u9b u9bVar = cVar.h;
                if (u9bVar != null && !u9bVar.e()) {
                    r(cVar, t);
                    k();
                    return;
                }
                m(cVar, t, j);
                return;
            }
            r(cVar, t);
            i();
        }
    }

    public OperatorMerge(boolean z, int i) {
        this.a = z;
        this.b = i;
    }

    public static <T> OperatorMerge<T> a(boolean z) {
        if (z) {
            return (OperatorMerge<T>) a.a;
        }
        return (OperatorMerge<T>) b.a;
    }

    public o7b<i7b<? extends T>> call(o7b<? super T> o7bVar) {
        d dVar = new d(o7bVar, this.a, this.b);
        MergeProducer<T> mergeProducer = new MergeProducer<>(dVar);
        dVar.h = mergeProducer;
        o7bVar.b(dVar);
        o7bVar.f(mergeProducer);
        return dVar;
    }

    @Override // com.baidu.tieba.i7b.b, com.baidu.tieba.a8b
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((o7b) ((o7b) obj));
    }
}
