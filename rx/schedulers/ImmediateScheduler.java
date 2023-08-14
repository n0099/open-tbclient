package rx.schedulers;

import com.baidu.tieba.b1c;
@Deprecated
/* loaded from: classes2.dex */
public final class ImmediateScheduler extends b1c {
    @Override // com.baidu.tieba.b1c
    public b1c.a createWorker() {
        return null;
    }

    public ImmediateScheduler() {
        throw new IllegalStateException("No instances!");
    }
}
