package rx.internal.operators;

import com.baidu.tieba.a2c;
import com.baidu.tieba.g2c;
import com.baidu.tieba.j4c;
import com.baidu.tieba.o2c;
import com.baidu.tieba.u1c;
import com.baidu.tieba.u6c;
import com.baidu.tieba.v1c;
import java.util.concurrent.atomic.AtomicLong;
import rx.exceptions.MissingBackpressureException;
/* loaded from: classes2.dex */
public final class OperatorZip$Zip<R> extends AtomicLong {
    public static final int THRESHOLD = (int) (j4c.c * 0.7d);
    public static final long serialVersionUID = 5995274816189928317L;
    public final v1c<? super R> child;
    public final u6c childSubscription;
    public int emitted;
    public AtomicLong requested;
    public volatile Object[] subscribers;
    public final o2c<? extends R> zipFunction;

    /* loaded from: classes2.dex */
    public final class a extends a2c {
        public final j4c e = j4c.a();

        public a() {
        }

        public void g(long j) {
            e(j);
        }

        @Override // com.baidu.tieba.v1c
        public void onError(Throwable th) {
            OperatorZip$Zip.this.child.onError(th);
        }

        @Override // com.baidu.tieba.v1c
        public void onNext(Object obj) {
            try {
                this.e.g(obj);
            } catch (MissingBackpressureException e) {
                onError(e);
            }
            OperatorZip$Zip.this.tick();
        }

        @Override // com.baidu.tieba.a2c
        public void d() {
            e(j4c.c);
        }

        @Override // com.baidu.tieba.v1c
        public void onCompleted() {
            this.e.f();
            OperatorZip$Zip.this.tick();
        }
    }

    public OperatorZip$Zip(a2c<? super R> a2cVar, o2c<? extends R> o2cVar) {
        u6c u6cVar = new u6c();
        this.childSubscription = u6cVar;
        this.child = a2cVar;
        this.zipFunction = o2cVar;
        a2cVar.b(u6cVar);
    }

    public void start(u1c[] u1cVarArr, AtomicLong atomicLong) {
        Object[] objArr = new Object[u1cVarArr.length];
        for (int i = 0; i < u1cVarArr.length; i++) {
            a aVar = new a();
            objArr[i] = aVar;
            this.childSubscription.a(aVar);
        }
        this.requested = atomicLong;
        this.subscribers = objArr;
        for (int i2 = 0; i2 < u1cVarArr.length; i2++) {
            u1cVarArr[i2].O((a) objArr[i2]);
        }
    }

    /* JADX DEBUG: Type inference failed for r9v4. Raw type applied. Possible types: R, ? super R */
    public void tick() {
        Object[] objArr = this.subscribers;
        if (objArr != null && getAndIncrement() == 0) {
            int length = objArr.length;
            v1c<? super R> v1cVar = this.child;
            AtomicLong atomicLong = this.requested;
            while (true) {
                Object[] objArr2 = new Object[length];
                boolean z = true;
                for (int i = 0; i < length; i++) {
                    j4c j4cVar = ((a) objArr[i]).e;
                    Object h = j4cVar.h();
                    if (h == null) {
                        z = false;
                    } else if (j4cVar.d(h)) {
                        v1cVar.onCompleted();
                        this.childSubscription.unsubscribe();
                        return;
                    } else {
                        objArr2[i] = j4cVar.c(h);
                    }
                }
                if (z && atomicLong.get() > 0) {
                    try {
                        v1cVar.onNext((R) this.zipFunction.call(objArr2));
                        atomicLong.decrementAndGet();
                        this.emitted++;
                        for (Object obj : objArr) {
                            j4c j4cVar2 = ((a) obj).e;
                            j4cVar2.i();
                            if (j4cVar2.d(j4cVar2.h())) {
                                v1cVar.onCompleted();
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
                        g2c.g(th, v1cVar, objArr2);
                        return;
                    }
                } else if (decrementAndGet() <= 0) {
                    return;
                }
            }
        }
    }
}
