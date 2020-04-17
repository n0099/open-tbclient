package io.reactivex.internal.operators.single;

import io.reactivex.aa;
import io.reactivex.c.h;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.q;
import io.reactivex.u;
import io.reactivex.y;
import java.util.Iterator;
/* loaded from: classes7.dex */
public final class SingleFlatMapIterableObservable<T, R> extends q<R> {
    final h<? super T, ? extends Iterable<? extends R>> mapper;
    final aa<T> source;

    @Override // io.reactivex.q
    protected void a(u<? super R> uVar) {
        this.source.a(new FlatMapIterableObserver(uVar, this.mapper));
    }

    /* loaded from: classes7.dex */
    static final class FlatMapIterableObserver<T, R> extends BasicIntQueueDisposable<R> implements y<T> {
        private static final long serialVersionUID = -8938804753851907758L;
        final u<? super R> actual;
        volatile boolean cancelled;
        io.reactivex.disposables.b d;
        volatile Iterator<? extends R> it;
        final h<? super T, ? extends Iterable<? extends R>> mapper;
        boolean outputFused;

        FlatMapIterableObserver(u<? super R> uVar, h<? super T, ? extends Iterable<? extends R>> hVar) {
            this.actual = uVar;
            this.mapper = hVar;
        }

        @Override // io.reactivex.y
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.d, bVar)) {
                this.d = bVar;
                this.actual.onSubscribe(this);
            }
        }

        /* JADX DEBUG: Type inference failed for r2v3. Raw type applied. Possible types: R, ? super R */
        @Override // io.reactivex.y
        public void onSuccess(T t) {
            u<? super R> uVar = this.actual;
            try {
                Iterator<? extends R> it = this.mapper.apply(t).iterator();
                if (!it.hasNext()) {
                    uVar.onComplete();
                } else if (this.outputFused) {
                    this.it = it;
                    uVar.onNext(null);
                    uVar.onComplete();
                } else {
                    while (!this.cancelled) {
                        try {
                            uVar.onNext((R) it.next());
                            if (!this.cancelled) {
                                try {
                                    if (!it.hasNext()) {
                                        uVar.onComplete();
                                        return;
                                    }
                                } catch (Throwable th) {
                                    io.reactivex.exceptions.a.L(th);
                                    uVar.onError(th);
                                    return;
                                }
                            } else {
                                return;
                            }
                        } catch (Throwable th2) {
                            io.reactivex.exceptions.a.L(th2);
                            uVar.onError(th2);
                            return;
                        }
                    }
                }
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.L(th3);
                this.actual.onError(th3);
            }
        }

        @Override // io.reactivex.y
        public void onError(Throwable th) {
            this.d = DisposableHelper.DISPOSED;
            this.actual.onError(th);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.cancelled = true;
            this.d.dispose();
            this.d = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.internal.a.c
        public int requestFusion(int i) {
            if ((i & 2) != 0) {
                this.outputFused = true;
                return 2;
            }
            return 0;
        }

        @Override // io.reactivex.internal.a.g
        public void clear() {
            this.it = null;
        }

        @Override // io.reactivex.internal.a.g
        public boolean isEmpty() {
            return this.it == null;
        }

        @Override // io.reactivex.internal.a.g
        public R poll() throws Exception {
            Iterator<? extends R> it = this.it;
            if (it != null) {
                R r = (R) io.reactivex.internal.functions.a.h(it.next(), "The iterator returned a null value");
                if (!it.hasNext()) {
                    this.it = null;
                    return r;
                }
                return r;
            }
            return null;
        }
    }
}
