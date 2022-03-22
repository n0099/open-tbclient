package kotlinx.coroutines.test;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.internal.ThreadSafeHeap;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B'\u0012\n\u0010\t\u001a\u00060\u0002j\u0002`\u001e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010 \u001a\u00020\u000e¢\u0006\u0004\b!\u0010\"J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R(\u0010\u0012\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00118\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\u00020\u00058\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\t\u001a\u00060\u0002j\u0002`\u001e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001fR\u0016\u0010 \u001a\u00020\u000e8\u0000@\u0001X\u0081\u0004¢\u0006\u0006\n\u0004\b \u0010\u0010¨\u0006#"}, d2 = {"Lkotlinx/coroutines/test/TimedRunnableObsolete;", "Ljava/lang/Comparable;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "other", "", "compareTo", "(Lkotlinx/coroutines/test/TimedRunnableObsolete;)I", "", "run", "()V", "", "toString", "()Ljava/lang/String;", "", "count", "J", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "heap", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "getHeap", "()Lkotlinx/coroutines/internal/ThreadSafeHeap;", "setHeap", "(Lkotlinx/coroutines/internal/ThreadSafeHeap;)V", "index", "I", "getIndex", "()I", "setIndex", "(I)V", "Lkotlinx/coroutines/Runnable;", "Ljava/lang/Runnable;", "time", "<init>", "(Ljava/lang/Runnable;JJ)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public final class TimedRunnableObsolete implements Comparable<TimedRunnableObsolete>, Runnable, ThreadSafeHeapNode {
    public final long count;
    public ThreadSafeHeap<?> heap;
    public int index;
    public final Runnable run;
    @JvmField
    public final long time;

    public TimedRunnableObsolete(Runnable runnable, long j, long j2) {
        this.run = runnable;
        this.count = j;
        this.time = j2;
    }

    @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
    public ThreadSafeHeap<?> getHeap() {
        return this.heap;
    }

    @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
    public int getIndex() {
        return this.index;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.run.run();
    }

    @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
    public void setHeap(ThreadSafeHeap<?> threadSafeHeap) {
        this.heap = threadSafeHeap;
    }

    @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
    public void setIndex(int i) {
        this.index = i;
    }

    public String toString() {
        return "TimedRunnable(time=" + this.time + ", run=" + this.run + ')';
    }

    public /* synthetic */ TimedRunnableObsolete(Runnable runnable, long j, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(runnable, (i & 2) != 0 ? 0L : j, (i & 4) != 0 ? 0L : j2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    public int compareTo(TimedRunnableObsolete timedRunnableObsolete) {
        long j = this.time;
        long j2 = timedRunnableObsolete.time;
        if (j == j2) {
            j = this.count;
            j2 = timedRunnableObsolete.count;
        }
        return (j > j2 ? 1 : (j == j2 ? 0 : -1));
    }
}
