package io.reactivex.internal.operators.single;

import io.reactivex.aa;
import io.reactivex.b.h;
import io.reactivex.w;
import io.reactivex.y;
/* loaded from: classes6.dex */
public final class a<T, R> extends w<R> {
    final h<? super T, ? extends R> mapper;
    final aa<? extends T> source;

    @Override // io.reactivex.w
    protected void b(y<? super R> yVar) {
        this.source.a(new C1285a(yVar, this.mapper));
    }

    /* renamed from: io.reactivex.internal.operators.single.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    static final class C1285a<T, R> implements y<T> {
        final h<? super T, ? extends R> mapper;
        final y<? super R> qri;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C1285a(y<? super R> yVar, h<? super T, ? extends R> hVar) {
            this.qri = yVar;
            this.mapper = hVar;
        }

        @Override // io.reactivex.y
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            this.qri.onSubscribe(bVar);
        }

        @Override // io.reactivex.y
        public void onSuccess(T t) {
            try {
                this.qri.onSuccess(io.reactivex.internal.functions.a.n(this.mapper.apply(t), "The mapper function returned a null value."));
            } catch (Throwable th) {
                io.reactivex.exceptions.a.N(th);
                onError(th);
            }
        }

        @Override // io.reactivex.y
        public void onError(Throwable th) {
            this.qri.onError(th);
        }
    }
}
