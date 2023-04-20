package rx.internal.util;

import com.baidu.tieba.f2b;
/* loaded from: classes9.dex */
public final class UtilityFunctions {

    /* loaded from: classes9.dex */
    public enum Identity implements f2b<Object, Object> {
        INSTANCE;

        @Override // com.baidu.tieba.f2b
        public Object call(Object obj) {
            return obj;
        }
    }

    public static <T> f2b<? super T, Boolean> a() {
        return AlwaysTrue.INSTANCE;
    }

    public static <T> f2b<T, T> b() {
        return Identity.INSTANCE;
    }

    /* loaded from: classes9.dex */
    public enum AlwaysFalse implements f2b<Object, Boolean> {
        INSTANCE;

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.f2b
        public Boolean call(Object obj) {
            return Boolean.FALSE;
        }
    }

    /* loaded from: classes9.dex */
    public enum AlwaysTrue implements f2b<Object, Boolean> {
        INSTANCE;

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.f2b
        public Boolean call(Object obj) {
            return Boolean.TRUE;
        }
    }
}
