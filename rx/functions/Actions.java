package rx.functions;

import com.baidu.tieba.vjc;
import com.baidu.tieba.wjc;
import com.baidu.tieba.xjc;
import rx.exceptions.OnErrorNotImplementedException;
/* loaded from: classes2.dex */
public final class Actions {
    public static final a a = new a();

    /* loaded from: classes2.dex */
    public static final class a<T0, T1, T2, T3, T4, T5, T6, T7, T8> implements vjc, wjc<T0>, xjc<T0, T1>, Object<T0, T1, T2> {
        @Override // com.baidu.tieba.xjc
        public void a(T0 t0, T1 t1) {
        }

        public void b(T0 t0, T1 t1, T2 t2, T3 t3) {
        }

        @Override // com.baidu.tieba.vjc
        public void call() {
        }

        @Override // com.baidu.tieba.wjc
        public void call(T0 t0) {
        }
    }

    public static <T0, T1, T2, T3, T4, T5, T6, T7, T8> a<T0, T1, T2, T3, T4, T5, T6, T7, T8> a() {
        return a;
    }

    public static wjc<Throwable> b() {
        return NotImplemented.INSTANCE;
    }

    /* loaded from: classes2.dex */
    public enum NotImplemented implements wjc<Throwable> {
        INSTANCE;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wjc
        public void call(Throwable th) {
            throw new OnErrorNotImplementedException(th);
        }
    }
}
