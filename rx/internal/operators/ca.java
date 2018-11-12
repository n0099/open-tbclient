package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.g;
import rx.internal.operators.cb;
/* loaded from: classes2.dex */
public final class ca<T> extends cb<T> {
    @Override // rx.internal.operators.cb
    public /* bridge */ /* synthetic */ rx.j call(rx.j jVar) {
        return super.call(jVar);
    }

    public ca(final long j, final TimeUnit timeUnit, rx.d<? extends T> dVar, rx.g gVar) {
        super(new cb.a<T>() { // from class: rx.internal.operators.ca.1
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // rx.functions.h
            public /* bridge */ /* synthetic */ rx.k a(Object obj, Long l, g.a aVar) {
                return a((cb.c) ((cb.c) obj), l, aVar);
            }

            public rx.k a(final cb.c<T> cVar, final Long l, g.a aVar) {
                return aVar.a(new rx.functions.a() { // from class: rx.internal.operators.ca.1.1
                    @Override // rx.functions.a
                    public void call() {
                        cVar.dD(l.longValue());
                    }
                }, j, timeUnit);
            }
        }, new cb.b<T>() { // from class: rx.internal.operators.ca.2
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // rx.functions.i
            public /* bridge */ /* synthetic */ rx.k a(Object obj, Long l, Object obj2, g.a aVar) {
                return a((cb.c<Long>) obj, l, (Long) obj2, aVar);
            }

            public rx.k a(final cb.c<T> cVar, final Long l, T t, g.a aVar) {
                return aVar.a(new rx.functions.a() { // from class: rx.internal.operators.ca.2.1
                    @Override // rx.functions.a
                    public void call() {
                        cVar.dD(l.longValue());
                    }
                }, j, timeUnit);
            }
        }, dVar, gVar);
    }
}
