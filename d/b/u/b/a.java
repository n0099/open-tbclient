package d.b.u.b;

import android.graphics.SurfaceTexture;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import d.b.u.b.g.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static final String f64672d = "a";

    /* renamed from: a  reason: collision with root package name */
    public d.b.u.b.c.a f64673a;

    /* renamed from: b  reason: collision with root package name */
    public List<b> f64674b;

    /* renamed from: c  reason: collision with root package name */
    public int f64675c = 0;

    public a(Object obj, List<c> list) {
        b(obj, list);
    }

    public void a(long j) {
        List<b> list;
        if (this.f64673a == null || (list = this.f64674b) == null || list.size() == 0) {
            return;
        }
        synchronized (this) {
            for (b bVar : this.f64674b) {
                this.f64673a.b(bVar.c());
                bVar.b(j);
            }
            notifyAll();
        }
        this.f64673a.d(j);
        this.f64673a.e();
    }

    public final void b(Object obj, List<c> list) {
        b bVar;
        d.b.u.b.c.a aVar;
        if (list == null || list.size() == 0) {
            return;
        }
        List<b> list2 = this.f64674b;
        if (list2 == null) {
            this.f64674b = new ArrayList();
        } else {
            list2.clear();
        }
        for (int i = 0; i < list.size(); i++) {
            try {
                this.f64674b.add(new b(list.get(i)));
                if (list.get(i).l()) {
                    this.f64675c = i;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        int size = this.f64674b.size();
        int i2 = this.f64675c;
        if (size > i2) {
            if (obj != null) {
                if (obj instanceof Surface) {
                    this.f64673a = new d.b.u.b.c.a(this.f64674b.get(this.f64675c).c(), (Surface) obj, true);
                } else if (obj instanceof SurfaceTexture) {
                    this.f64673a = new d.b.u.b.c.a(this.f64674b.get(this.f64675c).c(), (SurfaceTexture) obj);
                } else if (obj instanceof SurfaceHolder) {
                    this.f64673a = new d.b.u.b.c.a(this.f64674b.get(this.f64675c).c(), (SurfaceHolder) obj);
                }
            } else {
                List<b> list3 = this.f64674b;
                if (list3 != null && list3 != null && (bVar = list3.get(i2)) != null && (aVar = this.f64673a) != null) {
                    aVar.f(bVar.c());
                }
            }
        }
        for (b bVar2 : this.f64674b) {
            d.b.u.b.c.a aVar2 = this.f64673a;
            if (aVar2 != null) {
                aVar2.b(bVar2.c());
                bVar2.f();
            }
        }
    }

    public void c() {
        d.b.u.b.c.a aVar = this.f64673a;
        if (aVar != null) {
            aVar.g();
            this.f64673a = null;
        }
        List<b> list = this.f64674b;
        if (list != null) {
            for (b bVar : list) {
                bVar.e();
            }
            this.f64674b.clear();
            this.f64674b = null;
        }
    }

    public void d(d.b.u.b.e.c cVar) {
        for (b bVar : this.f64674b) {
            d.b.u.b.c.a aVar = this.f64673a;
            if (aVar != null) {
                aVar.b(bVar.c());
                bVar.g(cVar);
            }
        }
    }

    public void e(List<c> list) {
        Log.d(f64672d, "updateSurfaceDrawer !!!");
        this.f64673a.c();
        for (b bVar : this.f64674b) {
            bVar.e();
        }
        this.f64674b.clear();
        b(null, list);
    }
}
