package com.facebook.common.internal;
/* loaded from: classes14.dex */
public class k {
    public static final j<Boolean> poE = new j<Boolean>() { // from class: com.facebook.common.internal.k.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.common.internal.j
        /* renamed from: eqi */
        public Boolean get() {
            return true;
        }
    };
    public static final j<Boolean> poF = new j<Boolean>() { // from class: com.facebook.common.internal.k.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.common.internal.j
        /* renamed from: eqi */
        public Boolean get() {
            return false;
        }
    };

    public static <T> j<T> bc(final T t) {
        return new j<T>() { // from class: com.facebook.common.internal.k.1
            /* JADX WARN: Type inference failed for: r0v0, types: [T, java.lang.Object] */
            @Override // com.facebook.common.internal.j
            public T get() {
                return t;
            }
        };
    }
}
