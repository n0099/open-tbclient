package f.a.e0;

import f.a.g;
import f.a.t.b;
import g.d.d;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public abstract class a<T> implements g<T>, b {

    /* renamed from: e  reason: collision with root package name */
    public final AtomicReference<d> f67457e = new AtomicReference<>();

    public final void a() {
        dispose();
    }

    public void b() {
        this.f67457e.get().request(Long.MAX_VALUE);
    }

    @Override // f.a.t.b
    public final void dispose() {
        SubscriptionHelper.cancel(this.f67457e);
    }

    @Override // f.a.t.b
    public final boolean isDisposed() {
        return this.f67457e.get() == SubscriptionHelper.CANCELLED;
    }

    @Override // f.a.g, g.d.c
    public final void onSubscribe(d dVar) {
        if (f.a.x.i.d.d(this.f67457e, dVar, getClass())) {
            b();
        }
    }
}
