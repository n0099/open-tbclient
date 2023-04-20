package rx.schedulers;

import com.baidu.tieba.q1b;
@Deprecated
/* loaded from: classes9.dex */
public final class ImmediateScheduler extends q1b {
    @Override // com.baidu.tieba.q1b
    public q1b.a createWorker() {
        return null;
    }

    public ImmediateScheduler() {
        throw new IllegalStateException("No instances!");
    }
}
