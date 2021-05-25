package d.o.a.e.b.k;

import android.util.SparseArray;
import com.ss.android.socialbase.downloader.exception.BaseException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes7.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public int f67341b = 0;

    /* renamed from: a  reason: collision with root package name */
    public volatile SparseArray<c> f67340a = new SparseArray<>();

    public List<Integer> a() {
        ArrayList arrayList;
        synchronized (d.class) {
            f();
            arrayList = new ArrayList();
            for (int i2 = 0; i2 < this.f67340a.size(); i2++) {
                c cVar = this.f67340a.get(this.f67340a.keyAt(i2));
                if (cVar != null) {
                    arrayList.add(Integer.valueOf(cVar.S()));
                }
            }
        }
        return arrayList;
    }

    public void b(int i2, long j) {
        c cVar = this.f67340a.get(i2);
        if (cVar != null) {
            cVar.P(j);
        }
    }

    public void c(c cVar) {
        cVar.T();
        synchronized (d.class) {
            if (this.f67341b >= 500) {
                f();
                this.f67341b = 0;
            } else {
                this.f67341b++;
            }
            this.f67340a.put(cVar.S(), cVar);
        }
        d.o.a.e.b.n.a O = cVar.O();
        try {
            ExecutorService A0 = d.o.a.e.b.g.d.A0();
            if (O != null && O.H() != null) {
                if ("mime_type_plg".equals(O.H().m0()) && d.o.a.e.b.j.a.r().b("divide_plugin", 1) == 1) {
                    O.H().c2("executor_group", 3);
                }
                int P = O.H().P();
                if (P == 3) {
                    A0 = d.o.a.e.b.g.d.y0();
                } else if (P == 4) {
                    A0 = d.o.a.e.b.g.d.z0();
                }
            }
            if (A0 != null) {
                if (d.o.a.e.b.j.a.d(cVar.S()).q("pause_with_interrupt", false)) {
                    cVar.K(A0.submit(cVar));
                    return;
                } else {
                    A0.execute(cVar);
                    return;
                }
            }
            d.o.a.e.b.e.a.e(O.O(), O.H(), new BaseException(1003, "execute failed cpu thread executor service is null"), O.H() != null ? O.H().H0() : 0);
        } catch (Exception e2) {
            if (O != null) {
                d.o.a.e.b.e.a.e(O.O(), O.H(), new BaseException(1003, d.o.a.e.b.l.e.Y(e2, "DownloadThreadPoolExecute")), O.H() != null ? O.H().H0() : 0);
            }
            e2.printStackTrace();
        } catch (OutOfMemoryError e3) {
            if (O != null) {
                d.o.a.e.b.e.a.e(O.O(), O.H(), new BaseException(1003, "execute OOM"), O.H() != null ? O.H().H0() : 0);
            }
            e3.printStackTrace();
        }
    }

    public boolean d(int i2) {
        synchronized (d.class) {
            boolean z = false;
            if (this.f67340a != null && this.f67340a.size() > 0) {
                c cVar = this.f67340a.get(i2);
                if (cVar != null && cVar.Q()) {
                    z = true;
                }
                return z;
            }
            return false;
        }
    }

    public c e(int i2) {
        synchronized (d.class) {
            f();
            c cVar = this.f67340a.get(i2);
            if (cVar != null) {
                cVar.M();
                i(cVar);
                this.f67340a.remove(i2);
                return cVar;
            }
            return null;
        }
    }

    public final void f() {
        try {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < this.f67340a.size(); i2++) {
                int keyAt = this.f67340a.keyAt(i2);
                if (!this.f67340a.get(keyAt).Q()) {
                    arrayList.add(Integer.valueOf(keyAt));
                }
            }
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                Integer num = (Integer) arrayList.get(i3);
                if (num != null) {
                    this.f67340a.remove(num.intValue());
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void g(c cVar) {
        if (cVar == null) {
            return;
        }
        synchronized (d.class) {
            try {
                if (d.o.a.e.b.l.a.a(524288)) {
                    int indexOfValue = this.f67340a.indexOfValue(cVar);
                    if (indexOfValue >= 0) {
                        this.f67340a.removeAt(indexOfValue);
                    }
                } else {
                    this.f67340a.remove(cVar.S());
                }
            }
        }
    }

    public void h(int i2) {
        synchronized (d.class) {
            f();
            c cVar = this.f67340a.get(i2);
            if (cVar != null) {
                cVar.z();
                i(cVar);
                this.f67340a.remove(i2);
            }
        }
    }

    public final void i(c cVar) {
        Future U;
        if (cVar == null) {
            return;
        }
        try {
            ExecutorService A0 = d.o.a.e.b.g.d.A0();
            d.o.a.e.b.n.a O = cVar.O();
            if (O != null && O.H() != null) {
                int P = O.H().P();
                if (P == 3) {
                    A0 = d.o.a.e.b.g.d.y0();
                } else if (P == 4) {
                    A0 = d.o.a.e.b.g.d.z0();
                }
            }
            if (A0 == null || !(A0 instanceof ThreadPoolExecutor)) {
                return;
            }
            ((ThreadPoolExecutor) A0).remove(cVar);
            if (!d.o.a.e.b.j.a.d(cVar.S()).q("pause_with_interrupt", false) || (U = cVar.U()) == null) {
                return;
            }
            U.cancel(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
