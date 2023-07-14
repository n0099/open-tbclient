package kotlin;

import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.UIntIterator;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
@SinceKotlin(version = "1.3")
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00012B\u0014\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006B\u0014\b\u0001\u0012\u0006\u0010\u0007\u001a\u00020\bø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\tJ\u001b\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J \u0010\u0013\u001a\u00020\u000f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u001e\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0004H\u0086\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b!\u0010\u000bJ\u000f\u0010\"\u001a\u00020\u000fH\u0016¢\u0006\u0004\b#\u0010$J\u0019\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00020&H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b'\u0010(J#\u0010)\u001a\u00020*2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0002H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b,\u0010-J\u0010\u0010.\u001a\u00020/HÖ\u0001¢\u0006\u0004\b0\u00101R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\b8\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\f\u0010\r\u0088\u0001\u0007\u0092\u0001\u00020\bø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u00063"}, d2 = {"Lkotlin/UIntArray;", "", "Lkotlin/UInt;", "size", "", "constructor-impl", "(I)[I", "storage", "", "([I)[I", "getSize-impl", "([I)I", "getStorage$annotations", "()V", "contains", "", "element", "contains-WZ4Q5Ns", "([II)Z", "containsAll", "elements", "containsAll-impl", "([ILjava/util/Collection;)Z", "equals", "other", "", "equals-impl", "([ILjava/lang/Object;)Z", CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE, "index", "get-pVg5ArA", "([II)I", TTDownloadField.TT_HASHCODE, "hashCode-impl", "isEmpty", "isEmpty-impl", "([I)Z", "iterator", "", "iterator-impl", "([I)Ljava/util/Iterator;", "set", "", "value", "set-VXSXFK8", "([III)V", "toString", "", "toString-impl", "([I)Ljava/lang/String;", "Iterator", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
@ExperimentalUnsignedTypes
@JvmInline
/* loaded from: classes10.dex */
public final class UIntArray implements Collection<UInt>, KMappedMarker {
    public final int[] storage;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ UIntArray m992boximpl(int[] iArr) {
        return new UIntArray(iArr);
    }

    @PublishedApi
    /* renamed from: constructor-impl  reason: not valid java name */
    public static int[] m994constructorimpl(int[] storage) {
        Intrinsics.checkNotNullParameter(storage, "storage");
        return storage;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m997equalsimpl(int[] iArr, Object obj) {
        return (obj instanceof UIntArray) && Intrinsics.areEqual(iArr, ((UIntArray) obj).m1008unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m998equalsimpl0(int[] iArr, int[] iArr2) {
        return Intrinsics.areEqual(iArr, iArr2);
    }

    @PublishedApi
    public static /* synthetic */ void getStorage$annotations() {
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m1001hashCodeimpl(int[] iArr) {
        return Arrays.hashCode(iArr);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m1005toStringimpl(int[] iArr) {
        return "UIntArray(storage=" + Arrays.toString(iArr) + ')';
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(UInt uInt) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: add-WZ4Q5Ns  reason: not valid java name */
    public boolean m1006addWZ4Q5Ns(int i) {
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
    public boolean equals(Object obj) {
        return m997equalsimpl(this.storage, obj);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return m1001hashCodeimpl(this.storage);
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
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return (T[]) CollectionToArray.toArray(this, array);
    }

    public String toString() {
        return m1005toStringimpl(this.storage);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int[] m1008unboximpl() {
        return this.storage;
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\bH\u0096\u0002J\u0015\u0010\t\u001a\u00020\nH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\r"}, d2 = {"Lkotlin/UIntArray$Iterator;", "Lkotlin/collections/UIntIterator;", "array", "", "([I)V", "index", "", "hasNext", "", "nextUInt", "Lkotlin/UInt;", "nextUInt-pVg5ArA", "()I", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes10.dex */
    public static final class Iterator extends UIntIterator {
        public final int[] array;
        public int index;

        public Iterator(int[] array) {
            Intrinsics.checkNotNullParameter(array, "array");
            this.array = array;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.index < this.array.length) {
                return true;
            }
            return false;
        }

        @Override // kotlin.collections.UIntIterator
        /* renamed from: nextUInt-pVg5ArA  reason: not valid java name */
        public int mo1009nextUIntpVg5ArA() {
            int i = this.index;
            int[] iArr = this.array;
            if (i < iArr.length) {
                this.index = i + 1;
                return UInt.m940constructorimpl(iArr[i]);
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

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int[] m993constructorimpl(int i) {
        return m994constructorimpl(new int[i]);
    }

    /* renamed from: getSize-impl  reason: not valid java name */
    public static int m1000getSizeimpl(int[] iArr) {
        return iArr.length;
    }

    /* renamed from: isEmpty-impl  reason: not valid java name */
    public static boolean m1002isEmptyimpl(int[] iArr) {
        if (iArr.length == 0) {
            return true;
        }
        return false;
    }

    /* renamed from: iterator-impl  reason: not valid java name */
    public static java.util.Iterator<UInt> m1003iteratorimpl(int[] iArr) {
        return new Iterator(iArr);
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof UInt)) {
            return false;
        }
        return m1007containsWZ4Q5Ns(((UInt) obj).m991unboximpl());
    }

    /* renamed from: contains-WZ4Q5Ns  reason: not valid java name */
    public boolean m1007containsWZ4Q5Ns(int i) {
        return m995containsWZ4Q5Ns(this.storage, i);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return m996containsAllimpl(this.storage, elements);
    }

    /* renamed from: contains-WZ4Q5Ns  reason: not valid java name */
    public static boolean m995containsWZ4Q5Ns(int[] iArr, int i) {
        return ArraysKt___ArraysKt.contains(iArr, i);
    }

    /* renamed from: get-pVg5ArA  reason: not valid java name */
    public static final int m999getpVg5ArA(int[] iArr, int i) {
        return UInt.m940constructorimpl(iArr[i]);
    }

    /* renamed from: containsAll-impl  reason: not valid java name */
    public static boolean m996containsAllimpl(int[] iArr, Collection<UInt> elements) {
        boolean z;
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (!elements.isEmpty()) {
            for (Object obj : elements) {
                if ((obj instanceof UInt) && ArraysKt___ArraysKt.contains(iArr, ((UInt) obj).m991unboximpl())) {
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

    /* renamed from: set-VXSXFK8  reason: not valid java name */
    public static final void m1004setVXSXFK8(int[] iArr, int i, int i2) {
        iArr[i] = i2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Collection
    /* renamed from: getSize */
    public int size() {
        return m1000getSizeimpl(this.storage);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return m1002isEmptyimpl(this.storage);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public java.util.Iterator<UInt> iterator() {
        return m1003iteratorimpl(this.storage);
    }
}
