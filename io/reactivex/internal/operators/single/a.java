package io.reactivex.internal.operators.single;

import io.reactivex.aa;
import io.reactivex.b.h;
import io.reactivex.disposables.b;
import io.reactivex.w;
import io.reactivex.y;
/* loaded from: classes4.dex */
public final class a<T, R> extends w<R> {
    final h<? super T, ? extends R> mapper;
    final aa<? extends T> source;

    @Override // io.reactivex.w
    protected void b(y<? super R> yVar) {
        this.source.a(new C0712a(yVar, this.mapper));
    }

    /* renamed from: io.reactivex.internal.operators.single.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    static final class C0712a<T, R> implements y<T> {
        final y<? super R> mVO;
        final h<? super T, ? extends R> mapper;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0712a(y<? super R> yVar, h<? super T, ? extends R> hVar) {
            this.mVO = yVar;
            this.mapper = hVar;
        }

        @Override // io.reactivex.y
        public void onSubscribe(b bVar) {
            this.mVO.onSubscribe(bVar);
        }

        @Override // io.reactivex.y
        public void onSuccess(T t) {
            try {
                this.mVO.onSuccess(io.reactivex.internal.functions.a.h(this.mapper.apply(t), "The mapper function returned a null value."));
            } catch (Throwable th) {
                io.reactivex.exceptions.a.I(th);
                onError(th);
            }
        }

        @Override // io.reactivex.y
        public void onError(Throwable th) {
            this.mVO.onError(th);
        }
    }
}
