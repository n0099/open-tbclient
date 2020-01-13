package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import rx.d;
/* loaded from: classes5.dex */
public final class BufferUntilSubscriber<T> extends rx.subjects.c<T, T> {
    static final rx.e nMK = new rx.e() { // from class: rx.internal.operators.BufferUntilSubscriber.1
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
    final State<T> nMI;
    private boolean nMJ;

    public static <T> BufferUntilSubscriber<T> dMR() {
        return new BufferUntilSubscriber<>(new State());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
    static final class a<T> implements d.a<T> {
        final State<T> nMI;

        @Override // rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((rx.j) ((rx.j) obj));
        }

        public a(State<T> state) {
            this.nMI = state;
        }

        public void call(rx.j<? super T> jVar) {
            boolean z = true;
            if (this.nMI.casObserverRef(null, jVar)) {
                jVar.add(rx.subscriptions.e.l(new rx.functions.a() { // from class: rx.internal.operators.BufferUntilSubscriber.a.1
                    @Override // rx.functions.a
                    public void call() {
                        a.this.nMI.set(BufferUntilSubscriber.nMK);
                    }
                }));
                synchronized (this.nMI.guard) {
                    if (this.nMI.emitting) {
                        z = false;
                    } else {
                        this.nMI.emitting = true;
                    }
                }
                if (!z) {
                    return;
                }
                while (true) {
                    Object poll = this.nMI.buffer.poll();
                    if (poll != null) {
                        NotificationLite.a(this.nMI.get(), poll);
                    } else {
                        synchronized (this.nMI.guard) {
                            if (this.nMI.buffer.isEmpty()) {
                                this.nMI.emitting = false;
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
        this.nMI = state;
    }

    private void cc(Object obj) {
        synchronized (this.nMI.guard) {
            this.nMI.buffer.add(obj);
            if (this.nMI.get() != null && !this.nMI.emitting) {
                this.nMJ = true;
                this.nMI.emitting = true;
            }
        }
        if (!this.nMJ) {
            return;
        }
        while (true) {
            Object poll = this.nMI.buffer.poll();
            if (poll != null) {
                NotificationLite.a(this.nMI.get(), poll);
            } else {
                return;
            }
        }
    }

    @Override // rx.e
    public void onCompleted() {
        if (this.nMJ) {
            this.nMI.get().onCompleted();
        } else {
            cc(NotificationLite.dMS());
        }
    }

    @Override // rx.e
    public void onError(Throwable th) {
        if (this.nMJ) {
            this.nMI.get().onError(th);
        } else {
            cc(NotificationLite.error(th));
        }
    }

    @Override // rx.e
    public void onNext(T t) {
        if (this.nMJ) {
            this.nMI.get().onNext(t);
        } else {
            cc(NotificationLite.next(t));
        }
    }
}
