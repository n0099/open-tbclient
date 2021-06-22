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
        public boolean f70196e = true;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Executor f70197f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ AbstractFuture f70198g;

        /* renamed from: d.g.c.i.a.n$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC1916a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Runnable f70199e;

            public RunnableC1916a(Runnable runnable) {
                this.f70199e = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f70196e = false;
                this.f70199e.run();
            }
        }

        public a(Executor executor, AbstractFuture abstractFuture) {
            this.f70197f = executor;
            this.f70198g = abstractFuture;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            try {
                this.f70197f.execute(new RunnableC1916a(runnable));
            } catch (RejectedExecutionException e2) {
                if (this.f70196e) {
                    this.f70198g.B(e2);
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
