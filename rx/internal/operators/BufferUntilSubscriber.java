package rx.internal.operators;

import com.baidu.tieba.doc;
import com.baidu.tieba.eoc;
import com.baidu.tieba.etc;
import com.baidu.tieba.joc;
import com.baidu.tieba.jtc;
import com.baidu.tieba.qoc;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class BufferUntilSubscriber<T> extends etc<T, T> {
    public static final eoc d = new a();
    public final State<T> b;
    public boolean c;

    /* loaded from: classes2.dex */
    public static class a implements eoc {
        @Override // com.baidu.tieba.eoc
        public void onCompleted() {
        }

        @Override // com.baidu.tieba.eoc
        public void onError(Throwable th) {
        }

        @Override // com.baidu.tieba.eoc
        public void onNext(Object obj) {
        }
    }

    /* loaded from: classes2.dex */
    public static final class b<T> implements doc.a<T> {
        public final State<T> a;

        /* loaded from: classes2.dex */
        public class a implements qoc {
            public a() {
            }

            @Override // com.baidu.tieba.qoc
            public void call() {
                b.this.a.set(BufferUntilSubscriber.d);
            }
        }

        public b(State<T> state) {
            this.a = state;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.roc
        /* renamed from: a */
        public void call(joc<? super T> jocVar) {
            boolean z;
            if (this.a.casObserverRef(null, jocVar)) {
                jocVar.b(jtc.a(new a()));
                synchronized (this.a.guard) {
                    z = true;
                    if (!this.a.emitting) {
                        this.a.emitting = true;
                    } else {
                        z = false;
                    }
                }
                if (!z) {
                    return;
                }
                while (true) {
                    Object poll = this.a.buffer.poll();
                    if (poll != null) {
                        NotificationLite.a(this.a.get(), poll);
                    } else {
                        synchronized (this.a.guard) {
                            if (this.a.buffer.isEmpty()) {
                                this.a.emitting = false;
                                return;
                            }
                        }
                    }
                }
            } else {
                jocVar.onError(new IllegalStateException("Only one subscriber allowed!"));
            }
        }
    }

    public static <T> BufferUntilSubscriber<T> Q() {
        return new BufferUntilSubscriber<>(new State());
    }

    @Override // com.baidu.tieba.eoc
    public void onCompleted() {
        if (this.c) {
            this.b.get().onCompleted();
        } else {
            R(NotificationLite.b());
        }
    }

    /* loaded from: classes2.dex */
    public static final class State<T> extends AtomicReference<eoc<? super T>> {
        public static final long serialVersionUID = 8026705089538090368L;
        public boolean emitting;
        public final Object guard = new Object();
        public final ConcurrentLinkedQueue<Object> buffer = new ConcurrentLinkedQueue<>();

        public boolean casObserverRef(eoc<? super T> eocVar, eoc<? super T> eocVar2) {
            return compareAndSet(eocVar, eocVar2);
        }
    }

    public BufferUntilSubscriber(State<T> state) {
        super(new b(state));
        this.b = state;
    }

    @Override // com.baidu.tieba.eoc
    public void onError(Throwable th) {
        if (this.c) {
            this.b.get().onError(th);
        } else {
            R(NotificationLite.c(th));
        }
    }

    @Override // com.baidu.tieba.eoc
    public void onNext(T t) {
        if (this.c) {
            this.b.get().onNext(t);
        } else {
            R(NotificationLite.i(t));
        }
    }

    public final void R(Object obj) {
        synchronized (this.b.guard) {
            this.b.buffer.add(obj);
            if (this.b.get() != null && !this.b.emitting) {
                this.c = true;
                this.b.emitting = true;
            }
        }
        if (!this.c) {
            return;
        }
        while (true) {
            Object poll = this.b.buffer.poll();
            if (poll != null) {
                NotificationLite.a(this.b.get(), poll);
            } else {
                return;
            }
        }
    }
}
