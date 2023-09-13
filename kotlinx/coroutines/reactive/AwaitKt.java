package kotlinx.coroutines.reactive;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.searchbox.yy.gameassist.GameAssistConstKt;
import java.util.NoSuchElementException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0002\u001a!\u0010\t\u001a\u0002H\n\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000bH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\f\u001a)\u0010\r\u001a\u0002H\n\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000b2\u0006\u0010\u000e\u001a\u0002H\nH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a/\u0010\u0010\u001a\u0002H\n\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\n0\u0012H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0013\u001a#\u0010\u0014\u001a\u0004\u0018\u0001H\n\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000bH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\f\u001a!\u0010\u0015\u001a\u0002H\n\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000bH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\f\u001a5\u0010\u0016\u001a\u0002H\n\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000b2\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u0001H\nH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0017\u001a!\u0010\u0018\u001a\u0002H\n\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000bH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\f\u001a)\u0010\u0019\u001a\u0002H\n\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000b2\u0006\u0010\u000e\u001a\u0002H\nH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a/\u0010\u001a\u001a\u0002H\n\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\n0\u0012H\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u0013\u001a#\u0010\u001b\u001a\u0004\u0018\u0001H\n\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000bH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"gotSignalInTerminalStateException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "signalName", "", "moreThanOneValueProvidedException", "mode", "Lkotlinx/coroutines/reactive/Mode;", "awaitFirst", ExifInterface.GPS_DIRECTION_TRUE, "Lorg/reactivestreams/Publisher;", "(Lorg/reactivestreams/Publisher;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitFirstOrDefault", "default", "(Lorg/reactivestreams/Publisher;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitFirstOrElse", "defaultValue", "Lkotlin/Function0;", "(Lorg/reactivestreams/Publisher;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitFirstOrNull", "awaitLast", "awaitOne", "(Lorg/reactivestreams/Publisher;Lkotlinx/coroutines/reactive/Mode;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitSingle", "awaitSingleOrDefault", "awaitSingleOrElse", "awaitSingleOrNull", "kotlinx-coroutines-reactive"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AwaitKt {
    public static final <T> Object awaitOne(Publisher<T> publisher, final Mode mode, final T t, Continuation<? super T> continuation) {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        ReactiveFlowKt.injectCoroutineContext(publisher, cancellableContinuationImpl.getContext()).subscribe(new Subscriber<T>() { // from class: kotlinx.coroutines.reactive.AwaitKt$awaitOne$2$1
            public boolean inTerminalState;
            public boolean seenValue;
            public Subscription subscription;
            public T value;

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            /* loaded from: classes2.dex */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[Mode.values().length];
                    iArr[Mode.FIRST.ordinal()] = 1;
                    iArr[Mode.FIRST_OR_DEFAULT.ordinal()] = 2;
                    iArr[Mode.LAST.ordinal()] = 3;
                    iArr[Mode.SINGLE.ordinal()] = 4;
                    iArr[Mode.SINGLE_OR_DEFAULT.ordinal()] = 5;
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            private final boolean tryEnterTerminalState(String str) {
                if (this.inTerminalState) {
                    AwaitKt.gotSignalInTerminalStateException(cancellableContinuationImpl.getContext(), str);
                    return false;
                }
                this.inTerminalState = true;
                return true;
            }

            @Override // org.reactivestreams.Subscriber
            public void onError(Throwable th) {
                if (tryEnterTerminalState(GameAssistConstKt.TYPE_CALLBACK_ERROR)) {
                    CancellableContinuation<T> cancellableContinuation = cancellableContinuationImpl;
                    Result.Companion companion = Result.Companion;
                    cancellableContinuation.resumeWith(Result.m850constructorimpl(ResultKt.createFailure(th)));
                }
            }

            @Override // org.reactivestreams.Subscriber
            public void onSubscribe(final Subscription subscription) {
                long j;
                if (this.subscription != null) {
                    subscription.cancel();
                    return;
                }
                this.subscription = subscription;
                cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.reactive.AwaitKt$awaitOne$2$1$onSubscribe$1
                    {
                        super(1);
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                        invoke2(th);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(Throwable th) {
                        Subscription.this.cancel();
                    }
                });
                Mode mode2 = mode;
                if (mode2 != Mode.FIRST && mode2 != Mode.FIRST_OR_DEFAULT) {
                    j = Long.MAX_VALUE;
                } else {
                    j = 1;
                }
                subscription.request(j);
            }

            @Override // org.reactivestreams.Subscriber
            public void onComplete() {
                if (!tryEnterTerminalState(GameAssistConstKt.TYPE_CALLBACK_COMPLETE)) {
                    return;
                }
                if (this.seenValue) {
                    Mode mode2 = mode;
                    if (mode2 != Mode.FIRST_OR_DEFAULT && mode2 != Mode.FIRST && cancellableContinuationImpl.isActive()) {
                        CancellableContinuation<T> cancellableContinuation = cancellableContinuationImpl;
                        Result.Companion companion = Result.Companion;
                        cancellableContinuation.resumeWith(Result.m850constructorimpl(this.value));
                        return;
                    }
                    return;
                }
                Mode mode3 = mode;
                if (mode3 != Mode.FIRST_OR_DEFAULT && mode3 != Mode.SINGLE_OR_DEFAULT) {
                    if (cancellableContinuationImpl.isActive()) {
                        CancellableContinuation<T> cancellableContinuation2 = cancellableContinuationImpl;
                        Result.Companion companion2 = Result.Companion;
                        cancellableContinuation2.resumeWith(Result.m850constructorimpl(ResultKt.createFailure(new NoSuchElementException(Intrinsics.stringPlus("No value received via onNext for ", mode)))));
                        return;
                    }
                    return;
                }
                CancellableContinuation<T> cancellableContinuation3 = cancellableContinuationImpl;
                Result.Companion companion3 = Result.Companion;
                cancellableContinuation3.resumeWith(Result.m850constructorimpl(t));
            }

            @Override // org.reactivestreams.Subscriber
            public void onNext(T t2) {
                Subscription subscription = this.subscription;
                CancellableContinuation<T> cancellableContinuation = cancellableContinuationImpl;
                if (subscription == null) {
                    CoroutineExceptionHandlerKt.handleCoroutineException(cancellableContinuation.getContext(), new IllegalStateException("'onNext' was called before 'onSubscribe'"));
                } else if (this.inTerminalState) {
                    AwaitKt.gotSignalInTerminalStateException(cancellableContinuation.getContext(), "onNext");
                } else {
                    int i = WhenMappings.$EnumSwitchMapping$0[mode.ordinal()];
                    if (i != 1 && i != 2) {
                        if (i == 3 || i == 4 || i == 5) {
                            Mode mode2 = mode;
                            if ((mode2 == Mode.SINGLE || mode2 == Mode.SINGLE_OR_DEFAULT) && this.seenValue) {
                                subscription.cancel();
                                if (cancellableContinuationImpl.isActive()) {
                                    CancellableContinuation<T> cancellableContinuation2 = cancellableContinuationImpl;
                                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException(Intrinsics.stringPlus("More than one onNext value for ", mode));
                                    Result.Companion companion = Result.Companion;
                                    cancellableContinuation2.resumeWith(Result.m850constructorimpl(ResultKt.createFailure(illegalArgumentException)));
                                    return;
                                }
                                return;
                            }
                            this.value = t2;
                            this.seenValue = true;
                        }
                    } else if (this.seenValue) {
                        AwaitKt.moreThanOneValueProvidedException(cancellableContinuationImpl.getContext(), mode);
                    } else {
                        this.seenValue = true;
                        subscription.cancel();
                        CancellableContinuation<T> cancellableContinuation3 = cancellableContinuationImpl;
                        Result.Companion companion2 = Result.Companion;
                        cancellableContinuation3.resumeWith(Result.m850constructorimpl(t2));
                    }
                }
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public static final <T> Object awaitFirst(Publisher<T> publisher, Continuation<? super T> continuation) {
        return awaitOne$default(publisher, Mode.FIRST, null, continuation, 2, null);
    }

    public static final <T> Object awaitFirstOrNull(Publisher<T> publisher, Continuation<? super T> continuation) {
        return awaitOne$default(publisher, Mode.FIRST_OR_DEFAULT, null, continuation, 2, null);
    }

    public static final <T> Object awaitLast(Publisher<T> publisher, Continuation<? super T> continuation) {
        return awaitOne$default(publisher, Mode.LAST, null, continuation, 2, null);
    }

    public static final <T> Object awaitSingle(Publisher<T> publisher, Continuation<? super T> continuation) {
        return awaitOne$default(publisher, Mode.SINGLE, null, continuation, 2, null);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated without a replacement due to its name incorrectly conveying the behavior. There is a specialized version for Reactor's Mono, please use that where applicable. Alternatively, please consider using awaitFirstOrNull().", replaceWith = @ReplaceWith(expression = "this.awaitSingleOrNull()", imports = {"kotlinx.coroutines.reactor"}))
    public static final <T> Object awaitSingleOrNull(Publisher<T> publisher, Continuation<? super T> continuation) {
        return awaitOne$default(publisher, Mode.SINGLE_OR_DEFAULT, null, continuation, 2, null);
    }

    public static final void gotSignalInTerminalStateException(CoroutineContext coroutineContext, String str) {
        CoroutineExceptionHandlerKt.handleCoroutineException(coroutineContext, new IllegalStateException('\'' + str + "' was called after the publisher already signalled being in a terminal state"));
    }

    public static final void moreThanOneValueProvidedException(CoroutineContext coroutineContext, Mode mode) {
        CoroutineExceptionHandlerKt.handleCoroutineException(coroutineContext, new IllegalStateException("Only a single value was requested in '" + mode + "', but the publisher provided more"));
    }

    public static final <T> Object awaitFirstOrDefault(Publisher<T> publisher, T t, Continuation<? super T> continuation) {
        return awaitOne(publisher, Mode.FIRST_OR_DEFAULT, t, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated without a replacement due to its name incorrectly conveying the behavior. Please consider using awaitFirstOrDefault().")
    public static final <T> Object awaitSingleOrDefault(Publisher<T> publisher, T t, Continuation<? super T> continuation) {
        return awaitOne(publisher, Mode.SINGLE_OR_DEFAULT, t, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object awaitFirstOrElse(Publisher<T> publisher, Function0<? extends T> function0, Continuation<? super T> continuation) {
        AwaitKt$awaitFirstOrElse$1 awaitKt$awaitFirstOrElse$1;
        Object obj;
        int i;
        if (continuation instanceof AwaitKt$awaitFirstOrElse$1) {
            awaitKt$awaitFirstOrElse$1 = (AwaitKt$awaitFirstOrElse$1) continuation;
            int i2 = awaitKt$awaitFirstOrElse$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                awaitKt$awaitFirstOrElse$1.label = i2 - Integer.MIN_VALUE;
                AwaitKt$awaitFirstOrElse$1 awaitKt$awaitFirstOrElse$12 = awaitKt$awaitFirstOrElse$1;
                obj = awaitKt$awaitFirstOrElse$12.result;
                Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = awaitKt$awaitFirstOrElse$12.label;
                if (i == 0) {
                    if (i == 1) {
                        function0 = (Function0) awaitKt$awaitFirstOrElse$12.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    Mode mode = Mode.FIRST_OR_DEFAULT;
                    awaitKt$awaitFirstOrElse$12.L$0 = function0;
                    awaitKt$awaitFirstOrElse$12.label = 1;
                    obj = awaitOne$default(publisher, mode, null, awaitKt$awaitFirstOrElse$12, 2, null);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                if (obj != null) {
                    return function0.invoke();
                }
                return obj;
            }
        }
        awaitKt$awaitFirstOrElse$1 = new AwaitKt$awaitFirstOrElse$1(continuation);
        AwaitKt$awaitFirstOrElse$1 awaitKt$awaitFirstOrElse$122 = awaitKt$awaitFirstOrElse$1;
        obj = awaitKt$awaitFirstOrElse$122.result;
        Object coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = awaitKt$awaitFirstOrElse$122.label;
        if (i == 0) {
        }
        if (obj != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated without a replacement due to its name incorrectly conveying the behavior. Please consider using awaitFirstOrElse().")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object awaitSingleOrElse(Publisher<T> publisher, Function0<? extends T> function0, Continuation<? super T> continuation) {
        AwaitKt$awaitSingleOrElse$1 awaitKt$awaitSingleOrElse$1;
        Object obj;
        int i;
        if (continuation instanceof AwaitKt$awaitSingleOrElse$1) {
            awaitKt$awaitSingleOrElse$1 = (AwaitKt$awaitSingleOrElse$1) continuation;
            int i2 = awaitKt$awaitSingleOrElse$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                awaitKt$awaitSingleOrElse$1.label = i2 - Integer.MIN_VALUE;
                AwaitKt$awaitSingleOrElse$1 awaitKt$awaitSingleOrElse$12 = awaitKt$awaitSingleOrElse$1;
                obj = awaitKt$awaitSingleOrElse$12.result;
                Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = awaitKt$awaitSingleOrElse$12.label;
                if (i == 0) {
                    if (i == 1) {
                        function0 = (Function0) awaitKt$awaitSingleOrElse$12.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    Mode mode = Mode.SINGLE_OR_DEFAULT;
                    awaitKt$awaitSingleOrElse$12.L$0 = function0;
                    awaitKt$awaitSingleOrElse$12.label = 1;
                    obj = awaitOne$default(publisher, mode, null, awaitKt$awaitSingleOrElse$12, 2, null);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                if (obj != null) {
                    return function0.invoke();
                }
                return obj;
            }
        }
        awaitKt$awaitSingleOrElse$1 = new AwaitKt$awaitSingleOrElse$1(continuation);
        AwaitKt$awaitSingleOrElse$1 awaitKt$awaitSingleOrElse$122 = awaitKt$awaitSingleOrElse$1;
        obj = awaitKt$awaitSingleOrElse$122.result;
        Object coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = awaitKt$awaitSingleOrElse$122.label;
        if (i == 0) {
        }
        if (obj != null) {
        }
    }

    public static /* synthetic */ Object awaitOne$default(Publisher publisher, Mode mode, Object obj, Continuation continuation, int i, Object obj2) {
        if ((i & 2) != 0) {
            obj = null;
        }
        return awaitOne(publisher, mode, obj, continuation);
    }
}
