package rx.internal.util;

import com.baidu.tieba.kna;
/* loaded from: classes9.dex */
public final class UtilityFunctions {

    /* loaded from: classes9.dex */
    public enum Identity implements kna<Object, Object> {
        INSTANCE;

        @Override // com.baidu.tieba.kna
        public Object call(Object obj) {
            return obj;
        }
    }

    public static <T> kna<? super T, Boolean> a() {
        return AlwaysTrue.INSTANCE;
    }

    public static <T> kna<T, T> b() {
        return Identity.INSTANCE;
    }

    /* loaded from: classes9.dex */
    public enum AlwaysFalse implements kna<Object, Boolean> {
        INSTANCE;

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.kna
        public Boolean call(Object obj) {
            return Boolean.FALSE;
        }
    }

    /* loaded from: classes9.dex */
    public enum AlwaysTrue implements kna<Object, Boolean> {
        INSTANCE;

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.kna
        public Boolean call(Object obj) {
            return Boolean.TRUE;
        }
    }
}
