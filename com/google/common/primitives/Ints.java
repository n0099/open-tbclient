package com.google.common.primitives;

import com.baidu.android.common.others.lang.StringUtil;
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
/* loaded from: classes6.dex */
public final class Ints {

    /* loaded from: classes6.dex */
    public static class IntArrayAsList extends AbstractList<Integer> implements RandomAccess, Serializable {
        public static final long serialVersionUID = 0;
        public final int[] array;
        public final int end;
        public final int start;

        public IntArrayAsList(int[] iArr) {
            this(iArr, 0, iArr.length);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return (obj instanceof Integer) && Ints.g(this.array, ((Integer) obj).intValue(), this.start, this.end) != -1;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof IntArrayAsList) {
                IntArrayAsList intArrayAsList = (IntArrayAsList) obj;
                int size = size();
                if (intArrayAsList.size() != size) {
                    return false;
                }
                for (int i = 0; i < size; i++) {
                    if (this.array[this.start + i] != intArrayAsList.array[intArrayAsList.start + i]) {
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
                int i3 = this.array[i2];
                Ints.f(i3);
                i = (i * 31) + i3;
            }
            return i;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            int g2;
            if (!(obj instanceof Integer) || (g2 = Ints.g(this.array, ((Integer) obj).intValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return g2 - this.start;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            int h2;
            if (!(obj instanceof Integer) || (h2 = Ints.h(this.array, ((Integer) obj).intValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return h2 - this.start;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.end - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Integer> subList(int i, int i2) {
            n.v(i, i2, size());
            if (i == i2) {
                return Collections.emptyList();
            }
            int[] iArr = this.array;
            int i3 = this.start;
            return new IntArrayAsList(iArr, i + i3, i3 + i2);
        }

        public int[] toIntArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 5);
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

        public IntArrayAsList(int[] iArr, int i, int i2) {
            this.array = iArr;
            this.start = i;
            this.end = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.AbstractList, java.util.List
        public Integer get(int i) {
            n.n(i, size());
            return Integer.valueOf(this.array[this.start + i]);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.AbstractList, java.util.List
        public Integer set(int i, Integer num) {
            n.n(i, size());
            int[] iArr = this.array;
            int i2 = this.start;
            int i3 = iArr[i2 + i];
            n.p(num);
            iArr[i2 + i] = num.intValue();
            return Integer.valueOf(i3);
        }
    }

    /* loaded from: classes6.dex */
    public static final class IntConverter extends Converter<String, Integer> implements Serializable {
        public static final IntConverter INSTANCE = new IntConverter();
        public static final long serialVersionUID = 1;

        private Object readResolve() {
            return INSTANCE;
        }

        public String toString() {
            return "Ints.stringConverter()";
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.base.Converter
        public String doBackward(Integer num) {
            return num.toString();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.base.Converter
        public Integer doForward(String str) {
            return Integer.decode(str);
        }
    }

    /* loaded from: classes6.dex */
    public enum LexicographicalComparator implements Comparator<int[]> {
        INSTANCE;

        @Override // java.lang.Enum
        public String toString() {
            return "Ints.lexicographicalComparator()";
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        public int compare(int[] iArr, int[] iArr2) {
            int min = Math.min(iArr.length, iArr2.length);
            for (int i = 0; i < min; i++) {
                int d2 = Ints.d(iArr[i], iArr2[i]);
                if (d2 != 0) {
                    return d2;
                }
            }
            return iArr.length - iArr2.length;
        }
    }

    public static int c(long j) {
        int i = (int) j;
        n.h(((long) i) == j, "Out of range: %s", j);
        return i;
    }

    public static int d(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i > i2 ? 1 : 0;
    }

    public static int e(byte b2, byte b3, byte b4, byte b5) {
        return (b2 << 24) | ((b3 & 255) << 16) | ((b4 & 255) << 8) | (b5 & 255);
    }

    public static int f(int i) {
        return i;
    }

    public static int g(int[] iArr, int i, int i2, int i3) {
        while (i2 < i3) {
            if (iArr[i2] == i) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static int h(int[] iArr, int i, int i2, int i3) {
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            if (iArr[i4] == i) {
                return i4;
            }
        }
        return -1;
    }

    public static int i(int... iArr) {
        n.d(iArr.length > 0);
        int i = iArr[0];
        for (int i2 = 1; i2 < iArr.length; i2++) {
            if (iArr[i2] < i) {
                i = iArr[i2];
            }
        }
        return i;
    }

    public static int j(long j) {
        if (j > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (j < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j;
    }

    public static int[] k(Collection<? extends Number> collection) {
        if (collection instanceof IntArrayAsList) {
            return ((IntArrayAsList) collection).toIntArray();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            Object obj = array[i];
            n.p(obj);
            iArr[i] = ((Number) obj).intValue();
        }
        return iArr;
    }
}
