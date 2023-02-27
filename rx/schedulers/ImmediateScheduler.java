package rx.schedulers;

import com.baidu.tieba.vma;
@Deprecated
/* loaded from: classes9.dex */
public final class ImmediateScheduler extends vma {
    @Override // com.baidu.tieba.vma
    public vma.a createWorker() {
        return null;
    }

    public ImmediateScheduler() {
        throw new IllegalStateException("No instances!");
    }
}
