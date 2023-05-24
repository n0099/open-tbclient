package rx.schedulers;

import com.baidu.tieba.l7b;
@Deprecated
/* loaded from: classes10.dex */
public final class ImmediateScheduler extends l7b {
    @Override // com.baidu.tieba.l7b
    public l7b.a createWorker() {
        return null;
    }

    public ImmediateScheduler() {
        throw new IllegalStateException("No instances!");
    }
}
