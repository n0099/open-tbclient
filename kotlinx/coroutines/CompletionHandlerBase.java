package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b \u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H¦\u0002¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lkotlinx/coroutines/CompletionHandlerBase;", "Lkotlin/jvm/functions/Function1;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "", "cause", "", "invoke", "(Ljava/lang/Throwable;)V", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public abstract class CompletionHandlerBase extends LockFreeLinkedListNode implements Function1<Throwable, Unit> {
    public abstract void invoke(Throwable th);
}
