package rx.subjects;

import com.baidu.tieba.ebc;
import com.baidu.tieba.pfc;
import com.baidu.tieba.sac;
import com.baidu.tieba.tac;
import com.baidu.tieba.yac;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class ReplaySubject$ReplayState<T> extends AtomicReference<ReplaySubject$ReplayProducer<T>[]> implements sac.a<T>, tac<T> {
    public static final ReplaySubject$ReplayProducer[] EMPTY = new ReplaySubject$ReplayProducer[0];
    public static final ReplaySubject$ReplayProducer[] TERMINATED = new ReplaySubject$ReplayProducer[0];
    public static final long serialVersionUID = 5952362471246910544L;
    public final pfc<T> buffer;

    public boolean isTerminated() {
        if (get() == TERMINATED) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.tac
    public void onCompleted() {
        pfc<T> pfcVar = this.buffer;
        pfcVar.complete();
        for (ReplaySubject$ReplayProducer<T> replaySubject$ReplayProducer : getAndSet(TERMINATED)) {
            pfcVar.a(replaySubject$ReplayProducer);
        }
    }

    public ReplaySubject$ReplayState(pfc<T> pfcVar) {
        this.buffer = pfcVar;
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

    public void call(yac<? super T> yacVar) {
        ReplaySubject$ReplayProducer<T> replaySubject$ReplayProducer = new ReplaySubject$ReplayProducer<>(yacVar, this);
        yacVar.b(replaySubject$ReplayProducer);
        yacVar.f(replaySubject$ReplayProducer);
        if (add(replaySubject$ReplayProducer) && replaySubject$ReplayProducer.isUnsubscribed()) {
            remove(replaySubject$ReplayProducer);
        } else {
            this.buffer.a(replaySubject$ReplayProducer);
        }
    }

    @Override // com.baidu.tieba.tac
    public void onError(Throwable th) {
        pfc<T> pfcVar = this.buffer;
        pfcVar.error(th);
        ArrayList arrayList = null;
        for (ReplaySubject$ReplayProducer<T> replaySubject$ReplayProducer : getAndSet(TERMINATED)) {
            try {
                pfcVar.a(replaySubject$ReplayProducer);
            } catch (Throwable th2) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(th2);
            }
        }
        ebc.d(arrayList);
    }

    @Override // com.baidu.tieba.tac
    public void onNext(T t) {
        pfc<T> pfcVar = this.buffer;
        pfcVar.next(t);
        for (ReplaySubject$ReplayProducer<T> replaySubject$ReplayProducer : get()) {
            pfcVar.a(replaySubject$ReplayProducer);
        }
    }

    @Override // com.baidu.tieba.sac.a, com.baidu.tieba.gbc
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((yac) ((yac) obj));
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
