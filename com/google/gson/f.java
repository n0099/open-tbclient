package com.google.gson;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public final class f extends i implements Iterable<i> {
    private final List<i> ikf = new ArrayList();

    public void b(i iVar) {
        if (iVar == null) {
            iVar = j.ikg;
        }
        this.ikf.add(iVar);
    }

    @Override // java.lang.Iterable
    public Iterator<i> iterator() {
        return this.ikf.iterator();
    }

    @Override // com.google.gson.i
    public Number bYz() {
        if (this.ikf.size() == 1) {
            return this.ikf.get(0).bYz();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.i
    public String bYA() {
        if (this.ikf.size() == 1) {
            return this.ikf.get(0).bYA();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.i
    public double getAsDouble() {
        if (this.ikf.size() == 1) {
            return this.ikf.get(0).getAsDouble();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.i
    public long getAsLong() {
        if (this.ikf.size() == 1) {
            return this.ikf.get(0).getAsLong();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.i
    public int getAsInt() {
        if (this.ikf.size() == 1) {
            return this.ikf.get(0).getAsInt();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.i
    public boolean getAsBoolean() {
        if (this.ikf.size() == 1) {
            return this.ikf.get(0).getAsBoolean();
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof f) && ((f) obj).ikf.equals(this.ikf));
    }

    public int hashCode() {
        return this.ikf.hashCode();
    }
}
