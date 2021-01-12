package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import rx.d;
/* loaded from: classes14.dex */
public final class BufferUntilSubscriber<T> extends rx.subjects.c<T, T> {
    static final rx.e qoi = new rx.e() { // from class: rx.internal.operators.BufferUntilSubscriber.1
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
    final State<T> qog;
    private boolean qoh;

    public static <T> BufferUntilSubscriber<T> eKB() {
        return new BufferUntilSubscriber<>(new State());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
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

    /* loaded from: classes14.dex */
    static final class a<T> implements d.a<T> {
        final State<T> qog;

        @Override // rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((rx.j) ((rx.j) obj));
        }

        public a(State<T> state) {
            this.qog = state;
        }

        public void call(rx.j<? super T> jVar) {
            boolean z = true;
            if (this.qog.casObserverRef(null, jVar)) {
                jVar.add(rx.subscriptions.e.l(new rx.functions.a() { // from class: rx.internal.operators.BufferUntilSubscriber.a.1
                    @Override // rx.functions.a
                    public void call() {
                        a.this.qog.set(BufferUntilSubscriber.qoi);
                    }
                }));
                synchronized (this.qog.guard) {
                    if (this.qog.emitting) {
                        z = false;
                    } else {
                        this.qog.emitting = true;
                    }
                }
                if (!z) {
                    return;
                }
                while (true) {
                    Object poll = this.qog.buffer.poll();
                    if (poll != null) {
                        NotificationLite.a(this.qog.get(), poll);
                    } else {
                        synchronized (this.qog.guard) {
                            if (this.qog.buffer.isEmpty()) {
                                this.qog.emitting = false;
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
        this.qog = state;
    }

    private void bZ(Object obj) {
        synchronized (this.qog.guard) {
            this.qog.buffer.add(obj);
            if (this.qog.get() != null && !this.qog.emitting) {
                this.qoh = true;
                this.qog.emitting = true;
            }
        }
        if (!this.qoh) {
            return;
        }
        while (true) {
            Object poll = this.qog.buffer.poll();
            if (poll != null) {
                NotificationLite.a(this.qog.get(), poll);
            } else {
                return;
            }
        }
    }

    @Override // rx.e
    public void onCompleted() {
        if (this.qoh) {
            this.qog.get().onCompleted();
        } else {
            bZ(NotificationLite.eKC());
        }
    }

    @Override // rx.e
    public void onError(Throwable th) {
        if (this.qoh) {
            this.qog.get().onError(th);
        } else {
            bZ(NotificationLite.error(th));
        }
    }

    @Override // rx.e
    public void onNext(T t) {
        if (this.qoh) {
            this.qog.get().onNext(t);
        } else {
            bZ(NotificationLite.next(t));
        }
    }
}
