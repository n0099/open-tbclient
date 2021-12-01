package com.dxmpay.apollon.utils.support;

import java.util.List;
import java.util.Map;
/* loaded from: classes12.dex */
public interface MultiValueMap<K, V> extends Map<K, List<V>> {
    void add(K k2, V v);

    V getFirst(K k2);

    void set(K k2, V v);

    void setAll(Map<K, V> map);

    Map<K, V> toSingleValueMap();
}
