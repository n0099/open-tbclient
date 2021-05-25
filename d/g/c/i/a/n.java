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
        public boolean f66361e = true;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Executor f66362f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ AbstractFuture f66363g;

        /* renamed from: d.g.c.i.a.n$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC1854a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Runnable f66364e;

            public RunnableC1854a(Runnable runnable) {
                this.f66364e = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f66361e = false;
                this.f66364e.run();
            }
        }

        public a(Executor executor, AbstractFuture abstractFuture) {
            this.f66362f = executor;
            this.f66363g = abstractFuture;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            try {
                this.f66362f.execute(new RunnableC1854a(runnable));
            } catch (RejectedExecutionException e2) {
                if (this.f66361e) {
                    this.f66363g.B(e2);
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
