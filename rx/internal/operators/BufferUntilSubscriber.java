package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import rx.d;
/* loaded from: classes2.dex */
public final class BufferUntilSubscriber<T> extends rx.subjects.c<T, T> {
    static final rx.e iEN = new rx.e() { // from class: rx.internal.operators.BufferUntilSubscriber.1
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
    final State<T> iEL;
    private boolean iEM;

    public static <T> BufferUntilSubscriber<T> cdT() {
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
        final State<T> iEL;

        @Override // rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((rx.j) ((rx.j) obj));
        }

        public a(State<T> state) {
            this.iEL = state;
        }

        public void call(rx.j<? super T> jVar) {
            boolean z = true;
            if (this.iEL.casObserverRef(null, jVar)) {
                jVar.add(rx.subscriptions.e.j(new rx.functions.a() { // from class: rx.internal.operators.BufferUntilSubscriber.a.1
                    @Override // rx.functions.a
                    public void call() {
                        a.this.iEL.set(BufferUntilSubscriber.iEN);
                    }
                }));
                synchronized (this.iEL.guard) {
                    if (this.iEL.emitting) {
                        z = false;
                    } else {
                        this.iEL.emitting = true;
                    }
                }
                if (!z) {
                    return;
                }
                while (true) {
                    Object poll = this.iEL.buffer.poll();
                    if (poll != null) {
                        NotificationLite.a(this.iEL.get(), poll);
                    } else {
                        synchronized (this.iEL.guard) {
                            if (this.iEL.buffer.isEmpty()) {
                                this.iEL.emitting = false;
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
        this.iEL = state;
    }

    private void aX(Object obj) {
        synchronized (this.iEL.guard) {
            this.iEL.buffer.add(obj);
            if (this.iEL.get() != null && !this.iEL.emitting) {
                this.iEM = true;
                this.iEL.emitting = true;
            }
        }
        if (!this.iEM) {
            return;
        }
        while (true) {
            Object poll = this.iEL.buffer.poll();
            if (poll != null) {
                NotificationLite.a(this.iEL.get(), poll);
            } else {
                return;
            }
        }
    }

    @Override // rx.e
    public void onCompleted() {
        if (this.iEM) {
            this.iEL.get().onCompleted();
        } else {
            aX(NotificationLite.cdX());
        }
    }

    @Override // rx.e
    public void onError(Throwable th) {
        if (this.iEM) {
            this.iEL.get().onError(th);
        } else {
            aX(NotificationLite.M(th));
        }
    }

    @Override // rx.e
    public void onNext(T t) {
        if (this.iEM) {
            this.iEL.get().onNext(t);
        } else {
            aX(NotificationLite.aY(t));
        }
    }

    @Override // rx.subjects.c
    public boolean hasObservers() {
        boolean z;
        synchronized (this.iEL.guard) {
            z = this.iEL.get() != null;
        }
        return z;
    }
}
