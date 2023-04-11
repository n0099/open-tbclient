package rx.schedulers;

import com.baidu.tieba.i1b;
@Deprecated
/* loaded from: classes9.dex */
public final class ImmediateScheduler extends i1b {
    @Override // com.baidu.tieba.i1b
    public i1b.a createWorker() {
        return null;
    }

    public ImmediateScheduler() {
        throw new IllegalStateException("No instances!");
    }
}
