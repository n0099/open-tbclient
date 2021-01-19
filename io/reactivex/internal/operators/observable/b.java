package io.reactivex.internal.operators.observable;

import io.reactivex.b.h;
import io.reactivex.t;
import io.reactivex.u;
/* loaded from: classes5.dex */
public final class b<T, U> extends io.reactivex.internal.operators.observable.a<T, U> {
    final h<? super T, ? extends U> qfr;

    public b(t<T> tVar, h<? super T, ? extends U> hVar) {
        super(tVar);
        this.qfr = hVar;
    }

    @Override // io.reactivex.q
    public void a(u<? super U> uVar) {
        this.source.subscribe(new a(uVar, this.qfr));
    }

    /* loaded from: classes5.dex */
    static final class a<T, U> extends io.reactivex.internal.observers.a<T, U> {
        final h<? super T, ? extends U> mapper;

        a(u<? super U> uVar, h<? super T, ? extends U> hVar) {
            super(uVar);
            this.mapper = hVar;
        }

        @Override // io.reactivex.u
        public void onNext(T t) {
            if (!this.done) {
                if (this.sourceMode != 0) {
                    this.actual.onNext(null);
                    return;
                }
                try {
                    this.actual.onNext(io.reactivex.internal.functions.a.m(this.mapper.apply(t), "The mapper function returned a null value."));
                } catch (Throwable th) {
                    P(th);
                }
            }
        }

        @Override // io.reactivex.internal.a.c
        public int requestFusion(int i) {
            return RO(i);
        }

        @Override // io.reactivex.internal.a.f
        public U poll() throws Exception {
            T poll = this.qdJ.poll();
            if (poll != null) {
                return (U) io.reactivex.internal.functions.a.m(this.mapper.apply(poll), "The mapper function returned a null value.");
            }
            return null;
        }
    }
}
