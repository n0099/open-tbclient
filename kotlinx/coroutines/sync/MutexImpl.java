package kotlinx.coroutines.sync;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.sapi2.ecommerce.activity.InvoiceBuildActivity;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteHelper;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.internal.AtomicDesc;
import kotlinx.coroutines.internal.AtomicKt;
import kotlinx.coroutines.internal.AtomicOp;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListKt;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.OpDescriptor;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectKt;
import org.aspectj.lang.JoinPoint;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0016\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002:\u0006$%&'()B\u000f\u0012\u0006\u0010!\u001a\u00020\u0005¢\u0006\u0004\b\"\u0010#J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\t\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0096@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000b\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\nJT\u0010\u0012\u001a\u00020\b\"\u0004\b\u0000\u0010\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\"\u0010\u0011\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000fH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0017\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0017\u0010\u0007J\u0019\u0010\u0018\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\u00020\u00058V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\u00058@@\u0000X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001bR$\u0010 \u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00010\u00028V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006*"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl;", "Lkotlinx/coroutines/sync/Mutex;", "Lkotlinx/coroutines/selects/SelectClause2;", "", "owner", "", "holdsLock", "(Ljava/lang/Object;)Z", "", "lock", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lockSuspend", "R", "Lkotlinx/coroutines/selects/SelectInstance;", InvoiceBuildActivity.EXTRA_PARAMS_TYPE, "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", BreakpointSQLiteHelper.BLOCK_TABLE_NAME, "registerSelectClause2", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "", "toString", "()Ljava/lang/String;", "tryLock", JoinPoint.SYNCHRONIZATION_UNLOCK, "(Ljava/lang/Object;)V", "isLocked", "()Z", "isLockedEmptyQueueState$kotlinx_coroutines_core", "isLockedEmptyQueueState", "getOnLock", "()Lkotlinx/coroutines/selects/SelectClause2;", "onLock", "locked", "<init>", "(Z)V", "LockCont", "LockSelect", "LockWaiter", "LockedQueue", "TryLockDesc", "UnlockOp", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class MutexImpl implements Mutex, SelectClause2<Object, Mutex> {
    public static final AtomicReferenceFieldUpdater _state$FU = AtomicReferenceFieldUpdater.newUpdater(MutexImpl.class, Object.class, "_state");
    public volatile Object _state;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\f¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\f8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$LockCont;", "kotlinx/coroutines/sync/MutexImpl$LockWaiter", "", "token", "", "completeResumeLockWaiter", "(Ljava/lang/Object;)V", "", "toString", "()Ljava/lang/String;", "tryResumeLockWaiter", "()Ljava/lang/Object;", "Lkotlinx/coroutines/CancellableContinuation;", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "owner", "<init>", "(Ljava/lang/Object;Lkotlinx/coroutines/CancellableContinuation;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes3.dex */
    public static final class LockCont extends LockWaiter {
        @JvmField
        public final CancellableContinuation<Unit> cont;

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlinx.coroutines.CancellableContinuation<? super kotlin.Unit> */
        /* JADX WARN: Multi-variable type inference failed */
        public LockCont(Object obj, CancellableContinuation<? super Unit> cancellableContinuation) {
            super(obj);
            this.cont = cancellableContinuation;
        }

        @Override // kotlinx.coroutines.sync.MutexImpl.LockWaiter
        public void completeResumeLockWaiter(Object obj) {
            this.cont.completeResume(obj);
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        public String toString() {
            return "LockCont[" + this.owner + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.cont + ']';
        }

        @Override // kotlinx.coroutines.sync.MutexImpl.LockWaiter
        public Object tryResumeLockWaiter() {
            return CancellableContinuation.DefaultImpls.tryResume$default(this.cont, Unit.INSTANCE, null, 2, null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002BN\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014\u0012\"\u0010\u0010\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00030\rø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\fR5\u0010\u0010\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00030\r8\u0006@\u0007X\u0087\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u00020\u000e8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00148\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$LockSelect;", "R", "kotlinx/coroutines/sync/MutexImpl$LockWaiter", "", "token", "", "completeResumeLockWaiter", "(Ljava/lang/Object;)V", "", "toString", "()Ljava/lang/String;", "tryResumeLockWaiter", "()Ljava/lang/Object;", "Lkotlin/Function2;", "Lkotlinx/coroutines/sync/Mutex;", "Lkotlin/coroutines/Continuation;", BreakpointSQLiteHelper.BLOCK_TABLE_NAME, "Lkotlin/jvm/functions/Function2;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "Lkotlinx/coroutines/selects/SelectInstance;", InvoiceBuildActivity.EXTRA_PARAMS_TYPE, "Lkotlinx/coroutines/selects/SelectInstance;", "owner", "<init>", "(Ljava/lang/Object;Lkotlinx/coroutines/sync/Mutex;Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes3.dex */
    public static final class LockSelect<R> extends LockWaiter {
        @JvmField
        public final Function2<Mutex, Continuation<? super R>, Object> block;
        @JvmField
        public final Mutex mutex;
        @JvmField
        public final SelectInstance<R> select;

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlinx.coroutines.selects.SelectInstance<? super R> */
        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.functions.Function2<? super kotlinx.coroutines.sync.Mutex, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> */
        /* JADX WARN: Multi-variable type inference failed */
        public LockSelect(Object obj, Mutex mutex, SelectInstance<? super R> selectInstance, Function2<? super Mutex, ? super Continuation<? super R>, ? extends Object> function2) {
            super(obj);
            this.mutex = mutex;
            this.select = selectInstance;
            this.block = function2;
        }

        @Override // kotlinx.coroutines.sync.MutexImpl.LockWaiter
        public void completeResumeLockWaiter(Object obj) {
            Symbol symbol;
            if (DebugKt.getASSERTIONS_ENABLED()) {
                symbol = MutexKt.SELECT_SUCCESS;
                if (!(obj == symbol)) {
                    throw new AssertionError();
                }
            }
            ContinuationKt.startCoroutine(this.block, this.mutex, this.select.getCompletion());
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        public String toString() {
            return "LockSelect[" + this.owner + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.mutex + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.select + ']';
        }

        @Override // kotlinx.coroutines.sync.MutexImpl.LockWaiter
        public Object tryResumeLockWaiter() {
            Symbol symbol;
            if (this.select.trySelect()) {
                symbol = MutexKt.SELECT_SUCCESS;
                return symbol;
            }
            return null;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\b\"\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000e\u0010\u0007J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\n\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$LockWaiter;", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "", "token", "", "completeResumeLockWaiter", "(Ljava/lang/Object;)V", "dispose", "()V", "tryResumeLockWaiter", "()Ljava/lang/Object;", "owner", "Ljava/lang/Object;", "<init>", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes3.dex */
    public static abstract class LockWaiter extends LockFreeLinkedListNode implements DisposableHandle {
        @JvmField
        public final Object owner;

        public LockWaiter(Object obj) {
            this.owner = obj;
        }

        public abstract void completeResumeLockWaiter(Object obj);

        @Override // kotlinx.coroutines.DisposableHandle
        public final void dispose() {
            remove();
        }

        public abstract Object tryResumeLockWaiter();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$LockedQueue;", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "", "toString", "()Ljava/lang/String;", "", "owner", "Ljava/lang/Object;", "<init>", "(Ljava/lang/Object;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes3.dex */
    public static final class LockedQueue extends LockFreeLinkedListHead {
        @JvmField
        public Object owner;

        public LockedQueue(Object obj) {
            this.owner = obj;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        public String toString() {
            return "LockedQueue[" + this.owner + ']';
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0012B\u0019\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0010\u0010\u0011J%\u0010\u0007\u001a\u00020\u00062\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\t\u001a\u0004\u0018\u00010\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$TryLockDesc;", "Lkotlinx/coroutines/internal/AtomicDesc;", "Lkotlinx/coroutines/internal/AtomicOp;", "op", "", SmsLoginView.f.l, "", "complete", "(Lkotlinx/coroutines/internal/AtomicOp;Ljava/lang/Object;)V", "prepare", "(Lkotlinx/coroutines/internal/AtomicOp;)Ljava/lang/Object;", "Lkotlinx/coroutines/sync/MutexImpl;", "mutex", "Lkotlinx/coroutines/sync/MutexImpl;", "owner", "Ljava/lang/Object;", "<init>", "(Lkotlinx/coroutines/sync/MutexImpl;Ljava/lang/Object;)V", "PrepareOp", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes3.dex */
    public static final class TryLockDesc extends AtomicDesc {
        @JvmField
        public final MutexImpl mutex;
        @JvmField
        public final Object owner;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R \u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00068\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$TryLockDesc$PrepareOp;", "Lkotlinx/coroutines/internal/OpDescriptor;", "", "affected", "perform", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/AtomicOp;", "atomicOp", "Lkotlinx/coroutines/internal/AtomicOp;", "getAtomicOp", "()Lkotlinx/coroutines/internal/AtomicOp;", "<init>", "(Lkotlinx/coroutines/sync/MutexImpl$TryLockDesc;Lkotlinx/coroutines/internal/AtomicOp;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
        /* loaded from: classes3.dex */
        public final class PrepareOp extends OpDescriptor {
            public final AtomicOp<?> atomicOp;

            public PrepareOp(AtomicOp<?> atomicOp) {
                this.atomicOp = atomicOp;
            }

            @Override // kotlinx.coroutines.internal.OpDescriptor
            public AtomicOp<?> getAtomicOp() {
                return this.atomicOp;
            }

            @Override // kotlinx.coroutines.internal.OpDescriptor
            public Object perform(Object obj) {
                Object atomicOp = getAtomicOp().isDecided() ? MutexKt.EMPTY_UNLOCKED : getAtomicOp();
                if (obj != null) {
                    MutexImpl._state$FU.compareAndSet((MutexImpl) obj, this, atomicOp);
                    return null;
                }
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.sync.MutexImpl");
            }
        }

        public TryLockDesc(MutexImpl mutexImpl, Object obj) {
            this.mutex = mutexImpl;
            this.owner = obj;
        }

        @Override // kotlinx.coroutines.internal.AtomicDesc
        public void complete(AtomicOp<?> atomicOp, Object obj) {
            Empty empty;
            if (obj != null) {
                empty = MutexKt.EMPTY_UNLOCKED;
            } else {
                Object obj2 = this.owner;
                empty = obj2 == null ? MutexKt.EMPTY_LOCKED : new Empty(obj2);
            }
            MutexImpl._state$FU.compareAndSet(this.mutex, atomicOp, empty);
        }

        @Override // kotlinx.coroutines.internal.AtomicDesc
        public Object prepare(AtomicOp<?> atomicOp) {
            Empty empty;
            Symbol symbol;
            PrepareOp prepareOp = new PrepareOp(atomicOp);
            MutexImpl mutexImpl = this.mutex;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = MutexImpl._state$FU;
            empty = MutexKt.EMPTY_UNLOCKED;
            if (!atomicReferenceFieldUpdater.compareAndSet(mutexImpl, empty, prepareOp)) {
                symbol = MutexKt.LOCK_FAIL;
                return symbol;
            }
            return prepareOp.perform(this.mutex);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u001c\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00068V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u00020\n8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$UnlockOp;", "Lkotlinx/coroutines/internal/OpDescriptor;", "", "affected", "perform", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/AtomicOp;", "getAtomicOp", "()Lkotlinx/coroutines/internal/AtomicOp;", "atomicOp", "Lkotlinx/coroutines/sync/MutexImpl$LockedQueue;", "queue", "Lkotlinx/coroutines/sync/MutexImpl$LockedQueue;", "<init>", "(Lkotlinx/coroutines/sync/MutexImpl$LockedQueue;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes3.dex */
    public static final class UnlockOp extends OpDescriptor {
        @JvmField
        public final LockedQueue queue;

        public UnlockOp(LockedQueue lockedQueue) {
            this.queue = lockedQueue;
        }

        @Override // kotlinx.coroutines.internal.OpDescriptor
        public AtomicOp<?> getAtomicOp() {
            return null;
        }

        @Override // kotlinx.coroutines.internal.OpDescriptor
        public Object perform(Object obj) {
            Symbol symbol;
            Object obj2 = this.queue.isEmpty() ? MutexKt.EMPTY_UNLOCKED : this.queue;
            if (obj != null) {
                MutexImpl mutexImpl = (MutexImpl) obj;
                MutexImpl._state$FU.compareAndSet(mutexImpl, this, obj2);
                if (mutexImpl._state == this.queue) {
                    symbol = MutexKt.UNLOCK_FAIL;
                    return symbol;
                }
                return null;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.sync.MutexImpl");
        }
    }

    public MutexImpl(boolean z) {
        this._state = z ? MutexKt.EMPTY_LOCKED : MutexKt.EMPTY_UNLOCKED;
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public SelectClause2<Object, Mutex> getOnLock() {
        return this;
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public boolean holdsLock(Object obj) {
        Object obj2 = this._state;
        if (obj2 instanceof Empty) {
            if (((Empty) obj2).locked == obj) {
                return true;
            }
        } else if ((obj2 instanceof LockedQueue) && ((LockedQueue) obj2).owner == obj) {
            return true;
        }
        return false;
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public boolean isLocked() {
        Symbol symbol;
        while (true) {
            Object obj = this._state;
            if (obj instanceof Empty) {
                Object obj2 = ((Empty) obj).locked;
                symbol = MutexKt.UNLOCKED;
                return obj2 != symbol;
            } else if (obj instanceof LockedQueue) {
                return true;
            } else {
                if (!(obj instanceof OpDescriptor)) {
                    throw new IllegalStateException(("Illegal state " + obj).toString());
                }
                ((OpDescriptor) obj).perform(this);
            }
        }
    }

    public final boolean isLockedEmptyQueueState$kotlinx_coroutines_core() {
        Object obj = this._state;
        return (obj instanceof LockedQueue) && ((LockedQueue) obj).isEmpty();
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public Object lock(Object obj, Continuation<? super Unit> continuation) {
        Object lockSuspend;
        return (!tryLock(obj) && (lockSuspend = lockSuspend(obj, continuation)) == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? lockSuspend : Unit.INSTANCE;
    }

    public final /* synthetic */ Object lockSuspend(final Object obj, Continuation<? super Unit> continuation) {
        Symbol symbol;
        final CancellableContinuationImpl orCreateCancellableContinuation = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        final LockCont lockCont = new LockCont(obj, orCreateCancellableContinuation);
        while (true) {
            final Object obj2 = this._state;
            if (obj2 instanceof Empty) {
                Empty empty = (Empty) obj2;
                Object obj3 = empty.locked;
                symbol = MutexKt.UNLOCKED;
                if (obj3 != symbol) {
                    _state$FU.compareAndSet(this, obj2, new LockedQueue(empty.locked));
                } else {
                    if (_state$FU.compareAndSet(this, obj2, obj == null ? MutexKt.EMPTY_LOCKED : new Empty(obj))) {
                        Unit unit = Unit.INSTANCE;
                        Result.Companion companion = Result.Companion;
                        orCreateCancellableContinuation.resumeWith(Result.m702constructorimpl(unit));
                        break;
                    }
                }
            } else if (obj2 instanceof LockedQueue) {
                LockedQueue lockedQueue = (LockedQueue) obj2;
                boolean z = false;
                if (lockedQueue.owner != obj) {
                    LockFreeLinkedListNode.CondAddOp condAddOp = new LockFreeLinkedListNode.CondAddOp(lockCont) { // from class: kotlinx.coroutines.sync.MutexImpl$lockSuspend$$inlined$suspendAtomicCancellableCoroutineReusable$lambda$1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // kotlinx.coroutines.internal.AtomicOp
                        public Object prepare(LockFreeLinkedListNode lockFreeLinkedListNode) {
                            if (this._state == obj2) {
                                return null;
                            }
                            return LockFreeLinkedListKt.getCONDITION_FALSE();
                        }
                    };
                    while (true) {
                        int tryCondAddNext = lockedQueue.getPrevNode().tryCondAddNext(lockCont, lockedQueue, condAddOp);
                        if (tryCondAddNext == 1) {
                            z = true;
                            break;
                        } else if (tryCondAddNext == 2) {
                            break;
                        }
                    }
                    if (z) {
                        CancellableContinuationKt.removeOnCancellation(orCreateCancellableContinuation, lockCont);
                        break;
                    }
                } else {
                    throw new IllegalStateException(("Already locked by " + obj).toString());
                }
            } else if (!(obj2 instanceof OpDescriptor)) {
                throw new IllegalStateException(("Illegal state " + obj2).toString());
            } else {
                ((OpDescriptor) obj2).perform(this);
            }
        }
        Object result = orCreateCancellableContinuation.getResult();
        if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    @Override // kotlinx.coroutines.selects.SelectClause2
    public <R> void registerSelectClause2(SelectInstance<? super R> selectInstance, Object obj, Function2<? super Mutex, ? super Continuation<? super R>, ? extends Object> function2) {
        Symbol symbol;
        Symbol symbol2;
        while (!selectInstance.isSelected()) {
            final Object obj2 = this._state;
            if (obj2 instanceof Empty) {
                Empty empty = (Empty) obj2;
                Object obj3 = empty.locked;
                symbol = MutexKt.UNLOCKED;
                if (obj3 != symbol) {
                    _state$FU.compareAndSet(this, obj2, new LockedQueue(empty.locked));
                } else {
                    Object performAtomicTrySelect = selectInstance.performAtomicTrySelect(new TryLockDesc(this, obj));
                    if (performAtomicTrySelect == null) {
                        UndispatchedKt.startCoroutineUnintercepted(function2, this, selectInstance.getCompletion());
                        return;
                    } else if (performAtomicTrySelect == SelectKt.getALREADY_SELECTED()) {
                        return;
                    } else {
                        symbol2 = MutexKt.LOCK_FAIL;
                        if (performAtomicTrySelect != symbol2 && performAtomicTrySelect != AtomicKt.RETRY_ATOMIC) {
                            throw new IllegalStateException(("performAtomicTrySelect(TryLockDesc) returned " + performAtomicTrySelect).toString());
                        }
                    }
                }
            } else if (obj2 instanceof LockedQueue) {
                LockedQueue lockedQueue = (LockedQueue) obj2;
                boolean z = false;
                if (lockedQueue.owner != obj) {
                    final LockSelect lockSelect = new LockSelect(obj, this, selectInstance, function2);
                    LockFreeLinkedListNode.CondAddOp condAddOp = new LockFreeLinkedListNode.CondAddOp(lockSelect) { // from class: kotlinx.coroutines.sync.MutexImpl$registerSelectClause2$$inlined$addLastIf$1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // kotlinx.coroutines.internal.AtomicOp
                        public Object prepare(LockFreeLinkedListNode lockFreeLinkedListNode) {
                            if (this._state == obj2) {
                                return null;
                            }
                            return LockFreeLinkedListKt.getCONDITION_FALSE();
                        }
                    };
                    while (true) {
                        int tryCondAddNext = lockedQueue.getPrevNode().tryCondAddNext(lockSelect, lockedQueue, condAddOp);
                        if (tryCondAddNext == 1) {
                            z = true;
                            break;
                        } else if (tryCondAddNext == 2) {
                            break;
                        }
                    }
                    if (z) {
                        selectInstance.disposeOnSelect(lockSelect);
                        return;
                    }
                } else {
                    throw new IllegalStateException(("Already locked by " + obj).toString());
                }
            } else if (!(obj2 instanceof OpDescriptor)) {
                throw new IllegalStateException(("Illegal state " + obj2).toString());
            } else {
                ((OpDescriptor) obj2).perform(this);
            }
        }
    }

    public String toString() {
        while (true) {
            Object obj = this._state;
            if (obj instanceof Empty) {
                return "Mutex[" + ((Empty) obj).locked + ']';
            } else if (!(obj instanceof OpDescriptor)) {
                if (!(obj instanceof LockedQueue)) {
                    throw new IllegalStateException(("Illegal state " + obj).toString());
                }
                return "Mutex[" + ((LockedQueue) obj).owner + ']';
            } else {
                ((OpDescriptor) obj).perform(this);
            }
        }
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public boolean tryLock(Object obj) {
        Symbol symbol;
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof Empty) {
                Object obj3 = ((Empty) obj2).locked;
                symbol = MutexKt.UNLOCKED;
                if (obj3 != symbol) {
                    return false;
                }
                if (_state$FU.compareAndSet(this, obj2, obj == null ? MutexKt.EMPTY_LOCKED : new Empty(obj))) {
                    return true;
                }
            } else if (obj2 instanceof LockedQueue) {
                if (((LockedQueue) obj2).owner != obj) {
                    return false;
                }
                throw new IllegalStateException(("Already locked by " + obj).toString());
            } else if (!(obj2 instanceof OpDescriptor)) {
                throw new IllegalStateException(("Illegal state " + obj2).toString());
            } else {
                ((OpDescriptor) obj2).perform(this);
            }
        }
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public void unlock(Object obj) {
        Empty empty;
        Symbol symbol;
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof Empty) {
                if (obj == null) {
                    Object obj3 = ((Empty) obj2).locked;
                    symbol = MutexKt.UNLOCKED;
                    if (!(obj3 != symbol)) {
                        throw new IllegalStateException("Mutex is not locked".toString());
                    }
                } else {
                    Empty empty2 = (Empty) obj2;
                    if (!(empty2.locked == obj)) {
                        throw new IllegalStateException(("Mutex is locked by " + empty2.locked + " but expected " + obj).toString());
                    }
                }
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$FU;
                empty = MutexKt.EMPTY_UNLOCKED;
                if (atomicReferenceFieldUpdater.compareAndSet(this, obj2, empty)) {
                    return;
                }
            } else if (obj2 instanceof OpDescriptor) {
                ((OpDescriptor) obj2).perform(this);
            } else if (obj2 instanceof LockedQueue) {
                if (obj != null) {
                    LockedQueue lockedQueue = (LockedQueue) obj2;
                    if (!(lockedQueue.owner == obj)) {
                        throw new IllegalStateException(("Mutex is locked by " + lockedQueue.owner + " but expected " + obj).toString());
                    }
                }
                LockedQueue lockedQueue2 = (LockedQueue) obj2;
                LockFreeLinkedListNode removeFirstOrNull = lockedQueue2.removeFirstOrNull();
                if (removeFirstOrNull == null) {
                    UnlockOp unlockOp = new UnlockOp(lockedQueue2);
                    if (_state$FU.compareAndSet(this, obj2, unlockOp) && unlockOp.perform(this) == null) {
                        return;
                    }
                } else {
                    LockWaiter lockWaiter = (LockWaiter) removeFirstOrNull;
                    Object tryResumeLockWaiter = lockWaiter.tryResumeLockWaiter();
                    if (tryResumeLockWaiter != null) {
                        Object obj4 = lockWaiter.owner;
                        if (obj4 == null) {
                            obj4 = MutexKt.LOCKED;
                        }
                        lockedQueue2.owner = obj4;
                        lockWaiter.completeResumeLockWaiter(tryResumeLockWaiter);
                        return;
                    }
                }
            } else {
                throw new IllegalStateException(("Illegal state " + obj2).toString());
            }
        }
    }
}
