package d.o.a.e.b.f;

import java.util.List;
/* loaded from: classes7.dex */
public abstract class l implements v {

    /* renamed from: a  reason: collision with root package name */
    public boolean f70972a = false;

    @Override // d.o.a.e.b.f.v
    public void a(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.f70972a = true;
    }

    @Override // d.o.a.e.b.f.v
    public boolean a() {
        return this.f70972a;
    }
}
