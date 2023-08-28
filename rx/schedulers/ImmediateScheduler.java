package rx.schedulers;

import com.baidu.tieba.s7c;
@Deprecated
/* loaded from: classes2.dex */
public final class ImmediateScheduler extends s7c {
    @Override // com.baidu.tieba.s7c
    public s7c.a createWorker() {
        return null;
    }

    public ImmediateScheduler() {
        throw new IllegalStateException("No instances!");
    }
}
