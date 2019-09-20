package com.google.gson;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public final class f extends h implements Iterable<h> {
    private final List<h> kqi = new ArrayList();

    public void b(h hVar) {
        if (hVar == null) {
            hVar = i.kqj;
        }
        this.kqi.add(hVar);
    }

    @Override // java.lang.Iterable
    public Iterator<h> iterator() {
        return this.kqi.iterator();
    }

    @Override // com.google.gson.h
    public Number cMU() {
        if (this.kqi.size() == 1) {
            return this.kqi.get(0).cMU();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.h
    public String cMV() {
        if (this.kqi.size() == 1) {
            return this.kqi.get(0).cMV();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.h
    public boolean cMW() {
        if (this.kqi.size() == 1) {
            return this.kqi.get(0).cMW();
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof f) && ((f) obj).kqi.equals(this.kqi));
    }

    public int hashCode() {
        return this.kqi.hashCode();
    }
}
