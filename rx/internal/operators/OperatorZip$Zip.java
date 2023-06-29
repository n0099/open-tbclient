package rx.internal.operators;

import com.baidu.tieba.dtb;
import com.baidu.tieba.jtb;
import com.baidu.tieba.mvb;
import com.baidu.tieba.rtb;
import com.baidu.tieba.xsb;
import com.baidu.tieba.xxb;
import com.baidu.tieba.ysb;
import java.util.concurrent.atomic.AtomicLong;
import rx.exceptions.MissingBackpressureException;
/* loaded from: classes2.dex */
public final class OperatorZip$Zip<R> extends AtomicLong {
    public static final int THRESHOLD = (int) (mvb.c * 0.7d);
    public static final long serialVersionUID = 5995274816189928317L;
    public final ysb<? super R> child;
    public final xxb childSubscription;
    public int emitted;
    public AtomicLong requested;
    public volatile Object[] subscribers;
    public final rtb<? extends R> zipFunction;

    /* loaded from: classes2.dex */
    public final class a extends dtb {
        public final mvb e = mvb.a();

        public a() {
        }

        public void g(long j) {
            e(j);
        }

        @Override // com.baidu.tieba.ysb
        public void onError(Throwable th) {
            OperatorZip$Zip.this.child.onError(th);
        }

        @Override // com.baidu.tieba.ysb
        public void onNext(Object obj) {
            try {
                this.e.g(obj);
            } catch (MissingBackpressureException e) {
                onError(e);
            }
            OperatorZip$Zip.this.tick();
        }

        @Override // com.baidu.tieba.dtb
        public void d() {
            e(mvb.c);
        }

        @Override // com.baidu.tieba.ysb
        public void onCompleted() {
            this.e.f();
            OperatorZip$Zip.this.tick();
        }
    }

    public OperatorZip$Zip(dtb<? super R> dtbVar, rtb<? extends R> rtbVar) {
        xxb xxbVar = new xxb();
        this.childSubscription = xxbVar;
        this.child = dtbVar;
        this.zipFunction = rtbVar;
        dtbVar.b(xxbVar);
    }

    public void start(xsb[] xsbVarArr, AtomicLong atomicLong) {
        Object[] objArr = new Object[xsbVarArr.length];
        for (int i = 0; i < xsbVarArr.length; i++) {
            a aVar = new a();
            objArr[i] = aVar;
            this.childSubscription.a(aVar);
        }
        this.requested = atomicLong;
        this.subscribers = objArr;
        for (int i2 = 0; i2 < xsbVarArr.length; i2++) {
            xsbVarArr[i2].M((a) objArr[i2]);
        }
    }

    /* JADX DEBUG: Type inference failed for r9v4. Raw type applied. Possible types: R, ? super R */
    public void tick() {
        Object[] objArr = this.subscribers;
        if (objArr != null && getAndIncrement() == 0) {
            int length = objArr.length;
            ysb<? super R> ysbVar = this.child;
            AtomicLong atomicLong = this.requested;
            while (true) {
                Object[] objArr2 = new Object[length];
                boolean z = true;
                for (int i = 0; i < length; i++) {
                    mvb mvbVar = ((a) objArr[i]).e;
                    Object h = mvbVar.h();
                    if (h == null) {
                        z = false;
                    } else if (mvbVar.d(h)) {
                        ysbVar.onCompleted();
                        this.childSubscription.unsubscribe();
                        return;
                    } else {
                        objArr2[i] = mvbVar.c(h);
                    }
                }
                if (z && atomicLong.get() > 0) {
                    try {
                        ysbVar.onNext((R) this.zipFunction.call(objArr2));
                        atomicLong.decrementAndGet();
                        this.emitted++;
                        for (Object obj : objArr) {
                            mvb mvbVar2 = ((a) obj).e;
                            mvbVar2.i();
                            if (mvbVar2.d(mvbVar2.h())) {
                                ysbVar.onCompleted();
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
                        jtb.g(th, ysbVar, objArr2);
                        return;
                    }
                } else if (decrementAndGet() <= 0) {
                    return;
                }
            }
        }
    }
}
