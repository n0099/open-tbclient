package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import rx.d;
import rx.subjects.UnicastSubject;
/* loaded from: classes2.dex */
public final class ci<T, U> implements d.b<rx.d<T>, T> {
    static final Object iJr = new Object();
    final rx.functions.e<? extends rx.d<? extends U>> iJw;

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public ci(rx.functions.e<? extends rx.d<? extends U>> eVar) {
        this.iJw = eVar;
    }

    public rx.j<? super T> call(rx.j<? super rx.d<T>> jVar) {
        b bVar = new b(jVar, this.iJw);
        jVar.add(bVar);
        bVar.cdW();
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class b<T, U> extends rx.j<T> {
        final rx.j<? super rx.d<T>> child;
        boolean emitting;
        rx.e<T> iJt;
        rx.d<T> iJu;
        List<Object> iJv;
        final rx.functions.e<? extends rx.d<? extends U>> iJw;
        final Object guard = new Object();
        final rx.subscriptions.d serial = new rx.subscriptions.d();

        public b(rx.j<? super rx.d<T>> jVar, rx.functions.e<? extends rx.d<? extends U>> eVar) {
            this.child = new rx.b.f(jVar);
            this.iJw = eVar;
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
                    if (this.iJv == null) {
                        this.iJv = new ArrayList();
                    }
                    this.iJv.add(t);
                    return;
                }
                List<Object> list = this.iJv;
                this.iJv = null;
                this.emitting = true;
                List<Object> list2 = list;
                boolean z3 = true;
                do {
                    try {
                        eC(list2);
                        if (z3) {
                            bl(t);
                            z3 = false;
                        }
                        try {
                            synchronized (this.guard) {
                                try {
                                    list2 = this.iJv;
                                    this.iJv = null;
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
        void eC(List<Object> list) {
            if (list != null) {
                for (Object obj : list) {
                    if (obj == ci.iJr) {
                        cdU();
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

        void cdU() {
            rx.e<T> eVar = this.iJt;
            if (eVar != null) {
                eVar.onCompleted();
            }
            cdV();
            this.child.onNext(this.iJu);
        }

        void cdV() {
            UnicastSubject cfl = UnicastSubject.cfl();
            this.iJt = cfl;
            this.iJu = cfl;
            try {
                rx.d<? extends U> call = this.iJw.call();
                a aVar = new a(this);
                this.serial.g(aVar);
                call.unsafeSubscribe(aVar);
            } catch (Throwable th) {
                this.child.onError(th);
                unsubscribe();
            }
        }

        void bl(T t) {
            rx.e<T> eVar = this.iJt;
            if (eVar != null) {
                eVar.onNext(t);
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            synchronized (this.guard) {
                if (this.emitting) {
                    this.iJv = Collections.singletonList(NotificationLite.M(th));
                    return;
                }
                this.iJv = null;
                this.emitting = true;
                error(th);
            }
        }

        @Override // rx.e
        public void onCompleted() {
            synchronized (this.guard) {
                if (this.emitting) {
                    if (this.iJv == null) {
                        this.iJv = new ArrayList();
                    }
                    this.iJv.add(NotificationLite.cdg());
                    return;
                }
                List<Object> list = this.iJv;
                this.iJv = null;
                this.emitting = true;
                try {
                    eC(list);
                    complete();
                } catch (Throwable th) {
                    error(th);
                }
            }
        }

        void cdW() {
            boolean z = true;
            boolean z2 = false;
            synchronized (this.guard) {
                if (this.emitting) {
                    if (this.iJv == null) {
                        this.iJv = new ArrayList();
                    }
                    this.iJv.add(ci.iJr);
                    return;
                }
                List<Object> list = this.iJv;
                this.iJv = null;
                this.emitting = true;
                List<Object> list2 = list;
                boolean z3 = true;
                do {
                    try {
                        eC(list2);
                        if (z3) {
                            cdU();
                            z3 = false;
                        }
                        try {
                            synchronized (this.guard) {
                                try {
                                    list2 = this.iJv;
                                    this.iJv = null;
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
            rx.e<T> eVar = this.iJt;
            this.iJt = null;
            this.iJu = null;
            if (eVar != null) {
                eVar.onCompleted();
            }
            this.child.onCompleted();
            unsubscribe();
        }

        void error(Throwable th) {
            rx.e<T> eVar = this.iJt;
            this.iJt = null;
            this.iJu = null;
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
        final b<T, U> iJx;

        public a(b<T, U> bVar) {
            this.iJx = bVar;
        }

        @Override // rx.j
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        @Override // rx.e
        public void onNext(U u) {
            if (!this.done) {
                this.done = true;
                this.iJx.cdW();
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            this.iJx.onError(th);
        }

        @Override // rx.e
        public void onCompleted() {
            if (!this.done) {
                this.done = true;
                this.iJx.onCompleted();
            }
        }
    }
}
