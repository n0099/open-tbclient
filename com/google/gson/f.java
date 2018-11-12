package com.google.gson;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public final class f extends i implements Iterable<i> {
    private final List<i> ilQ = new ArrayList();

    public void b(i iVar) {
        if (iVar == null) {
            iVar = j.ilR;
        }
        this.ilQ.add(iVar);
    }

    @Override // java.lang.Iterable
    public Iterator<i> iterator() {
        return this.ilQ.iterator();
    }

    @Override // com.google.gson.i
    public Number bXW() {
        if (this.ilQ.size() == 1) {
            return this.ilQ.get(0).bXW();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.i
    public String bXX() {
        if (this.ilQ.size() == 1) {
            return this.ilQ.get(0).bXX();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.i
    public double getAsDouble() {
        if (this.ilQ.size() == 1) {
            return this.ilQ.get(0).getAsDouble();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.i
    public long getAsLong() {
        if (this.ilQ.size() == 1) {
            return this.ilQ.get(0).getAsLong();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.i
    public int getAsInt() {
        if (this.ilQ.size() == 1) {
            return this.ilQ.get(0).getAsInt();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.i
    public boolean getAsBoolean() {
        if (this.ilQ.size() == 1) {
            return this.ilQ.get(0).getAsBoolean();
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof f) && ((f) obj).ilQ.equals(this.ilQ));
    }

    public int hashCode() {
        return this.ilQ.hashCode();
    }
}
