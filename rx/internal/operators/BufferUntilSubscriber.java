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
    public static final e f72473h = new a();

    /* renamed from: f  reason: collision with root package name */
    public final State<T> f72474f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f72475g;

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
        public final State<T> f72476e;

        /* loaded from: classes8.dex */
        public class a implements h.n.a {
            public a() {
            }

            @Override // h.n.a
            public void call() {
                b.this.f72476e.set(BufferUntilSubscriber.f72473h);
            }
        }

        public b(State<T> state) {
            this.f72476e = state;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(j<? super T> jVar) {
            boolean z;
            if (this.f72476e.casObserverRef(null, jVar)) {
                jVar.add(h.u.e.a(new a()));
                synchronized (this.f72476e.guard) {
                    z = true;
                    if (this.f72476e.emitting) {
                        z = false;
                    } else {
                        this.f72476e.emitting = true;
                    }
                }
                if (!z) {
                    return;
                }
                while (true) {
                    Object poll = this.f72476e.buffer.poll();
                    if (poll != null) {
                        NotificationLite.a(this.f72476e.get(), poll);
                    } else {
                        synchronized (this.f72476e.guard) {
                            if (this.f72476e.buffer.isEmpty()) {
                                this.f72476e.emitting = false;
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
        this.f72474f = state;
    }

    public static <T> BufferUntilSubscriber<T> K() {
        return new BufferUntilSubscriber<>(new State());
    }

    public final void L(Object obj) {
        synchronized (this.f72474f.guard) {
            this.f72474f.buffer.add(obj);
            if (this.f72474f.get() != null && !this.f72474f.emitting) {
                this.f72475g = true;
                this.f72474f.emitting = true;
            }
        }
        if (!this.f72475g) {
            return;
        }
        while (true) {
            Object poll = this.f72474f.buffer.poll();
            if (poll == null) {
                return;
            }
            NotificationLite.a(this.f72474f.get(), poll);
        }
    }

    @Override // h.e
    public void onCompleted() {
        if (this.f72475g) {
            this.f72474f.get().onCompleted();
        } else {
            L(NotificationLite.b());
        }
    }

    @Override // h.e
    public void onError(Throwable th) {
        if (this.f72475g) {
            this.f72474f.get().onError(th);
        } else {
            L(NotificationLite.c(th));
        }
    }

    @Override // h.e
    public void onNext(T t) {
        if (this.f72475g) {
            this.f72474f.get().onNext(t);
        } else {
            L(NotificationLite.h(t));
        }
    }
}
