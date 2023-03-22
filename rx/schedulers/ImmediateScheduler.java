package rx.schedulers;

import com.baidu.tieba.rra;
@Deprecated
/* loaded from: classes9.dex */
public final class ImmediateScheduler extends rra {
    @Override // com.baidu.tieba.rra
    public rra.a createWorker() {
        return null;
    }

    public ImmediateScheduler() {
        throw new IllegalStateException("No instances!");
    }
}
