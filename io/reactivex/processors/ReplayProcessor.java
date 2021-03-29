package io.reactivex.processors;

import f.a.x.i.b;
import g.d.c;
import g.d.d;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class ReplayProcessor<T> extends f.a.b0.a<T> {

    /* renamed from: f  reason: collision with root package name */
    public final a<T> f68103f;

    /* loaded from: classes7.dex */
    public static final class Node<T> extends AtomicReference<Node<T>> {
        public static final long serialVersionUID = 6404226426336033100L;
        public final T value;

        public Node(T t) {
            this.value = t;
        }
    }

    /* loaded from: classes7.dex */
    public static final class ReplaySubscription<T> extends AtomicInteger implements d {
        public static final long serialVersionUID = 466549804534799122L;
        public final c<? super T> actual;
        public volatile boolean cancelled;
        public long emitted;
        public Object index;
        public final AtomicLong requested = new AtomicLong();
        public final ReplayProcessor<T> state;

        public ReplaySubscription(c<? super T> cVar, ReplayProcessor<T> replayProcessor) {
            this.actual = cVar;
            this.state = replayProcessor;
        }

        @Override // g.d.d
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.state.d(this);
        }

        @Override // g.d.d
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                b.a(this.requested, j);
                this.state.f68103f.a(this);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class TimedNode<T> extends AtomicReference<TimedNode<T>> {
        public static final long serialVersionUID = 6404226426336033100L;
        public final long time;
        public final T value;

        public TimedNode(T t, long j) {
            this.value = t;
            this.time = j;
        }
    }

    /* loaded from: classes7.dex */
    public interface a<T> {
        void a(ReplaySubscription<T> replaySubscription);
    }

    public abstract void d(ReplaySubscription<T> replaySubscription);
}
