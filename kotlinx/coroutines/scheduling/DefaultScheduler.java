package kotlinx.coroutines.scheduling;

import kotlin.Metadata;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DispatchersKt;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.internal.SystemPropsKt;
import kotlinx.coroutines.internal.SystemPropsKt__SystemProps_commonKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\u0007R\u0019\u0010\n\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lkotlinx/coroutines/scheduling/DefaultScheduler;", "Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "", "close", "()V", "", "toDebugString", "()Ljava/lang/String;", "toString", "Lkotlinx/coroutines/CoroutineDispatcher;", "IO", "Lkotlinx/coroutines/CoroutineDispatcher;", "getIO", "()Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public final class DefaultScheduler extends ExperimentalCoroutineDispatcher {
    public static final DefaultScheduler INSTANCE;
    public static final CoroutineDispatcher IO;

    @Override // kotlinx.coroutines.scheduling.ExperimentalCoroutineDispatcher, kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        return TasksKt.DEFAULT_SCHEDULER_NAME;
    }

    static {
        int systemProp$default;
        DefaultScheduler defaultScheduler = new DefaultScheduler();
        INSTANCE = defaultScheduler;
        systemProp$default = SystemPropsKt__SystemProps_commonKt.systemProp$default(DispatchersKt.IO_PARALLELISM_PROPERTY_NAME, RangesKt___RangesKt.coerceAtLeast(64, SystemPropsKt.getAVAILABLE_PROCESSORS()), 0, 0, 12, (Object) null);
        IO = defaultScheduler.blocking(systemProp$default);
    }

    public DefaultScheduler() {
        super(0, 0, null, 7, null);
    }

    @Override // kotlinx.coroutines.scheduling.ExperimentalCoroutineDispatcher, kotlinx.coroutines.ExecutorCoroutineDispatcher, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new UnsupportedOperationException("DefaultDispatcher cannot be closed");
    }

    public final CoroutineDispatcher getIO() {
        return IO;
    }

    @InternalCoroutinesApi
    public final String toDebugString() {
        return super.toString();
    }
}
