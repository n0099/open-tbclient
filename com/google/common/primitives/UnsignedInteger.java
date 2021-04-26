package com.google.common.primitives;

import d.g.c.a.n;
import java.math.BigInteger;
/* loaded from: classes6.dex */
public final class UnsignedInteger extends Number implements Comparable<UnsignedInteger> {
    public final int value;
    public static final UnsignedInteger ZERO = fromIntBits(0);
    public static final UnsignedInteger ONE = fromIntBits(1);
    public static final UnsignedInteger MAX_VALUE = fromIntBits(-1);

    public UnsignedInteger(int i2) {
        this.value = i2 & (-1);
    }

    public static UnsignedInteger fromIntBits(int i2) {
        return new UnsignedInteger(i2);
    }

    public static UnsignedInteger valueOf(long j) {
        n.h((4294967295L & j) == j, "value (%s) is outside the range for an unsigned integer value", j);
        return fromIntBits((int) j);
    }

    public BigInteger bigIntegerValue() {
        return BigInteger.valueOf(longValue());
    }

    public UnsignedInteger dividedBy(UnsignedInteger unsignedInteger) {
        int i2 = this.value;
        n.p(unsignedInteger);
        return fromIntBits(UnsignedInts.b(i2, unsignedInteger.value));
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return longValue();
    }

    public boolean equals(Object obj) {
        return (obj instanceof UnsignedInteger) && this.value == ((UnsignedInteger) obj).value;
    }

    @Override // java.lang.Number
    public float floatValue() {
        return (float) longValue();
    }

    public int hashCode() {
        return this.value;
    }

    @Override // java.lang.Number
    public int intValue() {
        return this.value;
    }

    @Override // java.lang.Number
    public long longValue() {
        return UnsignedInts.f(this.value);
    }

    public UnsignedInteger minus(UnsignedInteger unsignedInteger) {
        int i2 = this.value;
        n.p(unsignedInteger);
        return fromIntBits(i2 - unsignedInteger.value);
    }

    public UnsignedInteger mod(UnsignedInteger unsignedInteger) {
        int i2 = this.value;
        n.p(unsignedInteger);
        return fromIntBits(UnsignedInts.e(i2, unsignedInteger.value));
    }

    public UnsignedInteger plus(UnsignedInteger unsignedInteger) {
        int i2 = this.value;
        n.p(unsignedInteger);
        return fromIntBits(i2 + unsignedInteger.value);
    }

    public UnsignedInteger times(UnsignedInteger unsignedInteger) {
        int i2 = this.value;
        n.p(unsignedInteger);
        return fromIntBits(i2 * unsignedInteger.value);
    }

    public String toString() {
        return toString(10);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    public int compareTo(UnsignedInteger unsignedInteger) {
        n.p(unsignedInteger);
        return UnsignedInts.a(this.value, unsignedInteger.value);
    }

    public String toString(int i2) {
        return UnsignedInts.g(this.value, i2);
    }

    public static UnsignedInteger valueOf(BigInteger bigInteger) {
        n.p(bigInteger);
        n.k(bigInteger.signum() >= 0 && bigInteger.bitLength() <= 32, "value (%s) is outside the range for an unsigned integer value", bigInteger);
        return fromIntBits(bigInteger.intValue());
    }

    public static UnsignedInteger valueOf(String str) {
        return valueOf(str, 10);
    }

    public static UnsignedInteger valueOf(String str, int i2) {
        return fromIntBits(UnsignedInts.d(str, i2));
    }
}
