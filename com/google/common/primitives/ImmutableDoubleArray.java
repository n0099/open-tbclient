package com.google.common.primitives;

import com.baidu.android.common.others.lang.StringUtil;
import d.h.c.a.n;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;
/* loaded from: classes6.dex */
public final class ImmutableDoubleArray implements Serializable {
    public static final ImmutableDoubleArray EMPTY = new ImmutableDoubleArray(new double[0]);
    public final double[] array;
    public final int end;
    public final transient int start;

    /* loaded from: classes6.dex */
    public static class AsList extends AbstractList<Double> implements RandomAccess, Serializable {
        public final ImmutableDoubleArray parent;

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return indexOf(obj) >= 0;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(Object obj) {
            if (obj instanceof AsList) {
                return this.parent.equals(((AsList) obj).parent);
            }
            if (obj instanceof List) {
                List list = (List) obj;
                if (size() != list.size()) {
                    return false;
                }
                int i = this.parent.start;
                for (Object obj2 : list) {
                    if (obj2 instanceof Double) {
                        int i2 = i + 1;
                        if (ImmutableDoubleArray.areEqual(this.parent.array[i], ((Double) obj2).doubleValue())) {
                            i = i2;
                        }
                    }
                    return false;
                }
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            return this.parent.hashCode();
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            if (obj instanceof Double) {
                return this.parent.indexOf(((Double) obj).doubleValue());
            }
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            if (obj instanceof Double) {
                return this.parent.lastIndexOf(((Double) obj).doubleValue());
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.parent.length();
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Double> subList(int i, int i2) {
            return this.parent.subArray(i, i2).asList();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return this.parent.toString();
        }

        public AsList(ImmutableDoubleArray immutableDoubleArray) {
            this.parent = immutableDoubleArray;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.AbstractList, java.util.List
        public Double get(int i) {
            return Double.valueOf(this.parent.get(i));
        }
    }

    /* loaded from: classes6.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public double[] f31219a;

        /* renamed from: b  reason: collision with root package name */
        public int f31220b = 0;

        public b(int i) {
            this.f31219a = new double[i];
        }

        public static int f(int i, int i2) {
            if (i2 >= 0) {
                int i3 = i + (i >> 1) + 1;
                if (i3 < i2) {
                    i3 = Integer.highestOneBit(i2 - 1) << 1;
                }
                if (i3 < 0) {
                    return Integer.MAX_VALUE;
                }
                return i3;
            }
            throw new AssertionError("cannot store more than MAX_VALUE elements");
        }

        public b a(double d2) {
            e(1);
            double[] dArr = this.f31219a;
            int i = this.f31220b;
            dArr[i] = d2;
            this.f31220b = i + 1;
            return this;
        }

        public b b(Iterable<Double> iterable) {
            if (iterable instanceof Collection) {
                c((Collection) iterable);
                return this;
            }
            for (Double d2 : iterable) {
                a(d2.doubleValue());
            }
            return this;
        }

        public b c(Collection<Double> collection) {
            e(collection.size());
            for (Double d2 : collection) {
                double[] dArr = this.f31219a;
                int i = this.f31220b;
                this.f31220b = i + 1;
                dArr[i] = d2.doubleValue();
            }
            return this;
        }

        public ImmutableDoubleArray d() {
            return this.f31220b == 0 ? ImmutableDoubleArray.EMPTY : new ImmutableDoubleArray(this.f31219a, 0, this.f31220b);
        }

        public final void e(int i) {
            int i2 = this.f31220b + i;
            double[] dArr = this.f31219a;
            if (i2 > dArr.length) {
                double[] dArr2 = new double[f(dArr.length, i2)];
                System.arraycopy(this.f31219a, 0, dArr2, 0, this.f31220b);
                this.f31219a = dArr2;
            }
        }
    }

    public static boolean areEqual(double d2, double d3) {
        return Double.doubleToLongBits(d2) == Double.doubleToLongBits(d3);
    }

    public static b builder(int i) {
        n.f(i >= 0, "Invalid initialCapacity: %s", i);
        return new b(i);
    }

    public static ImmutableDoubleArray copyOf(double[] dArr) {
        return dArr.length == 0 ? EMPTY : new ImmutableDoubleArray(Arrays.copyOf(dArr, dArr.length));
    }

    private boolean isPartialView() {
        return this.start > 0 || this.end < this.array.length;
    }

    public static ImmutableDoubleArray of() {
        return EMPTY;
    }

    public List<Double> asList() {
        return new AsList();
    }

    public boolean contains(double d2) {
        return indexOf(d2) >= 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ImmutableDoubleArray) {
            ImmutableDoubleArray immutableDoubleArray = (ImmutableDoubleArray) obj;
            if (length() != immutableDoubleArray.length()) {
                return false;
            }
            for (int i = 0; i < length(); i++) {
                if (!areEqual(get(i), immutableDoubleArray.get(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public double get(int i) {
        n.n(i, length());
        return this.array[this.start + i];
    }

    public int hashCode() {
        int i = 1;
        for (int i2 = this.start; i2 < this.end; i2++) {
            i = (i * 31) + Doubles.d(this.array[i2]);
        }
        return i;
    }

    public int indexOf(double d2) {
        for (int i = this.start; i < this.end; i++) {
            if (areEqual(this.array[i], d2)) {
                return i - this.start;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.end == this.start;
    }

    public int lastIndexOf(double d2) {
        int i = this.end;
        while (true) {
            i--;
            if (i < this.start) {
                return -1;
            }
            if (areEqual(this.array[i], d2)) {
                return i - this.start;
            }
        }
    }

    public int length() {
        return this.end - this.start;
    }

    public Object readResolve() {
        return isEmpty() ? EMPTY : this;
    }

    public ImmutableDoubleArray subArray(int i, int i2) {
        n.v(i, i2, length());
        if (i == i2) {
            return EMPTY;
        }
        double[] dArr = this.array;
        int i3 = this.start;
        return new ImmutableDoubleArray(dArr, i + i3, i3 + i2);
    }

    public double[] toArray() {
        return Arrays.copyOfRange(this.array, this.start, this.end);
    }

    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder(length() * 5);
        sb.append('[');
        sb.append(this.array[this.start]);
        int i = this.start;
        while (true) {
            i++;
            if (i < this.end) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(this.array[i]);
            } else {
                sb.append(']');
                return sb.toString();
            }
        }
    }

    public ImmutableDoubleArray trimmed() {
        return isPartialView() ? new ImmutableDoubleArray(toArray()) : this;
    }

    public Object writeReplace() {
        return trimmed();
    }

    public ImmutableDoubleArray(double[] dArr) {
        this(dArr, 0, dArr.length);
    }

    public static ImmutableDoubleArray of(double d2) {
        return new ImmutableDoubleArray(new double[]{d2});
    }

    public ImmutableDoubleArray(double[] dArr, int i, int i2) {
        this.array = dArr;
        this.start = i;
        this.end = i2;
    }

    public static b builder() {
        return new b(10);
    }

    public static ImmutableDoubleArray copyOf(Collection<Double> collection) {
        return collection.isEmpty() ? EMPTY : new ImmutableDoubleArray(Doubles.h(collection));
    }

    public static ImmutableDoubleArray of(double d2, double d3) {
        return new ImmutableDoubleArray(new double[]{d2, d3});
    }

    public static ImmutableDoubleArray copyOf(Iterable<Double> iterable) {
        if (iterable instanceof Collection) {
            return copyOf((Collection<Double>) iterable);
        }
        b builder = builder();
        builder.b(iterable);
        return builder.d();
    }

    public static ImmutableDoubleArray of(double d2, double d3, double d4) {
        return new ImmutableDoubleArray(new double[]{d2, d3, d4});
    }

    public static ImmutableDoubleArray of(double d2, double d3, double d4, double d5) {
        return new ImmutableDoubleArray(new double[]{d2, d3, d4, d5});
    }

    public static ImmutableDoubleArray of(double d2, double d3, double d4, double d5, double d6) {
        return new ImmutableDoubleArray(new double[]{d2, d3, d4, d5, d6});
    }

    public static ImmutableDoubleArray of(double d2, double d3, double d4, double d5, double d6, double d7) {
        return new ImmutableDoubleArray(new double[]{d2, d3, d4, d5, d6, d7});
    }

    public static ImmutableDoubleArray of(double d2, double... dArr) {
        n.e(dArr.length <= 2147483646, "the total number of elements must fit in an int");
        double[] dArr2 = new double[dArr.length + 1];
        dArr2[0] = d2;
        System.arraycopy(dArr, 0, dArr2, 1, dArr.length);
        return new ImmutableDoubleArray(dArr2);
    }
}
