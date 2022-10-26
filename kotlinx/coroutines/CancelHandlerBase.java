package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b \u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H¦\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/CancelHandlerBase;", "Lkotlin/jvm/functions/Function1;", "", "cause", "", "invoke", "(Ljava/lang/Throwable;)V", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public abstract class CancelHandlerBase implements Function1 {
    public abstract void invoke(Throwable th);
}
