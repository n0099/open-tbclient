package rx.schedulers;

import com.baidu.tieba.k6c;
@Deprecated
/* loaded from: classes2.dex */
public final class ImmediateScheduler extends k6c {
    @Override // com.baidu.tieba.k6c
    public k6c.a createWorker() {
        return null;
    }

    public ImmediateScheduler() {
        throw new IllegalStateException("No instances!");
    }
}
