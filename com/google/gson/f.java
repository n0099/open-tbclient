package com.google.gson;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public final class f extends i implements Iterable<i> {
    private final List<i> jNy = new ArrayList();

    public void b(i iVar) {
        if (iVar == null) {
            iVar = j.jNz;
        }
        this.jNy.add(iVar);
    }

    @Override // java.lang.Iterable
    public Iterator<i> iterator() {
        return this.jNy.iterator();
    }

    @Override // com.google.gson.i
    public Number cAP() {
        if (this.jNy.size() == 1) {
            return this.jNy.get(0).cAP();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.i
    public String cAQ() {
        if (this.jNy.size() == 1) {
            return this.jNy.get(0).cAQ();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.i
    public double getAsDouble() {
        if (this.jNy.size() == 1) {
            return this.jNy.get(0).getAsDouble();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.i
    public long getAsLong() {
        if (this.jNy.size() == 1) {
            return this.jNy.get(0).getAsLong();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.i
    public int getAsInt() {
        if (this.jNy.size() == 1) {
            return this.jNy.get(0).getAsInt();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.i
    public boolean getAsBoolean() {
        if (this.jNy.size() == 1) {
            return this.jNy.get(0).getAsBoolean();
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof f) && ((f) obj).jNy.equals(this.jNy));
    }

    public int hashCode() {
        return this.jNy.hashCode();
    }
}
