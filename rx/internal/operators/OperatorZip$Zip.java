package rx.internal.operators;

import com.baidu.tieba.d1c;
import com.baidu.tieba.j1c;
import com.baidu.tieba.m3c;
import com.baidu.tieba.r1c;
import com.baidu.tieba.x0c;
import com.baidu.tieba.x5c;
import com.baidu.tieba.y0c;
import java.util.concurrent.atomic.AtomicLong;
import rx.exceptions.MissingBackpressureException;
/* loaded from: classes2.dex */
public final class OperatorZip$Zip<R> extends AtomicLong {
    public static final int THRESHOLD = (int) (m3c.c * 0.7d);
    public static final long serialVersionUID = 5995274816189928317L;
    public final y0c<? super R> child;
    public final x5c childSubscription;
    public int emitted;
    public AtomicLong requested;
    public volatile Object[] subscribers;
    public final r1c<? extends R> zipFunction;

    /* loaded from: classes2.dex */
    public final class a extends d1c {
        public final m3c e = m3c.a();

        public a() {
        }

        public void g(long j) {
            e(j);
        }

        @Override // com.baidu.tieba.y0c
        public void onError(Throwable th) {
            OperatorZip$Zip.this.child.onError(th);
        }

        @Override // com.baidu.tieba.y0c
        public void onNext(Object obj) {
            try {
                this.e.g(obj);
            } catch (MissingBackpressureException e) {
                onError(e);
            }
            OperatorZip$Zip.this.tick();
        }

        @Override // com.baidu.tieba.d1c
        public void d() {
            e(m3c.c);
        }

        @Override // com.baidu.tieba.y0c
        public void onCompleted() {
            this.e.f();
            OperatorZip$Zip.this.tick();
        }
    }

    public OperatorZip$Zip(d1c<? super R> d1cVar, r1c<? extends R> r1cVar) {
        x5c x5cVar = new x5c();
        this.childSubscription = x5cVar;
        this.child = d1cVar;
        this.zipFunction = r1cVar;
        d1cVar.b(x5cVar);
    }

    public void start(x0c[] x0cVarArr, AtomicLong atomicLong) {
        Object[] objArr = new Object[x0cVarArr.length];
        for (int i = 0; i < x0cVarArr.length; i++) {
            a aVar = new a();
            objArr[i] = aVar;
            this.childSubscription.a(aVar);
        }
        this.requested = atomicLong;
        this.subscribers = objArr;
        for (int i2 = 0; i2 < x0cVarArr.length; i2++) {
            x0cVarArr[i2].O((a) objArr[i2]);
        }
    }

    /* JADX DEBUG: Type inference failed for r9v4. Raw type applied. Possible types: R, ? super R */
    public void tick() {
        Object[] objArr = this.subscribers;
        if (objArr != null && getAndIncrement() == 0) {
            int length = objArr.length;
            y0c<? super R> y0cVar = this.child;
            AtomicLong atomicLong = this.requested;
            while (true) {
                Object[] objArr2 = new Object[length];
                boolean z = true;
                for (int i = 0; i < length; i++) {
                    m3c m3cVar = ((a) objArr[i]).e;
                    Object h = m3cVar.h();
                    if (h == null) {
                        z = false;
                    } else if (m3cVar.d(h)) {
                        y0cVar.onCompleted();
                        this.childSubscription.unsubscribe();
                        return;
                    } else {
                        objArr2[i] = m3cVar.c(h);
                    }
                }
                if (z && atomicLong.get() > 0) {
                    try {
                        y0cVar.onNext((R) this.zipFunction.call(objArr2));
                        atomicLong.decrementAndGet();
                        this.emitted++;
                        for (Object obj : objArr) {
                            m3c m3cVar2 = ((a) obj).e;
                            m3cVar2.i();
                            if (m3cVar2.d(m3cVar2.h())) {
                                y0cVar.onCompleted();
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
                        j1c.g(th, y0cVar, objArr2);
                        return;
                    }
                } else if (decrementAndGet() <= 0) {
                    return;
                }
            }
        }
    }
}
