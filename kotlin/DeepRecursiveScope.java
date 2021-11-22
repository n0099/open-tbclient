package kotlin;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.RestrictsSuspension;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@SinceKotlin(version = "1.4")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u0001\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0004\u001a\u00028\u00012\u0006\u0010\u0003\u001a\u00028\u0000H¦@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J7\u0010\u0004\u001a\u00028\u0003\"\u0004\b\u0002\u0010\u0006\"\u0004\b\u0003\u0010\u0007*\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\b2\u0006\u0010\u0003\u001a\u00028\u0002H¦@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\tJ&\u0010\f\u001a\u00020\u000b*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\nH\u0087\u0002¢\u0006\u0004\b\f\u0010\r\u0082\u0001\u0001\u0010\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Lkotlin/DeepRecursiveScope;", "T", "R", "value", "callRecursive", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "U", "S", "Lkotlin/DeepRecursiveFunction;", "(Lkotlin/DeepRecursiveFunction;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "", "invoke", "(Lkotlin/DeepRecursiveFunction;Ljava/lang/Object;)Ljava/lang/Void;", "<init>", "()V", "Lkotlin/DeepRecursiveScopeImpl;", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@ExperimentalStdlibApi
@RestrictsSuspension
/* loaded from: classes2.dex */
public abstract class DeepRecursiveScope<T, R> {
    public DeepRecursiveScope() {
    }

    public abstract Object callRecursive(T t, Continuation<? super R> continuation);

    public abstract <U, S> Object callRecursive(DeepRecursiveFunction<U, S> deepRecursiveFunction, U u, Continuation<? super S> continuation);

    @Deprecated(level = DeprecationLevel.ERROR, message = "'invoke' should not be called from DeepRecursiveScope. Use 'callRecursive' to do recursion in the heap instead of the call stack.", replaceWith = @ReplaceWith(expression = "this.callRecursive(value)", imports = {}))
    public final Void invoke(DeepRecursiveFunction<?, ?> invoke, Object obj) {
        Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
        throw new UnsupportedOperationException("Should not be called from DeepRecursiveScope");
    }

    public /* synthetic */ DeepRecursiveScope(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
