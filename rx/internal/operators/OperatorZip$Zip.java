package rx.internal.operators;

import com.baidu.tieba.e7c;
import com.baidu.tieba.h6c;
import com.baidu.tieba.i6c;
import com.baidu.tieba.kbc;
import com.baidu.tieba.n6c;
import com.baidu.tieba.t6c;
import com.baidu.tieba.z8c;
import java.util.concurrent.atomic.AtomicLong;
import rx.exceptions.MissingBackpressureException;
/* loaded from: classes2.dex */
public final class OperatorZip$Zip<R> extends AtomicLong {
    public static final int THRESHOLD = (int) (z8c.c * 0.7d);
    public static final long serialVersionUID = 5995274816189928317L;
    public final i6c<? super R> child;
    public final kbc childSubscription;
    public int emitted;
    public AtomicLong requested;
    public volatile Object[] subscribers;
    public final e7c<? extends R> zipFunction;

    /* loaded from: classes2.dex */
    public final class a extends n6c {
        public final z8c e = z8c.a();

        public a() {
        }

        public void g(long j) {
            e(j);
        }

        @Override // com.baidu.tieba.i6c
        public void onError(Throwable th) {
            OperatorZip$Zip.this.child.onError(th);
        }

        @Override // com.baidu.tieba.i6c
        public void onNext(Object obj) {
            try {
                this.e.g(obj);
            } catch (MissingBackpressureException e) {
                onError(e);
            }
            OperatorZip$Zip.this.tick();
        }

        @Override // com.baidu.tieba.n6c
        public void d() {
            e(z8c.c);
        }

        @Override // com.baidu.tieba.i6c
        public void onCompleted() {
            this.e.f();
            OperatorZip$Zip.this.tick();
        }
    }

    public OperatorZip$Zip(n6c<? super R> n6cVar, e7c<? extends R> e7cVar) {
        kbc kbcVar = new kbc();
        this.childSubscription = kbcVar;
        this.child = n6cVar;
        this.zipFunction = e7cVar;
        n6cVar.b(kbcVar);
    }

    public void start(h6c[] h6cVarArr, AtomicLong atomicLong) {
        Object[] objArr = new Object[h6cVarArr.length];
        for (int i = 0; i < h6cVarArr.length; i++) {
            a aVar = new a();
            objArr[i] = aVar;
            this.childSubscription.a(aVar);
        }
        this.requested = atomicLong;
        this.subscribers = objArr;
        for (int i2 = 0; i2 < h6cVarArr.length; i2++) {
            h6cVarArr[i2].O((a) objArr[i2]);
        }
    }

    /* JADX DEBUG: Type inference failed for r9v4. Raw type applied. Possible types: R, ? super R */
    public void tick() {
        Object[] objArr = this.subscribers;
        if (objArr != null && getAndIncrement() == 0) {
            int length = objArr.length;
            i6c<? super R> i6cVar = this.child;
            AtomicLong atomicLong = this.requested;
            while (true) {
                Object[] objArr2 = new Object[length];
                boolean z = true;
                for (int i = 0; i < length; i++) {
                    z8c z8cVar = ((a) objArr[i]).e;
                    Object h = z8cVar.h();
                    if (h == null) {
                        z = false;
                    } else if (z8cVar.d(h)) {
                        i6cVar.onCompleted();
                        this.childSubscription.unsubscribe();
                        return;
                    } else {
                        objArr2[i] = z8cVar.c(h);
                    }
                }
                if (z && atomicLong.get() > 0) {
                    try {
                        i6cVar.onNext((R) this.zipFunction.call(objArr2));
                        atomicLong.decrementAndGet();
                        this.emitted++;
                        for (Object obj : objArr) {
                            z8c z8cVar2 = ((a) obj).e;
                            z8cVar2.i();
                            if (z8cVar2.d(z8cVar2.h())) {
                                i6cVar.onCompleted();
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
                        t6c.g(th, i6cVar, objArr2);
                        return;
                    }
                } else if (decrementAndGet() <= 0) {
                    return;
                }
            }
        }
    }
}
