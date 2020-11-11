package io.reactivex.internal.operators.single;

import io.reactivex.aa;
import io.reactivex.c.h;
import io.reactivex.w;
import io.reactivex.y;
/* loaded from: classes17.dex */
public final class a<T, R> extends w<R> {
    final h<? super T, ? extends R> mapper;
    final aa<? extends T> source;

    @Override // io.reactivex.w
    protected void b(y<? super R> yVar) {
        this.source.a(new C1072a(yVar, this.mapper));
    }

    /* renamed from: io.reactivex.internal.operators.single.a$a  reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    static final class C1072a<T, R> implements y<T> {
        final h<? super T, ? extends R> mapper;
        final y<? super R> pOZ;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C1072a(y<? super R> yVar, h<? super T, ? extends R> hVar) {
            this.pOZ = yVar;
            this.mapper = hVar;
        }

        @Override // io.reactivex.y
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            this.pOZ.onSubscribe(bVar);
        }

        @Override // io.reactivex.y
        public void onSuccess(T t) {
            try {
                this.pOZ.onSuccess(io.reactivex.internal.functions.a.l(this.mapper.apply(t), "The mapper function returned a null value."));
            } catch (Throwable th) {
                io.reactivex.exceptions.a.J(th);
                onError(th);
            }
        }

        @Override // io.reactivex.y
        public void onError(Throwable th) {
            this.pOZ.onError(th);
        }
    }
}
