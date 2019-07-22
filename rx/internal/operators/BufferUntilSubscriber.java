package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import rx.d;
/* loaded from: classes2.dex */
public final class BufferUntilSubscriber<T> extends rx.subjects.c<T, T> {
    static final rx.e kuP = new rx.e() { // from class: rx.internal.operators.BufferUntilSubscriber.1
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
    final State<T> kuN;
    private boolean kuO;

    public static <T> BufferUntilSubscriber<T> cPk() {
        return new BufferUntilSubscriber<>(new State());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
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

    /* loaded from: classes2.dex */
    static final class a<T> implements d.a<T> {
        final State<T> kuN;

        @Override // rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((rx.j) ((rx.j) obj));
        }

        public a(State<T> state) {
            this.kuN = state;
        }

        public void call(rx.j<? super T> jVar) {
            boolean z = true;
            if (this.kuN.casObserverRef(null, jVar)) {
                jVar.add(rx.subscriptions.e.l(new rx.functions.a() { // from class: rx.internal.operators.BufferUntilSubscriber.a.1
                    @Override // rx.functions.a
                    public void call() {
                        a.this.kuN.set(BufferUntilSubscriber.kuP);
                    }
                }));
                synchronized (this.kuN.guard) {
                    if (this.kuN.emitting) {
                        z = false;
                    } else {
                        this.kuN.emitting = true;
                    }
                }
                if (!z) {
                    return;
                }
                while (true) {
                    Object poll = this.kuN.buffer.poll();
                    if (poll != null) {
                        NotificationLite.a(this.kuN.get(), poll);
                    } else {
                        synchronized (this.kuN.guard) {
                            if (this.kuN.buffer.isEmpty()) {
                                this.kuN.emitting = false;
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
        this.kuN = state;
    }

    private void bp(Object obj) {
        synchronized (this.kuN.guard) {
            this.kuN.buffer.add(obj);
            if (this.kuN.get() != null && !this.kuN.emitting) {
                this.kuO = true;
                this.kuN.emitting = true;
            }
        }
        if (!this.kuO) {
            return;
        }
        while (true) {
            Object poll = this.kuN.buffer.poll();
            if (poll != null) {
                NotificationLite.a(this.kuN.get(), poll);
            } else {
                return;
            }
        }
    }

    @Override // rx.e
    public void onCompleted() {
        if (this.kuO) {
            this.kuN.get().onCompleted();
        } else {
            bp(NotificationLite.cPn());
        }
    }

    @Override // rx.e
    public void onError(Throwable th) {
        if (this.kuO) {
            this.kuN.get().onError(th);
        } else {
            bp(NotificationLite.N(th));
        }
    }

    @Override // rx.e
    public void onNext(T t) {
        if (this.kuO) {
            this.kuN.get().onNext(t);
        } else {
            bp(NotificationLite.bq(t));
        }
    }
}
