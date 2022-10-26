package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.ugc.editvideo.sticker.StickerDataChangeType;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0019\b\u0017\u0018\u0000*\u0012\b\u0000\u0010\u0003*\u00020\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0007¢\u0006\u0004\b0\u0010\u000fJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0000H\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0004\b\b\u0010\u0007J.\u0010\f\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00028\u00002\u0014\u0010\u000b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00020\n0\tH\u0086\b¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u0005¢\u0006\u0004\b\u000e\u0010\u000fJ\u0011\u0010\u0010\u001a\u0004\u0018\u00018\u0000H\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0012\u0010\u0011J\u0017\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0013H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00020\u0018H\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ&\u0010\u001d\u001a\u0004\u0018\u00018\u00002\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n0\tH\u0086\b¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u001f\u0010\u0011J\u0018\u0010!\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0018H\u0082\u0010¢\u0006\u0004\b!\u0010\"J\u0018\u0010#\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0018H\u0082\u0010¢\u0006\u0004\b#\u0010\"J\u001f\u0010%\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u0018H\u0002¢\u0006\u0004\b%\u0010&R \u0010'\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0013\u0010)\u001a\u00020\n8F@\u0006¢\u0006\u0006\u001a\u0004\b)\u0010*R$\u0010/\u001a\u00020\u00182\u0006\u0010+\u001a\u00020\u00188F@BX\u0086\u000e¢\u0006\f\u001a\u0004\b,\u0010-\"\u0004\b.\u0010\"¨\u00061"}, d2 = {"Lkotlinx/coroutines/internal/ThreadSafeHeap;", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "", ExifInterface.GPS_DIRECTION_TRUE, "node", "", "addImpl", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;)V", "addLast", "Lkotlin/Function1;", "", "cond", "addLastIf", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;Lkotlin/jvm/functions/Function1;)Z", "clear", "()V", "firstImpl", "()Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "peek", "", "realloc", "()[Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "remove", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;)Z", "", "index", "removeAtImpl", "(I)Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "predicate", "removeFirstIf", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "removeFirstOrNull", "i", "siftDownFrom", "(I)V", "siftUpFrom", "j", StickerDataChangeType.SWAP, "(II)V", "a", "[Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "isEmpty", "()Z", "value", "getSize", "()I", "setSize", "size", "<init>", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public class ThreadSafeHeap {
    public volatile int _size = 0;
    public ThreadSafeHeapNode[] a;

    private final ThreadSafeHeapNode[] realloc() {
        ThreadSafeHeapNode[] threadSafeHeapNodeArr = this.a;
        if (threadSafeHeapNodeArr == null) {
            ThreadSafeHeapNode[] threadSafeHeapNodeArr2 = new ThreadSafeHeapNode[4];
            this.a = threadSafeHeapNodeArr2;
            return threadSafeHeapNodeArr2;
        } else if (getSize() >= threadSafeHeapNodeArr.length) {
            Object[] copyOf = Arrays.copyOf(threadSafeHeapNodeArr, getSize() * 2);
            Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, newSize)");
            ThreadSafeHeapNode[] threadSafeHeapNodeArr3 = (ThreadSafeHeapNode[]) copyOf;
            this.a = threadSafeHeapNodeArr3;
            return threadSafeHeapNodeArr3;
        } else {
            return threadSafeHeapNodeArr;
        }
    }

    public final void clear() {
        synchronized (this) {
            ThreadSafeHeapNode[] threadSafeHeapNodeArr = this.a;
            if (threadSafeHeapNodeArr != null) {
                ArraysKt___ArraysJvmKt.fill$default(threadSafeHeapNodeArr, (Object) null, 0, 0, 6, (Object) null);
            }
            this._size = 0;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final ThreadSafeHeapNode firstImpl() {
        ThreadSafeHeapNode[] threadSafeHeapNodeArr = this.a;
        if (threadSafeHeapNodeArr != null) {
            return threadSafeHeapNodeArr[0];
        }
        return null;
    }

    public final int getSize() {
        return this._size;
    }

    public final boolean isEmpty() {
        if (getSize() == 0) {
            return true;
        }
        return false;
    }

    public final ThreadSafeHeapNode peek() {
        ThreadSafeHeapNode firstImpl;
        synchronized (this) {
            firstImpl = firstImpl();
        }
        return firstImpl;
    }

    public final ThreadSafeHeapNode removeFirstOrNull() {
        ThreadSafeHeapNode threadSafeHeapNode;
        synchronized (this) {
            if (getSize() > 0) {
                threadSafeHeapNode = removeAtImpl(0);
            } else {
                threadSafeHeapNode = null;
            }
        }
        return threadSafeHeapNode;
    }

    private final void setSize(int i) {
        this._size = i;
    }

    private final void siftUpFrom(int i) {
        while (i > 0) {
            ThreadSafeHeapNode[] threadSafeHeapNodeArr = this.a;
            if (threadSafeHeapNodeArr == null) {
                Intrinsics.throwNpe();
            }
            int i2 = (i - 1) / 2;
            ThreadSafeHeapNode threadSafeHeapNode = threadSafeHeapNodeArr[i2];
            if (threadSafeHeapNode == null) {
                Intrinsics.throwNpe();
            }
            Comparable comparable = (Comparable) threadSafeHeapNode;
            ThreadSafeHeapNode threadSafeHeapNode2 = threadSafeHeapNodeArr[i];
            if (threadSafeHeapNode2 == null) {
                Intrinsics.throwNpe();
            }
            if (comparable.compareTo(threadSafeHeapNode2) <= 0) {
                return;
            }
            swap(i, i2);
            i = i2;
        }
    }

    public final void addImpl(ThreadSafeHeapNode threadSafeHeapNode) {
        boolean z;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (threadSafeHeapNode.getHeap() == null) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                throw new AssertionError();
            }
        }
        threadSafeHeapNode.setHeap(this);
        ThreadSafeHeapNode[] realloc = realloc();
        int size = getSize();
        setSize(size + 1);
        realloc[size] = threadSafeHeapNode;
        threadSafeHeapNode.setIndex(size);
        siftUpFrom(size);
    }

    public final void addLast(ThreadSafeHeapNode threadSafeHeapNode) {
        synchronized (this) {
            addImpl(threadSafeHeapNode);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final boolean remove(ThreadSafeHeapNode threadSafeHeapNode) {
        boolean z;
        synchronized (this) {
            z = true;
            boolean z2 = false;
            if (threadSafeHeapNode.getHeap() == null) {
                z = false;
            } else {
                int index = threadSafeHeapNode.getIndex();
                if (DebugKt.getASSERTIONS_ENABLED()) {
                    if (index >= 0) {
                        z2 = true;
                    }
                    if (!z2) {
                        throw new AssertionError();
                    }
                }
                removeAtImpl(index);
            }
        }
        return z;
    }

    private final void siftDownFrom(int i) {
        while (true) {
            int i2 = (i * 2) + 1;
            if (i2 >= getSize()) {
                return;
            }
            ThreadSafeHeapNode[] threadSafeHeapNodeArr = this.a;
            if (threadSafeHeapNodeArr == null) {
                Intrinsics.throwNpe();
            }
            int i3 = i2 + 1;
            if (i3 < getSize()) {
                ThreadSafeHeapNode threadSafeHeapNode = threadSafeHeapNodeArr[i3];
                if (threadSafeHeapNode == null) {
                    Intrinsics.throwNpe();
                }
                Comparable comparable = (Comparable) threadSafeHeapNode;
                ThreadSafeHeapNode threadSafeHeapNode2 = threadSafeHeapNodeArr[i2];
                if (threadSafeHeapNode2 == null) {
                    Intrinsics.throwNpe();
                }
                if (comparable.compareTo(threadSafeHeapNode2) < 0) {
                    i2 = i3;
                }
            }
            ThreadSafeHeapNode threadSafeHeapNode3 = threadSafeHeapNodeArr[i];
            if (threadSafeHeapNode3 == null) {
                Intrinsics.throwNpe();
            }
            Comparable comparable2 = (Comparable) threadSafeHeapNode3;
            ThreadSafeHeapNode threadSafeHeapNode4 = threadSafeHeapNodeArr[i2];
            if (threadSafeHeapNode4 == null) {
                Intrinsics.throwNpe();
            }
            if (comparable2.compareTo(threadSafeHeapNode4) <= 0) {
                return;
            }
            swap(i, i2);
            i = i2;
        }
    }

    private final void swap(int i, int i2) {
        ThreadSafeHeapNode[] threadSafeHeapNodeArr = this.a;
        if (threadSafeHeapNodeArr == null) {
            Intrinsics.throwNpe();
        }
        ThreadSafeHeapNode threadSafeHeapNode = threadSafeHeapNodeArr[i2];
        if (threadSafeHeapNode == null) {
            Intrinsics.throwNpe();
        }
        ThreadSafeHeapNode threadSafeHeapNode2 = threadSafeHeapNodeArr[i];
        if (threadSafeHeapNode2 == null) {
            Intrinsics.throwNpe();
        }
        threadSafeHeapNodeArr[i] = threadSafeHeapNode;
        threadSafeHeapNodeArr[i2] = threadSafeHeapNode2;
        threadSafeHeapNode.setIndex(i);
        threadSafeHeapNode2.setIndex(i2);
    }

    public final boolean addLastIf(ThreadSafeHeapNode threadSafeHeapNode, Function1 function1) {
        boolean z;
        synchronized (this) {
            try {
                if (((Boolean) function1.invoke(firstImpl())).booleanValue()) {
                    addImpl(threadSafeHeapNode);
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

    public final ThreadSafeHeapNode removeAtImpl(int i) {
        boolean z;
        boolean z2 = false;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (getSize() > 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                throw new AssertionError();
            }
        }
        ThreadSafeHeapNode[] threadSafeHeapNodeArr = this.a;
        if (threadSafeHeapNodeArr == null) {
            Intrinsics.throwNpe();
        }
        setSize(getSize() - 1);
        if (i < getSize()) {
            swap(i, getSize());
            int i2 = (i - 1) / 2;
            if (i > 0) {
                ThreadSafeHeapNode threadSafeHeapNode = threadSafeHeapNodeArr[i];
                if (threadSafeHeapNode == null) {
                    Intrinsics.throwNpe();
                }
                Comparable comparable = (Comparable) threadSafeHeapNode;
                ThreadSafeHeapNode threadSafeHeapNode2 = threadSafeHeapNodeArr[i2];
                if (threadSafeHeapNode2 == null) {
                    Intrinsics.throwNpe();
                }
                if (comparable.compareTo(threadSafeHeapNode2) < 0) {
                    swap(i, i2);
                    siftUpFrom(i2);
                }
            }
            siftDownFrom(i);
        }
        ThreadSafeHeapNode threadSafeHeapNode3 = threadSafeHeapNodeArr[getSize()];
        if (threadSafeHeapNode3 == null) {
            Intrinsics.throwNpe();
        }
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (threadSafeHeapNode3.getHeap() == this) {
                z2 = true;
            }
            if (!z2) {
                throw new AssertionError();
            }
        }
        threadSafeHeapNode3.setHeap(null);
        threadSafeHeapNode3.setIndex(-1);
        threadSafeHeapNodeArr[getSize()] = null;
        return threadSafeHeapNode3;
    }

    public final ThreadSafeHeapNode removeFirstIf(Function1 function1) {
        synchronized (this) {
            try {
                ThreadSafeHeapNode firstImpl = firstImpl();
                ThreadSafeHeapNode threadSafeHeapNode = null;
                if (firstImpl != null) {
                    if (((Boolean) function1.invoke(firstImpl)).booleanValue()) {
                        threadSafeHeapNode = removeAtImpl(0);
                    }
                    InlineMarker.finallyStart(1);
                    InlineMarker.finallyEnd(1);
                    return threadSafeHeapNode;
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
}
