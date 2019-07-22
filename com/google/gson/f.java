package com.google.gson;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public final class f extends h implements Iterable<h> {
    private final List<h> kmF = new ArrayList();

    public void b(h hVar) {
        if (hVar == null) {
            hVar = i.kmG;
        }
        this.kmF.add(hVar);
    }

    @Override // java.lang.Iterable
    public Iterator<h> iterator() {
        return this.kmF.iterator();
    }

    @Override // com.google.gson.h
    public Number cLL() {
        if (this.kmF.size() == 1) {
            return this.kmF.get(0).cLL();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.h
    public String cLM() {
        if (this.kmF.size() == 1) {
            return this.kmF.get(0).cLM();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.h
    public boolean cLN() {
        if (this.kmF.size() == 1) {
            return this.kmF.get(0).cLN();
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof f) && ((f) obj).kmF.equals(this.kmF));
    }

    public int hashCode() {
        return this.kmF.hashCode();
    }
}
