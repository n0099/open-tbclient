package rx.internal.operators;

import rx.internal.util.UtilityFunctions;
/* loaded from: classes2.dex */
public final class bg {
    static final Object iMa = new Object();

    static <T> rx.d<Object> l(rx.d<T> dVar) {
        return rx.d.concat(dVar, rx.d.just(iMa));
    }

    public static <T> rx.d<Boolean> sequenceEqual(rx.d<? extends T> dVar, rx.d<? extends T> dVar2, final rx.functions.g<? super T, ? super T, Boolean> gVar) {
        return rx.d.zip(l(dVar), l(dVar2), new rx.functions.g<Object, Object, Boolean>() { // from class: rx.internal.operators.bg.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: k */
            public Boolean j(Object obj, Object obj2) {
                boolean z = obj == bg.iMa;
                boolean z2 = obj2 == bg.iMa;
                if (z && z2) {
                    return true;
                }
                if (z || z2) {
                    return false;
                }
                return (Boolean) rx.functions.g.this.j(obj, obj2);
            }
        }).all(UtilityFunctions.cfU());
    }
}
