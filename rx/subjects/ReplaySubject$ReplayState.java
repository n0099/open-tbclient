package rx.subjects;

import com.baidu.tieba.bab;
import com.baidu.tieba.j5b;
import com.baidu.tieba.k5b;
import com.baidu.tieba.p5b;
import com.baidu.tieba.v5b;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes9.dex */
public final class ReplaySubject$ReplayState<T> extends AtomicReference<ReplaySubject$ReplayProducer<T>[]> implements j5b.a<T>, k5b<T> {
    public static final ReplaySubject$ReplayProducer[] EMPTY = new ReplaySubject$ReplayProducer[0];
    public static final ReplaySubject$ReplayProducer[] TERMINATED = new ReplaySubject$ReplayProducer[0];
    public static final long serialVersionUID = 5952362471246910544L;
    public final bab<T> buffer;

    public boolean isTerminated() {
        if (get() == TERMINATED) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.k5b
    public void onCompleted() {
        bab<T> babVar = this.buffer;
        babVar.complete();
        for (ReplaySubject$ReplayProducer<T> replaySubject$ReplayProducer : getAndSet(TERMINATED)) {
            babVar.a(replaySubject$ReplayProducer);
        }
    }

    public ReplaySubject$ReplayState(bab<T> babVar) {
        this.buffer = babVar;
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

    public void call(p5b<? super T> p5bVar) {
        ReplaySubject$ReplayProducer<T> replaySubject$ReplayProducer = new ReplaySubject$ReplayProducer<>(p5bVar, this);
        p5bVar.b(replaySubject$ReplayProducer);
        p5bVar.f(replaySubject$ReplayProducer);
        if (add(replaySubject$ReplayProducer) && replaySubject$ReplayProducer.isUnsubscribed()) {
            remove(replaySubject$ReplayProducer);
        } else {
            this.buffer.a(replaySubject$ReplayProducer);
        }
    }

    @Override // com.baidu.tieba.k5b
    public void onError(Throwable th) {
        bab<T> babVar = this.buffer;
        babVar.error(th);
        ArrayList arrayList = null;
        for (ReplaySubject$ReplayProducer<T> replaySubject$ReplayProducer : getAndSet(TERMINATED)) {
            try {
                babVar.a(replaySubject$ReplayProducer);
            } catch (Throwable th2) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(th2);
            }
        }
        v5b.d(arrayList);
    }

    @Override // com.baidu.tieba.k5b
    public void onNext(T t) {
        bab<T> babVar = this.buffer;
        babVar.next(t);
        for (ReplaySubject$ReplayProducer<T> replaySubject$ReplayProducer : get()) {
            babVar.a(replaySubject$ReplayProducer);
        }
    }

    @Override // com.baidu.tieba.j5b.a, com.baidu.tieba.x5b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((p5b) ((p5b) obj));
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
