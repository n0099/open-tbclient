package rx.subjects;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import rx.d;
import rx.functions.Actions;
import rx.internal.operators.NotificationLite;
import rx.j;
import rx.subscriptions.e;
/* loaded from: classes2.dex */
final class SubjectSubscriptionManager<T> extends AtomicReference<a<T>> implements d.a<T> {
    private static final long serialVersionUID = 6035251036011671568L;
    boolean active;
    volatile Object latest;
    rx.functions.b<b<T>> onAdded;
    rx.functions.b<b<T>> onStart;
    rx.functions.b<b<T>> onTerminated;

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((j) ((j) obj));
    }

    public SubjectSubscriptionManager() {
        super(a.kGm);
        this.active = true;
        this.onStart = Actions.cOv();
        this.onAdded = Actions.cOv();
        this.onTerminated = Actions.cOv();
    }

    public void call(j<? super T> jVar) {
        b<T> bVar = new b<>(jVar);
        addUnsubscriber(jVar, bVar);
        this.onStart.call(bVar);
        if (!jVar.isUnsubscribed() && add(bVar) && jVar.isUnsubscribed()) {
            remove(bVar);
        }
    }

    void addUnsubscriber(j<? super T> jVar, final b<T> bVar) {
        jVar.add(e.l(new rx.functions.a() { // from class: rx.subjects.SubjectSubscriptionManager.1
            @Override // rx.functions.a
            public void call() {
                SubjectSubscriptionManager.this.remove(bVar);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setLatest(Object obj) {
        this.latest = obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object getLatest() {
        return this.latest;
    }

    b<T>[] observers() {
        return get().kGj;
    }

    boolean add(b<T> bVar) {
        a<T> aVar;
        do {
            aVar = get();
            if (aVar.terminated) {
                this.onTerminated.call(bVar);
                return false;
            }
        } while (!compareAndSet(aVar, aVar.b(bVar)));
        this.onAdded.call(bVar);
        return true;
    }

    void remove(b<T> bVar) {
        a<T> aVar;
        a<T> c;
        do {
            aVar = get();
            if (aVar.terminated || (c = aVar.c(bVar)) == aVar) {
                return;
            }
        } while (!compareAndSet(aVar, c));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b<T>[] next(Object obj) {
        setLatest(obj);
        return get().kGj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b<T>[] terminate(Object obj) {
        setLatest(obj);
        this.active = false;
        return get().terminated ? a.kGk : getAndSet(a.kGl).kGj;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public static final class a<T> {
        static final b[] kGk = new b[0];
        static final a kGl = new a(true, kGk);
        static final a kGm = new a(false, kGk);
        final b[] kGj;
        final boolean terminated;

        public a(boolean z, b[] bVarArr) {
            this.terminated = z;
            this.kGj = bVarArr;
        }

        public a b(b bVar) {
            int length = this.kGj.length;
            b[] bVarArr = new b[length + 1];
            System.arraycopy(this.kGj, 0, bVarArr, 0, length);
            bVarArr[length] = bVar;
            return new a(this.terminated, bVarArr);
        }

        public a c(b bVar) {
            b[] bVarArr;
            int i;
            b[] bVarArr2 = this.kGj;
            int length = bVarArr2.length;
            if (length == 1 && bVarArr2[0] == bVar) {
                return kGm;
            }
            if (length != 0) {
                b[] bVarArr3 = new b[length - 1];
                int i2 = 0;
                int i3 = 0;
                while (i2 < length) {
                    b bVar2 = bVarArr2[i2];
                    if (bVar2 == bVar) {
                        i = i3;
                    } else if (i3 != length - 1) {
                        i = i3 + 1;
                        bVarArr3[i3] = bVar2;
                    } else {
                        return this;
                    }
                    i2++;
                    i3 = i;
                }
                if (i3 == 0) {
                    return kGm;
                }
                if (i3 < length - 1) {
                    bVarArr = new b[i3];
                    System.arraycopy(bVarArr3, 0, bVarArr, 0, i3);
                } else {
                    bVarArr = bVarArr3;
                }
                return new a(this.terminated, bVarArr);
            }
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public static final class b<T> implements rx.e<T> {
        final j<? super T> actual;
        boolean emitting;
        boolean first = true;
        List<Object> kGn;
        boolean kGo;

        public b(j<? super T> jVar) {
            this.actual = jVar;
        }

        @Override // rx.e
        public void onNext(T t) {
            this.actual.onNext(t);
        }

        @Override // rx.e
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // rx.e
        public void onCompleted() {
            this.actual.onCompleted();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void bB(Object obj) {
            if (!this.kGo) {
                synchronized (this) {
                    this.first = false;
                    if (this.emitting) {
                        if (this.kGn == null) {
                            this.kGn = new ArrayList();
                        }
                        this.kGn.add(obj);
                        return;
                    }
                    this.kGo = true;
                }
            }
            NotificationLite.a(this.actual, obj);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void bC(Object obj) {
            synchronized (this) {
                if (this.first && !this.emitting) {
                    this.first = false;
                    this.emitting = obj != null;
                    if (obj != null) {
                        a(null, obj);
                    }
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x001a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void a(List<Object> list, Object obj) {
            boolean z = true;
            boolean z2 = false;
            boolean z3 = true;
            while (true) {
                if (list != null) {
                    try {
                        for (Object obj2 : list) {
                            bD(obj2);
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (!z2) {
                            synchronized (this) {
                                this.emitting = false;
                            }
                        }
                        throw th;
                    }
                }
                if (z3) {
                    bD(obj);
                    z3 = false;
                }
                try {
                    synchronized (this) {
                        try {
                            list = this.kGn;
                            this.kGn = null;
                            if (list == null) {
                                this.emitting = false;
                                return;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            z = false;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
                try {
                    throw th;
                } catch (Throwable th4) {
                    th = th4;
                    z2 = z;
                    if (!z2) {
                    }
                    throw th;
                }
            }
        }

        void bD(Object obj) {
            if (obj != null) {
                NotificationLite.a(this.actual, obj);
            }
        }
    }
}
