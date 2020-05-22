package rx.internal.operators;

import android.support.v7.widget.ActivityChooserView;
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
/* loaded from: classes6.dex */
public final class OperatorMerge<T> implements d.b<T, rx.d<? extends T>> {
    final boolean delayErrors;
    final int nFU;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class a {
        static final OperatorMerge<Object> nGj = new OperatorMerge<>(true, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class b {
        static final OperatorMerge<Object> nGj = new OperatorMerge<>(false, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public static <T> OperatorMerge<T> xj(boolean z) {
        return z ? (OperatorMerge<T>) a.nGj : (OperatorMerge<T>) b.nGj;
    }

    OperatorMerge(boolean z, int i) {
        this.delayErrors = z;
        this.nFU = i;
    }

    public rx.j<rx.d<? extends T>> call(rx.j<? super T> jVar) {
        d dVar = new d(jVar, this.delayErrors, this.nFU);
        MergeProducer<T> mergeProducer = new MergeProducer<>(dVar);
        dVar.nGn = mergeProducer;
        jVar.add(dVar);
        jVar.setProducer(mergeProducer);
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
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
    /* loaded from: classes6.dex */
    public static final class d<T> extends rx.j<rx.d<? extends T>> {
        static final c<?>[] nGs = new c[0];
        final rx.j<? super T> child;
        final boolean delayErrors;
        volatile boolean done;
        boolean emitting;
        long lastId;
        int lastIndex;
        boolean missed;
        final int nFU;
        MergeProducer<T> nGn;
        volatile rx.subscriptions.b nGo;
        volatile ConcurrentLinkedQueue<Throwable> nGp;
        final Object nGq = new Object();
        volatile c<?>[] nGr = nGs;
        final int nGt;
        int nGu;
        volatile Queue<Object> queue;
        long uniqueId;

        public d(rx.j<? super T> jVar, boolean z, int i) {
            this.child = jVar;
            this.delayErrors = z;
            this.nFU = i;
            if (i == Integer.MAX_VALUE) {
                this.nGt = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                request(Long.MAX_VALUE);
                return;
            }
            this.nGt = Math.max(1, i >> 1);
            request(i);
        }

        Queue<Throwable> dPG() {
            ConcurrentLinkedQueue<Throwable> concurrentLinkedQueue = this.nGp;
            if (concurrentLinkedQueue == null) {
                synchronized (this) {
                    concurrentLinkedQueue = this.nGp;
                    if (concurrentLinkedQueue == null) {
                        concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
                        this.nGp = concurrentLinkedQueue;
                    }
                }
            }
            return concurrentLinkedQueue;
        }

        rx.subscriptions.b dPH() {
            boolean z;
            rx.subscriptions.b bVar = this.nGo;
            if (bVar == null) {
                synchronized (this) {
                    rx.subscriptions.b bVar2 = this.nGo;
                    if (bVar2 != null) {
                        bVar = bVar2;
                        z = false;
                    } else {
                        rx.subscriptions.b bVar3 = new rx.subscriptions.b();
                        this.nGo = bVar3;
                        bVar = bVar3;
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
                if (dVar == rx.d.dPk()) {
                    dPI();
                } else if (dVar instanceof ScalarSynchronousObservable) {
                    bV(((ScalarSynchronousObservable) dVar).get());
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

        void dPI() {
            int i = this.nGu + 1;
            if (i == this.nGt) {
                this.nGu = 0;
                requestMore(i);
                return;
            }
            this.nGu = i;
        }

        private void dPJ() {
            ArrayList arrayList = new ArrayList(this.nGp);
            if (arrayList.size() == 1) {
                this.child.onError((Throwable) arrayList.get(0));
            } else {
                this.child.onError(new CompositeException(arrayList));
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            dPG().offer(th);
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
            dPH().add(cVar);
            synchronized (this.nGq) {
                c<?>[] cVarArr = this.nGr;
                int length = cVarArr.length;
                c<?>[] cVarArr2 = new c[length + 1];
                System.arraycopy(cVarArr, 0, cVarArr2, 0, length);
                cVarArr2[length] = cVar;
                this.nGr = cVarArr2;
            }
        }

        void b(c<T> cVar) {
            int i = 0;
            rx.internal.util.g gVar = cVar.nGl;
            if (gVar != null) {
                gVar.release();
            }
            this.nGo.a(cVar);
            synchronized (this.nGq) {
                c<?>[] cVarArr = this.nGr;
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
                        this.nGr = nGs;
                        return;
                    }
                    c<?>[] cVarArr2 = new c[length - 1];
                    System.arraycopy(cVarArr, 0, cVarArr2, 0, i);
                    System.arraycopy(cVarArr, i + 1, cVarArr2, i, (length - i) - 1);
                    this.nGr = cVarArr2;
                }
            }
        }

        void a(c<T> cVar, T t) {
            boolean z = false;
            long j = this.nGn.get();
            if (j != 0) {
                synchronized (this) {
                    j = this.nGn.get();
                    if (!this.emitting && j != 0) {
                        this.emitting = true;
                        z = true;
                    }
                }
            }
            if (z) {
                rx.internal.util.g gVar = cVar.nGl;
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
            rx.internal.util.g gVar = cVar.nGl;
            if (gVar == null) {
                gVar = rx.internal.util.g.dPY();
                cVar.add(gVar);
                cVar.nGl = gVar;
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
                        this.nGn.produced(1);
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

        void bV(T t) {
            boolean z = false;
            long j = this.nGn.get();
            if (j != 0) {
                synchronized (this) {
                    j = this.nGn.get();
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
                bW(t);
                emitLoop();
                return;
            }
            bW(t);
            emit();
        }

        protected void bW(T t) {
            Queue<Object> queue = this.queue;
            if (queue == null) {
                int i = this.nFU;
                if (i == Integer.MAX_VALUE) {
                    queue = new rx.internal.util.atomic.f<>(rx.internal.util.g.SIZE);
                } else if (rx.internal.util.a.h.Kl(i)) {
                    if (ae.dQh()) {
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
                    this.nGn.produced(1);
                }
                int i = this.nGu + 1;
                if (i == this.nGt) {
                    this.nGu = 0;
                    requestMore(i);
                } else {
                    this.nGu = i;
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
        /* JADX WARN: Removed duplicated region for block: B:103:0x0172 A[Catch: all -> 0x0078, TryCatch #3 {all -> 0x0078, blocks: (B:3:0x0001, B:4:0x0005, B:7:0x000c, B:15:0x002e, B:45:0x0086, B:53:0x00b2, B:25:0x004d, B:28:0x0060, B:31:0x0068, B:33:0x006e, B:54:0x00bb, B:35:0x0074, B:57:0x00c3, B:59:0x00cf, B:73:0x0104, B:75:0x010a, B:79:0x0114, B:81:0x011a, B:118:0x0198, B:120:0x019e, B:85:0x0124, B:86:0x012c, B:90:0x013a, B:93:0x0146, B:95:0x014c, B:97:0x0159, B:101:0x0164, B:103:0x0172, B:105:0x017a, B:67:0x00e1, B:114:0x018d, B:117:0x0194, B:69:0x00eb, B:121:0x01a2, B:106:0x017b, B:108:0x0181, B:109:0x0187, B:137:0x01d6, B:138:0x01da, B:46:0x008a), top: B:148:0x0001 }] */
        /* JADX WARN: Removed duplicated region for block: B:144:0x01e3  */
        /* JADX WARN: Removed duplicated region for block: B:155:0x017a A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:158:0x0005 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:57:0x00c3 A[Catch: all -> 0x0078, TryCatch #3 {all -> 0x0078, blocks: (B:3:0x0001, B:4:0x0005, B:7:0x000c, B:15:0x002e, B:45:0x0086, B:53:0x00b2, B:25:0x004d, B:28:0x0060, B:31:0x0068, B:33:0x006e, B:54:0x00bb, B:35:0x0074, B:57:0x00c3, B:59:0x00cf, B:73:0x0104, B:75:0x010a, B:79:0x0114, B:81:0x011a, B:118:0x0198, B:120:0x019e, B:85:0x0124, B:86:0x012c, B:90:0x013a, B:93:0x0146, B:95:0x014c, B:97:0x0159, B:101:0x0164, B:103:0x0172, B:105:0x017a, B:67:0x00e1, B:114:0x018d, B:117:0x0194, B:69:0x00eb, B:121:0x01a2, B:106:0x017b, B:108:0x0181, B:109:0x0187, B:137:0x01d6, B:138:0x01da, B:46:0x008a), top: B:148:0x0001 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void emitLoop() {
            long j;
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
                    long j2 = this.nGn.get();
                    boolean z3 = j2 == Long.MAX_VALUE;
                    int i3 = 0;
                    if (queue != null) {
                        do {
                            int i4 = 0;
                            obj = null;
                            while (j2 > 0) {
                                obj = queue.poll();
                                if (!checkTerminate()) {
                                    if (obj == null) {
                                        break;
                                    }
                                    jVar.onNext((Object) NotificationLite.getValue(obj));
                                    j2--;
                                    i4++;
                                    i3++;
                                } else {
                                    return;
                                }
                            }
                            if (i4 > 0) {
                                if (z3) {
                                    j2 = Long.MAX_VALUE;
                                } else {
                                    j2 = this.nGn.produced(i4);
                                }
                            }
                            if (j2 != 0) {
                            }
                        } while (obj != null);
                        j = j2;
                        i = i3;
                        z = this.done;
                        Queue<Object> queue2 = this.queue;
                        c<?>[] cVarArr = this.nGr;
                        length = cVarArr.length;
                        if (!z && ((queue2 == null || queue2.isEmpty()) && length == 0)) {
                            ConcurrentLinkedQueue<Throwable> concurrentLinkedQueue = this.nGp;
                            if (concurrentLinkedQueue == null || concurrentLinkedQueue.isEmpty()) {
                                jVar.onCompleted();
                                return;
                            } else {
                                dPJ();
                                return;
                            }
                        }
                        if (length > 0) {
                            z2 = false;
                            i2 = i;
                        } else {
                            long j3 = this.lastId;
                            int i5 = this.lastIndex;
                            if (length <= i5 || cVarArr[i5].id != j3) {
                                if (length <= i5) {
                                    i5 = 0;
                                }
                                for (int i6 = 0; i6 < length && cVarArr[i5].id != j3; i6++) {
                                    i5++;
                                    if (i5 == length) {
                                        i5 = 0;
                                    }
                                }
                                this.lastIndex = i5;
                                this.lastId = cVarArr[i5].id;
                            }
                            int i7 = i5;
                            int i8 = i;
                            long j4 = j;
                            int i9 = 0;
                            boolean z4 = false;
                            while (true) {
                                if (i9 >= length) {
                                    z2 = z4;
                                    i2 = i8;
                                    break;
                                } else if (!checkTerminate()) {
                                    c<?> cVar = cVarArr[i7];
                                    Object obj2 = null;
                                    do {
                                        int i10 = 0;
                                        while (j4 > 0) {
                                            if (!checkTerminate()) {
                                                rx.internal.util.g gVar = cVar.nGl;
                                                if (gVar == null || (obj2 = gVar.poll()) == null) {
                                                    break;
                                                }
                                                jVar.onNext((Object) NotificationLite.getValue(obj2));
                                                i10++;
                                                j4--;
                                            } else {
                                                return;
                                            }
                                        }
                                        if (i10 > 0) {
                                            if (!z3) {
                                                j4 = this.nGn.produced(i10);
                                            } else {
                                                j4 = Long.MAX_VALUE;
                                            }
                                            cVar.requestMore(i10);
                                        }
                                        if (j4 == 0) {
                                            break;
                                        }
                                    } while (obj2 != null);
                                    boolean z5 = cVar.done;
                                    rx.internal.util.g gVar2 = cVar.nGl;
                                    if (z5 && (gVar2 == null || gVar2.isEmpty())) {
                                        b(cVar);
                                        if (!checkTerminate()) {
                                            i8++;
                                            z4 = true;
                                        } else {
                                            return;
                                        }
                                    }
                                    if (j4 == 0) {
                                        z2 = z4;
                                        i2 = i8;
                                        break;
                                    }
                                    int i11 = i7 + 1;
                                    if (i11 == length) {
                                        i11 = 0;
                                    }
                                    i9++;
                                    i7 = i11;
                                } else {
                                    return;
                                }
                            }
                            this.lastIndex = i7;
                            this.lastId = cVarArr[i7].id;
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
                    j = j2;
                    i = i3;
                    z = this.done;
                    Queue<Object> queue22 = this.queue;
                    c<?>[] cVarArr2 = this.nGr;
                    length = cVarArr2.length;
                    if (!z) {
                    }
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
            ConcurrentLinkedQueue<Throwable> concurrentLinkedQueue = this.nGp;
            if (!this.delayErrors && concurrentLinkedQueue != null && !concurrentLinkedQueue.isEmpty()) {
                try {
                    dPJ();
                    return true;
                } finally {
                    unsubscribe();
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class c<T> extends rx.j<T> {
        static final int LIMIT = rx.internal.util.g.SIZE / 4;
        volatile boolean done;
        final long id;
        final d<T> nGk;
        volatile rx.internal.util.g nGl;
        int nGm;

        public c(d<T> dVar, long j) {
            this.nGk = dVar;
            this.id = j;
        }

        @Override // rx.j
        public void onStart() {
            this.nGm = rx.internal.util.g.SIZE;
            request(rx.internal.util.g.SIZE);
        }

        @Override // rx.e
        public void onNext(T t) {
            this.nGk.a(this, t);
        }

        @Override // rx.e
        public void onError(Throwable th) {
            this.done = true;
            this.nGk.dPG().offer(th);
            this.nGk.emit();
        }

        @Override // rx.e
        public void onCompleted() {
            this.done = true;
            this.nGk.emit();
        }

        public void requestMore(long j) {
            int i = this.nGm - ((int) j);
            if (i > LIMIT) {
                this.nGm = i;
                return;
            }
            this.nGm = rx.internal.util.g.SIZE;
            int i2 = rx.internal.util.g.SIZE - i;
            if (i2 > 0) {
                request(i2);
            }
        }
    }
}
