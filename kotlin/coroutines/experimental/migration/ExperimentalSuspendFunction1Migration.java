package kotlin.coroutines.experimental.migration;

import kotlin.Metadata;
import kotlin.coroutines.experimental.Continuation;
import kotlin.jvm.functions.Function2;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B)\u0012 \u0010\f\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00070\n¢\u0006\u0004\b\u0010\u0010\u0011J(\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00028\u00002\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tR3\u0010\f\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00070\n8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lkotlin/coroutines/experimental/migration/ExperimentalSuspendFunction1Migration;", "T1", "R", "Lkotlin/jvm/functions/Function2;", "t1", "Lkotlin/coroutines/experimental/Continuation;", "continuation", "", "invoke", "(Ljava/lang/Object;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "function", "Lkotlin/Function2;", "getFunction", "()Lkotlin/jvm/functions/Function2;", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "kotlin-stdlib-coroutines"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public final class ExperimentalSuspendFunction1Migration<T1, R> implements Function2<T1, Continuation<? super R>, Object> {
    public final Function2<T1, kotlin.coroutines.Continuation<? super R>, Object> function;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.jvm.functions.Function2<? super T1, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> */
    /* JADX WARN: Multi-variable type inference failed */
    public ExperimentalSuspendFunction1Migration(Function2<? super T1, ? super kotlin.coroutines.Continuation<? super R>, ? extends Object> function2) {
        this.function = function2;
    }

    public final Function2<T1, kotlin.coroutines.Continuation<? super R>, Object> getFunction() {
        return this.function;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke((ExperimentalSuspendFunction1Migration<T1, R>) obj, (Continuation) ((Continuation) obj2));
    }

    public Object invoke(T1 t1, Continuation<? super R> continuation) {
        return this.function.invoke(t1, CoroutinesMigrationKt.toContinuation(continuation));
    }
}
