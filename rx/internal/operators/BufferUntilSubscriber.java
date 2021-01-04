package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import rx.d;
/* loaded from: classes15.dex */
public final class BufferUntilSubscriber<T> extends rx.subjects.c<T, T> {
    static final rx.e qrc = new rx.e() { // from class: rx.internal.operators.BufferUntilSubscriber.1
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
    final State<T> qra;
    private boolean qrb;

    public static <T> BufferUntilSubscriber<T> eNN() {
        return new BufferUntilSubscriber<>(new State());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
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

    /* loaded from: classes15.dex */
    static final class a<T> implements d.a<T> {
        final State<T> qra;

        @Override // rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((rx.j) ((rx.j) obj));
        }

        public a(State<T> state) {
            this.qra = state;
        }

        public void call(rx.j<? super T> jVar) {
            boolean z = true;
            if (this.qra.casObserverRef(null, jVar)) {
                jVar.add(rx.subscriptions.e.l(new rx.functions.a() { // from class: rx.internal.operators.BufferUntilSubscriber.a.1
                    @Override // rx.functions.a
                    public void call() {
                        a.this.qra.set(BufferUntilSubscriber.qrc);
                    }
                }));
                synchronized (this.qra.guard) {
                    if (this.qra.emitting) {
                        z = false;
                    } else {
                        this.qra.emitting = true;
                    }
                }
                if (!z) {
                    return;
                }
                while (true) {
                    Object poll = this.qra.buffer.poll();
                    if (poll != null) {
                        NotificationLite.a(this.qra.get(), poll);
                    } else {
                        synchronized (this.qra.guard) {
                            if (this.qra.buffer.isEmpty()) {
                                this.qra.emitting = false;
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
        this.qra = state;
    }

    private void bY(Object obj) {
        synchronized (this.qra.guard) {
            this.qra.buffer.add(obj);
            if (this.qra.get() != null && !this.qra.emitting) {
                this.qrb = true;
                this.qra.emitting = true;
            }
        }
        if (!this.qrb) {
            return;
        }
        while (true) {
            Object poll = this.qra.buffer.poll();
            if (poll != null) {
                NotificationLite.a(this.qra.get(), poll);
            } else {
                return;
            }
        }
    }

    @Override // rx.e
    public void onCompleted() {
        if (this.qrb) {
            this.qra.get().onCompleted();
        } else {
            bY(NotificationLite.eNO());
        }
    }

    @Override // rx.e
    public void onError(Throwable th) {
        if (this.qrb) {
            this.qra.get().onError(th);
        } else {
            bY(NotificationLite.error(th));
        }
    }

    @Override // rx.e
    public void onNext(T t) {
        if (this.qrb) {
            this.qra.get().onNext(t);
        } else {
            bY(NotificationLite.next(t));
        }
    }
}
