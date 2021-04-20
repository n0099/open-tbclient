package com.google.common.util.concurrent;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes6.dex */
public class AtomicDouble extends Number implements Serializable {
    public static final long serialVersionUID = 0;
    public transient AtomicLong value;

    public AtomicDouble(double d2) {
        this.value = new AtomicLong(Double.doubleToRawLongBits(d2));
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.value = new AtomicLong();
        set(objectInputStream.readDouble());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeDouble(get());
    }

    public final double addAndGet(double d2) {
        long j;
        double longBitsToDouble;
        do {
            j = this.value.get();
            longBitsToDouble = Double.longBitsToDouble(j) + d2;
        } while (!this.value.compareAndSet(j, Double.doubleToRawLongBits(longBitsToDouble)));
        return longBitsToDouble;
    }

    public final boolean compareAndSet(double d2, double d3) {
        return this.value.compareAndSet(Double.doubleToRawLongBits(d2), Double.doubleToRawLongBits(d3));
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return get();
    }

    @Override // java.lang.Number
    public float floatValue() {
        return (float) get();
    }

    public final double get() {
        return Double.longBitsToDouble(this.value.get());
    }

    public final double getAndAdd(double d2) {
        long j;
        double longBitsToDouble;
        do {
            j = this.value.get();
            longBitsToDouble = Double.longBitsToDouble(j);
        } while (!this.value.compareAndSet(j, Double.doubleToRawLongBits(longBitsToDouble + d2)));
        return longBitsToDouble;
    }

    public final double getAndSet(double d2) {
        return Double.longBitsToDouble(this.value.getAndSet(Double.doubleToRawLongBits(d2)));
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) get();
    }

    public final void lazySet(double d2) {
        this.value.lazySet(Double.doubleToRawLongBits(d2));
    }

    @Override // java.lang.Number
    public long longValue() {
        return (long) get();
    }

    public final void set(double d2) {
        this.value.set(Double.doubleToRawLongBits(d2));
    }

    public String toString() {
        return Double.toString(get());
    }

    public final boolean weakCompareAndSet(double d2, double d3) {
        return this.value.weakCompareAndSet(Double.doubleToRawLongBits(d2), Double.doubleToRawLongBits(d3));
    }

    public AtomicDouble() {
        this(0.0d);
    }
}
