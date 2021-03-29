package d.b.i0.d1.g;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public long f53768a;

    /* renamed from: b  reason: collision with root package name */
    public int f53769b;

    /* renamed from: c  reason: collision with root package name */
    public List<b> f53770c = new ArrayList();

    public List<b> a() {
        return this.f53770c;
    }

    public long b() {
        return this.f53768a;
    }

    public boolean c() {
        return this.f53769b == 1;
    }

    public void d(int i) {
        this.f53769b = i;
    }

    public void e(List<b> list) {
        this.f53770c = list;
    }

    public void f(long j) {
        this.f53768a = j;
    }
}
