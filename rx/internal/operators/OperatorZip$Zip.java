package rx.internal.operators;

import com.baidu.tieba.f1b;
import com.baidu.tieba.g1b;
import com.baidu.tieba.l1b;
import com.baidu.tieba.o3b;
import com.baidu.tieba.r1b;
import com.baidu.tieba.z1b;
import com.baidu.tieba.z5b;
import java.util.concurrent.atomic.AtomicLong;
import rx.exceptions.MissingBackpressureException;
/* loaded from: classes9.dex */
public final class OperatorZip$Zip<R> extends AtomicLong {
    public static final int THRESHOLD = (int) (o3b.c * 0.7d);
    public static final long serialVersionUID = 5995274816189928317L;
    public final g1b<? super R> child;
    public final z5b childSubscription;
    public int emitted;
    public AtomicLong requested;
    public volatile Object[] subscribers;
    public final z1b<? extends R> zipFunction;

    /* loaded from: classes9.dex */
    public final class a extends l1b {
        public final o3b e = o3b.a();

        public a() {
        }

        public void g(long j) {
            e(j);
        }

        @Override // com.baidu.tieba.g1b
        public void onError(Throwable th) {
            OperatorZip$Zip.this.child.onError(th);
        }

        @Override // com.baidu.tieba.g1b
        public void onNext(Object obj) {
            try {
                this.e.g(obj);
            } catch (MissingBackpressureException e) {
                onError(e);
            }
            OperatorZip$Zip.this.tick();
        }

        @Override // com.baidu.tieba.l1b
        public void d() {
            e(o3b.c);
        }

        @Override // com.baidu.tieba.g1b
        public void onCompleted() {
            this.e.f();
            OperatorZip$Zip.this.tick();
        }
    }

    public OperatorZip$Zip(l1b<? super R> l1bVar, z1b<? extends R> z1bVar) {
        z5b z5bVar = new z5b();
        this.childSubscription = z5bVar;
        this.child = l1bVar;
        this.zipFunction = z1bVar;
        l1bVar.b(z5bVar);
    }

    public void start(f1b[] f1bVarArr, AtomicLong atomicLong) {
        Object[] objArr = new Object[f1bVarArr.length];
        for (int i = 0; i < f1bVarArr.length; i++) {
            a aVar = new a();
            objArr[i] = aVar;
            this.childSubscription.a(aVar);
        }
        this.requested = atomicLong;
        this.subscribers = objArr;
        for (int i2 = 0; i2 < f1bVarArr.length; i2++) {
            f1bVarArr[i2].B((a) objArr[i2]);
        }
    }

    /* JADX DEBUG: Type inference failed for r9v4. Raw type applied. Possible types: R, ? super R */
    public void tick() {
        Object[] objArr = this.subscribers;
        if (objArr != null && getAndIncrement() == 0) {
            int length = objArr.length;
            g1b<? super R> g1bVar = this.child;
            AtomicLong atomicLong = this.requested;
            while (true) {
                Object[] objArr2 = new Object[length];
                boolean z = true;
                for (int i = 0; i < length; i++) {
                    o3b o3bVar = ((a) objArr[i]).e;
                    Object h = o3bVar.h();
                    if (h == null) {
                        z = false;
                    } else if (o3bVar.d(h)) {
                        g1bVar.onCompleted();
                        this.childSubscription.unsubscribe();
                        return;
                    } else {
                        objArr2[i] = o3bVar.c(h);
                    }
                }
                if (z && atomicLong.get() > 0) {
                    try {
                        g1bVar.onNext((R) this.zipFunction.call(objArr2));
                        atomicLong.decrementAndGet();
                        this.emitted++;
                        for (Object obj : objArr) {
                            o3b o3bVar2 = ((a) obj).e;
                            o3bVar2.i();
                            if (o3bVar2.d(o3bVar2.h())) {
                                g1bVar.onCompleted();
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
                        r1b.g(th, g1bVar, objArr2);
                        return;
                    }
                } else if (decrementAndGet() <= 0) {
                    return;
                }
            }
        }
    }
}
