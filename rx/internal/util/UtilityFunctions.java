package rx.internal.util;

import com.baidu.tieba.m2c;
/* loaded from: classes2.dex */
public final class UtilityFunctions {

    /* loaded from: classes2.dex */
    public enum Identity implements m2c<Object, Object> {
        INSTANCE;

        @Override // com.baidu.tieba.m2c
        public Object call(Object obj) {
            return obj;
        }
    }

    public static <T> m2c<? super T, Boolean> a() {
        return AlwaysTrue.INSTANCE;
    }

    public static <T> m2c<T, T> b() {
        return Identity.INSTANCE;
    }

    /* loaded from: classes2.dex */
    public enum AlwaysFalse implements m2c<Object, Boolean> {
        INSTANCE;

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.m2c
        public Boolean call(Object obj) {
            return Boolean.FALSE;
        }
    }

    /* loaded from: classes2.dex */
    public enum AlwaysTrue implements m2c<Object, Boolean> {
        INSTANCE;

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.m2c
        public Boolean call(Object obj) {
            return Boolean.TRUE;
        }
    }
}
