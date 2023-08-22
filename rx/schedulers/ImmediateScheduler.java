package rx.schedulers;

import com.baidu.tieba.q7c;
@Deprecated
/* loaded from: classes2.dex */
public final class ImmediateScheduler extends q7c {
    @Override // com.baidu.tieba.q7c
    public q7c.a createWorker() {
        return null;
    }

    public ImmediateScheduler() {
        throw new IllegalStateException("No instances!");
    }
}
