package com.google.gson;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public final class f extends h implements Iterable<h> {
    private final List<h> hNJ = new ArrayList();

    public void b(h hVar) {
        if (hVar == null) {
            hVar = i.hNK;
        }
        this.hNJ.add(hVar);
    }

    @Override // java.lang.Iterable
    public Iterator<h> iterator() {
        return this.hNJ.iterator();
    }

    @Override // com.google.gson.h
    public Number bMD() {
        if (this.hNJ.size() == 1) {
            return this.hNJ.get(0).bMD();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.h
    public String bME() {
        if (this.hNJ.size() == 1) {
            return this.hNJ.get(0).bME();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.h
    public boolean getAsBoolean() {
        if (this.hNJ.size() == 1) {
            return this.hNJ.get(0).getAsBoolean();
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof f) && ((f) obj).hNJ.equals(this.hNJ));
    }

    public int hashCode() {
        return this.hNJ.hashCode();
    }
}
