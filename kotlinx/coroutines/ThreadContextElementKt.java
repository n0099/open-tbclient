package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.internal.ThreadLocalElement;
import kotlinx.coroutines.internal.ThreadLocalKey;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a-\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u0002\u001a\u00028\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001b\u0010\u0007\u001a\u00020\u0006*\u0006\u0012\u0002\b\u00030\u0001H\u0086Hø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u001b\u0010\n\u001a\u00020\t*\u0006\u0012\u0002\b\u00030\u0001H\u0086Hø\u0001\u0000¢\u0006\u0004\b\n\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"T", "Ljava/lang/ThreadLocal;", "value", "Lkotlinx/coroutines/ThreadContextElement;", "asContextElement", "(Ljava/lang/ThreadLocal;Ljava/lang/Object;)Lkotlinx/coroutines/ThreadContextElement;", "", "ensurePresent", "(Ljava/lang/ThreadLocal;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "isPresent", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes10.dex */
public final class ThreadContextElementKt {
    public static final <T> ThreadContextElement<T> asContextElement(ThreadLocal<T> threadLocal, T t) {
        return new ThreadLocalElement(t, threadLocal);
    }

    public static /* synthetic */ ThreadContextElement asContextElement$default(ThreadLocal threadLocal, Object obj, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            obj = threadLocal.get();
        }
        return asContextElement(threadLocal, obj);
    }

    public static final Object ensurePresent(ThreadLocal<?> threadLocal, Continuation<? super Unit> continuation) {
        if (Boxing.boxBoolean(continuation.getContext().get(new ThreadLocalKey(threadLocal)) != null).booleanValue()) {
            return Unit.INSTANCE;
        }
        throw new IllegalStateException(("ThreadLocal " + threadLocal + " is missing from context " + continuation.getContext()).toString());
    }

    public static final Object ensurePresent$$forInline(ThreadLocal threadLocal, Continuation continuation) {
        InlineMarker.mark(3);
        Continuation continuation2 = null;
        if (continuation2.getContext().get(new ThreadLocalKey(threadLocal)) != null) {
            return Unit.INSTANCE;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("ThreadLocal ");
        sb.append(threadLocal);
        sb.append(" is missing from context ");
        InlineMarker.mark(3);
        sb.append(continuation2.getContext());
        throw new IllegalStateException(sb.toString().toString());
    }

    public static final Object isPresent(ThreadLocal<?> threadLocal, Continuation<? super Boolean> continuation) {
        return Boxing.boxBoolean(continuation.getContext().get(new ThreadLocalKey(threadLocal)) != null);
    }

    public static final Object isPresent$$forInline(ThreadLocal threadLocal, Continuation continuation) {
        InlineMarker.mark(3);
        Continuation continuation2 = null;
        return Boolean.valueOf(continuation2.getContext().get(new ThreadLocalKey(threadLocal)) != null);
    }
}
