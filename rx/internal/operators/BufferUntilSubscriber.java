package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import rx.d;
/* loaded from: classes6.dex */
public final class BufferUntilSubscriber<T> extends rx.subjects.c<T, T> {
    static final rx.e njn = new rx.e() { // from class: rx.internal.operators.BufferUntilSubscriber.1
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
    final State<T> njl;
    private boolean njm;

    public static <T> BufferUntilSubscriber<T> dHG() {
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
        final State<T> njl;

        @Override // rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((rx.j) ((rx.j) obj));
        }

        public a(State<T> state) {
            this.njl = state;
        }

        public void call(rx.j<? super T> jVar) {
            boolean z = true;
            if (this.njl.casObserverRef(null, jVar)) {
                jVar.add(rx.subscriptions.e.l(new rx.functions.a() { // from class: rx.internal.operators.BufferUntilSubscriber.a.1
                    @Override // rx.functions.a
                    public void call() {
                        a.this.njl.set(BufferUntilSubscriber.njn);
                    }
                }));
                synchronized (this.njl.guard) {
                    if (this.njl.emitting) {
                        z = false;
                    } else {
                        this.njl.emitting = true;
                    }
                }
                if (!z) {
                    return;
                }
                while (true) {
                    Object poll = this.njl.buffer.poll();
                    if (poll != null) {
                        NotificationLite.a(this.njl.get(), poll);
                    } else {
                        synchronized (this.njl.guard) {
                            if (this.njl.buffer.isEmpty()) {
                                this.njl.emitting = false;
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
        this.njl = state;
    }

    private void bN(Object obj) {
        synchronized (this.njl.guard) {
            this.njl.buffer.add(obj);
            if (this.njl.get() != null && !this.njl.emitting) {
                this.njm = true;
                this.njl.emitting = true;
            }
        }
        if (!this.njm) {
            return;
        }
        while (true) {
            Object poll = this.njl.buffer.poll();
            if (poll != null) {
                NotificationLite.a(this.njl.get(), poll);
            } else {
                return;
            }
        }
    }

    @Override // rx.e
    public void onCompleted() {
        if (this.njm) {
            this.njl.get().onCompleted();
        } else {
            bN(NotificationLite.dHH());
        }
    }

    @Override // rx.e
    public void onError(Throwable th) {
        if (this.njm) {
            this.njl.get().onError(th);
        } else {
            bN(NotificationLite.error(th));
        }
    }

    @Override // rx.e
    public void onNext(T t) {
        if (this.njm) {
            this.njl.get().onNext(t);
        } else {
            bN(NotificationLite.next(t));
        }
    }
}
