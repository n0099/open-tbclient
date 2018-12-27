package com.google.gson;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public final class f extends i implements Iterable<i> {
    private final List<i> iwm = new ArrayList();

    public void b(i iVar) {
        if (iVar == null) {
            iVar = j.iwn;
        }
        this.iwm.add(iVar);
    }

    @Override // java.lang.Iterable
    public Iterator<i> iterator() {
        return this.iwm.iterator();
    }

    @Override // com.google.gson.i
    public Number caS() {
        if (this.iwm.size() == 1) {
            return this.iwm.get(0).caS();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.i
    public String caT() {
        if (this.iwm.size() == 1) {
            return this.iwm.get(0).caT();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.i
    public double getAsDouble() {
        if (this.iwm.size() == 1) {
            return this.iwm.get(0).getAsDouble();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.i
    public long getAsLong() {
        if (this.iwm.size() == 1) {
            return this.iwm.get(0).getAsLong();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.i
    public int getAsInt() {
        if (this.iwm.size() == 1) {
            return this.iwm.get(0).getAsInt();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.i
    public boolean getAsBoolean() {
        if (this.iwm.size() == 1) {
            return this.iwm.get(0).getAsBoolean();
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof f) && ((f) obj).iwm.equals(this.iwm));
    }

    public int hashCode() {
        return this.iwm.hashCode();
    }
}
