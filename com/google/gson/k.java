package com.google.gson;

import com.google.gson.internal.LinkedTreeMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes2.dex */
public final class k extends i {
    private final LinkedTreeMap<String, i> jNs = new LinkedTreeMap<>();

    public void a(String str, i iVar) {
        if (iVar == null) {
            iVar = j.jNr;
        }
        this.jNs.put(str, iVar);
    }

    public Set<Map.Entry<String, i>> entrySet() {
        return this.jNs.entrySet();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof k) && ((k) obj).jNs.equals(this.jNs));
    }

    public int hashCode() {
        return this.jNs.hashCode();
    }
}
