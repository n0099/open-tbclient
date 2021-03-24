package com.squareup.wire;

import com.baidu.android.common.others.lang.StringUtil;
import com.squareup.wire.ExtendableMessage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes6.dex */
public final class ExtensionMap<T extends ExtendableMessage<?>> {
    public final Map<Extension<T, ?>, Object> map;

    public ExtensionMap() {
        this.map = new TreeMap();
    }

    public boolean equals(Object obj) {
        return (obj instanceof ExtensionMap) && this.map.equals(((ExtensionMap) obj).map);
    }

    public <E> E get(Extension<T, E> extension) {
        return (E) this.map.get(extension);
    }

    public List<Extension<T, ?>> getExtensions() {
        return Collections.unmodifiableList(new ArrayList(this.map.keySet()));
    }

    public int hashCode() {
        return this.map.hashCode();
    }

    public <E> void put(Extension<T, E> extension, E e2) {
        this.map.put(extension, e2);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(StringUtil.ARRAY_START);
        String str = "";
        for (Map.Entry<Extension<T, ?>, Object> entry : this.map.entrySet()) {
            sb.append(str);
            sb.append(entry.getKey().getTag());
            sb.append("=");
            sb.append(entry.getValue());
            str = StringUtil.ARRAY_ELEMENT_SEPARATOR;
        }
        sb.append("}");
        return sb.toString();
    }

    public ExtensionMap(ExtensionMap<T> extensionMap) {
        TreeMap treeMap = new TreeMap();
        this.map = treeMap;
        treeMap.putAll(extensionMap.map);
    }
}
