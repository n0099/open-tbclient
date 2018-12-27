package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.d;
import rx.g;
import rx.subjects.UnicastSubject;
/* loaded from: classes2.dex */
public final class ck<T> implements d.b<rx.d<T>, T> {
    static final Object iMB = new Object();
    final long iHG;
    final long iHH;
    final rx.g scheduler;
    final int size;
    final TimeUnit unit;

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public ck(long j, long j2, TimeUnit timeUnit, int i, rx.g gVar) {
        this.iHG = j;
        this.iHH = j2;
        this.unit = timeUnit;
        this.size = i;
        this.scheduler = gVar;
    }

    public rx.j<? super T> call(rx.j<? super rx.d<T>> jVar) {
        g.a createWorker = this.scheduler.createWorker();
        if (this.iHG == this.iHH) {
            b bVar = new b(jVar, createWorker);
            bVar.add(createWorker);
            bVar.cef();
            return bVar;
        }
        c cVar = new c(jVar, createWorker);
        cVar.add(createWorker);
        cVar.ceh();
        cVar.ceg();
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class d<T> {
        static final d<Object> iNc = new d<>(null, null, 0);
        final int count;
        final rx.e<T> iMD;
        final rx.d<T> iME;

        public d(rx.e<T> eVar, rx.d<T> dVar, int i) {
            this.iMD = eVar;
            this.iME = dVar;
            this.count = i;
        }

        public d<T> ceS() {
            return new d<>(this.iMD, this.iME, this.count + 1);
        }

        public d<T> a(rx.e<T> eVar, rx.d<T> dVar) {
            return new d<>(eVar, dVar, 0);
        }

        public d<T> ceT() {
            return ceU();
        }

        public static <T> d<T> ceU() {
            return (d<T>) iNc;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class b extends rx.j<T> {
        final rx.j<? super rx.d<T>> child;
        boolean emitting;
        List<Object> iMF;
        final g.a iMV;
        final Object guard = new Object();
        volatile d<T> iMW = d.ceU();

        public b(rx.j<? super rx.d<T>> jVar, g.a aVar) {
            this.child = new rx.b.f(jVar);
            this.iMV = aVar;
            jVar.add(rx.subscriptions.e.j(new rx.functions.a() { // from class: rx.internal.operators.ck.b.1
                @Override // rx.functions.a
                public void call() {
                    if (b.this.iMW.iMD == null) {
                        b.this.unsubscribe();
                    }
                }
            }));
        }

        @Override // rx.j
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [174=4] */
        @Override // rx.e
        public void onNext(T t) {
            List<Object> list;
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
                this.emitting = true;
                try {
                    if (!bn(t)) {
                        synchronized (this.guard) {
                            this.emitting = false;
                        }
                        return;
                    }
                    do {
                        try {
                            synchronized (this.guard) {
                                try {
                                    list = this.iMF;
                                    if (list == null) {
                                        this.emitting = false;
                                        return;
                                    }
                                    this.iMF = null;
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
                    } while (eE(list));
                    synchronized (this.guard) {
                        this.emitting = false;
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: rx.internal.operators.ck$b */
        /* JADX WARN: Multi-variable type inference failed */
        boolean eE(List<Object> list) {
            if (list == null) {
                return true;
            }
            for (Object obj : list) {
                if (obj == ck.iMB) {
                    if (!ceP()) {
                        return false;
                    }
                } else if (NotificationLite.ba(obj)) {
                    error(NotificationLite.bc(obj));
                    return true;
                } else if (NotificationLite.aZ(obj)) {
                    complete();
                    return true;
                } else if (!bn(obj)) {
                    return false;
                }
            }
            return true;
        }

        boolean ceP() {
            rx.e<T> eVar = this.iMW.iMD;
            if (eVar != null) {
                eVar.onCompleted();
            }
            if (this.child.isUnsubscribed()) {
                this.iMW = this.iMW.ceT();
                unsubscribe();
                return false;
            }
            UnicastSubject cgc = UnicastSubject.cgc();
            this.iMW = this.iMW.a(cgc, cgc);
            this.child.onNext(cgc);
            return true;
        }

        boolean bn(T t) {
            d<T> ceS;
            d<T> dVar = this.iMW;
            if (dVar.iMD == null) {
                if (!ceP()) {
                    return false;
                }
                dVar = this.iMW;
            }
            dVar.iMD.onNext(t);
            if (dVar.count == ck.this.size - 1) {
                dVar.iMD.onCompleted();
                ceS = dVar.ceT();
            } else {
                ceS = dVar.ceS();
            }
            this.iMW = ceS;
            return true;
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

        void error(Throwable th) {
            rx.e<T> eVar = this.iMW.iMD;
            this.iMW = this.iMW.ceT();
            if (eVar != null) {
                eVar.onError(th);
            }
            this.child.onError(th);
            unsubscribe();
        }

        void complete() {
            rx.e<T> eVar = this.iMW.iMD;
            this.iMW = this.iMW.ceT();
            if (eVar != null) {
                eVar.onCompleted();
            }
            this.child.onCompleted();
            unsubscribe();
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
                    eE(list);
                    complete();
                } catch (Throwable th) {
                    error(th);
                }
            }
        }

        void cef() {
            this.iMV.a(new rx.functions.a() { // from class: rx.internal.operators.ck.b.2
                @Override // rx.functions.a
                public void call() {
                    b.this.ceQ();
                }
            }, 0L, ck.this.iHG, ck.this.unit);
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [341=4] */
        void ceQ() {
            List<Object> list;
            boolean z = true;
            boolean z2 = false;
            synchronized (this.guard) {
                if (this.emitting) {
                    if (this.iMF == null) {
                        this.iMF = new ArrayList();
                    }
                    this.iMF.add(ck.iMB);
                    return;
                }
                this.emitting = true;
                try {
                    if (!ceP()) {
                        synchronized (this.guard) {
                            this.emitting = false;
                        }
                        return;
                    }
                    do {
                        try {
                            synchronized (this.guard) {
                                try {
                                    list = this.iMF;
                                    if (list == null) {
                                        this.emitting = false;
                                        return;
                                    }
                                    this.iMF = null;
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
                    } while (eE(list));
                    synchronized (this.guard) {
                        this.emitting = false;
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a<T> {
        int count;
        final rx.e<T> iMD;
        final rx.d<T> iME;

        public a(rx.e<T> eVar, rx.d<T> dVar) {
            this.iMD = new rx.b.e(eVar);
            this.iME = dVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class c extends rx.j<T> {
        final rx.j<? super rx.d<T>> child;
        boolean done;
        final Object guard;
        final List<a<T>> iHC;
        final g.a iMV;

        public c(rx.j<? super rx.d<T>> jVar, g.a aVar) {
            super(jVar);
            this.child = jVar;
            this.iMV = aVar;
            this.guard = new Object();
            this.iHC = new LinkedList();
        }

        @Override // rx.j
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        @Override // rx.e
        public void onNext(T t) {
            synchronized (this.guard) {
                if (!this.done) {
                    ArrayList<a> arrayList = new ArrayList(this.iHC);
                    Iterator<a<T>> it = this.iHC.iterator();
                    while (it.hasNext()) {
                        a<T> next = it.next();
                        int i = next.count + 1;
                        next.count = i;
                        if (i == ck.this.size) {
                            it.remove();
                        }
                    }
                    for (a aVar : arrayList) {
                        aVar.iMD.onNext(t);
                        if (aVar.count == ck.this.size) {
                            aVar.iMD.onCompleted();
                        }
                    }
                }
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            synchronized (this.guard) {
                if (!this.done) {
                    this.done = true;
                    ArrayList<a> arrayList = new ArrayList(this.iHC);
                    this.iHC.clear();
                    for (a aVar : arrayList) {
                        aVar.iMD.onError(th);
                    }
                    this.child.onError(th);
                }
            }
        }

        @Override // rx.e
        public void onCompleted() {
            synchronized (this.guard) {
                if (!this.done) {
                    this.done = true;
                    ArrayList<a> arrayList = new ArrayList(this.iHC);
                    this.iHC.clear();
                    for (a aVar : arrayList) {
                        aVar.iMD.onCompleted();
                    }
                    this.child.onCompleted();
                }
            }
        }

        void ceg() {
            this.iMV.a(new rx.functions.a() { // from class: rx.internal.operators.ck.c.1
                @Override // rx.functions.a
                public void call() {
                    c.this.ceh();
                }
            }, ck.this.iHH, ck.this.iHH, ck.this.unit);
        }

        void ceh() {
            final a<T> ceR = ceR();
            synchronized (this.guard) {
                if (!this.done) {
                    this.iHC.add(ceR);
                    try {
                        this.child.onNext(ceR.iME);
                        this.iMV.a(new rx.functions.a() { // from class: rx.internal.operators.ck.c.2
                            @Override // rx.functions.a
                            public void call() {
                                c.this.a(ceR);
                            }
                        }, ck.this.iHG, ck.this.unit);
                    } catch (Throwable th) {
                        onError(th);
                    }
                }
            }
        }

        void a(a<T> aVar) {
            boolean z;
            synchronized (this.guard) {
                if (!this.done) {
                    Iterator<a<T>> it = this.iHC.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = false;
                            break;
                        } else if (it.next() == aVar) {
                            z = true;
                            it.remove();
                            break;
                        }
                    }
                    if (z) {
                        aVar.iMD.onCompleted();
                    }
                }
            }
        }

        a<T> ceR() {
            UnicastSubject cgc = UnicastSubject.cgc();
            return new a<>(cgc, cgc);
        }
    }
}
