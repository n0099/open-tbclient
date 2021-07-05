package d.f.d.b;

import com.google.common.collect.ImmutableMap;
import java.util.concurrent.ExecutionException;
/* loaded from: classes10.dex */
public interface f<K, V> extends c<K, V>, d.f.d.a.g<K, V> {
    @Deprecated
    V apply(K k);

    V get(K k) throws ExecutionException;

    ImmutableMap<K, V> getAll(Iterable<? extends K> iterable) throws ExecutionException;

    V getUnchecked(K k);

    void refresh(K k);
}
