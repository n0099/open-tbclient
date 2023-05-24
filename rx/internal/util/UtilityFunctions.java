package rx.internal.util;

import com.baidu.tieba.a8b;
/* loaded from: classes10.dex */
public final class UtilityFunctions {

    /* loaded from: classes10.dex */
    public enum Identity implements a8b<Object, Object> {
        INSTANCE;

        @Override // com.baidu.tieba.a8b
        public Object call(Object obj) {
            return obj;
        }
    }

    public static <T> a8b<? super T, Boolean> a() {
        return AlwaysTrue.INSTANCE;
    }

    public static <T> a8b<T, T> b() {
        return Identity.INSTANCE;
    }

    /* loaded from: classes10.dex */
    public enum AlwaysFalse implements a8b<Object, Boolean> {
        INSTANCE;

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.a8b
        public Boolean call(Object obj) {
            return Boolean.FALSE;
        }
    }

    /* loaded from: classes10.dex */
    public enum AlwaysTrue implements a8b<Object, Boolean> {
        INSTANCE;

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.a8b
        public Boolean call(Object obj) {
            return Boolean.TRUE;
        }
    }
}
