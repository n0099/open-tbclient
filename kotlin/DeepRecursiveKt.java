package kotlin;

import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a4\u0010\u0004\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u0003\u001a\u00028\u0000H\u0087\u0002¢\u0006\u0004\b\u0004\u0010\u0005\"\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002@\u0002X\u0082\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b\b\u0010\t*v\b\u0003\u0010\u000f\"5\b\u0001\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f\u0012\u0006\u0012\u0004\u0018\u00010\u00070\n¢\u0006\u0002\b\r25\b\u0001\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f\u0012\u0006\u0012\u0004\u0018\u00010\u00070\n¢\u0006\u0002\b\rB\u0002\b\u000e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"T", "R", "Lkotlin/DeepRecursiveFunction;", "value", "invoke", "(Lkotlin/DeepRecursiveFunction;Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlin/Result;", "", "UNDEFINED_RESULT", "Ljava/lang/Object;", "Lkotlin/Function3;", "Lkotlin/DeepRecursiveScope;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "Lkotlin/ExperimentalStdlibApi;", "DeepRecursiveFunctionBlock", "kotlin-stdlib"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes10.dex */
public final class DeepRecursiveKt {
    public static final Object UNDEFINED_RESULT;

    static {
        Result.Companion companion = Result.Companion;
        UNDEFINED_RESULT = Result.m649constructorimpl(IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED());
    }

    @ExperimentalStdlibApi
    public static /* synthetic */ void DeepRecursiveFunctionBlock$annotations() {
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalStdlibApi
    public static final <T, R> R invoke(DeepRecursiveFunction<T, R> invoke, T t) {
        Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
        return (R) new DeepRecursiveScopeImpl(invoke.getBlock$kotlin_stdlib(), t).runCallLoop();
    }
}
