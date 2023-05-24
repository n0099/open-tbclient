package rx.subjects;

import com.baidu.tieba.bcb;
import com.baidu.tieba.i7b;
import com.baidu.tieba.j7b;
import com.baidu.tieba.o7b;
import com.baidu.tieba.u7b;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes10.dex */
public final class ReplaySubject$ReplayState<T> extends AtomicReference<ReplaySubject$ReplayProducer<T>[]> implements i7b.a<T>, j7b<T> {
    public static final ReplaySubject$ReplayProducer[] EMPTY = new ReplaySubject$ReplayProducer[0];
    public static final ReplaySubject$ReplayProducer[] TERMINATED = new ReplaySubject$ReplayProducer[0];
    public static final long serialVersionUID = 5952362471246910544L;
    public final bcb<T> buffer;

    public boolean isTerminated() {
        if (get() == TERMINATED) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.j7b
    public void onCompleted() {
        bcb<T> bcbVar = this.buffer;
        bcbVar.complete();
        for (ReplaySubject$ReplayProducer<T> replaySubject$ReplayProducer : getAndSet(TERMINATED)) {
            bcbVar.a(replaySubject$ReplayProducer);
        }
    }

    public ReplaySubject$ReplayState(bcb<T> bcbVar) {
        this.buffer = bcbVar;
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

    public void call(o7b<? super T> o7bVar) {
        ReplaySubject$ReplayProducer<T> replaySubject$ReplayProducer = new ReplaySubject$ReplayProducer<>(o7bVar, this);
        o7bVar.b(replaySubject$ReplayProducer);
        o7bVar.f(replaySubject$ReplayProducer);
        if (add(replaySubject$ReplayProducer) && replaySubject$ReplayProducer.isUnsubscribed()) {
            remove(replaySubject$ReplayProducer);
        } else {
            this.buffer.a(replaySubject$ReplayProducer);
        }
    }

    @Override // com.baidu.tieba.j7b
    public void onError(Throwable th) {
        bcb<T> bcbVar = this.buffer;
        bcbVar.error(th);
        ArrayList arrayList = null;
        for (ReplaySubject$ReplayProducer<T> replaySubject$ReplayProducer : getAndSet(TERMINATED)) {
            try {
                bcbVar.a(replaySubject$ReplayProducer);
            } catch (Throwable th2) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(th2);
            }
        }
        u7b.d(arrayList);
    }

    @Override // com.baidu.tieba.j7b
    public void onNext(T t) {
        bcb<T> bcbVar = this.buffer;
        bcbVar.next(t);
        for (ReplaySubject$ReplayProducer<T> replaySubject$ReplayProducer : get()) {
            bcbVar.a(replaySubject$ReplayProducer);
        }
    }

    @Override // com.baidu.tieba.i7b.a, com.baidu.tieba.w7b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((o7b) ((o7b) obj));
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
