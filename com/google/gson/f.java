package com.google.gson;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public final class f extends h implements Iterable<h> {
    private final List<h> hFp = new ArrayList();

    public void b(h hVar) {
        if (hVar == null) {
            hVar = i.hFq;
        }
        this.hFp.add(hVar);
    }

    @Override // java.lang.Iterable
    public Iterator<h> iterator() {
        return this.hFp.iterator();
    }

    @Override // com.google.gson.h
    public Number bJM() {
        if (this.hFp.size() == 1) {
            return this.hFp.get(0).bJM();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.h
    public String bJN() {
        if (this.hFp.size() == 1) {
            return this.hFp.get(0).bJN();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.h
    public boolean getAsBoolean() {
        if (this.hFp.size() == 1) {
            return this.hFp.get(0).getAsBoolean();
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof f) && ((f) obj).hFp.equals(this.hFp));
    }

    public int hashCode() {
        return this.hFp.hashCode();
    }
}
