package d.b.g0.a.j1.p;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes3.dex */
public class c implements e {

    /* renamed from: a  reason: collision with root package name */
    public List<Long> f44951a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public long f44952b = -1;

    @Override // d.b.g0.a.j1.p.e
    public long a() {
        List<Long> list = this.f44951a;
        if (list == null || list.size() <= 0 || this.f44952b < 0) {
            return -1L;
        }
        return this.f44952b - ((Long) Collections.min(this.f44951a)).longValue();
    }

    @Override // d.b.g0.a.j1.p.e
    public void b(long j) {
        List<Long> list = this.f44951a;
        if (list != null) {
            list.add(Long.valueOf(j));
        }
    }

    @Override // d.b.g0.a.j1.p.e
    public void c(long j) {
        this.f44952b = j;
    }

    @Override // d.b.g0.a.j1.p.e
    public String getType() {
        return "PageUpdateRender";
    }
}
