package com.dd.plist;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes7.dex */
public class g extends i implements Map<String, i> {
    private HashMap<String, i> lGQ = new LinkedHashMap();

    @Override // java.util.Map
    public int size() {
        return this.lGQ.size();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.lGQ.isEmpty();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return this.lGQ.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        if (obj == null) {
            return false;
        }
        return this.lGQ.containsValue(i.aO(obj));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Map
    /* renamed from: aM */
    public i get(Object obj) {
        return this.lGQ.get(obj);
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
            return this.lGQ.get(str);
        }
        return this.lGQ.put(str, iVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Map
    /* renamed from: aN */
    public i remove(Object obj) {
        return this.lGQ.remove(obj);
    }

    @Override // java.util.Map
    public void clear() {
        this.lGQ.clear();
    }

    @Override // java.util.Map
    public Set<String> keySet() {
        return this.lGQ.keySet();
    }

    @Override // java.util.Map
    public Collection<i> values() {
        return this.lGQ.values();
    }

    @Override // java.util.Map
    public Set<Map.Entry<String, i>> entrySet() {
        return this.lGQ.entrySet();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return obj.getClass().equals(getClass()) && ((g) obj).lGQ.equals(this.lGQ);
    }

    @Override // java.util.Map
    public int hashCode() {
        return (this.lGQ != null ? this.lGQ.hashCode() : 0) + 581;
    }
}
