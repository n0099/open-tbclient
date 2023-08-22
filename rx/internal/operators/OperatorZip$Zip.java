package rx.internal.operators;

import com.baidu.tieba.dac;
import com.baidu.tieba.i8c;
import com.baidu.tieba.n7c;
import com.baidu.tieba.o7c;
import com.baidu.tieba.occ;
import com.baidu.tieba.t7c;
import com.baidu.tieba.z7c;
import java.util.concurrent.atomic.AtomicLong;
import rx.exceptions.MissingBackpressureException;
/* loaded from: classes2.dex */
public final class OperatorZip$Zip<R> extends AtomicLong {
    public static final int THRESHOLD = (int) (dac.c * 0.7d);
    public static final long serialVersionUID = 5995274816189928317L;
    public final o7c<? super R> child;
    public final occ childSubscription;
    public int emitted;
    public AtomicLong requested;
    public volatile Object[] subscribers;
    public final i8c<? extends R> zipFunction;

    /* loaded from: classes2.dex */
    public final class a extends t7c {
        public final dac e = dac.a();

        public a() {
        }

        public void g(long j) {
            e(j);
        }

        @Override // com.baidu.tieba.o7c
        public void onError(Throwable th) {
            OperatorZip$Zip.this.child.onError(th);
        }

        @Override // com.baidu.tieba.o7c
        public void onNext(Object obj) {
            try {
                this.e.g(obj);
            } catch (MissingBackpressureException e) {
                onError(e);
            }
            OperatorZip$Zip.this.tick();
        }

        @Override // com.baidu.tieba.t7c
        public void d() {
            e(dac.c);
        }

        @Override // com.baidu.tieba.o7c
        public void onCompleted() {
            this.e.f();
            OperatorZip$Zip.this.tick();
        }
    }

    public OperatorZip$Zip(t7c<? super R> t7cVar, i8c<? extends R> i8cVar) {
        occ occVar = new occ();
        this.childSubscription = occVar;
        this.child = t7cVar;
        this.zipFunction = i8cVar;
        t7cVar.b(occVar);
    }

    public void start(n7c[] n7cVarArr, AtomicLong atomicLong) {
        Object[] objArr = new Object[n7cVarArr.length];
        for (int i = 0; i < n7cVarArr.length; i++) {
            a aVar = new a();
            objArr[i] = aVar;
            this.childSubscription.a(aVar);
        }
        this.requested = atomicLong;
        this.subscribers = objArr;
        for (int i2 = 0; i2 < n7cVarArr.length; i2++) {
            n7cVarArr[i2].O((a) objArr[i2]);
        }
    }

    /* JADX DEBUG: Type inference failed for r9v4. Raw type applied. Possible types: R, ? super R */
    public void tick() {
        Object[] objArr = this.subscribers;
        if (objArr != null && getAndIncrement() == 0) {
            int length = objArr.length;
            o7c<? super R> o7cVar = this.child;
            AtomicLong atomicLong = this.requested;
            while (true) {
                Object[] objArr2 = new Object[length];
                boolean z = true;
                for (int i = 0; i < length; i++) {
                    dac dacVar = ((a) objArr[i]).e;
                    Object h = dacVar.h();
                    if (h == null) {
                        z = false;
                    } else if (dacVar.d(h)) {
                        o7cVar.onCompleted();
                        this.childSubscription.unsubscribe();
                        return;
                    } else {
                        objArr2[i] = dacVar.c(h);
                    }
                }
                if (z && atomicLong.get() > 0) {
                    try {
                        o7cVar.onNext((R) this.zipFunction.call(objArr2));
                        atomicLong.decrementAndGet();
                        this.emitted++;
                        for (Object obj : objArr) {
                            dac dacVar2 = ((a) obj).e;
                            dacVar2.i();
                            if (dacVar2.d(dacVar2.h())) {
                                o7cVar.onCompleted();
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
                        z7c.g(th, o7cVar, objArr2);
                        return;
                    }
                } else if (decrementAndGet() <= 0) {
                    return;
                }
            }
        }
    }
}
