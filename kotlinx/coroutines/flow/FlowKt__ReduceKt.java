package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobstat.Config;
import com.baidu.pass.ecommerce.StatKey;
import com.baidu.searchbox.player.ubc.FloatingStatPlugin;
import com.baidu.swan.gamecenter.appmanager.download.AppDownloadNetworkStateReceiver;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.internal.AbortFlowException;
import kotlinx.coroutines.flow.internal.FlowExceptions_commonKt;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
@Metadata(d1 = {"\u0000,\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u001a!\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0003\u001aE\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\"\u0010\u0004\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\t\u001a#\u0010\n\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0003\u001aG\u0010\n\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\"\u0010\u0004\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\t\u001ay\u0010\u000b\u001a\u0002H\f\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\f*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\r\u001a\u0002H\f2H\b\u0004\u0010\u000e\u001aB\b\u0001\u0012\u0013\u0012\u0011H\f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u0011H\u0001¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\f0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u000fH\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u0014\u001a!\u0010\u0015\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0003\u001a#\u0010\u0016\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0003\u001as\u0010\u0017\u001a\u0002H\u0018\"\u0004\b\u0000\u0010\u0018\"\b\b\u0001\u0010\u0001*\u0002H\u0018*\b\u0012\u0004\u0012\u0002H\u00010\u00022F\u0010\u000e\u001aB\b\u0001\u0012\u0013\u0012\u0011H\u0018¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u0011H\u0001¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00180\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u000fH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001a\u001a!\u0010\u001b\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0003\u001a#\u0010\u001c\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0003\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, d2 = {Config.TRACE_VISIT_FIRST, ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/Flow;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "predicate", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "firstOrNull", StatKey.EDITADDR_PASTE_ADDRESS_STAGE_FOLD, "R", "initial", AppDownloadNetworkStateReceiver.KEY_OPERATION, "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "acc", "value", "(Lkotlinx/coroutines/flow/Flow;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", FloatingStatPlugin.VALUE_LAST, "lastOrNull", "reduce", ExifInterface.LATITUDE_SOUTH, "accumulator", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "single", "singleOrNull", "kotlinx-coroutines-core"}, k = 5, mv = {1, 6, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes2.dex */
public final /* synthetic */ class FlowKt__ReduceKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0068 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object first(Flow<? extends T> flow, Continuation<? super T> continuation) {
        FlowKt__ReduceKt$first$1 flowKt__ReduceKt$first$1;
        int i;
        Ref.ObjectRef objectRef;
        AbortFlowException e;
        FlowCollector<T> flowCollector;
        T t;
        if (continuation instanceof FlowKt__ReduceKt$first$1) {
            flowKt__ReduceKt$first$1 = (FlowKt__ReduceKt$first$1) continuation;
            int i2 = flowKt__ReduceKt$first$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                flowKt__ReduceKt$first$1.label = i2 - Integer.MIN_VALUE;
                Object obj = flowKt__ReduceKt$first$1.result;
                Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = flowKt__ReduceKt$first$1.label;
                if (i == 0) {
                    if (i == 1) {
                        flowCollector = (FlowKt__ReduceKt$first$$inlined$collectWhile$1) flowKt__ReduceKt$first$1.L$1;
                        objectRef = (Ref.ObjectRef) flowKt__ReduceKt$first$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                        } catch (AbortFlowException e2) {
                            e = e2;
                            FlowExceptions_commonKt.checkOwnership(e, flowCollector);
                            t = objectRef.element;
                            if (t == NullSurrogateKt.NULL) {
                            }
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    objectRef2.element = (T) NullSurrogateKt.NULL;
                    FlowCollector<T> flowCollector2 = new FlowCollector<T>() { // from class: kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$1
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public Object emit(T t2, Continuation<? super Unit> continuation2) {
                            Ref.ObjectRef.this.element = t2;
                            throw new AbortFlowException(this);
                        }
                    };
                    try {
                        flowKt__ReduceKt$first$1.L$0 = objectRef2;
                        flowKt__ReduceKt$first$1.L$1 = flowCollector2;
                        flowKt__ReduceKt$first$1.label = 1;
                        if (flow.collect(flowCollector2, flowKt__ReduceKt$first$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        objectRef = objectRef2;
                    } catch (AbortFlowException e3) {
                        objectRef = objectRef2;
                        e = e3;
                        flowCollector = flowCollector2;
                        FlowExceptions_commonKt.checkOwnership(e, flowCollector);
                        t = objectRef.element;
                        if (t == NullSurrogateKt.NULL) {
                        }
                    }
                }
                t = objectRef.element;
                if (t == NullSurrogateKt.NULL) {
                    return t;
                }
                throw new NoSuchElementException("Expected at least one element");
            }
        }
        flowKt__ReduceKt$first$1 = new FlowKt__ReduceKt$first$1(continuation);
        Object obj2 = flowKt__ReduceKt$first$1.result;
        Object coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__ReduceKt$first$1.label;
        if (i == 0) {
        }
        t = objectRef.element;
        if (t == NullSurrogateKt.NULL) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0068 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object singleOrNull(Flow<? extends T> flow, Continuation<? super T> continuation) {
        FlowKt__ReduceKt$singleOrNull$1 flowKt__ReduceKt$singleOrNull$1;
        int i;
        Ref.ObjectRef objectRef;
        AbortFlowException e;
        FlowCollector<T> flowCollector;
        T t;
        if (continuation instanceof FlowKt__ReduceKt$singleOrNull$1) {
            flowKt__ReduceKt$singleOrNull$1 = (FlowKt__ReduceKt$singleOrNull$1) continuation;
            int i2 = flowKt__ReduceKt$singleOrNull$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                flowKt__ReduceKt$singleOrNull$1.label = i2 - Integer.MIN_VALUE;
                Object obj = flowKt__ReduceKt$singleOrNull$1.result;
                Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = flowKt__ReduceKt$singleOrNull$1.label;
                if (i == 0) {
                    if (i == 1) {
                        flowCollector = (FlowKt__ReduceKt$singleOrNull$$inlined$collectWhile$1) flowKt__ReduceKt$singleOrNull$1.L$1;
                        objectRef = (Ref.ObjectRef) flowKt__ReduceKt$singleOrNull$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                        } catch (AbortFlowException e2) {
                            e = e2;
                            FlowExceptions_commonKt.checkOwnership(e, flowCollector);
                            t = objectRef.element;
                            if (t != NullSurrogateKt.NULL) {
                            }
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    objectRef2.element = (T) NullSurrogateKt.NULL;
                    FlowCollector<T> flowCollector2 = new FlowCollector<T>() { // from class: kotlinx.coroutines.flow.FlowKt__ReduceKt$singleOrNull$$inlined$collectWhile$1
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public Object emit(T t2, Continuation<? super Unit> continuation2) {
                            boolean z;
                            Ref.ObjectRef objectRef3 = Ref.ObjectRef.this;
                            T t3 = objectRef3.element;
                            T t4 = (T) NullSurrogateKt.NULL;
                            if (t3 == t4) {
                                objectRef3.element = t2;
                                z = true;
                            } else {
                                objectRef3.element = t4;
                                z = false;
                            }
                            if (z) {
                                return Unit.INSTANCE;
                            }
                            throw new AbortFlowException(this);
                        }
                    };
                    try {
                        flowKt__ReduceKt$singleOrNull$1.L$0 = objectRef2;
                        flowKt__ReduceKt$singleOrNull$1.L$1 = flowCollector2;
                        flowKt__ReduceKt$singleOrNull$1.label = 1;
                        if (flow.collect(flowCollector2, flowKt__ReduceKt$singleOrNull$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        objectRef = objectRef2;
                    } catch (AbortFlowException e3) {
                        objectRef = objectRef2;
                        e = e3;
                        flowCollector = flowCollector2;
                        FlowExceptions_commonKt.checkOwnership(e, flowCollector);
                        t = objectRef.element;
                        if (t != NullSurrogateKt.NULL) {
                        }
                    }
                }
                t = objectRef.element;
                if (t != NullSurrogateKt.NULL) {
                    return null;
                }
                return t;
            }
        }
        flowKt__ReduceKt$singleOrNull$1 = new FlowKt__ReduceKt$singleOrNull$1(continuation);
        Object obj2 = flowKt__ReduceKt$singleOrNull$1.result;
        Object coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__ReduceKt$singleOrNull$1.label;
        if (i == 0) {
        }
        t = objectRef.element;
        if (t != NullSurrogateKt.NULL) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0070 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object first(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, Continuation<? super T> continuation) {
        FlowKt__ReduceKt$first$3 flowKt__ReduceKt$first$3;
        int i;
        Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function22;
        Ref.ObjectRef objectRef;
        AbortFlowException e;
        FlowCollector<? super Object> flowCollector;
        T t;
        if (continuation instanceof FlowKt__ReduceKt$first$3) {
            flowKt__ReduceKt$first$3 = (FlowKt__ReduceKt$first$3) continuation;
            int i2 = flowKt__ReduceKt$first$3.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                flowKt__ReduceKt$first$3.label = i2 - Integer.MIN_VALUE;
                Object obj = flowKt__ReduceKt$first$3.result;
                Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = flowKt__ReduceKt$first$3.label;
                if (i == 0) {
                    if (i == 1) {
                        flowCollector = (FlowKt__ReduceKt$first$$inlined$collectWhile$2) flowKt__ReduceKt$first$3.L$2;
                        objectRef = (Ref.ObjectRef) flowKt__ReduceKt$first$3.L$1;
                        function22 = (Function2) flowKt__ReduceKt$first$3.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                        } catch (AbortFlowException e2) {
                            e = e2;
                            FlowExceptions_commonKt.checkOwnership(e, flowCollector);
                            t = objectRef.element;
                            if (t == NullSurrogateKt.NULL) {
                            }
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    objectRef2.element = (T) NullSurrogateKt.NULL;
                    FlowCollector<? super Object> flowKt__ReduceKt$first$$inlined$collectWhile$2 = new FlowKt__ReduceKt$first$$inlined$collectWhile$2<>(function2, objectRef2);
                    try {
                        flowKt__ReduceKt$first$3.L$0 = function2;
                        flowKt__ReduceKt$first$3.L$1 = objectRef2;
                        flowKt__ReduceKt$first$3.L$2 = flowKt__ReduceKt$first$$inlined$collectWhile$2;
                        flowKt__ReduceKt$first$3.label = 1;
                        if (flow.collect(flowKt__ReduceKt$first$$inlined$collectWhile$2, flowKt__ReduceKt$first$3) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        function22 = function2;
                        objectRef = objectRef2;
                    } catch (AbortFlowException e3) {
                        function22 = function2;
                        objectRef = objectRef2;
                        e = e3;
                        flowCollector = flowKt__ReduceKt$first$$inlined$collectWhile$2;
                        FlowExceptions_commonKt.checkOwnership(e, flowCollector);
                        t = objectRef.element;
                        if (t == NullSurrogateKt.NULL) {
                        }
                    }
                }
                t = objectRef.element;
                if (t == NullSurrogateKt.NULL) {
                    return t;
                }
                throw new NoSuchElementException(Intrinsics.stringPlus("Expected at least one element matching the predicate ", function22));
            }
        }
        flowKt__ReduceKt$first$3 = new FlowKt__ReduceKt$first$3(continuation);
        Object obj2 = flowKt__ReduceKt$first$3.result;
        Object coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__ReduceKt$first$3.label;
        if (i == 0) {
        }
        t = objectRef.element;
        if (t == NullSurrogateKt.NULL) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object firstOrNull(Flow<? extends T> flow, Continuation<? super T> continuation) {
        FlowKt__ReduceKt$firstOrNull$1 flowKt__ReduceKt$firstOrNull$1;
        int i;
        Ref.ObjectRef objectRef;
        AbortFlowException e;
        FlowCollector<T> flowCollector;
        if (continuation instanceof FlowKt__ReduceKt$firstOrNull$1) {
            flowKt__ReduceKt$firstOrNull$1 = (FlowKt__ReduceKt$firstOrNull$1) continuation;
            int i2 = flowKt__ReduceKt$firstOrNull$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                flowKt__ReduceKt$firstOrNull$1.label = i2 - Integer.MIN_VALUE;
                Object obj = flowKt__ReduceKt$firstOrNull$1.result;
                Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = flowKt__ReduceKt$firstOrNull$1.label;
                if (i == 0) {
                    if (i == 1) {
                        flowCollector = (FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$1) flowKt__ReduceKt$firstOrNull$1.L$1;
                        objectRef = (Ref.ObjectRef) flowKt__ReduceKt$firstOrNull$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                        } catch (AbortFlowException e2) {
                            e = e2;
                            FlowExceptions_commonKt.checkOwnership(e, flowCollector);
                            return objectRef.element;
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    FlowCollector<T> flowCollector2 = new FlowCollector<T>() { // from class: kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$1
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public Object emit(T t, Continuation<? super Unit> continuation2) {
                            Ref.ObjectRef.this.element = t;
                            throw new AbortFlowException(this);
                        }
                    };
                    try {
                        flowKt__ReduceKt$firstOrNull$1.L$0 = objectRef2;
                        flowKt__ReduceKt$firstOrNull$1.L$1 = flowCollector2;
                        flowKt__ReduceKt$firstOrNull$1.label = 1;
                        if (flow.collect(flowCollector2, flowKt__ReduceKt$firstOrNull$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        objectRef = objectRef2;
                    } catch (AbortFlowException e3) {
                        objectRef = objectRef2;
                        e = e3;
                        flowCollector = flowCollector2;
                        FlowExceptions_commonKt.checkOwnership(e, flowCollector);
                        return objectRef.element;
                    }
                }
                return objectRef.element;
            }
        }
        flowKt__ReduceKt$firstOrNull$1 = new FlowKt__ReduceKt$firstOrNull$1(continuation);
        Object obj2 = flowKt__ReduceKt$firstOrNull$1.result;
        Object coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__ReduceKt$firstOrNull$1.label;
        if (i == 0) {
        }
        return objectRef.element;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0058 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object last(Flow<? extends T> flow, Continuation<? super T> continuation) {
        FlowKt__ReduceKt$last$1 flowKt__ReduceKt$last$1;
        int i;
        Ref.ObjectRef objectRef;
        T t;
        if (continuation instanceof FlowKt__ReduceKt$last$1) {
            flowKt__ReduceKt$last$1 = (FlowKt__ReduceKt$last$1) continuation;
            int i2 = flowKt__ReduceKt$last$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                flowKt__ReduceKt$last$1.label = i2 - Integer.MIN_VALUE;
                Object obj = flowKt__ReduceKt$last$1.result;
                Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = flowKt__ReduceKt$last$1.label;
                if (i == 0) {
                    if (i == 1) {
                        objectRef = (Ref.ObjectRef) flowKt__ReduceKt$last$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    objectRef2.element = (T) NullSurrogateKt.NULL;
                    FlowCollector<? super Object> flowKt__ReduceKt$last$2 = new FlowKt__ReduceKt$last$2<>(objectRef2);
                    flowKt__ReduceKt$last$1.L$0 = objectRef2;
                    flowKt__ReduceKt$last$1.label = 1;
                    if (flow.collect(flowKt__ReduceKt$last$2, flowKt__ReduceKt$last$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    objectRef = objectRef2;
                }
                t = objectRef.element;
                if (t == NullSurrogateKt.NULL) {
                    return t;
                }
                throw new NoSuchElementException("Expected at least one element");
            }
        }
        flowKt__ReduceKt$last$1 = new FlowKt__ReduceKt$last$1(continuation);
        Object obj2 = flowKt__ReduceKt$last$1.result;
        Object coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__ReduceKt$last$1.label;
        if (i == 0) {
        }
        t = objectRef.element;
        if (t == NullSurrogateKt.NULL) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object lastOrNull(Flow<? extends T> flow, Continuation<? super T> continuation) {
        FlowKt__ReduceKt$lastOrNull$1 flowKt__ReduceKt$lastOrNull$1;
        int i;
        Ref.ObjectRef objectRef;
        if (continuation instanceof FlowKt__ReduceKt$lastOrNull$1) {
            flowKt__ReduceKt$lastOrNull$1 = (FlowKt__ReduceKt$lastOrNull$1) continuation;
            int i2 = flowKt__ReduceKt$lastOrNull$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                flowKt__ReduceKt$lastOrNull$1.label = i2 - Integer.MIN_VALUE;
                Object obj = flowKt__ReduceKt$lastOrNull$1.result;
                Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = flowKt__ReduceKt$lastOrNull$1.label;
                if (i == 0) {
                    if (i == 1) {
                        objectRef = (Ref.ObjectRef) flowKt__ReduceKt$lastOrNull$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    FlowCollector<? super Object> flowKt__ReduceKt$lastOrNull$2 = new FlowKt__ReduceKt$lastOrNull$2<>(objectRef2);
                    flowKt__ReduceKt$lastOrNull$1.L$0 = objectRef2;
                    flowKt__ReduceKt$lastOrNull$1.label = 1;
                    if (flow.collect(flowKt__ReduceKt$lastOrNull$2, flowKt__ReduceKt$lastOrNull$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    objectRef = objectRef2;
                }
                return objectRef.element;
            }
        }
        flowKt__ReduceKt$lastOrNull$1 = new FlowKt__ReduceKt$lastOrNull$1(continuation);
        Object obj2 = flowKt__ReduceKt$lastOrNull$1.result;
        Object coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__ReduceKt$lastOrNull$1.label;
        if (i == 0) {
        }
        return objectRef.element;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0058 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object single(Flow<? extends T> flow, Continuation<? super T> continuation) {
        FlowKt__ReduceKt$single$1 flowKt__ReduceKt$single$1;
        int i;
        Ref.ObjectRef objectRef;
        T t;
        if (continuation instanceof FlowKt__ReduceKt$single$1) {
            flowKt__ReduceKt$single$1 = (FlowKt__ReduceKt$single$1) continuation;
            int i2 = flowKt__ReduceKt$single$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                flowKt__ReduceKt$single$1.label = i2 - Integer.MIN_VALUE;
                Object obj = flowKt__ReduceKt$single$1.result;
                Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = flowKt__ReduceKt$single$1.label;
                if (i == 0) {
                    if (i == 1) {
                        objectRef = (Ref.ObjectRef) flowKt__ReduceKt$single$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    objectRef2.element = (T) NullSurrogateKt.NULL;
                    FlowCollector<? super Object> flowKt__ReduceKt$single$2 = new FlowKt__ReduceKt$single$2<>(objectRef2);
                    flowKt__ReduceKt$single$1.L$0 = objectRef2;
                    flowKt__ReduceKt$single$1.label = 1;
                    if (flow.collect(flowKt__ReduceKt$single$2, flowKt__ReduceKt$single$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    objectRef = objectRef2;
                }
                t = objectRef.element;
                if (t == NullSurrogateKt.NULL) {
                    return t;
                }
                throw new NoSuchElementException("Flow is empty");
            }
        }
        flowKt__ReduceKt$single$1 = new FlowKt__ReduceKt$single$1(continuation);
        Object obj2 = flowKt__ReduceKt$single$1.result;
        Object coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__ReduceKt$single$1.label;
        if (i == 0) {
        }
        t = objectRef.element;
        if (t == NullSurrogateKt.NULL) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object firstOrNull(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, Continuation<? super T> continuation) {
        FlowKt__ReduceKt$firstOrNull$3 flowKt__ReduceKt$firstOrNull$3;
        int i;
        Ref.ObjectRef objectRef;
        AbortFlowException e;
        FlowCollector<? super Object> flowCollector;
        if (continuation instanceof FlowKt__ReduceKt$firstOrNull$3) {
            flowKt__ReduceKt$firstOrNull$3 = (FlowKt__ReduceKt$firstOrNull$3) continuation;
            int i2 = flowKt__ReduceKt$firstOrNull$3.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                flowKt__ReduceKt$firstOrNull$3.label = i2 - Integer.MIN_VALUE;
                Object obj = flowKt__ReduceKt$firstOrNull$3.result;
                Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = flowKt__ReduceKt$firstOrNull$3.label;
                if (i == 0) {
                    if (i == 1) {
                        flowCollector = (FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2) flowKt__ReduceKt$firstOrNull$3.L$1;
                        objectRef = (Ref.ObjectRef) flowKt__ReduceKt$firstOrNull$3.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                        } catch (AbortFlowException e2) {
                            e = e2;
                            FlowExceptions_commonKt.checkOwnership(e, flowCollector);
                            return objectRef.element;
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    FlowCollector<? super Object> flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2 = new FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2<>(function2, objectRef2);
                    try {
                        flowKt__ReduceKt$firstOrNull$3.L$0 = objectRef2;
                        flowKt__ReduceKt$firstOrNull$3.L$1 = flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2;
                        flowKt__ReduceKt$firstOrNull$3.label = 1;
                        if (flow.collect(flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2, flowKt__ReduceKt$firstOrNull$3) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        objectRef = objectRef2;
                    } catch (AbortFlowException e3) {
                        objectRef = objectRef2;
                        e = e3;
                        flowCollector = flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2;
                        FlowExceptions_commonKt.checkOwnership(e, flowCollector);
                        return objectRef.element;
                    }
                }
                return objectRef.element;
            }
        }
        flowKt__ReduceKt$firstOrNull$3 = new FlowKt__ReduceKt$firstOrNull$3(continuation);
        Object obj2 = flowKt__ReduceKt$firstOrNull$3.result;
        Object coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__ReduceKt$firstOrNull$3.label;
        if (i == 0) {
        }
        return objectRef.element;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0058 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0059  */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlinx.coroutines.internal.Symbol, T] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <S, T extends S> Object reduce(Flow<? extends T> flow, Function3<? super S, ? super T, ? super Continuation<? super S>, ? extends Object> function3, Continuation<? super S> continuation) {
        FlowKt__ReduceKt$reduce$1 flowKt__ReduceKt$reduce$1;
        int i;
        Ref.ObjectRef objectRef;
        T t;
        if (continuation instanceof FlowKt__ReduceKt$reduce$1) {
            flowKt__ReduceKt$reduce$1 = (FlowKt__ReduceKt$reduce$1) continuation;
            int i2 = flowKt__ReduceKt$reduce$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                flowKt__ReduceKt$reduce$1.label = i2 - Integer.MIN_VALUE;
                Object obj = flowKt__ReduceKt$reduce$1.result;
                Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = flowKt__ReduceKt$reduce$1.label;
                if (i == 0) {
                    if (i == 1) {
                        objectRef = (Ref.ObjectRef) flowKt__ReduceKt$reduce$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    objectRef2.element = NullSurrogateKt.NULL;
                    FlowCollector<? super Object> flowKt__ReduceKt$reduce$2 = new FlowKt__ReduceKt$reduce$2<>(objectRef2, function3);
                    flowKt__ReduceKt$reduce$1.L$0 = objectRef2;
                    flowKt__ReduceKt$reduce$1.label = 1;
                    if (flow.collect(flowKt__ReduceKt$reduce$2, flowKt__ReduceKt$reduce$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    objectRef = objectRef2;
                }
                t = objectRef.element;
                if (t == NullSurrogateKt.NULL) {
                    return t;
                }
                throw new NoSuchElementException("Empty flow can't be reduced");
            }
        }
        flowKt__ReduceKt$reduce$1 = new FlowKt__ReduceKt$reduce$1(continuation);
        Object obj2 = flowKt__ReduceKt$reduce$1.result;
        Object coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__ReduceKt$reduce$1.label;
        if (i == 0) {
        }
        t = objectRef.element;
        if (t == NullSurrogateKt.NULL) {
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: R */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T, R> Object fold(Flow<? extends T> flow, R r, Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> function3, Continuation<? super R> continuation) {
        FlowKt__ReduceKt$fold$1 flowKt__ReduceKt$fold$1;
        int i;
        Ref.ObjectRef objectRef;
        if (continuation instanceof FlowKt__ReduceKt$fold$1) {
            flowKt__ReduceKt$fold$1 = (FlowKt__ReduceKt$fold$1) continuation;
            int i2 = flowKt__ReduceKt$fold$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                flowKt__ReduceKt$fold$1.label = i2 - Integer.MIN_VALUE;
                Object obj = flowKt__ReduceKt$fold$1.result;
                Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = flowKt__ReduceKt$fold$1.label;
                if (i == 0) {
                    if (i == 1) {
                        objectRef = (Ref.ObjectRef) flowKt__ReduceKt$fold$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    objectRef2.element = r;
                    FlowCollector<? super Object> flowKt__ReduceKt$fold$2 = new FlowKt__ReduceKt$fold$2<>(objectRef2, function3);
                    flowKt__ReduceKt$fold$1.L$0 = objectRef2;
                    flowKt__ReduceKt$fold$1.label = 1;
                    if (flow.collect(flowKt__ReduceKt$fold$2, flowKt__ReduceKt$fold$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    objectRef = objectRef2;
                }
                return objectRef.element;
            }
        }
        flowKt__ReduceKt$fold$1 = new FlowKt__ReduceKt$fold$1(continuation);
        Object obj2 = flowKt__ReduceKt$fold$1.result;
        Object coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__ReduceKt$fold$1.label;
        if (i == 0) {
        }
        return objectRef.element;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: R */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, R> Object fold$$forInline(Flow<? extends T> flow, R r, Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> function3, Continuation<? super R> continuation) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = r;
        FlowKt__ReduceKt$fold$2 flowKt__ReduceKt$fold$2 = new FlowKt__ReduceKt$fold$2(objectRef, function3);
        InlineMarker.mark(0);
        flow.collect(flowKt__ReduceKt$fold$2, continuation);
        InlineMarker.mark(1);
        return objectRef.element;
    }
}
