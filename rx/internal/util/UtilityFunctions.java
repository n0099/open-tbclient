package rx.internal.util;

import com.baidu.tieba.q1c;
/* loaded from: classes2.dex */
public final class UtilityFunctions {

    /* loaded from: classes2.dex */
    public enum Identity implements q1c<Object, Object> {
        INSTANCE;

        @Override // com.baidu.tieba.q1c
        public Object call(Object obj) {
            return obj;
        }
    }

    public static <T> q1c<? super T, Boolean> a() {
        return AlwaysTrue.INSTANCE;
    }

    public static <T> q1c<T, T> b() {
        return Identity.INSTANCE;
    }

    /* loaded from: classes2.dex */
    public enum AlwaysFalse implements q1c<Object, Boolean> {
        INSTANCE;

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.q1c
        public Boolean call(Object obj) {
            return Boolean.FALSE;
        }
    }

    /* loaded from: classes2.dex */
    public enum AlwaysTrue implements q1c<Object, Boolean> {
        INSTANCE;

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.q1c
        public Boolean call(Object obj) {
            return Boolean.TRUE;
        }
    }
}
