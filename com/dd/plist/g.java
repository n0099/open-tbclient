package com.dd.plist;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes7.dex */
public class g extends i implements Map<String, i> {
    private HashMap<String, i> lGF = new LinkedHashMap();

    @Override // java.util.Map
    public int size() {
        return this.lGF.size();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.lGF.isEmpty();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return this.lGF.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        if (obj == null) {
            return false;
        }
        return this.lGF.containsValue(i.aO(obj));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Map
    /* renamed from: aM */
    public i get(Object obj) {
        return this.lGF.get(obj);
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
            return this.lGF.get(str);
        }
        return this.lGF.put(str, iVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Map
    /* renamed from: aN */
    public i remove(Object obj) {
        return this.lGF.remove(obj);
    }

    @Override // java.util.Map
    public void clear() {
        this.lGF.clear();
    }

    @Override // java.util.Map
    public Set<String> keySet() {
        return this.lGF.keySet();
    }

    @Override // java.util.Map
    public Collection<i> values() {
        return this.lGF.values();
    }

    @Override // java.util.Map
    public Set<Map.Entry<String, i>> entrySet() {
        return this.lGF.entrySet();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return obj.getClass().equals(getClass()) && ((g) obj).lGF.equals(this.lGF);
    }

    @Override // java.util.Map
    public int hashCode() {
        return (this.lGF != null ? this.lGF.hashCode() : 0) + 581;
    }
}
