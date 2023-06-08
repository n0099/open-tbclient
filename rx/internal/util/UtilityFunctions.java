package rx.internal.util;

import com.baidu.tieba.fnb;
/* loaded from: classes2.dex */
public final class UtilityFunctions {

    /* loaded from: classes2.dex */
    public enum Identity implements fnb<Object, Object> {
        INSTANCE;

        @Override // com.baidu.tieba.fnb
        public Object call(Object obj) {
            return obj;
        }
    }

    public static <T> fnb<? super T, Boolean> a() {
        return AlwaysTrue.INSTANCE;
    }

    public static <T> fnb<T, T> b() {
        return Identity.INSTANCE;
    }

    /* loaded from: classes2.dex */
    public enum AlwaysFalse implements fnb<Object, Boolean> {
        INSTANCE;

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.fnb
        public Boolean call(Object obj) {
            return Boolean.FALSE;
        }
    }

    /* loaded from: classes2.dex */
    public enum AlwaysTrue implements fnb<Object, Boolean> {
        INSTANCE;

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.fnb
        public Boolean call(Object obj) {
            return Boolean.TRUE;
        }
    }
}
