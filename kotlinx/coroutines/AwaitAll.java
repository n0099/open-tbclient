package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.searchbox.net.listener.DiaoqiJsonListener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u000e:\u0002\u000b\fB\u001d\u0012\u0014\u0010\u0004\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0086@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tR\"\u0010\u0004\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/AwaitAll;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlinx/coroutines/Deferred;", "deferreds", "<init>", "([Lkotlinx/coroutines/Deferred;)V", "", "await", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "[Lkotlinx/coroutines/Deferred;", "AwaitAllNode", "DisposeHandlersOnCancel", "kotlinx-coroutines-core", ""}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AwaitAll<T> {
    public static final /* synthetic */ AtomicIntegerFieldUpdater notCompletedCount$FU = AtomicIntegerFieldUpdater.newUpdater(AwaitAll.class, "notCompletedCount");
    public final Deferred<T>[] deferreds;
    public volatile /* synthetic */ int notCompletedCount;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\b\u0082\u0004\u0018\u00002\u00020\u001cB\u001b\u0012\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0096\u0002¢\u0006\u0004\b\t\u0010\nR \u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000bR<\u0010\u0013\u001a\u000e\u0018\u00010\fR\b\u0012\u0004\u0012\u00028\u00000\r2\u0012\u0010\u000e\u001a\u000e\u0018\u00010\fR\b\u0012\u0004\u0012\u00028\u00000\r8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0015\u001a\u00020\u00148\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lkotlinx/coroutines/AwaitAll$AwaitAllNode;", "Lkotlinx/coroutines/CancellableContinuation;", "", "continuation", "<init>", "(Lkotlinx/coroutines/AwaitAll;Lkotlinx/coroutines/CancellableContinuation;)V", "", "cause", "", DiaoqiJsonListener.SCHEME_FORBID_WHITE_LIST, "(Ljava/lang/Throwable;)V", "Lkotlinx/coroutines/CancellableContinuation;", "Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;", "Lkotlinx/coroutines/AwaitAll;", "value", "getDisposer", "()Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;", "setDisposer", "(Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;)V", "disposer", "Lkotlinx/coroutines/DisposableHandle;", "handle", "Lkotlinx/coroutines/DisposableHandle;", "getHandle", "()Lkotlinx/coroutines/DisposableHandle;", "setHandle", "(Lkotlinx/coroutines/DisposableHandle;)V", "kotlinx-coroutines-core", "Lkotlinx/coroutines/JobNode;"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public final class AwaitAllNode extends JobNode {
        public volatile /* synthetic */ Object _disposer = null;
        public final CancellableContinuation<List<? extends T>> continuation;
        public DisposableHandle handle;

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlinx.coroutines.CancellableContinuation<? super java.util.List<? extends T>> */
        /* JADX WARN: Multi-variable type inference failed */
        public AwaitAllNode(CancellableContinuation<? super List<? extends T>> cancellableContinuation) {
            this.continuation = cancellableContinuation;
        }

        public final AwaitAll<T>.DisposeHandlersOnCancel getDisposer() {
            return (DisposeHandlersOnCancel) this._disposer;
        }

        public final DisposableHandle getHandle() {
            DisposableHandle disposableHandle = this.handle;
            if (disposableHandle != null) {
                return disposableHandle;
            }
            Intrinsics.throwUninitializedPropertyAccessException("handle");
            return null;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.INSTANCE;
        }

        public final void setDisposer(AwaitAll<T>.DisposeHandlersOnCancel disposeHandlersOnCancel) {
            this._disposer = disposeHandlersOnCancel;
        }

        public final void setHandle(DisposableHandle disposableHandle) {
            this.handle = disposableHandle;
        }

        @Override // kotlinx.coroutines.CompletionHandlerBase
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public void invoke2(Throwable th) {
            if (th != null) {
                Object tryResumeWithException = this.continuation.tryResumeWithException(th);
                if (tryResumeWithException != null) {
                    this.continuation.completeResume(tryResumeWithException);
                    AwaitAll<T>.DisposeHandlersOnCancel disposer = getDisposer();
                    if (disposer != null) {
                        disposer.disposeAll();
                        return;
                    }
                    return;
                }
                return;
            }
            if (AwaitAll.notCompletedCount$FU.decrementAndGet(AwaitAll.this) == 0) {
                CancellableContinuation<List<? extends T>> cancellableContinuation = this.continuation;
                Result.Companion companion = Result.Companion;
                Deferred[] deferredArr = AwaitAll.this.deferreds;
                ArrayList arrayList = new ArrayList(deferredArr.length);
                int i = 0;
                int length = deferredArr.length;
                while (i < length) {
                    Deferred deferred = deferredArr[i];
                    i++;
                    arrayList.add(deferred.getCompleted());
                }
                cancellableContinuation.resumeWith(Result.m850constructorimpl(arrayList));
            }
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u000e\u0012\f0\u0004R\b\u0012\u0004\u0012\u00028\u00000\u00050\u0003¢\u0006\u0002\u0010\u0006J\u0006\u0010\b\u001a\u00020\tJ\u0013\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0096\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016R \u0010\u0002\u001a\u0012\u0012\u000e\u0012\f0\u0004R\b\u0012\u0004\u0012\u00028\u00000\u00050\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u000f"}, d2 = {"Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;", "Lkotlinx/coroutines/CancelHandler;", "nodes", "", "Lkotlinx/coroutines/AwaitAll$AwaitAllNode;", "Lkotlinx/coroutines/AwaitAll;", "(Lkotlinx/coroutines/AwaitAll;[Lkotlinx/coroutines/AwaitAll$AwaitAllNode;)V", "[Lkotlinx/coroutines/AwaitAll$AwaitAllNode;", "disposeAll", "", DiaoqiJsonListener.SCHEME_FORBID_WHITE_LIST, "cause", "", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public final class DisposeHandlersOnCancel extends CancelHandler {
        public final AwaitAll<T>.AwaitAllNode[] nodes;

        public DisposeHandlersOnCancel(AwaitAll<T>.AwaitAllNode[] awaitAllNodeArr) {
            this.nodes = awaitAllNodeArr;
        }

        public final void disposeAll() {
            AwaitAll<T>.AwaitAllNode[] awaitAllNodeArr = this.nodes;
            int length = awaitAllNodeArr.length;
            int i = 0;
            while (i < length) {
                AwaitAll<T>.AwaitAllNode awaitAllNode = awaitAllNodeArr[i];
                i++;
                awaitAllNode.getHandle().dispose();
            }
        }

        public String toString() {
            return "DisposeHandlersOnCancel[" + this.nodes + ']';
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.INSTANCE;
        }

        @Override // kotlinx.coroutines.CancelHandlerBase
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public void invoke2(Throwable th) {
            disposeAll();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlinx.coroutines.Deferred<? extends T>[] */
    /* JADX WARN: Multi-variable type inference failed */
    public AwaitAll(Deferred<? extends T>[] deferredArr) {
        this.deferreds = deferredArr;
        this.notCompletedCount = deferredArr.length;
    }

    public final Object await(Continuation<? super List<? extends T>> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        int length = this.deferreds.length;
        AwaitAllNode[] awaitAllNodeArr = new AwaitAllNode[length];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            Deferred deferred = this.deferreds[i2];
            deferred.start();
            AwaitAllNode awaitAllNode = new AwaitAllNode(cancellableContinuationImpl);
            awaitAllNode.setHandle(deferred.invokeOnCompletion(awaitAllNode));
            Unit unit = Unit.INSTANCE;
            awaitAllNodeArr[i2] = awaitAllNode;
        }
        AwaitAll<T>.DisposeHandlersOnCancel disposeHandlersOnCancel = new DisposeHandlersOnCancel(awaitAllNodeArr);
        while (i < length) {
            AwaitAllNode awaitAllNode2 = awaitAllNodeArr[i];
            i++;
            awaitAllNode2.setDisposer(disposeHandlersOnCancel);
        }
        if (cancellableContinuationImpl.isCompleted()) {
            disposeHandlersOnCancel.disposeAll();
        } else {
            cancellableContinuationImpl.invokeOnCancellation(disposeHandlersOnCancel);
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
