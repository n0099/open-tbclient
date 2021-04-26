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
        public boolean f65632e = true;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Executor f65633f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ AbstractFuture f65634g;

        /* renamed from: d.g.c.i.a.n$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC1786a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Runnable f65635e;

            public RunnableC1786a(Runnable runnable) {
                this.f65635e = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f65632e = false;
                this.f65635e.run();
            }
        }

        public a(Executor executor, AbstractFuture abstractFuture) {
            this.f65633f = executor;
            this.f65634g = abstractFuture;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            try {
                this.f65633f.execute(new RunnableC1786a(runnable));
            } catch (RejectedExecutionException e2) {
                if (this.f65632e) {
                    this.f65634g.B(e2);
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
