package rx.schedulers;

import com.baidu.tieba.lmb;
@Deprecated
/* loaded from: classes2.dex */
public final class ImmediateScheduler extends lmb {
    @Override // com.baidu.tieba.lmb
    public lmb.a createWorker() {
        return null;
    }

    public ImmediateScheduler() {
        throw new IllegalStateException("No instances!");
    }
}
