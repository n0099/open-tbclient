package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import rx.d;
/* loaded from: classes16.dex */
public final class BufferUntilSubscriber<T> extends rx.subjects.c<T, T> {
    static final rx.e pdg = new rx.e() { // from class: rx.internal.operators.BufferUntilSubscriber.1
        @Override // rx.e
        public void onCompleted() {
        }

        @Override // rx.e
        public void onError(Throwable th) {
        }

        @Override // rx.e
        public void onNext(Object obj) {
        }
    };
    final State<T> pde;
    private boolean pdf;

    public static <T> BufferUntilSubscriber<T> erR() {
        return new BufferUntilSubscriber<>(new State());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public static final class State<T> extends AtomicReference<rx.e<? super T>> {
        private static final long serialVersionUID = 8026705089538090368L;
        boolean emitting;
        final Object guard = new Object();
        final ConcurrentLinkedQueue<Object> buffer = new ConcurrentLinkedQueue<>();

        State() {
        }

        boolean casObserverRef(rx.e<? super T> eVar, rx.e<? super T> eVar2) {
            return compareAndSet(eVar, eVar2);
        }
    }

    /* loaded from: classes16.dex */
    static final class a<T> implements d.a<T> {
        final State<T> pde;

        @Override // rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((rx.j) ((rx.j) obj));
        }

        public a(State<T> state) {
            this.pde = state;
        }

        public void call(rx.j<? super T> jVar) {
            boolean z = true;
            if (this.pde.casObserverRef(null, jVar)) {
                jVar.add(rx.subscriptions.e.l(new rx.functions.a() { // from class: rx.internal.operators.BufferUntilSubscriber.a.1
                    @Override // rx.functions.a
                    public void call() {
                        a.this.pde.set(BufferUntilSubscriber.pdg);
                    }
                }));
                synchronized (this.pde.guard) {
                    if (this.pde.emitting) {
                        z = false;
                    } else {
                        this.pde.emitting = true;
                    }
                }
                if (!z) {
                    return;
                }
                while (true) {
                    Object poll = this.pde.buffer.poll();
                    if (poll != null) {
                        NotificationLite.a(this.pde.get(), poll);
                    } else {
                        synchronized (this.pde.guard) {
                            if (this.pde.buffer.isEmpty()) {
                                this.pde.emitting = false;
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

    private BufferUntilSubscriber(State<T> state) {
        super(new a(state));
        this.pde = state;
    }

    private void cb(Object obj) {
        synchronized (this.pde.guard) {
            this.pde.buffer.add(obj);
            if (this.pde.get() != null && !this.pde.emitting) {
                this.pdf = true;
                this.pde.emitting = true;
            }
        }
        if (!this.pdf) {
            return;
        }
        while (true) {
            Object poll = this.pde.buffer.poll();
            if (poll != null) {
                NotificationLite.a(this.pde.get(), poll);
            } else {
                return;
            }
        }
    }

    @Override // rx.e
    public void onCompleted() {
        if (this.pdf) {
            this.pde.get().onCompleted();
        } else {
            cb(NotificationLite.erS());
        }
    }

    @Override // rx.e
    public void onError(Throwable th) {
        if (this.pdf) {
            this.pde.get().onError(th);
        } else {
            cb(NotificationLite.error(th));
        }
    }

    @Override // rx.e
    public void onNext(T t) {
        if (this.pdf) {
            this.pde.get().onNext(t);
        } else {
            cb(NotificationLite.next(t));
        }
    }
}
