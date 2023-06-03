package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.searchbox.yy.gameassist.GameAssistConstKt;
import com.baidu.ugc.editvideo.sticker.StickerDataChangeType;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlow;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.internal.Symbol;
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u0010062\b\u0012\u0004\u0012\u00028\u0000072\b\u0012\u0004\u0012\u00028\u0000082\b\u0012\u0004\u0012\u00028\u000009B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\t\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\f\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ-\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000!2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0019H\u0016¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00028\u0000H\u0016¢\u0006\u0004\b&\u0010'J!\u0010*\u001a\u00020\r2\b\u0010(\u001a\u0004\u0018\u00010\u00022\u0006\u0010)\u001a\u00020\u0002H\u0002¢\u0006\u0004\b*\u0010\u000fR\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00000+8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0016\u0010/\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R*\u0010\u0018\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00028\u00008V@VX\u0096\u000e¢\u0006\u0012\u0012\u0004\b4\u0010%\u001a\u0004\b1\u00102\"\u0004\b3\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u00065"}, d2 = {"Lkotlinx/coroutines/flow/StateFlowImpl;", ExifInterface.GPS_DIRECTION_TRUE, "", "initialState", "<init>", "(Ljava/lang/Object;)V", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", "collect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expect", StickerDataChangeType.UPDATE, "", "compareAndSet", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "Lkotlinx/coroutines/flow/StateFlowSlot;", "createSlot", "()Lkotlinx/coroutines/flow/StateFlowSlot;", "", "size", "", "createSlotArray", "(I)[Lkotlinx/coroutines/flow/StateFlowSlot;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/coroutines/CoroutineContext;", "context", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlinx/coroutines/flow/Flow;", "fuse", "(Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/Flow;", "resetReplayCache", "()V", "tryEmit", "(Ljava/lang/Object;)Z", "expectedState", GameAssistConstKt.KEY_DISK_NEW_STATE, "updateState", "", "getReplayCache", "()Ljava/util/List;", "replayCache", "sequence", "I", "getValue", "()Ljava/lang/Object;", "setValue", "getValue$annotations", "kotlinx-coroutines-core", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlow;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlinx/coroutines/flow/CancellableFlow;", "Lkotlinx/coroutines/flow/internal/FusibleFlow;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes10.dex */
public final class StateFlowImpl<T> extends AbstractSharedFlow<StateFlowSlot> implements MutableStateFlow<T>, CancellableFlow<T>, FusibleFlow<T> {
    public volatile /* synthetic */ Object _state;
    public int sequence;

    public static /* synthetic */ void getValue$annotations() {
    }

    public StateFlowImpl(Object obj) {
        this._state = obj;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    public StateFlowSlot[] createSlotArray(int i) {
        return new StateFlowSlot[i];
    }

    @Override // kotlinx.coroutines.flow.MutableStateFlow
    public void setValue(T t) {
        if (t == null) {
            t = (T) NullSurrogateKt.NULL;
        }
        updateState(null, t);
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public boolean tryEmit(T t) {
        setValue(t);
        return true;
    }

    private final boolean updateState(Object obj, Object obj2) {
        getSlots();
        synchronized (this) {
            Object obj3 = this._state;
            if (obj != null && !Intrinsics.areEqual(obj3, obj)) {
                return false;
            }
            if (Intrinsics.areEqual(obj3, obj2)) {
                return true;
            }
            this._state = obj2;
            int i = this.sequence;
            if ((i & 1) == 0) {
                int i2 = i + 1;
                this.sequence = i2;
                StateFlowSlot[] slots = getSlots();
                Unit unit = Unit.INSTANCE;
                while (true) {
                    StateFlowSlot[] stateFlowSlotArr = slots;
                    if (stateFlowSlotArr != null) {
                        int length = stateFlowSlotArr.length;
                        int i3 = 0;
                        while (i3 < length) {
                            StateFlowSlot stateFlowSlot = stateFlowSlotArr[i3];
                            i3++;
                            if (stateFlowSlot != null) {
                                stateFlowSlot.makePending();
                            }
                        }
                    }
                    synchronized (this) {
                        if (this.sequence == i2) {
                            this.sequence = i2 + 1;
                            return true;
                        }
                        i2 = this.sequence;
                        slots = getSlots();
                        Unit unit2 = Unit.INSTANCE;
                    }
                }
            } else {
                this.sequence = i + 2;
                return true;
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:24:0x0073 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:58:0x0024 */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00b4, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r11, r12) == false) goto L26;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ab A[Catch: all -> 0x0073, TryCatch #0 {all -> 0x0073, blocks: (B:14:0x003e, B:34:0x00a6, B:39:0x00b0, B:49:0x00d1, B:51:0x00d7, B:41:0x00b6, B:45:0x00bd, B:37:0x00ab, B:19:0x005c, B:22:0x006f, B:33:0x0097), top: B:58:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b0 A[Catch: all -> 0x0073, TryCatch #0 {all -> 0x0073, blocks: (B:14:0x003e, B:34:0x00a6, B:39:0x00b0, B:49:0x00d1, B:51:0x00d7, B:41:0x00b6, B:45:0x00bd, B:37:0x00ab, B:19:0x005c, B:22:0x006f, B:33:0x0097), top: B:58:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00cf A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00d7 A[Catch: all -> 0x0073, TRY_LEAVE, TryCatch #0 {all -> 0x0073, blocks: (B:14:0x003e, B:34:0x00a6, B:39:0x00b0, B:49:0x00d1, B:51:0x00d7, B:41:0x00b6, B:45:0x00bd, B:37:0x00ab, B:19:0x005c, B:22:0x006f, B:33:0x0097), top: B:58:0x0024 }] */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v2, types: [kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot] */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x00d5 -> B:34:0x00a6). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x00e7 -> B:34:0x00a6). Please submit an issue!!! */
    @Override // kotlinx.coroutines.flow.SharedFlow, kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object collect(FlowCollector<? super T> flowCollector, Continuation<?> continuation) {
        StateFlowImpl$collect$1 stateFlowImpl$collect$1;
        Object coroutine_suspended;
        int i;
        StateFlowImpl<T> stateFlowImpl;
        StateFlowSlot stateFlowSlot;
        FlowCollector flowCollector2;
        Job job;
        Object obj;
        FlowCollector<? super T> flowCollector3;
        StateFlowSlot stateFlowSlot2;
        boolean takePending;
        Object obj2;
        Object obj3;
        try {
            if (continuation instanceof StateFlowImpl$collect$1) {
                stateFlowImpl$collect$1 = (StateFlowImpl$collect$1) continuation;
                int i2 = stateFlowImpl$collect$1.label;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    stateFlowImpl$collect$1.label = i2 - Integer.MIN_VALUE;
                    Object obj4 = stateFlowImpl$collect$1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = stateFlowImpl$collect$1.label;
                    StateFlowSlot stateFlowSlot3 = 1;
                    if (i == 0) {
                        if (i != 1) {
                            if (i != 2) {
                                if (i == 3) {
                                    obj = stateFlowImpl$collect$1.L$4;
                                    job = (Job) stateFlowImpl$collect$1.L$3;
                                    StateFlowSlot stateFlowSlot4 = (StateFlowSlot) stateFlowImpl$collect$1.L$2;
                                    FlowCollector flowCollector4 = (FlowCollector) stateFlowImpl$collect$1.L$1;
                                    stateFlowImpl = (StateFlowImpl) stateFlowImpl$collect$1.L$0;
                                    ResultKt.throwOnFailure(obj4);
                                    stateFlowSlot3 = stateFlowSlot4;
                                    flowCollector2 = flowCollector4;
                                    obj2 = stateFlowImpl._state;
                                    if (job != null) {
                                        JobKt.ensureActive(job);
                                    }
                                    if (obj != null) {
                                        stateFlowSlot2 = stateFlowSlot3;
                                        flowCollector3 = flowCollector2;
                                    }
                                    if (obj2 == NullSurrogateKt.NULL) {
                                        obj3 = null;
                                    } else {
                                        obj3 = obj2;
                                    }
                                    stateFlowImpl$collect$1.L$0 = stateFlowImpl;
                                    stateFlowImpl$collect$1.L$1 = flowCollector2;
                                    stateFlowImpl$collect$1.L$2 = stateFlowSlot3;
                                    stateFlowImpl$collect$1.L$3 = job;
                                    stateFlowImpl$collect$1.L$4 = obj2;
                                    stateFlowImpl$collect$1.label = 2;
                                    if (flowCollector2.emit(obj3, stateFlowImpl$collect$1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    obj = obj2;
                                    stateFlowSlot2 = stateFlowSlot3;
                                    flowCollector3 = flowCollector2;
                                    takePending = stateFlowSlot2.takePending();
                                    stateFlowSlot3 = stateFlowSlot2;
                                    flowCollector2 = flowCollector3;
                                    if (!takePending) {
                                        stateFlowImpl$collect$1.L$0 = stateFlowImpl;
                                        stateFlowImpl$collect$1.L$1 = flowCollector3;
                                        stateFlowImpl$collect$1.L$2 = stateFlowSlot2;
                                        stateFlowImpl$collect$1.L$3 = job;
                                        stateFlowImpl$collect$1.L$4 = obj;
                                        stateFlowImpl$collect$1.label = 3;
                                        Object awaitPending = stateFlowSlot2.awaitPending(stateFlowImpl$collect$1);
                                        stateFlowSlot3 = stateFlowSlot2;
                                        flowCollector2 = flowCollector3;
                                        if (awaitPending == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                    }
                                    obj2 = stateFlowImpl._state;
                                    if (job != null) {
                                    }
                                    if (obj != null) {
                                    }
                                    if (obj2 == NullSurrogateKt.NULL) {
                                    }
                                    stateFlowImpl$collect$1.L$0 = stateFlowImpl;
                                    stateFlowImpl$collect$1.L$1 = flowCollector2;
                                    stateFlowImpl$collect$1.L$2 = stateFlowSlot3;
                                    stateFlowImpl$collect$1.L$3 = job;
                                    stateFlowImpl$collect$1.L$4 = obj2;
                                    stateFlowImpl$collect$1.label = 2;
                                    if (flowCollector2.emit(obj3, stateFlowImpl$collect$1) == coroutine_suspended) {
                                    }
                                } else {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                            } else {
                                obj = stateFlowImpl$collect$1.L$4;
                                job = (Job) stateFlowImpl$collect$1.L$3;
                                StateFlowSlot stateFlowSlot5 = (StateFlowSlot) stateFlowImpl$collect$1.L$2;
                                FlowCollector<? super T> flowCollector5 = (FlowCollector) stateFlowImpl$collect$1.L$1;
                                stateFlowImpl = (StateFlowImpl) stateFlowImpl$collect$1.L$0;
                                ResultKt.throwOnFailure(obj4);
                                stateFlowSlot2 = stateFlowSlot5;
                                flowCollector3 = flowCollector5;
                                takePending = stateFlowSlot2.takePending();
                                stateFlowSlot3 = stateFlowSlot2;
                                flowCollector2 = flowCollector3;
                                if (!takePending) {
                                }
                                obj2 = stateFlowImpl._state;
                                if (job != null) {
                                }
                                if (obj != null) {
                                }
                                if (obj2 == NullSurrogateKt.NULL) {
                                }
                                stateFlowImpl$collect$1.L$0 = stateFlowImpl;
                                stateFlowImpl$collect$1.L$1 = flowCollector2;
                                stateFlowImpl$collect$1.L$2 = stateFlowSlot3;
                                stateFlowImpl$collect$1.L$3 = job;
                                stateFlowImpl$collect$1.L$4 = obj2;
                                stateFlowImpl$collect$1.label = 2;
                                if (flowCollector2.emit(obj3, stateFlowImpl$collect$1) == coroutine_suspended) {
                                }
                            }
                        } else {
                            stateFlowSlot = (StateFlowSlot) stateFlowImpl$collect$1.L$2;
                            flowCollector = (FlowCollector) stateFlowImpl$collect$1.L$1;
                            stateFlowImpl = (StateFlowImpl) stateFlowImpl$collect$1.L$0;
                            ResultKt.throwOnFailure(obj4);
                        }
                    } else {
                        ResultKt.throwOnFailure(obj4);
                        StateFlowSlot allocateSlot = allocateSlot();
                        try {
                            if (flowCollector instanceof SubscribedFlowCollector) {
                                stateFlowImpl$collect$1.L$0 = this;
                                stateFlowImpl$collect$1.L$1 = flowCollector;
                                stateFlowImpl$collect$1.L$2 = allocateSlot;
                                stateFlowImpl$collect$1.label = 1;
                                if (((SubscribedFlowCollector) flowCollector).onSubscription(stateFlowImpl$collect$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            stateFlowImpl = this;
                            stateFlowSlot = allocateSlot;
                        } catch (Throwable th) {
                            th = th;
                            stateFlowImpl = this;
                            stateFlowSlot3 = allocateSlot;
                            stateFlowImpl.freeSlot(stateFlowSlot3);
                            throw th;
                        }
                    }
                    flowCollector2 = flowCollector;
                    job = (Job) stateFlowImpl$collect$1.getContext().get(Job.Key);
                    obj = null;
                    stateFlowSlot3 = stateFlowSlot;
                    obj2 = stateFlowImpl._state;
                    if (job != null) {
                    }
                    if (obj != null) {
                    }
                    if (obj2 == NullSurrogateKt.NULL) {
                    }
                    stateFlowImpl$collect$1.L$0 = stateFlowImpl;
                    stateFlowImpl$collect$1.L$1 = flowCollector2;
                    stateFlowImpl$collect$1.L$2 = stateFlowSlot3;
                    stateFlowImpl$collect$1.L$3 = job;
                    stateFlowImpl$collect$1.L$4 = obj2;
                    stateFlowImpl$collect$1.label = 2;
                    if (flowCollector2.emit(obj3, stateFlowImpl$collect$1) == coroutine_suspended) {
                    }
                }
            }
            if (i == 0) {
            }
            flowCollector2 = flowCollector;
            job = (Job) stateFlowImpl$collect$1.getContext().get(Job.Key);
            obj = null;
            stateFlowSlot3 = stateFlowSlot;
            obj2 = stateFlowImpl._state;
            if (job != null) {
            }
            if (obj != null) {
            }
            if (obj2 == NullSurrogateKt.NULL) {
            }
            stateFlowImpl$collect$1.L$0 = stateFlowImpl;
            stateFlowImpl$collect$1.L$1 = flowCollector2;
            stateFlowImpl$collect$1.L$2 = stateFlowSlot3;
            stateFlowImpl$collect$1.L$3 = job;
            stateFlowImpl$collect$1.L$4 = obj2;
            stateFlowImpl$collect$1.label = 2;
            if (flowCollector2.emit(obj3, stateFlowImpl$collect$1) == coroutine_suspended) {
            }
        } catch (Throwable th2) {
            th = th2;
        }
        stateFlowImpl$collect$1 = new StateFlowImpl$collect$1(this, continuation);
        Object obj42 = stateFlowImpl$collect$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = stateFlowImpl$collect$1.label;
        StateFlowSlot stateFlowSlot32 = 1;
    }

    @Override // kotlinx.coroutines.flow.MutableStateFlow
    public boolean compareAndSet(T t, T t2) {
        if (t == null) {
            t = (T) NullSurrogateKt.NULL;
        }
        if (t2 == null) {
            t2 = (T) NullSurrogateKt.NULL;
        }
        return updateState(t, t2);
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow, kotlinx.coroutines.flow.FlowCollector
    public Object emit(T t, Continuation<? super Unit> continuation) {
        setValue(t);
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    public StateFlowSlot createSlot() {
        return new StateFlowSlot();
    }

    @Override // kotlinx.coroutines.flow.SharedFlow
    public List<T> getReplayCache() {
        return CollectionsKt__CollectionsJVMKt.listOf(getValue());
    }

    @Override // kotlinx.coroutines.flow.MutableStateFlow, kotlinx.coroutines.flow.StateFlow
    public T getValue() {
        Symbol symbol = NullSurrogateKt.NULL;
        T t = (T) this._state;
        if (t == symbol) {
            return null;
        }
        return t;
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public void resetReplayCache() {
        throw new UnsupportedOperationException("MutableStateFlow.resetReplayCache is not supported");
    }

    @Override // kotlinx.coroutines.flow.internal.FusibleFlow
    public Flow<T> fuse(CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow) {
        return StateFlowKt.fuseStateFlow(this, coroutineContext, i, bufferOverflow);
    }
}
