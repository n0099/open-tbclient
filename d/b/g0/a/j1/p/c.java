package d.b.g0.a.j1.p;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public class c implements e {

    /* renamed from: a  reason: collision with root package name */
    public List<Long> f44952a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public long f44953b = -1;

    @Override // d.b.g0.a.j1.p.e
    public long a() {
        List<Long> list = this.f44952a;
        if (list == null || list.size() <= 0 || this.f44953b < 0) {
            return -1L;
        }
        return this.f44953b - ((Long) Collections.min(this.f44952a)).longValue();
    }

    @Override // d.b.g0.a.j1.p.e
    public void b(long j) {
        List<Long> list = this.f44952a;
        if (list != null) {
            list.add(Long.valueOf(j));
        }
    }

    @Override // d.b.g0.a.j1.p.e
    public void c(long j) {
        this.f44953b = j;
    }

    @Override // d.b.g0.a.j1.p.e
    public String getType() {
        return "PageUpdateRender";
    }
}
