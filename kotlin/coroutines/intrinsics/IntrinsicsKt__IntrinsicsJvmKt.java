package kotlin.coroutines.intrinsics;

import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteHelper;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.RestrictedContinuationImpl;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aH\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\u001c\b\u0004\u0010\u0005\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003H\u0083\b¢\u0006\u0004\b\u0007\u0010\b\u001aF\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001\"\u0004\b\u0000\u0010\u0000*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a_\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001\"\u0004\b\u0000\u0010\f\"\u0004\b\u0001\u0010\u0000*#\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00040\r¢\u0006\u0002\b\u000e2\u0006\u0010\u000f\u001a\u00028\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u0010\u001a%\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0007¢\u0006\u0004\b\u0011\u0010\u0012\u001aC\u0010\u0013\u001a\u0004\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u0000*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a\\\u0010\u0013\u001a\u0004\u0018\u00010\u0004\"\u0004\b\u0000\u0010\f\"\u0004\b\u0001\u0010\u0000*#\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00040\r¢\u0006\u0002\b\u000e2\u0006\u0010\u000f\u001a\u00028\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0015\u001ap\u0010\u0013\u001a\u0004\u0018\u00010\u0004\"\u0004\b\u0000\u0010\f\"\u0004\b\u0001\u0010\u0016\"\u0004\b\u0002\u0010\u0000*)\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0017¢\u0006\u0002\b\u000e2\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00028\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00020\u0001H\u0081\bø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0019\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"T", "Lkotlin/coroutines/Continuation;", "completion", "Lkotlin/Function1;", "", BreakpointSQLiteHelper.BLOCK_TABLE_NAME, "", "createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt", "(Lkotlin/coroutines/Continuation;Lkotlin/Function1;)Lkotlin/coroutines/Continuation;", "createCoroutineFromSuspendFunction", "createCoroutineUnintercepted", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "R", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", SocialConstants.PARAM_RECEIVER, "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "intercepted", "(Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "startCoroutineUninterceptedOrReturn", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "P", "Lkotlin/Function3;", "param", "(Lkotlin/jvm/functions/Function3;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 5, mv = {1, 1, 15}, pn = "", xi = 0, xs = "kotlin/coroutines/intrinsics/IntrinsicsKt")
/* loaded from: classes2.dex */
public class IntrinsicsKt__IntrinsicsJvmKt {
    @SinceKotlin(version = "1.3")
    public static final <T> Continuation<Unit> createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt(final Continuation<? super T> continuation, final Function1<? super Continuation<? super T>, ? extends Object> function1) {
        final CoroutineContext context = continuation.getContext();
        if (context == EmptyCoroutineContext.INSTANCE) {
            if (continuation != null) {
                return new RestrictedContinuationImpl(continuation) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$1
                    public int label;

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public Object invokeSuspend(Object obj) {
                        int i2 = this.label;
                        if (i2 == 0) {
                            this.label = 1;
                            ResultKt.throwOnFailure(obj);
                            return Function1.this.invoke(this);
                        } else if (i2 == 1) {
                            this.label = 2;
                            ResultKt.throwOnFailure(obj);
                            return obj;
                        } else {
                            throw new IllegalStateException("This coroutine had already completed".toString());
                        }
                    }
                };
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        } else if (continuation != null) {
            return new ContinuationImpl(continuation, context) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$2
                public int label;

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public Object invokeSuspend(Object obj) {
                    int i2 = this.label;
                    if (i2 == 0) {
                        this.label = 1;
                        ResultKt.throwOnFailure(obj);
                        return Function1.this.invoke(this);
                    } else if (i2 == 1) {
                        this.label = 2;
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    } else {
                        throw new IllegalStateException("This coroutine had already completed".toString());
                    }
                }
            };
        } else {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }
    }

    @SinceKotlin(version = "1.3")
    public static final <T> Continuation<Unit> createCoroutineUnintercepted(final Function1<? super Continuation<? super T>, ? extends Object> createCoroutineUnintercepted, Continuation<? super T> completion) {
        Continuation<Unit> continuation;
        Intrinsics.checkNotNullParameter(createCoroutineUnintercepted, "$this$createCoroutineUnintercepted");
        Intrinsics.checkNotNullParameter(completion, "completion");
        final Continuation<?> probeCoroutineCreated = DebugProbesKt.probeCoroutineCreated(completion);
        if (createCoroutineUnintercepted instanceof BaseContinuationImpl) {
            return ((BaseContinuationImpl) createCoroutineUnintercepted).create(probeCoroutineCreated);
        }
        final CoroutineContext context = probeCoroutineCreated.getContext();
        if (context == EmptyCoroutineContext.INSTANCE) {
            if (probeCoroutineCreated == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            }
            continuation = new RestrictedContinuationImpl(probeCoroutineCreated) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$1
                public int label;

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public Object invokeSuspend(Object obj) {
                    int i2 = this.label;
                    if (i2 != 0) {
                        if (i2 == 1) {
                            this.label = 2;
                            ResultKt.throwOnFailure(obj);
                            return obj;
                        }
                        throw new IllegalStateException("This coroutine had already completed".toString());
                    }
                    this.label = 1;
                    ResultKt.throwOnFailure(obj);
                    Function1 function1 = createCoroutineUnintercepted;
                    if (function1 != null) {
                        return ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function1, 1)).invoke(this);
                    }
                    throw new NullPointerException("null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
                }
            };
        } else if (probeCoroutineCreated == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        } else {
            continuation = new ContinuationImpl(probeCoroutineCreated, context) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$2
                public int label;

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public Object invokeSuspend(Object obj) {
                    int i2 = this.label;
                    if (i2 != 0) {
                        if (i2 == 1) {
                            this.label = 2;
                            ResultKt.throwOnFailure(obj);
                            return obj;
                        }
                        throw new IllegalStateException("This coroutine had already completed".toString());
                    }
                    this.label = 1;
                    ResultKt.throwOnFailure(obj);
                    Function1 function1 = createCoroutineUnintercepted;
                    if (function1 != null) {
                        return ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function1, 1)).invoke(this);
                    }
                    throw new NullPointerException("null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
                }
            };
        }
        return continuation;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.coroutines.Continuation<? super T> */
    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    public static final <T> Continuation<T> intercepted(Continuation<? super T> intercepted) {
        Continuation<T> continuation;
        Intrinsics.checkNotNullParameter(intercepted, "$this$intercepted");
        ContinuationImpl continuationImpl = !(intercepted instanceof ContinuationImpl) ? null : intercepted;
        return (continuationImpl == null || (continuation = (Continuation<T>) continuationImpl.intercepted()) == null) ? intercepted : continuation;
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    public static final <T> Object startCoroutineUninterceptedOrReturn(Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) {
        if (function1 != null) {
            return ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function1, 1)).invoke(continuation);
        }
        throw new NullPointerException("null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    public static final <R, T> Object startCoroutineUninterceptedOrReturn(Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r, Continuation<? super T> continuation) {
        if (function2 != null) {
            return ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(r, continuation);
        }
        throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
    }

    @InlineOnly
    public static final <R, P, T> Object startCoroutineUninterceptedOrReturn(Function3<? super R, ? super P, ? super Continuation<? super T>, ? extends Object> function3, R r, P p, Continuation<? super T> continuation) {
        if (function3 != null) {
            return ((Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function3, 3)).invoke(r, p, continuation);
        }
        throw new NullPointerException("null cannot be cast to non-null type (R, P, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
    }

    @SinceKotlin(version = "1.3")
    public static final <R, T> Continuation<Unit> createCoroutineUnintercepted(final Function2<? super R, ? super Continuation<? super T>, ? extends Object> createCoroutineUnintercepted, final R r, Continuation<? super T> completion) {
        Continuation<Unit> continuation;
        Intrinsics.checkNotNullParameter(createCoroutineUnintercepted, "$this$createCoroutineUnintercepted");
        Intrinsics.checkNotNullParameter(completion, "completion");
        final Continuation<?> probeCoroutineCreated = DebugProbesKt.probeCoroutineCreated(completion);
        if (createCoroutineUnintercepted instanceof BaseContinuationImpl) {
            return ((BaseContinuationImpl) createCoroutineUnintercepted).create(r, probeCoroutineCreated);
        }
        final CoroutineContext context = probeCoroutineCreated.getContext();
        if (context == EmptyCoroutineContext.INSTANCE) {
            if (probeCoroutineCreated == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            }
            continuation = new RestrictedContinuationImpl(probeCoroutineCreated) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$3
                public int label;

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public Object invokeSuspend(Object obj) {
                    int i2 = this.label;
                    if (i2 != 0) {
                        if (i2 == 1) {
                            this.label = 2;
                            ResultKt.throwOnFailure(obj);
                            return obj;
                        }
                        throw new IllegalStateException("This coroutine had already completed".toString());
                    }
                    this.label = 1;
                    ResultKt.throwOnFailure(obj);
                    Function2 function2 = createCoroutineUnintercepted;
                    if (function2 != null) {
                        return ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(r, this);
                    }
                    throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
                }
            };
        } else if (probeCoroutineCreated == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        } else {
            continuation = new ContinuationImpl(probeCoroutineCreated, context) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$4
                public int label;

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public Object invokeSuspend(Object obj) {
                    int i2 = this.label;
                    if (i2 != 0) {
                        if (i2 == 1) {
                            this.label = 2;
                            ResultKt.throwOnFailure(obj);
                            return obj;
                        }
                        throw new IllegalStateException("This coroutine had already completed".toString());
                    }
                    this.label = 1;
                    ResultKt.throwOnFailure(obj);
                    Function2 function2 = createCoroutineUnintercepted;
                    if (function2 != null) {
                        return ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(r, this);
                    }
                    throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
                }
            };
        }
        return continuation;
    }
}
