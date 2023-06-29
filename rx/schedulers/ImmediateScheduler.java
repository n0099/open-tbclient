package rx.schedulers;

import com.baidu.tieba.atb;
@Deprecated
/* loaded from: classes2.dex */
public final class ImmediateScheduler extends atb {
    @Override // com.baidu.tieba.atb
    public atb.a createWorker() {
        return null;
    }

    public ImmediateScheduler() {
        throw new IllegalStateException("No instances!");
    }
}
