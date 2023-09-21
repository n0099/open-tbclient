package rx.internal.util;

import com.baidu.tieba.ddc;
/* loaded from: classes2.dex */
public final class UtilityFunctions {

    /* loaded from: classes2.dex */
    public enum Identity implements ddc<Object, Object> {
        INSTANCE;

        @Override // com.baidu.tieba.ddc
        public Object call(Object obj) {
            return obj;
        }
    }

    public static <T> ddc<? super T, Boolean> a() {
        return AlwaysTrue.INSTANCE;
    }

    public static <T> ddc<T, T> b() {
        return Identity.INSTANCE;
    }

    /* loaded from: classes2.dex */
    public enum AlwaysFalse implements ddc<Object, Boolean> {
        INSTANCE;

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.ddc
        public Boolean call(Object obj) {
            return Boolean.FALSE;
        }
    }

    /* loaded from: classes2.dex */
    public enum AlwaysTrue implements ddc<Object, Boolean> {
        INSTANCE;

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.ddc
        public Boolean call(Object obj) {
            return Boolean.TRUE;
        }
    }
}
