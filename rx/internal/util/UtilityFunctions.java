package rx.internal.util;

import com.baidu.tieba.ptb;
/* loaded from: classes2.dex */
public final class UtilityFunctions {

    /* loaded from: classes2.dex */
    public enum Identity implements ptb<Object, Object> {
        INSTANCE;

        @Override // com.baidu.tieba.ptb
        public Object call(Object obj) {
            return obj;
        }
    }

    public static <T> ptb<? super T, Boolean> a() {
        return AlwaysTrue.INSTANCE;
    }

    public static <T> ptb<T, T> b() {
        return Identity.INSTANCE;
    }

    /* loaded from: classes2.dex */
    public enum AlwaysFalse implements ptb<Object, Boolean> {
        INSTANCE;

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.ptb
        public Boolean call(Object obj) {
            return Boolean.FALSE;
        }
    }

    /* loaded from: classes2.dex */
    public enum AlwaysTrue implements ptb<Object, Boolean> {
        INSTANCE;

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.ptb
        public Boolean call(Object obj) {
            return Boolean.TRUE;
        }
    }
}
