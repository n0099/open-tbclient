package rx.subjects;

import com.baidu.tieba.asa;
import com.baidu.tieba.ewa;
import com.baidu.tieba.ora;
import com.baidu.tieba.pra;
import com.baidu.tieba.ura;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes9.dex */
public final class ReplaySubject$ReplayState<T> extends AtomicReference<ReplaySubject$ReplayProducer<T>[]> implements ora.a<T>, pra<T> {
    public static final ReplaySubject$ReplayProducer[] EMPTY = new ReplaySubject$ReplayProducer[0];
    public static final ReplaySubject$ReplayProducer[] TERMINATED = new ReplaySubject$ReplayProducer[0];
    public static final long serialVersionUID = 5952362471246910544L;
    public final ewa<T> buffer;

    public boolean isTerminated() {
        if (get() == TERMINATED) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.pra
    public void onCompleted() {
        ewa<T> ewaVar = this.buffer;
        ewaVar.complete();
        for (ReplaySubject$ReplayProducer<T> replaySubject$ReplayProducer : getAndSet(TERMINATED)) {
            ewaVar.a(replaySubject$ReplayProducer);
        }
    }

    public ReplaySubject$ReplayState(ewa<T> ewaVar) {
        this.buffer = ewaVar;
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

    public void call(ura<? super T> uraVar) {
        ReplaySubject$ReplayProducer<T> replaySubject$ReplayProducer = new ReplaySubject$ReplayProducer<>(uraVar, this);
        uraVar.b(replaySubject$ReplayProducer);
        uraVar.f(replaySubject$ReplayProducer);
        if (add(replaySubject$ReplayProducer) && replaySubject$ReplayProducer.isUnsubscribed()) {
            remove(replaySubject$ReplayProducer);
        } else {
            this.buffer.a(replaySubject$ReplayProducer);
        }
    }

    @Override // com.baidu.tieba.pra
    public void onError(Throwable th) {
        ewa<T> ewaVar = this.buffer;
        ewaVar.error(th);
        ArrayList arrayList = null;
        for (ReplaySubject$ReplayProducer<T> replaySubject$ReplayProducer : getAndSet(TERMINATED)) {
            try {
                ewaVar.a(replaySubject$ReplayProducer);
            } catch (Throwable th2) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(th2);
            }
        }
        asa.d(arrayList);
    }

    @Override // com.baidu.tieba.pra
    public void onNext(T t) {
        ewa<T> ewaVar = this.buffer;
        ewaVar.next(t);
        for (ReplaySubject$ReplayProducer<T> replaySubject$ReplayProducer : get()) {
            ewaVar.a(replaySubject$ReplayProducer);
        }
    }

    @Override // com.baidu.tieba.ora.a, com.baidu.tieba.csa
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((ura) ((ura) obj));
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
