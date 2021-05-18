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
        public boolean f66318e = true;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Executor f66319f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ AbstractFuture f66320g;

        /* renamed from: d.g.c.i.a.n$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC1850a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Runnable f66321e;

            public RunnableC1850a(Runnable runnable) {
                this.f66321e = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f66318e = false;
                this.f66321e.run();
            }
        }

        public a(Executor executor, AbstractFuture abstractFuture) {
            this.f66319f = executor;
            this.f66320g = abstractFuture;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            try {
                this.f66319f.execute(new RunnableC1850a(runnable));
            } catch (RejectedExecutionException e2) {
                if (this.f66318e) {
                    this.f66320g.B(e2);
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
