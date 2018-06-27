package com.google.gson;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public final class f extends h implements Iterable<h> {
    private final List<h> hML = new ArrayList();

    public void b(h hVar) {
        if (hVar == null) {
            hVar = i.hMM;
        }
        this.hML.add(hVar);
    }

    @Override // java.lang.Iterable
    public Iterator<h> iterator() {
        return this.hML.iterator();
    }

    @Override // com.google.gson.h
    public Number bOc() {
        if (this.hML.size() == 1) {
            return this.hML.get(0).bOc();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.h
    public String bOd() {
        if (this.hML.size() == 1) {
            return this.hML.get(0).bOd();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.h
    public boolean getAsBoolean() {
        if (this.hML.size() == 1) {
            return this.hML.get(0).getAsBoolean();
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof f) && ((f) obj).hML.equals(this.hML));
    }

    public int hashCode() {
        return this.hML.hashCode();
    }
}
