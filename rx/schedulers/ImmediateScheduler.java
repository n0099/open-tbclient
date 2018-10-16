package rx.schedulers;

import rx.g;
@Deprecated
/* loaded from: classes2.dex */
public final class ImmediateScheduler extends g {
    private ImmediateScheduler() {
        throw new IllegalStateException("No instances!");
    }

    @Override // rx.g
    public g.a createWorker() {
        return null;
    }
}
