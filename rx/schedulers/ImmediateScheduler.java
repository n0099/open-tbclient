package rx.schedulers;

import com.baidu.tieba.job;
@Deprecated
/* loaded from: classes2.dex */
public final class ImmediateScheduler extends job {
    @Override // com.baidu.tieba.job
    public job.a createWorker() {
        return null;
    }

    public ImmediateScheduler() {
        throw new IllegalStateException("No instances!");
    }
}
