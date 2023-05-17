package rx.internal.operators;

import com.baidu.tieba.b8b;
import com.baidu.tieba.ecb;
import com.baidu.tieba.h7b;
import com.baidu.tieba.i7b;
import com.baidu.tieba.n7b;
import com.baidu.tieba.t7b;
import com.baidu.tieba.t9b;
import java.util.concurrent.atomic.AtomicLong;
import rx.exceptions.MissingBackpressureException;
/* loaded from: classes10.dex */
public final class OperatorZip$Zip<R> extends AtomicLong {
    public static final int THRESHOLD = (int) (t9b.c * 0.7d);
    public static final long serialVersionUID = 5995274816189928317L;
    public final i7b<? super R> child;
    public final ecb childSubscription;
    public int emitted;
    public AtomicLong requested;
    public volatile Object[] subscribers;
    public final b8b<? extends R> zipFunction;

    /* loaded from: classes10.dex */
    public final class a extends n7b {
        public final t9b e = t9b.a();

        public a() {
        }

        public void g(long j) {
            e(j);
        }

        @Override // com.baidu.tieba.i7b
        public void onError(Throwable th) {
            OperatorZip$Zip.this.child.onError(th);
        }

        @Override // com.baidu.tieba.i7b
        public void onNext(Object obj) {
            try {
                this.e.g(obj);
            } catch (MissingBackpressureException e) {
                onError(e);
            }
            OperatorZip$Zip.this.tick();
        }

        @Override // com.baidu.tieba.n7b
        public void d() {
            e(t9b.c);
        }

        @Override // com.baidu.tieba.i7b
        public void onCompleted() {
            this.e.f();
            OperatorZip$Zip.this.tick();
        }
    }

    public OperatorZip$Zip(n7b<? super R> n7bVar, b8b<? extends R> b8bVar) {
        ecb ecbVar = new ecb();
        this.childSubscription = ecbVar;
        this.child = n7bVar;
        this.zipFunction = b8bVar;
        n7bVar.b(ecbVar);
    }

    public void start(h7b[] h7bVarArr, AtomicLong atomicLong) {
        Object[] objArr = new Object[h7bVarArr.length];
        for (int i = 0; i < h7bVarArr.length; i++) {
            a aVar = new a();
            objArr[i] = aVar;
            this.childSubscription.a(aVar);
        }
        this.requested = atomicLong;
        this.subscribers = objArr;
        for (int i2 = 0; i2 < h7bVarArr.length; i2++) {
            h7bVarArr[i2].F((a) objArr[i2]);
        }
    }

    /* JADX DEBUG: Type inference failed for r9v4. Raw type applied. Possible types: R, ? super R */
    public void tick() {
        Object[] objArr = this.subscribers;
        if (objArr != null && getAndIncrement() == 0) {
            int length = objArr.length;
            i7b<? super R> i7bVar = this.child;
            AtomicLong atomicLong = this.requested;
            while (true) {
                Object[] objArr2 = new Object[length];
                boolean z = true;
                for (int i = 0; i < length; i++) {
                    t9b t9bVar = ((a) objArr[i]).e;
                    Object h = t9bVar.h();
                    if (h == null) {
                        z = false;
                    } else if (t9bVar.d(h)) {
                        i7bVar.onCompleted();
                        this.childSubscription.unsubscribe();
                        return;
                    } else {
                        objArr2[i] = t9bVar.c(h);
                    }
                }
                if (z && atomicLong.get() > 0) {
                    try {
                        i7bVar.onNext((R) this.zipFunction.call(objArr2));
                        atomicLong.decrementAndGet();
                        this.emitted++;
                        for (Object obj : objArr) {
                            t9b t9bVar2 = ((a) obj).e;
                            t9bVar2.i();
                            if (t9bVar2.d(t9bVar2.h())) {
                                i7bVar.onCompleted();
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
                        t7b.g(th, i7bVar, objArr2);
                        return;
                    }
                } else if (decrementAndGet() <= 0) {
                    return;
                }
            }
        }
    }
}
