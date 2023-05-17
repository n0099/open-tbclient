package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.internal.Symbol;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\u001a\u0017\u0010\u0001\u001a\u0004\u0018\u00010\u0000*\u0004\u0018\u00010\u0000H\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u0017\u0010\u0003\u001a\u0004\u0018\u00010\u0000*\u0004\u0018\u00010\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0002\"\u001c\u0010\u0005\u001a\u00020\u00048\u0002@\u0003X\u0083\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\u0007\u0010\b\"\u001c\u0010\t\u001a\u00020\u00048\u0002@\u0003X\u0083\u0004¢\u0006\f\n\u0004\b\t\u0010\u0006\u0012\u0004\b\n\u0010\b\"\u001c\u0010\u000b\u001a\u00020\u00048\u0000@\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0006\u0012\u0004\b\f\u0010\b\"\u001c\u0010\u000e\u001a\u00020\r8\u0002@\u0003X\u0083\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u0012\u0004\b\u0010\u0010\b\"\u001c\u0010\u0011\u001a\u00020\r8\u0002@\u0003X\u0083\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u000f\u0012\u0004\b\u0012\u0010\b\"\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015\"\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015\"\u001c\u0010\u0017\u001a\u00020\u00048\u0002@\u0003X\u0083\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0006\u0012\u0004\b\u0018\u0010\b\"\u001c\u0010\u0019\u001a\u00020\u00048\u0002@\u0003X\u0083\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0006\u0012\u0004\b\u001a\u0010\b\"\u0016\u0010\u001b\u001a\u00020\u00138\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001b\u0010\u0015¨\u0006\u001c"}, d2 = {"", "boxIncomplete", "(Ljava/lang/Object;)Ljava/lang/Object;", "unboxState", "Lkotlinx/coroutines/internal/Symbol;", "COMPLETING_ALREADY", "Lkotlinx/coroutines/internal/Symbol;", "COMPLETING_ALREADY$annotations", "()V", "COMPLETING_RETRY", "COMPLETING_RETRY$annotations", "COMPLETING_WAITING_CHILDREN", "COMPLETING_WAITING_CHILDREN$annotations", "Lkotlinx/coroutines/Empty;", "EMPTY_ACTIVE", "Lkotlinx/coroutines/Empty;", "EMPTY_ACTIVE$annotations", "EMPTY_NEW", "EMPTY_NEW$annotations", "", "FALSE", "I", "RETRY", "SEALED", "SEALED$annotations", "TOO_LATE_TO_CANCEL", "TOO_LATE_TO_CANCEL$annotations", "TRUE", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes10.dex */
public final class JobSupportKt {
    public static final int FALSE = 0;
    public static final int RETRY = -1;
    public static final int TRUE = 1;
    public static final Symbol COMPLETING_ALREADY = new Symbol("COMPLETING_ALREADY");
    @JvmField
    public static final Symbol COMPLETING_WAITING_CHILDREN = new Symbol("COMPLETING_WAITING_CHILDREN");
    public static final Symbol COMPLETING_RETRY = new Symbol("COMPLETING_RETRY");
    public static final Symbol TOO_LATE_TO_CANCEL = new Symbol("TOO_LATE_TO_CANCEL");
    public static final Symbol SEALED = new Symbol("SEALED");
    public static final Empty EMPTY_NEW = new Empty(false);
    public static final Empty EMPTY_ACTIVE = new Empty(true);

    public static /* synthetic */ void COMPLETING_ALREADY$annotations() {
    }

    public static /* synthetic */ void COMPLETING_RETRY$annotations() {
    }

    public static /* synthetic */ void COMPLETING_WAITING_CHILDREN$annotations() {
    }

    public static /* synthetic */ void EMPTY_ACTIVE$annotations() {
    }

    public static /* synthetic */ void EMPTY_NEW$annotations() {
    }

    public static /* synthetic */ void SEALED$annotations() {
    }

    public static /* synthetic */ void TOO_LATE_TO_CANCEL$annotations() {
    }

    public static final Object boxIncomplete(Object obj) {
        if (obj instanceof Incomplete) {
            return new IncompleteStateBox((Incomplete) obj);
        }
        return obj;
    }

    public static final Object unboxState(Object obj) {
        Object obj2;
        Incomplete incomplete;
        if (!(obj instanceof IncompleteStateBox)) {
            obj2 = null;
        } else {
            obj2 = obj;
        }
        IncompleteStateBox incompleteStateBox = (IncompleteStateBox) obj2;
        if (incompleteStateBox != null && (incomplete = incompleteStateBox.state) != null) {
            return incomplete;
        }
        return obj;
    }
}
