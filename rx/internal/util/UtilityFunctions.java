package rx.internal.util;

import com.baidu.tieba.anb;
/* loaded from: classes2.dex */
public final class UtilityFunctions {

    /* loaded from: classes2.dex */
    public enum Identity implements anb<Object, Object> {
        INSTANCE;

        @Override // com.baidu.tieba.anb
        public Object call(Object obj) {
            return obj;
        }
    }

    public static <T> anb<? super T, Boolean> a() {
        return AlwaysTrue.INSTANCE;
    }

    public static <T> anb<T, T> b() {
        return Identity.INSTANCE;
    }

    /* loaded from: classes2.dex */
    public enum AlwaysFalse implements anb<Object, Boolean> {
        INSTANCE;

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.anb
        public Boolean call(Object obj) {
            return Boolean.FALSE;
        }
    }

    /* loaded from: classes2.dex */
    public enum AlwaysTrue implements anb<Object, Boolean> {
        INSTANCE;

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.anb
        public Boolean call(Object obj) {
            return Boolean.TRUE;
        }
    }
}
