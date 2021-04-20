package kotlin;

import com.baidu.tbadk.core.data.SmallTailInfo;
import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.UShortIterator;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
@SinceKotlin(version = "1.3")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0017\n\u0002\b\t\b\u0087@\u0018\u00002\u00020\u00012\u00020\u0002:\u00013B\u0014\b\u0016\u0012\u0006\u0010*\u001a\u00020\u0012ø\u0001\u0000¢\u0006\u0004\b0\u00101B\u0014\b\u0001\u0012\u0006\u0010,\u001a\u00020+ø\u0001\u0000¢\u0006\u0004\b0\u00102J\u001b\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\r\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u0016ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0012H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001f\u001a\u00020\u001cH\u0096\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ#\u0010$\u001a\u00020!2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u0003H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\"\u0010#J\u0010\u0010&\u001a\u00020%HÖ\u0001¢\u0006\u0004\b&\u0010'R\u0016\u0010*\u001a\u00020\u00128V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u001c\u0010,\u001a\u00020+8\u0000@\u0001X\u0081\u0004¢\u0006\f\n\u0004\b,\u0010-\u0012\u0004\b.\u0010/ø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u00064"}, d2 = {"Lkotlin/UShortArray;", "Ljava/util/Collection;", "Lkotlin/jvm/internal/markers/KMappedMarker;", "Lkotlin/UShort;", "element", "", "contains-xj2QHRw", "([SS)Z", "contains", "", "elements", "containsAll-impl", "([SLjava/util/Collection;)Z", "containsAll", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "index", "get-impl", "([SI)S", "get", "hashCode", "()I", "isEmpty-impl", "([S)Z", "isEmpty", "Lkotlin/collections/UShortIterator;", "iterator-impl", "([S)Lkotlin/collections/UShortIterator;", "iterator", "value", "", "set-01HTLdE", "([SIS)V", "set", "", "toString", "()Ljava/lang/String;", "getSize-impl", "([S)I", "size", "", "storage", "[S", "storage$annotations", "()V", "constructor-impl", "(I)[S", "([S)[S", "Iterator", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@ExperimentalUnsignedTypes
/* loaded from: classes7.dex */
public final class UShortArray implements Collection<UShort>, KMappedMarker {
    public final short[] storage;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0017\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0003\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u00020\u0005H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lkotlin/UShortArray$Iterator;", "Lkotlin/collections/UShortIterator;", "", "hasNext", "()Z", "Lkotlin/UShort;", "nextUShort", "()S", "", "array", "[S", "", "index", "I", "<init>", "([S)V", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes7.dex */
    public static final class Iterator extends UShortIterator {
        public final short[] array;
        public int index;

        public Iterator(short[] sArr) {
            this.array = sArr;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < this.array.length;
        }

        @Override // kotlin.collections.UShortIterator
        public short nextUShort() {
            int i = this.index;
            short[] sArr = this.array;
            if (i < sArr.length) {
                this.index = i + 1;
                return UShort.m883constructorimpl(sArr[i]);
            }
            throw new NoSuchElementException(String.valueOf(this.index));
        }
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [kotlin.UShortArray.box-impl(short[]):kotlin.UShortArray] */
    @PublishedApi
    public /* synthetic */ UShortArray(short[] sArr) {
        this.storage = sArr;
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ UShortArray m925boximpl(short[] sArr) {
        return new UShortArray(sArr);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static short[] m926constructorimpl(int i) {
        return m927constructorimpl(new short[i]);
    }

    @PublishedApi
    /* renamed from: constructor-impl  reason: not valid java name */
    public static short[] m927constructorimpl(short[] sArr) {
        return sArr;
    }

    /* renamed from: containsAll-impl  reason: not valid java name */
    public static boolean m929containsAllimpl(short[] sArr, Collection<UShort> collection) {
        boolean z;
        if (!collection.isEmpty()) {
            for (Object obj : collection) {
                if ((obj instanceof UShort) && ArraysKt___ArraysKt.contains(sArr, ((UShort) obj).m924unboximpl())) {
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
    public static boolean m930equalsimpl(short[] sArr, Object obj) {
        return (obj instanceof UShortArray) && Intrinsics.areEqual(sArr, ((UShortArray) obj).m941unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m931equalsimpl0(short[] sArr, short[] sArr2) {
        throw null;
    }

    /* renamed from: get-impl  reason: not valid java name */
    public static final short m932getimpl(short[] sArr, int i) {
        return UShort.m883constructorimpl(sArr[i]);
    }

    /* renamed from: getSize-impl  reason: not valid java name */
    public static int m933getSizeimpl(short[] sArr) {
        return sArr.length;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m934hashCodeimpl(short[] sArr) {
        if (sArr != null) {
            return Arrays.hashCode(sArr);
        }
        return 0;
    }

    /* renamed from: isEmpty-impl  reason: not valid java name */
    public static boolean m935isEmptyimpl(short[] sArr) {
        return sArr.length == 0;
    }

    /* renamed from: iterator-impl  reason: not valid java name */
    public static UShortIterator m936iteratorimpl(short[] sArr) {
        return new Iterator(sArr);
    }

    /* renamed from: set-01HTLdE  reason: not valid java name */
    public static final void m937set01HTLdE(short[] sArr, int i, short s) {
        sArr[i] = s;
    }

    @PublishedApi
    public static /* synthetic */ void storage$annotations() {
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m938toStringimpl(short[] sArr) {
        return "UShortArray(storage=" + Arrays.toString(sArr) + SmallTailInfo.EMOTION_SUFFIX;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.util.Collection
    public /* synthetic */ boolean add(UShort uShort) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: add-xj2QHRw  reason: not valid java name */
    public boolean m939addxj2QHRw(short s) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends UShort> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof UShort) {
            return m940containsxj2QHRw(((UShort) obj).m924unboximpl());
        }
        return false;
    }

    /* renamed from: contains-xj2QHRw  reason: not valid java name */
    public boolean m940containsxj2QHRw(short s) {
        return m928containsxj2QHRw(this.storage, s);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<? extends Object> collection) {
        return m929containsAllimpl(this.storage, collection);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return m930equalsimpl(this.storage, obj);
    }

    public int getSize() {
        return m933getSizeimpl(this.storage);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return m934hashCodeimpl(this.storage);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return m935isEmptyimpl(this.storage);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Collection, java.lang.Iterable
    public UShortIterator iterator() {
        return m936iteratorimpl(this.storage);
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
        return m938toStringimpl(this.storage);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ short[] m941unboximpl() {
        return this.storage;
    }

    /* renamed from: contains-xj2QHRw  reason: not valid java name */
    public static boolean m928containsxj2QHRw(short[] sArr, short s) {
        return ArraysKt___ArraysKt.contains(sArr, s);
    }
}
