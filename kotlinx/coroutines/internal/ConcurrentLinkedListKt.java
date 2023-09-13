package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\u001a#\u0010\u0002\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000*\u00028\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001ao\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00028\u00000\u0004*\u00028\u00002\u0006\u0010\u0007\u001a\u00020\u000628\u0010\f\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0007\u0012\u0015\u0012\u0013\u0018\u00018\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00028\u00000\bH\u0082\bø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\"\u001a\u0010\u0011\u001a\u00020\u00108\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u0012\u0004\b\u0013\u0010\u0014\"\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "N", "close", "(Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;)Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "Lkotlinx/coroutines/internal/Segment;", ExifInterface.LATITUDE_SOUTH, "", "id", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "prev", "createNewSegment", "Lkotlinx/coroutines/internal/SegmentOrClosed;", "findSegmentInternal", "(Lkotlinx/coroutines/internal/Segment;JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/Symbol;", "CLOSED", "Lkotlinx/coroutines/internal/Symbol;", "getCLOSED$annotations", "()V", "", "POINTERS_SHIFT", "I", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ConcurrentLinkedListKt {
    public static final Symbol CLOSED = new Symbol("CLOSED");
    public static final int POINTERS_SHIFT = 16;

    public static /* synthetic */ void getCLOSED$annotations() {
    }

    /* JADX DEBUG: Method not inlined, still used in: [kotlinx.coroutines.internal.ConcurrentLinkedListNode.getNext():N extends kotlinx.coroutines.internal.ConcurrentLinkedListNode<N>, kotlinx.coroutines.internal.ConcurrentLinkedListNode.markAsClosed():boolean, kotlinx.coroutines.internal.ConcurrentLinkedListNode.nextOrIfClosed(kotlin.jvm.functions.Function0):N extends kotlinx.coroutines.internal.ConcurrentLinkedListNode<N>] */
    public static final /* synthetic */ Symbol access$getCLOSED$p() {
        return CLOSED;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [kotlinx.coroutines.internal.ConcurrentLinkedListNode] */
    public static final <N extends ConcurrentLinkedListNode<N>> N close(N n) {
        while (true) {
            Object nextOrClosed = n.getNextOrClosed();
            if (nextOrClosed == CLOSED) {
                return n;
            }
            ?? r0 = (ConcurrentLinkedListNode) nextOrClosed;
            if (r0 == 0) {
                if (n.markAsClosed()) {
                    return n;
                }
            } else {
                n = r0;
            }
        }
    }

    public static final <S extends Segment<S>> Object findSegmentInternal(S s, long j, Function2<? super Long, ? super S, ? extends S> function2) {
        while (true) {
            if (s.getId() < j || s.getRemoved()) {
                Object nextOrClosed = s.getNextOrClosed();
                if (nextOrClosed == CLOSED) {
                    return SegmentOrClosed.m2348constructorimpl(CLOSED);
                }
                S s2 = (S) ((ConcurrentLinkedListNode) nextOrClosed);
                if (s2 == null) {
                    s2 = function2.invoke(Long.valueOf(s.getId() + 1), s);
                    if (s.trySetNext(s2)) {
                        if (s.getRemoved()) {
                            s.remove();
                        }
                    }
                }
                s = s2;
            } else {
                return SegmentOrClosed.m2348constructorimpl(s);
            }
        }
    }
}
