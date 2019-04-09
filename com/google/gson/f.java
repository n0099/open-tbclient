package com.google.gson;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public final class f extends i implements Iterable<i> {
    private final List<i> jML = new ArrayList();

    public void b(i iVar) {
        if (iVar == null) {
            iVar = j.jMM;
        }
        this.jML.add(iVar);
    }

    @Override // java.lang.Iterable
    public Iterator<i> iterator() {
        return this.jML.iterator();
    }

    @Override // com.google.gson.i
    public Number cAL() {
        if (this.jML.size() == 1) {
            return this.jML.get(0).cAL();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.i
    public String cAM() {
        if (this.jML.size() == 1) {
            return this.jML.get(0).cAM();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.i
    public double getAsDouble() {
        if (this.jML.size() == 1) {
            return this.jML.get(0).getAsDouble();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.i
    public long getAsLong() {
        if (this.jML.size() == 1) {
            return this.jML.get(0).getAsLong();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.i
    public int getAsInt() {
        if (this.jML.size() == 1) {
            return this.jML.get(0).getAsInt();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.i
    public boolean getAsBoolean() {
        if (this.jML.size() == 1) {
            return this.jML.get(0).getAsBoolean();
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof f) && ((f) obj).jML.equals(this.jML));
    }

    public int hashCode() {
        return this.jML.hashCode();
    }
}
