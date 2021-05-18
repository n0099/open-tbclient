package com.google.common.collect;

import com.google.common.collect.Multisets;
import com.google.common.primitives.Ints;
import d.g.c.a.n;
import d.g.c.c.d;
import d.g.c.c.f0;
import d.g.c.c.i0;
import d.g.c.c.m;
import d.g.c.c.r0;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.Enum;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
/* loaded from: classes6.dex */
public final class EnumMultiset<E extends Enum<E>> extends d<E> implements Serializable {
    public static final long serialVersionUID = 0;
    public transient int[] counts;
    public transient int distinctElements;
    public transient E[] enumConstants;
    public transient long size;
    public transient Class<E> type;

    /* loaded from: classes6.dex */
    public class a extends EnumMultiset<E>.c<E> {
        public a() {
            super();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.EnumMultiset.c
        /* renamed from: b */
        public E a(int i2) {
            return (E) EnumMultiset.this.enumConstants[i2];
        }
    }

    /* loaded from: classes6.dex */
    public class b extends EnumMultiset<E>.c<i0.a<E>> {

        /* loaded from: classes6.dex */
        public class a extends Multisets.b<E> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f31060e;

            public a(int i2) {
                this.f31060e = i2;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.g.c.c.i0.a
            /* renamed from: a */
            public E getElement() {
                return (E) EnumMultiset.this.enumConstants[this.f31060e];
            }

            @Override // d.g.c.c.i0.a
            public int getCount() {
                return EnumMultiset.this.counts[this.f31060e];
            }
        }

        public b() {
            super();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.EnumMultiset.c
        /* renamed from: b */
        public i0.a<E> a(int i2) {
            return new a(i2);
        }
    }

    /* loaded from: classes6.dex */
    public abstract class c<T> implements Iterator<T> {

        /* renamed from: e  reason: collision with root package name */
        public int f31062e = 0;

        /* renamed from: f  reason: collision with root package name */
        public int f31063f = -1;

        public c() {
        }

        public abstract T a(int i2);

        @Override // java.util.Iterator
        public boolean hasNext() {
            while (this.f31062e < EnumMultiset.this.enumConstants.length) {
                int[] iArr = EnumMultiset.this.counts;
                int i2 = this.f31062e;
                if (iArr[i2] > 0) {
                    return true;
                }
                this.f31062e = i2 + 1;
            }
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext()) {
                T a2 = a(this.f31062e);
                int i2 = this.f31062e;
                this.f31063f = i2;
                this.f31062e = i2 + 1;
                return a2;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            m.e(this.f31063f >= 0);
            if (EnumMultiset.this.counts[this.f31063f] > 0) {
                EnumMultiset.access$210(EnumMultiset.this);
                EnumMultiset.this.size -= EnumMultiset.this.counts[this.f31063f];
                EnumMultiset.this.counts[this.f31063f] = 0;
            }
            this.f31063f = -1;
        }
    }

    public EnumMultiset(Class<E> cls) {
        this.type = cls;
        n.d(cls.isEnum());
        E[] enumConstants = cls.getEnumConstants();
        this.enumConstants = enumConstants;
        this.counts = new int[enumConstants.length];
    }

    public static /* synthetic */ int access$210(EnumMultiset enumMultiset) {
        int i2 = enumMultiset.distinctElements;
        enumMultiset.distinctElements = i2 - 1;
        return i2;
    }

    public static <E extends Enum<E>> EnumMultiset<E> create(Class<E> cls) {
        return new EnumMultiset<>(cls);
    }

    private boolean isActuallyE(Object obj) {
        if (obj instanceof Enum) {
            Enum r5 = (Enum) obj;
            int ordinal = r5.ordinal();
            E[] eArr = this.enumConstants;
            return ordinal < eArr.length && eArr[ordinal] == r5;
        }
        return false;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        Class<E> cls = (Class) objectInputStream.readObject();
        this.type = cls;
        E[] enumConstants = cls.getEnumConstants();
        this.enumConstants = enumConstants;
        this.counts = new int[enumConstants.length];
        r0.f(this, objectInputStream);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.type);
        r0.k(this, objectOutputStream);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.collect.EnumMultiset<E extends java.lang.Enum<E>> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // d.g.c.c.d, d.g.c.c.i0
    public /* bridge */ /* synthetic */ int add(Object obj, int i2) {
        return add((EnumMultiset<E>) ((Enum) obj), i2);
    }

    public void checkIsE(Object obj) {
        n.p(obj);
        if (isActuallyE(obj)) {
            return;
        }
        throw new ClassCastException("Expected an " + this.type + " but got " + obj);
    }

    @Override // d.g.c.c.d, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        Arrays.fill(this.counts, 0);
        this.size = 0L;
        this.distinctElements = 0;
    }

    @Override // d.g.c.c.d, java.util.AbstractCollection, java.util.Collection, d.g.c.c.i0
    public /* bridge */ /* synthetic */ boolean contains(Object obj) {
        return super.contains(obj);
    }

    @Override // d.g.c.c.i0
    public int count(Object obj) {
        if (obj == null || !isActuallyE(obj)) {
            return 0;
        }
        return this.counts[((Enum) obj).ordinal()];
    }

    @Override // d.g.c.c.d
    public int distinctElements() {
        return this.distinctElements;
    }

    @Override // d.g.c.c.d
    public Iterator<E> elementIterator() {
        return new a();
    }

    @Override // d.g.c.c.d, d.g.c.c.i0
    public /* bridge */ /* synthetic */ Set elementSet() {
        return super.elementSet();
    }

    @Override // d.g.c.c.d
    public Iterator<i0.a<E>> entryIterator() {
        return new b();
    }

    @Override // d.g.c.c.d, d.g.c.c.i0
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // d.g.c.c.d, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, d.g.c.c.i0
    public Iterator<E> iterator() {
        return Multisets.i(this);
    }

    @Override // d.g.c.c.d, d.g.c.c.i0
    public int remove(Object obj, int i2) {
        if (obj == null || !isActuallyE(obj)) {
            return 0;
        }
        Enum r1 = (Enum) obj;
        m.b(i2, "occurrences");
        if (i2 == 0) {
            return count(obj);
        }
        int ordinal = r1.ordinal();
        int[] iArr = this.counts;
        int i3 = iArr[ordinal];
        if (i3 == 0) {
            return 0;
        }
        if (i3 <= i2) {
            iArr[ordinal] = 0;
            this.distinctElements--;
            this.size -= i3;
        } else {
            iArr[ordinal] = i3 - i2;
            this.size -= i2;
        }
        return i3;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.collect.EnumMultiset<E extends java.lang.Enum<E>> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // d.g.c.c.d, d.g.c.c.i0
    public /* bridge */ /* synthetic */ int setCount(Object obj, int i2) {
        return setCount((EnumMultiset<E>) ((Enum) obj), i2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, d.g.c.c.i0
    public int size() {
        return Ints.j(this.size);
    }

    public static <E extends Enum<E>> EnumMultiset<E> create(Iterable<E> iterable) {
        Iterator<E> it = iterable.iterator();
        n.e(it.hasNext(), "EnumMultiset constructor passed empty Iterable");
        EnumMultiset<E> enumMultiset = new EnumMultiset<>(it.next().getDeclaringClass());
        f0.a(enumMultiset, iterable);
        return enumMultiset;
    }

    public int add(E e2, int i2) {
        checkIsE(e2);
        m.b(i2, "occurrences");
        if (i2 == 0) {
            return count(e2);
        }
        int ordinal = e2.ordinal();
        int i3 = this.counts[ordinal];
        long j = i2;
        long j2 = i3 + j;
        n.h(j2 <= 2147483647L, "too many occurrences: %s", j2);
        this.counts[ordinal] = (int) j2;
        if (i3 == 0) {
            this.distinctElements++;
        }
        this.size += j;
        return i3;
    }

    public int setCount(E e2, int i2) {
        checkIsE(e2);
        m.b(i2, "count");
        int ordinal = e2.ordinal();
        int[] iArr = this.counts;
        int i3 = iArr[ordinal];
        iArr[ordinal] = i2;
        this.size += i2 - i3;
        if (i3 == 0 && i2 > 0) {
            this.distinctElements++;
        } else if (i3 > 0 && i2 == 0) {
            this.distinctElements--;
        }
        return i3;
    }

    public static <E extends Enum<E>> EnumMultiset<E> create(Iterable<E> iterable, Class<E> cls) {
        EnumMultiset<E> create = create(cls);
        f0.a(create, iterable);
        return create;
    }
}
