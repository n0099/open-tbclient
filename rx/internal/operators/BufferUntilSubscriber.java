package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import rx.d;
/* loaded from: classes6.dex */
public final class BufferUntilSubscriber<T> extends rx.subjects.c<T, T> {
    static final rx.e njk = new rx.e() { // from class: rx.internal.operators.BufferUntilSubscriber.1
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
    final State<T> nji;
    private boolean njj;

    public static <T> BufferUntilSubscriber<T> dHJ() {
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
        final State<T> nji;

        @Override // rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((rx.j) ((rx.j) obj));
        }

        public a(State<T> state) {
            this.nji = state;
        }

        public void call(rx.j<? super T> jVar) {
            boolean z = true;
            if (this.nji.casObserverRef(null, jVar)) {
                jVar.add(rx.subscriptions.e.l(new rx.functions.a() { // from class: rx.internal.operators.BufferUntilSubscriber.a.1
                    @Override // rx.functions.a
                    public void call() {
                        a.this.nji.set(BufferUntilSubscriber.njk);
                    }
                }));
                synchronized (this.nji.guard) {
                    if (this.nji.emitting) {
                        z = false;
                    } else {
                        this.nji.emitting = true;
                    }
                }
                if (!z) {
                    return;
                }
                while (true) {
                    Object poll = this.nji.buffer.poll();
                    if (poll != null) {
                        NotificationLite.a(this.nji.get(), poll);
                    } else {
                        synchronized (this.nji.guard) {
                            if (this.nji.buffer.isEmpty()) {
                                this.nji.emitting = false;
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
        this.nji = state;
    }

    private void bM(Object obj) {
        synchronized (this.nji.guard) {
            this.nji.buffer.add(obj);
            if (this.nji.get() != null && !this.nji.emitting) {
                this.njj = true;
                this.nji.emitting = true;
            }
        }
        if (!this.njj) {
            return;
        }
        while (true) {
            Object poll = this.nji.buffer.poll();
            if (poll != null) {
                NotificationLite.a(this.nji.get(), poll);
            } else {
                return;
            }
        }
    }

    @Override // rx.e
    public void onCompleted() {
        if (this.njj) {
            this.nji.get().onCompleted();
        } else {
            bM(NotificationLite.dHK());
        }
    }

    @Override // rx.e
    public void onError(Throwable th) {
        if (this.njj) {
            this.nji.get().onError(th);
        } else {
            bM(NotificationLite.error(th));
        }
    }

    @Override // rx.e
    public void onNext(T t) {
        if (this.njj) {
            this.nji.get().onNext(t);
        } else {
            bM(NotificationLite.next(t));
        }
    }
}
