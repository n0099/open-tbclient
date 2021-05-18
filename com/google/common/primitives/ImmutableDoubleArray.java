package com.google.common.primitives;

import com.baidu.android.common.others.lang.StringUtil;
import d.g.c.a.n;
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
                int i2 = this.parent.start;
                for (Object obj2 : list) {
                    if (obj2 instanceof Double) {
                        int i3 = i2 + 1;
                        if (ImmutableDoubleArray.areEqual(this.parent.array[i2], ((Double) obj2).doubleValue())) {
                            i2 = i3;
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
        public List<Double> subList(int i2, int i3) {
            return this.parent.subArray(i2, i3).asList();
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
        public Double get(int i2) {
            return Double.valueOf(this.parent.get(i2));
        }
    }

    /* loaded from: classes6.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public double[] f31443a;

        /* renamed from: b  reason: collision with root package name */
        public int f31444b = 0;

        public b(int i2) {
            this.f31443a = new double[i2];
        }

        public static int f(int i2, int i3) {
            if (i3 >= 0) {
                int i4 = i2 + (i2 >> 1) + 1;
                if (i4 < i3) {
                    i4 = Integer.highestOneBit(i3 - 1) << 1;
                }
                if (i4 < 0) {
                    return Integer.MAX_VALUE;
                }
                return i4;
            }
            throw new AssertionError("cannot store more than MAX_VALUE elements");
        }

        public b a(double d2) {
            e(1);
            double[] dArr = this.f31443a;
            int i2 = this.f31444b;
            dArr[i2] = d2;
            this.f31444b = i2 + 1;
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
                double[] dArr = this.f31443a;
                int i2 = this.f31444b;
                this.f31444b = i2 + 1;
                dArr[i2] = d2.doubleValue();
            }
            return this;
        }

        public ImmutableDoubleArray d() {
            return this.f31444b == 0 ? ImmutableDoubleArray.EMPTY : new ImmutableDoubleArray(this.f31443a, 0, this.f31444b);
        }

        public final void e(int i2) {
            int i3 = this.f31444b + i2;
            double[] dArr = this.f31443a;
            if (i3 > dArr.length) {
                double[] dArr2 = new double[f(dArr.length, i3)];
                System.arraycopy(this.f31443a, 0, dArr2, 0, this.f31444b);
                this.f31443a = dArr2;
            }
        }
    }

    public static boolean areEqual(double d2, double d3) {
        return Double.doubleToLongBits(d2) == Double.doubleToLongBits(d3);
    }

    public static b builder(int i2) {
        n.f(i2 >= 0, "Invalid initialCapacity: %s", i2);
        return new b(i2);
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
            for (int i2 = 0; i2 < length(); i2++) {
                if (!areEqual(get(i2), immutableDoubleArray.get(i2))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public double get(int i2) {
        n.n(i2, length());
        return this.array[this.start + i2];
    }

    public int hashCode() {
        int i2 = 1;
        for (int i3 = this.start; i3 < this.end; i3++) {
            i2 = (i2 * 31) + Doubles.d(this.array[i3]);
        }
        return i2;
    }

    public int indexOf(double d2) {
        for (int i2 = this.start; i2 < this.end; i2++) {
            if (areEqual(this.array[i2], d2)) {
                return i2 - this.start;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.end == this.start;
    }

    public int lastIndexOf(double d2) {
        int i2 = this.end;
        while (true) {
            i2--;
            if (i2 < this.start) {
                return -1;
            }
            if (areEqual(this.array[i2], d2)) {
                return i2 - this.start;
            }
        }
    }

    public int length() {
        return this.end - this.start;
    }

    public Object readResolve() {
        return isEmpty() ? EMPTY : this;
    }

    public ImmutableDoubleArray subArray(int i2, int i3) {
        n.v(i2, i3, length());
        if (i2 == i3) {
            return EMPTY;
        }
        double[] dArr = this.array;
        int i4 = this.start;
        return new ImmutableDoubleArray(dArr, i2 + i4, i4 + i3);
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
        int i2 = this.start;
        while (true) {
            i2++;
            if (i2 < this.end) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(this.array[i2]);
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

    public ImmutableDoubleArray(double[] dArr, int i2, int i3) {
        this.array = dArr;
        this.start = i2;
        this.end = i3;
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
