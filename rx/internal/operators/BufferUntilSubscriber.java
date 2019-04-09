package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import rx.d;
/* loaded from: classes2.dex */
public final class BufferUntilSubscriber<T> extends rx.subjects.c<T, T> {
    static final rx.e jUW = new rx.e() { // from class: rx.internal.operators.BufferUntilSubscriber.1
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
    final State<T> jUU;
    private boolean jUV;

    public static <T> BufferUntilSubscriber<T> cDO() {
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
        final State<T> jUU;

        @Override // rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((rx.j) ((rx.j) obj));
        }

        public a(State<T> state) {
            this.jUU = state;
        }

        public void call(rx.j<? super T> jVar) {
            boolean z = true;
            if (this.jUU.casObserverRef(null, jVar)) {
                jVar.add(rx.subscriptions.e.l(new rx.functions.a() { // from class: rx.internal.operators.BufferUntilSubscriber.a.1
                    @Override // rx.functions.a
                    public void call() {
                        a.this.jUU.set(BufferUntilSubscriber.jUW);
                    }
                }));
                synchronized (this.jUU.guard) {
                    if (this.jUU.emitting) {
                        z = false;
                    } else {
                        this.jUU.emitting = true;
                    }
                }
                if (!z) {
                    return;
                }
                while (true) {
                    Object poll = this.jUU.buffer.poll();
                    if (poll != null) {
                        NotificationLite.a(this.jUU.get(), poll);
                    } else {
                        synchronized (this.jUU.guard) {
                            if (this.jUU.buffer.isEmpty()) {
                                this.jUU.emitting = false;
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
        this.jUU = state;
    }

    private void bl(Object obj) {
        synchronized (this.jUU.guard) {
            this.jUU.buffer.add(obj);
            if (this.jUU.get() != null && !this.jUU.emitting) {
                this.jUV = true;
                this.jUU.emitting = true;
            }
        }
        if (!this.jUV) {
            return;
        }
        while (true) {
            Object poll = this.jUU.buffer.poll();
            if (poll != null) {
                NotificationLite.a(this.jUU.get(), poll);
            } else {
                return;
            }
        }
    }

    @Override // rx.e
    public void onCompleted() {
        if (this.jUV) {
            this.jUU.get().onCompleted();
        } else {
            bl(NotificationLite.cDR());
        }
    }

    @Override // rx.e
    public void onError(Throwable th) {
        if (this.jUV) {
            this.jUU.get().onError(th);
        } else {
            bl(NotificationLite.O(th));
        }
    }

    @Override // rx.e
    public void onNext(T t) {
        if (this.jUV) {
            this.jUU.get().onNext(t);
        } else {
            bl(NotificationLite.bm(t));
        }
    }
}
