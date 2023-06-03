package rx.internal.operators;

import com.baidu.tieba.cnb;
import com.baidu.tieba.frb;
import com.baidu.tieba.imb;
import com.baidu.tieba.jmb;
import com.baidu.tieba.omb;
import com.baidu.tieba.umb;
import com.baidu.tieba.uob;
import java.util.concurrent.atomic.AtomicLong;
import rx.exceptions.MissingBackpressureException;
/* loaded from: classes2.dex */
public final class OperatorZip$Zip<R> extends AtomicLong {
    public static final int THRESHOLD = (int) (uob.c * 0.7d);
    public static final long serialVersionUID = 5995274816189928317L;
    public final jmb<? super R> child;
    public final frb childSubscription;
    public int emitted;
    public AtomicLong requested;
    public volatile Object[] subscribers;
    public final cnb<? extends R> zipFunction;

    /* loaded from: classes2.dex */
    public final class a extends omb {
        public final uob e = uob.a();

        public a() {
        }

        public void g(long j) {
            e(j);
        }

        @Override // com.baidu.tieba.jmb
        public void onError(Throwable th) {
            OperatorZip$Zip.this.child.onError(th);
        }

        @Override // com.baidu.tieba.jmb
        public void onNext(Object obj) {
            try {
                this.e.g(obj);
            } catch (MissingBackpressureException e) {
                onError(e);
            }
            OperatorZip$Zip.this.tick();
        }

        @Override // com.baidu.tieba.omb
        public void d() {
            e(uob.c);
        }

        @Override // com.baidu.tieba.jmb
        public void onCompleted() {
            this.e.f();
            OperatorZip$Zip.this.tick();
        }
    }

    public OperatorZip$Zip(omb<? super R> ombVar, cnb<? extends R> cnbVar) {
        frb frbVar = new frb();
        this.childSubscription = frbVar;
        this.child = ombVar;
        this.zipFunction = cnbVar;
        ombVar.b(frbVar);
    }

    public void start(imb[] imbVarArr, AtomicLong atomicLong) {
        Object[] objArr = new Object[imbVarArr.length];
        for (int i = 0; i < imbVarArr.length; i++) {
            a aVar = new a();
            objArr[i] = aVar;
            this.childSubscription.a(aVar);
        }
        this.requested = atomicLong;
        this.subscribers = objArr;
        for (int i2 = 0; i2 < imbVarArr.length; i2++) {
            imbVarArr[i2].F((a) objArr[i2]);
        }
    }

    /* JADX DEBUG: Type inference failed for r9v4. Raw type applied. Possible types: R, ? super R */
    public void tick() {
        Object[] objArr = this.subscribers;
        if (objArr != null && getAndIncrement() == 0) {
            int length = objArr.length;
            jmb<? super R> jmbVar = this.child;
            AtomicLong atomicLong = this.requested;
            while (true) {
                Object[] objArr2 = new Object[length];
                boolean z = true;
                for (int i = 0; i < length; i++) {
                    uob uobVar = ((a) objArr[i]).e;
                    Object h = uobVar.h();
                    if (h == null) {
                        z = false;
                    } else if (uobVar.d(h)) {
                        jmbVar.onCompleted();
                        this.childSubscription.unsubscribe();
                        return;
                    } else {
                        objArr2[i] = uobVar.c(h);
                    }
                }
                if (z && atomicLong.get() > 0) {
                    try {
                        jmbVar.onNext((R) this.zipFunction.call(objArr2));
                        atomicLong.decrementAndGet();
                        this.emitted++;
                        for (Object obj : objArr) {
                            uob uobVar2 = ((a) obj).e;
                            uobVar2.i();
                            if (uobVar2.d(uobVar2.h())) {
                                jmbVar.onCompleted();
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
                        umb.g(th, jmbVar, objArr2);
                        return;
                    }
                } else if (decrementAndGet() <= 0) {
                    return;
                }
            }
        }
    }
}
