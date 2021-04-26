package com.google.common.util.concurrent;

import com.google.common.primitives.ImmutableLongArray;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLongArray;
/* loaded from: classes6.dex */
public class AtomicDoubleArray implements Serializable {
    public static final long serialVersionUID = 0;
    public transient AtomicLongArray longs;

    public AtomicDoubleArray(int i2) {
        this.longs = new AtomicLongArray(i2);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        ImmutableLongArray.b builder = ImmutableLongArray.builder();
        for (int i2 = 0; i2 < readInt; i2++) {
            builder.a(Double.doubleToRawLongBits(objectInputStream.readDouble()));
        }
        this.longs = new AtomicLongArray(builder.d().toArray());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        int length = length();
        objectOutputStream.writeInt(length);
        for (int i2 = 0; i2 < length; i2++) {
            objectOutputStream.writeDouble(get(i2));
        }
    }

    public double addAndGet(int i2, double d2) {
        long j;
        double longBitsToDouble;
        do {
            j = this.longs.get(i2);
            longBitsToDouble = Double.longBitsToDouble(j) + d2;
        } while (!this.longs.compareAndSet(i2, j, Double.doubleToRawLongBits(longBitsToDouble)));
        return longBitsToDouble;
    }

    public final boolean compareAndSet(int i2, double d2, double d3) {
        return this.longs.compareAndSet(i2, Double.doubleToRawLongBits(d2), Double.doubleToRawLongBits(d3));
    }

    public final double get(int i2) {
        return Double.longBitsToDouble(this.longs.get(i2));
    }

    public final double getAndAdd(int i2, double d2) {
        long j;
        double longBitsToDouble;
        do {
            j = this.longs.get(i2);
            longBitsToDouble = Double.longBitsToDouble(j);
        } while (!this.longs.compareAndSet(i2, j, Double.doubleToRawLongBits(longBitsToDouble + d2)));
        return longBitsToDouble;
    }

    public final double getAndSet(int i2, double d2) {
        return Double.longBitsToDouble(this.longs.getAndSet(i2, Double.doubleToRawLongBits(d2)));
    }

    public final void lazySet(int i2, double d2) {
        this.longs.lazySet(i2, Double.doubleToRawLongBits(d2));
    }

    public final int length() {
        return this.longs.length();
    }

    public final void set(int i2, double d2) {
        this.longs.set(i2, Double.doubleToRawLongBits(d2));
    }

    public String toString() {
        int length = length() - 1;
        if (length == -1) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder((length + 1) * 19);
        sb.append('[');
        int i2 = 0;
        while (true) {
            sb.append(Double.longBitsToDouble(this.longs.get(i2)));
            if (i2 == length) {
                sb.append(']');
                return sb.toString();
            }
            sb.append(',');
            sb.append(' ');
            i2++;
        }
    }

    public final boolean weakCompareAndSet(int i2, double d2, double d3) {
        return this.longs.weakCompareAndSet(i2, Double.doubleToRawLongBits(d2), Double.doubleToRawLongBits(d3));
    }

    public AtomicDoubleArray(double[] dArr) {
        int length = dArr.length;
        long[] jArr = new long[length];
        for (int i2 = 0; i2 < length; i2++) {
            jArr[i2] = Double.doubleToRawLongBits(dArr[i2]);
        }
        this.longs = new AtomicLongArray(jArr);
    }
}
