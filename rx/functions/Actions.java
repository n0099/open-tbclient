package rx.functions;

import rx.exceptions.OnErrorNotImplementedException;
/* loaded from: classes2.dex */
public final class Actions {
    private static final b knk = new b();

    public static <T0, T1, T2, T3, T4, T5, T6, T7, T8> b<T0, T1, T2, T3, T4, T5, T6, T7, T8> cLu() {
        return knk;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class b<T0, T1, T2, T3, T4, T5, T6, T7, T8> implements rx.functions.a, rx.functions.b<T0>, c<T0, T1> {
        b() {
        }

        @Override // rx.functions.a
        public void call() {
        }

        @Override // rx.functions.b
        public void call(T0 t0) {
        }

        @Override // rx.functions.c
        public void i(T0 t0, T1 t1) {
        }
    }

    public static <T> rx.functions.b<T> e(rx.functions.a aVar) {
        return new a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a<T> implements rx.functions.b<T> {
        final rx.functions.a action;

        public a(rx.functions.a aVar) {
            this.action = aVar;
        }

        @Override // rx.functions.b
        public void call(T t) {
            this.action.call();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public enum NotImplemented implements rx.functions.b<Throwable> {
        INSTANCE;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.functions.b
        public void call(Throwable th) {
            throw new OnErrorNotImplementedException(th);
        }
    }

    public static rx.functions.b<Throwable> cLv() {
        return NotImplemented.INSTANCE;
    }
}
