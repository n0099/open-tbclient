package rx.schedulers;

import com.baidu.tieba.ncc;
@Deprecated
/* loaded from: classes2.dex */
public final class ImmediateScheduler extends ncc {
    @Override // com.baidu.tieba.ncc
    public ncc.a createWorker() {
        return null;
    }

    public ImmediateScheduler() {
        throw new IllegalStateException("No instances!");
    }
}
