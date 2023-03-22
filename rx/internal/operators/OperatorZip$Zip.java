package rx.internal.operators;

import com.baidu.tieba.asa;
import com.baidu.tieba.isa;
import com.baidu.tieba.iwa;
import com.baidu.tieba.ora;
import com.baidu.tieba.pra;
import com.baidu.tieba.ura;
import com.baidu.tieba.xta;
import java.util.concurrent.atomic.AtomicLong;
import rx.exceptions.MissingBackpressureException;
/* loaded from: classes9.dex */
public final class OperatorZip$Zip<R> extends AtomicLong {
    public static final int THRESHOLD = (int) (xta.c * 0.7d);
    public static final long serialVersionUID = 5995274816189928317L;
    public final pra<? super R> child;
    public final iwa childSubscription;
    public int emitted;
    public AtomicLong requested;
    public volatile Object[] subscribers;
    public final isa<? extends R> zipFunction;

    /* loaded from: classes9.dex */
    public final class a extends ura {
        public final xta e = xta.a();

        public a() {
        }

        public void g(long j) {
            e(j);
        }

        @Override // com.baidu.tieba.pra
        public void onError(Throwable th) {
            OperatorZip$Zip.this.child.onError(th);
        }

        @Override // com.baidu.tieba.pra
        public void onNext(Object obj) {
            try {
                this.e.g(obj);
            } catch (MissingBackpressureException e) {
                onError(e);
            }
            OperatorZip$Zip.this.tick();
        }

        @Override // com.baidu.tieba.ura
        public void d() {
            e(xta.c);
        }

        @Override // com.baidu.tieba.pra
        public void onCompleted() {
            this.e.f();
            OperatorZip$Zip.this.tick();
        }
    }

    public OperatorZip$Zip(ura<? super R> uraVar, isa<? extends R> isaVar) {
        iwa iwaVar = new iwa();
        this.childSubscription = iwaVar;
        this.child = uraVar;
        this.zipFunction = isaVar;
        uraVar.b(iwaVar);
    }

    public void start(ora[] oraVarArr, AtomicLong atomicLong) {
        Object[] objArr = new Object[oraVarArr.length];
        for (int i = 0; i < oraVarArr.length; i++) {
            a aVar = new a();
            objArr[i] = aVar;
            this.childSubscription.a(aVar);
        }
        this.requested = atomicLong;
        this.subscribers = objArr;
        for (int i2 = 0; i2 < oraVarArr.length; i2++) {
            oraVarArr[i2].B((a) objArr[i2]);
        }
    }

    /* JADX DEBUG: Type inference failed for r9v4. Raw type applied. Possible types: R, ? super R */
    public void tick() {
        Object[] objArr = this.subscribers;
        if (objArr != null && getAndIncrement() == 0) {
            int length = objArr.length;
            pra<? super R> praVar = this.child;
            AtomicLong atomicLong = this.requested;
            while (true) {
                Object[] objArr2 = new Object[length];
                boolean z = true;
                for (int i = 0; i < length; i++) {
                    xta xtaVar = ((a) objArr[i]).e;
                    Object h = xtaVar.h();
                    if (h == null) {
                        z = false;
                    } else if (xtaVar.d(h)) {
                        praVar.onCompleted();
                        this.childSubscription.unsubscribe();
                        return;
                    } else {
                        objArr2[i] = xtaVar.c(h);
                    }
                }
                if (z && atomicLong.get() > 0) {
                    try {
                        praVar.onNext((R) this.zipFunction.call(objArr2));
                        atomicLong.decrementAndGet();
                        this.emitted++;
                        for (Object obj : objArr) {
                            xta xtaVar2 = ((a) obj).e;
                            xtaVar2.i();
                            if (xtaVar2.d(xtaVar2.h())) {
                                praVar.onCompleted();
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
                        asa.g(th, praVar, objArr2);
                        return;
                    }
                } else if (decrementAndGet() <= 0) {
                    return;
                }
            }
        }
    }
}
