package rx.internal.operators;

import com.baidu.tieba.apc;
import com.baidu.tieba.doc;
import com.baidu.tieba.eoc;
import com.baidu.tieba.gtc;
import com.baidu.tieba.joc;
import com.baidu.tieba.poc;
import com.baidu.tieba.vqc;
import java.util.concurrent.atomic.AtomicLong;
import rx.exceptions.MissingBackpressureException;
/* loaded from: classes2.dex */
public final class OperatorZip$Zip<R> extends AtomicLong {
    public static final int THRESHOLD = (int) (vqc.c * 0.7d);
    public static final long serialVersionUID = 5995274816189928317L;
    public final eoc<? super R> child;
    public final gtc childSubscription;
    public int emitted;
    public AtomicLong requested;
    public volatile Object[] subscribers;
    public final apc<? extends R> zipFunction;

    /* loaded from: classes2.dex */
    public final class a extends joc {
        public final vqc e = vqc.a();

        public a() {
        }

        public void g(long j) {
            e(j);
        }

        @Override // com.baidu.tieba.eoc
        public void onError(Throwable th) {
            OperatorZip$Zip.this.child.onError(th);
        }

        @Override // com.baidu.tieba.eoc
        public void onNext(Object obj) {
            try {
                this.e.g(obj);
            } catch (MissingBackpressureException e) {
                onError(e);
            }
            OperatorZip$Zip.this.tick();
        }

        @Override // com.baidu.tieba.joc
        public void d() {
            e(vqc.c);
        }

        @Override // com.baidu.tieba.eoc
        public void onCompleted() {
            this.e.f();
            OperatorZip$Zip.this.tick();
        }
    }

    public OperatorZip$Zip(joc<? super R> jocVar, apc<? extends R> apcVar) {
        gtc gtcVar = new gtc();
        this.childSubscription = gtcVar;
        this.child = jocVar;
        this.zipFunction = apcVar;
        jocVar.b(gtcVar);
    }

    public void start(doc[] docVarArr, AtomicLong atomicLong) {
        Object[] objArr = new Object[docVarArr.length];
        for (int i = 0; i < docVarArr.length; i++) {
            a aVar = new a();
            objArr[i] = aVar;
            this.childSubscription.a(aVar);
        }
        this.requested = atomicLong;
        this.subscribers = objArr;
        for (int i2 = 0; i2 < docVarArr.length; i2++) {
            docVarArr[i2].O((a) objArr[i2]);
        }
    }

    /* JADX DEBUG: Type inference failed for r9v4. Raw type applied. Possible types: R, ? super R */
    public void tick() {
        Object[] objArr = this.subscribers;
        if (objArr != null && getAndIncrement() == 0) {
            int length = objArr.length;
            eoc<? super R> eocVar = this.child;
            AtomicLong atomicLong = this.requested;
            while (true) {
                Object[] objArr2 = new Object[length];
                boolean z = true;
                for (int i = 0; i < length; i++) {
                    vqc vqcVar = ((a) objArr[i]).e;
                    Object h = vqcVar.h();
                    if (h == null) {
                        z = false;
                    } else if (vqcVar.d(h)) {
                        eocVar.onCompleted();
                        this.childSubscription.unsubscribe();
                        return;
                    } else {
                        objArr2[i] = vqcVar.c(h);
                    }
                }
                if (z && atomicLong.get() > 0) {
                    try {
                        eocVar.onNext((R) this.zipFunction.call(objArr2));
                        atomicLong.decrementAndGet();
                        this.emitted++;
                        for (Object obj : objArr) {
                            vqc vqcVar2 = ((a) obj).e;
                            vqcVar2.i();
                            if (vqcVar2.d(vqcVar2.h())) {
                                eocVar.onCompleted();
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
                        poc.g(th, eocVar, objArr2);
                        return;
                    }
                } else if (decrementAndGet() <= 0) {
                    return;
                }
            }
        }
    }
}
