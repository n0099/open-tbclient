package rx.schedulers;

import com.baidu.tieba.qmb;
@Deprecated
/* loaded from: classes2.dex */
public final class ImmediateScheduler extends qmb {
    @Override // com.baidu.tieba.qmb
    public qmb.a createWorker() {
        return null;
    }

    public ImmediateScheduler() {
        throw new IllegalStateException("No instances!");
    }
}
