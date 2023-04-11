package rx.functions;

import com.baidu.tieba.s1b;
import com.baidu.tieba.t1b;
import com.baidu.tieba.u1b;
import rx.exceptions.OnErrorNotImplementedException;
/* loaded from: classes9.dex */
public final class Actions {
    public static final a a = new a();

    /* loaded from: classes9.dex */
    public static final class a<T0, T1, T2, T3, T4, T5, T6, T7, T8> implements s1b, t1b<T0>, u1b<T0, T1> {
        @Override // com.baidu.tieba.s1b
        public void call() {
        }

        @Override // com.baidu.tieba.t1b
        public void call(T0 t0) {
        }

        @Override // com.baidu.tieba.u1b
        public void call(T0 t0, T1 t1) {
        }

        public void call(T0 t0, T1 t1, T2 t2) {
        }

        public void call(T0 t0, T1 t1, T2 t2, T3 t3) {
        }

        public void call(T0 t0, T1 t1, T2 t2, T3 t3, T4 t4) {
        }

        public void call(T0 t0, T1 t1, T2 t2, T3 t3, T4 t4, T5 t5) {
        }

        public void call(T0 t0, T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6) {
        }

        public void call(T0 t0, T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7) {
        }

        public void call(T0 t0, T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8) {
        }

        public void call(Object... objArr) {
        }
    }

    public static <T0, T1, T2, T3, T4, T5, T6, T7, T8> a<T0, T1, T2, T3, T4, T5, T6, T7, T8> a() {
        return a;
    }

    public static t1b<Throwable> b() {
        return NotImplemented.INSTANCE;
    }

    /* loaded from: classes9.dex */
    public enum NotImplemented implements t1b<Throwable> {
        INSTANCE;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.t1b
        public void call(Throwable th) {
            throw new OnErrorNotImplementedException(th);
        }
    }
}
