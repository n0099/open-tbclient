package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.internal.Symbol;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0017\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0017\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0005\u0010\u0003\"\u001c\u0010\u0007\u001a\u00020\u00068\u0002@\u0003X\u0083\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u0012\u0004\b\t\u0010\n\"\u001c\u0010\u000b\u001a\u00020\u00068\u0002@\u0003X\u0083\u0004¢\u0006\f\n\u0004\b\u000b\u0010\b\u0012\u0004\b\f\u0010\n\"\u0016\u0010\r\u001a\u00020\u00008\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000e\"\u0016\u0010\u000f\u001a\u00020\u00008\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000e\"\u0016\u0010\u0010\u001a\u00020\u00008\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000e\"\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013\"\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0013\"\u0016\u0010\u0015\u001a\u00020\u00118\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0013*\u001e\b\u0002\u0010\u0018\u001a\u0004\b\u0000\u0010\u0016\"\b\u0012\u0004\u0012\u00028\u00000\u00172\b\u0012\u0004\u0012\u00028\u00000\u0017¨\u0006\u0019"}, d2 = {"", "timeNanos", "delayNanosToMillis", "(J)J", "timeMillis", "delayToNanos", "Lkotlinx/coroutines/internal/Symbol;", "CLOSED_EMPTY", "Lkotlinx/coroutines/internal/Symbol;", "CLOSED_EMPTY$annotations", "()V", "DISPOSED_TASK", "DISPOSED_TASK$annotations", "MAX_DELAY_NS", "J", "MAX_MS", "MS_TO_NS", "", "SCHEDULE_COMPLETED", "I", "SCHEDULE_DISPOSED", "SCHEDULE_OK", "T", "Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "Queue", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public final class EventLoop_commonKt {
    public static final long MAX_DELAY_NS = 4611686018427387903L;
    public static final long MAX_MS = 9223372036854L;
    public static final long MS_TO_NS = 1000000;
    public static final int SCHEDULE_COMPLETED = 1;
    public static final int SCHEDULE_DISPOSED = 2;
    public static final int SCHEDULE_OK = 0;
    public static final Symbol DISPOSED_TASK = new Symbol("REMOVED_TASK");
    public static final Symbol CLOSED_EMPTY = new Symbol("CLOSED_EMPTY");

    public static /* synthetic */ void CLOSED_EMPTY$annotations() {
    }

    public static /* synthetic */ void DISPOSED_TASK$annotations() {
    }

    public static final long delayNanosToMillis(long j) {
        return j / 1000000;
    }

    public static final long delayToNanos(long j) {
        if (j <= 0) {
            return 0L;
        }
        if (j >= MAX_MS) {
            return Long.MAX_VALUE;
        }
        return 1000000 * j;
    }
}
