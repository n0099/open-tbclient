package d.o.a.e.b.f;

import java.util.List;
/* loaded from: classes7.dex */
public abstract class l implements v {

    /* renamed from: a  reason: collision with root package name */
    public boolean f71076a = false;

    @Override // d.o.a.e.b.f.v
    public void a(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.f71076a = true;
    }

    @Override // d.o.a.e.b.f.v
    public boolean a() {
        return this.f71076a;
    }
}
