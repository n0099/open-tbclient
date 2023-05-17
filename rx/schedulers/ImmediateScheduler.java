package rx.schedulers;

import com.baidu.tieba.k7b;
@Deprecated
/* loaded from: classes10.dex */
public final class ImmediateScheduler extends k7b {
    @Override // com.baidu.tieba.k7b
    public k7b.a createWorker() {
        return null;
    }

    public ImmediateScheduler() {
        throw new IllegalStateException("No instances!");
    }
}
