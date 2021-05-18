package d.a.k0.e1.g;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public long f54273a;

    /* renamed from: b  reason: collision with root package name */
    public int f54274b;

    /* renamed from: c  reason: collision with root package name */
    public List<b> f54275c = new ArrayList();

    public List<b> a() {
        return this.f54275c;
    }

    public long b() {
        return this.f54273a;
    }

    public boolean c() {
        return this.f54274b == 1;
    }

    public void d(int i2) {
        this.f54274b = i2;
    }

    public void e(List<b> list) {
        this.f54275c = list;
    }

    public void f(long j) {
        this.f54273a = j;
    }
}
