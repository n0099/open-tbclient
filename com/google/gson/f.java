package com.google.gson;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public final class f extends i implements Iterable<i> {
    private final List<i> itc = new ArrayList();

    public void b(i iVar) {
        if (iVar == null) {
            iVar = j.itd;
        }
        this.itc.add(iVar);
    }

    @Override // java.lang.Iterable
    public Iterator<i> iterator() {
        return this.itc.iterator();
    }

    @Override // com.google.gson.i
    public Number cac() {
        if (this.itc.size() == 1) {
            return this.itc.get(0).cac();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.i
    public String cad() {
        if (this.itc.size() == 1) {
            return this.itc.get(0).cad();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.i
    public double getAsDouble() {
        if (this.itc.size() == 1) {
            return this.itc.get(0).getAsDouble();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.i
    public long getAsLong() {
        if (this.itc.size() == 1) {
            return this.itc.get(0).getAsLong();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.i
    public int getAsInt() {
        if (this.itc.size() == 1) {
            return this.itc.get(0).getAsInt();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.i
    public boolean getAsBoolean() {
        if (this.itc.size() == 1) {
            return this.itc.get(0).getAsBoolean();
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof f) && ((f) obj).itc.equals(this.itc));
    }

    public int hashCode() {
        return this.itc.hashCode();
    }
}
