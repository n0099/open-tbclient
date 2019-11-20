package com.google.gson;

import com.google.gson.internal.LinkedTreeMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes2.dex */
public final class j extends h {
    private final LinkedTreeMap<String, h> knF = new LinkedTreeMap<>();

    public void a(String str, h hVar) {
        if (hVar == null) {
            hVar = i.knE;
        }
        this.knF.put(str, hVar);
    }

    public Set<Map.Entry<String, h>> entrySet() {
        return this.knF.entrySet();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof j) && ((j) obj).knF.equals(this.knF));
    }

    public int hashCode() {
        return this.knF.hashCode();
    }
}
