package rx.internal.operators;

import h.d;
import h.e;
import h.j;
import h.t.d;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes8.dex */
public final class BufferUntilSubscriber<T> extends d<T, T> {

    /* renamed from: h  reason: collision with root package name */
    public static final e f72369h = new a();

    /* renamed from: f  reason: collision with root package name */
    public final State<T> f72370f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f72371g;

    /* loaded from: classes8.dex */
    public static final class State<T> extends AtomicReference<e<? super T>> {
        public static final long serialVersionUID = 8026705089538090368L;
        public boolean emitting;
        public final Object guard = new Object();
        public final ConcurrentLinkedQueue<Object> buffer = new ConcurrentLinkedQueue<>();

        public boolean casObserverRef(e<? super T> eVar, e<? super T> eVar2) {
            return compareAndSet(eVar, eVar2);
        }
    }

    /* loaded from: classes8.dex */
    public static class a implements e {
        @Override // h.e
        public void onCompleted() {
        }

        @Override // h.e
        public void onError(Throwable th) {
        }

        @Override // h.e
        public void onNext(Object obj) {
        }
    }

    /* loaded from: classes8.dex */
    public static final class b<T> implements d.a<T> {

        /* renamed from: e  reason: collision with root package name */
        public final State<T> f72372e;

        /* loaded from: classes8.dex */
        public class a implements h.n.a {
            public a() {
            }

            @Override // h.n.a
            public void call() {
                b.this.f72372e.set(BufferUntilSubscriber.f72369h);
            }
        }

        public b(State<T> state) {
            this.f72372e = state;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(j<? super T> jVar) {
            boolean z;
            if (this.f72372e.casObserverRef(null, jVar)) {
                jVar.add(h.u.e.a(new a()));
                synchronized (this.f72372e.guard) {
                    z = true;
                    if (this.f72372e.emitting) {
                        z = false;
                    } else {
                        this.f72372e.emitting = true;
                    }
                }
                if (!z) {
                    return;
                }
                while (true) {
                    Object poll = this.f72372e.buffer.poll();
                    if (poll != null) {
                        NotificationLite.a(this.f72372e.get(), poll);
                    } else {
                        synchronized (this.f72372e.guard) {
                            if (this.f72372e.buffer.isEmpty()) {
                                this.f72372e.emitting = false;
                                return;
                            }
                        }
                    }
                }
            } else {
                jVar.onError(new IllegalStateException("Only one subscriber allowed!"));
            }
        }
    }

    public BufferUntilSubscriber(State<T> state) {
        super(new b(state));
        this.f72370f = state;
    }

    public static <T> BufferUntilSubscriber<T> K() {
        return new BufferUntilSubscriber<>(new State());
    }

    public final void L(Object obj) {
        synchronized (this.f72370f.guard) {
            this.f72370f.buffer.add(obj);
            if (this.f72370f.get() != null && !this.f72370f.emitting) {
                this.f72371g = true;
                this.f72370f.emitting = true;
            }
        }
        if (!this.f72371g) {
            return;
        }
        while (true) {
            Object poll = this.f72370f.buffer.poll();
            if (poll == null) {
                return;
            }
            NotificationLite.a(this.f72370f.get(), poll);
        }
    }

    @Override // h.e
    public void onCompleted() {
        if (this.f72371g) {
            this.f72370f.get().onCompleted();
        } else {
            L(NotificationLite.b());
        }
    }

    @Override // h.e
    public void onError(Throwable th) {
        if (this.f72371g) {
            this.f72370f.get().onError(th);
        } else {
            L(NotificationLite.c(th));
        }
    }

    @Override // h.e
    public void onNext(T t) {
        if (this.f72371g) {
            this.f72370f.get().onNext(t);
        } else {
            L(NotificationLite.h(t));
        }
    }
}
