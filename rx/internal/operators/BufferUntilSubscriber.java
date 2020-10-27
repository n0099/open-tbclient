package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import rx.d;
/* loaded from: classes16.dex */
public final class BufferUntilSubscriber<T> extends rx.subjects.c<T, T> {
    static final rx.e pUz = new rx.e() { // from class: rx.internal.operators.BufferUntilSubscriber.1
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
    final State<T> pUx;
    private boolean pUy;

    public static <T> BufferUntilSubscriber<T> eBP() {
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
        final State<T> pUx;

        @Override // rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((rx.j) ((rx.j) obj));
        }

        public a(State<T> state) {
            this.pUx = state;
        }

        public void call(rx.j<? super T> jVar) {
            boolean z = true;
            if (this.pUx.casObserverRef(null, jVar)) {
                jVar.add(rx.subscriptions.e.l(new rx.functions.a() { // from class: rx.internal.operators.BufferUntilSubscriber.a.1
                    @Override // rx.functions.a
                    public void call() {
                        a.this.pUx.set(BufferUntilSubscriber.pUz);
                    }
                }));
                synchronized (this.pUx.guard) {
                    if (this.pUx.emitting) {
                        z = false;
                    } else {
                        this.pUx.emitting = true;
                    }
                }
                if (!z) {
                    return;
                }
                while (true) {
                    Object poll = this.pUx.buffer.poll();
                    if (poll != null) {
                        NotificationLite.a(this.pUx.get(), poll);
                    } else {
                        synchronized (this.pUx.guard) {
                            if (this.pUx.buffer.isEmpty()) {
                                this.pUx.emitting = false;
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
        this.pUx = state;
    }

    private void cf(Object obj) {
        synchronized (this.pUx.guard) {
            this.pUx.buffer.add(obj);
            if (this.pUx.get() != null && !this.pUx.emitting) {
                this.pUy = true;
                this.pUx.emitting = true;
            }
        }
        if (!this.pUy) {
            return;
        }
        while (true) {
            Object poll = this.pUx.buffer.poll();
            if (poll != null) {
                NotificationLite.a(this.pUx.get(), poll);
            } else {
                return;
            }
        }
    }

    @Override // rx.e
    public void onCompleted() {
        if (this.pUy) {
            this.pUx.get().onCompleted();
        } else {
            cf(NotificationLite.eBQ());
        }
    }

    @Override // rx.e
    public void onError(Throwable th) {
        if (this.pUy) {
            this.pUx.get().onError(th);
        } else {
            cf(NotificationLite.error(th));
        }
    }

    @Override // rx.e
    public void onNext(T t) {
        if (this.pUy) {
            this.pUx.get().onNext(t);
        } else {
            cf(NotificationLite.next(t));
        }
    }
}
