package d.a.l0.a.h0.g.l;

import androidx.annotation.NonNull;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes2.dex */
public class c implements b {

    /* renamed from: a  reason: collision with root package name */
    public List<b> f42102a = new CopyOnWriteArrayList();

    @Override // d.a.l0.a.h0.g.l.b
    public void a() {
        List<b> list = this.f42102a;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (b bVar : this.f42102a) {
            bVar.a();
        }
    }

    @Override // d.a.l0.a.h0.g.l.b
    public void b() {
        List<b> list = this.f42102a;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (b bVar : this.f42102a) {
            bVar.b();
        }
    }

    public void c(@NonNull b bVar) {
        this.f42102a.add(bVar);
    }

    public void d(@NonNull b bVar) {
        this.f42102a.remove(bVar);
    }
}
