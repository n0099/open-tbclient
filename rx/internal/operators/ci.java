package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import rx.d;
import rx.subjects.UnicastSubject;
/* loaded from: classes2.dex */
public final class ci<T, U> implements d.b<rx.d<T>, T> {
    static final Object iAz = new Object();
    final rx.functions.e<? extends rx.d<? extends U>> iAE;

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public ci(rx.functions.e<? extends rx.d<? extends U>> eVar) {
        this.iAE = eVar;
    }

    public rx.j<? super T> call(rx.j<? super rx.d<T>> jVar) {
        b bVar = new b(jVar, this.iAE);
        jVar.add(bVar);
        bVar.ccx();
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class b<T, U> extends rx.j<T> {
        final rx.j<? super rx.d<T>> child;
        boolean emitting;
        rx.e<T> iAB;
        rx.d<T> iAC;
        List<Object> iAD;
        final rx.functions.e<? extends rx.d<? extends U>> iAE;
        final Object guard = new Object();
        final rx.subscriptions.d serial = new rx.subscriptions.d();

        public b(rx.j<? super rx.d<T>> jVar, rx.functions.e<? extends rx.d<? extends U>> eVar) {
            this.child = new rx.b.f(jVar);
            this.iAE = eVar;
            add(this.serial);
        }

        @Override // rx.j
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        @Override // rx.e
        public void onNext(T t) {
            boolean z = true;
            boolean z2 = false;
            synchronized (this.guard) {
                if (this.emitting) {
                    if (this.iAD == null) {
                        this.iAD = new ArrayList();
                    }
                    this.iAD.add(t);
                    return;
                }
                List<Object> list = this.iAD;
                this.iAD = null;
                this.emitting = true;
                List<Object> list2 = list;
                boolean z3 = true;
                do {
                    try {
                        eA(list2);
                        if (z3) {
                            bl(t);
                            z3 = false;
                        }
                        try {
                            synchronized (this.guard) {
                                try {
                                    list2 = this.iAD;
                                    this.iAD = null;
                                    if (list2 == null) {
                                        this.emitting = false;
                                        return;
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    z = false;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                        try {
                            throw th;
                        } catch (Throwable th3) {
                            th = th3;
                            z2 = z;
                            if (!z2) {
                                synchronized (this.guard) {
                                    this.emitting = false;
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                    }
                } while (!this.child.isUnsubscribed());
                synchronized (this.guard) {
                    this.emitting = false;
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: rx.internal.operators.ci$b<T, U> */
        /* JADX WARN: Multi-variable type inference failed */
        void eA(List<Object> list) {
            if (list != null) {
                for (Object obj : list) {
                    if (obj == ci.iAz) {
                        ccv();
                    } else if (NotificationLite.ba(obj)) {
                        error(NotificationLite.bc(obj));
                        return;
                    } else if (NotificationLite.aZ(obj)) {
                        complete();
                        return;
                    } else {
                        bl(obj);
                    }
                }
            }
        }

        void ccv() {
            rx.e<T> eVar = this.iAB;
            if (eVar != null) {
                eVar.onCompleted();
            }
            ccw();
            this.child.onNext(this.iAC);
        }

        void ccw() {
            UnicastSubject cdM = UnicastSubject.cdM();
            this.iAB = cdM;
            this.iAC = cdM;
            try {
                rx.d<? extends U> call = this.iAE.call();
                a aVar = new a(this);
                this.serial.g(aVar);
                call.unsafeSubscribe(aVar);
            } catch (Throwable th) {
                this.child.onError(th);
                unsubscribe();
            }
        }

        void bl(T t) {
            rx.e<T> eVar = this.iAB;
            if (eVar != null) {
                eVar.onNext(t);
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            synchronized (this.guard) {
                if (this.emitting) {
                    this.iAD = Collections.singletonList(NotificationLite.M(th));
                    return;
                }
                this.iAD = null;
                this.emitting = true;
                error(th);
            }
        }

        @Override // rx.e
        public void onCompleted() {
            synchronized (this.guard) {
                if (this.emitting) {
                    if (this.iAD == null) {
                        this.iAD = new ArrayList();
                    }
                    this.iAD.add(NotificationLite.cbH());
                    return;
                }
                List<Object> list = this.iAD;
                this.iAD = null;
                this.emitting = true;
                try {
                    eA(list);
                    complete();
                } catch (Throwable th) {
                    error(th);
                }
            }
        }

        void ccx() {
            boolean z = true;
            boolean z2 = false;
            synchronized (this.guard) {
                if (this.emitting) {
                    if (this.iAD == null) {
                        this.iAD = new ArrayList();
                    }
                    this.iAD.add(ci.iAz);
                    return;
                }
                List<Object> list = this.iAD;
                this.iAD = null;
                this.emitting = true;
                List<Object> list2 = list;
                boolean z3 = true;
                do {
                    try {
                        eA(list2);
                        if (z3) {
                            ccv();
                            z3 = false;
                        }
                        try {
                            synchronized (this.guard) {
                                try {
                                    list2 = this.iAD;
                                    this.iAD = null;
                                    if (list2 == null) {
                                        this.emitting = false;
                                        return;
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    z = false;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                        try {
                            throw th;
                        } catch (Throwable th3) {
                            th = th3;
                            z2 = z;
                            if (!z2) {
                                synchronized (this.guard) {
                                    this.emitting = false;
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                    }
                } while (!this.child.isUnsubscribed());
                synchronized (this.guard) {
                    this.emitting = false;
                }
            }
        }

        void complete() {
            rx.e<T> eVar = this.iAB;
            this.iAB = null;
            this.iAC = null;
            if (eVar != null) {
                eVar.onCompleted();
            }
            this.child.onCompleted();
            unsubscribe();
        }

        void error(Throwable th) {
            rx.e<T> eVar = this.iAB;
            this.iAB = null;
            this.iAC = null;
            if (eVar != null) {
                eVar.onError(th);
            }
            this.child.onError(th);
            unsubscribe();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a<T, U> extends rx.j<U> {
        boolean done;
        final b<T, U> iAF;

        public a(b<T, U> bVar) {
            this.iAF = bVar;
        }

        @Override // rx.j
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        @Override // rx.e
        public void onNext(U u) {
            if (!this.done) {
                this.done = true;
                this.iAF.ccx();
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            this.iAF.onError(th);
        }

        @Override // rx.e
        public void onCompleted() {
            if (!this.done) {
                this.done = true;
                this.iAF.onCompleted();
            }
        }
    }
}
