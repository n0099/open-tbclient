package rx.schedulers;

import com.baidu.tieba.m5b;
@Deprecated
/* loaded from: classes9.dex */
public final class ImmediateScheduler extends m5b {
    @Override // com.baidu.tieba.m5b
    public m5b.a createWorker() {
        return null;
    }

    public ImmediateScheduler() {
        throw new IllegalStateException("No instances!");
    }
}
