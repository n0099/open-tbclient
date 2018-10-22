package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import rx.d;
/* loaded from: classes2.dex */
public final class BufferUntilSubscriber<T> extends rx.subjects.c<T, T> {
    static final rx.e isK = new rx.e() { // from class: rx.internal.operators.BufferUntilSubscriber.1
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
    final State<T> isI;
    private boolean isJ;

    public static <T> BufferUntilSubscriber<T> cbD() {
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
        final State<T> isI;

        @Override // rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((rx.j) ((rx.j) obj));
        }

        public a(State<T> state) {
            this.isI = state;
        }

        public void call(rx.j<? super T> jVar) {
            boolean z = true;
            if (this.isI.casObserverRef(null, jVar)) {
                jVar.add(rx.subscriptions.e.j(new rx.functions.a() { // from class: rx.internal.operators.BufferUntilSubscriber.a.1
                    @Override // rx.functions.a
                    public void call() {
                        a.this.isI.set(BufferUntilSubscriber.isK);
                    }
                }));
                synchronized (this.isI.guard) {
                    if (this.isI.emitting) {
                        z = false;
                    } else {
                        this.isI.emitting = true;
                    }
                }
                if (!z) {
                    return;
                }
                while (true) {
                    Object poll = this.isI.buffer.poll();
                    if (poll != null) {
                        NotificationLite.a(this.isI.get(), poll);
                    } else {
                        synchronized (this.isI.guard) {
                            if (this.isI.buffer.isEmpty()) {
                                this.isI.emitting = false;
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
        this.isI = state;
    }

    private void aX(Object obj) {
        synchronized (this.isI.guard) {
            this.isI.buffer.add(obj);
            if (this.isI.get() != null && !this.isI.emitting) {
                this.isJ = true;
                this.isI.emitting = true;
            }
        }
        if (!this.isJ) {
            return;
        }
        while (true) {
            Object poll = this.isI.buffer.poll();
            if (poll != null) {
                NotificationLite.a(this.isI.get(), poll);
            } else {
                return;
            }
        }
    }

    @Override // rx.e
    public void onCompleted() {
        if (this.isJ) {
            this.isI.get().onCompleted();
        } else {
            aX(NotificationLite.cbH());
        }
    }

    @Override // rx.e
    public void onError(Throwable th) {
        if (this.isJ) {
            this.isI.get().onError(th);
        } else {
            aX(NotificationLite.M(th));
        }
    }

    @Override // rx.e
    public void onNext(T t) {
        if (this.isJ) {
            this.isI.get().onNext(t);
        } else {
            aX(NotificationLite.aY(t));
        }
    }

    @Override // rx.subjects.c
    public boolean hasObservers() {
        boolean z;
        synchronized (this.isI.guard) {
            z = this.isI.get() != null;
        }
        return z;
    }
}
