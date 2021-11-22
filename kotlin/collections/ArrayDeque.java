package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
@SinceKotlin(version = "1.4")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b!\b\u0007\u0018\u0000 R*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001RB\u0011\b\u0016\u0012\u0006\u0010O\u001a\u00020\u0007¢\u0006\u0004\bP\u0010\u001bB\t\b\u0016¢\u0006\u0004\bP\u0010\u0014B\u0017\b\u0016\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b¢\u0006\u0004\bP\u0010QJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u0005\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0005\u0010\nJ%\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\r\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000fJ\u0015\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0015\u0010\u0006J%\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001f\u0010\u001bJ$\u0010\"\u001a\u00020\u00042\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040 H\u0082\b¢\u0006\u0004\b\"\u0010#J\r\u0010$\u001a\u00028\u0000¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b&\u0010%J\u0018\u0010'\u001a\u00028\u00002\u0006\u0010\b\u001a\u00020\u0007H\u0096\u0002¢\u0006\u0004\b'\u0010(J\u0017\u0010)\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b)\u0010\u001dJ\u0017\u0010*\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00028\u0000H\u0016¢\u0006\u0004\b*\u0010+J\u0018\u0010,\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00020\u0007H\u0083\b¢\u0006\u0004\b,\u0010(J\u0018\u0010\u0016\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0083\b¢\u0006\u0004\b\u0016\u0010\u001dJO\u00106\u001a\u00020\t2>\u00103\u001a:\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(0\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010201¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\t0-H\u0000¢\u0006\u0004\b4\u00105J\u000f\u00107\u001a\u00020\u0004H\u0016¢\u0006\u0004\b7\u00108J\r\u00109\u001a\u00028\u0000¢\u0006\u0004\b9\u0010%J\u0017\u0010:\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00028\u0000H\u0016¢\u0006\u0004\b:\u0010+J\u000f\u0010;\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b;\u0010%J\u0017\u0010<\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b<\u0010\u001dJ\u0017\u0010=\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b=\u0010\u001dJ\u0017\u0010>\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u0016¢\u0006\u0004\b>\u0010\u0006J\u001d\u0010?\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0016¢\u0006\u0004\b?\u0010\u000fJ\u0017\u0010@\u001a\u00028\u00002\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b@\u0010(J\r\u0010A\u001a\u00028\u0000¢\u0006\u0004\bA\u0010%J\u000f\u0010B\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\bB\u0010%J\r\u0010C\u001a\u00028\u0000¢\u0006\u0004\bC\u0010%J\u000f\u0010D\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\bD\u0010%J\u001d\u0010E\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0016¢\u0006\u0004\bE\u0010\u000fJ \u0010F\u001a\u00028\u00002\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\bF\u0010GR\u001e\u0010H\u001a\n\u0012\u0006\u0012\u0004\u0018\u000102018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0016\u00100\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010JR$\u0010L\u001a\u00020\u00072\u0006\u0010K\u001a\u00020\u00078\u0016@RX\u0096\u000e¢\u0006\f\n\u0004\bL\u0010J\u001a\u0004\bM\u0010N¨\u0006S"}, d2 = {"Lkotlin/collections/ArrayDeque;", "E", "Lkotlin/collections/AbstractMutableList;", "element", "", "add", "(Ljava/lang/Object;)Z", "", "index", "", "(ILjava/lang/Object;)V", "", "elements", "addAll", "(ILjava/util/Collection;)Z", "(Ljava/util/Collection;)Z", "addFirst", "(Ljava/lang/Object;)V", "addLast", "clear", "()V", "contains", "internalIndex", "copyCollectionElements", "(ILjava/util/Collection;)V", "newCapacity", "copyElements", "(I)V", "decremented", "(I)I", "minCapacity", "ensureCapacity", "Lkotlin/Function1;", "predicate", "filterInPlace", "(Lkotlin/Function1;)Z", "first", "()Ljava/lang/Object;", "firstOrNull", "get", "(I)Ljava/lang/Object;", "incremented", "indexOf", "(Ljava/lang/Object;)I", "internalGet", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "head", "", "", "structure", "internalStructure$kotlin_stdlib", "(Lkotlin/Function2;)V", "internalStructure", "isEmpty", "()Z", "last", "lastIndexOf", "lastOrNull", "negativeMod", "positiveMod", "remove", "removeAll", "removeAt", "removeFirst", "removeFirstOrNull", "removeLast", "removeLastOrNull", "retainAll", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "elementData", "[Ljava/lang/Object;", "I", "<set-?>", "size", "getSize", "()I", "initialCapacity", "<init>", "(Ljava/util/Collection;)V", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@WasExperimental(markerClass = {ExperimentalStdlibApi.class})
/* loaded from: classes2.dex */
public final class ArrayDeque<E> extends AbstractMutableList<E> {
    public static final int defaultMinCapacity = 10;
    public static final int maxArraySize = 2147483639;
    public Object[] elementData;
    public int head;
    public int size;
    public static final Companion Companion = new Companion(null);
    public static final Object[] emptyElementData = new Object[0];

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0080\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0007\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\b¨\u0006\u0010"}, d2 = {"Lkotlin/collections/ArrayDeque$Companion;", "", "oldCapacity", "minCapacity", "newCapacity$kotlin_stdlib", "(II)I", "newCapacity", "defaultMinCapacity", "I", "", "", "emptyElementData", "[Ljava/lang/Object;", "maxArraySize", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class Companion {
        public Companion() {
        }

        public final int newCapacity$kotlin_stdlib(int i2, int i3) {
            int i4 = i2 + (i2 >> 1);
            if (i4 - i3 < 0) {
                i4 = i3;
            }
            if (i4 - ArrayDeque.maxArraySize > 0) {
                if (i3 > 2147483639) {
                    return Integer.MAX_VALUE;
                }
                return ArrayDeque.maxArraySize;
            }
            return i4;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ArrayDeque(int i2) {
        Object[] objArr;
        if (i2 == 0) {
            objArr = emptyElementData;
        } else if (i2 > 0) {
            objArr = new Object[i2];
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + i2);
        }
        this.elementData = objArr;
    }

    private final void copyCollectionElements(int i2, Collection<? extends E> collection) {
        Iterator<? extends E> it = collection.iterator();
        int length = this.elementData.length;
        while (i2 < length && it.hasNext()) {
            this.elementData[i2] = it.next();
            i2++;
        }
        int i3 = this.head;
        for (int i4 = 0; i4 < i3 && it.hasNext(); i4++) {
            this.elementData[i4] = it.next();
        }
        this.size = size() + collection.size();
    }

    private final void copyElements(int i2) {
        Object[] objArr = new Object[i2];
        Object[] objArr2 = this.elementData;
        ArraysKt___ArraysJvmKt.copyInto(objArr2, objArr, 0, this.head, objArr2.length);
        Object[] objArr3 = this.elementData;
        int length = objArr3.length;
        int i3 = this.head;
        ArraysKt___ArraysJvmKt.copyInto(objArr3, objArr, length - i3, 0, i3);
        this.head = 0;
        this.elementData = objArr;
    }

    private final int decremented(int i2) {
        return i2 == 0 ? ArraysKt___ArraysKt.getLastIndex(this.elementData) : i2 - 1;
    }

    private final void ensureCapacity(int i2) {
        if (i2 >= 0) {
            Object[] objArr = this.elementData;
            if (i2 <= objArr.length) {
                return;
            }
            if (objArr == emptyElementData) {
                this.elementData = new Object[RangesKt___RangesKt.coerceAtLeast(i2, 10)];
                return;
            } else {
                copyElements(Companion.newCapacity$kotlin_stdlib(objArr.length, i2));
                return;
            }
        }
        throw new IllegalStateException("Deque is too big.");
    }

    private final boolean filterInPlace(Function1<? super E, Boolean> function1) {
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty()) {
            if (!(this.elementData.length == 0)) {
                int positiveMod = positiveMod(this.head + size());
                int i2 = this.head;
                if (this.head < positiveMod) {
                    for (int i3 = this.head; i3 < positiveMod; i3++) {
                        Object obj = this.elementData[i3];
                        if (function1.invoke(obj).booleanValue()) {
                            this.elementData[i2] = obj;
                            i2++;
                        } else {
                            z = true;
                        }
                    }
                    ArraysKt___ArraysJvmKt.fill(this.elementData, (Object) null, i2, positiveMod);
                } else {
                    int length = this.elementData.length;
                    boolean z2 = false;
                    for (int i4 = this.head; i4 < length; i4++) {
                        Object obj2 = this.elementData[i4];
                        this.elementData[i4] = null;
                        if (function1.invoke(obj2).booleanValue()) {
                            this.elementData[i2] = obj2;
                            i2++;
                        } else {
                            z2 = true;
                        }
                    }
                    i2 = positiveMod(i2);
                    for (int i5 = 0; i5 < positiveMod; i5++) {
                        Object obj3 = this.elementData[i5];
                        this.elementData[i5] = null;
                        if (function1.invoke(obj3).booleanValue()) {
                            this.elementData[i2] = obj3;
                            i2 = incremented(i2);
                        } else {
                            z2 = true;
                        }
                    }
                    z = z2;
                }
                if (z) {
                    this.size = negativeMod(i2 - this.head);
                }
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int incremented(int i2) {
        if (i2 == ArraysKt___ArraysKt.getLastIndex(this.elementData)) {
            return 0;
        }
        return i2 + 1;
    }

    @InlineOnly
    private final E internalGet(int i2) {
        return (E) this.elementData[i2];
    }

    @InlineOnly
    private final int internalIndex(int i2) {
        return positiveMod(this.head + i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int negativeMod(int i2) {
        return i2 < 0 ? i2 + this.elementData.length : i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int positiveMod(int i2) {
        Object[] objArr = this.elementData;
        return i2 >= objArr.length ? i2 - objArr.length : i2;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e2) {
        addLast(e2);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements.isEmpty()) {
            return false;
        }
        ensureCapacity(size() + elements.size());
        copyCollectionElements(positiveMod(this.head + size()), elements);
        return true;
    }

    public final void addFirst(E e2) {
        ensureCapacity(size() + 1);
        int decremented = decremented(this.head);
        this.head = decremented;
        this.elementData[decremented] = e2;
        this.size = size() + 1;
    }

    public final void addLast(E e2) {
        ensureCapacity(size() + 1);
        this.elementData[positiveMod(this.head + size())] = e2;
        this.size = size() + 1;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        int positiveMod = positiveMod(this.head + size());
        int i2 = this.head;
        if (i2 < positiveMod) {
            ArraysKt___ArraysJvmKt.fill(this.elementData, (Object) null, i2, positiveMod);
        } else if (!isEmpty()) {
            Object[] objArr = this.elementData;
            ArraysKt___ArraysJvmKt.fill(objArr, (Object) null, this.head, objArr.length);
            ArraysKt___ArraysJvmKt.fill(this.elementData, (Object) null, 0, positiveMod);
        }
        this.head = 0;
        this.size = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final E first() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        return (E) this.elementData[this.head];
    }

    public final E firstOrNull() {
        if (isEmpty()) {
            return null;
        }
        return (E) this.elementData[this.head];
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i2) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(i2, size());
        return (E) this.elementData[positiveMod(this.head + i2)];
    }

    @Override // kotlin.collections.AbstractMutableList
    public int getSize() {
        return this.size;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        int i2;
        int positiveMod = positiveMod(this.head + size());
        int i3 = this.head;
        if (i3 < positiveMod) {
            while (i3 < positiveMod) {
                if (Intrinsics.areEqual(obj, this.elementData[i3])) {
                    i2 = this.head;
                } else {
                    i3++;
                }
            }
            return -1;
        } else if (i3 < positiveMod) {
            return -1;
        } else {
            int length = this.elementData.length;
            while (true) {
                if (i3 >= length) {
                    for (int i4 = 0; i4 < positiveMod; i4++) {
                        if (Intrinsics.areEqual(obj, this.elementData[i4])) {
                            i3 = i4 + this.elementData.length;
                            i2 = this.head;
                        }
                    }
                    return -1;
                } else if (Intrinsics.areEqual(obj, this.elementData[i3])) {
                    i2 = this.head;
                    break;
                } else {
                    i3++;
                }
            }
        }
        return i3 - i2;
    }

    /* JADX DEBUG: Type inference failed for r1v8. Raw type applied. Possible types: ? super java.lang.Object[] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Object[], java.lang.Object] */
    public final void internalStructure$kotlin_stdlib(Function2<? super Integer, ? super Object[], Unit> structure) {
        Intrinsics.checkNotNullParameter(structure, "structure");
        int positiveMod = positiveMod(this.head + size());
        if (isEmpty()) {
            structure.invoke(Integer.valueOf(this.head), new Object[0]);
            return;
        }
        ?? r0 = new Object[size()];
        int i2 = this.head;
        if (i2 < positiveMod) {
            ArraysKt___ArraysJvmKt.copyInto$default(this.elementData, (Object[]) r0, 0, i2, positiveMod, 2, (Object) null);
            structure.invoke(Integer.valueOf(this.head), r0);
            return;
        }
        ArraysKt___ArraysJvmKt.copyInto$default(this.elementData, (Object[]) r0, 0, i2, 0, 10, (Object) null);
        Object[] objArr = this.elementData;
        ArraysKt___ArraysJvmKt.copyInto(objArr, (Object[]) r0, objArr.length - this.head, 0, positiveMod);
        structure.invoke(Integer.valueOf(this.head - this.elementData.length), r0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return size() == 0;
    }

    public final E last() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        return (E) this.elementData[positiveMod(this.head + CollectionsKt__CollectionsKt.getLastIndex(this))];
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        int lastIndex;
        int i2;
        int positiveMod = positiveMod(this.head + size());
        int i3 = this.head;
        if (i3 < positiveMod) {
            lastIndex = positiveMod - 1;
            if (lastIndex < i3) {
                return -1;
            }
            while (!Intrinsics.areEqual(obj, this.elementData[lastIndex])) {
                if (lastIndex == i3) {
                    return -1;
                }
                lastIndex--;
            }
            i2 = this.head;
        } else if (i3 <= positiveMod) {
            return -1;
        } else {
            int i4 = positiveMod - 1;
            while (true) {
                if (i4 >= 0) {
                    if (Intrinsics.areEqual(obj, this.elementData[i4])) {
                        lastIndex = i4 + this.elementData.length;
                        i2 = this.head;
                        break;
                    }
                    i4--;
                } else {
                    lastIndex = ArraysKt___ArraysKt.getLastIndex(this.elementData);
                    int i5 = this.head;
                    if (lastIndex < i5) {
                        return -1;
                    }
                    while (!Intrinsics.areEqual(obj, this.elementData[lastIndex])) {
                        if (lastIndex == i5) {
                            return -1;
                        }
                        lastIndex--;
                    }
                    i2 = this.head;
                }
            }
        }
        return lastIndex - i2;
    }

    public final E lastOrNull() {
        if (isEmpty()) {
            return null;
        }
        return (E) this.elementData[positiveMod(this.head + CollectionsKt__CollectionsKt.getLastIndex(this))];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf == -1) {
            return false;
        }
        remove(indexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty()) {
            if (!(this.elementData.length == 0)) {
                int positiveMod = positiveMod(this.head + size());
                int i2 = this.head;
                if (this.head < positiveMod) {
                    for (int i3 = this.head; i3 < positiveMod; i3++) {
                        Object obj = this.elementData[i3];
                        if (!elements.contains(obj)) {
                            this.elementData[i2] = obj;
                            i2++;
                        } else {
                            z = true;
                        }
                    }
                    ArraysKt___ArraysJvmKt.fill(this.elementData, (Object) null, i2, positiveMod);
                } else {
                    int length = this.elementData.length;
                    boolean z2 = false;
                    for (int i4 = this.head; i4 < length; i4++) {
                        Object obj2 = this.elementData[i4];
                        this.elementData[i4] = null;
                        if (!elements.contains(obj2)) {
                            this.elementData[i2] = obj2;
                            i2++;
                        } else {
                            z2 = true;
                        }
                    }
                    i2 = positiveMod(i2);
                    for (int i5 = 0; i5 < positiveMod; i5++) {
                        Object obj3 = this.elementData[i5];
                        this.elementData[i5] = null;
                        if (!elements.contains(obj3)) {
                            this.elementData[i2] = obj3;
                            i2 = incremented(i2);
                        } else {
                            z2 = true;
                        }
                    }
                    z = z2;
                }
                if (z) {
                    this.size = negativeMod(i2 - this.head);
                }
            }
        }
        return z;
    }

    @Override // kotlin.collections.AbstractMutableList
    public E removeAt(int i2) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(i2, size());
        if (i2 == CollectionsKt__CollectionsKt.getLastIndex(this)) {
            return removeLast();
        }
        if (i2 != 0) {
            int positiveMod = positiveMod(this.head + i2);
            E e2 = (E) this.elementData[positiveMod];
            if (i2 < (size() >> 1)) {
                int i3 = this.head;
                if (positiveMod >= i3) {
                    Object[] objArr = this.elementData;
                    ArraysKt___ArraysJvmKt.copyInto(objArr, objArr, i3 + 1, i3, positiveMod);
                } else {
                    Object[] objArr2 = this.elementData;
                    ArraysKt___ArraysJvmKt.copyInto(objArr2, objArr2, 1, 0, positiveMod);
                    Object[] objArr3 = this.elementData;
                    objArr3[0] = objArr3[objArr3.length - 1];
                    int i4 = this.head;
                    ArraysKt___ArraysJvmKt.copyInto(objArr3, objArr3, i4 + 1, i4, objArr3.length - 1);
                }
                Object[] objArr4 = this.elementData;
                int i5 = this.head;
                objArr4[i5] = null;
                this.head = incremented(i5);
            } else {
                int positiveMod2 = positiveMod(this.head + CollectionsKt__CollectionsKt.getLastIndex(this));
                if (positiveMod <= positiveMod2) {
                    Object[] objArr5 = this.elementData;
                    ArraysKt___ArraysJvmKt.copyInto(objArr5, objArr5, positiveMod, positiveMod + 1, positiveMod2 + 1);
                } else {
                    Object[] objArr6 = this.elementData;
                    ArraysKt___ArraysJvmKt.copyInto(objArr6, objArr6, positiveMod, positiveMod + 1, objArr6.length);
                    Object[] objArr7 = this.elementData;
                    objArr7[objArr7.length - 1] = objArr7[0];
                    ArraysKt___ArraysJvmKt.copyInto(objArr7, objArr7, 0, 1, positiveMod2 + 1);
                }
                this.elementData[positiveMod2] = null;
            }
            this.size = size() - 1;
            return e2;
        }
        return removeFirst();
    }

    public final E removeFirst() {
        if (!isEmpty()) {
            E e2 = (E) this.elementData[this.head];
            Object[] objArr = this.elementData;
            int i2 = this.head;
            objArr[i2] = null;
            this.head = incremented(i2);
            this.size = size() - 1;
            return e2;
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    public final E removeFirstOrNull() {
        if (isEmpty()) {
            return null;
        }
        return removeFirst();
    }

    public final E removeLast() {
        if (!isEmpty()) {
            int positiveMod = positiveMod(this.head + CollectionsKt__CollectionsKt.getLastIndex(this));
            E e2 = (E) this.elementData[positiveMod];
            this.elementData[positiveMod] = null;
            this.size = size() - 1;
            return e2;
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    public final E removeLastOrNull() {
        if (isEmpty()) {
            return null;
        }
        return removeLast();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty()) {
            if (!(this.elementData.length == 0)) {
                int positiveMod = positiveMod(this.head + size());
                int i2 = this.head;
                if (this.head < positiveMod) {
                    for (int i3 = this.head; i3 < positiveMod; i3++) {
                        Object obj = this.elementData[i3];
                        if (elements.contains(obj)) {
                            this.elementData[i2] = obj;
                            i2++;
                        } else {
                            z = true;
                        }
                    }
                    ArraysKt___ArraysJvmKt.fill(this.elementData, (Object) null, i2, positiveMod);
                } else {
                    int length = this.elementData.length;
                    boolean z2 = false;
                    for (int i4 = this.head; i4 < length; i4++) {
                        Object obj2 = this.elementData[i4];
                        this.elementData[i4] = null;
                        if (elements.contains(obj2)) {
                            this.elementData[i2] = obj2;
                            i2++;
                        } else {
                            z2 = true;
                        }
                    }
                    i2 = positiveMod(i2);
                    for (int i5 = 0; i5 < positiveMod; i5++) {
                        Object obj3 = this.elementData[i5];
                        this.elementData[i5] = null;
                        if (elements.contains(obj3)) {
                            this.elementData[i2] = obj3;
                            i2 = incremented(i2);
                        } else {
                            z2 = true;
                        }
                    }
                    z = z2;
                }
                if (z) {
                    this.size = negativeMod(i2 - this.head);
                }
            }
        }
        return z;
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public E set(int i2, E e2) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(i2, size());
        int positiveMod = positiveMod(this.head + i2);
        E e3 = (E) this.elementData[positiveMod];
        this.elementData[positiveMod] = e2;
        return e3;
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public void add(int i2, E e2) {
        AbstractList.Companion.checkPositionIndex$kotlin_stdlib(i2, size());
        if (i2 == size()) {
            addLast(e2);
        } else if (i2 == 0) {
            addFirst(e2);
        } else {
            ensureCapacity(size() + 1);
            int positiveMod = positiveMod(this.head + i2);
            if (i2 < ((size() + 1) >> 1)) {
                int decremented = decremented(positiveMod);
                int decremented2 = decremented(this.head);
                int i3 = this.head;
                if (decremented >= i3) {
                    Object[] objArr = this.elementData;
                    objArr[decremented2] = objArr[i3];
                    ArraysKt___ArraysJvmKt.copyInto(objArr, objArr, i3, i3 + 1, decremented + 1);
                } else {
                    Object[] objArr2 = this.elementData;
                    ArraysKt___ArraysJvmKt.copyInto(objArr2, objArr2, i3 - 1, i3, objArr2.length);
                    Object[] objArr3 = this.elementData;
                    objArr3[objArr3.length - 1] = objArr3[0];
                    ArraysKt___ArraysJvmKt.copyInto(objArr3, objArr3, 0, 1, decremented + 1);
                }
                this.elementData[decremented] = e2;
                this.head = decremented2;
            } else {
                int positiveMod2 = positiveMod(this.head + size());
                if (positiveMod < positiveMod2) {
                    Object[] objArr4 = this.elementData;
                    ArraysKt___ArraysJvmKt.copyInto(objArr4, objArr4, positiveMod + 1, positiveMod, positiveMod2);
                } else {
                    Object[] objArr5 = this.elementData;
                    ArraysKt___ArraysJvmKt.copyInto(objArr5, objArr5, 1, 0, positiveMod2);
                    Object[] objArr6 = this.elementData;
                    objArr6[0] = objArr6[objArr6.length - 1];
                    ArraysKt___ArraysJvmKt.copyInto(objArr6, objArr6, positiveMod + 1, positiveMod, objArr6.length - 1);
                }
                this.elementData[positiveMod] = e2;
            }
            this.size = size() + 1;
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i2, Collection<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        AbstractList.Companion.checkPositionIndex$kotlin_stdlib(i2, size());
        if (elements.isEmpty()) {
            return false;
        }
        if (i2 == size()) {
            return addAll(elements);
        }
        ensureCapacity(size() + elements.size());
        int positiveMod = positiveMod(this.head + size());
        int positiveMod2 = positiveMod(this.head + i2);
        int size = elements.size();
        if (i2 < ((size() + 1) >> 1)) {
            int i3 = this.head;
            int i4 = i3 - size;
            if (positiveMod2 < i3) {
                Object[] objArr = this.elementData;
                ArraysKt___ArraysJvmKt.copyInto(objArr, objArr, i4, i3, objArr.length);
                if (size >= positiveMod2) {
                    Object[] objArr2 = this.elementData;
                    ArraysKt___ArraysJvmKt.copyInto(objArr2, objArr2, objArr2.length - size, 0, positiveMod2);
                } else {
                    Object[] objArr3 = this.elementData;
                    ArraysKt___ArraysJvmKt.copyInto(objArr3, objArr3, objArr3.length - size, 0, size);
                    Object[] objArr4 = this.elementData;
                    ArraysKt___ArraysJvmKt.copyInto(objArr4, objArr4, 0, size, positiveMod2);
                }
            } else if (i4 >= 0) {
                Object[] objArr5 = this.elementData;
                ArraysKt___ArraysJvmKt.copyInto(objArr5, objArr5, i4, i3, positiveMod2);
            } else {
                Object[] objArr6 = this.elementData;
                i4 += objArr6.length;
                int i5 = positiveMod2 - i3;
                int length = objArr6.length - i4;
                if (length >= i5) {
                    ArraysKt___ArraysJvmKt.copyInto(objArr6, objArr6, i4, i3, positiveMod2);
                } else {
                    ArraysKt___ArraysJvmKt.copyInto(objArr6, objArr6, i4, i3, i3 + length);
                    Object[] objArr7 = this.elementData;
                    ArraysKt___ArraysJvmKt.copyInto(objArr7, objArr7, 0, this.head + length, positiveMod2);
                }
            }
            this.head = i4;
            copyCollectionElements(negativeMod(positiveMod2 - size), elements);
        } else {
            int i6 = positiveMod2 + size;
            if (positiveMod2 < positiveMod) {
                int i7 = size + positiveMod;
                Object[] objArr8 = this.elementData;
                if (i7 <= objArr8.length) {
                    ArraysKt___ArraysJvmKt.copyInto(objArr8, objArr8, i6, positiveMod2, positiveMod);
                } else if (i6 >= objArr8.length) {
                    ArraysKt___ArraysJvmKt.copyInto(objArr8, objArr8, i6 - objArr8.length, positiveMod2, positiveMod);
                } else {
                    int length2 = positiveMod - (i7 - objArr8.length);
                    ArraysKt___ArraysJvmKt.copyInto(objArr8, objArr8, 0, length2, positiveMod);
                    Object[] objArr9 = this.elementData;
                    ArraysKt___ArraysJvmKt.copyInto(objArr9, objArr9, i6, positiveMod2, length2);
                }
            } else {
                Object[] objArr10 = this.elementData;
                ArraysKt___ArraysJvmKt.copyInto(objArr10, objArr10, size, 0, positiveMod);
                Object[] objArr11 = this.elementData;
                if (i6 >= objArr11.length) {
                    ArraysKt___ArraysJvmKt.copyInto(objArr11, objArr11, i6 - objArr11.length, positiveMod2, objArr11.length);
                } else {
                    ArraysKt___ArraysJvmKt.copyInto(objArr11, objArr11, 0, objArr11.length - size, objArr11.length);
                    Object[] objArr12 = this.elementData;
                    ArraysKt___ArraysJvmKt.copyInto(objArr12, objArr12, i6, positiveMod2, objArr12.length - size);
                }
            }
            copyCollectionElements(positiveMod2, elements);
        }
        return true;
    }

    public ArrayDeque() {
        this.elementData = emptyElementData;
    }

    public ArrayDeque(Collection<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Object[] array = elements.toArray(new Object[0]);
        if (array != null) {
            this.elementData = array;
            this.size = array.length;
            if (array.length == 0) {
                this.elementData = emptyElementData;
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }
}
