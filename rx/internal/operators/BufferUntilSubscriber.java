package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import rx.d;
/* loaded from: classes6.dex */
public final class BufferUntilSubscriber<T> extends rx.subjects.c<T, T> {
    static final rx.e ojX = new rx.e() { // from class: rx.internal.operators.BufferUntilSubscriber.1
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
    final State<T> ojV;
    private boolean ojW;

    public static <T> BufferUntilSubscriber<T> dXV() {
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
        final State<T> ojV;

        @Override // rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((rx.j) ((rx.j) obj));
        }

        public a(State<T> state) {
            this.ojV = state;
        }

        public void call(rx.j<? super T> jVar) {
            boolean z = true;
            if (this.ojV.casObserverRef(null, jVar)) {
                jVar.add(rx.subscriptions.e.l(new rx.functions.a() { // from class: rx.internal.operators.BufferUntilSubscriber.a.1
                    @Override // rx.functions.a
                    public void call() {
                        a.this.ojV.set(BufferUntilSubscriber.ojX);
                    }
                }));
                synchronized (this.ojV.guard) {
                    if (this.ojV.emitting) {
                        z = false;
                    } else {
                        this.ojV.emitting = true;
                    }
                }
                if (!z) {
                    return;
                }
                while (true) {
                    Object poll = this.ojV.buffer.poll();
                    if (poll != null) {
                        NotificationLite.a(this.ojV.get(), poll);
                    } else {
                        synchronized (this.ojV.guard) {
                            if (this.ojV.buffer.isEmpty()) {
                                this.ojV.emitting = false;
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
        this.ojV = state;
    }

    private void bU(Object obj) {
        synchronized (this.ojV.guard) {
            this.ojV.buffer.add(obj);
            if (this.ojV.get() != null && !this.ojV.emitting) {
                this.ojW = true;
                this.ojV.emitting = true;
            }
        }
        if (!this.ojW) {
            return;
        }
        while (true) {
            Object poll = this.ojV.buffer.poll();
            if (poll != null) {
                NotificationLite.a(this.ojV.get(), poll);
            } else {
                return;
            }
        }
    }

    @Override // rx.e
    public void onCompleted() {
        if (this.ojW) {
            this.ojV.get().onCompleted();
        } else {
            bU(NotificationLite.dXW());
        }
    }

    @Override // rx.e
    public void onError(Throwable th) {
        if (this.ojW) {
            this.ojV.get().onError(th);
        } else {
            bU(NotificationLite.error(th));
        }
    }

    @Override // rx.e
    public void onNext(T t) {
        if (this.ojW) {
            this.ojV.get().onNext(t);
        } else {
            bU(NotificationLite.next(t));
        }
    }
}
