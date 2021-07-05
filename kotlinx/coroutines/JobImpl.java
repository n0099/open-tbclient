package kotlinx.coroutines;

import com.baidu.mobads.container.util.XAdRemoteEvent;
import kotlin.Metadata;
import kotlin.Unit;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0003H\u0003¢\u0006\u0004\b\n\u0010\u0005R\u001c\u0010\n\u001a\u00020\u00038\u0010@\u0010X\u0090\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\u0005R\u0016\u0010\u000e\u001a\u00020\u00038P@\u0010X\u0090\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/JobImpl;", "Lkotlinx/coroutines/CompletableJob;", "Lkotlinx/coroutines/JobSupport;", "", XAdRemoteEvent.COMPLETE, "()Z", "", "exception", "completeExceptionally", "(Ljava/lang/Throwable;)Z", "handlesException", "Z", "getHandlesException$kotlinx_coroutines_core", "getOnCancelComplete$kotlinx_coroutines_core", "onCancelComplete", "Lkotlinx/coroutines/Job;", "parent", "<init>", "(Lkotlinx/coroutines/Job;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes10.dex */
public class JobImpl extends JobSupport implements CompletableJob {
    public final boolean handlesException;

    public JobImpl(Job job) {
        super(true);
        initParentJobInternal$kotlinx_coroutines_core(job);
        this.handlesException = handlesException();
    }

    private final boolean handlesException() {
        JobSupport jobSupport;
        ChildHandle parentHandle$kotlinx_coroutines_core = getParentHandle$kotlinx_coroutines_core();
        if (!(parentHandle$kotlinx_coroutines_core instanceof ChildHandleNode)) {
            parentHandle$kotlinx_coroutines_core = null;
        }
        ChildHandleNode childHandleNode = (ChildHandleNode) parentHandle$kotlinx_coroutines_core;
        if (childHandleNode != null && (jobSupport = (JobSupport) childHandleNode.job) != null) {
            while (!jobSupport.getHandlesException$kotlinx_coroutines_core()) {
                ChildHandle parentHandle$kotlinx_coroutines_core2 = jobSupport.getParentHandle$kotlinx_coroutines_core();
                if (!(parentHandle$kotlinx_coroutines_core2 instanceof ChildHandleNode)) {
                    parentHandle$kotlinx_coroutines_core2 = null;
                }
                ChildHandleNode childHandleNode2 = (ChildHandleNode) parentHandle$kotlinx_coroutines_core2;
                if (childHandleNode2 != null) {
                    jobSupport = (JobSupport) childHandleNode2.job;
                    if (jobSupport == null) {
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override // kotlinx.coroutines.CompletableJob
    public boolean complete() {
        return makeCompleting$kotlinx_coroutines_core(Unit.INSTANCE);
    }

    @Override // kotlinx.coroutines.CompletableJob
    public boolean completeExceptionally(Throwable th) {
        return makeCompleting$kotlinx_coroutines_core(new CompletedExceptionally(th, false, 2, null));
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean getHandlesException$kotlinx_coroutines_core() {
        return this.handlesException;
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean getOnCancelComplete$kotlinx_coroutines_core() {
        return true;
    }
}
