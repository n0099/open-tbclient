package rx.functions;

import h.n.b;
import h.n.c;
import rx.exceptions.OnErrorNotImplementedException;
/* loaded from: classes8.dex */
public final class Actions {

    /* renamed from: a  reason: collision with root package name */
    public static final a f72472a = new a();

    /* loaded from: classes8.dex */
    public enum NotImplemented implements b<Throwable> {
        INSTANCE;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        public void call(Throwable th) {
            throw new OnErrorNotImplementedException(th);
        }
    }

    /* loaded from: classes8.dex */
    public static final class a<T0, T1, T2, T3, T4, T5, T6, T7, T8> implements h.n.a, b<T0>, c<T0, T1> {
        @Override // h.n.c
        public void a(T0 t0, T1 t1) {
        }

        @Override // h.n.a
        public void call() {
        }

        @Override // h.n.b
        public void call(T0 t0) {
        }
    }

    public static <T0, T1, T2, T3, T4, T5, T6, T7, T8> a<T0, T1, T2, T3, T4, T5, T6, T7, T8> a() {
        return f72472a;
    }

    public static b<Throwable> b() {
        return NotImplemented.INSTANCE;
    }
}
