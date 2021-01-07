package com.squareup.wire;

import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes6.dex */
final class ExtensionRegistry {
    private final Map<Class<? extends ExtendableMessage>, Map<Integer, Extension<?, ?>>> extensionsByTag = new LinkedHashMap();
    private final Map<Class<? extends ExtendableMessage>, Map<String, Extension<?, ?>>> extensionsByName = new LinkedHashMap();

    public <T extends ExtendableMessage<?>, E> void add(Extension<T, E> extension) {
        Class<T> extendedType = extension.getExtendedType();
        Map<Integer, Extension<?, ?>> map = this.extensionsByTag.get(extendedType);
        Map<String, Extension<?, ?>> map2 = this.extensionsByName.get(extendedType);
        if (map == null) {
            map = new LinkedHashMap<>();
            map2 = new LinkedHashMap<>();
            this.extensionsByTag.put(extendedType, map);
            this.extensionsByName.put(extendedType, map2);
        }
        map.put(Integer.valueOf(extension.getTag()), extension);
        map2.put(extension.getName(), extension);
    }

    public <T extends ExtendableMessage<?>, E> Extension<T, E> getExtension(Class<T> cls, int i) {
        Map<Integer, Extension<?, ?>> map = this.extensionsByTag.get(cls);
        if (map == null) {
            return null;
        }
        return (Extension<T, E>) map.get(Integer.valueOf(i));
    }

    public <T extends ExtendableMessage<?>, E> Extension<T, E> getExtension(Class<T> cls, String str) {
        Map<String, Extension<?, ?>> map = this.extensionsByName.get(cls);
        if (map == null) {
            return null;
        }
        return (Extension<T, E>) map.get(str);
    }
}
