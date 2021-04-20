package d.b.i0.e1.g;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public long f55290a;

    /* renamed from: b  reason: collision with root package name */
    public int f55291b;

    /* renamed from: c  reason: collision with root package name */
    public List<b> f55292c = new ArrayList();

    public List<b> a() {
        return this.f55292c;
    }

    public long b() {
        return this.f55290a;
    }

    public boolean c() {
        return this.f55291b == 1;
    }

    public void d(int i) {
        this.f55291b = i;
    }

    public void e(List<b> list) {
        this.f55292c = list;
    }

    public void f(long j) {
        this.f55290a = j;
    }
}
