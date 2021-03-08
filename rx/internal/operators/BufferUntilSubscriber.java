package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import rx.d;
/* loaded from: classes4.dex */
public final class BufferUntilSubscriber<T> extends rx.subjects.c<T, T> {
    static final rx.e qzo = new rx.e() { // from class: rx.internal.operators.BufferUntilSubscriber.1
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
    final State<T> qzm;
    private boolean qzn;

    public static <T> BufferUntilSubscriber<T> eMH() {
        return new BufferUntilSubscriber<>(new State());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    static final class a<T> implements d.a<T> {
        final State<T> qzm;

        @Override // rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((rx.j) ((rx.j) obj));
        }

        public a(State<T> state) {
            this.qzm = state;
        }

        public void call(rx.j<? super T> jVar) {
            boolean z = true;
            if (this.qzm.casObserverRef(null, jVar)) {
                jVar.add(rx.subscriptions.e.l(new rx.functions.a() { // from class: rx.internal.operators.BufferUntilSubscriber.a.1
                    @Override // rx.functions.a
                    public void call() {
                        a.this.qzm.set(BufferUntilSubscriber.qzo);
                    }
                }));
                synchronized (this.qzm.guard) {
                    if (this.qzm.emitting) {
                        z = false;
                    } else {
                        this.qzm.emitting = true;
                    }
                }
                if (!z) {
                    return;
                }
                while (true) {
                    Object poll = this.qzm.buffer.poll();
                    if (poll != null) {
                        NotificationLite.a(this.qzm.get(), poll);
                    } else {
                        synchronized (this.qzm.guard) {
                            if (this.qzm.buffer.isEmpty()) {
                                this.qzm.emitting = false;
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
        this.qzm = state;
    }

    private void ca(Object obj) {
        synchronized (this.qzm.guard) {
            this.qzm.buffer.add(obj);
            if (this.qzm.get() != null && !this.qzm.emitting) {
                this.qzn = true;
                this.qzm.emitting = true;
            }
        }
        if (!this.qzn) {
            return;
        }
        while (true) {
            Object poll = this.qzm.buffer.poll();
            if (poll != null) {
                NotificationLite.a(this.qzm.get(), poll);
            } else {
                return;
            }
        }
    }

    @Override // rx.e
    public void onCompleted() {
        if (this.qzn) {
            this.qzm.get().onCompleted();
        } else {
            ca(NotificationLite.eMI());
        }
    }

    @Override // rx.e
    public void onError(Throwable th) {
        if (this.qzn) {
            this.qzm.get().onError(th);
        } else {
            ca(NotificationLite.error(th));
        }
    }

    @Override // rx.e
    public void onNext(T t) {
        if (this.qzn) {
            this.qzm.get().onNext(t);
        } else {
            ca(NotificationLite.next(t));
        }
    }
}
