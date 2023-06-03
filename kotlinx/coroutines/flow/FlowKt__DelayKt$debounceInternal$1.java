package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.SavedStateHandle;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.selects.SelectBuilderImpl;
/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;", "downstream", "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1", f = "Delay.kt", i = {0, 0, 0, 0, 1, 1, 1, 1}, l = {222, 355}, m = "invokeSuspend", n = {"downstream", SavedStateHandle.VALUES, "lastValue", "timeoutMillis", "downstream", SavedStateHandle.VALUES, "lastValue", "timeoutMillis"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"})
/* loaded from: classes10.dex */
public final class FlowKt__DelayKt$debounceInternal$1<T> extends SuspendLambda implements Function3<CoroutineScope, FlowCollector<? super T>, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Flow<T> $this_debounceInternal;
    public final /* synthetic */ Function1<T, Long> $timeoutMillisSelector;
    public /* synthetic */ Object L$0;
    public /* synthetic */ Object L$1;
    public Object L$2;
    public Object L$3;
    public int label;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.jvm.functions.Function1<? super T, java.lang.Long> */
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlinx.coroutines.flow.Flow<? extends T> */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__DelayKt$debounceInternal$1(Function1<? super T, Long> function1, Flow<? extends T> flow, Continuation<? super FlowKt__DelayKt$debounceInternal$1> continuation) {
        super(3, continuation);
        this.$timeoutMillisSelector = function1;
        this.$this_debounceInternal = flow;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Object obj, Continuation<? super Unit> continuation) {
        return invoke(coroutineScope, (FlowCollector) ((FlowCollector) obj), continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        FlowKt__DelayKt$debounceInternal$1 flowKt__DelayKt$debounceInternal$1 = new FlowKt__DelayKt$debounceInternal$1(this.$timeoutMillisSelector, this.$this_debounceInternal, continuation);
        flowKt__DelayKt$debounceInternal$1.L$0 = coroutineScope;
        flowKt__DelayKt$debounceInternal$1.L$1 = flowCollector;
        return flowKt__DelayKt$debounceInternal$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:61|26|30|31|(3:33|(1:41)(1:37)|(2:39|40))|42|43|44|(1:46)|47|48|(1:50)|(1:52)(1:53)) */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0119, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x011a, code lost:
        r13.handleBuilderException(r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0102 A[Catch: all -> 0x0119, TryCatch #0 {all -> 0x0119, blocks: (B:49:0x00fe, B:51:0x0102, B:52:0x010c), top: B:64:0x00fe }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x012c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x012d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x012d -> B:11:0x0072). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        FlowCollector flowCollector;
        FlowKt__DelayKt$debounceInternal$1<T> flowKt__DelayKt$debounceInternal$1;
        ReceiveChannel receiveChannel;
        Ref.ObjectRef objectRef;
        Ref.LongRef longRef;
        Object obj2;
        Object result;
        boolean z;
        boolean z2;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    Ref.LongRef longRef2 = (Ref.LongRef) this.L$3;
                    ResultKt.throwOnFailure(obj);
                    flowCollector = (FlowCollector) this.L$0;
                    receiveChannel = (ReceiveChannel) this.L$1;
                    objectRef = (Ref.ObjectRef) this.L$2;
                    flowKt__DelayKt$debounceInternal$1 = this;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                objectRef = (Ref.ObjectRef) this.L$2;
                receiveChannel = (ReceiveChannel) this.L$1;
                flowCollector = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure(obj);
                longRef = (Ref.LongRef) this.L$3;
                flowKt__DelayKt$debounceInternal$1 = this;
                objectRef.element = null;
                FlowKt__DelayKt$debounceInternal$1<T> flowKt__DelayKt$debounceInternal$12 = flowKt__DelayKt$debounceInternal$1;
                obj2 = coroutine_suspended;
                Ref.LongRef longRef3 = longRef;
                FlowCollector flowCollector2 = flowCollector;
                ReceiveChannel receiveChannel2 = receiveChannel;
                if (DebugKt.getASSERTIONS_ENABLED()) {
                    if (objectRef.element != null && longRef3.element <= 0) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (!z) {
                        throw new AssertionError();
                    }
                }
                flowKt__DelayKt$debounceInternal$12.L$0 = flowCollector2;
                flowKt__DelayKt$debounceInternal$12.L$1 = receiveChannel2;
                flowKt__DelayKt$debounceInternal$12.L$2 = objectRef;
                flowKt__DelayKt$debounceInternal$12.L$3 = longRef3;
                flowKt__DelayKt$debounceInternal$12.label = 2;
                SelectBuilderImpl selectBuilderImpl = new SelectBuilderImpl(flowKt__DelayKt$debounceInternal$12);
                if (objectRef.element != null) {
                    selectBuilderImpl.onTimeout(longRef3.element, new FlowKt__DelayKt$debounceInternal$1$3$1(flowCollector2, objectRef, null));
                }
                selectBuilderImpl.invoke(receiveChannel2.getOnReceiveCatching(), new FlowKt__DelayKt$debounceInternal$1$3$2(objectRef, flowCollector2, null));
                result = selectBuilderImpl.getResult();
                if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(flowKt__DelayKt$debounceInternal$12);
                }
                if (result != obj2) {
                    return obj2;
                }
                coroutine_suspended = obj2;
                flowKt__DelayKt$debounceInternal$1 = flowKt__DelayKt$debounceInternal$12;
                receiveChannel = receiveChannel2;
                flowCollector = flowCollector2;
            }
        } else {
            ResultKt.throwOnFailure(obj);
            ReceiveChannel produce$default = ProduceKt.produce$default((CoroutineScope) this.L$0, null, 0, new FlowKt__DelayKt$debounceInternal$1$values$1(this.$this_debounceInternal, null), 3, null);
            flowCollector = (FlowCollector) this.L$1;
            flowKt__DelayKt$debounceInternal$1 = this;
            receiveChannel = produce$default;
            objectRef = new Ref.ObjectRef();
        }
        if (objectRef.element != NullSurrogateKt.DONE) {
            longRef = new Ref.LongRef();
            T t = objectRef.element;
            if (t != null) {
                Function1<T, Long> function1 = flowKt__DelayKt$debounceInternal$1.$timeoutMillisSelector;
                if (t == NullSurrogateKt.NULL) {
                    t = null;
                }
                long longValue = function1.invoke(t).longValue();
                longRef.element = longValue;
                if (longValue >= 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    if (longRef.element == 0) {
                        Symbol symbol = NullSurrogateKt.NULL;
                        T t2 = objectRef.element;
                        if (t2 == symbol) {
                            t2 = null;
                        }
                        flowKt__DelayKt$debounceInternal$1.L$0 = flowCollector;
                        flowKt__DelayKt$debounceInternal$1.L$1 = receiveChannel;
                        flowKt__DelayKt$debounceInternal$1.L$2 = objectRef;
                        flowKt__DelayKt$debounceInternal$1.L$3 = longRef;
                        flowKt__DelayKt$debounceInternal$1.label = 1;
                        if (flowCollector.emit(t2, flowKt__DelayKt$debounceInternal$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        objectRef.element = null;
                    }
                } else {
                    throw new IllegalArgumentException("Debounce timeout should not be negative".toString());
                }
            }
            FlowKt__DelayKt$debounceInternal$1<T> flowKt__DelayKt$debounceInternal$122 = flowKt__DelayKt$debounceInternal$1;
            obj2 = coroutine_suspended;
            Ref.LongRef longRef32 = longRef;
            FlowCollector flowCollector22 = flowCollector;
            ReceiveChannel receiveChannel22 = receiveChannel;
            if (DebugKt.getASSERTIONS_ENABLED()) {
            }
            flowKt__DelayKt$debounceInternal$122.L$0 = flowCollector22;
            flowKt__DelayKt$debounceInternal$122.L$1 = receiveChannel22;
            flowKt__DelayKt$debounceInternal$122.L$2 = objectRef;
            flowKt__DelayKt$debounceInternal$122.L$3 = longRef32;
            flowKt__DelayKt$debounceInternal$122.label = 2;
            SelectBuilderImpl selectBuilderImpl2 = new SelectBuilderImpl(flowKt__DelayKt$debounceInternal$122);
            if (objectRef.element != null) {
            }
            selectBuilderImpl2.invoke(receiveChannel22.getOnReceiveCatching(), new FlowKt__DelayKt$debounceInternal$1$3$2(objectRef, flowCollector22, null));
            result = selectBuilderImpl2.getResult();
            if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            }
            if (result != obj2) {
            }
        } else {
            return Unit.INSTANCE;
        }
    }
}
