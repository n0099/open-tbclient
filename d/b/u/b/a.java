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
    public static final String f64673d = "a";

    /* renamed from: a  reason: collision with root package name */
    public d.b.u.b.c.a f64674a;

    /* renamed from: b  reason: collision with root package name */
    public List<b> f64675b;

    /* renamed from: c  reason: collision with root package name */
    public int f64676c = 0;

    public a(Object obj, List<c> list) {
        b(obj, list);
    }

    public void a(long j) {
        List<b> list;
        if (this.f64674a == null || (list = this.f64675b) == null || list.size() == 0) {
            return;
        }
        synchronized (this) {
            for (b bVar : this.f64675b) {
                this.f64674a.b(bVar.c());
                bVar.b(j);
            }
            notifyAll();
        }
        this.f64674a.d(j);
        this.f64674a.e();
    }

    public final void b(Object obj, List<c> list) {
        b bVar;
        d.b.u.b.c.a aVar;
        if (list == null || list.size() == 0) {
            return;
        }
        List<b> list2 = this.f64675b;
        if (list2 == null) {
            this.f64675b = new ArrayList();
        } else {
            list2.clear();
        }
        for (int i = 0; i < list.size(); i++) {
            try {
                this.f64675b.add(new b(list.get(i)));
                if (list.get(i).l()) {
                    this.f64676c = i;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        int size = this.f64675b.size();
        int i2 = this.f64676c;
        if (size > i2) {
            if (obj != null) {
                if (obj instanceof Surface) {
                    this.f64674a = new d.b.u.b.c.a(this.f64675b.get(this.f64676c).c(), (Surface) obj, true);
                } else if (obj instanceof SurfaceTexture) {
                    this.f64674a = new d.b.u.b.c.a(this.f64675b.get(this.f64676c).c(), (SurfaceTexture) obj);
                } else if (obj instanceof SurfaceHolder) {
                    this.f64674a = new d.b.u.b.c.a(this.f64675b.get(this.f64676c).c(), (SurfaceHolder) obj);
                }
            } else {
                List<b> list3 = this.f64675b;
                if (list3 != null && list3 != null && (bVar = list3.get(i2)) != null && (aVar = this.f64674a) != null) {
                    aVar.f(bVar.c());
                }
            }
        }
        for (b bVar2 : this.f64675b) {
            d.b.u.b.c.a aVar2 = this.f64674a;
            if (aVar2 != null) {
                aVar2.b(bVar2.c());
                bVar2.f();
            }
        }
    }

    public void c() {
        d.b.u.b.c.a aVar = this.f64674a;
        if (aVar != null) {
            aVar.g();
            this.f64674a = null;
        }
        List<b> list = this.f64675b;
        if (list != null) {
            for (b bVar : list) {
                bVar.e();
            }
            this.f64675b.clear();
            this.f64675b = null;
        }
    }

    public void d(d.b.u.b.e.c cVar) {
        for (b bVar : this.f64675b) {
            d.b.u.b.c.a aVar = this.f64674a;
            if (aVar != null) {
                aVar.b(bVar.c());
                bVar.g(cVar);
            }
        }
    }

    public void e(List<c> list) {
        Log.d(f64673d, "updateSurfaceDrawer !!!");
        this.f64674a.c();
        for (b bVar : this.f64675b) {
            bVar.e();
        }
        this.f64675b.clear();
        b(null, list);
    }
}
