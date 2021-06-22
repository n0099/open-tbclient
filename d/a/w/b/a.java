package d.a.w.b;

import android.graphics.SurfaceTexture;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import d.a.w.b.g.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static final String f68538d = "a";

    /* renamed from: a  reason: collision with root package name */
    public d.a.w.b.c.a f68539a;

    /* renamed from: b  reason: collision with root package name */
    public List<b> f68540b;

    /* renamed from: c  reason: collision with root package name */
    public int f68541c = 0;

    public a(Object obj, List<c> list) {
        b(obj, list);
    }

    public void a(long j) {
        List<b> list;
        if (this.f68539a == null || (list = this.f68540b) == null || list.size() == 0) {
            return;
        }
        synchronized (this) {
            for (b bVar : this.f68540b) {
                this.f68539a.b(bVar.c());
                bVar.b(j);
            }
            notifyAll();
        }
        this.f68539a.d(j);
        this.f68539a.e();
    }

    public final void b(Object obj, List<c> list) {
        b bVar;
        d.a.w.b.c.a aVar;
        if (list == null || list.size() == 0) {
            return;
        }
        List<b> list2 = this.f68540b;
        if (list2 == null) {
            this.f68540b = new ArrayList();
        } else {
            list2.clear();
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            try {
                this.f68540b.add(new b(list.get(i2)));
                if (list.get(i2).l()) {
                    this.f68541c = i2;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        int size = this.f68540b.size();
        int i3 = this.f68541c;
        if (size > i3) {
            if (obj != null) {
                if (obj instanceof Surface) {
                    this.f68539a = new d.a.w.b.c.a(this.f68540b.get(this.f68541c).c(), (Surface) obj, true);
                } else if (obj instanceof SurfaceTexture) {
                    this.f68539a = new d.a.w.b.c.a(this.f68540b.get(this.f68541c).c(), (SurfaceTexture) obj);
                } else if (obj instanceof SurfaceHolder) {
                    this.f68539a = new d.a.w.b.c.a(this.f68540b.get(this.f68541c).c(), (SurfaceHolder) obj);
                }
            } else {
                List<b> list3 = this.f68540b;
                if (list3 != null && list3 != null && (bVar = list3.get(i3)) != null && (aVar = this.f68539a) != null) {
                    aVar.f(bVar.c());
                }
            }
        }
        for (b bVar2 : this.f68540b) {
            d.a.w.b.c.a aVar2 = this.f68539a;
            if (aVar2 != null) {
                aVar2.b(bVar2.c());
                bVar2.f();
            }
        }
    }

    public void c() {
        d.a.w.b.c.a aVar = this.f68539a;
        if (aVar != null) {
            aVar.g();
            this.f68539a = null;
        }
        List<b> list = this.f68540b;
        if (list != null) {
            for (b bVar : list) {
                bVar.e();
            }
            this.f68540b.clear();
            this.f68540b = null;
        }
    }

    public void d(d.a.w.b.e.c cVar) {
        for (b bVar : this.f68540b) {
            d.a.w.b.c.a aVar = this.f68539a;
            if (aVar != null) {
                aVar.b(bVar.c());
                bVar.g(cVar);
            }
        }
    }

    public void e(List<c> list) {
        Log.d(f68538d, "updateSurfaceDrawer !!!");
        this.f68539a.c();
        for (b bVar : this.f68540b) {
            bVar.e();
        }
        this.f68540b.clear();
        b(null, list);
    }
}
