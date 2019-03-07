package com.google.gson;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public final class f extends i implements Iterable<i> {
    private final List<i> jNf = new ArrayList();

    public void b(i iVar) {
        if (iVar == null) {
            iVar = j.jNg;
        }
        this.jNf.add(iVar);
    }

    @Override // java.lang.Iterable
    public Iterator<i> iterator() {
        return this.jNf.iterator();
    }

    @Override // com.google.gson.i
    public Number cAF() {
        if (this.jNf.size() == 1) {
            return this.jNf.get(0).cAF();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.i
    public String cAG() {
        if (this.jNf.size() == 1) {
            return this.jNf.get(0).cAG();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.i
    public double getAsDouble() {
        if (this.jNf.size() == 1) {
            return this.jNf.get(0).getAsDouble();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.i
    public long getAsLong() {
        if (this.jNf.size() == 1) {
            return this.jNf.get(0).getAsLong();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.i
    public int getAsInt() {
        if (this.jNf.size() == 1) {
            return this.jNf.get(0).getAsInt();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.i
    public boolean getAsBoolean() {
        if (this.jNf.size() == 1) {
            return this.jNf.get(0).getAsBoolean();
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof f) && ((f) obj).jNf.equals(this.jNf));
    }

    public int hashCode() {
        return this.jNf.hashCode();
    }
}
