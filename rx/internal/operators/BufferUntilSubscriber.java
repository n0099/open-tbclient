package rx.internal.operators;

import h.d;
import h.e;
import h.j;
import h.t.d;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class BufferUntilSubscriber<T> extends d<T, T> {

    /* renamed from: h  reason: collision with root package name */
    public static final e f68147h = new a();

    /* renamed from: f  reason: collision with root package name */
    public final State<T> f68148f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f68149g;

    /* loaded from: classes7.dex */
    public static final class State<T> extends AtomicReference<e<? super T>> {
        public static final long serialVersionUID = 8026705089538090368L;
        public boolean emitting;
        public final Object guard = new Object();
        public final ConcurrentLinkedQueue<Object> buffer = new ConcurrentLinkedQueue<>();

        public boolean casObserverRef(e<? super T> eVar, e<? super T> eVar2) {
            return compareAndSet(eVar, eVar2);
        }
    }

    /* loaded from: classes7.dex */
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

    /* loaded from: classes7.dex */
    public static final class b<T> implements d.a<T> {

        /* renamed from: e  reason: collision with root package name */
        public final State<T> f68150e;

        /* loaded from: classes7.dex */
        public class a implements h.n.a {
            public a() {
            }

            @Override // h.n.a
            public void call() {
                b.this.f68150e.set(BufferUntilSubscriber.f68147h);
            }
        }

        public b(State<T> state) {
            this.f68150e = state;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(j<? super T> jVar) {
            boolean z;
            if (this.f68150e.casObserverRef(null, jVar)) {
                jVar.add(h.u.e.a(new a()));
                synchronized (this.f68150e.guard) {
                    z = true;
                    if (this.f68150e.emitting) {
                        z = false;
                    } else {
                        this.f68150e.emitting = true;
                    }
                }
                if (!z) {
                    return;
                }
                while (true) {
                    Object poll = this.f68150e.buffer.poll();
                    if (poll != null) {
                        NotificationLite.a(this.f68150e.get(), poll);
                    } else {
                        synchronized (this.f68150e.guard) {
                            if (this.f68150e.buffer.isEmpty()) {
                                this.f68150e.emitting = false;
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
        this.f68148f = state;
    }

    public static <T> BufferUntilSubscriber<T> L() {
        return new BufferUntilSubscriber<>(new State());
    }

    public final void M(Object obj) {
        synchronized (this.f68148f.guard) {
            this.f68148f.buffer.add(obj);
            if (this.f68148f.get() != null && !this.f68148f.emitting) {
                this.f68149g = true;
                this.f68148f.emitting = true;
            }
        }
        if (!this.f68149g) {
            return;
        }
        while (true) {
            Object poll = this.f68148f.buffer.poll();
            if (poll == null) {
                return;
            }
            NotificationLite.a(this.f68148f.get(), poll);
        }
    }

    @Override // h.e
    public void onCompleted() {
        if (this.f68149g) {
            this.f68148f.get().onCompleted();
        } else {
            M(NotificationLite.b());
        }
    }

    @Override // h.e
    public void onError(Throwable th) {
        if (this.f68149g) {
            this.f68148f.get().onError(th);
        } else {
            M(NotificationLite.c(th));
        }
    }

    @Override // h.e
    public void onNext(T t) {
        if (this.f68149g) {
            this.f68148f.get().onNext(t);
        } else {
            M(NotificationLite.h(t));
        }
    }
}
