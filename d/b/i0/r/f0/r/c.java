package d.b.i0.r.f0.r;

import d.b.c.j.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public List<n> f51320a;

    /* renamed from: b  reason: collision with root package name */
    public List<n> f51321b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f51322c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f51323d;

    /* renamed from: f  reason: collision with root package name */
    public int f51325f;

    /* renamed from: e  reason: collision with root package name */
    public int f51324e = 2;

    /* renamed from: g  reason: collision with root package name */
    public int f51326g = 1;

    public c(List<n> list, boolean z, int i) {
        this.f51325f = 2;
        this.f51320a = list;
        this.f51323d = z;
        this.f51325f = i;
        j(list);
    }

    public int a(int i) {
        if (this.f51322c) {
            int size = this.f51321b.size();
            if (i == 0) {
                return (size - 1) - this.f51326g;
            }
            int i2 = this.f51326g;
            return i == size - i2 ? i2 : i;
        }
        return i;
    }

    public int b() {
        List<n> list = this.f51320a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public int c(int i) {
        return this.f51322c ? i - this.f51326g : i;
    }

    public int d() {
        if (this.f51322c) {
            return this.f51326g;
        }
        return 0;
    }

    public List<n> e() {
        return this.f51321b;
    }

    public final List<n> f() {
        ArrayList arrayList = new ArrayList();
        List<n> list = this.f51320a;
        if (list != null) {
            if (this.f51322c) {
                if (list.size() > this.f51325f && this.f51320a.size() >= this.f51326g) {
                    arrayList.addAll(this.f51320a.subList(0, this.f51325f));
                    List<n> list2 = this.f51320a;
                    int i = this.f51325f;
                    arrayList.addAll(0, list2.subList(i - this.f51326g, i));
                    arrayList.addAll(this.f51320a.subList(0, this.f51326g));
                } else {
                    arrayList.addAll(this.f51320a);
                    List<n> list3 = this.f51320a;
                    arrayList.addAll(0, list3.subList(list3.size() - this.f51326g, this.f51320a.size()));
                    arrayList.addAll(this.f51320a.subList(0, this.f51326g));
                }
            } else if (list != null && list.size() > 0) {
                int size = this.f51320a.size();
                int i2 = this.f51326g;
                if (size >= i2) {
                    arrayList.addAll(this.f51320a.subList(0, i2));
                }
            }
        }
        return arrayList;
    }

    public void g(int i) {
        this.f51326g = i;
        j(this.f51320a);
    }

    public void h(int i) {
        this.f51325f = i;
        j(this.f51320a);
    }

    public void i(int i) {
        this.f51324e = i;
        j(this.f51320a);
    }

    public void j(List<n> list) {
        if (list != null && list.size() >= this.f51324e && list.size() <= this.f51325f) {
            this.f51322c = true;
        } else if (list.size() > this.f51325f && this.f51323d) {
            this.f51322c = true;
        } else {
            this.f51322c = false;
        }
        this.f51321b = f();
    }
}
