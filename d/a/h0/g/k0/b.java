package d.a.h0.g.k0;

import androidx.annotation.Nullable;
import d.a.h0.a.e0.l.f;
import d.a.h0.a.e0.l.j;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<a> f46435a = new ArrayList<>();

    /* loaded from: classes3.dex */
    public interface a {
        void a();

        void b(int i2);
    }

    @Nullable
    public static b a() {
        j jVar;
        f W = d.a.h0.a.z0.f.V().W();
        if (W == null || (jVar = (j) W.n(j.class)) == null) {
            return null;
        }
        return jVar.T2();
    }

    public synchronized void b() {
        Iterator<a> it = this.f46435a.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.f46435a.clear();
    }

    public synchronized void c(a aVar) {
        if (!this.f46435a.contains(aVar)) {
            this.f46435a.add(aVar);
        }
    }

    public synchronized void d(int i2) {
        Iterator<a> it = this.f46435a.iterator();
        while (it.hasNext()) {
            it.next().b(i2);
        }
    }
}
