package rx.functions;

import com.baidu.tieba.tob;
import com.baidu.tieba.uob;
import com.baidu.tieba.vob;
import rx.exceptions.OnErrorNotImplementedException;
/* loaded from: classes2.dex */
public final class Actions {
    public static final a a = new a();

    /* loaded from: classes2.dex */
    public static final class a<T0, T1, T2, T3, T4, T5, T6, T7, T8> implements tob, uob<T0>, vob<T0, T1> {
        @Override // com.baidu.tieba.tob
        public void call() {
        }

        @Override // com.baidu.tieba.uob
        public void call(T0 t0) {
        }

        @Override // com.baidu.tieba.vob
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

    public static uob<Throwable> b() {
        return NotImplemented.INSTANCE;
    }

    /* loaded from: classes2.dex */
    public enum NotImplemented implements uob<Throwable> {
        INSTANCE;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.uob
        public void call(Throwable th) {
            throw new OnErrorNotImplementedException(th);
        }
    }
}
