package com.google.gson;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public final class f extends h implements Iterable<h> {
    private final List<h> kfw = new ArrayList();

    public void b(h hVar) {
        if (hVar == null) {
            hVar = i.kfx;
        }
        this.kfw.add(hVar);
    }

    @Override // java.lang.Iterable
    public Iterator<h> iterator() {
        return this.kfw.iterator();
    }

    @Override // com.google.gson.h
    public Number cIH() {
        if (this.kfw.size() == 1) {
            return this.kfw.get(0).cIH();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.h
    public String cII() {
        if (this.kfw.size() == 1) {
            return this.kfw.get(0).cII();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.h
    public boolean getAsBoolean() {
        if (this.kfw.size() == 1) {
            return this.kfw.get(0).getAsBoolean();
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof f) && ((f) obj).kfw.equals(this.kfw));
    }

    public int hashCode() {
        return this.kfw.hashCode();
    }
}
