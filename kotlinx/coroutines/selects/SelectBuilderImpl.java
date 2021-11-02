package kotlinx.coroutines.selects;

import com.baidu.mobads.container.util.XAdRemoteEvent;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteHelper;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.CompletedExceptionallyKt;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobCancellingNode;
import kotlinx.coroutines.internal.AtomicDesc;
import kotlinx.coroutines.internal.AtomicKt;
import kotlinx.coroutines.internal.AtomicOp;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.OpDescriptor;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import kotlinx.coroutines.selects.SelectBuilder;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0001\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u0004WXYZB\u0015\u0012\f\u0010S\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\bU\u0010VJ\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ.\u0010\u0012\u001a\u00020\t2\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u000eH\u0082\b¢\u0006\u0004\b\u0012\u0010\u0013J\u0011\u0010\u0014\u001a\u0004\u0018\u00010\u000fH\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\n\u0018\u00010\u0016j\u0004\u0018\u0001`\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001aH\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001e\u0010\rJ8\u0010\"\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u001f2\u001c\u0010\u0011\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000f0!H\u0016ø\u0001\u0000¢\u0006\u0004\b\"\u0010#J\u0019\u0010&\u001a\u0004\u0018\u00010\u000f2\u0006\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b&\u0010'J\u0017\u0010)\u001a\u00020\t2\u0006\u0010(\u001a\u00020\u001aH\u0016¢\u0006\u0004\b)\u0010\u001dJ \u0010,\u001a\u00020\t2\f\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000*H\u0016ø\u0001\u0000¢\u0006\u0004\b,\u0010-J\u000f\u0010/\u001a\u00020.H\u0016¢\u0006\u0004\b/\u00100J\u000f\u00102\u001a\u000201H\u0016¢\u0006\u0004\b2\u00103J\u001b\u00106\u001a\u0004\u0018\u00010\u000f2\b\u00105\u001a\u0004\u0018\u000104H\u0016¢\u0006\u0004\b6\u00107J5\u00109\u001a\u00020\t*\u0002082\u001c\u0010\u0011\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000f0!H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b9\u0010:JG\u00109\u001a\u00020\t\"\u0004\b\u0001\u0010;*\b\u0012\u0004\u0012\u00028\u00010<2\"\u0010\u0011\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000f0=H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b9\u0010>J[\u00109\u001a\u00020\t\"\u0004\b\u0001\u0010?\"\u0004\b\u0002\u0010;*\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020@2\u0006\u0010A\u001a\u00028\u00012\"\u0010\u0011\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000f0=H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b9\u0010BR\u001e\u0010F\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`C8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\bD\u0010ER\u001c\u0010I\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\bG\u0010HR\u0016\u0010M\u001a\u00020J8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\bK\u0010LR\u0016\u0010N\u001a\u0002018V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\bN\u00103R(\u0010R\u001a\u0004\u0018\u00010\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u00078B@BX\u0082\u000e¢\u0006\f\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010\u000bR\u001c\u0010S\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bS\u0010T\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006["}, d2 = {"Lkotlinx/coroutines/selects/SelectBuilderImpl;", "R", "Lkotlinx/coroutines/selects/SelectBuilder;", "Lkotlinx/coroutines/selects/SelectInstance;", "Lkotlin/coroutines/Continuation;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "Lkotlinx/coroutines/DisposableHandle;", "handle", "", "disposeOnSelect", "(Lkotlinx/coroutines/DisposableHandle;)V", "doAfterSelect", "()V", "Lkotlin/Function0;", "", "value", BreakpointSQLiteHelper.BLOCK_TABLE_NAME, "doResume", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "getResult", "()Ljava/lang/Object;", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "", "e", "handleBuilderException", "(Ljava/lang/Throwable;)V", "initCancellability", "", "timeMillis", "Lkotlin/Function1;", "onTimeout", "(JLkotlin/jvm/functions/Function1;)V", "Lkotlinx/coroutines/internal/AtomicDesc;", "desc", "performAtomicTrySelect", "(Lkotlinx/coroutines/internal/AtomicDesc;)Ljava/lang/Object;", "exception", "resumeSelectWithException", "Lkotlin/Result;", "result", "resumeWith", "(Ljava/lang/Object;)V", "", "toString", "()Ljava/lang/String;", "", "trySelect", "()Z", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "otherOp", "trySelectOther", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)Ljava/lang/Object;", "Lkotlinx/coroutines/selects/SelectClause0;", "invoke", "(Lkotlinx/coroutines/selects/SelectClause0;Lkotlin/jvm/functions/Function1;)V", "Q", "Lkotlinx/coroutines/selects/SelectClause1;", "Lkotlin/Function2;", "(Lkotlinx/coroutines/selects/SelectClause1;Lkotlin/jvm/functions/Function2;)V", "P", "Lkotlinx/coroutines/selects/SelectClause2;", "param", "(Lkotlinx/coroutines/selects/SelectClause2;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "callerFrame", "getCompletion", "()Lkotlin/coroutines/Continuation;", "completion", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "context", "isSelected", "getParentHandle", "()Lkotlinx/coroutines/DisposableHandle;", "setParentHandle", "parentHandle", "uCont", "Lkotlin/coroutines/Continuation;", "<init>", "(Lkotlin/coroutines/Continuation;)V", "AtomicSelectOp", "DisposeNode", "PairSelectOp", "SelectOnCancelling", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@PublishedApi
/* loaded from: classes3.dex */
public final class SelectBuilderImpl<R> extends LockFreeLinkedListHead implements SelectBuilder<R>, SelectInstance<R>, Continuation<R>, CoroutineStackFrame {
    public final Continuation<R> uCont;
    public static final AtomicReferenceFieldUpdater _state$FU = AtomicReferenceFieldUpdater.newUpdater(SelectBuilderImpl.class, Object.class, "_state");
    public static final AtomicReferenceFieldUpdater _result$FU = AtomicReferenceFieldUpdater.newUpdater(SelectBuilderImpl.class, Object.class, "_result");
    public volatile Object _state = this;
    public volatile Object _result = SelectKt.access$getUNDECIDED$p();
    public volatile Object _parentHandle = null;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u001e\u0010\u001fJ#\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\b\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00138\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u00168\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001a\u001a\u00020\u00198\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lkotlinx/coroutines/selects/SelectBuilderImpl$AtomicSelectOp;", "Lkotlinx/coroutines/internal/AtomicOp;", "", "affected", SmsLoginView.f.l, "", XAdRemoteEvent.COMPLETE, "(Ljava/lang/Object;Ljava/lang/Object;)V", "completeSelect", "(Ljava/lang/Object;)V", "prepare", "(Ljava/lang/Object;)Ljava/lang/Object;", "prepareSelectOp", "()Ljava/lang/Object;", "", "toString", "()Ljava/lang/String;", "undoPrepare", "()V", "Lkotlinx/coroutines/internal/AtomicDesc;", "desc", "Lkotlinx/coroutines/internal/AtomicDesc;", "Lkotlinx/coroutines/selects/SelectBuilderImpl;", "impl", "Lkotlinx/coroutines/selects/SelectBuilderImpl;", "", "opSequence", "J", "getOpSequence", "()J", "<init>", "(Lkotlinx/coroutines/selects/SelectBuilderImpl;Lkotlinx/coroutines/internal/AtomicDesc;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes3.dex */
    public static final class AtomicSelectOp extends AtomicOp<Object> {
        @JvmField
        public final AtomicDesc desc;
        @JvmField
        public final SelectBuilderImpl<?> impl;
        public final long opSequence = SelectKt.access$getSelectOpSequenceNumber$p().next();

        public AtomicSelectOp(SelectBuilderImpl<?> selectBuilderImpl, AtomicDesc atomicDesc) {
            this.impl = selectBuilderImpl;
            this.desc = atomicDesc;
            this.desc.setAtomicOp(this);
        }

        private final void completeSelect(Object obj) {
            boolean z = obj == null;
            if (SelectBuilderImpl._state$FU.compareAndSet(this.impl, this, z ? null : this.impl) && z) {
                this.impl.doAfterSelect();
            }
        }

        private final Object prepareSelectOp() {
            SelectBuilderImpl<?> selectBuilderImpl = this.impl;
            while (true) {
                Object obj = selectBuilderImpl._state;
                if (obj == this) {
                    return null;
                }
                if (obj instanceof OpDescriptor) {
                    ((OpDescriptor) obj).perform(this.impl);
                } else {
                    SelectBuilderImpl<?> selectBuilderImpl2 = this.impl;
                    if (obj == selectBuilderImpl2) {
                        if (SelectBuilderImpl._state$FU.compareAndSet(selectBuilderImpl2, selectBuilderImpl2, this)) {
                            return null;
                        }
                    } else {
                        return SelectKt.getALREADY_SELECTED();
                    }
                }
            }
        }

        private final void undoPrepare() {
            SelectBuilderImpl<?> selectBuilderImpl = this.impl;
            SelectBuilderImpl._state$FU.compareAndSet(selectBuilderImpl, this, selectBuilderImpl);
        }

        @Override // kotlinx.coroutines.internal.AtomicOp
        public void complete(Object obj, Object obj2) {
            completeSelect(obj2);
            this.desc.complete(this, obj2);
        }

        @Override // kotlinx.coroutines.internal.AtomicOp
        public long getOpSequence() {
            return this.opSequence;
        }

        @Override // kotlinx.coroutines.internal.AtomicOp
        public Object prepare(Object obj) {
            Object prepareSelectOp;
            if (obj != null || (prepareSelectOp = prepareSelectOp()) == null) {
                try {
                    return this.desc.prepare(this);
                } catch (Throwable th) {
                    if (obj == null) {
                        undoPrepare();
                    }
                    throw th;
                }
            }
            return prepareSelectOp;
        }

        @Override // kotlinx.coroutines.internal.OpDescriptor
        public String toString() {
            return "AtomicSelectOp(sequence=" + getOpSequence() + ')';
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lkotlinx/coroutines/selects/SelectBuilderImpl$DisposeNode;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/DisposableHandle;", "handle", "Lkotlinx/coroutines/DisposableHandle;", "<init>", "(Lkotlinx/coroutines/DisposableHandle;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes3.dex */
    public static final class DisposeNode extends LockFreeLinkedListNode {
        @JvmField
        public final DisposableHandle handle;

        public DisposeNode(DisposableHandle disposableHandle) {
            this.handle = disposableHandle;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u001c\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00068V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u00020\n8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lkotlinx/coroutines/selects/SelectBuilderImpl$PairSelectOp;", "Lkotlinx/coroutines/internal/OpDescriptor;", "", "affected", "perform", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/AtomicOp;", "getAtomicOp", "()Lkotlinx/coroutines/internal/AtomicOp;", "atomicOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "otherOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "<init>", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes3.dex */
    public static final class PairSelectOp extends OpDescriptor {
        @JvmField
        public final LockFreeLinkedListNode.PrepareOp otherOp;

        public PairSelectOp(LockFreeLinkedListNode.PrepareOp prepareOp) {
            this.otherOp = prepareOp;
        }

        @Override // kotlinx.coroutines.internal.OpDescriptor
        public AtomicOp<?> getAtomicOp() {
            return this.otherOp.getAtomicOp();
        }

        @Override // kotlinx.coroutines.internal.OpDescriptor
        public Object perform(Object obj) {
            if (obj != null) {
                SelectBuilderImpl selectBuilderImpl = (SelectBuilderImpl) obj;
                this.otherOp.finishPrepare();
                Object decide = this.otherOp.getAtomicOp().decide(null);
                SelectBuilderImpl._state$FU.compareAndSet(selectBuilderImpl, this, decide == null ? this.otherOp.desc : selectBuilderImpl);
                return decide;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.selects.SelectBuilderImpl<*>");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/selects/SelectBuilderImpl$SelectOnCancelling;", "Lkotlinx/coroutines/JobCancellingNode;", "", "cause", "", "invoke", "(Ljava/lang/Throwable;)V", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/Job;", "job", "<init>", "(Lkotlinx/coroutines/selects/SelectBuilderImpl;Lkotlinx/coroutines/Job;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes3.dex */
    public final class SelectOnCancelling extends JobCancellingNode<Job> {
        public SelectOnCancelling(Job job) {
            super(job);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.INSTANCE;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        public String toString() {
            return "SelectOnCancelling[" + SelectBuilderImpl.this + ']';
        }

        @Override // kotlinx.coroutines.CompletionHandlerBase
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public void invoke2(Throwable th) {
            if (SelectBuilderImpl.this.trySelect()) {
                SelectBuilderImpl.this.resumeSelectWithException(this.job.getCancellationException());
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.coroutines.Continuation<? super R> */
    /* JADX WARN: Multi-variable type inference failed */
    public SelectBuilderImpl(Continuation<? super R> continuation) {
        this.uCont = continuation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doAfterSelect() {
        DisposableHandle parentHandle = getParentHandle();
        if (parentHandle != null) {
            parentHandle.dispose();
        }
        Object next = getNext();
        if (next != null) {
            for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) next; !Intrinsics.areEqual(lockFreeLinkedListNode, this); lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode()) {
                if (lockFreeLinkedListNode instanceof DisposeNode) {
                    ((DisposeNode) lockFreeLinkedListNode).handle.dispose();
                }
            }
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    }

    private final void doResume(Function0<? extends Object> function0, Function0<Unit> function02) {
        if (DebugKt.getASSERTIONS_ENABLED() && !isSelected()) {
            throw new AssertionError();
        }
        while (true) {
            Object obj = this._result;
            if (obj == SelectKt.access$getUNDECIDED$p()) {
                if (_result$FU.compareAndSet(this, SelectKt.access$getUNDECIDED$p(), function0.invoke())) {
                    return;
                }
            } else if (obj != IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                throw new IllegalStateException("Already resumed");
            } else {
                if (_result$FU.compareAndSet(this, IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED(), SelectKt.access$getRESUMED$p())) {
                    function02.invoke();
                    return;
                }
            }
        }
    }

    private final DisposableHandle getParentHandle() {
        return (DisposableHandle) this._parentHandle;
    }

    private final void initCancellability() {
        Job job = (Job) getContext().get(Job.Key);
        if (job != null) {
            DisposableHandle invokeOnCompletion$default = Job.DefaultImpls.invokeOnCompletion$default(job, true, false, new SelectOnCancelling(job), 2, null);
            setParentHandle(invokeOnCompletion$default);
            if (isSelected()) {
                invokeOnCompletion$default.dispose();
            }
        }
    }

    private final void setParentHandle(DisposableHandle disposableHandle) {
        this._parentHandle = disposableHandle;
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public void disposeOnSelect(DisposableHandle disposableHandle) {
        DisposeNode disposeNode = new DisposeNode(disposableHandle);
        if (!isSelected()) {
            addLast(disposeNode);
            if (!isSelected()) {
                return;
            }
        }
        disposableHandle.dispose();
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public CoroutineStackFrame getCallerFrame() {
        Continuation<R> continuation = this.uCont;
        if (!(continuation instanceof CoroutineStackFrame)) {
            continuation = null;
        }
        return (CoroutineStackFrame) continuation;
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public Continuation<R> getCompletion() {
        return this;
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return this.uCont.getContext();
    }

    @PublishedApi
    public final Object getResult() {
        if (!isSelected()) {
            initCancellability();
        }
        Object obj = this._result;
        if (obj == SelectKt.access$getUNDECIDED$p()) {
            if (_result$FU.compareAndSet(this, SelectKt.access$getUNDECIDED$p(), IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED())) {
                return IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            }
            obj = this._result;
        }
        if (obj != SelectKt.access$getRESUMED$p()) {
            if (obj instanceof CompletedExceptionally) {
                throw ((CompletedExceptionally) obj).cause;
            }
            return obj;
        }
        throw new IllegalStateException("Already resumed");
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @PublishedApi
    public final void handleBuilderException(Throwable th) {
        if (trySelect()) {
            Result.Companion companion = Result.Companion;
            resumeWith(Result.m652constructorimpl(ResultKt.createFailure(th)));
        } else if (th instanceof CancellationException) {
        } else {
            Object result = getResult();
            if (result instanceof CompletedExceptionally) {
                Throwable th2 = ((CompletedExceptionally) result).cause;
                if (DebugKt.getRECOVER_STACK_TRACES()) {
                    th2 = StackTraceRecoveryKt.unwrapImpl(th2);
                }
                if (th2 == (!DebugKt.getRECOVER_STACK_TRACES() ? th : StackTraceRecoveryKt.unwrapImpl(th))) {
                    return;
                }
            }
            CoroutineExceptionHandlerKt.handleCoroutineException(getContext(), th);
        }
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public <P, Q> void invoke(SelectClause2<? super P, ? extends Q> selectClause2, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2) {
        SelectBuilder.DefaultImpls.invoke(this, selectClause2, function2);
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public boolean isSelected() {
        while (true) {
            Object obj = this._state;
            if (obj == this) {
                return false;
            }
            if (!(obj instanceof OpDescriptor)) {
                return true;
            }
            ((OpDescriptor) obj).perform(this);
        }
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public void onTimeout(long j, final Function1<? super Continuation<? super R>, ? extends Object> function1) {
        if (j <= 0) {
            if (trySelect()) {
                UndispatchedKt.startCoroutineUnintercepted(function1, getCompletion());
                return;
            }
            return;
        }
        disposeOnSelect(DelayKt.getDelay(getContext()).invokeOnTimeout(j, new Runnable() { // from class: kotlinx.coroutines.selects.SelectBuilderImpl$onTimeout$$inlined$Runnable$1
            @Override // java.lang.Runnable
            public final void run() {
                if (SelectBuilderImpl.this.trySelect()) {
                    CancellableKt.startCoroutineCancellable(function1, SelectBuilderImpl.this.getCompletion());
                }
            }
        }));
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public Object performAtomicTrySelect(AtomicDesc atomicDesc) {
        return new AtomicSelectOp(this, atomicDesc).perform(null);
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public void resumeSelectWithException(Throwable th) {
        if (DebugKt.getASSERTIONS_ENABLED() && !isSelected()) {
            throw new AssertionError();
        }
        while (true) {
            Object obj = this._result;
            if (obj == SelectKt.access$getUNDECIDED$p()) {
                Continuation<R> continuation = this.uCont;
                if (_result$FU.compareAndSet(this, SelectKt.access$getUNDECIDED$p(), new CompletedExceptionally((DebugKt.getRECOVER_STACK_TRACES() && (continuation instanceof CoroutineStackFrame)) ? StackTraceRecoveryKt.access$recoverFromStackFrame(th, (CoroutineStackFrame) continuation) : th, false, 2, null))) {
                    return;
                }
            } else if (obj != IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                throw new IllegalStateException("Already resumed");
            } else {
                if (_result$FU.compareAndSet(this, IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED(), SelectKt.access$getRESUMED$p())) {
                    Continuation intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(this.uCont);
                    Result.Companion companion = Result.Companion;
                    intercepted.resumeWith(Result.m652constructorimpl(ResultKt.createFailure(th)));
                    return;
                }
            }
        }
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) {
        if (DebugKt.getASSERTIONS_ENABLED() && !isSelected()) {
            throw new AssertionError();
        }
        while (true) {
            Object obj2 = this._result;
            if (obj2 == SelectKt.access$getUNDECIDED$p()) {
                if (_result$FU.compareAndSet(this, SelectKt.access$getUNDECIDED$p(), CompletedExceptionallyKt.toState(obj))) {
                    return;
                }
            } else if (obj2 != IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                throw new IllegalStateException("Already resumed");
            } else {
                if (_result$FU.compareAndSet(this, IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED(), SelectKt.access$getRESUMED$p())) {
                    if (Result.m658isFailureimpl(obj)) {
                        Continuation<R> continuation = this.uCont;
                        Throwable m655exceptionOrNullimpl = Result.m655exceptionOrNullimpl(obj);
                        if (m655exceptionOrNullimpl == null) {
                            Intrinsics.throwNpe();
                        }
                        Result.Companion companion = Result.Companion;
                        if (DebugKt.getRECOVER_STACK_TRACES() && (continuation instanceof CoroutineStackFrame)) {
                            m655exceptionOrNullimpl = StackTraceRecoveryKt.access$recoverFromStackFrame(m655exceptionOrNullimpl, (CoroutineStackFrame) continuation);
                        }
                        continuation.resumeWith(Result.m652constructorimpl(ResultKt.createFailure(m655exceptionOrNullimpl)));
                        return;
                    }
                    this.uCont.resumeWith(obj);
                    return;
                }
            }
        }
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public String toString() {
        Object obj = this._state;
        StringBuilder sb = new StringBuilder();
        sb.append("SelectInstance(state=");
        sb.append(obj == this ? "this" : String.valueOf(obj));
        sb.append(", result=");
        sb.append(this._result);
        sb.append(')');
        return sb.toString();
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public boolean trySelect() {
        Object trySelectOther = trySelectOther(null);
        if (trySelectOther == CancellableContinuationImplKt.RESUME_TOKEN) {
            return true;
        }
        if (trySelectOther == null) {
            return false;
        }
        throw new IllegalStateException(("Unexpected trySelectIdempotent result " + trySelectOther).toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0025, code lost:
        doAfterSelect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002a, code lost:
        return kotlinx.coroutines.CancellableContinuationImplKt.RESUME_TOKEN;
     */
    @Override // kotlinx.coroutines.selects.SelectInstance
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object trySelectOther(LockFreeLinkedListNode.PrepareOp prepareOp) {
        while (true) {
            Object obj = this._state;
            if (obj == this) {
                if (prepareOp == null) {
                    if (_state$FU.compareAndSet(this, this, null)) {
                        break;
                    }
                } else {
                    PairSelectOp pairSelectOp = new PairSelectOp(prepareOp);
                    if (_state$FU.compareAndSet(this, this, pairSelectOp)) {
                        Object perform = pairSelectOp.perform(this);
                        if (perform != null) {
                            return perform;
                        }
                    }
                }
            } else if (obj instanceof OpDescriptor) {
                if (prepareOp != null) {
                    AtomicOp<?> atomicOp = prepareOp.getAtomicOp();
                    if ((atomicOp instanceof AtomicSelectOp) && ((AtomicSelectOp) atomicOp).impl == this) {
                        throw new IllegalStateException("Cannot use matching select clauses on the same object".toString());
                    }
                    if (atomicOp.isEarlierThan((OpDescriptor) obj)) {
                        return AtomicKt.RETRY_ATOMIC;
                    }
                }
                ((OpDescriptor) obj).perform(this);
            } else if (prepareOp != null && obj == prepareOp.desc) {
                return CancellableContinuationImplKt.RESUME_TOKEN;
            } else {
                return null;
            }
        }
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public void invoke(SelectClause0 selectClause0, Function1<? super Continuation<? super R>, ? extends Object> function1) {
        selectClause0.registerSelectClause0(this, function1);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.functions.Function2<? super Q, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.selects.SelectBuilder
    public <Q> void invoke(SelectClause1<? extends Q> selectClause1, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2) {
        selectClause1.registerSelectClause1(this, function2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: P */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function2<? super Q, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.selects.SelectBuilder
    public <P, Q> void invoke(SelectClause2<? super P, ? extends Q> selectClause2, P p, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2) {
        selectClause2.registerSelectClause2(this, p, function2);
    }
}
