package rx.internal.operators;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.d;
import rx.exceptions.MissingBackpressureException;
/* loaded from: classes14.dex */
public final class OperatorBufferWithSize<T> implements d.b<List<T>, T> {
    final int count;
    final int skip;

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public rx.j<? super T> call(rx.j<? super List<T>> jVar) {
        if (this.skip == this.count) {
            a aVar = new a(jVar, this.count);
            jVar.add(aVar);
            jVar.setProducer(aVar.eFJ());
            return aVar;
        } else if (this.skip > this.count) {
            BufferSkip bufferSkip = new BufferSkip(jVar, this.count, this.skip);
            jVar.add(bufferSkip);
            jVar.setProducer(bufferSkip.eFJ());
            return bufferSkip;
        } else {
            BufferOverlap bufferOverlap = new BufferOverlap(jVar, this.count, this.skip);
            jVar.add(bufferOverlap);
            jVar.setProducer(bufferOverlap.eFJ());
            return bufferOverlap;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public static final class a<T> extends rx.j<T> {
        final rx.j<? super List<T>> actual;
        List<T> buffer;
        final int count;

        public a(rx.j<? super List<T>> jVar, int i) {
            this.actual = jVar;
            this.count = i;
            request(0L);
        }

        @Override // rx.e
        public void onNext(T t) {
            List list = this.buffer;
            if (list == null) {
                list = new ArrayList(this.count);
                this.buffer = list;
            }
            list.add(t);
            if (list.size() == this.count) {
                this.buffer = null;
                this.actual.onNext(list);
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            this.buffer = null;
            this.actual.onError(th);
        }

        @Override // rx.e
        public void onCompleted() {
            List<T> list = this.buffer;
            if (list != null) {
                this.actual.onNext(list);
            }
            this.actual.onCompleted();
        }

        rx.f eFJ() {
            return new rx.f() { // from class: rx.internal.operators.OperatorBufferWithSize.a.1
                @Override // rx.f
                public void request(long j) {
                    if (j < 0) {
                        throw new IllegalArgumentException("n >= required but it was " + j);
                    }
                    if (j != 0) {
                        a.this.request(rx.internal.operators.a.P(j, a.this.count));
                    }
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public static final class BufferSkip<T> extends rx.j<T> {
        final rx.j<? super List<T>> actual;
        List<T> buffer;
        final int count;
        long index;
        final int skip;

        public BufferSkip(rx.j<? super List<T>> jVar, int i, int i2) {
            this.actual = jVar;
            this.count = i;
            this.skip = i2;
            request(0L);
        }

        @Override // rx.e
        public void onNext(T t) {
            long j = this.index;
            List list = this.buffer;
            if (j == 0) {
                list = new ArrayList(this.count);
                this.buffer = list;
            }
            long j2 = j + 1;
            if (j2 == this.skip) {
                this.index = 0L;
            } else {
                this.index = j2;
            }
            if (list != null) {
                list.add(t);
                if (list.size() == this.count) {
                    this.buffer = null;
                    this.actual.onNext(list);
                }
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            this.buffer = null;
            this.actual.onError(th);
        }

        @Override // rx.e
        public void onCompleted() {
            List<T> list = this.buffer;
            if (list != null) {
                this.buffer = null;
                this.actual.onNext(list);
            }
            this.actual.onCompleted();
        }

        rx.f eFJ() {
            return new BufferSkipProducer();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes14.dex */
        public final class BufferSkipProducer extends AtomicBoolean implements rx.f {
            private static final long serialVersionUID = 3428177408082367154L;

            BufferSkipProducer() {
            }

            @Override // rx.f
            public void request(long j) {
                if (j < 0) {
                    throw new IllegalArgumentException("n >= 0 required but it was " + j);
                }
                if (j != 0) {
                    BufferSkip bufferSkip = BufferSkip.this;
                    if (get() || !compareAndSet(false, true)) {
                        bufferSkip.request(rx.internal.operators.a.P(j, bufferSkip.skip));
                    } else {
                        bufferSkip.request(rx.internal.operators.a.O(rx.internal.operators.a.P(j, bufferSkip.count), rx.internal.operators.a.P(bufferSkip.skip - bufferSkip.count, j - 1)));
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public static final class BufferOverlap<T> extends rx.j<T> {
        final rx.j<? super List<T>> actual;
        final int count;
        long index;
        long produced;
        final ArrayDeque<List<T>> qha = new ArrayDeque<>();
        final AtomicLong requested = new AtomicLong();
        final int skip;

        public BufferOverlap(rx.j<? super List<T>> jVar, int i, int i2) {
            this.actual = jVar;
            this.count = i;
            this.skip = i2;
            request(0L);
        }

        @Override // rx.e
        public void onNext(T t) {
            long j = this.index;
            if (j == 0) {
                this.qha.offer(new ArrayList(this.count));
            }
            long j2 = j + 1;
            if (j2 == this.skip) {
                this.index = 0L;
            } else {
                this.index = j2;
            }
            Iterator<List<T>> it = this.qha.iterator();
            while (it.hasNext()) {
                it.next().add(t);
            }
            List<T> peek = this.qha.peek();
            if (peek != null && peek.size() == this.count) {
                this.qha.poll();
                this.produced++;
                this.actual.onNext(peek);
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            this.qha.clear();
            this.actual.onError(th);
        }

        @Override // rx.e
        public void onCompleted() {
            long j = this.produced;
            if (j != 0) {
                if (j > this.requested.get()) {
                    this.actual.onError(new MissingBackpressureException("More produced than requested? " + j));
                    return;
                }
                this.requested.addAndGet(-j);
            }
            rx.internal.operators.a.a(this.requested, this.qha, this.actual);
        }

        rx.f eFJ() {
            return new BufferOverlapProducer();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes14.dex */
        public final class BufferOverlapProducer extends AtomicBoolean implements rx.f {
            private static final long serialVersionUID = -4015894850868853147L;

            BufferOverlapProducer() {
            }

            @Override // rx.f
            public void request(long j) {
                BufferOverlap bufferOverlap = BufferOverlap.this;
                if (rx.internal.operators.a.a(bufferOverlap.requested, j, bufferOverlap.qha, bufferOverlap.actual) && j != 0) {
                    if (get() || !compareAndSet(false, true)) {
                        bufferOverlap.request(rx.internal.operators.a.P(bufferOverlap.skip, j));
                    } else {
                        bufferOverlap.request(rx.internal.operators.a.O(rx.internal.operators.a.P(bufferOverlap.skip, j - 1), bufferOverlap.count));
                    }
                }
            }
        }
    }
}
