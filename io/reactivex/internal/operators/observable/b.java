package io.reactivex.internal.operators.observable;

import io.reactivex.c.h;
import io.reactivex.t;
import io.reactivex.u;
/* loaded from: classes7.dex */
public final class b<T, U> extends io.reactivex.internal.operators.observable.a<T, U> {
    final h<? super T, ? extends U> nxW;

    public b(t<T> tVar, h<? super T, ? extends U> hVar) {
        super(tVar);
        this.nxW = hVar;
    }

    @Override // io.reactivex.q
    public void a(u<? super U> uVar) {
        this.source.subscribe(new a(uVar, this.nxW));
    }

    /* loaded from: classes7.dex */
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
                    this.actual.onNext(io.reactivex.internal.functions.a.h(this.mapper.apply(t), "The mapper function returned a null value."));
                } catch (Throwable th) {
                    I(th);
                }
            }
        }

        @Override // io.reactivex.internal.a.c
        public int requestFusion(int i) {
            return Nv(i);
        }

        @Override // io.reactivex.internal.a.g
        public U poll() throws Exception {
            T poll = this.nwk.poll();
            if (poll != null) {
                return (U) io.reactivex.internal.functions.a.h(this.mapper.apply(poll), "The mapper function returned a null value.");
            }
            return null;
        }
    }
}
