package com.google.gson;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public final class f extends h implements Iterable<h> {
    private final List<h> kfz = new ArrayList();

    public void b(h hVar) {
        if (hVar == null) {
            hVar = i.kfA;
        }
        this.kfz.add(hVar);
    }

    @Override // java.lang.Iterable
    public Iterator<h> iterator() {
        return this.kfz.iterator();
    }

    @Override // com.google.gson.h
    public Number cIG() {
        if (this.kfz.size() == 1) {
            return this.kfz.get(0).cIG();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.h
    public String cIH() {
        if (this.kfz.size() == 1) {
            return this.kfz.get(0).cIH();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.h
    public boolean getAsBoolean() {
        if (this.kfz.size() == 1) {
            return this.kfz.get(0).getAsBoolean();
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof f) && ((f) obj).kfz.equals(this.kfz));
    }

    public int hashCode() {
        return this.kfz.hashCode();
    }
}
