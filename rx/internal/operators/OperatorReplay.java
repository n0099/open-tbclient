package rx.internal.operators;

import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.ebc;
import com.baidu.tieba.fbc;
import com.baidu.tieba.gbc;
import com.baidu.tieba.gdc;
import com.baidu.tieba.kbc;
import com.baidu.tieba.nfc;
import com.baidu.tieba.sac;
import com.baidu.tieba.uac;
import com.baidu.tieba.vac;
import com.baidu.tieba.wfc;
import com.baidu.tieba.xec;
import com.baidu.tieba.yac;
import com.baidu.tieba.zac;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.OnErrorThrowable;
/* loaded from: classes2.dex */
public final class OperatorReplay<T> extends xec<T> {
    public static final kbc e = new a();
    public final sac<? extends T> b;
    public final AtomicReference<f<T>> c;
    public final kbc<? extends e<T>> d;

    /* loaded from: classes2.dex */
    public interface e<T> {
        void complete();

        void error(Throwable th);

        void next(T t);

        void replay(InnerProducer<T> innerProducer);
    }

    /* loaded from: classes2.dex */
    public static final class f<T> extends yac<T> implements zac {
        public static final InnerProducer[] t = new InnerProducer[0];
        public final e<T> e;
        public boolean f;
        public volatile boolean g;
        public volatile long j;
        public long k;
        public boolean m;
        public boolean n;
        public long o;
        public long p;
        public volatile uac q;
        public List<InnerProducer<T>> r;
        public boolean s;
        public final gdc<InnerProducer<T>> h = new gdc<>();
        public InnerProducer<T>[] i = t;
        public final AtomicBoolean l = new AtomicBoolean();

        /* loaded from: classes2.dex */
        public class a implements fbc {
            public a() {
            }

            @Override // com.baidu.tieba.fbc
            public void call() {
                if (!f.this.g) {
                    synchronized (f.this.h) {
                        if (!f.this.g) {
                            f.this.h.g();
                            f.this.j++;
                            f.this.g = true;
                        }
                    }
                }
            }
        }

        public InnerProducer<T>[] h() {
            InnerProducer<T>[] innerProducerArr;
            synchronized (this.h) {
                InnerProducer<T>[] h = this.h.h();
                int length = h.length;
                innerProducerArr = new InnerProducer[length];
                System.arraycopy(h, 0, innerProducerArr, 0, length);
            }
            return innerProducerArr;
        }

        public void i() {
            b(wfc.a(new a()));
        }

        @Override // com.baidu.tieba.tac
        public void onCompleted() {
            if (!this.f) {
                this.f = true;
                try {
                    this.e.complete();
                    m();
                } finally {
                    unsubscribe();
                }
            }
        }

        public f(e<T> eVar) {
            this.e = eVar;
            e(0L);
        }

        @Override // com.baidu.tieba.yac
        public void f(uac uacVar) {
            if (this.q == null) {
                this.q = uacVar;
                k(null);
                m();
                return;
            }
            throw new IllegalStateException("Only a single producer can be set on a Subscriber.");
        }

        public boolean g(InnerProducer<T> innerProducer) {
            if (innerProducer != null) {
                if (this.g) {
                    return false;
                }
                synchronized (this.h) {
                    if (this.g) {
                        return false;
                    }
                    this.h.a(innerProducer);
                    this.j++;
                    return true;
                }
            }
            throw null;
        }

        public void l(InnerProducer<T> innerProducer) {
            if (this.g) {
                return;
            }
            synchronized (this.h) {
                if (this.g) {
                    return;
                }
                this.h.e(innerProducer);
                if (this.h.b()) {
                    this.i = t;
                }
                this.j++;
            }
        }

        @Override // com.baidu.tieba.tac
        public void onError(Throwable th) {
            if (!this.f) {
                this.f = true;
                try {
                    this.e.error(th);
                    m();
                } finally {
                    unsubscribe();
                }
            }
        }

        @Override // com.baidu.tieba.tac
        public void onNext(T t2) {
            if (!this.f) {
                this.e.next(t2);
                m();
            }
        }

        public void j(long j, long j2) {
            long j3 = this.p;
            uac uacVar = this.q;
            long j4 = j - j2;
            if (j4 != 0) {
                this.o = j;
                if (uacVar != null) {
                    if (j3 != 0) {
                        this.p = 0L;
                        uacVar.request(j3 + j4);
                        return;
                    }
                    uacVar.request(j4);
                    return;
                }
                long j5 = j3 + j4;
                if (j5 < 0) {
                    j5 = Long.MAX_VALUE;
                }
                this.p = j5;
            } else if (j3 != 0 && uacVar != null) {
                this.p = 0L;
                uacVar.request(j3);
            }
        }

        public void k(InnerProducer<T> innerProducer) {
            InnerProducer<T>[] h;
            long j;
            List<InnerProducer<T>> list;
            boolean z;
            long j2;
            InnerProducer<T>[] h2;
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
                    for (InnerProducer<T> innerProducer2 : h()) {
                        if (innerProducer2 != null) {
                            j4 = Math.max(j4, innerProducer2.totalRequested.get());
                        }
                    }
                    j = j4;
                }
                j(j, j3);
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
                        for (InnerProducer<T> innerProducer4 : h()) {
                            if (innerProducer4 != null) {
                                j2 = Math.max(j2, innerProducer4.totalRequested.get());
                            }
                        }
                    }
                    j(j2, j5);
                }
            }
        }

        public void m() {
            InnerProducer<T>[] innerProducerArr = this.i;
            if (this.k != this.j) {
                synchronized (this.h) {
                    innerProducerArr = this.i;
                    InnerProducer<T>[] h = this.h.h();
                    int length = h.length;
                    if (innerProducerArr.length != length) {
                        innerProducerArr = new InnerProducer[length];
                        this.i = innerProducerArr;
                    }
                    System.arraycopy(h, 0, innerProducerArr, 0, length);
                    this.k = this.j;
                }
            }
            e<T> eVar = this.e;
            for (InnerProducer<T> innerProducer : innerProducerArr) {
                if (innerProducer != null) {
                    eVar.replay(innerProducer);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class BoundedReplayBuffer<T> extends AtomicReference<Node> implements e<T> {
        public static final long serialVersionUID = 2346567790059478686L;
        public long index;
        public int size;
        public Node tail;

        public Object enterTransform(Object obj) {
            return obj;
        }

        public Object leaveTransform(Object obj) {
            return obj;
        }

        public void truncate() {
        }

        public void truncateFinal() {
        }

        public BoundedReplayBuffer() {
            Node node = new Node(null, 0L);
            this.tail = node;
            set(node);
        }

        @Override // rx.internal.operators.OperatorReplay.e
        public final void complete() {
            Object enterTransform = enterTransform(NotificationLite.b());
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
            if (obj != null && NotificationLite.f(leaveTransform(obj))) {
                return true;
            }
            return false;
        }

        public boolean hasError() {
            Object obj = this.tail.value;
            if (obj != null && NotificationLite.g(leaveTransform(obj))) {
                return true;
            }
            return false;
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

        public final void addLast(Node node) {
            this.tail.set(node);
            this.tail = node;
            this.size++;
        }

        public final void collect(Collection<? super T> collection) {
            Node initialHead = getInitialHead();
            while (true) {
                initialHead = initialHead.get();
                if (initialHead != null) {
                    Object leaveTransform = leaveTransform(initialHead.value);
                    if (!NotificationLite.f(leaveTransform) && !NotificationLite.g(leaveTransform)) {
                        collection.add((Object) NotificationLite.e(leaveTransform));
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
        }

        @Override // rx.internal.operators.OperatorReplay.e
        public final void error(Throwable th) {
            Object enterTransform = enterTransform(NotificationLite.c(th));
            long j = this.index + 1;
            this.index = j;
            addLast(new Node(enterTransform, j));
            truncateFinal();
        }

        @Override // rx.internal.operators.OperatorReplay.e
        public final void next(T t) {
            Object enterTransform = enterTransform(NotificationLite.i(t));
            long j = this.index + 1;
            this.index = j;
            addLast(new Node(enterTransform, j));
            truncate();
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

        public final void setFirst(Node node) {
            set(node);
        }

        @Override // rx.internal.operators.OperatorReplay.e
        public final void replay(InnerProducer<T> innerProducer) {
            yac<? super T> yacVar;
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
                    if (innerProducer.isUnsubscribed() || (yacVar = innerProducer.child) == null) {
                        return;
                    }
                    long j = innerProducer.get();
                    long j2 = 0;
                    while (j2 != j && (node = node2.get()) != null) {
                        Object leaveTransform = leaveTransform(node.value);
                        try {
                            if (NotificationLite.a(yacVar, leaveTransform)) {
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
                            ebc.e(th);
                            innerProducer.unsubscribe();
                            if (!NotificationLite.g(leaveTransform) && !NotificationLite.f(leaveTransform)) {
                                yacVar.onError(OnErrorThrowable.addValueAsLastCause(th, NotificationLite.e(leaveTransform)));
                                return;
                            }
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
    }

    /* loaded from: classes2.dex */
    public static final class InnerProducer<T> extends AtomicLong implements uac, zac {
        public static final long UNSUBSCRIBED = Long.MIN_VALUE;
        public static final long serialVersionUID = -4453897557930727610L;
        public yac<? super T> child;
        public boolean emitting;
        public Object index;
        public boolean missed;
        public final f<T> parent;
        public final AtomicLong totalRequested = new AtomicLong();

        public InnerProducer(f<T> fVar, yac<? super T> yacVar) {
            this.parent = fVar;
            this.child = yacVar;
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

        @Override // com.baidu.tieba.zac
        public boolean isUnsubscribed() {
            if (get() == Long.MIN_VALUE) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.tieba.zac
        public void unsubscribe() {
            if (get() != Long.MIN_VALUE && getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.l(this);
                this.parent.k(this);
                this.child = null;
            }
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

        @Override // com.baidu.tieba.uac
        public void request(long j) {
            long j2;
            long j3;
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i < 0) {
                return;
            }
            do {
                j2 = get();
                if (j2 == Long.MIN_VALUE) {
                    return;
                }
                if (j2 >= 0 && i == 0) {
                    return;
                }
                j3 = j2 + j;
                if (j3 < 0) {
                    j3 = Long.MAX_VALUE;
                }
            } while (!compareAndSet(j2, j3));
            addTotalRequested(j);
            this.parent.k(this);
            this.parent.e.replay(this);
        }
    }

    /* loaded from: classes2.dex */
    public static final class Node extends AtomicReference<Node> {
        public static final long serialVersionUID = 245354315435971818L;
        public final long index;
        public final Object value;

        public Node(Object obj, long j) {
            this.value = obj;
            this.index = j;
        }
    }

    /* loaded from: classes2.dex */
    public static final class SizeAndTimeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        public static final long serialVersionUID = 3457957419649567404L;
        public final int limit;
        public final long maxAgeInMillis;
        public final vac scheduler;

        public SizeAndTimeBoundReplayBuffer(int i, long j, vac vacVar) {
            this.scheduler = vacVar;
            this.limit = i;
            this.maxAgeInMillis = j;
        }

        @Override // rx.internal.operators.OperatorReplay.BoundedReplayBuffer
        public Object enterTransform(Object obj) {
            return new nfc(this.scheduler.now(), obj);
        }

        @Override // rx.internal.operators.OperatorReplay.BoundedReplayBuffer
        public Object leaveTransform(Object obj) {
            return ((nfc) obj).b();
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
                if (node2 == null || ((nfc) node2.value).a() > now) {
                    break;
                }
                node3 = node2.get();
            }
            return node;
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
                    } else if (((nfc) node2.value).a() > now) {
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
                if (node == null || this.size <= 1 || ((nfc) node.value).a() > now) {
                    break;
                }
                i++;
                this.size--;
                node2 = node.get();
            }
        }
    }

    /* loaded from: classes2.dex */
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

    /* loaded from: classes2.dex */
    public static final class UnboundedReplayBuffer<T> extends ArrayList<Object> implements e<T> {
        public static final long serialVersionUID = 7063189396499112664L;
        public volatile int size;

        public UnboundedReplayBuffer(int i) {
            super(i);
        }

        @Override // rx.internal.operators.OperatorReplay.e
        public void error(Throwable th) {
            add(NotificationLite.c(th));
            this.size++;
        }

        @Override // rx.internal.operators.OperatorReplay.e
        public void next(T t) {
            add(NotificationLite.i(t));
            this.size++;
        }

        @Override // rx.internal.operators.OperatorReplay.e
        public void complete() {
            add(NotificationLite.b());
            this.size++;
        }

        @Override // rx.internal.operators.OperatorReplay.e
        public void replay(InnerProducer<T> innerProducer) {
            int i;
            synchronized (innerProducer) {
                if (innerProducer.emitting) {
                    innerProducer.missed = true;
                    return;
                }
                innerProducer.emitting = true;
                while (!innerProducer.isUnsubscribed()) {
                    int i2 = this.size;
                    Integer num = (Integer) innerProducer.index();
                    if (num != null) {
                        i = num.intValue();
                    } else {
                        i = 0;
                    }
                    yac<? super T> yacVar = innerProducer.child;
                    if (yacVar == null) {
                        return;
                    }
                    long j = innerProducer.get();
                    long j2 = 0;
                    while (j2 != j && i < i2) {
                        Object obj = get(i);
                        try {
                            if (NotificationLite.a(yacVar, obj) || innerProducer.isUnsubscribed()) {
                                return;
                            }
                            i++;
                            j2++;
                        } catch (Throwable th) {
                            ebc.e(th);
                            innerProducer.unsubscribe();
                            if (!NotificationLite.g(obj) && !NotificationLite.f(obj)) {
                                yacVar.onError(OnErrorThrowable.addValueAsLastCause(th, NotificationLite.e(obj)));
                                return;
                            }
                            return;
                        }
                    }
                    if (j2 != 0) {
                        innerProducer.index = Integer.valueOf(i);
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

    /* loaded from: classes2.dex */
    public static class a implements kbc {
        @Override // com.baidu.tieba.kbc
        public Object call() {
            return new UnboundedReplayBuffer(16);
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements kbc<e<T>> {
        public final /* synthetic */ int a;

        public b(int i) {
            this.a = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.kbc
        public e<T> call() {
            return new SizeBoundReplayBuffer(this.a);
        }
    }

    /* loaded from: classes2.dex */
    public static class c implements kbc<e<T>> {
        public final /* synthetic */ int a;
        public final /* synthetic */ long b;
        public final /* synthetic */ vac c;

        public c(int i, long j, vac vacVar) {
            this.a = i;
            this.b = j;
            this.c = vacVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.kbc
        public e<T> call() {
            return new SizeAndTimeBoundReplayBuffer(this.a, this.b, this.c);
        }
    }

    /* loaded from: classes2.dex */
    public static class d implements sac.a<T> {
        public final /* synthetic */ AtomicReference a;
        public final /* synthetic */ kbc b;

        public d(AtomicReference atomicReference, kbc kbcVar) {
            this.a = atomicReference;
            this.b = kbcVar;
        }

        public void call(yac<? super T> yacVar) {
            f fVar;
            while (true) {
                fVar = (f) this.a.get();
                if (fVar != null) {
                    break;
                }
                f fVar2 = new f((e) this.b.call());
                fVar2.i();
                if (this.a.compareAndSet(fVar, fVar2)) {
                    fVar = fVar2;
                    break;
                }
            }
            InnerProducer<T> innerProducer = new InnerProducer<>(fVar, yacVar);
            fVar.g(innerProducer);
            yacVar.b(innerProducer);
            fVar.e.replay(innerProducer);
            yacVar.f(innerProducer);
        }

        @Override // com.baidu.tieba.sac.a, com.baidu.tieba.gbc
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((yac) ((yac) obj));
        }
    }

    public OperatorReplay(sac.a<T> aVar, sac<? extends T> sacVar, AtomicReference<f<T>> atomicReference, kbc<? extends e<T>> kbcVar) {
        super(aVar);
        this.b = sacVar;
        this.c = atomicReference;
        this.d = kbcVar;
    }

    public static <T> xec<T> S(sac<? extends T> sacVar, long j, TimeUnit timeUnit, vac vacVar) {
        return T(sacVar, j, timeUnit, vacVar, Integer.MAX_VALUE);
    }

    public static <T> xec<T> Q(sac<? extends T> sacVar) {
        return U(sacVar, e);
    }

    public static <T> xec<T> R(sac<? extends T> sacVar, int i) {
        if (i == Integer.MAX_VALUE) {
            return Q(sacVar);
        }
        return U(sacVar, new b(i));
    }

    public static <T> xec<T> U(sac<? extends T> sacVar, kbc<? extends e<T>> kbcVar) {
        AtomicReference atomicReference = new AtomicReference();
        return new OperatorReplay(new d(atomicReference, kbcVar), sacVar, atomicReference, kbcVar);
    }

    public static <T> xec<T> T(sac<? extends T> sacVar, long j, TimeUnit timeUnit, vac vacVar, int i) {
        return U(sacVar, new c(i, timeUnit.toMillis(j), vacVar));
    }

    @Override // com.baidu.tieba.xec
    public void P(gbc<? super zac> gbcVar) {
        f<T> fVar;
        while (true) {
            fVar = this.c.get();
            if (fVar != null && !fVar.isUnsubscribed()) {
                break;
            }
            f<T> fVar2 = new f<>(this.d.call());
            fVar2.i();
            if (this.c.compareAndSet(fVar, fVar2)) {
                fVar = fVar2;
                break;
            }
        }
        boolean z = true;
        z = (fVar.l.get() || !fVar.l.compareAndSet(false, true)) ? false : false;
        gbcVar.call(fVar);
        if (z) {
            this.b.O(fVar);
        }
    }
}
