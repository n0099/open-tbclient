package h.q;

import rx.exceptions.OnErrorNotImplementedException;
/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final h.e<Object> f67968a = new C1883a();

    /* renamed from: h.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C1883a implements h.e<Object> {
        @Override // h.e
        public final void onCompleted() {
        }

        @Override // h.e
        public final void onError(Throwable th) {
            throw new OnErrorNotImplementedException(th);
        }

        @Override // h.e
        public final void onNext(Object obj) {
        }
    }

    public static <T> h.e<T> a() {
        return (h.e<T>) f67968a;
    }
}
