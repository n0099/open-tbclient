package h.q;

import rx.exceptions.OnErrorNotImplementedException;
/* loaded from: classes8.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final h.e<Object> f72076a = new C1989a();

    /* renamed from: h.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C1989a implements h.e<Object> {
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
        return (h.e<T>) f72076a;
    }
}
