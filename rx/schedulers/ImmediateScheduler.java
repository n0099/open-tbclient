package rx.schedulers;

import com.baidu.tieba.hoc;
@Deprecated
/* loaded from: classes2.dex */
public final class ImmediateScheduler extends hoc {
    @Override // com.baidu.tieba.hoc
    public hoc.a createWorker() {
        return null;
    }

    public ImmediateScheduler() {
        throw new IllegalStateException("No instances!");
    }
}
