package com.google.gson;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public final class f extends i implements Iterable<i> {
    private final List<i> jNq = new ArrayList();

    public void b(i iVar) {
        if (iVar == null) {
            iVar = j.jNr;
        }
        this.jNq.add(iVar);
    }

    @Override // java.lang.Iterable
    public Iterator<i> iterator() {
        return this.jNq.iterator();
    }

    @Override // com.google.gson.i
    public Number cAS() {
        if (this.jNq.size() == 1) {
            return this.jNq.get(0).cAS();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.i
    public String cAT() {
        if (this.jNq.size() == 1) {
            return this.jNq.get(0).cAT();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.i
    public double getAsDouble() {
        if (this.jNq.size() == 1) {
            return this.jNq.get(0).getAsDouble();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.i
    public long getAsLong() {
        if (this.jNq.size() == 1) {
            return this.jNq.get(0).getAsLong();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.i
    public int getAsInt() {
        if (this.jNq.size() == 1) {
            return this.jNq.get(0).getAsInt();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.i
    public boolean getAsBoolean() {
        if (this.jNq.size() == 1) {
            return this.jNq.get(0).getAsBoolean();
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof f) && ((f) obj).jNq.equals(this.jNq));
    }

    public int hashCode() {
        return this.jNq.hashCode();
    }
}
