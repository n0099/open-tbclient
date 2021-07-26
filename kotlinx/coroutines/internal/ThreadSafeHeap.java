package kotlinx.coroutines.internal;

import com.baidu.ugc.editvideo.sticker.StickerDataChangeType;
import java.lang.Comparable;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;
@InternalCoroutinesApi
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0019\b\u0017\u0018\u0000*\u0012\b\u0000\u0010\u0003*\u00020\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0007¢\u0006\u0004\b0\u0010\u000fJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0000H\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0004\b\b\u0010\u0007J.\u0010\f\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00028\u00002\u0014\u0010\u000b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00020\n0\tH\u0086\b¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u0005¢\u0006\u0004\b\u000e\u0010\u000fJ\u0011\u0010\u0010\u001a\u0004\u0018\u00018\u0000H\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0012\u0010\u0011J\u0017\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0013H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00020\u0018H\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ&\u0010\u001d\u001a\u0004\u0018\u00018\u00002\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n0\tH\u0086\b¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u001f\u0010\u0011J\u0018\u0010!\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0018H\u0082\u0010¢\u0006\u0004\b!\u0010\"J\u0018\u0010#\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0018H\u0082\u0010¢\u0006\u0004\b#\u0010\"J\u001f\u0010%\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u0018H\u0002¢\u0006\u0004\b%\u0010&R \u0010'\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0013\u0010)\u001a\u00020\n8F@\u0006¢\u0006\u0006\u001a\u0004\b)\u0010*R$\u0010/\u001a\u00020\u00182\u0006\u0010+\u001a\u00020\u00188F@BX\u0086\u000e¢\u0006\f\u001a\u0004\b,\u0010-\"\u0004\b.\u0010\"¨\u00061"}, d2 = {"Lkotlinx/coroutines/internal/ThreadSafeHeap;", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "", "T", "node", "", "addImpl", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;)V", "addLast", "Lkotlin/Function1;", "", "cond", "addLastIf", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;Lkotlin/jvm/functions/Function1;)Z", "clear", "()V", "firstImpl", "()Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "peek", "", "realloc", "()[Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "remove", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;)Z", "", "index", "removeAtImpl", "(I)Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "predicate", "removeFirstIf", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "removeFirstOrNull", "i", "siftDownFrom", "(I)V", "siftUpFrom", "j", StickerDataChangeType.SWAP, "(II)V", "a", "[Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "isEmpty", "()Z", "value", "getSize", "()I", "setSize", "size", "<init>", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes9.dex */
public class ThreadSafeHeap<T extends ThreadSafeHeapNode & Comparable<? super T>> {
    public volatile int _size = 0;

    /* renamed from: a  reason: collision with root package name */
    public T[] f73526a;

    private final T[] realloc() {
        T[] tArr = this.f73526a;
        if (tArr == null) {
            T[] tArr2 = (T[]) new ThreadSafeHeapNode[4];
            this.f73526a = tArr2;
            return tArr2;
        } else if (getSize() >= tArr.length) {
            Object[] copyOf = Arrays.copyOf(tArr, getSize() * 2);
            Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, newSize)");
            T[] tArr3 = (T[]) ((ThreadSafeHeapNode[]) copyOf);
            this.f73526a = tArr3;
            return tArr3;
        } else {
            return tArr;
        }
    }

    private final void setSize(int i2) {
        this._size = i2;
    }

    private final void siftDownFrom(int i2) {
        while (true) {
            int i3 = (i2 * 2) + 1;
            if (i3 >= getSize()) {
                return;
            }
            T[] tArr = this.f73526a;
            if (tArr == null) {
                Intrinsics.throwNpe();
            }
            int i4 = i3 + 1;
            if (i4 < getSize()) {
                T t = tArr[i4];
                if (t == null) {
                    Intrinsics.throwNpe();
                }
                Comparable comparable = (Comparable) t;
                T t2 = tArr[i3];
                if (t2 == null) {
                    Intrinsics.throwNpe();
                }
                if (comparable.compareTo(t2) < 0) {
                    i3 = i4;
                }
            }
            T t3 = tArr[i2];
            if (t3 == null) {
                Intrinsics.throwNpe();
            }
            Comparable comparable2 = (Comparable) t3;
            T t4 = tArr[i3];
            if (t4 == null) {
                Intrinsics.throwNpe();
            }
            if (comparable2.compareTo(t4) <= 0) {
                return;
            }
            swap(i2, i3);
            i2 = i3;
        }
    }

    private final void siftUpFrom(int i2) {
        while (i2 > 0) {
            T[] tArr = this.f73526a;
            if (tArr == null) {
                Intrinsics.throwNpe();
            }
            int i3 = (i2 - 1) / 2;
            T t = tArr[i3];
            if (t == null) {
                Intrinsics.throwNpe();
            }
            Comparable comparable = (Comparable) t;
            T t2 = tArr[i2];
            if (t2 == null) {
                Intrinsics.throwNpe();
            }
            if (comparable.compareTo(t2) <= 0) {
                return;
            }
            swap(i2, i3);
            i2 = i3;
        }
    }

    private final void swap(int i2, int i3) {
        T[] tArr = this.f73526a;
        if (tArr == null) {
            Intrinsics.throwNpe();
        }
        T t = tArr[i3];
        if (t == null) {
            Intrinsics.throwNpe();
        }
        T t2 = tArr[i2];
        if (t2 == null) {
            Intrinsics.throwNpe();
        }
        tArr[i2] = t;
        tArr[i3] = t2;
        t.setIndex(i2);
        t2.setIndex(i3);
    }

    @PublishedApi
    public final void addImpl(T t) {
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (!(t.getHeap() == null)) {
                throw new AssertionError();
            }
        }
        t.setHeap(this);
        T[] realloc = realloc();
        int size = getSize();
        setSize(size + 1);
        realloc[size] = t;
        t.setIndex(size);
        siftUpFrom(size);
    }

    public final void addLast(T t) {
        synchronized (this) {
            addImpl(t);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final boolean addLastIf(T t, Function1<? super T, Boolean> function1) {
        boolean z;
        synchronized (this) {
            try {
                if (function1.invoke(firstImpl()).booleanValue()) {
                    addImpl(t);
                    z = true;
                } else {
                    z = false;
                }
                InlineMarker.finallyStart(1);
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
        InlineMarker.finallyEnd(1);
        return z;
    }

    public final void clear() {
        synchronized (this) {
            T[] tArr = this.f73526a;
            if (tArr != null) {
                ArraysKt___ArraysJvmKt.fill$default(tArr, (Object) null, 0, 0, 6, (Object) null);
            }
            this._size = 0;
            Unit unit = Unit.INSTANCE;
        }
    }

    @PublishedApi
    public final T firstImpl() {
        T[] tArr = this.f73526a;
        if (tArr != null) {
            return tArr[0];
        }
        return null;
    }

    public final int getSize() {
        return this._size;
    }

    public final boolean isEmpty() {
        return getSize() == 0;
    }

    public final T peek() {
        T firstImpl;
        synchronized (this) {
            firstImpl = firstImpl();
        }
        return firstImpl;
    }

    public final boolean remove(T t) {
        boolean z;
        synchronized (this) {
            z = true;
            if (t.getHeap() == null) {
                z = false;
            } else {
                int index = t.getIndex();
                if (DebugKt.getASSERTIONS_ENABLED()) {
                    if (!(index >= 0)) {
                        throw new AssertionError();
                    }
                }
                removeAtImpl(index);
            }
        }
        return z;
    }

    @PublishedApi
    public final T removeAtImpl(int i2) {
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (!(getSize() > 0)) {
                throw new AssertionError();
            }
        }
        T[] tArr = this.f73526a;
        if (tArr == null) {
            Intrinsics.throwNpe();
        }
        setSize(getSize() - 1);
        if (i2 < getSize()) {
            swap(i2, getSize());
            int i3 = (i2 - 1) / 2;
            if (i2 > 0) {
                T t = tArr[i2];
                if (t == null) {
                    Intrinsics.throwNpe();
                }
                Comparable comparable = (Comparable) t;
                T t2 = tArr[i3];
                if (t2 == null) {
                    Intrinsics.throwNpe();
                }
                if (comparable.compareTo(t2) < 0) {
                    swap(i2, i3);
                    siftUpFrom(i3);
                }
            }
            siftDownFrom(i2);
        }
        T t3 = tArr[getSize()];
        if (t3 == null) {
            Intrinsics.throwNpe();
        }
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (!(t3.getHeap() == this)) {
                throw new AssertionError();
            }
        }
        t3.setHeap(null);
        t3.setIndex(-1);
        tArr[getSize()] = null;
        return t3;
    }

    public final T removeFirstIf(Function1<? super T, Boolean> function1) {
        synchronized (this) {
            try {
                T firstImpl = firstImpl();
                if (firstImpl != null) {
                    T removeAtImpl = function1.invoke(firstImpl).booleanValue() ? removeAtImpl(0) : null;
                    InlineMarker.finallyStart(1);
                    InlineMarker.finallyEnd(1);
                    return removeAtImpl;
                }
                InlineMarker.finallyStart(2);
                InlineMarker.finallyEnd(2);
                return null;
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
    }

    public final T removeFirstOrNull() {
        T removeAtImpl;
        synchronized (this) {
            removeAtImpl = getSize() > 0 ? removeAtImpl(0) : null;
        }
        return removeAtImpl;
    }
}
