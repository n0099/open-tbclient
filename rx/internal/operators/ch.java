package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import rx.d;
import rx.subjects.UnicastSubject;
/* loaded from: classes2.dex */
public final class ch<T, U> implements d.b<rx.d<T>, T> {
    static final Object iJr = new Object();
    final rx.d<U> iCr;

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public ch(rx.d<U> dVar) {
        this.iCr = dVar;
    }

    public rx.j<? super T> call(rx.j<? super rx.d<T>> jVar) {
        b bVar = new b(jVar);
        a aVar = new a(bVar);
        jVar.add(bVar);
        jVar.add(aVar);
        bVar.cdX();
        this.iCr.unsafeSubscribe(aVar);
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class b<T> extends rx.j<T> {
        final rx.j<? super rx.d<T>> child;
        boolean emitting;
        final Object guard = new Object();
        rx.e<T> iJt;
        rx.d<T> iJu;
        List<Object> iJv;

        public b(rx.j<? super rx.d<T>> jVar) {
            this.child = new rx.b.f(jVar);
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

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: rx.internal.operators.ch$b<T> */
        /* JADX WARN: Multi-variable type inference failed */
        void eC(List<Object> list) {
            if (list != null) {
                for (Object obj : list) {
                    if (obj == ch.iJr) {
                        cdV();
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

        void cdV() {
            rx.e<T> eVar = this.iJt;
            if (eVar != null) {
                eVar.onCompleted();
            }
            cdW();
            this.child.onNext(this.iJu);
        }

        void cdW() {
            UnicastSubject cfm = UnicastSubject.cfm();
            this.iJt = cfm;
            this.iJu = cfm;
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
                    this.iJv.add(NotificationLite.cdh());
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

        void cdX() {
            boolean z = true;
            boolean z2 = false;
            synchronized (this.guard) {
                if (this.emitting) {
                    if (this.iJv == null) {
                        this.iJv = new ArrayList();
                    }
                    this.iJv.add(ch.iJr);
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
                            cdV();
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
        final b<T> iJs;

        public a(b<T> bVar) {
            this.iJs = bVar;
        }

        @Override // rx.j
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        @Override // rx.e
        public void onNext(U u) {
            this.iJs.cdX();
        }

        @Override // rx.e
        public void onError(Throwable th) {
            this.iJs.onError(th);
        }

        @Override // rx.e
        public void onCompleted() {
            this.iJs.onCompleted();
        }
    }
}
