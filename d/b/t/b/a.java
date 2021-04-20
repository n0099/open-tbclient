package d.b.t.b;

import android.graphics.SurfaceTexture;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import d.b.t.b.g.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static final String f65367d = "a";

    /* renamed from: a  reason: collision with root package name */
    public d.b.t.b.c.a f65368a;

    /* renamed from: b  reason: collision with root package name */
    public List<b> f65369b;

    /* renamed from: c  reason: collision with root package name */
    public int f65370c = 0;

    public a(Object obj, List<c> list) {
        b(obj, list);
    }

    public void a(long j) {
        List<b> list;
        if (this.f65368a == null || (list = this.f65369b) == null || list.size() == 0) {
            return;
        }
        synchronized (this) {
            for (b bVar : this.f65369b) {
                this.f65368a.b(bVar.c());
                bVar.b(j);
            }
            notifyAll();
        }
        this.f65368a.d(j);
        this.f65368a.e();
    }

    public final void b(Object obj, List<c> list) {
        b bVar;
        d.b.t.b.c.a aVar;
        if (list == null || list.size() == 0) {
            return;
        }
        List<b> list2 = this.f65369b;
        if (list2 == null) {
            this.f65369b = new ArrayList();
        } else {
            list2.clear();
        }
        for (int i = 0; i < list.size(); i++) {
            try {
                this.f65369b.add(new b(list.get(i)));
                if (list.get(i).l()) {
                    this.f65370c = i;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        int size = this.f65369b.size();
        int i2 = this.f65370c;
        if (size > i2) {
            if (obj != null) {
                if (obj instanceof Surface) {
                    this.f65368a = new d.b.t.b.c.a(this.f65369b.get(this.f65370c).c(), (Surface) obj, true);
                } else if (obj instanceof SurfaceTexture) {
                    this.f65368a = new d.b.t.b.c.a(this.f65369b.get(this.f65370c).c(), (SurfaceTexture) obj);
                } else if (obj instanceof SurfaceHolder) {
                    this.f65368a = new d.b.t.b.c.a(this.f65369b.get(this.f65370c).c(), (SurfaceHolder) obj);
                }
            } else {
                List<b> list3 = this.f65369b;
                if (list3 != null && list3 != null && (bVar = list3.get(i2)) != null && (aVar = this.f65368a) != null) {
                    aVar.f(bVar.c());
                }
            }
        }
        for (b bVar2 : this.f65369b) {
            d.b.t.b.c.a aVar2 = this.f65368a;
            if (aVar2 != null) {
                aVar2.b(bVar2.c());
                bVar2.f();
            }
        }
    }

    public void c() {
        d.b.t.b.c.a aVar = this.f65368a;
        if (aVar != null) {
            aVar.g();
            this.f65368a = null;
        }
        List<b> list = this.f65369b;
        if (list != null) {
            for (b bVar : list) {
                bVar.e();
            }
            this.f65369b.clear();
            this.f65369b = null;
        }
    }

    public void d(d.b.t.b.e.c cVar) {
        for (b bVar : this.f65369b) {
            d.b.t.b.c.a aVar = this.f65368a;
            if (aVar != null) {
                aVar.b(bVar.c());
                bVar.g(cVar);
            }
        }
    }

    public void e(List<c> list) {
        Log.d(f65367d, "updateSurfaceDrawer !!!");
        this.f65368a.c();
        for (b bVar : this.f65369b) {
            bVar.e();
        }
        this.f65369b.clear();
        b(null, list);
    }
}
