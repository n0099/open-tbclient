package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import rx.d;
/* loaded from: classes6.dex */
public final class BufferUntilSubscriber<T> extends rx.subjects.c<T, T> {
    static final rx.e ojV = new rx.e() { // from class: rx.internal.operators.BufferUntilSubscriber.1
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
    final State<T> ojT;
    private boolean ojU;

    public static <T> BufferUntilSubscriber<T> dXU() {
        return new BufferUntilSubscriber<>(new State());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    static final class a<T> implements d.a<T> {
        final State<T> ojT;

        @Override // rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((rx.j) ((rx.j) obj));
        }

        public a(State<T> state) {
            this.ojT = state;
        }

        public void call(rx.j<? super T> jVar) {
            boolean z = true;
            if (this.ojT.casObserverRef(null, jVar)) {
                jVar.add(rx.subscriptions.e.l(new rx.functions.a() { // from class: rx.internal.operators.BufferUntilSubscriber.a.1
                    @Override // rx.functions.a
                    public void call() {
                        a.this.ojT.set(BufferUntilSubscriber.ojV);
                    }
                }));
                synchronized (this.ojT.guard) {
                    if (this.ojT.emitting) {
                        z = false;
                    } else {
                        this.ojT.emitting = true;
                    }
                }
                if (!z) {
                    return;
                }
                while (true) {
                    Object poll = this.ojT.buffer.poll();
                    if (poll != null) {
                        NotificationLite.a(this.ojT.get(), poll);
                    } else {
                        synchronized (this.ojT.guard) {
                            if (this.ojT.buffer.isEmpty()) {
                                this.ojT.emitting = false;
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
        this.ojT = state;
    }

    private void bU(Object obj) {
        synchronized (this.ojT.guard) {
            this.ojT.buffer.add(obj);
            if (this.ojT.get() != null && !this.ojT.emitting) {
                this.ojU = true;
                this.ojT.emitting = true;
            }
        }
        if (!this.ojU) {
            return;
        }
        while (true) {
            Object poll = this.ojT.buffer.poll();
            if (poll != null) {
                NotificationLite.a(this.ojT.get(), poll);
            } else {
                return;
            }
        }
    }

    @Override // rx.e
    public void onCompleted() {
        if (this.ojU) {
            this.ojT.get().onCompleted();
        } else {
            bU(NotificationLite.dXV());
        }
    }

    @Override // rx.e
    public void onError(Throwable th) {
        if (this.ojU) {
            this.ojT.get().onError(th);
        } else {
            bU(NotificationLite.error(th));
        }
    }

    @Override // rx.e
    public void onNext(T t) {
        if (this.ojU) {
            this.ojT.get().onNext(t);
        } else {
            bU(NotificationLite.next(t));
        }
    }
}
