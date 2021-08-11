package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0002\u001a\u00020\u00018\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lkotlinx/coroutines/IncompleteStateBox;", "Lkotlinx/coroutines/Incomplete;", "state", "Lkotlinx/coroutines/Incomplete;", "<init>", "(Lkotlinx/coroutines/Incomplete;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class IncompleteStateBox {
    @JvmField
    public final Incomplete state;

    public IncompleteStateBox(Incomplete incomplete) {
        this.state = incomplete;
    }
}
