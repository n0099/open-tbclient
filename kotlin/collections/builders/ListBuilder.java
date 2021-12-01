package kotlin.collections.builders;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.collections.AbstractMutableList;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableList;
import kotlin.jvm.internal.markers.KMutableListIterator;
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010+\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u00042\b\u0012\u0004\u0012\u0002H\u00010\u0005:\u0001QB\u0007\b\u0016¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tBM\b\u0002\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000\u0012\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000¢\u0006\u0002\u0010\u0012J\u0015\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0019J\u001d\u0010\u0017\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001cJ\u001e\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001fH\u0016J\u0016\u0010\u001d\u001a\u00020\u000f2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001fH\u0016J&\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001f2\u0006\u0010\"\u001a\u00020\bH\u0002J\u001d\u0010#\u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001cJ\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000%J\b\u0010&\u001a\u00020\u001aH\u0002J\b\u0010'\u001a\u00020\u001aH\u0016J\u0014\u0010(\u001a\u00020\u000f2\n\u0010)\u001a\u0006\u0012\u0002\b\u00030%H\u0002J\u0010\u0010*\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020\bH\u0002J\u0010\u0010,\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\bH\u0002J\u0013\u0010-\u001a\u00020\u000f2\b\u0010)\u001a\u0004\u0018\u00010.H\u0096\u0002J\u0016\u0010/\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\bH\u0096\u0002¢\u0006\u0002\u00100J\b\u00101\u001a\u00020\bH\u0016J\u0015\u00102\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00103J\u0018\u00104\u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\bH\u0002J\b\u00105\u001a\u00020\u000fH\u0016J\u000f\u00106\u001a\b\u0012\u0004\u0012\u00028\u000007H\u0096\u0002J\u0015\u00108\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00103J\u000e\u00109\u001a\b\u0012\u0004\u0012\u00028\u00000:H\u0016J\u0016\u00109\u001a\b\u0012\u0004\u0012\u00028\u00000:2\u0006\u0010\u001b\u001a\u00020\bH\u0016J\u0015\u0010;\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0019J\u0016\u0010<\u001a\u00020\u000f2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001fH\u0016J\u0015\u0010=\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\bH\u0016¢\u0006\u0002\u00100J\u0015\u0010>\u001a\u00028\u00002\u0006\u0010!\u001a\u00020\bH\u0002¢\u0006\u0002\u00100J\u0018\u0010?\u001a\u00020\u001a2\u0006\u0010@\u001a\u00020\b2\u0006\u0010A\u001a\u00020\bH\u0002J\u0016\u0010B\u001a\u00020\u000f2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001fH\u0016J.\u0010C\u001a\u00020\b2\u0006\u0010@\u001a\u00020\b2\u0006\u0010A\u001a\u00020\b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001f2\u0006\u0010D\u001a\u00020\u000fH\u0002J\u001e\u0010E\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010FJ\u001e\u0010G\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010H\u001a\u00020\b2\u0006\u0010I\u001a\u00020\bH\u0016J\u0015\u0010J\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010.0\u000bH\u0016¢\u0006\u0002\u0010KJ'\u0010J\u001a\b\u0012\u0004\u0012\u0002HL0\u000b\"\u0004\b\u0001\u0010L2\f\u0010M\u001a\b\u0012\u0004\u0012\u0002HL0\u000bH\u0016¢\u0006\u0002\u0010NJ\b\u0010O\u001a\u00020PH\u0016R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006R"}, d2 = {"Lkotlin/collections/builders/ListBuilder;", "E", "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "Lkotlin/collections/AbstractMutableList;", "()V", "initialCapacity", "", "(I)V", "array", "", "offset", "length", "isReadOnly", "", "backing", "root", "([Ljava/lang/Object;IIZLkotlin/collections/builders/ListBuilder;Lkotlin/collections/builders/ListBuilder;)V", "[Ljava/lang/Object;", "size", "getSize", "()I", "add", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "elements", "", "addAllInternal", "i", "n", "addAtInternal", "build", "", "checkIsMutable", "clear", "contentEquals", "other", "ensureCapacity", "minCapacity", "ensureExtraCapacity", "equals", "", "get", "(I)Ljava/lang/Object;", TTDownloadField.TT_HASHCODE, "indexOf", "(Ljava/lang/Object;)I", "insertAtInternal", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "remove", "removeAll", "removeAt", "removeAtInternal", "removeRangeInternal", "rangeOffset", "rangeLength", "retainAll", "retainOrRemoveAllInternal", "retain", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "subList", "fromIndex", "toIndex", "toArray", "()[Ljava/lang/Object;", "T", "destination", "([Ljava/lang/Object;)[Ljava/lang/Object;", "toString", "", "Itr", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class ListBuilder<E> extends AbstractMutableList<E> implements List<E>, RandomAccess, KMutableList {
    public E[] array;
    public final ListBuilder<E> backing;
    public boolean isReadOnly;
    public int length;
    public int offset;
    public final ListBuilder<E> root;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001d\b\u0016\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\fJ\t\u0010\r\u001a\u00020\u000eH\u0096\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u000e\u0010\u0010\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\r\u0010\u0013\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0011J\b\u0010\u0014\u001a\u00020\u0006H\u0016J\b\u0010\u0015\u001a\u00020\nH\u0016J\u0015\u0010\u0016\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lkotlin/collections/builders/ListBuilder$Itr;", "E", "", "list", "Lkotlin/collections/builders/ListBuilder;", "index", "", "(Lkotlin/collections/builders/ListBuilder;I)V", "lastIndex", "add", "", "element", "(Ljava/lang/Object;)V", "hasNext", "", "hasPrevious", "next", "()Ljava/lang/Object;", "nextIndex", "previous", "previousIndex", "remove", "set", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public static final class Itr<E> implements ListIterator<E>, KMutableListIterator {
        public int index;
        public int lastIndex;
        public final ListBuilder<E> list;

        public Itr(ListBuilder<E> list, int i2) {
            Intrinsics.checkNotNullParameter(list, "list");
            this.list = list;
            this.index = i2;
            this.lastIndex = -1;
        }

        @Override // java.util.ListIterator
        public void add(E e2) {
            ListBuilder<E> listBuilder = this.list;
            int i2 = this.index;
            this.index = i2 + 1;
            listBuilder.add(i2, e2);
            this.lastIndex = -1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.index < this.list.length;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.index > 0;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public E next() {
            if (this.index < this.list.length) {
                int i2 = this.index;
                this.index = i2 + 1;
                this.lastIndex = i2;
                return (E) this.list.array[this.list.offset + this.lastIndex];
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.index;
        }

        @Override // java.util.ListIterator
        public E previous() {
            int i2 = this.index;
            if (i2 > 0) {
                int i3 = i2 - 1;
                this.index = i3;
                this.lastIndex = i3;
                return (E) this.list.array[this.list.offset + this.lastIndex];
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.index - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            if (this.lastIndex != -1) {
                this.list.remove(this.lastIndex);
                this.index = this.lastIndex;
                this.lastIndex = -1;
                return;
            }
            throw new IllegalStateException("Call next() or previous() before removing element from the iterator.".toString());
        }

        @Override // java.util.ListIterator
        public void set(E e2) {
            if (this.lastIndex != -1) {
                this.list.set(this.lastIndex, e2);
                return;
            }
            throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.".toString());
        }
    }

    public ListBuilder(E[] eArr, int i2, int i3, boolean z, ListBuilder<E> listBuilder, ListBuilder<E> listBuilder2) {
        this.array = eArr;
        this.offset = i2;
        this.length = i3;
        this.isReadOnly = z;
        this.backing = listBuilder;
        this.root = listBuilder2;
    }

    private final void addAllInternal(int i2, Collection<? extends E> collection, int i3) {
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            listBuilder.addAllInternal(i2, collection, i3);
            this.array = this.backing.array;
            this.length += i3;
            return;
        }
        insertAtInternal(i2, i3);
        Iterator<? extends E> it = collection.iterator();
        for (int i4 = 0; i4 < i3; i4++) {
            this.array[i2 + i4] = it.next();
        }
    }

    private final void addAtInternal(int i2, E e2) {
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            listBuilder.addAtInternal(i2, e2);
            this.array = this.backing.array;
            this.length++;
            return;
        }
        insertAtInternal(i2, 1);
        this.array[i2] = e2;
    }

    private final void checkIsMutable() {
        ListBuilder<E> listBuilder;
        if (this.isReadOnly || ((listBuilder = this.root) != null && listBuilder.isReadOnly)) {
            throw new UnsupportedOperationException();
        }
    }

    private final boolean contentEquals(List<?> list) {
        boolean subarrayContentEquals;
        subarrayContentEquals = ListBuilderKt.subarrayContentEquals(this.array, this.offset, this.length, list);
        return subarrayContentEquals;
    }

    private final void ensureCapacity(int i2) {
        if (this.backing == null) {
            E[] eArr = this.array;
            if (i2 > eArr.length) {
                this.array = (E[]) ListBuilderKt.copyOfUninitializedElements(this.array, ArrayDeque.Companion.newCapacity$kotlin_stdlib(eArr.length, i2));
                return;
            }
            return;
        }
        throw new IllegalStateException();
    }

    private final void ensureExtraCapacity(int i2) {
        ensureCapacity(this.length + i2);
    }

    private final void insertAtInternal(int i2, int i3) {
        ensureExtraCapacity(i3);
        E[] eArr = this.array;
        ArraysKt___ArraysJvmKt.copyInto(eArr, eArr, i2 + i3, i2, this.offset + this.length);
        this.length += i3;
    }

    private final E removeAtInternal(int i2) {
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            this.length--;
            return listBuilder.removeAtInternal(i2);
        }
        E[] eArr = this.array;
        E e2 = eArr[i2];
        ArraysKt___ArraysJvmKt.copyInto(eArr, eArr, i2, i2 + 1, this.offset + this.length);
        ListBuilderKt.resetAt(this.array, (this.offset + this.length) - 1);
        this.length--;
        return e2;
    }

    private final void removeRangeInternal(int i2, int i3) {
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            listBuilder.removeRangeInternal(i2, i3);
        } else {
            E[] eArr = this.array;
            ArraysKt___ArraysJvmKt.copyInto(eArr, eArr, i2, i2 + i3, this.length);
            E[] eArr2 = this.array;
            int i4 = this.length;
            ListBuilderKt.resetRange(eArr2, i4 - i3, i4);
        }
        this.length -= i3;
    }

    private final int retainOrRemoveAllInternal(int i2, int i3, Collection<? extends E> collection, boolean z) {
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            int retainOrRemoveAllInternal = listBuilder.retainOrRemoveAllInternal(i2, i3, collection, z);
            this.length -= retainOrRemoveAllInternal;
            return retainOrRemoveAllInternal;
        }
        int i4 = 0;
        int i5 = 0;
        while (i4 < i3) {
            int i6 = i2 + i4;
            if (collection.contains(this.array[i6]) == z) {
                E[] eArr = this.array;
                i4++;
                eArr[i5 + i2] = eArr[i6];
                i5++;
            } else {
                i4++;
            }
        }
        int i7 = i3 - i5;
        E[] eArr2 = this.array;
        ArraysKt___ArraysJvmKt.copyInto(eArr2, eArr2, i2 + i5, i3 + i2, this.length);
        E[] eArr3 = this.array;
        int i8 = this.length;
        ListBuilderKt.resetRange(eArr3, i8 - i7, i8);
        this.length -= i7;
        return i7;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e2) {
        checkIsMutable();
        addAtInternal(this.offset + this.length, e2);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        checkIsMutable();
        int size = elements.size();
        addAllInternal(this.offset + this.length, elements, size);
        return size > 0;
    }

    public final List<E> build() {
        if (this.backing == null) {
            checkIsMutable();
            this.isReadOnly = true;
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        checkIsMutable();
        removeRangeInternal(this.offset, this.length);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof List) && contentEquals((List) obj));
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i2) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(i2, this.length);
        return this.array[this.offset + i2];
    }

    @Override // kotlin.collections.AbstractMutableList
    public int getSize() {
        return this.length;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int subarrayContentHashCode;
        subarrayContentHashCode = ListBuilderKt.subarrayContentHashCode(this.array, this.offset, this.length);
        return subarrayContentHashCode;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        for (int i2 = 0; i2 < this.length; i2++) {
            if (Intrinsics.areEqual(this.array[this.offset + i2], obj)) {
                return i2;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return this.length == 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        return new Itr(this, 0);
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        for (int i2 = this.length - 1; i2 >= 0; i2--) {
            if (Intrinsics.areEqual(this.array[this.offset + i2], obj)) {
                return i2;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator() {
        return new Itr(this, 0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        checkIsMutable();
        int indexOf = indexOf(obj);
        if (indexOf >= 0) {
            remove(indexOf);
        }
        return indexOf >= 0;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.Collection<? extends java.lang.Object> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        checkIsMutable();
        return retainOrRemoveAllInternal(this.offset, this.length, elements, false) > 0;
    }

    @Override // kotlin.collections.AbstractMutableList
    public E removeAt(int i2) {
        checkIsMutable();
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(i2, this.length);
        return removeAtInternal(this.offset + i2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.Collection<? extends java.lang.Object> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        checkIsMutable();
        return retainOrRemoveAllInternal(this.offset, this.length, elements, true) > 0;
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public E set(int i2, E e2) {
        checkIsMutable();
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(i2, this.length);
        E[] eArr = this.array;
        int i3 = this.offset;
        E e3 = eArr[i3 + i2];
        eArr[i3 + i2] = e2;
        return e3;
    }

    @Override // java.util.AbstractList, java.util.List
    public List<E> subList(int i2, int i3) {
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(i2, i3, this.length);
        E[] eArr = this.array;
        int i4 = this.offset + i2;
        int i5 = i3 - i2;
        boolean z = this.isReadOnly;
        ListBuilder<E> listBuilder = this.root;
        return new ListBuilder(eArr, i4, i5, z, this, listBuilder != null ? listBuilder : this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] destination) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        int length = destination.length;
        int i2 = this.length;
        if (length < i2) {
            E[] eArr = this.array;
            int i3 = this.offset;
            T[] tArr = (T[]) Arrays.copyOfRange(eArr, i3, i2 + i3, destination.getClass());
            Intrinsics.checkNotNullExpressionValue(tArr, "java.util.Arrays.copyOfR…h, destination.javaClass)");
            return tArr;
        }
        E[] eArr2 = this.array;
        if (eArr2 != null) {
            int i4 = this.offset;
            ArraysKt___ArraysJvmKt.copyInto(eArr2, destination, 0, i4, i2 + i4);
            int length2 = destination.length;
            int i5 = this.length;
            if (length2 > i5) {
                destination[i5] = null;
            }
            return destination;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        String subarrayContentToString;
        subarrayContentToString = ListBuilderKt.subarrayContentToString(this.array, this.offset, this.length);
        return subarrayContentToString;
    }

    public ListBuilder() {
        this(10);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator(int i2) {
        AbstractList.Companion.checkPositionIndex$kotlin_stdlib(i2, this.length);
        return new Itr(this, i2);
    }

    public ListBuilder(int i2) {
        this(ListBuilderKt.arrayOfUninitializedElements(i2), 0, 0, false, null, null);
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public void add(int i2, E e2) {
        checkIsMutable();
        AbstractList.Companion.checkPositionIndex$kotlin_stdlib(i2, this.length);
        addAtInternal(this.offset + i2, e2);
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i2, Collection<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        checkIsMutable();
        AbstractList.Companion.checkPositionIndex$kotlin_stdlib(i2, this.length);
        int size = elements.size();
        addAllInternal(this.offset + i2, elements, size);
        return size > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        E[] eArr = this.array;
        int i2 = this.offset;
        Object[] copyOfRange = ArraysKt___ArraysJvmKt.copyOfRange(eArr, i2, this.length + i2);
        if (copyOfRange != null) {
            return copyOfRange;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
    }
}
