package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import rx.d;
/* loaded from: classes7.dex */
public final class BufferUntilSubscriber<T> extends rx.subjects.c<T, T> {
    static final rx.e oNQ = new rx.e() { // from class: rx.internal.operators.BufferUntilSubscriber.1
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
    final State<T> oNO;
    private boolean oNP;

    public static <T> BufferUntilSubscriber<T> eog() {
        return new BufferUntilSubscriber<>(new State());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
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

    /* loaded from: classes7.dex */
    static final class a<T> implements d.a<T> {
        final State<T> oNO;

        @Override // rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((rx.j) ((rx.j) obj));
        }

        public a(State<T> state) {
            this.oNO = state;
        }

        public void call(rx.j<? super T> jVar) {
            boolean z = true;
            if (this.oNO.casObserverRef(null, jVar)) {
                jVar.add(rx.subscriptions.e.l(new rx.functions.a() { // from class: rx.internal.operators.BufferUntilSubscriber.a.1
                    @Override // rx.functions.a
                    public void call() {
                        a.this.oNO.set(BufferUntilSubscriber.oNQ);
                    }
                }));
                synchronized (this.oNO.guard) {
                    if (this.oNO.emitting) {
                        z = false;
                    } else {
                        this.oNO.emitting = true;
                    }
                }
                if (!z) {
                    return;
                }
                while (true) {
                    Object poll = this.oNO.buffer.poll();
                    if (poll != null) {
                        NotificationLite.a(this.oNO.get(), poll);
                    } else {
                        synchronized (this.oNO.guard) {
                            if (this.oNO.buffer.isEmpty()) {
                                this.oNO.emitting = false;
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
        this.oNO = state;
    }

    private void bY(Object obj) {
        synchronized (this.oNO.guard) {
            this.oNO.buffer.add(obj);
            if (this.oNO.get() != null && !this.oNO.emitting) {
                this.oNP = true;
                this.oNO.emitting = true;
            }
        }
        if (!this.oNP) {
            return;
        }
        while (true) {
            Object poll = this.oNO.buffer.poll();
            if (poll != null) {
                NotificationLite.a(this.oNO.get(), poll);
            } else {
                return;
            }
        }
    }

    @Override // rx.e
    public void onCompleted() {
        if (this.oNP) {
            this.oNO.get().onCompleted();
        } else {
            bY(NotificationLite.eoh());
        }
    }

    @Override // rx.e
    public void onError(Throwable th) {
        if (this.oNP) {
            this.oNO.get().onError(th);
        } else {
            bY(NotificationLite.error(th));
        }
    }

    @Override // rx.e
    public void onNext(T t) {
        if (this.oNP) {
            this.oNO.get().onNext(t);
        } else {
            bY(NotificationLite.next(t));
        }
    }
}
