package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import rx.d;
/* loaded from: classes2.dex */
public final class BufferUntilSubscriber<T> extends rx.subjects.c<T, T> {
    static final rx.e iBD = new rx.e() { // from class: rx.internal.operators.BufferUntilSubscriber.1
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
    final State<T> iBB;
    private boolean iBC;

    public static <T> BufferUntilSubscriber<T> cdc() {
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
        final State<T> iBB;

        @Override // rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((rx.j) ((rx.j) obj));
        }

        public a(State<T> state) {
            this.iBB = state;
        }

        public void call(rx.j<? super T> jVar) {
            boolean z = true;
            if (this.iBB.casObserverRef(null, jVar)) {
                jVar.add(rx.subscriptions.e.j(new rx.functions.a() { // from class: rx.internal.operators.BufferUntilSubscriber.a.1
                    @Override // rx.functions.a
                    public void call() {
                        a.this.iBB.set(BufferUntilSubscriber.iBD);
                    }
                }));
                synchronized (this.iBB.guard) {
                    if (this.iBB.emitting) {
                        z = false;
                    } else {
                        this.iBB.emitting = true;
                    }
                }
                if (!z) {
                    return;
                }
                while (true) {
                    Object poll = this.iBB.buffer.poll();
                    if (poll != null) {
                        NotificationLite.a(this.iBB.get(), poll);
                    } else {
                        synchronized (this.iBB.guard) {
                            if (this.iBB.buffer.isEmpty()) {
                                this.iBB.emitting = false;
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
        this.iBB = state;
    }

    private void aX(Object obj) {
        synchronized (this.iBB.guard) {
            this.iBB.buffer.add(obj);
            if (this.iBB.get() != null && !this.iBB.emitting) {
                this.iBC = true;
                this.iBB.emitting = true;
            }
        }
        if (!this.iBC) {
            return;
        }
        while (true) {
            Object poll = this.iBB.buffer.poll();
            if (poll != null) {
                NotificationLite.a(this.iBB.get(), poll);
            } else {
                return;
            }
        }
    }

    @Override // rx.e
    public void onCompleted() {
        if (this.iBC) {
            this.iBB.get().onCompleted();
        } else {
            aX(NotificationLite.cdg());
        }
    }

    @Override // rx.e
    public void onError(Throwable th) {
        if (this.iBC) {
            this.iBB.get().onError(th);
        } else {
            aX(NotificationLite.M(th));
        }
    }

    @Override // rx.e
    public void onNext(T t) {
        if (this.iBC) {
            this.iBB.get().onNext(t);
        } else {
            aX(NotificationLite.aY(t));
        }
    }

    @Override // rx.subjects.c
    public boolean hasObservers() {
        boolean z;
        synchronized (this.iBB.guard) {
            z = this.iBB.get() != null;
        }
        return z;
    }
}
