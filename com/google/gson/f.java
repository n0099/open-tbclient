package com.google.gson;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public final class f extends h implements Iterable<h> {
    private final List<h> knD = new ArrayList();

    public void b(h hVar) {
        if (hVar == null) {
            hVar = i.knE;
        }
        this.knD.add(hVar);
    }

    @Override // java.lang.Iterable
    public Iterator<h> iterator() {
        return this.knD.iterator();
    }

    @Override // com.google.gson.h
    public Number cJP() {
        if (this.knD.size() == 1) {
            return this.knD.get(0).cJP();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.h
    public String cJQ() {
        if (this.knD.size() == 1) {
            return this.knD.get(0).cJQ();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.h
    public boolean cJR() {
        if (this.knD.size() == 1) {
            return this.knD.get(0).cJR();
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof f) && ((f) obj).knD.equals(this.knD));
    }

    public int hashCode() {
        return this.knD.hashCode();
    }
}
