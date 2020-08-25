package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import rx.d;
/* loaded from: classes5.dex */
public final class BufferUntilSubscriber<T> extends rx.subjects.c<T, T> {
    static final rx.e oDT = new rx.e() { // from class: rx.internal.operators.BufferUntilSubscriber.1
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
    final State<T> oDR;
    private boolean oDS;

    public static <T> BufferUntilSubscriber<T> ejZ() {
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
        final State<T> oDR;

        @Override // rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((rx.j) ((rx.j) obj));
        }

        public a(State<T> state) {
            this.oDR = state;
        }

        public void call(rx.j<? super T> jVar) {
            boolean z = true;
            if (this.oDR.casObserverRef(null, jVar)) {
                jVar.add(rx.subscriptions.e.l(new rx.functions.a() { // from class: rx.internal.operators.BufferUntilSubscriber.a.1
                    @Override // rx.functions.a
                    public void call() {
                        a.this.oDR.set(BufferUntilSubscriber.oDT);
                    }
                }));
                synchronized (this.oDR.guard) {
                    if (this.oDR.emitting) {
                        z = false;
                    } else {
                        this.oDR.emitting = true;
                    }
                }
                if (!z) {
                    return;
                }
                while (true) {
                    Object poll = this.oDR.buffer.poll();
                    if (poll != null) {
                        NotificationLite.a(this.oDR.get(), poll);
                    } else {
                        synchronized (this.oDR.guard) {
                            if (this.oDR.buffer.isEmpty()) {
                                this.oDR.emitting = false;
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
        this.oDR = state;
    }

    private void bY(Object obj) {
        synchronized (this.oDR.guard) {
            this.oDR.buffer.add(obj);
            if (this.oDR.get() != null && !this.oDR.emitting) {
                this.oDS = true;
                this.oDR.emitting = true;
            }
        }
        if (!this.oDS) {
            return;
        }
        while (true) {
            Object poll = this.oDR.buffer.poll();
            if (poll != null) {
                NotificationLite.a(this.oDR.get(), poll);
            } else {
                return;
            }
        }
    }

    @Override // rx.e
    public void onCompleted() {
        if (this.oDS) {
            this.oDR.get().onCompleted();
        } else {
            bY(NotificationLite.eka());
        }
    }

    @Override // rx.e
    public void onError(Throwable th) {
        if (this.oDS) {
            this.oDR.get().onError(th);
        } else {
            bY(NotificationLite.error(th));
        }
    }

    @Override // rx.e
    public void onNext(T t) {
        if (this.oDS) {
            this.oDR.get().onNext(t);
        } else {
            bY(NotificationLite.next(t));
        }
    }
}
