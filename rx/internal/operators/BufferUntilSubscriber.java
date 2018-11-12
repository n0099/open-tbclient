package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import rx.d;
/* loaded from: classes2.dex */
public final class BufferUntilSubscriber<T> extends rx.subjects.c<T, T> {
    static final rx.e iuu = new rx.e() { // from class: rx.internal.operators.BufferUntilSubscriber.1
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
    final State<T> ius;
    private boolean iut;

    public static <T> BufferUntilSubscriber<T> cba() {
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
        final State<T> ius;

        @Override // rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((rx.j) ((rx.j) obj));
        }

        public a(State<T> state) {
            this.ius = state;
        }

        public void call(rx.j<? super T> jVar) {
            boolean z = true;
            if (this.ius.casObserverRef(null, jVar)) {
                jVar.add(rx.subscriptions.e.j(new rx.functions.a() { // from class: rx.internal.operators.BufferUntilSubscriber.a.1
                    @Override // rx.functions.a
                    public void call() {
                        a.this.ius.set(BufferUntilSubscriber.iuu);
                    }
                }));
                synchronized (this.ius.guard) {
                    if (this.ius.emitting) {
                        z = false;
                    } else {
                        this.ius.emitting = true;
                    }
                }
                if (!z) {
                    return;
                }
                while (true) {
                    Object poll = this.ius.buffer.poll();
                    if (poll != null) {
                        NotificationLite.a(this.ius.get(), poll);
                    } else {
                        synchronized (this.ius.guard) {
                            if (this.ius.buffer.isEmpty()) {
                                this.ius.emitting = false;
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
        this.ius = state;
    }

    private void aW(Object obj) {
        synchronized (this.ius.guard) {
            this.ius.buffer.add(obj);
            if (this.ius.get() != null && !this.ius.emitting) {
                this.iut = true;
                this.ius.emitting = true;
            }
        }
        if (!this.iut) {
            return;
        }
        while (true) {
            Object poll = this.ius.buffer.poll();
            if (poll != null) {
                NotificationLite.a(this.ius.get(), poll);
            } else {
                return;
            }
        }
    }

    @Override // rx.e
    public void onCompleted() {
        if (this.iut) {
            this.ius.get().onCompleted();
        } else {
            aW(NotificationLite.cbe());
        }
    }

    @Override // rx.e
    public void onError(Throwable th) {
        if (this.iut) {
            this.ius.get().onError(th);
        } else {
            aW(NotificationLite.M(th));
        }
    }

    @Override // rx.e
    public void onNext(T t) {
        if (this.iut) {
            this.ius.get().onNext(t);
        } else {
            aW(NotificationLite.aX(t));
        }
    }

    @Override // rx.subjects.c
    public boolean hasObservers() {
        boolean z;
        synchronized (this.ius.guard) {
            z = this.ius.get() != null;
        }
        return z;
    }
}
