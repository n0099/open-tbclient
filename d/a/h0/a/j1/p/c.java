package d.a.h0.a.j1.p;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes3.dex */
public class c implements e {

    /* renamed from: a  reason: collision with root package name */
    public List<Long> f42998a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public long f42999b = -1;

    @Override // d.a.h0.a.j1.p.e
    public long a() {
        List<Long> list = this.f42998a;
        if (list == null || list.size() <= 0 || this.f42999b < 0) {
            return -1L;
        }
        return this.f42999b - ((Long) Collections.min(this.f42998a)).longValue();
    }

    @Override // d.a.h0.a.j1.p.e
    public void b(long j) {
        this.f42999b = j;
    }

    @Override // d.a.h0.a.j1.p.e
    public void c(long j) {
        List<Long> list = this.f42998a;
        if (list != null) {
            list.add(Long.valueOf(j));
        }
    }

    @Override // d.a.h0.a.j1.p.e
    public String getType() {
        return "PageUpdateRender";
    }
}
