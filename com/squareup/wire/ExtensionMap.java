package com.squareup.wire;

import com.baidu.webkit.internal.ETAG;
import com.squareup.wire.ExtendableMessage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes17.dex */
public final class ExtensionMap<T extends ExtendableMessage<?>> {
    private final Map<Extension<T, ?>, Object> map = new TreeMap();

    public ExtensionMap() {
    }

    public ExtensionMap(ExtensionMap<T> extensionMap) {
        this.map.putAll(extensionMap.map);
    }

    public List<Extension<T, ?>> getExtensions() {
        return Collections.unmodifiableList(new ArrayList(this.map.keySet()));
    }

    public <E> E get(Extension<T, E> extension) {
        return (E) this.map.get(extension);
    }

    public <E> void put(Extension<T, E> extension, E e) {
        this.map.put(extension, e);
    }

    public boolean equals(Object obj) {
        return (obj instanceof ExtensionMap) && this.map.equals(((ExtensionMap) obj).map);
    }

    public int hashCode() {
        return this.map.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        String str = "";
        Iterator<Map.Entry<Extension<T, ?>, Object>> it = this.map.entrySet().iterator();
        while (true) {
            String str2 = str;
            if (it.hasNext()) {
                Map.Entry<Extension<T, ?>, Object> next = it.next();
                sb.append(str2);
                sb.append(next.getKey().getTag());
                sb.append(ETAG.EQUAL);
                sb.append(next.getValue());
                str = ", ";
            } else {
                sb.append("}");
                return sb.toString();
            }
        }
    }
}
