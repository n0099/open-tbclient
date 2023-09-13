package rx.internal.util;

import com.baidu.tieba.lbc;
/* loaded from: classes2.dex */
public final class UtilityFunctions {

    /* loaded from: classes2.dex */
    public enum Identity implements lbc<Object, Object> {
        INSTANCE;

        @Override // com.baidu.tieba.lbc
        public Object call(Object obj) {
            return obj;
        }
    }

    public static <T> lbc<? super T, Boolean> a() {
        return AlwaysTrue.INSTANCE;
    }

    public static <T> lbc<T, T> b() {
        return Identity.INSTANCE;
    }

    /* loaded from: classes2.dex */
    public enum AlwaysFalse implements lbc<Object, Boolean> {
        INSTANCE;

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.lbc
        public Boolean call(Object obj) {
            return Boolean.FALSE;
        }
    }

    /* loaded from: classes2.dex */
    public enum AlwaysTrue implements lbc<Object, Boolean> {
        INSTANCE;

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.lbc
        public Boolean call(Object obj) {
            return Boolean.TRUE;
        }
    }
}
