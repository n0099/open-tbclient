package kotlin.reflect.jvm.internal.impl.storage;

import kotlin.jvm.functions.Function0;
/* loaded from: classes2.dex */
public interface CacheWithNotNullValues<K, V> {
    V computeIfAbsent(K k, Function0<? extends V> function0);
}
