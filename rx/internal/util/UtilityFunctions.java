package rx.internal.util;

import com.baidu.tieba.xoc;
/* loaded from: classes2.dex */
public final class UtilityFunctions {

    /* loaded from: classes2.dex */
    public enum Identity implements xoc<Object, Object> {
        INSTANCE;

        @Override // com.baidu.tieba.xoc
        public Object call(Object obj) {
            return obj;
        }
    }

    public static <T> xoc<? super T, Boolean> a() {
        return AlwaysTrue.INSTANCE;
    }

    public static <T> xoc<T, T> b() {
        return Identity.INSTANCE;
    }

    /* loaded from: classes2.dex */
    public enum AlwaysFalse implements xoc<Object, Boolean> {
        INSTANCE;

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.xoc
        public Boolean call(Object obj) {
            return Boolean.FALSE;
        }
    }

    /* loaded from: classes2.dex */
    public enum AlwaysTrue implements xoc<Object, Boolean> {
        INSTANCE;

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.xoc
        public Boolean call(Object obj) {
            return Boolean.TRUE;
        }
    }
}
