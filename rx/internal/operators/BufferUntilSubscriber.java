package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import rx.d;
/* loaded from: classes2.dex */
public final class BufferUntilSubscriber<T> extends rx.subjects.c<T, T> {
    static final rx.e iFV = new rx.e() { // from class: rx.internal.operators.BufferUntilSubscriber.1
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
    final State<T> iFT;
    private boolean iFU;

    public static <T> BufferUntilSubscriber<T> ceB() {
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
        final State<T> iFT;

        @Override // rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((rx.j) ((rx.j) obj));
        }

        public a(State<T> state) {
            this.iFT = state;
        }

        public void call(rx.j<? super T> jVar) {
            boolean z = true;
            if (this.iFT.casObserverRef(null, jVar)) {
                jVar.add(rx.subscriptions.e.j(new rx.functions.a() { // from class: rx.internal.operators.BufferUntilSubscriber.a.1
                    @Override // rx.functions.a
                    public void call() {
                        a.this.iFT.set(BufferUntilSubscriber.iFV);
                    }
                }));
                synchronized (this.iFT.guard) {
                    if (this.iFT.emitting) {
                        z = false;
                    } else {
                        this.iFT.emitting = true;
                    }
                }
                if (!z) {
                    return;
                }
                while (true) {
                    Object poll = this.iFT.buffer.poll();
                    if (poll != null) {
                        NotificationLite.a(this.iFT.get(), poll);
                    } else {
                        synchronized (this.iFT.guard) {
                            if (this.iFT.buffer.isEmpty()) {
                                this.iFT.emitting = false;
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
        this.iFT = state;
    }

    private void aX(Object obj) {
        synchronized (this.iFT.guard) {
            this.iFT.buffer.add(obj);
            if (this.iFT.get() != null && !this.iFT.emitting) {
                this.iFU = true;
                this.iFT.emitting = true;
            }
        }
        if (!this.iFU) {
            return;
        }
        while (true) {
            Object poll = this.iFT.buffer.poll();
            if (poll != null) {
                NotificationLite.a(this.iFT.get(), poll);
            } else {
                return;
            }
        }
    }

    @Override // rx.e
    public void onCompleted() {
        if (this.iFU) {
            this.iFT.get().onCompleted();
        } else {
            aX(NotificationLite.ceF());
        }
    }

    @Override // rx.e
    public void onError(Throwable th) {
        if (this.iFU) {
            this.iFT.get().onError(th);
        } else {
            aX(NotificationLite.M(th));
        }
    }

    @Override // rx.e
    public void onNext(T t) {
        if (this.iFU) {
            this.iFT.get().onNext(t);
        } else {
            aX(NotificationLite.aY(t));
        }
    }

    @Override // rx.subjects.c
    public boolean hasObservers() {
        boolean z;
        synchronized (this.iFT.guard) {
            z = this.iFT.get() != null;
        }
        return z;
    }
}
