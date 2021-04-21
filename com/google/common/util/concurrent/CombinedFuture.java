package com.google.common.util.concurrent;

import d.h.c.a.n;
import d.h.c.i.a.b;
import d.h.c.i.a.c;
import d.h.c.i.a.l;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
/* loaded from: classes6.dex */
public final class CombinedFuture<V> extends b<Object, V> {

    /* loaded from: classes6.dex */
    public final class AsyncCallableInterruptibleTask extends CombinedFuture<V>.CombinedFutureInterruptibleTask<l<V>> {
        public final c<V> callable;

        public AsyncCallableInterruptibleTask(c<V> cVar, Executor executor) {
            super(executor);
            n.p(cVar);
            this.callable = cVar;
        }

        @Override // com.google.common.util.concurrent.CombinedFuture.CombinedFutureInterruptibleTask
        public /* bridge */ /* synthetic */ void setValue(Object obj) {
            setValue((l) ((l) obj));
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public String toPendingString() {
            return this.callable.toString();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.util.concurrent.InterruptibleTask
        public l<V> runInterruptibly() throws Exception {
            this.thrownByExecute = false;
            l<V> call = this.callable.call();
            n.r(call, "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", this.callable);
            return call;
        }

        public void setValue(l<V> lVar) {
            CombinedFuture.this.C(lVar);
            CombinedFuture.this.F();
            throw null;
        }
    }

    /* loaded from: classes6.dex */
    public final class CallableInterruptibleTask extends CombinedFuture<V>.CombinedFutureInterruptibleTask<V> {
        public final Callable<V> callable;

        public CallableInterruptibleTask(Callable<V> callable, Executor executor) {
            super(executor);
            n.p(callable);
            this.callable = callable;
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public V runInterruptibly() throws Exception {
            this.thrownByExecute = false;
            return this.callable.call();
        }

        @Override // com.google.common.util.concurrent.CombinedFuture.CombinedFutureInterruptibleTask
        public void setValue(V v) {
            CombinedFuture.this.A(v);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public String toPendingString() {
            return this.callable.toString();
        }
    }

    /* loaded from: classes6.dex */
    public abstract class CombinedFutureInterruptibleTask<T> extends InterruptibleTask<T> {
        public final Executor listenerExecutor;
        public boolean thrownByExecute = true;

        public CombinedFutureInterruptibleTask(Executor executor) {
            n.p(executor);
            this.listenerExecutor = executor;
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public final void afterRanInterruptibly(T t, Throwable th) {
            if (th != null) {
                if (th instanceof ExecutionException) {
                    CombinedFuture.this.B(th.getCause());
                    return;
                } else if (th instanceof CancellationException) {
                    CombinedFuture.this.cancel(false);
                    return;
                } else {
                    CombinedFuture.this.B(th);
                    return;
                }
            }
            setValue(t);
        }

        public final void execute() {
            try {
                this.listenerExecutor.execute(this);
            } catch (RejectedExecutionException e2) {
                if (this.thrownByExecute) {
                    CombinedFuture.this.B(e2);
                }
            }
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public final boolean isDone() {
            return CombinedFuture.this.isDone();
        }

        public abstract void setValue(T t);
    }
}
