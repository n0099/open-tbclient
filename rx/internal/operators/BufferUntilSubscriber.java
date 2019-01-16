package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import rx.d;
/* loaded from: classes2.dex */
public final class BufferUntilSubscriber<T> extends rx.subjects.c<T, T> {
    static final rx.e iFU = new rx.e() { // from class: rx.internal.operators.BufferUntilSubscriber.1
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
    final State<T> iFS;
    private boolean iFT;

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
        final State<T> iFS;

        @Override // rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((rx.j) ((rx.j) obj));
        }

        public a(State<T> state) {
            this.iFS = state;
        }

        public void call(rx.j<? super T> jVar) {
            boolean z = true;
            if (this.iFS.casObserverRef(null, jVar)) {
                jVar.add(rx.subscriptions.e.j(new rx.functions.a() { // from class: rx.internal.operators.BufferUntilSubscriber.a.1
                    @Override // rx.functions.a
                    public void call() {
                        a.this.iFS.set(BufferUntilSubscriber.iFU);
                    }
                }));
                synchronized (this.iFS.guard) {
                    if (this.iFS.emitting) {
                        z = false;
                    } else {
                        this.iFS.emitting = true;
                    }
                }
                if (!z) {
                    return;
                }
                while (true) {
                    Object poll = this.iFS.buffer.poll();
                    if (poll != null) {
                        NotificationLite.a(this.iFS.get(), poll);
                    } else {
                        synchronized (this.iFS.guard) {
                            if (this.iFS.buffer.isEmpty()) {
                                this.iFS.emitting = false;
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
        this.iFS = state;
    }

    private void aX(Object obj) {
        synchronized (this.iFS.guard) {
            this.iFS.buffer.add(obj);
            if (this.iFS.get() != null && !this.iFS.emitting) {
                this.iFT = true;
                this.iFS.emitting = true;
            }
        }
        if (!this.iFT) {
            return;
        }
        while (true) {
            Object poll = this.iFS.buffer.poll();
            if (poll != null) {
                NotificationLite.a(this.iFS.get(), poll);
            } else {
                return;
            }
        }
    }

    @Override // rx.e
    public void onCompleted() {
        if (this.iFT) {
            this.iFS.get().onCompleted();
        } else {
            aX(NotificationLite.ceF());
        }
    }

    @Override // rx.e
    public void onError(Throwable th) {
        if (this.iFT) {
            this.iFS.get().onError(th);
        } else {
            aX(NotificationLite.M(th));
        }
    }

    @Override // rx.e
    public void onNext(T t) {
        if (this.iFT) {
            this.iFS.get().onNext(t);
        } else {
            aX(NotificationLite.aY(t));
        }
    }

    @Override // rx.subjects.c
    public boolean hasObservers() {
        boolean z;
        synchronized (this.iFS.guard) {
            z = this.iFS.get() != null;
        }
        return z;
    }
}
