package d.a.i0.a.h0.g.l;

import androidx.annotation.NonNull;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes2.dex */
public class c implements b {

    /* renamed from: a  reason: collision with root package name */
    public List<b> f41928a = new CopyOnWriteArrayList();

    @Override // d.a.i0.a.h0.g.l.b
    public void a() {
        List<b> list = this.f41928a;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (b bVar : this.f41928a) {
            bVar.a();
        }
    }

    @Override // d.a.i0.a.h0.g.l.b
    public void b() {
        List<b> list = this.f41928a;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (b bVar : this.f41928a) {
            bVar.b();
        }
    }

    public void c(@NonNull b bVar) {
        this.f41928a.add(bVar);
    }

    public void d(@NonNull b bVar) {
        this.f41928a.remove(bVar);
    }
}
