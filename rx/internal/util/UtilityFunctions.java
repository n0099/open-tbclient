package rx.internal.util;

import com.baidu.tieba.ckc;
/* loaded from: classes2.dex */
public final class UtilityFunctions {

    /* loaded from: classes2.dex */
    public enum Identity implements ckc<Object, Object> {
        INSTANCE;

        @Override // com.baidu.tieba.ckc
        public Object call(Object obj) {
            return obj;
        }
    }

    public static <T> ckc<? super T, Boolean> a() {
        return AlwaysTrue.INSTANCE;
    }

    public static <T> ckc<T, T> b() {
        return Identity.INSTANCE;
    }

    /* loaded from: classes2.dex */
    public enum AlwaysFalse implements ckc<Object, Boolean> {
        INSTANCE;

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.ckc
        public Boolean call(Object obj) {
            return Boolean.FALSE;
        }
    }

    /* loaded from: classes2.dex */
    public enum AlwaysTrue implements ckc<Object, Boolean> {
        INSTANCE;

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.ckc
        public Boolean call(Object obj) {
            return Boolean.TRUE;
        }
    }
}
