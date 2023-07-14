package rx.subjects;

import com.baidu.tieba.a2c;
import com.baidu.tieba.g2c;
import com.baidu.tieba.q6c;
import com.baidu.tieba.u1c;
import com.baidu.tieba.v1c;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class ReplaySubject$ReplayState<T> extends AtomicReference<ReplaySubject$ReplayProducer<T>[]> implements u1c.a<T>, v1c<T> {
    public static final ReplaySubject$ReplayProducer[] EMPTY = new ReplaySubject$ReplayProducer[0];
    public static final ReplaySubject$ReplayProducer[] TERMINATED = new ReplaySubject$ReplayProducer[0];
    public static final long serialVersionUID = 5952362471246910544L;
    public final q6c<T> buffer;

    public boolean isTerminated() {
        if (get() == TERMINATED) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.v1c
    public void onCompleted() {
        q6c<T> q6cVar = this.buffer;
        q6cVar.complete();
        for (ReplaySubject$ReplayProducer<T> replaySubject$ReplayProducer : getAndSet(TERMINATED)) {
            q6cVar.a(replaySubject$ReplayProducer);
        }
    }

    public ReplaySubject$ReplayState(q6c<T> q6cVar) {
        this.buffer = q6cVar;
        lazySet(EMPTY);
    }

    public boolean add(ReplaySubject$ReplayProducer<T> replaySubject$ReplayProducer) {
        ReplaySubject$ReplayProducer<T>[] replaySubject$ReplayProducerArr;
        ReplaySubject$ReplayProducer[] replaySubject$ReplayProducerArr2;
        do {
            replaySubject$ReplayProducerArr = get();
            if (replaySubject$ReplayProducerArr == TERMINATED) {
                return false;
            }
            int length = replaySubject$ReplayProducerArr.length;
            replaySubject$ReplayProducerArr2 = new ReplaySubject$ReplayProducer[length + 1];
            System.arraycopy(replaySubject$ReplayProducerArr, 0, replaySubject$ReplayProducerArr2, 0, length);
            replaySubject$ReplayProducerArr2[length] = replaySubject$ReplayProducer;
        } while (!compareAndSet(replaySubject$ReplayProducerArr, replaySubject$ReplayProducerArr2));
        return true;
    }

    public void call(a2c<? super T> a2cVar) {
        ReplaySubject$ReplayProducer<T> replaySubject$ReplayProducer = new ReplaySubject$ReplayProducer<>(a2cVar, this);
        a2cVar.b(replaySubject$ReplayProducer);
        a2cVar.f(replaySubject$ReplayProducer);
        if (add(replaySubject$ReplayProducer) && replaySubject$ReplayProducer.isUnsubscribed()) {
            remove(replaySubject$ReplayProducer);
        } else {
            this.buffer.a(replaySubject$ReplayProducer);
        }
    }

    @Override // com.baidu.tieba.v1c
    public void onError(Throwable th) {
        q6c<T> q6cVar = this.buffer;
        q6cVar.error(th);
        ArrayList arrayList = null;
        for (ReplaySubject$ReplayProducer<T> replaySubject$ReplayProducer : getAndSet(TERMINATED)) {
            try {
                q6cVar.a(replaySubject$ReplayProducer);
            } catch (Throwable th2) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(th2);
            }
        }
        g2c.d(arrayList);
    }

    @Override // com.baidu.tieba.v1c
    public void onNext(T t) {
        q6c<T> q6cVar = this.buffer;
        q6cVar.next(t);
        for (ReplaySubject$ReplayProducer<T> replaySubject$ReplayProducer : get()) {
            q6cVar.a(replaySubject$ReplayProducer);
        }
    }

    @Override // com.baidu.tieba.u1c.a, com.baidu.tieba.i2c
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((a2c) ((a2c) obj));
    }

    public void remove(ReplaySubject$ReplayProducer<T> replaySubject$ReplayProducer) {
        ReplaySubject$ReplayProducer<T>[] replaySubject$ReplayProducerArr;
        ReplaySubject$ReplayProducer[] replaySubject$ReplayProducerArr2;
        do {
            replaySubject$ReplayProducerArr = get();
            if (replaySubject$ReplayProducerArr != TERMINATED && replaySubject$ReplayProducerArr != EMPTY) {
                int length = replaySubject$ReplayProducerArr.length;
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (replaySubject$ReplayProducerArr[i2] == replaySubject$ReplayProducer) {
                        i = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i < 0) {
                    return;
                }
                if (length == 1) {
                    replaySubject$ReplayProducerArr2 = EMPTY;
                } else {
                    ReplaySubject$ReplayProducer[] replaySubject$ReplayProducerArr3 = new ReplaySubject$ReplayProducer[length - 1];
                    System.arraycopy(replaySubject$ReplayProducerArr, 0, replaySubject$ReplayProducerArr3, 0, i);
                    System.arraycopy(replaySubject$ReplayProducerArr, i + 1, replaySubject$ReplayProducerArr3, i, (length - i) - 1);
                    replaySubject$ReplayProducerArr2 = replaySubject$ReplayProducerArr3;
                }
            } else {
                return;
            }
        } while (!compareAndSet(replaySubject$ReplayProducerArr, replaySubject$ReplayProducerArr2));
    }
}
