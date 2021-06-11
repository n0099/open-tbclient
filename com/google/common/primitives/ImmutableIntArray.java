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
public final class ImmutableIntArray implements Serializable {
    public static final ImmutableIntArray EMPTY = new ImmutableIntArray(new int[0]);
    public final int[] array;
    public final int end;
    public final transient int start;

    /* loaded from: classes6.dex */
    public static class AsList extends AbstractList<Integer> implements RandomAccess, Serializable {
        public final ImmutableIntArray parent;

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
                    if (obj2 instanceof Integer) {
                        int i3 = i2 + 1;
                        if (this.parent.array[i2] == ((Integer) obj2).intValue()) {
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
            if (obj instanceof Integer) {
                return this.parent.indexOf(((Integer) obj).intValue());
            }
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            if (obj instanceof Integer) {
                return this.parent.lastIndexOf(((Integer) obj).intValue());
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.parent.length();
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Integer> subList(int i2, int i3) {
            return this.parent.subArray(i2, i3).asList();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return this.parent.toString();
        }

        public AsList(ImmutableIntArray immutableIntArray) {
            this.parent = immutableIntArray;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.AbstractList, java.util.List
        public Integer get(int i2) {
            return Integer.valueOf(this.parent.get(i2));
        }
    }

    /* loaded from: classes6.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public int[] f31465a;

        /* renamed from: b  reason: collision with root package name */
        public int f31466b = 0;

        public b(int i2) {
            this.f31465a = new int[i2];
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

        public b a(int i2) {
            e(1);
            int[] iArr = this.f31465a;
            int i3 = this.f31466b;
            iArr[i3] = i2;
            this.f31466b = i3 + 1;
            return this;
        }

        public b b(Iterable<Integer> iterable) {
            if (iterable instanceof Collection) {
                c((Collection) iterable);
                return this;
            }
            for (Integer num : iterable) {
                a(num.intValue());
            }
            return this;
        }

        public b c(Collection<Integer> collection) {
            e(collection.size());
            for (Integer num : collection) {
                int[] iArr = this.f31465a;
                int i2 = this.f31466b;
                this.f31466b = i2 + 1;
                iArr[i2] = num.intValue();
            }
            return this;
        }

        public ImmutableIntArray d() {
            return this.f31466b == 0 ? ImmutableIntArray.EMPTY : new ImmutableIntArray(this.f31465a, 0, this.f31466b);
        }

        public final void e(int i2) {
            int i3 = this.f31466b + i2;
            int[] iArr = this.f31465a;
            if (i3 > iArr.length) {
                int[] iArr2 = new int[f(iArr.length, i3)];
                System.arraycopy(this.f31465a, 0, iArr2, 0, this.f31466b);
                this.f31465a = iArr2;
            }
        }
    }

    public static b builder(int i2) {
        n.f(i2 >= 0, "Invalid initialCapacity: %s", i2);
        return new b(i2);
    }

    public static ImmutableIntArray copyOf(int[] iArr) {
        return iArr.length == 0 ? EMPTY : new ImmutableIntArray(Arrays.copyOf(iArr, iArr.length));
    }

    private boolean isPartialView() {
        return this.start > 0 || this.end < this.array.length;
    }

    public static ImmutableIntArray of() {
        return EMPTY;
    }

    public List<Integer> asList() {
        return new AsList();
    }

    public boolean contains(int i2) {
        return indexOf(i2) >= 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ImmutableIntArray) {
            ImmutableIntArray immutableIntArray = (ImmutableIntArray) obj;
            if (length() != immutableIntArray.length()) {
                return false;
            }
            for (int i2 = 0; i2 < length(); i2++) {
                if (get(i2) != immutableIntArray.get(i2)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public int get(int i2) {
        n.n(i2, length());
        return this.array[this.start + i2];
    }

    public int hashCode() {
        int i2 = 1;
        for (int i3 = this.start; i3 < this.end; i3++) {
            int i4 = this.array[i3];
            Ints.f(i4);
            i2 = (i2 * 31) + i4;
        }
        return i2;
    }

    public int indexOf(int i2) {
        for (int i3 = this.start; i3 < this.end; i3++) {
            if (this.array[i3] == i2) {
                return i3 - this.start;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.end == this.start;
    }

    public int lastIndexOf(int i2) {
        int i3 = this.end;
        while (true) {
            i3--;
            int i4 = this.start;
            if (i3 < i4) {
                return -1;
            }
            if (this.array[i3] == i2) {
                return i3 - i4;
            }
        }
    }

    public int length() {
        return this.end - this.start;
    }

    public Object readResolve() {
        return isEmpty() ? EMPTY : this;
    }

    public ImmutableIntArray subArray(int i2, int i3) {
        n.v(i2, i3, length());
        if (i2 == i3) {
            return EMPTY;
        }
        int[] iArr = this.array;
        int i4 = this.start;
        return new ImmutableIntArray(iArr, i2 + i4, i4 + i3);
    }

    public int[] toArray() {
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

    public ImmutableIntArray trimmed() {
        return isPartialView() ? new ImmutableIntArray(toArray()) : this;
    }

    public Object writeReplace() {
        return trimmed();
    }

    public ImmutableIntArray(int[] iArr) {
        this(iArr, 0, iArr.length);
    }

    public static ImmutableIntArray copyOf(Collection<Integer> collection) {
        return collection.isEmpty() ? EMPTY : new ImmutableIntArray(Ints.k(collection));
    }

    public static ImmutableIntArray of(int i2) {
        return new ImmutableIntArray(new int[]{i2});
    }

    public ImmutableIntArray(int[] iArr, int i2, int i3) {
        this.array = iArr;
        this.start = i2;
        this.end = i3;
    }

    public static b builder() {
        return new b(10);
    }

    public static ImmutableIntArray copyOf(Iterable<Integer> iterable) {
        if (iterable instanceof Collection) {
            return copyOf((Collection<Integer>) iterable);
        }
        b builder = builder();
        builder.b(iterable);
        return builder.d();
    }

    public static ImmutableIntArray of(int i2, int i3) {
        return new ImmutableIntArray(new int[]{i2, i3});
    }

    public static ImmutableIntArray of(int i2, int i3, int i4) {
        return new ImmutableIntArray(new int[]{i2, i3, i4});
    }

    public static ImmutableIntArray of(int i2, int i3, int i4, int i5) {
        return new ImmutableIntArray(new int[]{i2, i3, i4, i5});
    }

    public static ImmutableIntArray of(int i2, int i3, int i4, int i5, int i6) {
        return new ImmutableIntArray(new int[]{i2, i3, i4, i5, i6});
    }

    public static ImmutableIntArray of(int i2, int i3, int i4, int i5, int i6, int i7) {
        return new ImmutableIntArray(new int[]{i2, i3, i4, i5, i6, i7});
    }

    public static ImmutableIntArray of(int i2, int... iArr) {
        n.e(iArr.length <= 2147483646, "the total number of elements must fit in an int");
        int[] iArr2 = new int[iArr.length + 1];
        iArr2[0] = i2;
        System.arraycopy(iArr, 0, iArr2, 1, iArr.length);
        return new ImmutableIntArray(iArr2);
    }
}
