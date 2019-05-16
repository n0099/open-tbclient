package com.google.gson;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public final class f extends h implements Iterable<h> {
    private final List<h> kfv = new ArrayList();

    public void b(h hVar) {
        if (hVar == null) {
            hVar = i.kfw;
        }
        this.kfv.add(hVar);
    }

    @Override // java.lang.Iterable
    public Iterator<h> iterator() {
        return this.kfv.iterator();
    }

    @Override // com.google.gson.h
    public Number cIF() {
        if (this.kfv.size() == 1) {
            return this.kfv.get(0).cIF();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.h
    public String cIG() {
        if (this.kfv.size() == 1) {
            return this.kfv.get(0).cIG();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.h
    public boolean getAsBoolean() {
        if (this.kfv.size() == 1) {
            return this.kfv.get(0).getAsBoolean();
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof f) && ((f) obj).kfv.equals(this.kfv));
    }

    public int hashCode() {
        return this.kfv.hashCode();
    }
}
