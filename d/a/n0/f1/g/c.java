package d.a.n0.f1.g;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public long f54463a;

    /* renamed from: b  reason: collision with root package name */
    public int f54464b;

    /* renamed from: c  reason: collision with root package name */
    public List<b> f54465c = new ArrayList();

    public List<b> a() {
        return this.f54465c;
    }

    public long b() {
        return this.f54463a;
    }

    public boolean c() {
        return this.f54464b == 1;
    }

    public void d(int i2) {
        this.f54464b = i2;
    }

    public void e(List<b> list) {
        this.f54465c = list;
    }

    public void f(long j) {
        this.f54463a = j;
    }
}
