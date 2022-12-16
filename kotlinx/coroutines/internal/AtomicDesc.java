package kotlinx.coroutines.internal;

import com.baidu.bdtask.model.response.TaskProcessData;
import com.baidu.sapi2.views.SmsLoginView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\b&\u0018\u0000B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J%\u0010\u0006\u001a\u00020\u00052\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\b\u001a\u0004\u0018\u00010\u00032\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0001H&¢\u0006\u0004\b\b\u0010\tR&\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u00018\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lkotlinx/coroutines/internal/AtomicDesc;", "Lkotlinx/coroutines/internal/AtomicOp;", "op", "", SmsLoginView.f.l, "", TaskProcessData.keyComplete, "(Lkotlinx/coroutines/internal/AtomicOp;Ljava/lang/Object;)V", "prepare", "(Lkotlinx/coroutines/internal/AtomicOp;)Ljava/lang/Object;", "atomicOp", "Lkotlinx/coroutines/internal/AtomicOp;", "getAtomicOp", "()Lkotlinx/coroutines/internal/AtomicOp;", "setAtomicOp", "(Lkotlinx/coroutines/internal/AtomicOp;)V", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes9.dex */
public abstract class AtomicDesc {
    public AtomicOp<?> atomicOp;

    public abstract void complete(AtomicOp<?> atomicOp, Object obj);

    public abstract Object prepare(AtomicOp<?> atomicOp);

    public final AtomicOp<?> getAtomicOp() {
        AtomicOp<?> atomicOp = this.atomicOp;
        if (atomicOp == null) {
            Intrinsics.throwUninitializedPropertyAccessException("atomicOp");
        }
        return atomicOp;
    }

    public final void setAtomicOp(AtomicOp<?> atomicOp) {
        this.atomicOp = atomicOp;
    }
}
