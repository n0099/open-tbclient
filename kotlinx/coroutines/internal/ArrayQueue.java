package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt___ArraysJvmKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0010\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\n\u0010\u000bR\u001e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0013\u001a\u00020\u00128F@\u0006¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0011¨\u0006\u0017"}, d2 = {"Lkotlinx/coroutines/internal/ArrayQueue;", "", "T", "element", "", "addLast", "(Ljava/lang/Object;)V", "clear", "()V", "ensureCapacity", "removeFirstOrNull", "()Ljava/lang/Object;", "", "elements", "[Ljava/lang/Object;", "", "head", "I", "", "isEmpty", "()Z", "tail", "<init>", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public class ArrayQueue<T> {
    public Object[] elements = new Object[16];
    public int head;
    public int tail;

    private final void ensureCapacity() {
        Object[] objArr = this.elements;
        int length = objArr.length;
        Object[] objArr2 = new Object[length << 1];
        ArraysKt___ArraysJvmKt.copyInto$default(objArr, objArr2, 0, this.head, 0, 10, (Object) null);
        Object[] objArr3 = this.elements;
        int length2 = objArr3.length;
        int i2 = this.head;
        ArraysKt___ArraysJvmKt.copyInto$default(objArr3, objArr2, length2 - i2, 0, i2, 4, (Object) null);
        this.elements = objArr2;
        this.head = 0;
        this.tail = length;
    }

    public final void addLast(T t) {
        Object[] objArr = this.elements;
        int i2 = this.tail;
        objArr[i2] = t;
        int length = (objArr.length - 1) & (i2 + 1);
        this.tail = length;
        if (length == this.head) {
            ensureCapacity();
        }
    }

    public final void clear() {
        this.head = 0;
        this.tail = 0;
        this.elements = new Object[this.elements.length];
    }

    public final boolean isEmpty() {
        return this.head == this.tail;
    }

    public final T removeFirstOrNull() {
        int i2 = this.head;
        if (i2 == this.tail) {
            return null;
        }
        Object[] objArr = this.elements;
        T t = (T) objArr[i2];
        objArr[i2] = null;
        this.head = (i2 + 1) & (objArr.length - 1);
        if (t != null) {
            return t;
        }
        throw new TypeCastException("null cannot be cast to non-null type T");
    }
}
