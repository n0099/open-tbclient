package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import rx.d;
/* loaded from: classes2.dex */
public final class BufferUntilSubscriber<T> extends rx.subjects.c<T, T> {
    static final rx.e isJ = new rx.e() { // from class: rx.internal.operators.BufferUntilSubscriber.1
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
    final State<T> isH;
    private boolean isI;

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
        final State<T> isH;

        @Override // rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((rx.j) ((rx.j) obj));
        }

        public a(State<T> state) {
            this.isH = state;
        }

        public void call(rx.j<? super T> jVar) {
            boolean z = true;
            if (this.isH.casObserverRef(null, jVar)) {
                jVar.add(rx.subscriptions.e.j(new rx.functions.a() { // from class: rx.internal.operators.BufferUntilSubscriber.a.1
                    @Override // rx.functions.a
                    public void call() {
                        a.this.isH.set(BufferUntilSubscriber.isJ);
                    }
                }));
                synchronized (this.isH.guard) {
                    if (this.isH.emitting) {
                        z = false;
                    } else {
                        this.isH.emitting = true;
                    }
                }
                if (!z) {
                    return;
                }
                while (true) {
                    Object poll = this.isH.buffer.poll();
                    if (poll != null) {
                        NotificationLite.a(this.isH.get(), poll);
                    } else {
                        synchronized (this.isH.guard) {
                            if (this.isH.buffer.isEmpty()) {
                                this.isH.emitting = false;
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
        this.isH = state;
    }

    private void aX(Object obj) {
        synchronized (this.isH.guard) {
            this.isH.buffer.add(obj);
            if (this.isH.get() != null && !this.isH.emitting) {
                this.isI = true;
                this.isH.emitting = true;
            }
        }
        if (!this.isI) {
            return;
        }
        while (true) {
            Object poll = this.isH.buffer.poll();
            if (poll != null) {
                NotificationLite.a(this.isH.get(), poll);
            } else {
                return;
            }
        }
    }

    @Override // rx.e
    public void onCompleted() {
        if (this.isI) {
            this.isH.get().onCompleted();
        } else {
            aX(NotificationLite.cbH());
        }
    }

    @Override // rx.e
    public void onError(Throwable th) {
        if (this.isI) {
            this.isH.get().onError(th);
        } else {
            aX(NotificationLite.M(th));
        }
    }

    @Override // rx.e
    public void onNext(T t) {
        if (this.isI) {
            this.isH.get().onNext(t);
        } else {
            aX(NotificationLite.aY(t));
        }
    }

    @Override // rx.subjects.c
    public boolean hasObservers() {
        boolean z;
        synchronized (this.isH.guard) {
            z = this.isH.get() != null;
        }
        return z;
    }
}
