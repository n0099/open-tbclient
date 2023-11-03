package rx.internal.operators;

import com.baidu.tieba.amc;
import com.baidu.tieba.fkc;
import com.baidu.tieba.ijc;
import com.baidu.tieba.jjc;
import com.baidu.tieba.loc;
import com.baidu.tieba.ojc;
import com.baidu.tieba.ujc;
import java.util.concurrent.atomic.AtomicLong;
import rx.exceptions.MissingBackpressureException;
/* loaded from: classes2.dex */
public final class OperatorZip$Zip<R> extends AtomicLong {
    public static final int THRESHOLD = (int) (amc.c * 0.7d);
    public static final long serialVersionUID = 5995274816189928317L;
    public final jjc<? super R> child;
    public final loc childSubscription;
    public int emitted;
    public AtomicLong requested;
    public volatile Object[] subscribers;
    public final fkc<? extends R> zipFunction;

    /* loaded from: classes2.dex */
    public final class a extends ojc {
        public final amc e = amc.a();

        public a() {
        }

        public void g(long j) {
            e(j);
        }

        @Override // com.baidu.tieba.jjc
        public void onError(Throwable th) {
            OperatorZip$Zip.this.child.onError(th);
        }

        @Override // com.baidu.tieba.jjc
        public void onNext(Object obj) {
            try {
                this.e.g(obj);
            } catch (MissingBackpressureException e) {
                onError(e);
            }
            OperatorZip$Zip.this.tick();
        }

        @Override // com.baidu.tieba.ojc
        public void d() {
            e(amc.c);
        }

        @Override // com.baidu.tieba.jjc
        public void onCompleted() {
            this.e.f();
            OperatorZip$Zip.this.tick();
        }
    }

    public OperatorZip$Zip(ojc<? super R> ojcVar, fkc<? extends R> fkcVar) {
        loc locVar = new loc();
        this.childSubscription = locVar;
        this.child = ojcVar;
        this.zipFunction = fkcVar;
        ojcVar.b(locVar);
    }

    public void start(ijc[] ijcVarArr, AtomicLong atomicLong) {
        Object[] objArr = new Object[ijcVarArr.length];
        for (int i = 0; i < ijcVarArr.length; i++) {
            a aVar = new a();
            objArr[i] = aVar;
            this.childSubscription.a(aVar);
        }
        this.requested = atomicLong;
        this.subscribers = objArr;
        for (int i2 = 0; i2 < ijcVarArr.length; i2++) {
            ijcVarArr[i2].O((a) objArr[i2]);
        }
    }

    /* JADX DEBUG: Type inference failed for r9v4. Raw type applied. Possible types: R, ? super R */
    public void tick() {
        Object[] objArr = this.subscribers;
        if (objArr != null && getAndIncrement() == 0) {
            int length = objArr.length;
            jjc<? super R> jjcVar = this.child;
            AtomicLong atomicLong = this.requested;
            while (true) {
                Object[] objArr2 = new Object[length];
                boolean z = true;
                for (int i = 0; i < length; i++) {
                    amc amcVar = ((a) objArr[i]).e;
                    Object h = amcVar.h();
                    if (h == null) {
                        z = false;
                    } else if (amcVar.d(h)) {
                        jjcVar.onCompleted();
                        this.childSubscription.unsubscribe();
                        return;
                    } else {
                        objArr2[i] = amcVar.c(h);
                    }
                }
                if (z && atomicLong.get() > 0) {
                    try {
                        jjcVar.onNext((R) this.zipFunction.call(objArr2));
                        atomicLong.decrementAndGet();
                        this.emitted++;
                        for (Object obj : objArr) {
                            amc amcVar2 = ((a) obj).e;
                            amcVar2.i();
                            if (amcVar2.d(amcVar2.h())) {
                                jjcVar.onCompleted();
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
                        ujc.g(th, jjcVar, objArr2);
                        return;
                    }
                } else if (decrementAndGet() <= 0) {
                    return;
                }
            }
        }
    }
}
