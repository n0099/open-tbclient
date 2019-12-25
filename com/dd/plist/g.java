package com.dd.plist;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes4.dex */
public class g extends i implements Map<String, i> {
    private HashMap<String, i> lCt = new LinkedHashMap();

    @Override // java.util.Map
    public int size() {
        return this.lCt.size();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.lCt.isEmpty();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return this.lCt.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        if (obj == null) {
            return false;
        }
        return this.lCt.containsValue(i.aM(obj));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Map
    /* renamed from: aK */
    public i get(Object obj) {
        return this.lCt.get(obj);
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
            return this.lCt.get(str);
        }
        return this.lCt.put(str, iVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Map
    /* renamed from: aL */
    public i remove(Object obj) {
        return this.lCt.remove(obj);
    }

    @Override // java.util.Map
    public void clear() {
        this.lCt.clear();
    }

    @Override // java.util.Map
    public Set<String> keySet() {
        return this.lCt.keySet();
    }

    @Override // java.util.Map
    public Collection<i> values() {
        return this.lCt.values();
    }

    @Override // java.util.Map
    public Set<Map.Entry<String, i>> entrySet() {
        return this.lCt.entrySet();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return obj.getClass().equals(getClass()) && ((g) obj).lCt.equals(this.lCt);
    }

    @Override // java.util.Map
    public int hashCode() {
        return (this.lCt != null ? this.lCt.hashCode() : 0) + 581;
    }
}
