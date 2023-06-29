package rx.subjects;

import com.baidu.tieba.ayb;
import com.baidu.tieba.dtb;
import com.baidu.tieba.ktb;
import com.baidu.tieba.ltb;
import com.baidu.tieba.xsb;
import com.baidu.tieba.ysb;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import rx.functions.Actions;
import rx.internal.operators.NotificationLite;
/* loaded from: classes2.dex */
public final class SubjectSubscriptionManager<T> extends AtomicReference<b<T>> implements xsb.a<T> {
    public static final long serialVersionUID = 6035251036011671568L;
    public boolean active;
    public volatile Object latest;
    public ltb<c<T>> onAdded;
    public ltb<c<T>> onStart;
    public ltb<c<T>> onTerminated;

    /* loaded from: classes2.dex */
    public class a implements ktb {
        public final /* synthetic */ c a;

        public a(c cVar) {
            this.a = cVar;
        }

        @Override // com.baidu.tieba.ktb
        public void call() {
            SubjectSubscriptionManager.this.remove(this.a);
        }
    }

    /* loaded from: classes2.dex */
    public static final class b<T> {
        public static final c[] c;
        public static final b d;
        public static final b e;
        public final boolean a;
        public final c[] b;

        static {
            c[] cVarArr = new c[0];
            c = cVarArr;
            d = new b(true, cVarArr);
            e = new b(false, c);
        }

        public b(boolean z, c[] cVarArr) {
            this.a = z;
            this.b = cVarArr;
        }

        public b a(c cVar) {
            c[] cVarArr = this.b;
            int length = cVarArr.length;
            c[] cVarArr2 = new c[length + 1];
            System.arraycopy(cVarArr, 0, cVarArr2, 0, length);
            cVarArr2[length] = cVar;
            return new b(this.a, cVarArr2);
        }

        public b b(c cVar) {
            c[] cVarArr = this.b;
            int length = cVarArr.length;
            if (length == 1 && cVarArr[0] == cVar) {
                return e;
            }
            if (length == 0) {
                return this;
            }
            int i = length - 1;
            c[] cVarArr2 = new c[i];
            int i2 = 0;
            for (c cVar2 : cVarArr) {
                if (cVar2 != cVar) {
                    if (i2 == i) {
                        return this;
                    }
                    cVarArr2[i2] = cVar2;
                    i2++;
                }
            }
            if (i2 == 0) {
                return e;
            }
            if (i2 < i) {
                c[] cVarArr3 = new c[i2];
                System.arraycopy(cVarArr2, 0, cVarArr3, 0, i2);
                cVarArr2 = cVarArr3;
            }
            return new b(this.a, cVarArr2);
        }
    }

    /* loaded from: classes2.dex */
    public static final class c<T> implements ysb<T> {
        public final dtb<? super T> a;
        public boolean b = true;
        public boolean c;
        public List<Object> d;
        public boolean e;

        public c(dtb<? super T> dtbVar) {
            this.a = dtbVar;
        }

        public void a(Object obj) {
            if (obj != null) {
                NotificationLite.a(this.a, obj);
            }
        }

        public void b(Object obj) {
            synchronized (this) {
                if (this.b && !this.c) {
                    boolean z = false;
                    this.b = false;
                    if (obj != null) {
                        z = true;
                    }
                    this.c = z;
                    if (obj != null) {
                        c(null, obj);
                    }
                }
            }
        }

        public void d(Object obj) {
            if (!this.e) {
                synchronized (this) {
                    this.b = false;
                    if (this.c) {
                        if (this.d == null) {
                            this.d = new ArrayList();
                        }
                        this.d.add(obj);
                        return;
                    }
                    this.e = true;
                }
            }
            NotificationLite.a(this.a, obj);
        }

        @Override // com.baidu.tieba.ysb
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // com.baidu.tieba.ysb
        public void onNext(T t) {
            this.a.onNext(t);
        }

        /* JADX WARN: Removed duplicated region for block: B:30:0x0038  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void c(List<Object> list, Object obj) {
            boolean z = true;
            boolean z2 = true;
            while (true) {
                if (list != null) {
                    try {
                        for (Object obj2 : list) {
                            a(obj2);
                        }
                    } catch (Throwable th) {
                        th = th;
                        z = false;
                        if (!z) {
                        }
                        throw th;
                    }
                }
                if (z2) {
                    a(obj);
                    z2 = false;
                }
                try {
                    synchronized (this) {
                        try {
                            list = this.d;
                            this.d = null;
                            if (list == null) {
                                this.c = false;
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
                    if (!z) {
                        synchronized (this) {
                            this.c = false;
                        }
                    }
                    throw th;
                }
            }
        }

        @Override // com.baidu.tieba.ysb
        public void onCompleted() {
            this.a.onCompleted();
        }
    }

    public SubjectSubscriptionManager() {
        super(b.e);
        this.active = true;
        this.onStart = Actions.a();
        this.onAdded = Actions.a();
        this.onTerminated = Actions.a();
    }

    public Object getLatest() {
        return this.latest;
    }

    public c<T>[] observers() {
        return get().b;
    }

    public boolean add(c<T> cVar) {
        b<T> bVar;
        do {
            bVar = get();
            if (bVar.a) {
                this.onTerminated.call(cVar);
                return false;
            }
        } while (!compareAndSet(bVar, bVar.a(cVar)));
        this.onAdded.call(cVar);
        return true;
    }

    public void call(dtb<? super T> dtbVar) {
        c<T> cVar = new c<>(dtbVar);
        addUnsubscriber(dtbVar, cVar);
        this.onStart.call(cVar);
        if (!dtbVar.isUnsubscribed() && add(cVar) && dtbVar.isUnsubscribed()) {
            remove(cVar);
        }
    }

    public c<T>[] next(Object obj) {
        setLatest(obj);
        return get().b;
    }

    public void remove(c<T> cVar) {
        b<T> bVar;
        b<T> b2;
        do {
            bVar = get();
            if (bVar.a || (b2 = bVar.b(cVar)) == bVar) {
                return;
            }
        } while (!compareAndSet(bVar, b2));
    }

    public void setLatest(Object obj) {
        this.latest = obj;
    }

    public c<T>[] terminate(Object obj) {
        setLatest(obj);
        this.active = false;
        if (get().a) {
            return b.c;
        }
        return getAndSet(b.d).b;
    }

    public void addUnsubscriber(dtb<? super T> dtbVar, c<T> cVar) {
        dtbVar.b(ayb.a(new a(cVar)));
    }

    @Override // com.baidu.tieba.xsb.a, com.baidu.tieba.ltb
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((dtb) ((dtb) obj));
    }
}
