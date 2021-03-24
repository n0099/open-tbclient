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
    public int f67097b = 0;

    /* renamed from: a  reason: collision with root package name */
    public volatile SparseArray<c> f67096a = new SparseArray<>();

    public List<Integer> a() {
        ArrayList arrayList;
        synchronized (d.class) {
            f();
            arrayList = new ArrayList();
            for (int i = 0; i < this.f67096a.size(); i++) {
                c cVar = this.f67096a.get(this.f67096a.keyAt(i));
                if (cVar != null) {
                    arrayList.add(Integer.valueOf(cVar.S()));
                }
            }
        }
        return arrayList;
    }

    public void b(int i, long j) {
        c cVar = this.f67096a.get(i);
        if (cVar != null) {
            cVar.P(j);
        }
    }

    public void c(c cVar) {
        cVar.T();
        synchronized (d.class) {
            if (this.f67097b >= 500) {
                f();
                this.f67097b = 0;
            } else {
                this.f67097b++;
            }
            this.f67096a.put(cVar.S(), cVar);
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

    public boolean d(int i) {
        synchronized (d.class) {
            boolean z = false;
            if (this.f67096a != null && this.f67096a.size() > 0) {
                c cVar = this.f67096a.get(i);
                if (cVar != null && cVar.Q()) {
                    z = true;
                }
                return z;
            }
            return false;
        }
    }

    public c e(int i) {
        synchronized (d.class) {
            f();
            c cVar = this.f67096a.get(i);
            if (cVar != null) {
                cVar.M();
                i(cVar);
                this.f67096a.remove(i);
                return cVar;
            }
            return null;
        }
    }

    public final void f() {
        try {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.f67096a.size(); i++) {
                int keyAt = this.f67096a.keyAt(i);
                if (!this.f67096a.get(keyAt).Q()) {
                    arrayList.add(Integer.valueOf(keyAt));
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                Integer num = (Integer) arrayList.get(i2);
                if (num != null) {
                    this.f67096a.remove(num.intValue());
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
                    int indexOfValue = this.f67096a.indexOfValue(cVar);
                    if (indexOfValue >= 0) {
                        this.f67096a.removeAt(indexOfValue);
                    }
                } else {
                    this.f67096a.remove(cVar.S());
                }
            }
        }
    }

    public void h(int i) {
        synchronized (d.class) {
            f();
            c cVar = this.f67096a.get(i);
            if (cVar != null) {
                cVar.z();
                i(cVar);
                this.f67096a.remove(i);
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
