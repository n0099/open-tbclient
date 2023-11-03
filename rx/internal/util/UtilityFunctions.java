package rx.internal.util;

import com.baidu.tieba.bkc;
/* loaded from: classes2.dex */
public final class UtilityFunctions {

    /* loaded from: classes2.dex */
    public enum Identity implements bkc<Object, Object> {
        INSTANCE;

        @Override // com.baidu.tieba.bkc
        public Object call(Object obj) {
            return obj;
        }
    }

    public static <T> bkc<? super T, Boolean> a() {
        return AlwaysTrue.INSTANCE;
    }

    public static <T> bkc<T, T> b() {
        return Identity.INSTANCE;
    }

    /* loaded from: classes2.dex */
    public enum AlwaysFalse implements bkc<Object, Boolean> {
        INSTANCE;

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.bkc
        public Boolean call(Object obj) {
            return Boolean.FALSE;
        }
    }

    /* loaded from: classes2.dex */
    public enum AlwaysTrue implements bkc<Object, Boolean> {
        INSTANCE;

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.bkc
        public Boolean call(Object obj) {
            return Boolean.TRUE;
        }
    }
}
