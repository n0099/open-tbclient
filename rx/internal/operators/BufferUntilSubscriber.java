package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import rx.d;
/* loaded from: classes6.dex */
public final class BufferUntilSubscriber<T> extends rx.subjects.c<T, T> {
    static final rx.e nNG = new rx.e() { // from class: rx.internal.operators.BufferUntilSubscriber.1
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
    final State<T> nNE;
    private boolean nNF;

    public static <T> BufferUntilSubscriber<T> dOi() {
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
        final State<T> nNE;

        @Override // rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((rx.j) ((rx.j) obj));
        }

        public a(State<T> state) {
            this.nNE = state;
        }

        public void call(rx.j<? super T> jVar) {
            boolean z = true;
            if (this.nNE.casObserverRef(null, jVar)) {
                jVar.add(rx.subscriptions.e.l(new rx.functions.a() { // from class: rx.internal.operators.BufferUntilSubscriber.a.1
                    @Override // rx.functions.a
                    public void call() {
                        a.this.nNE.set(BufferUntilSubscriber.nNG);
                    }
                }));
                synchronized (this.nNE.guard) {
                    if (this.nNE.emitting) {
                        z = false;
                    } else {
                        this.nNE.emitting = true;
                    }
                }
                if (!z) {
                    return;
                }
                while (true) {
                    Object poll = this.nNE.buffer.poll();
                    if (poll != null) {
                        NotificationLite.a(this.nNE.get(), poll);
                    } else {
                        synchronized (this.nNE.guard) {
                            if (this.nNE.buffer.isEmpty()) {
                                this.nNE.emitting = false;
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
        this.nNE = state;
    }

    private void cd(Object obj) {
        synchronized (this.nNE.guard) {
            this.nNE.buffer.add(obj);
            if (this.nNE.get() != null && !this.nNE.emitting) {
                this.nNF = true;
                this.nNE.emitting = true;
            }
        }
        if (!this.nNF) {
            return;
        }
        while (true) {
            Object poll = this.nNE.buffer.poll();
            if (poll != null) {
                NotificationLite.a(this.nNE.get(), poll);
            } else {
                return;
            }
        }
    }

    @Override // rx.e
    public void onCompleted() {
        if (this.nNF) {
            this.nNE.get().onCompleted();
        } else {
            cd(NotificationLite.dOj());
        }
    }

    @Override // rx.e
    public void onError(Throwable th) {
        if (this.nNF) {
            this.nNE.get().onError(th);
        } else {
            cd(NotificationLite.error(th));
        }
    }

    @Override // rx.e
    public void onNext(T t) {
        if (this.nNF) {
            this.nNE.get().onNext(t);
        } else {
            cd(NotificationLite.next(t));
        }
    }
}
