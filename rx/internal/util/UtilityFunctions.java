package rx.internal.util;

import com.baidu.tieba.b6b;
/* loaded from: classes9.dex */
public final class UtilityFunctions {

    /* loaded from: classes9.dex */
    public enum Identity implements b6b<Object, Object> {
        INSTANCE;

        @Override // com.baidu.tieba.b6b
        public Object call(Object obj) {
            return obj;
        }
    }

    public static <T> b6b<? super T, Boolean> a() {
        return AlwaysTrue.INSTANCE;
    }

    public static <T> b6b<T, T> b() {
        return Identity.INSTANCE;
    }

    /* loaded from: classes9.dex */
    public enum AlwaysFalse implements b6b<Object, Boolean> {
        INSTANCE;

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.b6b
        public Boolean call(Object obj) {
            return Boolean.FALSE;
        }
    }

    /* loaded from: classes9.dex */
    public enum AlwaysTrue implements b6b<Object, Boolean> {
        INSTANCE;

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.b6b
        public Boolean call(Object obj) {
            return Boolean.TRUE;
        }
    }
}
