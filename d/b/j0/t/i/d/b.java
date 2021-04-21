package d.b.j0.t.i.d;

import d.b.i0.r.q.a2;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public List<a2> f62785a;

    /* renamed from: b  reason: collision with root package name */
    public List<a2> f62786b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f62787c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f62788d;

    /* renamed from: f  reason: collision with root package name */
    public int f62790f;

    /* renamed from: e  reason: collision with root package name */
    public int f62789e = 2;

    /* renamed from: g  reason: collision with root package name */
    public int f62791g = 1;

    public b(List<a2> list, boolean z, int i) {
        this.f62790f = 2;
        this.f62788d = z;
        this.f62790f = i;
        j(list);
    }

    public int a(int i) {
        if (this.f62787c) {
            int size = this.f62786b.size();
            if (i == 0) {
                return (size - 1) - this.f62791g;
            }
            int i2 = this.f62791g;
            return i == size - i2 ? i2 : i;
        }
        return i;
    }

    public int b() {
        List<a2> list = this.f62785a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public int c(int i) {
        return this.f62787c ? i - this.f62791g : i;
    }

    public int d() {
        if (this.f62787c) {
            return this.f62791g;
        }
        return 0;
    }

    public List<a2> e() {
        return this.f62786b;
    }

    public final List<a2> f() {
        ArrayList arrayList = new ArrayList();
        List<a2> list = this.f62785a;
        if (list != null) {
            if (this.f62787c) {
                if (list.size() > this.f62790f && this.f62785a.size() >= this.f62791g) {
                    arrayList.addAll(this.f62785a.subList(0, this.f62790f));
                    List<a2> list2 = this.f62785a;
                    int i = this.f62790f;
                    arrayList.addAll(0, list2.subList(i - this.f62791g, i));
                    arrayList.addAll(this.f62785a.subList(0, this.f62791g));
                } else {
                    arrayList.addAll(this.f62785a);
                    List<a2> list3 = this.f62785a;
                    arrayList.addAll(0, list3.subList(list3.size() - this.f62791g, this.f62785a.size()));
                    arrayList.addAll(this.f62785a.subList(0, this.f62791g));
                }
            } else if (list != null && list.size() > 0) {
                int size = this.f62785a.size();
                int i2 = this.f62791g;
                if (size >= i2) {
                    arrayList.addAll(this.f62785a.subList(0, i2));
                }
            }
        }
        return arrayList;
    }

    public void g(int i) {
        this.f62791g = i;
        j(this.f62785a);
    }

    public void h(int i) {
        this.f62790f = i;
        j(this.f62785a);
    }

    public void i(int i) {
        this.f62789e = i;
        j(this.f62785a);
    }

    public void j(List<a2> list) {
        if (list == null) {
            return;
        }
        this.f62785a = list;
        if (list != null && list.size() >= this.f62789e && list.size() <= this.f62790f) {
            this.f62787c = true;
        } else if (list.size() > this.f62790f && this.f62788d) {
            this.f62787c = true;
        } else {
            this.f62787c = false;
        }
        this.f62786b = f();
    }
}
