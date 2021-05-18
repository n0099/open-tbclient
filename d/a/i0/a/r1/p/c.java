package d.a.i0.a.r1.p;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes3.dex */
public class c implements e {

    /* renamed from: a  reason: collision with root package name */
    public List<Long> f44382a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public long f44383b = -1;

    @Override // d.a.i0.a.r1.p.e
    public long a() {
        List<Long> list = this.f44382a;
        if (list == null || list.size() <= 0 || this.f44383b < 0) {
            return -1L;
        }
        return this.f44383b - ((Long) Collections.min(this.f44382a)).longValue();
    }

    @Override // d.a.i0.a.r1.p.e
    public void b(long j) {
        this.f44383b = j;
    }

    @Override // d.a.i0.a.r1.p.e
    public void c(long j) {
        List<Long> list = this.f44382a;
        if (list != null) {
            list.add(Long.valueOf(j));
        }
    }

    @Override // d.a.i0.a.r1.p.e
    public String getType() {
        return "PageUpdateRender";
    }
}
