package rx.internal.operators;

import com.baidu.tieba.bmc;
import com.baidu.tieba.gkc;
import com.baidu.tieba.jjc;
import com.baidu.tieba.kjc;
import com.baidu.tieba.moc;
import com.baidu.tieba.pjc;
import com.baidu.tieba.vjc;
import java.util.concurrent.atomic.AtomicLong;
import rx.exceptions.MissingBackpressureException;
/* loaded from: classes2.dex */
public final class OperatorZip$Zip<R> extends AtomicLong {
    public static final int THRESHOLD = (int) (bmc.c * 0.7d);
    public static final long serialVersionUID = 5995274816189928317L;
    public final kjc<? super R> child;
    public final moc childSubscription;
    public int emitted;
    public AtomicLong requested;
    public volatile Object[] subscribers;
    public final gkc<? extends R> zipFunction;

    /* loaded from: classes2.dex */
    public final class a extends pjc {
        public final bmc e = bmc.a();

        public a() {
        }

        public void g(long j) {
            e(j);
        }

        @Override // com.baidu.tieba.kjc
        public void onError(Throwable th) {
            OperatorZip$Zip.this.child.onError(th);
        }

        @Override // com.baidu.tieba.kjc
        public void onNext(Object obj) {
            try {
                this.e.g(obj);
            } catch (MissingBackpressureException e) {
                onError(e);
            }
            OperatorZip$Zip.this.tick();
        }

        @Override // com.baidu.tieba.pjc
        public void d() {
            e(bmc.c);
        }

        @Override // com.baidu.tieba.kjc
        public void onCompleted() {
            this.e.f();
            OperatorZip$Zip.this.tick();
        }
    }

    public OperatorZip$Zip(pjc<? super R> pjcVar, gkc<? extends R> gkcVar) {
        moc mocVar = new moc();
        this.childSubscription = mocVar;
        this.child = pjcVar;
        this.zipFunction = gkcVar;
        pjcVar.b(mocVar);
    }

    public void start(jjc[] jjcVarArr, AtomicLong atomicLong) {
        Object[] objArr = new Object[jjcVarArr.length];
        for (int i = 0; i < jjcVarArr.length; i++) {
            a aVar = new a();
            objArr[i] = aVar;
            this.childSubscription.a(aVar);
        }
        this.requested = atomicLong;
        this.subscribers = objArr;
        for (int i2 = 0; i2 < jjcVarArr.length; i2++) {
            jjcVarArr[i2].O((a) objArr[i2]);
        }
    }

    /* JADX DEBUG: Type inference failed for r9v4. Raw type applied. Possible types: R, ? super R */
    public void tick() {
        Object[] objArr = this.subscribers;
        if (objArr != null && getAndIncrement() == 0) {
            int length = objArr.length;
            kjc<? super R> kjcVar = this.child;
            AtomicLong atomicLong = this.requested;
            while (true) {
                Object[] objArr2 = new Object[length];
                boolean z = true;
                for (int i = 0; i < length; i++) {
                    bmc bmcVar = ((a) objArr[i]).e;
                    Object h = bmcVar.h();
                    if (h == null) {
                        z = false;
                    } else if (bmcVar.d(h)) {
                        kjcVar.onCompleted();
                        this.childSubscription.unsubscribe();
                        return;
                    } else {
                        objArr2[i] = bmcVar.c(h);
                    }
                }
                if (z && atomicLong.get() > 0) {
                    try {
                        kjcVar.onNext((R) this.zipFunction.call(objArr2));
                        atomicLong.decrementAndGet();
                        this.emitted++;
                        for (Object obj : objArr) {
                            bmc bmcVar2 = ((a) obj).e;
                            bmcVar2.i();
                            if (bmcVar2.d(bmcVar2.h())) {
                                kjcVar.onCompleted();
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
                        vjc.g(th, kjcVar, objArr2);
                        return;
                    }
                } else if (decrementAndGet() <= 0) {
                    return;
                }
            }
        }
    }
}
