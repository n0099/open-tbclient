package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.g;
import rx.internal.operators.p;
/* loaded from: classes4.dex */
public final class o<T> extends p<T> {
    @Override // rx.internal.operators.p
    public /* bridge */ /* synthetic */ rx.j call(rx.j jVar) {
        return super.call(jVar);
    }

    public o(final long j, final TimeUnit timeUnit, rx.d<? extends T> dVar, rx.g gVar) {
        super(new p.a<T>() { // from class: rx.internal.operators.o.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.h
            /* renamed from: a */
            public rx.k b(final p.c<T> cVar, final Long l, g.a aVar) {
                return aVar.a(new rx.functions.a() { // from class: rx.internal.operators.o.1.1
                    @Override // rx.functions.a
                    public void call() {
                        cVar.onTimeout(l.longValue());
                    }
                }, j, timeUnit);
            }
        }, new p.b<T>() { // from class: rx.internal.operators.o.2
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // rx.functions.i
            public /* bridge */ /* synthetic */ rx.k a(Object obj, Long l, Object obj2, g.a aVar) {
                return a((p.c<Long>) obj, l, (Long) obj2, aVar);
            }

            public rx.k a(final p.c<T> cVar, final Long l, T t, g.a aVar) {
                return aVar.a(new rx.functions.a() { // from class: rx.internal.operators.o.2.1
                    @Override // rx.functions.a
                    public void call() {
                        cVar.onTimeout(l.longValue());
                    }
                }, j, timeUnit);
            }
        }, dVar, gVar);
    }
}
