package rx.internal.operators;

import com.baidu.tieba.bpa;
import com.baidu.tieba.ena;
import com.baidu.tieba.mna;
import com.baidu.tieba.mra;
import com.baidu.tieba.sma;
import com.baidu.tieba.tma;
import com.baidu.tieba.yma;
import java.util.concurrent.atomic.AtomicLong;
import rx.exceptions.MissingBackpressureException;
/* loaded from: classes9.dex */
public final class OperatorZip$Zip<R> extends AtomicLong {
    public static final int THRESHOLD = (int) (bpa.c * 0.7d);
    public static final long serialVersionUID = 5995274816189928317L;
    public final tma<? super R> child;
    public final mra childSubscription;
    public int emitted;
    public AtomicLong requested;
    public volatile Object[] subscribers;
    public final mna<? extends R> zipFunction;

    /* loaded from: classes9.dex */
    public final class a extends yma {
        public final bpa e = bpa.a();

        public a() {
        }

        public void g(long j) {
            e(j);
        }

        @Override // com.baidu.tieba.tma
        public void onError(Throwable th) {
            OperatorZip$Zip.this.child.onError(th);
        }

        @Override // com.baidu.tieba.tma
        public void onNext(Object obj) {
            try {
                this.e.g(obj);
            } catch (MissingBackpressureException e) {
                onError(e);
            }
            OperatorZip$Zip.this.tick();
        }

        @Override // com.baidu.tieba.yma
        public void d() {
            e(bpa.c);
        }

        @Override // com.baidu.tieba.tma
        public void onCompleted() {
            this.e.f();
            OperatorZip$Zip.this.tick();
        }
    }

    public OperatorZip$Zip(yma<? super R> ymaVar, mna<? extends R> mnaVar) {
        mra mraVar = new mra();
        this.childSubscription = mraVar;
        this.child = ymaVar;
        this.zipFunction = mnaVar;
        ymaVar.b(mraVar);
    }

    public void start(sma[] smaVarArr, AtomicLong atomicLong) {
        Object[] objArr = new Object[smaVarArr.length];
        for (int i = 0; i < smaVarArr.length; i++) {
            a aVar = new a();
            objArr[i] = aVar;
            this.childSubscription.a(aVar);
        }
        this.requested = atomicLong;
        this.subscribers = objArr;
        for (int i2 = 0; i2 < smaVarArr.length; i2++) {
            smaVarArr[i2].B((a) objArr[i2]);
        }
    }

    /* JADX DEBUG: Type inference failed for r9v4. Raw type applied. Possible types: R, ? super R */
    public void tick() {
        Object[] objArr = this.subscribers;
        if (objArr != null && getAndIncrement() == 0) {
            int length = objArr.length;
            tma<? super R> tmaVar = this.child;
            AtomicLong atomicLong = this.requested;
            while (true) {
                Object[] objArr2 = new Object[length];
                boolean z = true;
                for (int i = 0; i < length; i++) {
                    bpa bpaVar = ((a) objArr[i]).e;
                    Object h = bpaVar.h();
                    if (h == null) {
                        z = false;
                    } else if (bpaVar.d(h)) {
                        tmaVar.onCompleted();
                        this.childSubscription.unsubscribe();
                        return;
                    } else {
                        objArr2[i] = bpaVar.c(h);
                    }
                }
                if (z && atomicLong.get() > 0) {
                    try {
                        tmaVar.onNext((R) this.zipFunction.call(objArr2));
                        atomicLong.decrementAndGet();
                        this.emitted++;
                        for (Object obj : objArr) {
                            bpa bpaVar2 = ((a) obj).e;
                            bpaVar2.i();
                            if (bpaVar2.d(bpaVar2.h())) {
                                tmaVar.onCompleted();
                                this.childSubscription.unsubscribe();
                                return;
                            }
                        }
                        if (this.emitted > THRESHOLD) {
                            for (Object obj2 : objArr) {
                                ((a) obj2).g(this.emitted);
                            }
                            this.emitted = 0;
                        }
                    } catch (Throwable th) {
                        ena.g(th, tmaVar, objArr2);
                        return;
                    }
                } else if (decrementAndGet() <= 0) {
                    return;
                }
            }
        }
    }
}
