package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowKt;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import kotlinx.coroutines.internal.Symbol;
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00042\b\u0012\u0004\u0012\u0002H\u00010\u00052\b\u0012\u0004\u0012\u0002H\u00010\u0006:\u0001hB\u001d\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0019\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0003H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010.J\u0010\u0010/\u001a\u00020,2\u0006\u00100\u001a\u000201H\u0002J\b\u00102\u001a\u00020,H\u0002J\u001f\u00103\u001a\u0002042\f\u00105\u001a\b\u0012\u0004\u0012\u00028\u000006H\u0096@ø\u0001\u0000¢\u0006\u0002\u00107J\u0010\u00108\u001a\u00020,2\u0006\u00109\u001a\u00020\u0012H\u0002J\b\u0010:\u001a\u00020\u0003H\u0014J\u001d\u0010;\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000e2\u0006\u0010<\u001a\u00020\bH\u0014¢\u0006\u0002\u0010=J\b\u0010>\u001a\u00020,H\u0002J\u0019\u0010?\u001a\u00020,2\u0006\u0010@\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010AJ\u0019\u0010B\u001a\u00020,2\u0006\u0010@\u001a\u00028\u0000H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010AJ\u0012\u0010C\u001a\u00020,2\b\u0010D\u001a\u0004\u0018\u00010\u000fH\u0002J1\u0010E\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020,\u0018\u00010F0\u000e2\u0014\u0010G\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020,\u0018\u00010F0\u000eH\u0002¢\u0006\u0002\u0010HJ&\u0010I\u001a\b\u0012\u0004\u0012\u00028\u00000J2\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010N\u001a\u0004\u0018\u00010\u000f2\u0006\u0010O\u001a\u00020\u0012H\u0002J7\u0010P\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e2\u0010\u0010Q\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000e2\u0006\u0010R\u001a\u00020\b2\u0006\u0010S\u001a\u00020\bH\u0002¢\u0006\u0002\u0010TJ\b\u0010U\u001a\u00020,H\u0016J\u0015\u0010V\u001a\u00020W2\u0006\u0010@\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010XJ\u0015\u0010Y\u001a\u00020W2\u0006\u0010@\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010XJ\u0015\u0010Z\u001a\u00020W2\u0006\u0010@\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010XJ\u0010\u0010[\u001a\u00020\u00122\u0006\u0010-\u001a\u00020\u0003H\u0002J\u0012\u0010\\\u001a\u0004\u0018\u00010\u000f2\u0006\u0010-\u001a\u00020\u0003H\u0002J(\u0010]\u001a\u00020,2\u0006\u0010^\u001a\u00020\u00122\u0006\u0010_\u001a\u00020\u00122\u0006\u0010`\u001a\u00020\u00122\u0006\u0010a\u001a\u00020\u0012H\u0002J%\u0010b\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020,\u0018\u00010F0\u000e2\u0006\u0010c\u001a\u00020\u0012H\u0000¢\u0006\u0004\bd\u0010eJ\r\u0010f\u001a\u00020\u0012H\u0000¢\u0006\u0002\bgR\u001a\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0014R\u001a\u0010\u0018\u001a\u00028\u00008DX\u0084\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0014R\u000e\u0010 \u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b*\u0010(\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006i"}, d2 = {"Lkotlinx/coroutines/flow/SharedFlowImpl;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/internal/AbstractSharedFlow;", "Lkotlinx/coroutines/flow/SharedFlowSlot;", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lkotlinx/coroutines/flow/CancellableFlow;", "Lkotlinx/coroutines/flow/internal/FusibleFlow;", "replay", "", "bufferCapacity", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "(IILkotlinx/coroutines/channels/BufferOverflow;)V", "buffer", "", "", "[Ljava/lang/Object;", "bufferEndIndex", "", "getBufferEndIndex", "()J", "bufferSize", "head", "getHead", "lastReplayedLocked", "getLastReplayedLocked$annotations", "()V", "getLastReplayedLocked", "()Ljava/lang/Object;", "minCollectorIndex", "queueEndIndex", "getQueueEndIndex", "queueSize", "replayCache", "", "getReplayCache", "()Ljava/util/List;", "replayIndex", "replaySize", "getReplaySize", "()I", CommonTbJsBridge.FILE_DOWNLOAD_TOTAL_SIZE, "getTotalSize", "awaitValue", "", "slot", "(Lkotlinx/coroutines/flow/SharedFlowSlot;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelEmitter", "emitter", "Lkotlinx/coroutines/flow/SharedFlowImpl$Emitter;", "cleanupTailLocked", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "correctCollectorIndexesOnDropOldest", "newHead", "createSlot", "createSlotArray", "size", "(I)[Lkotlinx/coroutines/flow/SharedFlowSlot;", "dropOldestLocked", "emit", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitSuspend", "enqueueLocked", "item", "findSlotsToResumeLocked", "Lkotlin/coroutines/Continuation;", "resumesIn", "([Lkotlin/coroutines/Continuation;)[Lkotlin/coroutines/Continuation;", "fuse", "Lkotlinx/coroutines/flow/Flow;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "getPeekedValueLockedAt", "index", "growBuffer", "curBuffer", "curSize", "newSize", "([Ljava/lang/Object;II)[Ljava/lang/Object;", "resetReplayCache", "tryEmit", "", "(Ljava/lang/Object;)Z", "tryEmitLocked", "tryEmitNoCollectorsLocked", "tryPeekLocked", "tryTakeValue", "updateBufferLocked", "newReplayIndex", "newMinCollectorIndex", "newBufferEndIndex", "newQueueEndIndex", "updateCollectorIndexLocked", "oldIndex", "updateCollectorIndexLocked$kotlinx_coroutines_core", "(J)[Lkotlin/coroutines/Continuation;", "updateNewCollectorIndexLocked", "updateNewCollectorIndexLocked$kotlinx_coroutines_core", "Emitter", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public class SharedFlowImpl<T> extends AbstractSharedFlow<SharedFlowSlot> implements MutableSharedFlow<T>, CancellableFlow<T>, FusibleFlow<T> {
    public Object[] buffer;
    public final int bufferCapacity;
    public int bufferSize;
    public long minCollectorIndex;
    public final BufferOverflow onBufferOverflow;
    public int queueSize;
    public final int replay;
    public long replayIndex;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BufferOverflow.values().length];
            iArr[BufferOverflow.SUSPEND.ordinal()] = 1;
            iArr[BufferOverflow.DROP_LATEST.ordinal()] = 2;
            iArr[BufferOverflow.DROP_OLDEST.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ void getLastReplayedLocked$annotations() {
    }

    @Override // kotlinx.coroutines.flow.SharedFlow, kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector<? super T> flowCollector, Continuation<?> continuation) {
        return collect$suspendImpl(this, flowCollector, continuation);
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow, kotlinx.coroutines.flow.FlowCollector
    public Object emit(T t, Continuation<? super Unit> continuation) {
        return emit$suspendImpl(this, t, continuation);
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B1\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\nH\u0016R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/flow/SharedFlowImpl$Emitter;", "Lkotlinx/coroutines/DisposableHandle;", "flow", "Lkotlinx/coroutines/flow/SharedFlowImpl;", "index", "", "value", "", "cont", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/flow/SharedFlowImpl;JLjava/lang/Object;Lkotlin/coroutines/Continuation;)V", "dispose", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Emitter implements DisposableHandle {
        @JvmField
        public final Continuation<Unit> cont;
        @JvmField
        public final SharedFlowImpl<?> flow;
        @JvmField
        public long index;
        @JvmField
        public final Object value;

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.coroutines.Continuation<? super kotlin.Unit> */
        /* JADX WARN: Multi-variable type inference failed */
        public Emitter(SharedFlowImpl<?> sharedFlowImpl, long j, Object obj, Continuation<? super Unit> continuation) {
            this.flow = sharedFlowImpl;
            this.index = j;
            this.value = obj;
            this.cont = continuation;
        }

        @Override // kotlinx.coroutines.DisposableHandle
        public void dispose() {
            this.flow.cancelEmitter(this);
        }
    }

    public SharedFlowImpl(int i, int i2, BufferOverflow bufferOverflow) {
        this.replay = i;
        this.bufferCapacity = i2;
        this.onBufferOverflow = bufferOverflow;
    }

    public static /* synthetic */ Object emit$suspendImpl(SharedFlowImpl sharedFlowImpl, Object obj, Continuation continuation) {
        if (sharedFlowImpl.tryEmit(obj)) {
            return Unit.INSTANCE;
        }
        Object emitSuspend = sharedFlowImpl.emitSuspend(obj, continuation);
        if (emitSuspend == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return emitSuspend;
        }
        return Unit.INSTANCE;
    }

    private final Object[] growBuffer(Object[] objArr, int i, int i2) {
        boolean z;
        if (i2 > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            Object[] objArr2 = new Object[i2];
            this.buffer = objArr2;
            if (objArr == null) {
                return objArr2;
            }
            long head = getHead();
            for (int i3 = 0; i3 < i; i3++) {
                long j = i3 + head;
                SharedFlowKt.access$setBufferAt(objArr2, j, SharedFlowKt.access$getBufferAt(objArr, j));
            }
            return objArr2;
        }
        throw new IllegalStateException("Buffer size overflow".toString());
    }

    @Override // kotlinx.coroutines.flow.internal.FusibleFlow
    public Flow<T> fuse(CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow) {
        return SharedFlowKt.fuseSharedFlow(this, coroutineContext, i, bufferOverflow);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cancelEmitter(Emitter emitter) {
        synchronized (this) {
            if (emitter.index < getHead()) {
                return;
            }
            Object[] objArr = this.buffer;
            Intrinsics.checkNotNull(objArr);
            if (SharedFlowKt.access$getBufferAt(objArr, emitter.index) != emitter) {
                return;
            }
            SharedFlowKt.access$setBufferAt(objArr, emitter.index, SharedFlowKt.NO_VALUE);
            cleanupTailLocked();
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void correctCollectorIndexesOnDropOldest(long j) {
        AbstractSharedFlowSlot[] access$getSlots;
        if (AbstractSharedFlow.access$getNCollectors(this) != 0 && (access$getSlots = AbstractSharedFlow.access$getSlots(this)) != null) {
            int i = 0;
            int length = access$getSlots.length;
            while (i < length) {
                AbstractSharedFlowSlot abstractSharedFlowSlot = access$getSlots[i];
                i++;
                if (abstractSharedFlowSlot != null) {
                    SharedFlowSlot sharedFlowSlot = (SharedFlowSlot) abstractSharedFlowSlot;
                    long j2 = sharedFlowSlot.index;
                    if (j2 >= 0 && j2 < j) {
                        sharedFlowSlot.index = j;
                    }
                }
            }
        }
        this.minCollectorIndex = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void enqueueLocked(Object obj) {
        int totalSize = getTotalSize();
        Object[] objArr = this.buffer;
        if (objArr == null) {
            objArr = growBuffer(null, 0, 2);
        } else if (totalSize >= objArr.length) {
            objArr = growBuffer(objArr, totalSize, objArr.length * 2);
        }
        SharedFlowKt.access$setBufferAt(objArr, getHead() + totalSize, obj);
    }

    private final Object getPeekedValueLockedAt(long j) {
        Object[] objArr = this.buffer;
        Intrinsics.checkNotNull(objArr);
        Object access$getBufferAt = SharedFlowKt.access$getBufferAt(objArr, j);
        if (access$getBufferAt instanceof Emitter) {
            return ((Emitter) access$getBufferAt).value;
        }
        return access$getBufferAt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long tryPeekLocked(SharedFlowSlot sharedFlowSlot) {
        long j = sharedFlowSlot.index;
        if (j < getBufferEndIndex()) {
            return j;
        }
        if (this.bufferCapacity > 0 || j > getHead() || this.queueSize == 0) {
            return -1L;
        }
        return j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    public SharedFlowSlot[] createSlotArray(int i) {
        return new SharedFlowSlot[i];
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public boolean tryEmit(T t) {
        int i;
        boolean z;
        Continuation<Unit>[] continuationArr = AbstractSharedFlowKt.EMPTY_RESUMES;
        synchronized (this) {
            i = 0;
            if (tryEmitLocked(t)) {
                continuationArr = findSlotsToResumeLocked(continuationArr);
                z = true;
            } else {
                z = false;
            }
        }
        int length = continuationArr.length;
        while (i < length) {
            Continuation<Unit> continuation = continuationArr[i];
            i++;
            if (continuation != null) {
                Result.Companion companion = Result.Companion;
                continuation.resumeWith(Result.m855constructorimpl(Unit.INSTANCE));
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object awaitValue(SharedFlowSlot sharedFlowSlot, Continuation<? super Unit> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        synchronized (this) {
            if (tryPeekLocked(sharedFlowSlot) < 0) {
                sharedFlowSlot.cont = cancellableContinuationImpl;
                sharedFlowSlot.cont = cancellableContinuationImpl;
            } else {
                Result.Companion companion = Result.Companion;
                cancellableContinuationImpl.resumeWith(Result.m855constructorimpl(Unit.INSTANCE));
            }
            Unit unit = Unit.INSTANCE;
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return result;
        }
        return Unit.INSTANCE;
    }

    private final void cleanupTailLocked() {
        if (this.bufferCapacity == 0 && this.queueSize <= 1) {
            return;
        }
        Object[] objArr = this.buffer;
        Intrinsics.checkNotNull(objArr);
        while (this.queueSize > 0 && SharedFlowKt.access$getBufferAt(objArr, (getHead() + getTotalSize()) - 1) == SharedFlowKt.NO_VALUE) {
            this.queueSize--;
            SharedFlowKt.access$setBufferAt(objArr, getHead() + getTotalSize(), null);
        }
    }

    private final void dropOldestLocked() {
        boolean z;
        Object[] objArr = this.buffer;
        Intrinsics.checkNotNull(objArr);
        SharedFlowKt.access$setBufferAt(objArr, getHead(), null);
        this.bufferSize--;
        long head = getHead() + 1;
        if (this.replayIndex < head) {
            this.replayIndex = head;
        }
        if (this.minCollectorIndex < head) {
            correctCollectorIndexesOnDropOldest(head);
        }
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (getHead() == head) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                throw new AssertionError();
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:3|(7:5|6|(3:(6:(1:(1:11)(2:42|43))(1:44)|12|13|14|15|(3:16|(4:26|(1:28)(1:34)|29|(2:31|32)(1:33))(3:18|19|(2:21|22)(1:24))|25))(4:45|46|47|48)|38|39)(5:54|55|56|(2:58|(1:60))|62)|49|50|15|(3:16|(0)(0)|25)))|65|6|(0)(0)|49|50|15|(3:16|(0)(0)|25)) */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00d3, code lost:
        r10 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00d4, code lost:
        r5 = r8;
        r8 = r10;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00c2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ab A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ Object collect$suspendImpl(SharedFlowImpl sharedFlowImpl, FlowCollector flowCollector, Continuation continuation) {
        SharedFlowImpl$collect$1 sharedFlowImpl$collect$1;
        int i;
        SharedFlowImpl sharedFlowImpl2;
        Throwable th;
        SharedFlowSlot sharedFlowSlot;
        FlowCollector flowCollector2;
        Job job;
        Object tryTakeValue;
        Job job2;
        FlowCollector flowCollector3;
        if (continuation instanceof SharedFlowImpl$collect$1) {
            sharedFlowImpl$collect$1 = (SharedFlowImpl$collect$1) continuation;
            int i2 = sharedFlowImpl$collect$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                sharedFlowImpl$collect$1.label = i2 - Integer.MIN_VALUE;
                Object obj = sharedFlowImpl$collect$1.result;
                Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = sharedFlowImpl$collect$1.label;
                if (i == 0) {
                    if (i != 1) {
                        if (i != 2) {
                            if (i == 3) {
                                job2 = (Job) sharedFlowImpl$collect$1.L$3;
                                sharedFlowSlot = (SharedFlowSlot) sharedFlowImpl$collect$1.L$2;
                                flowCollector3 = (FlowCollector) sharedFlowImpl$collect$1.L$1;
                                sharedFlowImpl2 = (SharedFlowImpl) sharedFlowImpl$collect$1.L$0;
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } else {
                            job2 = (Job) sharedFlowImpl$collect$1.L$3;
                            sharedFlowSlot = (SharedFlowSlot) sharedFlowImpl$collect$1.L$2;
                            flowCollector3 = (FlowCollector) sharedFlowImpl$collect$1.L$1;
                            sharedFlowImpl2 = (SharedFlowImpl) sharedFlowImpl$collect$1.L$0;
                        }
                        try {
                            ResultKt.throwOnFailure(obj);
                            flowCollector2 = flowCollector3;
                            job = job2;
                            sharedFlowImpl = sharedFlowImpl2;
                            while (true) {
                                tryTakeValue = sharedFlowImpl.tryTakeValue(sharedFlowSlot);
                                if (tryTakeValue != SharedFlowKt.NO_VALUE) {
                                    if (job != null) {
                                        JobKt.ensureActive(job);
                                    }
                                    sharedFlowImpl$collect$1.L$0 = sharedFlowImpl;
                                    sharedFlowImpl$collect$1.L$1 = flowCollector2;
                                    sharedFlowImpl$collect$1.L$2 = sharedFlowSlot;
                                    sharedFlowImpl$collect$1.L$3 = job;
                                    sharedFlowImpl$collect$1.label = 3;
                                    if (flowCollector2.emit(tryTakeValue, sharedFlowImpl$collect$1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                } else {
                                    sharedFlowImpl$collect$1.L$0 = sharedFlowImpl;
                                    sharedFlowImpl$collect$1.L$1 = flowCollector2;
                                    sharedFlowImpl$collect$1.L$2 = sharedFlowSlot;
                                    sharedFlowImpl$collect$1.L$3 = job;
                                    sharedFlowImpl$collect$1.label = 2;
                                    if (sharedFlowImpl.awaitValue(sharedFlowSlot, sharedFlowImpl$collect$1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } else {
                        sharedFlowSlot = (SharedFlowSlot) sharedFlowImpl$collect$1.L$2;
                        FlowCollector flowCollector4 = (FlowCollector) sharedFlowImpl$collect$1.L$1;
                        SharedFlowImpl sharedFlowImpl3 = (SharedFlowImpl) sharedFlowImpl$collect$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            flowCollector2 = flowCollector4;
                            sharedFlowImpl = sharedFlowImpl3;
                        } catch (Throwable th3) {
                            th = th3;
                            sharedFlowImpl2 = sharedFlowImpl3;
                        }
                    }
                    sharedFlowImpl2.freeSlot(sharedFlowSlot);
                    throw th;
                }
                ResultKt.throwOnFailure(obj);
                SharedFlowSlot sharedFlowSlot2 = (SharedFlowSlot) sharedFlowImpl.allocateSlot();
                try {
                    if (flowCollector instanceof SubscribedFlowCollector) {
                        sharedFlowImpl$collect$1.L$0 = sharedFlowImpl;
                        sharedFlowImpl$collect$1.L$1 = flowCollector;
                        sharedFlowImpl$collect$1.L$2 = sharedFlowSlot2;
                        sharedFlowImpl$collect$1.label = 1;
                        if (((SubscribedFlowCollector) flowCollector).onSubscription(sharedFlowImpl$collect$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    flowCollector2 = flowCollector;
                    sharedFlowSlot = sharedFlowSlot2;
                } catch (Throwable th4) {
                    sharedFlowImpl2 = sharedFlowImpl;
                    th = th4;
                    sharedFlowSlot = sharedFlowSlot2;
                }
                job = (Job) sharedFlowImpl$collect$1.getContext().get(Job.Key);
                while (true) {
                    tryTakeValue = sharedFlowImpl.tryTakeValue(sharedFlowSlot);
                    if (tryTakeValue != SharedFlowKt.NO_VALUE) {
                    }
                }
            }
        }
        sharedFlowImpl$collect$1 = new SharedFlowImpl$collect$1(sharedFlowImpl, continuation);
        Object obj2 = sharedFlowImpl$collect$1.result;
        Object coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = sharedFlowImpl$collect$1.label;
        if (i == 0) {
        }
        job = (Job) sharedFlowImpl$collect$1.getContext().get(Job.Key);
        while (true) {
            tryTakeValue = sharedFlowImpl.tryTakeValue(sharedFlowSlot);
            if (tryTakeValue != SharedFlowKt.NO_VALUE) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object emitSuspend(T t, Continuation<? super Unit> continuation) {
        Continuation<Unit>[] continuationArr;
        Emitter emitter;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        Continuation<Unit>[] continuationArr2 = AbstractSharedFlowKt.EMPTY_RESUMES;
        synchronized (this) {
            if (!tryEmitLocked(t)) {
                Emitter emitter2 = new Emitter(this, getTotalSize() + getHead(), t, cancellableContinuationImpl);
                enqueueLocked(emitter2);
                this.queueSize++;
                if (this.bufferCapacity == 0) {
                    continuationArr2 = findSlotsToResumeLocked(continuationArr2);
                }
                continuationArr = continuationArr2;
                emitter = emitter2;
            } else {
                Result.Companion companion = Result.Companion;
                cancellableContinuationImpl.resumeWith(Result.m855constructorimpl(Unit.INSTANCE));
                continuationArr = findSlotsToResumeLocked(continuationArr2);
                emitter = null;
            }
        }
        if (emitter != null) {
            CancellableContinuationKt.disposeOnCancellation(cancellableContinuationImpl, emitter);
        }
        int i = 0;
        int length = continuationArr.length;
        while (i < length) {
            Continuation<Unit> continuation2 = continuationArr[i];
            i++;
            if (continuation2 != null) {
                Result.Companion companion2 = Result.Companion;
                continuation2.resumeWith(Result.m855constructorimpl(Unit.INSTANCE));
            }
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return result;
        }
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:24:0x004b */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:28:0x0011 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:29:0x0011 */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v6, types: [java.lang.Object[], java.lang.Object] */
    public final Continuation<Unit>[] findSlotsToResumeLocked(Continuation<Unit>[] continuationArr) {
        AbstractSharedFlowSlot[] access$getSlots;
        SharedFlowSlot sharedFlowSlot;
        Continuation<? super Unit> continuation;
        int length = continuationArr.length;
        if (AbstractSharedFlow.access$getNCollectors(this) != 0 && (access$getSlots = AbstractSharedFlow.access$getSlots(this)) != null) {
            int i = 0;
            int length2 = access$getSlots.length;
            while (i < length2) {
                AbstractSharedFlowSlot abstractSharedFlowSlot = access$getSlots[i];
                i++;
                if (abstractSharedFlowSlot != null && (continuation = (sharedFlowSlot = (SharedFlowSlot) abstractSharedFlowSlot).cont) != null && tryPeekLocked(sharedFlowSlot) >= 0) {
                    int length3 = continuationArr.length;
                    continuationArr = continuationArr;
                    if (length >= length3) {
                        ?? copyOf = Arrays.copyOf(continuationArr, Math.max(2, continuationArr.length * 2));
                        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
                        continuationArr = copyOf;
                    }
                    continuationArr[length] = continuation;
                    sharedFlowSlot.cont = null;
                    length++;
                }
            }
        }
        return continuationArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean tryEmitLocked(T t) {
        if (getNCollectors() == 0) {
            return tryEmitNoCollectorsLocked(t);
        }
        if (this.bufferSize >= this.bufferCapacity && this.minCollectorIndex <= this.replayIndex) {
            int i = WhenMappings.$EnumSwitchMapping$0[this.onBufferOverflow.ordinal()];
            if (i != 1) {
                if (i == 2) {
                    return true;
                }
            } else {
                return false;
            }
        }
        enqueueLocked(t);
        int i2 = this.bufferSize + 1;
        this.bufferSize = i2;
        if (i2 > this.bufferCapacity) {
            dropOldestLocked();
        }
        if (getReplaySize() > this.replay) {
            updateBufferLocked(this.replayIndex + 1, this.minCollectorIndex, getBufferEndIndex(), getQueueEndIndex());
        }
        return true;
    }

    private final long getBufferEndIndex() {
        return getHead() + this.bufferSize;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long getHead() {
        return Math.min(this.minCollectorIndex, this.replayIndex);
    }

    private final long getQueueEndIndex() {
        return getHead() + this.bufferSize + this.queueSize;
    }

    private final int getReplaySize() {
        return (int) ((getHead() + this.bufferSize) - this.replayIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getTotalSize() {
        return this.bufferSize + this.queueSize;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    public SharedFlowSlot createSlot() {
        return new SharedFlowSlot();
    }

    public final T getLastReplayedLocked() {
        Object[] objArr = this.buffer;
        Intrinsics.checkNotNull(objArr);
        return (T) SharedFlowKt.access$getBufferAt(objArr, (this.replayIndex + getReplaySize()) - 1);
    }

    @Override // kotlinx.coroutines.flow.SharedFlow
    public List<T> getReplayCache() {
        synchronized (this) {
            int replaySize = getReplaySize();
            if (replaySize == 0) {
                return CollectionsKt__CollectionsKt.emptyList();
            }
            ArrayList arrayList = new ArrayList(replaySize);
            Object[] objArr = this.buffer;
            Intrinsics.checkNotNull(objArr);
            int i = 0;
            while (i < replaySize) {
                int i2 = i + 1;
                arrayList.add(SharedFlowKt.access$getBufferAt(objArr, this.replayIndex + i));
                i = i2;
            }
            return arrayList;
        }
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public void resetReplayCache() {
        synchronized (this) {
            updateBufferLocked(getBufferEndIndex(), this.minCollectorIndex, getBufferEndIndex(), getQueueEndIndex());
            Unit unit = Unit.INSTANCE;
        }
    }

    public final long updateNewCollectorIndexLocked$kotlinx_coroutines_core() {
        long j = this.replayIndex;
        if (j < this.minCollectorIndex) {
            this.minCollectorIndex = j;
        }
        return j;
    }

    private final boolean tryEmitNoCollectorsLocked(T t) {
        boolean z;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (getNCollectors() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                throw new AssertionError();
            }
        }
        if (this.replay == 0) {
            return true;
        }
        enqueueLocked(t);
        int i = this.bufferSize + 1;
        this.bufferSize = i;
        if (i > this.replay) {
            dropOldestLocked();
        }
        this.minCollectorIndex = getHead() + this.bufferSize;
        return true;
    }

    private final Object tryTakeValue(SharedFlowSlot sharedFlowSlot) {
        Object obj;
        Continuation<Unit>[] continuationArr = AbstractSharedFlowKt.EMPTY_RESUMES;
        synchronized (this) {
            long tryPeekLocked = tryPeekLocked(sharedFlowSlot);
            if (tryPeekLocked < 0) {
                obj = SharedFlowKt.NO_VALUE;
            } else {
                long j = sharedFlowSlot.index;
                Object peekedValueLockedAt = getPeekedValueLockedAt(tryPeekLocked);
                sharedFlowSlot.index = tryPeekLocked + 1;
                continuationArr = updateCollectorIndexLocked$kotlinx_coroutines_core(j);
                obj = peekedValueLockedAt;
            }
        }
        int i = 0;
        int length = continuationArr.length;
        while (i < length) {
            Continuation<Unit> continuation = continuationArr[i];
            i++;
            if (continuation != null) {
                Result.Companion companion = Result.Companion;
                continuation.resumeWith(Result.m855constructorimpl(Unit.INSTANCE));
            }
        }
        return obj;
    }

    private final void updateBufferLocked(long j, long j2, long j3, long j4) {
        boolean z;
        boolean z2;
        boolean z3;
        long min = Math.min(j2, j);
        boolean z4 = true;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (min >= getHead()) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (!z3) {
                throw new AssertionError();
            }
        }
        for (long head = getHead(); head < min; head = 1 + head) {
            Object[] objArr = this.buffer;
            Intrinsics.checkNotNull(objArr);
            SharedFlowKt.access$setBufferAt(objArr, head, null);
        }
        this.replayIndex = j;
        this.minCollectorIndex = j2;
        this.bufferSize = (int) (j3 - min);
        this.queueSize = (int) (j4 - j3);
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (this.bufferSize >= 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                throw new AssertionError();
            }
        }
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (this.queueSize >= 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                throw new AssertionError();
            }
        }
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (this.replayIndex > getHead() + this.bufferSize) {
                z4 = false;
            }
            if (!z4) {
                throw new AssertionError();
            }
        }
    }

    public final Continuation<Unit>[] updateCollectorIndexLocked$kotlinx_coroutines_core(long j) {
        int i;
        long j2;
        long j3;
        boolean z;
        boolean z2;
        AbstractSharedFlowSlot[] access$getSlots;
        boolean z3;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (j >= this.minCollectorIndex) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (!z3) {
                throw new AssertionError();
            }
        }
        if (j > this.minCollectorIndex) {
            return AbstractSharedFlowKt.EMPTY_RESUMES;
        }
        long head = getHead();
        long j4 = this.bufferSize + head;
        long j5 = 1;
        if (this.bufferCapacity == 0 && this.queueSize > 0) {
            j4++;
        }
        if (AbstractSharedFlow.access$getNCollectors(this) != 0 && (access$getSlots = AbstractSharedFlow.access$getSlots(this)) != null) {
            int length = access$getSlots.length;
            int i2 = 0;
            while (i2 < length) {
                AbstractSharedFlowSlot abstractSharedFlowSlot = access$getSlots[i2];
                i2++;
                if (abstractSharedFlowSlot != null) {
                    long j6 = ((SharedFlowSlot) abstractSharedFlowSlot).index;
                    if (j6 >= 0 && j6 < j4) {
                        j4 = j6;
                    }
                }
            }
        }
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (j4 >= this.minCollectorIndex) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                throw new AssertionError();
            }
        }
        if (j4 <= this.minCollectorIndex) {
            return AbstractSharedFlowKt.EMPTY_RESUMES;
        }
        long bufferEndIndex = getBufferEndIndex();
        if (getNCollectors() > 0) {
            i = Math.min(this.queueSize, this.bufferCapacity - ((int) (bufferEndIndex - j4)));
        } else {
            i = this.queueSize;
        }
        Continuation<Unit>[] continuationArr = AbstractSharedFlowKt.EMPTY_RESUMES;
        long j7 = this.queueSize + bufferEndIndex;
        if (i > 0) {
            continuationArr = new Continuation[i];
            Object[] objArr = this.buffer;
            Intrinsics.checkNotNull(objArr);
            long j8 = bufferEndIndex;
            int i3 = 0;
            while (true) {
                if (bufferEndIndex < j7) {
                    long j9 = bufferEndIndex + j5;
                    Object access$getBufferAt = SharedFlowKt.access$getBufferAt(objArr, bufferEndIndex);
                    Symbol symbol = SharedFlowKt.NO_VALUE;
                    if (access$getBufferAt != symbol) {
                        if (access$getBufferAt != null) {
                            Emitter emitter = (Emitter) access$getBufferAt;
                            j2 = j4;
                            int i4 = i3 + 1;
                            continuationArr[i3] = emitter.cont;
                            SharedFlowKt.access$setBufferAt(objArr, bufferEndIndex, symbol);
                            SharedFlowKt.access$setBufferAt(objArr, j8, emitter.value);
                            j8++;
                            if (i4 >= i) {
                                break;
                            }
                            i3 = i4;
                            bufferEndIndex = j9;
                            j4 = j2;
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.flow.SharedFlowImpl.Emitter");
                        }
                    } else {
                        bufferEndIndex = j9;
                    }
                    j5 = 1;
                } else {
                    j2 = j4;
                    break;
                }
            }
            bufferEndIndex = j8;
        } else {
            j2 = j4;
        }
        int i5 = (int) (bufferEndIndex - head);
        if (getNCollectors() == 0) {
            j3 = bufferEndIndex;
        } else {
            j3 = j2;
        }
        long max = Math.max(this.replayIndex, bufferEndIndex - Math.min(this.replay, i5));
        if (this.bufferCapacity == 0 && max < j7) {
            Object[] objArr2 = this.buffer;
            Intrinsics.checkNotNull(objArr2);
            if (Intrinsics.areEqual(SharedFlowKt.access$getBufferAt(objArr2, max), SharedFlowKt.NO_VALUE)) {
                bufferEndIndex++;
                max++;
            }
        }
        updateBufferLocked(max, j3, bufferEndIndex, j7);
        cleanupTailLocked();
        if (continuationArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (true ^ z) {
            return findSlotsToResumeLocked(continuationArr);
        }
        return continuationArr;
    }
}
