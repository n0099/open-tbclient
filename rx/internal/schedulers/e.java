package rx.internal.schedulers;

import java.util.concurrent.TimeUnit;
import rx.g;
import rx.k;
/* loaded from: classes6.dex */
public final class e extends rx.g {
    public static final e ofs = new e();

    private e() {
    }

    @Override // rx.g
    public g.a createWorker() {
        return new a();
    }

    /* loaded from: classes6.dex */
    final class a extends g.a implements k {
        final rx.subscriptions.a oft = new rx.subscriptions.a();

        a() {
        }

        @Override // rx.g.a
        public k a(rx.functions.a aVar, long j, TimeUnit timeUnit) {
            return c(new i(aVar, this, e.this.now() + timeUnit.toMillis(j)));
        }

        @Override // rx.g.a
        public k c(rx.functions.a aVar) {
            aVar.call();
            return rx.subscriptions.e.dVO();
        }

        @Override // rx.k
        public void unsubscribe() {
            this.oft.unsubscribe();
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.oft.isUnsubscribed();
        }
    }
}
