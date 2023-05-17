package rx.internal.util;

import com.baidu.tieba.z7b;
/* loaded from: classes10.dex */
public final class UtilityFunctions {

    /* loaded from: classes10.dex */
    public enum Identity implements z7b<Object, Object> {
        INSTANCE;

        @Override // com.baidu.tieba.z7b
        public Object call(Object obj) {
            return obj;
        }
    }

    public static <T> z7b<? super T, Boolean> a() {
        return AlwaysTrue.INSTANCE;
    }

    public static <T> z7b<T, T> b() {
        return Identity.INSTANCE;
    }

    /* loaded from: classes10.dex */
    public enum AlwaysFalse implements z7b<Object, Boolean> {
        INSTANCE;

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.z7b
        public Boolean call(Object obj) {
            return Boolean.FALSE;
        }
    }

    /* loaded from: classes10.dex */
    public enum AlwaysTrue implements z7b<Object, Boolean> {
        INSTANCE;

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.z7b
        public Boolean call(Object obj) {
            return Boolean.TRUE;
        }
    }
}
