package rx.internal.operators;

import com.baidu.tieba.ebc;
import com.baidu.tieba.idc;
import com.baidu.tieba.nbc;
import com.baidu.tieba.sac;
import com.baidu.tieba.tac;
import com.baidu.tieba.tfc;
import com.baidu.tieba.yac;
import java.util.concurrent.atomic.AtomicLong;
import rx.exceptions.MissingBackpressureException;
/* loaded from: classes2.dex */
public final class OperatorZip$Zip<R> extends AtomicLong {
    public static final int THRESHOLD = (int) (idc.c * 0.7d);
    public static final long serialVersionUID = 5995274816189928317L;
    public final tac<? super R> child;
    public final tfc childSubscription;
    public int emitted;
    public AtomicLong requested;
    public volatile Object[] subscribers;
    public final nbc<? extends R> zipFunction;

    /* loaded from: classes2.dex */
    public final class a extends yac {
        public final idc e = idc.a();

        public a() {
        }

        public void g(long j) {
            e(j);
        }

        @Override // com.baidu.tieba.tac
        public void onError(Throwable th) {
            OperatorZip$Zip.this.child.onError(th);
        }

        @Override // com.baidu.tieba.tac
        public void onNext(Object obj) {
            try {
                this.e.g(obj);
            } catch (MissingBackpressureException e) {
                onError(e);
            }
            OperatorZip$Zip.this.tick();
        }

        @Override // com.baidu.tieba.yac
        public void d() {
            e(idc.c);
        }

        @Override // com.baidu.tieba.tac
        public void onCompleted() {
            this.e.f();
            OperatorZip$Zip.this.tick();
        }
    }

    public OperatorZip$Zip(yac<? super R> yacVar, nbc<? extends R> nbcVar) {
        tfc tfcVar = new tfc();
        this.childSubscription = tfcVar;
        this.child = yacVar;
        this.zipFunction = nbcVar;
        yacVar.b(tfcVar);
    }

    public void start(sac[] sacVarArr, AtomicLong atomicLong) {
        Object[] objArr = new Object[sacVarArr.length];
        for (int i = 0; i < sacVarArr.length; i++) {
            a aVar = new a();
            objArr[i] = aVar;
            this.childSubscription.a(aVar);
        }
        this.requested = atomicLong;
        this.subscribers = objArr;
        for (int i2 = 0; i2 < sacVarArr.length; i2++) {
            sacVarArr[i2].O((a) objArr[i2]);
        }
    }

    /* JADX DEBUG: Type inference failed for r9v4. Raw type applied. Possible types: R, ? super R */
    public void tick() {
        Object[] objArr = this.subscribers;
        if (objArr != null && getAndIncrement() == 0) {
            int length = objArr.length;
            tac<? super R> tacVar = this.child;
            AtomicLong atomicLong = this.requested;
            while (true) {
                Object[] objArr2 = new Object[length];
                boolean z = true;
                for (int i = 0; i < length; i++) {
                    idc idcVar = ((a) objArr[i]).e;
                    Object h = idcVar.h();
                    if (h == null) {
                        z = false;
                    } else if (idcVar.d(h)) {
                        tacVar.onCompleted();
                        this.childSubscription.unsubscribe();
                        return;
                    } else {
                        objArr2[i] = idcVar.c(h);
                    }
                }
                if (z && atomicLong.get() > 0) {
                    try {
                        tacVar.onNext((R) this.zipFunction.call(objArr2));
                        atomicLong.decrementAndGet();
                        this.emitted++;
                        for (Object obj : objArr) {
                            idc idcVar2 = ((a) obj).e;
                            idcVar2.i();
                            if (idcVar2.d(idcVar2.h())) {
                                tacVar.onCompleted();
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
                        ebc.g(th, tacVar, objArr2);
                        return;
                    }
                } else if (decrementAndGet() <= 0) {
                    return;
                }
            }
        }
    }
}
