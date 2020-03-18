package com.dd.plist;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes7.dex */
public class g extends i implements Map<String, i> {
    private HashMap<String, i> lIw = new LinkedHashMap();

    @Override // java.util.Map
    public int size() {
        return this.lIw.size();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.lIw.isEmpty();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return this.lIw.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        if (obj == null) {
            return false;
        }
        return this.lIw.containsValue(i.aO(obj));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Map
    /* renamed from: aM */
    public i get(Object obj) {
        return this.lIw.get(obj);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends String, ? extends i> map) {
        for (Map.Entry<? extends String, ? extends i> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Map
    /* renamed from: a */
    public i put(String str, i iVar) {
        if (str == null) {
            return null;
        }
        if (iVar == null) {
            return this.lIw.get(str);
        }
        return this.lIw.put(str, iVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Map
    /* renamed from: aN */
    public i remove(Object obj) {
        return this.lIw.remove(obj);
    }

    @Override // java.util.Map
    public void clear() {
        this.lIw.clear();
    }

    @Override // java.util.Map
    public Set<String> keySet() {
        return this.lIw.keySet();
    }

    @Override // java.util.Map
    public Collection<i> values() {
        return this.lIw.values();
    }

    @Override // java.util.Map
    public Set<Map.Entry<String, i>> entrySet() {
        return this.lIw.entrySet();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return obj.getClass().equals(getClass()) && ((g) obj).lIw.equals(this.lIw);
    }

    @Override // java.util.Map
    public int hashCode() {
        return (this.lIw != null ? this.lIw.hashCode() : 0) + 581;
    }
}
