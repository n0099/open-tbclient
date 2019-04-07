package rx.internal.util;
/* loaded from: classes2.dex */
public final class UtilityFunctions {
    public static <T> rx.functions.f<? super T, Boolean> cEy() {
        return AlwaysTrue.INSTANCE;
    }

    public static <T> rx.functions.f<T, T> cEz() {
        return Identity.INSTANCE;
    }

    /* loaded from: classes2.dex */
    enum AlwaysTrue implements rx.functions.f<Object, Boolean> {
        INSTANCE;

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // rx.functions.f
        public Boolean call(Object obj) {
            return true;
        }
    }

    /* loaded from: classes2.dex */
    enum AlwaysFalse implements rx.functions.f<Object, Boolean> {
        INSTANCE;

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // rx.functions.f
        public Boolean call(Object obj) {
            return false;
        }
    }

    /* loaded from: classes2.dex */
    enum Identity implements rx.functions.f<Object, Object> {
        INSTANCE;

        @Override // rx.functions.f
        public Object call(Object obj) {
            return obj;
        }
    }
}
