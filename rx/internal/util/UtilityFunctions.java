package rx.internal.util;

import com.baidu.tieba.woc;
/* loaded from: classes2.dex */
public final class UtilityFunctions {

    /* loaded from: classes2.dex */
    public enum Identity implements woc<Object, Object> {
        INSTANCE;

        @Override // com.baidu.tieba.woc
        public Object call(Object obj) {
            return obj;
        }
    }

    public static <T> woc<? super T, Boolean> a() {
        return AlwaysTrue.INSTANCE;
    }

    public static <T> woc<T, T> b() {
        return Identity.INSTANCE;
    }

    /* loaded from: classes2.dex */
    public enum AlwaysFalse implements woc<Object, Boolean> {
        INSTANCE;

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.woc
        public Boolean call(Object obj) {
            return Boolean.FALSE;
        }
    }

    /* loaded from: classes2.dex */
    public enum AlwaysTrue implements woc<Object, Boolean> {
        INSTANCE;

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.woc
        public Boolean call(Object obj) {
            return Boolean.TRUE;
        }
    }
}
