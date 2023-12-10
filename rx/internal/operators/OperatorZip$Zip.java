package rx.internal.operators;

import com.baidu.tieba.bpc;
import com.baidu.tieba.eoc;
import com.baidu.tieba.foc;
import com.baidu.tieba.htc;
import com.baidu.tieba.koc;
import com.baidu.tieba.qoc;
import com.baidu.tieba.wqc;
import java.util.concurrent.atomic.AtomicLong;
import rx.exceptions.MissingBackpressureException;
/* loaded from: classes2.dex */
public final class OperatorZip$Zip<R> extends AtomicLong {
    public static final int THRESHOLD = (int) (wqc.c * 0.7d);
    public static final long serialVersionUID = 5995274816189928317L;
    public final foc<? super R> child;
    public final htc childSubscription;
    public int emitted;
    public AtomicLong requested;
    public volatile Object[] subscribers;
    public final bpc<? extends R> zipFunction;

    /* loaded from: classes2.dex */
    public final class a extends koc {
        public final wqc e = wqc.a();

        public a() {
        }

        public void g(long j) {
            e(j);
        }

        @Override // com.baidu.tieba.foc
        public void onError(Throwable th) {
            OperatorZip$Zip.this.child.onError(th);
        }

        @Override // com.baidu.tieba.foc
        public void onNext(Object obj) {
            try {
                this.e.g(obj);
            } catch (MissingBackpressureException e) {
                onError(e);
            }
            OperatorZip$Zip.this.tick();
        }

        @Override // com.baidu.tieba.koc
        public void d() {
            e(wqc.c);
        }

        @Override // com.baidu.tieba.foc
        public void onCompleted() {
            this.e.f();
            OperatorZip$Zip.this.tick();
        }
    }

    public OperatorZip$Zip(koc<? super R> kocVar, bpc<? extends R> bpcVar) {
        htc htcVar = new htc();
        this.childSubscription = htcVar;
        this.child = kocVar;
        this.zipFunction = bpcVar;
        kocVar.b(htcVar);
    }

    public void start(eoc[] eocVarArr, AtomicLong atomicLong) {
        Object[] objArr = new Object[eocVarArr.length];
        for (int i = 0; i < eocVarArr.length; i++) {
            a aVar = new a();
            objArr[i] = aVar;
            this.childSubscription.a(aVar);
        }
        this.requested = atomicLong;
        this.subscribers = objArr;
        for (int i2 = 0; i2 < eocVarArr.length; i2++) {
            eocVarArr[i2].O((a) objArr[i2]);
        }
    }

    /* JADX DEBUG: Type inference failed for r9v4. Raw type applied. Possible types: R, ? super R */
    public void tick() {
        Object[] objArr = this.subscribers;
        if (objArr != null && getAndIncrement() == 0) {
            int length = objArr.length;
            foc<? super R> focVar = this.child;
            AtomicLong atomicLong = this.requested;
            while (true) {
                Object[] objArr2 = new Object[length];
                boolean z = true;
                for (int i = 0; i < length; i++) {
                    wqc wqcVar = ((a) objArr[i]).e;
                    Object h = wqcVar.h();
                    if (h == null) {
                        z = false;
                    } else if (wqcVar.d(h)) {
                        focVar.onCompleted();
                        this.childSubscription.unsubscribe();
                        return;
                    } else {
                        objArr2[i] = wqcVar.c(h);
                    }
                }
                if (z && atomicLong.get() > 0) {
                    try {
                        focVar.onNext((R) this.zipFunction.call(objArr2));
                        atomicLong.decrementAndGet();
                        this.emitted++;
                        for (Object obj : objArr) {
                            wqc wqcVar2 = ((a) obj).e;
                            wqcVar2.i();
                            if (wqcVar2.d(wqcVar2.h())) {
                                focVar.onCompleted();
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
                        qoc.g(th, focVar, objArr2);
                        return;
                    }
                } else if (decrementAndGet() <= 0) {
                    return;
                }
            }
        }
    }
}
