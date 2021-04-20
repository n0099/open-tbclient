package d.b.h0.r.f0.r;

import d.b.c.j.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public List<n> f50984a;

    /* renamed from: b  reason: collision with root package name */
    public List<n> f50985b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f50986c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f50987d;

    /* renamed from: f  reason: collision with root package name */
    public int f50989f;

    /* renamed from: e  reason: collision with root package name */
    public int f50988e = 2;

    /* renamed from: g  reason: collision with root package name */
    public int f50990g = 1;

    public c(List<n> list, boolean z, int i) {
        this.f50989f = 2;
        this.f50984a = list;
        this.f50987d = z;
        this.f50989f = i;
        j(list);
    }

    public int a(int i) {
        if (this.f50986c) {
            int size = this.f50985b.size();
            if (i == 0) {
                return (size - 1) - this.f50990g;
            }
            int i2 = this.f50990g;
            return i == size - i2 ? i2 : i;
        }
        return i;
    }

    public int b() {
        List<n> list = this.f50984a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public int c(int i) {
        return this.f50986c ? i - this.f50990g : i;
    }

    public int d() {
        if (this.f50986c) {
            return this.f50990g;
        }
        return 0;
    }

    public List<n> e() {
        return this.f50985b;
    }

    public final List<n> f() {
        ArrayList arrayList = new ArrayList();
        List<n> list = this.f50984a;
        if (list != null) {
            if (this.f50986c) {
                if (list.size() > this.f50989f && this.f50984a.size() >= this.f50990g) {
                    arrayList.addAll(this.f50984a.subList(0, this.f50989f));
                    List<n> list2 = this.f50984a;
                    int i = this.f50989f;
                    arrayList.addAll(0, list2.subList(i - this.f50990g, i));
                    arrayList.addAll(this.f50984a.subList(0, this.f50990g));
                } else {
                    arrayList.addAll(this.f50984a);
                    List<n> list3 = this.f50984a;
                    arrayList.addAll(0, list3.subList(list3.size() - this.f50990g, this.f50984a.size()));
                    arrayList.addAll(this.f50984a.subList(0, this.f50990g));
                }
            } else if (list != null && list.size() > 0) {
                int size = this.f50984a.size();
                int i2 = this.f50990g;
                if (size >= i2) {
                    arrayList.addAll(this.f50984a.subList(0, i2));
                }
            }
        }
        return arrayList;
    }

    public void g(int i) {
        this.f50990g = i;
        j(this.f50984a);
    }

    public void h(int i) {
        this.f50989f = i;
        j(this.f50984a);
    }

    public void i(int i) {
        this.f50988e = i;
        j(this.f50984a);
    }

    public void j(List<n> list) {
        if (list != null && list.size() >= this.f50988e && list.size() <= this.f50989f) {
            this.f50986c = true;
        } else if (list.size() > this.f50989f && this.f50987d) {
            this.f50986c = true;
        } else {
            this.f50986c = false;
        }
        this.f50985b = f();
    }
}
