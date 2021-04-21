package d.b.h0.g.k0;

import androidx.annotation.Nullable;
import d.b.h0.a.e0.l.f;
import d.b.h0.a.e0.l.j;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<a> f48960a = new ArrayList<>();

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i);

        void b();
    }

    @Nullable
    public static b a() {
        j jVar;
        f W = d.b.h0.a.z0.f.V().W();
        if (W == null || (jVar = (j) W.n(j.class)) == null) {
            return null;
        }
        return jVar.U2();
    }

    public synchronized void b() {
        Iterator<a> it = this.f48960a.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
        this.f48960a.clear();
    }

    public synchronized void c(a aVar) {
        if (!this.f48960a.contains(aVar)) {
            this.f48960a.add(aVar);
        }
    }

    public synchronized void d(int i) {
        Iterator<a> it = this.f48960a.iterator();
        while (it.hasNext()) {
            it.next().a(i);
        }
    }
}
