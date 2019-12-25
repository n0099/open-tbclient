package io.reactivex.subscribers;

import com.google.android.exoplayer2.Format;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import java.util.concurrent.atomic.AtomicReference;
import org.a.d;
/* loaded from: classes4.dex */
public abstract class a<T> implements io.reactivex.disposables.b, j<T> {
    final AtomicReference<d> s = new AtomicReference<>();

    @Override // io.reactivex.j, org.a.c
    public final void onSubscribe(d dVar) {
        if (io.reactivex.internal.util.d.a(this.s, dVar, getClass())) {
            onStart();
        }
    }

    protected void onStart() {
        this.s.get().request(Format.OFFSET_SAMPLE_RELATIVE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void cancel() {
        dispose();
    }

    @Override // io.reactivex.disposables.b
    public final boolean isDisposed() {
        return this.s.get() == SubscriptionHelper.CANCELLED;
    }

    @Override // io.reactivex.disposables.b
    public final void dispose() {
        SubscriptionHelper.cancel(this.s);
    }
}
