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
public final class ImmutableLongArray implements Serializable {
    public static final ImmutableLongArray EMPTY = new ImmutableLongArray(new long[0]);
    public final long[] array;
    public final int end;
    public final transient int start;

    /* loaded from: classes6.dex */
    public static class AsList extends AbstractList<Long> implements RandomAccess, Serializable {
        public final ImmutableLongArray parent;

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
                    if (obj2 instanceof Long) {
                        int i3 = i2 + 1;
                        if (this.parent.array[i2] == ((Long) obj2).longValue()) {
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
            if (obj instanceof Long) {
                return this.parent.indexOf(((Long) obj).longValue());
            }
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            if (obj instanceof Long) {
                return this.parent.lastIndexOf(((Long) obj).longValue());
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.parent.length();
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Long> subList(int i2, int i3) {
            return this.parent.subArray(i2, i3).asList();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return this.parent.toString();
        }

        public AsList(ImmutableLongArray immutableLongArray) {
            this.parent = immutableLongArray;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.AbstractList, java.util.List
        public Long get(int i2) {
            return Long.valueOf(this.parent.get(i2));
        }
    }

    /* loaded from: classes6.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public long[] f31565a;

        /* renamed from: b  reason: collision with root package name */
        public int f31566b = 0;

        public b(int i2) {
            this.f31565a = new long[i2];
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

        public b a(long j) {
            e(1);
            long[] jArr = this.f31565a;
            int i2 = this.f31566b;
            jArr[i2] = j;
            this.f31566b = i2 + 1;
            return this;
        }

        public b b(Iterable<Long> iterable) {
            if (iterable instanceof Collection) {
                c((Collection) iterable);
                return this;
            }
            for (Long l : iterable) {
                a(l.longValue());
            }
            return this;
        }

        public b c(Collection<Long> collection) {
            e(collection.size());
            for (Long l : collection) {
                long[] jArr = this.f31565a;
                int i2 = this.f31566b;
                this.f31566b = i2 + 1;
                jArr[i2] = l.longValue();
            }
            return this;
        }

        public ImmutableLongArray d() {
            return this.f31566b == 0 ? ImmutableLongArray.EMPTY : new ImmutableLongArray(this.f31565a, 0, this.f31566b);
        }

        public final void e(int i2) {
            int i3 = this.f31566b + i2;
            long[] jArr = this.f31565a;
            if (i3 > jArr.length) {
                long[] jArr2 = new long[f(jArr.length, i3)];
                System.arraycopy(this.f31565a, 0, jArr2, 0, this.f31566b);
                this.f31565a = jArr2;
            }
        }
    }

    public static b builder(int i2) {
        n.f(i2 >= 0, "Invalid initialCapacity: %s", i2);
        return new b(i2);
    }

    public static ImmutableLongArray copyOf(long[] jArr) {
        return jArr.length == 0 ? EMPTY : new ImmutableLongArray(Arrays.copyOf(jArr, jArr.length));
    }

    private boolean isPartialView() {
        return this.start > 0 || this.end < this.array.length;
    }

    public static ImmutableLongArray of() {
        return EMPTY;
    }

    public List<Long> asList() {
        return new AsList();
    }

    public boolean contains(long j) {
        return indexOf(j) >= 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ImmutableLongArray) {
            ImmutableLongArray immutableLongArray = (ImmutableLongArray) obj;
            if (length() != immutableLongArray.length()) {
                return false;
            }
            for (int i2 = 0; i2 < length(); i2++) {
                if (get(i2) != immutableLongArray.get(i2)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public long get(int i2) {
        n.n(i2, length());
        return this.array[this.start + i2];
    }

    public int hashCode() {
        int i2 = 1;
        for (int i3 = this.start; i3 < this.end; i3++) {
            i2 = (i2 * 31) + Longs.e(this.array[i3]);
        }
        return i2;
    }

    public int indexOf(long j) {
        for (int i2 = this.start; i2 < this.end; i2++) {
            if (this.array[i2] == j) {
                return i2 - this.start;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.end == this.start;
    }

    public int lastIndexOf(long j) {
        int i2 = this.end;
        while (true) {
            i2--;
            int i3 = this.start;
            if (i2 < i3) {
                return -1;
            }
            if (this.array[i2] == j) {
                return i2 - i3;
            }
        }
    }

    public int length() {
        return this.end - this.start;
    }

    public Object readResolve() {
        return isEmpty() ? EMPTY : this;
    }

    public ImmutableLongArray subArray(int i2, int i3) {
        n.v(i2, i3, length());
        if (i2 == i3) {
            return EMPTY;
        }
        long[] jArr = this.array;
        int i4 = this.start;
        return new ImmutableLongArray(jArr, i2 + i4, i4 + i3);
    }

    public long[] toArray() {
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

    public ImmutableLongArray trimmed() {
        return isPartialView() ? new ImmutableLongArray(toArray()) : this;
    }

    public Object writeReplace() {
        return trimmed();
    }

    public ImmutableLongArray(long[] jArr) {
        this(jArr, 0, jArr.length);
    }

    public static ImmutableLongArray of(long j) {
        return new ImmutableLongArray(new long[]{j});
    }

    public ImmutableLongArray(long[] jArr, int i2, int i3) {
        this.array = jArr;
        this.start = i2;
        this.end = i3;
    }

    public static b builder() {
        return new b(10);
    }

    public static ImmutableLongArray copyOf(Collection<Long> collection) {
        return collection.isEmpty() ? EMPTY : new ImmutableLongArray(Longs.h(collection));
    }

    public static ImmutableLongArray of(long j, long j2) {
        return new ImmutableLongArray(new long[]{j, j2});
    }

    public static ImmutableLongArray copyOf(Iterable<Long> iterable) {
        if (iterable instanceof Collection) {
            return copyOf((Collection<Long>) iterable);
        }
        b builder = builder();
        builder.b(iterable);
        return builder.d();
    }

    public static ImmutableLongArray of(long j, long j2, long j3) {
        return new ImmutableLongArray(new long[]{j, j2, j3});
    }

    public static ImmutableLongArray of(long j, long j2, long j3, long j4) {
        return new ImmutableLongArray(new long[]{j, j2, j3, j4});
    }

    public static ImmutableLongArray of(long j, long j2, long j3, long j4, long j5) {
        return new ImmutableLongArray(new long[]{j, j2, j3, j4, j5});
    }

    public static ImmutableLongArray of(long j, long j2, long j3, long j4, long j5, long j6) {
        return new ImmutableLongArray(new long[]{j, j2, j3, j4, j5, j6});
    }

    public static ImmutableLongArray of(long j, long... jArr) {
        n.e(jArr.length <= 2147483646, "the total number of elements must fit in an int");
        long[] jArr2 = new long[jArr.length + 1];
        jArr2[0] = j;
        System.arraycopy(jArr, 0, jArr2, 1, jArr.length);
        return new ImmutableLongArray(jArr2);
    }
}
