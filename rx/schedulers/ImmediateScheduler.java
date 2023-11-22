package rx.schedulers;

import com.baidu.tieba.mjc;
@Deprecated
/* loaded from: classes2.dex */
public final class ImmediateScheduler extends mjc {
    @Override // com.baidu.tieba.mjc
    public mjc.a createWorker() {
        return null;
    }

    public ImmediateScheduler() {
        throw new IllegalStateException("No instances!");
    }
}
