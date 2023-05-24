package rx.internal.operators;

import com.baidu.tieba.c8b;
import com.baidu.tieba.fcb;
import com.baidu.tieba.i7b;
import com.baidu.tieba.j7b;
import com.baidu.tieba.o7b;
import com.baidu.tieba.u7b;
import com.baidu.tieba.u9b;
import java.util.concurrent.atomic.AtomicLong;
import rx.exceptions.MissingBackpressureException;
/* loaded from: classes10.dex */
public final class OperatorZip$Zip<R> extends AtomicLong {
    public static final int THRESHOLD = (int) (u9b.c * 0.7d);
    public static final long serialVersionUID = 5995274816189928317L;
    public final j7b<? super R> child;
    public final fcb childSubscription;
    public int emitted;
    public AtomicLong requested;
    public volatile Object[] subscribers;
    public final c8b<? extends R> zipFunction;

    /* loaded from: classes10.dex */
    public final class a extends o7b {
        public final u9b e = u9b.a();

        public a() {
        }

        public void g(long j) {
            e(j);
        }

        @Override // com.baidu.tieba.j7b
        public void onError(Throwable th) {
            OperatorZip$Zip.this.child.onError(th);
        }

        @Override // com.baidu.tieba.j7b
        public void onNext(Object obj) {
            try {
                this.e.g(obj);
            } catch (MissingBackpressureException e) {
                onError(e);
            }
            OperatorZip$Zip.this.tick();
        }

        @Override // com.baidu.tieba.o7b
        public void d() {
            e(u9b.c);
        }

        @Override // com.baidu.tieba.j7b
        public void onCompleted() {
            this.e.f();
            OperatorZip$Zip.this.tick();
        }
    }

    public OperatorZip$Zip(o7b<? super R> o7bVar, c8b<? extends R> c8bVar) {
        fcb fcbVar = new fcb();
        this.childSubscription = fcbVar;
        this.child = o7bVar;
        this.zipFunction = c8bVar;
        o7bVar.b(fcbVar);
    }

    public void start(i7b[] i7bVarArr, AtomicLong atomicLong) {
        Object[] objArr = new Object[i7bVarArr.length];
        for (int i = 0; i < i7bVarArr.length; i++) {
            a aVar = new a();
            objArr[i] = aVar;
            this.childSubscription.a(aVar);
        }
        this.requested = atomicLong;
        this.subscribers = objArr;
        for (int i2 = 0; i2 < i7bVarArr.length; i2++) {
            i7bVarArr[i2].F((a) objArr[i2]);
        }
    }

    /* JADX DEBUG: Type inference failed for r9v4. Raw type applied. Possible types: R, ? super R */
    public void tick() {
        Object[] objArr = this.subscribers;
        if (objArr != null && getAndIncrement() == 0) {
            int length = objArr.length;
            j7b<? super R> j7bVar = this.child;
            AtomicLong atomicLong = this.requested;
            while (true) {
                Object[] objArr2 = new Object[length];
                boolean z = true;
                for (int i = 0; i < length; i++) {
                    u9b u9bVar = ((a) objArr[i]).e;
                    Object h = u9bVar.h();
                    if (h == null) {
                        z = false;
                    } else if (u9bVar.d(h)) {
                        j7bVar.onCompleted();
                        this.childSubscription.unsubscribe();
                        return;
                    } else {
                        objArr2[i] = u9bVar.c(h);
                    }
                }
                if (z && atomicLong.get() > 0) {
                    try {
                        j7bVar.onNext((R) this.zipFunction.call(objArr2));
                        atomicLong.decrementAndGet();
                        this.emitted++;
                        for (Object obj : objArr) {
                            u9b u9bVar2 = ((a) obj).e;
                            u9bVar2.i();
                            if (u9bVar2.d(u9bVar2.h())) {
                                j7bVar.onCompleted();
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
                        u7b.g(th, j7bVar, objArr2);
                        return;
                    }
                } else if (decrementAndGet() <= 0) {
                    return;
                }
            }
        }
    }
}
