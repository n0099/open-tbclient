package d.a.u.b;

import android.graphics.SurfaceTexture;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import d.a.u.b.g.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static final String f64663d = "a";

    /* renamed from: a  reason: collision with root package name */
    public d.a.u.b.c.a f64664a;

    /* renamed from: b  reason: collision with root package name */
    public List<b> f64665b;

    /* renamed from: c  reason: collision with root package name */
    public int f64666c = 0;

    public a(Object obj, List<c> list) {
        b(obj, list);
    }

    public void a(long j) {
        List<b> list;
        if (this.f64664a == null || (list = this.f64665b) == null || list.size() == 0) {
            return;
        }
        synchronized (this) {
            for (b bVar : this.f64665b) {
                this.f64664a.b(bVar.c());
                bVar.b(j);
            }
            notifyAll();
        }
        this.f64664a.d(j);
        this.f64664a.e();
    }

    public final void b(Object obj, List<c> list) {
        b bVar;
        d.a.u.b.c.a aVar;
        if (list == null || list.size() == 0) {
            return;
        }
        List<b> list2 = this.f64665b;
        if (list2 == null) {
            this.f64665b = new ArrayList();
        } else {
            list2.clear();
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            try {
                this.f64665b.add(new b(list.get(i2)));
                if (list.get(i2).l()) {
                    this.f64666c = i2;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        int size = this.f64665b.size();
        int i3 = this.f64666c;
        if (size > i3) {
            if (obj != null) {
                if (obj instanceof Surface) {
                    this.f64664a = new d.a.u.b.c.a(this.f64665b.get(this.f64666c).c(), (Surface) obj, true);
                } else if (obj instanceof SurfaceTexture) {
                    this.f64664a = new d.a.u.b.c.a(this.f64665b.get(this.f64666c).c(), (SurfaceTexture) obj);
                } else if (obj instanceof SurfaceHolder) {
                    this.f64664a = new d.a.u.b.c.a(this.f64665b.get(this.f64666c).c(), (SurfaceHolder) obj);
                }
            } else {
                List<b> list3 = this.f64665b;
                if (list3 != null && list3 != null && (bVar = list3.get(i3)) != null && (aVar = this.f64664a) != null) {
                    aVar.f(bVar.c());
                }
            }
        }
        for (b bVar2 : this.f64665b) {
            d.a.u.b.c.a aVar2 = this.f64664a;
            if (aVar2 != null) {
                aVar2.b(bVar2.c());
                bVar2.f();
            }
        }
    }

    public void c() {
        d.a.u.b.c.a aVar = this.f64664a;
        if (aVar != null) {
            aVar.g();
            this.f64664a = null;
        }
        List<b> list = this.f64665b;
        if (list != null) {
            for (b bVar : list) {
                bVar.e();
            }
            this.f64665b.clear();
            this.f64665b = null;
        }
    }

    public void d(d.a.u.b.e.c cVar) {
        for (b bVar : this.f64665b) {
            d.a.u.b.c.a aVar = this.f64664a;
            if (aVar != null) {
                aVar.b(bVar.c());
                bVar.g(cVar);
            }
        }
    }

    public void e(List<c> list) {
        Log.d(f64663d, "updateSurfaceDrawer !!!");
        this.f64664a.c();
        for (b bVar : this.f64665b) {
            bVar.e();
        }
        this.f64665b.clear();
        b(null, list);
    }
}
