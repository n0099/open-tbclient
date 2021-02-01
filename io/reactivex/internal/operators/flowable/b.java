package io.reactivex.internal.operators.flowable;

import io.reactivex.b.h;
import io.reactivex.g;
import io.reactivex.j;
/* loaded from: classes5.dex */
public final class b<T, U> extends io.reactivex.internal.operators.flowable.a<T, U> {
    final h<? super T, ? extends U> mapper;

    public b(g<T> gVar, h<? super T, ? extends U> hVar) {
        super(gVar);
        this.mapper = hVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.reactivex.g
    public void a(org.a.c<? super U> cVar) {
        if (cVar instanceof io.reactivex.internal.a.a) {
            this.qnW.a((j) new a((io.reactivex.internal.a.a) cVar, this.mapper));
        } else {
            this.qnW.a((j) new C1300b(cVar, this.mapper));
        }
    }

    /* renamed from: io.reactivex.internal.operators.flowable.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    static final class C1300b<T, U> extends io.reactivex.internal.subscribers.b<T, U> {
        final h<? super T, ? extends U> mapper;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C1300b(org.a.c<? super U> cVar, h<? super T, ? extends U> hVar) {
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
                    this.actual.onNext(io.reactivex.internal.functions.a.m(this.mapper.apply(t), "The mapper function returned a null value."));
                } catch (Throwable th) {
                    O(th);
                }
            }
        }

        @Override // io.reactivex.internal.a.c
        public int requestFusion(int i) {
            return Sj(i);
        }

        @Override // io.reactivex.internal.a.f
        public U poll() throws Exception {
            T poll = this.qs.poll();
            if (poll != null) {
                return (U) io.reactivex.internal.functions.a.m(this.mapper.apply(poll), "The mapper function returned a null value.");
            }
            return null;
        }
    }

    /* loaded from: classes5.dex */
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
                    this.actual.onNext(io.reactivex.internal.functions.a.m(this.mapper.apply(t), "The mapper function returned a null value."));
                } catch (Throwable th) {
                    O(th);
                }
            }
        }

        @Override // io.reactivex.internal.a.a
        public boolean tryOnNext(T t) {
            if (this.done) {
                return false;
            }
            try {
                return this.actual.tryOnNext(io.reactivex.internal.functions.a.m(this.mapper.apply(t), "The mapper function returned a null value."));
            } catch (Throwable th) {
                O(th);
                return true;
            }
        }

        @Override // io.reactivex.internal.a.c
        public int requestFusion(int i) {
            return Sj(i);
        }

        @Override // io.reactivex.internal.a.f
        public U poll() throws Exception {
            T poll = this.qs.poll();
            if (poll != null) {
                return (U) io.reactivex.internal.functions.a.m(this.mapper.apply(poll), "The mapper function returned a null value.");
            }
            return null;
        }
    }
}
