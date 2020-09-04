package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.Iterator;
/* loaded from: classes7.dex */
public final class FlowableFromIterable<T> extends io.reactivex.g<T> {
    final Iterable<? extends T> onr;

    @Override // io.reactivex.g
    public void a(org.b.c<? super T> cVar) {
        try {
            a(cVar, this.onr.iterator());
        } catch (Throwable th) {
            io.reactivex.exceptions.a.J(th);
            EmptySubscription.error(th, cVar);
        }
    }

    public static <T> void a(org.b.c<? super T> cVar, Iterator<? extends T> it) {
        try {
            if (!it.hasNext()) {
                EmptySubscription.complete(cVar);
            } else if (cVar instanceof io.reactivex.internal.a.a) {
                cVar.onSubscribe(new IteratorConditionalSubscription((io.reactivex.internal.a.a) cVar, it));
            } else {
                cVar.onSubscribe(new IteratorSubscription(cVar, it));
            }
        } catch (Throwable th) {
            io.reactivex.exceptions.a.J(th);
            EmptySubscription.error(th, cVar);
        }
    }

    /* loaded from: classes7.dex */
    static abstract class BaseRangeSubscription<T> extends BasicQueueSubscription<T> {
        private static final long serialVersionUID = -2252972430506210021L;
        volatile boolean cancelled;
        Iterator<? extends T> it;
        boolean once;

        abstract void fastPath();

        abstract void slowPath(long j);

        BaseRangeSubscription(Iterator<? extends T> it) {
            this.it = it;
        }

        @Override // io.reactivex.internal.a.c
        public final int requestFusion(int i) {
            return i & 1;
        }

        @Override // io.reactivex.internal.a.g
        public final T poll() {
            if (this.it == null) {
                return null;
            }
            if (!this.once) {
                this.once = true;
            } else if (!this.it.hasNext()) {
                return null;
            }
            return (T) io.reactivex.internal.functions.a.k(this.it.next(), "Iterator.next() returned a null value");
        }

        @Override // io.reactivex.internal.a.g
        public final boolean isEmpty() {
            return this.it == null || !this.it.hasNext();
        }

        @Override // io.reactivex.internal.a.g
        public final void clear() {
            this.it = null;
        }

        @Override // org.b.d
        public final void request(long j) {
            if (SubscriptionHelper.validate(j) && io.reactivex.internal.util.b.a(this, j) == 0) {
                if (j == Long.MAX_VALUE) {
                    fastPath();
                } else {
                    slowPath(j);
                }
            }
        }

        @Override // org.b.d
        public final void cancel() {
            this.cancelled = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class IteratorSubscription<T> extends BaseRangeSubscription<T> {
        private static final long serialVersionUID = -6022804456014692607L;
        final org.b.c<? super T> actual;

        IteratorSubscription(org.b.c<? super T> cVar, Iterator<? extends T> it) {
            super(it);
            this.actual = cVar;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableFromIterable.BaseRangeSubscription
        void fastPath() {
            Iterator<? extends T> it = this.it;
            org.b.c<? super T> cVar = this.actual;
            while (!this.cancelled) {
                try {
                    Object obj = (T) it.next();
                    if (!this.cancelled) {
                        if (obj == null) {
                            cVar.onError(new NullPointerException("Iterator.next() returned a null value"));
                            return;
                        }
                        cVar.onNext(obj);
                        if (!this.cancelled) {
                            try {
                                if (!it.hasNext()) {
                                    if (!this.cancelled) {
                                        cVar.onComplete();
                                        return;
                                    }
                                    return;
                                }
                            } catch (Throwable th) {
                                io.reactivex.exceptions.a.J(th);
                                cVar.onError(th);
                                return;
                            }
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.J(th2);
                    cVar.onError(th2);
                    return;
                }
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableFromIterable.BaseRangeSubscription
        void slowPath(long j) {
            Iterator<? extends T> it = this.it;
            org.b.c<? super T> cVar = this.actual;
            long j2 = 0;
            while (true) {
                if (j2 != j) {
                    if (!this.cancelled) {
                        try {
                            Object obj = (T) it.next();
                            if (!this.cancelled) {
                                if (obj == null) {
                                    cVar.onError(new NullPointerException("Iterator.next() returned a null value"));
                                    return;
                                }
                                cVar.onNext(obj);
                                if (!this.cancelled) {
                                    try {
                                        if (!it.hasNext()) {
                                            if (!this.cancelled) {
                                                cVar.onComplete();
                                                return;
                                            }
                                            return;
                                        }
                                        j2++;
                                    } catch (Throwable th) {
                                        io.reactivex.exceptions.a.J(th);
                                        cVar.onError(th);
                                        return;
                                    }
                                } else {
                                    return;
                                }
                            } else {
                                return;
                            }
                        } catch (Throwable th2) {
                            io.reactivex.exceptions.a.J(th2);
                            cVar.onError(th2);
                            return;
                        }
                    } else {
                        return;
                    }
                } else {
                    j = get();
                    if (j2 == j) {
                        j = addAndGet(-j2);
                        if (j == 0) {
                            return;
                        }
                        j2 = 0;
                    } else {
                        continue;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class IteratorConditionalSubscription<T> extends BaseRangeSubscription<T> {
        private static final long serialVersionUID = -6022804456014692607L;
        final io.reactivex.internal.a.a<? super T> actual;

        IteratorConditionalSubscription(io.reactivex.internal.a.a<? super T> aVar, Iterator<? extends T> it) {
            super(it);
            this.actual = aVar;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableFromIterable.BaseRangeSubscription
        void fastPath() {
            Iterator<? extends T> it = this.it;
            io.reactivex.internal.a.a<? super T> aVar = this.actual;
            while (!this.cancelled) {
                try {
                    Object obj = (T) it.next();
                    if (!this.cancelled) {
                        if (obj == null) {
                            aVar.onError(new NullPointerException("Iterator.next() returned a null value"));
                            return;
                        }
                        aVar.tryOnNext(obj);
                        if (!this.cancelled) {
                            try {
                                if (!it.hasNext()) {
                                    if (!this.cancelled) {
                                        aVar.onComplete();
                                        return;
                                    }
                                    return;
                                }
                            } catch (Throwable th) {
                                io.reactivex.exceptions.a.J(th);
                                aVar.onError(th);
                                return;
                            }
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.J(th2);
                    aVar.onError(th2);
                    return;
                }
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableFromIterable.BaseRangeSubscription
        void slowPath(long j) {
            Iterator<? extends T> it = this.it;
            io.reactivex.internal.a.a<? super T> aVar = this.actual;
            long j2 = 0;
            while (true) {
                if (j2 != j) {
                    if (!this.cancelled) {
                        try {
                            Object obj = (T) it.next();
                            if (!this.cancelled) {
                                if (obj == null) {
                                    aVar.onError(new NullPointerException("Iterator.next() returned a null value"));
                                    return;
                                }
                                boolean tryOnNext = aVar.tryOnNext(obj);
                                if (!this.cancelled) {
                                    try {
                                        if (!it.hasNext()) {
                                            if (!this.cancelled) {
                                                aVar.onComplete();
                                                return;
                                            }
                                            return;
                                        } else if (tryOnNext) {
                                            j2++;
                                        }
                                    } catch (Throwable th) {
                                        io.reactivex.exceptions.a.J(th);
                                        aVar.onError(th);
                                        return;
                                    }
                                } else {
                                    return;
                                }
                            } else {
                                return;
                            }
                        } catch (Throwable th2) {
                            io.reactivex.exceptions.a.J(th2);
                            aVar.onError(th2);
                            return;
                        }
                    } else {
                        return;
                    }
                } else {
                    j = get();
                    if (j2 == j) {
                        j = addAndGet(-j2);
                        if (j == 0) {
                            return;
                        }
                        j2 = 0;
                    } else {
                        continue;
                    }
                }
            }
        }
    }
}
