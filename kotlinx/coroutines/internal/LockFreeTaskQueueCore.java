package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.DebugKt;
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0016\b\u0000\u0018\u0000 /*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001:\u0002/0B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00028\u0000¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0000j\b\u0012\u0004\u0012\u00028\u0000`\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0000j\b\u0012\u0004\u0012\u00028\u0000`\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0011\u0010\u0010J\r\u0010\u0012\u001a\u00020\u0005¢\u0006\u0004\b\u0012\u0010\u0013J3\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u000e2\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\t\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\u0005¢\u0006\u0004\b\u0017\u0010\u0013J-\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00010\u001b\"\u0004\b\u0001\u0010\u00182\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0019¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0013\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u0000¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\"\u0010#J3\u0010&\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u000e2\u0006\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u0003H\u0002¢\u0006\u0004\b&\u0010'R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010(R\u0011\u0010)\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b)\u0010\u0013R\u0014\u0010*\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010(R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010+R\u0011\u0010.\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b,\u0010-¨\u00061"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "", ExifInterface.LONGITUDE_EAST, "", "capacity", "", "singleConsumer", "<init>", "(IZ)V", "element", "addLast", "(Ljava/lang/Object;)I", "", "state", "Lkotlinx/coroutines/internal/Core;", "allocateNextCopy", "(J)Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "allocateOrGetNextCopy", "close", "()Z", "index", "fillPlaceholder", "(ILjava/lang/Object;)Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "isClosed", "R", "Lkotlin/Function1;", "transform", "", "map", "(Lkotlin/jvm/functions/Function1;)Ljava/util/List;", "markFrozen", "()J", "next", "()Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "removeFirstOrNull", "()Ljava/lang/Object;", "oldHead", "newHead", "removeSlowPath", "(II)Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "I", "isEmpty", "mask", "Z", "getSize", "()I", "size", "Companion", "Placeholder", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes10.dex */
public final class LockFreeTaskQueueCore<E> {
    public static final int ADD_CLOSED = 2;
    public static final int ADD_FROZEN = 1;
    public static final int ADD_SUCCESS = 0;
    public static final int CAPACITY_BITS = 30;
    public static final long CLOSED_MASK = 2305843009213693952L;
    public static final int CLOSED_SHIFT = 61;
    public static final long FROZEN_MASK = 1152921504606846976L;
    public static final int FROZEN_SHIFT = 60;
    public static final long HEAD_MASK = 1073741823;
    public static final int HEAD_SHIFT = 0;
    public static final int INITIAL_CAPACITY = 8;
    public static final int MAX_CAPACITY_MASK = 1073741823;
    public static final int MIN_ADD_SPIN_CAPACITY = 1024;
    public static final long TAIL_MASK = 1152921503533105152L;
    public static final int TAIL_SHIFT = 30;
    public volatile /* synthetic */ Object _next = null;
    public volatile /* synthetic */ long _state = 0;
    public /* synthetic */ AtomicReferenceArray array;
    public final int capacity;
    public final int mask;
    public final boolean singleConsumer;
    public static final Companion Companion = new Companion(null);
    @JvmField
    public static final Symbol REMOVE_FROZEN = new Symbol("REMOVE_FROZEN");
    public static final /* synthetic */ AtomicReferenceFieldUpdater _next$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeTaskQueueCore.class, Object.class, "_next");
    public static final /* synthetic */ AtomicLongFieldUpdater _state$FU = AtomicLongFieldUpdater.newUpdater(LockFreeTaskQueueCore.class, "_state");

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u0016\u001a\u00020\u0004*\u00020\tJ\u0012\u0010\u0017\u001a\u00020\t*\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0004J\u0012\u0010\u0019\u001a\u00020\t*\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0004JP\u0010\u001b\u001a\u0002H\u001c\"\u0004\b\u0001\u0010\u001c*\u00020\t26\u0010\u001d\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\"\u0012\u0004\u0012\u0002H\u001c0\u001eH\u0086\b¢\u0006\u0002\u0010#J\u0015\u0010$\u001a\u00020\t*\u00020\t2\u0006\u0010%\u001a\u00020\tH\u0086\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u00138\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore$Companion;", "", "()V", "ADD_CLOSED", "", "ADD_FROZEN", "ADD_SUCCESS", "CAPACITY_BITS", "CLOSED_MASK", "", "CLOSED_SHIFT", "FROZEN_MASK", "FROZEN_SHIFT", "HEAD_MASK", "HEAD_SHIFT", "INITIAL_CAPACITY", "MAX_CAPACITY_MASK", "MIN_ADD_SPIN_CAPACITY", "REMOVE_FROZEN", "Lkotlinx/coroutines/internal/Symbol;", "TAIL_MASK", "TAIL_SHIFT", "addFailReason", "updateHead", "newHead", "updateTail", "newTail", "withState", ExifInterface.GPS_DIRECTION_TRUE, BreakpointSQLiteHelper.BLOCK_TABLE_NAME, "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "head", "tail", "(JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "wo", "other", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes10.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int addFailReason(long j) {
            return (j & LockFreeTaskQueueCore.CLOSED_MASK) != 0 ? 2 : 1;
        }

        public final long wo(long j, long j2) {
            return j & (~j2);
        }

        public Companion() {
        }

        public final long updateHead(long j, int i) {
            return wo(j, LockFreeTaskQueueCore.HEAD_MASK) | (i << 0);
        }

        public final long updateTail(long j, int i) {
            return wo(j, LockFreeTaskQueueCore.TAIL_MASK) | (i << 30);
        }

        public final <T> T withState(long j, Function2<? super Integer, ? super Integer, ? extends T> function2) {
            return function2.invoke(Integer.valueOf((int) ((LockFreeTaskQueueCore.HEAD_MASK & j) >> 0)), Integer.valueOf((int) ((j & LockFreeTaskQueueCore.TAIL_MASK) >> 30)));
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore$Placeholder;", "", "index", "", "(I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes10.dex */
    public static final class Placeholder {
        @JvmField
        public final int index;

        public Placeholder(int i) {
            this.index = i;
        }
    }

    private final long markFrozen() {
        long j;
        long j2;
        do {
            j = this._state;
            if ((j & FROZEN_MASK) != 0) {
                return j;
            }
            j2 = j | FROZEN_MASK;
        } while (!_state$FU.compareAndSet(this, j, j2));
        return j2;
    }

    public final boolean close() {
        long j;
        do {
            j = this._state;
            if ((j & CLOSED_MASK) != 0) {
                return true;
            }
            if ((FROZEN_MASK & j) != 0) {
                return false;
            }
        } while (!_state$FU.compareAndSet(this, j, j | CLOSED_MASK));
        return true;
    }

    public final int getSize() {
        long j = this._state;
        return 1073741823 & (((int) ((j & TAIL_MASK) >> 30)) - ((int) ((HEAD_MASK & j) >> 0)));
    }

    public final boolean isClosed() {
        if ((this._state & CLOSED_MASK) != 0) {
            return true;
        }
        return false;
    }

    public final boolean isEmpty() {
        long j = this._state;
        if (((int) ((HEAD_MASK & j) >> 0)) != ((int) ((j & TAIL_MASK) >> 30))) {
            return false;
        }
        return true;
    }

    public final LockFreeTaskQueueCore<E> next() {
        return allocateOrGetNextCopy(markFrozen());
    }

    public LockFreeTaskQueueCore(int i, boolean z) {
        boolean z2;
        this.capacity = i;
        this.singleConsumer = z;
        this.mask = i - 1;
        this.array = new AtomicReferenceArray(this.capacity);
        if (this.mask <= 1073741823) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            if ((this.capacity & this.mask) == 0) {
                return;
            }
            throw new IllegalStateException("Check failed.".toString());
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v2, resolved type: java.util.concurrent.atomic.AtomicReferenceArray */
    /* JADX WARN: Multi-variable type inference failed */
    private final LockFreeTaskQueueCore<E> allocateNextCopy(long j) {
        LockFreeTaskQueueCore<E> lockFreeTaskQueueCore = new LockFreeTaskQueueCore<>(this.capacity * 2, this.singleConsumer);
        int i = (int) ((HEAD_MASK & j) >> 0);
        int i2 = (int) ((TAIL_MASK & j) >> 30);
        while (true) {
            int i3 = this.mask;
            if ((i & i3) != (i2 & i3)) {
                Object obj = this.array.get(i3 & i);
                if (obj == null) {
                    obj = new Placeholder(i);
                }
                lockFreeTaskQueueCore.array.set(lockFreeTaskQueueCore.mask & i, obj);
                i++;
            } else {
                lockFreeTaskQueueCore._state = Companion.wo(j, FROZEN_MASK);
                return lockFreeTaskQueueCore;
            }
        }
    }

    private final LockFreeTaskQueueCore<E> allocateOrGetNextCopy(long j) {
        while (true) {
            LockFreeTaskQueueCore<E> lockFreeTaskQueueCore = (LockFreeTaskQueueCore) this._next;
            if (lockFreeTaskQueueCore != null) {
                return lockFreeTaskQueueCore;
            }
            _next$FU.compareAndSet(this, null, allocateNextCopy(j));
        }
    }

    private final LockFreeTaskQueueCore<E> fillPlaceholder(int i, E e) {
        Object obj = this.array.get(this.mask & i);
        if ((obj instanceof Placeholder) && ((Placeholder) obj).index == i) {
            this.array.set(i & this.mask, e);
            return this;
        }
        return null;
    }

    private final LockFreeTaskQueueCore<E> removeSlowPath(int i, int i2) {
        long j;
        int i3;
        do {
            j = this._state;
            boolean z = false;
            i3 = (int) ((HEAD_MASK & j) >> 0);
            if (DebugKt.getASSERTIONS_ENABLED()) {
                if (i3 == i) {
                    z = true;
                }
                if (!z) {
                    throw new AssertionError();
                }
            }
            if ((FROZEN_MASK & j) != 0) {
                return next();
            }
        } while (!_state$FU.compareAndSet(this, j, Companion.updateHead(j, i2)));
        this.array.set(this.mask & i3, null);
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x004c, code lost:
        return 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int addLast(E e) {
        while (true) {
            long j = this._state;
            if ((3458764513820540928L & j) != 0) {
                return Companion.addFailReason(j);
            }
            int i = (int) ((HEAD_MASK & j) >> 0);
            int i2 = (int) ((TAIL_MASK & j) >> 30);
            int i3 = this.mask;
            if (((i2 + 2) & i3) == (i & i3)) {
                return 1;
            }
            if (!this.singleConsumer && this.array.get(i2 & i3) != null) {
                int i4 = this.capacity;
                if (i4 < 1024 || ((i2 - i) & MAX_CAPACITY_MASK) > (i4 >> 1)) {
                    break;
                }
            } else if (_state$FU.compareAndSet(this, j, Companion.updateTail(j, (i2 + 1) & MAX_CAPACITY_MASK))) {
                this.array.set(i2 & i3, e);
                LockFreeTaskQueueCore<E> lockFreeTaskQueueCore = this;
                while ((lockFreeTaskQueueCore._state & FROZEN_MASK) != 0 && (lockFreeTaskQueueCore = lockFreeTaskQueueCore.next().fillPlaceholder(i2, e)) != null) {
                }
                return 0;
            }
        }
    }

    public final <R> List<R> map(Function1<? super E, ? extends R> function1) {
        ArrayList arrayList = new ArrayList(this.capacity);
        long j = this._state;
        int i = (int) ((HEAD_MASK & j) >> 0);
        int i2 = (int) ((j & TAIL_MASK) >> 30);
        while (true) {
            int i3 = this.mask;
            if ((i & i3) != (i2 & i3)) {
                Object obj = (Object) this.array.get(i3 & i);
                if (obj != 0 && !(obj instanceof Placeholder)) {
                    arrayList.add(function1.invoke(obj));
                }
                i++;
            } else {
                return arrayList;
            }
        }
    }

    public final Object removeFirstOrNull() {
        while (true) {
            long j = this._state;
            if ((FROZEN_MASK & j) != 0) {
                return REMOVE_FROZEN;
            }
            int i = (int) ((HEAD_MASK & j) >> 0);
            int i2 = (int) ((TAIL_MASK & j) >> 30);
            int i3 = this.mask;
            if ((i2 & i3) == (i & i3)) {
                return null;
            }
            Object obj = this.array.get(i3 & i);
            if (obj == null) {
                if (this.singleConsumer) {
                    return null;
                }
            } else if (obj instanceof Placeholder) {
                return null;
            } else {
                int i4 = (i + 1) & MAX_CAPACITY_MASK;
                if (_state$FU.compareAndSet(this, j, Companion.updateHead(j, i4))) {
                    this.array.set(this.mask & i, null);
                    return obj;
                } else if (this.singleConsumer) {
                    LockFreeTaskQueueCore<E> lockFreeTaskQueueCore = this;
                    do {
                        lockFreeTaskQueueCore = lockFreeTaskQueueCore.removeSlowPath(i, i4);
                    } while (lockFreeTaskQueueCore != null);
                    return obj;
                }
            }
        }
    }
}
