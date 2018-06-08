package com.google.gson;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public final class f extends h implements Iterable<h> {
    private final List<h> hIF = new ArrayList();

    public void b(h hVar) {
        if (hVar == null) {
            hVar = i.hIG;
        }
        this.hIF.add(hVar);
    }

    @Override // java.lang.Iterable
    public Iterator<h> iterator() {
        return this.hIF.iterator();
    }

    @Override // com.google.gson.h
    public Number bNA() {
        if (this.hIF.size() == 1) {
            return this.hIF.get(0).bNA();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.h
    public String bNB() {
        if (this.hIF.size() == 1) {
            return this.hIF.get(0).bNB();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.h
    public boolean getAsBoolean() {
        if (this.hIF.size() == 1) {
            return this.hIF.get(0).getAsBoolean();
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof f) && ((f) obj).hIF.equals(this.hIF));
    }

    public int hashCode() {
        return this.hIF.hashCode();
    }
}
