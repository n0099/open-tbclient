package com.dd.plist;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes5.dex */
public class g extends i implements Map<String, i> {
    private HashMap<String, i> lFR = new LinkedHashMap();

    @Override // java.util.Map
    public int size() {
        return this.lFR.size();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.lFR.isEmpty();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return this.lFR.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        if (obj == null) {
            return false;
        }
        return this.lFR.containsValue(i.aM(obj));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Map
    /* renamed from: aK */
    public i get(Object obj) {
        return this.lFR.get(obj);
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
            return this.lFR.get(str);
        }
        return this.lFR.put(str, iVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Map
    /* renamed from: aL */
    public i remove(Object obj) {
        return this.lFR.remove(obj);
    }

    @Override // java.util.Map
    public void clear() {
        this.lFR.clear();
    }

    @Override // java.util.Map
    public Set<String> keySet() {
        return this.lFR.keySet();
    }

    @Override // java.util.Map
    public Collection<i> values() {
        return this.lFR.values();
    }

    @Override // java.util.Map
    public Set<Map.Entry<String, i>> entrySet() {
        return this.lFR.entrySet();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return obj.getClass().equals(getClass()) && ((g) obj).lFR.equals(this.lFR);
    }

    @Override // java.util.Map
    public int hashCode() {
        return (this.lFR != null ? this.lFR.hashCode() : 0) + 581;
    }
}
