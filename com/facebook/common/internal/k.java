package com.facebook.common.internal;
/* loaded from: classes13.dex */
public class k {
    public static final j<Boolean> mlx = new j<Boolean>() { // from class: com.facebook.common.internal.k.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.common.internal.j
        /* renamed from: dus */
        public Boolean get() {
            return true;
        }
    };
    public static final j<Boolean> mly = new j<Boolean>() { // from class: com.facebook.common.internal.k.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.common.internal.j
        /* renamed from: dus */
        public Boolean get() {
            return false;
        }
    };

    public static <T> j<T> aP(final T t) {
        return new j<T>() { // from class: com.facebook.common.internal.k.1
            /* JADX WARN: Type inference failed for: r0v0, types: [T, java.lang.Object] */
            @Override // com.facebook.common.internal.j
            public T get() {
                return t;
            }
        };
    }
}
