package rx.internal.operators;

import com.baidu.tieba.b8c;
import com.baidu.tieba.fac;
import com.baidu.tieba.k8c;
import com.baidu.tieba.p7c;
import com.baidu.tieba.q7c;
import com.baidu.tieba.qcc;
import com.baidu.tieba.v7c;
import java.util.concurrent.atomic.AtomicLong;
import rx.exceptions.MissingBackpressureException;
/* loaded from: classes2.dex */
public final class OperatorZip$Zip<R> extends AtomicLong {
    public static final int THRESHOLD = (int) (fac.c * 0.7d);
    public static final long serialVersionUID = 5995274816189928317L;
    public final q7c<? super R> child;
    public final qcc childSubscription;
    public int emitted;
    public AtomicLong requested;
    public volatile Object[] subscribers;
    public final k8c<? extends R> zipFunction;

    /* loaded from: classes2.dex */
    public final class a extends v7c {
        public final fac e = fac.a();

        public a() {
        }

        public void g(long j) {
            e(j);
        }

        @Override // com.baidu.tieba.q7c
        public void onError(Throwable th) {
            OperatorZip$Zip.this.child.onError(th);
        }

        @Override // com.baidu.tieba.q7c
        public void onNext(Object obj) {
            try {
                this.e.g(obj);
            } catch (MissingBackpressureException e) {
                onError(e);
            }
            OperatorZip$Zip.this.tick();
        }

        @Override // com.baidu.tieba.v7c
        public void d() {
            e(fac.c);
        }

        @Override // com.baidu.tieba.q7c
        public void onCompleted() {
            this.e.f();
            OperatorZip$Zip.this.tick();
        }
    }

    public OperatorZip$Zip(v7c<? super R> v7cVar, k8c<? extends R> k8cVar) {
        qcc qccVar = new qcc();
        this.childSubscription = qccVar;
        this.child = v7cVar;
        this.zipFunction = k8cVar;
        v7cVar.b(qccVar);
    }

    public void start(p7c[] p7cVarArr, AtomicLong atomicLong) {
        Object[] objArr = new Object[p7cVarArr.length];
        for (int i = 0; i < p7cVarArr.length; i++) {
            a aVar = new a();
            objArr[i] = aVar;
            this.childSubscription.a(aVar);
        }
        this.requested = atomicLong;
        this.subscribers = objArr;
        for (int i2 = 0; i2 < p7cVarArr.length; i2++) {
            p7cVarArr[i2].O((a) objArr[i2]);
        }
    }

    /* JADX DEBUG: Type inference failed for r9v4. Raw type applied. Possible types: R, ? super R */
    public void tick() {
        Object[] objArr = this.subscribers;
        if (objArr != null && getAndIncrement() == 0) {
            int length = objArr.length;
            q7c<? super R> q7cVar = this.child;
            AtomicLong atomicLong = this.requested;
            while (true) {
                Object[] objArr2 = new Object[length];
                boolean z = true;
                for (int i = 0; i < length; i++) {
                    fac facVar = ((a) objArr[i]).e;
                    Object h = facVar.h();
                    if (h == null) {
                        z = false;
                    } else if (facVar.d(h)) {
                        q7cVar.onCompleted();
                        this.childSubscription.unsubscribe();
                        return;
                    } else {
                        objArr2[i] = facVar.c(h);
                    }
                }
                if (z && atomicLong.get() > 0) {
                    try {
                        q7cVar.onNext((R) this.zipFunction.call(objArr2));
                        atomicLong.decrementAndGet();
                        this.emitted++;
                        for (Object obj : objArr) {
                            fac facVar2 = ((a) obj).e;
                            facVar2.i();
                            if (facVar2.d(facVar2.h())) {
                                q7cVar.onCompleted();
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
                        b8c.g(th, q7cVar, objArr2);
                        return;
                    }
                } else if (decrementAndGet() <= 0) {
                    return;
                }
            }
        }
    }
}
