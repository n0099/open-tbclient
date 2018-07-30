package com.google.gson;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public final class f extends h implements Iterable<h> {
    private final List<h> hFI = new ArrayList();

    public void b(h hVar) {
        if (hVar == null) {
            hVar = i.hFJ;
        }
        this.hFI.add(hVar);
    }

    @Override // java.lang.Iterable
    public Iterator<h> iterator() {
        return this.hFI.iterator();
    }

    @Override // com.google.gson.h
    public Number bJV() {
        if (this.hFI.size() == 1) {
            return this.hFI.get(0).bJV();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.h
    public String bJW() {
        if (this.hFI.size() == 1) {
            return this.hFI.get(0).bJW();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.h
    public boolean getAsBoolean() {
        if (this.hFI.size() == 1) {
            return this.hFI.get(0).getAsBoolean();
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof f) && ((f) obj).hFI.equals(this.hFI));
    }

    public int hashCode() {
        return this.hFI.hashCode();
    }
}
