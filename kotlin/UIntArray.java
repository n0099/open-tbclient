package kotlin;

import com.baidu.tbadk.core.data.SmallTailInfo;
import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.UIntIterator;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
@SinceKotlin(version = "1.3")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\t\b\u0087@\u0018\u00002\u00020\u00012\u00020\u0002:\u00013B\u0014\b\u0016\u0012\u0006\u0010*\u001a\u00020\u0012ø\u0001\u0000¢\u0006\u0004\b0\u00101B\u0014\b\u0001\u0012\u0006\u0010,\u001a\u00020+ø\u0001\u0000¢\u0006\u0004\b0\u00102J\u001b\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\r\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u0016ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0012H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001f\u001a\u00020\u001cH\u0096\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ#\u0010$\u001a\u00020!2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u0003H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\"\u0010#J\u0010\u0010&\u001a\u00020%HÖ\u0001¢\u0006\u0004\b&\u0010'R\u0016\u0010*\u001a\u00020\u00128V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u001c\u0010,\u001a\u00020+8\u0000@\u0001X\u0081\u0004¢\u0006\f\n\u0004\b,\u0010-\u0012\u0004\b.\u0010/ø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u00064"}, d2 = {"Lkotlin/UIntArray;", "Ljava/util/Collection;", "Lkotlin/jvm/internal/markers/KMappedMarker;", "Lkotlin/UInt;", "element", "", "contains-WZ4Q5Ns", "([II)Z", "contains", "", "elements", "containsAll-impl", "([ILjava/util/Collection;)Z", "containsAll", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "index", "get-impl", "([II)I", "get", "hashCode", "()I", "isEmpty-impl", "([I)Z", "isEmpty", "Lkotlin/collections/UIntIterator;", "iterator-impl", "([I)Lkotlin/collections/UIntIterator;", "iterator", "value", "", "set-VXSXFK8", "([III)V", "set", "", "toString", "()Ljava/lang/String;", "getSize-impl", "([I)I", "size", "", "storage", "[I", "storage$annotations", "()V", "constructor-impl", "(I)[I", "([I)[I", "Iterator", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@ExperimentalUnsignedTypes
/* loaded from: classes7.dex */
public final class UIntArray implements Collection<UInt>, KMappedMarker {
    public final int[] storage;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0003\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u00020\u0005H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lkotlin/UIntArray$Iterator;", "Lkotlin/collections/UIntIterator;", "", "hasNext", "()Z", "Lkotlin/UInt;", "nextUInt", "()I", "", "array", "[I", "", "index", "I", "<init>", "([I)V", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes7.dex */
    public static final class Iterator extends UIntIterator {
        public final int[] array;
        public int index;

        public Iterator(int[] iArr) {
            this.array = iArr;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < this.array.length;
        }

        @Override // kotlin.collections.UIntIterator
        public int nextUInt() {
            int i = this.index;
            int[] iArr = this.array;
            if (i < iArr.length) {
                this.index = i + 1;
                return UInt.m717constructorimpl(iArr[i]);
            }
            throw new NoSuchElementException(String.valueOf(this.index));
        }
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [kotlin.UIntArray.box-impl(int[]):kotlin.UIntArray] */
    @PublishedApi
    public /* synthetic */ UIntArray(int[] iArr) {
        this.storage = iArr;
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ UIntArray m761boximpl(int[] iArr) {
        return new UIntArray(iArr);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int[] m762constructorimpl(int i) {
        return m763constructorimpl(new int[i]);
    }

    @PublishedApi
    /* renamed from: constructor-impl  reason: not valid java name */
    public static int[] m763constructorimpl(int[] iArr) {
        return iArr;
    }

    /* renamed from: containsAll-impl  reason: not valid java name */
    public static boolean m765containsAllimpl(int[] iArr, Collection<UInt> collection) {
        boolean z;
        if (!collection.isEmpty()) {
            for (Object obj : collection) {
                if ((obj instanceof UInt) && ArraysKt___ArraysKt.contains(iArr, ((UInt) obj).m760unboximpl())) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (!z) {
                    return false;
                }
            }
        }
        return true;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m766equalsimpl(int[] iArr, Object obj) {
        return (obj instanceof UIntArray) && Intrinsics.areEqual(iArr, ((UIntArray) obj).m777unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m767equalsimpl0(int[] iArr, int[] iArr2) {
        throw null;
    }

    /* renamed from: get-impl  reason: not valid java name */
    public static final int m768getimpl(int[] iArr, int i) {
        return UInt.m717constructorimpl(iArr[i]);
    }

    /* renamed from: getSize-impl  reason: not valid java name */
    public static int m769getSizeimpl(int[] iArr) {
        return iArr.length;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m770hashCodeimpl(int[] iArr) {
        if (iArr != null) {
            return Arrays.hashCode(iArr);
        }
        return 0;
    }

    /* renamed from: isEmpty-impl  reason: not valid java name */
    public static boolean m771isEmptyimpl(int[] iArr) {
        return iArr.length == 0;
    }

    /* renamed from: iterator-impl  reason: not valid java name */
    public static UIntIterator m772iteratorimpl(int[] iArr) {
        return new Iterator(iArr);
    }

    /* renamed from: set-VXSXFK8  reason: not valid java name */
    public static final void m773setVXSXFK8(int[] iArr, int i, int i2) {
        iArr[i] = i2;
    }

    @PublishedApi
    public static /* synthetic */ void storage$annotations() {
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m774toStringimpl(int[] iArr) {
        return "UIntArray(storage=" + Arrays.toString(iArr) + SmallTailInfo.EMOTION_SUFFIX;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.util.Collection
    public /* synthetic */ boolean add(UInt uInt) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: add-WZ4Q5Ns  reason: not valid java name */
    public boolean m775addWZ4Q5Ns(int i) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends UInt> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof UInt) {
            return m776containsWZ4Q5Ns(((UInt) obj).m760unboximpl());
        }
        return false;
    }

    /* renamed from: contains-WZ4Q5Ns  reason: not valid java name */
    public boolean m776containsWZ4Q5Ns(int i) {
        return m764containsWZ4Q5Ns(this.storage, i);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<? extends Object> collection) {
        return m765containsAllimpl(this.storage, collection);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return m766equalsimpl(this.storage, obj);
    }

    public int getSize() {
        return m769getSizeimpl(this.storage);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return m770hashCodeimpl(this.storage);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return m771isEmptyimpl(this.storage);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Collection, java.lang.Iterable
    public UIntIterator iterator() {
        return m772iteratorimpl(this.storage);
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) CollectionToArray.toArray(this, tArr);
    }

    public String toString() {
        return m774toStringimpl(this.storage);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int[] m777unboximpl() {
        return this.storage;
    }

    /* renamed from: contains-WZ4Q5Ns  reason: not valid java name */
    public static boolean m764containsWZ4Q5Ns(int[] iArr, int i) {
        return ArraysKt___ArraysKt.contains(iArr, i);
    }
}
