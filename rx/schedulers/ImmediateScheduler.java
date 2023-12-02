package rx.schedulers;

import com.baidu.tieba.goc;
@Deprecated
/* loaded from: classes2.dex */
public final class ImmediateScheduler extends goc {
    @Override // com.baidu.tieba.goc
    public goc.a createWorker() {
        return null;
    }

    public ImmediateScheduler() {
        throw new IllegalStateException("No instances!");
    }
}
