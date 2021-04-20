package d.g.c.i.a;

import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.DirectExecutor;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
/* loaded from: classes6.dex */
public final class n {

    /* loaded from: classes6.dex */
    public static class a implements Executor {

        /* renamed from: e  reason: collision with root package name */
        public boolean f67069e = true;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Executor f67070f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ AbstractFuture f67071g;

        /* renamed from: d.g.c.i.a.n$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC1842a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Runnable f67072e;

            public RunnableC1842a(Runnable runnable) {
                this.f67072e = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f67069e = false;
                this.f67072e.run();
            }
        }

        public a(Executor executor, AbstractFuture abstractFuture) {
            this.f67070f = executor;
            this.f67071g = abstractFuture;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            try {
                this.f67070f.execute(new RunnableC1842a(runnable));
            } catch (RejectedExecutionException e2) {
                if (this.f67069e) {
                    this.f67071g.B(e2);
                }
            }
        }
    }

    public static Executor a() {
        return DirectExecutor.INSTANCE;
    }

    public static Executor b(Executor executor, AbstractFuture<?> abstractFuture) {
        d.g.c.a.n.p(executor);
        d.g.c.a.n.p(abstractFuture);
        return executor == a() ? executor : new a(executor, abstractFuture);
    }
}
