package rx.internal.operators;

import com.baidu.tieba.d6b;
import com.baidu.tieba.fab;
import com.baidu.tieba.j5b;
import com.baidu.tieba.k5b;
import com.baidu.tieba.p5b;
import com.baidu.tieba.u7b;
import com.baidu.tieba.v5b;
import java.util.concurrent.atomic.AtomicLong;
import rx.exceptions.MissingBackpressureException;
/* loaded from: classes9.dex */
public final class OperatorZip$Zip<R> extends AtomicLong {
    public static final int THRESHOLD = (int) (u7b.c * 0.7d);
    public static final long serialVersionUID = 5995274816189928317L;
    public final k5b<? super R> child;
    public final fab childSubscription;
    public int emitted;
    public AtomicLong requested;
    public volatile Object[] subscribers;
    public final d6b<? extends R> zipFunction;

    /* loaded from: classes9.dex */
    public final class a extends p5b {
        public final u7b e = u7b.a();

        public a() {
        }

        public void g(long j) {
            e(j);
        }

        @Override // com.baidu.tieba.k5b
        public void onError(Throwable th) {
            OperatorZip$Zip.this.child.onError(th);
        }

        @Override // com.baidu.tieba.k5b
        public void onNext(Object obj) {
            try {
                this.e.g(obj);
            } catch (MissingBackpressureException e) {
                onError(e);
            }
            OperatorZip$Zip.this.tick();
        }

        @Override // com.baidu.tieba.p5b
        public void d() {
            e(u7b.c);
        }

        @Override // com.baidu.tieba.k5b
        public void onCompleted() {
            this.e.f();
            OperatorZip$Zip.this.tick();
        }
    }

    public OperatorZip$Zip(p5b<? super R> p5bVar, d6b<? extends R> d6bVar) {
        fab fabVar = new fab();
        this.childSubscription = fabVar;
        this.child = p5bVar;
        this.zipFunction = d6bVar;
        p5bVar.b(fabVar);
    }

    public void start(j5b[] j5bVarArr, AtomicLong atomicLong) {
        Object[] objArr = new Object[j5bVarArr.length];
        for (int i = 0; i < j5bVarArr.length; i++) {
            a aVar = new a();
            objArr[i] = aVar;
            this.childSubscription.a(aVar);
        }
        this.requested = atomicLong;
        this.subscribers = objArr;
        for (int i2 = 0; i2 < j5bVarArr.length; i2++) {
            j5bVarArr[i2].D((a) objArr[i2]);
        }
    }

    /* JADX DEBUG: Type inference failed for r9v4. Raw type applied. Possible types: R, ? super R */
    public void tick() {
        Object[] objArr = this.subscribers;
        if (objArr != null && getAndIncrement() == 0) {
            int length = objArr.length;
            k5b<? super R> k5bVar = this.child;
            AtomicLong atomicLong = this.requested;
            while (true) {
                Object[] objArr2 = new Object[length];
                boolean z = true;
                for (int i = 0; i < length; i++) {
                    u7b u7bVar = ((a) objArr[i]).e;
                    Object h = u7bVar.h();
                    if (h == null) {
                        z = false;
                    } else if (u7bVar.d(h)) {
                        k5bVar.onCompleted();
                        this.childSubscription.unsubscribe();
                        return;
                    } else {
                        objArr2[i] = u7bVar.c(h);
                    }
                }
                if (z && atomicLong.get() > 0) {
                    try {
                        k5bVar.onNext((R) this.zipFunction.call(objArr2));
                        atomicLong.decrementAndGet();
                        this.emitted++;
                        for (Object obj : objArr) {
                            u7b u7bVar2 = ((a) obj).e;
                            u7bVar2.i();
                            if (u7bVar2.d(u7bVar2.h())) {
                                k5bVar.onCompleted();
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
                        v5b.g(th, k5bVar, objArr2);
                        return;
                    }
                } else if (decrementAndGet() <= 0) {
                    return;
                }
            }
        }
    }
}
