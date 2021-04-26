package com.google.common.primitives;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.FieldBuilder;
import com.google.android.material.badge.BadgeDrawable;
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
                for (int i2 = 0; i2 < size; i2++) {
                    if (this.array[this.start + i2] != doubleArrayAsList.array[doubleArrayAsList.start + i2]) {
                        return false;
                    }
                }
                return true;
            }
            return super.equals(obj);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int i2 = 1;
            for (int i3 = this.start; i3 < this.end; i3++) {
                i2 = (i2 * 31) + Doubles.d(this.array[i3]);
            }
            return i2;
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
        public List<Double> subList(int i2, int i3) {
            n.v(i2, i3, size());
            if (i2 == i3) {
                return Collections.emptyList();
            }
            double[] dArr = this.array;
            int i4 = this.start;
            return new DoubleArrayAsList(dArr, i2 + i4, i4 + i3);
        }

        public double[] toDoubleArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 12);
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

        public DoubleArrayAsList(double[] dArr, int i2, int i3) {
            this.array = dArr;
            this.start = i2;
            this.end = i3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.AbstractList, java.util.List
        public Double get(int i2) {
            n.n(i2, size());
            return Double.valueOf(this.array[this.start + i2]);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.AbstractList, java.util.List
        public Double set(int i2, Double d2) {
            n.n(i2, size());
            double[] dArr = this.array;
            int i3 = this.start;
            double d3 = dArr[i3 + i2];
            n.p(d2);
            dArr[i3 + i2] = d2.doubleValue();
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
            for (int i2 = 0; i2 < min; i2++) {
                int compare = Double.compare(dArr[i2], dArr2[i2]);
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
        return Pattern.compile(("[+-]?(?:NaN|Infinity|" + ("(?:\\d+#(?:\\.\\d*#)?|\\.\\d+#)(?:[eE][+-]?\\d+#)?[fFdD]?") + FieldBuilder.SE + ("0[xX](?:[0-9a-fA-F]+#(?:\\.[0-9a-fA-F]*#)?|\\.[0-9a-fA-F]+#)[pP][+-]?\\d+#[fFdD]?") + SmallTailInfo.EMOTION_SUFFIX).replace("#", BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX));
    }

    public static int d(double d2) {
        return Double.valueOf(d2).hashCode();
    }

    public static int e(double[] dArr, double d2, int i2, int i3) {
        while (i2 < i3) {
            if (dArr[i2] == d2) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static boolean f(double d2) {
        return Double.NEGATIVE_INFINITY < d2 && d2 < Double.POSITIVE_INFINITY;
    }

    public static int g(double[] dArr, double d2, int i2, int i3) {
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            if (dArr[i4] == d2) {
                return i4;
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
        for (int i2 = 0; i2 < length; i2++) {
            Object obj = array[i2];
            n.p(obj);
            dArr[i2] = ((Number) obj).doubleValue();
        }
        return dArr;
    }
}
