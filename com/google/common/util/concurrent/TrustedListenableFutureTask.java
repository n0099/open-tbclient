package com.google.common.util.concurrent;

import d.g.c.a.n;
import d.g.c.i.a.c;
import d.g.c.i.a.e;
import d.g.c.i.a.l;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;
/* loaded from: classes6.dex */
public class TrustedListenableFutureTask<V> extends e.a<V> implements RunnableFuture<V> {

    /* loaded from: classes6.dex */
    public final class TrustedFutureInterruptibleAsyncTask extends InterruptibleTask<l<V>> {
        public final c<V> callable;

        public TrustedFutureInterruptibleAsyncTask(c<V> cVar) {
            n.p(cVar);
            this.callable = cVar;
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public /* bridge */ /* synthetic */ void afterRanInterruptibly(Object obj, Throwable th) {
            afterRanInterruptibly((l) ((l) obj), th);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public final boolean isDone() {
            return TrustedListenableFutureTask.this.isDone();
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public String toPendingString() {
            return this.callable.toString();
        }

        public void afterRanInterruptibly(l<V> lVar, Throwable th) {
            if (th == null) {
                TrustedListenableFutureTask.this.C(lVar);
            } else {
                TrustedListenableFutureTask.this.B(th);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.util.concurrent.InterruptibleTask
        public l<V> runInterruptibly() throws Exception {
            l<V> call = this.callable.call();
            n.r(call, "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", this.callable);
            return call;
        }
    }

    /* loaded from: classes6.dex */
    public final class TrustedFutureInterruptibleTask extends InterruptibleTask<V> {
        public final Callable<V> callable;

        public TrustedFutureInterruptibleTask(Callable<V> callable) {
            n.p(callable);
            this.callable = callable;
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public void afterRanInterruptibly(V v, Throwable th) {
            if (th == null) {
                TrustedListenableFutureTask.this.A(v);
            } else {
                TrustedListenableFutureTask.this.B(th);
            }
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public final boolean isDone() {
            return TrustedListenableFutureTask.this.isDone();
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public V runInterruptibly() throws Exception {
            return this.callable.call();
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public String toPendingString() {
            return this.callable.toString();
        }
    }
}
