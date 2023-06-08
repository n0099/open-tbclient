package rx.internal.operators;

import com.baidu.tieba.hnb;
import com.baidu.tieba.krb;
import com.baidu.tieba.nmb;
import com.baidu.tieba.omb;
import com.baidu.tieba.tmb;
import com.baidu.tieba.zmb;
import com.baidu.tieba.zob;
import java.util.concurrent.atomic.AtomicLong;
import rx.exceptions.MissingBackpressureException;
/* loaded from: classes2.dex */
public final class OperatorZip$Zip<R> extends AtomicLong {
    public static final int THRESHOLD = (int) (zob.c * 0.7d);
    public static final long serialVersionUID = 5995274816189928317L;
    public final omb<? super R> child;
    public final krb childSubscription;
    public int emitted;
    public AtomicLong requested;
    public volatile Object[] subscribers;
    public final hnb<? extends R> zipFunction;

    /* loaded from: classes2.dex */
    public final class a extends tmb {
        public final zob e = zob.a();

        public a() {
        }

        public void g(long j) {
            e(j);
        }

        @Override // com.baidu.tieba.omb
        public void onError(Throwable th) {
            OperatorZip$Zip.this.child.onError(th);
        }

        @Override // com.baidu.tieba.omb
        public void onNext(Object obj) {
            try {
                this.e.g(obj);
            } catch (MissingBackpressureException e) {
                onError(e);
            }
            OperatorZip$Zip.this.tick();
        }

        @Override // com.baidu.tieba.tmb
        public void d() {
            e(zob.c);
        }

        @Override // com.baidu.tieba.omb
        public void onCompleted() {
            this.e.f();
            OperatorZip$Zip.this.tick();
        }
    }

    public OperatorZip$Zip(tmb<? super R> tmbVar, hnb<? extends R> hnbVar) {
        krb krbVar = new krb();
        this.childSubscription = krbVar;
        this.child = tmbVar;
        this.zipFunction = hnbVar;
        tmbVar.b(krbVar);
    }

    public void start(nmb[] nmbVarArr, AtomicLong atomicLong) {
        Object[] objArr = new Object[nmbVarArr.length];
        for (int i = 0; i < nmbVarArr.length; i++) {
            a aVar = new a();
            objArr[i] = aVar;
            this.childSubscription.a(aVar);
        }
        this.requested = atomicLong;
        this.subscribers = objArr;
        for (int i2 = 0; i2 < nmbVarArr.length; i2++) {
            nmbVarArr[i2].F((a) objArr[i2]);
        }
    }

    /* JADX DEBUG: Type inference failed for r9v4. Raw type applied. Possible types: R, ? super R */
    public void tick() {
        Object[] objArr = this.subscribers;
        if (objArr != null && getAndIncrement() == 0) {
            int length = objArr.length;
            omb<? super R> ombVar = this.child;
            AtomicLong atomicLong = this.requested;
            while (true) {
                Object[] objArr2 = new Object[length];
                boolean z = true;
                for (int i = 0; i < length; i++) {
                    zob zobVar = ((a) objArr[i]).e;
                    Object h = zobVar.h();
                    if (h == null) {
                        z = false;
                    } else if (zobVar.d(h)) {
                        ombVar.onCompleted();
                        this.childSubscription.unsubscribe();
                        return;
                    } else {
                        objArr2[i] = zobVar.c(h);
                    }
                }
                if (z && atomicLong.get() > 0) {
                    try {
                        ombVar.onNext((R) this.zipFunction.call(objArr2));
                        atomicLong.decrementAndGet();
                        this.emitted++;
                        for (Object obj : objArr) {
                            zob zobVar2 = ((a) obj).e;
                            zobVar2.i();
                            if (zobVar2.d(zobVar2.h())) {
                                ombVar.onCompleted();
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
                        zmb.g(th, ombVar, objArr2);
                        return;
                    }
                } else if (decrementAndGet() <= 0) {
                    return;
                }
            }
        }
    }
}
