package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import rx.d;
/* loaded from: classes15.dex */
public final class BufferUntilSubscriber<T> extends rx.subjects.c<T, T> {
    static final rx.e qsK = new rx.e() { // from class: rx.internal.operators.BufferUntilSubscriber.1
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
    final State<T> qsI;
    private boolean qsJ;

    public static <T> BufferUntilSubscriber<T> eOr() {
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
        final State<T> qsI;

        @Override // rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((rx.j) ((rx.j) obj));
        }

        public a(State<T> state) {
            this.qsI = state;
        }

        public void call(rx.j<? super T> jVar) {
            boolean z = true;
            if (this.qsI.casObserverRef(null, jVar)) {
                jVar.add(rx.subscriptions.e.l(new rx.functions.a() { // from class: rx.internal.operators.BufferUntilSubscriber.a.1
                    @Override // rx.functions.a
                    public void call() {
                        a.this.qsI.set(BufferUntilSubscriber.qsK);
                    }
                }));
                synchronized (this.qsI.guard) {
                    if (this.qsI.emitting) {
                        z = false;
                    } else {
                        this.qsI.emitting = true;
                    }
                }
                if (!z) {
                    return;
                }
                while (true) {
                    Object poll = this.qsI.buffer.poll();
                    if (poll != null) {
                        NotificationLite.a(this.qsI.get(), poll);
                    } else {
                        synchronized (this.qsI.guard) {
                            if (this.qsI.buffer.isEmpty()) {
                                this.qsI.emitting = false;
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
        this.qsI = state;
    }

    private void bZ(Object obj) {
        synchronized (this.qsI.guard) {
            this.qsI.buffer.add(obj);
            if (this.qsI.get() != null && !this.qsI.emitting) {
                this.qsJ = true;
                this.qsI.emitting = true;
            }
        }
        if (!this.qsJ) {
            return;
        }
        while (true) {
            Object poll = this.qsI.buffer.poll();
            if (poll != null) {
                NotificationLite.a(this.qsI.get(), poll);
            } else {
                return;
            }
        }
    }

    @Override // rx.e
    public void onCompleted() {
        if (this.qsJ) {
            this.qsI.get().onCompleted();
        } else {
            bZ(NotificationLite.eOs());
        }
    }

    @Override // rx.e
    public void onError(Throwable th) {
        if (this.qsJ) {
            this.qsI.get().onError(th);
        } else {
            bZ(NotificationLite.error(th));
        }
    }

    @Override // rx.e
    public void onNext(T t) {
        if (this.qsJ) {
            this.qsI.get().onNext(t);
        } else {
            bZ(NotificationLite.next(t));
        }
    }
}
