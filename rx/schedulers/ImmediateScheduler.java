package rx.schedulers;

import com.baidu.tieba.x1c;
@Deprecated
/* loaded from: classes2.dex */
public final class ImmediateScheduler extends x1c {
    @Override // com.baidu.tieba.x1c
    public x1c.a createWorker() {
        return null;
    }

    public ImmediateScheduler() {
        throw new IllegalStateException("No instances!");
    }
}
