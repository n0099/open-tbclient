package rx.internal.util;

import com.baidu.tieba.gsa;
/* loaded from: classes9.dex */
public final class UtilityFunctions {

    /* loaded from: classes9.dex */
    public enum Identity implements gsa<Object, Object> {
        INSTANCE;

        @Override // com.baidu.tieba.gsa
        public Object call(Object obj) {
            return obj;
        }
    }

    public static <T> gsa<? super T, Boolean> a() {
        return AlwaysTrue.INSTANCE;
    }

    public static <T> gsa<T, T> b() {
        return Identity.INSTANCE;
    }

    /* loaded from: classes9.dex */
    public enum AlwaysFalse implements gsa<Object, Boolean> {
        INSTANCE;

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.gsa
        public Boolean call(Object obj) {
            return Boolean.FALSE;
        }
    }

    /* loaded from: classes9.dex */
    public enum AlwaysTrue implements gsa<Object, Boolean> {
        INSTANCE;

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.gsa
        public Boolean call(Object obj) {
            return Boolean.TRUE;
        }
    }
}
