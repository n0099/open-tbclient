package rx.internal.operators;

import com.baidu.tieba.apc;
import com.baidu.tieba.brc;
import com.baidu.tieba.cpc;
import com.baidu.tieba.doc;
import com.baidu.tieba.foc;
import com.baidu.tieba.joc;
import com.baidu.tieba.koc;
import com.baidu.tieba.tsc;
import com.baidu.tieba.vqc;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.CompositeException;
/* loaded from: classes2.dex */
public final class OnSubscribeCombineLatest<T, R> implements doc.a<R> {
    public final doc<? extends T>[] a;
    public final Iterable<? extends doc<? extends T>> b;
    public final apc<? extends R> c;
    public final int d;
    public final boolean e;

    /* loaded from: classes2.dex */
    public static final class LatestCoordinator<T, R> extends AtomicInteger implements foc, koc {
        public static final Object MISSING = new Object();
        public static final long serialVersionUID = 8567835998786448817L;
        public int active;
        public final joc<? super R> actual;
        public final int bufferSize;
        public volatile boolean cancelled;
        public final apc<? extends R> combiner;
        public int complete;
        public final boolean delayError;
        public volatile boolean done;
        public final AtomicReference<Throwable> error;
        public final Object[] latest;
        public final brc<Object> queue;
        public final AtomicLong requested;
        public final a<T, R>[] subscribers;

        @Override // com.baidu.tieba.koc
        public boolean isUnsubscribed() {
            return this.cancelled;
        }

        @Override // com.baidu.tieba.koc
        public void unsubscribe() {
            if (!this.cancelled) {
                this.cancelled = true;
                if (getAndIncrement() == 0) {
                    cancel(this.queue);
                }
            }
        }

        public LatestCoordinator(joc<? super R> jocVar, apc<? extends R> apcVar, int i, int i2, boolean z) {
            this.actual = jocVar;
            this.combiner = apcVar;
            this.bufferSize = i2;
            this.delayError = z;
            Object[] objArr = new Object[i];
            this.latest = objArr;
            Arrays.fill(objArr, MISSING);
            this.subscribers = new a[i];
            this.queue = new brc<>(i2);
            this.requested = new AtomicLong();
            this.error = new AtomicReference<>();
        }

        public void cancel(Queue<?> queue) {
            queue.clear();
            for (a<T, R> aVar : this.subscribers) {
                aVar.unsubscribe();
            }
        }

        @Override // com.baidu.tieba.foc
        public void request(long j) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i >= 0) {
                if (i != 0) {
                    cpc.b(this.requested, j);
                    drain();
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("n >= required but it was " + j);
        }

        public void subscribe(doc<? extends T>[] docVarArr) {
            a<T, R>[] aVarArr = this.subscribers;
            int length = aVarArr.length;
            for (int i = 0; i < length; i++) {
                aVarArr[i] = new a<>(this, i);
            }
            lazySet(0);
            this.actual.b(this);
            this.actual.f(this);
            for (int i2 = 0; i2 < length && !this.cancelled; i2++) {
                docVarArr[i2].F(aVarArr[i2]);
            }
        }

        public boolean checkTerminated(boolean z, boolean z2, joc<?> jocVar, Queue<?> queue, boolean z3) {
            if (this.cancelled) {
                cancel(queue);
                return true;
            } else if (z) {
                if (z3) {
                    if (z2) {
                        Throwable th = this.error.get();
                        if (th != null) {
                            jocVar.onError(th);
                        } else {
                            jocVar.onCompleted();
                        }
                        return true;
                    }
                    return false;
                }
                Throwable th2 = this.error.get();
                if (th2 != null) {
                    cancel(queue);
                    jocVar.onError(th2);
                    return true;
                } else if (z2) {
                    jocVar.onCompleted();
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        public void combine(Object obj, int i) {
            boolean z;
            a<T, R> aVar = this.subscribers[i];
            synchronized (this) {
                int length = this.latest.length;
                Object obj2 = this.latest[i];
                int i2 = this.active;
                if (obj2 == MISSING) {
                    i2++;
                    this.active = i2;
                }
                int i3 = this.complete;
                if (obj == null) {
                    i3++;
                    this.complete = i3;
                } else {
                    this.latest[i] = NotificationLite.e(obj);
                }
                boolean z2 = false;
                if (i2 == length) {
                    z = true;
                } else {
                    z = false;
                }
                if (i3 == length || (obj == null && obj2 == MISSING)) {
                    z2 = true;
                }
                if (!z2) {
                    if (obj != null && z) {
                        this.queue.l(aVar, this.latest.clone());
                    } else if (obj == null && this.error.get() != null && (obj2 == MISSING || !this.delayError)) {
                        this.done = true;
                    }
                } else {
                    this.done = true;
                }
            }
            if (!z && obj != null) {
                aVar.g(1L);
            } else {
                drain();
            }
        }

        /* JADX DEBUG: Type inference failed for r1v13. Raw type applied. Possible types: R, ? super R */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x0093, code lost:
            if (r3 == 0) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x009c, code lost:
            if (r13 == Long.MAX_VALUE) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x009e, code lost:
            com.baidu.tieba.cpc.g(r10, r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x00a1, code lost:
            r12 = addAndGet(-r12);
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x00a6, code lost:
            if (r12 != 0) goto L6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x00a8, code lost:
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void drain() {
            long j;
            boolean z;
            if (getAndIncrement() != 0) {
                return;
            }
            brc<Object> brcVar = this.queue;
            joc<? super R> jocVar = this.actual;
            boolean z2 = this.delayError;
            AtomicLong atomicLong = this.requested;
            int i = 1;
            while (!checkTerminated(this.done, brcVar.isEmpty(), jocVar, brcVar, z2)) {
                long j2 = atomicLong.get();
                long j3 = 0;
                while (true) {
                    if (j3 != j2) {
                        boolean z3 = this.done;
                        a aVar = (a) brcVar.peek();
                        if (aVar == null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        long j4 = j3;
                        if (checkTerminated(z3, z, jocVar, brcVar, z2)) {
                            return;
                        }
                        if (z) {
                            j = j4;
                            break;
                        }
                        brcVar.poll();
                        Object[] objArr = (Object[]) brcVar.poll();
                        if (objArr == null) {
                            this.cancelled = true;
                            cancel(brcVar);
                            jocVar.onError(new IllegalStateException("Broken queue?! Sender received but not the array."));
                            return;
                        }
                        try {
                            jocVar.onNext((R) this.combiner.call(objArr));
                            aVar.g(1L);
                            j3 = j4 + 1;
                        } catch (Throwable th) {
                            this.cancelled = true;
                            cancel(brcVar);
                            jocVar.onError(th);
                            return;
                        }
                    } else {
                        j = j3;
                        break;
                    }
                }
            }
        }

        public void onError(Throwable th) {
            Throwable th2;
            Throwable th3;
            AtomicReference<Throwable> atomicReference = this.error;
            do {
                th2 = atomicReference.get();
                if (th2 != null) {
                    if (th2 instanceof CompositeException) {
                        ArrayList arrayList = new ArrayList(((CompositeException) th2).getExceptions());
                        arrayList.add(th);
                        th3 = new CompositeException(arrayList);
                    } else {
                        th3 = new CompositeException(Arrays.asList(th2, th));
                    }
                } else {
                    th3 = th;
                }
            } while (!atomicReference.compareAndSet(th2, th3));
        }
    }

    /* loaded from: classes2.dex */
    public static final class a<T, R> extends joc<T> {
        public final LatestCoordinator<T, R> e;
        public final int f;
        public boolean g;

        public a(LatestCoordinator<T, R> latestCoordinator, int i) {
            this.e = latestCoordinator;
            this.f = i;
            e(latestCoordinator.bufferSize);
        }

        public void g(long j) {
            e(j);
        }

        @Override // com.baidu.tieba.eoc
        public void onError(Throwable th) {
            if (this.g) {
                tsc.j(th);
                return;
            }
            this.e.onError(th);
            this.g = true;
            this.e.combine(null, this.f);
        }

        @Override // com.baidu.tieba.eoc
        public void onNext(T t) {
            if (this.g) {
                return;
            }
            this.e.combine(NotificationLite.i(t), this.f);
        }

        @Override // com.baidu.tieba.eoc
        public void onCompleted() {
            if (this.g) {
                return;
            }
            this.g = true;
            this.e.combine(null, this.f);
        }
    }

    public OnSubscribeCombineLatest(Iterable<? extends doc<? extends T>> iterable, apc<? extends R> apcVar) {
        this(null, iterable, apcVar, vqc.c, false);
    }

    public OnSubscribeCombineLatest(doc<? extends T>[] docVarArr, Iterable<? extends doc<? extends T>> iterable, apc<? extends R> apcVar, int i, boolean z) {
        this.a = docVarArr;
        this.b = iterable;
        this.c = apcVar;
        this.d = i;
        this.e = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004d  */
    @Override // com.baidu.tieba.roc
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void call(joc<? super R> jocVar) {
        int length;
        int i;
        doc<? extends T>[] docVarArr = this.a;
        if (docVarArr == null) {
            Iterable<? extends doc<? extends T>> iterable = this.b;
            if (iterable instanceof List) {
                List list = (List) iterable;
                docVarArr = (doc[]) list.toArray(new doc[list.size()]);
                length = docVarArr.length;
            } else {
                doc<? extends T>[] docVarArr2 = new doc[8];
                int i2 = 0;
                for (doc<? extends T> docVar : iterable) {
                    if (i2 == docVarArr2.length) {
                        doc<? extends T>[] docVarArr3 = new doc[(i2 >> 2) + i2];
                        System.arraycopy(docVarArr2, 0, docVarArr3, 0, i2);
                        docVarArr2 = docVarArr3;
                    }
                    docVarArr2[i2] = docVar;
                    i2++;
                }
                docVarArr = docVarArr2;
                i = i2;
                if (i != 0) {
                    jocVar.onCompleted();
                    return;
                } else {
                    new LatestCoordinator(jocVar, this.c, i, this.d, this.e).subscribe(docVarArr);
                    return;
                }
            }
        } else {
            length = docVarArr.length;
        }
        i = length;
        if (i != 0) {
        }
    }
}
