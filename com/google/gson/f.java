package com.google.gson;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public final class f extends i implements Iterable<i> {
    private final List<i> ikg = new ArrayList();

    public void b(i iVar) {
        if (iVar == null) {
            iVar = j.ikh;
        }
        this.ikg.add(iVar);
    }

    @Override // java.lang.Iterable
    public Iterator<i> iterator() {
        return this.ikg.iterator();
    }

    @Override // com.google.gson.i
    public Number bYz() {
        if (this.ikg.size() == 1) {
            return this.ikg.get(0).bYz();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.i
    public String bYA() {
        if (this.ikg.size() == 1) {
            return this.ikg.get(0).bYA();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.i
    public double getAsDouble() {
        if (this.ikg.size() == 1) {
            return this.ikg.get(0).getAsDouble();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.i
    public long getAsLong() {
        if (this.ikg.size() == 1) {
            return this.ikg.get(0).getAsLong();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.i
    public int getAsInt() {
        if (this.ikg.size() == 1) {
            return this.ikg.get(0).getAsInt();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.i
    public boolean getAsBoolean() {
        if (this.ikg.size() == 1) {
            return this.ikg.get(0).getAsBoolean();
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof f) && ((f) obj).ikg.equals(this.ikg));
    }

    public int hashCode() {
        return this.ikg.hashCode();
    }
}
