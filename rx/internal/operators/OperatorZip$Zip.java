package rx.internal.operators;

import com.baidu.tieba.afc;
import com.baidu.tieba.fdc;
import com.baidu.tieba.kcc;
import com.baidu.tieba.lcc;
import com.baidu.tieba.lhc;
import com.baidu.tieba.qcc;
import com.baidu.tieba.wcc;
import java.util.concurrent.atomic.AtomicLong;
import rx.exceptions.MissingBackpressureException;
/* loaded from: classes2.dex */
public final class OperatorZip$Zip<R> extends AtomicLong {
    public static final int THRESHOLD = (int) (afc.c * 0.7d);
    public static final long serialVersionUID = 5995274816189928317L;
    public final lcc<? super R> child;
    public final lhc childSubscription;
    public int emitted;
    public AtomicLong requested;
    public volatile Object[] subscribers;
    public final fdc<? extends R> zipFunction;

    /* loaded from: classes2.dex */
    public final class a extends qcc {
        public final afc e = afc.a();

        public a() {
        }

        public void g(long j) {
            e(j);
        }

        @Override // com.baidu.tieba.lcc
        public void onError(Throwable th) {
            OperatorZip$Zip.this.child.onError(th);
        }

        @Override // com.baidu.tieba.lcc
        public void onNext(Object obj) {
            try {
                this.e.g(obj);
            } catch (MissingBackpressureException e) {
                onError(e);
            }
            OperatorZip$Zip.this.tick();
        }

        @Override // com.baidu.tieba.qcc
        public void d() {
            e(afc.c);
        }

        @Override // com.baidu.tieba.lcc
        public void onCompleted() {
            this.e.f();
            OperatorZip$Zip.this.tick();
        }
    }

    public OperatorZip$Zip(qcc<? super R> qccVar, fdc<? extends R> fdcVar) {
        lhc lhcVar = new lhc();
        this.childSubscription = lhcVar;
        this.child = qccVar;
        this.zipFunction = fdcVar;
        qccVar.b(lhcVar);
    }

    public void start(kcc[] kccVarArr, AtomicLong atomicLong) {
        Object[] objArr = new Object[kccVarArr.length];
        for (int i = 0; i < kccVarArr.length; i++) {
            a aVar = new a();
            objArr[i] = aVar;
            this.childSubscription.a(aVar);
        }
        this.requested = atomicLong;
        this.subscribers = objArr;
        for (int i2 = 0; i2 < kccVarArr.length; i2++) {
            kccVarArr[i2].O((a) objArr[i2]);
        }
    }

    /* JADX DEBUG: Type inference failed for r9v4. Raw type applied. Possible types: R, ? super R */
    public void tick() {
        Object[] objArr = this.subscribers;
        if (objArr != null && getAndIncrement() == 0) {
            int length = objArr.length;
            lcc<? super R> lccVar = this.child;
            AtomicLong atomicLong = this.requested;
            while (true) {
                Object[] objArr2 = new Object[length];
                boolean z = true;
                for (int i = 0; i < length; i++) {
                    afc afcVar = ((a) objArr[i]).e;
                    Object h = afcVar.h();
                    if (h == null) {
                        z = false;
                    } else if (afcVar.d(h)) {
                        lccVar.onCompleted();
                        this.childSubscription.unsubscribe();
                        return;
                    } else {
                        objArr2[i] = afcVar.c(h);
                    }
                }
                if (z && atomicLong.get() > 0) {
                    try {
                        lccVar.onNext((R) this.zipFunction.call(objArr2));
                        atomicLong.decrementAndGet();
                        this.emitted++;
                        for (Object obj : objArr) {
                            afc afcVar2 = ((a) obj).e;
                            afcVar2.i();
                            if (afcVar2.d(afcVar2.h())) {
                                lccVar.onCompleted();
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
                        wcc.g(th, lccVar, objArr2);
                        return;
                    }
                } else if (decrementAndGet() <= 0) {
                    return;
                }
            }
        }
    }
}
