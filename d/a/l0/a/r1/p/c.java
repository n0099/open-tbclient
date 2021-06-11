package d.a.l0.a.r1.p;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes3.dex */
public class c implements e {

    /* renamed from: a  reason: collision with root package name */
    public List<Long> f48232a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public long f48233b = -1;

    @Override // d.a.l0.a.r1.p.e
    public long a() {
        List<Long> list = this.f48232a;
        if (list == null || list.size() <= 0 || this.f48233b < 0) {
            return -1L;
        }
        return this.f48233b - ((Long) Collections.min(this.f48232a)).longValue();
    }

    @Override // d.a.l0.a.r1.p.e
    public void b(long j) {
        this.f48233b = j;
    }

    @Override // d.a.l0.a.r1.p.e
    public void c(long j) {
        List<Long> list = this.f48232a;
        if (list != null) {
            list.add(Long.valueOf(j));
        }
    }

    @Override // d.a.l0.a.r1.p.e
    public String getType() {
        return "PageUpdateRender";
    }
}
