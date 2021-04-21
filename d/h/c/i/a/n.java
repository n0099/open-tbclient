package d.h.c.i.a;

import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.DirectExecutor;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
/* loaded from: classes6.dex */
public final class n {

    /* loaded from: classes6.dex */
    public static class a implements Executor {

        /* renamed from: e  reason: collision with root package name */
        public boolean f67216e = true;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Executor f67217f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ AbstractFuture f67218g;

        /* renamed from: d.h.c.i.a.n$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC1846a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Runnable f67219e;

            public RunnableC1846a(Runnable runnable) {
                this.f67219e = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f67216e = false;
                this.f67219e.run();
            }
        }

        public a(Executor executor, AbstractFuture abstractFuture) {
            this.f67217f = executor;
            this.f67218g = abstractFuture;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            try {
                this.f67217f.execute(new RunnableC1846a(runnable));
            } catch (RejectedExecutionException e2) {
                if (this.f67216e) {
                    this.f67218g.B(e2);
                }
            }
        }
    }

    public static Executor a() {
        return DirectExecutor.INSTANCE;
    }

    public static Executor b(Executor executor, AbstractFuture<?> abstractFuture) {
        d.h.c.a.n.p(executor);
        d.h.c.a.n.p(abstractFuture);
        return executor == a() ? executor : new a(executor, abstractFuture);
    }
}
