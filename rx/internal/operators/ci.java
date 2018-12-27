package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import rx.d;
import rx.subjects.UnicastSubject;
/* loaded from: classes2.dex */
public final class ci<T, U> implements d.b<rx.d<T>, T> {
    static final Object iMB = new Object();
    final rx.functions.e<? extends rx.d<? extends U>> iMG;

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public ci(rx.functions.e<? extends rx.d<? extends U>> eVar) {
        this.iMG = eVar;
    }

    public rx.j<? super T> call(rx.j<? super rx.d<T>> jVar) {
        b bVar = new b(jVar, this.iMG);
        jVar.add(bVar);
        bVar.ceN();
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class b<T, U> extends rx.j<T> {
        final rx.j<? super rx.d<T>> child;
        boolean emitting;
        rx.e<T> iMD;
        rx.d<T> iME;
        List<Object> iMF;
        final rx.functions.e<? extends rx.d<? extends U>> iMG;
        final Object guard = new Object();
        final rx.subscriptions.d serial = new rx.subscriptions.d();

        public b(rx.j<? super rx.d<T>> jVar, rx.functions.e<? extends rx.d<? extends U>> eVar) {
            this.child = new rx.b.f(jVar);
            this.iMG = eVar;
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
                    if (this.iMF == null) {
                        this.iMF = new ArrayList();
                    }
                    this.iMF.add(t);
                    return;
                }
                List<Object> list = this.iMF;
                this.iMF = null;
                this.emitting = true;
                List<Object> list2 = list;
                boolean z3 = true;
                do {
                    try {
                        eD(list2);
                        if (z3) {
                            bl(t);
                            z3 = false;
                        }
                        try {
                            synchronized (this.guard) {
                                try {
                                    list2 = this.iMF;
                                    this.iMF = null;
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
        void eD(List<Object> list) {
            if (list != null) {
                for (Object obj : list) {
                    if (obj == ci.iMB) {
                        ceL();
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

        void ceL() {
            rx.e<T> eVar = this.iMD;
            if (eVar != null) {
                eVar.onCompleted();
            }
            ceM();
            this.child.onNext(this.iME);
        }

        void ceM() {
            UnicastSubject cgc = UnicastSubject.cgc();
            this.iMD = cgc;
            this.iME = cgc;
            try {
                rx.d<? extends U> call = this.iMG.call();
                a aVar = new a(this);
                this.serial.g(aVar);
                call.unsafeSubscribe(aVar);
            } catch (Throwable th) {
                this.child.onError(th);
                unsubscribe();
            }
        }

        void bl(T t) {
            rx.e<T> eVar = this.iMD;
            if (eVar != null) {
                eVar.onNext(t);
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            synchronized (this.guard) {
                if (this.emitting) {
                    this.iMF = Collections.singletonList(NotificationLite.M(th));
                    return;
                }
                this.iMF = null;
                this.emitting = true;
                error(th);
            }
        }

        @Override // rx.e
        public void onCompleted() {
            synchronized (this.guard) {
                if (this.emitting) {
                    if (this.iMF == null) {
                        this.iMF = new ArrayList();
                    }
                    this.iMF.add(NotificationLite.cdX());
                    return;
                }
                List<Object> list = this.iMF;
                this.iMF = null;
                this.emitting = true;
                try {
                    eD(list);
                    complete();
                } catch (Throwable th) {
                    error(th);
                }
            }
        }

        void ceN() {
            boolean z = true;
            boolean z2 = false;
            synchronized (this.guard) {
                if (this.emitting) {
                    if (this.iMF == null) {
                        this.iMF = new ArrayList();
                    }
                    this.iMF.add(ci.iMB);
                    return;
                }
                List<Object> list = this.iMF;
                this.iMF = null;
                this.emitting = true;
                List<Object> list2 = list;
                boolean z3 = true;
                do {
                    try {
                        eD(list2);
                        if (z3) {
                            ceL();
                            z3 = false;
                        }
                        try {
                            synchronized (this.guard) {
                                try {
                                    list2 = this.iMF;
                                    this.iMF = null;
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
            rx.e<T> eVar = this.iMD;
            this.iMD = null;
            this.iME = null;
            if (eVar != null) {
                eVar.onCompleted();
            }
            this.child.onCompleted();
            unsubscribe();
        }

        void error(Throwable th) {
            rx.e<T> eVar = this.iMD;
            this.iMD = null;
            this.iME = null;
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
        final b<T, U> iMH;

        public a(b<T, U> bVar) {
            this.iMH = bVar;
        }

        @Override // rx.j
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        @Override // rx.e
        public void onNext(U u) {
            if (!this.done) {
                this.done = true;
                this.iMH.ceN();
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            this.iMH.onError(th);
        }

        @Override // rx.e
        public void onCompleted() {
            if (!this.done) {
                this.done = true;
                this.iMH.onCompleted();
            }
        }
    }
}
