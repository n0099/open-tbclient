package rx.internal.operators;

import com.baidu.tieba.h2b;
import com.baidu.tieba.h6b;
import com.baidu.tieba.n1b;
import com.baidu.tieba.o1b;
import com.baidu.tieba.t1b;
import com.baidu.tieba.w3b;
import com.baidu.tieba.z1b;
import java.util.concurrent.atomic.AtomicLong;
import rx.exceptions.MissingBackpressureException;
/* loaded from: classes9.dex */
public final class OperatorZip$Zip<R> extends AtomicLong {
    public static final int THRESHOLD = (int) (w3b.c * 0.7d);
    public static final long serialVersionUID = 5995274816189928317L;
    public final o1b<? super R> child;
    public final h6b childSubscription;
    public int emitted;
    public AtomicLong requested;
    public volatile Object[] subscribers;
    public final h2b<? extends R> zipFunction;

    /* loaded from: classes9.dex */
    public final class a extends t1b {
        public final w3b e = w3b.a();

        public a() {
        }

        public void g(long j) {
            e(j);
        }

        @Override // com.baidu.tieba.o1b
        public void onError(Throwable th) {
            OperatorZip$Zip.this.child.onError(th);
        }

        @Override // com.baidu.tieba.o1b
        public void onNext(Object obj) {
            try {
                this.e.g(obj);
            } catch (MissingBackpressureException e) {
                onError(e);
            }
            OperatorZip$Zip.this.tick();
        }

        @Override // com.baidu.tieba.t1b
        public void d() {
            e(w3b.c);
        }

        @Override // com.baidu.tieba.o1b
        public void onCompleted() {
            this.e.f();
            OperatorZip$Zip.this.tick();
        }
    }

    public OperatorZip$Zip(t1b<? super R> t1bVar, h2b<? extends R> h2bVar) {
        h6b h6bVar = new h6b();
        this.childSubscription = h6bVar;
        this.child = t1bVar;
        this.zipFunction = h2bVar;
        t1bVar.b(h6bVar);
    }

    public void start(n1b[] n1bVarArr, AtomicLong atomicLong) {
        Object[] objArr = new Object[n1bVarArr.length];
        for (int i = 0; i < n1bVarArr.length; i++) {
            a aVar = new a();
            objArr[i] = aVar;
            this.childSubscription.a(aVar);
        }
        this.requested = atomicLong;
        this.subscribers = objArr;
        for (int i2 = 0; i2 < n1bVarArr.length; i2++) {
            n1bVarArr[i2].B((a) objArr[i2]);
        }
    }

    /* JADX DEBUG: Type inference failed for r9v4. Raw type applied. Possible types: R, ? super R */
    public void tick() {
        Object[] objArr = this.subscribers;
        if (objArr != null && getAndIncrement() == 0) {
            int length = objArr.length;
            o1b<? super R> o1bVar = this.child;
            AtomicLong atomicLong = this.requested;
            while (true) {
                Object[] objArr2 = new Object[length];
                boolean z = true;
                for (int i = 0; i < length; i++) {
                    w3b w3bVar = ((a) objArr[i]).e;
                    Object h = w3bVar.h();
                    if (h == null) {
                        z = false;
                    } else if (w3bVar.d(h)) {
                        o1bVar.onCompleted();
                        this.childSubscription.unsubscribe();
                        return;
                    } else {
                        objArr2[i] = w3bVar.c(h);
                    }
                }
                if (z && atomicLong.get() > 0) {
                    try {
                        o1bVar.onNext((R) this.zipFunction.call(objArr2));
                        atomicLong.decrementAndGet();
                        this.emitted++;
                        for (Object obj : objArr) {
                            w3b w3bVar2 = ((a) obj).e;
                            w3bVar2.i();
                            if (w3bVar2.d(w3bVar2.h())) {
                                o1bVar.onCompleted();
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
                        z1b.g(th, o1bVar, objArr2);
                        return;
                    }
                } else if (decrementAndGet() <= 0) {
                    return;
                }
            }
        }
    }
}
