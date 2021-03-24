package rx.internal.util;

import h.n.f;
/* loaded from: classes7.dex */
public final class UtilityFunctions {

    /* loaded from: classes7.dex */
    public enum AlwaysFalse implements f<Object, Boolean> {
        INSTANCE;

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h.n.f
        public Boolean call(Object obj) {
            return Boolean.FALSE;
        }
    }

    /* loaded from: classes7.dex */
    public enum AlwaysTrue implements f<Object, Boolean> {
        INSTANCE;

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h.n.f
        public Boolean call(Object obj) {
            return Boolean.TRUE;
        }
    }

    /* loaded from: classes7.dex */
    public enum Identity implements f<Object, Object> {
        INSTANCE;

        @Override // h.n.f
        public Object call(Object obj) {
            return obj;
        }
    }

    public static <T> f<? super T, Boolean> a() {
        return AlwaysTrue.INSTANCE;
    }

    public static <T> f<T, T> b() {
        return Identity.INSTANCE;
    }
}
