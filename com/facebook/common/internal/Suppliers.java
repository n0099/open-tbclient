package com.facebook.common.internal;
/* loaded from: classes5.dex */
public class Suppliers {
    public static final Supplier<Boolean> BOOLEAN_TRUE = new Supplier<Boolean>() { // from class: com.facebook.common.internal.Suppliers.2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.facebook.common.internal.Supplier
        public Boolean get() {
            return Boolean.TRUE;
        }
    };
    public static final Supplier<Boolean> BOOLEAN_FALSE = new Supplier<Boolean>() { // from class: com.facebook.common.internal.Suppliers.3
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.facebook.common.internal.Supplier
        public Boolean get() {
            return Boolean.FALSE;
        }
    };

    public static <T> Supplier<T> of(final T t) {
        return new Supplier<T>() { // from class: com.facebook.common.internal.Suppliers.1
            /* JADX WARN: Type inference failed for: r0v0, types: [T, java.lang.Object] */
            @Override // com.facebook.common.internal.Supplier
            public T get() {
                return t;
            }
        };
    }
}
