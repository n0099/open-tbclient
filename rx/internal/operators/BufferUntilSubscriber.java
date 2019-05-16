package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import rx.d;
/* loaded from: classes2.dex */
public final class BufferUntilSubscriber<T> extends rx.subjects.c<T, T> {
    static final rx.e knm = new rx.e() { // from class: rx.internal.operators.BufferUntilSubscriber.1
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
    final State<T> knk;
    private boolean knl;

    public static <T> BufferUntilSubscriber<T> cLu() {
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
        final State<T> knk;

        @Override // rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((rx.j) ((rx.j) obj));
        }

        public a(State<T> state) {
            this.knk = state;
        }

        public void call(rx.j<? super T> jVar) {
            boolean z = true;
            if (this.knk.casObserverRef(null, jVar)) {
                jVar.add(rx.subscriptions.e.l(new rx.functions.a() { // from class: rx.internal.operators.BufferUntilSubscriber.a.1
                    @Override // rx.functions.a
                    public void call() {
                        a.this.knk.set(BufferUntilSubscriber.knm);
                    }
                }));
                synchronized (this.knk.guard) {
                    if (this.knk.emitting) {
                        z = false;
                    } else {
                        this.knk.emitting = true;
                    }
                }
                if (!z) {
                    return;
                }
                while (true) {
                    Object poll = this.knk.buffer.poll();
                    if (poll != null) {
                        NotificationLite.a(this.knk.get(), poll);
                    } else {
                        synchronized (this.knk.guard) {
                            if (this.knk.buffer.isEmpty()) {
                                this.knk.emitting = false;
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
        this.knk = state;
    }

    private void bn(Object obj) {
        synchronized (this.knk.guard) {
            this.knk.buffer.add(obj);
            if (this.knk.get() != null && !this.knk.emitting) {
                this.knl = true;
                this.knk.emitting = true;
            }
        }
        if (!this.knl) {
            return;
        }
        while (true) {
            Object poll = this.knk.buffer.poll();
            if (poll != null) {
                NotificationLite.a(this.knk.get(), poll);
            } else {
                return;
            }
        }
    }

    @Override // rx.e
    public void onCompleted() {
        if (this.knl) {
            this.knk.get().onCompleted();
        } else {
            bn(NotificationLite.cLx());
        }
    }

    @Override // rx.e
    public void onError(Throwable th) {
        if (this.knl) {
            this.knk.get().onError(th);
        } else {
            bn(NotificationLite.N(th));
        }
    }

    @Override // rx.e
    public void onNext(T t) {
        if (this.knl) {
            this.knk.get().onNext(t);
        } else {
            bn(NotificationLite.bo(t));
        }
    }
}
