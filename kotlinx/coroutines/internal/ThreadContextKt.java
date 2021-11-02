package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ThreadContextElement;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a!\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a#\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0000¢\u0006\u0004\b\n\u0010\u000b\"\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e\",\u0010\u0011\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012\"4\u0010\u0014\u001a \u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u0013\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00130\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012\"(\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00150\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0012\"(\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00150\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0012¨\u0006\u0018"}, d2 = {"Lkotlin/coroutines/CoroutineContext;", "context", "", "oldState", "", "restoreThreadContext", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)V", "threadContextElements", "(Lkotlin/coroutines/CoroutineContext;)Ljava/lang/Object;", "countOrElement", "updateThreadContext", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/Symbol;", "ZERO", "Lkotlinx/coroutines/internal/Symbol;", "Lkotlin/Function2;", "Lkotlin/coroutines/CoroutineContext$Element;", "countAll", "Lkotlin/Function2;", "Lkotlinx/coroutines/ThreadContextElement;", "findOne", "Lkotlinx/coroutines/internal/ThreadState;", "restoreState", "updateState", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class ThreadContextKt {
    public static final Symbol ZERO = new Symbol("ZERO");
    public static final Function2<Object, CoroutineContext.Element, Object> countAll = ThreadContextKt$countAll$1.INSTANCE;
    public static final Function2<ThreadContextElement<?>, CoroutineContext.Element, ThreadContextElement<?>> findOne = ThreadContextKt$findOne$1.INSTANCE;
    public static final Function2<ThreadState, CoroutineContext.Element, ThreadState> updateState = ThreadContextKt$updateState$1.INSTANCE;
    public static final Function2<ThreadState, CoroutineContext.Element, ThreadState> restoreState = ThreadContextKt$restoreState$1.INSTANCE;

    public static final void restoreThreadContext(CoroutineContext coroutineContext, Object obj) {
        if (obj == ZERO) {
            return;
        }
        if (obj instanceof ThreadState) {
            ((ThreadState) obj).start();
            coroutineContext.fold(obj, restoreState);
            return;
        }
        Object fold = coroutineContext.fold(null, findOne);
        if (fold != null) {
            ((ThreadContextElement) fold).restoreThreadContext(coroutineContext, obj);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
    }

    public static final Object threadContextElements(CoroutineContext coroutineContext) {
        Object fold = coroutineContext.fold(0, countAll);
        if (fold == null) {
            Intrinsics.throwNpe();
        }
        return fold;
    }

    public static final Object updateThreadContext(CoroutineContext coroutineContext, Object obj) {
        if (obj == null) {
            obj = threadContextElements(coroutineContext);
        }
        if (obj == 0) {
            return ZERO;
        }
        if (obj instanceof Integer) {
            return coroutineContext.fold(new ThreadState(coroutineContext, ((Number) obj).intValue()), updateState);
        }
        if (obj != null) {
            return ((ThreadContextElement) obj).updateThreadContext(coroutineContext);
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
    }
}
