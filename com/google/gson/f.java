package com.google.gson;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public final class f extends i implements Iterable<i> {
    private final List<i> ixu = new ArrayList();

    public void b(i iVar) {
        if (iVar == null) {
            iVar = j.ixv;
        }
        this.ixu.add(iVar);
    }

    @Override // java.lang.Iterable
    public Iterator<i> iterator() {
        return this.ixu.iterator();
    }

    @Override // com.google.gson.i
    public Number cbA() {
        if (this.ixu.size() == 1) {
            return this.ixu.get(0).cbA();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.i
    public String cbB() {
        if (this.ixu.size() == 1) {
            return this.ixu.get(0).cbB();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.i
    public double getAsDouble() {
        if (this.ixu.size() == 1) {
            return this.ixu.get(0).getAsDouble();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.i
    public long getAsLong() {
        if (this.ixu.size() == 1) {
            return this.ixu.get(0).getAsLong();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.i
    public int getAsInt() {
        if (this.ixu.size() == 1) {
            return this.ixu.get(0).getAsInt();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.i
    public boolean getAsBoolean() {
        if (this.ixu.size() == 1) {
            return this.ixu.get(0).getAsBoolean();
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof f) && ((f) obj).ixu.equals(this.ixu));
    }

    public int hashCode() {
        return this.ixu.hashCode();
    }
}
