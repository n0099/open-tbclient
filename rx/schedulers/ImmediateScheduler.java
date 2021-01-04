package rx.schedulers;

import rx.g;
@Deprecated
/* loaded from: classes15.dex */
public final class ImmediateScheduler extends g {
    private ImmediateScheduler() {
        throw new IllegalStateException("No instances!");
    }

    @Override // rx.g
    public g.a createWorker() {
        return null;
    }
}
