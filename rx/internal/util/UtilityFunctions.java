package rx.internal.util;

import com.baidu.tieba.p1c;
/* loaded from: classes2.dex */
public final class UtilityFunctions {

    /* loaded from: classes2.dex */
    public enum Identity implements p1c<Object, Object> {
        INSTANCE;

        @Override // com.baidu.tieba.p1c
        public Object call(Object obj) {
            return obj;
        }
    }

    public static <T> p1c<? super T, Boolean> a() {
        return AlwaysTrue.INSTANCE;
    }

    public static <T> p1c<T, T> b() {
        return Identity.INSTANCE;
    }

    /* loaded from: classes2.dex */
    public enum AlwaysFalse implements p1c<Object, Boolean> {
        INSTANCE;

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.p1c
        public Boolean call(Object obj) {
            return Boolean.FALSE;
        }
    }

    /* loaded from: classes2.dex */
    public enum AlwaysTrue implements p1c<Object, Boolean> {
        INSTANCE;

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.p1c
        public Boolean call(Object obj) {
            return Boolean.TRUE;
        }
    }
}
