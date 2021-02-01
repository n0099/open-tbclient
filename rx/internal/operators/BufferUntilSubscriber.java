package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import rx.d;
/* loaded from: classes5.dex */
public final class BufferUntilSubscriber<T> extends rx.subjects.c<T, T> {
    static final rx.e qym = new rx.e() { // from class: rx.internal.operators.BufferUntilSubscriber.1
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
    final State<T> qyk;
    private boolean qyl;

    public static <T> BufferUntilSubscriber<T> eMR() {
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
        final State<T> qyk;

        @Override // rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((rx.j) ((rx.j) obj));
        }

        public a(State<T> state) {
            this.qyk = state;
        }

        public void call(rx.j<? super T> jVar) {
            boolean z = true;
            if (this.qyk.casObserverRef(null, jVar)) {
                jVar.add(rx.subscriptions.e.l(new rx.functions.a() { // from class: rx.internal.operators.BufferUntilSubscriber.a.1
                    @Override // rx.functions.a
                    public void call() {
                        a.this.qyk.set(BufferUntilSubscriber.qym);
                    }
                }));
                synchronized (this.qyk.guard) {
                    if (this.qyk.emitting) {
                        z = false;
                    } else {
                        this.qyk.emitting = true;
                    }
                }
                if (!z) {
                    return;
                }
                while (true) {
                    Object poll = this.qyk.buffer.poll();
                    if (poll != null) {
                        NotificationLite.a(this.qyk.get(), poll);
                    } else {
                        synchronized (this.qyk.guard) {
                            if (this.qyk.buffer.isEmpty()) {
                                this.qyk.emitting = false;
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
        this.qyk = state;
    }

    private void bZ(Object obj) {
        synchronized (this.qyk.guard) {
            this.qyk.buffer.add(obj);
            if (this.qyk.get() != null && !this.qyk.emitting) {
                this.qyl = true;
                this.qyk.emitting = true;
            }
        }
        if (!this.qyl) {
            return;
        }
        while (true) {
            Object poll = this.qyk.buffer.poll();
            if (poll != null) {
                NotificationLite.a(this.qyk.get(), poll);
            } else {
                return;
            }
        }
    }

    @Override // rx.e
    public void onCompleted() {
        if (this.qyl) {
            this.qyk.get().onCompleted();
        } else {
            bZ(NotificationLite.eMS());
        }
    }

    @Override // rx.e
    public void onError(Throwable th) {
        if (this.qyl) {
            this.qyk.get().onError(th);
        } else {
            bZ(NotificationLite.error(th));
        }
    }

    @Override // rx.e
    public void onNext(T t) {
        if (this.qyl) {
            this.qyk.get().onNext(t);
        } else {
            bZ(NotificationLite.next(t));
        }
    }
}
