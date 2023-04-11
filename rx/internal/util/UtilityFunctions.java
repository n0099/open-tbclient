package rx.internal.util;

import com.baidu.tieba.x1b;
/* loaded from: classes9.dex */
public final class UtilityFunctions {

    /* loaded from: classes9.dex */
    public enum Identity implements x1b<Object, Object> {
        INSTANCE;

        @Override // com.baidu.tieba.x1b
        public Object call(Object obj) {
            return obj;
        }
    }

    public static <T> x1b<? super T, Boolean> a() {
        return AlwaysTrue.INSTANCE;
    }

    public static <T> x1b<T, T> b() {
        return Identity.INSTANCE;
    }

    /* loaded from: classes9.dex */
    public enum AlwaysFalse implements x1b<Object, Boolean> {
        INSTANCE;

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.x1b
        public Boolean call(Object obj) {
            return Boolean.FALSE;
        }
    }

    /* loaded from: classes9.dex */
    public enum AlwaysTrue implements x1b<Object, Boolean> {
        INSTANCE;

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.x1b
        public Boolean call(Object obj) {
            return Boolean.TRUE;
        }
    }
}
