package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import rx.d;
import rx.subjects.UnicastSubject;
/* loaded from: classes2.dex */
public final class ch<T, U> implements d.b<rx.d<T>, T> {
    static final Object iCj = new Object();
    final rx.d<U> ivi;

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public ch(rx.d<U> dVar) {
        this.ivi = dVar;
    }

    public rx.j<? super T> call(rx.j<? super rx.d<T>> jVar) {
        b bVar = new b(jVar);
        a aVar = new a(bVar);
        jVar.add(bVar);
        jVar.add(aVar);
        bVar.cbU();
        this.ivi.unsafeSubscribe(aVar);
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class b<T> extends rx.j<T> {
        final rx.j<? super rx.d<T>> child;
        boolean emitting;
        final Object guard = new Object();
        rx.e<T> iCl;
        rx.d<T> iCm;
        List<Object> iCn;

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
                    if (this.iCn == null) {
                        this.iCn = new ArrayList();
                    }
                    this.iCn.add(t);
                    return;
                }
                List<Object> list = this.iCn;
                this.iCn = null;
                this.emitting = true;
                List<Object> list2 = list;
                boolean z3 = true;
                do {
                    try {
                        ey(list2);
                        if (z3) {
                            bk(t);
                            z3 = false;
                        }
                        try {
                            synchronized (this.guard) {
                                try {
                                    list2 = this.iCn;
                                    this.iCn = null;
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
        void ey(List<Object> list) {
            if (list != null) {
                for (Object obj : list) {
                    if (obj == ch.iCj) {
                        cbS();
                    } else if (NotificationLite.aZ(obj)) {
                        error(NotificationLite.bb(obj));
                        return;
                    } else if (NotificationLite.aY(obj)) {
                        complete();
                        return;
                    } else {
                        bk(obj);
                    }
                }
            }
        }

        void cbS() {
            rx.e<T> eVar = this.iCl;
            if (eVar != null) {
                eVar.onCompleted();
            }
            cbT();
            this.child.onNext(this.iCm);
        }

        void cbT() {
            UnicastSubject cdj = UnicastSubject.cdj();
            this.iCl = cdj;
            this.iCm = cdj;
        }

        void bk(T t) {
            rx.e<T> eVar = this.iCl;
            if (eVar != null) {
                eVar.onNext(t);
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            synchronized (this.guard) {
                if (this.emitting) {
                    this.iCn = Collections.singletonList(NotificationLite.M(th));
                    return;
                }
                this.iCn = null;
                this.emitting = true;
                error(th);
            }
        }

        @Override // rx.e
        public void onCompleted() {
            synchronized (this.guard) {
                if (this.emitting) {
                    if (this.iCn == null) {
                        this.iCn = new ArrayList();
                    }
                    this.iCn.add(NotificationLite.cbe());
                    return;
                }
                List<Object> list = this.iCn;
                this.iCn = null;
                this.emitting = true;
                try {
                    ey(list);
                    complete();
                } catch (Throwable th) {
                    error(th);
                }
            }
        }

        void cbU() {
            boolean z = true;
            boolean z2 = false;
            synchronized (this.guard) {
                if (this.emitting) {
                    if (this.iCn == null) {
                        this.iCn = new ArrayList();
                    }
                    this.iCn.add(ch.iCj);
                    return;
                }
                List<Object> list = this.iCn;
                this.iCn = null;
                this.emitting = true;
                List<Object> list2 = list;
                boolean z3 = true;
                do {
                    try {
                        ey(list2);
                        if (z3) {
                            cbS();
                            z3 = false;
                        }
                        try {
                            synchronized (this.guard) {
                                try {
                                    list2 = this.iCn;
                                    this.iCn = null;
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
            rx.e<T> eVar = this.iCl;
            this.iCl = null;
            this.iCm = null;
            if (eVar != null) {
                eVar.onCompleted();
            }
            this.child.onCompleted();
            unsubscribe();
        }

        void error(Throwable th) {
            rx.e<T> eVar = this.iCl;
            this.iCl = null;
            this.iCm = null;
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
        final b<T> iCk;

        public a(b<T> bVar) {
            this.iCk = bVar;
        }

        @Override // rx.j
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        @Override // rx.e
        public void onNext(U u) {
            this.iCk.cbU();
        }

        @Override // rx.e
        public void onError(Throwable th) {
            this.iCk.onError(th);
        }

        @Override // rx.e
        public void onCompleted() {
            this.iCk.onCompleted();
        }
    }
}
