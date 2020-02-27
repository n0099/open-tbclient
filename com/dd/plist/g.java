package com.dd.plist;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes7.dex */
public class g extends i implements Map<String, i> {
    private HashMap<String, i> lGD = new LinkedHashMap();

    @Override // java.util.Map
    public int size() {
        return this.lGD.size();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.lGD.isEmpty();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return this.lGD.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        if (obj == null) {
            return false;
        }
        return this.lGD.containsValue(i.aO(obj));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Map
    /* renamed from: aM */
    public i get(Object obj) {
        return this.lGD.get(obj);
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
            return this.lGD.get(str);
        }
        return this.lGD.put(str, iVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Map
    /* renamed from: aN */
    public i remove(Object obj) {
        return this.lGD.remove(obj);
    }

    @Override // java.util.Map
    public void clear() {
        this.lGD.clear();
    }

    @Override // java.util.Map
    public Set<String> keySet() {
        return this.lGD.keySet();
    }

    @Override // java.util.Map
    public Collection<i> values() {
        return this.lGD.values();
    }

    @Override // java.util.Map
    public Set<Map.Entry<String, i>> entrySet() {
        return this.lGD.entrySet();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return obj.getClass().equals(getClass()) && ((g) obj).lGD.equals(this.lGD);
    }

    @Override // java.util.Map
    public int hashCode() {
        return (this.lGD != null ? this.lGD.hashCode() : 0) + 581;
    }
}
