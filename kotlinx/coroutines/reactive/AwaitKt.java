package kotlinx.coroutines.reactive;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.imsdk.IMConstants;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.reactive.AwaitKt;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a#\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a+\u0010\u0005\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0004\u001a\u00028\u0000H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a1\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0086@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a%\u0010\u000b\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\u0003\u001a#\u0010\f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\u0003\u001a7\u0010\u000f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00018\u0000H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a#\u0010\u0011\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0003\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lorg/reactivestreams/Publisher;", "awaitFirst", "(Lorg/reactivestreams/Publisher;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "default", "awaitFirstOrDefault", "(Lorg/reactivestreams/Publisher;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function0;", "defaultValue", "awaitFirstOrElse", "(Lorg/reactivestreams/Publisher;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitFirstOrNull", "awaitLast", "Lkotlinx/coroutines/reactive/Mode;", "mode", "awaitOne", "(Lorg/reactivestreams/Publisher;Lkotlinx/coroutines/reactive/Mode;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitSingle", "kotlinx-coroutines-reactive"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes9.dex */
public final class AwaitKt {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
    /* loaded from: classes9.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Mode.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[Mode.FIRST.ordinal()] = 1;
            $EnumSwitchMapping$0[Mode.FIRST_OR_DEFAULT.ordinal()] = 2;
            $EnumSwitchMapping$0[Mode.LAST.ordinal()] = 3;
            $EnumSwitchMapping$0[Mode.SINGLE.ordinal()] = 4;
        }
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

    public static final <T> Object awaitFirstOrDefault(Publisher<T> publisher, T t, Continuation<? super T> continuation) {
        return awaitOne(publisher, Mode.FIRST_OR_DEFAULT, t, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
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
                        function0 = (Function0) awaitKt$awaitFirstOrElse$12.L$1;
                        Publisher publisher2 = (Publisher) awaitKt$awaitFirstOrElse$12.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    Mode mode = Mode.FIRST_OR_DEFAULT;
                    awaitKt$awaitFirstOrElse$12.L$0 = publisher;
                    awaitKt$awaitFirstOrElse$12.L$1 = function0;
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

    public static final /* synthetic */ <T> Object awaitOne(final Publisher<T> publisher, final Mode mode, final T t, Continuation<? super T> continuation) {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        ReactiveFlowKt.injectCoroutineContext(publisher, cancellableContinuationImpl.getContext()).subscribe(new Subscriber<T>() { // from class: kotlinx.coroutines.reactive.AwaitKt$awaitOne$$inlined$suspendCancellableCoroutine$lambda$1
            public boolean seenValue;
            public Subscription subscription;
            public T value;

            @Override // org.reactivestreams.Subscriber
            public void onComplete() {
                if (this.seenValue) {
                    if (CancellableContinuation.this.isActive()) {
                        CancellableContinuation cancellableContinuation = CancellableContinuation.this;
                        T t2 = this.value;
                        Result.Companion companion = Result.Companion;
                        cancellableContinuation.resumeWith(Result.m768constructorimpl(t2));
                    }
                } else if (mode == Mode.FIRST_OR_DEFAULT) {
                    CancellableContinuation cancellableContinuation2 = CancellableContinuation.this;
                    Object obj = t;
                    Result.Companion companion2 = Result.Companion;
                    cancellableContinuation2.resumeWith(Result.m768constructorimpl(obj));
                } else if (CancellableContinuation.this.isActive()) {
                    CancellableContinuation cancellableContinuation3 = CancellableContinuation.this;
                    NoSuchElementException noSuchElementException = new NoSuchElementException("No value received via onNext for " + mode);
                    Result.Companion companion3 = Result.Companion;
                    cancellableContinuation3.resumeWith(Result.m768constructorimpl(ResultKt.createFailure(noSuchElementException)));
                }
            }

            @Override // org.reactivestreams.Subscriber
            public void onError(Throwable th) {
                CancellableContinuation cancellableContinuation = CancellableContinuation.this;
                Result.Companion companion = Result.Companion;
                cancellableContinuation.resumeWith(Result.m768constructorimpl(ResultKt.createFailure(th)));
            }

            @Override // org.reactivestreams.Subscriber
            public void onSubscribe(final Subscription subscription) {
                long j;
                this.subscription = subscription;
                CancellableContinuation.this.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.reactive.AwaitKt$awaitOne$$inlined$suspendCancellableCoroutine$lambda$1.1
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
                if (mode == Mode.FIRST) {
                    j = 1;
                } else {
                    j = Long.MAX_VALUE;
                }
                subscription.request(j);
            }

            @Override // org.reactivestreams.Subscriber
            public void onNext(T t2) {
                int i = AwaitKt.WhenMappings.$EnumSwitchMapping$0[mode.ordinal()];
                if (i != 1 && i != 2) {
                    if (i == 3 || i == 4) {
                        if (mode == Mode.SINGLE && this.seenValue) {
                            Subscription subscription = this.subscription;
                            if (subscription == null) {
                                Intrinsics.throwUninitializedPropertyAccessException(IMConstants.SERVICE_TYPE_SUBSCRIPTION);
                            }
                            subscription.cancel();
                            if (CancellableContinuation.this.isActive()) {
                                CancellableContinuation cancellableContinuation = CancellableContinuation.this;
                                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("More than one onNext value for " + mode);
                                Result.Companion companion = Result.Companion;
                                cancellableContinuation.resumeWith(Result.m768constructorimpl(ResultKt.createFailure(illegalArgumentException)));
                                return;
                            }
                            return;
                        }
                        this.value = t2;
                        this.seenValue = true;
                    }
                } else if (!this.seenValue) {
                    this.seenValue = true;
                    Subscription subscription2 = this.subscription;
                    if (subscription2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(IMConstants.SERVICE_TYPE_SUBSCRIPTION);
                    }
                    subscription2.cancel();
                    CancellableContinuation cancellableContinuation2 = CancellableContinuation.this;
                    Result.Companion companion2 = Result.Companion;
                    cancellableContinuation2.resumeWith(Result.m768constructorimpl(t2));
                }
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public static /* synthetic */ Object awaitOne$default(Publisher publisher, Mode mode, Object obj, Continuation continuation, int i, Object obj2) {
        if ((i & 2) != 0) {
            obj = null;
        }
        return awaitOne(publisher, mode, obj, continuation);
    }
}
