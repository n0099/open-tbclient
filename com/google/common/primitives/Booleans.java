package com.google.common.primitives;

import d.g.c.a.n;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
/* loaded from: classes6.dex */
public final class Booleans {

    /* loaded from: classes6.dex */
    public static class BooleanArrayAsList extends AbstractList<Boolean> implements RandomAccess, Serializable {
        public static final long serialVersionUID = 0;
        public final boolean[] array;
        public final int end;
        public final int start;

        public BooleanArrayAsList(boolean[] zArr) {
            this(zArr, 0, zArr.length);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return (obj instanceof Boolean) && Booleans.e(this.array, ((Boolean) obj).booleanValue(), this.start, this.end) != -1;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof BooleanArrayAsList) {
                BooleanArrayAsList booleanArrayAsList = (BooleanArrayAsList) obj;
                int size = size();
                if (booleanArrayAsList.size() != size) {
                    return false;
                }
                for (int i2 = 0; i2 < size; i2++) {
                    if (this.array[this.start + i2] != booleanArrayAsList.array[booleanArrayAsList.start + i2]) {
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
                i2 = (i2 * 31) + Booleans.d(this.array[i3]);
            }
            return i2;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            int e2;
            if (!(obj instanceof Boolean) || (e2 = Booleans.e(this.array, ((Boolean) obj).booleanValue(), this.start, this.end)) < 0) {
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
            int f2;
            if (!(obj instanceof Boolean) || (f2 = Booleans.f(this.array, ((Boolean) obj).booleanValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return f2 - this.start;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.end - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Boolean> subList(int i2, int i3) {
            n.v(i2, i3, size());
            if (i2 == i3) {
                return Collections.emptyList();
            }
            boolean[] zArr = this.array;
            int i4 = this.start;
            return new BooleanArrayAsList(zArr, i2 + i4, i4 + i3);
        }

        public boolean[] toBooleanArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 7);
            sb.append(this.array[this.start] ? "[true" : "[false");
            int i2 = this.start;
            while (true) {
                i2++;
                if (i2 < this.end) {
                    sb.append(this.array[i2] ? ", true" : ", false");
                } else {
                    sb.append(']');
                    return sb.toString();
                }
            }
        }

        public BooleanArrayAsList(boolean[] zArr, int i2, int i3) {
            this.array = zArr;
            this.start = i2;
            this.end = i3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.AbstractList, java.util.List
        public Boolean get(int i2) {
            n.n(i2, size());
            return Boolean.valueOf(this.array[this.start + i2]);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.AbstractList, java.util.List
        public Boolean set(int i2, Boolean bool) {
            n.n(i2, size());
            boolean[] zArr = this.array;
            int i3 = this.start;
            boolean z = zArr[i3 + i2];
            n.p(bool);
            zArr[i3 + i2] = bool.booleanValue();
            return Boolean.valueOf(z);
        }
    }

    /* loaded from: classes6.dex */
    public enum BooleanComparator implements Comparator<Boolean> {
        TRUE_FIRST(1, "Booleans.trueFirst()"),
        FALSE_FIRST(-1, "Booleans.falseFirst()");
        
        public final String toString;
        public final int trueValue;

        BooleanComparator(int i2, String str) {
            this.trueValue = i2;
            this.toString = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.toString;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        public int compare(Boolean bool, Boolean bool2) {
            return (bool2.booleanValue() ? this.trueValue : 0) - (bool.booleanValue() ? this.trueValue : 0);
        }
    }

    /* loaded from: classes6.dex */
    public enum LexicographicalComparator implements Comparator<boolean[]> {
        INSTANCE;

        @Override // java.lang.Enum
        public String toString() {
            return "Booleans.lexicographicalComparator()";
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        public int compare(boolean[] zArr, boolean[] zArr2) {
            int min = Math.min(zArr.length, zArr2.length);
            for (int i2 = 0; i2 < min; i2++) {
                int c2 = Booleans.c(zArr[i2], zArr2[i2]);
                if (c2 != 0) {
                    return c2;
                }
            }
            return zArr.length - zArr2.length;
        }
    }

    public static int c(boolean z, boolean z2) {
        if (z == z2) {
            return 0;
        }
        return z ? 1 : -1;
    }

    public static int d(boolean z) {
        return z ? 1231 : 1237;
    }

    public static int e(boolean[] zArr, boolean z, int i2, int i3) {
        while (i2 < i3) {
            if (zArr[i2] == z) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static int f(boolean[] zArr, boolean z, int i2, int i3) {
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            if (zArr[i4] == z) {
                return i4;
            }
        }
        return -1;
    }
}
