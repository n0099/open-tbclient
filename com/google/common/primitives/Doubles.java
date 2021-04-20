package com.google.common.primitives;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.FieldBuilder;
import com.google.common.base.Converter;
import d.g.c.a.n;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import java.util.regex.Pattern;
/* loaded from: classes6.dex */
public final class Doubles {

    /* loaded from: classes6.dex */
    public static class DoubleArrayAsList extends AbstractList<Double> implements RandomAccess, Serializable {
        public static final long serialVersionUID = 0;
        public final double[] array;
        public final int end;
        public final int start;

        public DoubleArrayAsList(double[] dArr) {
            this(dArr, 0, dArr.length);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return (obj instanceof Double) && Doubles.e(this.array, ((Double) obj).doubleValue(), this.start, this.end) != -1;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof DoubleArrayAsList) {
                DoubleArrayAsList doubleArrayAsList = (DoubleArrayAsList) obj;
                int size = size();
                if (doubleArrayAsList.size() != size) {
                    return false;
                }
                for (int i = 0; i < size; i++) {
                    if (this.array[this.start + i] != doubleArrayAsList.array[doubleArrayAsList.start + i]) {
                        return false;
                    }
                }
                return true;
            }
            return super.equals(obj);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int i = 1;
            for (int i2 = this.start; i2 < this.end; i2++) {
                i = (i * 31) + Doubles.d(this.array[i2]);
            }
            return i;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            int e2;
            if (!(obj instanceof Double) || (e2 = Doubles.e(this.array, ((Double) obj).doubleValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return e2 - this.start;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            int g2;
            if (!(obj instanceof Double) || (g2 = Doubles.g(this.array, ((Double) obj).doubleValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return g2 - this.start;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.end - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Double> subList(int i, int i2) {
            n.v(i, i2, size());
            if (i == i2) {
                return Collections.emptyList();
            }
            double[] dArr = this.array;
            int i3 = this.start;
            return new DoubleArrayAsList(dArr, i + i3, i3 + i2);
        }

        public double[] toDoubleArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 12);
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

        public DoubleArrayAsList(double[] dArr, int i, int i2) {
            this.array = dArr;
            this.start = i;
            this.end = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.AbstractList, java.util.List
        public Double get(int i) {
            n.n(i, size());
            return Double.valueOf(this.array[this.start + i]);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.AbstractList, java.util.List
        public Double set(int i, Double d2) {
            n.n(i, size());
            double[] dArr = this.array;
            int i2 = this.start;
            double d3 = dArr[i2 + i];
            n.p(d2);
            dArr[i2 + i] = d2.doubleValue();
            return Double.valueOf(d3);
        }
    }

    /* loaded from: classes6.dex */
    public static final class DoubleConverter extends Converter<String, Double> implements Serializable {
        public static final DoubleConverter INSTANCE = new DoubleConverter();
        public static final long serialVersionUID = 1;

        private Object readResolve() {
            return INSTANCE;
        }

        public String toString() {
            return "Doubles.stringConverter()";
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.base.Converter
        public String doBackward(Double d2) {
            return d2.toString();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.base.Converter
        public Double doForward(String str) {
            return Double.valueOf(str);
        }
    }

    /* loaded from: classes6.dex */
    public enum LexicographicalComparator implements Comparator<double[]> {
        INSTANCE;

        @Override // java.lang.Enum
        public String toString() {
            return "Doubles.lexicographicalComparator()";
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        public int compare(double[] dArr, double[] dArr2) {
            int min = Math.min(dArr.length, dArr2.length);
            for (int i = 0; i < min; i++) {
                int compare = Double.compare(dArr[i], dArr2[i]);
                if (compare != 0) {
                    return compare;
                }
            }
            return dArr.length - dArr2.length;
        }
    }

    static {
        c();
    }

    public static Pattern c() {
        return Pattern.compile(("[+-]?(?:NaN|Infinity|" + ("(?:\\d+#(?:\\.\\d*#)?|\\.\\d+#)(?:[eE][+-]?\\d+#)?[fFdD]?") + FieldBuilder.SE + ("0[xX](?:[0-9a-fA-F]+#(?:\\.[0-9a-fA-F]*#)?|\\.[0-9a-fA-F]+#)[pP][+-]?\\d+#[fFdD]?") + SmallTailInfo.EMOTION_SUFFIX).replace("#", "+"));
    }

    public static int d(double d2) {
        return Double.valueOf(d2).hashCode();
    }

    public static int e(double[] dArr, double d2, int i, int i2) {
        while (i < i2) {
            if (dArr[i] == d2) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static boolean f(double d2) {
        return Double.NEGATIVE_INFINITY < d2 && d2 < Double.POSITIVE_INFINITY;
    }

    public static int g(double[] dArr, double d2, int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            if (dArr[i3] == d2) {
                return i3;
            }
        }
        return -1;
    }

    public static double[] h(Collection<? extends Number> collection) {
        if (collection instanceof DoubleArrayAsList) {
            return ((DoubleArrayAsList) collection).toDoubleArray();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        double[] dArr = new double[length];
        for (int i = 0; i < length; i++) {
            Object obj = array[i];
            n.p(obj);
            dArr[i] = ((Number) obj).doubleValue();
        }
        return dArr;
    }
}
