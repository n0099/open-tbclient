package d.b.j0.e1.g;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public long f55711a;

    /* renamed from: b  reason: collision with root package name */
    public int f55712b;

    /* renamed from: c  reason: collision with root package name */
    public List<b> f55713c = new ArrayList();

    public List<b> a() {
        return this.f55713c;
    }

    public long b() {
        return this.f55711a;
    }

    public boolean c() {
        return this.f55712b == 1;
    }

    public void d(int i) {
        this.f55712b = i;
    }

    public void e(List<b> list) {
        this.f55713c = list;
    }

    public void f(long j) {
        this.f55711a = j;
    }
}
