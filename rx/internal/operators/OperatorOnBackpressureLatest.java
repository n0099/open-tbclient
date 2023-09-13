package rx.internal.operators;

import com.baidu.tieba.sac;
import com.baidu.tieba.tac;
import com.baidu.tieba.uac;
import com.baidu.tieba.yac;
import com.baidu.tieba.zac;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class OperatorOnBackpressureLatest<T> implements sac.b<T, T> {

    /* loaded from: classes2.dex */
    public static final class a {
        public static final OperatorOnBackpressureLatest<Object> a = new OperatorOnBackpressureLatest<>();
    }

    /* loaded from: classes2.dex */
    public static final class LatestEmitter<T> extends AtomicLong implements uac, zac, tac<T> {
        public static final Object EMPTY = new Object();
        public static final long NOT_REQUESTED = -4611686018427387904L;
        public static final long serialVersionUID = -1364393685005146274L;
        public final yac<? super T> child;
        public volatile boolean done;
        public boolean emitting;
        public boolean missed;
        public b<? super T> parent;
        public Throwable terminal;
        public final AtomicReference<Object> value = new AtomicReference<>(EMPTY);

        @Override // com.baidu.tieba.zac
        public boolean isUnsubscribed() {
            if (get() == Long.MIN_VALUE) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.tieba.tac
        public void onCompleted() {
            this.done = true;
            emit();
        }

        @Override // com.baidu.tieba.zac
        public void unsubscribe() {
            if (get() >= 0) {
                getAndSet(Long.MIN_VALUE);
            }
        }

        public LatestEmitter(yac<? super T> yacVar) {
            this.child = yacVar;
            lazySet(-4611686018427387904L);
        }

        @Override // com.baidu.tieba.tac
        public void onError(Throwable th) {
            this.terminal = th;
            this.done = true;
            emit();
        }

        @Override // com.baidu.tieba.tac
        public void onNext(T t) {
            this.value.lazySet(t);
            emit();
        }

        public long produced(long j) {
            long j2;
            long j3;
            do {
                j2 = get();
                if (j2 < 0) {
                    return j2;
                }
                j3 = j2 - j;
            } while (!compareAndSet(j2, j3));
            return j3;
        }

        public void emit() {
            boolean z;
            synchronized (this) {
                boolean z2 = true;
                if (this.emitting) {
                    this.missed = true;
                    return;
                }
                this.emitting = true;
                this.missed = false;
                while (true) {
                    try {
                        long j = get();
                        if (j != Long.MIN_VALUE) {
                            Object obj = this.value.get();
                            if (j > 0 && obj != EMPTY) {
                                this.child.onNext(obj);
                                this.value.compareAndSet(obj, EMPTY);
                                produced(1L);
                                obj = EMPTY;
                            }
                            if (obj == EMPTY && this.done) {
                                Throwable th = this.terminal;
                                if (th != null) {
                                    this.child.onError(th);
                                } else {
                                    this.child.onCompleted();
                                }
                            }
                            try {
                                synchronized (this) {
                                    try {
                                        if (!this.missed) {
                                            this.emitting = false;
                                            return;
                                        }
                                        this.missed = false;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        z2 = false;
                                    }
                                }
                            } catch (Throwable th3) {
                                th = th3;
                            }
                            try {
                                throw th;
                            } catch (Throwable th4) {
                                z = z2;
                                th = th4;
                                if (!z) {
                                    synchronized (this) {
                                        this.emitting = false;
                                    }
                                }
                                throw th;
                            }
                        }
                        return;
                    } catch (Throwable th5) {
                        th = th5;
                        z = false;
                    }
                }
            }
        }

        @Override // com.baidu.tieba.uac
        public void request(long j) {
            long j2;
            int i;
            long j3;
            if (j >= 0) {
                do {
                    j2 = get();
                    if (j2 == Long.MIN_VALUE) {
                        return;
                    }
                    i = (j2 > (-4611686018427387904L) ? 1 : (j2 == (-4611686018427387904L) ? 0 : -1));
                    if (i == 0) {
                        j3 = j;
                    } else {
                        j3 = j2 + j;
                        if (j3 < 0) {
                            j3 = Long.MAX_VALUE;
                        }
                    }
                } while (!compareAndSet(j2, j3));
                if (i == 0) {
                    this.parent.g(Long.MAX_VALUE);
                }
                emit();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class b<T> extends yac<T> {
        public final LatestEmitter<T> e;

        public b(LatestEmitter<T> latestEmitter) {
            this.e = latestEmitter;
        }

        public void g(long j) {
            e(j);
        }

        @Override // com.baidu.tieba.tac
        public void onError(Throwable th) {
            this.e.onError(th);
        }

        @Override // com.baidu.tieba.tac
        public void onNext(T t) {
            this.e.onNext(t);
        }

        @Override // com.baidu.tieba.yac
        public void d() {
            e(0L);
        }

        @Override // com.baidu.tieba.tac
        public void onCompleted() {
            this.e.onCompleted();
        }
    }

    public static <T> OperatorOnBackpressureLatest<T> a() {
        return (OperatorOnBackpressureLatest<T>) a.a;
    }

    public yac<? super T> call(yac<? super T> yacVar) {
        LatestEmitter latestEmitter = new LatestEmitter(yacVar);
        b<? super T> bVar = new b<>(latestEmitter);
        latestEmitter.parent = bVar;
        yacVar.b(bVar);
        yacVar.b(latestEmitter);
        yacVar.f(latestEmitter);
        return bVar;
    }

    @Override // com.baidu.tieba.sac.b, com.baidu.tieba.lbc
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((yac) ((yac) obj));
    }
}
