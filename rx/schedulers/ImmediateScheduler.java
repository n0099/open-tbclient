package rx.schedulers;

import com.baidu.tieba.ljc;
@Deprecated
/* loaded from: classes2.dex */
public final class ImmediateScheduler extends ljc {
    @Override // com.baidu.tieba.ljc
    public ljc.a createWorker() {
        return null;
    }

    public ImmediateScheduler() {
        throw new IllegalStateException("No instances!");
    }
}
