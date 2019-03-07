package com.facebook.imagepipeline.c;

import com.android.internal.util.Predicate;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public interface t<K, V> {
    @Nullable
    com.facebook.common.references.a<V> a(K k, com.facebook.common.references.a<V> aVar);

    @Nullable
    com.facebook.common.references.a<V> aW(K k);

    boolean b(Predicate<K> predicate);
}
