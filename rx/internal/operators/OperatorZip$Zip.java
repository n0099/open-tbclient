package rx.internal.operators;

import com.baidu.tieba.apb;
import com.baidu.tieba.dtb;
import com.baidu.tieba.gob;
import com.baidu.tieba.hob;
import com.baidu.tieba.mob;
import com.baidu.tieba.sob;
import com.baidu.tieba.sqb;
import java.util.concurrent.atomic.AtomicLong;
import rx.exceptions.MissingBackpressureException;
/* loaded from: classes2.dex */
public final class OperatorZip$Zip<R> extends AtomicLong {
    public static final int THRESHOLD = (int) (sqb.c * 0.7d);
    public static final long serialVersionUID = 5995274816189928317L;
    public final hob<? super R> child;
    public final dtb childSubscription;
    public int emitted;
    public AtomicLong requested;
    public volatile Object[] subscribers;
    public final apb<? extends R> zipFunction;

    /* loaded from: classes2.dex */
    public final class a extends mob {
        public final sqb e = sqb.a();

        public a() {
        }

        public void g(long j) {
            e(j);
        }

        @Override // com.baidu.tieba.hob
        public void onError(Throwable th) {
            OperatorZip$Zip.this.child.onError(th);
        }

        @Override // com.baidu.tieba.hob
        public void onNext(Object obj) {
            try {
                this.e.g(obj);
            } catch (MissingBackpressureException e) {
                onError(e);
            }
            OperatorZip$Zip.this.tick();
        }

        @Override // com.baidu.tieba.mob
        public void d() {
            e(sqb.c);
        }

        @Override // com.baidu.tieba.hob
        public void onCompleted() {
            this.e.f();
            OperatorZip$Zip.this.tick();
        }
    }

    public OperatorZip$Zip(mob<? super R> mobVar, apb<? extends R> apbVar) {
        dtb dtbVar = new dtb();
        this.childSubscription = dtbVar;
        this.child = mobVar;
        this.zipFunction = apbVar;
        mobVar.b(dtbVar);
    }

    public void start(gob[] gobVarArr, AtomicLong atomicLong) {
        Object[] objArr = new Object[gobVarArr.length];
        for (int i = 0; i < gobVarArr.length; i++) {
            a aVar = new a();
            objArr[i] = aVar;
            this.childSubscription.a(aVar);
        }
        this.requested = atomicLong;
        this.subscribers = objArr;
        for (int i2 = 0; i2 < gobVarArr.length; i2++) {
            gobVarArr[i2].F((a) objArr[i2]);
        }
    }

    /* JADX DEBUG: Type inference failed for r9v4. Raw type applied. Possible types: R, ? super R */
    public void tick() {
        Object[] objArr = this.subscribers;
        if (objArr != null && getAndIncrement() == 0) {
            int length = objArr.length;
            hob<? super R> hobVar = this.child;
            AtomicLong atomicLong = this.requested;
            while (true) {
                Object[] objArr2 = new Object[length];
                boolean z = true;
                for (int i = 0; i < length; i++) {
                    sqb sqbVar = ((a) objArr[i]).e;
                    Object h = sqbVar.h();
                    if (h == null) {
                        z = false;
                    } else if (sqbVar.d(h)) {
                        hobVar.onCompleted();
                        this.childSubscription.unsubscribe();
                        return;
                    } else {
                        objArr2[i] = sqbVar.c(h);
                    }
                }
                if (z && atomicLong.get() > 0) {
                    try {
                        hobVar.onNext((R) this.zipFunction.call(objArr2));
                        atomicLong.decrementAndGet();
                        this.emitted++;
                        for (Object obj : objArr) {
                            sqb sqbVar2 = ((a) obj).e;
                            sqbVar2.i();
                            if (sqbVar2.d(sqbVar2.h())) {
                                hobVar.onCompleted();
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
                        sob.g(th, hobVar, objArr2);
                        return;
                    }
                } else if (decrementAndGet() <= 0) {
                    return;
                }
            }
        }
    }
}
