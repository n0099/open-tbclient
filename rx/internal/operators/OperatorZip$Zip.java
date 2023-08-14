package rx.internal.operators;

import com.baidu.tieba.e1c;
import com.baidu.tieba.k1c;
import com.baidu.tieba.n3c;
import com.baidu.tieba.s1c;
import com.baidu.tieba.y0c;
import com.baidu.tieba.y5c;
import com.baidu.tieba.z0c;
import java.util.concurrent.atomic.AtomicLong;
import rx.exceptions.MissingBackpressureException;
/* loaded from: classes2.dex */
public final class OperatorZip$Zip<R> extends AtomicLong {
    public static final int THRESHOLD = (int) (n3c.c * 0.7d);
    public static final long serialVersionUID = 5995274816189928317L;
    public final z0c<? super R> child;
    public final y5c childSubscription;
    public int emitted;
    public AtomicLong requested;
    public volatile Object[] subscribers;
    public final s1c<? extends R> zipFunction;

    /* loaded from: classes2.dex */
    public final class a extends e1c {
        public final n3c e = n3c.a();

        public a() {
        }

        public void g(long j) {
            e(j);
        }

        @Override // com.baidu.tieba.z0c
        public void onError(Throwable th) {
            OperatorZip$Zip.this.child.onError(th);
        }

        @Override // com.baidu.tieba.z0c
        public void onNext(Object obj) {
            try {
                this.e.g(obj);
            } catch (MissingBackpressureException e) {
                onError(e);
            }
            OperatorZip$Zip.this.tick();
        }

        @Override // com.baidu.tieba.e1c
        public void d() {
            e(n3c.c);
        }

        @Override // com.baidu.tieba.z0c
        public void onCompleted() {
            this.e.f();
            OperatorZip$Zip.this.tick();
        }
    }

    public OperatorZip$Zip(e1c<? super R> e1cVar, s1c<? extends R> s1cVar) {
        y5c y5cVar = new y5c();
        this.childSubscription = y5cVar;
        this.child = e1cVar;
        this.zipFunction = s1cVar;
        e1cVar.b(y5cVar);
    }

    public void start(y0c[] y0cVarArr, AtomicLong atomicLong) {
        Object[] objArr = new Object[y0cVarArr.length];
        for (int i = 0; i < y0cVarArr.length; i++) {
            a aVar = new a();
            objArr[i] = aVar;
            this.childSubscription.a(aVar);
        }
        this.requested = atomicLong;
        this.subscribers = objArr;
        for (int i2 = 0; i2 < y0cVarArr.length; i2++) {
            y0cVarArr[i2].O((a) objArr[i2]);
        }
    }

    /* JADX DEBUG: Type inference failed for r9v4. Raw type applied. Possible types: R, ? super R */
    public void tick() {
        Object[] objArr = this.subscribers;
        if (objArr != null && getAndIncrement() == 0) {
            int length = objArr.length;
            z0c<? super R> z0cVar = this.child;
            AtomicLong atomicLong = this.requested;
            while (true) {
                Object[] objArr2 = new Object[length];
                boolean z = true;
                for (int i = 0; i < length; i++) {
                    n3c n3cVar = ((a) objArr[i]).e;
                    Object h = n3cVar.h();
                    if (h == null) {
                        z = false;
                    } else if (n3cVar.d(h)) {
                        z0cVar.onCompleted();
                        this.childSubscription.unsubscribe();
                        return;
                    } else {
                        objArr2[i] = n3cVar.c(h);
                    }
                }
                if (z && atomicLong.get() > 0) {
                    try {
                        z0cVar.onNext((R) this.zipFunction.call(objArr2));
                        atomicLong.decrementAndGet();
                        this.emitted++;
                        for (Object obj : objArr) {
                            n3c n3cVar2 = ((a) obj).e;
                            n3cVar2.i();
                            if (n3cVar2.d(n3cVar2.h())) {
                                z0cVar.onCompleted();
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
                        k1c.g(th, z0cVar, objArr2);
                        return;
                    }
                } else if (decrementAndGet() <= 0) {
                    return;
                }
            }
        }
    }
}
