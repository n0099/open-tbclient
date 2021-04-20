package f.b.e0;

import f.b.g;
import f.b.t.b;
import g.d.d;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public abstract class a<T> implements g<T>, b {

    /* renamed from: e  reason: collision with root package name */
    public final AtomicReference<d> f68463e = new AtomicReference<>();

    public final void a() {
        dispose();
    }

    public void b() {
        this.f68463e.get().request(Long.MAX_VALUE);
    }

    @Override // f.b.t.b
    public final void dispose() {
        SubscriptionHelper.cancel(this.f68463e);
    }

    @Override // f.b.t.b
    public final boolean isDisposed() {
        return this.f68463e.get() == SubscriptionHelper.CANCELLED;
    }

    @Override // f.b.g, g.d.c
    public final void onSubscribe(d dVar) {
        if (f.b.x.i.d.d(this.f68463e, dVar, getClass())) {
            b();
        }
    }
}
