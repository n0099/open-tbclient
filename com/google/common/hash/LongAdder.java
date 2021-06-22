package com.google.common.hash;

import com.google.common.hash.Striped64;
import d.g.c.d.i;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
/* loaded from: classes6.dex */
public final class LongAdder extends Striped64 implements Serializable, i {
    public static final long serialVersionUID = 7249069246863182397L;

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.busy = 0;
        this.cells = null;
        this.base = objectInputStream.readLong();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeLong(sum());
    }

    @Override // d.g.c.d.i
    public void add(long j) {
        int length;
        Striped64.b bVar;
        Striped64.b[] bVarArr = this.cells;
        if (bVarArr == null) {
            long j2 = this.base;
            if (casBase(j2, j2 + j)) {
                return;
            }
        }
        int[] iArr = Striped64.threadHashCode.get();
        boolean z = true;
        if (iArr != null && bVarArr != null && (length = bVarArr.length) >= 1 && (bVar = bVarArr[(length - 1) & iArr[0]]) != null) {
            long j3 = bVar.f31559a;
            z = bVar.a(j3, j3 + j);
            if (z) {
                return;
            }
        }
        retryUpdate(j, iArr, z);
    }

    public void decrement() {
        add(-1L);
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return sum();
    }

    @Override // java.lang.Number
    public float floatValue() {
        return (float) sum();
    }

    @Override // com.google.common.hash.Striped64
    public final long fn(long j, long j2) {
        return j + j2;
    }

    @Override // d.g.c.d.i
    public void increment() {
        add(1L);
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) sum();
    }

    @Override // java.lang.Number
    public long longValue() {
        return sum();
    }

    public void reset() {
        internalReset(0L);
    }

    @Override // d.g.c.d.i
    public long sum() {
        long j = this.base;
        Striped64.b[] bVarArr = this.cells;
        if (bVarArr != null) {
            for (Striped64.b bVar : bVarArr) {
                if (bVar != null) {
                    j += bVar.f31559a;
                }
            }
        }
        return j;
    }

    public long sumThenReset() {
        long j = this.base;
        Striped64.b[] bVarArr = this.cells;
        this.base = 0L;
        if (bVarArr != null) {
            for (Striped64.b bVar : bVarArr) {
                if (bVar != null) {
                    j += bVar.f31559a;
                    bVar.f31559a = 0L;
                }
            }
        }
        return j;
    }

    public String toString() {
        return Long.toString(sum());
    }
}
