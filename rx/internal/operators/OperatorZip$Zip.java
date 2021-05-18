package rx.internal.operators;

import h.d;
import h.e;
import h.n.j;
import h.o.d.f;
import h.u.b;
import java.util.concurrent.atomic.AtomicLong;
import rx.exceptions.MissingBackpressureException;
/* loaded from: classes7.dex */
public final class OperatorZip$Zip<R> extends AtomicLong {
    public static final int THRESHOLD = (int) (f.f68630g * 0.7d);
    public static final long serialVersionUID = 5995274816189928317L;
    public final e<? super R> child;
    public final b childSubscription;
    public int emitted;
    public AtomicLong requested;
    public volatile Object[] subscribers;
    public final j<? extends R> zipFunction;

    /* loaded from: classes7.dex */
    public final class a extends h.j {

        /* renamed from: e  reason: collision with root package name */
        public final f f69101e = f.a();

        public a() {
        }

        public void b(long j) {
            request(j);
        }

        @Override // h.e
        public void onCompleted() {
            this.f69101e.f();
            OperatorZip$Zip.this.tick();
        }

        @Override // h.e
        public void onError(Throwable th) {
            OperatorZip$Zip.this.child.onError(th);
        }

        @Override // h.e
        public void onNext(Object obj) {
            try {
                this.f69101e.g(obj);
            } catch (MissingBackpressureException e2) {
                onError(e2);
            }
            OperatorZip$Zip.this.tick();
        }

        @Override // h.j
        public void onStart() {
            request(f.f68630g);
        }
    }

    public OperatorZip$Zip(h.j<? super R> jVar, j<? extends R> jVar2) {
        b bVar = new b();
        this.childSubscription = bVar;
        this.child = jVar;
        this.zipFunction = jVar2;
        jVar.add(bVar);
    }

    public void start(d[] dVarArr, AtomicLong atomicLong) {
        Object[] objArr = new Object[dVarArr.length];
        for (int i2 = 0; i2 < dVarArr.length; i2++) {
            a aVar = new a();
            objArr[i2] = aVar;
            this.childSubscription.a(aVar);
        }
        this.requested = atomicLong;
        this.subscribers = objArr;
        for (int i3 = 0; i3 < dVarArr.length; i3++) {
            dVarArr[i3].I((a) objArr[i3]);
        }
    }

    /* JADX DEBUG: Type inference failed for r9v4. Raw type applied. Possible types: R, ? super R */
    public void tick() {
        Object[] objArr = this.subscribers;
        if (objArr == null || getAndIncrement() != 0) {
            return;
        }
        int length = objArr.length;
        e<? super R> eVar = this.child;
        AtomicLong atomicLong = this.requested;
        while (true) {
            Object[] objArr2 = new Object[length];
            boolean z = true;
            for (int i2 = 0; i2 < length; i2++) {
                f fVar = ((a) objArr[i2]).f69101e;
                Object h2 = fVar.h();
                if (h2 == null) {
                    z = false;
                } else if (fVar.d(h2)) {
                    eVar.onCompleted();
                    this.childSubscription.unsubscribe();
                    return;
                } else {
                    objArr2[i2] = fVar.c(h2);
                }
            }
            if (z && atomicLong.get() > 0) {
                try {
                    eVar.onNext((R) this.zipFunction.call(objArr2));
                    atomicLong.decrementAndGet();
                    this.emitted++;
                    for (Object obj : objArr) {
                        f fVar2 = ((a) obj).f69101e;
                        fVar2.i();
                        if (fVar2.d(fVar2.h())) {
                            eVar.onCompleted();
                            this.childSubscription.unsubscribe();
                            return;
                        }
                    }
                    if (this.emitted > THRESHOLD) {
                        for (Object obj2 : objArr) {
                            ((a) obj2).b(this.emitted);
                        }
                        this.emitted = 0;
                    }
                } catch (Throwable th) {
                    h.m.a.g(th, eVar, objArr2);
                    return;
                }
            } else if (decrementAndGet() <= 0) {
                return;
            }
        }
    }
}
