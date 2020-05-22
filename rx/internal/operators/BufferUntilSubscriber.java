package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import rx.d;
/* loaded from: classes6.dex */
public final class BufferUntilSubscriber<T> extends rx.subjects.c<T, T> {
    static final rx.e nEn = new rx.e() { // from class: rx.internal.operators.BufferUntilSubscriber.1
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
    final State<T> nEl;
    private boolean nEm;

    public static <T> BufferUntilSubscriber<T> dPA() {
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
        final State<T> nEl;

        @Override // rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((rx.j) ((rx.j) obj));
        }

        public a(State<T> state) {
            this.nEl = state;
        }

        public void call(rx.j<? super T> jVar) {
            boolean z = true;
            if (this.nEl.casObserverRef(null, jVar)) {
                jVar.add(rx.subscriptions.e.l(new rx.functions.a() { // from class: rx.internal.operators.BufferUntilSubscriber.a.1
                    @Override // rx.functions.a
                    public void call() {
                        a.this.nEl.set(BufferUntilSubscriber.nEn);
                    }
                }));
                synchronized (this.nEl.guard) {
                    if (this.nEl.emitting) {
                        z = false;
                    } else {
                        this.nEl.emitting = true;
                    }
                }
                if (!z) {
                    return;
                }
                while (true) {
                    Object poll = this.nEl.buffer.poll();
                    if (poll != null) {
                        NotificationLite.a(this.nEl.get(), poll);
                    } else {
                        synchronized (this.nEl.guard) {
                            if (this.nEl.buffer.isEmpty()) {
                                this.nEl.emitting = false;
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
        this.nEl = state;
    }

    private void bT(Object obj) {
        synchronized (this.nEl.guard) {
            this.nEl.buffer.add(obj);
            if (this.nEl.get() != null && !this.nEl.emitting) {
                this.nEm = true;
                this.nEl.emitting = true;
            }
        }
        if (!this.nEm) {
            return;
        }
        while (true) {
            Object poll = this.nEl.buffer.poll();
            if (poll != null) {
                NotificationLite.a(this.nEl.get(), poll);
            } else {
                return;
            }
        }
    }

    @Override // rx.e
    public void onCompleted() {
        if (this.nEm) {
            this.nEl.get().onCompleted();
        } else {
            bT(NotificationLite.dPB());
        }
    }

    @Override // rx.e
    public void onError(Throwable th) {
        if (this.nEm) {
            this.nEl.get().onError(th);
        } else {
            bT(NotificationLite.error(th));
        }
    }

    @Override // rx.e
    public void onNext(T t) {
        if (this.nEm) {
            this.nEl.get().onNext(t);
        } else {
            bT(NotificationLite.next(t));
        }
    }
}
