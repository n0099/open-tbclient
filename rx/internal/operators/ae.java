package rx.internal.operators;

import rx.d;
/* loaded from: classes2.dex */
public final class ae<T> implements d.b<T, T> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a {
        static final ae<Object> iIv = new ae<>();
    }

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public static <T> ae<T> ceK() {
        return (ae<T>) a.iIv;
    }

    ae() {
    }

    public rx.j<? super T> call(rx.j<? super T> jVar) {
        return jVar;
    }
}
