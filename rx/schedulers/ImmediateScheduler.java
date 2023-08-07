package rx.schedulers;

import com.baidu.tieba.a1c;
@Deprecated
/* loaded from: classes2.dex */
public final class ImmediateScheduler extends a1c {
    @Override // com.baidu.tieba.a1c
    public a1c.a createWorker() {
        return null;
    }

    public ImmediateScheduler() {
        throw new IllegalStateException("No instances!");
    }
}
