package rx.schedulers;

import com.baidu.tieba.vac;
@Deprecated
/* loaded from: classes2.dex */
public final class ImmediateScheduler extends vac {
    @Override // com.baidu.tieba.vac
    public vac.a createWorker() {
        return null;
    }

    public ImmediateScheduler() {
        throw new IllegalStateException("No instances!");
    }
}
