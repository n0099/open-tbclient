package d.b.i0.d1.g;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public long f53767a;

    /* renamed from: b  reason: collision with root package name */
    public int f53768b;

    /* renamed from: c  reason: collision with root package name */
    public List<b> f53769c = new ArrayList();

    public List<b> a() {
        return this.f53769c;
    }

    public long b() {
        return this.f53767a;
    }

    public boolean c() {
        return this.f53768b == 1;
    }

    public void d(int i) {
        this.f53768b = i;
    }

    public void e(List<b> list) {
        this.f53769c = list;
    }

    public void f(long j) {
        this.f53767a = j;
    }
}
