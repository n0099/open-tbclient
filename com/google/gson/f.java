package com.google.gson;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public final class f extends h implements Iterable<h> {
    private final List<h> kou = new ArrayList();

    public void b(h hVar) {
        if (hVar == null) {
            hVar = i.kov;
        }
        this.kou.add(hVar);
    }

    @Override // java.lang.Iterable
    public Iterator<h> iterator() {
        return this.kou.iterator();
    }

    @Override // com.google.gson.h
    public Number cJR() {
        if (this.kou.size() == 1) {
            return this.kou.get(0).cJR();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.h
    public String cJS() {
        if (this.kou.size() == 1) {
            return this.kou.get(0).cJS();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.h
    public boolean cJT() {
        if (this.kou.size() == 1) {
            return this.kou.get(0).cJT();
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof f) && ((f) obj).kou.equals(this.kou));
    }

    public int hashCode() {
        return this.kou.hashCode();
    }
}
