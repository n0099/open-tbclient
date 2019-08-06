package com.google.gson;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public final class f extends h implements Iterable<h> {
    private final List<h> knL = new ArrayList();

    public void b(h hVar) {
        if (hVar == null) {
            hVar = i.knM;
        }
        this.knL.add(hVar);
    }

    @Override // java.lang.Iterable
    public Iterator<h> iterator() {
        return this.knL.iterator();
    }

    @Override // com.google.gson.h
    public Number cMg() {
        if (this.knL.size() == 1) {
            return this.knL.get(0).cMg();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.h
    public String cMh() {
        if (this.knL.size() == 1) {
            return this.knL.get(0).cMh();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.h
    public boolean cMi() {
        if (this.knL.size() == 1) {
            return this.knL.get(0).cMi();
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof f) && ((f) obj).knL.equals(this.knL));
    }

    public int hashCode() {
        return this.knL.hashCode();
    }
}
