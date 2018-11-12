package rx.internal.operators;

import rx.g;
import rx.internal.operators.cb;
import rx.schedulers.Schedulers;
/* loaded from: classes2.dex */
public class cc<T, U, V> extends cb<T> {
    @Override // rx.internal.operators.cb
    public /* bridge */ /* synthetic */ rx.j call(rx.j jVar) {
        return super.call(jVar);
    }

    public cc(final rx.functions.e<? extends rx.d<U>> eVar, final rx.functions.f<? super T, ? extends rx.d<V>> fVar, rx.d<? extends T> dVar) {
        super(new cb.a<T>() { // from class: rx.internal.operators.cc.1
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // rx.functions.h
            public /* bridge */ /* synthetic */ rx.k a(Object obj, Long l, g.a aVar) {
                return a((cb.c) ((cb.c) obj), l, aVar);
            }

            public rx.k a(final cb.c<T> cVar, final Long l, g.a aVar) {
                if (rx.functions.e.this != null) {
                    try {
                        return ((rx.d) rx.functions.e.this.call()).unsafeSubscribe(new rx.j<U>() { // from class: rx.internal.operators.cc.1.1
                            @Override // rx.e
                            public void onCompleted() {
                                cVar.dD(l.longValue());
                            }

                            @Override // rx.e
                            public void onError(Throwable th) {
                                cVar.onError(th);
                            }

                            @Override // rx.e
                            public void onNext(U u) {
                                cVar.dD(l.longValue());
                            }
                        });
                    } catch (Throwable th) {
                        rx.exceptions.a.a(th, cVar);
                        return rx.subscriptions.e.cdr();
                    }
                }
                return rx.subscriptions.e.cdr();
            }
        }, new cb.b<T>() { // from class: rx.internal.operators.cc.2
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // rx.functions.i
            public /* bridge */ /* synthetic */ rx.k a(Object obj, Long l, Object obj2, g.a aVar) {
                return a((cb.c<Long>) obj, l, (Long) obj2, aVar);
            }

            public rx.k a(final cb.c<T> cVar, final Long l, T t, g.a aVar) {
                try {
                    return ((rx.d) rx.functions.f.this.call(t)).unsafeSubscribe(new rx.j<V>() { // from class: rx.internal.operators.cc.2.1
                        @Override // rx.e
                        public void onCompleted() {
                            cVar.dD(l.longValue());
                        }

                        @Override // rx.e
                        public void onError(Throwable th) {
                            cVar.onError(th);
                        }

                        @Override // rx.e
                        public void onNext(V v) {
                            cVar.dD(l.longValue());
                        }
                    });
                } catch (Throwable th) {
                    rx.exceptions.a.a(th, cVar);
                    return rx.subscriptions.e.cdr();
                }
            }
        }, dVar, Schedulers.immediate());
    }
}
