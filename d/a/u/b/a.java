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
    public static final String f63976d = "a";

    /* renamed from: a  reason: collision with root package name */
    public d.a.u.b.c.a f63977a;

    /* renamed from: b  reason: collision with root package name */
    public List<b> f63978b;

    /* renamed from: c  reason: collision with root package name */
    public int f63979c = 0;

    public a(Object obj, List<c> list) {
        b(obj, list);
    }

    public void a(long j) {
        List<b> list;
        if (this.f63977a == null || (list = this.f63978b) == null || list.size() == 0) {
            return;
        }
        synchronized (this) {
            for (b bVar : this.f63978b) {
                this.f63977a.b(bVar.c());
                bVar.b(j);
            }
            notifyAll();
        }
        this.f63977a.d(j);
        this.f63977a.e();
    }

    public final void b(Object obj, List<c> list) {
        b bVar;
        d.a.u.b.c.a aVar;
        if (list == null || list.size() == 0) {
            return;
        }
        List<b> list2 = this.f63978b;
        if (list2 == null) {
            this.f63978b = new ArrayList();
        } else {
            list2.clear();
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            try {
                this.f63978b.add(new b(list.get(i2)));
                if (list.get(i2).l()) {
                    this.f63979c = i2;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        int size = this.f63978b.size();
        int i3 = this.f63979c;
        if (size > i3) {
            if (obj != null) {
                if (obj instanceof Surface) {
                    this.f63977a = new d.a.u.b.c.a(this.f63978b.get(this.f63979c).c(), (Surface) obj, true);
                } else if (obj instanceof SurfaceTexture) {
                    this.f63977a = new d.a.u.b.c.a(this.f63978b.get(this.f63979c).c(), (SurfaceTexture) obj);
                } else if (obj instanceof SurfaceHolder) {
                    this.f63977a = new d.a.u.b.c.a(this.f63978b.get(this.f63979c).c(), (SurfaceHolder) obj);
                }
            } else {
                List<b> list3 = this.f63978b;
                if (list3 != null && list3 != null && (bVar = list3.get(i3)) != null && (aVar = this.f63977a) != null) {
                    aVar.f(bVar.c());
                }
            }
        }
        for (b bVar2 : this.f63978b) {
            d.a.u.b.c.a aVar2 = this.f63977a;
            if (aVar2 != null) {
                aVar2.b(bVar2.c());
                bVar2.f();
            }
        }
    }

    public void c() {
        d.a.u.b.c.a aVar = this.f63977a;
        if (aVar != null) {
            aVar.g();
            this.f63977a = null;
        }
        List<b> list = this.f63978b;
        if (list != null) {
            for (b bVar : list) {
                bVar.e();
            }
            this.f63978b.clear();
            this.f63978b = null;
        }
    }

    public void d(d.a.u.b.e.c cVar) {
        for (b bVar : this.f63978b) {
            d.a.u.b.c.a aVar = this.f63977a;
            if (aVar != null) {
                aVar.b(bVar.c());
                bVar.g(cVar);
            }
        }
    }

    public void e(List<c> list) {
        Log.d(f63976d, "updateSurfaceDrawer !!!");
        this.f63977a.c();
        for (b bVar : this.f63978b) {
            bVar.e();
        }
        this.f63978b.clear();
        b(null, list);
    }
}
