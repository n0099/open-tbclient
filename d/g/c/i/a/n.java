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
        public boolean f70092e = true;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Executor f70093f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ AbstractFuture f70094g;

        /* renamed from: d.g.c.i.a.n$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC1913a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Runnable f70095e;

            public RunnableC1913a(Runnable runnable) {
                this.f70095e = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f70092e = false;
                this.f70095e.run();
            }
        }

        public a(Executor executor, AbstractFuture abstractFuture) {
            this.f70093f = executor;
            this.f70094g = abstractFuture;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            try {
                this.f70093f.execute(new RunnableC1913a(runnable));
            } catch (RejectedExecutionException e2) {
                if (this.f70092e) {
                    this.f70094g.B(e2);
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
