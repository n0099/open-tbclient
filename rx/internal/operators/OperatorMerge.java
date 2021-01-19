package rx.internal.operators;

import androidx.appcompat.widget.ActivityChooserView;
import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;
import rx.d;
import rx.exceptions.CompositeException;
import rx.exceptions.MissingBackpressureException;
import rx.exceptions.OnErrorThrowable;
import rx.internal.util.ScalarSynchronousObservable;
import rx.internal.util.a.ae;
import rx.internal.util.atomic.SpscExactAtomicArrayQueue;
/* loaded from: classes14.dex */
public final class OperatorMerge<T> implements d.b<T, rx.d<? extends T>> {
    final boolean delayErrors;
    final int qpP;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public static final class a {
        static final OperatorMerge<Object> qqe = new OperatorMerge<>(true, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public static final class b {
        static final OperatorMerge<Object> qqe = new OperatorMerge<>(false, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public static <T> OperatorMerge<T> CJ(boolean z) {
        return z ? (OperatorMerge<T>) a.qqe : (OperatorMerge<T>) b.qqe;
    }

    OperatorMerge(boolean z, int i) {
        this.delayErrors = z;
        this.qpP = i;
    }

    public rx.j<rx.d<? extends T>> call(rx.j<? super T> jVar) {
        d dVar = new d(jVar, this.delayErrors, this.qpP);
        MergeProducer<T> mergeProducer = new MergeProducer<>(dVar);
        dVar.qqi = mergeProducer;
        jVar.add(dVar);
        jVar.setProducer(mergeProducer);
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public static final class MergeProducer<T> extends AtomicLong implements rx.f {
        private static final long serialVersionUID = -1214379189873595503L;
        final d<T> subscriber;

        public MergeProducer(d<T> dVar) {
            this.subscriber = dVar;
        }

        @Override // rx.f
        public void request(long j) {
            if (j > 0) {
                if (get() != Long.MAX_VALUE) {
                    rx.internal.operators.a.e(this, j);
                    this.subscriber.emit();
                }
            } else if (j < 0) {
                throw new IllegalArgumentException("n >= 0 required");
            }
        }

        public long produced(int i) {
            return addAndGet(-i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public static final class d<T> extends rx.j<rx.d<? extends T>> {
        static final c<?>[] qqn = new c[0];
        final rx.j<? super T> child;
        final boolean delayErrors;
        volatile boolean done;
        boolean emitting;
        long lastId;
        int lastIndex;
        boolean missed;
        final int qpP;
        MergeProducer<T> qqi;
        volatile rx.subscriptions.b qqj;
        volatile ConcurrentLinkedQueue<Throwable> qqk;
        final Object qql = new Object();
        volatile c<?>[] qqm = qqn;
        final int qqo;
        int qqp;
        volatile Queue<Object> queue;
        long uniqueId;

        public d(rx.j<? super T> jVar, boolean z, int i) {
            this.child = jVar;
            this.delayErrors = z;
            this.qpP = i;
            if (i == Integer.MAX_VALUE) {
                this.qqo = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                request(Long.MAX_VALUE);
                return;
            }
            this.qqo = Math.max(1, i >> 1);
            request(i);
        }

        Queue<Throwable> eKH() {
            ConcurrentLinkedQueue<Throwable> concurrentLinkedQueue = this.qqk;
            if (concurrentLinkedQueue == null) {
                synchronized (this) {
                    concurrentLinkedQueue = this.qqk;
                    if (concurrentLinkedQueue == null) {
                        concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
                        this.qqk = concurrentLinkedQueue;
                    }
                }
            }
            return concurrentLinkedQueue;
        }

        rx.subscriptions.b eKI() {
            rx.subscriptions.b bVar = this.qqj;
            if (bVar == null) {
                boolean z = false;
                synchronized (this) {
                    bVar = this.qqj;
                    if (bVar == null) {
                        bVar = new rx.subscriptions.b();
                        this.qqj = bVar;
                        z = true;
                    }
                }
                if (z) {
                    add(bVar);
                }
            }
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: rx.internal.operators.OperatorMerge$d<T> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // rx.e
        /* renamed from: d */
        public void onNext(rx.d<? extends T> dVar) {
            if (dVar != null) {
                if (dVar == rx.d.eKl()) {
                    eKJ();
                } else if (dVar instanceof ScalarSynchronousObservable) {
                    cb(((ScalarSynchronousObservable) dVar).get());
                } else {
                    long j = this.uniqueId;
                    this.uniqueId = 1 + j;
                    c cVar = new c(this, j);
                    a(cVar);
                    dVar.a((rx.j<? super Object>) cVar);
                    emit();
                }
            }
        }

        void eKJ() {
            int i = this.qqp + 1;
            if (i == this.qqo) {
                this.qqp = 0;
                requestMore(i);
                return;
            }
            this.qqp = i;
        }

        private void eKK() {
            ArrayList arrayList = new ArrayList(this.qqk);
            if (arrayList.size() == 1) {
                this.child.onError((Throwable) arrayList.get(0));
            } else {
                this.child.onError(new CompositeException(arrayList));
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            eKH().offer(th);
            this.done = true;
            emit();
        }

        @Override // rx.e
        public void onCompleted() {
            this.done = true;
            emit();
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v1, resolved type: rx.internal.operators.OperatorMerge$c<?>[] */
        /* JADX WARN: Multi-variable type inference failed */
        void a(c<T> cVar) {
            eKI().add(cVar);
            synchronized (this.qql) {
                c<?>[] cVarArr = this.qqm;
                int length = cVarArr.length;
                c<?>[] cVarArr2 = new c[length + 1];
                System.arraycopy(cVarArr, 0, cVarArr2, 0, length);
                cVarArr2[length] = cVar;
                this.qqm = cVarArr2;
            }
        }

        void b(c<T> cVar) {
            int i = 0;
            rx.internal.util.g gVar = cVar.qqg;
            if (gVar != null) {
                gVar.release();
            }
            this.qqj.a(cVar);
            synchronized (this.qql) {
                c<?>[] cVarArr = this.qqm;
                int length = cVarArr.length;
                while (true) {
                    if (i >= length) {
                        i = -1;
                        break;
                    } else if (cVar.equals(cVarArr[i])) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i >= 0) {
                    if (length == 1) {
                        this.qqm = qqn;
                        return;
                    }
                    c<?>[] cVarArr2 = new c[length - 1];
                    System.arraycopy(cVarArr, 0, cVarArr2, 0, i);
                    System.arraycopy(cVarArr, i + 1, cVarArr2, i, (length - i) - 1);
                    this.qqm = cVarArr2;
                }
            }
        }

        void a(c<T> cVar, T t) {
            boolean z = false;
            long j = this.qqi.get();
            if (j != 0) {
                synchronized (this) {
                    j = this.qqi.get();
                    if (!this.emitting && j != 0) {
                        this.emitting = true;
                        z = true;
                    }
                }
            }
            if (z) {
                rx.internal.util.g gVar = cVar.qqg;
                if (gVar == null || gVar.isEmpty()) {
                    a(cVar, t, j);
                    return;
                }
                b((c<c<T>>) cVar, (c<T>) t);
                emitLoop();
                return;
            }
            b((c<c<T>>) cVar, (c<T>) t);
            emit();
        }

        protected void b(c<T> cVar, T t) {
            rx.internal.util.g gVar = cVar.qqg;
            if (gVar == null) {
                gVar = rx.internal.util.g.eLb();
                cVar.add(gVar);
                cVar.qqg = gVar;
            }
            try {
                gVar.onNext(NotificationLite.next(t));
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

        protected void a(c<T> cVar, T t, long j) {
            try {
                this.child.onNext(t);
                if (j != Long.MAX_VALUE) {
                    try {
                        this.qqi.produced(1);
                    } catch (Throwable th) {
                        if (0 == 0) {
                            synchronized (this) {
                                this.emitting = false;
                            }
                        }
                        throw th;
                    }
                }
                cVar.requestMore(1L);
                synchronized (this) {
                    if (!this.missed) {
                        this.emitting = false;
                        return;
                    }
                    this.missed = false;
                    emitLoop();
                }
            }
        }

        public void requestMore(long j) {
            request(j);
        }

        void cb(T t) {
            boolean z = false;
            long j = this.qqi.get();
            if (j != 0) {
                synchronized (this) {
                    j = this.qqi.get();
                    if (!this.emitting && j != 0) {
                        this.emitting = true;
                        z = true;
                    }
                }
            }
            if (z) {
                Queue<Object> queue = this.queue;
                if (queue == null || queue.isEmpty()) {
                    b((d<T>) t, j);
                    return;
                }
                cc(t);
                emitLoop();
                return;
            }
            cc(t);
            emit();
        }

        protected void cc(T t) {
            Queue<Object> queue = this.queue;
            if (queue == null) {
                int i = this.qpP;
                if (i == Integer.MAX_VALUE) {
                    queue = new rx.internal.util.atomic.f<>(rx.internal.util.g.SIZE);
                } else if (rx.internal.util.a.h.Sm(i)) {
                    if (ae.eLk()) {
                        queue = new rx.internal.util.a.q<>(i);
                    } else {
                        queue = new rx.internal.util.atomic.c<>(i);
                    }
                } else {
                    queue = new SpscExactAtomicArrayQueue<>(i);
                }
                this.queue = queue;
            }
            if (!queue.offer(NotificationLite.next(t))) {
                unsubscribe();
                onError(OnErrorThrowable.addValueAsLastCause(new MissingBackpressureException(), t));
            }
        }

        protected void b(T t, long j) {
            try {
                this.child.onNext(t);
                if (j != Long.MAX_VALUE) {
                    this.qqi.produced(1);
                }
                int i = this.qqp + 1;
                if (i == this.qqo) {
                    this.qqp = 0;
                    requestMore(i);
                } else {
                    this.qqp = i;
                }
                synchronized (this) {
                    try {
                        if (!this.missed) {
                            this.emitting = false;
                        } else {
                            this.missed = false;
                            emitLoop();
                        }
                    }
                }
            } catch (Throwable th) {
                if (0 == 0) {
                    synchronized (this) {
                        this.emitting = false;
                    }
                }
                throw th;
            }
        }

        void emit() {
            synchronized (this) {
                if (this.emitting) {
                    this.missed = true;
                    return;
                }
                this.emitting = true;
                emitLoop();
            }
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        /* JADX WARN: Code restructure failed: missing block: B:98:0x014d, code lost:
            r20.lastIndex = r10;
            r20.lastId = r13[r10].id;
         */
        /* JADX WARN: Removed duplicated region for block: B:100:0x015b A[Catch: all -> 0x0075, TryCatch #4 {all -> 0x0075, blocks: (B:3:0x0001, B:4:0x0005, B:7:0x000c, B:15:0x002e, B:45:0x0083, B:53:0x00ad, B:25:0x004c, B:28:0x005d, B:31:0x0065, B:33:0x006b, B:54:0x00b6, B:35:0x0071, B:57:0x00be, B:59:0x00ca, B:70:0x00f3, B:72:0x00f9, B:76:0x0103, B:78:0x0109, B:115:0x017f, B:117:0x0185, B:82:0x0113, B:83:0x011b, B:87:0x0129, B:90:0x0131, B:92:0x0137, B:94:0x0142, B:98:0x014d, B:100:0x015b, B:102:0x0163, B:65:0x00d8, B:111:0x0176, B:114:0x017b, B:67:0x00e2, B:103:0x0164, B:105:0x016a, B:106:0x0170, B:134:0x01bb, B:135:0x01bf, B:46:0x0087, B:118:0x0189), top: B:143:0x0001 }] */
        /* JADX WARN: Removed duplicated region for block: B:141:0x01c8  */
        /* JADX WARN: Removed duplicated region for block: B:150:0x0163 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:155:0x0005 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:57:0x00be A[Catch: all -> 0x0075, TryCatch #4 {all -> 0x0075, blocks: (B:3:0x0001, B:4:0x0005, B:7:0x000c, B:15:0x002e, B:45:0x0083, B:53:0x00ad, B:25:0x004c, B:28:0x005d, B:31:0x0065, B:33:0x006b, B:54:0x00b6, B:35:0x0071, B:57:0x00be, B:59:0x00ca, B:70:0x00f3, B:72:0x00f9, B:76:0x0103, B:78:0x0109, B:115:0x017f, B:117:0x0185, B:82:0x0113, B:83:0x011b, B:87:0x0129, B:90:0x0131, B:92:0x0137, B:94:0x0142, B:98:0x014d, B:100:0x015b, B:102:0x0163, B:65:0x00d8, B:111:0x0176, B:114:0x017b, B:67:0x00e2, B:103:0x0164, B:105:0x016a, B:106:0x0170, B:134:0x01bb, B:135:0x01bf, B:46:0x0087, B:118:0x0189), top: B:143:0x0001 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void emitLoop() {
            int i;
            boolean z;
            int length;
            boolean z2;
            int i2;
            Object obj;
            try {
                rx.j<? super T> jVar = this.child;
                while (!checkTerminate()) {
                    Queue<Object> queue = this.queue;
                    long j = this.qqi.get();
                    boolean z3 = j == Long.MAX_VALUE;
                    int i3 = 0;
                    if (queue != null) {
                        do {
                            int i4 = 0;
                            obj = null;
                            while (j > 0) {
                                obj = queue.poll();
                                if (!checkTerminate()) {
                                    if (obj == null) {
                                        break;
                                    }
                                    jVar.onNext((Object) NotificationLite.getValue(obj));
                                    i3++;
                                    i4++;
                                    j--;
                                } else {
                                    return;
                                }
                            }
                            if (i4 > 0) {
                                if (z3) {
                                    j = Long.MAX_VALUE;
                                } else {
                                    j = this.qqi.produced(i4);
                                }
                            }
                            if (j != 0) {
                            }
                        } while (obj != null);
                        i = i3;
                        z = this.done;
                        Queue<Object> queue2 = this.queue;
                        c<?>[] cVarArr = this.qqm;
                        length = cVarArr.length;
                        if (!z && ((queue2 == null || queue2.isEmpty()) && length == 0)) {
                            ConcurrentLinkedQueue<Throwable> concurrentLinkedQueue = this.qqk;
                            if (concurrentLinkedQueue == null || concurrentLinkedQueue.isEmpty()) {
                                jVar.onCompleted();
                                return;
                            } else {
                                eKK();
                                return;
                            }
                        }
                        boolean z4 = false;
                        if (length > 0) {
                            z2 = false;
                            i2 = i;
                        } else {
                            long j2 = this.lastId;
                            int i5 = this.lastIndex;
                            if (length <= i5 || cVarArr[i5].id != j2) {
                                if (length <= i5) {
                                    i5 = 0;
                                }
                                for (int i6 = 0; i6 < length && cVarArr[i5].id != j2; i6++) {
                                    i5++;
                                    if (i5 == length) {
                                        i5 = 0;
                                    }
                                }
                                this.lastIndex = i5;
                                this.lastId = cVarArr[i5].id;
                            }
                            int i7 = 0;
                            int i8 = i5;
                            while (true) {
                                if (i7 >= length) {
                                    z2 = z4;
                                    i2 = i;
                                    break;
                                } else if (!checkTerminate()) {
                                    c<?> cVar = cVarArr[i8];
                                    Object obj2 = null;
                                    do {
                                        int i9 = 0;
                                        while (j > 0) {
                                            if (!checkTerminate()) {
                                                rx.internal.util.g gVar = cVar.qqg;
                                                if (gVar == null || (obj2 = gVar.poll()) == null) {
                                                    break;
                                                }
                                                jVar.onNext((Object) NotificationLite.getValue(obj2));
                                                j--;
                                                i9++;
                                            } else {
                                                return;
                                            }
                                        }
                                        if (i9 > 0) {
                                            if (!z3) {
                                                j = this.qqi.produced(i9);
                                            } else {
                                                j = Long.MAX_VALUE;
                                            }
                                            cVar.requestMore(i9);
                                        }
                                        if (j == 0) {
                                            break;
                                        }
                                    } while (obj2 != null);
                                    boolean z5 = cVar.done;
                                    rx.internal.util.g gVar2 = cVar.qqg;
                                    if (z5 && (gVar2 == null || gVar2.isEmpty())) {
                                        b(cVar);
                                        if (!checkTerminate()) {
                                            i++;
                                            z4 = true;
                                        } else {
                                            return;
                                        }
                                    }
                                    if (j == 0) {
                                        z2 = z4;
                                        i2 = i;
                                        break;
                                    }
                                    int i10 = i8 + 1;
                                    if (i10 == length) {
                                        i10 = 0;
                                    }
                                    i7++;
                                    i8 = i10;
                                } else {
                                    return;
                                }
                            }
                        }
                        if (i2 > 0) {
                            request(i2);
                        }
                        if (z2) {
                            synchronized (this) {
                                if (!this.missed) {
                                    this.emitting = false;
                                    return;
                                }
                                this.missed = false;
                            }
                        }
                    }
                    i = i3;
                    z = this.done;
                    Queue<Object> queue22 = this.queue;
                    c<?>[] cVarArr2 = this.qqm;
                    length = cVarArr2.length;
                    if (!z) {
                    }
                    boolean z42 = false;
                    if (length > 0) {
                    }
                    if (i2 > 0) {
                    }
                    if (z2) {
                    }
                }
            } catch (Throwable th) {
                if (0 == 0) {
                    synchronized (this) {
                        this.emitting = false;
                    }
                }
                throw th;
            }
        }

        boolean checkTerminate() {
            if (this.child.isUnsubscribed()) {
                return true;
            }
            ConcurrentLinkedQueue<Throwable> concurrentLinkedQueue = this.qqk;
            if (!this.delayErrors && concurrentLinkedQueue != null && !concurrentLinkedQueue.isEmpty()) {
                try {
                    eKK();
                    return true;
                } finally {
                    unsubscribe();
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public static final class c<T> extends rx.j<T> {
        static final int LIMIT = rx.internal.util.g.SIZE / 4;
        volatile boolean done;
        final long id;
        final d<T> qqf;
        volatile rx.internal.util.g qqg;
        int qqh;

        public c(d<T> dVar, long j) {
            this.qqf = dVar;
            this.id = j;
        }

        @Override // rx.j
        public void onStart() {
            this.qqh = rx.internal.util.g.SIZE;
            request(rx.internal.util.g.SIZE);
        }

        @Override // rx.e
        public void onNext(T t) {
            this.qqf.a(this, t);
        }

        @Override // rx.e
        public void onError(Throwable th) {
            this.done = true;
            this.qqf.eKH().offer(th);
            this.qqf.emit();
        }

        @Override // rx.e
        public void onCompleted() {
            this.done = true;
            this.qqf.emit();
        }

        public void requestMore(long j) {
            int i = this.qqh - ((int) j);
            if (i > LIMIT) {
                this.qqh = i;
                return;
            }
            this.qqh = rx.internal.util.g.SIZE;
            int i2 = rx.internal.util.g.SIZE - i;
            if (i2 > 0) {
                request(i2);
            }
        }
    }
}
