package kotlinx.coroutines.internal;

import com.baidu.tbadk.core.data.SmallTailInfo;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0081\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0014\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002HÂ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001e\u0010\u0006\u001a\u00020\u00002\f\b\u0002\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0013¨\u0006\u0016"}, d2 = {"Lkotlinx/coroutines/internal/ThreadLocalKey;", "kotlin/coroutines/CoroutineContext$Key", "Ljava/lang/ThreadLocal;", "component1", "()Ljava/lang/ThreadLocal;", "threadLocal", "copy", "(Ljava/lang/ThreadLocal;)Lkotlinx/coroutines/internal/ThreadLocalKey;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/lang/ThreadLocal;", "<init>", "(Ljava/lang/ThreadLocal;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@PublishedApi
/* loaded from: classes7.dex */
public final class ThreadLocalKey implements CoroutineContext.Key<ThreadLocalElement<?>> {
    public final ThreadLocal<?> threadLocal;

    public ThreadLocalKey(ThreadLocal<?> threadLocal) {
        this.threadLocal = threadLocal;
    }

    private final ThreadLocal<?> component1() {
        return this.threadLocal;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: kotlinx.coroutines.internal.ThreadLocalKey */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ThreadLocalKey copy$default(ThreadLocalKey threadLocalKey, ThreadLocal threadLocal, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            threadLocal = threadLocalKey.threadLocal;
        }
        return threadLocalKey.copy(threadLocal);
    }

    public final ThreadLocalKey copy(ThreadLocal<?> threadLocal) {
        return new ThreadLocalKey(threadLocal);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof ThreadLocalKey) && Intrinsics.areEqual(this.threadLocal, ((ThreadLocalKey) obj).threadLocal);
        }
        return true;
    }

    public int hashCode() {
        ThreadLocal<?> threadLocal = this.threadLocal;
        if (threadLocal != null) {
            return threadLocal.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "ThreadLocalKey(threadLocal=" + this.threadLocal + SmallTailInfo.EMOTION_SUFFIX;
    }
}
