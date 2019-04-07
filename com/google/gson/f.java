package com.google.gson;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public final class f extends i implements Iterable<i> {
    private final List<i> jMK = new ArrayList();

    public void b(i iVar) {
        if (iVar == null) {
            iVar = j.jML;
        }
        this.jMK.add(iVar);
    }

    @Override // java.lang.Iterable
    public Iterator<i> iterator() {
        return this.jMK.iterator();
    }

    @Override // com.google.gson.i
    public Number cAL() {
        if (this.jMK.size() == 1) {
            return this.jMK.get(0).cAL();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.i
    public String cAM() {
        if (this.jMK.size() == 1) {
            return this.jMK.get(0).cAM();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.i
    public double getAsDouble() {
        if (this.jMK.size() == 1) {
            return this.jMK.get(0).getAsDouble();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.i
    public long getAsLong() {
        if (this.jMK.size() == 1) {
            return this.jMK.get(0).getAsLong();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.i
    public int getAsInt() {
        if (this.jMK.size() == 1) {
            return this.jMK.get(0).getAsInt();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.i
    public boolean getAsBoolean() {
        if (this.jMK.size() == 1) {
            return this.jMK.get(0).getAsBoolean();
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof f) && ((f) obj).jMK.equals(this.jMK));
    }

    public int hashCode() {
        return this.jMK.hashCode();
    }
}
