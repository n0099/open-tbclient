package io.reactivex.internal.operators.flowable;

import io.reactivex.c.h;
import io.reactivex.j;
/* loaded from: classes17.dex */
public final class f<T, U> extends io.reactivex.internal.operators.flowable.a<T, U> {
    final h<? super T, ? extends U> mapper;

    public f(io.reactivex.g<T> gVar, h<? super T, ? extends U> hVar) {
        super(gVar);
        this.mapper = hVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.reactivex.g
    public void a(org.a.c<? super U> cVar) {
        if (cVar instanceof io.reactivex.internal.a.a) {
            this.oLT.a((j) new a((io.reactivex.internal.a.a) cVar, this.mapper));
        } else {
            this.oLT.a((j) new b(cVar, this.mapper));
        }
    }

    /* loaded from: classes17.dex */
    static final class b<T, U> extends io.reactivex.internal.subscribers.b<T, U> {
        final h<? super T, ? extends U> mapper;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(org.a.c<? super U> cVar, h<? super T, ? extends U> hVar) {
            super(cVar);
            this.mapper = hVar;
        }

        @Override // org.a.c
        public void onNext(T t) {
            if (!this.done) {
                if (this.sourceMode != 0) {
                    this.actual.onNext(null);
                    return;
                }
                try {
                    this.actual.onNext(io.reactivex.internal.functions.a.l(this.mapper.apply(t), "The mapper function returned a null value."));
                } catch (Throwable th) {
                    K(th);
                }
            }
        }

        @Override // io.reactivex.internal.a.c
        public int requestFusion(int i) {
            return OX(i);
        }

        @Override // io.reactivex.internal.a.g
        public U poll() throws Exception {
            T poll = this.qs.poll();
            if (poll != null) {
                return (U) io.reactivex.internal.functions.a.l(this.mapper.apply(poll), "The mapper function returned a null value.");
            }
            return null;
        }
    }

    /* loaded from: classes17.dex */
    static final class a<T, U> extends io.reactivex.internal.subscribers.a<T, U> {
        final h<? super T, ? extends U> mapper;

        a(io.reactivex.internal.a.a<? super U> aVar, h<? super T, ? extends U> hVar) {
            super(aVar);
            this.mapper = hVar;
        }

        @Override // org.a.c
        public void onNext(T t) {
            if (!this.done) {
                if (this.sourceMode != 0) {
                    this.actual.onNext(null);
                    return;
                }
                try {
                    this.actual.onNext(io.reactivex.internal.functions.a.l(this.mapper.apply(t), "The mapper function returned a null value."));
                } catch (Throwable th) {
                    K(th);
                }
            }
        }

        @Override // io.reactivex.internal.a.a
        public boolean tryOnNext(T t) {
            if (this.done) {
                return false;
            }
            try {
                return this.actual.tryOnNext(io.reactivex.internal.functions.a.l(this.mapper.apply(t), "The mapper function returned a null value."));
            } catch (Throwable th) {
                K(th);
                return true;
            }
        }

        @Override // io.reactivex.internal.a.c
        public int requestFusion(int i) {
            return OX(i);
        }

        @Override // io.reactivex.internal.a.g
        public U poll() throws Exception {
            T poll = this.qs.poll();
            if (poll != null) {
                return (U) io.reactivex.internal.functions.a.l(this.mapper.apply(poll), "The mapper function returned a null value.");
            }
            return null;
        }
    }
}
