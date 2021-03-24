package rx.internal.operators;

import com.baidu.tbadk.core.data.SmallTailInfo;
import h.d;
import h.g;
import h.j;
import h.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.OnErrorThrowable;
/* loaded from: classes7.dex */
public final class OperatorReplay<T> extends h.p.a<T> {
    public static final h.n.e i = new a();

    /* renamed from: f  reason: collision with root package name */
    public final h.d<? extends T> f68200f;

    /* renamed from: g  reason: collision with root package name */
    public final AtomicReference<f<T>> f68201g;

    /* renamed from: h  reason: collision with root package name */
    public final h.n.e<? extends e<T>> f68202h;

    /* loaded from: classes7.dex */
    public static class BoundedReplayBuffer<T> extends AtomicReference<Node> implements e<T> {
        public static final long serialVersionUID = 2346567790059478686L;
        public long index;
        public int size;
        public Node tail;

        public BoundedReplayBuffer() {
            Node node = new Node(null, 0L);
            this.tail = node;
            set(node);
        }

        public final void addLast(Node node) {
            this.tail.set(node);
            this.tail = node;
            this.size++;
        }

        public final void collect(Collection<? super T> collection) {
            Node initialHead = getInitialHead();
            while (true) {
                initialHead = initialHead.get();
                if (initialHead == null) {
                    return;
                }
                Object leaveTransform = leaveTransform(initialHead.value);
                if (NotificationLite.e(leaveTransform) || NotificationLite.f(leaveTransform)) {
                    return;
                }
                collection.add((Object) NotificationLite.d(leaveTransform));
            }
        }

        @Override // rx.internal.operators.OperatorReplay.e
        public final void complete() {
            Object enterTransform = enterTransform(NotificationLite.b());
            long j = this.index + 1;
            this.index = j;
            addLast(new Node(enterTransform, j));
            truncateFinal();
        }

        public Object enterTransform(Object obj) {
            return obj;
        }

        @Override // rx.internal.operators.OperatorReplay.e
        public final void error(Throwable th) {
            Object enterTransform = enterTransform(NotificationLite.c(th));
            long j = this.index + 1;
            this.index = j;
            addLast(new Node(enterTransform, j));
            truncateFinal();
        }

        public Node getInitialHead() {
            return get();
        }

        public boolean hasCompleted() {
            Object obj = this.tail.value;
            return obj != null && NotificationLite.e(leaveTransform(obj));
        }

        public boolean hasError() {
            Object obj = this.tail.value;
            return obj != null && NotificationLite.f(leaveTransform(obj));
        }

        public Object leaveTransform(Object obj) {
            return obj;
        }

        @Override // rx.internal.operators.OperatorReplay.e
        public final void next(T t) {
            Object enterTransform = enterTransform(NotificationLite.g(t));
            long j = this.index + 1;
            this.index = j;
            addLast(new Node(enterTransform, j));
            truncate();
        }

        public final void removeFirst() {
            Node node = get().get();
            if (node != null) {
                this.size--;
                setFirst(node);
                return;
            }
            throw new IllegalStateException("Empty list!");
        }

        public final void removeSome(int i) {
            Node node = get();
            while (i > 0) {
                node = node.get();
                i--;
                this.size--;
            }
            setFirst(node);
        }

        @Override // rx.internal.operators.OperatorReplay.e
        public final void replay(InnerProducer<T> innerProducer) {
            j<? super T> jVar;
            Node node;
            synchronized (innerProducer) {
                if (innerProducer.emitting) {
                    innerProducer.missed = true;
                    return;
                }
                innerProducer.emitting = true;
                while (!innerProducer.isUnsubscribed()) {
                    Node node2 = (Node) innerProducer.index();
                    if (node2 == null) {
                        node2 = getInitialHead();
                        innerProducer.index = node2;
                        innerProducer.addTotalRequested(node2.index);
                    }
                    if (innerProducer.isUnsubscribed() || (jVar = innerProducer.child) == null) {
                        return;
                    }
                    long j = innerProducer.get();
                    long j2 = 0;
                    while (j2 != j && (node = node2.get()) != null) {
                        Object leaveTransform = leaveTransform(node.value);
                        try {
                            if (NotificationLite.a(jVar, leaveTransform)) {
                                innerProducer.index = null;
                                return;
                            }
                            j2++;
                            if (innerProducer.isUnsubscribed()) {
                                return;
                            }
                            node2 = node;
                        } catch (Throwable th) {
                            innerProducer.index = null;
                            h.m.a.e(th);
                            innerProducer.unsubscribe();
                            if (NotificationLite.f(leaveTransform) || NotificationLite.e(leaveTransform)) {
                                return;
                            }
                            jVar.onError(OnErrorThrowable.addValueAsLastCause(th, NotificationLite.d(leaveTransform)));
                            return;
                        }
                    }
                    if (j2 != 0) {
                        innerProducer.index = node2;
                        if (j != Long.MAX_VALUE) {
                            innerProducer.produced(j2);
                        }
                    }
                    synchronized (innerProducer) {
                        if (!innerProducer.missed) {
                            innerProducer.emitting = false;
                            return;
                        }
                        innerProducer.missed = false;
                    }
                }
            }
        }

        public final void setFirst(Node node) {
            set(node);
        }

        public void truncate() {
        }

        public void truncateFinal() {
        }
    }

    /* loaded from: classes7.dex */
    public static final class InnerProducer<T> extends AtomicLong implements h.f, k {
        public static final long UNSUBSCRIBED = Long.MIN_VALUE;
        public static final long serialVersionUID = -4453897557930727610L;
        public j<? super T> child;
        public boolean emitting;
        public Object index;
        public boolean missed;
        public final f<T> parent;
        public final AtomicLong totalRequested = new AtomicLong();

        public InnerProducer(f<T> fVar, j<? super T> jVar) {
            this.parent = fVar;
            this.child = jVar;
        }

        public void addTotalRequested(long j) {
            long j2;
            long j3;
            do {
                j2 = this.totalRequested.get();
                j3 = j2 + j;
                if (j3 < 0) {
                    j3 = Long.MAX_VALUE;
                }
            } while (!this.totalRequested.compareAndSet(j2, j3));
        }

        public <U> U index() {
            return (U) this.index;
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            return get() == Long.MIN_VALUE;
        }

        public long produced(long j) {
            long j2;
            long j3;
            if (j > 0) {
                do {
                    j2 = get();
                    if (j2 == Long.MIN_VALUE) {
                        return Long.MIN_VALUE;
                    }
                    j3 = j2 - j;
                    if (j3 < 0) {
                        throw new IllegalStateException("More produced (" + j + ") than requested (" + j2 + SmallTailInfo.EMOTION_SUFFIX);
                    }
                } while (!compareAndSet(j2, j3));
                return j3;
            }
            throw new IllegalArgumentException("Cant produce zero or less");
        }

        @Override // h.f
        public void request(long j) {
            long j2;
            long j3;
            if (j < 0) {
                return;
            }
            do {
                j2 = get();
                if (j2 == Long.MIN_VALUE) {
                    return;
                }
                if (j2 >= 0 && j == 0) {
                    return;
                }
                j3 = j2 + j;
                if (j3 < 0) {
                    j3 = Long.MAX_VALUE;
                }
            } while (!compareAndSet(j2, j3));
            addTotalRequested(j);
            this.parent.f(this);
            this.parent.f68209e.replay(this);
        }

        @Override // h.k
        public void unsubscribe() {
            if (get() == Long.MIN_VALUE || getAndSet(Long.MIN_VALUE) == Long.MIN_VALUE) {
                return;
            }
            this.parent.g(this);
            this.parent.f(this);
            this.child = null;
        }
    }

    /* loaded from: classes7.dex */
    public static final class Node extends AtomicReference<Node> {
        public static final long serialVersionUID = 245354315435971818L;
        public final long index;
        public final Object value;

        public Node(Object obj, long j) {
            this.value = obj;
            this.index = j;
        }
    }

    /* loaded from: classes7.dex */
    public static final class SizeAndTimeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        public static final long serialVersionUID = 3457957419649567404L;
        public final int limit;
        public final long maxAgeInMillis;
        public final g scheduler;

        public SizeAndTimeBoundReplayBuffer(int i, long j, g gVar) {
            this.scheduler = gVar;
            this.limit = i;
            this.maxAgeInMillis = j;
        }

        @Override // rx.internal.operators.OperatorReplay.BoundedReplayBuffer
        public Object enterTransform(Object obj) {
            return new h.s.a(this.scheduler.now(), obj);
        }

        @Override // rx.internal.operators.OperatorReplay.BoundedReplayBuffer
        public Node getInitialHead() {
            Node node;
            long now = this.scheduler.now() - this.maxAgeInMillis;
            Node node2 = get();
            Node node3 = node2.get();
            while (true) {
                Node node4 = node3;
                node = node2;
                node2 = node4;
                if (node2 == null || ((h.s.a) node2.value).a() > now) {
                    break;
                }
                node3 = node2.get();
            }
            return node;
        }

        @Override // rx.internal.operators.OperatorReplay.BoundedReplayBuffer
        public Object leaveTransform(Object obj) {
            return ((h.s.a) obj).b();
        }

        @Override // rx.internal.operators.OperatorReplay.BoundedReplayBuffer
        public void truncate() {
            Node node;
            long now = this.scheduler.now() - this.maxAgeInMillis;
            Node node2 = get();
            Node node3 = node2.get();
            int i = 0;
            while (true) {
                Node node4 = node3;
                node = node2;
                node2 = node4;
                if (node2 != null) {
                    int i2 = this.size;
                    if (i2 > this.limit) {
                        i++;
                        this.size = i2 - 1;
                        node3 = node2.get();
                    } else if (((h.s.a) node2.value).a() > now) {
                        break;
                    } else {
                        i++;
                        this.size--;
                        node3 = node2.get();
                    }
                } else {
                    break;
                }
            }
            if (i != 0) {
                setFirst(node);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x003c, code lost:
            setFirst(r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x003f, code lost:
            return;
         */
        @Override // rx.internal.operators.OperatorReplay.BoundedReplayBuffer
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void truncateFinal() {
            long now = this.scheduler.now() - this.maxAgeInMillis;
            Node node = get();
            Node node2 = node.get();
            int i = 0;
            while (true) {
                Node node3 = node2;
                Node node4 = node;
                node = node3;
                if (node == null || this.size <= 1 || ((h.s.a) node.value).a() > now) {
                    break;
                }
                i++;
                this.size--;
                node2 = node.get();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class SizeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        public static final long serialVersionUID = -5898283885385201806L;
        public final int limit;

        public SizeBoundReplayBuffer(int i) {
            this.limit = i;
        }

        @Override // rx.internal.operators.OperatorReplay.BoundedReplayBuffer
        public void truncate() {
            if (this.size > this.limit) {
                removeFirst();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class UnboundedReplayBuffer<T> extends ArrayList<Object> implements e<T> {
        public static final long serialVersionUID = 7063189396499112664L;
        public volatile int size;

        public UnboundedReplayBuffer(int i) {
            super(i);
        }

        @Override // rx.internal.operators.OperatorReplay.e
        public void complete() {
            add(NotificationLite.b());
            this.size++;
        }

        @Override // rx.internal.operators.OperatorReplay.e
        public void error(Throwable th) {
            add(NotificationLite.c(th));
            this.size++;
        }

        @Override // rx.internal.operators.OperatorReplay.e
        public void next(T t) {
            add(NotificationLite.g(t));
            this.size++;
        }

        @Override // rx.internal.operators.OperatorReplay.e
        public void replay(InnerProducer<T> innerProducer) {
            synchronized (innerProducer) {
                if (innerProducer.emitting) {
                    innerProducer.missed = true;
                    return;
                }
                innerProducer.emitting = true;
                while (!innerProducer.isUnsubscribed()) {
                    int i = this.size;
                    Integer num = (Integer) innerProducer.index();
                    int intValue = num != null ? num.intValue() : 0;
                    j<? super T> jVar = innerProducer.child;
                    if (jVar == null) {
                        return;
                    }
                    long j = innerProducer.get();
                    long j2 = 0;
                    while (j2 != j && intValue < i) {
                        Object obj = get(intValue);
                        try {
                            if (NotificationLite.a(jVar, obj) || innerProducer.isUnsubscribed()) {
                                return;
                            }
                            intValue++;
                            j2++;
                        } catch (Throwable th) {
                            h.m.a.e(th);
                            innerProducer.unsubscribe();
                            if (NotificationLite.f(obj) || NotificationLite.e(obj)) {
                                return;
                            }
                            jVar.onError(OnErrorThrowable.addValueAsLastCause(th, NotificationLite.d(obj)));
                            return;
                        }
                    }
                    if (j2 != 0) {
                        innerProducer.index = Integer.valueOf(intValue);
                        if (j != Long.MAX_VALUE) {
                            innerProducer.produced(j2);
                        }
                    }
                    synchronized (innerProducer) {
                        if (!innerProducer.missed) {
                            innerProducer.emitting = false;
                            return;
                        }
                        innerProducer.missed = false;
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class a implements h.n.e {
        @Override // h.n.e
        public Object call() {
            return new UnboundedReplayBuffer(16);
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements h.n.e<e<T>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f68203e;

        public b(int i) {
            this.f68203e = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.e
        /* renamed from: a */
        public e<T> call() {
            return new SizeBoundReplayBuffer(this.f68203e);
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements h.n.e<e<T>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f68204e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f68205f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ g f68206g;

        public c(int i, long j, g gVar) {
            this.f68204e = i;
            this.f68205f = j;
            this.f68206g = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.e
        /* renamed from: a */
        public e<T> call() {
            return new SizeAndTimeBoundReplayBuffer(this.f68204e, this.f68205f, this.f68206g);
        }
    }

    /* loaded from: classes7.dex */
    public static class d implements d.a<T> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AtomicReference f68207e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ h.n.e f68208f;

        public d(AtomicReference atomicReference, h.n.e eVar) {
            this.f68207e = atomicReference;
            this.f68208f = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(j<? super T> jVar) {
            f fVar;
            while (true) {
                fVar = (f) this.f68207e.get();
                if (fVar != null) {
                    break;
                }
                f fVar2 = new f((e) this.f68208f.call());
                fVar2.d();
                if (this.f68207e.compareAndSet(fVar, fVar2)) {
                    fVar = fVar2;
                    break;
                }
            }
            InnerProducer<T> innerProducer = new InnerProducer<>(fVar, jVar);
            fVar.b(innerProducer);
            jVar.add(innerProducer);
            fVar.f68209e.replay(innerProducer);
            jVar.setProducer(innerProducer);
        }
    }

    /* loaded from: classes7.dex */
    public interface e<T> {
        void complete();

        void error(Throwable th);

        void next(T t);

        void replay(InnerProducer<T> innerProducer);
    }

    /* loaded from: classes7.dex */
    public static final class f<T> extends j<T> implements k {
        public static final InnerProducer[] t = new InnerProducer[0];

        /* renamed from: e  reason: collision with root package name */
        public final e<T> f68209e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f68210f;

        /* renamed from: g  reason: collision with root package name */
        public volatile boolean f68211g;
        public volatile long j;
        public long k;
        public boolean m;
        public boolean n;
        public long o;
        public long p;
        public volatile h.f q;
        public List<InnerProducer<T>> r;
        public boolean s;

        /* renamed from: h  reason: collision with root package name */
        public final h.o.d.e<InnerProducer<T>> f68212h = new h.o.d.e<>();
        public InnerProducer<T>[] i = t;
        public final AtomicBoolean l = new AtomicBoolean();

        /* loaded from: classes7.dex */
        public class a implements h.n.a {
            public a() {
            }

            @Override // h.n.a
            public void call() {
                if (f.this.f68211g) {
                    return;
                }
                synchronized (f.this.f68212h) {
                    if (!f.this.f68211g) {
                        f.this.f68212h.g();
                        f.this.j++;
                        f.this.f68211g = true;
                    }
                }
            }
        }

        public f(e<T> eVar) {
            this.f68209e = eVar;
            request(0L);
        }

        public boolean b(InnerProducer<T> innerProducer) {
            if (innerProducer != null) {
                if (this.f68211g) {
                    return false;
                }
                synchronized (this.f68212h) {
                    if (this.f68211g) {
                        return false;
                    }
                    this.f68212h.a(innerProducer);
                    this.j++;
                    return true;
                }
            }
            throw null;
        }

        public InnerProducer<T>[] c() {
            InnerProducer<T>[] innerProducerArr;
            synchronized (this.f68212h) {
                InnerProducer<T>[] h2 = this.f68212h.h();
                int length = h2.length;
                innerProducerArr = new InnerProducer[length];
                System.arraycopy(h2, 0, innerProducerArr, 0, length);
            }
            return innerProducerArr;
        }

        public void d() {
            add(h.u.e.a(new a()));
        }

        public void e(long j, long j2) {
            long j3 = this.p;
            h.f fVar = this.q;
            long j4 = j - j2;
            if (j4 == 0) {
                if (j3 == 0 || fVar == null) {
                    return;
                }
                this.p = 0L;
                fVar.request(j3);
                return;
            }
            this.o = j;
            if (fVar == null) {
                long j5 = j3 + j4;
                if (j5 < 0) {
                    j5 = Long.MAX_VALUE;
                }
                this.p = j5;
            } else if (j3 != 0) {
                this.p = 0L;
                fVar.request(j3 + j4);
            } else {
                fVar.request(j4);
            }
        }

        public void f(InnerProducer<T> innerProducer) {
            InnerProducer<T>[] c2;
            long j;
            List<InnerProducer<T>> list;
            boolean z;
            long j2;
            InnerProducer<T>[] c3;
            if (isUnsubscribed()) {
                return;
            }
            synchronized (this) {
                if (this.m) {
                    if (innerProducer != null) {
                        List list2 = this.r;
                        if (list2 == null) {
                            list2 = new ArrayList();
                            this.r = list2;
                        }
                        list2.add(innerProducer);
                    } else {
                        this.s = true;
                    }
                    this.n = true;
                    return;
                }
                this.m = true;
                long j3 = this.o;
                if (innerProducer != null) {
                    j = Math.max(j3, innerProducer.totalRequested.get());
                } else {
                    long j4 = j3;
                    for (InnerProducer<T> innerProducer2 : c()) {
                        if (innerProducer2 != null) {
                            j4 = Math.max(j4, innerProducer2.totalRequested.get());
                        }
                    }
                    j = j4;
                }
                e(j, j3);
                while (!isUnsubscribed()) {
                    synchronized (this) {
                        if (!this.n) {
                            this.m = false;
                            return;
                        }
                        this.n = false;
                        list = this.r;
                        this.r = null;
                        z = this.s;
                        this.s = false;
                    }
                    long j5 = this.o;
                    if (list != null) {
                        j2 = j5;
                        for (InnerProducer<T> innerProducer3 : list) {
                            j2 = Math.max(j2, innerProducer3.totalRequested.get());
                        }
                    } else {
                        j2 = j5;
                    }
                    if (z) {
                        for (InnerProducer<T> innerProducer4 : c()) {
                            if (innerProducer4 != null) {
                                j2 = Math.max(j2, innerProducer4.totalRequested.get());
                            }
                        }
                    }
                    e(j2, j5);
                }
            }
        }

        public void g(InnerProducer<T> innerProducer) {
            if (this.f68211g) {
                return;
            }
            synchronized (this.f68212h) {
                if (this.f68211g) {
                    return;
                }
                this.f68212h.e(innerProducer);
                if (this.f68212h.b()) {
                    this.i = t;
                }
                this.j++;
            }
        }

        public void h() {
            InnerProducer<T>[] innerProducerArr = this.i;
            if (this.k != this.j) {
                synchronized (this.f68212h) {
                    innerProducerArr = this.i;
                    InnerProducer<T>[] h2 = this.f68212h.h();
                    int length = h2.length;
                    if (innerProducerArr.length != length) {
                        innerProducerArr = new InnerProducer[length];
                        this.i = innerProducerArr;
                    }
                    System.arraycopy(h2, 0, innerProducerArr, 0, length);
                    this.k = this.j;
                }
            }
            e<T> eVar = this.f68209e;
            for (InnerProducer<T> innerProducer : innerProducerArr) {
                if (innerProducer != null) {
                    eVar.replay(innerProducer);
                }
            }
        }

        @Override // h.e
        public void onCompleted() {
            if (this.f68210f) {
                return;
            }
            this.f68210f = true;
            try {
                this.f68209e.complete();
                h();
            } finally {
                unsubscribe();
            }
        }

        @Override // h.e
        public void onError(Throwable th) {
            if (this.f68210f) {
                return;
            }
            this.f68210f = true;
            try {
                this.f68209e.error(th);
                h();
            } finally {
                unsubscribe();
            }
        }

        @Override // h.e
        public void onNext(T t2) {
            if (this.f68210f) {
                return;
            }
            this.f68209e.next(t2);
            h();
        }

        @Override // h.j
        public void setProducer(h.f fVar) {
            if (this.q == null) {
                this.q = fVar;
                f(null);
                h();
                return;
            }
            throw new IllegalStateException("Only a single producer can be set on a Subscriber.");
        }
    }

    public OperatorReplay(d.a<T> aVar, h.d<? extends T> dVar, AtomicReference<f<T>> atomicReference, h.n.e<? extends e<T>> eVar) {
        super(aVar);
        this.f68200f = dVar;
        this.f68201g = atomicReference;
        this.f68202h = eVar;
    }

    public static <T> h.p.a<T> L(h.d<? extends T> dVar) {
        return P(dVar, i);
    }

    public static <T> h.p.a<T> M(h.d<? extends T> dVar, int i2) {
        if (i2 == Integer.MAX_VALUE) {
            return L(dVar);
        }
        return P(dVar, new b(i2));
    }

    public static <T> h.p.a<T> N(h.d<? extends T> dVar, long j, TimeUnit timeUnit, g gVar) {
        return O(dVar, j, timeUnit, gVar, Integer.MAX_VALUE);
    }

    public static <T> h.p.a<T> O(h.d<? extends T> dVar, long j, TimeUnit timeUnit, g gVar, int i2) {
        return P(dVar, new c(i2, timeUnit.toMillis(j), gVar));
    }

    public static <T> h.p.a<T> P(h.d<? extends T> dVar, h.n.e<? extends e<T>> eVar) {
        AtomicReference atomicReference = new AtomicReference();
        return new OperatorReplay(new d(atomicReference, eVar), dVar, atomicReference, eVar);
    }

    @Override // h.p.a
    public void K(h.n.b<? super k> bVar) {
        f<T> fVar;
        while (true) {
            fVar = this.f68201g.get();
            if (fVar != null && !fVar.isUnsubscribed()) {
                break;
            }
            f<T> fVar2 = new f<>(this.f68202h.call());
            fVar2.d();
            if (this.f68201g.compareAndSet(fVar, fVar2)) {
                fVar = fVar2;
                break;
            }
        }
        boolean z = true;
        z = (fVar.l.get() || !fVar.l.compareAndSet(false, true)) ? false : false;
        bVar.call(fVar);
        if (z) {
            this.f68200f.J(fVar);
        }
    }
}
