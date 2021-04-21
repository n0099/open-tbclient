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
    public static final e f69300h = new a();

    /* renamed from: f  reason: collision with root package name */
    public final State<T> f69301f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f69302g;

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
        public final State<T> f69303e;

        /* loaded from: classes7.dex */
        public class a implements h.n.a {
            public a() {
            }

            @Override // h.n.a
            public void call() {
                b.this.f69303e.set(BufferUntilSubscriber.f69300h);
            }
        }

        public b(State<T> state) {
            this.f69303e = state;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(j<? super T> jVar) {
            boolean z;
            if (this.f69303e.casObserverRef(null, jVar)) {
                jVar.add(h.u.e.a(new a()));
                synchronized (this.f69303e.guard) {
                    z = true;
                    if (this.f69303e.emitting) {
                        z = false;
                    } else {
                        this.f69303e.emitting = true;
                    }
                }
                if (!z) {
                    return;
                }
                while (true) {
                    Object poll = this.f69303e.buffer.poll();
                    if (poll != null) {
                        NotificationLite.a(this.f69303e.get(), poll);
                    } else {
                        synchronized (this.f69303e.guard) {
                            if (this.f69303e.buffer.isEmpty()) {
                                this.f69303e.emitting = false;
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
        this.f69301f = state;
    }

    public static <T> BufferUntilSubscriber<T> N() {
        return new BufferUntilSubscriber<>(new State());
    }

    public final void O(Object obj) {
        synchronized (this.f69301f.guard) {
            this.f69301f.buffer.add(obj);
            if (this.f69301f.get() != null && !this.f69301f.emitting) {
                this.f69302g = true;
                this.f69301f.emitting = true;
            }
        }
        if (!this.f69302g) {
            return;
        }
        while (true) {
            Object poll = this.f69301f.buffer.poll();
            if (poll == null) {
                return;
            }
            NotificationLite.a(this.f69301f.get(), poll);
        }
    }

    @Override // h.e
    public void onCompleted() {
        if (this.f69302g) {
            this.f69301f.get().onCompleted();
        } else {
            O(NotificationLite.b());
        }
    }

    @Override // h.e
    public void onError(Throwable th) {
        if (this.f69302g) {
            this.f69301f.get().onError(th);
        } else {
            O(NotificationLite.c(th));
        }
    }

    @Override // h.e
    public void onNext(T t) {
        if (this.f69302g) {
            this.f69301f.get().onNext(t);
        } else {
            O(NotificationLite.h(t));
        }
    }
}
